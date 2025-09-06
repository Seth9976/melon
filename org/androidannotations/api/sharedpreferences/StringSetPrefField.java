package org.androidannotations.api.sharedpreferences;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import java.util.Set;

public final class StringSetPrefField extends AbstractPrefField {
    public StringSetPrefField(SharedPreferences sharedPreferences0, String s, Set set0) {
        super(sharedPreferences0, s, set0);
    }

    @Override  // org.androidannotations.api.sharedpreferences.AbstractPrefField
    public Object getOr(Object object0) {
        return this.getOr(((Set)object0));
    }

    public Set getOr(Set set0) {
        return SharedPreferencesCompat.getStringSet(this.sharedPreferences, this.key, set0);
    }

    @Override  // org.androidannotations.api.sharedpreferences.AbstractPrefField
    public void putInternal(Object object0) {
        this.putInternal(((Set)object0));
    }

    public void putInternal(Set set0) {
        SharedPreferences.Editor sharedPreferences$Editor0 = this.sharedPreferences.edit();
        SharedPreferencesCompat.putStringSet(sharedPreferences$Editor0, this.key, set0);
        this.apply(sharedPreferences$Editor0);
    }
}

