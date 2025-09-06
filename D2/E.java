package d2;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public final class e extends AccessibilityNodeProvider {
    public final f a;

    public e(f f0) {
        this.a = f0;
    }

    @Override  // android.view.accessibility.AccessibilityNodeProvider
    public final void addExtraDataToAccessibilityNodeInfo(int v, AccessibilityNodeInfo accessibilityNodeInfo0, String s, Bundle bundle0) {
        d d0 = new d(accessibilityNodeInfo0);
        this.a.a(v, d0, s, bundle0);
    }

    @Override  // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int v) {
        d d0 = this.a.b(v);
        return d0 == null ? null : d0.a;
    }

    @Override  // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String s, int v) {
        this.a.getClass();
        return null;
    }

    @Override  // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int v) {
        d d0 = this.a.c(v);
        return d0 == null ? null : d0.a;
    }

    @Override  // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int v, int v1, Bundle bundle0) {
        return this.a.d(v, v1, bundle0);
    }
}

