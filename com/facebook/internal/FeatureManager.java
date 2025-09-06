package com.facebook.internal;

import Tf.v;
import com.facebook.FacebookSdk;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u0011\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u001D\u001EB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000E\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0015\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\rJ\u0017\u0010\u0016\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\rR\u0014\u0010\u0017\u001A\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R&\u0010\u001B\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001A0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001F"}, d2 = {"Lcom/facebook/internal/FeatureManager;", "", "<init>", "()V", "Lcom/facebook/internal/FeatureManager$Feature;", "feature", "Lcom/facebook/internal/FeatureManager$Callback;", "callback", "Lie/H;", "checkFeature", "(Lcom/facebook/internal/FeatureManager$Feature;Lcom/facebook/internal/FeatureManager$Callback;)V", "", "isEnabled", "(Lcom/facebook/internal/FeatureManager$Feature;)Z", "disableFeature", "(Lcom/facebook/internal/FeatureManager$Feature;)V", "", "className", "getFeature", "(Ljava/lang/String;)Lcom/facebook/internal/FeatureManager$Feature;", "initializeFeatureMapping", "getGKStatus", "defaultStatus", "FEATURE_MANAGER_STORE", "Ljava/lang/String;", "", "", "featureMapping", "Ljava/util/Map;", "Callback", "Feature", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FeatureManager {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FeatureManager$Callback;", "", "", "enabled", "Lie/H;", "onCompleted", "(Z)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Callback {
        void onCompleted(boolean arg1);
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b0\b\u0086\u0001\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00018B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001A\u00020\tJ\b\u0010\n\u001A\u00020\tH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001A\u00020\u00008F¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007j\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001Aj\u0002\b\u001Bj\u0002\b\u001Cj\u0002\b\u001Dj\u0002\b\u001Ej\u0002\b\u001Fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b\'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7¨\u00069"}, d2 = {"Lcom/facebook/internal/FeatureManager$Feature;", "", "code", "", "(Ljava/lang/String;II)V", "parent", "getParent", "()Lcom/facebook/internal/FeatureManager$Feature;", "toKey", "", "toString", "Unknown", "Core", "AppEvents", "CodelessEvents", "CloudBridge", "RestrictiveDataFiltering", "AAM", "PrivacyProtection", "SuggestedEvents", "IntelligentIntegrity", "ModelRequest", "ProtectedMode", "MACARuleMatching", "BlocklistEvents", "FilterRedactedEvents", "FilterSensitiveParams", "StdParamEnforcement", "BannedParamFiltering", "EventDeactivation", "OnDeviceEventProcessing", "OnDevicePostInstallEventProcessing", "IapLogging", "IapLoggingLib2", "IapLoggingLib5To7", "AndroidManualImplicitPurchaseDedupe", "AndroidManualImplicitSubsDedupe", "AndroidIAPSubscriptionAutoLogging", "Instrument", "CrashReport", "CrashShield", "ThreadCheck", "ErrorReport", "AnrReport", "Monitoring", "ServiceUpdateCompliance", "Megatron", "Elora", "GPSARATriggers", "GPSPACAProcessing", "GPSTopicsObservation", "Login", "ChromeCustomTabsPrefetching", "IgnoreAppSwitchToLoggedOut", "BypassAppSwitch", "Share", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum Feature {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FeatureManager$Feature$Companion;", "", "()V", "fromInt", "Lcom/facebook/internal/FeatureManager$Feature;", "code", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final Feature fromInt(int v) {
                Feature[] arr_featureManager$Feature = Feature.values();
                for(int v1 = 0; v1 < arr_featureManager$Feature.length; ++v1) {
                    Feature featureManager$Feature0 = arr_featureManager$Feature[v1];
                    if(featureManager$Feature0.code == v) {
                        return featureManager$Feature0;
                    }
                }
                return Feature.Unknown;
            }
        }

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
        public final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
                int[] arr_v = new int[Feature.values().length];
                try {
                    arr_v[Feature.Core.ordinal()] = 1;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.AppEvents.ordinal()] = 2;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.CodelessEvents.ordinal()] = 3;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.RestrictiveDataFiltering.ordinal()] = 4;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.Instrument.ordinal()] = 5;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.CrashReport.ordinal()] = 6;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.CrashShield.ordinal()] = 7;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.ThreadCheck.ordinal()] = 8;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.ErrorReport.ordinal()] = 9;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.AnrReport.ordinal()] = 10;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.AAM.ordinal()] = 11;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.CloudBridge.ordinal()] = 12;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.PrivacyProtection.ordinal()] = 13;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.SuggestedEvents.ordinal()] = 14;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.IntelligentIntegrity.ordinal()] = 15;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.StdParamEnforcement.ordinal()] = 16;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.ProtectedMode.ordinal()] = 17;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.BannedParamFiltering.ordinal()] = 18;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.MACARuleMatching.ordinal()] = 19;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.BlocklistEvents.ordinal()] = 20;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.FilterRedactedEvents.ordinal()] = 21;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.FilterSensitiveParams.ordinal()] = 22;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.ModelRequest.ordinal()] = 23;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.EventDeactivation.ordinal()] = 24;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.OnDeviceEventProcessing.ordinal()] = 25;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.OnDevicePostInstallEventProcessing.ordinal()] = 26;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.IapLogging.ordinal()] = 27;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.IapLoggingLib2.ordinal()] = 28;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.IapLoggingLib5To7.ordinal()] = 29;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.AndroidManualImplicitPurchaseDedupe.ordinal()] = 30;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.AndroidManualImplicitSubsDedupe.ordinal()] = 0x1F;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.AndroidIAPSubscriptionAutoLogging.ordinal()] = 0x20;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.Monitoring.ordinal()] = 33;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.Megatron.ordinal()] = 34;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.Elora.ordinal()] = 35;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.GPSARATriggers.ordinal()] = 36;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.GPSPACAProcessing.ordinal()] = 37;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.GPSTopicsObservation.ordinal()] = 38;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.ServiceUpdateCompliance.ordinal()] = 39;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.Login.ordinal()] = 40;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.ChromeCustomTabsPrefetching.ordinal()] = 41;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.IgnoreAppSwitchToLoggedOut.ordinal()] = 42;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.BypassAppSwitch.ordinal()] = 43;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Feature.Share.ordinal()] = 44;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                WhenMappings.$EnumSwitchMapping$0 = arr_v;
            }
        }

        Unknown(-1),
        Core(0),
        AppEvents(0x10000),
        CodelessEvents(0x10100),
        CloudBridge(0x10800),
        RestrictiveDataFiltering(0x10200),
        AAM(0x10300),
        PrivacyProtection(0x10400),
        SuggestedEvents(0x10401),
        IntelligentIntegrity(0x10402),
        ModelRequest(0x10403),
        ProtectedMode(0x10404),
        MACARuleMatching(0x10405),
        BlocklistEvents(0x10406),
        FilterRedactedEvents(0x10407),
        FilterSensitiveParams(0x10408),
        StdParamEnforcement(0x1010409),
        BannedParamFiltering(0x101040A),
        EventDeactivation(0x10500),
        OnDeviceEventProcessing(0x10600),
        OnDevicePostInstallEventProcessing(0x10601),
        IapLogging(0x10700),
        IapLoggingLib2(0x10701),
        IapLoggingLib5To7(0x10702),
        AndroidManualImplicitPurchaseDedupe(0x10703),
        AndroidManualImplicitSubsDedupe(0x10704),
        AndroidIAPSubscriptionAutoLogging(0x10705),
        Instrument(0x20000),
        CrashReport(0x20100),
        CrashShield(0x20101),
        ThreadCheck(0x20102),
        ErrorReport(0x20200),
        AnrReport(0x20300),
        Monitoring(0x30000),
        ServiceUpdateCompliance(0x30100),
        Megatron(0x40000),
        Elora(0x50000),
        GPSARATriggers(0x60000),
        GPSPACAProcessing(0x70000),
        GPSTopicsObservation(0x80000),
        Login(0x1000000),
        ChromeCustomTabsPrefetching(0x1010000),
        IgnoreAppSwitchToLoggedOut(0x1020000),
        BypassAppSwitch(0x1030000),
        Share(0x2000000);

        @NotNull
        public static final Companion Companion;
        private final int code;

        private static final Feature[] $values() [...] // Inlined contents

        static {
            Feature.Companion = new Companion(null);
        }

        private Feature(int v1) {
            this.code = v1;
        }

        @NotNull
        public final Feature getParent() {
            int v = this.code;
            if((v & 0xFF) > 0) {
                return Feature.Companion.fromInt(v & 0xFFFFFF00);
            }
            if((0xFF00 & v) > 0) {
                return Feature.Companion.fromInt(v & 0xFFFF0000);
            }
            return (0xFF0000 & v) <= 0 ? Feature.Companion.fromInt(0) : Feature.Companion.fromInt(v & 0xFF000000);
        }

        @NotNull
        public final String toKey() [...] // Inlined contents

        @Override
        @NotNull
        public String toString() {
            switch(WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
                case 1: {
                    return "CoreKit";
                }
                case 2: {
                    return "AppEvents";
                }
                case 3: {
                    return "CodelessEvents";
                }
                case 4: {
                    return "RestrictiveDataFiltering";
                }
                case 5: {
                    return "Instrument";
                }
                case 6: {
                    return "CrashReport";
                }
                case 7: {
                    return "CrashShield";
                }
                case 8: {
                    return "ThreadCheck";
                }
                case 9: {
                    return "ErrorReport";
                }
                case 10: {
                    return "AnrReport";
                }
                case 11: {
                    return "AAM";
                }
                case 12: {
                    return "AppEventsCloudbridge";
                }
                case 13: {
                    return "PrivacyProtection";
                }
                case 14: {
                    return "SuggestedEvents";
                }
                case 15: {
                    return "IntelligentIntegrity";
                }
                case 16: {
                    return "StdParamEnforcement";
                }
                case 17: {
                    return "ProtectedMode";
                }
                case 18: {
                    return "BannedParamFiltering";
                }
                case 19: {
                    return "MACARuleMatching";
                }
                case 20: {
                    return "BlocklistEvents";
                }
                case 21: {
                    return "FilterRedactedEvents";
                }
                case 22: {
                    return "FilterSensitiveParams";
                }
                case 23: {
                    return "ModelRequest";
                }
                case 24: {
                    return "EventDeactivation";
                }
                case 25: {
                    return "OnDeviceEventProcessing";
                }
                case 26: {
                    return "OnDevicePostInstallEventProcessing";
                }
                case 27: {
                    return "IAPLogging";
                }
                case 28: {
                    return "IAPLoggingLib2";
                }
                case 29: {
                    return "IAPLoggingLib5To7";
                }
                case 30: {
                    return "AndroidManualImplicitPurchaseDedupe";
                }
                case 0x1F: {
                    return "AndroidManualImplicitSubsDedupe";
                }
                case 0x20: {
                    return "AndroidIAPSubscriptionAutoLogging";
                }
                case 33: {
                    return "Monitoring";
                }
                case 34: {
                    return "Megatron";
                }
                case 35: {
                    return "Elora";
                }
                case 36: {
                    return "GPSARATriggers";
                }
                case 37: {
                    return "GPSPACAProcessing";
                }
                case 38: {
                    return "GPSTopicsObservation";
                }
                case 39: {
                    return "ServiceUpdateCompliance";
                }
                case 40: {
                    return "LoginKit";
                }
                case 41: {
                    return "ChromeCustomTabsPrefetching";
                }
                case 42: {
                    return "IgnoreAppSwitchToLoggedOut";
                }
                case 43: {
                    return "BypassAppSwitch";
                }
                case 44: {
                    return "ShareKit";
                }
                default: {
                    return "unknown";
                }
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class com.facebook.internal.FeatureManager.WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[Feature.values().length];
            try {
                arr_v[Feature.RestrictiveDataFiltering.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.Instrument.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.CrashReport.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.CrashShield.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.ThreadCheck.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.ErrorReport.ordinal()] = 6;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.AnrReport.ordinal()] = 7;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.AAM.ordinal()] = 8;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.CloudBridge.ordinal()] = 9;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.PrivacyProtection.ordinal()] = 10;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.SuggestedEvents.ordinal()] = 11;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.IntelligentIntegrity.ordinal()] = 12;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.ModelRequest.ordinal()] = 13;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.EventDeactivation.ordinal()] = 14;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.OnDeviceEventProcessing.ordinal()] = 15;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.OnDevicePostInstallEventProcessing.ordinal()] = 16;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.IapLogging.ordinal()] = 17;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.IapLoggingLib2.ordinal()] = 18;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.IapLoggingLib5To7.ordinal()] = 19;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.AndroidManualImplicitPurchaseDedupe.ordinal()] = 20;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.AndroidManualImplicitSubsDedupe.ordinal()] = 21;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.AndroidIAPSubscriptionAutoLogging.ordinal()] = 22;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.BannedParamFiltering.ordinal()] = 23;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.ProtectedMode.ordinal()] = 24;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.StdParamEnforcement.ordinal()] = 25;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.MACARuleMatching.ordinal()] = 26;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.BlocklistEvents.ordinal()] = 27;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.FilterRedactedEvents.ordinal()] = 28;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.FilterSensitiveParams.ordinal()] = 29;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.ChromeCustomTabsPrefetching.ordinal()] = 30;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.Monitoring.ordinal()] = 0x1F;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.IgnoreAppSwitchToLoggedOut.ordinal()] = 0x20;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.BypassAppSwitch.ordinal()] = 33;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.GPSARATriggers.ordinal()] = 34;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.GPSPACAProcessing.ordinal()] = 35;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Feature.GPSTopicsObservation.ordinal()] = 36;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            com.facebook.internal.FeatureManager.WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    private static final String FEATURE_MANAGER_STORE = "com.facebook.internal.FEATURE_MANAGER";
    @NotNull
    public static final FeatureManager INSTANCE;
    @NotNull
    private static final Map featureMapping;

    static {
        FeatureManager.INSTANCE = new FeatureManager();
        FeatureManager.featureMapping = new HashMap();
    }

    public static final void checkFeature(@NotNull Feature featureManager$Feature0, @NotNull Callback featureManager$Callback0) {
        q.g(featureManager$Feature0, "feature");
        q.g(featureManager$Callback0, "callback");
        FetchedAppGateKeepersManager.loadAppGateKeepersAsync(new com.facebook.internal.FetchedAppGateKeepersManager.Callback() {
            @Override  // com.facebook.internal.FetchedAppGateKeepersManager$Callback
            public void onCompleted() {
                boolean z = FeatureManager.isEnabled(featureManager$Feature0);
                featureManager$Callback0.onCompleted(z);
            }
        });
    }

    private final boolean defaultStatus(Feature featureManager$Feature0) {
        switch(com.facebook.internal.FeatureManager.WhenMappings.$EnumSwitchMapping$0[featureManager$Feature0.ordinal()]) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 0x1F: 
            case 0x20: 
            case 33: 
            case 34: 
            case 35: 
            case 36: {
                return false;
            }
            default: {
                return true;
            }
        }
    }

    public static final void disableFeature(@NotNull Feature featureManager$Feature0) {
        q.g(featureManager$Feature0, "feature");
        FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).edit().putString("FBSDKFeature" + featureManager$Feature0, "18.1.3").apply();
    }

    @NotNull
    public static final Feature getFeature(@NotNull String s) {
        q.g(s, "className");
        FeatureManager.INSTANCE.initializeFeatureMapping();
        for(Object object0: FeatureManager.featureMapping.entrySet()) {
            Feature featureManager$Feature0 = (Feature)((Map.Entry)object0).getKey();
            String[] arr_s = (String[])((Map.Entry)object0).getValue();
            for(int v = 0; v < arr_s.length; ++v) {
                if(v.r0(s, arr_s[v], false)) {
                    return featureManager$Feature0;
                }
            }
        }
        return Feature.Unknown;
    }

    private final boolean getGKStatus(Feature featureManager$Feature0) {
        boolean z = this.defaultStatus(featureManager$Feature0);
        return FetchedAppGateKeepersManager.getGateKeeperForKey(("FBSDKFeature" + featureManager$Feature0), FacebookSdk.getApplicationId(), z);
    }

    private final void initializeFeatureMapping() {
        synchronized(this) {
            Map map0 = FeatureManager.featureMapping;
            if(!map0.isEmpty()) {
                return;
            }
            map0.put(Feature.AAM, new String[]{"com.facebook.appevents.aam."});
            map0.put(Feature.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
            map0.put(Feature.CloudBridge, new String[]{"com.facebook.appevents.cloudbridge."});
            map0.put(Feature.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
            map0.put(Feature.AnrReport, new String[]{"com.facebook.internal.instrument.anrreport."});
            map0.put(Feature.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
            map0.put(Feature.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
            map0.put(Feature.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
            map0.put(Feature.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
            map0.put(Feature.ProtectedMode, new String[]{"com.facebook.appevents.integrity.ProtectedModeManager"});
            map0.put(Feature.MACARuleMatching, new String[]{"com.facebook.appevents.integrity.MACARuleMatchingManager"});
            map0.put(Feature.BlocklistEvents, new String[]{"com.facebook.appevents.integrity.BlocklistEventsManager"});
            map0.put(Feature.FilterRedactedEvents, new String[]{"com.facebook.appevents.integrity.RedactedEventsManager"});
            map0.put(Feature.FilterSensitiveParams, new String[]{"com.facebook.appevents.integrity.SensitiveParamsManager"});
            map0.put(Feature.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
            map0.put(Feature.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
            map0.put(Feature.IapLogging, new String[]{"com.facebook.appevents.iap."});
            map0.put(Feature.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
            map0.put(Feature.GPSARATriggers, new String[]{"com.facebook.appevents.gps.ara.GpsARAManager"});
            map0.put(Feature.GPSPACAProcessing, new String[]{"com.facebook.appevents.gps.pa.PACustomAudienceClient"});
            map0.put(Feature.GPSTopicsObservation, new String[]{"com.facebook.appevents.gps.topics.GpsTopicsManager"});
        }
    }

    public static final boolean isEnabled(@NotNull Feature featureManager$Feature0) {
        q.g(featureManager$Feature0, "feature");
        if(Feature.Unknown == featureManager$Feature0) {
            return false;
        }
        if(Feature.Core == featureManager$Feature0) {
            return true;
        }
        String s = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).getString("FBSDKFeature" + featureManager$Feature0, null);
        if(s != null && s.equals("18.1.3")) {
            return false;
        }
        Feature featureManager$Feature1 = featureManager$Feature0.getParent();
        return featureManager$Feature1 == featureManager$Feature0 ? FeatureManager.INSTANCE.getGKStatus(featureManager$Feature0) : FeatureManager.isEnabled(featureManager$Feature1) && FeatureManager.INSTANCE.getGKStatus(featureManager$Feature0);
    }
}

