package com.google.android.material.textfield;

import E6.a;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.internal.B;
import e1.n;
import java.util.List;
import java.util.Locale;
import z6.i;

public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    public final ListPopupWindow e;
    public final AccessibilityManager f;
    public final Rect g;
    public final int h;
    public final float i;
    public ColorStateList j;
    public int k;
    public ColorStateList l;

    public MaterialAutoCompleteTextView(Context context0) {
        this(context0, null);
    }

    public MaterialAutoCompleteTextView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040055);  // attr:autoCompleteTextViewStyle
    }

    public MaterialAutoCompleteTextView(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0), attributeSet0, v);
        this.g = new Rect();
        Context context1 = this.getContext();
        TypedArray typedArray0 = B.m(context1, attributeSet0, d6.a.z, v, 0x7F14037C, new int[0]);  // style:Widget.AppCompat.AutoCompleteTextView
        if(typedArray0.hasValue(0) && typedArray0.getInt(0, 0) == 0) {
            this.setKeyListener(null);
        }
        this.h = typedArray0.getResourceId(3, 0x7F0D0535);  // layout:mtrl_auto_complete_simple_item
        this.i = (float)typedArray0.getDimensionPixelOffset(1, 0x7F070384);  // dimen:mtrl_exposed_dropdown_menu_popup_elevation
        if(typedArray0.hasValue(2)) {
            this.j = ColorStateList.valueOf(typedArray0.getColor(2, 0));
        }
        this.k = typedArray0.getColor(4, 0);
        this.l = n.r(context1, typedArray0, 5);
        this.f = (AccessibilityManager)context1.getSystemService("accessibility");
        ListPopupWindow listPopupWindow0 = new ListPopupWindow(context1);
        this.e = listPopupWindow0;
        listPopupWindow0.S = true;
        listPopupWindow0.T.setFocusable(true);
        listPopupWindow0.o = this;
        listPopupWindow0.T.setInputMethodMode(2);
        listPopupWindow0.l(this.getAdapter());
        listPopupWindow0.r = new p(this);
        if(typedArray0.hasValue(6)) {
            this.setSimpleItems(typedArray0.getResourceId(6, 0));
        }
        typedArray0.recycle();
    }

    public static void a(MaterialAutoCompleteTextView materialAutoCompleteTextView0, Object object0) {
        materialAutoCompleteTextView0.setText(materialAutoCompleteTextView0.convertSelectionToString(object0), false);
    }

    public final TextInputLayout b() {
        for(ViewParent viewParent0 = this.getParent(); viewParent0 != null; viewParent0 = viewParent0.getParent()) {
            if(viewParent0 instanceof TextInputLayout) {
                return (TextInputLayout)viewParent0;
            }
        }
        return null;
    }

    public final boolean c() {
        AccessibilityManager accessibilityManager0 = this.f;
        if(accessibilityManager0 == null || !accessibilityManager0.isTouchExplorationEnabled()) {
            if(accessibilityManager0 != null && accessibilityManager0.isEnabled()) {
                List list0 = accessibilityManager0.getEnabledAccessibilityServiceList(16);
                if(list0 != null) {
                    for(Object object0: list0) {
                        if(((AccessibilityServiceInfo)object0).getSettingsActivityName() == null || !((AccessibilityServiceInfo)object0).getSettingsActivityName().contains("SwitchAccess")) {
                            continue;
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override  // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        if(this.c()) {
            this.e.dismiss();
            return;
        }
        super.dismissDropDown();
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.j;
    }

    @Override  // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayout0 = this.b();
        return textInputLayout0 == null || !textInputLayout0.d0 ? super.getHint() : textInputLayout0.getHint();
    }

    public float getPopupElevation() {
        return this.i;
    }

    public int getSimpleItemSelectedColor() {
        return this.k;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.l;
    }

    @Override  // android.widget.AutoCompleteTextView
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout0 = this.b();
        if(textInputLayout0 != null && textInputLayout0.d0 && super.getHint() == null && (Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.toLowerCase(Locale.ENGLISH)).equals("meizu")) {
            this.setHint("");
        }
    }

    @Override  // android.widget.AutoCompleteTextView
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.dismiss();
    }

    @Override  // android.widget.TextView
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        if(View.MeasureSpec.getMode(v) == 0x80000000) {
            int v2 = this.getMeasuredWidth();
            ListAdapter listAdapter0 = this.getAdapter();
            TextInputLayout textInputLayout0 = this.b();
            int v3 = 0;
            if(listAdapter0 != null && textInputLayout0 != null) {
                int v4 = View.MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0);
                int v5 = View.MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0);
                ListPopupWindow listPopupWindow0 = this.e;
                int v6 = listPopupWindow0.T.isShowing() ? listPopupWindow0.c.getSelectedItemPosition() : -1;
                int v7 = Math.min(listAdapter0.getCount(), Math.max(0, v6) + 15);
                int v8 = Math.max(0, v7 - 15);
                View view0 = null;
                int v9 = 0;
                while(v8 < v7) {
                    int v10 = listAdapter0.getItemViewType(v8);
                    if(v10 != v3) {
                        view0 = null;
                        v3 = v10;
                    }
                    view0 = listAdapter0.getView(v8, view0, textInputLayout0);
                    if(view0.getLayoutParams() == null) {
                        view0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view0.measure(v4, v5);
                    v9 = Math.max(v9, view0.getMeasuredWidth());
                    ++v8;
                }
                Drawable drawable0 = listPopupWindow0.T.getBackground();
                if(drawable0 != null) {
                    drawable0.getPadding(this.g);
                    v9 += this.g.left + this.g.right;
                }
                v3 = textInputLayout0.getEndIconView().getMeasuredWidth() + v9;
            }
            this.setMeasuredDimension(Math.min(Math.max(v2, v3), View.MeasureSpec.getSize(v)), this.getMeasuredHeight());
        }
    }

    @Override  // android.widget.AutoCompleteTextView
    public final void onWindowFocusChanged(boolean z) {
        if(this.c()) {
            return;
        }
        super.onWindowFocusChanged(z);
    }

    @Override  // android.widget.AutoCompleteTextView
    public void setAdapter(ListAdapter listAdapter0) {
        super.setAdapter(listAdapter0);
        ListAdapter listAdapter1 = this.getAdapter();
        this.e.l(listAdapter1);
    }

    @Override  // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable0) {
        super.setDropDownBackgroundDrawable(drawable0);
        ListPopupWindow listPopupWindow0 = this.e;
        if(listPopupWindow0 != null) {
            listPopupWindow0.o(drawable0);
        }
    }

    public void setDropDownBackgroundTint(int v) {
        this.setDropDownBackgroundTintList(ColorStateList.valueOf(v));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList0) {
        this.j = colorStateList0;
        Drawable drawable0 = this.getDropDownBackground();
        if(drawable0 instanceof i) {
            ((i)drawable0).m(this.j);
        }
    }

    @Override  // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener adapterView$OnItemSelectedListener0) {
        super.setOnItemSelectedListener(adapterView$OnItemSelectedListener0);
        this.e.w = this.getOnItemSelectedListener();
    }

    @Override  // android.widget.TextView
    public void setRawInputType(int v) {
        super.setRawInputType(v);
        TextInputLayout textInputLayout0 = this.b();
        if(textInputLayout0 != null) {
            textInputLayout0.s();
        }
    }

    public void setSimpleItemSelectedColor(int v) {
        this.k = v;
        if(this.getAdapter() instanceof q) {
            ((q)this.getAdapter()).a();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList0) {
        this.l = colorStateList0;
        if(this.getAdapter() instanceof q) {
            ((q)this.getAdapter()).a();
        }
    }

    public void setSimpleItems(int v) {
        this.setSimpleItems(this.getResources().getStringArray(v));
    }

    public void setSimpleItems(String[] arr_s) {
        this.setAdapter(new q(this, this.getContext(), this.h, arr_s));
    }

    @Override  // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        if(this.c()) {
            this.e.show();
            return;
        }
        super.showDropDown();
    }
}

