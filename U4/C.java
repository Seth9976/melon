package u4;

import android.adservices.measurement.MeasurementManager;
import android.net.Uri;
import android.view.InputEvent;
import e1.u;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import n4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class c {
    public final MeasurementManager a;

    public c(MeasurementManager measurementManager0) {
        q.g(measurementManager0, "mMeasurementManager");
        super();
        this.a = measurementManager0;
    }

    @Nullable
    public Object a(@NotNull a a0, @NotNull Continuation continuation0) {
        return c.b(this, a0, continuation0);
    }

    public static Object b(c c0, a a0, Continuation continuation0) {
        new CancellableContinuationImpl(u.D(continuation0), 1).initCancellability();
        throw null;
    }

    @Nullable
    public Object c(@NotNull Continuation continuation0) {
        return c.d(this, continuation0);
    }

    public static Object d(c c0, Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        l.a a0 = new l.a(1);
        Y1.c c1 = new Y1.c(cancellableContinuationImpl0);
        b.x(c0.a, a0, c1);
        return cancellableContinuationImpl0.getResult();
    }

    @Nullable
    public Object e(@NotNull Uri uri0, @Nullable InputEvent inputEvent0, @NotNull Continuation continuation0) {
        return c.g(this, uri0, inputEvent0, continuation0);
    }

    @Nullable
    public Object f(@NotNull d d0, @NotNull Continuation continuation0) {
        return c.h(this, d0, continuation0);
    }

    public static Object g(c c0, Uri uri0, InputEvent inputEvent0, Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        l.a a0 = new l.a(1);
        Y1.c c1 = new Y1.c(cancellableContinuationImpl0);
        b.v(c0.a, uri0, inputEvent0, a0, c1);
        Object object0 = cancellableContinuationImpl0.getResult();
        return object0 == ne.a.a ? object0 : H.a;
    }

    public static Object h(c c0, d d0, Continuation continuation0) {
        Object object0 = CoroutineScopeKt.coroutineScope(new u4.b(c0, null), continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    @Nullable
    public Object i(@NotNull Uri uri0, @NotNull Continuation continuation0) {
        return c.j(this, uri0, continuation0);
    }

    public static Object j(c c0, Uri uri0, Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        l.a a0 = new l.a(1);
        Y1.c c1 = new Y1.c(cancellableContinuationImpl0);
        b.w(c0.a, uri0, a0, c1);
        Object object0 = cancellableContinuationImpl0.getResult();
        return object0 == ne.a.a ? object0 : H.a;
    }

    @Nullable
    public Object k(@NotNull e e0, @NotNull Continuation continuation0) {
        return c.l(this, e0, continuation0);
    }

    public static Object l(c c0, e e0, Continuation continuation0) {
        new CancellableContinuationImpl(u.D(continuation0), 1).initCancellability();
        throw null;
    }

    @Nullable
    public Object m(@NotNull f f0, @NotNull Continuation continuation0) {
        return c.n(this, f0, continuation0);
    }

    public static Object n(c c0, f f0, Continuation continuation0) {
        new CancellableContinuationImpl(u.D(continuation0), 1).initCancellability();
        throw null;
    }
}

