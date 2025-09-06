package com.kakao.tiara;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.SimpleTimeZone;

class TiaraCookieUtils {
    private static final int COOKIE_EXPIRES_HOUR = 10;
    private static final int COOKIE_EXPIRES_HOUR_AMOUNT = 12;
    private static final int COOKIE_EXPIRES_YEAR = 1;
    private static final int COOKIE_EXPIRES_YEAR_AMOUNT = 10;
    private static final String COOKIE_NAME_ACCOUNT_ID = "T_UACD";
    private static final String COOKIE_NAME_ADID = "DaumKakaoAdID";
    private static final String COOKIE_NAME_ADID_TRACKING_ENABLED = "DaumKakaoAdTrackingEnabled";
    private static final String COOKIE_NAME_ISUID = "_ISUID";
    private static final String COOKIE_NAME_SUID = "_SUID";
    private static final String COOKIE_NAME_TSID = "TSID";
    private static final String COOKIE_NAME_TUID = "TUID";
    private static final String COOKIE_NAME_T_ANO = "_T_ANO";
    private static final String COOKIE_NAME_UUID = "_UUID";
    private static final String EXPIRE_DATE_1972 = "Sat, 01-Jan-1972 00:00:00 GMT";
    private static final String EXPIRE_DATE_FORMAT = "EEE, dd-MMM-yyyy HH:mm:ss \'GMT\'";
    private static final String TAG = "TiaraCookieUtils";
    private static String[] rootDomains;
    private static String[] tiaraDomains;

    static {
        TiaraCookieUtils.tiaraDomains = new String[]{"tiara.daum.net", "tiara.kakao.com", "tiara.melon.com"};
        TiaraCookieUtils.rootDomains = new String[]{"daum.net", "kakao.com", "melon.com"};
    }

    // 去混淆评级： 低(20)
    private static String convertBooleanToString(boolean z) {
        return z ? "1" : "0";
    }

    public static void deleteAccountIdCookie() {
        TiaraCookieUtils.deleteCookie("T_UACD");
    }

    private static void deleteCookie(String s) {
        TiaraCookieUtils.setCookie(s, "", "Sat, 01-Jan-1972 00:00:00 GMT", TiaraCookieUtils.tiaraDomains);
    }

    public static void setAccountIdCookie(String s) {
        String s1 = TiaraEncrypt.encrypt(s, DataType.IDENTIFIER);
        if(s1 == null) {
            return;
        }
        TiaraCookieUtils.setCookie("T_UACD", s1, 1, 10, TiaraCookieUtils.tiaraDomains);
    }

    public static void setAdidCookie(String s) {
        TiaraCookieUtils.setCookie("DaumKakaoAdID", s, 1, 10, TiaraCookieUtils.tiaraDomains);
    }

    public static void setAdidTrackingEnabledCookie(boolean z) {
        TiaraCookieUtils.setCookie("DaumKakaoAdTrackingEnabled", TiaraCookieUtils.convertBooleanToString(z), 1, 10, TiaraCookieUtils.tiaraDomains);
    }

    private static void setCookie(String s, String s1, int v, int v1, String[] arr_s) {
        SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss \'GMT\'", Locale.US);
        simpleDateFormat0.setTimeZone(new SimpleTimeZone(0, "GMT"));
        Calendar calendar0 = Calendar.getInstance();
        calendar0.add(v, v1);
        TiaraCookieUtils.setCookie(s, s1, simpleDateFormat0.format(calendar0.getTime()), arr_s);
    }

    private static void setCookie(String s, String s1, String s2, String[] arr_s) {
        String s4;
        String s3;
        try {
            CookieManager cookieManager0 = CookieManager.getInstance();
            if(Build.VERSION.SDK_INT >= 0x1F) {
                s3 = "%s=%s; path=/; expires=%s; domain=.%s; SameSite=None; Secure; HttpOnly";
                s4 = "https://";
            }
            else {
                s3 = "%s=%s; path=/; expires=%s; domain=.%s; HttpOnly;";
                s4 = "";
            }
            for(int v = 0; v < arr_s.length; ++v) {
                String s5 = arr_s[v];
                String s6 = String.format(s3, s, s1, s2, s5);
                cookieManager0.setCookie(s4 + "." + s5, s6);
                cookieManager0.setCookie(s4 + s5, s6);
                Logger.debug("TiaraCookieUtils", "[cookie] " + s6, new Object[0]);
            }
            return;
        }
        catch(Exception exception0) {
        }
        Logger.error("TiaraCookieUtils", exception0.toString(), new Object[0]);
    }

    public static void setDomains(String[] arr_s) {
        if(arr_s != null && arr_s.length >= 1) {
            String[] arr_s1 = new String[arr_s.length];
            for(int v = 0; v < arr_s.length; ++v) {
                arr_s1[v] = "tiara." + arr_s[v];
            }
            TiaraCookieUtils.tiaraDomains = arr_s1;
            TiaraCookieUtils.rootDomains = arr_s;
        }
    }

    public static void setIsuidCookie(String s) {
        TiaraCookieUtils.setCookie("_ISUID", s, 10, 12, TiaraCookieUtils.tiaraDomains);
    }

    public static void setSuidCookie(String s) {
        TiaraCookieUtils.setCookie("_SUID", s, 10, 12, TiaraCookieUtils.tiaraDomains);
    }

    public static void setTAnoCookie(String s, String s1, Boolean boolean0) {
        StringBuilder stringBuilder0 = new StringBuilder("uuid=" + s);
        if(!TextUtils.isEmpty(s1)) {
            stringBuilder0.append(",adid=");
            stringBuilder0.append(s1);
        }
        if(boolean0 != null) {
            stringBuilder0.append(",adid_enabled=");
            stringBuilder0.append(TiaraCookieUtils.convertBooleanToString(boolean0.booleanValue()));
        }
        TiaraCookieUtils.setCookie("_T_ANO", TiaraEncrypt.encrypt(stringBuilder0.toString(), DataType.NON_IDENTIFIER), 1, 10, TiaraCookieUtils.rootDomains);
    }

    public static void setTsidCookie(String s) {
        TiaraCookieUtils.setCookie("TSID", s, 10, 12, TiaraCookieUtils.tiaraDomains);
    }

    public static void setTuidCookie(String s) {
        TiaraCookieUtils.setCookie("TUID", s, 1, 10, TiaraCookieUtils.tiaraDomains);
    }

    public static void setUuidCookie(String s) {
        TiaraCookieUtils.setCookie("_UUID", s, 1, 10, TiaraCookieUtils.tiaraDomains);
    }
}

