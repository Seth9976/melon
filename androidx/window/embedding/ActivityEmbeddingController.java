package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.window.RequiresWindowSdkExtension;
import ie.H;
import java.util.Set;
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
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u000BH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001D\u0010\u0017\u001A\u00020\u00162\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001B\u001A\u00020\u00162\u0006\u0010\u001A\u001A\u00020\u0019H\u0007¢\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0016H\u0007¢\u0006\u0004\b\u001D\u0010\u001EJ\u001D\u0010!\u001A\b\u0012\u0004\u0012\u00020 0\u001F2\u0006\u0010\u0007\u001A\u00020\u0006H\u0007¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010#¨\u0006%"}, d2 = {"Landroidx/window/embedding/ActivityEmbeddingController;", "", "Landroidx/window/embedding/EmbeddingBackend;", "backend", "<init>", "(Landroidx/window/embedding/EmbeddingBackend;)V", "Landroid/app/Activity;", "activity", "", "isActivityEmbedded", "(Landroid/app/Activity;)Z", "Landroidx/window/embedding/ActivityStack;", "getActivityStack", "(Landroid/app/Activity;)Landroidx/window/embedding/ActivityStack;", "Landroid/os/Bundle;", "options", "activityStack", "setLaunchingActivityStack$window_release", "(Landroid/os/Bundle;Landroidx/window/embedding/ActivityStack;)Landroid/os/Bundle;", "setLaunchingActivityStack", "", "activityStacks", "Lie/H;", "finishActivityStacks", "(Ljava/util/Set;)V", "Landroidx/window/embedding/EmbeddingConfiguration;", "embeddingConfiguration", "setEmbeddingConfiguration", "(Landroidx/window/embedding/EmbeddingConfiguration;)V", "invalidateVisibleActivityStacks", "()V", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "embeddedActivityWindowInfo", "(Landroid/app/Activity;)Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/embedding/EmbeddingBackend;", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ActivityEmbeddingController {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/window/embedding/ActivityEmbeddingController$Companion;", "", "()V", "getInstance", "Landroidx/window/embedding/ActivityEmbeddingController;", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ActivityEmbeddingController getInstance(@NotNull Context context0) {
            q.g(context0, "context");
            return new ActivityEmbeddingController(EmbeddingBackend.Companion.getInstance(context0));
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final EmbeddingBackend backend;

    static {
        ActivityEmbeddingController.Companion = new Companion(null);
    }

    public ActivityEmbeddingController(@NotNull EmbeddingBackend embeddingBackend0) {
        q.g(embeddingBackend0, "backend");
        super();
        this.backend = embeddingBackend0;
    }

    @RequiresWindowSdkExtension(version = 6)
    @NotNull
    public final Flow embeddedActivityWindowInfo(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        return FlowKt.callbackFlow(new n(activity0, null) {
            final Activity $activity;
            private Object L$0;
            int label;

            {
                ActivityEmbeddingController.this = activityEmbeddingController0;
                this.$activity = activity0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new androidx.window.embedding.ActivityEmbeddingController.embeddedActivityWindowInfo.1(ActivityEmbeddingController.this, this.$activity, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((ProducerScope)object0), ((Continuation)object1));
            }

            public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
                return ((androidx.window.embedding.ActivityEmbeddingController.embeddedActivityWindowInfo.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        ProducerScope producerScope0 = (ProducerScope)this.L$0;
                        androidx.window.embedding.a a1 = new androidx.window.embedding.a(producerScope0, 0);
                        ActivityEmbeddingController.this.backend.addEmbeddedActivityWindowInfoCallbackForActivity(this.$activity, a1);
                        androidx.window.embedding.ActivityEmbeddingController.embeddedActivityWindowInfo.1.1 activityEmbeddingController$embeddedActivityWindowInfo$1$10 = new we.a(a1) {
                            final b2.a $callback;

                            {
                                ActivityEmbeddingController.this = activityEmbeddingController0;
                                this.$callback = a0;
                                super(0);
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                ActivityEmbeddingController.this.backend.removeEmbeddedActivityWindowInfoCallbackForActivity(this.$callback);
                            }
                        };
                        this.label = 1;
                        return ProduceKt.awaitClose(producerScope0, activityEmbeddingController$embeddedActivityWindowInfo$1$10, this) == a0 ? a0 : H.a;
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

            private static final void invokeSuspend$lambda$0(ProducerScope producerScope0, EmbeddedActivityWindowInfo embeddedActivityWindowInfo0) {
                producerScope0.trySend-JP2dKIU(embeddedActivityWindowInfo0);
            }
        });
    }

    @RequiresWindowSdkExtension(version = 5)
    public final void finishActivityStacks(@NotNull Set set0) {
        q.g(set0, "activityStacks");
        this.backend.finishActivityStacks(set0);
    }

    @Nullable
    public final ActivityStack getActivityStack(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        return this.backend.getActivityStack(activity0);
    }

    @NotNull
    public static final ActivityEmbeddingController getInstance(@NotNull Context context0) {
        return ActivityEmbeddingController.Companion.getInstance(context0);
    }

    @RequiresWindowSdkExtension(version = 3)
    public final void invalidateVisibleActivityStacks() {
        this.backend.invalidateVisibleActivityStacks();
    }

    public final boolean isActivityEmbedded(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        return this.backend.isActivityEmbedded(activity0);
    }

    @RequiresWindowSdkExtension(version = 5)
    public final void setEmbeddingConfiguration(@NotNull EmbeddingConfiguration embeddingConfiguration0) {
        q.g(embeddingConfiguration0, "embeddingConfiguration");
        this.backend.setEmbeddingConfiguration(embeddingConfiguration0);
    }

    @RequiresWindowSdkExtension(version = 5)
    @NotNull
    public final Bundle setLaunchingActivityStack$window_release(@NotNull Bundle bundle0, @NotNull ActivityStack activityStack0) {
        q.g(bundle0, "options");
        q.g(activityStack0, "activityStack");
        return this.backend.setLaunchingActivityStack(bundle0, activityStack0);
    }
}

