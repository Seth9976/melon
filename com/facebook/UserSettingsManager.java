package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0011\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u00C1\u0002\u0018\u00002\u00020\u0001:\u0001EB\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J#\u0010\t\u001A\u00020\u00042\u0012\u0010\b\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u000B\u0010\u0003J\u0017\u0010\r\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u000F\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u000F\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u0010\u0010\u000EJ\u000F\u0010\u0011\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0003J\u000F\u0010\u0012\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0003J\u000F\u0010\u0013\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0013\u0010\u0003J\u000F\u0010\u0014\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0017\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001B\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b\u001B\u0010\u0018J\u000F\u0010\u001C\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b\u001C\u0010\u001AJ\u000F\u0010\u001D\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\b\u001D\u0010\u001AJ\u0011\u0010\u001E\u001A\u0004\u0018\u00010\u0015H\u0002\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0011\u0010 \u001A\u0004\u0018\u00010\u0015H\u0003\u00A2\u0006\u0004\b \u0010\u001FJ\u0011\u0010!\u001A\u0004\u0018\u00010\u0015H\u0002\u00A2\u0006\u0004\b!\u0010\u001FJ\u0017\u0010\"\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b\"\u0010\u0018J\u000F\u0010#\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b#\u0010\u001AJ\u000F\u0010$\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b$\u0010\u001AJ\u0017\u0010%\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b%\u0010\u0018J\u000F\u0010&\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b&\u0010\u001AR\u001C\u0010)\u001A\n (*\u0004\u0018\u00010\'0\'8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001A\u00020+8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001A\u00020+8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010/\u001A\u00020\'8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b/\u0010*R\u0014\u00101\u001A\u0002008\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001A\u00020\'8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b3\u0010*R\u0014\u00104\u001A\u00020\'8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b4\u0010*R\u0014\u00105\u001A\u00020\u00078\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001A\u00020\u00078\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b7\u00106R\u0014\u00108\u001A\u00020\u00078\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b8\u00106R\u0014\u00109\u001A\u00020\u00078\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b9\u00106R\u0014\u0010:\u001A\u00020\u00078\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b:\u00106R\u0014\u0010;\u001A\u00020\'8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b;\u0010*R\u0014\u0010<\u001A\u00020\'8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b<\u0010*R\u0016\u0010>\u001A\u00020=8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010@\u001A\u00020\'8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b@\u0010*R\u0014\u0010A\u001A\u00020\'8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bA\u0010*R\u0014\u0010B\u001A\u00020\'8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bB\u0010*R\u0014\u0010C\u001A\u00020\'8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bC\u0010*R\u0014\u0010D\u001A\u00020\'8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bD\u0010*\u00A8\u0006F"}, d2 = {"Lcom/facebook/UserSettingsManager;", "", "<init>", "()V", "Lie/H;", "initializeIfNotInitialized", "", "Lcom/facebook/UserSettingsManager$UserSetting;", "userSettings", "initializeUserSetting", "([Lcom/facebook/UserSettingsManager$UserSetting;)V", "initializeCodelessSetupEnabledAsync", "userSetting", "writeSettingToCache", "(Lcom/facebook/UserSettingsManager$UserSetting;)V", "readSettingFromCache", "loadSettingFromManifest", "logWarnings", "logIfSDKSettingsChanged", "logIfAutoAppLinkEnabled", "validateInitialized", "", "flag", "setAutoInitEnabled", "(Z)V", "getAutoInitEnabled", "()Z", "setAutoLogAppEventsEnabled", "getAutoLogAppEventsEnabled", "checkAutoLogAppEventsEnabled", "checkClientSideConfiguration", "()Ljava/lang/Boolean;", "readAutoLogAppEventsSettingFromCache", "loadAutoLogAppEventsSettingFromManifest", "setAdvertiserIDCollectionEnabled", "getAdvertiserIDCollectionEnabled", "getCodelessSetupEnabled", "setMonitorEnabled", "getMonitorEnabled", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isFetchingCodelessStatus", "EVENTS_CODELESS_SETUP_ENABLED", "", "TIMEOUT_7D", "J", "ADVERTISER_ID_KEY", "APPLICATION_FIELDS", "autoInitEnabled", "Lcom/facebook/UserSettingsManager$UserSetting;", "autoLogAppEventsEnabledLocally", "advertiserIDCollectionEnabled", "codelessSetupEnabled", "monitorEnabled", "USER_SETTINGS", "USER_SETTINGS_BITMASK", "Landroid/content/SharedPreferences;", "userSettingPref", "Landroid/content/SharedPreferences;", "LAST_TIMESTAMP", "VALUE", "ADVERTISERID_COLLECTION_NOT_SET_WARNING", "ADVERTISERID_COLLECTION_FALSE_WARNING", "AUTO_APP_LINK_WARNING", "UserSetting", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class UserSettingsManager {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000B\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001A\u00020\u0003R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u000F\u001A\u00020\u0010X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001E\u0010\u0015\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u001A\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/facebook/UserSettingsManager$UserSetting;", "", "defaultVal", "", "key", "", "(ZLjava/lang/String;)V", "getDefaultVal", "()Z", "setDefaultVal", "(Z)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "lastTS", "", "getLastTS", "()J", "setLastTS", "(J)V", "value", "getValue", "()Ljava/lang/Boolean;", "setValue", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class UserSetting {
        private boolean defaultVal;
        @NotNull
        private String key;
        private long lastTS;
        @Nullable
        private Boolean value;

        public UserSetting(boolean z, @NotNull String s) {
            q.g(s, "key");
            super();
            this.defaultVal = z;
            this.key = s;
        }

        public final boolean getDefaultVal() {
            return this.defaultVal;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        public final long getLastTS() {
            return this.lastTS;
        }

        @Nullable
        public final Boolean getValue() {
            return this.value;
        }

        public final boolean getValue() {
            return this.value == null ? this.defaultVal : this.value.booleanValue();
        }

        public final void setDefaultVal(boolean z) {
            this.defaultVal = z;
        }

        public final void setKey(@NotNull String s) {
            q.g(s, "<set-?>");
            this.key = s;
        }

        public final void setLastTS(long v) {
            this.lastTS = v;
        }

        public final void setValue(@Nullable Boolean boolean0) {
            this.value = boolean0;
        }
    }

    @NotNull
    private static final String ADVERTISERID_COLLECTION_FALSE_WARNING = "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you\'re sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.";
    @NotNull
    private static final String ADVERTISERID_COLLECTION_NOT_SET_WARNING = "You haven\'t set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.";
    @NotNull
    private static final String ADVERTISER_ID_KEY = "advertiser_id";
    @NotNull
    private static final String APPLICATION_FIELDS = "fields";
    @NotNull
    private static final String AUTO_APP_LINK_WARNING = "You haven\'t set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest";
    @NotNull
    private static final String EVENTS_CODELESS_SETUP_ENABLED = "auto_event_setup_enabled";
    @NotNull
    public static final UserSettingsManager INSTANCE = null;
    @NotNull
    private static final String LAST_TIMESTAMP = "last_timestamp";
    private static final String TAG = null;
    private static final long TIMEOUT_7D = 604800000L;
    @NotNull
    private static final String USER_SETTINGS = "com.facebook.sdk.USER_SETTINGS";
    @NotNull
    private static final String USER_SETTINGS_BITMASK = "com.facebook.sdk.USER_SETTINGS_BITMASK";
    @NotNull
    private static final String VALUE = "value";
    @NotNull
    private static final UserSetting advertiserIDCollectionEnabled;
    @NotNull
    private static final UserSetting autoInitEnabled;
    @NotNull
    private static final UserSetting autoLogAppEventsEnabledLocally;
    @NotNull
    private static final UserSetting codelessSetupEnabled;
    @NotNull
    private static final AtomicBoolean isFetchingCodelessStatus;
    @NotNull
    private static final AtomicBoolean isInitialized;
    @NotNull
    private static final UserSetting monitorEnabled;
    private static SharedPreferences userSettingPref;

    static {
        UserSettingsManager.INSTANCE = new UserSettingsManager();
        UserSettingsManager.TAG = "com.facebook.UserSettingsManager";
        UserSettingsManager.isInitialized = new AtomicBoolean(false);
        UserSettingsManager.isFetchingCodelessStatus = new AtomicBoolean(false);
        UserSettingsManager.autoInitEnabled = new UserSetting(true, "com.facebook.sdk.AutoInitEnabled");
        UserSettingsManager.autoLogAppEventsEnabledLocally = new UserSetting(true, "com.facebook.sdk.AutoLogAppEventsEnabled");
        UserSettingsManager.advertiserIDCollectionEnabled = new UserSetting(true, "com.facebook.sdk.AdvertiserIDCollectionEnabled");
        UserSettingsManager.codelessSetupEnabled = new UserSetting(false, "auto_event_setup_enabled");
        UserSettingsManager.monitorEnabled = new UserSetting(true, "com.facebook.sdk.MonitorEnabled");
    }

    private final boolean checkAutoLogAppEventsEnabled() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Map map0 = FetchedAppSettingsManager.getCachedMigratedAutoLogValuesInAppSettings();
            if(map0 != null && !map0.isEmpty()) {
                Boolean boolean0 = (Boolean)map0.get("auto_log_app_events_enabled");
                Boolean boolean1 = (Boolean)map0.get("auto_log_app_events_default");
                if(boolean0 != null) {
                    return boolean0.booleanValue();
                }
                Boolean boolean2 = this.checkClientSideConfiguration();
                if(boolean2 != null) {
                    return boolean2.booleanValue();
                }
                return boolean1 == null ? true : boolean1.booleanValue();
            }
            return UserSettingsManager.autoLogAppEventsEnabledLocally.getValue();
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return false;
    }

    private final Boolean checkClientSideConfiguration() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Boolean boolean0 = UserSettingsManager.readAutoLogAppEventsSettingFromCache();
            if(boolean0 != null) {
                return boolean0;
            }
            Boolean boolean1 = this.loadAutoLogAppEventsSettingFromManifest();
            return boolean1 == null ? null : boolean1;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    public static final boolean getAdvertiserIDCollectionEnabled() {
        Class class0 = UserSettingsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            UserSettingsManager.INSTANCE.initializeIfNotInitialized();
            return UserSettingsManager.advertiserIDCollectionEnabled.getValue();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    public static final boolean getAutoInitEnabled() {
        Class class0 = UserSettingsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            UserSettingsManager.INSTANCE.initializeIfNotInitialized();
            return UserSettingsManager.autoInitEnabled.getValue();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    public static final boolean getAutoLogAppEventsEnabled() {
        Class class0 = UserSettingsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            UserSettingsManager.INSTANCE.initializeIfNotInitialized();
            return UserSettingsManager.INSTANCE.checkAutoLogAppEventsEnabled();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    public static final boolean getCodelessSetupEnabled() {
        Class class0 = UserSettingsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            UserSettingsManager.INSTANCE.initializeIfNotInitialized();
            return UserSettingsManager.codelessSetupEnabled.getValue();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    public static final boolean getMonitorEnabled() {
        Class class0 = UserSettingsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            UserSettingsManager.INSTANCE.initializeIfNotInitialized();
            return UserSettingsManager.monitorEnabled.getValue();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    private final void initializeCodelessSetupEnabledAsync() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                UserSetting userSettingsManager$UserSetting0 = UserSettingsManager.codelessSetupEnabled;
                this.readSettingFromCache(userSettingsManager$UserSetting0);
                long v = System.currentTimeMillis();
                if(userSettingsManager$UserSetting0.getValue() != null && v - userSettingsManager$UserSetting0.getLastTS() < 604800000L) {
                    return;
                }
                userSettingsManager$UserSetting0.setValue(null);
                userSettingsManager$UserSetting0.setLastTS(0L);
                if(UserSettingsManager.isFetchingCodelessStatus.compareAndSet(false, true)) {
                    FacebookSdk.getExecutor().execute(new i(v));
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private static final void initializeCodelessSetupEnabledAsync$lambda$0(long v) {
        Class class0 = UserSettingsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            if(UserSettingsManager.advertiserIDCollectionEnabled.getValue()) {
                FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if(fetchedAppSettings0 != null && fetchedAppSettings0.getCodelessEventsEnabled()) {
                    Context context0 = FacebookSdk.getApplicationContext();
                    AttributionIdentifiers attributionIdentifiers0 = AttributionIdentifiers.Companion.getAttributionIdentifiers(context0);
                    String s = attributionIdentifiers0 == null || attributionIdentifiers0.getAndroidAdvertiserId() == null ? null : attributionIdentifiers0.getAndroidAdvertiserId();
                    if(s != null) {
                        Bundle bundle0 = new Bundle();
                        bundle0.putString("advertiser_id", s);
                        bundle0.putString("fields", "auto_event_setup_enabled");
                        GraphRequest graphRequest0 = GraphRequest.Companion.newGraphPathRequest(null, "app", null);
                        graphRequest0.setParameters(bundle0);
                        JSONObject jSONObject0 = graphRequest0.executeAndWait().getJSONObject();
                        if(jSONObject0 != null) {
                            Boolean boolean0 = Boolean.valueOf(jSONObject0.optBoolean("auto_event_setup_enabled", false));
                            UserSettingsManager.codelessSetupEnabled.setValue(boolean0);
                            UserSettingsManager.codelessSetupEnabled.setLastTS(v);
                            UserSettingsManager.INSTANCE.writeSettingToCache(UserSettingsManager.codelessSetupEnabled);
                        }
                    }
                }
            }
            UserSettingsManager.isFetchingCodelessStatus.set(false);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final void initializeIfNotInitialized() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                if(FacebookSdk.isInitialized() && UserSettingsManager.isInitialized.compareAndSet(false, true)) {
                    SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.USER_SETTINGS", 0);
                    q.f(sharedPreferences0, "getApplicationContext()\n…GS, Context.MODE_PRIVATE)");
                    UserSettingsManager.userSettingPref = sharedPreferences0;
                    this.initializeUserSetting(new UserSetting[]{UserSettingsManager.autoLogAppEventsEnabledLocally, UserSettingsManager.advertiserIDCollectionEnabled, UserSettingsManager.autoInitEnabled});
                    this.initializeCodelessSetupEnabledAsync();
                    this.logWarnings();
                    this.logIfSDKSettingsChanged();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void initializeUserSetting(UserSetting[] arr_userSettingsManager$UserSetting) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                for(int v = 0; v < arr_userSettingsManager$UserSetting.length; ++v) {
                    UserSetting userSettingsManager$UserSetting0 = arr_userSettingsManager$UserSetting[v];
                    if(userSettingsManager$UserSetting0 == UserSettingsManager.codelessSetupEnabled) {
                        this.initializeCodelessSetupEnabledAsync();
                    }
                    else if(userSettingsManager$UserSetting0.getValue() == null) {
                        this.readSettingFromCache(userSettingsManager$UserSetting0);
                        if(userSettingsManager$UserSetting0.getValue() == null) {
                            this.loadSettingFromManifest(userSettingsManager$UserSetting0);
                        }
                    }
                    else {
                        this.writeSettingToCache(userSettingsManager$UserSetting0);
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final Boolean loadAutoLogAppEventsSettingFromManifest() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            this.validateInitialized();
            try {
                ApplicationInfo applicationInfo0 = FacebookSdk.getApplicationContext().getPackageManager().getApplicationInfo("com.iloen.melon", 0x80);
                q.f(applicationInfo0, "ctx.packageManager.getAp…ageManager.GET_META_DATA)");
                Bundle bundle0 = applicationInfo0.metaData;
                if(bundle0 != null) {
                    UserSetting userSettingsManager$UserSetting0 = UserSettingsManager.autoLogAppEventsEnabledLocally;
                    if(bundle0.containsKey("com.facebook.sdk.AutoLogAppEventsEnabled")) {
                        return Boolean.valueOf(applicationInfo0.metaData.getBoolean(userSettingsManager$UserSetting0.getKey()));
                    }
                }
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                Utility.logd("com.facebook.UserSettingsManager", packageManager$NameNotFoundException0);
                return null;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        return null;
    }

    private final void loadSettingFromManifest(UserSetting userSettingsManager$UserSetting0) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.validateInitialized();
                try {
                    ApplicationInfo applicationInfo0 = FacebookSdk.getApplicationContext().getPackageManager().getApplicationInfo("com.iloen.melon", 0x80);
                    q.f(applicationInfo0, "ctx.packageManager.getAp…ageManager.GET_META_DATA)");
                    if(applicationInfo0.metaData != null && applicationInfo0.metaData.containsKey(userSettingsManager$UserSetting0.getKey())) {
                        userSettingsManager$UserSetting0.setValue(Boolean.valueOf(applicationInfo0.metaData.getBoolean(userSettingsManager$UserSetting0.getKey(), userSettingsManager$UserSetting0.getDefaultVal())));
                    }
                }
                catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                    Utility.logd("com.facebook.UserSettingsManager", packageManager$NameNotFoundException0);
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    public static final void logIfAutoAppLinkEnabled() {
        Class class0 = UserSettingsManager.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                Context context0 = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo0 = context0.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80);
                q.f(applicationInfo0, "ctx.packageManager.getAp…ageManager.GET_META_DATA)");
                if(applicationInfo0.metaData != null && applicationInfo0.metaData.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false)) {
                    InternalAppEventsLogger internalAppEventsLogger0 = new InternalAppEventsLogger(context0);
                    Bundle bundle0 = new Bundle();
                    if(!Utility.isAutoAppLinkSetup()) {
                        bundle0.putString("SchemeWarning", "You haven\'t set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
                        Log.w("com.facebook.UserSettingsManager", "You haven\'t set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
                    }
                    internalAppEventsLogger0.logEvent("fb_auto_applink", bundle0);
                    return;
                }
                return;
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private final void logIfSDKSettingsChanged() {
        int v4;
        int v3;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                if(UserSettingsManager.isInitialized.get() && FacebookSdk.isInitialized()) {
                    Context context0 = FacebookSdk.getApplicationContext();
                    int v = UserSettingsManager.autoInitEnabled.getValue() | UserSettingsManager.autoLogAppEventsEnabledLocally.getValue() << 1 | UserSettingsManager.advertiserIDCollectionEnabled.getValue() << 2 | UserSettingsManager.monitorEnabled.getValue() << 3;
                    SharedPreferences sharedPreferences0 = UserSettingsManager.userSettingPref;
                    if(sharedPreferences0 == null) {
                        q.m("userSettingPref");
                        throw null;
                    }
                    int v1 = 0;
                    int v2 = sharedPreferences0.getInt("com.facebook.sdk.USER_SETTINGS_BITMASK", 0);
                    if(v2 != v) {
                        SharedPreferences sharedPreferences1 = UserSettingsManager.userSettingPref;
                        if(sharedPreferences1 == null) {
                            q.m("userSettingPref");
                            throw null;
                        }
                        sharedPreferences1.edit().putInt("com.facebook.sdk.USER_SETTINGS_BITMASK", v).apply();
                        try {
                            ApplicationInfo applicationInfo0 = context0.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80);
                            q.f(applicationInfo0, "ctx.packageManager.getAp…ageManager.GET_META_DATA)");
                            if(applicationInfo0.metaData == null) {
                                v3 = 0;
                            }
                            else {
                                String[] arr_s = {"com.facebook.sdk.AutoInitEnabled", "com.facebook.sdk.AutoLogAppEventsEnabled", "com.facebook.sdk.AdvertiserIDCollectionEnabled", "com.facebook.sdk.MonitorEnabled"};
                                v3 = 0;
                                v4 = 0;
                                while(true) {
                                    if(v1 >= 4) {
                                        goto label_33;
                                    }
                                    try {
                                        v4 |= applicationInfo0.metaData.containsKey(arr_s[v1]) << v1;
                                        v3 |= applicationInfo0.metaData.getBoolean(arr_s[v1], new boolean[]{true, true, true, true}[v1]) << v1;
                                        ++v1;
                                    }
                                    catch(PackageManager.NameNotFoundException unused_ex) {
                                        v1 = v3;
                                        goto label_32;
                                    }
                                }
                            }
                            goto label_34;
                        }
                        catch(PackageManager.NameNotFoundException unused_ex) {
                            v4 = 0;
                        }
                    label_32:
                        v3 = v1;
                    label_33:
                        v1 = v4;
                    label_34:
                        InternalAppEventsLogger internalAppEventsLogger0 = new InternalAppEventsLogger(context0);
                        Bundle bundle0 = new Bundle();
                        bundle0.putInt("usage", v1);
                        bundle0.putInt("initial", v3);
                        bundle0.putInt("previous", v2);
                        bundle0.putInt("current", v);
                        internalAppEventsLogger0.logChangedSettingsEvent(bundle0);
                        return;
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void logWarnings() {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                ApplicationInfo applicationInfo0 = FacebookSdk.getApplicationContext().getPackageManager().getApplicationInfo("com.iloen.melon", 0x80);
                q.f(applicationInfo0, "ctx.packageManager.getAp…ageManager.GET_META_DATA)");
                Bundle bundle0 = applicationInfo0.metaData;
                if(bundle0 != null) {
                    if(!bundle0.containsKey("com.facebook.sdk.AdvertiserIDCollectionEnabled")) {
                        Log.w("com.facebook.UserSettingsManager", "You haven\'t set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
                    }
                    if(!UserSettingsManager.getAdvertiserIDCollectionEnabled()) {
                        Log.w("com.facebook.UserSettingsManager", "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you\'re sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.");
                        return;
                    }
                }
                return;
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final Boolean readAutoLogAppEventsSettingFromCache() {
        String s = "";
        Class class0 = UserSettingsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            UserSettingsManager.INSTANCE.validateInitialized();
            try {
                SharedPreferences sharedPreferences0 = UserSettingsManager.userSettingPref;
                if(sharedPreferences0 == null) {
                    q.m("userSettingPref");
                    throw null;
                }
                String s1 = sharedPreferences0.getString("com.facebook.sdk.AutoLogAppEventsEnabled", "");
                if(s1 != null) {
                    s = s1;
                }
                return s.length() > 0 ? Boolean.valueOf(new JSONObject(s).getBoolean("value")) : null;
            }
            catch(JSONException jSONException0) {
            }
            Utility.logd("com.facebook.UserSettingsManager", jSONException0);
            return null;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    private final void readSettingFromCache(UserSetting userSettingsManager$UserSetting0) {
        String s = "";
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.validateInitialized();
                try {
                    SharedPreferences sharedPreferences0 = UserSettingsManager.userSettingPref;
                    if(sharedPreferences0 != null) {
                        String s1 = sharedPreferences0.getString(userSettingsManager$UserSetting0.getKey(), "");
                        if(s1 != null) {
                            s = s1;
                        }
                        if(s.length() > 0) {
                            JSONObject jSONObject0 = new JSONObject(s);
                            userSettingsManager$UserSetting0.setValue(Boolean.valueOf(jSONObject0.getBoolean("value")));
                            userSettingsManager$UserSetting0.setLastTS(jSONObject0.getLong("last_timestamp"));
                            return;
                        }
                        return;
                    }
                    q.m("userSettingPref");
                    throw null;
                }
                catch(JSONException jSONException0) {
                }
                Utility.logd("com.facebook.UserSettingsManager", jSONException0);
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public static final void setAdvertiserIDCollectionEnabled(boolean z) {
        Class class0 = UserSettingsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            UserSetting userSettingsManager$UserSetting0 = UserSettingsManager.advertiserIDCollectionEnabled;
            userSettingsManager$UserSetting0.setValue(Boolean.valueOf(z));
            userSettingsManager$UserSetting0.setLastTS(System.currentTimeMillis());
            if(UserSettingsManager.isInitialized.get()) {
                UserSettingsManager.INSTANCE.writeSettingToCache(userSettingsManager$UserSetting0);
                return;
            }
            UserSettingsManager.INSTANCE.initializeIfNotInitialized();
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static final void setAutoInitEnabled(boolean z) {
        Class class0 = UserSettingsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            UserSetting userSettingsManager$UserSetting0 = UserSettingsManager.autoInitEnabled;
            userSettingsManager$UserSetting0.setValue(Boolean.valueOf(z));
            userSettingsManager$UserSetting0.setLastTS(System.currentTimeMillis());
            if(UserSettingsManager.isInitialized.get()) {
                UserSettingsManager.INSTANCE.writeSettingToCache(userSettingsManager$UserSetting0);
                return;
            }
            UserSettingsManager.INSTANCE.initializeIfNotInitialized();
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static final void setAutoLogAppEventsEnabled(boolean z) {
        Class class0 = UserSettingsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            UserSetting userSettingsManager$UserSetting0 = UserSettingsManager.autoLogAppEventsEnabledLocally;
            userSettingsManager$UserSetting0.setValue(Boolean.valueOf(z));
            userSettingsManager$UserSetting0.setLastTS(System.currentTimeMillis());
            if(UserSettingsManager.isInitialized.get()) {
                UserSettingsManager.INSTANCE.writeSettingToCache(userSettingsManager$UserSetting0);
                return;
            }
            UserSettingsManager.INSTANCE.initializeIfNotInitialized();
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static final void setMonitorEnabled(boolean z) {
        Class class0 = UserSettingsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            UserSetting userSettingsManager$UserSetting0 = UserSettingsManager.monitorEnabled;
            userSettingsManager$UserSetting0.setValue(Boolean.valueOf(z));
            userSettingsManager$UserSetting0.setLastTS(System.currentTimeMillis());
            if(UserSettingsManager.isInitialized.get()) {
                UserSettingsManager.INSTANCE.writeSettingToCache(userSettingsManager$UserSetting0);
                return;
            }
            UserSettingsManager.INSTANCE.initializeIfNotInitialized();
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final void validateInitialized() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                if(!UserSettingsManager.isInitialized.get()) {
                    throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void writeSettingToCache(UserSetting userSettingsManager$UserSetting0) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.validateInitialized();
                try {
                    JSONObject jSONObject0 = new JSONObject();
                    jSONObject0.put("value", userSettingsManager$UserSetting0.getValue());
                    jSONObject0.put("last_timestamp", userSettingsManager$UserSetting0.getLastTS());
                    SharedPreferences sharedPreferences0 = UserSettingsManager.userSettingPref;
                    if(sharedPreferences0 != null) {
                        sharedPreferences0.edit().putString(userSettingsManager$UserSetting0.getKey(), jSONObject0.toString()).apply();
                        this.logIfSDKSettingsChanged();
                        return;
                    }
                    q.m("userSettingPref");
                    throw null;
                }
                catch(Exception exception0) {
                }
                Utility.logd("com.facebook.UserSettingsManager", exception0);
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }
}

