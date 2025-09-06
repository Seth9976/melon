package com.kakao.tiara;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.net.UrlQuerySanitizer.ValueSanitizer;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.kakao.tiara.data.Install.Builder;
import com.kakao.tiara.data.Install;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TiaraManager implements Callback, SessionCallback {
    static class GlobalSettings {
        private String appInstallDate;
        private String appVersion;
        private boolean blockAppLog;
        private boolean cookieEnabled;
        private boolean cookieSyncAtInstanceEnabled;
        private String deployment;
        private Install install;
        private String serverUrl;
        private int sessionTimeout;
        private String tuid;
        private String uuid;

        public GlobalSettings() {
            this.cookieEnabled = false;
            this.cookieSyncAtInstanceEnabled = true;
        }

        public static String access$200(GlobalSettings tiaraManager$GlobalSettings0) {
            return tiaraManager$GlobalSettings0.uuid;
        }

        public String getAppInstallDate() {
            return this.appInstallDate;
        }

        public String getAppVersion() {
            return this.appVersion;
        }

        public String getDeployment() {
            return this.deployment;
        }

        public Install getInstall() {
            return this.install;
        }

        public String getServerUrl() {
            return this.serverUrl;
        }

        public int getSessionTimeout() {
            return this.sessionTimeout;
        }

        public String getTuid() {
            return this.tuid;
        }

        public String getUuid() {
            return this.uuid;
        }

        public boolean isAppLogBlocked() {
            return this.blockAppLog;
        }

        public boolean isCookieEnabled() {
            return this.cookieEnabled;
        }

        public boolean isCookieSyncAtInstanceEnabled() {
            return this.cookieSyncAtInstanceEnabled;
        }

        public void setAppInstallDate(String s) {
            this.appInstallDate = s;
        }

        public void setAppLogBlocked(boolean z) {
            this.blockAppLog = z;
        }

        public void setAppVersion(String s) {
            this.appVersion = s;
        }

        public void setCookieEnabled(boolean z) {
            this.cookieEnabled = z;
        }

        public void setCookieSyncAtInstanceEnabled(boolean z) {
            this.cookieSyncAtInstanceEnabled = z;
        }

        public void setDeployment(String s) {
            this.deployment = s;
        }

        public void setInstall(Install install0) {
            this.install = install0;
        }

        public void setServerUrl(String s) {
            this.serverUrl = s;
        }

        public void setSessionTimeout(int v) {
            this.sessionTimeout = v;
        }

        public void setTuid(String s) {
            this.tuid = s;
        }

        public void setUuid(String s) {
            this.uuid = s;
        }
    }

    static class InstanceHolder {
        private static final TiaraManager INSTANCE;

        static {
            InstanceHolder.INSTANCE = new TiaraManager(null);
        }

        public static TiaraManager access$100() {
            return InstanceHolder.INSTANCE;
        }
    }

    private static final String KEY_APP_VERSION = "app_version";
    private static final String KEY_INSTALL_BEGIN_TIME = "install_begin_time";
    private static final String KEY_INSTALL_CAMPAIGN = "install_campaign";
    private static final String KEY_INSTALL_CONTENT = "install_content";
    private static final String KEY_INSTALL_DATE = "install_date";
    private static final String KEY_INSTALL_FIRST_LAUNCH_TIME = "install_first_launch_time";
    private static final String KEY_INSTALL_MEDIUM = "install_medium";
    private static final String KEY_INSTALL_REFERRER = "install_referrer";
    private static final String KEY_INSTALL_REFERRER_CLICK_TIME = "install_referrer_click_time";
    private static final String KEY_INSTALL_SOURCE = "install_source";
    private static final String KEY_INSTALL_TERM = "install_term";
    private static final String KEY_TUID = "tuid";
    private static final String KEY_UUID = "uuid";
    private static final String OLD_PREFERENCE_NAME = "net.daum.android.tiara";
    private static final Pattern PATTERN_UUID = null;
    private static final String TAG = "TiaraManager";
    private static final String URL_KEY_CAMPAIGN = "utm_campaign";
    private static final String URL_KEY_CONTENT = "utm_content";
    private static final String URL_KEY_MEDIUM = "utm_medium";
    private static final String URL_KEY_SOURCE = "utm_source";
    private static final String URL_KEY_TERM = "utm_term";
    private Application context;
    private ThreadPoolExecutor executor;
    private GlobalSettings globalSettings;
    private boolean initialized;
    private TiaraSession session;
    private Map trackers;

    static {
        TiaraManager.PATTERN_UUID = Pattern.compile("(\\bUUID=[^;]*)");
    }

    private TiaraManager() {
        this.trackers = new HashMap();
        this.initialized = false;
        this.globalSettings = new GlobalSettings();
    }

    public TiaraManager(com.kakao.tiara.TiaraManager.1 tiaraManager$10) {
    }

    private boolean execute(Runnable runnable0) {
        if(!this.initialized) {
            return false;
        }
        try {
            this.executor.execute(runnable0);
            return true;
        }
        catch(Exception unused_ex) {
            return false;
        }
    }

    public boolean flush(Tracker tracker0) {
        return this.execute(tracker0);
    }

    public TiaraTracker get(String s) {
        return (TiaraTracker)this.trackers.get(s);
    }

    public String getAppVersion() {
        return this.getStringValue("app_version");
    }

    public Context getContext() {
        return this.context;
    }

    public GlobalSettings getGlobalSettings() {
        return this.globalSettings;
    }

    public static TiaraManager getInstance() {
        return InstanceHolder.access$100();
    }

    public SessionIds getSessionId() {
        return this.isInitialized() ? this.session.getSessionIds() : SessionIds.generateNullIds();
    }

    // 去混淆评级： 低(20)
    private static SharedPreferences getSharedPreferences(Context context0) {
        return context0 == null ? null : context0.getSharedPreferences("com.iloen.melon_tiara", 0);
    }

    private static String getStringValue(Context context0, String s) {
        SharedPreferences sharedPreferences0 = TiaraManager.getSharedPreferences(context0);
        return sharedPreferences0 == null ? null : sharedPreferences0.getString(s, null);
    }

    private String getStringValue(String s) {
        return TiaraManager.getStringValue(this.context, s);
    }

    public String getUuidCookie() {
        if(!this.initialized) {
            return null;
        }
        try {
            Map map0 = this.context.getSharedPreferences("net.daum.android.tiara", 0).getAll();
            if(map0 != null && !map0.isEmpty()) {
                Iterator iterator0 = map0.entrySet().iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        break;
                    }
                    Object object0 = iterator0.next();
                    Map.Entry map$Entry0 = (Map.Entry)object0;
                    String s = (String)map$Entry0.getKey();
                    if(s.endsWith("Cookies") && !s.contains("WebTransfer")) {
                        String s1 = (String)map$Entry0.getValue();
                        if(TextUtils.isEmpty(s1)) {
                            break;
                        }
                        Matcher matcher0 = TiaraManager.PATTERN_UUID.matcher(s1);
                        if(!matcher0.find()) {
                            break;
                        }
                        return matcher0.group(1);
                    }
                }
            }
        }
        catch(Exception exception0) {
            Logger.error("TiaraManager", exception0.toString(), new Object[0]);
        }
        return null;
    }

    public void holdSession() {
        if(!this.isInitialized()) {
            return;
        }
        this.session.hold();
    }

    public void initialize(Application application0, TiaraConfiguration tiaraConfiguration0) {
        if(this.initialized) {
            Log.w("TiaraManager", "already initialized.");
            return;
        }
        this.initialized = true;
        this.context = application0;
        String s = this.getStringValue("tuid");
        if(TextUtils.isEmpty(s)) {
            s = "QnRdtbJC1VOv_250906113405095";
            this.setStringValue("tuid", "QnRdtbJC1VOv_250906113405095");
        }
        this.globalSettings.setTuid(s);
        String s1 = this.getStringValue("uuid");
        if(TextUtils.isEmpty(s1)) {
            s1 = "KsX6AVe41WKK_250906039556911";
            this.setStringValue("uuid", "KsX6AVe41WKK_250906039556911");
        }
        this.globalSettings.setUuid(s1);
        String s2 = this.getStringValue("install_date");
        if(TextUtils.isEmpty(s2)) {
            s2 = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Calendar.getInstance().getTime());
            this.setStringValue("install_date", s2);
        }
        this.globalSettings.setAppInstallDate(s2);
        String s3 = this.getStringValue("install_referrer");
        String s4 = this.getStringValue("install_campaign");
        String s5 = this.getStringValue("install_medium");
        String s6 = this.getStringValue("install_source");
        String s7 = this.getStringValue("install_term");
        String s8 = this.getStringValue("install_content");
        String s9 = this.getStringValue("install_referrer_click_time");
        String s10 = this.getStringValue("install_begin_time");
        String s11 = this.getStringValue("install_first_launch_time");
        Install install0 = new Builder().referrer(s3).campaign(s4).medium(s5).source(s6).term(s7).content(s8).referrerClickTime(s9).installBeginTime(s10).firstLaunchTime(s11).build();
        this.globalSettings.setInstall(install0);
        this.globalSettings.setAppLogBlocked(tiaraConfiguration0.isAppLogBlocked());
        this.globalSettings.setSessionTimeout(tiaraConfiguration0.getSessionTimeout());
        this.globalSettings.setCookieEnabled(tiaraConfiguration0.isCookieEnabled());
        this.globalSettings.setCookieSyncAtInstanceEnabled(tiaraConfiguration0.isCookieSyncAtInstanceEnabled());
        this.globalSettings.setServerUrl(tiaraConfiguration0.getServerUrl());
        try {
            PackageManager packageManager0 = application0.getPackageManager();
            PackageInfo packageInfo0 = packageManager0.getPackageInfo("com.iloen.melon", 0x80);
            this.globalSettings.setAppVersion(packageInfo0.versionName);
            Bundle bundle0 = packageManager0.getApplicationInfo("com.iloen.melon", 0x80).metaData;
            if(bundle0 != null) {
                String s12 = bundle0.getString("TIARA_DEPLOYMENT", "production");
                this.globalSettings.setDeployment(s12);
            }
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            packageManager$NameNotFoundException0.printStackTrace();
        }
        this.executor = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable0) {
                return new Thread(runnable0, "tiara_event_tracking");
            }
        });
        this.session = new TiaraSession(this, tiaraConfiguration0.getSessionTimeout());
        if(this.globalSettings.isCookieEnabled()) {
            TiaraCookieUtils.setDomains(tiaraConfiguration0.getCookieDomains());
            TiaraCookieUtils.setTuidCookie(s);
            TiaraCookieUtils.setUuidCookie(s1);
            SessionIds sessionIds0 = this.session.getSessionIds();
            TiaraCookieUtils.setTsidCookie(sessionIds0.getTsid());
            TiaraCookieUtils.setSuidCookie(sessionIds0.getSuid());
            TiaraCookieUtils.setIsuidCookie(sessionIds0.getIsuid());
        }
        application0.registerActivityLifecycleCallbacks(new TiaraLifecycleCallbacks(this));
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public TiaraTracker newInstance(String s, TiaraSettings tiaraSettings0) {
        if(!this.trackers.containsKey(s)) {
            this.trackers.put(s, new TiaraTracker(s, tiaraSettings0));
        }
        return (TiaraTracker)this.trackers.get(s);
    }

    @Override  // com.kakao.tiara.TiaraLifecycleCallbacks$Callback
    public void onBackground() {
        this.session.onBackground();
        for(Object object0: new HashSet(this.trackers.keySet())) {
            ((TiaraTracker)this.trackers.get(((String)object0))).onBackground();
        }
    }

    @Override  // com.kakao.tiara.TiaraLifecycleCallbacks$Callback
    public void onForeground() {
        this.session.onForeground();
        for(Object object0: new HashSet(this.trackers.keySet())) {
            ((TiaraTracker)this.trackers.get(((String)object0))).onForeground();
        }
    }

    @Override  // com.kakao.tiara.TiaraSession$SessionCallback
    public void onStartNewSession(SessionIds sessionIds0) {
        for(Object object0: new HashSet(this.trackers.keySet())) {
            TiaraTracker tiaraTracker0 = (TiaraTracker)this.trackers.get(((String)object0));
            tiaraTracker0.resetSeqNum();
            tiaraTracker0.setSessionId(this.getSessionId());
        }
        if(!this.globalSettings.isCookieEnabled()) {
            return;
        }
        TiaraCookieUtils.setTsidCookie(sessionIds0.getTsid());
        TiaraCookieUtils.setSuidCookie(sessionIds0.getSuid());
        TiaraCookieUtils.setIsuidCookie(sessionIds0.getIsuid());
    }

    public void releaseSession() {
        if(!this.isInitialized()) {
            return;
        }
        this.session.release();
    }

    public void saveAppVersion(String s) {
        this.setStringValue("app_version", s);
    }

    public void setAccountIdCookie(String s) {
        if(this.isInitialized() && this.globalSettings.isCookieEnabled()) {
            if(TextUtils.isEmpty(s)) {
                TiaraCookieUtils.deleteAccountIdCookie();
                return;
            }
            TiaraCookieUtils.setAccountIdCookie(s);
        }
    }

    public void setAdidCookie(String s) {
        if(this.isInitialized() && this.globalSettings.isCookieEnabled() && !TextUtils.isEmpty(s)) {
            TiaraCookieUtils.setAdidCookie(s);
        }
    }

    public void setAdidTrackingEnabledCookie(boolean z) {
        if(this.isInitialized() && this.globalSettings.isCookieEnabled()) {
            TiaraCookieUtils.setAdidTrackingEnabledCookie(z);
        }
    }

    public void setInstallFromReferrer(String s, String s1, String s2) {
        if(this.context != null && !TextUtils.isEmpty(s) && TextUtils.getTrimmedLength(s) >= 2) {
            UrlQuerySanitizer urlQuerySanitizer0 = new UrlQuerySanitizer();
            UrlQuerySanitizer.ValueSanitizer urlQuerySanitizer$ValueSanitizer0 = UrlQuerySanitizer.getAllButNulLegal();
            urlQuerySanitizer0.registerParameters(new String[]{"utm_campaign", "utm_medium", "utm_source", "utm_term", "utm_content"}, urlQuerySanitizer$ValueSanitizer0);
            urlQuerySanitizer0.parseQuery(s);
            String s3 = urlQuerySanitizer0.getValue("utm_campaign");
            String s4 = urlQuerySanitizer0.getValue("utm_medium");
            String s5 = urlQuerySanitizer0.getValue("utm_source");
            String s6 = urlQuerySanitizer0.getValue("utm_term");
            String s7 = urlQuerySanitizer0.getValue("utm_content");
            TiaraManager.setStringValue(this.context, "install_referrer", s);
            TiaraManager.setStringValue(this.context, "install_campaign", s3);
            TiaraManager.setStringValue(this.context, "install_medium", s4);
            TiaraManager.setStringValue(this.context, "install_source", s5);
            TiaraManager.setStringValue(this.context, "install_term", s6);
            TiaraManager.setStringValue(this.context, "install_content", s7);
            TiaraManager.setStringValue(this.context, "install_referrer_click_time", s1);
            TiaraManager.setStringValue(this.context, "install_begin_time", s2);
            String s8 = TiaraManager.getStringValue(this.context, "install_first_launch_time");
            Install install0 = new Builder().referrer(s).campaign(s3).medium(s4).source(s5).term(s6).content(s7).referrerClickTime(s1).installBeginTime(s2).firstLaunchTime(s8).build();
            Logger.debug("TiaraManager", "Tiara install referrer : %s.", new Object[]{install0});
            TiaraManager.getInstance().getGlobalSettings().setInstall(install0);
        }
    }

    private static void setStringValue(Context context0, String s, String s1) {
        SharedPreferences sharedPreferences0 = TiaraManager.getSharedPreferences(context0);
        if(sharedPreferences0 == null) {
            return;
        }
        sharedPreferences0.edit().putString(s, s1).apply();
    }

    private void setStringValue(String s, String s1) {
        TiaraManager.setStringValue(this.context, s, s1);
    }

    public void setTAnoCookie(String s, boolean z) {
        if(this.isInitialized() && this.globalSettings.isCookieEnabled()) {
            TiaraCookieUtils.setTAnoCookie(GlobalSettings.access$200(this.globalSettings), s, Boolean.valueOf(z));
        }
    }

    public void startNewSessionIfExpired() {
        if(!this.isInitialized()) {
            return;
        }
        this.session.startNewSessionIfExpired();
    }

    public void updateFirstLaunchTime() {
        this.setStringValue("install_first_launch_time", "1757129645");
    }
}

