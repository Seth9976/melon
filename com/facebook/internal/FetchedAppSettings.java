package com.facebook.internal;

import Tf.o;
import android.net.Uri;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b7\u0018\u0000 a2\u00020\u0001:\u0002abB\u008F\u0003\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0002\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t\u0012\u001E\u0010\u000E\u001A\u001A\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f0\f\u0012\u0006\u0010\u000F\u001A\u00020\u0002\u0012\u0006\u0010\u0011\u001A\u00020\u0010\u0012\u0006\u0010\u0012\u001A\u00020\u0004\u0012\u0006\u0010\u0013\u001A\u00020\u0004\u0012\u0006\u0010\u0014\u001A\u00020\u0002\u0012\u0006\u0010\u0015\u001A\u00020\u0002\u0012\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0018\u001A\u00020\u0004\u0012\u0006\u0010\u0019\u001A\u00020\u0002\u0012\u0006\u0010\u001A\u001A\u00020\u0002\u0012\b\u0010\u001B\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u001C\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u001D\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u001E\u001A\u0004\u0018\u00010\u0016\u0012\b\u0010\u001F\u001A\u0004\u0018\u00010\u0016\u0012\u0014\u0010 \u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f\u0012\b\u0010!\u001A\u0004\u0018\u00010\u0016\u0012\b\u0010\"\u001A\u0004\u0018\u00010\u0016\u0012\b\u0010#\u001A\u0004\u0018\u00010\u0016\u0012\b\u0010$\u001A\u0004\u0018\u00010\u0016\u0012\b\u0010%\u001A\u0004\u0018\u00010\u0016\u0012\u000E\u0010\'\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&\u0012\u000E\u0010(\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&\u0012 \u0010*\u001A\u001C\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&0)\u0018\u00010&\u0012 \u0010+\u001A\u001C\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&0)\u0018\u00010&\u0012\b\u0010-\u001A\u0004\u0018\u00010,\u00A2\u0006\u0004\b.\u0010/J\r\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0003\u00100R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u00101R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u00102\u001A\u0004\b3\u00104R\u0017\u0010\u0006\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0006\u00101\u001A\u0004\b5\u00100R\u0017\u0010\b\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b\b\u00106\u001A\u0004\b7\u00108R\u001D\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00A2\u0006\f\n\u0004\b\u000B\u00109\u001A\u0004\b:\u0010;R/\u0010\u000E\u001A\u001A\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f0\f8\u0006\u00A2\u0006\f\n\u0004\b\u000E\u0010<\u001A\u0004\b=\u0010>R\u0017\u0010\u000F\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u000F\u00101\u001A\u0004\b?\u00100R\u0017\u0010\u0011\u001A\u00020\u00108\u0006\u00A2\u0006\f\n\u0004\b\u0011\u0010@\u001A\u0004\bA\u0010BR\u0017\u0010\u0012\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0012\u00102\u001A\u0004\bC\u00104R\u0017\u0010\u0013\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0013\u00102\u001A\u0004\bD\u00104R\u0017\u0010\u0014\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0014\u00101\u001A\u0004\bE\u00100R\u0017\u0010\u0015\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0015\u00101\u001A\u0004\bF\u00100R\u0019\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0006\u00A2\u0006\f\n\u0004\b\u0017\u0010G\u001A\u0004\bH\u0010IR\u0017\u0010\u0018\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0018\u00102\u001A\u0004\bJ\u00104R\u0017\u0010\u0019\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0019\u00101\u001A\u0004\bK\u00100R\u0017\u0010\u001A\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u001A\u00101\u001A\u0004\bL\u00100R\u0019\u0010\u001B\u001A\u0004\u0018\u00010\u00048\u0006\u00A2\u0006\f\n\u0004\b\u001B\u00102\u001A\u0004\bM\u00104R\u0019\u0010\u001C\u001A\u0004\u0018\u00010\u00048\u0006\u00A2\u0006\f\n\u0004\b\u001C\u00102\u001A\u0004\bN\u00104R\u0019\u0010\u001D\u001A\u0004\u0018\u00010\u00048\u0006\u00A2\u0006\f\n\u0004\b\u001D\u00102\u001A\u0004\bO\u00104R\u0019\u0010\u001E\u001A\u0004\u0018\u00010\u00168\u0006\u00A2\u0006\f\n\u0004\b\u001E\u0010G\u001A\u0004\bP\u0010IR\u0019\u0010\u001F\u001A\u0004\u0018\u00010\u00168\u0006\u00A2\u0006\f\n\u0004\b\u001F\u0010G\u001A\u0004\bQ\u0010IR%\u0010 \u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006\u00A2\u0006\f\n\u0004\b \u0010<\u001A\u0004\bR\u0010>R\u0019\u0010!\u001A\u0004\u0018\u00010\u00168\u0006\u00A2\u0006\f\n\u0004\b!\u0010G\u001A\u0004\bS\u0010IR\u0019\u0010\"\u001A\u0004\u0018\u00010\u00168\u0006\u00A2\u0006\f\n\u0004\b\"\u0010G\u001A\u0004\bT\u0010IR\u0019\u0010#\u001A\u0004\u0018\u00010\u00168\u0006\u00A2\u0006\f\n\u0004\b#\u0010G\u001A\u0004\bU\u0010IR\u0019\u0010$\u001A\u0004\u0018\u00010\u00168\u0006\u00A2\u0006\f\n\u0004\b$\u0010G\u001A\u0004\bV\u0010IR\u0019\u0010%\u001A\u0004\u0018\u00010\u00168\u0006\u00A2\u0006\f\n\u0004\b%\u0010G\u001A\u0004\bW\u0010IR\u001F\u0010\'\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&8\u0006\u00A2\u0006\f\n\u0004\b\'\u0010X\u001A\u0004\bY\u0010ZR\u001F\u0010(\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&8\u0006\u00A2\u0006\f\n\u0004\b(\u0010X\u001A\u0004\b[\u0010ZR1\u0010*\u001A\u001C\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&0)\u0018\u00010&8\u0006\u00A2\u0006\f\n\u0004\b*\u0010X\u001A\u0004\b\\\u0010ZR1\u0010+\u001A\u001C\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&0)\u0018\u00010&8\u0006\u00A2\u0006\f\n\u0004\b+\u0010X\u001A\u0004\b]\u0010ZR\u0019\u0010-\u001A\u0004\u0018\u00010,8\u0006\u00A2\u0006\f\n\u0004\b-\u0010^\u001A\u0004\b_\u0010`\u00A8\u0006c"}, d2 = {"Lcom/facebook/internal/FetchedAppSettings;", "", "", "supportsImplicitLogging", "", "nuxContent", "nuxEnabled", "", "sessionTimeoutInSeconds", "Ljava/util/EnumSet;", "Lcom/facebook/internal/SmartLoginOption;", "smartLoginOptions", "", "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "dialogConfigurations", "automaticLoggingEnabled", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "errorClassification", "smartLoginBookmarkIconURL", "smartLoginMenuIconURL", "iAPAutomaticLoggingEnabled", "codelessEventsEnabled", "Lorg/json/JSONArray;", "eventBindings", "sdkUpdateMessage", "trackUninstallEnabled", "monitorViaDialogEnabled", "rawAamRules", "suggestedEventsSetting", "restrictiveDataSetting", "protectedModeStandardParamsSetting", "MACARuleMatchingSetting", "migratedAutoLogValues", "blocklistEvents", "redactedEvents", "sensitiveParams", "schemaRestrictions", "bannedParams", "", "currencyDedupeParameters", "purchaseValueDedupeParameters", "Lie/m;", "prodDedupeParameters", "testDedupeParameters", "", "dedupeWindow", "<init>", "(ZLjava/lang/String;ZILjava/util/EnumSet;Ljava/util/Map;ZLcom/facebook/internal/FacebookRequestErrorClassification;Ljava/lang/String;Ljava/lang/String;ZZLorg/json/JSONArray;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;Lorg/json/JSONArray;Ljava/util/Map;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;)V", "()Z", "Z", "Ljava/lang/String;", "getNuxContent", "()Ljava/lang/String;", "getNuxEnabled", "I", "getSessionTimeoutInSeconds", "()I", "Ljava/util/EnumSet;", "getSmartLoginOptions", "()Ljava/util/EnumSet;", "Ljava/util/Map;", "getDialogConfigurations", "()Ljava/util/Map;", "getAutomaticLoggingEnabled", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "getErrorClassification", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "getSmartLoginBookmarkIconURL", "getSmartLoginMenuIconURL", "getIAPAutomaticLoggingEnabled", "getCodelessEventsEnabled", "Lorg/json/JSONArray;", "getEventBindings", "()Lorg/json/JSONArray;", "getSdkUpdateMessage", "getTrackUninstallEnabled", "getMonitorViaDialogEnabled", "getRawAamRules", "getSuggestedEventsSetting", "getRestrictiveDataSetting", "getProtectedModeStandardParamsSetting", "getMACARuleMatchingSetting", "getMigratedAutoLogValues", "getBlocklistEvents", "getRedactedEvents", "getSensitiveParams", "getSchemaRestrictions", "getBannedParams", "Ljava/util/List;", "getCurrencyDedupeParameters", "()Ljava/util/List;", "getPurchaseValueDedupeParameters", "getProdDedupeParameters", "getTestDedupeParameters", "Ljava/lang/Long;", "getDedupeWindow", "()Ljava/lang/Long;", "Companion", "DialogFeatureConfig", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FetchedAppSettings {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/internal/FetchedAppSettings$Companion;", "", "()V", "getDialogFeatureConfig", "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "applicationId", "", "actionName", "featureName", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final DialogFeatureConfig getDialogFeatureConfig(@NotNull String s, @NotNull String s1, @NotNull String s2) {
            q.g(s, "applicationId");
            q.g(s1, "actionName");
            q.g(s2, "featureName");
            if(s1.length() == 0 || s2.length() == 0) {
                return null;
            }
            FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(s);
            if(fetchedAppSettings0 != null) {
                Map map0 = fetchedAppSettings0.getDialogConfigurations();
                if(map0 != null) {
                    Map map1 = (Map)map0.get(s1);
                    return map1 == null ? null : ((DialogFeatureConfig)map1.get(s2));
                }
            }
            throw new NullPointerException();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B+\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000BR\u0013\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "", "dialogName", "", "featureName", "fallbackUrl", "Landroid/net/Uri;", "versionSpec", "", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;[I)V", "getDialogName", "()Ljava/lang/String;", "getFallbackUrl", "()Landroid/net/Uri;", "getFeatureName", "getVersionSpec", "()[I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class DialogFeatureConfig {
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000BJ\u0014\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig$Companion;", "", "()V", "DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR", "", "DIALOG_CONFIG_NAME_KEY", "DIALOG_CONFIG_URL_KEY", "DIALOG_CONFIG_VERSIONS_KEY", "parseDialogConfig", "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "dialogConfigJSON", "Lorg/json/JSONObject;", "parseVersionSpec", "", "versionsJSON", "Lorg/json/JSONArray;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.internal.FetchedAppSettings.DialogFeatureConfig.Companion {
            private com.facebook.internal.FetchedAppSettings.DialogFeatureConfig.Companion() {
            }

            public com.facebook.internal.FetchedAppSettings.DialogFeatureConfig.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @Nullable
            public final DialogFeatureConfig parseDialogConfig(@NotNull JSONObject jSONObject0) {
                q.g(jSONObject0, "dialogConfigJSON");
                String s = jSONObject0.optString("name");
                Uri uri0 = null;
                if(!Utility.isNullOrEmpty(s)) {
                    q.f(s, "dialogNameWithFeature");
                    List list0 = o.R0(s, new String[]{"|"}, 0, 6);
                    if(list0.size() == 2) {
                        Object object0 = p.k0(list0);
                        Object object1 = p.s0(list0);
                        if(!Utility.isNullOrEmpty(((String)object0)) && !Utility.isNullOrEmpty(((String)object1))) {
                            String s1 = jSONObject0.optString("url");
                            if(!Utility.isNullOrEmpty(s1)) {
                                uri0 = Uri.parse(s1);
                            }
                            return new DialogFeatureConfig(((String)object0), ((String)object1), uri0, this.parseVersionSpec(jSONObject0.optJSONArray("versions")), null);
                        }
                    }
                }
                return null;
            }

            private final int[] parseVersionSpec(JSONArray jSONArray0) {
                if(jSONArray0 != null) {
                    int v = jSONArray0.length();
                    int[] arr_v = new int[v];
                    for(int v1 = 0; v1 < v; ++v1) {
                        int v2 = -1;
                        int v3 = jSONArray0.optInt(v1, -1);
                        if(v3 == -1) {
                            String s = jSONArray0.optString(v1);
                            if(!Utility.isNullOrEmpty(s)) {
                                try {
                                    q.f(s, "versionString");
                                    v2 = Integer.parseInt(s);
                                }
                                catch(NumberFormatException numberFormatException0) {
                                    Utility.logd("FacebookSDK", numberFormatException0);
                                }
                                v3 = v2;
                            }
                        }
                        arr_v[v1] = v3;
                    }
                    return arr_v;
                }
                return null;
            }
        }

        @NotNull
        public static final com.facebook.internal.FetchedAppSettings.DialogFeatureConfig.Companion Companion = null;
        @NotNull
        private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "|";
        @NotNull
        private static final String DIALOG_CONFIG_NAME_KEY = "name";
        @NotNull
        private static final String DIALOG_CONFIG_URL_KEY = "url";
        @NotNull
        private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
        @NotNull
        private final String dialogName;
        @Nullable
        private final Uri fallbackUrl;
        @NotNull
        private final String featureName;
        @Nullable
        private final int[] versionSpec;

        static {
            DialogFeatureConfig.Companion = new com.facebook.internal.FetchedAppSettings.DialogFeatureConfig.Companion(null);
        }

        private DialogFeatureConfig(String s, String s1, Uri uri0, int[] arr_v) {
            this.dialogName = s;
            this.featureName = s1;
            this.fallbackUrl = uri0;
            this.versionSpec = arr_v;
        }

        public DialogFeatureConfig(String s, String s1, Uri uri0, int[] arr_v, DefaultConstructorMarker defaultConstructorMarker0) {
            this(s, s1, uri0, arr_v);
        }

        @NotNull
        public final String getDialogName() {
            return this.dialogName;
        }

        @Nullable
        public final Uri getFallbackUrl() {
            return this.fallbackUrl;
        }

        @NotNull
        public final String getFeatureName() {
            return this.featureName;
        }

        @Nullable
        public final int[] getVersionSpec() {
            return this.versionSpec;
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private final JSONArray MACARuleMatchingSetting;
    private final boolean automaticLoggingEnabled;
    @Nullable
    private final JSONArray bannedParams;
    @Nullable
    private final JSONArray blocklistEvents;
    private final boolean codelessEventsEnabled;
    @Nullable
    private final List currencyDedupeParameters;
    @Nullable
    private final Long dedupeWindow;
    @NotNull
    private final Map dialogConfigurations;
    @NotNull
    private final FacebookRequestErrorClassification errorClassification;
    @Nullable
    private final JSONArray eventBindings;
    private final boolean iAPAutomaticLoggingEnabled;
    @Nullable
    private final Map migratedAutoLogValues;
    private final boolean monitorViaDialogEnabled;
    @NotNull
    private final String nuxContent;
    private final boolean nuxEnabled;
    @Nullable
    private final List prodDedupeParameters;
    @Nullable
    private final JSONArray protectedModeStandardParamsSetting;
    @Nullable
    private final List purchaseValueDedupeParameters;
    @Nullable
    private final String rawAamRules;
    @Nullable
    private final JSONArray redactedEvents;
    @Nullable
    private final String restrictiveDataSetting;
    @Nullable
    private final JSONArray schemaRestrictions;
    @NotNull
    private final String sdkUpdateMessage;
    @Nullable
    private final JSONArray sensitiveParams;
    private final int sessionTimeoutInSeconds;
    @NotNull
    private final String smartLoginBookmarkIconURL;
    @NotNull
    private final String smartLoginMenuIconURL;
    @NotNull
    private final EnumSet smartLoginOptions;
    @Nullable
    private final String suggestedEventsSetting;
    private final boolean supportsImplicitLogging;
    @Nullable
    private final List testDedupeParameters;
    private final boolean trackUninstallEnabled;

    static {
        FetchedAppSettings.Companion = new Companion(null);
    }

    public FetchedAppSettings(boolean z, @NotNull String s, boolean z1, int v, @NotNull EnumSet enumSet0, @NotNull Map map0, boolean z2, @NotNull FacebookRequestErrorClassification facebookRequestErrorClassification0, @NotNull String s1, @NotNull String s2, boolean z3, boolean z4, @Nullable JSONArray jSONArray0, @NotNull String s3, boolean z5, boolean z6, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable JSONArray jSONArray1, @Nullable JSONArray jSONArray2, @Nullable Map map1, @Nullable JSONArray jSONArray3, @Nullable JSONArray jSONArray4, @Nullable JSONArray jSONArray5, @Nullable JSONArray jSONArray6, @Nullable JSONArray jSONArray7, @Nullable List list0, @Nullable List list1, @Nullable List list2, @Nullable List list3, @Nullable Long long0) {
        q.g(s, "nuxContent");
        q.g(enumSet0, "smartLoginOptions");
        q.g(map0, "dialogConfigurations");
        q.g(facebookRequestErrorClassification0, "errorClassification");
        q.g(s1, "smartLoginBookmarkIconURL");
        q.g(s2, "smartLoginMenuIconURL");
        q.g(s3, "sdkUpdateMessage");
        super();
        this.supportsImplicitLogging = z;
        this.nuxContent = s;
        this.nuxEnabled = z1;
        this.sessionTimeoutInSeconds = v;
        this.smartLoginOptions = enumSet0;
        this.dialogConfigurations = map0;
        this.automaticLoggingEnabled = z2;
        this.errorClassification = facebookRequestErrorClassification0;
        this.smartLoginBookmarkIconURL = s1;
        this.smartLoginMenuIconURL = s2;
        this.iAPAutomaticLoggingEnabled = z3;
        this.codelessEventsEnabled = z4;
        this.eventBindings = jSONArray0;
        this.sdkUpdateMessage = s3;
        this.trackUninstallEnabled = z5;
        this.monitorViaDialogEnabled = z6;
        this.rawAamRules = s4;
        this.suggestedEventsSetting = s5;
        this.restrictiveDataSetting = s6;
        this.protectedModeStandardParamsSetting = jSONArray1;
        this.MACARuleMatchingSetting = jSONArray2;
        this.migratedAutoLogValues = map1;
        this.blocklistEvents = jSONArray3;
        this.redactedEvents = jSONArray4;
        this.sensitiveParams = jSONArray5;
        this.schemaRestrictions = jSONArray6;
        this.bannedParams = jSONArray7;
        this.currencyDedupeParameters = list0;
        this.purchaseValueDedupeParameters = list1;
        this.prodDedupeParameters = list2;
        this.testDedupeParameters = list3;
        this.dedupeWindow = long0;
    }

    public final boolean getAutomaticLoggingEnabled() {
        return this.automaticLoggingEnabled;
    }

    @Nullable
    public final JSONArray getBannedParams() {
        return this.bannedParams;
    }

    @Nullable
    public final JSONArray getBlocklistEvents() {
        return this.blocklistEvents;
    }

    public final boolean getCodelessEventsEnabled() {
        return this.codelessEventsEnabled;
    }

    @Nullable
    public final List getCurrencyDedupeParameters() {
        return this.currencyDedupeParameters;
    }

    @Nullable
    public final Long getDedupeWindow() {
        return this.dedupeWindow;
    }

    @NotNull
    public final Map getDialogConfigurations() {
        return this.dialogConfigurations;
    }

    @Nullable
    public static final DialogFeatureConfig getDialogFeatureConfig(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        return FetchedAppSettings.Companion.getDialogFeatureConfig(s, s1, s2);
    }

    @NotNull
    public final FacebookRequestErrorClassification getErrorClassification() {
        return this.errorClassification;
    }

    @Nullable
    public final JSONArray getEventBindings() {
        return this.eventBindings;
    }

    public final boolean getIAPAutomaticLoggingEnabled() {
        return this.iAPAutomaticLoggingEnabled;
    }

    @Nullable
    public final JSONArray getMACARuleMatchingSetting() {
        return this.MACARuleMatchingSetting;
    }

    @Nullable
    public final Map getMigratedAutoLogValues() {
        return this.migratedAutoLogValues;
    }

    public final boolean getMonitorViaDialogEnabled() {
        return this.monitorViaDialogEnabled;
    }

    @NotNull
    public final String getNuxContent() {
        return this.nuxContent;
    }

    public final boolean getNuxEnabled() {
        return this.nuxEnabled;
    }

    @Nullable
    public final List getProdDedupeParameters() {
        return this.prodDedupeParameters;
    }

    @Nullable
    public final JSONArray getProtectedModeStandardParamsSetting() {
        return this.protectedModeStandardParamsSetting;
    }

    @Nullable
    public final List getPurchaseValueDedupeParameters() {
        return this.purchaseValueDedupeParameters;
    }

    @Nullable
    public final String getRawAamRules() {
        return this.rawAamRules;
    }

    @Nullable
    public final JSONArray getRedactedEvents() {
        return this.redactedEvents;
    }

    @Nullable
    public final String getRestrictiveDataSetting() {
        return this.restrictiveDataSetting;
    }

    @Nullable
    public final JSONArray getSchemaRestrictions() {
        return this.schemaRestrictions;
    }

    @NotNull
    public final String getSdkUpdateMessage() {
        return this.sdkUpdateMessage;
    }

    @Nullable
    public final JSONArray getSensitiveParams() {
        return this.sensitiveParams;
    }

    public final int getSessionTimeoutInSeconds() {
        return this.sessionTimeoutInSeconds;
    }

    @NotNull
    public final String getSmartLoginBookmarkIconURL() {
        return this.smartLoginBookmarkIconURL;
    }

    @NotNull
    public final String getSmartLoginMenuIconURL() {
        return this.smartLoginMenuIconURL;
    }

    @NotNull
    public final EnumSet getSmartLoginOptions() {
        return this.smartLoginOptions;
    }

    @Nullable
    public final String getSuggestedEventsSetting() {
        return this.suggestedEventsSetting;
    }

    @Nullable
    public final List getTestDedupeParameters() {
        return this.testDedupeParameters;
    }

    public final boolean getTrackUninstallEnabled() {
        return this.trackUninstallEnabled;
    }

    public final boolean supportsImplicitLogging() {
        return this.supportsImplicitLogging;
    }
}

