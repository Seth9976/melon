package com.google.android.material.stateful;

import C6.a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import androidx.collection.V;
import androidx.customview.view.AbsSavedState;

public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public final V c;

    static {
        ExtendableSavedState.CREATOR = new a(0);
    }

    public ExtendableSavedState(Parcel parcel0, ClassLoader classLoader0) {
        super(parcel0, classLoader0);
        int v = parcel0.readInt();
        String[] arr_s = new String[v];
        parcel0.readStringArray(arr_s);
        Bundle[] arr_bundle = new Bundle[v];
        parcel0.readTypedArray(arr_bundle, Bundle.CREATOR);
        this.c = new V(v);
        for(int v1 = 0; v1 < v; ++v1) {
            this.c.put(arr_s[v1], arr_bundle[v1]);
        }
    }

    public ExtendableSavedState(Parcelable parcelable0) {
        super(parcelable0);
        this.c = new V(0);
    }

    @Override
    public final String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.c + "}";
    }

    @Override  // androidx.customview.view.AbsSavedState
    public final void writeToParcel(Parcel parcel0, int v) {
        super.writeToParcel(parcel0, v);
        V v1 = this.c;
        int v2 = v1.size();
        parcel0.writeInt(v2);
        String[] arr_s = new String[v2];
        Bundle[] arr_bundle = new Bundle[v2];
        for(int v3 = 0; v3 < v2; ++v3) {
            arr_s[v3] = (String)v1.keyAt(v3);
            arr_bundle[v3] = (Bundle)v1.valueAt(v3);
        }
        parcel0.writeStringArray(arr_s);
        parcel0.writeTypedArray(arr_bundle, 0);
    }
}

