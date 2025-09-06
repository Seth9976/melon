package com.iloen.melon.utils.preference;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

@Deprecated(since = "6.7.0, use DataStore instead")
class SharedPrefsHelper implements SharedPreferences.Editor, SharedPreferences {
    public final SharedPreferences a;

    public SharedPrefsHelper(Context context0, String s) {
        this.a = context0.getSharedPreferences(s, 0);
    }

    @Override  // android.content.SharedPreferences$Editor
    public void apply() {
        this.edit().apply();
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor clear() {
        return this.edit().clear();
    }

    public void clearAndCommit() {
        this.clear().commit();
    }

    @Override  // android.content.SharedPreferences$Editor
    public boolean commit() {
        this.edit().apply();
        return true;
    }

    @Override  // android.content.SharedPreferences
    public boolean contains(String s) {
        return this.a.contains(s);
    }

    @Override  // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.a.edit();
    }

    @Override  // android.content.SharedPreferences
    public Map getAll() {
        return this.a.getAll();
    }

    @Override  // android.content.SharedPreferences
    public boolean getBoolean(String s, boolean z) {
        return this.a.getBoolean(s, z);
    }

    @Override  // android.content.SharedPreferences
    public float getFloat(String s, float f) {
        return this.a.getFloat(s, f);
    }

    @Override  // android.content.SharedPreferences
    public int getInt(String s, int v) {
        return this.a.getInt(s, v);
    }

    @Override  // android.content.SharedPreferences
    public long getLong(String s, long v) {
        return this.a.getLong(s, v);
    }

    @Override  // android.content.SharedPreferences
    public String getString(String s, String s1) {
        return this.a.getString(s, s1);
    }

    @Override  // android.content.SharedPreferences
    public Set getStringSet(String s, Set set0) {
        return this.a.getStringSet(s, set0);
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor putBoolean(String s, boolean z) {
        return this.edit().putBoolean(s, z);
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor putFloat(String s, float f) {
        return this.edit().putFloat(s, f);
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor putInt(String s, int v) {
        return this.edit().putInt(s, v);
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor putLong(String s, long v) {
        return this.edit().putLong(s, v);
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor putString(String s, String s1) {
        return this.edit().putString(s, s1);
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor putStringSet(String s, Set set0) {
        return this.edit().putStringSet(s, set0);
    }

    @Override  // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener0) {
        this.a.registerOnSharedPreferenceChangeListener(sharedPreferences$OnSharedPreferenceChangeListener0);
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor remove(String s) {
        return this.edit().remove(s);
    }

    public void removeAndCommit(String s) {
        this.remove(s).commit();
    }

    public void setBoolean(String s, boolean z) {
        this.putBoolean(s, z).commit();
    }

    public void setFloat(String s, float f) {
        this.putFloat(s, f).commit();
    }

    public void setInt(String s, int v) {
        this.putInt(s, v).commit();
    }

    public void setLong(String s, long v) {
        this.putLong(s, v).commit();
    }

    public void setString(String s, String s1) {
        this.putString(s, s1).commit();
    }

    public void setStringSet(String s, Set set0) {
        this.putStringSet(s, set0).commit();
    }

    @Override  // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener0) {
        this.a.unregisterOnSharedPreferenceChangeListener(sharedPreferences$OnSharedPreferenceChangeListener0);
    }
}

