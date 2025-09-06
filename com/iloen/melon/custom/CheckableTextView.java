package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.View;
import androidx.appcompat.app.o;
import com.iloen.melon.utils.ui.ViewUtils;
import k8.t1;

public class CheckableTextView extends MelonTextView implements S {
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public boolean a;

        static {
            SavedState.CREATOR = new m();  // 初始化器: Ljava/lang/Object;-><init>()V
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

    public boolean i;
    public boolean j;
    public Q k;
    public Q l;
    public final String m;
    public final String n;
    public final boolean o;
    public static final int[] r;

    static {
        CheckableTextView.r = new int[]{0x10100A0};
    }

    public CheckableTextView(Context context0) {
        super(context0);
        this.o = false;
    }

    public CheckableTextView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        boolean z = false;
        this.o = false;
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.e);
        this.m = typedArray0.getString(0);
        this.n = typedArray0.getString(1);
        typedArray0.recycle();
        if(!TextUtils.isEmpty(this.m) && !TextUtils.isEmpty(this.n)) {
            z = true;
        }
        this.o = z;
        if(z) {
            ViewUtils.setContentDescriptionWithButtonClassName(this, this.n);
        }
    }

    @Override  // com.iloen.melon.custom.S
    public final boolean isChecked() {
        return this.i;
    }

    @Override  // android.widget.TextView
    public final int[] onCreateDrawableState(int v) {
        int[] arr_v = super.onCreateDrawableState(v + 1);
        if(this.i) {
            View.mergeDrawableStates(arr_v, CheckableTextView.r);
        }
        return arr_v;
    }

    @Override  // android.widget.TextView
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        super.onRestoreInstanceState(((SavedState)parcelable0).getSuperState());
        this.setChecked(((SavedState)parcelable0).a);
        this.requestLayout();
    }

    @Override  // android.widget.TextView
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.a = this.i;
        return parcelable0;
    }

    @Override  // android.view.View
    public final boolean performClick() {
        if(!this.i) {
            this.setChecked(true);
        }
        return super.performClick();
    }

    @Override  // com.iloen.melon.custom.S
    public void setChecked(boolean z) {
        if(this.i != z) {
            this.i = z;
            this.refreshDrawableState();
            if(!this.j) {
                this.j = true;
                Q q0 = this.k;
                if(q0 != null) {
                    q0.n(this, this.i);
                }
                Q q1 = this.l;
                if(q1 != null) {
                    q1.n(this, this.i);
                }
                this.j = false;
                if(this.o) {
                    ViewUtils.setContentDescriptionWithButtonClassName(this, (this.i ? this.m : this.n));
                }
            }
        }
    }

    public void setOnCheckedChangeListener(Q q0) {
        this.k = q0;
    }

    @Override  // com.iloen.melon.custom.S
    public void setOnCheckedChangeWidgetListener(Q q0) {
        this.l = q0;
    }
}

