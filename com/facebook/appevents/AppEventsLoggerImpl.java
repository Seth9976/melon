package com.facebook.appevents;

import A5.a;
import Tf.o;
import Tf.v;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import b.l;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.gps.ara.GpsAraTriggersManager;
import com.facebook.appevents.gps.pa.PACustomAudienceClient;
import com.facebook.appevents.iap.InAppPurchase;
import com.facebook.appevents.iap.InAppPurchaseDedupeConfig;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.integrity.BannedParamManager;
import com.facebook.appevents.integrity.BlocklistEventsManager;
import com.facebook.appevents.integrity.MACARuleMatchingManager;
import com.facebook.appevents.integrity.ProtectedModeManager;
import com.facebook.appevents.integrity.SensitiveParamsManager;
import com.facebook.appevents.integrity.StdParamsEnforcementManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InstallReferrerUtil.Callback;
import com.facebook.internal.InstallReferrerUtil;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import e.k;
import ie.m;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 M2\u00020\u0001:\u0001MB%\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b\u0007\u0010\bB\'\b\u0010\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b\u0007\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ#\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b\u000E\u0010\u0012J\u001F\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001A\u00020\u0013\u00A2\u0006\u0004\b\u000E\u0010\u0015J)\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b\u000E\u0010\u0016J!\u0010\u0018\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u00022\b\u0010\u0017\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001E\u001A\u00020\r2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\b\u001E\u0010\u001FJ-\u0010\u001E\u001A\u00020\r2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b\u001E\u0010 J7\u0010#\u001A\u00020\r2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010!\u00A2\u0006\u0004\b#\u0010$J?\u0010\u001E\u001A\u00020\r2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010&\u001A\u00020%2\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010!\u00A2\u0006\u0004\b\u001E\u0010\'J\u001F\u0010*\u001A\u00020\r2\u0006\u0010(\u001A\u00020\u00102\b\u0010)\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b*\u0010+J\u008F\u0001\u00109\u001A\u00020\r2\b\u0010,\u001A\u0004\u0018\u00010\u00022\b\u0010.\u001A\u0004\u0018\u00010-2\b\u00100\u001A\u0004\u0018\u00010/2\b\u00101\u001A\u0004\u0018\u00010\u00022\b\u00102\u001A\u0004\u0018\u00010\u00022\b\u00103\u001A\u0004\u0018\u00010\u00022\b\u00104\u001A\u0004\u0018\u00010\u00022\b\u00105\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\b\u00106\u001A\u0004\u0018\u00010\u00022\b\u00107\u001A\u0004\u0018\u00010\u00022\b\u00108\u001A\u0004\u0018\u00010\u00022\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b9\u0010:J\r\u0010;\u001A\u00020\r\u00A2\u0006\u0004\b;\u0010<J\u0015\u0010=\u001A\u00020%2\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b=\u0010>J)\u0010?\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u00022\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b?\u0010@J+\u0010A\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u00022\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\bA\u0010@JA\u0010A\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u00022\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010!\u00A2\u0006\u0004\bA\u0010BJI\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u00022\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010&\u001A\u00020%2\b\u0010D\u001A\u0004\u0018\u00010C2\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010!\u00A2\u0006\u0004\b\u000E\u0010ER\u0014\u0010F\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001A\u00020H8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bI\u0010JR\u0011\u0010\u0004\u001A\u00020\u00028F\u00A2\u0006\u0006\u001A\u0004\bK\u0010L\u00A8\u0006N"}, d2 = {"Lcom/facebook/appevents/AppEventsLoggerImpl;", "", "", "activityName", "applicationId", "Lcom/facebook/AccessToken;", "accessToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "eventName", "Lie/H;", "logEvent", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "parameters", "(Ljava/lang/String;Landroid/os/Bundle;)V", "", "valueToSum", "(Ljava/lang/String;D)V", "(Ljava/lang/String;DLandroid/os/Bundle;)V", "buttonText", "logEventFromSE", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/math/BigDecimal;", "purchaseAmount", "Ljava/util/Currency;", "currency", "logPurchase", "(Ljava/math/BigDecimal;Ljava/util/Currency;)V", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;)V", "Lcom/facebook/appevents/OperationalData;", "operationalData", "logPurchaseImplicitly", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)V", "", "isImplicitlyLogged", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;ZLcom/facebook/appevents/OperationalData;)V", "payload", "action", "logPushNotificationOpen", "(Landroid/os/Bundle;Ljava/lang/String;)V", "itemID", "Lcom/facebook/appevents/AppEventsLogger$ProductAvailability;", "availability", "Lcom/facebook/appevents/AppEventsLogger$ProductCondition;", "condition", "description", "imageLink", "link", "title", "priceAmount", "gtin", "mpn", "brand", "logProductItem", "(Ljava/lang/String;Lcom/facebook/appevents/AppEventsLogger$ProductAvailability;Lcom/facebook/appevents/AppEventsLogger$ProductCondition;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/util/Currency;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "flush", "()V", "isValidForAccessToken", "(Lcom/facebook/AccessToken;)Z", "logSdkEvent", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;)V", "logEventImplicitly", "(Ljava/lang/String;Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)V", "Ljava/util/UUID;", "currentSessionId", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;ZLjava/util/UUID;Lcom/facebook/appevents/OperationalData;)V", "contextName", "Ljava/lang/String;", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "accessTokenAppId", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "getApplicationId", "()Ljava/lang/String;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppEventsLoggerImpl {
    @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u001F\u0010\n\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0007\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u0010H\u0007\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001A\u0004\u0018\u00010\fH\u0007\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001A\u00020\u00042\b\u0010\u0018\u001A\u0004\u0018\u00010\fH\u0007\u00A2\u0006\u0004\b\u0019\u0010\u000FJ!\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u001A2\b\u0010\u001C\u001A\u0004\u0018\u00010\fH\u0007\u00A2\u0006\u0004\b\u001D\u0010\u001EJ;\u0010&\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001F\u0012\u0006\u0012\u0004\u0018\u00010!0%2\b\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010\"\u001A\u0004\u0018\u00010!2\u0006\u0010$\u001A\u00020#H\u0007\u00A2\u0006\u0004\b&\u0010\'J\u0017\u0010)\u001A\u00020\u00042\u0006\u0010(\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b)\u0010\u000FJ!\u0010,\u001A\u00020\u00042\u0006\u0010+\u001A\u00020*2\b\u0010\u001C\u001A\u0004\u0018\u00010\fH\u0007\u00A2\u0006\u0004\b,\u0010-J\u000F\u0010.\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b.\u0010\u0003J\u0011\u0010/\u001A\u0004\u0018\u00010\fH\u0007\u00A2\u0006\u0004\b/\u0010\u0017J\u0019\u00101\u001A\u00020\u00042\b\u00100\u001A\u0004\u0018\u00010\fH\u0007\u00A2\u0006\u0004\b1\u0010\u000FJ!\u00104\u001A\u00020\u00042\u0006\u00103\u001A\u0002022\b\u0010+\u001A\u0004\u0018\u00010*H\u0007\u00A2\u0006\u0004\b4\u00105J\r\u00106\u001A\u00020\u0004\u00A2\u0006\u0004\b6\u0010\u0003J\u000F\u00108\u001A\u000207H\u0007\u00A2\u0006\u0004\b8\u00109J\u0017\u0010:\u001A\u00020\f2\u0006\u0010+\u001A\u00020*H\u0007\u00A2\u0006\u0004\b:\u0010;R\u0014\u0010<\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001A\u00020\f8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b>\u0010=R\u0014\u0010?\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b?\u0010=R\u0014\u0010@\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b@\u0010=R\u0014\u0010A\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bA\u0010=R\u0014\u0010B\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bB\u0010=R\u0014\u0010D\u001A\u00020C8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010F\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bF\u0010=R\u0014\u0010G\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bG\u0010=R\u0014\u0010H\u001A\u00020\f8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bH\u0010=R\u0018\u0010I\u001A\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bI\u0010=R\u0018\u0010K\u001A\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001A\u00020#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010Q\u001A\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010=R\u0014\u0010R\u001A\u00020\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bR\u0010S\u00A8\u0006T"}, d2 = {"Lcom/facebook/appevents/AppEventsLoggerImpl$Companion;", "", "<init>", "()V", "Lie/H;", "initializeTimersIfNeeded", "Lcom/facebook/appevents/AppEvent;", "event", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "accessTokenAppId", "logEvent", "(Lcom/facebook/appevents/AppEvent;Lcom/facebook/appevents/AccessTokenAppIdPair;)V", "", "message", "notifyDeveloperError", "(Ljava/lang/String;)V", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "getFlushBehavior", "()Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "flushBehavior", "setFlushBehavior", "(Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;)V", "getPushNotificationsRegistrationId", "()Ljava/lang/String;", "registrationId", "setPushNotificationsRegistrationId", "Landroid/app/Application;", "application", "applicationId", "activateApp", "(Landroid/app/Application;Ljava/lang/String;)V", "Landroid/os/Bundle;", "params", "Lcom/facebook/appevents/OperationalData;", "operationalData", "", "isImplicitlyLogged", "Lie/m;", "addImplicitPurchaseParameters", "(Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;Z)Lie/m;", "extraMsg", "functionDEPRECATED", "Landroid/content/Context;", "context", "initializeLib", "(Landroid/content/Context;Ljava/lang/String;)V", "onContextStop", "getInstallReferrer", "referrer", "setInstallReferrer", "Landroid/webkit/WebView;", "webView", "augmentWebView", "(Landroid/webkit/WebView;Landroid/content/Context;)V", "eagerFlush", "Ljava/util/concurrent/Executor;", "getAnalyticsExecutor", "()Ljava/util/concurrent/Executor;", "getAnonymousAppDeviceGUID", "(Landroid/content/Context;)Ljava/lang/String;", "ACCOUNT_KIT_EVENT_NAME_PREFIX", "Ljava/lang/String;", "APP_EVENTS_KILLSWITCH", "APP_EVENT_NAME_PUSH_OPENED", "APP_EVENT_PREFERENCES", "APP_EVENT_PUSH_PARAMETER_ACTION", "APP_EVENT_PUSH_PARAMETER_CAMPAIGN", "", "APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS", "I", "PUSH_PAYLOAD_CAMPAIGN_KEY", "PUSH_PAYLOAD_KEY", "TAG", "anonymousAppDeviceGUID", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "backgroundExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "flushBehaviorField", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "isActivateAppEventRequested", "Z", "pushNotificationsRegistrationIdField", "staticLock", "Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final void access$initializeTimersIfNeeded(Companion appEventsLoggerImpl$Companion0) {
            appEventsLoggerImpl$Companion0.initializeTimersIfNeeded();
        }

        public static final void access$notifyDeveloperError(Companion appEventsLoggerImpl$Companion0, String s) {
            appEventsLoggerImpl$Companion0.notifyDeveloperError(s);
        }

        public final void activateApp(@NotNull Application application0, @Nullable String s) {
            q.g(application0, "application");
            if(!FacebookSdk.isInitialized()) {
                throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
            }
            AnalyticsUserIDStore.initStore();
            UserDataStore.initStore();
            if(s == null) {
                s = FacebookSdk.getApplicationId();
            }
            FacebookSdk.publishInstallAsync(application0, s);
            ActivityLifecycleTracker.startTracking(application0, s);
            if(FeatureManager.isEnabled(Feature.GPSPACAProcessing)) {
                PACustomAudienceClient.INSTANCE.joinCustomAudience(s, "fb_mobile_app_install");
            }
            if(FeatureManager.isEnabled(Feature.GPSARATriggers)) {
                AppEvent appEvent0 = new AppEvent("unknown", "MOBILE_INSTALL_EVENT", null, null, false, ActivityLifecycleTracker.isInBackground(), ActivityLifecycleTracker.getCurrentSessionGuid(), null);
                GpsAraTriggersManager.INSTANCE.registerTriggerAsync(s, appEvent0);
            }
        }

        @NotNull
        public final m addImplicitPurchaseParameters(@Nullable Bundle bundle0, @Nullable OperationalData operationalData0, boolean z) {
            String s = AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled() ? "1" : "0";
            com.facebook.appevents.OperationalData.Companion operationalData$Companion0 = OperationalData.Companion;
            m m0 = OperationalData.Companion.addParameterAndReturn(OperationalDataEnum.IAPParameters, "is_implicit_purchase_logging_enabled", s, bundle0, operationalData0);
            OperationalDataEnum operationalDataEnum0 = OperationalDataEnum.IAPParameters;
            Object object0 = OperationalData.Companion.getParameter(operationalDataEnum0, "fb_iap_product_id", bundle0, operationalData0);
            String s1 = null;
            String s2 = object0 instanceof String ? ((String)object0) : null;
            if(!z) {
                if(bundle0 != null) {
                    s1 = bundle0.getString("fb_content_id");
                }
                if(s1 == null && s2 != null) {
                    m m1 = operationalData$Companion0.addParameterAndReturn(operationalDataEnum0, "fb_content_id", s2, bundle0, operationalData0);
                    m0 = operationalData$Companion0.addParameterAndReturn(operationalDataEnum0, "android_dynamic_ads_content_id", "client_manual", ((Bundle)m1.a), ((OperationalData)m1.b));
                }
            }
            m m2 = operationalData$Companion0.addParameterAndReturn(operationalDataEnum0, "is_autolog_app_events_enabled", (UserSettingsManager.getAutoLogAppEventsEnabled() ? "1" : "0"), ((Bundle)m0.a), ((OperationalData)m0.b));
            return new m(((Bundle)m2.a), ((OperationalData)m2.b));
        }

        public final void augmentWebView(@NotNull WebView webView0, @Nullable Context context0) {
            q.g(webView0, "webView");
            String s = Build.VERSION.RELEASE;
            q.f(s, "RELEASE");
            int v = 0;
            String[] arr_s = (String[])o.R0(s, new String[]{"."}, 0, 6).toArray(new String[0]);
            int v1 = arr_s.length == 0 ? 0 : Integer.parseInt(arr_s[0]);
            if(arr_s.length > 1) {
                v = Integer.parseInt(arr_s[1]);
            }
            if(v1 >= 4 && (v1 != 4 || v > 1)) {
                webView0.addJavascriptInterface(new FacebookSDKJSInterface(context0), "fbmq_" + FacebookSdk.getApplicationId());
                return;
            }
            String s1 = AppEventsLoggerImpl.access$getTAG$cp();
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, s1, "augmentWebView is only available for Android SDK version >= 17 on devices running Android >= 4.2");
        }

        public static void b(Context context0, AppEventsLoggerImpl appEventsLoggerImpl0) {
            Companion.initializeLib$lambda$4(context0, appEventsLoggerImpl0);
        }

        public final void eagerFlush() {
            if(this.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
            }
        }

        public final void functionDEPRECATED(@NotNull String s) {
            q.g(s, "extraMsg");
            Log.w(AppEventsLoggerImpl.access$getTAG$cp(), "This function is deprecated. " + s);
        }

        @NotNull
        public final Executor getAnalyticsExecutor() {
            if(AppEventsLoggerImpl.access$getBackgroundExecutor$cp() == null) {
                this.initializeTimersIfNeeded();
            }
            Executor executor0 = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
            if(executor0 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            return executor0;
        }

        @NotNull
        public final String getAnonymousAppDeviceGUID(@NotNull Context context0) {
            q.g(context0, "context");
            if(AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                synchronized(AppEventsLoggerImpl.access$getStaticLock$cp()) {
                    if(AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                        AppEventsLoggerImpl.access$setAnonymousAppDeviceGUID$cp(context0.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null));
                        if(AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                            AppEventsLoggerImpl.access$setAnonymousAppDeviceGUID$cp(("XZ" + UUID.randomUUID()));
                            context0.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp()).apply();
                        }
                    }
                }
            }
            String s = AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp();
            if(s == null) {
                throw new IllegalStateException("Required value was null.");
            }
            return s;
        }

        @NotNull
        public final FlushBehavior getFlushBehavior() {
            synchronized(AppEventsLoggerImpl.access$getStaticLock$cp()) {
                return AppEventsLoggerImpl.access$getFlushBehaviorField$cp();
            }
        }

        @Nullable
        public final String getInstallReferrer() {
            InstallReferrerUtil.tryUpdateReferrerInfo((String s) -> {
                SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
                if(s != null) {
                    sharedPreferences0.edit().putString("install_referrer", s).apply();
                }
            });
            return FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("install_referrer", null);

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/facebook/appevents/AppEventsLoggerImpl$Companion$getInstallReferrer$1", "Lcom/facebook/internal/InstallReferrerUtil$Callback;", "", "s", "Lie/H;", "onReceiveReferrerUrl", "(Ljava/lang/String;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
            public final class com.facebook.appevents.AppEventsLoggerImpl.Companion.getInstallReferrer.1 implements Callback {
                @Override  // com.facebook.internal.InstallReferrerUtil$Callback
                public void onReceiveReferrerUrl(@Nullable String s) {
                    AppEventsLoggerImpl.Companion.setInstallReferrer(s);
                }
            }

        }

        @Nullable
        public final String getPushNotificationsRegistrationId() {
            synchronized(AppEventsLoggerImpl.access$getStaticLock$cp()) {
                return AppEventsLoggerImpl.access$getPushNotificationsRegistrationIdField$cp();
            }
        }

        public final void initializeLib(@NotNull Context context0, @Nullable String s) {
            q.g(context0, "context");
            if(!FacebookSdk.getAutoLogAppEventsEnabled()) {
                return;
            }
            AppEventsLoggerImpl appEventsLoggerImpl0 = new AppEventsLoggerImpl(context0, s, null);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor0 = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
            if(scheduledThreadPoolExecutor0 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            scheduledThreadPoolExecutor0.execute(new l(8, context0, appEventsLoggerImpl0));
        }

        private static final void initializeLib$lambda$4(Context context0, AppEventsLoggerImpl appEventsLoggerImpl0) {
            q.g(context0, "$context");
            q.g(appEventsLoggerImpl0, "$logger");
            Bundle bundle0 = new Bundle();
            int v = 0;
            for(int v1 = 0; v1 < 11; ++v1) {
                String s = new String[]{"com.facebook.core.Core", "com.facebook.login.Login", "com.facebook.share.Share", "com.facebook.places.Places", "com.facebook.messenger.Messenger", "com.facebook.applinks.AppLinks", "com.facebook.marketing.Marketing", "com.facebook.gamingservices.GamingServices", "com.facebook.all.All", "com.android.billingclient.api.BillingClient", "com.android.vending.billing.IInAppBillingService"}[v1];
                String s1 = new String[]{"core_lib_included", "login_lib_included", "share_lib_included", "places_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "gamingservices_lib_included", "all_lib_included", "billing_client_lib_included", "billing_service_lib_included"}[v1];
                try {
                    Class.forName(s);
                    bundle0.putInt(s1, 1);
                    v |= 1 << v1;
                }
                catch(ClassNotFoundException unused_ex) {
                }
            }
            SharedPreferences sharedPreferences0 = context0.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            if(sharedPreferences0.getInt("kitsBitmask", 0) != v) {
                sharedPreferences0.edit().putInt("kitsBitmask", v).apply();
                appEventsLoggerImpl0.logEventImplicitly("fb_sdk_initialize", null, bundle0);
            }
        }

        private final void initializeTimersIfNeeded() {
            synchronized(AppEventsLoggerImpl.access$getStaticLock$cp()) {
                if(AppEventsLoggerImpl.access$getBackgroundExecutor$cp() != null) {
                    return;
                }
                AppEventsLoggerImpl.access$setBackgroundExecutor$cp(new ScheduledThreadPoolExecutor(1));
            }
            a a0 = new a(12);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor0 = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
            if(scheduledThreadPoolExecutor0 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            scheduledThreadPoolExecutor0.scheduleAtFixedRate(a0, 0L, 86400L, TimeUnit.SECONDS);
        }

        private static final void initializeTimersIfNeeded$lambda$6() {
            HashSet hashSet0 = new HashSet();
            for(Object object0: AppEventQueue.getKeySet()) {
                hashSet0.add(((AccessTokenAppIdPair)object0).getApplicationId());
            }
            for(Object object1: hashSet0) {
                FetchedAppSettingsManager.queryAppSettings(((String)object1), true);
            }
        }

        private final void logEvent(AppEvent appEvent0, AccessTokenAppIdPair accessTokenAppIdPair0) {
            AppEventQueue.add(accessTokenAppIdPair0, appEvent0);
            if(FeatureManager.isEnabled(Feature.OnDevicePostInstallEventProcessing) && OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                OnDeviceProcessingManager.sendCustomEventAsync(accessTokenAppIdPair0.getApplicationId(), appEvent0);
            }
            if(FeatureManager.isEnabled(Feature.GPSARATriggers)) {
                GpsAraTriggersManager.INSTANCE.registerTriggerAsync(accessTokenAppIdPair0.getApplicationId(), appEvent0);
            }
            if(FeatureManager.isEnabled(Feature.GPSPACAProcessing)) {
                PACustomAudienceClient.INSTANCE.joinCustomAudience(accessTokenAppIdPair0.getApplicationId(), appEvent0);
            }
            if(!appEvent0.getIsImplicit() && !AppEventsLoggerImpl.access$isActivateAppEventRequested$cp()) {
                if(q.b(appEvent0.getName(), "fb_mobile_activate_app")) {
                    AppEventsLoggerImpl.access$setActivateAppEventRequested$cp(true);
                    return;
                }
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity\'s onResume() methodbefore logging other app events.");
            }
        }

        private final void notifyDeveloperError(String s) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", s);
        }

        public final void onContextStop() {
            AppEventQueue.persistToDisk();
        }

        public final void setFlushBehavior(@NotNull FlushBehavior appEventsLogger$FlushBehavior0) {
            q.g(appEventsLogger$FlushBehavior0, "flushBehavior");
            synchronized(AppEventsLoggerImpl.access$getStaticLock$cp()) {
                AppEventsLoggerImpl.access$setFlushBehaviorField$cp(appEventsLogger$FlushBehavior0);
            }
        }

        // 检测为 Lambda 实现
        public final void setInstallReferrer(@Nullable String s) [...]

        public final void setPushNotificationsRegistrationId(@Nullable String s) {
            synchronized(AppEventsLoggerImpl.access$getStaticLock$cp()) {
                if(!Utility.stringsEqualOrEmpty(AppEventsLoggerImpl.access$getPushNotificationsRegistrationIdField$cp(), s)) {
                    AppEventsLoggerImpl.access$setPushNotificationsRegistrationIdField$cp(s);
                    AppEventsLoggerImpl appEventsLoggerImpl0 = new AppEventsLoggerImpl(FacebookSdk.getApplicationContext(), null, null);
                    appEventsLoggerImpl0.logEvent("fb_mobile_obtain_push_token");
                    if(AppEventsLoggerImpl.Companion.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                        appEventsLoggerImpl0.flush();
                    }
                }
            }
        }
    }

    @NotNull
    private static final String ACCOUNT_KIT_EVENT_NAME_PREFIX = "fb_ak";
    @NotNull
    public static final String APP_EVENTS_KILLSWITCH = "app_events_killswitch";
    @NotNull
    private static final String APP_EVENT_NAME_PUSH_OPENED = "fb_mobile_push_opened";
    @NotNull
    private static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    @NotNull
    private static final String APP_EVENT_PUSH_PARAMETER_ACTION = "fb_push_action";
    @NotNull
    private static final String APP_EVENT_PUSH_PARAMETER_CAMPAIGN = "fb_push_campaign";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String PUSH_PAYLOAD_CAMPAIGN_KEY = "campaign";
    @NotNull
    private static final String PUSH_PAYLOAD_KEY = "fb_push_payload";
    @NotNull
    private static final String TAG;
    @NotNull
    private AccessTokenAppIdPair accessTokenAppId;
    @Nullable
    private static String anonymousAppDeviceGUID;
    @Nullable
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    @NotNull
    private final String contextName;
    @NotNull
    private static FlushBehavior flushBehaviorField;
    private static boolean isActivateAppEventRequested;
    @Nullable
    private static String pushNotificationsRegistrationIdField;
    @NotNull
    private static final Object staticLock;

    static {
        AppEventsLoggerImpl.Companion = new Companion(null);
        AppEventsLoggerImpl.TAG = AppEventsLoggerImpl.class.getCanonicalName() == null ? "com.facebook.appevents.AppEventsLoggerImpl" : AppEventsLoggerImpl.class.getCanonicalName();
        AppEventsLoggerImpl.flushBehaviorField = FlushBehavior.AUTO;
        AppEventsLoggerImpl.staticLock = new Object();
    }

    public AppEventsLoggerImpl(@Nullable Context context0, @Nullable String s, @Nullable AccessToken accessToken0) {
        this(Utility.getActivityName(context0), s, accessToken0);
    }

    public AppEventsLoggerImpl(@NotNull String s, @Nullable String s1, @Nullable AccessToken accessToken0) {
        q.g(s, "activityName");
        super();
        Validate.sdkInitialized();
        this.contextName = s;
        if(accessToken0 == null) {
            accessToken0 = AccessToken.Companion.getCurrentAccessToken();
        }
        if(accessToken0 != null && !accessToken0.isExpired() && (s1 == null || s1.equals(accessToken0.getApplicationId()))) {
            this.accessTokenAppId = new AccessTokenAppIdPair(accessToken0);
        }
        else {
            if(s1 == null) {
                s1 = Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext());
            }
            if(s1 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            this.accessTokenAppId = new AccessTokenAppIdPair(null, s1);
        }
        Companion.access$initializeTimersIfNeeded(AppEventsLoggerImpl.Companion);
    }

    // 去混淆评级： 低(20)
    public static final String access$getAnonymousAppDeviceGUID$cp() {
        return CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class) ? null : AppEventsLoggerImpl.anonymousAppDeviceGUID;
    }

    // 去混淆评级： 低(20)
    public static final ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp() {
        return CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class) ? null : AppEventsLoggerImpl.backgroundExecutor;
    }

    // 去混淆评级： 低(20)
    public static final FlushBehavior access$getFlushBehaviorField$cp() {
        return CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class) ? null : AppEventsLoggerImpl.flushBehaviorField;
    }

    // 去混淆评级： 低(20)
    public static final String access$getPushNotificationsRegistrationIdField$cp() {
        return CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class) ? null : AppEventsLoggerImpl.pushNotificationsRegistrationIdField;
    }

    // 去混淆评级： 低(20)
    public static final Object access$getStaticLock$cp() {
        return CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class) ? null : AppEventsLoggerImpl.staticLock;
    }

    // 去混淆评级： 低(20)
    public static final String access$getTAG$cp() {
        return CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class) ? null : AppEventsLoggerImpl.TAG;
    }

    // 去混淆评级： 低(20)
    public static final boolean access$isActivateAppEventRequested$cp() {
        return CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class) ? false : AppEventsLoggerImpl.isActivateAppEventRequested;
    }

    public static final void access$setActivateAppEventRequested$cp(boolean z) {
        if(CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        AppEventsLoggerImpl.isActivateAppEventRequested = z;
    }

    public static final void access$setAnonymousAppDeviceGUID$cp(String s) {
        if(CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        AppEventsLoggerImpl.anonymousAppDeviceGUID = s;
    }

    public static final void access$setBackgroundExecutor$cp(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor0) {
        if(CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        AppEventsLoggerImpl.backgroundExecutor = scheduledThreadPoolExecutor0;
    }

    public static final void access$setFlushBehaviorField$cp(FlushBehavior appEventsLogger$FlushBehavior0) {
        if(CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        AppEventsLoggerImpl.flushBehaviorField = appEventsLogger$FlushBehavior0;
    }

    public static final void access$setPushNotificationsRegistrationIdField$cp(String s) {
        if(CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        AppEventsLoggerImpl.pushNotificationsRegistrationIdField = s;
    }

    public static final void activateApp(@NotNull Application application0, @Nullable String s) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            AppEventsLoggerImpl.Companion.activateApp(application0, s);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    @NotNull
    public static final m addImplicitPurchaseParameters(@Nullable Bundle bundle0, @Nullable OperationalData operationalData0, boolean z) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return AppEventsLoggerImpl.Companion.addImplicitPurchaseParameters(bundle0, operationalData0, z);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final void augmentWebView(@NotNull WebView webView0, @Nullable Context context0) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            AppEventsLoggerImpl.Companion.augmentWebView(webView0, context0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public final void flush() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AppEventQueue.flush(FlushReason.EXPLICIT);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public static final void functionDEPRECATED(@NotNull String s) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            AppEventsLoggerImpl.Companion.functionDEPRECATED(s);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    @NotNull
    public static final Executor getAnalyticsExecutor() {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return AppEventsLoggerImpl.Companion.getAnalyticsExecutor();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @NotNull
    public static final String getAnonymousAppDeviceGUID(@NotNull Context context0) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return AppEventsLoggerImpl.Companion.getAnonymousAppDeviceGUID(context0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @NotNull
    public final String getApplicationId() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.accessTokenAppId.getApplicationId();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @NotNull
    public static final FlushBehavior getFlushBehavior() {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return AppEventsLoggerImpl.Companion.getFlushBehavior();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @Nullable
    public static final String getInstallReferrer() {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return AppEventsLoggerImpl.Companion.getInstallReferrer();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @Nullable
    public static final String getPushNotificationsRegistrationId() {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return AppEventsLoggerImpl.Companion.getPushNotificationsRegistrationId();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final void initializeLib(@NotNull Context context0, @Nullable String s) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            AppEventsLoggerImpl.Companion.initializeLib(context0, s);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public final boolean isValidForAccessToken(@NotNull AccessToken accessToken0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            q.g(accessToken0, "accessToken");
            AccessTokenAppIdPair accessTokenAppIdPair0 = new AccessTokenAppIdPair(accessToken0);
            return q.b(this.accessTokenAppId, accessTokenAppIdPair0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }

    public final void logEvent(@Nullable String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.logEvent(s, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logEvent(@Nullable String s, double f) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.logEvent(s, f, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logEvent(@Nullable String s, double f, @Nullable Bundle bundle0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AppEventsLoggerImpl.logEvent$default(this, s, f, bundle0, false, ActivityLifecycleTracker.getCurrentSessionGuid(), null, 0x20, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logEvent(@Nullable String s, @Nullable Bundle bundle0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AppEventsLoggerImpl.logEvent$default(this, s, null, bundle0, false, ActivityLifecycleTracker.getCurrentSessionGuid(), null, 0x20, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logEvent(@Nullable String s, @Nullable Double double0, @Nullable Bundle bundle0, boolean z, @Nullable UUID uUID0, @Nullable OperationalData operationalData0) {
        JSONException jSONException1;
        Bundle bundle1;
        if(!CrashShieldHandler.isObjectCrashing(this) && s != null) {
            try {
                if(s.length() != 0) {
                    if(z || !AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled() || !q.b(s, "fb_mobile_purchase") && (!q.b(s, "Subscribe") && !q.b(s, "StartTrial"))) {
                        bundle1 = bundle0;
                    }
                    else {
                        Log.w(AppEventsLoggerImpl.TAG, "You are logging purchase events while auto-logging of in-app purchase is enabled in the SDK. Make sure you don\'t log duplicate events");
                        if((!FeatureManager.isEnabled(Feature.AndroidManualImplicitPurchaseDedupe) || !q.b(s, "fb_mobile_purchase")) && (!FeatureManager.isEnabled(Feature.AndroidManualImplicitSubsDedupe) || !q.b(s, "Subscribe") && !q.b(s, "StartTrial"))) {
                            bundle1 = bundle0;
                        }
                        else {
                            InAppPurchaseDedupeConfig inAppPurchaseDedupeConfig0 = InAppPurchaseDedupeConfig.INSTANCE;
                            Double double1 = inAppPurchaseDedupeConfig0.getValueOfManualEvent(double0, bundle0);
                            Currency currency0 = inAppPurchaseDedupeConfig0.getCurrencyOfManualEvent(bundle0);
                            if(double1 == null || currency0 == null) {
                                bundle1 = bundle0;
                            }
                            else {
                                m m0 = inAppPurchaseDedupeConfig0.addDedupeParameters(InAppPurchaseManager.performDedupe(k.z(new InAppPurchase(s, ((double)double1), currency0)), System.currentTimeMillis(), false, k.z(new m(bundle0, operationalData0))), bundle0, operationalData0);
                                operationalData0 = (OperationalData)m0.b;
                                bundle1 = (Bundle)m0.a;
                            }
                        }
                    }
                    if(FetchedAppGateKeepersManager.getGateKeeperForKey("app_events_killswitch", FacebookSdk.getApplicationId(), false)) {
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "KillSwitch is enabled and fail to log app event: %s", new Object[]{s});
                        return;
                    }
                    if(!BlocklistEventsManager.isInBlocklist(s)) {
                        Companion appEventsLoggerImpl$Companion0 = AppEventsLoggerImpl.Companion;
                        m m1 = appEventsLoggerImpl$Companion0.addImplicitPurchaseParameters(bundle1, operationalData0, z);
                        Bundle bundle2 = (Bundle)m1.a;
                        OperationalData operationalData1 = (OperationalData)m1.b;
                        try {
                            if(!ProtectedModeManager.INSTANCE.protectedModeIsApplied(bundle2)) {
                                SensitiveParamsManager.processFilterSensitiveParams(bundle2, s);
                            }
                            BannedParamManager.processFilterBannedParams(bundle2);
                            MACARuleMatchingManager.processParameters(bundle2, s);
                            StdParamsEnforcementManager.processFilterParamSchemaBlocking(bundle2);
                            ProtectedModeManager.processParametersForProtectedMode(bundle2);
                            appEventsLoggerImpl$Companion0.logEvent(new AppEvent(this.contextName, s, double0, bundle2, z, true, uUID0, operationalData1), this.accessTokenAppId);
                            return;
                        label_36:
                            jSONException1 = jSONException0;
                        }
                        catch(JSONException jSONException0) {
                            goto label_36;
                        }
                        catch(FacebookException unused_ex) {
                            Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", new Object[]{""});
                            return;
                        }
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: \'%s\'", new Object[]{jSONException1.toString()});
                    }
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    public static void logEvent$default(AppEventsLoggerImpl appEventsLoggerImpl0, String s, Bundle bundle0, int v, Object object0) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        if((v & 2) != 0) {
            bundle0 = null;
        }
        try {
            appEventsLoggerImpl0.logEvent(s, bundle0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static void logEvent$default(AppEventsLoggerImpl appEventsLoggerImpl0, String s, Double double0, Bundle bundle0, boolean z, UUID uUID0, OperationalData operationalData0, int v, Object object0) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        if((v & 0x20) != 0) {
            operationalData0 = null;
        }
        try {
            appEventsLoggerImpl0.logEvent(s, double0, bundle0, z, uUID0, operationalData0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public final void logEventFromSE(@Nullable String s, @Nullable String s1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle bundle0 = new Bundle();
            bundle0.putString("_is_suggested_event", "1");
            bundle0.putString("_button_text", s1);
            this.logEvent(s, bundle0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logEventImplicitly(@Nullable String s, @Nullable Double double0, @Nullable Bundle bundle0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AppEventsLoggerImpl.logEvent$default(this, s, double0, bundle0, true, ActivityLifecycleTracker.getCurrentSessionGuid(), null, 0x20, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logEventImplicitly(@Nullable String s, @Nullable BigDecimal bigDecimal0, @Nullable Currency currency0, @Nullable Bundle bundle0, @Nullable OperationalData operationalData0) {
        Throwable throwable1;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if(bigDecimal0 == null || currency0 == null) {
            goto label_12;
        }
        else {
            if(bundle0 == null) {
                try {
                    bundle0 = new Bundle();
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    CrashShieldHandler.handleThrowable(throwable1, this);
                    return;
                }
            }
            try {
                bundle0.putString("fb_currency", currency0.getCurrencyCode());
                this.logEvent(s, bigDecimal0.doubleValue(), bundle0, true, ActivityLifecycleTracker.getCurrentSessionGuid(), operationalData0);
                return;
            label_12:
                Utility.logd(AppEventsLoggerImpl.TAG, "purchaseAmount and currency cannot be null");
                return;
            }
            catch(Throwable throwable2) {
            }
        }
        throwable1 = throwable2;
        CrashShieldHandler.handleThrowable(throwable1, this);
    }

    public static void logEventImplicitly$default(AppEventsLoggerImpl appEventsLoggerImpl0, String s, BigDecimal bigDecimal0, Currency currency0, Bundle bundle0, OperationalData operationalData0, int v, Object object0) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        if((v & 16) != 0) {
            operationalData0 = null;
        }
        try {
            appEventsLoggerImpl0.logEventImplicitly(s, bigDecimal0, currency0, bundle0, operationalData0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public final void logProductItem(@Nullable String s, @Nullable ProductAvailability appEventsLogger$ProductAvailability0, @Nullable ProductCondition appEventsLogger$ProductCondition0, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable BigDecimal bigDecimal0, @Nullable Currency currency0, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable Bundle bundle0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if(s == null) {
                Companion.access$notifyDeveloperError(AppEventsLoggerImpl.Companion, "itemID cannot be null");
                return;
            }
            if(appEventsLogger$ProductAvailability0 == null) {
                Companion.access$notifyDeveloperError(AppEventsLoggerImpl.Companion, "availability cannot be null");
                return;
            }
            if(appEventsLogger$ProductCondition0 == null) {
                Companion.access$notifyDeveloperError(AppEventsLoggerImpl.Companion, "condition cannot be null");
                return;
            }
            if(s1 == null) {
                Companion.access$notifyDeveloperError(AppEventsLoggerImpl.Companion, "description cannot be null");
                return;
            }
            if(s2 == null) {
                Companion.access$notifyDeveloperError(AppEventsLoggerImpl.Companion, "imageLink cannot be null");
                return;
            }
            if(s3 == null) {
                Companion.access$notifyDeveloperError(AppEventsLoggerImpl.Companion, "link cannot be null");
                return;
            }
            if(s4 == null) {
                Companion.access$notifyDeveloperError(AppEventsLoggerImpl.Companion, "title cannot be null");
                return;
            }
            if(bigDecimal0 == null) {
                Companion.access$notifyDeveloperError(AppEventsLoggerImpl.Companion, "priceAmount cannot be null");
                return;
            }
            if(currency0 == null) {
                Companion.access$notifyDeveloperError(AppEventsLoggerImpl.Companion, "currency cannot be null");
                return;
            }
            if(s5 == null && s6 == null && s7 == null) {
                Companion.access$notifyDeveloperError(AppEventsLoggerImpl.Companion, "Either gtin, mpn or brand is required");
                return;
            }
            if(bundle0 == null) {
                bundle0 = new Bundle();
            }
            bundle0.putString("fb_product_item_id", s);
            bundle0.putString("fb_product_availability", appEventsLogger$ProductAvailability0.name());
            bundle0.putString("fb_product_condition", appEventsLogger$ProductCondition0.name());
            bundle0.putString("fb_product_description", s1);
            bundle0.putString("fb_product_image_link", s2);
            bundle0.putString("fb_product_link", s3);
            bundle0.putString("fb_product_title", s4);
            bundle0.putString("fb_product_price_amount", bigDecimal0.setScale(3, 4).toString());
            bundle0.putString("fb_product_price_currency", currency0.getCurrencyCode());
            if(s5 != null) {
                bundle0.putString("fb_product_gtin", s5);
            }
            if(s6 != null) {
                bundle0.putString("fb_product_mpn", s6);
            }
            if(s7 != null) {
                bundle0.putString("fb_product_brand", s7);
            }
            this.logEvent("fb_mobile_catalog_update", bundle0);
            AppEventsLoggerImpl.Companion.eagerFlush();
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public final void logPurchase(@Nullable BigDecimal bigDecimal0, @Nullable Currency currency0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.logPurchase(bigDecimal0, currency0, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logPurchase(@Nullable BigDecimal bigDecimal0, @Nullable Currency currency0, @Nullable Bundle bundle0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AppEventsLoggerImpl.logPurchase$default(this, bigDecimal0, currency0, bundle0, false, null, 16, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void logPurchase(@Nullable BigDecimal bigDecimal0, @Nullable Currency currency0, @Nullable Bundle bundle0, boolean z, @Nullable OperationalData operationalData0) {
        Throwable throwable1;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if(bigDecimal0 == null) {
                Companion.access$notifyDeveloperError(AppEventsLoggerImpl.Companion, "purchaseAmount cannot be null");
                return;
            }
            if(currency0 == null) {
                Companion.access$notifyDeveloperError(AppEventsLoggerImpl.Companion, "currency cannot be null");
                return;
            }
            if(bundle0 == null) {
                bundle0 = new Bundle();
            }
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            CrashShieldHandler.handleThrowable(throwable1, this);
            return;
        }
        try {
            bundle0.putString("fb_currency", currency0.getCurrencyCode());
            this.logEvent("fb_mobile_purchase", bigDecimal0.doubleValue(), bundle0, z, ActivityLifecycleTracker.getCurrentSessionGuid(), operationalData0);
            AppEventsLoggerImpl.Companion.eagerFlush();
            return;
        }
        catch(Throwable throwable2) {
            throwable1 = throwable2;
        }
        CrashShieldHandler.handleThrowable(throwable1, this);
    }

    public static void logPurchase$default(AppEventsLoggerImpl appEventsLoggerImpl0, BigDecimal bigDecimal0, Currency currency0, Bundle bundle0, int v, Object object0) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        if((v & 4) != 0) {
            bundle0 = null;
        }
        try {
            appEventsLoggerImpl0.logPurchase(bigDecimal0, currency0, bundle0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static void logPurchase$default(AppEventsLoggerImpl appEventsLoggerImpl0, BigDecimal bigDecimal0, Currency currency0, Bundle bundle0, boolean z, OperationalData operationalData0, int v, Object object0) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        if((v & 16) != 0) {
            operationalData0 = null;
        }
        try {
            appEventsLoggerImpl0.logPurchase(bigDecimal0, currency0, bundle0, z, operationalData0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public final void logPurchaseImplicitly(@Nullable BigDecimal bigDecimal0, @Nullable Currency currency0, @Nullable Bundle bundle0, @Nullable OperationalData operationalData0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.logPurchase(bigDecimal0, currency0, bundle0, true, operationalData0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public static void logPurchaseImplicitly$default(AppEventsLoggerImpl appEventsLoggerImpl0, BigDecimal bigDecimal0, Currency currency0, Bundle bundle0, OperationalData operationalData0, int v, Object object0) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        if((v & 8) != 0) {
            operationalData0 = null;
        }
        try {
            appEventsLoggerImpl0.logPurchaseImplicitly(bigDecimal0, currency0, bundle0, operationalData0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public final void logPushNotificationOpen(@NotNull Bundle bundle0, @Nullable String s) {
        String s2;
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                q.g(bundle0, "payload");
                try {
                    String s1 = bundle0.getString("fb_push_payload");
                    if(!Utility.isNullOrEmpty(s1)) {
                        s2 = new JSONObject(s1).getString("campaign");
                        goto label_7;
                    }
                    return;
                }
                catch(JSONException unused_ex) {
                    s2 = null;
                }
            label_7:
                if(s2 == null) {
                    Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, AppEventsLoggerImpl.TAG, "Malformed payload specified for logging a push notification open.");
                    return;
                }
                Bundle bundle1 = new Bundle();
                bundle1.putString("fb_push_campaign", s2);
                if(s != null) {
                    bundle1.putString("fb_push_action", s);
                }
                this.logEvent("fb_mobile_push_opened", bundle1);
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    public final void logSdkEvent(@NotNull String s, @Nullable Double double0, @Nullable Bundle bundle0) {
        Throwable throwable2;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                q.g(s, "eventName");
                if(!v.r0(s, "fb_ak", false)) {
                    goto label_6;
                }
                if(FacebookSdk.getAutoLogAppEventsEnabled()) {
                    AppEventsLoggerImpl.logEvent$default(this, s, double0, bundle0, true, ActivityLifecycleTracker.getCurrentSessionGuid(), null, 0x20, null);
                    return;
                    try {
                    label_6:
                        Log.e(AppEventsLoggerImpl.TAG, "logSdkEvent is deprecated and only supports account kit for legacy, please use logEvent instead");
                        return;
                    }
                    catch(Throwable throwable1) {
                        throwable2 = throwable1;
                        goto label_14;
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        throwable2 = throwable0;
    label_14:
        CrashShieldHandler.handleThrowable(throwable2, this);
    }

    public static final void onContextStop() {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            AppEventsLoggerImpl.Companion.onContextStop();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void setFlushBehavior(@NotNull FlushBehavior appEventsLogger$FlushBehavior0) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            AppEventsLoggerImpl.Companion.setFlushBehavior(appEventsLogger$FlushBehavior0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void setInstallReferrer(@Nullable String s) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            AppEventsLoggerImpl.Companion.setInstallReferrer(s);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void setPushNotificationsRegistrationId(@Nullable String s) {
        Class class0 = AppEventsLoggerImpl.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            AppEventsLoggerImpl.Companion.setPushNotificationsRegistrationId(s);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }
}

