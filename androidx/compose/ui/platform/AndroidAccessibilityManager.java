package androidx.compose.ui.platform;

import Q0.f;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "LQ0/f;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class AndroidAccessibilityManager implements f {
    public AndroidAccessibilityManager(@NotNull Context context0) {
        Object object0 = context0.getSystemService("accessibility");
        q.e(object0, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager0 = (AccessibilityManager)object0;
    }
}

