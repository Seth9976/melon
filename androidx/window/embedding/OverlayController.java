package androidx.window.embedding;

import android.content.Context;
import android.os.Bundle;
import androidx.window.RequiresWindowSdkExtension;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import org.jetbrains.annotations.NotNull;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\f\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0001¢\u0006\u0004\b\n\u0010\u000BJ#\u0010\u0012\u001A\u00020\u00112\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0019\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0019\u0010\u001AJ\u001D\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001B2\u0006\u0010\u0017\u001A\u00020\u0016H\u0007¢\u0006\u0004\b\u001D\u0010\u001ER\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001F¨\u0006!"}, d2 = {"Landroidx/window/embedding/OverlayController;", "", "Landroidx/window/embedding/EmbeddingBackend;", "backend", "<init>", "(Landroidx/window/embedding/EmbeddingBackend;)V", "Landroid/os/Bundle;", "options", "Landroidx/window/embedding/OverlayCreateParams;", "overlayCreateParams", "setOverlayCreateParams$window_release", "(Landroid/os/Bundle;Landroidx/window/embedding/OverlayCreateParams;)Landroid/os/Bundle;", "setOverlayCreateParams", "Lkotlin/Function1;", "Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "Landroidx/window/embedding/OverlayAttributes;", "calculator", "Lie/H;", "setOverlayAttributesCalculator", "(Lwe/k;)V", "clearOverlayAttributesCalculator", "()V", "", "overlayTag", "overlayAttributes", "updateOverlayAttributes", "(Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;)V", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/embedding/OverlayInfo;", "overlayInfo", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/embedding/EmbeddingBackend;", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class OverlayController {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/window/embedding/OverlayController$Companion;", "", "()V", "OVERLAY_FEATURE_VERSION", "", "getInstance", "Landroidx/window/embedding/OverlayController;", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final OverlayController getInstance(@NotNull Context context0) {
            q.g(context0, "context");
            return new OverlayController(EmbeddingBackend.Companion.getInstance(context0));
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final int OVERLAY_FEATURE_VERSION = 8;
    @NotNull
    private final EmbeddingBackend backend;

    static {
        OverlayController.Companion = new Companion(null);
    }

    public OverlayController(@NotNull EmbeddingBackend embeddingBackend0) {
        q.g(embeddingBackend0, "backend");
        super();
        this.backend = embeddingBackend0;
    }

    @RequiresWindowSdkExtension(version = 8)
    public final void clearOverlayAttributesCalculator() {
        this.backend.clearOverlayAttributesCalculator();
    }

    @NotNull
    public static final OverlayController getInstance(@NotNull Context context0) {
        return OverlayController.Companion.getInstance(context0);
    }

    @RequiresWindowSdkExtension(version = 8)
    @NotNull
    public final Flow overlayInfo(@NotNull String s) {
        q.g(s, "overlayTag");
        return FlowKt.callbackFlow(new n(s, null) {
            final String $overlayTag;
            private Object L$0;
            int label;

            {
                OverlayController.this = overlayController0;
                this.$overlayTag = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new androidx.window.embedding.OverlayController.overlayInfo.1(OverlayController.this, this.$overlayTag, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((ProducerScope)object0), ((Continuation)object1));
            }

            public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
                return ((androidx.window.embedding.OverlayController.overlayInfo.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        ProducerScope producerScope0 = (ProducerScope)this.L$0;
                        androidx.window.embedding.a a1 = new androidx.window.embedding.a(producerScope0, 1);
                        l.a a2 = new l.a(1);
                        OverlayController.this.backend.addOverlayInfoCallback(this.$overlayTag, a2, a1);
                        androidx.window.embedding.OverlayController.overlayInfo.1.2 overlayController$overlayInfo$1$20 = new we.a(a1) {
                            final b2.a $listener;

                            {
                                OverlayController.this = overlayController0;
                                this.$listener = a0;
                                super(0);
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                OverlayController.this.backend.removeOverlayInfoCallback(this.$listener);
                            }
                        };
                        this.label = 1;
                        return ProduceKt.awaitClose(producerScope0, overlayController$overlayInfo$1$20, this) == a0 ? a0 : H.a;
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

            private static final void invokeSuspend$lambda$0(ProducerScope producerScope0, OverlayInfo overlayInfo0) {
                producerScope0.trySend-JP2dKIU(overlayInfo0);
            }
        });
    }

    @RequiresWindowSdkExtension(version = 8)
    public final void setOverlayAttributesCalculator(@NotNull k k0) {
        q.g(k0, "calculator");
        this.backend.setOverlayAttributesCalculator(k0);
    }

    @RequiresWindowSdkExtension(version = 8)
    @NotNull
    public final Bundle setOverlayCreateParams$window_release(@NotNull Bundle bundle0, @NotNull OverlayCreateParams overlayCreateParams0) {
        q.g(bundle0, "options");
        q.g(overlayCreateParams0, "overlayCreateParams");
        return this.backend.setOverlayCreateParams(bundle0, overlayCreateParams0);
    }

    @RequiresWindowSdkExtension(version = 8)
    public final void updateOverlayAttributes(@NotNull String s, @NotNull OverlayAttributes overlayAttributes0) {
        q.g(s, "overlayTag");
        q.g(overlayAttributes0, "overlayAttributes");
        this.backend.updateOverlayAttributes(s, overlayAttributes0);
    }
}

