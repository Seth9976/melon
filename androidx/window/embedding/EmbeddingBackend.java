package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.window.RequiresWindowSdkExtension;
import b2.a;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000\u00A8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 [2\u00020\u0001:\u0001[J\u001D\u0010\u0006\u001A\u00020\u00052\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000B\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0003H&\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0003H&\u00A2\u0006\u0004\b\r\u0010\fJ3\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u00102\u0012\u0010\u0015\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012H&\u00A2\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001A\u00020\u00052\u0012\u0010\u0018\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012H&\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u000F\u001A\u00020\u000EH&\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010\"\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010!\u001A\u00020 H\'\u00A2\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001A\u00020\u00052\u0006\u0010\u001F\u001A\u00020\u001EH\'\u00A2\u0006\u0004\b$\u0010%J#\u0010*\u001A\u00020\u00052\u0012\u0010)\u001A\u000E\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020(0&H\'\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010,\u001A\u00020\u0005H\'\u00A2\u0006\u0004\b,\u0010-J\u0019\u0010/\u001A\u0004\u0018\u00010.2\u0006\u0010\u000F\u001A\u00020\u000EH&\u00A2\u0006\u0004\b/\u00100J\u001F\u00104\u001A\u0002012\u0006\u00102\u001A\u0002012\u0006\u00103\u001A\u00020.H\'\u00A2\u0006\u0004\b4\u00105J\u001F\u00108\u001A\u0002012\u0006\u00102\u001A\u0002012\u0006\u00107\u001A\u000206H\'\u00A2\u0006\u0004\b8\u00109J\u001D\u0010;\u001A\u00020\u00052\f\u0010:\u001A\b\u0012\u0004\u0012\u00020.0\u0002H\'\u00A2\u0006\u0004\b;\u0010\u0007J\u0017\u0010>\u001A\u00020\u00052\u0006\u0010=\u001A\u00020<H\'\u00A2\u0006\u0004\b>\u0010?J\u000F\u0010@\u001A\u00020\u0005H\'\u00A2\u0006\u0004\b@\u0010-J\u001F\u0010C\u001A\u00020\u00052\u0006\u0010A\u001A\u00020\u00142\u0006\u0010B\u001A\u00020(H\'\u00A2\u0006\u0004\bC\u0010DJ#\u0010G\u001A\u00020\u00052\u0012\u0010)\u001A\u000E\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F0&H\'\u00A2\u0006\u0004\bG\u0010+J\u000F\u0010H\u001A\u00020\u0005H\'\u00A2\u0006\u0004\bH\u0010-J\u001F\u0010L\u001A\u00020\u00052\u0006\u0010J\u001A\u00020I2\u0006\u0010K\u001A\u00020FH\'\u00A2\u0006\u0004\bL\u0010MJ-\u0010P\u001A\u00020\u00052\u0006\u0010J\u001A\u00020I2\u0006\u0010\u0011\u001A\u00020\u00102\f\u0010O\u001A\b\u0012\u0004\u0012\u00020N0\u0012H\'\u00A2\u0006\u0004\bP\u0010QJ\u001D\u0010R\u001A\u00020\u00052\f\u0010O\u001A\b\u0012\u0004\u0012\u00020N0\u0012H\'\u00A2\u0006\u0004\bR\u0010\u001AJ%\u0010T\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u000E2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020S0\u0012H\'\u00A2\u0006\u0004\bT\u0010UJ\u001D\u0010V\u001A\u00020\u00052\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020S0\u0012H\'\u00A2\u0006\u0004\bV\u0010\u001AR\u0014\u0010Z\u001A\u00020W8&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\bX\u0010Y\u00F8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00A8\u0006\\\u00C0\u0006\u0001"}, d2 = {"Landroidx/window/embedding/EmbeddingBackend;", "", "", "Landroidx/window/embedding/EmbeddingRule;", "rules", "Lie/H;", "setRules", "(Ljava/util/Set;)V", "getRules", "()Ljava/util/Set;", "rule", "addRule", "(Landroidx/window/embedding/EmbeddingRule;)V", "removeRule", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "executor", "Lb2/a;", "", "Landroidx/window/embedding/SplitInfo;", "callback", "addSplitListenerForActivity", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Lb2/a;)V", "consumer", "removeSplitListenerForActivity", "(Lb2/a;)V", "", "isActivityEmbedded", "(Landroid/app/Activity;)Z", "", "taskId", "Landroidx/window/embedding/SplitPinRule;", "splitPinRule", "pinTopActivityStack", "(ILandroidx/window/embedding/SplitPinRule;)Z", "unpinTopActivityStack", "(I)V", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "Landroidx/window/embedding/SplitAttributes;", "calculator", "setSplitAttributesCalculator", "(Lwe/k;)V", "clearSplitAttributesCalculator", "()V", "Landroidx/window/embedding/ActivityStack;", "getActivityStack", "(Landroid/app/Activity;)Landroidx/window/embedding/ActivityStack;", "Landroid/os/Bundle;", "options", "activityStack", "setLaunchingActivityStack", "(Landroid/os/Bundle;Landroidx/window/embedding/ActivityStack;)Landroid/os/Bundle;", "Landroidx/window/embedding/OverlayCreateParams;", "overlayCreateParams", "setOverlayCreateParams", "(Landroid/os/Bundle;Landroidx/window/embedding/OverlayCreateParams;)Landroid/os/Bundle;", "activityStacks", "finishActivityStacks", "Landroidx/window/embedding/EmbeddingConfiguration;", "embeddingConfig", "setEmbeddingConfiguration", "(Landroidx/window/embedding/EmbeddingConfiguration;)V", "invalidateVisibleActivityStacks", "splitInfo", "splitAttributes", "updateSplitAttributes", "(Landroidx/window/embedding/SplitInfo;Landroidx/window/embedding/SplitAttributes;)V", "Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "Landroidx/window/embedding/OverlayAttributes;", "setOverlayAttributesCalculator", "clearOverlayAttributesCalculator", "", "overlayTag", "overlayAttributes", "updateOverlayAttributes", "(Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;)V", "Landroidx/window/embedding/OverlayInfo;", "overlayInfoCallback", "addOverlayInfoCallback", "(Ljava/lang/String;Ljava/util/concurrent/Executor;Lb2/a;)V", "removeOverlayInfoCallback", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "addEmbeddedActivityWindowInfoCallbackForActivity", "(Landroid/app/Activity;Lb2/a;)V", "removeEmbeddedActivityWindowInfoCallbackForActivity", "Landroidx/window/embedding/SplitController$SplitSupportStatus;", "getSplitSupportStatus", "()Landroidx/window/embedding/SplitController$SplitSupportStatus;", "splitSupportStatus", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface EmbeddingBackend {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\u000E\u0010\u0003R\"\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/window/embedding/EmbeddingBackend$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroidx/window/embedding/EmbeddingBackend;", "getInstance", "(Landroid/content/Context;)Landroidx/window/embedding/EmbeddingBackend;", "Landroidx/window/embedding/EmbeddingBackendDecorator;", "overridingDecorator", "Lie/H;", "overrideDecorator", "(Landroidx/window/embedding/EmbeddingBackendDecorator;)V", "reset", "Lkotlin/Function1;", "decorator", "Lwe/k;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;
        @NotNull
        private static k decorator;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.decorator = EmbeddingBackend.Companion.decorator.1.INSTANCE;
        }

        @NotNull
        public final EmbeddingBackend getInstance(@NotNull Context context0) {
            q.g(context0, "context");
            return (EmbeddingBackend)Companion.decorator.invoke(ExtensionEmbeddingBackend.Companion.getInstance(context0));
        }

        public final void overrideDecorator(@NotNull EmbeddingBackendDecorator embeddingBackendDecorator0) {
            q.g(embeddingBackendDecorator0, "overridingDecorator");
            Companion.decorator = new k() {
                {
                    super(1, 0, EmbeddingBackendDecorator.class, object0, "decorate", "decorate(Landroidx/window/embedding/EmbeddingBackend;)Landroidx/window/embedding/EmbeddingBackend;");
                }

                public final EmbeddingBackend invoke(EmbeddingBackend embeddingBackend0) {
                    q.g(embeddingBackend0, "p0");
                    return ((EmbeddingBackendDecorator)this.receiver).decorate(embeddingBackend0);
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    return this.invoke(((EmbeddingBackend)object0));
                }
            };
        }

        public final void reset() {
            Companion.decorator = androidx.window.embedding.EmbeddingBackend.Companion.reset.1.INSTANCE;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/window/embedding/EmbeddingBackend;", "it", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
            final class androidx.window.embedding.EmbeddingBackend.Companion.reset.1 extends r implements k {
                public static final androidx.window.embedding.EmbeddingBackend.Companion.reset.1 INSTANCE;

                static {
                    androidx.window.embedding.EmbeddingBackend.Companion.reset.1.INSTANCE = new androidx.window.embedding.EmbeddingBackend.Companion.reset.1();
                }

                public androidx.window.embedding.EmbeddingBackend.Companion.reset.1() {
                    super(1);
                }

                public final EmbeddingBackend invoke(EmbeddingBackend embeddingBackend0) {
                    q.g(embeddingBackend0, "it");
                    return embeddingBackend0;
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    return this.invoke(((EmbeddingBackend)object0));
                }
            }

        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        EmbeddingBackend.Companion = Companion.$$INSTANCE;
    }

    @RequiresWindowSdkExtension(version = 6)
    void addEmbeddedActivityWindowInfoCallbackForActivity(@NotNull Activity arg1, @NotNull a arg2);

    @RequiresWindowSdkExtension(version = 8)
    void addOverlayInfoCallback(@NotNull String arg1, @NotNull Executor arg2, @NotNull a arg3);

    void addRule(@NotNull EmbeddingRule arg1);

    void addSplitListenerForActivity(@NotNull Activity arg1, @NotNull Executor arg2, @NotNull a arg3);

    @RequiresWindowSdkExtension(version = 8)
    void clearOverlayAttributesCalculator();

    @RequiresWindowSdkExtension(version = 2)
    void clearSplitAttributesCalculator();

    @RequiresWindowSdkExtension(version = 5)
    void finishActivityStacks(@NotNull Set arg1);

    @Nullable
    ActivityStack getActivityStack(@NotNull Activity arg1);

    @NotNull
    static EmbeddingBackend getInstance(@NotNull Context context0) {
        return EmbeddingBackend.Companion.getInstance(context0);
    }

    @NotNull
    Set getRules();

    @NotNull
    SplitSupportStatus getSplitSupportStatus();

    @RequiresWindowSdkExtension(version = 3)
    void invalidateVisibleActivityStacks();

    boolean isActivityEmbedded(@NotNull Activity arg1);

    static void overrideDecorator(@NotNull EmbeddingBackendDecorator embeddingBackendDecorator0) {
        EmbeddingBackend.Companion.overrideDecorator(embeddingBackendDecorator0);
    }

    @RequiresWindowSdkExtension(version = 5)
    boolean pinTopActivityStack(int arg1, @NotNull SplitPinRule arg2);

    @RequiresWindowSdkExtension(version = 6)
    void removeEmbeddedActivityWindowInfoCallbackForActivity(@NotNull a arg1);

    @RequiresWindowSdkExtension(version = 8)
    void removeOverlayInfoCallback(@NotNull a arg1);

    void removeRule(@NotNull EmbeddingRule arg1);

    void removeSplitListenerForActivity(@NotNull a arg1);

    static void reset() {
        EmbeddingBackend.Companion.reset();
    }

    @RequiresWindowSdkExtension(version = 5)
    void setEmbeddingConfiguration(@NotNull EmbeddingConfiguration arg1);

    @RequiresWindowSdkExtension(version = 5)
    @NotNull
    Bundle setLaunchingActivityStack(@NotNull Bundle arg1, @NotNull ActivityStack arg2);

    @RequiresWindowSdkExtension(version = 8)
    void setOverlayAttributesCalculator(@NotNull k arg1);

    @RequiresWindowSdkExtension(version = 5)
    @NotNull
    Bundle setOverlayCreateParams(@NotNull Bundle arg1, @NotNull OverlayCreateParams arg2);

    void setRules(@NotNull Set arg1);

    @RequiresWindowSdkExtension(version = 2)
    void setSplitAttributesCalculator(@NotNull k arg1);

    @RequiresWindowSdkExtension(version = 5)
    void unpinTopActivityStack(int arg1);

    @RequiresWindowSdkExtension(version = 8)
    void updateOverlayAttributes(@NotNull String arg1, @NotNull OverlayAttributes arg2);

    @RequiresWindowSdkExtension(version = 3)
    void updateSplitAttributes(@NotNull SplitInfo arg1, @NotNull SplitAttributes arg2);
}

