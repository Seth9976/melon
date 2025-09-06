package org.androidannotations.api.sharedpreferences;

import android.content.SharedPreferences;

public final class IntPrefField extends AbstractPrefField {
    public IntPrefField(SharedPreferences sharedPreferences0, String s, Integer integer0) {
        super(sharedPreferences0, s, integer0);
    }

    public Integer getOr(Integer integer0) {
        try {
            return this.sharedPreferences.getInt(this.key, ((int)integer0));
        }
        catch(ClassCastException classCastException0) {
            try {
                return Integer.parseInt(this.sharedPreferences.getString(this.key, "" + integer0));
            }
            catch(Exception unused_ex) {
                throw classCastException0;
            }
        }
    }

    @Override  // org.androidannotations.api.sharedpreferences.AbstractPrefField
    public Object getOr(Object object0) {
        return this.getOr(((Integer)object0));
    }

    public void putInternal(Integer integer0) {
        this.apply(this.edit().putInt(this.key, ((int)integer0)));
    }

    @Override  // org.androidannotations.api.sharedpreferences.AbstractPrefField
    public void putInternal(Object object0) {
        this.putInternal(((Integer)object0));
    }
}

