package org.androidannotations.api.sharedpreferences;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;

public abstract class AbstractPrefField {
    protected final Object defaultValue;
    protected final String key;
    protected final SharedPreferences sharedPreferences;

    public AbstractPrefField(SharedPreferences sharedPreferences0, String s, Object object0) {
        this.sharedPreferences = sharedPreferences0;
        this.key = s;
        this.defaultValue = object0;
    }

    public final void apply(SharedPreferences.Editor sharedPreferences$Editor0) {
        SharedPreferencesCompat.apply(sharedPreferences$Editor0);
    }

    public SharedPreferences.Editor edit() {
        return this.sharedPreferences.edit();
    }

    public final boolean exists() {
        return this.sharedPreferences.contains(this.key);
    }

    public final Object get() {
        return this.getOr(this.defaultValue);
    }

    public abstract Object getOr(Object arg1);

    public String key() {
        return this.key;
    }

    public final void put(Object object0) {
        if(object0 == null) {
            object0 = this.defaultValue;
        }
        this.putInternal(object0);
    }

    public abstract void putInternal(Object arg1);

    public final void remove() {
        this.apply(this.edit().remove(this.key));
    }
}

