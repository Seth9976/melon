package q4;

import android.adservices.customaudience.CustomAudienceManager;
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

public abstract class c {
    public final CustomAudienceManager a;

    public c(CustomAudienceManager customAudienceManager0) {
        q.g(customAudienceManager0, "customAudienceManager");
        super();
        this.a = customAudienceManager0;
    }

    @Nullable
    public Object a(@NotNull d d0, @NotNull Continuation continuation0) {
        return c.b(this, d0, continuation0);
    }

    public static Object b(c c0, d d0, Continuation continuation0) {
        int v = 0;
        if((Build.VERSION.SDK_INT < 33 ? 0 : b.a.a()) < 10) {
            if(Build.VERSION.SDK_INT == 0x1F || Build.VERSION.SDK_INT == 0x20) {
                v = a.a.a();
            }
            if(v < 10) {
                throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
            }
        }
        Object object0 = q4.b.a.a(c0.a, d0, continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    @Nullable
    public Object c(@NotNull e e0, @NotNull Continuation continuation0) {
        return c.d(this, e0, continuation0);
    }

    public static Object d(c c0, e e0, Continuation continuation0) {
        new CancellableContinuationImpl(u.D(continuation0), 1).initCancellability();
        n4.b.B();
        throw null;
    }

    @Nullable
    public Object e(@NotNull f f0, @NotNull Continuation continuation0) {
        return c.f(this, f0, continuation0);
    }

    public static Object f(c c0, f f0, Continuation continuation0) {
        new CancellableContinuationImpl(u.D(continuation0), 1).initCancellability();
        n4.b.s();
        throw null;
    }
}

