package com.iloen.melon.net;

import A8.M;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.log.TestLog;
import e1.u;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import va.e0;
import va.o;

public abstract class HttpRequest {
    public static final class FilePart {
        public File file;
        public String filename;

    }

    public static final String ENCODING_GZIP = "gzip,deflate";
    public static final String HEADER_ACCEPT_CHARSET = "Accept-Charset";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_USER_AGENT = "User-Agent";
    private static final String PARAM_KEY_CPID = "cpId";
    private static final String PARAM_KEY_CPKEY = "cpKey";
    protected static final String PARAM_KEY_FILTER_CODES = "filterCodes";
    protected static final String PARAM_KEY_MEMBERKEY = "memberKey";
    private static final String TAG = "Request";
    private Context mContext;
    private FilePart mFilePart;
    protected Headers mHeaders;
    private String mJsonString;
    private int mMethod;
    private Params mParams;
    private Class mResClazz;

    public HttpRequest(int v, Class class0) {
        this(MelonAppBase.instance.getContext(), v, class0, true);
    }

    public HttpRequest(Context context0, int v, Class class0) {
        this(context0, v, class0, true);
    }

    public HttpRequest(Context context0, int v, Class class0, boolean z) {
        new Params();
        this.mParams = Params.newInstance();
        Headers requestBuilder$Headers0 = new Headers();
        this.mHeaders = requestBuilder$Headers0;
        requestBuilder$Headers0.put("User-Agent", MelonAppBase.instance.getMelonProtocolUserAgent());
        this.mHeaders.put("Accept-Charset", "utf-8");
        this.mHeaders.put("Accept-Encoding", "gzip,deflate");
        this.mContext = context0;
        this.mMethod = v;
        this.mResClazz = class0;
        if(z) {
            this.addParam("cpId", MelonAppBase.instance.getMelonCpId());
            this.addParam("cpKey", MelonAppBase.instance.getMelonCpKey());
        }
    }

    public HttpRequest(Context context0, String s, String s1, int v, Class class0) {
        this(context0, v, class0, false);
        if(!TextUtils.isEmpty(s)) {
            this.addParam("cpId", s);
        }
        if(!TextUtils.isEmpty(s1)) {
            this.addParam("cpKey", s1);
        }
    }

    public void addFilePart(String s, File file0) {
        FilePart httpRequest$FilePart0 = new FilePart();
        this.mFilePart = httpRequest$FilePart0;
        httpRequest$FilePart0.filename = s;
        httpRequest$FilePart0.file = file0;
    }

    public void addHeader(String s, String s1) {
        Headers requestBuilder$Headers0 = this.mHeaders;
        if(requestBuilder$Headers0 != null) {
            requestBuilder$Headers0.put(s, s1);
        }
    }

    @Deprecated
    public void addMemberKey() {
        this.addMemberKey(u.v(((e0)o.a()).j()));
    }

    @Deprecated
    public void addMemberKey(String s) {
        if(u.o(s)) {
            this.addParam("memberKey", s);
        }
    }

    public void addMemberKey(String s, Boolean boolean0) {
        if(boolean0.booleanValue()) {
            this.addParam("memberKey", s);
            return;
        }
        if(u.o(s)) {
            this.addParam("memberKey", s);
        }
    }

    @Deprecated
    public void addMemberKeyAlwaysDeliver() {
        this.addMemberKeyAlwaysDeliver(u.v(((e0)o.a()).j()));
    }

    @Deprecated
    public void addMemberKeyAlwaysDeliver(String s) {
        this.addParam("memberKey", s);
    }

    public void addOsVersionParam() {
        String s = (String)this.mParams.get("memberKey");
        if(!TextUtils.isEmpty(s)) {
            this.mParams.remove("memberKey");
            this.addParam("osVersion", Build.VERSION.RELEASE);
            this.addMemberKey(s);
            return;
        }
        this.addParam("osVersion", Build.VERSION.RELEASE);
    }

