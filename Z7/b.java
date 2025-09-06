package z7;

import android.text.TextUtils;
import java.io.IOException;
import java.util.Iterator;

public final class b implements Runnable {
    public final int a;
    public final c b;

    public b(c c0, int v) {
        this.a = v;
        this.b = c0;
        super();
    }

    @Override
    public final void run() {
        ea.c c2;
        A7.b b1;
        A7.b b0;
        ea.c c1;
        switch(this.a) {
            case 0: {
                this.b.a();
                return;
            }
            case 1: {
                this.b.a();
                return;
            }
            default: {
                c c0 = this.b;
                Object object0 = c.m;
                __monitor_enter(object0);
                try {
                    c0.a.a();
                    c1 = ea.c.d(c0.a.a);
                }
                catch(Throwable throwable0) {
                    goto label_16;
                }
                try {
                    b0 = c0.c.z();
                    goto label_12;
                }
                catch(Throwable throwable1) {
                    try {
                        if(c1 != null) {
                            c1.i();
                        }
                        throw throwable1;
                    label_12:
                        if(c1 != null) {
                            c1.i();
                        }
                        goto label_18;
                    }
                    catch(Throwable throwable0) {
                    }
                }
            label_16:
                __monitor_exit(object0);
                throw throwable0;
            label_18:
                __monitor_exit(object0);
                try {
                    if(b0.b == 5 || b0.b == 3) {
                        b1 = c0.g(b0);
                    }
                    else {
                        if(c0.d.a(b0)) {
                            b1 = c0.b(b0);
                            goto label_28;
                        }
                        return;
                    }
                }
                catch(e e0) {
                    c0.h(e0);
                    return;
                }
            label_28:
                __monitor_enter(object0);
                try {
                    c0.a.a();
                    c2 = ea.c.d(c0.a.a);
                }
                catch(Throwable throwable2) {
                    goto label_41;
                }
                try {
                    c0.c.t(b1);
                    goto label_37;
                }
                catch(Throwable throwable3) {
                    try {
                        if(c2 != null) {
                            c2.i();
                        }
                        throw throwable3;
                    label_37:
                        if(c2 != null) {
                            c2.i();
                        }
                        goto label_43;
                    }
                    catch(Throwable throwable2) {
                    }
                }
            label_41:
                __monitor_exit(object0);
                throw throwable2;
            label_43:
                __monitor_exit(object0);
                synchronized(c0) {
                    if(c0.k.size() != 0 && !TextUtils.equals(b0.a, b1.a)) {
                        Iterator iterator0 = c0.k.iterator();
                        if(iterator0.hasNext()) {
                            Object object1 = iterator0.next();
                            if(object1 != null) {
                                throw new ClassCastException();
                            }
                            throw null;
                        }
                    }
                }
                if(b1.b == 4) {
                    synchronized(c0) {
                        c0.j = b1.a;
                    }
                }
                int v1 = b1.b;
                if(v1 == 5) {
                    c0.h(new e());  // 初始化器: Ljava/lang/Exception;-><init>()V
                    return;
                }
                if(v1 != 1 && v1 != 2) {
                    c0.i(b1);
                    return;
                }
                c0.h(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
                return;
            }
        }
    }
}

