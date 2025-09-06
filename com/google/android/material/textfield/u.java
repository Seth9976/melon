package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatTextView;
import c2.b;
import d2.d;

public final class u extends b {
    public final TextInputLayout a;

    public u(TextInputLayout textInputLayout0) {
        this.a = textInputLayout0;
    }

    @Override  // c2.b
    public final void onInitializeAccessibilityNodeInfo(View view0, d d0) {
        AccessibilityNodeInfo accessibilityNodeInfo0 = d0.a;
        super.onInitializeAccessibilityNodeInfo(view0, d0);
        TextInputLayout textInputLayout0 = this.a;
        EditText editText0 = textInputLayout0.getEditText();
        Editable editable0 = editText0 == null ? null : editText0.getText();
        CharSequence charSequence0 = textInputLayout0.getHint();
        CharSequence charSequence1 = textInputLayout0.getError();
        CharSequence charSequence2 = textInputLayout0.getPlaceholderText();
        int v = textInputLayout0.getCounterMaxLength();
        CharSequence charSequence3 = textInputLayout0.getCounterOverflowDescription();
        boolean z = TextUtils.isEmpty(editable0);
        boolean z1 = TextUtils.isEmpty(charSequence0);
        boolean z2 = textInputLayout0.Q0;
        boolean z3 = TextUtils.isEmpty(charSequence1);
        boolean z4 = !z3 || !TextUtils.isEmpty(charSequence3);
        String s = z1 ? "" : charSequence0.toString();
        s s1 = textInputLayout0.b;
        AppCompatTextView appCompatTextView0 = s1.b;
        if(appCompatTextView0.getVisibility() == 0) {
            accessibilityNodeInfo0.setLabelFor(appCompatTextView0);
            accessibilityNodeInfo0.setTraversalAfter(appCompatTextView0);
        }
        else {
            accessibilityNodeInfo0.setTraversalAfter(s1.d);
        }
        if(!z) {
            d0.q(editable0);
        }
        else if(!TextUtils.isEmpty(s)) {
            d0.q(s);
            if(!z2 && charSequence2 != null) {
                d0.q(s + ", " + charSequence2);
            }
        }
        else if(charSequence2 != null) {
            d0.q(charSequence2);
        }
        if(!TextUtils.isEmpty(s)) {
            accessibilityNodeInfo0.setHintText(s);
            accessibilityNodeInfo0.setShowingHintText(z);
        }
        if(editable0 == null || editable0.length() != v) {
            v = -1;
        }
        accessibilityNodeInfo0.setMaxTextLength(v);
        if(z4) {
            if(z3) {
                charSequence1 = charSequence3;
            }
            accessibilityNodeInfo0.setError(charSequence1);
        }
        AppCompatTextView appCompatTextView1 = textInputLayout0.j.y;
        if(appCompatTextView1 != null) {
            accessibilityNodeInfo0.setLabelFor(appCompatTextView1);
        }
        textInputLayout0.c.b().n(d0);
    }

    @Override  // c2.b
    public final void onPopulateAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
        super.onPopulateAccessibilityEvent(view0, accessibilityEvent0);
        this.a.c.b().o(accessibilityEvent0);
    }
}

