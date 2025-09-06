package co.ab180.airbridge;

import co.ab180.airbridge.internal.b;
import co.ab180.airbridge.internal.e0.c;
import co.ab180.airbridge.internal.e0.l0;
import co.ab180.airbridge.internal.e0.n0.a;
import co.ab180.airbridge.internal.e0.n0;
import ie.d;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import je.p;
import je.w;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bL\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010q\u001A\u00020\u0002\u0012\u0006\u0010u\u001A\u00020\u0002\u00A2\u0006\u0006\b\u008D\u0001\u0010\u008E\u0001J\u001D\u0010\u0005\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0010\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0013\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0013\u0010\u0011J\u0015\u0010\u0014\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0014\u0010\u0011J\u0015\u0010\u0015\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0015\u0010\u0011J\u0015\u0010\u0016\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0016\u0010\u0011J\u0015\u0010\u0017\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0017\u0010\u0011J\u0015\u0010\u0018\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0018\u0010\u0011J\u0015\u0010\u0019\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0019\u0010\u0011J\u0015\u0010\u001A\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u000F\u00A2\u0006\u0004\b\u001A\u0010\u0011J\u0017\u0010\u001B\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0015\u0010\u001D\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u0002\u00A2\u0006\u0004\b\u001D\u0010\u001CJ\u0015\u0010 \u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u001E\u00A2\u0006\u0004\b \u0010!J\u0015\u0010$\u001A\u00020\u00002\u0006\u0010#\u001A\u00020\"\u00A2\u0006\u0004\b$\u0010%J\u0015\u0010&\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\b&\u0010\u000EJ\u001D\u0010(\u001A\u00020\u00002\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00020\'H\u0007\u00A2\u0006\u0004\b(\u0010)J\u001B\u0010*\u001A\u00020\u00002\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00020\'\u00A2\u0006\u0004\b*\u0010)J\u0015\u0010,\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020+\u00A2\u0006\u0004\b,\u0010-J\u0015\u0010/\u001A\u00020\u00002\u0006\u0010.\u001A\u00020\u0002\u00A2\u0006\u0004\b/\u0010\u001CJ\u0015\u00101\u001A\u00020\u00002\u0006\u0010\b\u001A\u000200\u00A2\u0006\u0004\b1\u00102J\u0015\u00104\u001A\u00020\u00002\u0006\u0010\b\u001A\u000203\u00A2\u0006\u0004\b4\u00105J\u0015\u00108\u001A\u00020\u00002\u0006\u00107\u001A\u000206\u00A2\u0006\u0004\b8\u00109J!\u0010<\u001A\u00020\u00002\u0012\u0010;\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020:\u00A2\u0006\u0004\b<\u0010=J!\u0010?\u001A\u00020\u00002\u0012\u0010>\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010:\u00A2\u0006\u0004\b?\u0010=J\u0015\u0010@\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u000F\u00A2\u0006\u0004\b@\u0010\u0011J\u001B\u0010B\u001A\u00020\u00002\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020A0\'\u00A2\u0006\u0004\bB\u0010)J\r\u0010D\u001A\u00020C\u00A2\u0006\u0004\bD\u0010ER\u0016\u0010H\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010GR\u001C\u0010K\u001A\b\u0012\u0004\u0012\u00020A0\'8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010GR\u0016\u0010S\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010RR$\u0010V\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010:8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001A\u00020\"8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bZ\u0010MR\u0018\u0010^\u001A\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001A\u0002068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b_\u0010`R\u001C\u0010c\u001A\b\u0012\u0004\u0012\u00020\u00020\'8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bb\u0010JR\u0018\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bd\u0010RR\u0016\u0010f\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\be\u0010MR\u0016\u0010h\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bg\u0010MR\u0016\u0010j\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bi\u0010MR\u0018\u0010m\u001A\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010p\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010q\u001A\u00020\u00028\u0002@\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bX\u0010RR\u0016\u0010s\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\br\u0010MR\u0016\u0010u\u001A\u00020\u00028\u0002@\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bt\u0010RR\u0016\u0010w\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bv\u0010RR\u0016\u0010y\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bx\u0010MR\u0016\u0010{\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bz\u0010MR\u0016\u0010~\u001A\u00020\u001E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b|\u0010}R%\u0010\u0080\u0001\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010:8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u007F\u0010UR\u0018\u0010\u0082\u0001\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0081\u0001\u0010MR\u001B\u0010\u0085\u0001\u001A\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001A\u0010\u0087\u0001\u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0086\u0001\u0010RR\u0018\u0010\u0089\u0001\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0088\u0001\u0010MR\u0019\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u008A\u0001\u0010RR\u0018\u0010\u008C\u0001\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u008B\u0001\u0010M\u00A8\u0006\u008F\u0001"}, d2 = {"Lco/ab180/airbridge/AirbridgeOptionBuilder;", "", "", "secretId", "secretKey", "setSDKSignature", "(Ljava/lang/String;Ljava/lang/String;)Lco/ab180/airbridge/AirbridgeOptionBuilder;", "Lco/ab180/airbridge/AirbridgeLogLevel;", "value", "setLogLevel", "(Lco/ab180/airbridge/AirbridgeLogLevel;)Lco/ab180/airbridge/AirbridgeOptionBuilder;", "", "second", "setSessionTimeout", "(J)Lco/ab180/airbridge/AirbridgeOptionBuilder;", "", "setHashUserInformationEnabled", "(Z)Lco/ab180/airbridge/AirbridgeOptionBuilder;", "setAutoStartTrackingEnabled", "setTrackInSessionLifeCycleEventEnabled", "setTrackAirbridgeDeeplinkOnlyEnabled", "setPauseEventTransmitOnBackgroundEnabled", "setCollectLocationEnabled", "setTrackMetaDeferredAppLinkEnabled", "setErrorLogCollectionEnabled", "setClearEventBufferOnInitializeEnabled", "setSDKEnabled", "setAppMarketIdentifier", "(Ljava/lang/String;)Lco/ab180/airbridge/AirbridgeOptionBuilder;", "setSDKDevelopmentPlatform", "", "count", "setEventBufferCountLimit", "(I)Lco/ab180/airbridge/AirbridgeOptionBuilder;", "", "gibibyte", "setEventBufferSizeLimit", "(D)Lco/ab180/airbridge/AirbridgeOptionBuilder;", "setEventTransmitInterval", "", "setCustomDomains", "(Ljava/util/List;)Lco/ab180/airbridge/AirbridgeOptionBuilder;", "setTrackingLinkCustomDomains", "Lco/ab180/airbridge/OnAttributionResultReceiveListener;", "setOnAttributionReceived", "(Lco/ab180/airbridge/OnAttributionResultReceiveListener;)Lco/ab180/airbridge/AirbridgeOptionBuilder;", "metaAppID", "setMetaInstallReferrer", "Lco/ab180/airbridge/AirbridgeLifecycleIntegration;", "setLifecycleIntegration", "(Lco/ab180/airbridge/AirbridgeLifecycleIntegration;)Lco/ab180/airbridge/AirbridgeOptionBuilder;", "Lco/ab180/airbridge/OnInAppPurchaseReceiveListener;", "setOnInAppPurchaseReceived", "(Lco/ab180/airbridge/OnInAppPurchaseReceiveListener;)Lco/ab180/airbridge/AirbridgeOptionBuilder;", "Lco/ab180/airbridge/AirbridgeInAppPurchaseEnvironment;", "environment", "setInAppPurchaseEnvironment", "(Lco/ab180/airbridge/AirbridgeInAppPurchaseEnvironment;)Lco/ab180/airbridge/AirbridgeOptionBuilder;", "", "attributes", "setSDKAttributes", "(Ljava/util/Map;)Lco/ab180/airbridge/AirbridgeOptionBuilder;", "option", "setSDKWrapperOption", "setCollectTCFDataEnabled", "Lco/ab180/airbridge/common/AirbridgeTrackingBlocklist;", "setTrackingBlocklist", "Lco/ab180/airbridge/AirbridgeOption;", "build", "()Lco/ab180/airbridge/AirbridgeOption;", "d", "J", "sessionTimeoutMillis", "C", "Ljava/util/List;", "trackingBlocklist", "h", "Z", "trackAirbridgeLinkOnly", "s", "eventTransmitIntervalMillis", "o", "Ljava/lang/String;", "appMarketIdentifier", "x", "Ljava/util/Map;", "sdkAttributes", "r", "D", "eventMaximumBufferSize", "k", "facebookDeferredAppLinkEnabled", "z", "Lco/ab180/airbridge/OnInAppPurchaseReceiveListener;", "onInAppPurchaseReceiveListener", "A", "Lco/ab180/airbridge/AirbridgeInAppPurchaseEnvironment;", "inAppPurchaseEnvironment", "t", "customDomains", "a", "f", "autoStartTrackingEnabled", "g", "trackInSessionLifeCycleEventEnabled", "m", "resetEventBufferEnabled", "w", "Lco/ab180/airbridge/AirbridgeLifecycleIntegration;", "lifecycleIntegration", "c", "Lco/ab180/airbridge/AirbridgeLogLevel;", "logLevel", "name", "j", "collectLocationEnabled", "E", "token", "p", "platform", "l", "errorLogCollectionEnabled", "e", "userInfoHashEnabled", "q", "I", "eventMaximumBufferCount", "y", "sdkWrapperOption", "i", "pauseEventTransmitOnBackgroundEnabled", "u", "Lco/ab180/airbridge/OnAttributionResultReceiveListener;", "onAttributionResultReceiveListener", "v", "facebookAppId", "B", "isCollectTCFDataEnabled", "b", "n", "sdkEnabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class AirbridgeOptionBuilder {
    private AirbridgeInAppPurchaseEnvironment A;
    private boolean B;
    private List C;
    private final String D;
    private final String E;
    private String a;
    private String b;
    private AirbridgeLogLevel c;
    private long d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private String o;
    private String p;
    private int q;
    private double r;
    private long s;
    private List t;
    private OnAttributionResultReceiveListener u;
    private String v;
    private AirbridgeLifecycleIntegration w;
    private Map x;
    private Map y;
    private OnInAppPurchaseReceiveListener z;

    public AirbridgeOptionBuilder(@NotNull String s, @NotNull String s1) {
        this.D = s;
        this.E = s1;
        this.c = AirbridgeLogLevel.WARNING;
        TimeUnit timeUnit0 = TimeUnit.SECONDS;
        this.d = timeUnit0.toMillis(300L);
        this.e = true;
        this.f = true;
        this.l = true;
        this.n = true;
        this.o = "";
        this.p = "native";
        this.q = 0x7FFFFFFF;
        this.r = n0.b.e(1.0).c();
        this.s = timeUnit0.toMillis(0L);
        this.t = w.a;
        this.A = AirbridgeInAppPurchaseEnvironment.PRODUCTION;
        this.C = w.a;
    }

    @NotNull
    public final AirbridgeOption build() {
        return new AirbridgeOption(this.D, this.E, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C);
    }

    @d
    @NotNull
    public final AirbridgeOptionBuilder setAppMarketIdentifier(@NotNull String s) {
        b.e.d("{setAppMarketIdentifier} is called: {" + s + '}', new Object[0]);
        this.o = s;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setAutoStartTrackingEnabled(boolean z) {
        b.e.d("{setAutoStartTrackingEnabled} is called: {" + z + '}', new Object[0]);
        this.f = z;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setClearEventBufferOnInitializeEnabled(boolean z) {
        b.e.d("{setClearEventBufferOnInitializeEnabled} is called: {" + z + '}', new Object[0]);
        this.m = z;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setCollectLocationEnabled(boolean z) {
        b.e.d("{setCollectLocationEnabled} is called: {" + z + '}', new Object[0]);
        this.j = z;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setCollectTCFDataEnabled(boolean z) {
        b.e.d("{setCollectTCFDataEnabled} is called: {" + z + '}', new Object[0]);
        this.B = z;
        return this;
    }

    @d
    @NotNull
    public final AirbridgeOptionBuilder setCustomDomains(@NotNull List list0) {
        b.e.d("{setCustomDomains} is called: {" + list0 + '}', new Object[0]);
        this.t = list0;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setErrorLogCollectionEnabled(boolean z) {
        b.e.d("{setErrorLogCollectionEnabled} is called: {" + z + '}', new Object[0]);
        this.l = z;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setEventBufferCountLimit(int v) {
        co.ab180.airbridge.internal.b.b b$b0 = b.e;
        b$b0.d("{setEventBufferCountLimit} is called: {" + v + '}', new Object[0]);
        if(v < 0) {
            b$b0.f("`eventBufferCountLimit` is changed: `count` is lower than 0, `count` is set as 0", new Object[0]);
            v = 0;
        }
        this.q = v;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setEventBufferSizeLimit(double f) {
        co.ab180.airbridge.internal.b.b b$b0 = b.e;
        b$b0.d("`setEventBufferSizeLimit` is called: {" + f + '}', new Object[0]);
        if(f < 0.0) {
            b$b0.f("`eventBufferSizeLimit` is changed: `gibibyte` is lower than 0 byte, `gibibyte` is set as 0 byte", new Object[0]);
            f = n0.b.a(0L).c();
        }
        else {
            a n0$a0 = n0.b;
            if(n0$a0.b(f).a(n0$a0.e(1.0)) > 0) {
                b$b0.f("`eventBufferSizeLimit` is changed: `gibibyte` is higher than 1 tebibyte, `gibibyte` is set as 1 tebibyte", new Object[0]);
                f = n0$a0.e(1.0).c();
            }
        }
        this.r = f;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setEventTransmitInterval(long v) {
        long v1;
        co.ab180.airbridge.internal.b.b b$b0 = b.e;
        b$b0.d("{setEventTransmitInterval} is called: {" + v + '}', new Object[0]);
        if(v < 0L) {
            b$b0.f("`setEventTransmitInterval` is changed: `second` is lower than 0 second, `second` is set as 0 second", new Object[0]);
            v1 = TimeUnit.SECONDS.toMillis(0L);
        }
        else {
            TimeUnit timeUnit0 = TimeUnit.DAYS;
            if(v > timeUnit0.toSeconds(1L)) {
                b$b0.f("`setEventTransmitInterval` is changed: `second` is higher than 1 day, `second` is set as 1 day", new Object[0]);
                v1 = timeUnit0.toMillis(1L);
            }
            else {
                v1 = TimeUnit.SECONDS.toMillis(v);
            }
        }
        this.s = v1;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setHashUserInformationEnabled(boolean z) {
        b.e.d("{setHashUserInformationEnabled} is called: {" + z + '}', new Object[0]);
        this.e = z;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setInAppPurchaseEnvironment(@NotNull AirbridgeInAppPurchaseEnvironment airbridgeInAppPurchaseEnvironment0) {
        b.e.d("{setInAppPurchaseEnvironment} is called", new Object[0]);
        this.A = airbridgeInAppPurchaseEnvironment0;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setLifecycleIntegration(@NotNull AirbridgeLifecycleIntegration airbridgeLifecycleIntegration0) {
        b.e.d("{setLifecycleIntegration} is called", new Object[0]);
        this.w = airbridgeLifecycleIntegration0;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setLogLevel(@NotNull AirbridgeLogLevel airbridgeLogLevel0) {
        b.e.d("{setLogLevel} is called: {" + airbridgeLogLevel0 + '}', new Object[0]);
        this.c = airbridgeLogLevel0;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setMetaInstallReferrer(@NotNull String s) {
        b.e.d("{setMetaInstallReferrer} is called: {" + s + '}', new Object[0]);
        this.v = s;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setOnAttributionReceived(@NotNull OnAttributionResultReceiveListener onAttributionResultReceiveListener0) {
        b.e.d("{setOnAttributionReceived} is called", new Object[0]);
        this.u = onAttributionResultReceiveListener0;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setOnInAppPurchaseReceived(@NotNull OnInAppPurchaseReceiveListener onInAppPurchaseReceiveListener0) {
        b.e.d("{setOnInAppPurchaseReceived} is called", new Object[0]);
        this.z = onInAppPurchaseReceiveListener0;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setPauseEventTransmitOnBackgroundEnabled(boolean z) {
        b.e.d("{setPauseEventTransmitOnBackgroundEnabled} is called: {" + z + '}', new Object[0]);
        this.i = z;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setSDKAttributes(@NotNull Map map0) {
        b.e.d("{setSDKAttribute} is called: attributes={" + map0 + '}', new Object[0]);
        this.x = map0;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setSDKDevelopmentPlatform(@NotNull String s) {
        b.e.d("{setSDKDevelopmentPlatform} is called: {" + s + '}', new Object[0]);
        this.p = s;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setSDKEnabled(boolean z) {
        b.e.d("{setSDKEnabled} is called: {" + z + '}', new Object[0]);
        this.n = z;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setSDKSignature(@NotNull String s, @NotNull String s1) {
        co.ab180.airbridge.internal.b.b b$b0 = b.e;
        b$b0.d("{setSDKSignature} is called", new Object[0]);
        if(!l0.a(s)) {
            b$b0.f("`setSDKSignature` is ignored: `id` is not satisfy uuid format={" + s + '}', new Object[0]);
            return this;
        }
        if(!l0.b(s1)) {
            b$b0.f("`setSDKSignature` is ignored: `secret` is not satisfy `^[a-zA-Z0-9]{64}$` format", new Object[0]);
            return this;
        }
        this.a = s;
        this.b = s1;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setSDKWrapperOption(@NotNull Map map0) {
        b.e.d("{setSDKAttributes} is called: option={" + map0 + '}', new Object[0]);
        this.y = map0;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setSessionTimeout(long v) {
        long v1;
        co.ab180.airbridge.internal.b.b b$b0 = b.e;
        b$b0.d("{setSessionTimeout} is called: {" + v + '}', new Object[0]);
        if(v < 0L) {
            b$b0.f("`second` is lower than 0 second, `second` is set as 0 second", new Object[0]);
            v1 = TimeUnit.SECONDS.toMillis(0L);
        }
        else {
            TimeUnit timeUnit0 = TimeUnit.DAYS;
            if(v > timeUnit0.toMillis(7L)) {
                b$b0.f("`second` is higher than 7 day, `second` is set as 7 day", new Object[0]);
                v1 = timeUnit0.toMillis(7L);
            }
            else {
                v1 = TimeUnit.SECONDS.toMillis(v);
            }
        }
        this.d = v1;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setTrackAirbridgeDeeplinkOnlyEnabled(boolean z) {
        b.e.d("{setTrackAirbridgeDeeplinkOnlyEnabled} is called: {" + z + '}', new Object[0]);
        this.h = z;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setTrackInSessionLifeCycleEventEnabled(boolean z) {
        b.e.d("{setTrackInSessionLifeCycleEventEnabled} is called: {" + z + '}', new Object[0]);
        this.g = z;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setTrackMetaDeferredAppLinkEnabled(boolean z) {
        b.e.d("{setTrackMetaDeferredAppLinkEnabled} is called: {" + z + '}', new Object[0]);
        this.k = z;
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setTrackingBlocklist(@NotNull List list0) {
        b.e.d("{setTrackingBlocklist} is called: {" + c.a(list0) + '}', new Object[0]);
        this.C = p.e0(list0);
        return this;
    }

    @NotNull
    public final AirbridgeOptionBuilder setTrackingLinkCustomDomains(@NotNull List list0) {
        b.e.d("{setTrackingLinkCustomDomains} is called: {" + list0 + '}', new Object[0]);
        this.t = list0;
        return this;
    }
}