    private void addParam(String s, Object object0) {
        if(object0 == null) {
            this.addParam(s, "");
            return;
        }
        if(String.class.isInstance(object0)) {
            this.addParam(s, ((String)object0));
            return;
        }
        if(Integer.class.isInstance(object0)) {
            this.addParam(s, String.valueOf(((int)(((Integer)object0)))));
            return;
        }
        if(Long.class.isInstance(object0)) {
            this.addParam(s, String.valueOf(((long)(((Long)object0)))));
            return;
        }
        if(Boolean.class.isInstance(object0)) {
            this.addParam(s, String.valueOf(((Boolean)object0).booleanValue()));
            return;
        }
        LogU.e("Request", "addParam() unknown value:" + object0.toString());
    }

    public void addParam(String s, String s1) {
        Params requestBuilder$Params0 = this.mParams;
        if(TextUtils.isEmpty(s1)) {
            s1 = "";
        }
        requestBuilder$Params0.put(s, s1);
    }

    public void addParamToValueEncoded(String s, String s1) {
        this.mParams.addToValueEncoded(s, s1);
    }

    public void addParams(Object object0) {
        if(object0 != null) {
            Field[] arr_field = object0.getClass().getDeclaredFields();
            if(arr_field != null) {
                for(int v = 0; v < arr_field.length; ++v) {
                    Field field0 = arr_field[v];
                    if(!Modifier.isStatic(field0.getModifiers())) {
                        try {
                            this.addParam(field0.getName(), field0.get(object0));
                        }
                        catch(IllegalArgumentException illegalArgumentException0) {
                            LogU.e("Request", "addParameter() IllegalArgumentException:" + illegalArgumentException0.toString());
                        }
                        catch(IllegalAccessException illegalAccessException0) {
                            LogU.e("Request", "addParameter() IllegalAccessException:" + illegalAccessException0.toString());
                        }
                    }
                }
            }
        }
    }

    public String domain() {
        return M.a;
    }

    public FilePart filePart() {
        return this.mFilePart;
    }

    public abstract String getApiPath();

    public String getApiVersionPath() [...] // 潜在的解密器

    public Context getContext() {
        return this.mContext;
    }

    public int getMethod() {
        return this.mMethod;
    }

    public Class getResponseClazz() {
        return this.mResClazz == null ? HttpResponse.class : this.mResClazz;
    }

    public String getServerVersionPath() [...] // 潜在的解密器

    public Headers headers() {
        return this.mHeaders;
    }

    public int initialTimeoutMsPolicy() [...] // Inlined contents

    public String jsonString() {
        return this.mJsonString;
    }

    public Params params() {
        return this.mParams;
    }

    public void setJsonString(String s) {
        this.mJsonString = s;
    }

    public boolean shouldCache() {
        return true;
    }

    public String url() {
        String s = this.domain() + "" + "" + this.getApiPath();
        TestLog testLog0 = TestLog.INSTANCE;
        if(testLog0.isTestOn()) {
            testLog0.setTestVolleyReqUrl(this.getApiPath());
        }
        StringBuilder stringBuilder0 = new StringBuilder(s);
        if(1 == this.mMethod) {
            boolean z = this.mParams.containsKey("cpId");
            boolean z1 = this.mParams.containsKey("cpKey");
            if(z || z1) {
                String s1 = "?";
                String s2 = "&";
                if(!TextUtils.isEmpty(s)) {
                    if(s.contains("?")) {
                        s1 = "&";
                    }
                    stringBuilder0.append(s1);
                }
                if(z) {
                    stringBuilder0.append("_cpId=");
                    stringBuilder0.append(((String)this.mParams.get("cpId")));
                }
                if(z1) {
                    if(!z) {
                        s2 = "";
                    }
                    stringBuilder0.append(s2);
                    stringBuilder0.append("_cpKey=");
                    stringBuilder0.append(((String)this.mParams.get("cpKey")));
                }
            }
        }
        return stringBuilder0.toString();
    }
}

