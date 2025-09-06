package com.google.android.material.textfield;

import S1.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public final class q extends ArrayAdapter {
    public ColorStateList a;
    public ColorStateList b;
    public final MaterialAutoCompleteTextView c;

    public q(MaterialAutoCompleteTextView materialAutoCompleteTextView0, Context context0, int v, String[] arr_s) {
        this.c = materialAutoCompleteTextView0;
        super(context0, v, arr_s);
        this.a();
    }

    public final void a() {
        ColorStateList colorStateList2;
        MaterialAutoCompleteTextView materialAutoCompleteTextView0 = this.c;
        ColorStateList colorStateList0 = materialAutoCompleteTextView0.l;
        ColorStateList colorStateList1 = null;
        if(colorStateList0 == null) {
            colorStateList2 = null;
        }
        else {
            int[] arr_v = {0x10100A7};
            int[] arr_v1 = {colorStateList0.getColorForState(arr_v, 0), 0};
            colorStateList2 = new ColorStateList(new int[][]{arr_v, new int[0]}, arr_v1);
        }
        this.b = colorStateList2;
        if(materialAutoCompleteTextView0.k != 0 && materialAutoCompleteTextView0.l != null) {
            int[] arr_v2 = {0x1010367, 0xFEFEFF59};
            int[] arr_v3 = {0x10100A1, 0xFEFEFF59};
            int v = materialAutoCompleteTextView0.l.getColorForState(arr_v3, 0);
            int v1 = materialAutoCompleteTextView0.l.getColorForState(arr_v2, 0);
            int[] arr_v4 = {c.h(v, materialAutoCompleteTextView0.k), c.h(v1, materialAutoCompleteTextView0.k), materialAutoCompleteTextView0.k};
            colorStateList1 = new ColorStateList(new int[][]{arr_v3, arr_v2, new int[0]}, arr_v4);
        }
        this.a = colorStateList1;
    }

    @Override  // android.widget.ArrayAdapter
    public final View getView(int v, View view0, ViewGroup viewGroup0) {
        View view1 = super.getView(v, view0, viewGroup0);
        if(view1 instanceof TextView) {
            MaterialAutoCompleteTextView materialAutoCompleteTextView0 = this.c;
            Drawable drawable0 = null;
            if(materialAutoCompleteTextView0.getText().toString().contentEquals(((TextView)view1).getText()) && materialAutoCompleteTextView0.k != 0) {
                ColorDrawable colorDrawable0 = new ColorDrawable(materialAutoCompleteTextView0.k);
                if(this.b == null) {
                    drawable0 = colorDrawable0;
                }
                else {
                    colorDrawable0.setTintList(this.a);
                    drawable0 = new RippleDrawable(this.b, colorDrawable0, null);
                }
            }
            ((TextView)view1).setBackground(drawable0);
        }
        return view1;
    }
}

