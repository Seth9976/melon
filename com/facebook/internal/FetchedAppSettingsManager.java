package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.app.o;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.c;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.ondeviceprocessing.a;
import e.k;
import ie.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u0002yzB\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u001B\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u000BH\u0007\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0003J\u001D\u0010\u0012\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001A\u00020\u00042\u0006\u0010\u0017\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u001B\u0010\u001CJ1\u0010 \u001A\u001A\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001F0\u001E0\u00102\b\u0010\u001D\u001A\u0004\u0018\u00010\u001AH\u0002\u00A2\u0006\u0004\b \u0010!J\u001B\u0010$\u001A\u0004\u0018\u00010#2\b\u0010\"\u001A\u0004\u0018\u00010\u001AH\u0002\u00A2\u0006\u0004\b$\u0010%J#\u0010)\u001A\u0004\u0018\u00010(2\b\u0010&\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\'\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b)\u0010*J)\u0010.\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\b\u0010+\u001A\u0004\u0018\u00010\u001A2\u0006\u0010,\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b.\u0010/J[\u00104\u001A:\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060-02\u0018\u000101j\u001C\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060-02\u0018\u0001`32\b\u0010+\u001A\u0004\u0018\u00010\u001A2\b\b\u0002\u00100\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b4\u00105J\'\u00107\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\u00106\u001A\u0004\u0018\u00010\u001AH\u0002\u00A2\u0006\u0004\b7\u0010!J\u001F\u0010:\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u00106\u001A\u00020\u001AH\u0000\u00A2\u0006\u0004\b8\u00109R\u001C\u0010<\u001A\n ;*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b>\u0010=R\u0014\u0010?\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b?\u0010=R\u0014\u0010@\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b@\u0010=R\u0014\u0010A\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bA\u0010=R\u0014\u0010B\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bB\u0010=R\u0014\u0010C\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bC\u0010=R\u0014\u0010D\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bD\u0010=R\u0014\u0010E\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bE\u0010=R\u0014\u0010F\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bF\u0010=R\u0014\u0010G\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bG\u0010=R\u0014\u0010H\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bH\u0010=R\u0014\u0010I\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bI\u0010=R\u0014\u0010K\u001A\u00020J8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010M\u001A\u00020J8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bM\u0010LR\u0014\u0010N\u001A\u00020J8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bN\u0010LR\u0014\u0010O\u001A\u00020J8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bO\u0010LR\u0014\u0010P\u001A\u00020J8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bP\u0010LR\u0014\u0010Q\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bQ\u0010=R\u0014\u0010R\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bR\u0010=R\u0014\u0010S\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bS\u0010=R\u0014\u0010T\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bT\u0010=R\u0014\u0010U\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bU\u0010=R\u0014\u0010V\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bV\u0010=R\u0014\u0010W\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bW\u0010=R\u0014\u0010X\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bX\u0010=R\u0014\u0010Y\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bY\u0010=R\u0014\u0010Z\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bZ\u0010=R\u0014\u0010[\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b[\u0010=R\u0014\u0010\\\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\\\u0010=R\u0014\u0010]\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b]\u0010=R\u0014\u0010^\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b^\u0010=R\u0014\u0010_\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b_\u0010=R\u0014\u0010`\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b`\u0010=R\u0014\u0010a\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\ba\u0010=R\u0014\u0010b\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bb\u0010=R\u0014\u0010c\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bc\u0010=R\u0014\u0010d\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bd\u0010=R\u0014\u0010e\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\be\u0010=R\u0014\u0010f\u001A\u00020\u00068\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\bf\u0010=R\u0014\u0010g\u001A\u00020\u00068\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\bg\u0010=R\u001A\u0010h\u001A\b\u0012\u0004\u0012\u00020\u00060-8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010j\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bj\u0010=R \u0010k\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u001E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bk\u0010lR\"\u0010o\u001A\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010n0n0m8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bo\u0010pR\u001A\u0010r\u001A\b\u0012\u0004\u0012\u00020\u000B0q8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010t\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010v\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bv\u0010uR\u0018\u0010w\u001A\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bw\u0010x\u00A8\u0006{"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager;", "", "<init>", "()V", "Lie/H;", "loadAppSettingsAsync", "", "applicationId", "Lcom/facebook/internal/FetchedAppSettings;", "getAppSettingsWithoutQuery", "(Ljava/lang/String;)Lcom/facebook/internal/FetchedAppSettings;", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "callback", "getAppSettingsAsync", "(Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;)V", "pollCallbacks", "", "", "getCachedMigratedAutoLogValuesInAppSettings", "()Ljava/util/Map;", "forceRequery", "queryAppSettings", "(Ljava/lang/String;Z)Lcom/facebook/internal/FetchedAppSettings;", "flag", "setIsUnityInit", "(Z)V", "Lorg/json/JSONObject;", "getAppSettingsQueryResponse", "(Ljava/lang/String;)Lorg/json/JSONObject;", "dialogConfigResponse", "", "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "parseDialogConfigurations", "(Lorg/json/JSONObject;)Ljava/util/Map;", "parameters", "", "parseDedupeWindow", "(Lorg/json/JSONObject;)Ljava/lang/Long;", "protectedModeSettings", "ruleType", "Lorg/json/JSONArray;", "parseProtectedModeRules", "(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;", "originalJSON", "key", "", "parseCurrencyAndValueDedupeParameters", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/util/List;", "getTestValues", "Ljava/util/ArrayList;", "Lie/m;", "Lkotlin/collections/ArrayList;", "parseDedupeParameters", "(Lorg/json/JSONObject;Z)Ljava/util/ArrayList;", "settingsJSON", "parseMigratedAutoLogValues", "parseAppSettingsFromJSON$facebook_core_release", "(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/facebook/internal/FetchedAppSettings;", "parseAppSettingsFromJSON", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "APP_SETTINGS_PREFS_STORE", "APP_SETTINGS_PREFS_KEY_FORMAT", "APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING", "APP_SETTING_NUX_CONTENT", "APP_SETTING_NUX_ENABLED", "APP_SETTING_DIALOG_CONFIGS", "APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES", "APP_SETTING_APP_EVENTS_SESSION_TIMEOUT", "APP_SETTING_APP_EVENTS_FEATURE_BITMASK", "APP_SETTING_APP_EVENTS_EVENT_BINDINGS", "APP_SETTING_APP_EVENTS_CONFIG", "APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD", "", "AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD", "I", "IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD", "CODELESS_EVENTS_ENABLED_BITMASK_FIELD", "TRACK_UNINSTALL_ENABLED_BITMASK_FIELD", "MONITOR_ENABLED_BITMASK_FIELD", "APP_SETTING_SMART_LOGIN_OPTIONS", "SMART_LOGIN_BOOKMARK_ICON_URL", "SMART_LOGIN_MENU_ICON_URL", "SDK_UPDATE_MESSAGE", "APP_SETTING_APP_EVENTS_AAM_RULE", "SUGGESTED_EVENTS_SETTING", "PROTECTED_MODE_RULES", "STANDARD_PARAMS_KEY", "MACA_RULES_KEY", "BLOCKLIST_EVENTS_KEY", "REDACTED_EVENTS_KEY", "SENSITIVE_PARAMS_KEY", "DEDUPE_KEY", "ANDROID_DEDUPE_KEY", "PROD_DEDUPE_KEY", "TEST_DEDUPE_KEY", "KEY", "VALUE", "DEDUPE_WINDOW", "STD_PARAMS_SCHEMA_KEY", "STD_PARAMS_BLOCKED_KEY", "AUTO_LOG_APP_EVENTS_DEFAULT_FIELD", "AUTO_LOG_APP_EVENT_ENABLED_FIELD", "APP_SETTING_FIELDS", "Ljava/util/List;", "APPLICATION_FIELDS", "fetchedAppSettings", "Ljava/util/Map;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchAppSettingState;", "loadingState", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "fetchedAppSettingsCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "printedSDKUpdatedMessage", "Z", "isUnityInit", "unityEventBindings", "Lorg/json/JSONArray;", "FetchAppSettingState", "FetchedAppSettingsCallback", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FetchedAppSettingsManager {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager$FetchAppSettingState;", "", "(Ljava/lang/String;I)V", "NOT_LOADED", "LOADING", "SUCCESS", "ERROR", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR;

        private static final FetchAppSettingState[] $values() [...] // Inlined contents
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "", "Lcom/facebook/internal/FetchedAppSettings;", "fetchedAppSettings", "Lie/H;", "onSuccess", "(Lcom/facebook/internal/FetchedAppSettings;)V", "onError", "()V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface FetchedAppSettingsCallback {
        void onError();

        void onSuccess(@Nullable FetchedAppSettings arg1);
    }

    @NotNull
    private static final String ANDROID_DEDUPE_KEY = "FBAndroidSDK";
    @NotNull
    private static final String APPLICATION_FIELDS = "fields";
    @NotNull
    private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
    @NotNull
    private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
    @NotNull
    private static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";
    @NotNull
    private static final String APP_SETTING_APP_EVENTS_AAM_RULE = "aam_rules";
    @NotNull
    private static final String APP_SETTING_APP_EVENTS_CONFIG = "app_events_config";
    @NotNull
    private static final String APP_SETTING_APP_EVENTS_EVENT_BINDINGS = "auto_event_mapping_android";
    @NotNull
    private static final String APP_SETTING_APP_EVENTS_FEATURE_BITMASK = "app_events_feature_bitmask";
    @NotNull
    private static final String APP_SETTING_APP_EVENTS_SESSION_TIMEOUT = "app_events_session_timeout";
    @NotNull
    private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
    @NotNull
    private static final List APP_SETTING_FIELDS = null;
    @NotNull
    private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
    @NotNull
    private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
    @NotNull
    private static final String APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD = "restrictive_data_filter_params";
    @NotNull
    private static final String APP_SETTING_SMART_LOGIN_OPTIONS = "seamless_login";
    @NotNull
    private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    private static final int AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 8;
    @NotNull
    public static final String AUTO_LOG_APP_EVENTS_DEFAULT_FIELD = "auto_log_app_events_default";
    @NotNull
    public static final String AUTO_LOG_APP_EVENT_ENABLED_FIELD = "auto_log_app_events_enabled";
    @NotNull
    private static final String BLOCKLIST_EVENTS_KEY = "blocklist_events";
    private static final int CODELESS_EVENTS_ENABLED_BITMASK_FIELD = 0x20;
    @NotNull
    private static final String DEDUPE_KEY = "iap_manual_and_auto_log_dedup_keys";
    @NotNull
    private static final String DEDUPE_WINDOW = "iap_manual_and_auto_log_dedup_window_millis";
    private static final int IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 16;
    @NotNull
    public static final FetchedAppSettingsManager INSTANCE = null;
    @NotNull
    private static final String KEY = "key";
    @NotNull
    private static final String MACA_RULES_KEY = "maca_rules";
    private static final int MONITOR_ENABLED_BITMASK_FIELD = 0x4000;
    @NotNull
    private static final String PROD_DEDUPE_KEY = "prod_keys";
    @NotNull
    private static final String PROTECTED_MODE_RULES = "protected_mode_rules";
    @NotNull
    private static final String REDACTED_EVENTS_KEY = "redacted_events";
    @NotNull
    private static final String SDK_UPDATE_MESSAGE = "sdk_update_message";
    @NotNull
    private static final String SENSITIVE_PARAMS_KEY = "sensitive_params";
    @NotNull
    private static final String SMART_LOGIN_BOOKMARK_ICON_URL = "smart_login_bookmark_icon_url";
    @NotNull
    private static final String SMART_LOGIN_MENU_ICON_URL = "smart_login_menu_icon_url";
    @NotNull
    private static final String STANDARD_PARAMS_KEY = "standard_params";
    @NotNull
    private static final String STD_PARAMS_BLOCKED_KEY = "standard_params_blocked";
    @NotNull
    private static final String STD_PARAMS_SCHEMA_KEY = "standard_params_schema";
    @NotNull
    private static final String SUGGESTED_EVENTS_SETTING = "suggested_events_setting";
    private static final String TAG = null;
    @NotNull
    private static final String TEST_DEDUPE_KEY = "test_keys";
    private static final int TRACK_UNINSTALL_ENABLED_BITMASK_FIELD = 0x100;
    @NotNull
    private static final String VALUE = "value";
    @NotNull
    private static final Map fetchedAppSettings;
    @NotNull
    private static final ConcurrentLinkedQueue fetchedAppSettingsCallbacks;
    private static boolean isUnityInit;
    @NotNull
    private static final AtomicReference loadingState;
    private static boolean printedSDKUpdatedMessage;
    @Nullable
    private static JSONArray unityEventBindings;

    static {
        FetchedAppSettingsManager.INSTANCE = new FetchedAppSettingsManager();
        FetchedAppSettingsManager.TAG = "FetchedAppSettingsManager";
        FetchedAppSettingsManager.APP_SETTING_FIELDS = k.A(new String[]{"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url", "restrictive_data_filter_params", "aam_rules", "suggested_events_setting", "protected_mode_rules", "auto_log_app_events_default", "auto_log_app_events_enabled", o.r(new StringBuilder("app_events_config.os_version("), Build.VERSION.RELEASE, ')')});
        FetchedAppSettingsManager.fetchedAppSettings = new ConcurrentHashMap();
        FetchedAppSettingsManager.loadingState = new AtomicReference(FetchAppSettingState.NOT_LOADED);
        FetchedAppSettingsManager.fetchedAppSettingsCallbacks = new ConcurrentLinkedQueue();
    }

    public static void a(Context context0, String s, String s1) {
        FetchedAppSettingsManager.loadAppSettingsAsync$lambda$0(context0, s, s1);
    }

    public static void b(FetchedAppSettingsCallback fetchedAppSettingsManager$FetchedAppSettingsCallback0) {
        FetchedAppSettingsManager.pollCallbacks$lambda$1(fetchedAppSettingsManager$FetchedAppSettingsCallback0);
    }

    public static final void getAppSettingsAsync(@NotNull FetchedAppSettingsCallback fetchedAppSettingsManager$FetchedAppSettingsCallback0) {
        q.g(fetchedAppSettingsManager$FetchedAppSettingsCallback0, "callback");
        FetchedAppSettingsManager.fetchedAppSettingsCallbacks.add(fetchedAppSettingsManager$FetchedAppSettingsCallback0);
        FetchedAppSettingsManager.loadAppSettingsAsync();
    }

    private final JSONObject getAppSettingsQueryResponse(String s) {
        Bundle bundle0 = new Bundle();
        ArrayList arrayList0 = new ArrayList();
        arrayList0.addAll(FetchedAppSettingsManager.APP_SETTING_FIELDS);
        bundle0.putString("fields", TextUtils.join(",", arrayList0));
        GraphRequest graphRequest0 = GraphRequest.Companion.newGraphPathRequest(null, "app", null);
        graphRequest0.setForceApplicationRequest(true);
        graphRequest0.setParameters(bundle0);
        JSONObject jSONObject0 = graphRequest0.executeAndWait().getJsonObject();
        return jSONObject0 == null ? new JSONObject() : jSONObject0;
    }

    @Nullable
    public static final FetchedAppSettings getAppSettingsWithoutQuery(@Nullable String s) {
        return s == null ? null : ((FetchedAppSettings)FetchedAppSettingsManager.fetchedAppSettings.get(s));
    }

    @Nullable
    public static final Map getCachedMigratedAutoLogValuesInAppSettings() {
        Context context0 = FacebookSdk.getApplicationContext();
        String s = String.format("com.facebook.internal.APP_SETTINGS.%s", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
        String s1 = context0.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0).getString(s, null);
        if(!Utility.isNullOrEmpty(s1)) {
            if(s1 != null) {
                try {
                    JSONObject jSONObject0 = new JSONObject(s1);
                    return jSONObject0 == null ? null : FetchedAppSettingsManager.INSTANCE.parseMigratedAutoLogValues(jSONObject0);
                }
                catch(JSONException jSONException0) {
                    Utility.logd("FacebookSDK", jSONException0);
                    return null;
                }
            }
            throw new IllegalStateException("Required value was null.");
        }
        return null;
    }

    public static final void loadAppSettingsAsync() {
        Context context0 = FacebookSdk.getApplicationContext();
        String s = FacebookSdk.getApplicationId();
        if(Utility.isNullOrEmpty(s)) {
            FetchedAppSettingsManager.loadingState.set(FetchAppSettingState.ERROR);
            FetchedAppSettingsManager.INSTANCE.pollCallbacks();
            return;
        }
        if(FetchedAppSettingsManager.fetchedAppSettings.containsKey(s)) {
            FetchedAppSettingsManager.loadingState.set(FetchAppSettingState.SUCCESS);
            FetchedAppSettingsManager.INSTANCE.pollCallbacks();
            return;
        }
        AtomicReference atomicReference0 = FetchedAppSettingsManager.loadingState;
        FetchAppSettingState fetchedAppSettingsManager$FetchAppSettingState0 = FetchAppSettingState.NOT_LOADED;
        FetchAppSettingState fetchedAppSettingsManager$FetchAppSettingState1 = FetchAppSettingState.LOADING;
    alab1:
        while(!atomicReference0.compareAndSet(fetchedAppSettingsManager$FetchAppSettingState0, fetchedAppSettingsManager$FetchAppSettingState1)) {
            if(atomicReference0.get() != fetchedAppSettingsManager$FetchAppSettingState0) {
                AtomicReference atomicReference1 = FetchedAppSettingsManager.loadingState;
                FetchAppSettingState fetchedAppSettingsManager$FetchAppSettingState2 = FetchAppSettingState.ERROR;
                FetchAppSettingState fetchedAppSettingsManager$FetchAppSettingState3 = FetchAppSettingState.LOADING;
                while(true) {
                    if(atomicReference1.compareAndSet(fetchedAppSettingsManager$FetchAppSettingState2, fetchedAppSettingsManager$FetchAppSettingState3)) {
                        break alab1;
                    }
                    if(atomicReference1.get() == fetchedAppSettingsManager$FetchAppSettingState2) {
                        continue;
                    }
                    FetchedAppSettingsManager.INSTANCE.pollCallbacks();
                    return;
                }
            }
            if(false) {
                break;
            }
        }
        String s1 = String.format("com.facebook.internal.APP_SETTINGS.%s", Arrays.copyOf(new Object[]{s}, 1));
        FacebookSdk.getExecutor().execute(new a(context0, s1, s, 2));
    }

    private static final void loadAppSettingsAsync$lambda$0(Context context0, String s, String s1) {
        JSONObject jSONObject0;
        q.g(context0, "$context");
        q.g(s, "$settingsKey");
        q.g(s1, "$applicationId");
        SharedPreferences sharedPreferences0 = context0.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
        FetchedAppSettings fetchedAppSettings0 = null;
        String s2 = sharedPreferences0.getString(s, null);
        if(!Utility.isNullOrEmpty(s2)) {
            if(s2 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            try {
                jSONObject0 = new JSONObject(s2);
            }
            catch(JSONException jSONException0) {
                Utility.logd("FacebookSDK", jSONException0);
                jSONObject0 = null;
            }
            if(jSONObject0 != null) {
                fetchedAppSettings0 = FetchedAppSettingsManager.INSTANCE.parseAppSettingsFromJSON$facebook_core_release(s1, jSONObject0);
            }
        }
        FetchedAppSettingsManager fetchedAppSettingsManager0 = FetchedAppSettingsManager.INSTANCE;
        JSONObject jSONObject1 = fetchedAppSettingsManager0.getAppSettingsQueryResponse(s1);
        if(jSONObject1 != null) {
            fetchedAppSettingsManager0.parseAppSettingsFromJSON$facebook_core_release(s1, jSONObject1);
            sharedPreferences0.edit().putString(s, jSONObject1.toString()).apply();
        }
        if(fetchedAppSettings0 != null) {
            String s3 = fetchedAppSettings0.getSdkUpdateMessage();
            if(!FetchedAppSettingsManager.printedSDKUpdatedMessage && s3 != null && s3.length() > 0) {
                FetchedAppSettingsManager.printedSDKUpdatedMessage = true;
                Log.w("FetchedAppSettingsManager", s3);
            }
        }
        FetchedAppGateKeepersManager.queryAppGateKeepers(s1, true);
        AutomaticAnalyticsLogger.logActivateAppEvent();
        FetchAppSettingState fetchedAppSettingsManager$FetchAppSettingState0 = FetchedAppSettingsManager.fetchedAppSettings.containsKey(s1) ? FetchAppSettingState.SUCCESS : FetchAppSettingState.ERROR;
        FetchedAppSettingsManager.loadingState.set(fetchedAppSettingsManager$FetchAppSettingState0);
        fetchedAppSettingsManager0.pollCallbacks();
    }

    @NotNull
    public final FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release(@NotNull String s, @NotNull JSONObject jSONObject0) {
        q.g(s, "applicationId");
        q.g(jSONObject0, "settingsJSON");
        JSONArray jSONArray0 = jSONObject0.optJSONArray("android_sdk_error_categories");
        Companion facebookRequestErrorClassification$Companion0 = FacebookRequestErrorClassification.Companion;
        FacebookRequestErrorClassification facebookRequestErrorClassification0 = facebookRequestErrorClassification$Companion0.createFromJSON(jSONArray0);
        if(facebookRequestErrorClassification0 == null) {
            facebookRequestErrorClassification0 = facebookRequestErrorClassification$Companion0.getDefaultErrorClassification();
        }
        int v = jSONObject0.optInt("app_events_feature_bitmask", 0);
        JSONArray jSONArray1 = jSONObject0.optJSONArray("auto_event_mapping_android");
        FetchedAppSettingsManager.unityEventBindings = jSONArray1;
        if(jSONArray1 != null && InternalSettings.isUnityApp()) {
            UnityReflection.sendEventMapping(jSONArray1.toString());
        }
        JSONObject jSONObject1 = jSONObject0.optJSONObject("app_events_config");
        boolean z = jSONObject0.optBoolean("supports_implicit_sdk_logging", false);
        String s1 = jSONObject0.optString("gdpv4_nux_content", "");
        q.f(s1, "settingsJSON.optString(A…_SETTING_NUX_CONTENT, \"\")");
        boolean z1 = jSONObject0.optBoolean("gdpv4_nux_enabled", false);
        int v1 = jSONObject0.optInt("app_events_session_timeout", 60);
        long v2 = jSONObject0.optLong("seamless_login");
        EnumSet enumSet0 = SmartLoginOption.Companion.parseOptions(v2);
        Map map0 = this.parseDialogConfigurations(jSONObject0.optJSONObject("android_dialog_configs"));
        String s2 = jSONObject0.optString("smart_login_bookmark_icon_url");
        q.f(s2, "settingsJSON.optString(S…_LOGIN_BOOKMARK_ICON_URL)");
        String s3 = jSONObject0.optString("smart_login_menu_icon_url");
        q.f(s3, "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)");
        String s4 = jSONObject0.optString("sdk_update_message");
        q.f(s4, "settingsJSON.optString(SDK_UPDATE_MESSAGE)");
        FetchedAppSettings fetchedAppSettings0 = new FetchedAppSettings(z, s1, z1, v1, enumSet0, map0, (v & 8) != 0, facebookRequestErrorClassification0, s2, s3, (v & 16) != 0, (v & 0x20) != 0, jSONArray1, s4, (v & 0x100) != 0, (v & 0x4000) != 0, jSONObject0.optString("aam_rules"), jSONObject0.optString("suggested_events_setting"), jSONObject0.optString("restrictive_data_filter_params"), this.parseProtectedModeRules(jSONObject0.optJSONObject("protected_mode_rules"), "standard_params"), this.parseProtectedModeRules(jSONObject0.optJSONObject("protected_mode_rules"), "maca_rules"), this.parseMigratedAutoLogValues(jSONObject0), this.parseProtectedModeRules(jSONObject0.optJSONObject("protected_mode_rules"), "blocklist_events"), this.parseProtectedModeRules(jSONObject0.optJSONObject("protected_mode_rules"), "redacted_events"), this.parseProtectedModeRules(jSONObject0.optJSONObject("protected_mode_rules"), "sensitive_params"), this.parseProtectedModeRules(jSONObject0.optJSONObject("protected_mode_rules"), "standard_params_schema"), this.parseProtectedModeRules(jSONObject0.optJSONObject("protected_mode_rules"), "standard_params_blocked"), this.parseCurrencyAndValueDedupeParameters(jSONObject1, "fb_currency"), this.parseCurrencyAndValueDedupeParameters(jSONObject1, "_valueToSum"), FetchedAppSettingsManager.parseDedupeParameters$default(this, jSONObject1, false, 2, null), this.parseDedupeParameters(jSONObject1, true), this.parseDedupeWindow(jSONObject0.optJSONObject("app_events_config")));
        FetchedAppSettingsManager.fetchedAppSettings.put(s, fetchedAppSettings0);
        return fetchedAppSettings0;
    }

    private final List parseCurrencyAndValueDedupeParameters(JSONObject jSONObject0, String s) {
        try {
            JSONArray jSONArray0 = jSONObject0 == null ? null : jSONObject0.getJSONArray("iap_manual_and_auto_log_dedup_keys");
            if(jSONArray0 == null) {
                return null;
            }
            int v = jSONArray0.length();
            for(int v2 = 0; v2 < v; ++v2) {
                JSONObject jSONObject1 = jSONArray0.getJSONObject(v2);
                if(q.b(jSONObject1.getString("key"), "prod_keys")) {
                    JSONArray jSONArray1 = jSONObject1.getJSONArray("value");
                    int v3 = jSONArray1.length();
                    for(int v4 = 0; v4 < v3; ++v4) {
                        JSONObject jSONObject2 = jSONArray1.getJSONObject(v4);
                        if(q.b(jSONObject2.getString("key"), s)) {
                            JSONArray jSONArray2 = jSONObject2.getJSONArray("value");
                            ArrayList arrayList0 = new ArrayList();
                            int v5 = jSONArray2.length();
                            for(int v1 = 0; v1 < v5; ++v1) {
                                arrayList0.add(jSONArray2.getJSONObject(v1).getString("value"));
                            }
                            List list0 = new ArrayList();
                            ((ArrayList)list0).addAll(arrayList0);
                            return list0;
                        }
                    }
                }
            }
        }
        catch(Exception unused_ex) {
        }
        return null;
    }

    private final ArrayList parseDedupeParameters(JSONObject jSONObject0, boolean z) {
        try {
            JSONArray jSONArray0 = jSONObject0 == null ? null : jSONObject0.getJSONArray("iap_manual_and_auto_log_dedup_keys");
            if(jSONArray0 == null) {
                return null;
            }
            int v = jSONArray0.length();
            ArrayList arrayList0 = null;
            for(int v1 = 0; v1 < v; ++v1) {
                JSONObject jSONObject1 = jSONArray0.getJSONObject(v1);
                String s = jSONObject1.getString("key");
                if((!q.b(s, "prod_keys") || !z) && (!q.b(s, "test_keys") || z)) {
                    JSONArray jSONArray1 = jSONObject1.getJSONArray("value");
                    int v2 = jSONArray1.length();
                    for(int v3 = 0; v3 < v2; ++v3) {
                        JSONObject jSONObject2 = jSONArray1.getJSONObject(v3);
                        String s1 = jSONObject2.getString("key");
                        if(!q.b(s1, "_valueToSum") && !q.b(s1, "fb_currency")) {
                            JSONArray jSONArray2 = jSONObject2.getJSONArray("value");
                            ArrayList arrayList1 = new ArrayList();
                            int v4 = jSONArray2.length();
                            for(int v5 = 0; v5 < v4; ++v5) {
                                arrayList1.add(jSONArray2.getJSONObject(v5).getString("value"));
                            }
                            if(arrayList0 == null) {
                                arrayList0 = new ArrayList();
                            }
                            arrayList0.add(new m(s1, arrayList1));
                        }
                    }
                }
            }
            return arrayList0;
        }
        catch(Exception unused_ex) {
            return null;
        }
    }

    public static ArrayList parseDedupeParameters$default(FetchedAppSettingsManager fetchedAppSettingsManager0, JSONObject jSONObject0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return fetchedAppSettingsManager0.parseDedupeParameters(jSONObject0, z);
    }

    private final Long parseDedupeWindow(JSONObject jSONObject0) {
        if(jSONObject0 != null) {
            try {
                return jSONObject0.optLong("iap_manual_and_auto_log_dedup_window_millis");
            }
            catch(Exception unused_ex) {
            }
        }
        return null;
    }

    private final Map parseDialogConfigurations(JSONObject jSONObject0) {
        Map map0 = new HashMap();
        if(jSONObject0 != null) {
            JSONArray jSONArray0 = jSONObject0.optJSONArray("data");
            if(jSONArray0 != null) {
                int v = jSONArray0.length();
                for(int v1 = 0; v1 < v; ++v1) {
                    JSONObject jSONObject1 = jSONArray0.optJSONObject(v1);
                    q.f(jSONObject1, "dialogConfigData.optJSONObject(i)");
                    DialogFeatureConfig fetchedAppSettings$DialogFeatureConfig0 = DialogFeatureConfig.Companion.parseDialogConfig(jSONObject1);
                    if(fetchedAppSettings$DialogFeatureConfig0 != null) {
                        String s = fetchedAppSettings$DialogFeatureConfig0.getDialogName();
                        Map map1 = (Map)((HashMap)map0).get(s);
                        if(map1 == null) {
                            map1 = new HashMap();
                            map0.put(s, map1);
                        }
                        map1.put(fetchedAppSettings$DialogFeatureConfig0.getFeatureName(), fetchedAppSettings$DialogFeatureConfig0);
                    }
                }
            }
        }
        return map0;
    }

    private final Map parseMigratedAutoLogValues(JSONObject jSONObject0) {
        if(jSONObject0 == null) {
            return null;
        }
        HashMap hashMap0 = new HashMap();
        if(!jSONObject0.isNull("auto_log_app_events_default")) {
            try {
                hashMap0.put("auto_log_app_events_default", Boolean.valueOf(jSONObject0.getBoolean("auto_log_app_events_default")));
            }
            catch(JSONException jSONException0) {
                Utility.logd("FacebookSDK", jSONException0);
            }
        }
        if(!jSONObject0.isNull("auto_log_app_events_enabled")) {
            try {
                hashMap0.put("auto_log_app_events_enabled", Boolean.valueOf(jSONObject0.getBoolean("auto_log_app_events_enabled")));
            }
            catch(JSONException jSONException1) {
                Utility.logd("FacebookSDK", jSONException1);
            }
        }
        return !hashMap0.isEmpty() ? hashMap0 : null;
    }

    private final JSONArray parseProtectedModeRules(JSONObject jSONObject0, String s) {
        return jSONObject0 == null ? null : jSONObject0.optJSONArray(s);
    }

    private final void pollCallbacks() {
        synchronized(this) {
            FetchAppSettingState fetchedAppSettingsManager$FetchAppSettingState0 = (FetchAppSettingState)FetchedAppSettingsManager.loadingState.get();
            if(FetchAppSettingState.NOT_LOADED != fetchedAppSettingsManager$FetchAppSettingState0 && FetchAppSettingState.LOADING != fetchedAppSettingsManager$FetchAppSettingState0) {
                String s = FacebookSdk.getApplicationId();
                FetchedAppSettings fetchedAppSettings0 = (FetchedAppSettings)FetchedAppSettingsManager.fetchedAppSettings.get(s);
                Handler handler0 = new Handler(Looper.getMainLooper());
                if(FetchAppSettingState.ERROR == fetchedAppSettingsManager$FetchAppSettingState0) {
                    while(true) {
                        ConcurrentLinkedQueue concurrentLinkedQueue0 = FetchedAppSettingsManager.fetchedAppSettingsCallbacks;
                        if(concurrentLinkedQueue0.isEmpty()) {
                            break;
                        }
                        handler0.post(new c(((FetchedAppSettingsCallback)concurrentLinkedQueue0.poll()), 7));
                    }
                    return;
                }
                while(true) {
                    ConcurrentLinkedQueue concurrentLinkedQueue1 = FetchedAppSettingsManager.fetchedAppSettingsCallbacks;
                    if(concurrentLinkedQueue1.isEmpty()) {
                        break;
                    }
                    handler0.post(new h(1, ((FetchedAppSettingsCallback)concurrentLinkedQueue1.poll()), fetchedAppSettings0));
                }
            }
        }
    }

    private static final void pollCallbacks$lambda$1(FetchedAppSettingsCallback fetchedAppSettingsManager$FetchedAppSettingsCallback0) {
        fetchedAppSettingsManager$FetchedAppSettingsCallback0.onError();
    }

    private static final void pollCallbacks$lambda$2(FetchedAppSettingsCallback fetchedAppSettingsManager$FetchedAppSettingsCallback0, FetchedAppSettings fetchedAppSettings0) {
        fetchedAppSettingsManager$FetchedAppSettingsCallback0.onSuccess(fetchedAppSettings0);
    }

    @Nullable
    public static final FetchedAppSettings queryAppSettings(@NotNull String s, boolean z) {
        q.g(s, "applicationId");
        if(!z) {
            Map map0 = FetchedAppSettingsManager.fetchedAppSettings;
            if(map0.containsKey(s)) {
                return (FetchedAppSettings)map0.get(s);
            }
        }
        FetchedAppSettingsManager fetchedAppSettingsManager0 = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings fetchedAppSettings0 = fetchedAppSettingsManager0.parseAppSettingsFromJSON$facebook_core_release(s, fetchedAppSettingsManager0.getAppSettingsQueryResponse(s));
        if(s.equals(FacebookSdk.getApplicationId())) {
            FetchedAppSettingsManager.loadingState.set(FetchAppSettingState.SUCCESS);
            fetchedAppSettingsManager0.pollCallbacks();
        }
        return fetchedAppSettings0;
    }

    public static final void setIsUnityInit(boolean z) {
        FetchedAppSettingsManager.isUnityInit = z;
        JSONArray jSONArray0 = FetchedAppSettingsManager.unityEventBindings;
        if(jSONArray0 != null && z) {
            UnityReflection.sendEventMapping(String.valueOf(jSONArray0));
        }
    }
}

