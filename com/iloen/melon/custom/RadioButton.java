package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import androidx.appcompat.app.o;
import k8.t1;

public class RadioButton extends LinearLayout implements S {
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public boolean a;

        static {
            SavedState.CREATOR = new M0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override
        public final String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("CompoundButton.SavedState{");
            stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder0.append(" checked=");
            return o.s(stringBuilder0, this.a, "}");
        }

        @Override  // android.view.View$BaseSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeValue(Boolean.valueOf(this.a));
        }
    }

    public final boolean a;
    public boolean b;
    public boolean c;
    public Q d;
    public Q e;
    public static final int[] f;

    static {
        RadioButton.f = new int[]{0x10100A0};
    }

    public RadioButton(Context context0) {
        super(context0);
    }

    public RadioButton(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.z, 0, 0);
        this.a = typedArray0.getBoolean(0, true);
        typedArray0.recycle();
        this.setFocusable(true);
        this.setClickable(true);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(this.a) {
            view0.setDuplicateParentStateEnabled(true);
            view0.setClickable(false);
            view0.setFocusable(false);
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    @Override  // com.iloen.melon.custom.S
    public final boolean isChecked() {
        return this.b;
    }

    @Override  // android.view.ViewGroup
    public final int[] onCreateDrawableState(int v) {
        int[] arr_v = super.onCreateDrawableState(v + 1);
        if(this.b) {
            View.mergeDrawableStates(arr_v, RadioButton.f);
        }
        return arr_v;
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        super.onRestoreInstanceState(((SavedState)parcelable0).getSuperState());
        this.setChecked(((SavedState)parcelable0).a);
        this.requestLayout();
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.a = this.b;
        return parcelable0;
    }

    @Override  // android.view.View
    public final boolean performClick() {
        this.playSoundEffect(0);
        if(!this.b) {
            this.setChecked(true);
        }
        return super.performClick();
    }

    @Override  // com.iloen.melon.custom.S
    public void setChecked(boolean z) {
        if(this.b != z) {
            this.b = z;
            this.refreshDrawableState();
            if(!this.c) {
                this.c = true;
                Q q0 = this.d;
                if(q0 != null) {
                    q0.n(this, this.b);
                }
                Q q1 = this.e;
                if(q1 != null) {
                    q1.n(this, this.b);
                }
                this.c = false;
            }
        }
    }

    public void setOnCheckedChangeListener(Q q0) {
        this.d = q0;
    }

    @Override  // com.iloen.melon.custom.S
    public void setOnCheckedChangeWidgetListener(Q q0) {
        this.e = q0;
    }
}

