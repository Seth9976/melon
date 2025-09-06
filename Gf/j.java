package Gf;

import Qf.i;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.M0;
import androidx.compose.runtime.b0;
import androidx.lifecycle.s0;
import androidx.lifecycle.t0;
import androidx.lifecycle.t;
import ie.H;
import java.util.concurrent.ConcurrentHashMap;
import jd.Z;
import jd.x2;
import kotlinx.coroutines.MainCoroutineDispatcher;
import u5.e;
import we.k;

public class j implements k {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public j(b0 b00, k k0, x2 x20) {
        this.a = 2;
        super();
        this.b = b00;
        this.d = k0;
        this.c = x20;
    }

    public j(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    public static void d(int v) {
        Object[] arr_object = new Object[(v == 3 || v == 4 ? 2 : 3)];
        switch(v) {
            case 1: {
                arr_object[0] = "map";
                break;
            }
            case 2: {
                arr_object[0] = "compute";
                break;
            }
            case 3: 
            case 4: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
                break;
            }
            default: {
                arr_object[0] = "storageManager";
            }
        }
        switch(v) {
            case 3: {
                arr_object[1] = "recursionDetected";
                break;
            }
            case 4: {
                arr_object[1] = "raceCondition";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            }
        }
        if(v != 3 && v != 4) {
            arr_object[2] = "<init>";
        }
        String s = String.format((v == 3 || v == 4 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalStateException illegalStateException0 = v == 3 || v == 4 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalStateException0;
    }

    public AssertionError e(Object object0, Object object1) {
        AssertionError assertionError0 = new AssertionError("Inconsistent key detected. " + Gf.k.b + " is expected, was: " + object1 + ", most probably race condition detected on input " + object0 + " under " + ((m)this.b));
        m.e(assertionError0);
        return assertionError0;
    }

    public AssertionError f(Object object0, Object object1) {
        AssertionError assertionError0 = new AssertionError("Race condition detected on input " + object0 + ". Old value is " + object1 + " under " + ((m)this.b));
        m.e(assertionError0);
        return assertionError0;
    }

    public AssertionError g(Object object0, Throwable throwable0) {
        AssertionError assertionError0 = new AssertionError("Unable to remove " + object0 + " under " + ((m)this.b), throwable0);
        m.e(assertionError0);
        return assertionError0;
    }

    @Override  // we.k
    public Object invoke(Object object0) {
        Object object3;
        switch(this.a) {
            case 0: {
                m m0 = (m)this.b;
                a a0 = m0.b;
                o o0 = m0.a;
                ConcurrentHashMap concurrentHashMap0 = (ConcurrentHashMap)this.c;
                Gf.k k0 = concurrentHashMap0.get(object0);
                i i1 = Qf.k.a;
                Throwable throwable1 = null;
                Gf.k k1 = Gf.k.b;
                if(k0 != null && k0 != k1) {
                    Qf.k.k(k0);
                    if(k0 == i1) {
                        return null;
                    }
                    try {
                        return k0;
                    }
                    catch(Throwable throwable2) {
                        goto label_58;
                    }
                }
                o0.lock();
                try {
                    k0 = concurrentHashMap0.get(object0);
                    Gf.k k2 = Gf.k.c;
                    if(k0 == k1) {
                        l l0 = m0.d(object0, "");
                        if(l0 == null) {
                            j.d(3);
                            throw null;
                        }
                        if(l0.b) {
                            k0 = k2;
                            goto label_36;
                        }
                        else {
                            k0 = l0.c;
                        }
                    }
                    else {
                    label_36:
                        if(k0 == k2) {
                            l l1 = m0.d(object0, "");
                            if(l1 == null) {
                                j.d(3);
                                throw null;
                            }
                            if(!l1.b) {
                                k0 = l1.c;
                                goto label_81;
                            }
                            goto label_44;
                        }
                        else {
                        label_44:
                            if(k0 == null) {
                                goto label_49;
                            }
                            else {
                                Qf.k.k(k0);
                                if(k0 == i1) {
                                    goto label_47;
                                }
                            }
                        }
                    }
                    goto label_81;
                }
                catch(Throwable throwable3) {
                    goto label_79;
                }
            label_47:
                k0 = null;
                goto label_81;
                try {
                label_49:
                    concurrentHashMap0.put(object0, k1);
                    k0 = ((k)this.d).invoke(object0);
                    if(k0 != null) {
                        i1 = k0;
                    }
                    Object object1 = concurrentHashMap0.put(object0, i1);
                    if(object1 != k1) {
                        throwable1 = this.f(object0, object1);
                        throw throwable1;
                    }
                    goto label_81;
                }
                catch(Throwable throwable2) {
                    try {
                    label_58:
                        if(!Qf.k.i(throwable2)) {
                            if(throwable2 != throwable1) {
                                Object object2 = concurrentHashMap0.put(object0, new Qf.j(throwable2));
                                if(object2 != k1) {
                                    throw this.f(object0, object2);
                                }
                                a0.getClass();
                                throw throwable2;
                            }
                            goto label_65;
                        }
                        goto label_71;
                    }
                    catch(Throwable throwable3) {
                        goto label_79;
                    }
                    try {
                    label_65:
                        concurrentHashMap0.remove(object0);
                        goto label_69;
                    }
                    catch(Throwable throwable4) {
                        try {
                            throw this.g(object0, throwable4);
                        label_69:
                            a0.getClass();
                            throw throwable2;
                        }
                        catch(Throwable throwable3) {
                            goto label_79;
                        }
                    }
                    try {
                    label_71:
                        object3 = concurrentHashMap0.remove(object0);
                        goto label_75;
                    }
                    catch(Throwable throwable5) {
                        try {
                            throw this.g(object0, throwable5);
                        label_75:
                            if(object3 != k1) {
                                throw this.e(object0, object3);
                            }
                            throw (RuntimeException)throwable2;
                        }
                        catch(Throwable throwable3) {
                        }
                    }
                }
            label_79:
                o0.unlock();
                throw throwable3;
            label_81:
                o0.unlock();
                return k0;
            }
            case 1: {
                Throwable throwable6 = (Throwable)object0;
                t0 t00 = (t0)this.d;
                t t0 = (t)this.c;
                MainCoroutineDispatcher mainCoroutineDispatcher0 = (MainCoroutineDispatcher)this.b;
                me.j j0 = me.j.a;
                if(mainCoroutineDispatcher0.isDispatchNeeded(j0)) {
                    mainCoroutineDispatcher0.dispatch(j0, new s0(t0, t00, 1));
                    return H.a;
                }
                t0.c(t00);
                return H.a;
            }
            case 2: {
                ((Boolean)object0).getClass();
                ((b0)this.b).setValue(Boolean.TRUE);
                Z z0 = new Z(((x2)this.c));
                ((k)this.d).invoke(z0);
                return H.a;
            }
            case 3: {
                float f = ((Number)object0).floatValue();
                M0 m00 = (M0)this.d;
                if(Float.compare(f, m00.m()) < 0) {
                    ((we.a)this.b).invoke();
                    return true;
                }
                if(f > ((float)m00.m())) {
                    ((we.a)this.c).invoke();
                    return true;
                }
                return false;
            }
            default: {
                Throwable throwable0 = (Throwable)object0;
                e e0 = (e)this.b;
                ViewTreeObserver viewTreeObserver0 = (ViewTreeObserver)this.c;
                u5.i i0 = (u5.i)this.d;
                if(viewTreeObserver0.isAlive()) {
                    viewTreeObserver0.removeOnPreDrawListener(i0);
                    return H.a;
                }
                e0.a.getViewTreeObserver().removeOnPreDrawListener(i0);
                return H.a;
            }
        }
    }
}

