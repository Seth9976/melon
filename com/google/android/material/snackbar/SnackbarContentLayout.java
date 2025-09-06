package com.google.android.material.snackbar;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import e1.n;
import e6.a;

public class SnackbarContentLayout extends LinearLayout {
    public TextView a;
    public Button b;
    public int c;

    public SnackbarContentLayout(Context context0) {
        this(context0, null);
    }

    public SnackbarContentLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        n.C(context0, 0x7F040464, a.b);  // attr:motionEasingEmphasizedInterpolator
    }

    public final boolean a(int v, int v1, int v2) {
        boolean z;
        if(v == this.getOrientation()) {
            z = false;
        }
        else {
            this.setOrientation(v);
            z = true;
        }
        if(this.a.getPaddingTop() == v1 && this.a.getPaddingBottom() == v2) {
            return z;
        }
        TextView textView0 = this.a;
        if(textView0.isPaddingRelative()) {
            textView0.setPaddingRelative(textView0.getPaddingStart(), v1, textView0.getPaddingEnd(), v2);
            return true;
        }
        textView0.setPadding(textView0.getPaddingLeft(), v1, textView0.getPaddingRight(), v2);
        return true;
    }

    public Button getActionView() {
        return this.b;
    }

    public TextView getMessageView() {
        return this.a;
    }

    @Override  // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView)this.findViewById(0x7F0A0A9C);  // id:snackbar_text
        this.b = (Button)this.findViewById(0x7F0A0A9B);  // id:snackbar_action
    }

    @Override  // android.widget.LinearLayout
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        if(this.getOrientation() != 1) {
            int v2 = this.getResources().getDimensionPixelSize(0x7F0700DC);  // dimen:design_snackbar_padding_vertical_2lines
            int v3 = this.getResources().getDimensionPixelSize(0x7F0700DB);  // dimen:design_snackbar_padding_vertical
            Layout layout0 = this.a.getLayout();
            boolean z = layout0 != null && layout0.getLineCount() > 1;
            if(!z || this.c <= 0 || this.b.getMeasuredWidth() <= this.c) {
                if(!z) {
                    v2 = v3;
                }
                if(this.a(0, v2, v2)) {
                    super.onMeasure(v, v1);
                }
            }
            else if(this.a(1, v2, v2 - v3)) {
                super.onMeasure(v, v1);
            }
        }
    }

    public void setMaxInlineActionWidth(int v) {
        this.c = v;
    }
}

