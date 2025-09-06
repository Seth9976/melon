package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.window.WindowSdkExtensions;
import androidx.window.layout.adapter.WindowBackend;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F2\u0006\u0010\u0011\u001A\u00020\u0012H\u0016J\u0016\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F2\u0006\u0010\u0013\u001A\u00020\u0014H\u0016R\u001A\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/window/layout/WindowInfoTrackerImpl;", "Landroidx/window/layout/WindowInfoTracker;", "windowMetricsCalculator", "Landroidx/window/layout/WindowMetricsCalculator;", "windowBackend", "Landroidx/window/layout/adapter/WindowBackend;", "windowSdkExtensions", "Landroidx/window/WindowSdkExtensions;", "(Landroidx/window/layout/WindowMetricsCalculator;Landroidx/window/layout/adapter/WindowBackend;Landroidx/window/WindowSdkExtensions;)V", "supportedPostures", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures", "()Ljava/util/List;", "windowLayoutInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    @NotNull
    private final WindowBackend windowBackend;
    @NotNull
    private final WindowMetricsCalculator windowMetricsCalculator;
    @NotNull
    private final WindowSdkExtensions windowSdkExtensions;

    public WindowInfoTrackerImpl(@NotNull WindowMetricsCalculator windowMetricsCalculator0, @NotNull WindowBackend windowBackend0, @NotNull WindowSdkExtensions windowSdkExtensions0) {
        q.g(windowMetricsCalculator0, "windowMetricsCalculator");
        q.g(windowBackend0, "windowBackend");
        q.g(windowSdkExtensions0, "windowSdkExtensions");
        super();
        this.windowMetricsCalculator = windowMetricsCalculator0;
        this.windowBackend = windowBackend0;
        this.windowSdkExtensions = windowSdkExtensions0;
    }

    @Override  // androidx.window.layout.WindowInfoTracker
    @NotNull
    public List getSupportedPostures() {
        this.windowSdkExtensions.requireExtensionVersion$window_release(6);
        return this.windowBackend.getSupportedPostures();
    }

    @Override  // androidx.window.layout.WindowInfoTracker
    @NotNull
    public Flow windowLayoutInfo(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        return FlowKt.flowOn(FlowKt.callbackFlow(new n(activity0, null) {
            final Activity $activity;
            private Object L$0;
            int label;

            {
                WindowInfoTrackerImpl.this = windowInfoTrackerImpl0;
                this.$activity = activity0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new androidx.window.layout.WindowInfoTrackerImpl.windowLayoutInfo.2(WindowInfoTrackerImpl.this, this.$activity, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((ProducerScope)object0), ((Continuation)object1));
            }

            public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
                return ((androidx.window.layout.WindowInfoTrackerImpl.windowLayoutInfo.2)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        ProducerScope producerScope0 = (ProducerScope)this.L$0;
                        androidx.window.layout.a a1 = new androidx.window.layout.a(producerScope0, 1);
                        l.a a2 = new l.a(1);
                        WindowInfoTrackerImpl.this.windowBackend.registerLayoutChangeCallback(this.$activity, a2, a1);
                        androidx.window.layout.WindowInfoTrackerImpl.windowLayoutInfo.2.2 windowInfoTrackerImpl$windowLayoutInfo$2$20 = new we.a(a1) {
                            final b2.a $listener;

                            {
                                WindowInfoTrackerImpl.this = windowInfoTrackerImpl0;
                                this.$listener = a0;
                                super(0);
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                WindowInfoTrackerImpl.this.windowBackend.unregisterLayoutChangeCallback(this.$listener);
                            }
                        };
                        this.label = 1;
                        return ProduceKt.awaitClose(producerScope0, windowInfoTrackerImpl$windowLayoutInfo$2$20, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }

            private static final void invokeSuspend$lambda$0(ProducerScope producerScope0, WindowLayoutInfo windowLayoutInfo0) {
                producerScope0.trySend-JP2dKIU(windowLayoutInfo0);
            }
        }), Dispatchers.getMain());
    }

    @Override  // androidx.window.layout.WindowInfoTracker
    @NotNull
    public Flow windowLayoutInfo(@NotNull Context context0) {
        q.g(context0, "context");
        return FlowKt.flowOn(FlowKt.callbackFlow(new n(context0, null) {
            final Context $context;
            private Object L$0;
            int label;

            {
                WindowInfoTrackerImpl.this = windowInfoTrackerImpl0;
                this.$context = context0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new androidx.window.layout.WindowInfoTrackerImpl.windowLayoutInfo.1(WindowInfoTrackerImpl.this, this.$context, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((ProducerScope)object0), ((Continuation)object1));
            }

            public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
                return ((androidx.window.layout.WindowInfoTrackerImpl.windowLayoutInfo.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        ProducerScope producerScope0 = (ProducerScope)this.L$0;
                        androidx.window.layout.a a1 = new androidx.window.layout.a(producerScope0, 0);
                        l.a a2 = new l.a(1);
                        WindowInfoTrackerImpl.this.windowBackend.registerLayoutChangeCallback(this.$context, a2, a1);
                        androidx.window.layout.WindowInfoTrackerImpl.windowLayoutInfo.1.2 windowInfoTrackerImpl$windowLayoutInfo$1$20 = new we.a(a1) {
                            final b2.a $listener;

                            {
                                WindowInfoTrackerImpl.this = windowInfoTrackerImpl0;
                                this.$listener = a0;
                                super(0);
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                WindowInfoTrackerImpl.this.windowBackend.unregisterLayoutChangeCallback(this.$listener);
                            }
                        };
                        this.label = 1;
                        return ProduceKt.awaitClose(producerScope0, windowInfoTrackerImpl$windowLayoutInfo$1$20, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }

            private static final void invokeSuspend$lambda$0(ProducerScope producerScope0, WindowLayoutInfo windowLayoutInfo0) {
                producerScope0.trySend-JP2dKIU(windowLayoutInfo0);
            }
        }), Dispatchers.getMain());
    }
}

