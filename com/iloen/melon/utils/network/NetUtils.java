package com.iloen.melon.utils.network;

import Nb.u0;
import Nb.z0;
import Q1.c;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.NetworkStatusManager;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.NameValuePairList;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00C7\u0002\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\u000B\u0010\nJ\u0019\u0010\u000F\u001A\u00020\u000E2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\u0011\u0010\nJ\u000F\u0010\u0012\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0004J\u001F\u0010\u0014\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001D\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0017\u001A\u00020\u0016H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0019\u0010\u001C\u001A\u00020\u001B2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0007\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001E\u001A\u00020\b2\b\u0010\r\u001A\u0004\u0018\u00010\f\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\r\u0010 \u001A\u00020\u0002\u00A2\u0006\u0004\b \u0010\u0004J\u0015\u0010\"\u001A\u00020\u00052\u0006\u0010!\u001A\u00020\b\u00A2\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001A\u00020\u00052\u0006\u0010!\u001A\u00020\b\u00A2\u0006\u0004\b$\u0010#J\u0015\u0010\'\u001A\u00020\u00052\u0006\u0010&\u001A\u00020%\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010)\u001A\u00020\u001B2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016\u00A2\u0006\u0004\b)\u0010\u001DR\u0014\u0010*\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010-\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b-\u0010+R\u0014\u0010.\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b.\u0010+R\u0014\u0010/\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b/\u0010+R\u0014\u00100\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b0\u0010+R\u0014\u00101\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b1\u0010+R\u0014\u00102\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b2\u0010+R\u0014\u00103\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b3\u0010+R\u0014\u00104\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b4\u0010+\u00A8\u00065"}, d2 = {"Lcom/iloen/melon/utils/network/NetUtils;", "", "", "getCurrentNetworkState", "()I", "", "getNetworkType", "()Ljava/lang/String;", "", "isWifiConnected", "()Z", "isConnected", "Landroid/content/Context;", "context", "Lie/H;", "showNetworkInfoPopupIfNotConnected", "(Landroid/content/Context;)V", "isDataNetwork", "checkDataNetwork", "isShowToast", "showNetworkPopupOrToast", "(Landroid/content/Context;Z)Z", "Landroid/net/Uri;", "uri", "", "getQueryParameterNames", "(Landroid/net/Uri;)Ljava/util/Set;", "Lcom/iloen/melon/utils/NameValuePairList;", "getQueryParamList", "(Landroid/net/Uri;)Lcom/iloen/melon/utils/NameValuePairList;", "isConnectedOrConnecting", "(Landroid/content/Context;)Z", "getNetworkStateForPopup", "isOfflineRequest", "getSongBitrate", "(Z)Ljava/lang/String;", "getSongMetaType", "LNb/z0;", "playerType", "getMvBitrate", "(LNb/z0;)Ljava/lang/String;", "getWebViewParamList", "NETWORK_STATE_NONE", "I", "NETWORK_STATE_CELLULAR", "NETWORK_STATE_WIFI", "SHOW_NETWORK_DISCONNECTED_POPUP", "SHOW_NETWORK_USE_DATA_POPUP", "SHOW_NETWORK_TOAST", "CHECK_NETWORK_WIFI", "CHECK_NETWORK_CELLULAR_AND_MELON_YES", "CHECK_NETWORK_CELLULAR_AND_MELON_NO", "CHECK_NETWORK_NONE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class NetUtils {
    public static final int $stable = 0;
    public static final int CHECK_NETWORK_CELLULAR_AND_MELON_NO = 2;
    public static final int CHECK_NETWORK_CELLULAR_AND_MELON_YES = 1;
    public static final int CHECK_NETWORK_NONE = 3;
    public static final int CHECK_NETWORK_WIFI = 0;
    @NotNull
    public static final NetUtils INSTANCE = null;
    public static final int NETWORK_STATE_CELLULAR = 1;
    public static final int NETWORK_STATE_NONE = 0;
    public static final int NETWORK_STATE_WIFI = 2;
    public static final int SHOW_NETWORK_DISCONNECTED_POPUP = 1;
    public static final int SHOW_NETWORK_TOAST = 3;
    public static final int SHOW_NETWORK_USE_DATA_POPUP = 2;

    static {
        NetUtils.INSTANCE = new NetUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static void a(Context context0, String s) {
        Intent intent0 = new Intent();
        c.Y(intent0, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
        intent0.putExtra("alertdialogtype", 9);
        intent0.putExtra("typekey", s);
        context0.sendBroadcast(intent0);
    }

    // 去混淆评级： 低(30)
    public static final int checkDataNetwork() {
        return 0;
    }

    // 去混淆评级： 低(20)
    public static final int getCurrentNetworkState() [...] // 潜在的解密器

    @NotNull
    public final String getMvBitrate(@NotNull z0 z00) {
        q.g(z00, "playerType");
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("NetUtils", "getMvBitrate(): " + z00);
        String s = "3072";
        if(z00 instanceof u0) {
            return "3072";
        }
        try {
            String s1 = MelonSettingInfo.getMusicVideoBitrateWifi();
            if(s1 != null) {
                switch(s1) {
                    case "1M": {
                        s = "1024";
                        break;
                    }
                    case "500K": {
                        s = "500";
                        break;
                    }
                    case "700K": {
                        s = "700";
                    }
                }
            }
            logU$Companion0.d("NetUtils", "getMvBitrate() bitrate : " + s + ", currentNetState:" + 2);
            return s;
        }
        catch(Exception exception0) {
        }
        LogU.Companion.e("NetUtils", exception0.toString());
        return "700";
    }

    public final int getNetworkStateForPopup() {
        if(NetUtils.checkDataNetwork() == 3) {
            return 1;
        }
        return MelonSettingInfo.isUseDataNetwork() ? 3 : 2;
    }

    // 去混淆评级： 中等(60)
    @NotNull
    public static final String getNetworkType() [...] // 潜在的解密器

    @NotNull
    public static final NameValuePairList getQueryParamList(@Nullable Uri uri0) {
        NameValuePairList nameValuePairList0 = new NameValuePairList();
        if(uri0 != null) {
            for(Object object0: NetUtils.getQueryParameterNames(uri0)) {
                nameValuePairList0.add(((String)object0), uri0.getQueryParameter(((String)object0)));
            }
        }
        return nameValuePairList0;
    }

    @NotNull
    public static final Set getQueryParameterNames(@NotNull Uri uri0) {
        q.g(uri0, "uri");
        Set set0 = uri0.getQueryParameterNames();
        q.f(set0, "getQueryParameterNames(...)");
        return set0;
    }

    @NotNull
    public final String getSongBitrate(boolean z) {
        l1.B("getSongBitrate() - isOfflineRequest : ", z, LogU.Companion, "NetUtils");
        String s = z ? "AAC128" : MelonSettingInfo.getStreamingFileWiFi();
        if("AAC320".equals(s)) {
            return "320";
        }
        if("MP3320".equals(s)) {
            return "320";
        }
        return "AAC128".equals(s) ? "128" : "96";
    }

    @NotNull
    public final String getSongMetaType(boolean z) {
        l1.B("getMetaType() - isOfflineRequest : ", z, LogU.Companion, "NetUtils");
        String s = z ? "AAC128" : MelonSettingInfo.getStreamingFileWiFi();
        if("AAC320".equals(s)) {
            return "AAC";
        }
        if("MP3320".equals(s)) {
            return "MP3";
        }
        "AAC128".equals(s);
        return "AAC";
    }

    @NotNull
    public final NameValuePairList getWebViewParamList(@Nullable Uri uri0) {
        NameValuePairList nameValuePairList0 = new NameValuePairList();
        if(uri0 != null) {
            for(Object object0: NetUtils.getQueryParameterNames(uri0)) {
                String s = (String)object0;
                if(!"url".equals(s) && !"type".equals(s)) {
                    nameValuePairList0.add(s, uri0.getQueryParameter(s));
                }
            }
        }
        return nameValuePairList0;
    }

    public static final boolean isConnected() {
        return NetworkStatusManager.isNetworkAvailable();
    }

    public final boolean isConnectedOrConnecting(@Nullable Context context0) {
        return NetworkStatusManager.isNetworkAvailable();
    }

    // 去混淆评级： 低(20)
    public static final boolean isDataNetwork() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public static final boolean isWifiConnected() [...] // 潜在的解密器

    public static final void showNetworkInfoPopupIfNotConnected(@Nullable Context context0) {
        if(context0 == null) {
            LogU.Companion.w("NetUtils", "showNetworkInfoPopupIfNotConnected() invalid context");
            return;
        }
        if(NetUtils.checkDataNetwork() == 3) {
            NetUtils.INSTANCE.getClass();
            NetUtils.a(context0, "mobile");
            return;
        }
        if(!MelonSettingInfo.isUseDataNetwork()) {
            NetUtils.INSTANCE.getClass();
            NetUtils.a(context0, "melon");
            return;
        }
        ToastManager.showShort(0x7F1303DA);  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
    }

    public static final boolean showNetworkPopupOrToast(@NotNull Context context0, boolean z) {
        q.g(context0, "context");
        int v = NetUtils.checkDataNetwork();
        if(v != 0 && v != 1) {
            switch(v) {
                case 2: {
                    if(z) {
                        ToastManager.showShort(0x7F1303DA);  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
                        return false;
                    }
                    NetUtils.INSTANCE.getClass();
                    NetUtils.a(context0, "melon");
                    return false;
                }
                case 3: {
                    if(z) {
                        ToastManager.showShort(0x7F1303DA);  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
                        return false;
                    }
                    NetUtils.INSTANCE.getClass();
                    NetUtils.a(context0, "mobile");
                    return false;
                }
                default: {
                    return true;
                }
            }
        }
        return true;
    }
}

