package org.androidannotations.api.sharedpreferences;

import android.content.SharedPreferences;
import java.util.Set;

public abstract class SharedPreferencesHelper {
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesHelper(SharedPreferences sharedPreferences0) {
        this.sharedPreferences = sharedPreferences0;
    }

    public BooleanPrefField booleanField(String s, boolean z) {
        return new BooleanPrefField(this.sharedPreferences, s, Boolean.valueOf(z));
    }

    public final void clear() {
        SharedPreferencesCompat.apply(this.sharedPreferences.edit().clear());
    }

    public FloatPrefField floatField(String s, float f) {
        return new FloatPrefField(this.sharedPreferences, s, f);
    }

    public final SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    public IntPrefField intField(String s, int v) {
        return new IntPrefField(this.sharedPreferences, s, v);
    }

    public LongPrefField longField(String s, long v) {
        return new LongPrefField(this.sharedPreferences, s, v);
    }

    public StringPrefField stringField(String s, String s1) {
        return new StringPrefField(this.sharedPreferences, s, s1);
    }

    public StringSetPrefField stringSetField(String s, Set set0) {
        return new StringSetPrefField(this.sharedPreferences, s, set0);
    }
}

