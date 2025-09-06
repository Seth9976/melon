package i.n.i.b.a.s.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import androidx.media3.session.N;
import e3.b;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import w3.g;
import w3.h;
import w3.j;
import w3.k;

public final class eb extends Handler implements Runnable {
    public final int a;
    public final int b;
    public final long c;
    public IOException d;
    public int e;
    public Thread f;
    public boolean g;
    public volatile boolean h;
    public final Object i;
    public Object j;
    public final Object k;

    public eb(Object object0, Looper looper0, Object object1, Object object2, int v, long v1, int v2) {
        this.a = v2;
        this.k = object0;
        super(looper0);
        this.i = object1;
        this.j = object2;
        this.b = v;
        this.c = v1;
    }

    public void a(boolean z) {
        this.h = z;
        this.d = null;
        if(this.hasMessages(0)) {
            this.g = true;
            this.removeMessages(0);
            if(!z) {
                this.sendEmptyMessage(1);
            }
        }
        else {
            synchronized(this) {
                this.g = true;
                ((gb)this.i).b();
                Thread thread0 = this.f;
                if(thread0 != null) {
                    thread0.interrupt();
                }
            }
        }
        if(z) {
            ((sa)this.k).c = null;
            long v = SystemClock.elapsedRealtime();
            db db0 = (db)this.j;
            db0.getClass();
            db0.r(((gb)this.i), v, v - this.c, true);
            this.j = null;
        }
    }

    public void b() {
        this.d = null;
        ExecutorService executorService0 = (ExecutorService)((sa)this.k).b;
        eb eb0 = (eb)((sa)this.k).c;
        eb0.getClass();
        executorService0.execute(eb0);
    }

