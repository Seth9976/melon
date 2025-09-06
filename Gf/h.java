package Gf;

import Qf.j;
import we.a;

public class h implements a {
    public final m a;
    public final a b;
    public volatile Object c;

    public h(m m0, a a0) {
        if(m0 != null) {
            super();
            this.c = k.a;
            this.a = m0;
            this.b = a0;
            return;
        }
        h.d(0);
        throw null;
    }

    public static void d(int v) {
        Object[] arr_object = new Object[(v == 2 || v == 3 ? 2 : 3)];
        switch(v) {
            case 1: {
                arr_object[0] = "computable";
                break;
            }
            case 2: 
            case 3: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
                break;
            }
            default: {
                arr_object[0] = "storageManager";
            }
        }
        switch(v) {
            case 2: {
                arr_object[1] = "recursionDetected";
                break;
            }
            case 3: {
                arr_object[1] = "renderDebugInformation";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            }
        }
        if(v != 2 && v != 3) {
            arr_object[2] = "<init>";
        }
        String s = String.format((v == 2 || v == 3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalStateException illegalStateException0 = v == 2 || v == 3 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalStateException0;
    }

    public void e(Object object0) {
    }

    public l f(boolean z) {
        l l0 = this.a.d(null, "in a lazy value");
        if(l0 != null) {
            return l0;
        }
        h.d(2);
        throw null;
    }

    @Override  // we.a
    public Object invoke() {
        Object object2;
        k k0 = k.c;
        k k1 = k.b;
        Object object0 = this.c;
        if(!(object0 instanceof k)) {
            Qf.k.k(object0);
            return object0;
        }
        this.a.a.lock();
        try {
            Object object1 = this.c;
            if(!(object1 instanceof k)) {
                Qf.k.k(object1);
                return object1;
            }
            if(object1 == k1) {
                this.c = k0;
                l l0 = this.f(true);
                if(!l0.b) {
                    return l0.c;
                }
                goto label_21;
            }
            else {
            label_21:
                if(object1 == k0) {
                    l l1 = this.f(false);
                    if(!l1.b) {
                        return l1.c;
                    }
                    goto label_26;
                }
                else {
                    try {
                    label_26:
                        this.c = k1;
                        object2 = this.b.invoke();
                        this.e(object2);
                        this.c = object2;
                    }
                    catch(Throwable throwable0) {
                        if(!Qf.k.i(throwable0)) {
                            if(this.c == k1) {
                                this.c = new j(throwable0);
                            }
                            this.a.b.getClass();
                            throw throwable0;
                        }
                        this.c = k.a;
                        throw (RuntimeException)throwable0;
                    }
                }
            }
            return object2;
        }
        finally {
            this.a.a.unlock();
        }
    }
}

