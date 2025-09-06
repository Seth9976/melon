package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;

public class VerticalSeekBar extends AbsVerticalSeekBar {
    public VerticalSeekBar(Context context0) {
        this(context0, null);
    }

    public VerticalSeekBar(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x101007B);
    }

    public VerticalSeekBar(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    public void setOnSeekBarChangeListener(v1 v10) {
    }
}

