package com.iloen.melon.net;

import Db.h;
import android.content.Context;
import android.text.TextUtils;
import b3.Z;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request.Priority;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.network.UrlHttpCheckHelper;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k8.Y;
import va.e;

public class RequestBuilder {
    static final class Headers extends LinkedHashMap {
        private static final long serialVersionUID = 5270469715500620499L;

        public Map headers() [...] // Inlined contents

        public static Headers newInstance() {
            return new Headers();
        }
    }

    public static final class Params extends LinkedHashMap {
        private static final long serialVersionUID = 0x36B83AAA44517AA3L;

        public void addToValueEncoded(String s, String s1) {
            if(TextUtils.isEmpty(s1)) {
                this.put(s, "");
                return;
            }
            try {
                this.put(s, URLEncoder.encode(s1, "utf-8"));
            }
            catch(UnsupportedEncodingException unsupportedEncodingException0) {
                LogU.e("RequestBuilder", "addToValueEncoded() " + unsupportedEncodingException0);
            }
        }

        public static Params newInstance() {
            return new Params();
        }

        public Map params() [...] // Inlined contents
    }

    private static final String TAG = "RequestBuilder";
    protected InputStream fileStream;
    protected ErrorListener mErrorListener;
    protected File mFile;
    protected String mFilename;
    protected Headers mHeaders;
    protected Listener mListener;
    protected int mMethod;
    protected Priority mPriority;
    protected HttpRequest mRequest;
    protected String mTag;
    protected String mUrl;
    private static Map sEmptyHeaders;
    private static long sReqNum;

    static {
        RequestBuilder.sEmptyHeaders = new HashMap();
    }

    public RequestBuilder(HttpRequest httpRequest0) {
        this.mMethod = -1;
        this.mPriority = Priority.NORMAL;
        this.mRequest = httpRequest0;
        this.headers(httpRequest0.headers());
    }

