package com.google.android.material.textfield;

import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import kotlin.jvm.internal.q;

public final class n extends View.AccessibilityDelegate {
    public final int a;
    public final Object b;

    public n(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
        if(this.a != 0) {
            q.g(view0, "host");
            q.g(accessibilityNodeInfo0, "info");
            super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
            accessibilityNodeInfo0.setHintText("새로고침 작업을 하려면 두 번 탭 하세요");
            return;
        }
        super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
        EditText editText0 = ((o)this.b).h.getEditText();
        if(editText0 != null) {
            accessibilityNodeInfo0.setLabeledBy(editText0);
        }
    }
}

