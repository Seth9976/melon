package com.iloen.melon.custom;

import E8.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.iloen.melon.utils.ui.ViewUtils;
import k8.t1;

public class FilterDropDownView extends FilterLayout {
    public final View k;
    public final TextView l;
    public G m;
    public final Drawable n;

    public FilterDropDownView(Context context0) {
        this(context0, null);
    }

    public FilterDropDownView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public FilterDropDownView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        if(this.isInEditMode()) {
            return;
        }
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.k, v, 0);
        this.g = typedArray0.getColorStateList(1);
        this.h = (float)typedArray0.getDimensionPixelSize(0, 0);
        this.n = typedArray0.getDrawable(2);
        typedArray0.recycle();
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0268, null);  // layout:filter_dropdown
        if(view0 != null) {
            this.a.addView(view0);
        }
        this.k = view0.findViewById(0x7F0A03FA);  // id:dropdown_container
        this.l = (TextView)view0.findViewById(0x7F0A03FC);  // id:dropdown_text
        this.d();
        ViewUtils.setOnClickListener(view0, new a(this, 5));
    }

    @Override  // com.iloen.melon.custom.FilterLayout
    public final void d() {
        TextView textView0 = this.l;
        if(textView0 != null) {
            ColorStateList colorStateList0 = this.g;
            if(colorStateList0 != null) {
                textView0.setTextColor(colorStateList0);
            }
            float f = this.h;
            if(f > 0.0f) {
                this.l.setTextSize(0, f);
            }
            Drawable drawable0 = this.n;
            if(drawable0 != null) {
                this.l.setCompoundDrawablesWithIntrinsicBounds(drawable0, null, null, null);
            }
        }
    }

    public void setDropDownIcon(int v) {
        this.l.setCompoundDrawablesWithIntrinsicBounds(v, 0, 0, 0);
    }

    public void setOnDropDownListener(G g0) {
        this.m = g0;
    }

    public void setText(int v) {
        TextView textView0 = this.l;
        if(textView0 != null) {
            textView0.setText(v);
            this.l.requestLayout();
        }
    }

    public void setText(String s) {
        TextView textView0 = this.l;
        if(textView0 != null) {
            ViewUtils.hideWhen(textView0, TextUtils.isEmpty(s));
            this.l.setText(s);
            this.l.requestLayout();
        }
    }
}

