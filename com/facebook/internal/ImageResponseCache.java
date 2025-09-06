package com.facebook.internal;

import Tf.v;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001DB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001B\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\u000E\u001A\u0004\u0018\u00010\t2\u0006\u0010\r\u001A\u00020\fH\u0007¢\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\u0011\u001A\u00020\u00102\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0003R\u001F\u0010\u0017\u001A\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001AR\u0016\u0010\u001B\u001A\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lcom/facebook/internal/ImageResponseCache;", "", "<init>", "()V", "Lcom/facebook/internal/FileLruCache;", "getCache", "()Lcom/facebook/internal/FileLruCache;", "Landroid/net/Uri;", "uri", "Ljava/io/InputStream;", "getCachedImageStream", "(Landroid/net/Uri;)Ljava/io/InputStream;", "Ljava/net/HttpURLConnection;", "connection", "interceptAndCacheImageStream", "(Ljava/net/HttpURLConnection;)Ljava/io/InputStream;", "", "isCDNURL", "(Landroid/net/Uri;)Z", "Lie/H;", "clearCache", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "imageCache", "Lcom/facebook/internal/FileLruCache;", "BufferedHttpInputStream", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ImageResponseCache {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001B\b\u0000\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0005\u001A\u00020\u00048\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0005\u0010\u000B\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/ImageResponseCache$BufferedHttpInputStream;", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "stream", "Ljava/net/HttpURLConnection;", "connection", "<init>", "(Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V", "Lie/H;", "close", "()V", "Ljava/net/HttpURLConnection;", "getConnection", "()Ljava/net/HttpURLConnection;", "setConnection", "(Ljava/net/HttpURLConnection;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class BufferedHttpInputStream extends BufferedInputStream {
        @NotNull
        private HttpURLConnection connection;

        public BufferedHttpInputStream(@Nullable InputStream inputStream0, @NotNull HttpURLConnection httpURLConnection0) {
            q.g(httpURLConnection0, "connection");
            super(inputStream0, 0x2000);
            this.connection = httpURLConnection0;
        }

        @Override
        public void close() {
            super.close();
            Utility.disconnectQuietly(this.connection);
        }

        @NotNull
        public final HttpURLConnection getConnection() {
            return this.connection;
        }

        public final void setConnection(@NotNull HttpURLConnection httpURLConnection0) {
            q.g(httpURLConnection0, "<set-?>");
            this.connection = httpURLConnection0;
        }
    }

    @NotNull
    public static final ImageResponseCache INSTANCE;
    private static final String TAG;
    private static FileLruCache imageCache;

    static {
        ImageResponseCache.INSTANCE = new ImageResponseCache();
        ImageResponseCache.TAG = "ImageResponseCache";
    }

    public static final void clearCache() {
        try {
            ImageResponseCache.getCache().clearCache();
        }
        catch(IOException iOException0) {
            q.f("ImageResponseCache", "TAG");
            Logger.Companion.log(LoggingBehavior.CACHE, 5, "ImageResponseCache", "clearCache failed " + iOException0.getMessage());
        }
    }

    @NotNull
    public static final FileLruCache getCache() {
        synchronized(ImageResponseCache.class) {
            if(ImageResponseCache.imageCache == null) {
                q.f("ImageResponseCache", "TAG");
                ImageResponseCache.imageCache = new FileLruCache("ImageResponseCache", new Limits());
            }
            FileLruCache fileLruCache0 = ImageResponseCache.imageCache;
            if(fileLruCache0 != null) {
                return fileLruCache0;
            }
            q.m("imageCache");
        }
        throw null;
    }

    @Nullable
    public static final InputStream getCachedImageStream(@Nullable Uri uri0) {
        if(uri0 != null && ImageResponseCache.INSTANCE.isCDNURL(uri0)) {
            try {
                FileLruCache fileLruCache0 = ImageResponseCache.getCache();
                String s = uri0.toString();
                q.f(s, "uri.toString()");
                return FileLruCache.get$default(fileLruCache0, s, null, 2, null);
            }
            catch(IOException iOException0) {
                q.f("ImageResponseCache", "TAG");
                Logger.Companion.log(LoggingBehavior.CACHE, 5, "ImageResponseCache", iOException0.toString());
            }
        }
        return null;
    }

    public final String getTAG() {
        return "ImageResponseCache";
    }

    @Nullable
    public static final InputStream interceptAndCacheImageStream(@NotNull HttpURLConnection httpURLConnection0) {
        q.g(httpURLConnection0, "connection");
        if(httpURLConnection0.getResponseCode() == 200) {
            Uri uri0 = Uri.parse(httpURLConnection0.getURL().toString());
            InputStream inputStream0 = httpURLConnection0.getInputStream();
            try {
                if(ImageResponseCache.INSTANCE.isCDNURL(uri0)) {
                    FileLruCache fileLruCache0 = ImageResponseCache.getCache();
                    String s = uri0.toString();
                    q.f(s, "uri.toString()");
                    return fileLruCache0.interceptAndPut(s, new BufferedHttpInputStream(inputStream0, httpURLConnection0));
                }
            }
            catch(IOException unused_ex) {
            }
            return inputStream0;
        }
        return null;
    }

    private final boolean isCDNURL(Uri uri0) {
        if(uri0 != null) {
            String s = uri0.getHost();
            return s != null && (s.equals("fbcdn.net") || v.i0(s, ".fbcdn.net", false) || v.r0(s, "fbcdn", false) && v.i0(s, ".akamaihd.net", false));
        }
        return false;
    }
}