    public void c(boolean z) {
        this.h = z;
        this.d = null;
        if(this.hasMessages(1)) {
            this.g = true;
            this.removeMessages(1);
            if(!z) {
                this.sendEmptyMessage(2);
            }
        }
        else {
            synchronized(this) {
                this.g = true;
                ((h)this.i).cancelLoad();
                Thread thread0 = this.f;
                if(thread0 != null) {
                    thread0.interrupt();
                }
            }
        }
        if(z) {
            ((k)this.k).b = null;
            long v = SystemClock.elapsedRealtime();
            g g0 = (g)this.j;
            g0.getClass();
            g0.h(((h)this.i), v, v - this.c, true);
            this.j = null;
        }
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        if(this.a != 0) {
            if(!this.h) {
                int v = message0.what;
                if(v == 1) {
                    SystemClock.elapsedRealtime();
                    ((g)this.j).getClass();
                    this.d = null;
                    eb eb0 = ((k)this.k).b;
                    eb0.getClass();
                    ((k)this.k).a.execute(eb0);
                    return;
                }
                if(v != 4) {
                    ((k)this.k).b = null;
                    long v1 = SystemClock.elapsedRealtime();
                    long v2 = v1 - this.c;
                    g g0 = (g)this.j;
                    g0.getClass();
                    if(this.g) {
                        g0.h(((h)this.i), v1, v2, false);
                        return;
                    }
                    switch(message0.what) {
                        case 2: {
                            try {
                                g0.d(((h)this.i), v1, v2);
                            }
                            catch(RuntimeException runtimeException0) {
                                b.q("LoadTask", "Unexpected exception handling load completed", runtimeException0);
                                ((k)this.k).c = new j(runtimeException0);
                            }
                            return;
                        }
                        case 3: {
                            this.d = (IOException)message0.obj;
                            int v3 = this.e + 1;
                            this.e = v3;
                            N n0 = g0.a(((h)this.i), v1, v2, ((IOException)message0.obj), v3);
                            int v4 = n0.a;
                            if(v4 == 3) {
                                ((k)this.k).c = this.d;
                                return;
                            }
                            switch(v4) {
                                case 1: {
                                    this.e = 1;
                                label_39:
                                    long v5 = n0.b == 0x8000000000000001L ? ((long)Math.min((this.e - 1) * 1000, 5000)) : n0.b;
                                    k k0 = (k)this.k;
                                    b.j(k0.b == null);
                                    k0.b = this;
                                    if(v5 > 0L) {
                                        this.sendEmptyMessageDelayed(1, v5);
                                        return;
                                    }
                                    SystemClock.elapsedRealtime();
                                    ((g)this.j).getClass();
                                    this.d = null;
                                    eb eb1 = k0.b;
                                    eb1.getClass();
                                    k0.a.execute(eb1);
                                    return;
                                }
                                case 2: {
                                    return;
                                }
                                default: {
                                    goto label_39;
                                }
                            }
                        }
                        default: {
                            return;
                        }
                    }
                }
                throw (Error)message0.obj;
            }
            return;
        }
        if(!this.h) {
            int v6 = message0.what;
            if(v6 == 0) {
                this.b();
                return;
            }
            if(v6 != 3) {
                ((sa)this.k).c = null;
                long v7 = SystemClock.elapsedRealtime();
                long v8 = v7 - this.c;
                db db0 = (db)this.j;
                db0.getClass();
                if(this.g) {
                    db0.r(((gb)this.i), v7, v8, false);
                    return;
                }
                boolean z = true;
                switch(message0.what) {
                    case 1: {
                        try {
                            db0.o(((gb)this.i), v7, v8);
                        }
                        catch(RuntimeException runtimeException1) {
                            M7.H("LoadTask", "Unexpected exception handling load completed", runtimeException1);
                            ((sa)this.k).d = new lb(runtimeException1);
                        }
                        return;
                    }
                    case 2: {
                        this.d = (IOException)message0.obj;
                        int v9 = this.e + 1;
                        this.e = v9;
                        Jd jd0 = db0.f(((gb)this.i), v7, v8, ((IOException)message0.obj), v9);
                        int v10 = jd0.a;
                        if(v10 == 3) {
                            ((sa)this.k).d = this.d;
                            return;
                        }
                        switch(v10) {
                            case 1: {
                                this.e = 1;
                            label_89:
                                long v11 = jd0.b == 0x8000000000000001L ? ((long)Math.min((this.e - 1) * 1000, 5000)) : jd0.b;
                                sa sa0 = (sa)this.k;
                                if(((eb)sa0.c) != null) {
                                    z = false;
                                }
                                M7.J(z);
                                sa0.c = this;
                                if(v11 > 0L) {
                                    this.sendEmptyMessageDelayed(0, v11);
                                    return;
                                }
                                this.b();
                                return;
                            }
                            case 2: {
                                return;
                            }
                            default: {
                                goto label_89;
                            }
                        }
                    }
                    default: {
                        return;
                    }
                }
            }
            throw (Error)message0.obj;
        }
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            try {
                __monitor_enter(this);
                this.f = Thread.currentThread();
                __monitor_exit(this);
                if(!this.g) {
                    Trace.beginSection(("load:" + ((h)this.i).getClass().getSimpleName()));
                    try {
                        ((h)this.i).load();
                    }
                    finally {
                        Trace.endSection();
                    }
                }
                synchronized(this) {
                    this.f = null;
                    Thread.interrupted();
                }
                if(!this.h) {
                    this.sendEmptyMessage(2);
                    return;
                label_28:
                    if(!this.h) {
                        goto label_29;
                    }
                }
                return;
            }
            catch(IOException iOException0) {
                goto label_28;
            }
            catch(Exception exception0) {
                goto label_31;
            }
            catch(OutOfMemoryError outOfMemoryError0) {
                goto label_35;
            }
            catch(Error error0) {
                goto label_39;
            }
        label_29:
            this.obtainMessage(3, iOException0).sendToTarget();
            return;
        label_31:
            if(!this.h) {
                b.q("LoadTask", "Unexpected exception loading stream", exception0);
                this.obtainMessage(3, new j(exception0)).sendToTarget();
                return;
            label_35:
                if(!this.h) {
                    b.q("LoadTask", "OutOfMemory error loading stream", outOfMemoryError0);
                    this.obtainMessage(3, new j(outOfMemoryError0)).sendToTarget();
                    return;
                label_39:
                    if(!this.h) {
                        b.q("LoadTask", "Unexpected error loading stream", error0);
                        this.obtainMessage(4, error0).sendToTarget();
                    }
                    throw error0;
                }
            }
            return;
        }
        try {
            __monitor_enter(this);
            this.f = Thread.currentThread();
            __monitor_exit(this);
            if(!this.g) {
                Ja.M(("load:" + ((gb)this.i).getClass().getSimpleName()));
                try {
                    SystemClock.elapsedRealtime();
                    ((gb)this.i).g();
                }
                finally {
                    Ja.u();
                }
            }
            synchronized(this) {
                this.f = null;
                Thread.interrupted();
            }
            if(!this.h) {
                this.sendEmptyMessage(1);
                return;
            label_72:
                if(!this.h) {
                    goto label_73;
                }
            }
            return;
        }
        catch(IOException iOException1) {
            goto label_72;
        }
        catch(Exception exception1) {
            goto label_75;
        }
        catch(OutOfMemoryError outOfMemoryError1) {
            goto label_79;
        }
        catch(Error error1) {
            goto label_83;
        }
    label_73:
        this.obtainMessage(2, iOException1).sendToTarget();
        return;
    label_75:
        if(!this.h) {
            M7.H("LoadTask", "Unexpected exception loading stream", exception1);
            this.obtainMessage(2, new lb(exception1)).sendToTarget();
            return;
        label_79:
            if(!this.h) {
                M7.H("LoadTask", "OutOfMemory error loading stream", outOfMemoryError1);
                this.obtainMessage(2, new lb(outOfMemoryError1)).sendToTarget();
                return;
            label_83:
                if(!this.h) {
                    M7.H("LoadTask", "Unexpected error loading stream", error1);
                    this.obtainMessage(3, error1).sendToTarget();
                }
                throw error1;
            }
        }
    }
}

