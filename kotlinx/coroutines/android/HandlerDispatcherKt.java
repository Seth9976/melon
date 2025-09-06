package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import d5.n;
import e1.u;
import f1.B;
import ie.d;
import ie.o;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\u001A\u001F\u0010\u0006\u001A\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001A\u001B\u0010\n\u001A\u00020\u0000*\u00020\u00072\u0006\u0010\t\u001A\u00020\bH\u0001¢\u0006\u0004\b\n\u0010\u000B\u001A\u0010\u0010\r\u001A\u00020\fH\u0086@¢\u0006\u0004\b\r\u0010\u000E\u001A\u0010\u0010\u000F\u001A\u00020\fH\u0082@¢\u0006\u0004\b\u000F\u0010\u000E\u001A\u001D\u0010\u0013\u001A\u00020\u00122\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001A%\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0016\u001A\u00020\u00152\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u0019\u001A\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001A\"\u001C\u0010\u001B\u001A\u0004\u0018\u00010\u00038\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u0012\u0004\b\u001D\u0010\u001E\"\u0018\u0010\u0016\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u001F¨\u0006 "}, d2 = {"Landroid/os/Handler;", "", "name", "Lkotlinx/coroutines/android/HandlerDispatcher;", "from", "(Landroid/os/Handler;Ljava/lang/String;)Lkotlinx/coroutines/android/HandlerDispatcher;", "asCoroutineDispatcher", "Landroid/os/Looper;", "", "async", "asHandler", "(Landroid/os/Looper;Z)Landroid/os/Handler;", "", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFrameSlowPath", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "Lie/H;", "updateChoreographerAndPostFrameCallback", "(Lkotlinx/coroutines/CancellableContinuation;)V", "Landroid/view/Choreographer;", "choreographer", "postFrameCallback", "(Landroid/view/Choreographer;Lkotlinx/coroutines/CancellableContinuation;)V", "MAX_DELAY", "J", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "getMain$annotations", "()V", "Landroid/view/Choreographer;", "kotlinx-coroutines-android"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class HandlerDispatcherKt {
    private static final long MAX_DELAY = 0x3FFFFFFFFFFFFFFFL;
    @Nullable
    public static final HandlerDispatcher Main;
    @Nullable
    private static volatile Choreographer choreographer;

    static {
        HandlerContext handlerContext1;
        HandlerContext handlerContext0 = null;
        try {
            handlerContext1 = new HandlerContext(HandlerDispatcherKt.asHandler(Looper.getMainLooper(), true), null, 2, null);
        }
        catch(Throwable throwable0) {
            handlerContext1 = n.t(throwable0);
        }
        if(!(handlerContext1 instanceof o)) {
            handlerContext0 = handlerContext1;
        }
        HandlerDispatcherKt.Main = handlerContext0;
    }

    public static void a(CancellableContinuation cancellableContinuation0, long v) {
        HandlerDispatcherKt.postFrameCallback$lambda$5(cancellableContinuation0, v);
    }

    public static final Object access$awaitFrameSlowPath(Continuation continuation0) {
        return HandlerDispatcherKt.awaitFrameSlowPath(continuation0);
    }

    // 检测为 Lambda 实现
    public static final void access$updateChoreographerAndPostFrameCallback(CancellableContinuation cancellableContinuation0) [...]

    @NotNull
    public static final Handler asHandler(@NotNull Looper looper0, boolean z) {
        if(z) {
            Class class0 = Looper.class;
            Class class1 = Handler.class;
            if(Build.VERSION.SDK_INT >= 28) {
                Handler handler0 = Handler.createAsync(looper0);
                q.e(handler0, "null cannot be cast to non-null type android.os.Handler");
                return handler0;
            }
            try {
                return (Handler)class1.getDeclaredConstructor(class0, Handler.Callback.class, Boolean.TYPE).newInstance(looper0, 0, Boolean.TRUE);
            }
            catch(NoSuchMethodException unused_ex) {
                return new Handler(looper0);
            }
        }
        return new Handler(looper0);
    }

    @Nullable
    public static final Object awaitFrame(@NotNull Continuation continuation0) {
        Choreographer choreographer0 = HandlerDispatcherKt.choreographer;
        if(choreographer0 != null) {
            CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
            cancellableContinuationImpl0.initCancellability();
            HandlerDispatcherKt.postFrameCallback(choreographer0, cancellableContinuationImpl0);
            return cancellableContinuationImpl0.getResult();
        }
        return HandlerDispatcherKt.awaitFrameSlowPath(continuation0);
    }

    private static final Object awaitFrameSlowPath(Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        if(Looper.myLooper() == Looper.getMainLooper()) {
            HandlerDispatcherKt.access$updateChoreographerAndPostFrameCallback(cancellableContinuationImpl0);
            return cancellableContinuationImpl0.getResult();
        }
        Dispatchers.getMain().dispatch(cancellableContinuationImpl0.getContext(), () -> HandlerDispatcherKt.updateChoreographerAndPostFrameCallback(this.$cont));
        return cancellableContinuationImpl0.getResult();

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
        final class kotlinx.coroutines.android.HandlerDispatcherKt.awaitFrameSlowPath.2.1 implements Runnable {
            public kotlinx.coroutines.android.HandlerDispatcherKt.awaitFrameSlowPath.2.1(CancellableContinuation cancellableContinuation0) {
            }

            @Override
            public final void run() {
                HandlerDispatcherKt.access$updateChoreographerAndPostFrameCallback(this.$cont);
            }
        }

    }

    @NotNull
    public static final HandlerDispatcher from(@NotNull Handler handler0) {
        return HandlerDispatcherKt.from$default(handler0, null, 1, null);
    }

    @NotNull
    public static final HandlerDispatcher from(@NotNull Handler handler0, @Nullable String s) {
        return new HandlerContext(handler0, s);
    }

    public static HandlerDispatcher from$default(Handler handler0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            s = null;
        }
        return HandlerDispatcherKt.from(handler0, s);
    }

    @d
    public static void getMain$annotations() {
    }

    private static final void postFrameCallback(Choreographer choreographer0, CancellableContinuation cancellableContinuation0) {
        choreographer0.postFrameCallback(new B(cancellableContinuation0, 1));
    }

    private static final void postFrameCallback$lambda$5(CancellableContinuation cancellableContinuation0, long v) {
        cancellableContinuation0.resumeUndispatched(Dispatchers.getMain(), v);
    }

    private static final void updateChoreographerAndPostFrameCallback(CancellableContinuation cancellableContinuation0) {
        Choreographer choreographer0 = HandlerDispatcherKt.choreographer;
        if(choreographer0 == null) {
            choreographer0 = Choreographer.getInstance();
            q.d(choreographer0);
            HandlerDispatcherKt.choreographer = choreographer0;
        }
        HandlerDispatcherKt.postFrameCallback(choreographer0, cancellableContinuation0);
    }
}

