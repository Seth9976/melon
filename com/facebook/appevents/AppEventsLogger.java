package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import com.facebook.AccessToken;
import java.math.BigDecimal;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0004:;<=B%\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\f\u0010\rJ\u001F\u0010\f\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000F\u001A\u00020\u000E\u00A2\u0006\u0004\b\f\u0010\u0010J!\u0010\f\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\u00042\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\f\u0010\u0013J)\u0010\f\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\f\u0010\u0014J!\u0010\u0019\u001A\u00020\u000B2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017\u00A2\u0006\u0004\b\u0019\u0010\u001AJ+\u0010\u0019\u001A\u00020\u000B2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\u0019\u0010\u001BJ\u0015\u0010\u001D\u001A\u00020\u000B2\u0006\u0010\u001C\u001A\u00020\u0011\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010\u001D\u001A\u00020\u000B2\u0006\u0010\u001C\u001A\u00020\u00112\b\u0010\u001F\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u001D\u0010 J\u008F\u0001\u0010.\u001A\u00020\u000B2\b\u0010!\u001A\u0004\u0018\u00010\u00042\b\u0010#\u001A\u0004\u0018\u00010\"2\b\u0010%\u001A\u0004\u0018\u00010$2\b\u0010&\u001A\u0004\u0018\u00010\u00042\b\u0010\'\u001A\u0004\u0018\u00010\u00042\b\u0010(\u001A\u0004\u0018\u00010\u00042\b\u0010)\u001A\u0004\u0018\u00010\u00042\b\u0010*\u001A\u0004\u0018\u00010\u00152\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010+\u001A\u0004\u0018\u00010\u00042\b\u0010,\u001A\u0004\u0018\u00010\u00042\b\u0010-\u001A\u0004\u0018\u00010\u00042\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b.\u0010/J\r\u00100\u001A\u00020\u000B\u00A2\u0006\u0004\b0\u00101J\u0015\u00103\u001A\u0002022\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b3\u00104R\u0014\u00106\u001A\u0002058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b6\u00107R\u0011\u0010\u0005\u001A\u00020\u00048F\u00A2\u0006\u0006\u001A\u0004\b8\u00109\u00A8\u0006>"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger;", "", "Landroid/content/Context;", "context", "", "applicationId", "Lcom/facebook/AccessToken;", "accessToken", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "eventName", "Lie/H;", "logEvent", "(Ljava/lang/String;)V", "", "valueToSum", "(Ljava/lang/String;D)V", "Landroid/os/Bundle;", "parameters", "(Ljava/lang/String;Landroid/os/Bundle;)V", "(Ljava/lang/String;DLandroid/os/Bundle;)V", "Ljava/math/BigDecimal;", "purchaseAmount", "Ljava/util/Currency;", "currency", "logPurchase", "(Ljava/math/BigDecimal;Ljava/util/Currency;)V", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;)V", "payload", "logPushNotificationOpen", "(Landroid/os/Bundle;)V", "action", "(Landroid/os/Bundle;Ljava/lang/String;)V", "itemID", "Lcom/facebook/appevents/AppEventsLogger$ProductAvailability;", "availability", "Lcom/facebook/appevents/AppEventsLogger$ProductCondition;", "condition", "description", "imageLink", "link", "title", "priceAmount", "gtin", "mpn", "brand", "logProductItem", "(Ljava/lang/String;Lcom/facebook/appevents/AppEventsLogger$ProductAvailability;Lcom/facebook/appevents/AppEventsLogger$ProductCondition;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/util/Currency;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "flush", "()V", "", "isValidForAccessToken", "(Lcom/facebook/AccessToken;)Z", "Lcom/facebook/appevents/AppEventsLoggerImpl;", "loggerImpl", "Lcom/facebook/appevents/AppEventsLoggerImpl;", "getApplicationId", "()Ljava/lang/String;", "Companion", "FlushBehavior", "ProductAvailability", "ProductCondition", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppEventsLogger {
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b#\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b\u0007\u0010\u000BJ!\u0010\u000E\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\f2\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0011\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\f2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0007\u00A2\u0006\u0004\b\u0011\u0010\u0015J+\u0010\u0011\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\f2\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0007\u00A2\u0006\u0004\b\u0011\u0010\u0016J!\u0010\u0011\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\f2\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b\u0011\u0010\u0017J\u0011\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\u00062\u0006\u0010\u001B\u001A\u00020\u0018H\u0007\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u001E\u0010\u0003J\u0019\u0010 \u001A\u00020\u00062\b\u0010\u001F\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b \u0010!J!\u0010$\u001A\u00020\u00062\u0006\u0010#\u001A\u00020\"2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0007\u00A2\u0006\u0004\b$\u0010%J\u0011\u0010&\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b&\u0010\'J\u0019\u0010)\u001A\u00020\u00062\b\u0010(\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b)\u0010!J\u000F\u0010*\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b*\u0010\u0003Js\u00105\u001A\u00020\u00062\b\u0010+\u001A\u0004\u0018\u00010\t2\b\u0010,\u001A\u0004\u0018\u00010\t2\b\u0010-\u001A\u0004\u0018\u00010\t2\b\u0010.\u001A\u0004\u0018\u00010\t2\b\u0010/\u001A\u0004\u0018\u00010\t2\b\u00100\u001A\u0004\u0018\u00010\t2\b\u00101\u001A\u0004\u0018\u00010\t2\b\u00102\u001A\u0004\u0018\u00010\t2\b\u00103\u001A\u0004\u0018\u00010\t2\b\u00104\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b5\u00106J}\u00105\u001A\u00020\u00062\b\u0010+\u001A\u0004\u0018\u00010\t2\b\u0010,\u001A\u0004\u0018\u00010\t2\b\u0010-\u001A\u0004\u0018\u00010\t2\b\u0010.\u001A\u0004\u0018\u00010\t2\b\u0010/\u001A\u0004\u0018\u00010\t2\b\u00100\u001A\u0004\u0018\u00010\t2\b\u00101\u001A\u0004\u0018\u00010\t2\b\u00102\u001A\u0004\u0018\u00010\t2\b\u00103\u001A\u0004\u0018\u00010\t2\b\u00104\u001A\u0004\u0018\u00010\t2\b\u00107\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b5\u00108J\u000F\u00109\u001A\u00020\tH\u0007\u00A2\u0006\u0004\b9\u0010\'J\u000F\u0010:\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b:\u0010\u0003J\u0017\u0010;\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b;\u0010<J\u0019\u0010>\u001A\u00020\u00062\b\u0010=\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b>\u0010!R\u0014\u0010?\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bA\u0010@R\u0014\u0010B\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bB\u0010@R\u001C\u0010D\u001A\n C*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bD\u0010@\u00A8\u0006E"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger$Companion;", "", "<init>", "()V", "Landroid/app/Application;", "application", "Lie/H;", "activateApp", "(Landroid/app/Application;)V", "", "applicationId", "(Landroid/app/Application;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "initializeLib", "(Landroid/content/Context;Ljava/lang/String;)V", "Lcom/facebook/appevents/AppEventsLogger;", "newLogger", "(Landroid/content/Context;)Lcom/facebook/appevents/AppEventsLogger;", "Lcom/facebook/AccessToken;", "accessToken", "(Landroid/content/Context;Lcom/facebook/AccessToken;)Lcom/facebook/appevents/AppEventsLogger;", "(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/AccessToken;)Lcom/facebook/appevents/AppEventsLogger;", "(Landroid/content/Context;Ljava/lang/String;)Lcom/facebook/appevents/AppEventsLogger;", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "getFlushBehavior", "()Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "flushBehavior", "setFlushBehavior", "(Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;)V", "onContextStop", "registrationId", "setPushNotificationsRegistrationId", "(Ljava/lang/String;)V", "Landroid/webkit/WebView;", "webView", "augmentWebView", "(Landroid/webkit/WebView;Landroid/content/Context;)V", "getUserID", "()Ljava/lang/String;", "userID", "setUserID", "clearUserID", "email", "firstName", "lastName", "phone", "dateOfBirth", "gender", "city", "state", "zip", "country", "setUserData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "externalId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserData", "clearUserData", "getAnonymousAppDeviceGUID", "(Landroid/content/Context;)Ljava/lang/String;", "referrer", "setInstallReferrer", "ACTION_APP_EVENTS_FLUSHED", "Ljava/lang/String;", "APP_EVENTS_EXTRA_FLUSH_RESULT", "APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED", "kotlin.jvm.PlatformType", "TAG", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final void activateApp(@NotNull Application application0) {
            q.g(application0, "application");
            AppEventsLoggerImpl.Companion.activateApp(application0, null);
        }

        public final void activateApp(@NotNull Application application0, @Nullable String s) {
            q.g(application0, "application");
            AppEventsLoggerImpl.Companion.activateApp(application0, s);
        }

        public final void augmentWebView(@NotNull WebView webView0, @Nullable Context context0) {
            q.g(webView0, "webView");
            AppEventsLoggerImpl.Companion.augmentWebView(webView0, context0);
        }

        public final void clearUserData() {
            UserDataStore.clear();
        }

        public final void clearUserID() {
            AnalyticsUserIDStore.setUserID(null);
        }

        @NotNull
        public final String getAnonymousAppDeviceGUID(@NotNull Context context0) {
            q.g(context0, "context");
            return AppEventsLoggerImpl.Companion.getAnonymousAppDeviceGUID(context0);
        }

        @Nullable
        public final FlushBehavior getFlushBehavior() {
            return AppEventsLoggerImpl.Companion.getFlushBehavior();
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getUserData() [...] // 潜在的解密器

        @Nullable
        public final String getUserID() {
            return AnalyticsUserIDStore.getUserID();
        }

        public final void initializeLib(@NotNull Context context0, @Nullable String s) {
            q.g(context0, "context");
            AppEventsLoggerImpl.Companion.initializeLib(context0, s);
        }

        @NotNull
        public final AppEventsLogger newLogger(@NotNull Context context0) {
            q.g(context0, "context");
            return new AppEventsLogger(context0, null, null, null);
        }

        @NotNull
        public final AppEventsLogger newLogger(@NotNull Context context0, @Nullable AccessToken accessToken0) {
            q.g(context0, "context");
            return new AppEventsLogger(context0, null, accessToken0, null);
        }

        @NotNull
        public final AppEventsLogger newLogger(@NotNull Context context0, @Nullable String s) {
            q.g(context0, "context");
            return new AppEventsLogger(context0, s, null, null);
        }

        @NotNull
        public final AppEventsLogger newLogger(@NotNull Context context0, @Nullable String s, @Nullable AccessToken accessToken0) {
            q.g(context0, "context");
            return new AppEventsLogger(context0, s, accessToken0, null);
        }

        public final void onContextStop() {
            AppEventsLoggerImpl.Companion.onContextStop();
        }

        public final void setFlushBehavior(@NotNull FlushBehavior appEventsLogger$FlushBehavior0) {
            q.g(appEventsLogger$FlushBehavior0, "flushBehavior");
            AppEventsLoggerImpl.Companion.setFlushBehavior(appEventsLogger$FlushBehavior0);
        }

        public final void setInstallReferrer(@Nullable String s) {
            AppEventsLoggerImpl.Companion.setInstallReferrer(s);
        }

        public final void setPushNotificationsRegistrationId(@Nullable String s) {
            AppEventsLoggerImpl.Companion.setPushNotificationsRegistrationId(s);
        }

        public final void setUserData(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9) {
            UserDataStore.setUserDataAndHash$default(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, null, 0x400, null);
        }

        public final void setUserData(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10) {
            UserDataStore.setUserDataAndHash(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10);
        }

        public final void setUserID(@Nullable String s) {
            AnalyticsUserIDStore.setUserID(s);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "", "(Ljava/lang/String;I)V", "AUTO", "EXPLICIT_ONLY", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY;

        private static final FlushBehavior[] $values() [...] // Inlined contents
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger$ProductAvailability;", "", "(Ljava/lang/String;I)V", "IN_STOCK", "OUT_OF_STOCK", "PREORDER", "AVALIABLE_FOR_ORDER", "DISCONTINUED", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum ProductAvailability {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        AVALIABLE_FOR_ORDER,
        DISCONTINUED;

        private static final ProductAvailability[] $values() [...] // Inlined contents
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger$ProductCondition;", "", "(Ljava/lang/String;I)V", "NEW", "REFURBISHED", "USED", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum ProductCondition {
        NEW,
        REFURBISHED,
        USED;

        private static final ProductCondition[] $values() [...] // Inlined contents
    }

    @NotNull
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    @NotNull
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    @NotNull
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    @NotNull
    public static final Companion Companion;
    private static final String TAG;
    @NotNull
    private final AppEventsLoggerImpl loggerImpl;

    static {
        AppEventsLogger.Companion = new Companion(null);
        AppEventsLogger.TAG = AppEventsLogger.class.getCanonicalName();
    }

    private AppEventsLogger(Context context0, String s, AccessToken accessToken0) {
        this.loggerImpl = new AppEventsLoggerImpl(context0, s, accessToken0);
    }

    public AppEventsLogger(Context context0, String s, AccessToken accessToken0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(context0, s, accessToken0);
    }

    public static final void activateApp(@NotNull Application application0) {
        AppEventsLogger.Companion.activateApp(application0);
    }

    public static final void activateApp(@NotNull Application application0, @Nullable String s) {
        AppEventsLogger.Companion.activateApp(application0, s);
    }

    public static final void augmentWebView(@NotNull WebView webView0, @Nullable Context context0) {
        AppEventsLogger.Companion.augmentWebView(webView0, context0);
    }

    public static final void clearUserData() {
        AppEventsLogger.Companion.clearUserData();
    }

    public static final void clearUserID() {
        AppEventsLogger.Companion.clearUserID();
    }

    public final void flush() {
        this.loggerImpl.flush();
    }

    @NotNull
    public static final String getAnonymousAppDeviceGUID(@NotNull Context context0) {
        return AppEventsLogger.Companion.getAnonymousAppDeviceGUID(context0);
    }

    @NotNull
    public final String getApplicationId() {
        return this.loggerImpl.getApplicationId();
    }

    @Nullable
    public static final FlushBehavior getFlushBehavior() {
        return AppEventsLogger.Companion.getFlushBehavior();
    }

    @NotNull
    public static final String getUserData() {
        return AppEventsLogger.Companion.getUserData();
    }

    @Nullable
    public static final String getUserID() {
        return AppEventsLogger.Companion.getUserID();
    }

    public static final void initializeLib(@NotNull Context context0, @Nullable String s) {
        AppEventsLogger.Companion.initializeLib(context0, s);
    }

    public final boolean isValidForAccessToken(@NotNull AccessToken accessToken0) {
        q.g(accessToken0, "accessToken");
        return this.loggerImpl.isValidForAccessToken(accessToken0);
    }

    public final void logEvent(@Nullable String s) {
        this.loggerImpl.logEvent(s);
    }

    public final void logEvent(@Nullable String s, double f) {
        this.loggerImpl.logEvent(s, f);
    }

    public final void logEvent(@Nullable String s, double f, @Nullable Bundle bundle0) {
        this.loggerImpl.logEvent(s, f, bundle0);
    }

    public final void logEvent(@Nullable String s, @Nullable Bundle bundle0) {
        this.loggerImpl.logEvent(s, bundle0);
    }

    public final void logProductItem(@Nullable String s, @Nullable ProductAvailability appEventsLogger$ProductAvailability0, @Nullable ProductCondition appEventsLogger$ProductCondition0, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable BigDecimal bigDecimal0, @Nullable Currency currency0, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable Bundle bundle0) {
        this.loggerImpl.logProductItem(s, appEventsLogger$ProductAvailability0, appEventsLogger$ProductCondition0, s1, s2, s3, s4, bigDecimal0, currency0, s5, s6, s7, bundle0);
    }

    public final void logPurchase(@Nullable BigDecimal bigDecimal0, @Nullable Currency currency0) {
        this.loggerImpl.logPurchase(bigDecimal0, currency0);
    }

    public final void logPurchase(@Nullable BigDecimal bigDecimal0, @Nullable Currency currency0, @Nullable Bundle bundle0) {
        this.loggerImpl.logPurchase(bigDecimal0, currency0, bundle0);
    }

    public final void logPushNotificationOpen(@NotNull Bundle bundle0) {
        q.g(bundle0, "payload");
        this.loggerImpl.logPushNotificationOpen(bundle0, null);
    }

    public final void logPushNotificationOpen(@NotNull Bundle bundle0, @Nullable String s) {
        q.g(bundle0, "payload");
        this.loggerImpl.logPushNotificationOpen(bundle0, s);
    }

    @NotNull
    public static final AppEventsLogger newLogger(@NotNull Context context0) {
        return AppEventsLogger.Companion.newLogger(context0);
    }

    @NotNull
    public static final AppEventsLogger newLogger(@NotNull Context context0, @Nullable AccessToken accessToken0) {
        return AppEventsLogger.Companion.newLogger(context0, accessToken0);
    }

    @NotNull
    public static final AppEventsLogger newLogger(@NotNull Context context0, @Nullable String s) {
        return AppEventsLogger.Companion.newLogger(context0, s);
    }

    @NotNull
    public static final AppEventsLogger newLogger(@NotNull Context context0, @Nullable String s, @Nullable AccessToken accessToken0) {
        return AppEventsLogger.Companion.newLogger(context0, s, accessToken0);
    }

    public static final void onContextStop() {
        AppEventsLogger.Companion.onContextStop();
    }

    public static final void setFlushBehavior(@NotNull FlushBehavior appEventsLogger$FlushBehavior0) {
        AppEventsLogger.Companion.setFlushBehavior(appEventsLogger$FlushBehavior0);
    }

    public static final void setInstallReferrer(@Nullable String s) {
        AppEventsLogger.Companion.setInstallReferrer(s);
    }

    public static final void setPushNotificationsRegistrationId(@Nullable String s) {
        AppEventsLogger.Companion.setPushNotificationsRegistrationId(s);
    }

    public static final void setUserData(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9) {
        AppEventsLogger.Companion.setUserData(s, s1, s2, s3, s4, s5, s6, s7, s8, s9);
    }

    public static final void setUserData(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10) {
        AppEventsLogger.Companion.setUserData(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10);
    }

    public static final void setUserID(@Nullable String s) {
        AppEventsLogger.Companion.setUserID(s);
    }
}

