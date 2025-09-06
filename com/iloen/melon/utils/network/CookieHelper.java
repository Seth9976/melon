package com.iloen.melon.utils.network;

import U4.x;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import b3.Z;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.AdIdManager;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.DeviceIdentifier;
import java.util.HashMap;
import java.util.Map;

public class CookieHelper {
    static final class CookieHelperHolder {
        public static final CookieHelper a;

        static {
            CookieHelperHolder.a = new CookieHelper();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
    }

    public static final String IS_INPUT_AUTHENTICATION_ADULT_PWD = "IS_INPUT_AUTHENTICATION_ADULT_PWD";
    public CookieManager a;
    public static final String[] b;

    static {
        CookieHelper.b = new String[]{"mFlacIntro", "mStoryIntro", "extSearch"};
    }

    public final void a(Context context0) {
        LogU.d("CookieHelper", "createPCIDCookie()");
        this.setCookie("PCID", DeviceIdentifier.id(context0) + "; max-age=1576800000; Domain=.melon.com; Path=/");
    }

    public final CookieManager b() {
        if(this.a == null) {
            LogU.d("CookieHelper", "getCookieManager() CREATE SINGLE INSTANCE");
            CookieManager cookieManager0 = CookieManager.getInstance();
            this.a = cookieManager0;
            cookieManager0.setAcceptCookie(true);
            this.a(MelonAppBase.instance.getContext());
        }
        LogU.d("CookieHelper", "getCookieManager() REUSE SINGLE INSTANCE");
        return this.a;
    }

    public void flush() {
        LogU.d("CookieHelper", "flush()");
        this.b().flush();
    }

    public String getCookie() {
        return this.b().getCookie("https://melon.com");
    }

    public Map getCookieMap(Context context0) {
        Map map0 = new HashMap();
        String s = this.getCookie();
        if(TextUtils.isEmpty(s)) {
            LogU.w("CookieHelper", "getCookieMap() empty");
            return map0;
        }
        String[] arr_s = s.split("\\;");
        if(arr_s == null) {
            LogU.w("CookieHelper", "getCookieMap() split failed");
            return map0;
        }
        for(int v = 0; v < arr_s.length; ++v) {
            String[] arr_s1 = arr_s[v].split("\\=");
            try {
                String s1 = arr_s1[0].trim();
                String s2 = arr_s1[1].trim();
                if(!"PCID".equals(s1) || !DeviceIdentifier.id(context0).equals(s2)) {
                    ((HashMap)map0).put(s1, s2);
                }
            }
            catch(Exception unused_ex) {
            }
        }
        return map0;
    }

    public static CookieHelper getInstance() {
        return CookieHelperHolder.a;
    }

    public void initCookies(Context context0) {
        this.a(context0);
        Info advertisingIdClient$Info0 = AdIdManager.INSTANCE.getAdId();
        if(advertisingIdClient$Info0 != null) {
            this.setCookie("tiara.melon.com", "DaumKakaoAdID", advertisingIdClient$Info0.getId() + "; Domain=.tiara.melon.com; Path=/");
            this.setCookie("tiara.melon.com", "DaumKakaoAdTrackingEnabled", x.g(!advertisingIdClient$Info0.isLimitAdTrackingEnabled(), "; Domain=.tiara.melon.com; Path=/", new StringBuilder()));
        }
    }

    public void removeKakaoWebLoginCookie() {
        this.b().setCookie(".kakao.com", "_maldive_oauth_si=;");
    }

    public void removeSessionCookie() {
        LogU.d("CookieHelper", "removeSessionCookie()");
        try {
            this.b().removeSessionCookies(null);
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
    }

    public void setCookie(String s, String s1) {
        this.setCookie("https://melon.com", s, s1);
    }

    public void setCookie(String s, String s1, String s2) {
        String s3 = s1 + "=" + s2;
        Z.w("setCookie() key|value: ", s3, "CookieHelper");
        try {
            this.b().setCookie(s, s3);
        }
        catch(Exception exception0) {
            LogU.e("CookieHelper", "setCookie() ", exception0);
        }
    }

    public void setCookies(String[] arr_s) {
        if(arr_s == null) {
            LogU.v("CookieHelper", "setCookies() invalid parameter");
            return;
        }
        try {
            CookieManager cookieManager0 = this.b();
            for(int v = 0; v < arr_s.length; ++v) {
                String s = arr_s[v];
                LogU.d("CookieHelper", "setCookies() [" + v + "]:" + s);
                cookieManager0.setCookie("https://melon.com", s);
            }
        }
        catch(Exception exception0) {
            LogU.e("CookieHelper", "setCookies() ", exception0);
        }
    }

    public void updateServiceCookies(boolean z) {
        String s = z ? System.currentTimeMillis() + "; Domain=.melon.com; Path=/" : "; Domain=.melon.com; Path=/";
        for(int v = 0; v < 3; ++v) {
            String s1 = CookieHelper.b[v];
            LogU.d("CookieHelper", "updateServiceCookies() name: " + s1 + ", value:" + s);
            this.setCookie(s1, s);
        }
    }
}

