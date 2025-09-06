package androidx.window.embedding;

import android.app.Activity;
import android.os.Bundle;
import androidx.window.RequiresWindowSdkExtension;
import b2.a;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000\u00A2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001:\u0001NJ\u001D\u0010\u0006\u001A\u00020\u00052\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\bH&\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\fH&\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0015\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0013H\'\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u0011H\'\u00A2\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001D\u001A\u00020\u00052\u0012\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u001B0\u0019H\'\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\u0005H\'\u00A2\u0006\u0004\b\u001F\u0010 J\u001F\u0010%\u001A\u00020!2\u0006\u0010\"\u001A\u00020!2\u0006\u0010$\u001A\u00020#H\'\u00A2\u0006\u0004\b%\u0010&J\u001F\u0010)\u001A\u00020!2\u0006\u0010\"\u001A\u00020!2\u0006\u0010(\u001A\u00020\'H\'\u00A2\u0006\u0004\b)\u0010*J\u001D\u0010,\u001A\u00020\u00052\f\u0010+\u001A\b\u0012\u0004\u0012\u00020#0\u0002H\'\u00A2\u0006\u0004\b,\u0010\u0007J\u0017\u0010/\u001A\u00020\u00052\u0006\u0010.\u001A\u00020-H\'\u00A2\u0006\u0004\b/\u00100J\u000F\u00101\u001A\u00020\u0005H\'\u00A2\u0006\u0004\b1\u0010 J\u001F\u00105\u001A\u00020\u00052\u0006\u00103\u001A\u0002022\u0006\u00104\u001A\u00020\u001BH\'\u00A2\u0006\u0004\b5\u00106J#\u00109\u001A\u00020\u00052\u0012\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002080\u0019H\'\u00A2\u0006\u0004\b9\u0010\u001EJ\u000F\u0010:\u001A\u00020\u0005H\'\u00A2\u0006\u0004\b:\u0010 J\u001F\u0010>\u001A\u00020\u00052\u0006\u0010<\u001A\u00020;2\u0006\u0010=\u001A\u000208H\'\u00A2\u0006\u0004\b>\u0010?J-\u0010E\u001A\u00020\u00052\u0006\u0010<\u001A\u00020;2\u0006\u0010A\u001A\u00020@2\f\u0010D\u001A\b\u0012\u0004\u0012\u00020C0BH\'\u00A2\u0006\u0004\bE\u0010FJ\u001D\u0010G\u001A\u00020\u00052\f\u0010D\u001A\b\u0012\u0004\u0012\u00020C0BH\'\u00A2\u0006\u0004\bG\u0010HJ%\u0010K\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f2\f\u0010J\u001A\b\u0012\u0004\u0012\u00020I0BH\'\u00A2\u0006\u0004\bK\u0010LJ\u001D\u0010M\u001A\u00020\u00052\f\u0010J\u001A\b\u0012\u0004\u0012\u00020I0BH\'\u00A2\u0006\u0004\bM\u0010H\u00F8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00A8\u0006O\u00C0\u0006\u0001"}, d2 = {"Landroidx/window/embedding/EmbeddingInterfaceCompat;", "", "", "Landroidx/window/embedding/EmbeddingRule;", "rules", "Lie/H;", "setRules", "(Ljava/util/Set;)V", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "embeddingCallback", "setEmbeddingCallback", "(Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;)V", "Landroid/app/Activity;", "activity", "", "isActivityEmbedded", "(Landroid/app/Activity;)Z", "", "taskId", "Landroidx/window/embedding/SplitPinRule;", "splitPinRule", "pinTopActivityStack", "(ILandroidx/window/embedding/SplitPinRule;)Z", "unpinTopActivityStack", "(I)V", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "Landroidx/window/embedding/SplitAttributes;", "calculator", "setSplitAttributesCalculator", "(Lwe/k;)V", "clearSplitAttributesCalculator", "()V", "Landroid/os/Bundle;", "options", "Landroidx/window/embedding/ActivityStack;", "activityStack", "setLaunchingActivityStack", "(Landroid/os/Bundle;Landroidx/window/embedding/ActivityStack;)Landroid/os/Bundle;", "Landroidx/window/embedding/OverlayCreateParams;", "overlayCreateParams", "setOverlayCreateParams", "(Landroid/os/Bundle;Landroidx/window/embedding/OverlayCreateParams;)Landroid/os/Bundle;", "activityStacks", "finishActivityStacks", "Landroidx/window/embedding/EmbeddingConfiguration;", "embeddingConfig", "setEmbeddingConfiguration", "(Landroidx/window/embedding/EmbeddingConfiguration;)V", "invalidateVisibleActivityStacks", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "splitAttributes", "updateSplitAttributes", "(Landroidx/window/embedding/SplitInfo;Landroidx/window/embedding/SplitAttributes;)V", "Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "Landroidx/window/embedding/OverlayAttributes;", "setOverlayAttributesCalculator", "clearOverlayAttributesCalculator", "", "overlayTag", "overlayAttributes", "updateOverlayAttributes", "(Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;)V", "Ljava/util/concurrent/Executor;", "executor", "Lb2/a;", "Landroidx/window/embedding/OverlayInfo;", "overlayInfoCallback", "addOverlayInfoCallback", "(Ljava/lang/String;Ljava/util/concurrent/Executor;Lb2/a;)V", "removeOverlayInfoCallback", "(Lb2/a;)V", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "callback", "addEmbeddedActivityWindowInfoCallbackForActivity", "(Landroid/app/Activity;Lb2/a;)V", "removeEmbeddedActivityWindowInfoCallbackForActivity", "EmbeddingCallbackInterface", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface EmbeddingInterfaceCompat {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001D\u0010\u0006\u001A\u00020\u00052\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\n\u001A\u00020\u00052\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\n\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2 = {"Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "", "", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "Lie/H;", "onSplitInfoChanged", "(Ljava/util/List;)V", "Landroidx/window/embedding/ActivityStack;", "activityStacks", "onActivityStackChanged", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public interface EmbeddingCallbackInterface {
        void onActivityStackChanged(@NotNull List arg1);

        void onSplitInfoChanged(@NotNull List arg1);
    }

    @RequiresWindowSdkExtension(version = 6)
    void addEmbeddedActivityWindowInfoCallbackForActivity(@NotNull Activity arg1, @NotNull a arg2);

    @RequiresWindowSdkExtension(version = 8)
    void addOverlayInfoCallback(@NotNull String arg1, @NotNull Executor arg2, @NotNull a arg3);

    @RequiresWindowSdkExtension(version = 8)
    void clearOverlayAttributesCalculator();

    @RequiresWindowSdkExtension(version = 2)
    void clearSplitAttributesCalculator();

    @RequiresWindowSdkExtension(version = 5)
    void finishActivityStacks(@NotNull Set arg1);

    @RequiresWindowSdkExtension(version = 3)
    void invalidateVisibleActivityStacks();

    boolean isActivityEmbedded(@NotNull Activity arg1);

    @RequiresWindowSdkExtension(version = 5)
    boolean pinTopActivityStack(int arg1, @NotNull SplitPinRule arg2);

    @RequiresWindowSdkExtension(version = 6)
    void removeEmbeddedActivityWindowInfoCallbackForActivity(@NotNull a arg1);

    @RequiresWindowSdkExtension(version = 8)
    void removeOverlayInfoCallback(@NotNull a arg1);

    void setEmbeddingCallback(@NotNull EmbeddingCallbackInterface arg1);

    @RequiresWindowSdkExtension(version = 5)
    void setEmbeddingConfiguration(@NotNull EmbeddingConfiguration arg1);

    @RequiresWindowSdkExtension(version = 5)
    @NotNull
    Bundle setLaunchingActivityStack(@NotNull Bundle arg1, @NotNull ActivityStack arg2);

    @RequiresWindowSdkExtension(version = 8)
    void setOverlayAttributesCalculator(@NotNull k arg1);

    @RequiresWindowSdkExtension(version = 8)
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

