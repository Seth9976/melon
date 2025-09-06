package org.androidannotations.api.builder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class IntentBuilder extends Builder {
    protected final Context context;
    protected final Intent intent;

    public IntentBuilder(Context context0, Intent intent0) {
        this.context = context0;
        this.intent = intent0;
    }

    public IntentBuilder(Context context0, Class class0) {
        this(context0, new Intent(context0, class0));
    }

    public IntentBuilder action(String s) {
        this.intent.setAction(s);
        return this;
    }

    public IntentBuilder category(String s) {
        this.intent.addCategory(s);
        return this;
    }

    public IntentBuilder data(Uri uri0) {
        this.intent.setData(uri0);
        return this;
    }

    public IntentBuilder extra(String s, byte b) {
        this.intent.putExtra(s, b);
        return this;
    }

    public IntentBuilder extra(String s, char c) {
        this.intent.putExtra(s, c);
        return this;
    }

    public IntentBuilder extra(String s, double f) {
        this.intent.putExtra(s, f);
        return this;
    }

    public IntentBuilder extra(String s, float f) {
        this.intent.putExtra(s, f);
        return this;
    }

    public IntentBuilder extra(String s, int v) {
        this.intent.putExtra(s, v);
        return this;
    }

    public IntentBuilder extra(String s, long v) {
        this.intent.putExtra(s, v);
        return this;
    }

    public IntentBuilder extra(String s, Bundle bundle0) {
        this.intent.putExtra(s, bundle0);
        return this;
    }

    public IntentBuilder extra(String s, Parcelable parcelable0) {
        this.intent.putExtra(s, parcelable0);
        return this;
    }

    public IntentBuilder extra(String s, Serializable serializable0) {
        this.intent.putExtra(s, serializable0);
        return this;
    }

    public IntentBuilder extra(String s, CharSequence charSequence0) {
        this.intent.putExtra(s, charSequence0);
        return this;
    }

    public IntentBuilder extra(String s, String s1) {
        this.intent.putExtra(s, s1);
        return this;
    }

    public IntentBuilder extra(String s, short v) {
        this.intent.putExtra(s, v);
        return this;
    }

    public IntentBuilder extra(String s, boolean z) {
        this.intent.putExtra(s, z);
        return this;
    }

    public IntentBuilder extra(String s, byte[] arr_b) {
        this.intent.putExtra(s, arr_b);
        return this;
    }

    public IntentBuilder extra(String s, char[] arr_c) {
        this.intent.putExtra(s, arr_c);
        return this;
    }

    public IntentBuilder extra(String s, double[] arr_f) {
        this.intent.putExtra(s, arr_f);
        return this;
    }

    public IntentBuilder extra(String s, float[] arr_f) {
        this.intent.putExtra(s, arr_f);
        return this;
    }

    public IntentBuilder extra(String s, int[] arr_v) {
        this.intent.putExtra(s, arr_v);
        return this;
    }

    public IntentBuilder extra(String s, long[] arr_v) {
        this.intent.putExtra(s, arr_v);
        return this;
    }

    public IntentBuilder extra(String s, Parcelable[] arr_parcelable) {
        this.intent.putExtra(s, arr_parcelable);
        return this;
    }

    public IntentBuilder extra(String s, String[] arr_s) {
        this.intent.putExtra(s, arr_s);
        return this;
    }

    public IntentBuilder extra(String s, short[] arr_v) {
        this.intent.putExtra(s, arr_v);
        return this;
    }

    public IntentBuilder extra(String s, boolean[] arr_z) {
        this.intent.putExtra(s, arr_z);
        return this;
    }

    public IntentBuilder extras(Intent intent0) {
        this.intent.putExtras(intent0);
        return this;
    }

    public IntentBuilder flags(int v) {
        this.intent.setFlags(v);
        return this;
    }

    public Intent get() {
        return this.intent;
    }

    public Context getContext() {
        return this.context;
    }

    public IntentBuilder integerArrayListExtra(String s, ArrayList arrayList0) {
        this.intent.putIntegerArrayListExtra(s, arrayList0);
        return this;
    }

    public IntentBuilder parcelableArrayListExtra(String s, ArrayList arrayList0) {
        this.intent.putParcelableArrayListExtra(s, arrayList0);
        return this;
    }

    public IntentBuilder stringArrayListExtra(String s, ArrayList arrayList0) {
        this.intent.putStringArrayListExtra(s, arrayList0);
        return this;
    }

    public IntentBuilder type(String s) {
        this.intent.setType(s);
        return this;
    }
}

