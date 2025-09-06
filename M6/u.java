package M6;

import Ac.X3;
import K8.b;
import N1.c;
import N1.d;
import N6.a;
import U4.w;
import V4.G;
import Z1.f;
import Z4.n;
import Z6.i;
import android.app.Application;
import android.graphics.Typeface;
import android.media.session.MediaSession.Token;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.F0;
import androidx.media3.session.legacy.MediaSessionCompat.Token;
import androidx.media3.session.legacy.p;
import androidx.recyclerview.widget.h;
import androidx.room.Q;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.log.LogU;
import com.viewpagerindicator.IconPageIndicator;
import com.viewpagerindicator.TabPageIndicator;
import d5.e;
import d5.j;
import d5.m;
import d5.q;
import d5.v;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import jeb.synthetic.FIN;
import kotlinx.coroutines.CancellableContinuation.DefaultImpls;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;

public final class u implements Runnable {
    public final int a;
    public Object b;
    public final Object c;

    public u(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public u(b b0, Socket socket0) {
        this.a = 1;
        super();
        this.c = b0;
        this.b = socket0;
        Thread thread0 = new Thread(this);
        thread0.setDaemon(true);
        thread0.start();
    }

    public u(i i0) {
        this.a = 9;
        super();
        this.c = i0;
    }

    public u(SwipeDismissBehavior swipeDismissBehavior0, View view0, boolean z) {
        this.a = 19;
        super();
        this.c = swipeDismissBehavior0;
        this.b = view0;
    }

    public u(Object object0, Object object1, boolean z, int v) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        super();
    }

