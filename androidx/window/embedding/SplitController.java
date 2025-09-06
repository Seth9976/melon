package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import androidx.window.RequiresWindowSdkExtension;
import ie.H;
import java.util.List;
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

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0002()B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u000E\u001A\u00020\rH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001B\u001A\u00020\u00142\u0012\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017H\u0007¢\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0014H\u0007¢\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010!\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020\n2\u0006\u0010 \u001A\u00020\u0019H\u0007¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010#R\u0011\u0010\'\u001A\u00020$8F¢\u0006\u0006\u001A\u0004\b%\u0010&¨\u0006*"}, d2 = {"Landroidx/window/embedding/SplitController;", "", "Landroidx/window/embedding/EmbeddingBackend;", "embeddingBackend", "<init>", "(Landroidx/window/embedding/EmbeddingBackend;)V", "Landroid/app/Activity;", "activity", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/window/embedding/SplitInfo;", "splitInfoList", "(Landroid/app/Activity;)Lkotlinx/coroutines/flow/Flow;", "", "taskId", "Landroidx/window/embedding/SplitPinRule;", "splitPinRule", "", "pinTopActivityStack", "(ILandroidx/window/embedding/SplitPinRule;)Z", "Lie/H;", "unpinTopActivityStack", "(I)V", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "Landroidx/window/embedding/SplitAttributes;", "calculator", "setSplitAttributesCalculator", "(Lwe/k;)V", "clearSplitAttributesCalculator", "()V", "splitInfo", "splitAttributes", "updateSplitAttributes", "(Landroidx/window/embedding/SplitInfo;Landroidx/window/embedding/SplitAttributes;)V", "Landroidx/window/embedding/EmbeddingBackend;", "Landroidx/window/embedding/SplitController$SplitSupportStatus;", "getSplitSupportStatus", "()Landroidx/window/embedding/SplitController$SplitSupportStatus;", "splitSupportStatus", "Companion", "SplitSupportStatus", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SplitController {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/window/embedding/SplitController$Companion;", "", "()V", "sDebug", "", "getInstance", "Landroidx/window/embedding/SplitController;", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SplitController getInstance(@NotNull Context context0) {
            q.g(context0, "context");
            return new SplitController(EmbeddingBackend.Companion.getInstance(context0));
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0006H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/window/embedding/SplitController$SplitSupportStatus;", "", "rawValue", "", "(I)V", "toString", "", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class SplitSupportStatus {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/window/embedding/SplitController$SplitSupportStatus$Companion;", "", "()V", "SPLIT_AVAILABLE", "Landroidx/window/embedding/SplitController$SplitSupportStatus;", "SPLIT_ERROR_PROPERTY_NOT_DECLARED", "SPLIT_UNAVAILABLE", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class androidx.window.embedding.SplitController.SplitSupportStatus.Companion {
            private androidx.window.embedding.SplitController.SplitSupportStatus.Companion() {
            }

            public androidx.window.embedding.SplitController.SplitSupportStatus.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final androidx.window.embedding.SplitController.SplitSupportStatus.Companion Companion;
        @NotNull
        public static final SplitSupportStatus SPLIT_AVAILABLE;
        @NotNull
        public static final SplitSupportStatus SPLIT_ERROR_PROPERTY_NOT_DECLARED;
        @NotNull
        public static final SplitSupportStatus SPLIT_UNAVAILABLE;
        private final int rawValue;

        static {
            SplitSupportStatus.Companion = new androidx.window.embedding.SplitController.SplitSupportStatus.Companion(null);
            SplitSupportStatus.SPLIT_AVAILABLE = new SplitSupportStatus(0);
            SplitSupportStatus.SPLIT_UNAVAILABLE = new SplitSupportStatus(1);
            SplitSupportStatus.SPLIT_ERROR_PROPERTY_NOT_DECLARED = new SplitSupportStatus(2);
        }

        private SplitSupportStatus(int v) {
            this.rawValue = v;
        }

        @Override
        @NotNull
        public String toString() {
            switch(this.rawValue) {
                case 0: {
                    return "SplitSupportStatus: AVAILABLE";
                }
                case 1: {
                    return "SplitSupportStatus: UNAVAILABLE";
                }
                case 2: {
                    return "SplitSupportStatus: ERROR_SPLIT_PROPERTY_NOT_DECLARED";
                }
                default: {
                    return "UNKNOWN";
                }
            }
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final EmbeddingBackend embeddingBackend;
    public static final boolean sDebug = false;

    static {
        SplitController.Companion = new Companion(null);
    }

    public SplitController(@NotNull EmbeddingBackend embeddingBackend0) {
        q.g(embeddingBackend0, "embeddingBackend");
        super();
        this.embeddingBackend = embeddingBackend0;
    }

    @RequiresWindowSdkExtension(version = 2)
    public final void clearSplitAttributesCalculator() {
        this.embeddingBackend.clearSplitAttributesCalculator();
    }

    @NotNull
    public static final SplitController getInstance(@NotNull Context context0) {
        return SplitController.Companion.getInstance(context0);
    }

    @NotNull
    public final SplitSupportStatus getSplitSupportStatus() {
        return this.embeddingBackend.getSplitSupportStatus();
    }

    @RequiresWindowSdkExtension(version = 5)
    public final boolean pinTopActivityStack(int v, @NotNull SplitPinRule splitPinRule0) {
        q.g(splitPinRule0, "splitPinRule");
        return this.embeddingBackend.pinTopActivityStack(v, splitPinRule0);
    }

    @RequiresWindowSdkExtension(version = 2)
    public final void setSplitAttributesCalculator(@NotNull k k0) {
        q.g(k0, "calculator");
        this.embeddingBackend.setSplitAttributesCalculator(k0);
    }

    @NotNull
    public final Flow splitInfoList(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        return FlowKt.callbackFlow(new n(activity0, null) {
            final Activity $activity;
            private Object L$0;
            int label;

            {
                SplitController.this = splitController0;
                this.$activity = activity0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new androidx.window.embedding.SplitController.splitInfoList.1(SplitController.this, this.$activity, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((ProducerScope)object0), ((Continuation)object1));
            }

            public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
                return ((androidx.window.embedding.SplitController.splitInfoList.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        ProducerScope producerScope0 = (ProducerScope)this.L$0;
                        androidx.window.embedding.a a1 = new androidx.window.embedding.a(producerScope0, 2);
                        l.a a2 = new l.a(1);
                        SplitController.this.embeddingBackend.addSplitListenerForActivity(this.$activity, a2, a1);
                        androidx.window.embedding.SplitController.splitInfoList.1.2 splitController$splitInfoList$1$20 = new we.a(a1) {
                            final b2.a $listener;

                            {
                                SplitController.this = splitController0;
                                this.$listener = a0;
                                super(0);
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                SplitController.this.embeddingBackend.removeSplitListenerForActivity(this.$listener);
                            }
                        };
                        this.label = 1;
                        return ProduceKt.awaitClose(producerScope0, splitController$splitInfoList$1$20, this) == a0 ? a0 : H.a;
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

            private static final void invokeSuspend$lambda$0(ProducerScope producerScope0, List list0) {
                producerScope0.trySend-JP2dKIU(list0);
            }
        });
    }

    @RequiresWindowSdkExtension(version = 5)
    public final void unpinTopActivityStack(int v) {
        this.embeddingBackend.unpinTopActivityStack(v);
    }

    @RequiresWindowSdkExtension(version = 3)
    public final void updateSplitAttributes(@NotNull SplitInfo splitInfo0, @NotNull SplitAttributes splitAttributes0) {
        q.g(splitInfo0, "splitInfo");
        q.g(splitAttributes0, "splitAttributes");
        this.embeddingBackend.updateSplitAttributes(splitInfo0, splitAttributes0);
    }
}

