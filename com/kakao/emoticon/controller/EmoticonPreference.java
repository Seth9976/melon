package com.kakao.emoticon.controller;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import com.kakao.emoticon.KakaoEmoticon;

public class EmoticonPreference {
    private final Object LockForTabIndex;
    private static final String PREF_KEY_LAST_UPDATED_AT = "last_updated_at";
    private static final String PREF_KEY_NORMAL_CP_GUIDE_DISPLAYED = "normal_cp_guide_displayed";
    private static final String PREF_KEY_STORE_GUIDE_NEVER_ASK_AGAIN = "store_guide_never_ask_again";
    private static final String PREF_KEY_TAB_INDEX = "tab_index";
    private static final String PREF_KEY_UID = "uid";
    private static final String PREF_NAME = "pref_emoticon";
    private static final String PREF_NEED_RESET_CACHE_DIR = "pref_need_reset_cache_dir";
    private static volatile EmoticonPreference instance;
    private final SharedPreferences sharedPreferences;
    private String tabIndex;

    private EmoticonPreference(Context context0) {
        this.LockForTabIndex = new Object();
        this.sharedPreferences = context0.getSharedPreferences("pref_emoticon", 0);
    }

    public static EmoticonPreference getInstance() {
        if(EmoticonPreference.instance == null) {
            Class class0 = EmoticonPreference.class;
            synchronized(class0) {
                if(EmoticonPreference.instance == null) {
                    EmoticonPreference.instance = new EmoticonPreference(KakaoEmoticon.getApplication());
                }
            }
        }
        return EmoticonPreference.instance;
    }

    public long getLastUpdatedAt() {
        return this.sharedPreferences.getLong("last_updated_at", 0L);
    }

    public String getTabIndex() {
        if(this.tabIndex == null) {
            synchronized(this.LockForTabIndex) {
                this.tabIndex = this.sharedPreferences.getString("tab_index", "");
                return this.tabIndex;
            }
        }
        return this.tabIndex;
    }

    public String getUID() {
        return this.sharedPreferences.getString("uid", null);
    }

    public boolean isNeedResetCacheDir() {
        return this.sharedPreferences.getBoolean("pref_need_reset_cache_dir", true);
    }

    public boolean isNormalCPGuideOnceDisplayed() {
        return this.sharedPreferences.getBoolean("normal_cp_guide_displayed", false);
    }

    public boolean isStoreGuideNeverAskAgain() {
        return this.sharedPreferences.getBoolean("store_guide_never_ask_again", false);
    }

    public void resetTabIndex() {
        SharedPreferences.Editor sharedPreferences$Editor0 = this.sharedPreferences.edit();
        sharedPreferences$Editor0.remove("tab_index");
        sharedPreferences$Editor0.apply();
    }

    public void setLastUpdatedAt(long v) {
        this.sharedPreferences.edit().putLong("last_updated_at", v).apply();
    }

    public void setNeedResetCacheDir(boolean z) {
        this.sharedPreferences.edit().putBoolean("pref_need_reset_cache_dir", z).apply();
    }

    public void setNormalCPGuideOnceDisplayed(boolean z) {
        this.sharedPreferences.edit().putBoolean("normal_cp_guide_displayed", z).apply();
    }

    public void setStoreGuideNeverAskAgain(boolean z) {
        this.sharedPreferences.edit().putBoolean("store_guide_never_ask_again", z).apply();
    }

    public void setTabIndex(String s) {
        if(s != null && !s.equals(this.tabIndex)) {
            this.tabIndex = s;
            SharedPreferences.Editor sharedPreferences$Editor0 = this.sharedPreferences.edit();
            sharedPreferences$Editor0.putString("tab_index", s);
            sharedPreferences$Editor0.apply();
        }
    }

    public void setUID(String s) {
        this.sharedPreferences.edit().putString("uid", s).apply();
    }
}

