package e3;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.appcompat.app.z;
import d5.w;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import jg.d;
import jg.e;
import kotlin.jvm.internal.q;

public final class o implements d {
    public final int a;
    public final Object b;
    public int c;
    public Object d;
    public Object e;
    public static o f;

    public o() {
        this.a = 1;
        super();
        this.b = new Object();
        this.d = null;
        this.e = null;
        this.c = 0;
    }

    public o(int v, String s, int v1, ArrayList arrayList0, byte[] arr_b) {
        this.a = 2;
        super();
        this.d = s;
        this.c = v1;
        this.e = arrayList0 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList0);
        this.b = arr_b;
    }

    public o(Context context0) {
        this.a = 0;
        super();
        this.d = new Handler(Looper.getMainLooper());
        this.e = new CopyOnWriteArrayList();
        this.b = new Object();
        this.c = 0;
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context0.registerReceiver(new z(this, 4), intentFilter0);
    }

    public o(e e0, mg.d d0) {
        this.a = 3;
        super();
        this.e = e0;
        this.b = d0;
    }

    public static void a(int v, o o0) {
        synchronized(o0.b) {
            if(o0.c == v) {
                return;
            }
            o0.c = v;
        }
        for(Object object1: ((CopyOnWriteArrayList)o0.e)) {
            WeakReference weakReference0 = (WeakReference)object1;
            w3.e e0 = (w3.e)weakReference0.get();
            if(e0 == null) {
                ((CopyOnWriteArrayList)o0.e).remove(weakReference0);
            }
            else {
                e0.a(v);
            }
        }
    }

    public static o b(Context context0) {
        synchronized(o.class) {
            if(o.f == null) {
                o.f = new o(context0);
            }
            return o.f;
        }
    }

    public int c() {
        synchronized(this.b) {
        }
        return this.c;
    }

    @Override  // jg.d
    public void d(OutputStream outputStream0) {
        q.g(outputStream0, "outputStream");
        ((mg.d)this.b).d(outputStream0);
    }

    public int e() {
        switch(this.c) {
            case 2: {
                return 0x800;
            }
            case 3: {
                return 0x200;
            }
            default: {
                return 0;
            }
        }
    }

    @Override  // jg.d
    public String f(String s) {
        return ((mg.d)this.b).a.b(s);
    }

    public void g() {
        synchronized(this.b) {
            b.j(this.c > 0);
            int v1 = this.c - 1;
            this.c = v1;
            if(v1 == 0) {
                HandlerThread handlerThread0 = (HandlerThread)this.e;
                if(handlerThread0 != null) {
                    handlerThread0.quit();
                    this.e = null;
                    this.d = null;
                }
            }
        }
    }

    public void h(URL uRL0) {
        if(!q.b(uRL0.getProtocol(), "http")) {
            throw new IOException("unsupported protocol." + uRL0.getProtocol());
        }
        this.d = InetAddress.getByName(uRL0.getHost());
        if(uRL0.getPort() > 0xFFFF) {
            throw new IOException("port number is too large. port=" + uRL0.getPort());
        }
        this.c = uRL0.getPort() >= 0 ? uRL0.getPort() : 80;
        String s = uRL0.getFile();
        q.f(s, "url.file");
        ((e)this.e).b = s;
        InetAddress inetAddress0 = (InetAddress)this.d;
        if(inetAddress0 != null) {
            String s1 = w.S(inetAddress0, this.c);
            if(s1 != null) {
                this.setHeader("HOST", s1);
                return;
            }
        }
        throw new IllegalStateException("address must be set");
    }

    @Override  // jg.d
    public void setHeader(String s, String s1) {
        q.g(s1, "value");
        ((mg.d)this.b).setHeader(s, s1);
    }

    @Override
    public String toString() {
        return this.a == 3 ? ((mg.d)this.b).toString() : super.toString();
    }
}

