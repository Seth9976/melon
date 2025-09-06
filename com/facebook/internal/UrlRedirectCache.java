package com.facebook.internal;

import Tf.a;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001B\u0010\t\u001A\u0004\u0018\u00010\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000E\u001A\u00020\r2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00072\b\u0010\f\u001A\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0003R\u0014\u0010\u0012\u001A\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0015\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/facebook/internal/UrlRedirectCache;", "", "<init>", "()V", "Lcom/facebook/internal/FileLruCache;", "getCache", "()Lcom/facebook/internal/FileLruCache;", "Landroid/net/Uri;", "uri", "getRedirectedUri", "(Landroid/net/Uri;)Landroid/net/Uri;", "fromUri", "toUri", "Lie/H;", "cacheUriRedirect", "(Landroid/net/Uri;Landroid/net/Uri;)V", "clearCache", "", "tag", "Ljava/lang/String;", "redirectContentTag", "urlRedirectFileLruCache", "Lcom/facebook/internal/FileLruCache;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class UrlRedirectCache {
    @NotNull
    public static final UrlRedirectCache INSTANCE;
    @NotNull
    private static final String redirectContentTag;
    @NotNull
    private static final String tag;
    @Nullable
    private static FileLruCache urlRedirectFileLruCache;

    static {
        UrlRedirectCache.INSTANCE = new UrlRedirectCache();
        String s = I.a.b(UrlRedirectCache.class).m();
        if(s == null) {
            s = "UrlRedirectCache";
        }
        UrlRedirectCache.tag = s;
        UrlRedirectCache.redirectContentTag = s + "_Redirect";
    }

    public static final void cacheUriRedirect(@Nullable Uri uri0, @Nullable Uri uri1) {
        OutputStream outputStream0;
        if(uri0 != null && uri1 != null) {
            try {
                outputStream0 = null;
                FileLruCache fileLruCache0 = UrlRedirectCache.getCache();
                String s = uri0.toString();
                q.f(s, "fromUri.toString()");
                outputStream0 = fileLruCache0.openPutStream(s, UrlRedirectCache.redirectContentTag);
                String s1 = uri1.toString();
                q.f(s1, "toUri.toString()");
                byte[] arr_b = s1.getBytes(a.a);
                q.f(arr_b, "this as java.lang.String).getBytes(charset)");
                outputStream0.write(arr_b);
            }
            catch(IOException iOException0) {
                Logger.Companion.log(LoggingBehavior.CACHE, 4, UrlRedirectCache.tag, "IOException when accessing cache: " + iOException0.getMessage());
            }
            finally {
                Utility.closeQuietly(outputStream0);
            }
        }
    }

    public static final void clearCache() {
        try {
            UrlRedirectCache.getCache().clearCache();
        }
        catch(IOException iOException0) {
            Logger.Companion.log(LoggingBehavior.CACHE, 5, UrlRedirectCache.tag, "clearCache failed " + iOException0.getMessage());
        }
    }

    @NotNull
    public static final FileLruCache getCache() {
        synchronized(UrlRedirectCache.class) {
            FileLruCache fileLruCache0 = UrlRedirectCache.urlRedirectFileLruCache;
            if(fileLruCache0 == null) {
                Limits fileLruCache$Limits0 = new Limits();
                fileLruCache0 = new FileLruCache(UrlRedirectCache.tag, fileLruCache$Limits0);
            }
            UrlRedirectCache.urlRedirectFileLruCache = fileLruCache0;
            return fileLruCache0;
        }
    }

    @Nullable
    public static final Uri getRedirectedUri(@Nullable Uri uri0) {
        Uri uri1;
        String s1;
        InputStreamReader inputStreamReader0;
        boolean z;
        InputStream inputStream0;
        Closeable closeable1;
        FileLruCache fileLruCache0;
        Closeable closeable0 = null;
        if(uri0 == null) {
            return null;
        }
        String s = uri0.toString();
        q.f(s, "uri.toString()");
        HashSet hashSet0 = new HashSet();
        hashSet0.add(s);
        try {
            fileLruCache0 = UrlRedirectCache.getCache();
            closeable1 = null;
            inputStream0 = fileLruCache0.get(s, UrlRedirectCache.redirectContentTag);
            z = false;
            goto label_14;
        }
        catch(IOException iOException0) {
            goto label_50;
        }
        catch(Throwable throwable0) {
        }
        Utility.closeQuietly(closeable0);
        throw throwable0;
    label_14:
        while(inputStream0 != null) {
            try {
                inputStreamReader0 = new InputStreamReader(inputStream0);
            }
            catch(IOException iOException0) {
                goto label_50;
            }
            catch(Throwable throwable0) {
                closeable0 = closeable1;
                Utility.closeQuietly(closeable0);
                throw throwable0;
            }
            try {
                char[] arr_c = new char[0x80];
                StringBuilder stringBuilder0 = new StringBuilder();
                for(int v = inputStreamReader0.read(arr_c, 0, 0x80); v > 0; v = inputStreamReader0.read(arr_c, 0, 0x80)) {
                    stringBuilder0.append(arr_c, 0, v);
                }
                Utility.closeQuietly(inputStreamReader0);
                s1 = stringBuilder0.toString();
                q.f(s1, "urlBuilder.toString()");
                if(hashSet0.contains(s1)) {
                    if(s1.equals(s)) {
                        closeable1 = inputStreamReader0;
                        z = true;
                        break;
                    }
                    Logger.Companion.log(LoggingBehavior.CACHE, 6, UrlRedirectCache.tag, "A loop detected in UrlRedirectCache");
                    goto label_32;
                }
                else {
                    goto label_34;
                }
                break;
            }
            catch(IOException iOException0) {
                closeable1 = inputStreamReader0;
                goto label_50;
            }
            catch(Throwable throwable0) {
                closeable0 = inputStreamReader0;
                Utility.closeQuietly(closeable0);
                throw throwable0;
            }
        label_32:
            Utility.closeQuietly(inputStreamReader0);
            return null;
            try {
            label_34:
                hashSet0.add(s1);
                inputStream0 = fileLruCache0.get(s1, UrlRedirectCache.redirectContentTag);
                s = s1;
                closeable1 = inputStreamReader0;
                z = true;
                continue;
            }
            catch(IOException iOException0) {
                closeable1 = inputStreamReader0;
                goto label_50;
            }
            catch(Throwable throwable0) {
                closeable0 = inputStreamReader0;
                Utility.closeQuietly(closeable0);
                throw throwable0;
            }
        }
        if(z) {
            try {
                uri1 = Uri.parse(s);
                goto label_56;
            }
            catch(IOException iOException0) {
                try {
                label_50:
                    Logger.Companion.log(LoggingBehavior.CACHE, 4, UrlRedirectCache.tag, "IOException when accessing cache: " + iOException0.getMessage());
                    goto label_58;
                }
                catch(Throwable throwable0) {
                }
                closeable0 = closeable1;
                Utility.closeQuietly(closeable0);
                throw throwable0;
            }
            catch(Throwable throwable0) {
                closeable0 = closeable1;
            }
            Utility.closeQuietly(closeable0);
            throw throwable0;
        label_56:
            Utility.closeQuietly(closeable1);
            return uri1;
        }
    label_58:
        Utility.closeQuietly(closeable1);
        return null;
    }
}

