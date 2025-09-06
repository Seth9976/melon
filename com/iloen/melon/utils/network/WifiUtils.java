package com.iloen.melon.utils.network;

import android.content.Context;
import android.net.wifi.WifiManager.WifiLock;
import android.net.wifi.WifiManager;
import com.iloen.melon.utils.log.LogU;
import java.util.HashMap;

public class WifiUtils {
    public static WifiManager a;
    public static WifiManager.WifiLock b;
    public static int c;
    public static final HashMap d;

    static {
        WifiUtils.d = new HashMap();
    }

    public static void a(Context context0) {
        if(WifiUtils.a == null) {
            WifiUtils.a = (WifiManager)context0.getApplicationContext().getSystemService("wifi");
        }
        if(WifiUtils.b == null) {
            WifiUtils.b = WifiUtils.a.createWifiLock("com.iloen.melon");
        }
    }

    public static void acquireLock(Context context0) {
        HashMap hashMap0 = WifiUtils.d;
        synchronized(hashMap0) {
            String s = context0.getClass().getName();
            LogU.v("WifiUtils", "acquireLock / className: " + s);
            if(!hashMap0.containsKey(s) || hashMap0.get(s) == Boolean.FALSE) {
                if(WifiUtils.c == 0) {
                    WifiUtils.a(context0);
                    WifiManager.WifiLock wifiManager$WifiLock0 = WifiUtils.b;
                    if(wifiManager$WifiLock0 != null) {
                        wifiManager$WifiLock0.acquire();
                    }
                }
                ++WifiUtils.c;
                hashMap0.put(s, Boolean.TRUE);
                LogU.v("WifiUtils", "acquireLock / WifiLockRefCount: " + WifiUtils.c);
            }
        }
    }

    public static void releaseLock(Context context0) {
        HashMap hashMap0 = WifiUtils.d;
        synchronized(hashMap0) {
            String s = context0.getClass().getName();
            LogU.v("WifiUtils", "releaseLock / className: " + s);
            if(hashMap0.containsKey(s) && hashMap0.get(s) == Boolean.TRUE) {
                hashMap0.put(s, Boolean.FALSE);
                --WifiUtils.c;
                LogU.v("WifiUtils", "releaseLock / WifiLockRefCount: " + WifiUtils.c);
                if(WifiUtils.c == 0) {
                    WifiUtils.a(context0);
                    WifiManager.WifiLock wifiManager$WifiLock0 = WifiUtils.b;
                    if(wifiManager$WifiLock0 != null) {
                        wifiManager$WifiLock0.release();
                    }
                }
            }
        }
    }
}

