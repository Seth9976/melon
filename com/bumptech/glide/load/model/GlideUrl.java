package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class GlideUrl implements Key {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~\'%;$";
    private volatile byte[] cacheKeyBytes;
    private int hashCode;
    private final Headers headers;
    private String safeStringUrl;
    private URL safeUrl;
    private final String stringUrl;
    private final URL url;

    public GlideUrl(String s) {
        this(s, Headers.DEFAULT);
    }

    public GlideUrl(String s, Headers headers0) {
        this.url = null;
        this.stringUrl = Preconditions.checkNotEmpty(s);
        this.headers = (Headers)Preconditions.checkNotNull(headers0);
    }

    public GlideUrl(URL uRL0) {
        this(uRL0, Headers.DEFAULT);
    }

    public GlideUrl(URL uRL0, Headers headers0) {
        this.url = (URL)Preconditions.checkNotNull(uRL0);
        this.stringUrl = null;
        this.headers = (Headers)Preconditions.checkNotNull(headers0);
    }

    // 去混淆评级： 低(30)
    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof GlideUrl && this.getCacheKey().equals(((GlideUrl)object0).getCacheKey()) && this.headers.equals(((GlideUrl)object0).headers);
    }

    public String getCacheKey() {
        return this.stringUrl == null ? ((URL)Preconditions.checkNotNull(this.url)).toString() : this.stringUrl;
    }

    private byte[] getCacheKeyBytes() {
        if(this.cacheKeyBytes == null) {
            this.cacheKeyBytes = this.getCacheKey().getBytes(Key.CHARSET);
        }
        return this.cacheKeyBytes;
    }

    public Map getHeaders() {
        return this.headers.getHeaders();
    }

    private String getSafeStringUrl() {
        if(TextUtils.isEmpty(this.safeStringUrl)) {
            this.safeStringUrl = Uri.encode((TextUtils.isEmpty(this.stringUrl) ? ((URL)Preconditions.checkNotNull(this.url)).toString() : this.stringUrl), "@#&=*+-_.,:!?()/~\'%;$");
        }
        return this.safeStringUrl;
    }

    private URL getSafeUrl() {
        if(this.safeUrl == null) {
            this.safeUrl = new URL(this.getSafeStringUrl());
        }
        return this.safeUrl;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        if(this.hashCode == 0) {
            int v = this.getCacheKey().hashCode();
            this.hashCode = this.headers.hashCode() + v * 0x1F;
        }
        return this.hashCode;
    }

    @Override
    public String toString() {
        return this.getCacheKey();
    }

    public String toStringUrl() {
        return this.getSafeStringUrl();
    }

    public URL toURL() {
        return this.getSafeUrl();
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        messageDigest0.update(this.getCacheKeyBytes());
    }
}

