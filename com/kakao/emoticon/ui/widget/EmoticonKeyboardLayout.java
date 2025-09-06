package com.kakao.emoticon.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class EmoticonKeyboardLayout extends FrameLayout {
    public EmoticonKeyboardLayout(Context context0) {
        super(context0);
        this.init();
    }

    public EmoticonKeyboardLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.init();
    }

    public EmoticonKeyboardLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.init();
    }

    private void init() {
        this.setVisibility(8);
    }
}

