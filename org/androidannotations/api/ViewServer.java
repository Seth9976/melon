package org.androidannotations.api;

import U4.x;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ViewServer implements Runnable {
    static final class NoopViewServer extends ViewServer {
        private NoopViewServer() {
            super(null);
        }

        public NoopViewServer(org.androidannotations.api.ViewServer.1 viewServer$10) {
        }

        @Override  // org.androidannotations.api.ViewServer
        public void addWindow(Activity activity0) {
        }

        @Override  // org.androidannotations.api.ViewServer
        public void addWindow(View view0, String s) {
        }

        @Override  // org.androidannotations.api.ViewServer
        public boolean isRunning() {
            return false;
        }

        @Override  // org.androidannotations.api.ViewServer
        public void removeWindow(Activity activity0) {
        }

        @Override  // org.androidannotations.api.ViewServer
        public void removeWindow(View view0) {
        }

        @Override  // org.androidannotations.api.ViewServer
        public void run() {
        }

        @Override  // org.androidannotations.api.ViewServer
        public void setFocusedWindow(Activity activity0) {
        }

        @Override  // org.androidannotations.api.ViewServer
        public void setFocusedWindow(View view0) {
        }

        @Override  // org.androidannotations.api.ViewServer
        public boolean start() {
            return false;
        }

        @Override  // org.androidannotations.api.ViewServer
        public boolean stop() {
            return false;
        }
    }

    static class UncloseableOutputStream extends OutputStream {
        private final OutputStream mStream;

        public UncloseableOutputStream(OutputStream outputStream0) {
            this.mStream = outputStream0;
        }

        @Override
        public void close() {
        }

        @Override
        public boolean equals(Object object0) {
            return this.mStream.equals(object0);
        }

        @Override
        public void flush() {
            this.mStream.flush();
        }

        @Override
        public int hashCode() {
            return this.mStream.hashCode();
        }

        @Override
        public String toString() {
            return this.mStream.toString();
        }

        @Override
        public void write(int v) {
            this.mStream.write(v);
        }

        @Override
        public void write(byte[] arr_b) {
            this.mStream.write(arr_b);
        }

        @Override
        public void write(byte[] arr_b, int v, int v1) {
            this.mStream.write(arr_b, v, v1);
        }
    }

    class ViewServerWorker implements Runnable, WindowListener {
        private Socket mClient;
        private final Object[] mLock;
        private boolean mNeedFocusedWindowUpdate;
        private boolean mNeedWindowListUpdate;

        private ViewServerWorker(Socket socket0) {
            this.mLock = new Object[0];
            this.mClient = socket0;
            this.mNeedWindowListUpdate = false;
            this.mNeedFocusedWindowUpdate = false;
        }

        public ViewServerWorker(Socket socket0, org.androidannotations.api.ViewServer.1 viewServer$10) {
            this(socket0);
        }

        private View findWindow(int v) {
            View view0;
            if(v == -1) {
                ViewServer.this.mWindowsLock.readLock().lock();
                ViewServer.this.mWindowsLock.readLock().unlock();
                return ViewServer.this.mFocusedWindow;
            }
            ViewServer.this.mWindowsLock.readLock().lock();
            try {
                Iterator iterator0 = ViewServer.this.mWindows.entrySet().iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        goto label_18;
                    }
                    Object object0 = iterator0.next();
                    Map.Entry map$Entry0 = (Map.Entry)object0;
                    if(System.identityHashCode(map$Entry0.getKey()) == v) {
                        view0 = (View)map$Entry0.getKey();
                        break;
                    }
                }
            }
            catch(Throwable throwable0) {
                ViewServer.this.mWindowsLock.readLock().unlock();
                throw throwable0;
            }
            ViewServer.this.mWindowsLock.readLock().unlock();
            return view0;
        label_18:
            ViewServer.this.mWindowsLock.readLock().unlock();
            return null;
        }

        @Override  // org.androidannotations.api.ViewServer$WindowListener
        public void focusChanged() {
            synchronized(this.mLock) {
                this.mNeedFocusedWindowUpdate = true;
                this.mLock.notifyAll();
            }
        }

        private boolean getFocusedWindow(Socket socket0) {
            String s;
            BufferedWriter bufferedWriter0 = null;
            try {
                bufferedWriter0 = new BufferedWriter(new OutputStreamWriter(socket0.getOutputStream()), 0x2000);
                ViewServer.this.mFocusLock.readLock().lock();
                View view0 = ViewServer.this.mFocusedWindow;
                ViewServer.this.mFocusLock.readLock().unlock();
                if(view0 != null) {
                    ViewServer.this.mWindowsLock.readLock().lock();
                    try {
                        s = (String)ViewServer.this.mWindows.get(ViewServer.this.mFocusedWindow);
                    }
                    finally {
                        ViewServer.this.mWindowsLock.readLock().unlock();
                    }
                    bufferedWriter0.write(Integer.toHexString(System.identityHashCode(view0)));
                    bufferedWriter0.write(0x20);
                    bufferedWriter0.append(s);
                }
                bufferedWriter0.write(10);
                bufferedWriter0.flush();
            }
            catch(Exception unused_ex) {
                if(bufferedWriter0 != null) {
                    try {
                        bufferedWriter0.close();
                        return false;
                    }
                    catch(IOException unused_ex) {
                    }
                }
                return false;
            }
            catch(Throwable throwable0) {
                if(bufferedWriter0 != null) {
                    try {
                        bufferedWriter0.close();
                    }
                    catch(IOException unused_ex) {
                    }
                }
                throw throwable0;
            }
            try {
                bufferedWriter0.close();
                return true;
            }
            catch(IOException unused_ex) {
                return false;
            }
        }

        private boolean listWindows(Socket socket0) {
            BufferedWriter bufferedWriter1;
            BufferedWriter bufferedWriter0 = null;
            try {
                ViewServer.this.mWindowsLock.readLock().lock();
                bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(socket0.getOutputStream()), 0x2000);
                goto label_6;
            }
            catch(Exception unused_ex) {
                goto label_21;
            }
            catch(Throwable throwable0) {
            }
            goto label_25;
            try {
            label_6:
                for(Object object0: ViewServer.this.mWindows.entrySet()) {
                    bufferedWriter1.write(Integer.toHexString(System.identityHashCode(((Map.Entry)object0).getKey())));
                    bufferedWriter1.write(0x20);
                    bufferedWriter1.append(((CharSequence)((Map.Entry)object0).getValue()));
                    bufferedWriter1.write(10);
                }
                bufferedWriter1.write("DONE.\n");
                bufferedWriter1.flush();
                goto label_29;
            label_20:
                bufferedWriter0 = bufferedWriter1;
            }
            catch(Exception unused_ex) {
                goto label_20;
            }
            catch(Throwable throwable0) {
                bufferedWriter0 = bufferedWriter1;
                goto label_25;
            }
        label_21:
            ViewServer.this.mWindowsLock.readLock().unlock();
            if(bufferedWriter0 != null) {
                try {
                    bufferedWriter0.close();
                }
                catch(IOException unused_ex) {
                }
                return false;
            label_25:
                ViewServer.this.mWindowsLock.readLock().unlock();
                if(bufferedWriter0 != null) {
                    try {
                        bufferedWriter0.close();
                    }
                    catch(IOException unused_ex) {
                    }
                }
                throw throwable0;
            label_29:
                ViewServer.this.mWindowsLock.readLock().unlock();
                try {
                    bufferedWriter1.close();
                    return true;
                }
                catch(IOException unused_ex) {
                }
            }
            return false;
        }

        @Override
        public void run() {
            boolean z;
            String s1;
            BufferedReader bufferedReader0;
            try {
                try {
                    bufferedReader0 = null;
                    bufferedReader0 = new BufferedReader(new InputStreamReader(this.mClient.getInputStream()), 0x400);
                    String s = bufferedReader0.readLine();
                    int v = s.indexOf(0x20);
                    if(v == -1) {
                        s1 = "";
                    }
                    else {
                        s1 = s.substring(v + 1);
                        s = s.substring(0, v);
                    }
                    if("PROTOCOL".equalsIgnoreCase(s)) {
                        z = ViewServer.writeValue(this.mClient, "4");
                    }
                    else if("SERVER".equalsIgnoreCase(s)) {
                        z = ViewServer.writeValue(this.mClient, "4");
                    }
                    else if("LIST".equalsIgnoreCase(s)) {
                        z = this.listWindows(this.mClient);
                    }
                    else if("GET_FOCUS".equalsIgnoreCase(s)) {
                        z = this.getFocusedWindow(this.mClient);
                    }
                    else {
                        z = "AUTOLIST".equalsIgnoreCase(s) ? this.windowManagerAutolistLoop() : this.windowCommand(this.mClient, s, s1);
                    }
                    if(!z) {
                        Log.w("ViewServer", "An error occurred with the command: " + s);
                    }
                    goto label_49;
                }
                catch(IOException iOException0) {
                }
                Log.w("ViewServer", "Connection error: ", iOException0);
                if(bufferedReader0 != null) {
                    goto label_30;
                }
                goto label_34;
            }
            catch(Throwable throwable0) {
                goto label_37;
            }
            try {
            label_30:
                bufferedReader0.close();
            }
            catch(IOException iOException1) {
                iOException1.printStackTrace();
            }
        label_34:
            Socket socket0 = this.mClient;
            if(socket0 != null) {
                goto label_55;
            }
            return;
        label_37:
            if(bufferedReader0 != null) {
                try {
                    bufferedReader0.close();
                }
                catch(IOException iOException2) {
                    iOException2.printStackTrace();
                }
            }
            Socket socket1 = this.mClient;
            if(socket1 != null) {
                try {
                    socket1.close();
                }
                catch(IOException iOException3) {
                    iOException3.printStackTrace();
                }
            }
            throw throwable0;
            try {
            label_49:
                bufferedReader0.close();
            }
            catch(IOException iOException4) {
                iOException4.printStackTrace();
            }
            socket0 = this.mClient;
            if(socket0 != null) {
                try {
                label_55:
                    socket0.close();
                }
                catch(IOException iOException5) {
                    iOException5.printStackTrace();
                }
            }
        }

        private boolean windowCommand(Socket socket0, String s, String s1) {
            BufferedWriter bufferedWriter1;
            BufferedWriter bufferedWriter0;
            try {
                try {
                    Class class0 = String.class;
                    bufferedWriter0 = null;
                    int v = s1.indexOf(0x20);
                    if(v == -1) {
                        v = s1.length();
                    }
                    int v1 = (int)Long.parseLong(s1.substring(0, v), 16);
                    s1 = v >= s1.length() ? "" : s1.substring(v + 1);
                    View view0 = this.findWindow(v1);
                    if(view0 == null) {
                        return false;
                    }
                    Method method0 = ViewDebug.class.getDeclaredMethod("dispatchCommand", View.class, class0, class0, OutputStream.class);
                    method0.setAccessible(true);
                    method0.invoke(null, view0, s, s1, new UncloseableOutputStream(socket0.getOutputStream()));
                    if(!socket0.isOutputShutdown()) {
                        bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(socket0.getOutputStream()));
                        goto label_15;
                    }
                    goto label_33;
                }
                catch(Exception exception0) {
                    goto label_26;
                }
                try {
                label_15:
                    bufferedWriter1.write("DONE\n");
                    bufferedWriter0 = bufferedWriter1;
                    bufferedWriter1.flush();
                    bufferedWriter0 = bufferedWriter1;
                    goto label_33;
                }
                catch(Exception exception0) {
                    bufferedWriter0 = bufferedWriter1;
                    goto label_26;
                }
                try {
                    goto label_30;
                }
                catch(Exception exception0) {
                }
            label_26:
                Log.w("ViewServer", "Could not send command " + s + " with parameters " + s1, exception0);
                if(bufferedWriter0 != null) {
                    goto label_28;
                }
                return false;
            }
            catch(Throwable throwable0) {
                goto label_30;
            }
            try {
            label_28:
                bufferedWriter0.close();
            }
            catch(IOException unused_ex) {
            }
            return false;
        label_30:
            if(bufferedWriter0 != null) {
                try {
                    bufferedWriter0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable0;
        label_33:
            if(bufferedWriter0 != null) {
                try {
                    bufferedWriter0.close();
                    return true;
                }
                catch(IOException unused_ex) {
                    return false;
                }
            }
            return true;
        }

        private boolean windowManagerAutolistLoop() {
            boolean z2;
            boolean z;
            Exception exception1;
            BufferedWriter bufferedWriter1;
            ViewServer.this.addWindowListener(this);
            BufferedWriter bufferedWriter0 = null;
            try {
                bufferedWriter1 = null;
                bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(this.mClient.getOutputStream()));
            }
            catch(Exception exception0) {
                exception1 = exception0;
                goto label_41;
            }
            catch(Throwable throwable0) {
                goto label_45;
            }
            try {
                try {
                    while(true) {
                        if(Thread.interrupted()) {
                            goto label_49;
                        }
                        Object[] arr_object = this.mLock;
                        synchronized(arr_object) {
                            while(true) {
                                z = false;
                                boolean z1 = this.mNeedWindowListUpdate;
                                if(z1 || this.mNeedFocusedWindowUpdate) {
                                    break;
                                }
                                this.mLock.wait();
                            }
                            if(z1) {
                                this.mNeedWindowListUpdate = false;
                                z2 = true;
                            }
                            else {
                                z2 = false;
                            }
                            if(this.mNeedFocusedWindowUpdate) {
                                this.mNeedFocusedWindowUpdate = false;
                                z = true;
                            }
                        }
                        if(z2) {
                            bufferedWriter1.write("LIST UPDATE\n");
                            bufferedWriter1.flush();
                        }
                        if(z) {
                            bufferedWriter1.write("FOCUS UPDATE\n");
                            bufferedWriter1.flush();
                        }
                    }
                }
                catch(Exception exception1) {
                }
            label_41:
                Log.w("ViewServer", "Connection error: ", exception1);
                if(bufferedWriter1 != null) {
                    goto label_43;
                }
                goto label_50;
            }
            catch(Throwable throwable0) {
                bufferedWriter0 = bufferedWriter1;
                goto label_45;
            }
            try {
            label_43:
                bufferedWriter1.close();
            }
            catch(IOException unused_ex) {
            }
            goto label_50;
        label_45:
            if(bufferedWriter0 != null) {
                try {
                    bufferedWriter0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            ViewServer.this.removeWindowListener(this);
            throw throwable0;
            try {
            label_49:
                bufferedWriter1.close();
            }
            catch(IOException unused_ex) {
            }
        label_50:
            ViewServer.this.removeWindowListener(this);
            return true;
        }

        @Override  // org.androidannotations.api.ViewServer$WindowListener
        public void windowsChanged() {
            synchronized(this.mLock) {
                this.mNeedWindowListUpdate = true;
                this.mLock.notifyAll();
            }
        }
    }

    interface WindowListener {
        void focusChanged();

        void windowsChanged();
    }

    private static final String BUILD_TYPE_USER = "user";
    private static final String COMMAND_PROTOCOL_VERSION = "PROTOCOL";
    private static final String COMMAND_SERVER_VERSION = "SERVER";
    private static final String COMMAND_WINDOW_MANAGER_AUTOLIST = "AUTOLIST";
    private static final String COMMAND_WINDOW_MANAGER_GET_FOCUS = "GET_FOCUS";
    private static final String COMMAND_WINDOW_MANAGER_LIST = "LIST";
    private static final String LOG_TAG = "ViewServer";
    private static final String VALUE_PROTOCOL_VERSION = "4";
    private static final String VALUE_SERVER_VERSION = "4";
    private static final int VIEW_SERVER_DEFAULT_PORT = 4939;
    private static final int VIEW_SERVER_MAX_CONNECTIONS = 10;
    private final ReentrantReadWriteLock mFocusLock;
    private View mFocusedWindow;
    private final List mListeners;
    private final int mPort;
    private ServerSocket mServer;
    private Thread mThread;
    private ExecutorService mThreadPool;
    private final Map mWindows;
    private final ReentrantReadWriteLock mWindowsLock;
    private static ViewServer sServer;

    private ViewServer() {
        this.mListeners = new CopyOnWriteArrayList();
        this.mWindows = new HashMap();
        this.mWindowsLock = new ReentrantReadWriteLock();
        this.mFocusLock = new ReentrantReadWriteLock();
        this.mPort = -1;
    }

    private ViewServer(int v) {
        this.mListeners = new CopyOnWriteArrayList();
        this.mWindows = new HashMap();
        this.mWindowsLock = new ReentrantReadWriteLock();
        this.mFocusLock = new ReentrantReadWriteLock();
        this.mPort = v;
    }

    public ViewServer(org.androidannotations.api.ViewServer.1 viewServer$10) {
    }

    public void addWindow(Activity activity0) {
        String s1;
        String s = activity0.getTitle().toString();
        if(TextUtils.isEmpty(s)) {
            s1 = activity0.getClass().getCanonicalName() + "/0x" + System.identityHashCode(activity0);
        }
        else {
            StringBuilder stringBuilder0 = x.p(s, "(");
            stringBuilder0.append(activity0.getClass().getCanonicalName());
            stringBuilder0.append(")");
            s1 = stringBuilder0.toString();
        }
        this.addWindow(activity0.getWindow().getDecorView(), s1);
    }

    public void addWindow(View view0, String s) {
        this.mWindowsLock.writeLock().lock();
        try {
            View view1 = view0.getRootView();
            this.mWindows.put(view1, s);
        }
        finally {
            this.mWindowsLock.writeLock().unlock();
        }
        this.fireWindowsChangedEvent();
    }

    private void addWindowListener(WindowListener viewServer$WindowListener0) {
        if(!this.mListeners.contains(viewServer$WindowListener0)) {
            this.mListeners.add(viewServer$WindowListener0);
        }
    }

    private void fireFocusChangedEvent() {
        for(Object object0: this.mListeners) {
            ((WindowListener)object0).focusChanged();
        }
    }

    private void fireWindowsChangedEvent() {
        for(Object object0: this.mListeners) {
            ((WindowListener)object0).windowsChanged();
        }
    }

    public static ViewServer get(Context context0) {
        ApplicationInfo applicationInfo0 = context0.getApplicationInfo();
        if(!"user".equals(Build.TYPE) || (applicationInfo0.flags & 2) == 0) {
            ViewServer.sServer = new NoopViewServer(null);
        }
        else {
            if(ViewServer.sServer == null) {
                ViewServer.sServer = new ViewServer(4939);
            }
            if(!ViewServer.sServer.isRunning()) {
                try {
                    ViewServer.sServer.start();
                }
                catch(IOException iOException0) {
                    Log.d("ViewServer", "Error:", iOException0);
                }
                return ViewServer.sServer;
            }
        }
        return ViewServer.sServer;
    }

    public boolean isRunning() {
        return this.mThread != null && this.mThread.isAlive();
    }

    public void removeWindow(Activity activity0) {
        this.removeWindow(activity0.getWindow().getDecorView());
    }

    public void removeWindow(View view0) {
        this.mWindowsLock.writeLock().lock();
        try {
            View view1 = view0.getRootView();
            this.mWindows.remove(view1);
        }
        finally {
            this.mWindowsLock.writeLock().unlock();
        }
        this.mFocusLock.writeLock().lock();
        if(this.mFocusedWindow == view1) {
            this.mFocusedWindow = null;
        }
        this.mFocusLock.writeLock().unlock();
        this.fireWindowsChangedEvent();
    }

    private void removeWindowListener(WindowListener viewServer$WindowListener0) {
        this.mListeners.remove(viewServer$WindowListener0);
    }

    @Override
    public void run() {
        try {
            InetAddress inetAddress0 = InetAddress.getLocalHost();
            this.mServer = new ServerSocket(this.mPort, 10, inetAddress0);
        }
        catch(Exception exception0) {
            Log.w("ViewServer", "Starting ServerSocket error: ", exception0);
        }
        while(this.mServer != null && Thread.currentThread() == this.mThread) {
            try {
                Socket socket0 = this.mServer.accept();
                ExecutorService executorService0 = this.mThreadPool;
                if(executorService0 != null) {
                    executorService0.submit(new ViewServerWorker(this, socket0, null));
                    continue;
                }
                try {
                    socket0.close();
                }
                catch(IOException iOException0) {
                    iOException0.printStackTrace();
                }
            }
            catch(Exception exception1) {
                Log.w("ViewServer", "Connection error: ", exception1);
            }
        }
    }

    public void setFocusedWindow(Activity activity0) {
        this.setFocusedWindow(activity0.getWindow().getDecorView());
    }

    public void setFocusedWindow(View view0) {
        this.mFocusLock.writeLock().lock();
        try {
            this.mFocusedWindow = view0 == null ? null : view0.getRootView();
        }
        finally {
            this.mFocusLock.writeLock().unlock();
        }
        this.fireFocusChangedEvent();
    }

    public boolean start() {
        if(this.mThread != null) {
            return false;
        }
        StringBuilder stringBuilder0 = new StringBuilder("Local View Server [port=");
        this.mThread = new Thread(this, x.g(this.mPort, "]", stringBuilder0));
        this.mThreadPool = Executors.newFixedThreadPool(10);
        this.mThread.start();
        return true;
    }

    public boolean stop() {
        Thread thread0 = this.mThread;
        if(thread0 != null) {
            thread0.interrupt();
            ExecutorService executorService0 = this.mThreadPool;
            if(executorService0 != null) {
                try {
                    executorService0.shutdownNow();
                }
                catch(SecurityException unused_ex) {
                    Log.w("ViewServer", "Could not stop all view server threads");
                }
            }
            try {
                this.mThreadPool = null;
                this.mThread = null;
                this.mServer.close();
                this.mServer = null;
                return true;
            }
            catch(IOException unused_ex) {
                Log.w("ViewServer", "Could not close the view server");
            }
        }
        this.mWindowsLock.writeLock().lock();
        try {
            this.mWindows.clear();
        }
        finally {
            this.mWindowsLock.writeLock().unlock();
        }
        this.mFocusLock.writeLock().lock();
        this.mFocusedWindow = null;
        this.mFocusLock.writeLock().unlock();
        return false;
    }

    private static boolean writeValue(Socket socket0, String s) {
        BufferedWriter bufferedWriter0 = null;
        try {
            bufferedWriter0 = new BufferedWriter(new OutputStreamWriter(socket0.getOutputStream()), 0x2000);
            bufferedWriter0.write(s);
            bufferedWriter0.write("\n");
            bufferedWriter0.flush();
        }
        catch(Exception unused_ex) {
            if(bufferedWriter0 != null) {
                try {
                    bufferedWriter0.close();
                    return false;
                }
                catch(IOException unused_ex) {
                }
            }
            return false;
        }
        catch(Throwable throwable0) {
            if(bufferedWriter0 != null) {
                try {
                    bufferedWriter0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable0;
        }
        try {
            bufferedWriter0.close();
            return true;
        }
        catch(IOException unused_ex) {
            return false;
        }
    }

    class org.androidannotations.api.ViewServer.1 {
    }

}

