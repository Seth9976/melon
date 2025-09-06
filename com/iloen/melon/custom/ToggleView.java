package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.Collection;
import java.util.List;
import k8.t1;

public class ToggleView extends FilterLayout implements View.OnClickListener {
    public final MelonTextView k;
    public float l;
    public List m;
    public int n;
    public o1 o;

    public ToggleView(Context context0) {
        this(context0, null);
    }

    public ToggleView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ToggleView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.n = -1;
        if(this.isInEditMode()) {
            return;
        }
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.J, v, 0);
        typedArray0.getColorStateList(1);
        this.l = (float)typedArray0.getDimensionPixelSize(0, 0);
        typedArray0.recycle();
        MelonTextView melonTextView0 = (MelonTextView)((LayoutInflater)context0.getSystemService("layout_inflater")).inflate(0x7F0D0905, this, true).findViewById(0x7F0A0C76);  // layout:view_toggle
        this.k = melonTextView0;
        melonTextView0.setOnClickListener(this);
    }

    public final void e(List list0, o1 o10) {
        this.setFilterList(list0);
        this.setOnChangedListener(o10);
        this.requestLayout();
    }

    public Collection getFilterList() {
        return this.m;
    }

    @Override  // com.iloen.melon.custom.FilterLayout
    public float getTextSize() {
        return this.l;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.o != null) {
            List list0 = this.m;
            if(list0 != null) {
                int v = this.n + 1;
                this.n = v;
                int v1 = v < list0.size() ? this.n : 0;
                this.n = v1;
                this.o.c(v1, ((String)this.m.get(v1)));
                this.setFilterPosition(this.n);
            }
        }
    }

    public void setFilterList(List list0) {
        this.m = list0;
        this.n = 0;
        if(!list0.isEmpty()) {
            CharSequence charSequence0 = (CharSequence)list0.get(this.n);
            ViewUtils.setText(this.k, charSequence0);
        }
    }

    public void setFilterPosition(int v) {
        List list0 = this.m;
        if(list0 == null) {
            return;
        }
        this.n = v;
        CharSequence charSequence0 = (CharSequence)list0.get(v);
        ViewUtils.setText(this.k, charSequence0);
    }

    public void setIcon(int v) {
        this.k.setCompoundDrawablesWithIntrinsicBounds(v, 0, 0, 0);
    }

    public void setOnChangedListener(o1 o10) {
        this.o = o10;
    }

    @Override  // com.iloen.melon.custom.FilterLayout
    public void setTextColor(ColorStateList colorStateList0) {
        this.k.setTextColor(colorStateList0);
    }

    @Override  // com.iloen.melon.custom.FilterLayout
    public void setTextSize(float f) {
        this.l = (float)ScreenUtils.dipToPixel(this.getContext(), f);
    }
}

