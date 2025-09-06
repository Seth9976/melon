package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005B\u0013\b\u0016\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u00A2\u0006\u0004\b\u0004\u0010\bB\u001D\b\u0016\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t\u00A2\u0006\u0004\b\u0004\u0010\u000BB%\b\u0016\u0012\u0006\u0010\f\u001A\u00020\t\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\r\u00A2\u0006\u0004\b\u0004\u0010\u000FJ!\u0010\u0014\u001A\u00020\u00132\b\u0010\u0010\u001A\u0004\u0018\u00010\t2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0014\u001A\u00020\u00132\b\u0010\u0010\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001A\u00020\u00162\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\u0014\u0010\u0018J7\u0010\u001F\u001A\u00020\u00132\b\u0010\u001A\u001A\u0004\u0018\u00010\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001D\u00A2\u0006\u0004\b\u001F\u0010 J!\u0010\"\u001A\u00020\u00132\b\u0010\u0010\u001A\u0004\u0018\u00010\t2\b\u0010!\u001A\u0004\u0018\u00010\t\u00A2\u0006\u0004\b\"\u0010#JA\u0010$\u001A\u00020\u00132\b\u0010\u0010\u001A\u0004\u0018\u00010\t2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001D\u00A2\u0006\u0004\b$\u0010%J\u0017\u0010$\u001A\u00020\u00132\b\u0010\u0010\u001A\u0004\u0018\u00010\t\u00A2\u0006\u0004\b$\u0010&J+\u0010$\u001A\u00020\u00132\b\u0010\u0010\u001A\u0004\u0018\u00010\t2\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b$\u0010\'J!\u0010$\u001A\u00020\u00132\b\u0010\u0010\u001A\u0004\u0018\u00010\t2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b$\u0010\u0015J\u0015\u0010(\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b(\u0010)J\r\u0010*\u001A\u00020\u0013\u00A2\u0006\u0004\b*\u0010+R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010,\u00A8\u0006."}, d2 = {"Lcom/facebook/appevents/InternalAppEventsLogger;", "", "Lcom/facebook/appevents/AppEventsLoggerImpl;", "loggerImpl", "<init>", "(Lcom/facebook/appevents/AppEventsLoggerImpl;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "", "applicationId", "(Landroid/content/Context;Ljava/lang/String;)V", "activityName", "Lcom/facebook/AccessToken;", "accessToken", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "eventName", "Landroid/os/Bundle;", "parameters", "Lie/H;", "logEvent", "(Ljava/lang/String;Landroid/os/Bundle;)V", "", "valueToSum", "(Ljava/lang/String;DLandroid/os/Bundle;)V", "Ljava/math/BigDecimal;", "purchaseAmount", "Ljava/util/Currency;", "currency", "Lcom/facebook/appevents/OperationalData;", "operationalData", "logPurchaseImplicitly", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)V", "buttonText", "logEventFromSE", "(Ljava/lang/String;Ljava/lang/String;)V", "logEventImplicitly", "(Ljava/lang/String;Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)V", "(Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;)V", "logChangedSettingsEvent", "(Landroid/os/Bundle;)V", "flush", "()V", "Lcom/facebook/appevents/AppEventsLoggerImpl;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InternalAppEventsLogger {
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u0010\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001A\u00020\u000F2\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u001A\u001A\u00020\u00192\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\u001A\u0010\u001BJ+\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001C\u001A\u00020\n2\b\u0010\u0018\u001A\u0004\u0018\u00010\n2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001DH\u0007¢\u0006\u0004\b\u001A\u0010\u001F¨\u0006 "}, d2 = {"Lcom/facebook/appevents/InternalAppEventsLogger$Companion;", "", "<init>", "()V", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "getFlushBehavior", "()Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "Ljava/util/concurrent/Executor;", "getAnalyticsExecutor", "()Ljava/util/concurrent/Executor;", "", "getPushNotificationsRegistrationId", "()Ljava/lang/String;", "Landroid/os/Bundle;", "userData", "Lie/H;", "setUserData", "(Landroid/os/Bundle;)V", "", "ud", "setInternalUserData", "(Ljava/util/Map;)V", "Landroid/content/Context;", "context", "applicationId", "Lcom/facebook/appevents/InternalAppEventsLogger;", "createInstance", "(Landroid/content/Context;Ljava/lang/String;)Lcom/facebook/appevents/InternalAppEventsLogger;", "activityName", "Lcom/facebook/AccessToken;", "accessToken", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/AccessToken;)Lcom/facebook/appevents/InternalAppEventsLogger;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final InternalAppEventsLogger createInstance(@Nullable Context context0) {
            return Companion.createInstance$default(this, context0, null, 2, null);
        }

        @NotNull
        public final InternalAppEventsLogger createInstance(@Nullable Context context0, @Nullable String s) {
            return new InternalAppEventsLogger(context0, s);
        }

        @NotNull
        public final InternalAppEventsLogger createInstance(@NotNull String s, @Nullable String s1, @Nullable AccessToken accessToken0) {
            q.g(s, "activityName");
            return new InternalAppEventsLogger(s, s1, accessToken0);
        }

        public static InternalAppEventsLogger createInstance$default(Companion internalAppEventsLogger$Companion0, Context context0, String s, int v, Object object0) {
            if((v & 2) != 0) {
                s = null;
            }
            return internalAppEventsLogger$Companion0.createInstance(context0, s);
        }

        @NotNull
        public final Executor getAnalyticsExecutor() {
            return AppEventsLoggerImpl.Companion.getAnalyticsExecutor();
        }

        @NotNull
        public final FlushBehavior getFlushBehavior() {
            return AppEventsLoggerImpl.Companion.getFlushBehavior();
        }

        @Nullable
        public final String getPushNotificationsRegistrationId() {
            return AppEventsLoggerImpl.Companion.getPushNotificationsRegistrationId();
        }

        public final void setInternalUserData(@NotNull Map map0) {
            q.g(map0, "ud");
            UserDataStore.setInternalUd(map0);
        }

        public final void setUserData(@Nullable Bundle bundle0) {
            UserDataStore.setUserDataAndHash(bundle0);
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final AppEventsLoggerImpl loggerImpl;

    static {
        InternalAppEventsLogger.Companion = new Companion(null);
    }

    public InternalAppEventsLogger(@Nullable Context context0) {
        this(new AppEventsLoggerImpl(context0, null, null));
    }

    public InternalAppEventsLogger(@Nullable Context context0, @Nullable String s) {
        this(new AppEventsLoggerImpl(context0, s, null));
    }

    public InternalAppEventsLogger(@NotNull AppEventsLoggerImpl appEventsLoggerImpl0) {
        q.g(appEventsLoggerImpl0, "loggerImpl");
        super();
        this.loggerImpl = appEventsLoggerImpl0;
    }

    public InternalAppEventsLogger(@NotNull String s, @Nullable String s1, @Nullable AccessToken accessToken0) {
        q.g(s, "activityName");
        this(new AppEventsLoggerImpl(s, s1, accessToken0));
    }

    @NotNull
    public static final InternalAppEventsLogger createInstance(@Nullable Context context0) {
        return InternalAppEventsLogger.Companion.createInstance(context0);
    }

    @NotNull
    public static final InternalAppEventsLogger createInstance(@Nullable Context context0, @Nullable String s) {
        return InternalAppEventsLogger.Companion.createInstance(context0, s);
    }

    @NotNull
    public static final InternalAppEventsLogger createInstance(@NotNull String s, @Nullable String s1, @Nullable AccessToken accessToken0) {
        return InternalAppEventsLogger.Companion.createInstance(s, s1, accessToken0);
    }

    public final void flush() {
        this.loggerImpl.flush();
    }

    @NotNull
    public static final Executor getAnalyticsExecutor() {
        return InternalAppEventsLogger.Companion.getAnalyticsExecutor();
    }

    @NotNull
    public static final FlushBehavior getFlushBehavior() {
        return InternalAppEventsLogger.Companion.getFlushBehavior();
    }

    @Nullable
    public static final String getPushNotificationsRegistrationId() {
        return InternalAppEventsLogger.Companion.getPushNotificationsRegistrationId();
    }

    public final void logChangedSettingsEvent(@NotNull Bundle bundle0) {
        q.g(bundle0, "parameters");
        if((bundle0.getInt("previous") & 2) == 0 && !FacebookSdk.getAutoLogAppEventsEnabled()) {
            return;
        }
        this.loggerImpl.logEventImplicitly("fb_sdk_settings_changed", null, bundle0);
    }

    public final void logEvent(@Nullable String s, double f, @Nullable Bundle bundle0) {
        if(FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEvent(s, f, bundle0);
        }
    }

    public final void logEvent(@Nullable String s, @Nullable Bundle bundle0) {
        if(FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEvent(s, bundle0);
        }
    }

    public final void logEventFromSE(@Nullable String s, @Nullable String s1) {
        this.loggerImpl.logEventFromSE(s, s1);
    }

    public final void logEventImplicitly(@Nullable String s) {
        if(FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(s, null, null);
        }
    }

    public final void logEventImplicitly(@Nullable String s, @Nullable Bundle bundle0) {
        if(FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(s, null, bundle0);
        }
    }

    public final void logEventImplicitly(@Nullable String s, @Nullable Double double0, @Nullable Bundle bundle0) {
        if(FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(s, double0, bundle0);
        }
    }

    public final void logEventImplicitly(@Nullable String s, @Nullable BigDecimal bigDecimal0, @Nullable Currency currency0, @Nullable Bundle bundle0, @Nullable OperationalData operationalData0) {
        if(FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(s, bigDecimal0, currency0, bundle0, operationalData0);
        }
    }

    public static void logEventImplicitly$default(InternalAppEventsLogger internalAppEventsLogger0, String s, BigDecimal bigDecimal0, Currency currency0, Bundle bundle0, OperationalData operationalData0, int v, Object object0) {
        if((v & 16) != 0) {
            operationalData0 = null;
        }
        internalAppEventsLogger0.logEventImplicitly(s, bigDecimal0, currency0, bundle0, operationalData0);
    }

    public final void logPurchaseImplicitly(@Nullable BigDecimal bigDecimal0, @Nullable Currency currency0, @Nullable Bundle bundle0, @Nullable OperationalData operationalData0) {
        if(FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logPurchaseImplicitly(bigDecimal0, currency0, bundle0, operationalData0);
        }
    }

    public static void logPurchaseImplicitly$default(InternalAppEventsLogger internalAppEventsLogger0, BigDecimal bigDecimal0, Currency currency0, Bundle bundle0, OperationalData operationalData0, int v, Object object0) {
        if((v & 8) != 0) {
            operationalData0 = null;
        }
        internalAppEventsLogger0.logPurchaseImplicitly(bigDecimal0, currency0, bundle0, operationalData0);
    }

    public static final void setInternalUserData(@NotNull Map map0) {
        InternalAppEventsLogger.Companion.setInternalUserData(map0);
    }

    public static final void setUserData(@Nullable Bundle bundle0) {
        InternalAppEventsLogger.Companion.setUserData(bundle0);
    }
}

