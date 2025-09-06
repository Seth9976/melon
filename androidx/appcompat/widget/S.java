package androidx.appcompat.widget;

import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

public final class s extends View.AccessibilityDelegate {
    @Override  // android.view.View$AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
        accessibilityNodeInfo0.setCanOpenPopup(true);
    }
}

