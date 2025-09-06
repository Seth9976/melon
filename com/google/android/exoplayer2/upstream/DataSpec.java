package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import b3.Z;
import com.google.android.exoplayer2.util.Assertions;
import com.iloen.melon.utils.a;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import va.e;

public final class DataSpec {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpMethod {
    }

    public static final int FLAG_ALLOW_CACHE_FRAGMENTATION = 4;
    public static final int FLAG_ALLOW_GZIP = 1;
    public static final int FLAG_DONT_CACHE_IF_LENGTH_UNKNOWN = 2;
    public static final int HTTP_METHOD_GET = 1;
    public static final int HTTP_METHOD_HEAD = 3;
    public static final int HTTP_METHOD_POST = 2;
    public final long absoluteStreamPosition;
    public final int flags;
    public final byte[] httpBody;
    public final int httpMethod;
    public final Map httpRequestHeaders;
    public final String key;
    public final long length;
    public final long position;
    public final Uri uri;

    public DataSpec(Uri uri0) {
        this(uri0, 0);
    }

    public DataSpec(Uri uri0, int v) {
        this(uri0, 0L, -1L, null, v);
    }

    public DataSpec(Uri uri0, int v, byte[] arr_b, long v1, long v2, long v3, String s, int v4) {
        this(uri0, v, arr_b, v1, v2, v3, s, v4, Collections.EMPTY_MAP);
    }

    public DataSpec(Uri uri0, int v, byte[] arr_b, long v1, long v2, long v3, String s, int v4, Map map0) {
        boolean z = false;
        Assertions.checkArgument(Long.compare(v1, 0L) >= 0);
        Assertions.checkArgument(v2 >= 0L);
        if(v3 > 0L || v3 == -1L) {
            z = true;
        }
        Assertions.checkArgument(z);
        this.uri = uri0;
        this.httpMethod = v;
        if(arr_b == null || arr_b.length == 0) {
            arr_b = null;
        }
        this.httpBody = arr_b;
        this.absoluteStreamPosition = v1;
        this.position = v2;
        this.length = v3;
        this.key = s;
        this.flags = v4;
        this.httpRequestHeaders = Collections.unmodifiableMap(new HashMap(map0));
    }

    public DataSpec(Uri uri0, long v, long v1, long v2, String s, int v3) {
        this(uri0, null, v, v1, v2, s, v3);
    }

    public DataSpec(Uri uri0, long v, long v1, String s) {
        this(uri0, v, v, v1, s, 0);
    }

    public DataSpec(Uri uri0, long v, long v1, String s, int v2) {
        this(uri0, v, v, v1, s, v2);
    }

    public DataSpec(Uri uri0, long v, long v1, String s, int v2, Map map0) {
        this(uri0, 1, null, v, v, v1, s, v2, map0);
    }

    public DataSpec(Uri uri0, byte[] arr_b, long v, long v1, long v2, String s, int v3) {
        this(uri0, DataSpec.inferHttpMethod(arr_b), arr_b, v, v1, v2, s, v3);
    }

    public final String getHttpMethodString() {
        return DataSpec.getStringForHttpMethod(this.httpMethod);
    }

    public static String getStringForHttpMethod(int v) {
        switch(v) {
            case 1: {
                return "GET";
            }
            case 2: {
                return "POST";
            }
            case 3: {
                return "HEAD";
            }
            default: {
                throw new AssertionError(v);
            }
        }
    }

    private static int inferHttpMethod(byte[] arr_b) [...] // 潜在的解密器

    public boolean isFlagSet(int v) {
        return (this.flags & v) == v;
    }

    public DataSpec subrange(long v) {
        return this.subrange(v, (this.length == -1L ? -1L : this.length - v));
    }

    public DataSpec subrange(long v, long v1) {
        return v != 0L || this.length != v1 ? new DataSpec(this.uri, this.httpMethod, this.httpBody, this.absoluteStreamPosition + v, this.position + v, v1, this.key, this.flags, this.httpRequestHeaders) : this;
    }

    @Override
    public String toString() {
        String s = this.getHttpMethodString();
        String s1 = String.valueOf(this.uri);
        String s2 = Arrays.toString(this.httpBody);
        StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(s1.length() + Z.e(94, s), s2), this.key), "DataSpec[", s, " ", s1);
        e.g(stringBuilder0, ", ", s2, ", ");
        stringBuilder0.append(this.absoluteStreamPosition);
        a.s(this.position, ", ", ", ", stringBuilder0);
        stringBuilder0.append(this.length);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.key);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.flags);
        stringBuilder0.append("]");
        return stringBuilder0.toString();
    }

    public DataSpec withAdditionalHeaders(Map map0) {
        HashMap hashMap0 = new HashMap(this.httpRequestHeaders);
        hashMap0.putAll(map0);
        return new DataSpec(this.uri, this.httpMethod, this.httpBody, this.absoluteStreamPosition, this.position, this.length, this.key, this.flags, hashMap0);
    }

    public DataSpec withRequestHeaders(Map map0) {
        return new DataSpec(this.uri, this.httpMethod, this.httpBody, this.absoluteStreamPosition, this.position, this.length, this.key, this.flags, map0);
    }

    public DataSpec withUri(Uri uri0) {
        return new DataSpec(uri0, this.httpMethod, this.httpBody, this.absoluteStreamPosition, this.position, this.length, this.key, this.flags, this.httpRequestHeaders);
    }
}

