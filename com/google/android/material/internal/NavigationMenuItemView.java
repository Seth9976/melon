package com.google.android.material.internal;

import A6.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams;
import androidx.appcompat.widget.l1;
import c2.W;
import k.m;
import k.x;

public class NavigationMenuItemView extends ForegroundLinearLayout implements x {
    public int I;
    public boolean M;
    public boolean N;
    public boolean S;
    public final CheckedTextView T;
    public FrameLayout V;
    public m W;
    public ColorStateList b0;
    public boolean c0;
    public Drawable d0;
    public final c e0;
    public static final int[] f0;

    static {
        NavigationMenuItemView.f0 = new int[]{0x10100A0};
    }

    public NavigationMenuItemView(Context context0) {
        this(context0, null);
    }

    public NavigationMenuItemView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public NavigationMenuItemView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.S = true;
        c c0 = new c(this, 4);
        this.e0 = c0;
        this.setOrientation(0);
        LayoutInflater.from(context0).inflate(0x7F0D01F4, this, true);  // layout:design_navigation_menu_item
        this.setIconSize(context0.getResources().getDimensionPixelSize(0x7F0700CC));  // dimen:design_navigation_icon_size
        CheckedTextView checkedTextView0 = (CheckedTextView)this.findViewById(0x7F0A03B7);  // id:design_menu_item_text
        this.T = checkedTextView0;
        checkedTextView0.setDuplicateParentStateEnabled(true);
        W.o(checkedTextView0, c0);
    }

    @Override  // k.x
    public final void c(m m0) {
        StateListDrawable stateListDrawable0;
        this.W = m0;
        int v = m0.a;
        if(v > 0) {
            this.setId(v);
        }
        this.setVisibility((m0.isVisible() ? 0 : 8));
        if(this.getBackground() == null) {
            TypedValue typedValue0 = new TypedValue();
            if(this.getContext().getTheme().resolveAttribute(0x7F040167, typedValue0, true)) {  // attr:colorControlHighlight
                stateListDrawable0 = new StateListDrawable();
                ColorDrawable colorDrawable0 = new ColorDrawable(typedValue0.data);
                stateListDrawable0.addState(NavigationMenuItemView.f0, colorDrawable0);
                ColorDrawable colorDrawable1 = new ColorDrawable(0);
                stateListDrawable0.addState(ViewGroup.EMPTY_STATE_SET, colorDrawable1);
            }
            else {
                stateListDrawable0 = null;
            }
            this.setBackground(stateListDrawable0);
        }
        this.setCheckable(m0.isCheckable());
        this.setChecked(m0.isChecked());
        this.setEnabled(m0.isEnabled());
        this.setTitle(m0.e);
        this.setIcon(m0.getIcon());
        this.setActionView(m0.getActionView());
        this.setContentDescription(m0.q);
        l1.a(this, m0.r);
        CheckedTextView checkedTextView0 = this.T;
        if(this.W.e != null || this.W.getIcon() != null || this.W.getActionView() == null) {
            checkedTextView0.setVisibility(0);
            FrameLayout frameLayout1 = this.V;
            if(frameLayout1 != null) {
                LayoutParams linearLayoutCompat$LayoutParams1 = (LayoutParams)frameLayout1.getLayoutParams();
                linearLayoutCompat$LayoutParams1.width = -2;
                this.V.setLayoutParams(linearLayoutCompat$LayoutParams1);
            }
        }
        else {
            checkedTextView0.setVisibility(8);
            FrameLayout frameLayout0 = this.V;
            if(frameLayout0 != null) {
                LayoutParams linearLayoutCompat$LayoutParams0 = (LayoutParams)frameLayout0.getLayoutParams();
                linearLayoutCompat$LayoutParams0.width = -1;
                this.V.setLayoutParams(linearLayoutCompat$LayoutParams0);
            }
        }
    }

    @Override  // k.x
    public m getItemData() {
        return this.W;
    }

    @Override  // android.view.ViewGroup
    public final int[] onCreateDrawableState(int v) {
        int[] arr_v = super.onCreateDrawableState(v + 1);
        if(this.W != null && this.W.isCheckable() && this.W.isChecked()) {
            View.mergeDrawableStates(arr_v, NavigationMenuItemView.f0);
        }
        return arr_v;
    }

    private void setActionView(View view0) {
        if(view0 != null) {
            if(this.V == null) {
                this.V = (FrameLayout)((ViewStub)this.findViewById(0x7F0A03B6)).inflate();  // id:design_menu_item_action_area_stub
            }
            if(view0.getParent() != null) {
                ((ViewGroup)view0.getParent()).removeView(view0);
            }
            this.V.removeAllViews();
            this.V.addView(view0);
        }
    }

    public void setCheckable(boolean z) {
        this.refreshDrawableState();
        if(this.N != z) {
            this.N = z;
            this.e0.sendAccessibilityEvent(this.T, 0x800);
        }
    }

    public void setChecked(boolean z) {
        this.refreshDrawableState();
        this.T.setChecked(z);
        Typeface typeface0 = this.T.getTypeface();
        this.T.setTypeface(typeface0, (!z || !this.S ? 0 : 1));
    }

    public void setHorizontalPadding(int v) {
        this.setPadding(v, this.getPaddingTop(), v, this.getPaddingBottom());
    }

    public void setIcon(Drawable drawable0) {
        if(drawable0 != null) {
            if(this.c0) {
                Drawable.ConstantState drawable$ConstantState0 = drawable0.getConstantState();
                if(drawable$ConstantState0 != null) {
                    drawable0 = drawable$ConstantState0.newDrawable();
                }
                drawable0 = drawable0.mutate();
                drawable0.setTintList(this.b0);
            }
            drawable0.setBounds(0, 0, this.I, this.I);
        }
        else if(this.M) {
            if(this.d0 == null) {
                Drawable drawable1 = this.getResources().getDrawable(0x7F080782, this.getContext().getTheme());  // drawable:navigation_empty_icon
                this.d0 = drawable1;
                if(drawable1 != null) {
                    drawable1.setBounds(0, 0, this.I, this.I);
                }
            }
            drawable0 = this.d0;
        }
        this.T.setCompoundDrawablesRelative(drawable0, null, null, null);
    }

    public void setIconPadding(int v) {
        this.T.setCompoundDrawablePadding(v);
    }

    public void setIconSize(int v) {
        this.I = v;
    }

    public void setIconTintList(ColorStateList colorStateList0) {
        this.b0 = colorStateList0;
        this.c0 = colorStateList0 != null;
        m m0 = this.W;
        if(m0 != null) {
            this.setIcon(m0.getIcon());
        }
    }

    public void setMaxLines(int v) {
        this.T.setMaxLines(v);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.M = z;
    }

    public void setTextAppearance(int v) {
        this.T.setTextAppearance(v);
    }

    public void setTextColor(ColorStateList colorStateList0) {
        this.T.setTextColor(colorStateList0);
    }

    public void setTitle(CharSequence charSequence0) {
        this.T.setText(charSequence0);
    }
}

