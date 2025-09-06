package com.iloen.melon.custom;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.View;
import androidx.appcompat.app.o;

public class CheckableTagView extends MelonTextView implements S {
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public boolean a;

        static {
            SavedState.CREATOR = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
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
    public static final int[] m;

    static {
        CheckableTagView.m = new int[]{0x10100A0};
    }

    public CheckableTagView(Context context0) {
        super(context0);
    }

    public CheckableTagView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    @Override  // com.iloen.melon.custom.S
    public final boolean isChecked() {
        return this.i;
    }

    @Override  // android.widget.TextView
    public final int[] onCreateDrawableState(int v) {
        int[] arr_v = super.onCreateDrawableState(v + 1);
        if(this.i) {
            View.mergeDrawableStates(arr_v, CheckableTagView.m);
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

