package com.android.volley.toolbox;

import com.android.volley.Cache.Entry;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

public class HttpHeaderParser {
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String RFC1123_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";

    public static String formatEpochAsRfc1123(long v) {
        return HttpHeaderParser.newRfc1123Formatter().format(new Date(v));
    }

    private static SimpleDateFormat newRfc1123Formatter() {
        SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat0.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat0;
    }

    public static Entry parseCacheHeaders(NetworkResponse networkResponse0) {
        long v9;
        long v8;
        long v4;
        long v3;
        boolean z;
        long v = System.currentTimeMillis();
        Map map0 = networkResponse0.headers;
        String s = (String)map0.get("Date");
        long v1 = s == null ? 0L : HttpHeaderParser.parseDateAsEpoch(s);
        String s1 = (String)map0.get("Cache-Control");
        int v2 = 0;
        if(s1 == null) {
            z = false;
            v3 = 0L;
            v4 = 0L;
        }
        else {
            String[] arr_s = s1.split(",", 0);
            z = false;
            v3 = 0L;
            v4 = 0L;
            while(v2 < arr_s.length) {
                String s2 = arr_s[v2].trim();
                if(!s2.equals("no-cache") && !s2.equals("no-store")) {
                    if(s2.startsWith("max-age=")) {
                        try {
                            v3 = Long.parseLong(s2.substring(8));
                            ++v2;
                            continue;
                        label_17:
                            if(s2.startsWith("stale-while-revalidate=")) {
                                v4 = Long.parseLong(s2.substring(23));
                            }
                            else if(s2.equals("must-revalidate") || s2.equals("proxy-revalidate")) {
                                z = true;
                            }
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                    else {
                        goto label_17;
                    }
                    ++v2;
                    continue;
                }
                return null;
            }
            v2 = 1;
        }
        String s3 = (String)map0.get("Expires");
        long v5 = s3 == null ? 0L : HttpHeaderParser.parseDateAsEpoch(s3);
        String s4 = (String)map0.get("Last-Modified");
        long v6 = s4 == null ? 0L : HttpHeaderParser.parseDateAsEpoch(s4);
        String s5 = (String)map0.get("ETag");
        if(v2 == 0) {
            v9 = v1 <= 0L || v5 < v1 ? 0L : v5 - v1 + v;
            v8 = v9;
        }
        else {
            long v7 = v3 * 1000L + v;
            v8 = z ? v7 : v4 * 1000L + v7;
            v9 = v7;
        }
        Entry cache$Entry0 = new Entry();
        cache$Entry0.data = networkResponse0.data;
        cache$Entry0.etag = s5;
        cache$Entry0.softTtl = v9;
        cache$Entry0.ttl = v8;
        cache$Entry0.serverDate = v1;
        cache$Entry0.lastModified = v6;
        cache$Entry0.responseHeaders = map0;
        cache$Entry0.allResponseHeaders = networkResponse0.allHeaders;
        return cache$Entry0;
    }

    public static String parseCharset(Map map0) {
        return HttpHeaderParser.parseCharset(map0, "ISO-8859-1");
    }

    public static String parseCharset(Map map0, String s) {
        String s1 = (String)map0.get("Content-Type");
        if(s1 != null) {
            String[] arr_s = s1.split(";", 0);
            for(int v = 1; v < arr_s.length; ++v) {
                String[] arr_s1 = arr_s[v].trim().split("=", 0);
                if(arr_s1.length == 2 && arr_s1[0].equals("charset")) {
                    return arr_s1[1];
                }
            }
        }
        return s;
    }

    public static long parseDateAsEpoch(String s) {
        try {
            return HttpHeaderParser.newRfc1123Formatter().parse(s).getTime();
        }
        catch(ParseException parseException0) {
            VolleyLog.e(parseException0, "Unable to parse dateStr: %s, falling back to 0", new Object[]{s});
            return 0L;
        }
    }

    public static List toAllHeaderList(Map map0) {
        List list0 = new ArrayList(map0.size());
        for(Object object0: map0.entrySet()) {
            ((ArrayList)list0).add(new Header(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue())));
        }
        return list0;
    }

    public static Map toHeaderMap(List list0) {
        Map map0 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for(Object object0: list0) {
            ((TreeMap)map0).put(((Header)object0).getName(), ((Header)object0).getValue());
        }
        return map0;
    }
}

