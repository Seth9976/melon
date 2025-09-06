package Q0;

import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;

public final class w implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final C a;

    public w(C c0) {
        this.a = c0;
    }

    @Override  // android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        this.a.h = this.a.d.getEnabledAccessibilityServiceList(-1);
    }
}

