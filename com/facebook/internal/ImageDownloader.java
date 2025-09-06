package com.facebook.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.session.q0;
import com.facebook.FacebookException;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0007\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u0004<=>?B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\f\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\f\u0010\bJ\u000F\u0010\r\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\r\u0010\u0003J\'\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0019\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\b\u0019\u0010\u001AJ9\u0010!\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u000E2\u000E\u0010\u001D\u001A\n\u0018\u00010\u001Bj\u0004\u0018\u0001`\u001C2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\u0006\u0010 \u001A\u00020\tH\u0002\u00A2\u0006\u0004\b!\u0010\"J\u001F\u0010#\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b#\u0010$J\u0017\u0010%\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b%\u0010&J\u0019\u0010(\u001A\u0004\u0018\u00010\'2\u0006\u0010\u000F\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b(\u0010)J\u001B\u0010+\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\'0*H\u0007\u00A2\u0006\u0004\b+\u0010,R\u0014\u0010.\u001A\u00020-8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001A\u00020-8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b0\u0010/R\u001E\u00102\u001A\u0004\u0018\u0001018B@\u0002X\u0082\u000E\u00A2\u0006\f\n\u0004\b2\u00103\u001A\u0004\b4\u00105R\u0014\u00106\u001A\u00020\u00158\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001A\u00020\u00158\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b8\u00107R \u0010:\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\'098\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b:\u0010;\u00A8\u0006@"}, d2 = {"Lcom/facebook/internal/ImageDownloader;", "", "<init>", "()V", "Lcom/facebook/internal/ImageRequest;", "request", "Lie/H;", "downloadAsync", "(Lcom/facebook/internal/ImageRequest;)V", "", "cancelRequest", "(Lcom/facebook/internal/ImageRequest;)Z", "prioritizeRequest", "clearCache", "Lcom/facebook/internal/ImageDownloader$RequestKey;", "key", "allowCachedRedirects", "enqueueCacheRead", "(Lcom/facebook/internal/ImageRequest;Lcom/facebook/internal/ImageDownloader$RequestKey;Z)V", "enqueueDownload", "(Lcom/facebook/internal/ImageRequest;Lcom/facebook/internal/ImageDownloader$RequestKey;)V", "Lcom/facebook/internal/WorkQueue;", "workQueue", "Ljava/lang/Runnable;", "workItem", "enqueueRequest", "(Lcom/facebook/internal/ImageRequest;Lcom/facebook/internal/ImageDownloader$RequestKey;Lcom/facebook/internal/WorkQueue;Ljava/lang/Runnable;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Landroid/graphics/Bitmap;", "bitmap", "isCachedRedirect", "issueResponse", "(Lcom/facebook/internal/ImageDownloader$RequestKey;Ljava/lang/Exception;Landroid/graphics/Bitmap;Z)V", "readFromCache", "(Lcom/facebook/internal/ImageDownloader$RequestKey;Z)V", "download", "(Lcom/facebook/internal/ImageDownloader$RequestKey;)V", "Lcom/facebook/internal/ImageDownloader$DownloaderContext;", "removePendingRequest", "(Lcom/facebook/internal/ImageDownloader$RequestKey;)Lcom/facebook/internal/ImageDownloader$DownloaderContext;", "", "getPendingRequests", "()Ljava/util/Map;", "", "DOWNLOAD_QUEUE_MAX_CONCURRENT", "I", "CACHE_READ_QUEUE_MAX_CONCURRENT", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "downloadQueue", "Lcom/facebook/internal/WorkQueue;", "cacheReadQueue", "", "pendingRequests", "Ljava/util/Map;", "CacheReadWorkItem", "DownloadImageWorkItem", "DownloaderContext", "RequestKey", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ImageDownloader {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000BR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\f¨\u0006\r"}, d2 = {"Lcom/facebook/internal/ImageDownloader$CacheReadWorkItem;", "Ljava/lang/Runnable;", "Lcom/facebook/internal/ImageDownloader$RequestKey;", "key", "", "allowCachedRedirects", "<init>", "(Lcom/facebook/internal/ImageDownloader$RequestKey;Z)V", "Lie/H;", "run", "()V", "Lcom/facebook/internal/ImageDownloader$RequestKey;", "Z", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class CacheReadWorkItem implements Runnable {
        private final boolean allowCachedRedirects;
        @NotNull
        private final RequestKey key;

        public CacheReadWorkItem(@NotNull RequestKey imageDownloader$RequestKey0, boolean z) {
            q.g(imageDownloader$RequestKey0, "key");
            super();
            this.key = imageDownloader$RequestKey0;
            this.allowCachedRedirects = z;
        }

        @Override
        public void run() {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                ImageDownloader.INSTANCE.readFromCache(this.key, this.allowCachedRedirects);
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\t¨\u0006\n"}, d2 = {"Lcom/facebook/internal/ImageDownloader$DownloadImageWorkItem;", "Ljava/lang/Runnable;", "Lcom/facebook/internal/ImageDownloader$RequestKey;", "key", "<init>", "(Lcom/facebook/internal/ImageDownloader$RequestKey;)V", "Lie/H;", "run", "()V", "Lcom/facebook/internal/ImageDownloader$RequestKey;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class DownloadImageWorkItem implements Runnable {
        @NotNull
        private final RequestKey key;

        public DownloadImageWorkItem(@NotNull RequestKey imageDownloader$RequestKey0) {
            q.g(imageDownloader$RequestKey0, "key");
            super();
            this.key = imageDownloader$RequestKey0;
        }

        @Override
        public void run() {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                ImageDownloader.INSTANCE.download(this.key);
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\u0004R\u001C\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/ImageDownloader$DownloaderContext;", "", "request", "Lcom/facebook/internal/ImageRequest;", "(Lcom/facebook/internal/ImageRequest;)V", "isCancelled", "", "()Z", "setCancelled", "(Z)V", "getRequest", "()Lcom/facebook/internal/ImageRequest;", "setRequest", "workItem", "Lcom/facebook/internal/WorkQueue$WorkItem;", "getWorkItem", "()Lcom/facebook/internal/WorkQueue$WorkItem;", "setWorkItem", "(Lcom/facebook/internal/WorkQueue$WorkItem;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class DownloaderContext {
        private boolean isCancelled;
        @NotNull
        private ImageRequest request;
        @Nullable
        private WorkItem workItem;

        public DownloaderContext(@NotNull ImageRequest imageRequest0) {
            q.g(imageRequest0, "request");
            super();
            this.request = imageRequest0;
        }

        @NotNull
        public final ImageRequest getRequest() {
            return this.request;
        }

        @Nullable
        public final WorkItem getWorkItem() {
            return this.workItem;
        }

        public final boolean isCancelled() {
            return this.isCancelled;
        }

        public final void setCancelled(boolean z) {
            this.isCancelled = z;
        }

        public final void setRequest(@NotNull ImageRequest imageRequest0) {
            q.g(imageRequest0, "<set-?>");
            this.request = imageRequest0;
        }

        public final void setWorkItem(@Nullable WorkItem workQueue$WorkItem0) {
            this.workItem = workQueue$WorkItem0;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u001A\u0010\u0004\u001A\u00020\u0001X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/facebook/internal/ImageDownloader$RequestKey;", "", "uri", "Landroid/net/Uri;", "tag", "(Landroid/net/Uri;Ljava/lang/Object;)V", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "equals", "", "o", "hashCode", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class RequestKey {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/ImageDownloader$RequestKey$Companion;", "", "()V", "HASH_MULTIPLIER", "", "HASH_SEED", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final Companion Companion = null;
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        @NotNull
        private Object tag;
        @NotNull
        private Uri uri;

        static {
            RequestKey.Companion = new Companion(null);
        }

        public RequestKey(@NotNull Uri uri0, @NotNull Object object0) {
            q.g(uri0, "uri");
            q.g(object0, "tag");
            super();
            this.uri = uri0;
            this.tag = object0;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            return object0 != null && object0 instanceof RequestKey && ((RequestKey)object0).uri == this.uri && ((RequestKey)object0).tag == this.tag;
        }

        @NotNull
        public final Object getTag() {
            return this.tag;
        }

        @NotNull
        public final Uri getUri() {
            return this.uri;
        }

        @Override
        public int hashCode() {
            return this.tag.hashCode() + (this.uri.hashCode() + 1073) * 37;
        }

        public final void setTag(@NotNull Object object0) {
            q.g(object0, "<set-?>");
            this.tag = object0;
        }

        public final void setUri(@NotNull Uri uri0) {
            q.g(uri0, "<set-?>");
            this.uri = uri0;
        }
    }

    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    @NotNull
    public static final ImageDownloader INSTANCE;
    @NotNull
    private static final WorkQueue cacheReadQueue;
    @NotNull
    private static final WorkQueue downloadQueue;
    @Nullable
    private static Handler handler;
    @NotNull
    private static final Map pendingRequests;

    static {
        ImageDownloader.INSTANCE = new ImageDownloader();
        ImageDownloader.downloadQueue = new WorkQueue(8, null, 2, null);
        ImageDownloader.cacheReadQueue = new WorkQueue(2, null, 2, null);
        ImageDownloader.pendingRequests = new HashMap();
    }

    public static void a(ImageRequest imageRequest0, Exception exception0, boolean z, Bitmap bitmap0, Callback imageRequest$Callback0) {
        ImageDownloader.issueResponse$lambda$4(imageRequest0, exception0, z, bitmap0, imageRequest$Callback0);
    }

    public static final boolean cancelRequest(@NotNull ImageRequest imageRequest0) {
        boolean z;
        q.g(imageRequest0, "request");
        RequestKey imageDownloader$RequestKey0 = new RequestKey(imageRequest0.getImageUri(), imageRequest0.getCallerTag());
        Map map0 = ImageDownloader.pendingRequests;
        synchronized(map0) {
            DownloaderContext imageDownloader$DownloaderContext0 = (DownloaderContext)map0.get(imageDownloader$RequestKey0);
            if(imageDownloader$DownloaderContext0 == null) {
                z = false;
            }
            else {
                WorkItem workQueue$WorkItem0 = imageDownloader$DownloaderContext0.getWorkItem();
                z = true;
                if(workQueue$WorkItem0 == null || !workQueue$WorkItem0.cancel()) {
                    imageDownloader$DownloaderContext0.setCancelled(true);
                }
                else {
                    map0.remove(imageDownloader$RequestKey0);
                }
            }
            return z;
        }
    }

    public static final void clearCache() {
        ImageResponseCache.clearCache();
        UrlRedirectCache.clearCache();
    }

    private final void download(RequestKey imageDownloader$RequestKey0) {
        Bitmap bitmap0;
        IOException iOException1;
        HttpURLConnection httpURLConnection0;
        boolean z;
        Closeable closeable0 = null;
        try {
            z = true;
            URLConnection uRLConnection0 = new URL(imageDownloader$RequestKey0.getUri().toString()).openConnection();
            q.e(uRLConnection0, "null cannot be cast to non-null type java.net.HttpURLConnection");
            httpURLConnection0 = null;
            httpURLConnection0 = (HttpURLConnection)uRLConnection0;
            goto label_11;
        }
        catch(IOException iOException0) {
            httpURLConnection0 = null;
            InputStream inputStream0 = null;
            Utility.closeQuietly(inputStream0);
            Utility.disconnectQuietly(httpURLConnection0);
            iOException1 = iOException0;
            goto label_68;
            try {
            label_11:
                httpURLConnection0.setInstanceFollowRedirects(false);
                switch(httpURLConnection0.getResponseCode()) {
                    case 200: {
                        inputStream0 = ImageResponseCache.interceptAndCacheImageStream(httpURLConnection0);
                        bitmap0 = BitmapFactory.decodeStream(inputStream0);
                        iOException1 = null;
                        closeable0 = inputStream0;
                        goto label_65;
                    }
                    case 301: 
                    case 302: {
                        goto label_42;
                    }
                    default: {
                        inputStream0 = httpURLConnection0.getErrorStream();
                    }
                }
            }
            catch(IOException iOException0) {
                goto label_56;
            }
            catch(Throwable throwable0) {
                Utility.closeQuietly(closeable0);
                Utility.disconnectQuietly(httpURLConnection0);
                throw throwable0;
            }
            try {
                StringBuilder stringBuilder0 = new StringBuilder();
                if(inputStream0 == null) {
                    stringBuilder0.append("Unexpected error while downloading an image.");
                }
                else {
                    InputStreamReader inputStreamReader0 = new InputStreamReader(inputStream0);
                    char[] arr_c = new char[0x80];
                    int v;
                    while((v = inputStreamReader0.read(arr_c, 0, 0x80)) > 0) {
                        stringBuilder0.append(arr_c, 0, v);
                    }
                    Utility.closeQuietly(inputStreamReader0);
                }
                iOException1 = new FacebookException(stringBuilder0.toString());
                bitmap0 = null;
                closeable0 = inputStream0;
                goto label_65;
            }
            catch(IOException iOException0) {
                Utility.closeQuietly(inputStream0);
                Utility.disconnectQuietly(httpURLConnection0);
                iOException1 = iOException0;
                goto label_68;
            }
            catch(Throwable throwable0) {
                closeable0 = inputStream0;
                Utility.closeQuietly(closeable0);
                Utility.disconnectQuietly(httpURLConnection0);
                throw throwable0;
            }
            try {
                inputStream0 = ImageResponseCache.interceptAndCacheImageStream(httpURLConnection0);
                bitmap0 = BitmapFactory.decodeStream(inputStream0);
                iOException1 = null;
                closeable0 = inputStream0;
                goto label_65;
            }
            catch(IOException iOException0) {
            }
            catch(Throwable throwable0) {
                Utility.closeQuietly(closeable0);
                Utility.disconnectQuietly(httpURLConnection0);
                throw throwable0;
            }
            goto label_56;
            try {
                bitmap0 = BitmapFactory.decodeStream(inputStream0);
                iOException1 = null;
                closeable0 = inputStream0;
                goto label_65;
            }
            catch(IOException iOException0) {
                Utility.closeQuietly(inputStream0);
                Utility.disconnectQuietly(httpURLConnection0);
                iOException1 = iOException0;
                goto label_68;
            }
            catch(Throwable throwable0) {
                closeable0 = inputStream0;
                Utility.closeQuietly(closeable0);
                Utility.disconnectQuietly(httpURLConnection0);
                throw throwable0;
            }
            closeable0 = inputStream0;
            goto label_65;
            try {
            label_42:
                String s = httpURLConnection0.getHeaderField("location");
                if(!Utility.isNullOrEmpty(s)) {
                    Uri uri0 = Uri.parse(s);
                    UrlRedirectCache.cacheUriRedirect(imageDownloader$RequestKey0.getUri(), uri0);
                    DownloaderContext imageDownloader$DownloaderContext0 = this.removePendingRequest(imageDownloader$RequestKey0);
                    if(imageDownloader$DownloaderContext0 != null && !imageDownloader$DownloaderContext0.isCancelled()) {
                        q.f(uri0, "redirectUri");
                        this.enqueueCacheRead(imageDownloader$DownloaderContext0.getRequest(), new RequestKey(uri0, imageDownloader$RequestKey0.getTag()), false);
                    }
                }
                z = false;
                bitmap0 = null;
                iOException1 = null;
                goto label_65;
            }
            catch(IOException iOException0) {
            }
            catch(Throwable throwable0) {
                Utility.closeQuietly(closeable0);
                Utility.disconnectQuietly(httpURLConnection0);
                throw throwable0;
            }
            z = false;
        label_56:
            inputStream0 = null;
            Utility.closeQuietly(inputStream0);
            Utility.disconnectQuietly(httpURLConnection0);
            iOException1 = iOException0;
            goto label_68;
        }
        catch(Throwable throwable0) {
        }
        Utility.closeQuietly(closeable0);
        Utility.disconnectQuietly(httpURLConnection0);
        throw throwable0;
    label_65:
        Utility.closeQuietly(closeable0);
        Utility.disconnectQuietly(httpURLConnection0);
        closeable0 = bitmap0;
    label_68:
        if(z) {
            this.issueResponse(imageDownloader$RequestKey0, iOException1, ((Bitmap)closeable0), false);
        }
    }

    public static final void downloadAsync(@Nullable ImageRequest imageRequest0) {
        if(imageRequest0 == null) {
            return;
        }
        RequestKey imageDownloader$RequestKey0 = new RequestKey(imageRequest0.getImageUri(), imageRequest0.getCallerTag());
        Map map0 = ImageDownloader.pendingRequests;
        synchronized(map0) {
            DownloaderContext imageDownloader$DownloaderContext0 = (DownloaderContext)map0.get(imageDownloader$RequestKey0);
            if(imageDownloader$DownloaderContext0 == null) {
                ImageDownloader.INSTANCE.enqueueCacheRead(imageRequest0, imageDownloader$RequestKey0, imageRequest0.isCachedRedirectAllowed());
            }
            else {
                imageDownloader$DownloaderContext0.setRequest(imageRequest0);
                imageDownloader$DownloaderContext0.setCancelled(false);
                WorkItem workQueue$WorkItem0 = imageDownloader$DownloaderContext0.getWorkItem();
                if(workQueue$WorkItem0 != null) {
                    workQueue$WorkItem0.moveToFront();
                }
            }
        }
    }

    private final void enqueueCacheRead(ImageRequest imageRequest0, RequestKey imageDownloader$RequestKey0, boolean z) {
        CacheReadWorkItem imageDownloader$CacheReadWorkItem0 = new CacheReadWorkItem(imageDownloader$RequestKey0, z);
        this.enqueueRequest(imageRequest0, imageDownloader$RequestKey0, ImageDownloader.cacheReadQueue, imageDownloader$CacheReadWorkItem0);
    }

    private final void enqueueDownload(ImageRequest imageRequest0, RequestKey imageDownloader$RequestKey0) {
        DownloadImageWorkItem imageDownloader$DownloadImageWorkItem0 = new DownloadImageWorkItem(imageDownloader$RequestKey0);
        this.enqueueRequest(imageRequest0, imageDownloader$RequestKey0, ImageDownloader.downloadQueue, imageDownloader$DownloadImageWorkItem0);
    }

    private final void enqueueRequest(ImageRequest imageRequest0, RequestKey imageDownloader$RequestKey0, WorkQueue workQueue0, Runnable runnable0) {
        synchronized(ImageDownloader.pendingRequests) {
            DownloaderContext imageDownloader$DownloaderContext0 = new DownloaderContext(imageRequest0);
            ImageDownloader.pendingRequests.put(imageDownloader$RequestKey0, imageDownloader$DownloaderContext0);
            imageDownloader$DownloaderContext0.setWorkItem(WorkQueue.addActiveWorkItem$default(workQueue0, runnable0, false, 2, null));
        }
    }

    private final Handler getHandler() {
        synchronized(this) {
            if(ImageDownloader.handler == null) {
                ImageDownloader.handler = new Handler(Looper.getMainLooper());
            }
            return ImageDownloader.handler;
        }
    }

    @NotNull
    public final Map getPendingRequests() {
        return ImageDownloader.pendingRequests;
    }

    private final void issueResponse(RequestKey imageDownloader$RequestKey0, Exception exception0, Bitmap bitmap0, boolean z) {
        DownloaderContext imageDownloader$DownloaderContext0 = this.removePendingRequest(imageDownloader$RequestKey0);
        if(imageDownloader$DownloaderContext0 != null && !imageDownloader$DownloaderContext0.isCancelled()) {
            ImageRequest imageRequest0 = imageDownloader$DownloaderContext0.getRequest();
            Callback imageRequest$Callback0 = imageRequest0 == null ? null : imageRequest0.getCallback();
            if(imageRequest$Callback0 != null) {
                Handler handler0 = this.getHandler();
                if(handler0 != null) {
                    handler0.post(new q0(imageRequest0, exception0, z, bitmap0, imageRequest$Callback0));
                }
            }
        }
    }

    private static final void issueResponse$lambda$4(ImageRequest imageRequest0, Exception exception0, boolean z, Bitmap bitmap0, Callback imageRequest$Callback0) {
        q.g(imageRequest0, "$request");
        imageRequest$Callback0.onCompleted(new ImageResponse(imageRequest0, exception0, z, bitmap0));
    }

    public static final void prioritizeRequest(@NotNull ImageRequest imageRequest0) {
        q.g(imageRequest0, "request");
        RequestKey imageDownloader$RequestKey0 = new RequestKey(imageRequest0.getImageUri(), imageRequest0.getCallerTag());
        Map map0 = ImageDownloader.pendingRequests;
        synchronized(map0) {
            DownloaderContext imageDownloader$DownloaderContext0 = (DownloaderContext)map0.get(imageDownloader$RequestKey0);
            if(imageDownloader$DownloaderContext0 != null) {
                WorkItem workQueue$WorkItem0 = imageDownloader$DownloaderContext0.getWorkItem();
                if(workQueue$WorkItem0 != null) {
                    workQueue$WorkItem0.moveToFront();
                }
            }
        }
    }

    private final void readFromCache(RequestKey imageDownloader$RequestKey0, boolean z) {
        InputStream inputStream0;
        ImageRequest imageRequest0 = null;
        boolean z1 = false;
        if(z) {
            Uri uri0 = UrlRedirectCache.getRedirectedUri(imageDownloader$RequestKey0.getUri());
            if(uri0 == null) {
                inputStream0 = null;
            }
            else {
                inputStream0 = ImageResponseCache.getCachedImageStream(uri0);
                if(inputStream0 != null) {
                    z1 = true;
                }
            }
        }
        else {
            inputStream0 = null;
        }
        if(!z1) {
            inputStream0 = ImageResponseCache.getCachedImageStream(imageDownloader$RequestKey0.getUri());
        }
        if(inputStream0 != null) {
            Bitmap bitmap0 = BitmapFactory.decodeStream(inputStream0);
            Utility.closeQuietly(inputStream0);
            this.issueResponse(imageDownloader$RequestKey0, null, bitmap0, z1);
            return;
        }
        DownloaderContext imageDownloader$DownloaderContext0 = this.removePendingRequest(imageDownloader$RequestKey0);
        if(imageDownloader$DownloaderContext0 != null) {
            imageRequest0 = imageDownloader$DownloaderContext0.getRequest();
        }
        if(imageDownloader$DownloaderContext0 != null && !imageDownloader$DownloaderContext0.isCancelled() && imageRequest0 != null) {
            this.enqueueDownload(imageRequest0, imageDownloader$RequestKey0);
        }
    }

    private final DownloaderContext removePendingRequest(RequestKey imageDownloader$RequestKey0) {
        synchronized(ImageDownloader.pendingRequests) {
            return (DownloaderContext)ImageDownloader.pendingRequests.remove(imageDownloader$RequestKey0);
        }
    }
}

