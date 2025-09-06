package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.OperationalData.Companion;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.OperationalDataEnum;
import com.facebook.appevents.iap.InAppPurchase;
import com.facebook.appevents.iap.InAppPurchaseDedupeConfig;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.iap.InAppPurchaseUtils.BillingClientVersion;
import com.facebook.appevents.iap.InAppPurchaseUtils.IAPProductType;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import e.k;
import ie.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00C7\u0002\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0003J!\u0010\n\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\t\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\n\u0010\u000BJ;\u0010\u0013\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001A\u00020\u000EH\u0007\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0019\u001A\u0004\u0018\u00010\u00182\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\'\u0010\u001C\u001A\u0004\u0018\u00010\u00182\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001B\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\u000EH\u0007\u00A2\u0006\u0004\b\u001E\u0010\u001FJ1\u0010 \u001A\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0002\u00A2\u0006\u0004\b \u0010!J7\u0010)\u001A\u00020\u00162\u0006\u0010\"\u001A\u00020\u00062\u0006\u0010#\u001A\u00020\u00182\u0006\u0010%\u001A\u00020$2\u0006\u0010\'\u001A\u00020&2\u0006\u0010(\u001A\u00020&H\u0002\u00A2\u0006\u0004\b)\u0010*J7\u0010+\u001A\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\"\u001A\u00020\u00062\u0006\u0010#\u001A\u00020\u00182\u0006\u0010%\u001A\u00020$2\u0006\u0010(\u001A\u00020&H\u0002\u00A2\u0006\u0004\b+\u0010,JE\u0010 \u001A\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u00062\u0012\u0010.\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060-2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0002\u00A2\u0006\u0004\b \u0010/R\u001C\u00101\u001A\n 0*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b3\u00102R\u0014\u00105\u001A\u0002048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b5\u00106\u00A8\u00068"}, d2 = {"Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger;", "", "<init>", "()V", "Lie/H;", "logActivateAppEvent", "", "activityName", "", "timeSpentInSeconds", "logActivityTimeSpentEvent", "(Ljava/lang/String;J)V", "purchase", "skuDetails", "", "isSubscription", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;", "billingClientVersion", "isFirstAppLaunch", "logPurchase", "(Ljava/lang/String;Ljava/lang/String;ZLcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;Z)V", "", "Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger$PurchaseLoggingParameters;", "purchaseLoggingParametersList", "Landroid/os/Bundle;", "getPurchaseDedupeParameters", "(Ljava/util/List;)Landroid/os/Bundle;", "eventName", "getSubscriptionDedupeParameters", "(Ljava/util/List;Ljava/lang/String;)Landroid/os/Bundle;", "isImplicitPurchaseLoggingEnabled", "()Z", "getPurchaseLoggingParameters", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;)Ljava/util/List;", "type", "params", "Lcom/facebook/appevents/OperationalData;", "operationalData", "Lorg/json/JSONObject;", "purchaseJSON", "skuDetailsJSON", "getPurchaseParametersGPBLV2V4", "(Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;Lorg/json/JSONObject;Lorg/json/JSONObject;)Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger$PurchaseLoggingParameters;", "getPurchaseParametersGPBLV5V7", "(Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;Lorg/json/JSONObject;)Ljava/util/List;", "", "extraParameter", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;)Ljava/util/List;", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "APP_EVENTS_IF_AUTO_LOG_SUBS", "Lcom/facebook/appevents/InternalAppEventsLogger;", "internalAppEventsLogger", "Lcom/facebook/appevents/InternalAppEventsLogger;", "PurchaseLoggingParameters", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AutomaticAnalyticsLogger {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\'\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger$PurchaseLoggingParameters;", "", "purchaseAmount", "Ljava/math/BigDecimal;", "currency", "Ljava/util/Currency;", "param", "Landroid/os/Bundle;", "operationalData", "Lcom/facebook/appevents/OperationalData;", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)V", "getCurrency", "()Ljava/util/Currency;", "setCurrency", "(Ljava/util/Currency;)V", "getOperationalData", "()Lcom/facebook/appevents/OperationalData;", "setOperationalData", "(Lcom/facebook/appevents/OperationalData;)V", "getParam", "()Landroid/os/Bundle;", "setParam", "(Landroid/os/Bundle;)V", "getPurchaseAmount", "()Ljava/math/BigDecimal;", "setPurchaseAmount", "(Ljava/math/BigDecimal;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class PurchaseLoggingParameters {
        @NotNull
        private Currency currency;
        @NotNull
        private OperationalData operationalData;
        @NotNull
        private Bundle param;
        @NotNull
        private BigDecimal purchaseAmount;

        public PurchaseLoggingParameters(@NotNull BigDecimal bigDecimal0, @NotNull Currency currency0, @NotNull Bundle bundle0, @NotNull OperationalData operationalData0) {
            q.g(bigDecimal0, "purchaseAmount");
            q.g(currency0, "currency");
            q.g(bundle0, "param");
            q.g(operationalData0, "operationalData");
            super();
            this.purchaseAmount = bigDecimal0;
            this.currency = currency0;
            this.param = bundle0;
            this.operationalData = operationalData0;
        }

        @NotNull
        public final Currency getCurrency() {
            return this.currency;
        }

        @NotNull
        public final OperationalData getOperationalData() {
            return this.operationalData;
        }

        @NotNull
        public final Bundle getParam() {
            return this.param;
        }

        @NotNull
        public final BigDecimal getPurchaseAmount() {
            return this.purchaseAmount;
        }

        public final void setCurrency(@NotNull Currency currency0) {
            q.g(currency0, "<set-?>");
            this.currency = currency0;
        }

        public final void setOperationalData(@NotNull OperationalData operationalData0) {
            q.g(operationalData0, "<set-?>");
            this.operationalData = operationalData0;
        }

        public final void setParam(@NotNull Bundle bundle0) {
            q.g(bundle0, "<set-?>");
            this.param = bundle0;
        }

        public final void setPurchaseAmount(@NotNull BigDecimal bigDecimal0) {
            q.g(bigDecimal0, "<set-?>");
            this.purchaseAmount = bigDecimal0;
        }
    }

    @NotNull
    private static final String APP_EVENTS_IF_AUTO_LOG_SUBS = "app_events_if_auto_log_subs";
    @NotNull
    public static final AutomaticAnalyticsLogger INSTANCE;
    private static final String TAG;
    @NotNull
    private static final InternalAppEventsLogger internalAppEventsLogger;

    static {
        AutomaticAnalyticsLogger.INSTANCE = new AutomaticAnalyticsLogger();
        AutomaticAnalyticsLogger.TAG = AutomaticAnalyticsLogger.class.getCanonicalName();
        AutomaticAnalyticsLogger.internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
    }

    @Nullable
    public static final Bundle getPurchaseDedupeParameters(@NotNull List list0) {
        synchronized(AutomaticAnalyticsLogger.class) {
            q.g(list0, "purchaseLoggingParametersList");
            PurchaseLoggingParameters automaticAnalyticsLogger$PurchaseLoggingParameters0 = (PurchaseLoggingParameters)list0.get(0);
            return InAppPurchaseManager.performDedupe(k.z(new InAppPurchase("fb_mobile_purchase", automaticAnalyticsLogger$PurchaseLoggingParameters0.getPurchaseAmount().doubleValue(), automaticAnalyticsLogger$PurchaseLoggingParameters0.getCurrency())), System.currentTimeMillis(), true, k.z(new m(automaticAnalyticsLogger$PurchaseLoggingParameters0.getParam(), automaticAnalyticsLogger$PurchaseLoggingParameters0.getOperationalData())));
        }
    }

    private final List getPurchaseLoggingParameters(String s, String s1, BillingClientVersion inAppPurchaseUtils$BillingClientVersion0) {
        return this.getPurchaseLoggingParameters(s, s1, new HashMap(), inAppPurchaseUtils$BillingClientVersion0);
    }

    private final List getPurchaseLoggingParameters(String s, String s1, Map map0, BillingClientVersion inAppPurchaseUtils$BillingClientVersion0) {
        try {
            JSONObject jSONObject0 = new JSONObject(s);
            JSONObject jSONObject1 = new JSONObject(s1);
            Bundle bundle0 = new Bundle(1);
            OperationalData operationalData0 = new OperationalData();
            if(inAppPurchaseUtils$BillingClientVersion0 != null) {
                OperationalData.Companion.addParameter(OperationalDataEnum.IAPParameters, "fb_iap_sdk_supported_library_versions", inAppPurchaseUtils$BillingClientVersion0.getType(), bundle0, operationalData0);
            }
            Companion operationalData$Companion0 = OperationalData.Companion;
            OperationalDataEnum operationalDataEnum0 = OperationalDataEnum.IAPParameters;
            String s2 = jSONObject0.getString("productId");
            q.f(s2, "purchaseJSON.getString(C…stants.GP_IAP_PRODUCT_ID)");
            operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_product_id", s2, bundle0, operationalData0);
            String s3 = jSONObject0.getString("productId");
            q.f(s3, "purchaseJSON.getString(C…stants.GP_IAP_PRODUCT_ID)");
            operationalData$Companion0.addParameter(operationalDataEnum0, "fb_content_id", s3, bundle0, operationalData0);
            operationalData$Companion0.addParameter(operationalDataEnum0, "android_dynamic_ads_content_id", "client_implicit", bundle0, operationalData0);
            String s4 = jSONObject0.getString("purchaseTime");
            q.f(s4, "purchaseJSON.getString(C…nts.GP_IAP_PURCHASE_TIME)");
            operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_purchase_time", s4, bundle0, operationalData0);
            String s5 = jSONObject0.getString("purchaseToken");
            q.f(s5, "purchaseJSON.getString(C…ts.GP_IAP_PURCHASE_TOKEN)");
            operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_purchase_token", s5, bundle0, operationalData0);
            String s6 = jSONObject0.optString("packageName");
            q.f(s6, "purchaseJSON.optString(C…ants.GP_IAP_PACKAGE_NAME)");
            operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_package_name", s6, bundle0, operationalData0);
            String s7 = jSONObject1.optString("title");
            q.f(s7, "skuDetailsJSON.optString(Constants.GP_IAP_TITLE)");
            operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_product_title", s7, bundle0, operationalData0);
            String s8 = jSONObject1.optString("description");
            q.f(s8, "skuDetailsJSON.optString…tants.GP_IAP_DESCRIPTION)");
            operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_product_description", s8, bundle0, operationalData0);
            String s9 = jSONObject1.optString("type");
            q.f(s9, "type");
            operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_product_type", s9, bundle0, operationalData0);
            String s10 = InAppPurchaseManager.getSpecificBillingLibraryVersion();
            if(s10 != null) {
                operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_client_library_version", s10, bundle0, operationalData0);
            }
            for(Object object0: map0.entrySet()) {
                Object object1 = ((Map.Entry)object0).getKey();
                Object object2 = ((Map.Entry)object0).getValue();
                OperationalData.Companion.addParameter(OperationalDataEnum.IAPParameters, ((String)object1), ((String)object2), bundle0, operationalData0);
            }
            if(jSONObject1.has("price_amount_micros")) {
                return k.C(new PurchaseLoggingParameters[]{this.getPurchaseParametersGPBLV2V4(s9, bundle0, operationalData0, jSONObject0, jSONObject1)});
            }
            return jSONObject1.has("subscriptionOfferDetails") || jSONObject1.has("oneTimePurchaseOfferDetails") ? this.getPurchaseParametersGPBLV5V7(s9, bundle0, operationalData0, jSONObject1) : null;
        }
        catch(JSONException jSONException0) {
        }
        catch(Exception exception0) {
            Log.e(AutomaticAnalyticsLogger.TAG, "Failed to get purchase logging parameters,", exception0);
            return null;
        }
        Log.e(AutomaticAnalyticsLogger.TAG, "Error parsing in-app purchase/subscription data.", jSONException0);
        return null;
    }

    private final PurchaseLoggingParameters getPurchaseParametersGPBLV2V4(String s, Bundle bundle0, OperationalData operationalData0, JSONObject jSONObject0, JSONObject jSONObject1) {
        if(q.b(s, IAPProductType.SUBS.getType())) {
            Companion operationalData$Companion0 = OperationalData.Companion;
            OperationalDataEnum operationalDataEnum0 = OperationalDataEnum.IAPParameters;
            String s1 = Boolean.toString(jSONObject0.optBoolean("autoRenewing", false));
            q.f(s1, "toString(\n              …      )\n                )");
            operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_subs_auto_renewing", s1, bundle0, operationalData0);
            String s2 = jSONObject1.optString("subscriptionPeriod");
            q.f(s2, "skuDetailsJSON.optString…_IAP_SUBSCRIPTION_PERIOD)");
            operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_subs_period", s2, bundle0, operationalData0);
            String s3 = jSONObject1.optString("freeTrialPeriod");
            q.f(s3, "skuDetailsJSON.optString…GP_IAP_FREE_TRIAL_PERIOD)");
            operationalData$Companion0.addParameter(operationalDataEnum0, "fb_free_trial_period", s3, bundle0, operationalData0);
            String s4 = jSONObject1.optString("introductoryPriceCycles");
            q.f(s4, "introductoryPriceCycles");
            if(s4.length() > 0) {
                operationalData$Companion0.addParameter(operationalDataEnum0, "fb_intro_price_cycles", s4, bundle0, operationalData0);
            }
            String s5 = jSONObject1.optString("introductoryPricePeriod");
            q.f(s5, "introductoryPricePeriod");
            if(s5.length() > 0) {
                operationalData$Companion0.addParameter(operationalDataEnum0, "fb_intro_period", s5, bundle0, operationalData0);
            }
            String s6 = jSONObject1.optString("introductoryPriceAmountMicros");
            q.f(s6, "introductoryPriceAmountMicros");
            if(s6.length() > 0) {
                operationalData$Companion0.addParameter(operationalDataEnum0, "fb_intro_price_amount_micros", s6, bundle0, operationalData0);
            }
        }
        BigDecimal bigDecimal0 = new BigDecimal(((double)jSONObject1.getLong("price_amount_micros")) / 1000000.0);
        Currency currency0 = Currency.getInstance(jSONObject1.getString("price_currency_code"));
        q.f(currency0, "getInstance(skuDetailsJS…RICE_CURRENCY_CODE_V2V4))");
        return new PurchaseLoggingParameters(bigDecimal0, currency0, bundle0, operationalData0);
    }

    private final List getPurchaseParametersGPBLV5V7(String s, Bundle bundle0, OperationalData operationalData0, JSONObject jSONObject0) {
        if(q.b(s, IAPProductType.SUBS.getType())) {
            List list0 = new ArrayList();
            JSONArray jSONArray0 = jSONObject0.getJSONArray("subscriptionOfferDetails");
            if(jSONArray0 == null) {
                return null;
            }
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                JSONObject jSONObject1 = jSONObject0.getJSONArray("subscriptionOfferDetails").getJSONObject(v1);
                if(jSONObject1 == null) {
                    return null;
                }
                Bundle bundle1 = new Bundle(bundle0);
                OperationalData operationalData1 = operationalData0.copy();
                String s1 = jSONObject1.getString("basePlanId");
                OperationalDataEnum operationalDataEnum0 = OperationalDataEnum.IAPParameters;
                q.f(s1, "basePlanId");
                Companion operationalData$Companion0 = OperationalData.Companion;
                operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_base_plan", s1, bundle1, operationalData1);
                JSONArray jSONArray1 = jSONObject1.getJSONArray("pricingPhases");
                JSONObject jSONObject2 = jSONArray1.getJSONObject(jSONArray1.length() - 1);
                if(jSONObject2 == null) {
                    return null;
                }
                String s2 = jSONObject2.optString("billingPeriod");
                q.f(s2, "subscriptionJSON.optStri…IOD\n                    )");
                operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_subs_period", s2, bundle1, operationalData1);
                if(!jSONObject2.has("recurrenceMode") || jSONObject2.getInt("recurrenceMode") == 3) {
                    operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_subs_auto_renewing", "false", bundle1, operationalData1);
                }
                else {
                    operationalData$Companion0.addParameter(operationalDataEnum0, "fb_iap_subs_auto_renewing", "true", bundle1, operationalData1);
                }
                BigDecimal bigDecimal0 = new BigDecimal(((double)jSONObject2.getLong("priceAmountMicros")) / 1000000.0);
                Currency currency0 = Currency.getInstance(jSONObject2.getString("priceCurrencyCode"));
                q.f(currency0, "getInstance(subscription…RICE_CURRENCY_CODE_V5V7))");
                ((ArrayList)list0).add(new PurchaseLoggingParameters(bigDecimal0, currency0, bundle1, operationalData1));
            }
            return list0;
        }
        JSONObject jSONObject3 = jSONObject0.getJSONObject("oneTimePurchaseOfferDetails");
        if(jSONObject3 == null) {
            return null;
        }
        BigDecimal bigDecimal1 = new BigDecimal(((double)jSONObject3.getLong("priceAmountMicros")) / 1000000.0);
        Currency currency1 = Currency.getInstance(jSONObject3.getString("priceCurrencyCode"));
        q.f(currency1, "getInstance(oneTimePurch…RICE_CURRENCY_CODE_V5V7))");
        return k.C(new PurchaseLoggingParameters[]{new PurchaseLoggingParameters(bigDecimal1, currency1, bundle0, operationalData0)});
    }

    @Nullable
    public static final Bundle getSubscriptionDedupeParameters(@NotNull List list0, @NotNull String s) {
        synchronized(AutomaticAnalyticsLogger.class) {
            q.g(list0, "purchaseLoggingParametersList");
            q.g(s, "eventName");
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: list0) {
                arrayList0.add(new InAppPurchase(s, ((PurchaseLoggingParameters)object0).getPurchaseAmount().doubleValue(), ((PurchaseLoggingParameters)object0).getCurrency()));
            }
            long v1 = System.currentTimeMillis();
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, list0));
            for(Object object1: list0) {
                arrayList1.add(new m(((PurchaseLoggingParameters)object1).getParam(), ((PurchaseLoggingParameters)object1).getOperationalData()));
            }
            return InAppPurchaseManager.performDedupe(arrayList0, v1, true, arrayList1);
        }
    }

    public static final boolean isImplicitPurchaseLoggingEnabled() {
        FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return fetchedAppSettings0 != null && FacebookSdk.getAutoLogAppEventsEnabled() && fetchedAppSettings0.getIAPAutomaticLoggingEnabled();
    }

    public static final void logActivateAppEvent() {
        Context context0 = FacebookSdk.getApplicationContext();
        String s = FacebookSdk.getApplicationId();
        if(FacebookSdk.getAutoLogAppEventsEnabled()) {
            if(context0 instanceof Application) {
                AppEventsLogger.Companion.activateApp(((Application)context0), s);
                return;
            }
            Log.w(AutomaticAnalyticsLogger.TAG, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
        }
    }

    public static final void logActivityTimeSpentEvent(@Nullable String s, long v) {
        Context context0 = FacebookSdk.getApplicationContext();
        FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
        if(fetchedAppSettings0 != null && fetchedAppSettings0.getAutomaticLoggingEnabled() && v > 0L) {
            InternalAppEventsLogger internalAppEventsLogger0 = new InternalAppEventsLogger(context0);
            Bundle bundle0 = new Bundle(1);
            bundle0.putCharSequence("fb_aa_time_spent_view_name", s);
            internalAppEventsLogger0.logEvent("fb_aa_time_spent_on_view", ((double)v), bundle0);
        }
    }

    public static final void logPurchase(@NotNull String s, @NotNull String s1, boolean z, @Nullable BillingClientVersion inAppPurchaseUtils$BillingClientVersion0, boolean z1) {
        Bundle bundle0;
        String s3;
        String s2;
        q.g(s, "purchase");
        q.g(s1, "skuDetails");
        if(AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            List list0 = AutomaticAnalyticsLogger.INSTANCE.getPurchaseLoggingParameters(s, s1, inAppPurchaseUtils$BillingClientVersion0);
            if(list0 != null && !list0.isEmpty()) {
                if(!z || !FetchedAppGateKeepersManager.getGateKeeperForKey("app_events_if_auto_log_subs", FacebookSdk.getApplicationId(), false)) {
                    s3 = z1 ? "fb_mobile_purchase_restored" : "fb_mobile_purchase";
                }
                else {
                    if(z1) {
                        s2 = "SubscriptionRestore";
                    }
                    else {
                        s2 = InAppPurchaseEventManager.INSTANCE.hasFreeTrialPeirod(s1) ? "StartTrial" : "Subscribe";
                    }
                    s3 = s2;
                }
                if(!z || !FeatureManager.isEnabled(Feature.AndroidManualImplicitSubsDedupe)) {
                    bundle0 = z || !FeatureManager.isEnabled(Feature.AndroidManualImplicitPurchaseDedupe) ? null : AutomaticAnalyticsLogger.getPurchaseDedupeParameters(list0);
                }
                else {
                    bundle0 = AutomaticAnalyticsLogger.getSubscriptionDedupeParameters(list0, s3);
                }
                Bundle bundle1 = ((PurchaseLoggingParameters)list0.get(0)).getParam();
                OperationalData operationalData0 = ((PurchaseLoggingParameters)list0.get(0)).getOperationalData();
                InAppPurchaseDedupeConfig.INSTANCE.addDedupeParameters(bundle0, bundle1, operationalData0);
                if(!s3.equals("fb_mobile_purchase")) {
                    BigDecimal bigDecimal0 = ((PurchaseLoggingParameters)list0.get(0)).getPurchaseAmount();
                    Currency currency0 = ((PurchaseLoggingParameters)list0.get(0)).getCurrency();
                    Bundle bundle2 = ((PurchaseLoggingParameters)list0.get(0)).getParam();
                    OperationalData operationalData1 = ((PurchaseLoggingParameters)list0.get(0)).getOperationalData();
                    AutomaticAnalyticsLogger.internalAppEventsLogger.logEventImplicitly(s3, bigDecimal0, currency0, bundle2, operationalData1);
                    return;
                }
                BigDecimal bigDecimal1 = ((PurchaseLoggingParameters)list0.get(0)).getPurchaseAmount();
                Currency currency1 = ((PurchaseLoggingParameters)list0.get(0)).getCurrency();
                Bundle bundle3 = ((PurchaseLoggingParameters)list0.get(0)).getParam();
                OperationalData operationalData2 = ((PurchaseLoggingParameters)list0.get(0)).getOperationalData();
                AutomaticAnalyticsLogger.internalAppEventsLogger.logPurchaseImplicitly(bigDecimal1, currency1, bundle3, operationalData2);
            }
        }
    }

    public static void logPurchase$default(String s, String s1, boolean z, BillingClientVersion inAppPurchaseUtils$BillingClientVersion0, boolean z1, int v, Object object0) {
        if((v & 16) != 0) {
            z1 = false;
        }
        AutomaticAnalyticsLogger.logPurchase(s, s1, z, inAppPurchaseUtils$BillingClientVersion0, z1);
    }
}

