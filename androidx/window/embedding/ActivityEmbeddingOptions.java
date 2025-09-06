package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.window.RequiresWindowSdkExtension;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0007\u001A\u001C\u0010\u0006\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0007¨\u0006\u000B"}, d2 = {"setLaunchingActivityStack", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "activityStack", "Landroidx/window/embedding/ActivityStack;", "setOverlayCreateParams", "activity", "Landroid/app/Activity;", "overlayCreateParams", "Landroidx/window/embedding/OverlayCreateParams;", "window_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class ActivityEmbeddingOptions {
    @RequiresWindowSdkExtension(version = 5)
    @NotNull
    public static final Bundle setLaunchingActivityStack(@NotNull Bundle bundle0, @NotNull Context context0, @NotNull ActivityStack activityStack0) {
        q.g(bundle0, "<this>");
        q.g(context0, "context");
        q.g(activityStack0, "activityStack");
        return ActivityEmbeddingController.Companion.getInstance(context0).setLaunchingActivityStack$window_release(bundle0, activityStack0);
    }

    @RequiresWindowSdkExtension(version = 8)
    @NotNull
    public static final Bundle setOverlayCreateParams(@NotNull Bundle bundle0, @NotNull Activity activity0, @NotNull OverlayCreateParams overlayCreateParams0) {
        q.g(bundle0, "<this>");
        q.g(activity0, "activity");
        q.g(overlayCreateParams0, "overlayCreateParams");
        return OverlayController.Companion.getInstance(activity0).setOverlayCreateParams$window_release(bundle0, overlayCreateParams0);
    }
}

