package com.google.android.material.internal;

import A6.c;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.customview.view.AbsSavedState;
import c2.W;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public boolean c;

        static {
            SavedState.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            this.c = parcel0.readInt() == 1;
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(((int)this.c));
        }
    }

    public boolean d;
    public boolean e;
    public boolean f;
    public static final int[] g;

    static {
        CheckableImageButton.g = new int[]{0x10100A0};
    }

    public CheckableImageButton(Context context0) {
        this(context0, null);
    }

    public CheckableImageButton(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040309);  // attr:imageButtonStyle
    }

    public CheckableImageButton(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.e = true;
        this.f = true;
        W.o(this, new c(this, 3));
    }

    @Override  // android.widget.Checkable
    public final boolean isChecked() {
        return this.d;
    }

    // 去混淆评级： 低(20)
    @Override  // android.widget.ImageView
    public final int[] onCreateDrawableState(int v) {
        return this.d ? View.mergeDrawableStates(super.onCreateDrawableState(v + 1), CheckableImageButton.g) : super.onCreateDrawableState(v);
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        this.setChecked(((SavedState)parcelable0).c);
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.c = this.d;
        return parcelable0;
    }

    public void setCheckable(boolean z) {
        if(this.e != z) {
            this.e = z;
            this.sendAccessibilityEvent(0);
        }
    }

    @Override  // android.widget.Checkable
    public void setChecked(boolean z) {
        if(this.e && this.d != z) {
            this.d = z;
            this.refreshDrawableState();
            this.sendAccessibilityEvent(0x800);
        }
    }

    public void setPressable(boolean z) {
        this.f = z;
    }

    @Override  // android.view.View
    public void setPressed(boolean z) {
        if(this.f) {
            super.setPressed(z);
        }
    }

    @Override  // android.widget.Checkable
    public final void toggle() {
        this.setChecked(!this.d);
    }
}

