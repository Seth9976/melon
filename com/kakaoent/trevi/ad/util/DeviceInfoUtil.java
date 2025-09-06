package com.kakaoent.trevi.ad.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/kakaoent/trevi/ad/util/DeviceInfoUtil;", "", "<init>", "()V", "", "getOsName", "()Ljava/lang/String;", "getCurrentIp", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class DeviceInfoUtil {
    @NotNull
    public static final DeviceInfoUtil INSTANCE;

    static {
        DeviceInfoUtil.INSTANCE = new DeviceInfoUtil();
    }

    @Nullable
    public final String getCurrentIp() {
        try {
            Enumeration enumeration0 = NetworkInterface.getNetworkInterfaces();
            while(enumeration0.hasMoreElements()) {
                Enumeration enumeration1 = ((NetworkInterface)enumeration0.nextElement()).getInetAddresses();
                while(enumeration1.hasMoreElements()) {
                    InetAddress inetAddress0 = (InetAddress)enumeration1.nextElement();
                    if(!inetAddress0.isLoopbackAddress() && inetAddress0 instanceof Inet4Address) {
                        return inetAddress0.getHostAddress();
                    }
                    if(false) {
                        break;
                    }
                }
                if(false) {
                    break;
                }
            }
        }
        catch(SocketException socketException0) {
            TreviLog.INSTANCE.e("DeviceInfoUtil", "Error getCurrentIp() : " + socketException0.getMessage());
        }
        return null;
    }

    @NotNull
    public final String getOsName() [...] // Inlined contents
}

