package com.iloen.melon.utils.preference;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.iloen.melon.MelonAppBase;
import java.util.Map;
import java.util.Set;

@Deprecated(since = "6.7.0, use DataStore instead")
public class MelonPrefs extends SharedPrefsHelper implements DebugPreferenceConstants, PreferenceConstants {
    public static MelonPrefs b;

    public MelonPrefs(Context context0) {
        super(context0, "com.iloen.melon.tablet.Preference.SETTING");
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public void apply() {
        super.apply();
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public SharedPreferences.Editor clear() {
        return super.clear();
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public void clearAndCommit() {
        super.clearAndCommit();
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public boolean commit() {
        return super.commit();
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public boolean contains(String s) {
        return super.contains(s);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public SharedPreferences.Editor edit() {
        return super.edit();
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public Map getAll() {
        return super.getAll();
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public boolean getBoolean(String s, boolean z) {
        return super.getBoolean(s, z);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public float getFloat(String s, float f) {
        return super.getFloat(s, f);
    }

    public static MelonPrefs getInstance() {
        if(MelonPrefs.b == null) {
            MelonPrefs.b = new MelonPrefs(MelonAppBase.instance.getContext());
        }
        return MelonPrefs.b;
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public int getInt(String s, int v) {
        return super.getInt(s, v);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public long getLong(String s, long v) {
        return super.getLong(s, v);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public String getString(String s, String s1) {
        return super.getString(s, s1);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public Set getStringSet(String s, Set set0) {
        return super.getStringSet(s, set0);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public SharedPreferences.Editor putBoolean(String s, boolean z) {
        return super.putBoolean(s, z);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public SharedPreferences.Editor putFloat(String s, float f) {
        return super.putFloat(s, f);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public SharedPreferences.Editor putInt(String s, int v) {
        return super.putInt(s, v);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public SharedPreferences.Editor putLong(String s, long v) {
        return super.putLong(s, v);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public SharedPreferences.Editor putString(String s, String s1) {
        return super.putString(s, s1);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public SharedPreferences.Editor putStringSet(String s, Set set0) {
        return super.putStringSet(s, set0);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener0) {
        super.registerOnSharedPreferenceChangeListener(sharedPreferences$OnSharedPreferenceChangeListener0);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public SharedPreferences.Editor remove(String s) {
        return super.remove(s);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public void removeAndCommit(String s) {
        super.removeAndCommit(s);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public void setBoolean(String s, boolean z) {
        super.setBoolean(s, z);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public void setFloat(String s, float f) {
        super.setFloat(s, f);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public void setInt(String s, int v) {
        super.setInt(s, v);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public void setLong(String s, long v) {
        super.setLong(s, v);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public void setString(String s, String s1) {
        super.setString(s, s1);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public void setStringSet(String s, Set set0) {
        super.setStringSet(s, set0);
    }

    @Override  // com.iloen.melon.utils.preference.SharedPrefsHelper
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener0) {
        super.unregisterOnSharedPreferenceChangeListener(sharedPreferences$OnSharedPreferenceChangeListener0);
    }
}

