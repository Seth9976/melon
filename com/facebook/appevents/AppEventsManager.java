package com.facebook.appevents;

import b3.z;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.gps.ara.GpsAraTriggersManager;
import com.facebook.appevents.gps.pa.PACustomAudienceClient;
import com.facebook.appevents.gps.topics.GpsTopicsManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.integrity.BannedParamManager;
import com.facebook.appevents.integrity.BlocklistEventsManager;
import com.facebook.appevents.integrity.MACARuleMatchingManager;
import com.facebook.appevents.integrity.ProtectedModeManager;
import com.facebook.appevents.integrity.RedactedEventsManager;
import com.facebook.appevents.integrity.SensitiveParamsManager;
import com.facebook.appevents.integrity.StdParamsEnforcementManager;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/AppEventsManager;", "", "<init>", "()V", "Lie/H;", "start", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppEventsManager {
    @NotNull
    public static final AppEventsManager INSTANCE;

    static {
        AppEventsManager.INSTANCE = new AppEventsManager();
    }

    public static final void start() {
        Class class0 = AppEventsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            FetchedAppSettingsManager.getAppSettingsAsync(new FetchedAppSettingsCallback() {
                public static void a(boolean z) {
                    com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$9(z);
                }

                public static void b(boolean z) {
                    com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$12(z);
                }

                public static void c(boolean z) {
                    com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$7(z);
                }

                public static void d(boolean z) {
                    com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$11(z);
                }

                public static void e(boolean z) {
                    com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$8(z);
                }

                public static void h(boolean z) {
                    com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$10(z);
                }

                public static void i(boolean z) {
                    com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$5(z);
                }

                public static void j(boolean z) {
                    com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$0(z);
                }

                public static void k(boolean z) {
                    com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$4(z);
                }

                public static void o(boolean z) {
                    com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$6(z);
                }

                @Override  // com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback
                public void onError() {
                }

                @Override  // com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback
                public void onSuccess(@Nullable FetchedAppSettings fetchedAppSettings0) {
                    z z0 = new z(20);
                    FeatureManager.checkFeature(Feature.AAM, z0);
                    b b0 = new b(3);
                    FeatureManager.checkFeature(Feature.RestrictiveDataFiltering, b0);
                    b b1 = new b(4);
                    FeatureManager.checkFeature(Feature.PrivacyProtection, b1);
                    b b2 = new b(5);
                    FeatureManager.checkFeature(Feature.EventDeactivation, b2);
                    z z1 = new z(21);
                    FeatureManager.checkFeature(Feature.BannedParamFiltering, z1);
                    z z2 = new z(22);
                    FeatureManager.checkFeature(Feature.IapLogging, z2);
                    z z3 = new z(23);
                    FeatureManager.checkFeature(Feature.StdParamEnforcement, z3);
                    z z4 = new z(24);
                    FeatureManager.checkFeature(Feature.ProtectedMode, z4);
                    z z5 = new z(25);
                    FeatureManager.checkFeature(Feature.MACARuleMatching, z5);
                    z z6 = new z(26);
                    FeatureManager.checkFeature(Feature.BlocklistEvents, z6);
                    z z7 = new z(27);
                    FeatureManager.checkFeature(Feature.FilterRedactedEvents, z7);
                    z z8 = new z(28);
                    FeatureManager.checkFeature(Feature.FilterSensitiveParams, z8);
                    z z9 = new z(29);
                    FeatureManager.checkFeature(Feature.CloudBridge, z9);
                    b b3 = new b(0);
                    FeatureManager.checkFeature(Feature.GPSARATriggers, b3);
                    b b4 = new b(1);
                    FeatureManager.checkFeature(Feature.GPSPACAProcessing, b4);
                    b b5 = new b(2);
                    FeatureManager.checkFeature(Feature.GPSTopicsObservation, b5);
                }

                private static final void onSuccess$lambda$0(boolean z) {
                    if(z) {
                        MetadataIndexer.enable();
                    }
                }

                private static final void onSuccess$lambda$1(boolean z) {
                    if(z) {
                        RestrictiveDataManager.enable();
                    }
                }

                private static final void onSuccess$lambda$10(boolean z) {
                    if(z) {
                        RedactedEventsManager.enable();
                    }
                }

                private static final void onSuccess$lambda$11(boolean z) {
                    if(z) {
                        SensitiveParamsManager.enable();
                    }
                }

                private static final void onSuccess$lambda$12(boolean z) {
                    if(z) {
                        AppEventsCAPIManager.enable();
                    }
                }

                private static final void onSuccess$lambda$13(boolean z) {
                    if(z) {
                        GpsAraTriggersManager.enable();
                    }
                }

                private static final void onSuccess$lambda$14(boolean z) {
                    if(z) {
                        PACustomAudienceClient.enable();
                    }
                }

                private static final void onSuccess$lambda$15(boolean z) {
                    if(z) {
                        GpsTopicsManager.enableTopicsObservation();
                    }
                }

                private static final void onSuccess$lambda$2(boolean z) {
                    if(z) {
                        ModelManager.enable();
                    }
                }

                private static final void onSuccess$lambda$3(boolean z) {
                    if(z) {
                        EventDeactivationManager.enable();
                    }
                }

                private static final void onSuccess$lambda$4(boolean z) {
                    if(z) {
                        BannedParamManager.enable();
                    }
                }

                private static final void onSuccess$lambda$5(boolean z) {
                    if(z) {
                        InAppPurchaseManager.enableAutoLogging();
                    }
                }

                private static final void onSuccess$lambda$6(boolean z) {
                    if(z) {
                        StdParamsEnforcementManager.enable();
                    }
                }

                private static final void onSuccess$lambda$7(boolean z) {
                    if(z) {
                        ProtectedModeManager.enable();
                    }
                }

                private static final void onSuccess$lambda$8(boolean z) {
                    if(z) {
                        MACARuleMatchingManager.enable();
                    }
                }

                private static final void onSuccess$lambda$9(boolean z) {
                    if(z) {
                        BlocklistEventsManager.enable();
                    }
                }
            });
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }
}

