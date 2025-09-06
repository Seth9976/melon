package c2;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import d2.c;
import d2.d;
import d2.f;
import java.util.List;

public final class a extends View.AccessibilityDelegate {
    public final b a;

    public a(b b0) {
        this.a = b0;
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final boolean dispatchPopulateAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
        return this.a.dispatchPopulateAccessibilityEvent(view0, accessibilityEvent0);
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view0) {
        f f0 = this.a.getAccessibilityNodeProvider(view0);
        return f0 == null ? null : f0.a;
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
        this.a.onInitializeAccessibilityEvent(view0, accessibilityEvent0);
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
        Boolean boolean1;
        Boolean boolean0;
        d d0 = new d(accessibilityNodeInfo0);
        CharSequence charSequence0 = null;
        Class class0 = Boolean.class;
        if(Build.VERSION.SDK_INT >= 28) {
            boolean0 = Boolean.valueOf(Q.c(view0));
        }
        else {
            boolean0 = view0.getTag(0x7F0A0B2D);  // id:tag_screen_reader_focusable
            if(!class0.isInstance(boolean0)) {
                boolean0 = null;
            }
        }
        boolean z = true;
        boolean z1 = boolean0 != null && boolean0.booleanValue();
        int v1 = Build.VERSION.SDK_INT;
        if(v1 >= 28) {
            accessibilityNodeInfo0.setScreenReaderFocusable(z1);
        }
        else {
            d0.i(1, z1);
        }
        if(Build.VERSION.SDK_INT >= 28) {
            boolean1 = Boolean.valueOf(Q.b(view0));
        }
        else {
            boolean1 = view0.getTag(0x7F0A0B20);  // id:tag_accessibility_heading
            if(!class0.isInstance(boolean1)) {
                boolean1 = null;
            }
        }
        if(boolean1 == null || !boolean1.booleanValue()) {
            z = false;
        }
        if(v1 >= 28) {
            accessibilityNodeInfo0.setHeading(z);
        }
        else {
            d0.i(2, z);
        }
        CharSequence charSequence1 = W.e(view0);
        if(v1 >= 28) {
            accessibilityNodeInfo0.setPaneTitle(charSequence1);
        }
        else {
            accessibilityNodeInfo0.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence1);
        }
        if(Build.VERSION.SDK_INT >= 30) {
            charSequence0 = T.b(view0);
        }
        else {
            Object object0 = view0.getTag(0x7F0A0B2F);  // id:tag_state_description
            if(CharSequence.class.isInstance(object0)) {
                charSequence0 = object0;
            }
        }
        if(v1 >= 30) {
            P1.b.m(accessibilityNodeInfo0, charSequence0);
        }
        else {
            accessibilityNodeInfo0.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence0);
        }
        this.a.onInitializeAccessibilityNodeInfo(view0, d0);
        accessibilityNodeInfo0.getText();
        List list0 = b.getActionList(view0);
        for(int v = 0; v < list0.size(); ++v) {
            d0.b(((c)list0.get(v)));
        }
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final void onPopulateAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
        this.a.onPopulateAccessibilityEvent(view0, accessibilityEvent0);
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup0, View view0, AccessibilityEvent accessibilityEvent0) {
        return this.a.onRequestSendAccessibilityEvent(viewGroup0, view0, accessibilityEvent0);
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
        return this.a.performAccessibilityAction(view0, v, bundle0);
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final void sendAccessibilityEvent(View view0, int v) {
        this.a.sendAccessibilityEvent(view0, v);
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final void sendAccessibilityEventUnchecked(View view0, AccessibilityEvent accessibilityEvent0) {
        this.a.sendAccessibilityEventUnchecked(view0, accessibilityEvent0);
    }
}

