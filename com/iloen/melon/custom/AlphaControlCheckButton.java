package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import k8.t1;

public class AlphaControlCheckButton extends AlphaControlButton {
    public boolean i;
    public final int j;
    public final int k;

    public AlphaControlCheckButton(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.i = false;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.a);
        int v = typedArray0.getResourceId(0, -1);
        this.j = v;
        if(v < 0) {
            throw new IllegalArgumentException("\'checked_image\' parameter is missing.");
        }
        int v1 = typedArray0.getResourceId(1, -1);
        this.k = v1;
        if(v1 < 0) {
            throw new IllegalArgumentException("\'unchecked_image\' parameter is missing.");
        }
        if(this.i) {
            this.setBackgroundResource(this.j);
            return;
        }
        this.setBackgroundResource(v1);
    }

    public void setChecked(boolean z) {
        this.i = z;
        if(z) {
            this.setBackgroundResource(this.j);
            return;
        }
        this.setBackgroundResource(this.k);
    }
}