    public Request build() {
        String s2;
        File file1;
        int v = this.mMethod == -1 ? this.mRequest.getMethod() : this.mMethod;
        String s = TextUtils.isEmpty(this.mUrl) ? this.mRequest.url() : this.mUrl;
        Class class0 = this.mRequest.getResponseClazz();
        Params requestBuilder$Params0 = this.mRequest.params();
        FilePart httpRequest$FilePart0 = this.mRequest.filePart();
        String s1 = this.mRequest.jsonString();
        File file0 = this.mFile;
        Map map0 = null;
        if(file0 != null) {
            file1 = file0;
        }
        else if(httpRequest$FilePart0 != null) {
            file1 = httpRequest$FilePart0.file;
        }
        else {
            file1 = null;
        }
        if(TextUtils.isEmpty(this.mFilename)) {
            s2 = httpRequest$FilePart0 == null ? null : httpRequest$FilePart0.filename;
        }
        else {
            s2 = this.mFilename;
        }
        long v1 = RequestBuilder.sReqNum + 1L;
        RequestBuilder.sReqNum = v1;
        if(h.c.D()) {
            RequestBuilder.dumpRequest(this.mTag, v, s, this.mRequest.getClass().getSimpleName(), class0, this.mHeaders, requestBuilder$Params0, file1, s2, v1);
        }
        if(file1 != null) {
            Context context0 = this.mRequest.getContext();
            Headers requestBuilder$Headers0 = this.mHeaders;
            Map map1 = requestBuilder$Headers0 == null ? RequestBuilder.sEmptyHeaders : requestBuilder$Headers0;
            if(requestBuilder$Params0 != null && !requestBuilder$Params0.isEmpty()) {
                map0 = requestBuilder$Params0;
            }
            return new MultipartJsonRequest(context0, s, class0, map1, s2, file1, map0, this.mListener, this.mErrorListener, v1).setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f)).setTag(this.mTag);
        }
        if(this.fileStream != null) {
            Context context1 = this.mRequest.getContext();
            Headers requestBuilder$Headers1 = this.mHeaders;
            Map map2 = requestBuilder$Headers1 == null ? RequestBuilder.sEmptyHeaders : requestBuilder$Headers1;
            InputStream inputStream0 = this.fileStream;
            if(requestBuilder$Params0 != null && !requestBuilder$Params0.isEmpty()) {
                map0 = requestBuilder$Params0;
            }
            return new MultipartJsonRequest(context1, s, class0, map2, s2, inputStream0, map0, this.mListener, this.mErrorListener, v1).setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f)).setTag(this.mTag);
        }
        boolean z = v == 0 || 3 == v || !TextUtils.isEmpty(s1);
        StringBuilder stringBuilder0 = new StringBuilder();
        if(z && requestBuilder$Params0 != null && !requestBuilder$Params0.isEmpty()) {
            Iterator iterator0 = requestBuilder$Params0.entrySet().iterator();
            while(iterator0.hasNext()) {
                if(stringBuilder0.length() == 0) {
                    if(s.contains("?")) {
                        stringBuilder0.append("&");
                    }
                    else {
                        stringBuilder0.append("?");
                    }
                }
                Object object0 = iterator0.next();
                stringBuilder0.append(((Map.Entry)object0).getKey());
                stringBuilder0.append("=");
                stringBuilder0.append(((Map.Entry)object0).getValue());
                stringBuilder0.append("&");
            }
            if(stringBuilder0.length() > 0) {
                stringBuilder0.setLength(stringBuilder0.length() - 1);
            }
        }
        Context context2 = this.mRequest.getContext();
        StringBuilder stringBuilder1 = Y.p(s);
        stringBuilder1.append((z ? stringBuilder0.toString() : ""));
        String s3 = stringBuilder1.toString();
        Headers requestBuilder$Headers2 = this.mHeaders;
        Map map3 = requestBuilder$Headers2 == null ? RequestBuilder.sEmptyHeaders : requestBuilder$Headers2;
        if(!z && requestBuilder$Params0 != null && !requestBuilder$Params0.isEmpty()) {
            map0 = requestBuilder$Params0;
        }
        return new VolleyRequest(context2, v, s3, class0, map3, map0, s1, this.mListener, this.mErrorListener, this.mRequest.shouldCache(), this.mPriority, v1).setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f)).setTag(this.mTag);
    }

    private static void dumpRequest(String s, int v, String s1, String s2, Class class0, Headers requestBuilder$Headers0, Params requestBuilder$Params0, File file0, String s3, long v1) {
        StringBuilder stringBuilder0 = new StringBuilder("[REQ#] ");
        stringBuilder0.append(v1);
        stringBuilder0.append("\n[METHOD] ");
        stringBuilder0.append(v);
        stringBuilder0.append("\n[REQURL] ");
        stringBuilder0.append(s1);
        stringBuilder0.append("\n[RESPONSE] ");
        stringBuilder0.append(class0);
        e.g(stringBuilder0, "\n[TAG] ", s, "\n");
        if(!TextUtils.isEmpty(s3) && file0 != null) {
            stringBuilder0.append("[FILE] ");
            stringBuilder0.append(s3);
            stringBuilder0.append(", ");
            stringBuilder0.append(file0.getName());
            stringBuilder0.append("\n");
        }
        if(requestBuilder$Params0 != null && requestBuilder$Params0.size() > 0) {
            stringBuilder0.append("[PARAMS]\n");
            for(Object object0: requestBuilder$Params0.entrySet()) {
                stringBuilder0.append(">> ");
                stringBuilder0.append(((Map.Entry)object0).getKey());
                stringBuilder0.append("=");
                stringBuilder0.append(((Map.Entry)object0).getValue());
                stringBuilder0.append("\n");
            }
        }
        Z.x(new StringBuilder("=== [REQUEST] ===\n"), NetworkDebugHelper.logOnFile(s2, v1, stringBuilder0.toString()), "HttpRequest");
    }

    public RequestBuilder errorListener(ErrorListener response$ErrorListener0) {
        this.mErrorListener = response$ErrorListener0;
        return this;
    }

    public RequestBuilder file(String s, File file0) {
        this.mFilename = s;
        this.mFile = file0;
        return this;
    }

    public RequestBuilder headers(Headers requestBuilder$Headers0) {
        this.mHeaders = requestBuilder$Headers0;
        return this;
    }

    public RequestBuilder listener(Listener response$Listener0) {
        this.mListener = response$Listener0;
        return this;
    }

    public RequestBuilder method(int v) {
        this.mMethod = v;
        return this;
    }

    public static RequestBuilder newInstance(HttpRequest httpRequest0) {
        return new RequestBuilder(httpRequest0);
    }

    public RequestBuilder priority(Priority request$Priority0) {
        this.mPriority = request$Priority0;
        return this;
    }

    public void request() {
        RequestQueue requestQueue0 = MelonAppBase.instance.getRequestQueue();
        if(requestQueue0 == null) {
            LogU.e("RequestBuilder", "request() RequestQueue required");
            return;
        }
        Context context0 = this.mRequest.getContext();
        if(h.c.D()) {
            NetworkDebugHelper.dumpWifiConnection(context0, RequestBuilder.sReqNum);
        }
        Request request0 = this.build();
        if(!NetUtils.isConnected()) {
            request0.deliverError(MelonError.HTTP_CONNECTION_ERROR);
            return;
        }
        UrlHttpCheckHelper.INSTANCE.checkUrl(request0.getUrl());
        requestQueue0.add(request0);
    }

    public void requestForViewModel() {
        RequestQueue requestQueue0 = MelonAppBase.instance.getRequestQueue();
        if(requestQueue0 == null) {
            LogU.e("RequestBuilder", "request() RequestQueue required");
            return;
        }
        Context context0 = MelonAppBase.instance.getContext();
        if(h.c.D()) {
            NetworkDebugHelper.dumpWifiConnection(context0, RequestBuilder.sReqNum);
        }
        Request request0 = this.build();
        if(!NetUtils.isConnected()) {
            request0.deliverError(MelonError.HTTP_CONNECTION_ERROR);
            return;
        }
        UrlHttpCheckHelper.INSTANCE.checkUrl(request0.getUrl());
        requestQueue0.add(request0);
    }

    public HttpResponse requestSync(RequestFuture requestFuture0) {
        if(NetUtils.isConnected()) {
            try {
                this.request();
                HttpResponse httpResponse0 = (HttpResponse)requestFuture0.get(10L, TimeUnit.SECONDS);
                if(httpResponse0 != null) {
                    return httpResponse0;
                }
                LogU.e("RequestBuilder", "requestSync() invalid response");
                throw MelonError.SERVER_RESPONSE_ERROR;
            }
            catch(InterruptedException interruptedException0) {
                LogU.e("RequestBuilder", "requestSync() " + interruptedException0);
                throw new HttpResponseError(MelonError.fromResourceMessage(0x7F1303C6), interruptedException0);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
            catch(TimeoutException timeoutException0) {
                LogU.e("RequestBuilder", "requestSync() " + timeoutException0);
                throw MelonError.HTTP_CONNECTION_ERROR;
            }
            catch(ExecutionException executionException0) {
                LogU.e("RequestBuilder", "requestSync() " + executionException0);
                throw new HttpResponseError(MelonError.fromResourceMessage(0x7F1303C6), executionException0);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }
        throw MelonError.HTTP_CONNECTION_ERROR;
    }

    public HttpResponse requestSyncForViewModel(RequestFuture requestFuture0) {
        if(NetUtils.isConnected()) {
            try {
                this.requestForViewModel();
                HttpResponse httpResponse0 = (HttpResponse)requestFuture0.get(10L, TimeUnit.SECONDS);
                if(httpResponse0 != null) {
                    return httpResponse0;
                }
                LogU.e("RequestBuilder", "requestSync() invalid response");
                throw MelonError.SERVER_RESPONSE_ERROR;
            }
            catch(InterruptedException interruptedException0) {
                LogU.e("RequestBuilder", "requestSync() " + interruptedException0);
                throw new HttpResponseError(MelonError.fromResourceMessage(0x7F1303C6), interruptedException0);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
            catch(TimeoutException timeoutException0) {
                LogU.e("RequestBuilder", "requestSync() " + timeoutException0);
                throw MelonError.HTTP_CONNECTION_ERROR;
            }
            catch(ExecutionException executionException0) {
                LogU.e("RequestBuilder", "requestSync() " + executionException0);
                throw new HttpResponseError(MelonError.fromResourceMessage(0x7F1303C6), executionException0);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }
        throw MelonError.HTTP_CONNECTION_ERROR;
    }

    public RequestBuilder stream(String s, InputStream inputStream0) {
        this.mFilename = s;
        this.fileStream = inputStream0;
        return this;
    }

    public RequestBuilder tag(String s) {
        this.mTag = s;
        return this;
    }

    public RequestBuilder url(String s) {
        this.mUrl = s;
        return this;
    }
}

