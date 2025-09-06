package co.ab180.airbridge.internal.c0.f;

import De.l;
import De.w;
import Tf.u;
import U4.x;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import co.ab180.airbridge.internal.c0.f.c.c;
import co.ab180.airbridge.internal.c0.f.c.d;
import co.ab180.airbridge.internal.c0.f.c.e;
import co.ab180.airbridge.internal.z.f;
import ie.j;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0010\t\n\u0002\bD\b\u0000\u0018\u0000 \u001B2\u00020\u0001:\u0001\u000BB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0003J\u001B\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0004H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0007J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u000B\u0010\u0013J\u0017\u0010\u0014\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u000FJ\u000F\u0010\u000B\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u000B\u0010\u0003J\u001B\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0007J#\u0010\u000B\u001A\u00020\r2\u0012\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00A2\u0006\u0004\b\u000B\u0010\u0017J\u001B\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0007J\u001F\u0010\u0019\u001A\u00020\n2\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0019\u0010\fJ\u0017\u0010\u000B\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u000B\u0010\u000FJ\u000F\u0010\u0019\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u0003J\u000F\u0010\u001A\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0003J\u000F\u0010\u001B\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u001B\u0010\u0003J\u000F\u0010\u001C\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u001C\u0010\u0003R\u001B\u0010\"\u001A\u00020\u001D8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!R\u001C\u0010\'\u001A\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b%\u0010&R/\u0010.\u001A\u0004\u0018\u00010\u00052\b\u0010(\u001A\u0004\u0018\u00010\u00058V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\b)\u0010*\u001A\u0004\b+\u0010,\"\u0004\b-\u0010\u000FR+\u00105\u001A\u00020\n2\u0006\u0010(\u001A\u00020\n8V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\b/\u00100\u001A\u0004\b1\u00102\"\u0004\b3\u00104R+\u00109\u001A\u00020\u00052\u0006\u0010(\u001A\u00020\u00058V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\b6\u00107\u001A\u0004\b-\u0010,\"\u0004\b8\u0010\u000FR+\u0010<\u001A\u00020\n2\u0006\u0010(\u001A\u00020\n8V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\b:\u00100\u001A\u0004\b8\u00102\"\u0004\b;\u00104R/\u0010?\u001A\u0004\u0018\u00010\u00052\b\u0010(\u001A\u0004\u0018\u00010\u00058V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\b=\u0010*\u001A\u0004\b>\u0010,\"\u0004\b;\u0010\u000FR+\u0010F\u001A\u00020@2\u0006\u0010(\u001A\u00020@8V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bA\u0010B\u001A\u0004\bC\u0010D\"\u0004\b\u0019\u0010ER+\u0010H\u001A\u00020@2\u0006\u0010(\u001A\u00020@8V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bG\u0010B\u001A\u0004\b;\u0010D\"\u0004\b\u0006\u0010ER/\u0010K\u001A\u0004\u0018\u00010\u00052\b\u0010(\u001A\u0004\u0018\u00010\u00058V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bI\u0010*\u001A\u0004\bJ\u0010,\"\u0004\b+\u0010\u000FR+\u0010N\u001A\u00020\n2\u0006\u0010(\u001A\u00020\n8V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bL\u00100\u001A\u0004\bM\u00102\"\u0004\b\u000B\u00104R+\u0010P\u001A\u00020@2\u0006\u0010(\u001A\u00020@8V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bO\u0010B\u001A\u0004\b\u000E\u0010D\"\u0004\b\u000B\u0010ER\u001C\u0010R\u001A\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bQ\u0010&R+\u0010U\u001A\u00020\u00052\u0006\u0010(\u001A\u00020\u00058V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bS\u00107\u001A\u0004\bT\u0010,\"\u0004\b\u0010\u0010\u000FR+\u0010X\u001A\u00020\n2\u0006\u0010(\u001A\u00020\n8V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bV\u00100\u001A\u0004\bW\u00102\"\u0004\b-\u00104R+\u0010Z\u001A\u00020\n2\u0006\u0010(\u001A\u00020\n8V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bY\u00100\u001A\u0004\b3\u00102\"\u0004\b\u0006\u00104R/\u0010]\u001A\u0004\u0018\u00010\u00052\b\u0010(\u001A\u0004\u0018\u00010\u00058V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\b[\u0010*\u001A\u0004\b\\\u0010,\"\u0004\b3\u0010\u000FR/\u0010a\u001A\u0004\u0018\u00010\u00052\b\u0010(\u001A\u0004\u0018\u00010\u00058V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\b^\u0010*\u001A\u0004\b_\u0010,\"\u0004\b`\u0010\u000FR+\u0010d\u001A\u00020\n2\u0006\u0010(\u001A\u00020\n8V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bb\u00100\u001A\u0004\bc\u00102\"\u0004\bc\u00104R+\u0010g\u001A\u00020\n2\u0006\u0010(\u001A\u00020\n8V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\be\u00100\u001A\u0004\bf\u00102\"\u0004\b\u0010\u00104R+\u0010i\u001A\u00020\n2\u0006\u0010(\u001A\u00020\n8V@VX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bh\u00100\u001A\u0004\b\u0014\u00102\"\u0004\b\u0019\u00104R\u001C\u0010k\u001A\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bj\u0010&R\u001C\u0010m\u001A\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bl\u0010&R/\u0010q\u001A\u0004\u0018\u00010\u00052\b\u0010(\u001A\u0004\u0018\u00010\u00058B@BX\u0082\u008E\u0002\u00A2\u0006\u0012\n\u0004\bn\u0010*\u001A\u0004\bo\u0010,\"\u0004\bp\u0010\u000FR/\u0010t\u001A\u0004\u0018\u00010\u00052\b\u0010(\u001A\u0004\u0018\u00010\u00058B@BX\u0082\u008E\u0002\u00A2\u0006\u0012\n\u0004\br\u0010*\u001A\u0004\bs\u0010,\"\u0004\bJ\u0010\u000FR/\u0010w\u001A\u0004\u0018\u00010\u00052\b\u0010(\u001A\u0004\u0018\u00010\u00058B@BX\u0082\u008E\u0002\u00A2\u0006\u0012\n\u0004\bu\u0010*\u001A\u0004\bv\u0010,\"\u0004\b>\u0010\u000FR\u001C\u0010y\u001A\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bx\u0010&R\u001C\u0010{\u001A\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bz\u0010&R\u001C\u0010}\u001A\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b|\u0010&R\u001C\u0010\u007F\u001A\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b~\u0010&R)\u0010\u0080\u0001\u001A\u0004\u0018\u00010\u00052\b\u0010\t\u001A\u0004\u0018\u00010\u00058V@VX\u0096\u000E\u00A2\u0006\f\u001A\u0004\b`\u0010,\"\u0004\bc\u0010\u000FR*\u0010\u0082\u0001\u001A\u0004\u0018\u00010\u00052\b\u0010\t\u001A\u0004\u0018\u00010\u00058V@VX\u0096\u000E\u00A2\u0006\r\u001A\u0005\b\u0081\u0001\u0010,\"\u0004\b\u0006\u0010\u000FR)\u0010\u0083\u0001\u001A\u0004\u0018\u00010\u00052\b\u0010\t\u001A\u0004\u0018\u00010\u00058V@VX\u0096\u000E\u00A2\u0006\f\u001A\u0004\bp\u0010,\"\u0004\b\u0019\u0010\u000F\u00A8\u0006\u0084\u0001"}, d2 = {"Lco/ab180/airbridge/internal/c0/f/b;", "Lco/ab180/airbridge/internal/c0/f/a;", "<init>", "()V", "", "", "c", "()Ljava/util/Map;", "key", "value", "", "a", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lie/H;", "k", "(Ljava/lang/String;)V", "d", "", "t", "(Ljava/lang/String;Ljava/lang/Object;)Z", "l", "w", "data", "(Ljava/util/Map;)V", "v", "b", "B", "I", "H", "Landroid/content/Context;", "J", "Lie/j;", "D", "()Landroid/content/Context;", "context", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "K", "Landroid/content/SharedPreferences;", "internalPreferences", "<set-?>", "L", "Lco/ab180/airbridge/internal/c0/f/c/e;", "i", "()Ljava/lang/String;", "h", "savedSdkVersion", "M", "Lco/ab180/airbridge/internal/c0/f/c/a;", "r", "()Z", "e", "(Z)V", "hasDataBeforeAppSetIDCollected", "N", "Lco/ab180/airbridge/internal/c0/f/c/d;", "m", "backupDeviceUUID", "O", "g", "firstOpen", "P", "p", "sessionId", "", "Q", "Lco/ab180/airbridge/internal/c0/f/c/c;", "A", "()J", "(J)V", "sessionStartTimestamp", "R", "backgroundedTimestamp", "S", "n", "pushToken", "T", "C", "pushTokenChanged", "U", "eventTransmitIntervalTimestamp", "V", "installPreferences", "W", "s", "installEventUUID", "X", "z", "attributionResultReceived", "Y", "firstHandleAttributionResult", "Z", "q", "deferredDeeplink", "a0", "x", "j", "deferredDeepLinkThrowable", "b0", "f", "deferredDeeplinkReceived", "c0", "y", "firstHandleDeferredDeepLink", "d0", "ignoreHandleDeferredDeeplink", "e0", "attributionDataPreferences", "f0", "userInfoPreferences", "g0", "F", "o", "_userId", "h0", "E", "_userEmail", "i0", "G", "_userPhone", "j0", "userAliasPreferences", "k0", "userAttributesPreferences", "l0", "userAttributesExPreferences", "m0", "deviceAliasPreferences", "userId", "u", "userEmail", "userPhone", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b implements a {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\'\u0010(R\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000B\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u000B\u0010\u0004R\u0016\u0010\f\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000E\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u000E\u0010\u0004R\u0016\u0010\u000F\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u000F\u0010\u0004R\u0016\u0010\u0010\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0017\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0016\u0010\u0018\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0016\u0010\u001A\u001A\u00020\u00198\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0016\u0010\u001C\u001A\u00020\u00198\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u001C\u0010\u001BR\u0016\u0010\u001D\u001A\u00020\u00198\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u001D\u0010\u001BR\u0016\u0010\u001E\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u001E\u0010\u0004R\u0016\u0010\u001F\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u001F\u0010\u0004R\u0016\u0010 \u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b \u0010\u0004R\u0016\u0010!\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b!\u0010\u0004R\u0016\u0010\"\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0016\u0010#\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b#\u0010\u0004R\u0016\u0010$\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b$\u0010\u0004R\u0016\u0010%\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b%\u0010\u0004R\u0016\u0010&\u001A\u00020\u00028\u0002@\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b&\u0010\u0004\u00A8\u0006)"}, d2 = {"co/ab180/airbridge/internal/c0/f/b$a", "", "", "KEY_ATTRIBUTION_RESULT_RECEIVED", "Ljava/lang/String;", "KEY_BACKGROUND_TIMESTAMP", "KEY_BACKUP_DEVICE_UUID", "KEY_DEFERRED_DEEPLINK", "KEY_DEFERRED_DEEPLINK_RECEIVED", "KEY_DEFERRED_DEEPLINK_THROWABLE", "KEY_EVENT_TRANSMIT_INTERVAL_TIMESTAMP", "KEY_FIRST_HANDLE_ATTRIBUTION_RESULT", "KEY_FIRST_HANDLE_DEFERRED_DEEPLINK", "KEY_FIRST_OPEN", "KEY_HAS_DATA_BEFORE_APPSETID_COLLECTED", "KEY_IGNORE_HANDLE_DEFERRED_DEEPLINK", "KEY_INSTALL_EVENT_UUID", "KEY_PUSH_TOKEN", "KEY_PUSH_TOKEN_CHANGED", "KEY_SAVED_SDK_VERSION", "KEY_SESSION_ID", "KEY_SESSION_START_TIMESTAMP", "KEY_USER_EMAIL", "KEY_USER_ID", "KEY_USER_PHONE", "", "MAX_DEVICE_ALIAS_STRING_LENGTH", "I", "MAX_KEY_STRING_LENGTH", "MAX_USER_INFO_STRING_LENGTH", "PREFS_ATTRIBUTION_DATA", "PREFS_DEVICE_ALIAS", "PREFS_INSTALL", "PREFS_INTERNAL", "PREFS_USER_ALIAS", "PREFS_USER_ATTRIBUTES", "PREFS_USER_ATTRIBUTES_EX", "PREFS_USER_INFO", "REGEX_KEY_STRING", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class co.ab180.airbridge.internal.c0.f.b.a {
        private co.ab180.airbridge.internal.c0.f.b.a() {
        }

        public co.ab180.airbridge.internal.c0.f.b.a(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final String A = "airbridge-user-alias";
    private static final String B = "airbridge-user-attributes";
    private static final String C = "airbridge-user-attributes-ex";
    private static final String D = "airbridge-device-alias";
    private static final int E = 0x80;
    private static final int F = 0x400;
    private static final int G = 0x80;
    private static final String H = "^[a-zA-Z_][a-zA-Z0-9_]*$";
    @NotNull
    public static final co.ab180.airbridge.internal.c0.f.b.a I = null;
    private final j J;
    private final SharedPreferences K;
    @Nullable
    private final e L;
    @NotNull
    private final co.ab180.airbridge.internal.c0.f.c.a M;
    @NotNull
    private final d N;
    @NotNull
    private final co.ab180.airbridge.internal.c0.f.c.a O;
    @Nullable
    private final e P;
    @NotNull
    private final c Q;
    @NotNull
    private final c R;
    @Nullable
    private final e S;
    @NotNull
    private final co.ab180.airbridge.internal.c0.f.c.a T;
    @NotNull
    private final c U;
    private final SharedPreferences V;
    @NotNull
    private final d W;
    @NotNull
    private final co.ab180.airbridge.internal.c0.f.c.a X;
    @NotNull
    private final co.ab180.airbridge.internal.c0.f.c.a Y;
    @Nullable
    private final e Z;
    static final w[] a = null;
    @Nullable
    private final e a0;
    private static final String b = "airbridge-internal";
    @NotNull
    private final co.ab180.airbridge.internal.c0.f.c.a b0;
    private static final String c = "has_data_before_appsetid_collected";
    @NotNull
    private final co.ab180.airbridge.internal.c0.f.c.a c0;
    private static final String d = "saved_sdk_version";
    @NotNull
    private final co.ab180.airbridge.internal.c0.f.c.a d0;
    private static final String e = "backup_device_uuid";
    private final SharedPreferences e0;
    private static final String f = "first_open";
    private final SharedPreferences f0;
    private static final String g = "session_id";
    private final e g0;
    private static final String h = "session_start_timestamp";
    private final e h0;
    private static final String i = "background_timestamp";
    private final e i0;
    private static final String j = "push_token";
    private final SharedPreferences j0;
    private static final String k = "push_token_changed";
    private final SharedPreferences k0;
    private static final String l = "event_transmit_interval_timestamp";
    private final SharedPreferences l0;
    private static final String m = "airbridge-install";
    private final SharedPreferences m0;
    private static final String n = "install_event_uuid";
    private static final String o = "attribution_result_received";
    private static final String p = "first_handle_attribution_result";
    private static final String q = "deferred_deeplink";
    private static final String r = "deferred_deeplink_throwable";
    private static final String s = "deferred_deeplink_received";
    private static final String t = "first_handle_deferred_deeplink";
    private static final String u = "ignore_handle_deferred_deeplink";
    private static final String v = "airbridge-attribution-data";
    private static final String w = "airbridge-user-info";
    private static final String x = "user_id";
    private static final String y = "user_email";
    private static final String z = "user_phone";

    static {
        Class class0 = b.class;
        t t0 = new t(class0, "savedSdkVersion", "getSavedSdkVersion()Ljava/lang/String;", 0);
        J j0 = I.a;
        l l0 = x.c(class0, "hasDataBeforeAppSetIDCollected", "getHasDataBeforeAppSetIDCollected()Z", 0, j0);
        l l1 = x.c(class0, "backupDeviceUUID", "getBackupDeviceUUID()Ljava/lang/String;", 0, j0);
        l l2 = x.c(class0, "firstOpen", "getFirstOpen()Z", 0, j0);
        l l3 = x.c(class0, "sessionId", "getSessionId()Ljava/lang/String;", 0, j0);
        l l4 = x.c(class0, "sessionStartTimestamp", "getSessionStartTimestamp()J", 0, j0);
        l l5 = x.c(class0, "backgroundedTimestamp", "getBackgroundedTimestamp()J", 0, j0);
        l l6 = x.c(class0, "pushToken", "getPushToken()Ljava/lang/String;", 0, j0);
        l l7 = x.c(class0, "pushTokenChanged", "getPushTokenChanged()Z", 0, j0);
        l l8 = x.c(class0, "eventTransmitIntervalTimestamp", "getEventTransmitIntervalTimestamp()J", 0, j0);
        l l9 = x.c(class0, "installEventUUID", "getInstallEventUUID()Ljava/lang/String;", 0, j0);
        l l10 = x.c(class0, "attributionResultReceived", "getAttributionResultReceived()Z", 0, j0);
        l l11 = x.c(class0, "firstHandleAttributionResult", "getFirstHandleAttributionResult()Z", 0, j0);
        l l12 = x.c(class0, "deferredDeeplink", "getDeferredDeeplink()Ljava/lang/String;", 0, j0);
        l l13 = x.c(class0, "deferredDeepLinkThrowable", "getDeferredDeepLinkThrowable()Ljava/lang/String;", 0, j0);
        l l14 = x.c(class0, "deferredDeeplinkReceived", "getDeferredDeeplinkReceived()Z", 0, j0);
        l l15 = x.c(class0, "firstHandleDeferredDeepLink", "getFirstHandleDeferredDeepLink()Z", 0, j0);
        l l16 = x.c(class0, "ignoreHandleDeferredDeeplink", "getIgnoreHandleDeferredDeeplink()Z", 0, j0);
        l l17 = x.c(class0, "_userId", "get_userId()Ljava/lang/String;", 0, j0);
        l l18 = x.c(class0, "_userEmail", "get_userEmail()Ljava/lang/String;", 0, j0);
        l l19 = x.c(class0, "_userPhone", "get_userPhone()Ljava/lang/String;", 0, j0);
        b.a = new w[]{j0.e(t0), l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19};
        b.I = new co.ab180.airbridge.internal.c0.f.b.a(null);
    }

    public b() {
        this.J = f.b(Context.class);
        SharedPreferences sharedPreferences0 = this.D().getSharedPreferences("airbridge-internal", 0);
        this.K = sharedPreferences0;
        this.L = new e(sharedPreferences0, "saved_sdk_version", null);
        this.M = new co.ab180.airbridge.internal.c0.f.c.a(sharedPreferences0, "has_data_before_appsetid_collected", false);
        this.N = new d(sharedPreferences0, "backup_device_uuid");
        this.O = new co.ab180.airbridge.internal.c0.f.c.a(sharedPreferences0, "first_open", true);
        this.P = new e(sharedPreferences0, "session_id", null);
        this.Q = new c(sharedPreferences0, "session_start_timestamp", 0L);
        this.R = new c(sharedPreferences0, "background_timestamp", 0L);
        this.S = new e(sharedPreferences0, "push_token", null);
        this.T = new co.ab180.airbridge.internal.c0.f.c.a(sharedPreferences0, "push_token_changed", false);
        this.U = new c(sharedPreferences0, "event_transmit_interval_timestamp", 0L);
        SharedPreferences sharedPreferences1 = this.D().getSharedPreferences("airbridge-install", 0);
        this.V = sharedPreferences1;
        this.W = new d(sharedPreferences1, "install_event_uuid");
        this.X = new co.ab180.airbridge.internal.c0.f.c.a(sharedPreferences1, "attribution_result_received", false);
        this.Y = new co.ab180.airbridge.internal.c0.f.c.a(sharedPreferences1, "first_handle_attribution_result", true);
        this.Z = new e(sharedPreferences1, "deferred_deeplink", null);
        this.a0 = new e(sharedPreferences1, "deferred_deeplink_throwable", null);
        this.b0 = new co.ab180.airbridge.internal.c0.f.c.a(sharedPreferences1, "deferred_deeplink_received", false);
        this.c0 = new co.ab180.airbridge.internal.c0.f.c.a(sharedPreferences1, "first_handle_deferred_deeplink", true);
        this.d0 = new co.ab180.airbridge.internal.c0.f.c.a(sharedPreferences1, "ignore_handle_deferred_deeplink", false);
        this.e0 = this.D().getSharedPreferences("airbridge-attribution-data", 0);
        SharedPreferences sharedPreferences2 = this.D().getSharedPreferences("airbridge-user-info", 0);
        this.f0 = sharedPreferences2;
        this.g0 = new e(sharedPreferences2, "user_id", null);
        this.h0 = new e(sharedPreferences2, "user_email", null);
        this.i0 = new e(sharedPreferences2, "user_phone", null);
        this.j0 = this.D().getSharedPreferences("airbridge-user-alias", 0);
        this.k0 = this.D().getSharedPreferences("airbridge-user-attributes", 0);
        this.l0 = this.D().getSharedPreferences("airbridge-user-attributes-ex", 0);
        this.m0 = this.D().getSharedPreferences("airbridge-device-alias", 0);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public long A() {
        return (long)this.Q.a(this, b.a[5]);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void B() {
        this.K.edit().clear().apply();
        this.V.edit().clear().apply();
        this.e0.edit().clear().apply();
        this.f0.edit().clear().apply();
        this.j0.edit().clear().apply();
        this.k0.edit().clear().apply();
        this.l0.edit().clear().apply();
        this.m0.edit().clear().apply();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public boolean C() {
        return this.T.a(this, b.a[8]).booleanValue();
    }

    private final Context D() {
        return (Context)this.J.getValue();
    }

    private final String E() {
        return this.h0.a(this, b.a[19]);
    }

    private final String F() {
        return this.g0.a(this, b.a[18]);
    }

    private final String G() {
        return this.i0.a(this, b.a[20]);
    }

    private final void H() {
        co.ab180.airbridge.internal.b.e.e("Device data is modified: deviceAlias={" + this.v() + '}', new Object[0]);
    }

    private final void I() {
        JSONObject jSONObject0 = new JSONObject();
        String s = this.j();
        if(s != null) {
            jSONObject0.put("userId", s);
        }
        String s1 = this.u();
        if(s1 != null) {
            jSONObject0.put("userEmail", s1);
        }
        String s2 = this.o();
        if(s2 != null) {
            jSONObject0.put("userPhone", s2);
        }
        Map map0 = this.c();
        Map map1 = null;
        if(map0.isEmpty()) {
            map0 = null;
        }
        if(map0 != null) {
            jSONObject0.put("userAlias", map0.toString());
        }
        Map map2 = this.t();
        if(!map2.isEmpty()) {
            map1 = map2;
        }
        if(map1 != null) {
            jSONObject0.put("userAttributes", map1.toString());
        }
        co.ab180.airbridge.internal.b.e.e("User data is modified: user={" + jSONObject0 + '}', new Object[0]);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void a() {
        this.k0.edit().clear().apply();
        this.l0.edit().clear().apply();
        this.I();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void a(long v) {
        this.U.a(this, b.a[9], v);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void a(@NotNull String s) {
        this.m0.edit().remove(s).apply();
        this.H();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void a(@NotNull Map map0) {
        SharedPreferences.Editor sharedPreferences$Editor0 = this.e0.edit();
        sharedPreferences$Editor0.clear();
        for(Object object0: map0.entrySet()) {
            sharedPreferences$Editor0.putString(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
        }
        sharedPreferences$Editor0.apply();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void a(boolean z) {
        this.T.a(this, b.a[8], z);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public boolean a(@NotNull String s, @NotNull Object object0) {
        int v = this.k0.getAll().keySet().size();
        if(this.l0.getAll().keySet().size() + v >= 100) {
            co.ab180.airbridge.internal.b.e.f("User attribute count exceeds limit", new Object[0]);
            return false;
        }
        Pattern pattern0 = Pattern.compile("^[a-zA-Z_][a-zA-Z0-9_]*$");
        q.f(pattern0, "compile(...)");
        q.g(s, "input");
        if(!pattern0.matcher(s).matches()) {
            co.ab180.airbridge.internal.b.e.f("Given user attribute\'s key doesn\'t match the regular expression pattern (^[a-zA-Z_][a-zA-Z0-9_]*$): key={" + s + '}', new Object[0]);
            return false;
        }
        if(s.length() > 0x80) {
            co.ab180.airbridge.internal.b.e.f("Given user attribute\'s key length exceeds 128 characters: key={" + s + '}', new Object[0]);
            return false;
        }
        if(!(object0 instanceof Number) && !(object0 instanceof Boolean)) {
            if(!(object0 instanceof String)) {
                co.ab180.airbridge.internal.b.e.f("Given user attribute\'s value is neither String nor any number: value={" + object0 + '}', new Object[0]);
                return false;
            }
            else if(((String)object0).length() > 0x400) {
                co.ab180.airbridge.internal.b.e.f("Given user attribute\'s value length exceeds 1024 characters: value={" + object0 + '}', new Object[0]);
                return false;
            }
        }
        SharedPreferences.Editor sharedPreferences$Editor0 = this.k0.edit();
        SharedPreferences.Editor sharedPreferences$Editor1 = this.l0.edit();
        sharedPreferences$Editor0.remove(s);
        sharedPreferences$Editor1.remove(s);
        if(object0 instanceof Integer) {
            sharedPreferences$Editor0.putInt(s, ((Number)object0).intValue());
        }
        else if(object0 instanceof Long) {
            sharedPreferences$Editor0.putLong(s, ((Number)object0).longValue());
        }
        else if(object0 instanceof Float) {
            sharedPreferences$Editor0.putFloat(s, ((Number)object0).floatValue());
        }
        else if(object0 instanceof Double) {
            sharedPreferences$Editor1.putString(s, object0.toString());
        }
        else if(object0 instanceof Boolean) {
            sharedPreferences$Editor0.putBoolean(s, ((Boolean)object0).booleanValue());
        }
        else if(object0 instanceof String) {
            sharedPreferences$Editor0.putString(s, ((String)object0));
        }
        sharedPreferences$Editor0.apply();
        sharedPreferences$Editor1.apply();
        this.I();
        return true;
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public boolean a(@NotNull String s, @NotNull String s1) {
        if(this.j0.getAll().keySet().size() >= 10) {
            co.ab180.airbridge.internal.b.e.f("User alias count exceeds limit", new Object[0]);
            return false;
        }
        Pattern pattern0 = Pattern.compile("^[a-zA-Z_][a-zA-Z0-9_]*$");
        q.f(pattern0, "compile(...)");
        q.g(s, "input");
        if(!pattern0.matcher(s).matches()) {
            co.ab180.airbridge.internal.b.e.f("Given user alias\'s key doesn\'t match the regular expression pattern (^[a-zA-Z_][a-zA-Z0-9_]*$): key={" + s + '}', new Object[0]);
            return false;
        }
        if(s.length() > 0x80) {
            co.ab180.airbridge.internal.b.e.f("Given user alias\'s key length exceeds 128 characters: key={" + s + '}', new Object[0]);
            return false;
        }
        if(s1.length() > 0x400) {
            co.ab180.airbridge.internal.b.e.f("Given user alias\'s value length exceeds 1024 characters: value={" + s1 + '}', new Object[0]);
            return false;
        }
        this.j0.edit().putString(s, s1).apply();
        this.I();
        return true;
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void b() {
        this.m0.edit().clear().apply();
        this.H();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void b(long v) {
        this.Q.a(this, b.a[5], v);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void b(@Nullable String s) {
        this.p(s);
        this.I();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void b(boolean z) {
        this.d0.a(this, b.a[17], z);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public boolean b(@NotNull String s, @NotNull String s1) {
        if(this.m0.getAll().keySet().size() >= 10) {
            co.ab180.airbridge.internal.b.e.f("Device alias count exceeds limit", new Object[0]);
            return false;
        }
        Pattern pattern0 = Pattern.compile("^[a-zA-Z_][a-zA-Z0-9_]*$");
        q.f(pattern0, "compile(...)");
        q.g(s, "input");
        if(!pattern0.matcher(s).matches()) {
            co.ab180.airbridge.internal.b.e.f("Given device alias key doesn\'t match the regular expression pattern (^[a-zA-Z_][a-zA-Z0-9_]*$): key={" + s + '}', new Object[0]);
            return false;
        }
        if(s.length() > 0x80) {
            co.ab180.airbridge.internal.b.e.f("Given device alias\'s key length exceeds 128 characters: key={" + s + '}', new Object[0]);
            return false;
        }
        if(s1.length() > 0x80) {
            co.ab180.airbridge.internal.b.e.f("Given device alias\'s value length exceeds 128 characters: value={" + s1 + '}', new Object[0]);
            return false;
        }
        this.m0.edit().putString(s, s1).apply();
        this.H();
        return true;
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @NotNull
    public Map c() {
        Map map0 = new LinkedHashMap();
        for(Object object0: this.j0.getAll().keySet()) {
            String s = (String)object0;
            if(this.j0.getAll().get(s) instanceof String) {
                Object object1 = this.j0.getAll().get(s);
                if(object1 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                map0.put(s, ((String)object1));
            }
        }
        return map0;
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void c(long v) {
        this.R.a(this, b.a[6], v);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void c(@Nullable String s) {
        this.n(s);
        this.I();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void c(boolean z) {
        this.Y.a(this, b.a[12], z);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void d() {
        this.j0.edit().clear().apply();
        this.I();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void d(@NotNull String s) {
        this.W.a(this, b.a[10], s);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void d(boolean z) {
        this.c0.a(this, b.a[16], z);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void e(@Nullable String s) {
        this.Z.a(this, b.a[13], s);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void e(boolean z) {
        this.M.a(this, b.a[1], z);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public boolean e() {
        return this.Y.a(this, b.a[12]).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void f(@Nullable String s) {
        this.o(s);
        this.I();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void f(boolean z) {
        this.b0.a(this, b.a[15], z);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public boolean f() {
        return this.b0.a(this, b.a[15]).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public long g() {
        return (long)this.R.a(this, b.a[6]);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void g(@Nullable String s) {
        this.P.a(this, b.a[4], s);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void g(boolean z) {
        this.O.a(this, b.a[3], z);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @NotNull
    public String h() {
        return this.N.a(this, b.a[2]);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void h(@Nullable String s) {
        this.L.a(this, b.a[0], s);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void h(boolean z) {
        this.X.a(this, b.a[11], z);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @Nullable
    public String i() {
        return this.L.a(this, b.a[0]);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void i(@Nullable String s) {
        this.S.a(this, b.a[7], s);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @Nullable
    public String j() {
        return this.F();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void j(@Nullable String s) {
        this.a0.a(this, b.a[14], s);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public long k() {
        return (long)this.U.a(this, b.a[9]);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void k(@NotNull String s) {
        this.j0.edit().remove(s).apply();
        this.I();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void l(@NotNull String s) {
        this.k0.edit().remove(s).apply();
        this.l0.edit().remove(s).apply();
        this.I();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public boolean l() {
        return this.d0.a(this, b.a[17]).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public void m(@NotNull String s) {
        this.N.a(this, b.a[2], s);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public boolean m() {
        return this.O.a(this, b.a[3]).booleanValue();
    }

    private final void n(String s) {
        this.h0.a(this, b.a[19], s);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @Nullable
    public String n() {
        return this.S.a(this, b.a[7]);
    }

    private final void o(String s) {
        this.g0.a(this, b.a[18], s);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @Nullable
    public String o() {
        return this.G();
    }

    private final void p(String s) {
        this.i0.a(this, b.a[20], s);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @Nullable
    public String p() {
        return this.P.a(this, b.a[4]);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @Nullable
    public String q() {
        return this.Z.a(this, b.a[13]);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public boolean r() {
        return this.M.a(this, b.a[1]).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @NotNull
    public String s() {
        return this.W.a(this, b.a[10]);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @NotNull
    public Map t() {
        Map map0 = new LinkedHashMap();
        for(Object object0: this.k0.getAll().keySet()) {
            String s = (String)object0;
            Object object1 = this.k0.getAll().get(s);
            if(object1 != null) {
                map0.put(s, object1);
            }
        }
        for(Object object2: this.l0.getAll().keySet()) {
            String s1 = (String)object2;
            Object object3 = this.l0.getAll().get(s1);
            if(object3 != null) {
                Double double0 = u.f0(((String)object3));
                if(double0 != null) {
                    map0.put(s1, double0.doubleValue());
                }
            }
        }
        return map0;
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @Nullable
    public String u() {
        return this.E();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @NotNull
    public Map v() {
        Map map0 = new LinkedHashMap();
        for(Object object0: this.m0.getAll().keySet()) {
            String s = (String)object0;
            if(this.m0.getAll().get(s) instanceof String) {
                Object object1 = this.m0.getAll().get(s);
                if(object1 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                map0.put(s, ((String)object1));
            }
        }
        return map0;
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @NotNull
    public Map w() {
        Map map0 = new LinkedHashMap();
        for(Object object0: this.e0.getAll().entrySet()) {
            String s = (String)((Map.Entry)object0).getKey();
            Object object1 = ((Map.Entry)object0).getValue();
            if(object1 != null && object1 instanceof String) {
                map0.put(s, object1);
            }
        }
        return map0;
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    @Nullable
    public String x() {
        return this.a0.a(this, b.a[14]);
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public boolean y() {
        return this.c0.a(this, b.a[16]).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.c0.f.a
    public boolean z() {
        return this.X.a(this, b.a[11]).booleanValue();
    }
}

