package com.google.android.material.textfield;

import E6.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.internal.B;
import java.util.Locale;

public class TextInputEditText extends AppCompatEditText {
    public final Rect g;
    public boolean h;

    public TextInputEditText(Context context0) {
        this(context0, null);
    }

    public TextInputEditText(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F04022F);  // attr:editTextStyle
    }

    public TextInputEditText(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0), attributeSet0, v);
        this.g = new Rect();
        B.c(context0, attributeSet0, v, 0x7F1403C6);  // style:Widget.Design.TextInputEditText
        B.d(context0, attributeSet0, d6.a.g0, v, 0x7F1403C6, new int[0]);  // style:Widget.Design.TextInputEditText
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, d6.a.g0, v, 0x7F1403C6);  // style:Widget.Design.TextInputEditText
        this.setTextInputLayoutFocusedRectEnabled(typedArray0.getBoolean(0, false));
        typedArray0.recycle();
    }

    @Override  // android.widget.TextView
    public final void getFocusedRect(Rect rect0) {
        super.getFocusedRect(rect0);
        TextInputLayout textInputLayout0 = this.getTextInputLayout();
        if(textInputLayout0 != null && this.h && rect0 != null) {
            textInputLayout0.getFocusedRect(this.g);
            rect0.bottom = this.g.bottom;
        }
    }

    @Override  // android.view.View
    public final boolean getGlobalVisibleRect(Rect rect0, Point point0) {
        TextInputLayout textInputLayout0 = this.getTextInputLayout();
        if(textInputLayout0 != null && this.h) {
            boolean z = textInputLayout0.getGlobalVisibleRect(rect0, point0);
            if(z && point0 != null) {
                point0.offset(-this.getScrollX(), -this.getScrollY());
            }
            return z;
        }
        return super.getGlobalVisibleRect(rect0, point0);
    }

    @Override  // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayout0 = this.getTextInputLayout();
        return textInputLayout0 == null || !textInputLayout0.d0 ? super.getHint() : textInputLayout0.getHint();
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout0 = this.getTextInputLayout();
        return textInputLayout0 == null ? null : textInputLayout0.getHint();
    }

    private TextInputLayout getTextInputLayout() {
        for(ViewParent viewParent0 = this.getParent(); viewParent0 instanceof View; viewParent0 = viewParent0.getParent()) {
            if(viewParent0 instanceof TextInputLayout) {
                return (TextInputLayout)viewParent0;
            }
        }
        return null;
    }

    @Override  // android.widget.TextView
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout0 = this.getTextInputLayout();
        if(textInputLayout0 != null && textInputLayout0.d0 && super.getHint() == null && (Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.toLowerCase(Locale.ENGLISH)).equals("meizu")) {
            this.setHint("");
        }
    }

    @Override  // androidx.appcompat.widget.AppCompatEditText
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo0) {
        InputConnection inputConnection0 = super.onCreateInputConnection(editorInfo0);
        if(inputConnection0 != null && editorInfo0.hintText == null) {
            editorInfo0.hintText = this.getHintFromLayout();
        }
        return inputConnection0;
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        this.getTextInputLayout();
    }

    @Override  // android.view.View
    public final boolean requestRectangleOnScreen(Rect rect0) {
        TextInputLayout textInputLayout0 = this.getTextInputLayout();
        if(textInputLayout0 != null && this.h && rect0 != null) {
            int v = textInputLayout0.getHeight();
            int v1 = this.getHeight();
            this.g.set(rect0.left, rect0.top, rect0.right, rect0.bottom + (v - v1));
            return super.requestRectangleOnScreen(this.g);
        }
        return super.requestRectangleOnScreen(rect0);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z) {
        this.h = z;
    }
}

