package co.ab180.airbridge;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import co.ab180.airbridge.common.Event;
import co.ab180.airbridge.common.OnFailure;
import co.ab180.airbridge.common.OnSuccess;
import co.ab180.airbridge.internal.a;
import co.ab180.airbridge.internal.b;
import co.ab180.airbridge.internal.f;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009E\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000B\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u00C6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\u000B\u0010\u0003J\u000F\u0010\f\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\f\u0010\u0003J\u000F\u0010\u000E\u001A\u00020\rH\u0007\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\rH\u0007\u00A2\u0006\u0004\b\u0010\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\u0011\u0010\u0003J\u000F\u0010\u0012\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0003J\u000F\u0010\u0013\u001A\u00020\rH\u0007\u00A2\u0006\u0004\b\u0013\u0010\u000FJ\u000F\u0010\u0014\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\u0014\u0010\u0003J\u000F\u0010\u0015\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0003J\u001D\u0010\u0019\u001A\u00020\r2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\'\u0010\u0019\u001A\u00020\r2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\b\u0019\u0010\u001DJ\u001D\u0010\u001E\u001A\u00020\r2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007\u00A2\u0006\u0004\b\u001E\u0010\u001AJ\'\u0010\u001E\u001A\u00020\r2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\b\u001E\u0010\u001DJ\u001F\u0010!\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u00172\u0006\u0010 \u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b%\u0010\u0003J\u0017\u0010\'\u001A\u00020\b2\u0006\u0010&\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b\'\u0010$J\u000F\u0010(\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b(\u0010\u0003J\u0017\u0010*\u001A\u00020\b2\u0006\u0010)\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b*\u0010$J\u000F\u0010+\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b+\u0010\u0003J\u0017\u0010-\u001A\u00020\b2\u0006\u0010,\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b-\u0010$J\u000F\u0010.\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b.\u0010\u0003J\u001F\u00100\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u00172\u0006\u0010 \u001A\u00020/H\u0007\u00A2\u0006\u0004\b0\u00101J\u001F\u00100\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u00172\u0006\u0010 \u001A\u000202H\u0007\u00A2\u0006\u0004\b0\u00103J\u001F\u00100\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u00172\u0006\u0010 \u001A\u000204H\u0007\u00A2\u0006\u0004\b0\u00105J\u001F\u00100\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u00172\u0006\u0010 \u001A\u000206H\u0007\u00A2\u0006\u0004\b0\u00107J\u001F\u00100\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u00172\u0006\u0010 \u001A\u00020\rH\u0007\u00A2\u0006\u0004\b0\u00108J\u001F\u00100\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u00172\u0006\u0010 \u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b0\u0010\"J\u0017\u00109\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b9\u0010$J\u000F\u0010:\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b:\u0010\u0003J\u001F\u0010;\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u00172\u0006\u0010 \u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b;\u0010\"J\u0017\u0010<\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b<\u0010$J\u000F\u0010=\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b=\u0010\u0003J\u000F\u0010>\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b>\u0010\u0003J\u0017\u0010@\u001A\u00020\b2\u0006\u0010?\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b@\u0010$JK\u0010E\u001A\u00020\b2\u0006\u0010A\u001A\u00020\u00172\u0018\b\u0002\u0010C\u001A\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010B2\u0018\b\u0002\u0010D\u001A\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010BH\u0007\u00A2\u0006\u0004\bE\u0010FJ%\u0010J\u001A\u00020\r2\u0006\u0010H\u001A\u00020G2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020I0\u0016H\u0007\u00A2\u0006\u0004\bJ\u0010KJ/\u0010J\u001A\u00020\r2\u0006\u0010H\u001A\u00020G2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020I0\u00162\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\bJ\u0010LJ\u001F\u0010M\u001A\u00020\r2\u000E\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010I0\u0016H\u0007\u00A2\u0006\u0004\bM\u0010\u001AJ)\u0010M\u001A\u00020\r2\u000E\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010I0\u00162\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\bM\u0010\u001DJ)\u0010O\u001A\u00020\r2\u0006\u0010N\u001A\u00020I2\u0010\b\u0002\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0016H\u0007\u00A2\u0006\u0004\bO\u0010PJ1\u0010O\u001A\u00020\r2\u0006\u0010N\u001A\u00020I2\u000E\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00162\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\bO\u0010QJ)\u0010R\u001A\u00020\r2\u0006\u0010N\u001A\u00020I2\u0010\b\u0002\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0016H\u0007\u00A2\u0006\u0004\bR\u0010PJ1\u0010R\u001A\u00020\r2\u0006\u0010N\u001A\u00020I2\u000E\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00162\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\bR\u0010QJ\u001F\u0010V\u001A\u00020\b2\u0006\u0010T\u001A\u00020S2\u0006\u0010U\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\bV\u0010WJ\u001F\u0010Y\u001A\u00020\u00172\u0006\u0010U\u001A\u00020\u00172\u0006\u0010X\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\bY\u0010ZJ\u0017\u0010\\\u001A\u00020\b2\u0006\u0010[\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b\\\u0010$J\u0017\u0010_\u001A\u00020\r2\u0006\u0010^\u001A\u00020]H\u0007\u00A2\u0006\u0004\b_\u0010`J\u001F\u0010b\u001A\u00020\r2\u000E\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010a0\u0016H\u0007\u00A2\u0006\u0004\bb\u0010\u001AJ+\u0010b\u001A\u00020\r2\u000E\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010a0\u00162\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\bb\u0010\u001DJ\u001F\u0010c\u001A\u00020\r2\u000E\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010a0\u0016H\u0007\u00A2\u0006\u0004\bc\u0010\u001AJ+\u0010c\u001A\u00020\r2\u000E\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010a0\u00162\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\bc\u0010\u001DJ\u001F\u0010d\u001A\u00020\r2\u000E\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010a0\u0016H\u0007\u00A2\u0006\u0004\bd\u0010\u001AJ+\u0010d\u001A\u00020\r2\u000E\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010a0\u00162\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\bd\u0010\u001DJ\u001F\u0010e\u001A\u00020\r2\u000E\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010a0\u0016H\u0007\u00A2\u0006\u0004\be\u0010\u001AJ+\u0010e\u001A\u00020\r2\u000E\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010a0\u00162\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\be\u0010\u001DJ\u001D\u0010g\u001A\u00020\r2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020f0\u0016H\u0007\u00A2\u0006\u0004\bg\u0010\u001AJ)\u0010g\u001A\u00020\r2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020f0\u00162\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\bg\u0010\u001DJ\u001D\u0010h\u001A\u00020\r2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020f0\u0016H\u0007\u00A2\u0006\u0004\bh\u0010\u001AJ)\u0010h\u001A\u00020\r2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020f0\u00162\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\bh\u0010\u001DJ9\u0010k\u001A\u00020\b2\u0006\u0010i\u001A\u00020\u00172\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010B2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020j0\u0016H\u0007\u00A2\u0006\u0004\bk\u0010lJC\u0010k\u001A\u00020\b2\u0006\u0010i\u001A\u00020\u00172\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010B2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020j0\u00162\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\bk\u0010mR\u0014\u0010q\u001A\u00020n8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bo\u0010pR$\u0010w\u001A\u0004\u0018\u00010n8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\br\u0010p\u001A\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0014\u0010y\u001A\u00020n8@X\u0080\u0004\u00A2\u0006\u0006\u001A\u0004\bx\u0010t\u00A8\u0006z"}, d2 = {"Lco/ab180/airbridge/Airbridge;", "", "<init>", "()V", "Landroid/app/Application;", "app", "Lco/ab180/airbridge/AirbridgeOption;", "option", "Lie/H;", "initializeSDK", "(Landroid/app/Application;Lco/ab180/airbridge/AirbridgeOption;)V", "enableSDK", "disableSDK", "", "isSDKEnabled", "()Z", "isTrackingEnabled", "startTracking", "stopTracking", "isInAppPurchaseTrackingEnabled", "startInAppPurchaseTracking", "stopInAppPurchaseTracking", "Lco/ab180/airbridge/common/OnSuccess;", "", "onSuccess", "fetchAirbridgeGeneratedUUID", "(Lco/ab180/airbridge/common/OnSuccess;)Z", "Lco/ab180/airbridge/common/OnFailure;", "onFailure", "(Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "fetchDeviceUUID", "key", "value", "setDeviceAlias", "(Ljava/lang/String;Ljava/lang/String;)V", "removeDeviceAlias", "(Ljava/lang/String;)V", "clearDeviceAlias", "id", "setUserID", "clearUserID", "email", "setUserEmail", "clearUserEmail", "phone", "setUserPhone", "clearUserPhone", "", "setUserAttribute", "(Ljava/lang/String;I)V", "", "(Ljava/lang/String;J)V", "", "(Ljava/lang/String;F)V", "", "(Ljava/lang/String;D)V", "(Ljava/lang/String;Z)V", "removeUserAttribute", "clearUserAttributes", "setUserAlias", "removeUserAlias", "clearUserAlias", "clearUser", "token", "registerPushToken", "category", "", "semanticAttributes", "customAttributes", "trackEvent", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "Landroid/content/Intent;", "intent", "Landroid/net/Uri;", "handleDeeplink", "(Landroid/content/Intent;Lco/ab180/airbridge/common/OnSuccess;)Z", "(Landroid/content/Intent;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "handleDeferredDeeplink", "trackingLink", "click", "(Landroid/net/Uri;Lco/ab180/airbridge/common/OnSuccess;)Z", "(Landroid/net/Uri;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "impression", "Landroid/webkit/WebView;", "webView", "webToken", "setWebInterface", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "postMessageScript", "createWebInterfaceScript", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "command", "handleWebInterfaceCommand", "Lcom/google/firebase/messaging/RemoteMessage;", "remoteMessage", "isUninstallTrackingNotification", "(Lcom/google/firebase/messaging/RemoteMessage;)Z", "Lco/ab180/airbridge/common/ReferrerDetails;", "fetchGoogleInstallReferrerDetails", "fetchHuaweiInstallReferrerDetails", "fetchGalaxyStoreInstallReferrerDetails", "fetchMetaInstallReferrerDetails", "Lco/ab180/airbridge/common/AdvertisingIdInfo;", "fetchGoogleAdvertisingIdInfo", "fetchHuaweiAdvertisingIdInfo", "channel", "Lco/ab180/airbridge/common/AirbridgeTrackingLink;", "createTrackingLink", "(Ljava/lang/String;Ljava/util/Map;Lco/ab180/airbridge/common/OnSuccess;)V", "(Ljava/lang/String;Ljava/util/Map;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)V", "Lco/ab180/airbridge/internal/a;", "a", "Lco/ab180/airbridge/internal/a;", "defaultInstance", "b", "getInjectInstance$airbridge_release", "()Lco/ab180/airbridge/internal/a;", "setInjectInstance$airbridge_release", "(Lco/ab180/airbridge/internal/a;)V", "injectInstance", "getInstance$airbridge_release", "instance", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class Airbridge {
    @NotNull
    public static final Airbridge INSTANCE;
    private static final a a;
    @Nullable
    private static a b;

    static {
        Airbridge.INSTANCE = new Airbridge();
        Airbridge.a = new a(new f());
    }

    public static final void clearDeviceAlias() {
        b.e.d("{clearDeviceAlias} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().b();
    }

    public static final void clearUser() {
        b.e.d("{clearUser} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().e();
    }

    public static final void clearUserAlias() {
        b.e.d("{clearUserAlias} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().d();
    }

    public static final void clearUserAttributes() {
        b.e.d("{clearUserAttributes} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a();
    }

    public static final void clearUserEmail() {
        b.e.d("{clearUserEmail} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().c(null);
    }

    public static final void clearUserID() {
        b.e.d("{clearUserID} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().d(null);
    }

    public static final void clearUserPhone() {
        b.e.d("{clearUserPhone} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().b(null);
    }

    public static final boolean click(@NotNull Uri uri0) {
        return Airbridge.click$default(uri0, null, 2, null);
    }

    public static final boolean click(@NotNull Uri uri0, @Nullable OnSuccess onSuccess0) {
        return Airbridge.click(uri0, onSuccess0, null);
    }

    public static final boolean click(@NotNull Uri uri0, @Nullable OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        b.e.d("{click} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().b(uri0.toString(), onSuccess0, onFailure0);
    }

    public static boolean click$default(Uri uri0, OnSuccess onSuccess0, int v, Object object0) {
        if((v & 2) != 0) {
            onSuccess0 = null;
        }
        return Airbridge.click(uri0, onSuccess0);
    }

    public static final void createTrackingLink(@NotNull String s, @NotNull Map map0, @NotNull OnSuccess onSuccess0) {
        Airbridge.createTrackingLink(s, map0, onSuccess0, null);
    }

    public static final void createTrackingLink(@NotNull String s, @NotNull Map map0, @NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        b.e.d("{createTrackingLink} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a(s, map0, onSuccess0, onFailure0);
    }

    @NotNull
    public static final String createWebInterfaceScript(@NotNull String s, @NotNull String s1) {
        b.e.d("{createWebInterfaceScript} is called: {" + s + "} {" + s1 + '}', new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().c(s, s1);
    }

    public static final void disableSDK() {
        b.e.d("{disableSDK} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().l();
    }

    public static final void enableSDK() {
        b.e.d("{enableSDK} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().j();
    }

    public static final boolean fetchAirbridgeGeneratedUUID(@NotNull OnSuccess onSuccess0) {
        return Airbridge.fetchAirbridgeGeneratedUUID(onSuccess0, null);
    }

    public static final boolean fetchAirbridgeGeneratedUUID(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        b.e.d("{fetchAirbridgeGeneratedUUID} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().c(onSuccess0, onFailure0);
    }

    public static final boolean fetchDeviceUUID(@NotNull OnSuccess onSuccess0) {
        return Airbridge.fetchDeviceUUID(onSuccess0, null);
    }

    public static final boolean fetchDeviceUUID(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        b.e.d("{fetchDeviceUUID} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().b(onSuccess0, onFailure0);
    }

    public static final boolean fetchGalaxyStoreInstallReferrerDetails(@NotNull OnSuccess onSuccess0) {
        return Airbridge.fetchGalaxyStoreInstallReferrerDetails(onSuccess0, null);
    }

    public static final boolean fetchGalaxyStoreInstallReferrerDetails(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        b.e.d("{fetchGalaxyStoreInstallReferrerDetails} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().d("galaxy_store", onSuccess0, onFailure0);
    }

    public static boolean fetchGalaxyStoreInstallReferrerDetails$default(OnSuccess onSuccess0, OnFailure onFailure0, int v, Object object0) {
        if((v & 2) != 0) {
            onFailure0 = null;
        }
        return Airbridge.fetchGalaxyStoreInstallReferrerDetails(onSuccess0, onFailure0);
    }

    public static final boolean fetchGoogleAdvertisingIdInfo(@NotNull OnSuccess onSuccess0) {
        return Airbridge.fetchGoogleAdvertisingIdInfo(onSuccess0, null);
    }

    public static final boolean fetchGoogleAdvertisingIdInfo(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        b.e.d("{fetchGoogleAdvertisingIdInfo} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().a("google", onSuccess0, onFailure0);
    }

    public static boolean fetchGoogleAdvertisingIdInfo$default(OnSuccess onSuccess0, OnFailure onFailure0, int v, Object object0) {
        if((v & 2) != 0) {
            onFailure0 = null;
        }
        return Airbridge.fetchGoogleAdvertisingIdInfo(onSuccess0, onFailure0);
    }

    public static final boolean fetchGoogleInstallReferrerDetails(@NotNull OnSuccess onSuccess0) {
        return Airbridge.fetchGoogleInstallReferrerDetails(onSuccess0, null);
    }

    public static final boolean fetchGoogleInstallReferrerDetails(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        b.e.d("{fetchGoogleInstallReferrerDetails} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().d("google", onSuccess0, onFailure0);
    }

    public static boolean fetchGoogleInstallReferrerDetails$default(OnSuccess onSuccess0, OnFailure onFailure0, int v, Object object0) {
        if((v & 2) != 0) {
            onFailure0 = null;
        }
        return Airbridge.fetchGoogleInstallReferrerDetails(onSuccess0, onFailure0);
    }

    public static final boolean fetchHuaweiAdvertisingIdInfo(@NotNull OnSuccess onSuccess0) {
        return Airbridge.fetchHuaweiAdvertisingIdInfo(onSuccess0, null);
    }

    public static final boolean fetchHuaweiAdvertisingIdInfo(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        b.e.d("{fetchHuaweiAdvertisingIdInfo} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().a("huawei", onSuccess0, onFailure0);
    }

    public static boolean fetchHuaweiAdvertisingIdInfo$default(OnSuccess onSuccess0, OnFailure onFailure0, int v, Object object0) {
        if((v & 2) != 0) {
            onFailure0 = null;
        }
        return Airbridge.fetchHuaweiAdvertisingIdInfo(onSuccess0, onFailure0);
    }

    public static final boolean fetchHuaweiInstallReferrerDetails(@NotNull OnSuccess onSuccess0) {
        return Airbridge.fetchHuaweiInstallReferrerDetails(onSuccess0, null);
    }

    public static final boolean fetchHuaweiInstallReferrerDetails(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        b.e.d("{fetchHuaweiInstallReferrerDetails} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().d("huawei", onSuccess0, onFailure0);
    }

    public static boolean fetchHuaweiInstallReferrerDetails$default(OnSuccess onSuccess0, OnFailure onFailure0, int v, Object object0) {
        if((v & 2) != 0) {
            onFailure0 = null;
        }
        return Airbridge.fetchHuaweiInstallReferrerDetails(onSuccess0, onFailure0);
    }

    public static final boolean fetchMetaInstallReferrerDetails(@NotNull OnSuccess onSuccess0) {
        return Airbridge.fetchMetaInstallReferrerDetails(onSuccess0, null);
    }

    public static final boolean fetchMetaInstallReferrerDetails(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        b.e.d("{fetchMetaInstallReferrerDetails} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().d("meta", onSuccess0, onFailure0);
    }

    public static boolean fetchMetaInstallReferrerDetails$default(OnSuccess onSuccess0, OnFailure onFailure0, int v, Object object0) {
        if((v & 2) != 0) {
            onFailure0 = null;
        }
        return Airbridge.fetchMetaInstallReferrerDetails(onSuccess0, onFailure0);
    }

    @Nullable
    public final a getInjectInstance$airbridge_release() {
        return Airbridge.b;
    }

    @NotNull
    public final a getInstance$airbridge_release() {
        return Airbridge.b == null ? Airbridge.a : Airbridge.b;
    }

    public static final boolean handleDeeplink(@NotNull Intent intent0, @NotNull OnSuccess onSuccess0) {
        return Airbridge.handleDeeplink(intent0, onSuccess0, null);
    }

    public static final boolean handleDeeplink(@NotNull Intent intent0, @NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        b.e.d("{handleDeeplink} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().a(intent0, onSuccess0, onFailure0);
    }

    public static final boolean handleDeferredDeeplink(@NotNull OnSuccess onSuccess0) {
        return Airbridge.handleDeferredDeeplink(onSuccess0, null);
    }

    public static final boolean handleDeferredDeeplink(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        b.e.d("{handleDeferredDeeplink} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().a(onSuccess0, onFailure0);
    }

    public static final void handleWebInterfaceCommand(@NotNull String s) {
        b.e.d("{handleWebInterfaceCommand} is called: {" + s + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().f(s);
    }

    public static final boolean impression(@NotNull Uri uri0) {
        return Airbridge.impression$default(uri0, null, 2, null);
    }

    public static final boolean impression(@NotNull Uri uri0, @Nullable OnSuccess onSuccess0) {
        return Airbridge.impression(uri0, onSuccess0, null);
    }

    public static final boolean impression(@NotNull Uri uri0, @Nullable OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        b.e.d("{impression} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().c(uri0.toString(), onSuccess0, onFailure0);
    }

    public static boolean impression$default(Uri uri0, OnSuccess onSuccess0, int v, Object object0) {
        if((v & 2) != 0) {
            onSuccess0 = null;
        }
        return Airbridge.impression(uri0, onSuccess0);
    }

    public static final void initializeSDK(@NotNull Application application0, @NotNull AirbridgeOption airbridgeOption0) {
        b.e.d("{initializeSDK} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a(application0, airbridgeOption0);
    }

    public static final boolean isInAppPurchaseTrackingEnabled() {
        b.e.d("{isInAppPurchaseTrackingEnabled} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().c();
    }

    public static final boolean isSDKEnabled() {
        b.e.d("{isSDKEnabled} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().q();
    }

    public static final boolean isTrackingEnabled() {
        b.e.d("{isTrackingEnabled} is called", new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().i();
    }

    public static final boolean isUninstallTrackingNotification(@NotNull RemoteMessage remoteMessage0) {
        b.e.d("{isUninstallTrackingNotification} is called: {" + remoteMessage0 + '}', new Object[0]);
        return Airbridge.INSTANCE.getInstance$airbridge_release().a(remoteMessage0);
    }

    public static final void registerPushToken(@NotNull String s) {
        b.e.d("{registerPushToken} is called: {" + s + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().e(s);
    }

    public static final void removeDeviceAlias(@NotNull String s) {
        b.e.d("{removeDeviceAlias} is called: {" + s + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a(s);
    }

    public static final void removeUserAlias(@NotNull String s) {
        b.e.d("{removeUserAlias} is called: {" + s + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a(s, null);
    }

    public static final void removeUserAttribute(@NotNull String s) {
        b.e.d("{removeUserAttribute} is called: {" + s + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a(s, null);
    }

    public static final void setDeviceAlias(@NotNull String s, @NotNull String s1) {
        b.e.d("{setDeviceAlias} is called: {" + s + "} {" + s1 + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().b(s, s1);
    }

    public final void setInjectInstance$airbridge_release(@Nullable a a0) {
        Airbridge.b = a0;
    }

    public static final void setUserAlias(@NotNull String s, @NotNull String s1) {
        b.e.d("{setUserAlias} is called: {" + s + "} {" + s1 + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a(s, s1);
    }

    public static final void setUserAttribute(@NotNull String s, double f) {
        b.e.d("{setUserAttribute} is called: {" + s + "} {" + f + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a(s, f);
    }

    public static final void setUserAttribute(@NotNull String s, float f) {
        b.e.d("{setUserAttribute} is called: {" + s + "} {" + f + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a(s, f);
    }

    public static final void setUserAttribute(@NotNull String s, int v) {
        b.e.d("{setUserAttribute} is called: {" + s + "} {" + v + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a(s, v);
    }

    public static final void setUserAttribute(@NotNull String s, long v) {
        b.e.d("{setUserAttribute} is called: {" + s + "} {" + v + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a(s, v);
    }

    public static final void setUserAttribute(@NotNull String s, @NotNull String s1) {
        b.e.d("{setUserAttribute} is called: {" + s + "} {" + s1 + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a(s, s1);
    }

    public static final void setUserAttribute(@NotNull String s, boolean z) {
        b.e.d("{setUserAttribute} is called: {" + s + "} {" + z + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a(s, Boolean.valueOf(z));
    }

    public static final void setUserEmail(@NotNull String s) {
        b.e.d("{setUserEmail} is called: {" + s + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().c(s);
    }

    public static final void setUserID(@NotNull String s) {
        b.e.d("{setUserID} is called: {" + s + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().d(s);
    }

    public static final void setUserPhone(@NotNull String s) {
        b.e.d(H0.b.c('}', "{setUserPhone} is called: {", s), new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().b(s);
    }

    public static final void setWebInterface(@NotNull WebView webView0, @NotNull String s) {
        b.e.d("{setWebInterface} is called: {" + webView0 + "} {" + s + '}', new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().a(webView0, s);
    }

    public static final void startInAppPurchaseTracking() {
        b.e.d("{startInAppPurchaseTracking} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().h();
    }

    public static final void startTracking() {
        b.e.d("{startTracking} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().f();
    }

    public static final void stopInAppPurchaseTracking() {
        b.e.d("{stopInAppPurchaseTracking} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().k();
    }

    public static final void stopTracking() {
        b.e.d("{stopTracking} is called", new Object[0]);
        Airbridge.INSTANCE.getInstance$airbridge_release().g();
    }

    public static final void trackEvent(@NotNull String s) {
        Airbridge.trackEvent$default(s, null, null, 6, null);
    }

    public static final void trackEvent(@NotNull String s, @Nullable Map map0) {
        Airbridge.trackEvent$default(s, map0, null, 4, null);
    }

    public static final void trackEvent(@NotNull String s, @Nullable Map map0, @Nullable Map map1) {
        b.e.d("{trackEvent} is called: {" + s + "} {" + map0 + "} {" + map1 + '}', new Object[0]);
        a a0 = Airbridge.INSTANCE.getInstance$airbridge_release();
        Event event0 = new Event(s, map0, map1);
        co.ab180.airbridge.internal.u.c.d.a.a(a0, co.ab180.airbridge.internal.network.model.b.a, event0, null, 4, null);
    }

    public static void trackEvent$default(String s, Map map0, Map map1, int v, Object object0) {
        if((v & 2) != 0) {
            map0 = null;
        }
        if((v & 4) != 0) {
            map1 = null;
        }
        Airbridge.trackEvent(s, map0, map1);
    }
}

