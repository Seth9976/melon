package o4;

import android.adservices.adselection.AdSelectionManager;
import android.adservices.adselection.AdSelectionOutcome;
import android.os.Build.VERSION;
import e1.u;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r4.a;
import r4.b;

public abstract class j {
    public final AdSelectionManager a;

    public j(AdSelectionManager adSelectionManager0) {
        q.g(adSelectionManager0, "mAdSelectionManager");
        super();
        this.a = adSelectionManager0;
    }

    @Nullable
    public Object a(@NotNull m m0, @NotNull Continuation continuation0) {
        return j.b(this, m0, continuation0);
    }

    public static Object b(j j0, m m0, Continuation continuation0) {
        int v = 0;
        if((Build.VERSION.SDK_INT < 33 ? 0 : b.a.a()) < 10) {
            if(Build.VERSION.SDK_INT == 0x1F || Build.VERSION.SDK_INT == 0x20) {
                v = a.a.a();
            }
            if(v < 10) {
                throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
            }
        }
        return g.a.a(j0.a, m0, continuation0);
    }

    @Nullable
    public Object c(@NotNull n n0, @NotNull Continuation continuation0) {
        return j.d(this, n0, continuation0);
    }

    public static Object d(j j0, n n0, Continuation continuation0) {
        int v = 0;
        if((Build.VERSION.SDK_INT < 33 ? 0 : b.a.a()) < 10) {
            if(Build.VERSION.SDK_INT == 0x1F || Build.VERSION.SDK_INT == 0x20) {
                v = a.a.a();
            }
            if(v < 10) {
                throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
            }
        }
        return g.a.b(j0.a, n0, continuation0);
    }

    @Nullable
    public Object e(@NotNull o o0, @NotNull Continuation continuation0) {
        return j.f(this, o0, continuation0);
    }

    public static Object f(j j0, o o0, Continuation continuation0) {
        int v = 0;
        if((Build.VERSION.SDK_INT < 33 ? 0 : b.a.a()) < 8) {
            if(Build.VERSION.SDK_INT == 0x1F || Build.VERSION.SDK_INT == 0x20) {
                v = a.a.a();
            }
            if(v < 9) {
                throw new UnsupportedOperationException("API is unsupported. Min version is API 33 ext 8 or API 31/32 ext 9");
            }
        }
        Object object0 = g.b.a(j0.a, o0, continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    @Nullable
    public Object g(@NotNull p p0, @NotNull Continuation continuation0) {
        return j.h(this, p0, continuation0);
    }

    public static Object h(j j0, p p0, Continuation continuation0) {
        new CancellableContinuationImpl(u.D(continuation0), 1).initCancellability();
        throw null;
    }

    @Nullable
    public Object i(@NotNull o4.a a0, @NotNull Continuation continuation0) {
        return j.k(this, a0, continuation0);
    }

    @Nullable
    public Object j(@NotNull o4.b b0, @NotNull Continuation continuation0) {
        return j.l(this, b0, continuation0);
    }

    public static Object k(j j0, o4.a a0, Continuation continuation0) {
        i i0;
        if(continuation0 instanceof i) {
            i0 = (i)continuation0;
            int v = i0.B;
            if((v & 0x80000000) == 0) {
                i0 = new i(j0, continuation0);
            }
            else {
                i0.B = v ^ 0x80000000;
            }
        }
        else {
            i0 = new i(j0, continuation0);
        }
        Object object0 = i0.r;
        switch(i0.B) {
            case 0: {
                d5.n.D(object0);
                throw null;
            }
            case 1: {
                d5.n.D(object0);
                return new k(((AdSelectionOutcome)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static Object l(j j0, o4.b b0, Continuation continuation0) {
        int v = 0;
        if((Build.VERSION.SDK_INT < 33 ? 0 : b.a.a()) < 10) {
            if(Build.VERSION.SDK_INT == 0x1F || Build.VERSION.SDK_INT == 0x20) {
                v = a.a.a();
            }
            if(v < 10) {
                throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
            }
        }
        return g.a.c(j0.a, b0, continuation0);
    }

    @Nullable
    public Object m(@NotNull o4.q q0, @NotNull Continuation continuation0) {
        return j.n(this, q0, continuation0);
    }

    public static Object n(j j0, o4.q q0, Continuation continuation0) {
        int v = 0;
        if((Build.VERSION.SDK_INT < 33 ? 0 : b.a.a()) < 8) {
            if(Build.VERSION.SDK_INT == 0x1F || Build.VERSION.SDK_INT == 0x20) {
                v = a.a.a();
            }
            if(v < 9) {
                throw new UnsupportedOperationException("API is unsupported. Min version is API 33 ext 8 or API 31/32 ext 9");
            }
        }
        Object object0 = g.b.b(j0.a, q0, continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }
}

