package com.iloen.melon.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.iloen.melon.utils.log.FileLog;
import com.iloen.melon.utils.log.LogU;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

class NetworkDebugHelper {
    private static final int BUFFER_MAX = 0x19000;
    private static final int LOG_FILE_MAX = 500;
    private static final boolean LOG_ON_FILE = false;
    public static final String LOG_TAG = "HttpRequest";
    private static final boolean WIFI_DEBUG;

    static {
        NetworkDebugHelper.LOG_ON_FILE = false;
        NetworkDebugHelper.WIFI_DEBUG = false;
    }

    private static File createAndCheckLogFileMax(String s, long v) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("HttpRequest", "createAndCheckLogFileMax() - invalid parameter");
            return null;
        }
        File file0 = new File(FileLog.getPath() + "/protocol");
        if(!file0.exists()) {
            file0.mkdirs();
        }
        File[] arr_file = file0.listFiles();
        if(arr_file != null && arr_file.length >= 500) {
            for(int v1 = 0; v1 < arr_file.length; ++v1) {
                arr_file[v1].delete();
            }
        }
        File file1 = new File(file0, String.format("[%s][#%03d]%s.log", "20250906-113132", v, URLEncoder.encode(s, "UTF-8")));
        file1.createNewFile();
        return file1;
    }

    public static void dumpWifiConnection(Context context0, long v) {
        if(NetworkDebugHelper.WIFI_DEBUG) {
            if(context0 == null) {
                LogU.w("HttpRequest", "dumpWifiConnection() invalid context");
                return;
            }
            NetworkInfo networkInfo0 = ((ConnectivityManager)context0.getSystemService("connectivity")).getActiveNetworkInfo();
            if(networkInfo0 == null) {
                LogU.w("HttpRequest", "dumpWifiConnection() - Failed to get ConnectivityManager");
                return;
            }
            if(!networkInfo0.isConnected()) {
                LogU.d("HttpRequest", "dumpWifiConnection() - Network unavailable...");
                return;
            }
            if(networkInfo0.getType() != 1) {
                LogU.v("HttpRequest", "dumpWifiConnection() - Not WIFI connection");
                return;
            }
            WifiManager wifiManager0 = (WifiManager)context0.getApplicationContext().getSystemService("wifi");
            if(wifiManager0 != null) {
                WifiInfo wifiInfo0 = wifiManager0.getConnectionInfo();
                if(wifiInfo0 != null) {
                    if(!wifiInfo0.getHiddenSSID()) {
                        LogU.v("HttpRequest", "=======================[" + v + "]");
                        LogU.v("HttpRequest", "> WIFI SSID : " + wifiInfo0.getSSID());
                        LogU.v("HttpRequest", "=======================");
                        return;
                    }
                    LogU.w("HttpRequest", "dumpWifiConnection() - Wifi hidden SSID");
                }
            }
        }
    }

    public static String logOnFile(String s, long v, String s1) {
        BufferedOutputStream bufferedOutputStream1;
        BufferedOutputStream bufferedOutputStream0;
        if(s1 != null && NetworkDebugHelper.LOG_ON_FILE) {
            try {
                bufferedOutputStream0 = null;
                File file0 = NetworkDebugHelper.createAndCheckLogFileMax(s, v);
                if(file0 == null) {
                    LogU.w("HttpRequest", "logOnFile() - fail to get log file");
                    return s1;
                }
                bufferedOutputStream1 = new BufferedOutputStream(new FileOutputStream(file0, true), 0x19000);
            }
            catch(IOException iOException0) {
                goto label_22;
            }
            catch(SecurityException securityException0) {
                goto label_20;
            }
            catch(Throwable throwable0) {
                goto label_30;
            }
            try {
                bufferedOutputStream1.write(s1.getBytes("utf-8"));
                bufferedOutputStream1.flush();
                goto label_33;
            }
            catch(IOException iOException0) {
                bufferedOutputStream0 = bufferedOutputStream1;
                goto label_22;
            }
            catch(SecurityException securityException0) {
                bufferedOutputStream0 = bufferedOutputStream1;
                try {
                    while(true) {
                        LogU.w("HttpRequest", "logOnFile() - SecurityException :" + securityException0.toString());
                        goto label_25;
                        try {
                            goto label_30;
                        label_20:
                        }
                        catch(IOException iOException0) {
                            break;
                        }
                        catch(SecurityException securityException0) {
                        }
                    }
                label_22:
                    LogU.w("HttpRequest", "logOnFile() - IOException :" + iOException0.toString());
                    if(bufferedOutputStream0 != null) {
                        goto label_26;
                    }
                    return s1;
                }
                catch(Throwable throwable0) {
                    goto label_30;
                }
                goto label_26;
            label_25:
                if(bufferedOutputStream0 != null) {
                    try {
                    label_26:
                        bufferedOutputStream0.close();
                        return s1;
                    }
                    catch(IOException unused_ex) {
                    }
                }
                return s1;
            }
            catch(Throwable throwable0) {
                bufferedOutputStream0 = bufferedOutputStream1;
            }
        label_30:
            if(bufferedOutputStream0 != null) {
                try {
                    bufferedOutputStream0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable0;
            try {
            label_33:
                bufferedOutputStream1.close();
                return s1;
            }
            catch(IOException unused_ex) {
            }
        }
        return s1;
    }
}

