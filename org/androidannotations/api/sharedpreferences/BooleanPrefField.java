package org.androidannotations.api.sharedpreferences;

import android.content.SharedPreferences;

public final class BooleanPrefField extends AbstractPrefField {
    public BooleanPrefField(SharedPreferences sharedPreferences0, String s, Boolean boolean0) {
        super(sharedPreferences0, s, boolean0);
    }

    public Boolean getOr(Boolean boolean0) {
        return Boolean.valueOf(this.sharedPreferences.getBoolean(this.key, boolean0.booleanValue()));
    }

    @Override  // org.androidannotations.api.sharedpreferences.AbstractPrefField
    public Object getOr(Object object0) {
        return this.getOr(((Boolean)object0));
    }

    public void putInternal(Boolean boolean0) {
        this.apply(this.edit().putBoolean(this.key, boolean0.booleanValue()));
    }

    @Override  // org.androidannotations.api.sharedpreferences.AbstractPrefField
    public void putInternal(Object object0) {
        this.putInternal(((Boolean)object0));
    }
}

