package com.iloen.melon.net;

import A7.d;
import Db.h;
import android.content.Context;
import android.text.TextUtils;
import b3.Z;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.Request.Priority;
import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.n;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.CookieHelper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class VolleyRequest extends Request {
    private static final int BIG_DATA_FAILURE_STATUS_CODE = 500;
    private static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    private static final String PROTOCOL_CHARSET = "utf-8";
    private static final String SET_COOKIE = "Set-Cookie";
    private static final String TAG = "VolleyRequest";
    private static final boolean USE_CUSTOM_PARSER = false;
    private final Class mClazz;
    private final Context mContext;
    private final Map mHeaders;
    private final String mJsonString;
    private final Listener mListener;
    private final Map mParams;
    private final Priority mPriority;
    private final long mReqId;

    public VolleyRequest(Context context0, int v, String s, Class class0, Map map0, Map map1, String s1, Listener response$Listener0, ErrorListener response$ErrorListener0, boolean z, Priority request$Priority0, long v1) {
        super(v, s, response$ErrorListener0);
        this.setShouldCache(z);
        this.mContext = context0;
        this.mClazz = class0;
        this.mHeaders = map0;
        this.mParams = map1;
        this.mListener = response$Listener0;
        this.mPriority = request$Priority0;
        this.mReqId = v1;
        this.mJsonString = s1;
    }

    @Override  // com.android.volley.Request
    public void deliverError(VolleyError volleyError0) {
        ErrorListener response$ErrorListener0 = this.getErrorListener();
        if(response$ErrorListener0 != null && this.mContext != null) {
            response$ErrorListener0.onErrorResponse(volleyError0);
        }
    }

    @Override  // com.android.volley.Request
    public void deliverResponse(Object object0) {
        Listener response$Listener0 = this.mListener;
        if(response$Listener0 != null && this.mContext != null) {
            response$Listener0.onResponse(object0);
        }
    }

    private static void dumpResponse(int v, String s, String s1, String s2, long v1) {
        StringBuilder stringBuilder0 = new StringBuilder("[REQ#] ");
        stringBuilder0.append(v1);
        stringBuilder0.append("\n[METHOD] ");
        stringBuilder0.append(v);
        d.u(stringBuilder0, "\n[RESURL] ", s, "\n[JSON] ", s2);
        stringBuilder0.append("\n");
        Z.x(new StringBuilder("=== [RESPONSE] ===\n"), NetworkDebugHelper.logOnFile(s1, v1, stringBuilder0.toString()), "HttpRequest");
    }

    @Override  // com.android.volley.Request
    public byte[] getBody() {
        try {
            return TextUtils.isEmpty(this.mJsonString) ? super.getBody() : this.mJsonString.getBytes("utf-8");
        }
        catch(UnsupportedEncodingException unused_ex) {
            return super.getBody();
        }
    }

    // 去混淆评级： 低(20)
    @Override  // com.android.volley.Request
    public String getBodyContentType() {
        return TextUtils.isEmpty(this.mJsonString) ? super.getBodyContentType() : "application/json; charset=utf-8";
    }

    public String[] getHeaderValues(String s, NetworkResponse networkResponse0) {
        String[] arr_s = null;
        if(networkResponse0 == null) {
            LogU.w("VolleyRequest", "getHeaderValues() invalid response");
            return null;
        }
        ArrayList arrayList0 = null;
        for(Object object0: networkResponse0.allHeaders) {
            Header header0 = (Header)object0;
            if(s.equalsIgnoreCase(header0.getName())) {
                if(arrayList0 == null) {
                    arrayList0 = new ArrayList(2);
                }
                arrayList0.add(header0.getValue());
            }
        }
        if(arrayList0.size() > 0) {
            Object[] arr_object = arrayList0.toArray();
            arr_s = new String[arr_object.length];
            System.arraycopy(arr_object, 0, arr_s, 0, arr_object.length);
        }
        return arr_s;
    }

    @Override  // com.android.volley.Request
    public Map getHeaders() {
        Map map0 = this.mHeaders;
        return map0 != null ? map0 : new HashMap();
    }

    @Override  // com.android.volley.Request
    public Map getParams() {
        return this.mParams;
    }

    @Override  // com.android.volley.Request
    public Priority getPriority() {
        return this.mPriority;
    }

    private static boolean isSuccessful(int v) {
        return v >= 200 && v < 400;
    }

    private static String parseGzipEncodingResponse(byte[] arr_b) {
        OutOfMemoryError outOfMemoryError1;
        IOException iOException1;
        InputStreamReader inputStreamReader1;
        BufferedReader bufferedReader0;
        GZIPInputStream gZIPInputStream0;
        InputStreamReader inputStreamReader0;
        String s = "";
        if(arr_b == null) {
            LogU.w("VolleyRequest", "parseGzipEncodingResponse() invalid data");
            return "";
        }
        try {
            inputStreamReader0 = null;
            gZIPInputStream0 = null;
            gZIPInputStream0 = new GZIPInputStream(new ByteArrayInputStream(arr_b));
        }
        catch(IOException iOException0) {
            bufferedReader0 = null;
            iOException1 = iOException0;
            inputStreamReader1 = null;
            goto label_46;
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            bufferedReader0 = null;
            outOfMemoryError1 = outOfMemoryError0;
            inputStreamReader1 = null;
            goto label_54;
        }
        catch(Throwable throwable0) {
            bufferedReader0 = null;
            goto label_63;
        }
        try {
            inputStreamReader1 = new InputStreamReader(gZIPInputStream0);
        }
        catch(IOException iOException0) {
            bufferedReader0 = null;
            iOException1 = iOException0;
            inputStreamReader1 = null;
            goto label_46;
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            bufferedReader0 = null;
            outOfMemoryError1 = outOfMemoryError0;
            inputStreamReader1 = null;
            goto label_54;
        }
        catch(Throwable throwable0) {
            bufferedReader0 = null;
            goto label_63;
        }
        try {
            bufferedReader0 = null;
            bufferedReader0 = new BufferedReader(inputStreamReader1);
            goto label_41;
        }
        catch(IOException iOException2) {
            iOException1 = iOException2;
            goto label_46;
        }
        catch(OutOfMemoryError outOfMemoryError2) {
            outOfMemoryError1 = outOfMemoryError2;
            goto label_54;
            try {
                while(true) {
                label_41:
                    String s1 = bufferedReader0.readLine();
                    if(s1 == null) {
                        goto label_70;
                    }
                    s = s + s1;
                }
            }
            catch(IOException iOException1) {
            }
            catch(OutOfMemoryError outOfMemoryError1) {
                goto label_54;
            }
            catch(Throwable throwable0) {
                goto label_62;
            }
            try {
            label_46:
                LogU.w("VolleyRequest", "getStringFromInputStream() " + iOException1.toString());
                if(inputStreamReader1 != null) {
                    goto label_48;
                }
                goto label_49;
            }
            catch(Throwable throwable0) {
                goto label_62;
            }
            try {
            label_48:
                inputStreamReader1.close();
            }
            catch(IOException unused_ex) {
            }
        label_49:
            if(bufferedReader0 != null) {
                try {
                    bufferedReader0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            if(gZIPInputStream0 != null) {
                goto label_72;
            }
            return s;
            try {
            label_54:
                LogU.w("VolleyRequest", "getStringFromInputStream() " + outOfMemoryError1.toString());
                if(inputStreamReader1 != null) {
                    goto label_56;
                }
                goto label_57;
            }
            catch(Throwable throwable0) {
                goto label_62;
            }
            try {
            label_56:
                inputStreamReader1.close();
            }
            catch(IOException unused_ex) {
            }
        label_57:
            if(bufferedReader0 != null) {
                try {
                    bufferedReader0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            if(gZIPInputStream0 != null) {
                goto label_72;
            }
            return s;
        }
        catch(Throwable throwable0) {
        label_62:
            inputStreamReader0 = inputStreamReader1;
        }
    label_63:
        if(inputStreamReader0 != null) {
            try {
                inputStreamReader0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        if(bufferedReader0 != null) {
            try {
                bufferedReader0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        if(gZIPInputStream0 != null) {
            try {
                gZIPInputStream0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        throw throwable0;
        try {
        label_70:
            inputStreamReader1.close();
        }
        catch(IOException unused_ex) {
        }
        try {
            bufferedReader0.close();
        }
        catch(IOException unused_ex) {
        }
        try {
        label_72:
            gZIPInputStream0.close();
        }
        catch(IOException unused_ex) {
        }
        return s;
    }

    private static String parseMLog(NetworkResponse networkResponse0) {
        return networkResponse0 == null ? "" : ((String)networkResponse0.headers.get("M-Log"));
    }

    @Override  // com.android.volley.Request
    public Response parseNetworkResponse(NetworkResponse networkResponse0) {
        int v = networkResponse0.statusCode;
        LogU.v("VolleyRequest", "parseNetworkResponse() response:" + this.mClazz + ", statusCode:" + v);
        if(500 == v) {
            return Response.error(MelonError.BIG_DATA_ERROR);
        }
        if(!VolleyRequest.isSuccessful(v)) {
            return Response.error(MelonError.HTTP_RESPONSE_ERROR);
        }
        try {
            String s = VolleyRequest.parseResponse(networkResponse0);
            if(h.c.D()) {
                VolleyRequest.dumpResponse(this.getMethod(), this.getUrl(), this.mClazz.getSimpleName(), s.toString(), this.mReqId);
            }
            if(TextUtils.isEmpty(s)) {
                LogU.w("VolleyRequest", "parseNetworkResponse() invalid json");
                return Response.error(MelonError.SERVER_RESPONSE_ERROR);
            }
            if(networkResponse0.headers.containsKey("Set-Cookie")) {
                CookieHelper.getInstance().setCookies(this.getHeaderValues("Set-Cookie", networkResponse0));
            }
            Response response0 = Response.success((VolleyRequest.USE_CUSTOM_PARSER ? new ResponseParser().fromJson(s, this.mClazz) : new n().e(s, this.mClazz)), null);
            if(response0 == null) {
                LogU.w("VolleyRequest", "parseNetworkResponse() invalid response");
                return Response.error(MelonError.SERVER_RESPONSE_ERROR);
            }
            String s1 = VolleyRequest.parseMLog(networkResponse0);
            if(!TextUtils.isEmpty(s1)) {
                Object object0 = response0.result;
                if(object0 instanceof HttpResponse) {
                    ((HttpResponse)object0).logging = s1;
                }
            }
            return response0;
        }
        catch(Exception exception0) {
            LogU.w("VolleyRequest", "parseNetworkResponse() " + exception0);
            return Response.error(MelonError.SERVER_RESPONSE_ERROR);
        }
    }

    public static String parseResponse(NetworkResponse networkResponse0) {
        if(networkResponse0 == null) {
            return "";
        }
        String s = (String)networkResponse0.headers.get("Content-Encoding");
        if(!TextUtils.isEmpty(s) && "gzip".equals(s)) {
            return VolleyRequest.parseGzipEncodingResponse(networkResponse0.data);
        }
        String s1 = HttpHeaderParser.parseCharset(networkResponse0.headers, "utf-8");
        return new String(networkResponse0.data, s1);
    }
}

