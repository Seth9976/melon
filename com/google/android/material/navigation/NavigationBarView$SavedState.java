package com.google.android.material.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.customview.view.AbsSavedState;

class NavigationBarView.SavedState extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public Bundle c;

    static {
        NavigationBarView.SavedState.CREATOR = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public NavigationBarView.SavedState(Parcel parcel0, ClassLoader classLoader0) {
        super(parcel0, classLoader0);
        if(classLoader0 == null) {
            classLoader0 = this.getClass().getClassLoader();
        }
        this.c = parcel0.readBundle(classLoader0);
    }

    @Override  // androidx.customview.view.AbsSavedState
    public final void writeToParcel(Parcel parcel0, int v) {
        super.writeToParcel(parcel0, v);
        parcel0.writeBundle(this.c);
    }
}

