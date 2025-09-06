package co.ab180.airbridge.internal.e0;

import android.content.Context;
import co.ab180.airbridge.AirbridgeOption;
import ie.m;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import je.C;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A\u001F\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001A)\u0010\u0003\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001*\u00020\u00002\u0006\u0010\u0006\u001A\u00020\u0005H\u0000¢\u0006\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"Lco/ab180/airbridge/AirbridgeOption;", "", "", "a", "(Lco/ab180/airbridge/AirbridgeOption;)Ljava/util/Map;", "Landroid/content/Context;", "context", "", "(Lco/ab180/airbridge/AirbridgeOption;Landroid/content/Context;)Ljava/util/Map;", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class b {
    @NotNull
    public static final Map a(@NotNull AirbridgeOption airbridgeOption0) {
        Map map0 = m0.a.b();
        Map map1 = airbridgeOption0.getSdkAttributes();
        return map1 != null ? C.U(map1, map0) : map0;
    }

    @NotNull
    public static final Map a(@NotNull AirbridgeOption airbridgeOption0, @NotNull Context context0) {
        m m0 = new m("sdkEnabled", Boolean.valueOf(airbridgeOption0.isSdkEnabled()));
        m m1 = new m("logLevel", airbridgeOption0.getLogLevel().getValue$airbridge_release());
        m m2 = new m("autoStartTrackingEnabled", Boolean.valueOf(airbridgeOption0.isAutoStartTrackingEnabled()));
        m m3 = new m("trackingLinkCustomDomains", k0.a(context0, airbridgeOption0));
        m m4 = new m("trackMetaDeferredAppLinkEnabled", Boolean.valueOf(airbridgeOption0.isFacebookDeferredAppLinkEnabled()));
        TimeUnit timeUnit0 = TimeUnit.MILLISECONDS;
        m m5 = new m("sessionTimeoutInSecond", timeUnit0.toSeconds(airbridgeOption0.getSessionTimeoutMillis()));
        m m6 = new m("collectLocationEnabled", Boolean.valueOf(airbridgeOption0.isLocationCollectionEnabled()));
        m m7 = new m("metaInstallReferrerAppID", airbridgeOption0.getFacebookAppId());
        m m8 = new m("trackAirbridgeDeeplinkOnlyEnabled", Boolean.valueOf(airbridgeOption0.isTrackAirbridgeLinkOnly()));
        m m9 = new m("trackInSessionLifecycleEventEnabled", Boolean.valueOf(airbridgeOption0.isTrackInSessionLifeCycleEventEnabled()));
        m m10 = new m("hashUserInformationEnabled", Boolean.valueOf(airbridgeOption0.isUserInfoHashEnabled()));
        m m11 = new m("sdkSignatureID", (airbridgeOption0.getSecretId() == null ? null : "***"));
        return airbridgeOption0.getSecretKey() == null ? C.S(new m[]{m0, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, new m("sdkSignatureSecret", null), new m("clearEventBufferOnInitializeEnabled", Boolean.valueOf(airbridgeOption0.isResetEventBufferEnabled())), new m("eventBufferCountLimit", airbridgeOption0.getEventMaximumBufferCount()), new m("eventBufferSizeLimitInGibibyte", airbridgeOption0.getEventMaximumBufferSize()), new m("pauseEventTransmitOnBackgroundEnabled", Boolean.valueOf(airbridgeOption0.isPauseEventTransmitOnBackgroundEnabled())), new m("eventTransmitIntervalInSecond", timeUnit0.toSeconds(airbridgeOption0.getEventTransmitIntervalMillis())), new m("collectTCFDataEnabled", Boolean.valueOf(airbridgeOption0.isCollectTCFDataEnabled())), new m("trackingBlocklist", c.a(airbridgeOption0.getTrackingBlocklist()))}) : C.S(new m[]{m0, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, new m("sdkSignatureSecret", "***"), new m("clearEventBufferOnInitializeEnabled", Boolean.valueOf(airbridgeOption0.isResetEventBufferEnabled())), new m("eventBufferCountLimit", airbridgeOption0.getEventMaximumBufferCount()), new m("eventBufferSizeLimitInGibibyte", airbridgeOption0.getEventMaximumBufferSize()), new m("pauseEventTransmitOnBackgroundEnabled", Boolean.valueOf(airbridgeOption0.isPauseEventTransmitOnBackgroundEnabled())), new m("eventTransmitIntervalInSecond", timeUnit0.toSeconds(airbridgeOption0.getEventTransmitIntervalMillis())), new m("collectTCFDataEnabled", Boolean.valueOf(airbridgeOption0.isCollectTCFDataEnabled())), new m("trackingBlocklist", c.a(airbridgeOption0.getTrackingBlocklist()))});
    }
}

