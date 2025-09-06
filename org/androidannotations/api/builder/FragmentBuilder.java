package org.androidannotations.api.builder;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class FragmentBuilder extends Builder {
    protected Bundle args;

    public FragmentBuilder() {
        this.args = new Bundle();
    }

    public FragmentBuilder arg(Bundle bundle0) {
        this.args.putAll(bundle0);
        return this;
    }

    public FragmentBuilder arg(String s, byte b) {
        this.args.putByte(s, b);
        return this;
    }

    public FragmentBuilder arg(String s, char c) {
        this.args.putChar(s, c);
        return this;
    }

    public FragmentBuilder arg(String s, double f) {
        this.args.putDouble(s, f);
        return this;
    }

    public FragmentBuilder arg(String s, float f) {
        this.args.putFloat(s, f);
        return this;
    }

    public FragmentBuilder arg(String s, int v) {
        this.args.putInt(s, v);
        return this;
    }

    public FragmentBuilder arg(String s, long v) {
        this.args.putLong(s, v);
        return this;
    }

    public FragmentBuilder arg(String s, Bundle bundle0) {
        this.args.putBundle(s, bundle0);
        return this;
    }

    public FragmentBuilder arg(String s, Parcelable parcelable0) {
        this.args.putParcelable(s, parcelable0);
        return this;
    }

    public FragmentBuilder arg(String s, SparseArray sparseArray0) {
        this.args.putSparseParcelableArray(s, sparseArray0);
        return this;
    }

    public FragmentBuilder arg(String s, Serializable serializable0) {
        this.args.putSerializable(s, serializable0);
        return this;
    }

    public FragmentBuilder arg(String s, CharSequence charSequence0) {
        this.args.putCharSequence(s, charSequence0);
        return this;
    }

    public FragmentBuilder arg(String s, String s1) {
        this.args.putString(s, s1);
        return this;
    }

    public FragmentBuilder arg(String s, short v) {
        this.args.putShort(s, v);
        return this;
    }

    public FragmentBuilder arg(String s, boolean z) {
        this.args.putBoolean(s, z);
        return this;
    }

    public FragmentBuilder arg(String s, byte[] arr_b) {
        this.args.putByteArray(s, arr_b);
        return this;
    }

    public FragmentBuilder arg(String s, char[] arr_c) {
        this.args.putCharArray(s, arr_c);
        return this;
    }

    public FragmentBuilder arg(String s, double[] arr_f) {
        this.args.putDoubleArray(s, arr_f);
        return this;
    }

    public FragmentBuilder arg(String s, float[] arr_f) {
        this.args.putFloatArray(s, arr_f);
        return this;
    }

    public FragmentBuilder arg(String s, int[] arr_v) {
        this.args.putIntArray(s, arr_v);
        return this;
    }

    public FragmentBuilder arg(String s, long[] arr_v) {
        this.args.putLongArray(s, arr_v);
        return this;
    }

    public FragmentBuilder arg(String s, Parcelable[] arr_parcelable) {
        this.args.putParcelableArray(s, arr_parcelable);
        return this;
    }

    public FragmentBuilder arg(String s, String[] arr_s) {
        this.args.putStringArray(s, arr_s);
        return this;
    }

    public FragmentBuilder arg(String s, short[] arr_v) {
        this.args.putShortArray(s, arr_v);
        return this;
    }

    public FragmentBuilder arg(String s, boolean[] arr_z) {
        this.args.putBooleanArray(s, arr_z);
        return this;
    }

    public Bundle args() {
        return this.args;
    }

    public abstract Object build();

    public FragmentBuilder integerArrayListArg(String s, ArrayList arrayList0) {
        this.args.putIntegerArrayList(s, arrayList0);
        return this;
    }

    public FragmentBuilder parcelableArrayListArg(String s, ArrayList arrayList0) {
        this.args.putParcelableArrayList(s, arrayList0);
        return this;
    }

    public FragmentBuilder stringArrayListArg(String s, ArrayList arrayList0) {
        this.args.putStringArrayList(s, arrayList0);
        return this;
    }
}

