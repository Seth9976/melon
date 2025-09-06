package org.androidannotations.api.sharedpreferences;

import android.content.SharedPreferences;

public final class FloatPrefField extends AbstractPrefField {
    public FloatPrefField(SharedPreferences sharedPreferences0, String s, Float float0) {
        super(sharedPreferences0, s, float0);
    }

    public Float getOr(Float float0) {
        try {
            return this.sharedPreferences.getFloat(this.key, ((float)float0));
        }
        catch(ClassCastException classCastException0) {
            try {
                return Float.parseFloat(this.sharedPreferences.getString(this.key, "" + float0));
            }
            catch(Exception unused_ex) {
                throw classCastException0;
            }
        }
    }

    @Override  // org.androidannotations.api.sharedpreferences.AbstractPrefField
    public Object getOr(Object object0) {
        return this.getOr(((Float)object0));
    }

    public void putInternal(Float float0) {
        this.apply(this.edit().putFloat(this.key, ((float)float0)));
    }

    @Override  // org.androidannotations.api.sharedpreferences.AbstractPrefField
    public void putInternal(Object object0) {
        this.putInternal(((Float)object0));
    }
}

