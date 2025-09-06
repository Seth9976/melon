package Q0;

import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import java.util.List;
import je.w;

public final class v implements AccessibilityManager.AccessibilityStateChangeListener {
    public final C a;

    public v(C c0) {
        this.a = c0;
    }

    @Override  // android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
        C c0 = this.a;
        List list0 = z ? c0.d.getEnabledAccessibilityServiceList(-1) : w.a;
        c0.h = list0;
    }
}

