package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache.Entry;
import com.android.volley.ClientError;
import com.android.volley.Header;
import com.android.volley.Network;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class BasicNetwork implements Network {
    protected static final boolean DEBUG = false;
    private static final int DEFAULT_POOL_SIZE = 0x1000;
    private static final int SLOW_REQUEST_THRESHOLD_MS = 3000;
    private final BaseHttpStack mBaseHttpStack;
    @Deprecated
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    static {
        BasicNetwork.DEBUG = VolleyLog.DEBUG;
    }

    public BasicNetwork(BaseHttpStack baseHttpStack0) {
        this(baseHttpStack0, new ByteArrayPool(0x1000));
    }

    public BasicNetwork(BaseHttpStack baseHttpStack0, ByteArrayPool byteArrayPool0) {
        this.mBaseHttpStack = baseHttpStack0;
        this.mHttpStack = baseHttpStack0;
        this.mPool = byteArrayPool0;
    }

    @Deprecated
    public BasicNetwork(HttpStack httpStack0) {
        this(httpStack0, new ByteArrayPool(0x1000));
    }

    @Deprecated
    public BasicNetwork(HttpStack httpStack0, ByteArrayPool byteArrayPool0) {
        this.mHttpStack = httpStack0;
        this.mBaseHttpStack = new AdaptedHttpStack(httpStack0);
        this.mPool = byteArrayPool0;
    }

    private static List combineHeaders(List list0, Entry cache$Entry0) {
        TreeSet treeSet0 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if(!list0.isEmpty()) {
            for(Object object0: list0) {
                treeSet0.add(((Header)object0).getName());
            }
        }
        List list1 = new ArrayList(list0);
        List list2 = cache$Entry0.allResponseHeaders;
        if(list2 != null) {
            if(!list2.isEmpty()) {
                for(Object object1: cache$Entry0.allResponseHeaders) {
                    Header header0 = (Header)object1;
                    if(!treeSet0.contains(header0.getName())) {
                        ((ArrayList)list1).add(header0);
                    }
                }
                return list1;
            }
        }
        else if(!cache$Entry0.responseHeaders.isEmpty()) {
            for(Object object2: cache$Entry0.responseHeaders.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object2;
                if(!treeSet0.contains(map$Entry0.getKey())) {
                    ((ArrayList)list1).add(new Header(((String)map$Entry0.getKey()), ((String)map$Entry0.getValue())));
                }
            }
        }
        return list1;
    }

    @Deprecated
    public static Map convertHeaders(Header[] arr_header) {
        Map map0 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for(int v = 0; v < arr_header.length; ++v) {
            ((TreeMap)map0).put(arr_header[v].getName(), arr_header[v].getValue());
        }
        return map0;
    }

    private Map getCacheHeaders(Entry cache$Entry0) {
        if(cache$Entry0 == null) {
            return Collections.EMPTY_MAP;
        }
        Map map0 = new HashMap();
        String s = cache$Entry0.etag;
        if(s != null) {
            ((HashMap)map0).put("If-None-Match", s);
        }
        long v = cache$Entry0.lastModified;
        if(v > 0L) {
            ((HashMap)map0).put("If-Modified-Since", HttpHeaderParser.formatEpochAsRfc1123(v));
        }
        return map0;
    }

    private byte[] inputStreamToBytes(InputStream inputStream0, int v) {
        byte[] arr_b1;
        PoolingByteArrayOutputStream poolingByteArrayOutputStream0 = new PoolingByteArrayOutputStream(this.mPool, v);
        byte[] arr_b = null;
        try {
            if(inputStream0 == null) {
                throw new ServerError();
            }
            arr_b = this.mPool.getBuf(0x400);
            int v1;
            while((v1 = inputStream0.read(arr_b)) != -1) {
                poolingByteArrayOutputStream0.write(arr_b, 0, v1);
            }
            arr_b1 = poolingByteArrayOutputStream0.toByteArray();
            goto label_19;
        label_12:
            if(inputStream0 != null) {
                goto label_13;
            }
            goto label_16;
        }
        catch(Throwable throwable0) {
            goto label_12;
        }
        try {
        label_13:
            inputStream0.close();
        }
        catch(IOException unused_ex) {
            VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
        }
    label_16:
        this.mPool.returnBuf(arr_b);
        poolingByteArrayOutputStream0.close();
        throw throwable0;
        try {
        label_19:
            inputStream0.close();
        }
        catch(IOException unused_ex) {
            VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
        }
        this.mPool.returnBuf(arr_b);
        poolingByteArrayOutputStream0.close();
        return arr_b1;
    }

    public void logError(String s, String s1, long v) {
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", new Object[]{s, ((long)(SystemClock.elapsedRealtime() - v)), s1});
    }

    private void logSlowRequests(long v, Request request0, byte[] arr_b, int v1) {
        if(!BasicNetwork.DEBUG && v <= 3000L) {
            return;
        }
        Long long0 = v;
        Integer integer0 = arr_b == null ? "null" : ((int)arr_b.length);
        VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[]{request0, long0, integer0, v1, request0.getRetryPolicy().getCurrentRetryCount()});
    }

    @Override  // com.android.volley.Network
    public NetworkResponse performRequest(Request request0) {
        long v3;
        byte[] arr_b3;
        long v2;
        byte[] arr_b2;
        byte[] arr_b1;
        InputStream inputStream0;
        List list3;
        Entry cache$Entry0;
        List list2;
        int v1;
        HttpResponse httpResponse1;
        long v = SystemClock.elapsedRealtime();
        List list0 = Collections.EMPTY_LIST;
        HttpResponse httpResponse0 = null;
        try {
            Map map0 = this.getCacheHeaders(request0.getCacheEntry());
            httpResponse1 = this.mBaseHttpStack.executeRequest(request0, map0);
            goto label_10;
        }
        catch(SocketTimeoutException unused_ex) {
            throw new TimeoutError();
        }
        catch(UnknownHostException unused_ex) {
            throw new NetworkError();
        }
        catch(MalformedURLException malformedURLException0) {
            throw new RuntimeException("Bad URL " + request0.getUrl(), malformedURLException0);
        }
        catch(IOException iOException0) {
        }
        List list1 = list0;
        byte[] arr_b = null;
        goto label_70;
        try {
        label_10:
            v1 = httpResponse1.getStatusCode();
            list2 = httpResponse1.getHeaders();
            goto label_18;
        }
        catch(SocketTimeoutException unused_ex) {
            throw new TimeoutError();
        }
        catch(UnknownHostException unused_ex) {
            throw new NetworkError();
        }
        catch(MalformedURLException malformedURLException0) {
            throw new RuntimeException("Bad URL " + request0.getUrl(), malformedURLException0);
        }
        catch(IOException iOException0) {
        }
        list1 = list0;
        arr_b = null;
        httpResponse0 = httpResponse1;
        goto label_70;
    label_18:
        if(v1 == 304) {
            try {
                cache$Entry0 = request0.getCacheEntry();
                if(cache$Entry0 == null) {
                    return new NetworkResponse(304, null, true, SystemClock.elapsedRealtime() - v, list2);
                }
                goto label_25;
            }
            catch(SocketTimeoutException unused_ex) {
                throw new TimeoutError();
            }
            catch(UnknownHostException unused_ex) {
                throw new NetworkError();
            }
            catch(MalformedURLException malformedURLException0) {
                throw new RuntimeException("Bad URL " + request0.getUrl(), malformedURLException0);
            }
            catch(IOException iOException0) {
            }
            list3 = list2;
            goto label_36;
            try {
            label_25:
                list3 = list2;
                List list4 = BasicNetwork.combineHeaders(list3, cache$Entry0);
                return new NetworkResponse(304, cache$Entry0.data, true, SystemClock.elapsedRealtime() - v, list4);
            }
            catch(SocketTimeoutException unused_ex) {
                throw new TimeoutError();
            }
            catch(UnknownHostException unused_ex) {
                throw new NetworkError();
            }
            catch(MalformedURLException malformedURLException0) {
                throw new RuntimeException("Bad URL " + request0.getUrl(), malformedURLException0);
            }
            catch(IOException iOException0) {
            }
        }
        else {
            try {
                list3 = list2;
                inputStream0 = httpResponse1.getContent();
                if(inputStream0 == null) {
                    arr_b1 = new byte[0];
                    goto label_40;
                }
            }
            catch(SocketTimeoutException unused_ex) {
                throw new TimeoutError();
            }
            catch(UnknownHostException unused_ex) {
                throw new NetworkError();
            }
            catch(MalformedURLException malformedURLException0) {
                throw new RuntimeException("Bad URL " + request0.getUrl(), malformedURLException0);
            }
            try {
                arr_b1 = this.inputStreamToBytes(inputStream0, httpResponse1.getContentLength());
                goto label_40;
            }
            catch(SocketTimeoutException unused_ex) {
                throw new TimeoutError();
            }
            catch(UnknownHostException unused_ex) {
                throw new NetworkError();
            }
            catch(MalformedURLException malformedURLException0) {
                throw new RuntimeException("Bad URL " + request0.getUrl(), malformedURLException0);
            }
            catch(IOException iOException0) {
            }
        }
    label_36:
        arr_b = null;
        httpResponse0 = httpResponse1;
        list1 = list3;
        goto label_70;
        try {
        label_40:
            arr_b2 = arr_b1;
            v2 = SystemClock.elapsedRealtime();
            arr_b3 = arr_b2;
            goto label_47;
        }
        catch(SocketTimeoutException unused_ex) {
            throw new TimeoutError();
        }
        catch(UnknownHostException unused_ex) {
            throw new NetworkError();
        }
        catch(MalformedURLException malformedURLException0) {
            throw new RuntimeException("Bad URL " + request0.getUrl(), malformedURLException0);
        }
        catch(IOException iOException0) {
        }
        List list5 = list3;
        goto label_58;
        try {
        label_47:
            this.logSlowRequests(v2 - v, request0, arr_b3, v1);
            goto label_52;
        }
        catch(SocketTimeoutException unused_ex) {
            throw new TimeoutError();
        }
        catch(UnknownHostException unused_ex) {
            throw new NetworkError();
        }
        catch(MalformedURLException malformedURLException0) {
            throw new RuntimeException("Bad URL " + request0.getUrl(), malformedURLException0);
        }
        catch(IOException iOException0) {
        }
        list5 = list3;
        goto label_67;
    label_52:
        if(v1 < 200 || v1 > 299) {
            try {
                list5 = list3;
                throw new IOException();
            }
            catch(SocketTimeoutException unused_ex) {
                throw new TimeoutError();
            }
            catch(UnknownHostException unused_ex) {
                throw new NetworkError();
            }
            catch(MalformedURLException malformedURLException0) {
                throw new RuntimeException("Bad URL " + request0.getUrl(), malformedURLException0);
            }
            catch(IOException iOException0) {
            }
        }
        else {
            try {
                list5 = list3;
                v3 = SystemClock.elapsedRealtime();
                arr_b2 = arr_b3;
            }
            catch(SocketTimeoutException unused_ex) {
                throw new TimeoutError();
            }
            catch(UnknownHostException unused_ex) {
                throw new NetworkError();
            }
            catch(MalformedURLException malformedURLException0) {
                throw new RuntimeException("Bad URL " + request0.getUrl(), malformedURLException0);
            }
            catch(IOException iOException0) {
                goto label_67;
            }
            try {
                return new NetworkResponse(v1, arr_b2, false, v3 - v, list5);
            }
            catch(SocketTimeoutException unused_ex) {
                throw new TimeoutError();
            }
            catch(UnknownHostException unused_ex) {
                throw new NetworkError();
            }
            catch(MalformedURLException malformedURLException0) {
                throw new RuntimeException("Bad URL " + request0.getUrl(), malformedURLException0);
            }
            catch(IOException iOException0) {
            }
        label_58:
            arr_b3 = arr_b2;
        }
    label_67:
        arr_b = arr_b3;
        httpResponse0 = httpResponse1;
        list1 = list5;
    label_70:
        if(httpResponse0 == null) {
            throw new NoConnectionError(iOException0);
        }
        int v4 = httpResponse0.getStatusCode();
        VolleyLog.e("Unexpected response code %d for %s", new Object[]{v4, request0.getUrl()});
        if(arr_b == null) {
            throw new NetworkError();
        }
        NetworkResponse networkResponse0 = new NetworkResponse(v4, arr_b, false, SystemClock.elapsedRealtime() - v, list1);
        if(v4 == 401 || v4 == 403) {
            throw new AuthFailureError(networkResponse0);
        }
        if(v4 >= 400 && v4 <= 0x1F3) {
            throw new ClientError(networkResponse0);
        }
        throw new ServerError(networkResponse0);
    }
}

