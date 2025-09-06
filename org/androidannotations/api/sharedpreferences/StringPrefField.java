package org.androidannotations.api.sharedpreferences;

import android.content.SharedPreferences;

public final class StringPrefField extends AbstractPrefField {
    public StringPrefField(SharedPreferences sharedPreferences0, String s, String s1) {
        super(sharedPreferences0, s, s1);
    }

    @Override  // org.androidannotations.api.sharedpreferences.AbstractPrefField
    public Object getOr(Object object0) {
        return this.getOr(((String)object0));
    }

    public String getOr(String s) {
        return this.sharedPreferences.getString(this.key, s);
    }

    @Override  // org.androidannotations.api.sharedpreferences.AbstractPrefField
    public void putInternal(Object object0) {
        this.putInternal(((String)object0));
    }

    public void putInternal(String s) {
        this.apply(this.edit().putString(this.key, s));
    }
}

