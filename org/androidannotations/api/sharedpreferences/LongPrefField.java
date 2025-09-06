package org.androidannotations.api.sharedpreferences;

import android.content.SharedPreferences;

public final class LongPrefField extends AbstractPrefField {
    public LongPrefField(SharedPreferences sharedPreferences0, String s, Long long0) {
        super(sharedPreferences0, s, long0);
    }

    public Long getOr(Long long0) {
        try {
            return this.sharedPreferences.getLong(this.key, ((long)long0));
        }
        catch(ClassCastException classCastException0) {
            try {
                return Long.parseLong(this.sharedPreferences.getString(this.key, "" + long0));
            }
            catch(Exception unused_ex) {
                throw classCastException0;
            }
        }
    }

    @Override  // org.androidannotations.api.sharedpreferences.AbstractPrefField
    public Object getOr(Object object0) {
        return this.getOr(((Long)object0));
    }

    public void putInternal(Long long0) {
        this.apply(this.edit().putLong(this.key, ((long)long0)));
    }

    @Override  // org.androidannotations.api.sharedpreferences.AbstractPrefField
    public void putInternal(Object object0) {
        this.putInternal(((Long)object0));
    }
}

