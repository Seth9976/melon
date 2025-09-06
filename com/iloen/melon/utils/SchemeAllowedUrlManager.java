package com.iloen.melon.utils;

import H0.b;
import android.net.Uri;
import b3.Z;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.SchemeWebViewUrlListReq;
import com.iloen.melon.net.v4x.response.SchemeWebViewUrlListRes.RESPONSE;
import com.iloen.melon.net.v4x.response.SchemeWebViewUrlListRes;
import com.iloen.melon.utils.cipher.MelonCryptoManager;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SchemeAllowedUrlManager {
    public interface Callback {
        void callback(SERVER_STATE arg1);
    }

    public static enum SERVER_STATE {
        NONE,
        SUCCESS,
        ERROR;

    }

    static final class SchemeAllowedUrlCheckHolder {
        public static final SchemeAllowedUrlManager a;

        static {
            SchemeAllowedUrlManager schemeAllowedUrlManager0 = new SchemeAllowedUrlManager();  // 初始化器: Ljava/lang/Object;-><init>()V
            schemeAllowedUrlManager0.a = SERVER_STATE.NONE;
            String[] arr_s = MelonAppBase.instance.getContext().getResources().getStringArray(0x7F03000E);  // array:domain_whitelist
            schemeAllowedUrlManager0.b = new ArrayList();
            for(int v = 0; v < arr_s.length; ++v) {
                schemeAllowedUrlManager0.b(arr_s[v]);
            }
            SchemeAllowedUrlCheckHolder.a = schemeAllowedUrlManager0;
        }
    }

    static class URLPattern {
        public Pattern host;
        public Pattern path;
        public Integer port;
        public Pattern scheme;

        public URLPattern(String s, String s1, String s2, String s3) {
            try {
                this.scheme = "*".equals(s) ? null : Pattern.compile(URLPattern.a(s, false), 2);
                if("*".equals(s1)) {
                    this.host = null;
                }
                else if(s1.startsWith("*.")) {
                    this.host = Pattern.compile(("([a-z0-9.-]*\\.)?" + URLPattern.a(s1.substring(2), false)), 2);
                }
                else {
                    this.host = Pattern.compile(URLPattern.a(s1, false), 2);
                }
                this.port = s2 == null || "*".equals(s2) ? null : Integer.parseInt(s2, 10);
                if(s3 != null && !"/*".equals(s3)) {
                    this.path = Pattern.compile(URLPattern.a(s3, true));
                    return;
                }
                this.path = null;
            }
            catch(NumberFormatException unused_ex) {
                throw new MalformedURLException("Port must be a number");
            }
        }

        public static String a(String s, boolean z) {
            StringBuilder stringBuilder0 = new StringBuilder();
            for(int v = 0; v < s.length(); ++v) {
                int v1 = s.charAt(v);
                if(v1 == 42 && z) {
                    stringBuilder0.append(".");
                }
                else if("\\.[]{}()^$?+|".indexOf(v1) > -1) {
                    stringBuilder0.append('\\');
                }
                stringBuilder0.append(((char)v1));
            }
            return stringBuilder0.toString();
        }
    }

    public static final String TAG = "Whitelist";
    public SERVER_STATE a;
    public ArrayList b;

    public static void a(SchemeAllowedUrlManager schemeAllowedUrlManager0) {
        Set set0 = MelonPrefs.getInstance().getStringSet("whitelistDomains", null);
        if(set0 != null && !set0.isEmpty()) {
            for(Object object0: set0) {
                String s = (String)object0;
                try {
                    String s1 = MelonCryptoManager.melonCrypto(0, s);
                    LogU.d("Whitelist", "loadWhiteListInStorage() > domain : " + s1);
                    schemeAllowedUrlManager0.b(s1);
                }
                catch(Exception unused_ex) {
                }
            }
        }
    }

    public final void b(String s) {
        String s1 = "*";
        if(this.b != null) {
            try {
                if(s.compareTo("*") == 0) {
                    LogU.d("Whitelist", "Unlimited access to network resources");
                    this.b = null;
                    return;
                }
                Matcher matcher0 = Pattern.compile("^((\\*|[A-Za-z-]+):(//)?)?(\\*|((\\*\\.)?[^*/:]+))?(:(\\d+))?(/.*)?").matcher(s);
                if(matcher0.matches()) {
                    String s2 = matcher0.group(2);
                    String s3 = matcher0.group(4);
                    if(!"file".equals(s2) && !"content".equals(s2) || s3 != null) {
                        s1 = s3;
                    }
                    String s4 = matcher0.group(8);
                    String s5 = matcher0.group(9);
                    if(s2 == null) {
                        this.b.add(new URLPattern("http", s1, s4, s5));
                        this.b.add(new URLPattern("https", s1, s4, s5));
                        LogU.d("Whitelist", "addWhiteListEntry() scheme : " + null + "   host : " + s1 + "   path : " + s5);
                        return;
                    }
                    this.b.add(new URLPattern(s2, s1, s4, s5));
                    LogU.d("Whitelist", "addWhiteListEntry() scheme : " + s2 + "   host : " + s1 + "   path : " + s5);
                }
            }
            catch(Exception unused_ex) {
                Z.w("Failed to add origin : ", s, "Whitelist");
            }
        }
    }

    public static SchemeAllowedUrlManager getInstance() {
        return SchemeAllowedUrlCheckHolder.a;
    }

    public boolean isAllowedUrl(String s) {
        if(this.b == null) {
            return true;
        }
        if(s == null) {
            return false;
        }
        String s1 = Uri.parse(s).getScheme();
        if(s1 == null) {
            return false;
        }
        String s2 = s1.trim();
        if(!s2.equalsIgnoreCase("file") && !s2.equalsIgnoreCase("javascript")) {
            for(Object object0: this.b) {
                URLPattern schemeAllowedUrlManager$URLPattern0 = (URLPattern)object0;
                schemeAllowedUrlManager$URLPattern0.getClass();
                try {
                    URI uRI0 = new URI(s);
                    if(uRI0.getScheme() == null) {
                        uRI0 = new URI("https://" + s);
                    }
                    if(schemeAllowedUrlManager$URLPattern0.scheme != null && !schemeAllowedUrlManager$URLPattern0.scheme.matcher(uRI0.getScheme()).matches() || schemeAllowedUrlManager$URLPattern0.host != null && !schemeAllowedUrlManager$URLPattern0.host.matcher(uRI0.getHost()).matches()) {
                        continue;
                    }
                    return true;
                }
                catch(URISyntaxException unused_ex) {
                }
                catch(Exception exception0) {
                    goto label_22;
                }
                continue;
            label_22:
                LogU.d("Whitelist", exception0.toString());
            }
        }
        return false;
    }

    public boolean isSSL(String s) {
        try {
            return !new URI(s).getScheme().equals("http");
        }
        catch(URISyntaxException unused_ex) {
            return false;
        }
    }

    public void updateAllowedUrl(Callback schemeAllowedUrlManager$Callback0) {
        SERVER_STATE schemeAllowedUrlManager$SERVER_STATE0 = this.a;
        if(schemeAllowedUrlManager$SERVER_STATE0 != SERVER_STATE.SUCCESS) {
            RequestBuilder.newInstance(new SchemeWebViewUrlListReq(MelonAppBase.instance.getContext())).tag("Whitelist").listener(new Listener() {
                public final Callback a;
                public final SchemeAllowedUrlManager b;

                {
                    Callback schemeAllowedUrlManager$Callback0 = schemeAllowedUrlManager$Callback0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.b = schemeAllowedUrlManager0;
                    this.a = schemeAllowedUrlManager$Callback0;
                }

                public void onResponse(SchemeWebViewUrlListRes schemeWebViewUrlListRes0) {
                    if(schemeWebViewUrlListRes0 != null && schemeWebViewUrlListRes0.isSuccessful()) {
                        RESPONSE schemeWebViewUrlListRes$RESPONSE0 = schemeWebViewUrlListRes0.response;
                        SchemeAllowedUrlManager schemeAllowedUrlManager0 = this.b;
                        if(schemeWebViewUrlListRes$RESPONSE0 == null) {
                            LogU.d("Whitelist", "updateAllowedUrl() : no domain to add.");
                            SchemeAllowedUrlManager.a(schemeAllowedUrlManager0);
                        }
                        else {
                            ArrayList arrayList0 = schemeWebViewUrlListRes$RESPONSE0.allowList;
                            if(arrayList0 == null) {
                                LogU.d("Whitelist", "updateAllowedUrl() : no domain to add.");
                                SchemeAllowedUrlManager.a(schemeAllowedUrlManager0);
                            }
                            else {
                                for(Object object0: arrayList0) {
                                    String s = (String)object0;
                                    Z.w(" add original domain : ", s, "Whitelist");
                                    try {
                                        LogU.d("Whitelist", "add crypto : " + MelonCryptoManager.melonCrypto(0, s));
                                        schemeAllowedUrlManager0.b(MelonCryptoManager.melonCrypto(0, s));
                                    }
                                    catch(Exception unused_ex) {
                                    }
                                }
                                HashSet hashSet0 = new HashSet();
                                for(Object object1: arrayList0) {
                                    String s1 = (String)object1;
                                    try {
                                        hashSet0.add(s1);
                                    }
                                    catch(Exception exception0) {
                                        b.v(exception0, new StringBuilder("SchemeAllowedUrlManager() "), "Whitelist");
                                    }
                                }
                                MelonPrefs.getInstance().setStringSet("whitelistDomains", hashSet0);
                            }
                        }
                        schemeAllowedUrlManager0.a = SERVER_STATE.SUCCESS;
                        this.a.callback(SERVER_STATE.SUCCESS);
                    }
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((SchemeWebViewUrlListRes)object0));
                }
            }).errorListener(new ErrorListener() {
                public final Callback a;
                public final SchemeAllowedUrlManager b;

                {
                    Callback schemeAllowedUrlManager$Callback0 = schemeAllowedUrlManager$Callback0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.b = schemeAllowedUrlManager0;
                    this.a = schemeAllowedUrlManager$Callback0;
                }

                @Override  // com.android.volley.Response$ErrorListener
                public void onErrorResponse(VolleyError volleyError0) {
                    LogU.d("Whitelist", "server update fail > error : " + volleyError0.networkResponse);
                    SchemeAllowedUrlManager.a(this.b);
                    this.b.a = SERVER_STATE.ERROR;
                    this.a.callback(SERVER_STATE.ERROR);
                }
            }).request();
            return;
        }
        schemeAllowedUrlManager$Callback0.callback(schemeAllowedUrlManager$SERVER_STATE0);
    }
}

