package co.ab180.airbridge;

import A7.d;
import java.util.List;
import java.util.Map;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\br\b\u0086\b\u0018\u00002\u00020\u0001B\u00AD\u0002\u0012\u0006\u00109\u001A\u00020\u0002\u0012\u0006\u0010:\u001A\u00020\u0002\u0012\b\u0010;\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010<\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010=\u001A\u00020\b\u0012\u0006\u0010>\u001A\u00020\u000B\u0012\u0006\u0010?\u001A\u00020\u000E\u0012\u0006\u0010@\u001A\u00020\u000E\u0012\u0006\u0010A\u001A\u00020\u000E\u0012\u0006\u0010B\u001A\u00020\u000E\u0012\u0006\u0010C\u001A\u00020\u000E\u0012\u0006\u0010D\u001A\u00020\u000E\u0012\u0006\u0010E\u001A\u00020\u000E\u0012\u0006\u0010F\u001A\u00020\u000E\u0012\u0006\u0010G\u001A\u00020\u000E\u0012\u0006\u0010H\u001A\u00020\u0002\u0012\u0006\u0010I\u001A\u00020\u0002\u0012\u0006\u0010J\u001A\u00020\u001B\u0012\u0006\u0010K\u001A\u00020\u001E\u0012\u0006\u0010L\u001A\u00020\u000B\u0012\f\u0010M\u001A\b\u0012\u0004\u0012\u00020\u00020\"\u0012\b\u0010N\u001A\u0004\u0018\u00010%\u0012\b\u0010O\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010P\u001A\u0004\u0018\u00010)\u0012\u0014\u0010Q\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010,\u0012\u0014\u0010R\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010,\u0012\b\u0010S\u001A\u0004\u0018\u000100\u0012\u0006\u0010T\u001A\u000203\u0012\u0006\u0010U\u001A\u00020\u000E\u0012\f\u0010V\u001A\b\u0012\u0004\u0012\u0002070\"\u00A2\u0006\u0006\b\u00A7\u0001\u0010\u00A8\u0001J\u0010\u0010\u0003\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001A\u00020\bH\u00C6\u0003\u00A2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EH\u00C6\u0003\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u000EH\u00C6\u0003\u00A2\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001A\u00020\u000EH\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0013\u001A\u00020\u000EH\u00C6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001A\u00020\u000EH\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0015\u001A\u00020\u000EH\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0010J\u0010\u0010\u0016\u001A\u00020\u000EH\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0010J\u0010\u0010\u0017\u001A\u00020\u000EH\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0010J\u0010\u0010\u0018\u001A\u00020\u000EH\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0010J\u0010\u0010\u0019\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001A\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u0004J\u0010\u0010\u001C\u001A\u00020\u001BH\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u001F\u001A\u00020\u001EH\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010 J\u0010\u0010!\u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\rJ\u0016\u0010#\u001A\b\u0012\u0004\u0012\u00020\u00020\"H\u00C6\u0003\u00A2\u0006\u0004\b#\u0010$J\u0012\u0010&\u001A\u0004\u0018\u00010%H\u00C6\u0003\u00A2\u0006\u0004\b&\u0010\'J\u0012\u0010(\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b(\u0010\u0004J\u0012\u0010*\u001A\u0004\u0018\u00010)H\u00C6\u0003\u00A2\u0006\u0004\b*\u0010+J\u001E\u0010-\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010,H\u00C6\u0003\u00A2\u0006\u0004\b-\u0010.J\u001E\u0010/\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010,H\u00C6\u0003\u00A2\u0006\u0004\b/\u0010.J\u0012\u00101\u001A\u0004\u0018\u000100H\u00C6\u0003\u00A2\u0006\u0004\b1\u00102J\u0010\u00104\u001A\u000203H\u00C6\u0003\u00A2\u0006\u0004\b4\u00105J\u0010\u00106\u001A\u00020\u000EH\u00C6\u0003\u00A2\u0006\u0004\b6\u0010\u0010J\u0016\u00108\u001A\b\u0012\u0004\u0012\u0002070\"H\u00C6\u0003\u00A2\u0006\u0004\b8\u0010$J\u00F0\u0002\u0010W\u001A\u00020\u00002\b\b\u0002\u00109\u001A\u00020\u00022\b\b\u0002\u0010:\u001A\u00020\u00022\n\b\u0002\u0010;\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010<\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010=\u001A\u00020\b2\b\b\u0002\u0010>\u001A\u00020\u000B2\b\b\u0002\u0010?\u001A\u00020\u000E2\b\b\u0002\u0010@\u001A\u00020\u000E2\b\b\u0002\u0010A\u001A\u00020\u000E2\b\b\u0002\u0010B\u001A\u00020\u000E2\b\b\u0002\u0010C\u001A\u00020\u000E2\b\b\u0002\u0010D\u001A\u00020\u000E2\b\b\u0002\u0010E\u001A\u00020\u000E2\b\b\u0002\u0010F\u001A\u00020\u000E2\b\b\u0002\u0010G\u001A\u00020\u000E2\b\b\u0002\u0010H\u001A\u00020\u00022\b\b\u0002\u0010I\u001A\u00020\u00022\b\b\u0002\u0010J\u001A\u00020\u001B2\b\b\u0002\u0010K\u001A\u00020\u001E2\b\b\u0002\u0010L\u001A\u00020\u000B2\u000E\b\u0002\u0010M\u001A\b\u0012\u0004\u0012\u00020\u00020\"2\n\b\u0002\u0010N\u001A\u0004\u0018\u00010%2\n\b\u0002\u0010O\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010P\u001A\u0004\u0018\u00010)2\u0016\b\u0002\u0010Q\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010,2\u0016\b\u0002\u0010R\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010,2\n\b\u0002\u0010S\u001A\u0004\u0018\u0001002\b\b\u0002\u0010T\u001A\u0002032\b\b\u0002\u0010U\u001A\u00020\u000E2\u000E\b\u0002\u0010V\u001A\b\u0012\u0004\u0012\u0002070\"H\u00C6\u0001\u00A2\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\bY\u0010\u0004J\u0010\u0010Z\u001A\u00020\u001BH\u00D6\u0001\u00A2\u0006\u0004\bZ\u0010\u001DJ\u001A\u0010\\\u001A\u00020\u000E2\b\u0010[\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b\\\u0010]R\"\u0010c\u001A\u00020\u001B8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b^\u0010_\u001A\u0004\b`\u0010\u001D\"\u0004\ba\u0010bR\'\u0010R\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010,8\u0006@\u0006\u00A2\u0006\f\n\u0004\bd\u0010e\u001A\u0004\bf\u0010.R\u0019\u0010>\u001A\u00020\u000B8\u0006@\u0006\u00A2\u0006\f\n\u0004\bg\u0010h\u001A\u0004\bi\u0010\rR\u001B\u0010P\u001A\u0004\u0018\u00010)8\u0006@\u0006\u00A2\u0006\f\n\u0004\bj\u0010k\u001A\u0004\bl\u0010+R\u0019\u0010F\u001A\u00020\u000E8\u0006@\u0006\u00A2\u0006\f\n\u0004\bm\u0010n\u001A\u0004\bF\u0010\u0010R\u001F\u0010M\u001A\b\u0012\u0004\u0012\u00020\u00020\"8\u0006@\u0006\u00A2\u0006\f\n\u0004\bo\u0010p\u001A\u0004\bq\u0010$R\u0019\u0010K\u001A\u00020\u001E8\u0006@\u0006\u00A2\u0006\f\n\u0004\br\u0010s\u001A\u0004\bt\u0010 R\u0019\u0010U\u001A\u00020\u000E8\u0006@\u0006\u00A2\u0006\f\n\u0004\bu\u0010n\u001A\u0004\bU\u0010\u0010R\u001C\u0010x\u001A\u00020\u000E8\u0000@\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\bv\u0010n\u001A\u0004\bw\u0010\u0010R\u001B\u0010S\u001A\u0004\u0018\u0001008\u0006@\u0006\u00A2\u0006\f\n\u0004\bs\u0010y\u001A\u0004\bz\u00102R\u0019\u0010E\u001A\u00020\u000E8\u0006@\u0006\u00A2\u0006\f\n\u0004\b{\u0010n\u001A\u0004\bE\u0010\u0010R\u0019\u0010G\u001A\u00020\u000E8\u0006@\u0006\u00A2\u0006\f\n\u0004\b|\u0010n\u001A\u0004\bG\u0010\u0010R\u0019\u0010L\u001A\u00020\u000B8\u0006@\u0006\u00A2\u0006\f\n\u0004\b}\u0010h\u001A\u0004\b~\u0010\rR\u001A\u0010J\u001A\u00020\u001B8\u0006@\u0006\u00A2\u0006\r\n\u0004\b\u007F\u0010_\u001A\u0005\b\u0080\u0001\u0010\u001DR\u001C\u0010:\u001A\u00020\u00028\u0006@\u0006\u00A2\u0006\u000F\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001A\u0005\b\u0083\u0001\u0010\u0004R\u001C\u0010H\u001A\u00020\u00028\u0006@\u0006\u00A2\u0006\u000F\n\u0006\b\u0084\u0001\u0010\u0082\u0001\u001A\u0005\b\u0085\u0001\u0010\u0004R\u001C\u00109\u001A\u00020\u00028\u0006@\u0006\u00A2\u0006\u000F\n\u0006\b\u0086\u0001\u0010\u0082\u0001\u001A\u0005\b\u0087\u0001\u0010\u0004R\u001E\u0010<\u001A\u0004\u0018\u00010\u00028\u0006@\u0006\u00A2\u0006\u000F\n\u0006\b\u0088\u0001\u0010\u0082\u0001\u001A\u0005\b\u0089\u0001\u0010\u0004R&\u0010\u008D\u0001\u001A\u00020\u001B8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0015\n\u0005\b\u008A\u0001\u0010_\u001A\u0005\b\u008B\u0001\u0010\u001D\"\u0005\b\u008C\u0001\u0010bR\u001E\u0010;\u001A\u0004\u0018\u00010\u00028\u0006@\u0006\u00A2\u0006\u000F\n\u0006\b\u008E\u0001\u0010\u0082\u0001\u001A\u0005\b\u008F\u0001\u0010\u0004R\u001E\u0010O\u001A\u0004\u0018\u00010\u00028\u0006@\u0006\u00A2\u0006\u000F\n\u0006\b\u0090\u0001\u0010\u0082\u0001\u001A\u0005\b\u0091\u0001\u0010\u0004R)\u0010Q\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010,8\u0006@\u0006\u00A2\u0006\u000E\n\u0005\b\u0092\u0001\u0010e\u001A\u0005\b\u0093\u0001\u0010.R\u001E\u0010N\u001A\u0004\u0018\u00010%8\u0006@\u0006\u00A2\u0006\u000F\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001A\u0005\b\u0096\u0001\u0010\'R\u001C\u0010=\u001A\u00020\b8\u0006@\u0006\u00A2\u0006\u000F\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001A\u0005\b\u0099\u0001\u0010\nR\u001C\u0010I\u001A\u00020\u00028\u0006@\u0006\u00A2\u0006\u000F\n\u0006\b\u009A\u0001\u0010\u0082\u0001\u001A\u0005\b\u009B\u0001\u0010\u0004R\u001A\u0010?\u001A\u00020\u000E8\u0006@\u0006\u00A2\u0006\r\n\u0005\b\u009C\u0001\u0010n\u001A\u0004\b?\u0010\u0010R\u001A\u0010C\u001A\u00020\u000E8\u0006@\u0006\u00A2\u0006\r\n\u0005\b\u009D\u0001\u0010n\u001A\u0004\bC\u0010\u0010R\u001A\u0010@\u001A\u00020\u000E8\u0006@\u0006\u00A2\u0006\r\n\u0005\b\u009E\u0001\u0010n\u001A\u0004\b@\u0010\u0010R\u001A\u0010D\u001A\u00020\u000E8\u0006@\u0006\u00A2\u0006\r\n\u0005\b\u009F\u0001\u0010n\u001A\u0004\bD\u0010\u0010R\u001A\u0010B\u001A\u00020\u000E8\u0006@\u0006\u00A2\u0006\r\n\u0005\b\u00A0\u0001\u0010n\u001A\u0004\bB\u0010\u0010R!\u0010V\u001A\b\u0012\u0004\u0012\u0002070\"8\u0006@\u0006\u00A2\u0006\u000E\n\u0005\b\u00A1\u0001\u0010p\u001A\u0005\b\u00A2\u0001\u0010$R\u001A\u0010A\u001A\u00020\u000E8\u0006@\u0006\u00A2\u0006\r\n\u0005\b\u00A3\u0001\u0010n\u001A\u0004\bA\u0010\u0010R\u001C\u0010T\u001A\u0002038\u0006@\u0006\u00A2\u0006\u000F\n\u0006\b\u00A4\u0001\u0010\u00A5\u0001\u001A\u0005\b\u00A6\u0001\u00105\u00A8\u0006\u00A9\u0001"}, d2 = {"Lco/ab180/airbridge/AirbridgeOption;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lco/ab180/airbridge/AirbridgeLogLevel;", "component5", "()Lco/ab180/airbridge/AirbridgeLogLevel;", "", "component6", "()J", "", "component7", "()Z", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "", "component18", "()I", "", "component19", "()D", "component20", "", "component21", "()Ljava/util/List;", "Lco/ab180/airbridge/OnAttributionResultReceiveListener;", "component22", "()Lco/ab180/airbridge/OnAttributionResultReceiveListener;", "component23", "Lco/ab180/airbridge/AirbridgeLifecycleIntegration;", "component24", "()Lco/ab180/airbridge/AirbridgeLifecycleIntegration;", "", "component25", "()Ljava/util/Map;", "component26", "Lco/ab180/airbridge/OnInAppPurchaseReceiveListener;", "component27", "()Lco/ab180/airbridge/OnInAppPurchaseReceiveListener;", "Lco/ab180/airbridge/AirbridgeInAppPurchaseEnvironment;", "component28", "()Lco/ab180/airbridge/AirbridgeInAppPurchaseEnvironment;", "component29", "Lco/ab180/airbridge/common/AirbridgeTrackingBlocklist;", "component30", "name", "token", "secretId", "secretKey", "logLevel", "sessionTimeoutMillis", "isUserInfoHashEnabled", "isAutoStartTrackingEnabled", "isTrackInSessionLifeCycleEventEnabled", "isTrackAirbridgeLinkOnly", "isPauseEventTransmitOnBackgroundEnabled", "isLocationCollectionEnabled", "isFacebookDeferredAppLinkEnabled", "isResetEventBufferEnabled", "isSdkEnabled", "appMarketIdentifier", "platform", "eventMaximumBufferCount", "eventMaximumBufferSize", "eventTransmitIntervalMillis", "customDomains", "onAttributionResultReceiveListener", "facebookAppId", "lifecycleIntegration", "sdkAttributes", "sdkWrapperOption", "onInAppPurchaseReceiveListener", "inAppPurchaseEnvironment", "isCollectTCFDataEnabled", "trackingBlocklist", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lco/ab180/airbridge/AirbridgeLogLevel;JZZZZZZZZZLjava/lang/String;Ljava/lang/String;IDJLjava/util/List;Lco/ab180/airbridge/OnAttributionResultReceiveListener;Ljava/lang/String;Lco/ab180/airbridge/AirbridgeLifecycleIntegration;Ljava/util/Map;Ljava/util/Map;Lco/ab180/airbridge/OnInAppPurchaseReceiveListener;Lco/ab180/airbridge/AirbridgeInAppPurchaseEnvironment;ZLjava/util/List;)Lco/ab180/airbridge/AirbridgeOption;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getAttributionRequestMaxCount$airbridge_release", "setAttributionRequestMaxCount$airbridge_release", "(I)V", "attributionRequestMaxCount", "C", "Ljava/util/Map;", "getSdkWrapperOption", "i", "J", "getSessionTimeoutMillis", "A", "Lco/ab180/airbridge/AirbridgeLifecycleIntegration;", "getLifecycleIntegration", "q", "Z", "x", "Ljava/util/List;", "getCustomDomains", "v", "D", "getEventMaximumBufferSize", "F", "c", "isSDKSignatureSecretEnabled$airbridge_release", "isSDKSignatureSecretEnabled", "Lco/ab180/airbridge/OnInAppPurchaseReceiveListener;", "getOnInAppPurchaseReceiveListener", "p", "r", "w", "getEventTransmitIntervalMillis", "u", "getEventMaximumBufferCount", "e", "Ljava/lang/String;", "getToken", "s", "getAppMarketIdentifier", "d", "getName", "g", "getSecretKey", "b", "getAttributionTimeout$airbridge_release", "setAttributionTimeout$airbridge_release", "attributionTimeout", "f", "getSecretId", "z", "getFacebookAppId", "B", "getSdkAttributes", "y", "Lco/ab180/airbridge/OnAttributionResultReceiveListener;", "getOnAttributionResultReceiveListener", "h", "Lco/ab180/airbridge/AirbridgeLogLevel;", "getLogLevel", "t", "getPlatform", "j", "n", "k", "o", "m", "G", "getTrackingBlocklist", "l", "E", "Lco/ab180/airbridge/AirbridgeInAppPurchaseEnvironment;", "getInAppPurchaseEnvironment", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lco/ab180/airbridge/AirbridgeLogLevel;JZZZZZZZZZLjava/lang/String;Ljava/lang/String;IDJLjava/util/List;Lco/ab180/airbridge/OnAttributionResultReceiveListener;Ljava/lang/String;Lco/ab180/airbridge/AirbridgeLifecycleIntegration;Ljava/util/Map;Ljava/util/Map;Lco/ab180/airbridge/OnInAppPurchaseReceiveListener;Lco/ab180/airbridge/AirbridgeInAppPurchaseEnvironment;ZLjava/util/List;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class AirbridgeOption {
    @Nullable
    private final AirbridgeLifecycleIntegration A;
    @Nullable
    private final Map B;
    @Nullable
    private final Map C;
    @Nullable
    private final OnInAppPurchaseReceiveListener D;
    @NotNull
    private final AirbridgeInAppPurchaseEnvironment E;
    private final boolean F;
    @NotNull
    private final List G;
    private int a;
    private int b;
    private final boolean c;
    @NotNull
    private final String d;
    @NotNull
    private final String e;
    @Nullable
    private final String f;
    @Nullable
    private final String g;
    @NotNull
    private final AirbridgeLogLevel h;
    private final long i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    @NotNull
    private final String s;
    @NotNull
    private final String t;
    private final int u;
    private final double v;
    private final long w;
    @NotNull
    private final List x;
    @Nullable
    private final OnAttributionResultReceiveListener y;
    @Nullable
    private final String z;

    public AirbridgeOption(@NotNull String s, @NotNull String s1, @Nullable String s2, @Nullable String s3, @NotNull AirbridgeLogLevel airbridgeLogLevel0, long v, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, @NotNull String s4, @NotNull String s5, int v1, double f, long v2, @NotNull List list0, @Nullable OnAttributionResultReceiveListener onAttributionResultReceiveListener0, @Nullable String s6, @Nullable AirbridgeLifecycleIntegration airbridgeLifecycleIntegration0, @Nullable Map map0, @Nullable Map map1, @Nullable OnInAppPurchaseReceiveListener onInAppPurchaseReceiveListener0, @NotNull AirbridgeInAppPurchaseEnvironment airbridgeInAppPurchaseEnvironment0, boolean z9, @NotNull List list1) {
        this.d = s;
        this.e = s1;
        this.f = s2;
        this.g = s3;
        this.h = airbridgeLogLevel0;
        this.i = v;
        this.j = z;
        this.k = z1;
        this.l = z2;
        this.m = z3;
        this.n = z4;
        this.o = z5;
        this.p = z6;
        this.q = z7;
        this.r = z8;
        this.s = s4;
        this.t = s5;
        this.u = v1;
        this.v = f;
        this.w = v2;
        this.x = list0;
        this.y = onAttributionResultReceiveListener0;
        this.z = s6;
        this.A = airbridgeLifecycleIntegration0;
        this.B = map0;
        this.C = map1;
        this.D = onInAppPurchaseReceiveListener0;
        this.E = airbridgeInAppPurchaseEnvironment0;
        this.F = z9;
        this.G = list1;
        this.a = 5;
        this.b = 60000;
        this.c = s2 != null && s3 != null;
    }

    @NotNull
    public final String component1() {
        return this.d;
    }

    public final boolean component10() {
        return this.m;
    }

    public final boolean component11() {
        return this.n;
    }

    public final boolean component12() {
        return this.o;
    }

    public final boolean component13() {
        return this.p;
    }

    public final boolean component14() {
        return this.q;
    }

    public final boolean component15() {
        return this.r;
    }

    @NotNull
    public final String component16() {
        return this.s;
    }

    @NotNull
    public final String component17() {
        return this.t;
    }

    public final int component18() {
        return this.u;
    }

    public final double component19() {
        return this.v;
    }

    @NotNull
    public final String component2() {
        return this.e;
    }

    public final long component20() {
        return this.w;
    }

    @NotNull
    public final List component21() {
        return this.x;
    }

    @Nullable
    public final OnAttributionResultReceiveListener component22() {
        return this.y;
    }

    @Nullable
    public final String component23() {
        return this.z;
    }

    @Nullable
    public final AirbridgeLifecycleIntegration component24() {
        return this.A;
    }

    @Nullable
    public final Map component25() {
        return this.B;
    }

    @Nullable
    public final Map component26() {
        return this.C;
    }

    @Nullable
    public final OnInAppPurchaseReceiveListener component27() {
        return this.D;
    }

    @NotNull
    public final AirbridgeInAppPurchaseEnvironment component28() {
        return this.E;
    }

    public final boolean component29() {
        return this.F;
    }

    @Nullable
    public final String component3() {
        return this.f;
    }

    @NotNull
    public final List component30() {
        return this.G;
    }

    @Nullable
    public final String component4() {
        return this.g;
    }

    @NotNull
    public final AirbridgeLogLevel component5() {
        return this.h;
    }

    public final long component6() {
        return this.i;
    }

    public final boolean component7() {
        return this.j;
    }

    public final boolean component8() {
        return this.k;
    }

    public final boolean component9() {
        return this.l;
    }

    @NotNull
    public final AirbridgeOption copy(@NotNull String s, @NotNull String s1, @Nullable String s2, @Nullable String s3, @NotNull AirbridgeLogLevel airbridgeLogLevel0, long v, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, @NotNull String s4, @NotNull String s5, int v1, double f, long v2, @NotNull List list0, @Nullable OnAttributionResultReceiveListener onAttributionResultReceiveListener0, @Nullable String s6, @Nullable AirbridgeLifecycleIntegration airbridgeLifecycleIntegration0, @Nullable Map map0, @Nullable Map map1, @Nullable OnInAppPurchaseReceiveListener onInAppPurchaseReceiveListener0, @NotNull AirbridgeInAppPurchaseEnvironment airbridgeInAppPurchaseEnvironment0, boolean z9, @NotNull List list1) {
        return new AirbridgeOption(s, s1, s2, s3, airbridgeLogLevel0, v, z, z1, z2, z3, z4, z5, z6, z7, z8, s4, s5, v1, f, v2, list0, onAttributionResultReceiveListener0, s6, airbridgeLifecycleIntegration0, map0, map1, onInAppPurchaseReceiveListener0, airbridgeInAppPurchaseEnvironment0, z9, list1);
    }

    public static AirbridgeOption copy$default(AirbridgeOption airbridgeOption0, String s, String s1, String s2, String s3, AirbridgeLogLevel airbridgeLogLevel0, long v, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, String s4, String s5, int v1, double f, long v2, List list0, OnAttributionResultReceiveListener onAttributionResultReceiveListener0, String s6, AirbridgeLifecycleIntegration airbridgeLifecycleIntegration0, Map map0, Map map1, OnInAppPurchaseReceiveListener onInAppPurchaseReceiveListener0, AirbridgeInAppPurchaseEnvironment airbridgeInAppPurchaseEnvironment0, boolean z9, List list1, int v3, Object object0) {
        String s7 = (v3 & 1) == 0 ? s : airbridgeOption0.d;
        String s8 = (v3 & 2) == 0 ? s1 : airbridgeOption0.e;
        String s9 = (v3 & 4) == 0 ? s2 : airbridgeOption0.f;
        String s10 = (v3 & 8) == 0 ? s3 : airbridgeOption0.g;
        AirbridgeLogLevel airbridgeLogLevel1 = (v3 & 16) == 0 ? airbridgeLogLevel0 : airbridgeOption0.h;
        long v4 = (v3 & 0x20) == 0 ? v : airbridgeOption0.i;
        boolean z10 = (v3 & 0x40) == 0 ? z : airbridgeOption0.j;
        boolean z11 = (v3 & 0x80) == 0 ? z1 : airbridgeOption0.k;
        boolean z12 = (v3 & 0x100) == 0 ? z2 : airbridgeOption0.l;
        boolean z13 = (v3 & 0x200) == 0 ? z3 : airbridgeOption0.m;
        boolean z14 = (v3 & 0x400) == 0 ? z4 : airbridgeOption0.n;
        boolean z15 = (v3 & 0x800) == 0 ? z5 : airbridgeOption0.o;
        boolean z16 = (v3 & 0x1000) == 0 ? z6 : airbridgeOption0.p;
        boolean z17 = (v3 & 0x2000) == 0 ? z7 : airbridgeOption0.q;
        boolean z18 = (v3 & 0x4000) == 0 ? z8 : airbridgeOption0.r;
        String s11 = (v3 & 0x8000) == 0 ? s4 : airbridgeOption0.s;
        String s12 = (v3 & 0x10000) == 0 ? s5 : airbridgeOption0.t;
        int v5 = (v3 & 0x20000) == 0 ? v1 : airbridgeOption0.u;
        double f1 = (v3 & 0x40000) == 0 ? f : airbridgeOption0.v;
        long v6 = (v3 & 0x80000) == 0 ? v2 : airbridgeOption0.w;
        List list2 = (v3 & 0x100000) == 0 ? list0 : airbridgeOption0.x;
        OnAttributionResultReceiveListener onAttributionResultReceiveListener1 = (v3 & 0x200000) == 0 ? onAttributionResultReceiveListener0 : airbridgeOption0.y;
        String s13 = (v3 & 0x400000) == 0 ? s6 : airbridgeOption0.z;
        AirbridgeLifecycleIntegration airbridgeLifecycleIntegration1 = (v3 & 0x800000) == 0 ? airbridgeLifecycleIntegration0 : airbridgeOption0.A;
        Map map2 = (v3 & 0x1000000) == 0 ? map0 : airbridgeOption0.B;
        Map map3 = (v3 & 0x2000000) == 0 ? map1 : airbridgeOption0.C;
        OnInAppPurchaseReceiveListener onInAppPurchaseReceiveListener1 = (v3 & 0x4000000) == 0 ? onInAppPurchaseReceiveListener0 : airbridgeOption0.D;
        AirbridgeInAppPurchaseEnvironment airbridgeInAppPurchaseEnvironment1 = (v3 & 0x8000000) == 0 ? airbridgeInAppPurchaseEnvironment0 : airbridgeOption0.E;
        boolean z19 = (v3 & 0x10000000) == 0 ? z9 : airbridgeOption0.F;
        return (v3 & 0x20000000) == 0 ? airbridgeOption0.copy(s7, s8, s9, s10, airbridgeLogLevel1, v4, z10, z11, z12, z13, z14, z15, z16, z17, z18, s11, s12, v5, f1, v6, list2, onAttributionResultReceiveListener1, s13, airbridgeLifecycleIntegration1, map2, map3, onInAppPurchaseReceiveListener1, airbridgeInAppPurchaseEnvironment1, z19, list1) : airbridgeOption0.copy(s7, s8, s9, s10, airbridgeLogLevel1, v4, z10, z11, z12, z13, z14, z15, z16, z17, z18, s11, s12, v5, f1, v6, list2, onAttributionResultReceiveListener1, s13, airbridgeLifecycleIntegration1, map2, map3, onInAppPurchaseReceiveListener1, airbridgeInAppPurchaseEnvironment1, z19, airbridgeOption0.G);
    }

    // 去混淆评级： 低(28)
    @Override
    public boolean equals(@Nullable Object object0) {
        if(this != object0) {
            if(object0 instanceof AirbridgeOption) {
                AirbridgeOption airbridgeOption0 = (AirbridgeOption)object0;
                return q.b(this.d, airbridgeOption0.d) && q.b(this.e, airbridgeOption0.e) && q.b(this.f, airbridgeOption0.f) && q.b(this.g, airbridgeOption0.g) && q.b(this.h, airbridgeOption0.h) && this.i == airbridgeOption0.i && this.j == airbridgeOption0.j && this.k == airbridgeOption0.k && this.l == airbridgeOption0.l && this.m == airbridgeOption0.m && this.n == airbridgeOption0.n && this.o == airbridgeOption0.o && this.p == airbridgeOption0.p && this.q == airbridgeOption0.q && this.r == airbridgeOption0.r && q.b(this.s, airbridgeOption0.s) && q.b(this.t, airbridgeOption0.t) && this.u == airbridgeOption0.u && Double.compare(this.v, airbridgeOption0.v) == 0 && this.w == airbridgeOption0.w && q.b(this.x, airbridgeOption0.x) && q.b(this.y, airbridgeOption0.y) && q.b(this.z, airbridgeOption0.z) && q.b(this.A, airbridgeOption0.A) && q.b(this.B, airbridgeOption0.B) && q.b(this.C, airbridgeOption0.C) && q.b(this.D, airbridgeOption0.D) && q.b(this.E, airbridgeOption0.E) && this.F == airbridgeOption0.F && q.b(this.G, airbridgeOption0.G);
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getAppMarketIdentifier() {
        return this.s;
    }

    public final int getAttributionRequestMaxCount$airbridge_release() {
        return this.a;
    }

    public final int getAttributionTimeout$airbridge_release() {
        return this.b;
    }

    @NotNull
    public final List getCustomDomains() {
        return this.x;
    }

    public final int getEventMaximumBufferCount() {
        return this.u;
    }

    public final double getEventMaximumBufferSize() {
        return this.v;
    }

    public final long getEventTransmitIntervalMillis() {
        return this.w;
    }

    @Nullable
    public final String getFacebookAppId() {
        return this.z;
    }

    @NotNull
    public final AirbridgeInAppPurchaseEnvironment getInAppPurchaseEnvironment() {
        return this.E;
    }

    @Nullable
    public final AirbridgeLifecycleIntegration getLifecycleIntegration() {
        return this.A;
    }

    @NotNull
    public final AirbridgeLogLevel getLogLevel() {
        return this.h;
    }

    @NotNull
    public final String getName() {
        return this.d;
    }

    @Nullable
    public final OnAttributionResultReceiveListener getOnAttributionResultReceiveListener() {
        return this.y;
    }

    @Nullable
    public final OnInAppPurchaseReceiveListener getOnInAppPurchaseReceiveListener() {
        return this.D;
    }

    @NotNull
    public final String getPlatform() {
        return this.t;
    }

    @Nullable
    public final Map getSdkAttributes() {
        return this.B;
    }

    @Nullable
    public final Map getSdkWrapperOption() {
        return this.C;
    }

    @Nullable
    public final String getSecretId() {
        return this.f;
    }

    @Nullable
    public final String getSecretKey() {
        return this.g;
    }

    public final long getSessionTimeoutMillis() {
        return this.i;
    }

    @NotNull
    public final String getToken() {
        return this.e;
    }

    @NotNull
    public final List getTrackingBlocklist() {
        return this.G;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.c((((((this.d == null ? 0 : this.d.hashCode()) * 0x1F + (this.e == null ? 0 : this.e.hashCode())) * 0x1F + (this.f == null ? 0 : this.f.hashCode())) * 0x1F + (this.g == null ? 0 : this.g.hashCode())) * 0x1F + (this.h == null ? 0 : this.h.hashCode())) * 0x1F, 0x1F, this.i);
        int v2 = this.j;
        int v3 = 1;
        if(v2) {
            v2 = 1;
        }
        int v4 = this.k;
        if(v4) {
            v4 = 1;
        }
        int v5 = this.l;
        if(v5) {
            v5 = 1;
        }
        int v6 = this.m;
        if(v6) {
            v6 = 1;
        }
        int v7 = this.n;
        if(v7) {
            v7 = 1;
        }
        int v8 = this.o;
        if(v8) {
            v8 = 1;
        }
        int v9 = this.p;
        if(v9) {
            v9 = 1;
        }
        int v10 = this.q;
        if(v10) {
            v10 = 1;
        }
        int v11 = this.r;
        if(v11) {
            v11 = 1;
        }
        int v12 = d.c((Double.hashCode(this.v) + d.b(this.u, (((((((((((v1 + v2) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v10) * 0x1F + v11) * 0x1F + (this.s == null ? 0 : this.s.hashCode())) * 0x1F + (this.t == null ? 0 : this.t.hashCode())) * 0x1F, 0x1F)) * 0x1F, 0x1F, this.w);
        int v13 = this.x == null ? 0 : this.x.hashCode();
        int v14 = this.y == null ? 0 : this.y.hashCode();
        int v15 = this.z == null ? 0 : this.z.hashCode();
        int v16 = this.A == null ? 0 : this.A.hashCode();
        int v17 = this.B == null ? 0 : this.B.hashCode();
        int v18 = this.C == null ? 0 : this.C.hashCode();
        int v19 = this.D == null ? 0 : this.D.hashCode();
        int v20 = this.E == null ? 0 : this.E.hashCode();
        if(!this.F) {
            v3 = false;
        }
        List list0 = this.G;
        if(list0 != null) {
            v = list0.hashCode();
        }
        return (((((((((v12 + v13) * 0x1F + v14) * 0x1F + v15) * 0x1F + v16) * 0x1F + v17) * 0x1F + v18) * 0x1F + v19) * 0x1F + v20) * 0x1F + v3) * 0x1F + v;
    }

    public final boolean isAutoStartTrackingEnabled() {
        return this.k;
    }

    public final boolean isCollectTCFDataEnabled() {
        return this.F;
    }

    public final boolean isFacebookDeferredAppLinkEnabled() {
        return this.p;
    }

    public final boolean isLocationCollectionEnabled() {
        return this.o;
    }

    public final boolean isPauseEventTransmitOnBackgroundEnabled() {
        return this.n;
    }

    public final boolean isResetEventBufferEnabled() {
        return this.q;
    }

    public final boolean isSDKSignatureSecretEnabled$airbridge_release() {
        return this.c;
    }

    public final boolean isSdkEnabled() {
        return this.r;
    }

    public final boolean isTrackAirbridgeLinkOnly() {
        return this.m;
    }

    public final boolean isTrackInSessionLifeCycleEventEnabled() {
        return this.l;
    }

    public final boolean isUserInfoHashEnabled() {
        return this.j;
    }

    public final void setAttributionRequestMaxCount$airbridge_release(int v) {
        this.a = v;
    }

    public final void setAttributionTimeout$airbridge_release(int v) {
        this.b = v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("AirbridgeOption(name=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", token=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", secretId=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", secretKey=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", logLevel=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", sessionTimeoutMillis=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", isUserInfoHashEnabled=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", isAutoStartTrackingEnabled=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", isTrackInSessionLifeCycleEventEnabled=");
        stringBuilder0.append(this.l);
        stringBuilder0.append(", isTrackAirbridgeLinkOnly=");
        stringBuilder0.append(this.m);
        stringBuilder0.append(", isPauseEventTransmitOnBackgroundEnabled=");
        stringBuilder0.append(this.n);
        stringBuilder0.append(", isLocationCollectionEnabled=");
        stringBuilder0.append(this.o);
        stringBuilder0.append(", isFacebookDeferredAppLinkEnabled=");
        stringBuilder0.append(this.p);
        stringBuilder0.append(", isResetEventBufferEnabled=");
        stringBuilder0.append(this.q);
        stringBuilder0.append(", isSdkEnabled=");
        stringBuilder0.append(this.r);
        stringBuilder0.append(", appMarketIdentifier=");
        stringBuilder0.append(this.s);
        stringBuilder0.append(", platform=");
        stringBuilder0.append(this.t);
        stringBuilder0.append(", eventMaximumBufferCount=");
        stringBuilder0.append(this.u);
        stringBuilder0.append(", eventMaximumBufferSize=");
        stringBuilder0.append(this.v);
        stringBuilder0.append(", eventTransmitIntervalMillis=");
        stringBuilder0.append(this.w);
        stringBuilder0.append(", customDomains=");
        stringBuilder0.append(this.x);
        stringBuilder0.append(", onAttributionResultReceiveListener=");
        stringBuilder0.append(this.y);
        stringBuilder0.append(", facebookAppId=");
        stringBuilder0.append(this.z);
        stringBuilder0.append(", lifecycleIntegration=");
        stringBuilder0.append(this.A);
        stringBuilder0.append(", sdkAttributes=");
        stringBuilder0.append(this.B);
        stringBuilder0.append(", sdkWrapperOption=");
        stringBuilder0.append(this.C);
        stringBuilder0.append(", onInAppPurchaseReceiveListener=");
        stringBuilder0.append(this.D);
        stringBuilder0.append(", inAppPurchaseEnvironment=");
        stringBuilder0.append(this.E);
        stringBuilder0.append(", isCollectTCFDataEnabled=");
        stringBuilder0.append(this.F);
        stringBuilder0.append(", trackingBlocklist=");
        return Y.m(stringBuilder0, this.G, ")");
    }
}

