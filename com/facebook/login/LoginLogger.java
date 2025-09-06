package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 12\u00020\u0001:\u00011B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ#\u0010\u000F\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\f2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0010Jc\u0010\u0018\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u00042\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0014\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00112\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001C\u001A\u00020\t2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00042\b\u0010\u001B\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u001C\u0010\u001DJg\u0010 \u001A\u00020\t2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00042\b\u0010\u001B\u001A\u0004\u0018\u00010\u00042\b\u0010\u0014\u001A\u0004\u0018\u00010\u00042\b\u0010\u001E\u001A\u0004\u0018\u00010\u00042\b\u0010\u001F\u001A\u0004\u0018\u00010\u00042\u0018\u0010\u0012\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b \u0010!J/\u0010\"\u001A\u00020\t2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00042\b\u0010\u001B\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\"\u0010\u001DJ\u0017\u0010$\u001A\u00020\t2\b\u0010#\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b$\u0010\u000BJ\u0017\u0010%\u001A\u00020\t2\b\u0010#\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b%\u0010\u000BJ\u0017\u0010&\u001A\u00020\t2\b\u0010#\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b&\u0010\u000BJ\u001F\u0010\'\u001A\u00020\t2\b\u0010#\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b\'\u0010(J/\u0010)\u001A\u00020\t2\b\u0010\u000E\u001A\u0004\u0018\u00010\u00042\b\u0010\u001E\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b)\u0010\u001DR\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010*\u001A\u0004\b+\u0010,R\u0014\u0010.\u001A\u00020-8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u0010*\u00A8\u00062"}, d2 = {"Lcom/facebook/login/LoginLogger;", "", "Landroid/content/Context;", "context", "", "applicationId", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "loginRequestId", "Lie/H;", "logHeartbeatEvent", "(Ljava/lang/String;)V", "Lcom/facebook/login/LoginClient$Request;", "pendingLoginRequest", "eventName", "logStartLogin", "(Lcom/facebook/login/LoginClient$Request;Ljava/lang/String;)V", "", "loggingExtras", "Lcom/facebook/login/LoginClient$Result$Code;", "result", "resultExtras", "Ljava/lang/Exception;", "exception", "logCompleteLogin", "(Ljava/lang/String;Ljava/util/Map;Lcom/facebook/login/LoginClient$Result$Code;Ljava/util/Map;Ljava/lang/Exception;Ljava/lang/String;)V", "authId", "method", "logAuthorizationMethodStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "errorMessage", "errorCode", "logAuthorizationMethodComplete", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "logAuthorizationMethodNotTried", "loggerRef", "logLoginStatusStart", "logLoginStatusSuccess", "logLoginStatusFailure", "logLoginStatusError", "(Ljava/lang/String;Ljava/lang/Exception;)V", "logUnexpectedError", "Ljava/lang/String;", "getApplicationId", "()Ljava/lang/String;", "Lcom/facebook/appevents/InternalAppEventsLogger;", "logger", "Lcom/facebook/appevents/InternalAppEventsLogger;", "facebookVersion", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class LoginLogger {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00A2\u0006\u0002\u0010\u0002J\u0012\u0010+\u001A\u00020,2\b\u0010-\u001A\u0004\u0018\u00010\u0004H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u0016\u0010(\u001A\n **\u0004\u0018\u00010)0)X\u0082\u0004\u00A2\u0006\u0002\n\u0000\u00A8\u0006."}, d2 = {"Lcom/facebook/login/LoginLogger$Companion;", "", "()V", "EVENT_EXTRAS_DEFAULT_AUDIENCE", "", "EVENT_EXTRAS_FACEBOOK_VERSION", "EVENT_EXTRAS_FAILURE", "EVENT_EXTRAS_IS_REAUTHORIZE", "EVENT_EXTRAS_LOGIN_BEHAVIOR", "EVENT_EXTRAS_MISSING_INTERNET_PERMISSION", "EVENT_EXTRAS_NEW_PERMISSIONS", "EVENT_EXTRAS_NOT_TRIED", "EVENT_EXTRAS_PERMISSIONS", "EVENT_EXTRAS_REQUEST_CODE", "EVENT_EXTRAS_TARGET_APP", "EVENT_EXTRAS_TRY_LOGIN_ACTIVITY", "EVENT_NAME_FOA_LOGIN_COMPLETE", "EVENT_NAME_FOA_LOGIN_METHOD_COMPLETE", "EVENT_NAME_FOA_LOGIN_METHOD_NOT_TRIED", "EVENT_NAME_FOA_LOGIN_METHOD_START", "EVENT_NAME_FOA_LOGIN_START", "EVENT_NAME_LOGIN_COMPLETE", "EVENT_NAME_LOGIN_HEARTBEAT", "EVENT_NAME_LOGIN_METHOD_COMPLETE", "EVENT_NAME_LOGIN_METHOD_NOT_TRIED", "EVENT_NAME_LOGIN_METHOD_START", "EVENT_NAME_LOGIN_START", "EVENT_NAME_LOGIN_STATUS_COMPLETE", "EVENT_NAME_LOGIN_STATUS_START", "EVENT_PARAM_AUTH_LOGGER_ID", "EVENT_PARAM_CHALLENGE", "EVENT_PARAM_ERROR_CODE", "EVENT_PARAM_ERROR_MESSAGE", "EVENT_PARAM_EXTRAS", "EVENT_PARAM_FOA_METHOD_RESULT_SKIPPED", "EVENT_PARAM_LOGIN_RESULT", "EVENT_PARAM_METHOD", "EVENT_PARAM_METHOD_RESULT_SKIPPED", "EVENT_PARAM_TIMESTAMP", "FACEBOOK_PACKAGE_NAME", "worker", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "newAuthorizationLoggingBundle", "Landroid/os/Bundle;", "authLoggerId", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final Bundle access$newAuthorizationLoggingBundle(Companion loginLogger$Companion0, String s) {
            return loginLogger$Companion0.newAuthorizationLoggingBundle(s);
        }

        private final Bundle newAuthorizationLoggingBundle(String s) {
            Bundle bundle0 = new Bundle();
            bundle0.putLong("1_timestamp_ms", System.currentTimeMillis());
            bundle0.putString("0_auth_logger_id", s);
            bundle0.putString("3_method", "");
            bundle0.putString("2_result", "");
            bundle0.putString("5_error_message", "");
            bundle0.putString("4_error_code", "");
            bundle0.putString("6_extras", "");
            return bundle0;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";
    @NotNull
    public static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";
    @NotNull
    public static final String EVENT_EXTRAS_FAILURE = "failure";
    @NotNull
    public static final String EVENT_EXTRAS_IS_REAUTHORIZE = "isReauthorize";
    @NotNull
    public static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";
    @NotNull
    public static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";
    @NotNull
    public static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";
    @NotNull
    public static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";
    @NotNull
    public static final String EVENT_EXTRAS_PERMISSIONS = "permissions";
    @NotNull
    public static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
    @NotNull
    public static final String EVENT_EXTRAS_TARGET_APP = "target_app";
    @NotNull
    public static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";
    @NotNull
    public static final String EVENT_NAME_FOA_LOGIN_COMPLETE = "foa_mobile_login_complete";
    @NotNull
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_COMPLETE = "foa_mobile_login_method_complete";
    @NotNull
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_NOT_TRIED = "foa_mobile_login_method_not_tried";
    @NotNull
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_START = "foa_mobile_login_method_start";
    @NotNull
    public static final String EVENT_NAME_FOA_LOGIN_START = "foa_mobile_login_start";
    @NotNull
    public static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";
    @NotNull
    public static final String EVENT_NAME_LOGIN_HEARTBEAT = "fb_mobile_login_heartbeat";
    @NotNull
    public static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";
    @NotNull
    public static final String EVENT_NAME_LOGIN_METHOD_NOT_TRIED = "fb_mobile_login_method_not_tried";
    @NotNull
    public static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";
    @NotNull
    public static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";
    @NotNull
    public static final String EVENT_NAME_LOGIN_STATUS_COMPLETE = "fb_mobile_login_status_complete";
    @NotNull
    public static final String EVENT_NAME_LOGIN_STATUS_START = "fb_mobile_login_status_start";
    @NotNull
    public static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
    @NotNull
    public static final String EVENT_PARAM_CHALLENGE = "7_challenge";
    @NotNull
    public static final String EVENT_PARAM_ERROR_CODE = "4_error_code";
    @NotNull
    public static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";
    @NotNull
    public static final String EVENT_PARAM_EXTRAS = "6_extras";
    @NotNull
    public static final String EVENT_PARAM_FOA_METHOD_RESULT_SKIPPED = "foa_skipped";
    @NotNull
    public static final String EVENT_PARAM_LOGIN_RESULT = "2_result";
    @NotNull
    public static final String EVENT_PARAM_METHOD = "3_method";
    @NotNull
    public static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";
    @NotNull
    public static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
    @NotNull
    public static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    @NotNull
    private final String applicationId;
    @Nullable
    private String facebookVersion;
    @NotNull
    private final InternalAppEventsLogger logger;
    private static final ScheduledExecutorService worker;

    static {
        LoginLogger.Companion = new Companion(null);
        LoginLogger.worker = Executors.newSingleThreadScheduledExecutor();
    }

    public LoginLogger(@NotNull Context context0, @NotNull String s) {
        q.g(context0, "context");
        q.g(s, "applicationId");
        super();
        this.applicationId = s;
        this.logger = new InternalAppEventsLogger(context0, s);
        try {
            PackageManager packageManager0 = context0.getPackageManager();
            if(packageManager0 != null) {
                PackageInfo packageInfo0 = packageManager0.getPackageInfo("com.facebook.katana", 0);
                if(packageInfo0 != null) {
                    this.facebookVersion = packageInfo0.versionName;
                }
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final String getApplicationId() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.applicationId;
    }

    public final void logAuthorizationMethodComplete(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable Map map0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            LoginLogger.logAuthorizationMethodComplete$default(this, s, s1, s2, s3, s4, map0, null, 0x40, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logAuthorizationMethodComplete(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable Map map0, @Nullable String s5) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle bundle0 = Companion.access$newAuthorizationLoggingBundle(LoginLogger.Companion, s);
            if(s2 != null) {
                bundle0.putString("2_result", s2);
            }
            if(s3 != null) {
                bundle0.putString("5_error_message", s3);
            }
            if(s4 != null) {
                bundle0.putString("4_error_code", s4);
            }
            if(map0 != null && !map0.isEmpty()) {
                LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                for(Object object0: map0.entrySet()) {
                    Map.Entry map$Entry0 = (Map.Entry)object0;
                    if(((String)map$Entry0.getKey()) != null) {
                        linkedHashMap0.put(map$Entry0.getKey(), map$Entry0.getValue());
                    }
                }
                bundle0.putString("6_extras", new JSONObject(linkedHashMap0).toString());
            }
            bundle0.putString("3_method", s1);
            this.logger.logEventImplicitly(s5, bundle0);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public static void logAuthorizationMethodComplete$default(LoginLogger loginLogger0, String s, String s1, String s2, String s3, String s4, Map map0, String s5, int v, Object object0) {
        Class class0 = LoginLogger.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            if((v & 0x40) != 0) {
                s5 = "fb_mobile_login_method_complete";
            }
            loginLogger0.logAuthorizationMethodComplete(s, s1, s2, s3, s4, map0, s5);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public final void logAuthorizationMethodNotTried(@Nullable String s, @Nullable String s1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            LoginLogger.logAuthorizationMethodNotTried$default(this, s, s1, null, 4, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logAuthorizationMethodNotTried(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle bundle0 = Companion.access$newAuthorizationLoggingBundle(LoginLogger.Companion, s);
            bundle0.putString("3_method", s1);
            this.logger.logEventImplicitly(s2, bundle0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public static void logAuthorizationMethodNotTried$default(LoginLogger loginLogger0, String s, String s1, String s2, int v, Object object0) {
        Class class0 = LoginLogger.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            if((v & 4) != 0) {
                s2 = "fb_mobile_login_method_not_tried";
            }
            loginLogger0.logAuthorizationMethodNotTried(s, s1, s2);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public final void logAuthorizationMethodStart(@Nullable String s, @Nullable String s1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            LoginLogger.logAuthorizationMethodStart$default(this, s, s1, null, 4, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logAuthorizationMethodStart(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle bundle0 = Companion.access$newAuthorizationLoggingBundle(LoginLogger.Companion, s);
            bundle0.putString("3_method", s1);
            this.logger.logEventImplicitly(s2, bundle0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public static void logAuthorizationMethodStart$default(LoginLogger loginLogger0, String s, String s1, String s2, int v, Object object0) {
        Class class0 = LoginLogger.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            if((v & 4) != 0) {
                s2 = "fb_mobile_login_method_start";
            }
            loginLogger0.logAuthorizationMethodStart(s, s1, s2);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public final void logCompleteLogin(@Nullable String s, @NotNull Map map0, @Nullable Code loginClient$Result$Code0, @Nullable Map map1, @Nullable Exception exception0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(map0, "loggingExtras");
            LoginLogger.logCompleteLogin$default(this, s, map0, loginClient$Result$Code0, map1, exception0, null, 0x20, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logCompleteLogin(@Nullable String s, @NotNull Map map0, @Nullable Code loginClient$Result$Code0, @Nullable Map map1, @Nullable Exception exception0, @Nullable String s1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                q.g(map0, "loggingExtras");
                Bundle bundle0 = Companion.access$newAuthorizationLoggingBundle(LoginLogger.Companion, s);
                if(loginClient$Result$Code0 != null) {
                    bundle0.putString("2_result", loginClient$Result$Code0.getLoggingValue());
                }
                JSONObject jSONObject0 = null;
                if((exception0 == null ? null : exception0.getMessage()) != null) {
                    bundle0.putString("5_error_message", exception0.getMessage());
                }
                if(!map0.isEmpty()) {
                    jSONObject0 = new JSONObject(map0);
                }
                if(map1 != null) {
                    if(jSONObject0 == null) {
                        jSONObject0 = new JSONObject();
                    }
                    try {
                        for(Object object0: map1.entrySet()) {
                            String s2 = (String)((Map.Entry)object0).getKey();
                            String s3 = (String)((Map.Entry)object0).getValue();
                            if(s2 != null) {
                                jSONObject0.put(s2, s3);
                            }
                        }
                    }
                    catch(JSONException unused_ex) {
                    }
                }
                if(jSONObject0 != null) {
                    bundle0.putString("6_extras", jSONObject0.toString());
                }
                this.logger.logEventImplicitly(s1, bundle0);
                if(loginClient$Result$Code0 == Code.SUCCESS) {
                    this.logHeartbeatEvent(s);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public static void logCompleteLogin$default(LoginLogger loginLogger0, String s, Map map0, Code loginClient$Result$Code0, Map map1, Exception exception0, String s1, int v, Object object0) {
        Class class0 = LoginLogger.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            if((v & 0x20) != 0) {
                s1 = "fb_mobile_login_complete";
            }
            loginLogger0.logCompleteLogin(s, map0, loginClient$Result$Code0, map1, exception0, s1);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private final void logHeartbeatEvent(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            d d0 = new d(this, Companion.access$newAuthorizationLoggingBundle(LoginLogger.Companion, s));
            LoginLogger.worker.schedule(d0, 5L, TimeUnit.SECONDS);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final void logHeartbeatEvent$lambda$0(LoginLogger loginLogger0, Bundle bundle0) {
        Class class0 = LoginLogger.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(loginLogger0, "this$0");
            q.g(bundle0, "$bundle");
            loginLogger0.logger.logEventImplicitly("fb_mobile_login_heartbeat", bundle0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public final void logLoginStatusError(@Nullable String s, @NotNull Exception exception0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(exception0, "exception");
            Bundle bundle0 = Companion.access$newAuthorizationLoggingBundle(LoginLogger.Companion, s);
            bundle0.putString("2_result", "error");
            bundle0.putString("5_error_message", exception0.toString());
            this.logger.logEventImplicitly("fb_mobile_login_status_complete", bundle0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logLoginStatusFailure(@Nullable String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle bundle0 = Companion.access$newAuthorizationLoggingBundle(LoginLogger.Companion, s);
            bundle0.putString("2_result", "failure");
            this.logger.logEventImplicitly("fb_mobile_login_status_complete", bundle0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logLoginStatusStart(@Nullable String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle bundle0 = Companion.access$newAuthorizationLoggingBundle(LoginLogger.Companion, s);
            this.logger.logEventImplicitly("fb_mobile_login_status_start", bundle0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logLoginStatusSuccess(@Nullable String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle bundle0 = Companion.access$newAuthorizationLoggingBundle(LoginLogger.Companion, s);
            bundle0.putString("2_result", "success");
            this.logger.logEventImplicitly("fb_mobile_login_status_complete", bundle0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logStartLogin(@NotNull Request loginClient$Request0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(loginClient$Request0, "pendingLoginRequest");
            LoginLogger.logStartLogin$default(this, loginClient$Request0, null, 2, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logStartLogin(@NotNull Request loginClient$Request0, @Nullable String s) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                q.g(loginClient$Request0, "pendingLoginRequest");
                Bundle bundle0 = Companion.access$newAuthorizationLoggingBundle(LoginLogger.Companion, loginClient$Request0.getAuthId());
                try {
                    JSONObject jSONObject0 = new JSONObject();
                    jSONObject0.put("login_behavior", loginClient$Request0.getLoginBehavior().toString());
                    jSONObject0.put("request_code", LoginClient.Companion.getLoginRequestCode());
                    jSONObject0.put("permissions", TextUtils.join(",", loginClient$Request0.getPermissions()));
                    jSONObject0.put("default_audience", loginClient$Request0.getDefaultAudience().toString());
                    jSONObject0.put("isReauthorize", loginClient$Request0.isRerequest());
                    String s1 = this.facebookVersion;
                    if(s1 != null) {
                        jSONObject0.put("facebookVersion", s1);
                    }
                    if(loginClient$Request0.getLoginTargetApp() != null) {
                        jSONObject0.put("target_app", loginClient$Request0.getLoginTargetApp().toString());
                    }
                    bundle0.putString("6_extras", jSONObject0.toString());
                }
                catch(JSONException unused_ex) {
                }
                this.logger.logEventImplicitly(s, bundle0);
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public static void logStartLogin$default(LoginLogger loginLogger0, Request loginClient$Request0, String s, int v, Object object0) {
        Class class0 = LoginLogger.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            if((v & 2) != 0) {
                s = "fb_mobile_login_start";
            }
            loginLogger0.logStartLogin(loginClient$Request0, s);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public final void logUnexpectedError(@Nullable String s, @Nullable String s1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            LoginLogger.logUnexpectedError$default(this, s, s1, null, 4, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logUnexpectedError(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle bundle0 = Companion.access$newAuthorizationLoggingBundle(LoginLogger.Companion, "");
            bundle0.putString("2_result", "error");
            bundle0.putString("5_error_message", s1);
            bundle0.putString("3_method", s2);
            this.logger.logEventImplicitly(s, bundle0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public static void logUnexpectedError$default(LoginLogger loginLogger0, String s, String s1, String s2, int v, Object object0) {
        Class class0 = LoginLogger.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            if((v & 4) != 0) {
                s2 = "";
            }
            loginLogger0.logUnexpectedError(s, s1, s2);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }
}