    public void a(BufferedReader bufferedReader0, Properties properties0, Properties properties1, Properties properties2) {
        String s2;
        try {
            String s = bufferedReader0.readLine();
            if(s == null) {
                return;
            }
            StringTokenizer stringTokenizer0 = new StringTokenizer(s);
            if(stringTokenizer0.hasMoreTokens()) {
                properties0.put("method", stringTokenizer0.nextToken());
                if(stringTokenizer0.hasMoreTokens()) {
                    String s1 = stringTokenizer0.nextToken();
                    int v = s1.indexOf(0x3F);
                    if(v >= 0) {
                        this.c(s1.substring(v + 1), properties1);
                        s2 = Uri.decode(s1.substring(0, v));
                    }
                    else {
                        s2 = Uri.decode(s1);
                    }
                    if(stringTokenizer0.hasMoreTokens()) {
                        for(String s3 = bufferedReader0.readLine(); s3 != null && s3.trim().length() > 0; s3 = bufferedReader0.readLine()) {
                            int v1 = s3.indexOf(58);
                            if(v1 >= 0) {
                                properties2.put(s3.substring(0, v1).trim().toLowerCase(), s3.substring(v1 + 1).trim());
                            }
                        }
                    }
                    properties0.put("uri", s2);
                    return;
                }
                this.g("400 Bad Request", "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                throw null;
            }
            this.g("400 Bad Request", "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            throw null;
        }
        catch(IOException iOException0) {
        }
        this.g("500 Internal Server Error", "SERVER INTERNAL ERROR: IOException: " + iOException0.getMessage());
        throw null;
    }

    public void b(String s, byte[] arr_b, BufferedReader bufferedReader0, Properties properties0, Properties properties1) {
        String s8;
        try {
            byte[] arr_b1 = s.getBytes();
            Vector vector0 = new Vector();
            int v = 0;
            int v1 = 0;
            int v2 = -1;
            while(v < arr_b.length) {
                if(arr_b[v] == arr_b1[v1]) {
                    if(v1 == 0) {
                        v2 = v;
                    }
                    if(v1 + 1 == arr_b1.length) {
                        vector0.addElement(v2);
                        goto label_15;
                    }
                    else {
                        ++v1;
                        goto label_17;
                    }
                    goto label_14;
                }
                else {
                label_14:
                    v -= v1;
                }
            label_15:
                v1 = 0;
                v2 = -1;
            label_17:
                ++v;
            }
            int v3 = vector0.size();
            int[] arr_v = new int[v3];
            for(int v4 = 0; v4 < v3; ++v4) {
                arr_v[v4] = (int)(((Integer)vector0.elementAt(v4)));
            }
            String s1 = bufferedReader0.readLine();
            int v5 = 1;
            while(true) {
                if(s1 == null) {
                    return;
                }
                if(s1.indexOf(s) == -1) {
                    this.g("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but next chunk does not start with boundary. Usage: GET /example/file.html");
                    throw null;
                }
                Properties properties2 = new Properties();
                String s2;
                for(s2 = bufferedReader0.readLine(); s2 != null && s2.trim().length() > 0; s2 = bufferedReader0.readLine()) {
                    int v6 = s2.indexOf(58);
                    if(v6 != -1) {
                        properties2.put(s2.substring(0, v6).trim().toLowerCase(), s2.substring(v6 + 1).trim());
                    }
                }
                if(s2 != null) {
                    String s3 = properties2.getProperty("content-disposition");
                    if(s3 == null) {
                        this.g("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but no content-disposition info found. Usage: GET /example/file.html");
                        throw null;
                    }
                    StringTokenizer stringTokenizer0 = new StringTokenizer(s3, "; ");
                    Properties properties3 = new Properties();
                    while(stringTokenizer0.hasMoreTokens()) {
                        String s4 = stringTokenizer0.nextToken();
                        int v7 = s4.indexOf(61);
                        if(v7 != -1) {
                            properties3.put(s4.substring(0, v7).trim().toLowerCase(), s4.substring(v7 + 1).trim());
                        }
                    }
                    String s5 = properties3.getProperty("name");
                    String s6 = s5.substring(1, s5.length() - 1);
                    String s7 = "";
                    if(properties2.getProperty("content-type") == null) {
                        while(s2 != null && s2.indexOf(s) == -1) {
                            s2 = bufferedReader0.readLine();
                            if(s2 != null) {
                                int v8 = s2.indexOf(s);
                                s7 = v8 == -1 ? s7 + s2 : s7 + s2.substring(0, v8 - 2);
                            }
                        }
                        s8 = s7;
                    }
                    else {
                        if(v5 + 1 > v3) {
                            this.g("500 Internal Server Error", "Error processing request");
                            throw null;
                        }
                        int v9;
                        for(v9 = arr_v[v5 - 1]; v9 < arr_b.length; ++v9) {
                            if(arr_b[v9] == 13) {
                                if(arr_b[v9 + 1] != 10) {
                                    ++v9;
                                }
                                else if(arr_b[v9 + 2] == 13) {
                                    v9 += 3;
                                    if(arr_b[v9] != 10) {
                                        continue;
                                    }
                                    break;
                                }
                                else {
                                    v9 += 2;
                                }
                            }
                        }
                        properties1.put(s6, u.f(arr_b, v9 + 1, arr_v[v5] - (v9 + 1) - 4));
                        String s9 = properties3.getProperty("filename");
                        s8 = s9.substring(1, s9.length() - 1);
                        while(true) {
                            s2 = bufferedReader0.readLine();
                            if(s2 == null || s2.indexOf(s) != -1) {
                                break;
                            }
                        }
                    }
                    properties0.put(s6, s8);
                }
                ++v5;
                s1 = s2;
            }
        }
        catch(IOException iOException0) {
        }
        this.g("500 Internal Server Error", "SERVER INTERNAL ERROR: IOException: " + iOException0.getMessage());
        throw null;
    }

    public void c(String s, Properties properties0) {
        if(s != null) {
            StringTokenizer stringTokenizer0 = new StringTokenizer(s, "&");
            while(stringTokenizer0.hasMoreTokens()) {
                String s1 = stringTokenizer0.nextToken();
                int v = s1.indexOf(61);
                if(v >= 0) {
                    properties0.put(this.d(s1.substring(0, v)).trim(), this.d(s1.substring(v + 1)));
                }
            }
        }
    }

    public String d(String s) {
        try {
            StringBuffer stringBuffer0 = new StringBuffer();
            for(int v = 0; v < s.length(); ++v) {
                int v1 = s.charAt(v);
                switch(v1) {
                    case 37: {
                        stringBuffer0.append(((char)Integer.parseInt(s.substring(v + 1, v + 3), 16)));
                        v += 2;
                        break;
                    }
                    case 43: {
                        stringBuffer0.append(' ');
                        break;
                    }
                    default: {
                        stringBuffer0.append(((char)v1));
                    }
                }
            }
            return stringBuffer0.toString();
        }
        catch(Exception unused_ex) {
            this.g("400 Bad Request", "BAD REQUEST: Bad percent-encoding.");
            throw null;
        }
    }

    private final void e() {
        try {
            ((Runnable)this.c).run();
        }
        finally {
            Object object0 = ((Q)this.b).e;
            synchronized(object0) {
                ((Q)this.b).a();
            }
        }
    }

    public static String f(byte[] arr_b, int v, int v1) {
        if(v1 > 0) {
            try {
                File file0 = File.createTempFile("NanoHTTPD", "", new File("/data/user/0/com.iloen.melon/cache"));
                FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
                fileOutputStream0.write(arr_b, v, v1);
                fileOutputStream0.close();
                return FileUtils.getSafetyPath(file0);
            }
            catch(Exception exception0) {
                LogU.e("HttpServer", "Error: " + exception0.getMessage());
            }
        }
        return "";
    }

    public void g(String s, String s1) {
        this.h(s, "text/plain", null, new ByteArrayInputStream(s1.getBytes()));
        throw new InterruptedException();
    }

    public void h(String s, String s1, Properties properties0, InputStream inputStream0) {
        Socket socket0 = (Socket)this.b;
        try {
            if(s == null) {
                throw new Error("sendResponse(): Status can\'t be null.");
            }
            OutputStream outputStream0 = socket0.getOutputStream();
            PrintWriter printWriter0 = new PrintWriter(outputStream0);
            printWriter0.print("HTTP/1.0 " + s + " \r\n");
            if(s1 != null) {
                printWriter0.print("Content-Type: " + s1 + "\r\n");
            }
            if(properties0 == null || properties0.getProperty("Date") == null) {
                new Date();
                printWriter0.print("Date: Sat, 6 Sep 2025 03:23:18 GMT\r\n");
            }
            if(properties0 != null) {
                Enumeration enumeration0 = properties0.keys();
                while(enumeration0.hasMoreElements()) {
                    String s2 = (String)enumeration0.nextElement();
                    printWriter0.print(s2 + ": " + properties0.getProperty(s2) + "\r\n");
                }
            }
            printWriter0.print("\r\n");
            printWriter0.flush();
            if(inputStream0 != null) {
                int v = inputStream0.available();
                byte[] arr_b = new byte[0x800];
                while(v > 0) {
                    int v1 = inputStream0.read(arr_b, 0, (v <= 0x800 ? v : 0x800));
                    if(v1 <= 0) {
                        break;
                    }
                    outputStream0.write(arr_b, 0, v1);
                    v -= v1;
                }
            }
            outputStream0.flush();
            outputStream0.close();
            if(inputStream0 != null) {
                inputStream0.close();
            }
        }
        catch(IOException unused_ex) {
            try {
                socket0.close();
            }
            catch(Throwable unused_ex) {
            }
        }
    }

    public void i() {
        int v;
        boolean z = false;
        boolean z1 = false;
        while(true) {
            try {
            label_2:
                ArrayDeque arrayDeque0 = ((i)this.c).b;
                __monitor_enter(arrayDeque0);
                v = FIN.finallyOpen$NT();
                if(z) {
                label_17:
                    Runnable runnable0 = (Runnable)((i)this.c).b.poll();
                    this.b = runnable0;
                    if(runnable0 == null) {
                        ((i)this.c).c = 1;
                        FIN.finallyExec$NT(v);
                        if(!z1) {
                            return;
                        }
                    }
                    else {
                        goto label_26;
                    }
                }
                else {
                    i i0 = (i)this.c;
                    if(i0.c == 4) {
                        FIN.finallyCodeBegin$NT(v);
                        __monitor_exit(arrayDeque0);
                        FIN.finallyCodeEnd$NT(v);
                        if(!z1) {
                            return;
                        }
                    }
                    else {
                        ++i0.d;
                        i0.c = 4;
                        z = true;
                        goto label_17;
                    }
                }
            }
            catch(Throwable throwable0) {
                break;
            }
            Thread.currentThread().interrupt();
            return;
            try {
            label_26:
                FIN.finallyExec$NT(v);
                z1 |= Thread.interrupted();
                try {
                    ((Runnable)this.b).run();
                }
                catch(RuntimeException runtimeException0) {
                    i.f.log(Level.SEVERE, "Exception while executing runnable " + ((Runnable)this.b), runtimeException0);
                }
                finally {
                    this.b = null;
                }
                goto label_2;
            }
            catch(Throwable throwable0) {
            }
            break;
        }
        if(z1) {
            Thread.currentThread().interrupt();
        }
        throw throwable0;
    }

    @Override
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream0;
        boolean z;
        Throwable throwable3;
        long v1;
        Properties properties4;
        String s2;
        String s1;
        Properties properties3;
        Properties properties2;
        Properties properties1;
        String s;
        int v;
        byte[] arr_b;
        InputStream inputStream0;
        Object object0;
        q q0 = null;
        switch(this.a) {
            case 0: {
                t t0 = (t)this.c;
                Future future0 = (Future)this.b;
                if(future0 instanceof a) {
                    Throwable throwable1 = ((a)future0).a();
                    if(throwable1 != null) {
                        t0.onFailure(throwable1);
                        return;
                    }
                }
                try {
                    object0 = com.google.firebase.b.D(future0);
                }
                catch(ExecutionException executionException1) {
                    t0.onFailure(executionException1.getCause());
                    return;
                }
                catch(Throwable throwable2) {
                    t0.onFailure(throwable2);
                    return;
                }
                t0.onSuccess(object0);
                return;
            }
            case 1: {
                try {
                    inputStream0 = ((Socket)this.b).getInputStream();
                    if(inputStream0 != null) {
                        arr_b = new byte[0x2000];
                        v = inputStream0.read(arr_b, 0, 0x2000);
                        if(v > 0) {
                            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(arr_b, 0, v)));
                            Properties properties0 = new Properties();
                            s = "";
                            properties1 = new Properties();
                            properties2 = new Properties();
                            properties3 = new Properties();
                            this.a(bufferedReader0, properties0, properties1, properties2);
                            s1 = properties0.getProperty("method");
                            s2 = properties0.getProperty("uri");
                            String s3 = properties2.getProperty("content-length");
                            if(s3 != null) {
                                try {
                                    properties4 = properties1;
                                    v1 = (long)Integer.parseInt(s3);
                                    goto label_55;
                                }
                                catch(NumberFormatException unused_ex) {
                                }
                            }
                            goto label_53;
                        }
                    }
                    return;
                }
                catch(IOException iOException0) {
                    goto label_122;
                }
                catch(InterruptedException unused_ex) {
                    return;
                }
            label_53:
                properties4 = properties1;
                v1 = 0x7FFFFFFFFFFFFFFFL;
            label_55:
                int v2 = 0;
                try {
                    while(true) {
                        if(v2 >= v) {
                            throwable3 = q0;
                            z = false;
                            break;
                        }
                        throwable3 = q0;
                        if(arr_b[v2] == 13) {
                            if(arr_b[v2 + 1] != 10) {
                                ++v2;
                            }
                            else if(arr_b[v2 + 2] == 13) {
                                v2 += 3;
                                if(arr_b[v2] == 10) {
                                    z = true;
                                    break;
                                }
                            }
                            else {
                                v2 += 2;
                            }
                        }
                        ++v2;
                        q0 = throwable3;
                    }
                    byteArrayOutputStream0 = new ByteArrayOutputStream();
                    if(v2 + 1 < v) {
                        byteArrayOutputStream0.write(arr_b, v2 + 1, v - (v2 + 1));
                    }
                }
                catch(IOException iOException0) {
                    goto label_123;
                }
                catch(InterruptedException unused_ex) {
                    return;
                }
                if(v2 + 1 < v) {
                    v1 -= (long)(v - (v2 + 1) + 1);
                }
                else if(!z || v1 == 0x7FFFFFFFFFFFFFFFL) {
                    v1 = 0L;
                }
                try {
                    try {
                        byte[] arr_b1 = new byte[0x200];
                        while(v >= 0 && v1 > 0L) {
                            int v3 = inputStream0.read(arr_b1, 0, 0x200);
                            v1 -= (long)v3;
                            if(v3 > 0) {
                                byteArrayOutputStream0.write(arr_b1, 0, v3);
                            }
                            v = v3;
                        }
                        byte[] arr_b2 = byteArrayOutputStream0.toByteArray();
                        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(arr_b2)));
                        if(s1.equalsIgnoreCase("POST")) {
                            StringTokenizer stringTokenizer0 = new StringTokenizer(properties2.getProperty("content-type"), "; ");
                            if((stringTokenizer0.hasMoreTokens() ? stringTokenizer0.nextToken() : "").equalsIgnoreCase("multipart/form-data")) {
                                if(stringTokenizer0.hasMoreTokens()) {
                                    StringTokenizer stringTokenizer1 = new StringTokenizer(stringTokenizer0.nextToken(), "=");
                                    if(stringTokenizer1.countTokens() == 2) {
                                        stringTokenizer1.nextToken();
                                        this.b(stringTokenizer1.nextToken(), arr_b2, bufferedReader1, properties4, properties3);
                                        goto label_113;
                                    }
                                    this.g("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but boundary syntax error. Usage: GET /example/file.html");
                                    throw throwable3;
                                }
                                this.g("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                                throw throwable3;
                            }
                            else {
                                char[] arr_c = new char[0x200];
                                for(int v4 = bufferedReader1.read(arr_c); v4 >= 0 && !s.endsWith("\r\n"); v4 = bufferedReader1.read(arr_c)) {
                                    s = s + arr_c;
                                }
                                this.c(s.trim(), properties4);
                            }
                        }
                    label_113:
                        com.google.firebase.messaging.u u0 = ((b)this.c).a(s2, s1, properties2);
                        this.h(((String)u0.a), ((String)u0.b), ((Properties)u0.d), ((InputStream)u0.c));
                        bufferedReader1.close();
                        inputStream0.close();
                        return;
                    }
                    catch(IOException iOException0) {
                    }
                    goto label_123;
                }
                catch(InterruptedException unused_ex) {
                    return;
                }
            label_122:
                throwable3 = null;
                try {
                label_123:
                    this.g("500 Internal Server Error", "SERVER INTERNAL ERROR: IOException: " + iOException0.getMessage());
                    throw throwable3;
                }
                catch(Throwable unused_ex) {
                    return;
                }
            }
            case 2: {
                ((c)this.b).a = this.c;
                return;
            }
            case 3: {
                ((Application)this.b).unregisterActivityLifecycleCallbacks(((c)this.c));
                return;
            }
            case 4: {
                try {
                    Object object1 = this.c;
                    Object object2 = this.b;
                    Method method0 = d.d;
                    if(method0 != null) {
                        method0.invoke(object2, object1, Boolean.FALSE, "AppCompat recreation");
                        return;
                    }
                    d.e.invoke(object2, object1, Boolean.FALSE);
                    return;
                }
                catch(RuntimeException runtimeException0) {
                }
                catch(Throwable throwable4) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", throwable4);
                    return;
                }
                if(runtimeException0.getClass() == RuntimeException.class && runtimeException0.getMessage() != null && runtimeException0.getMessage().startsWith("Unable to stop")) {
                    throw runtimeException0;
                }
                return;
            }
            case 5: {
                V2.a a0 = (V2.a)this.c;
                Object object3 = this.b;
                if(a0.c.get()) {
                    a0.f.dispatchOnCancelled(a0, object3);
                }
                else {
                    a0.f.dispatchOnLoadComplete(a0, object3);
                }
                a0.b = 3;
                return;
            }
            case 6: {
                w w0 = w.e();
                q q1 = (q)this.b;
                w0.a("WM-DelayedWorkTracker", "Scheduling work " + q1.a);
                ((W4.a)this.c).a.d(new q[]{q1});
                return;
            }
            case 7: {
                I7.c c0 = (I7.c)this.b;
                Typeface typeface0 = (Typeface)this.c;
                R1.a a1 = (R1.a)c0.b;
                if(a1 != null) {
                    a1.k(typeface0);
                }
                return;
            }
            case 8: {
                ((f)this.b).accept(this.c);
                return;
            }
            case 9: {
                try {
                    this.i();
                    return;
                }
                catch(Error error0) {
                    synchronized(((i)this.c).b) {
                        ((i)this.c).c = 1;
                    }
                    throw error0;
                }
            }
            case 10: {
                p p0 = (p)this.c;
                MediaSessionCompat.Token mediaSessionCompat$Token0 = (MediaSessionCompat.Token)this.b;
                ArrayList arrayList0 = (ArrayList)p0.a;
                if(!arrayList0.isEmpty()) {
                    androidx.media3.session.legacy.f f0 = mediaSessionCompat$Token0.a();
                    if(f0 != null) {
                        for(Object object4: arrayList0) {
                            ((Bundle)object4).putBinder("extra_session_binder", f0.asBinder());
                        }
                    }
                    arrayList0.clear();
                }
                X2.b b1 = (X2.b)p0.b;
                b1.getClass();
                ((MediaSession.Token)mediaSessionCompat$Token0.b).getClass();
                b1.setSessionToken(((MediaSession.Token)mediaSessionCompat$Token0.b));
                return;
            }
            case 11: {
                F0 f00 = (F0)this.c;
                h h1 = (h)f00.f;
                if(h1.g == f00.b) {
                    androidx.recyclerview.widget.u u1 = (androidx.recyclerview.widget.u)this.b;
                    List list0 = h1.f;
                    h1.e = f00.d;
                    h1.f = Collections.unmodifiableList(f00.d);
                    u1.a(h1.a);
                    h1.a(list0, ((Runnable)f00.e));
                }
                return;
            }
            case 12: {
                V4.f f1 = ((c5.a)this.c).a.m;
                String s4 = (String)this.b;
                synchronized(f1.k) {
                    G g0 = f1.c(s4);
                    if(g0 != null) {
                        q0 = g0.a;
                    }
                }
                if(q0 != null && q0.b()) {
                    synchronized(((c5.a)this.c).c) {
                        j j0 = d5.t.i(q0);
                        ((c5.a)this.c).f.put(j0, q0);
                        Job job0 = n.a(((c5.a)this.c).h, q0, ((c5.a)this.c).b.b, ((c5.a)this.c));
                        j j1 = d5.t.i(q0);
                        ((c5.a)this.c).g.put(j1, job0);
                    }
                    return;
                }
                return;
            }
            case 13: {
                Future future1 = (Future)this.b;
                if(!future1.isDone() && !future1.isCancelled()) {
                    future1.cancel(true);
                    y5.a.Y("AsyncExecutor", "Async task is taking too long, cancel it!");
                    Runnable runnable0 = (Runnable)this.c;
                    if(runnable0 != null) {
                        runnable0.run();
                    }
                }
                return;
            }
            case 14: {
                e e0 = (e)this.b;
                ((X3)((com.gaa.sdk.iap.e)this.c).b).e(((com.gaa.sdk.iap.d)e0.c), ((List)e0.b));
                return;
            }
            case 15: {
                synchronized(((com.gaa.sdk.iap.i)this.c).a) {
                    Z8.e e1 = ((com.gaa.sdk.iap.i)this.c).c;
                    if(e1 != null) {
                        e1.a(((com.gaa.sdk.iap.d)this.b));
                    }
                }
                return;
            }
            case 16: {
                View view0 = (View)this.b;
                int v9 = view0.getLeft();
                int v10 = ((IconPageIndicator)this.c).getWidth();
                int v11 = view0.getWidth();
                ((IconPageIndicator)this.c).smoothScrollTo(v9 - (v10 - v11) / 2, 0);
                ((IconPageIndicator)this.c).d = null;
                return;
            }
            case 17: {
                View view1 = (View)this.b;
                int v12 = view1.getLeft();
                int v13 = ((TabPageIndicator)this.c).getWidth();
                int v14 = view1.getWidth();
                ((TabPageIndicator)this.c).smoothScrollTo(v12 - (v13 - v14) / 2, 0);
                ((TabPageIndicator)this.c).a = null;
                return;
            }
            case 18: {
                this.e();
                return;
            }
            case 19: {
                j2.c c1 = ((SwipeDismissBehavior)this.c).a;
                if(c1 != null && c1.h()) {
                    ((View)this.b).postOnAnimation(this);
                }
                return;
            }
            case 20: {
                e1.u.D(((tg.w)this.b)).resumeWith(d5.n.t(((Throwable)this.c)));
                return;
            }
            default: {
                CancellableContinuationImpl cancellableContinuationImpl0 = (CancellableContinuationImpl)this.c;
                B b0 = (B)this.b;
                if(b0.isCancelled()) {
                    DefaultImpls.cancel$default(cancellableContinuationImpl0, null, 1, null);
                    return;
                }
                try {
                    cancellableContinuationImpl0.resumeWith(w1.i.f(b0));
                }
                catch(ExecutionException executionException0) {
                    Throwable throwable0 = executionException0.getCause();
                    if(throwable0 != null) {
                        cancellableContinuationImpl0.resumeWith(d5.n.t(throwable0));
                        return;
                    }
                    ie.h h0 = new ie.h();  // 初始化器: Ljava/lang/NullPointerException;-><init>()V
                    kotlin.jvm.internal.q.l(h0, "kotlin.jvm.internal.q");
                    throw h0;
                }
            }
        }
    }

    @Override
    public String toString() {
        String s;
        switch(this.a) {
            case 0: {
                m m0 = new m("u", 2);
                v v0 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
                ((v)m0.d).b = v0;
                m0.d = v0;
                v0.a = (t)this.c;
                return m0.toString();
            }
            case 9: {
                Runnable runnable0 = (Runnable)this.b;
                if(runnable0 != null) {
                    return "SequentialExecutorWorker{running=" + runnable0 + "}";
                }
                StringBuilder stringBuilder0 = new StringBuilder("SequentialExecutorWorker{state=");
                switch(((i)this.c).c) {
                    case 1: {
                        s = "IDLE";
                        break;
                    }
                    case 2: {
                        s = "QUEUING";
                        break;
                    }
                    case 3: {
                        s = "QUEUED";
                        break;
                    }
                    case 4: {
                        s = "RUNNING";
                        break;
                    }
                    default: {
                        s = "null";
                    }
                }
                stringBuilder0.append(s);
                stringBuilder0.append("}");
                return stringBuilder0.toString();
            }
            default: {
                return super.toString();
            }
        }
    }
}

