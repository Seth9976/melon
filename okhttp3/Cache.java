package okhttp3;

import Tf.o;
import Tf.v;
import d8.d;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import je.w;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache.Editor;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010)\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0007\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0004ONPQB!\b\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u00A2\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\t\u0010\u000BJ\u0019\u0010\u0011\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\r\u001A\u00020\fH\u0000\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0019\u0010\u0016\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001A\u00020\u000EH\u0000\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001A\u001A\u00020\u00172\u0006\u0010\r\u001A\u00020\fH\u0000\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001F\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\u000EH\u0000\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\r\u0010 \u001A\u00020\u0017\u00A2\u0006\u0004\b \u0010!J\r\u0010\"\u001A\u00020\u0017\u00A2\u0006\u0004\b\"\u0010!J\r\u0010#\u001A\u00020\u0017\u00A2\u0006\u0004\b#\u0010!J\u0013\u0010&\u001A\b\u0012\u0004\u0012\u00020%0$\u00A2\u0006\u0004\b&\u0010\'J\r\u0010)\u001A\u00020(\u00A2\u0006\u0004\b)\u0010*J\r\u0010+\u001A\u00020(\u00A2\u0006\u0004\b+\u0010*J\r\u0010,\u001A\u00020\u0005\u00A2\u0006\u0004\b,\u0010-J\r\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0006\u0010-J\u000F\u0010.\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b.\u0010!J\u000F\u0010/\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b/\u0010!J\u000F\u0010\u0004\u001A\u00020\u0003H\u0007\u00A2\u0006\u0004\b0\u00101J\u0017\u00106\u001A\u00020\u00172\u0006\u00103\u001A\u000202H\u0000\u00A2\u0006\u0004\b4\u00105J\u000F\u00108\u001A\u00020\u0017H\u0000\u00A2\u0006\u0004\b7\u0010!J\r\u00109\u001A\u00020(\u00A2\u0006\u0004\b9\u0010*J\r\u0010:\u001A\u00020(\u00A2\u0006\u0004\b:\u0010*J\r\u0010;\u001A\u00020(\u00A2\u0006\u0004\b;\u0010*J\u001D\u0010?\u001A\u00020\u00172\f\u0010>\u001A\b\u0018\u00010<R\u00020=H\u0002\u00A2\u0006\u0004\b?\u0010@R\u001A\u0010A\u001A\u00020=8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\bA\u0010B\u001A\u0004\bC\u0010DR\"\u0010+\u001A\u00020(8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b+\u0010E\u001A\u0004\bF\u0010*\"\u0004\bG\u0010HR\"\u0010)\u001A\u00020(8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b)\u0010E\u001A\u0004\bI\u0010*\"\u0004\bJ\u0010HR\u0016\u00109\u001A\u00020(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b9\u0010ER\u0016\u0010:\u001A\u00020(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010ER\u0016\u0010;\u001A\u00020(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b;\u0010ER\u0011\u0010L\u001A\u00020K8F\u00A2\u0006\u0006\u001A\u0004\bL\u0010MR\u0011\u0010\u0004\u001A\u00020\u00038G\u00A2\u0006\u0006\u001A\u0004\b\u0004\u00101\u00A8\u0006R"}, d2 = {"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Ljava/io/File;", "directory", "", "maxSize", "Lokhttp3/internal/io/FileSystem;", "fileSystem", "<init>", "(Ljava/io/File;JLokhttp3/internal/io/FileSystem;)V", "(Ljava/io/File;J)V", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", "get$okhttp", "(Lokhttp3/Request;)Lokhttp3/Response;", "get", "response", "Lokhttp3/internal/cache/CacheRequest;", "put$okhttp", "(Lokhttp3/Response;)Lokhttp3/internal/cache/CacheRequest;", "put", "Lie/H;", "remove$okhttp", "(Lokhttp3/Request;)V", "remove", "cached", "network", "update$okhttp", "(Lokhttp3/Response;Lokhttp3/Response;)V", "update", "initialize", "()V", "delete", "evictAll", "", "", "urls", "()Ljava/util/Iterator;", "", "writeAbortCount", "()I", "writeSuccessCount", "size", "()J", "flush", "close", "-deprecated_directory", "()Ljava/io/File;", "Lokhttp3/internal/cache/CacheStrategy;", "cacheStrategy", "trackResponse$okhttp", "(Lokhttp3/internal/cache/CacheStrategy;)V", "trackResponse", "trackConditionalCacheHit$okhttp", "trackConditionalCacheHit", "networkCount", "hitCount", "requestCount", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "abortQuietly", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "cache", "Lokhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "I", "getWriteSuccessCount$okhttp", "setWriteSuccessCount$okhttp", "(I)V", "getWriteAbortCount$okhttp", "setWriteAbortCount$okhttp", "", "isClosed", "()Z", "Companion", "CacheResponseBody", "Entry", "RealCacheRequest", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Cache implements Closeable, Flushable {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001A\u00060\u0003R\u00020\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0007\u001A\u00020\rH\u0016J\n\u0010\u0005\u001A\u0004\u0018\u00010\u000EH\u0016J\b\u0010\u000F\u001A\u00020\nH\u0016R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001A\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0010"}, d2 = {"Lokhttp3/Cache$CacheResponseBody;", "Lokhttp3/ResponseBody;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "contentType", "", "contentLength", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V", "bodySource", "Lokio/BufferedSource;", "getSnapshot", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "", "Lokhttp3/MediaType;", "source", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class CacheResponseBody extends ResponseBody {
        @NotNull
        private final BufferedSource bodySource;
        @Nullable
        private final String contentLength;
        @Nullable
        private final String contentType;
        @NotNull
        private final Snapshot snapshot;

        public CacheResponseBody(@NotNull Snapshot diskLruCache$Snapshot0, @Nullable String s, @Nullable String s1) {
            q.g(diskLruCache$Snapshot0, "snapshot");
            super();
            this.snapshot = diskLruCache$Snapshot0;
            this.contentType = s;
            this.contentLength = s1;
            this.bodySource = Okio.buffer(new ForwardingSource(this) {
                @Override  // okio.ForwardingSource
                public void close() {
                    CacheResponseBody.this.getSnapshot().close();
                    super.close();
                }
            });
        }

        @Override  // okhttp3.ResponseBody
        public long contentLength() {
            return this.contentLength == null ? -1L : Util.toLongOrDefault(this.contentLength, -1L);
        }

        @Override  // okhttp3.ResponseBody
        @Nullable
        public MediaType contentType() {
            return this.contentType == null ? null : MediaType.Companion.parse(this.contentType);
        }

        @NotNull
        public final Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override  // okhttp3.ResponseBody
        @NotNull
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007J\u0015\u0010\f\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u000EH\u0000¢\u0006\u0002\b\u000FJ\u0018\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0011H\u0002J\u001E\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0019\u001A\u00020\u001AJ\n\u0010\u001B\u001A\u00020\u0015*\u00020\u0017J\u0012\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\t0\u001D*\u00020\u0011H\u0002J\n\u0010\u0010\u001A\u00020\u0011*\u00020\u0017R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2 = {"Lokhttp3/Cache$Companion;", "", "()V", "ENTRY_BODY", "", "ENTRY_COUNT", "ENTRY_METADATA", "VERSION", "key", "", "url", "Lokhttp3/HttpUrl;", "readInt", "source", "Lokio/BufferedSource;", "readInt$okhttp", "varyHeaders", "Lokhttp3/Headers;", "requestHeaders", "responseHeaders", "varyMatches", "", "cachedResponse", "Lokhttp3/Response;", "cachedRequest", "newRequest", "Lokhttp3/Request;", "hasVaryAll", "varyFields", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final boolean hasVaryAll(@NotNull Response response0) {
            q.g(response0, "<this>");
            return this.varyFields(response0.headers()).contains("*");
        }

        @NotNull
        public final String key(@NotNull HttpUrl httpUrl0) {
            q.g(httpUrl0, "url");
            return ByteString.Companion.encodeUtf8(httpUrl0.toString()).md5().hex();
        }

        public final int readInt$okhttp(@NotNull BufferedSource bufferedSource0) {
            q.g(bufferedSource0, "source");
            try {
                long v = bufferedSource0.readDecimalLong();
                String s = bufferedSource0.readUtf8LineStrict();
                if(v < 0L || v > 0x7FFFFFFFL || s.length() > 0) {
                    throw new IOException("expected an int but was \"" + v + s + '\"');
                }
                return (int)v;
            }
            catch(NumberFormatException numberFormatException0) {
            }
            throw new IOException(numberFormatException0.getMessage());
        }

        private final Set varyFields(Headers headers0) {
            int v = headers0.size();
            Set set0 = null;
            for(int v1 = 0; v1 < v; ++v1) {
                if("Vary".equalsIgnoreCase(headers0.name(v1))) {
                    String s = headers0.value(v1);
                    if(set0 == null) {
                        v.k0();
                        set0 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                    }
                    for(Object object0: o.S0(s, new char[]{','})) {
                        set0.add(o.e1(((String)object0)).toString());
                    }
                }
            }
            return set0 == null ? y.a : set0;
        }

        private final Headers varyHeaders(Headers headers0, Headers headers1) {
            Set set0 = this.varyFields(headers1);
            if(set0.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Builder headers$Builder0 = new Builder();
            int v = headers0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                String s = headers0.name(v1);
                if(set0.contains(s)) {
                    headers$Builder0.add(s, headers0.value(v1));
                }
            }
            return headers$Builder0.build();
        }

        @NotNull
        public final Headers varyHeaders(@NotNull Response response0) {
            q.g(response0, "<this>");
            Response response1 = response0.networkResponse();
            q.d(response1);
            return this.varyHeaders(response1.request().headers(), response0.headers());
        }

        public final boolean varyMatches(@NotNull Response response0, @NotNull Headers headers0, @NotNull Request request0) {
            q.g(response0, "cachedResponse");
            q.g(headers0, "cachedRequest");
            q.g(request0, "newRequest");
            Iterable iterable0 = this.varyFields(response0.headers());
            if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
                return true;
            }
            for(Object object0: iterable0) {
                if(!q.b(headers0.values(((String)object0)), request0.headers(((String)object0)))) {
                    return false;
                }
                if(false) {
                    break;
                }
            }
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\u0004\u0010\bJ\u001D\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ%\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\u000F2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001A\u00020\u00122\n\u0010\u0017\u001A\u00060\u0015R\u00020\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001D\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0019\u0010\u0007\u001A\u00020\u00062\n\u0010 \u001A\u00060\u001FR\u00020\u0016\u00A2\u0006\u0004\b\u0007\u0010!R\u0014\u0010#\u001A\u00020\"8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001A\u00020%8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b&\u0010\'R\u0014\u0010)\u001A\u00020(8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001A\u00020+8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001A\u00020.8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001A\u00020(8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b1\u0010*R\u0014\u00102\u001A\u00020%8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b2\u0010\'R\u0016\u00104\u001A\u0004\u0018\u0001038\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001A\u0002068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001A\u0002068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b9\u00108R\u0014\u0010:\u001A\u00020\u001C8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b:\u0010;\u00A8\u0006="}, d2 = {"Lokhttp3/Cache$Entry;", "", "Lokio/Source;", "rawSource", "<init>", "(Lokio/Source;)V", "Lokhttp3/Response;", "response", "(Lokhttp3/Response;)V", "Lokio/BufferedSource;", "source", "", "Ljava/security/cert/Certificate;", "readCertificateList", "(Lokio/BufferedSource;)Ljava/util/List;", "Lokio/BufferedSink;", "sink", "certificates", "Lie/H;", "writeCertList", "(Lokio/BufferedSink;Ljava/util/List;)V", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "writeTo", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "Lokhttp3/Request;", "request", "", "matches", "(Lokhttp3/Request;Lokhttp3/Response;)Z", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;)Lokhttp3/Response;", "Lokhttp3/HttpUrl;", "url", "Lokhttp3/HttpUrl;", "Lokhttp3/Headers;", "varyHeaders", "Lokhttp3/Headers;", "", "requestMethod", "Ljava/lang/String;", "Lokhttp3/Protocol;", "protocol", "Lokhttp3/Protocol;", "", "code", "I", "message", "responseHeaders", "Lokhttp3/Handshake;", "handshake", "Lokhttp3/Handshake;", "", "sentRequestMillis", "J", "receivedResponseMillis", "isHttps", "()Z", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class Entry {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokhttp3/Cache$Entry$Companion;", "", "()V", "RECEIVED_MILLIS", "", "SENT_MILLIS", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class okhttp3.Cache.Entry.Companion {
            private okhttp3.Cache.Entry.Companion() {
            }

            public okhttp3.Cache.Entry.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final okhttp3.Cache.Entry.Companion Companion;
        @NotNull
        private static final String RECEIVED_MILLIS;
        @NotNull
        private static final String SENT_MILLIS;
        private final int code;
        @Nullable
        private final Handshake handshake;
        @NotNull
        private final String message;
        @NotNull
        private final Protocol protocol;
        private final long receivedResponseMillis;
        @NotNull
        private final String requestMethod;
        @NotNull
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        @NotNull
        private final HttpUrl url;
        @NotNull
        private final Headers varyHeaders;

        // 去混淆评级： 低(20)
        static {
            Entry.Companion = new okhttp3.Cache.Entry.Companion(null);
            Entry.SENT_MILLIS = "OkHttp-Sent-Millis";
            Entry.RECEIVED_MILLIS = "OkHttp-Received-Millis";
        }

        public Entry(@NotNull Response response0) {
            q.g(response0, "response");
            super();
            this.url = response0.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response0);
            this.requestMethod = response0.request().method();
            this.protocol = response0.protocol();
            this.code = response0.code();
            this.message = response0.message();
            this.responseHeaders = response0.headers();
            this.handshake = response0.handshake();
            this.sentRequestMillis = response0.sentRequestAtMillis();
            this.receivedResponseMillis = response0.receivedResponseAtMillis();
        }

        public Entry(@NotNull Source source0) {
            q.g(source0, "rawSource");
            TlsVersion tlsVersion0;
            super();
            try {
                BufferedSource bufferedSource0 = Okio.buffer(source0);
                String s = bufferedSource0.readUtf8LineStrict();
                HttpUrl httpUrl0 = HttpUrl.Companion.parse(s);
                if(httpUrl0 == null) {
                    IOException iOException0 = new IOException("Cache corruption for " + s);
                    Platform.Companion.get().log("cache corruption", 5, iOException0);
                    throw iOException0;
                }
                this.url = httpUrl0;
                this.requestMethod = bufferedSource0.readUtf8LineStrict();
                Builder headers$Builder0 = new Builder();
                int v = Cache.Companion.readInt$okhttp(bufferedSource0);
                for(int v2 = 0; v2 < v; ++v2) {
                    headers$Builder0.addLenient$okhttp(bufferedSource0.readUtf8LineStrict());
                }
                this.varyHeaders = headers$Builder0.build();
                String s1 = bufferedSource0.readUtf8LineStrict();
                StatusLine statusLine0 = StatusLine.Companion.parse(s1);
                this.protocol = statusLine0.protocol;
                this.code = statusLine0.code;
                this.message = statusLine0.message;
                Builder headers$Builder1 = new Builder();
                int v3 = Cache.Companion.readInt$okhttp(bufferedSource0);
                for(int v1 = 0; v1 < v3; ++v1) {
                    headers$Builder1.addLenient$okhttp(bufferedSource0.readUtf8LineStrict());
                }
                String s2 = headers$Builder1.get(Entry.SENT_MILLIS);
                String s3 = headers$Builder1.get(Entry.RECEIVED_MILLIS);
                headers$Builder1.removeAll(Entry.SENT_MILLIS);
                headers$Builder1.removeAll(Entry.RECEIVED_MILLIS);
                long v4 = 0L;
                this.sentRequestMillis = s2 == null ? 0L : Long.parseLong(s2);
                if(s3 != null) {
                    v4 = Long.parseLong(s3);
                }
                this.receivedResponseMillis = v4;
                this.responseHeaders = headers$Builder1.build();
                if(this.isHttps()) {
                    String s4 = bufferedSource0.readUtf8LineStrict();
                    if(s4.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + s4 + '\"');
                    }
                    String s5 = bufferedSource0.readUtf8LineStrict();
                    CipherSuite cipherSuite0 = CipherSuite.Companion.forJavaName(s5);
                    List list0 = this.readCertificateList(bufferedSource0);
                    List list1 = this.readCertificateList(bufferedSource0);
                    if(bufferedSource0.exhausted()) {
                        tlsVersion0 = TlsVersion.SSL_3_0;
                    }
                    else {
                        String s6 = bufferedSource0.readUtf8LineStrict();
                        tlsVersion0 = TlsVersion.Companion.forJavaName(s6);
                    }
                    this.handshake = Handshake.Companion.get(tlsVersion0, cipherSuite0, list0, list1);
                }
                else {
                    this.handshake = null;
                }
                goto label_63;
            }
            catch(Throwable throwable0) {
            }
            try {
                throw throwable0;
            }
            catch(Throwable throwable1) {
                d.l(source0, throwable0);
                throw throwable1;
            }
        label_63:
            source0.close();
        }

        private final boolean isHttps() {
            return q.b(this.url.scheme(), "https");
        }

        public final boolean matches(@NotNull Request request0, @NotNull Response response0) {
            q.g(request0, "request");
            q.g(response0, "response");
            return q.b(this.url, request0.url()) && q.b(this.requestMethod, request0.method()) && Cache.Companion.varyMatches(response0, this.varyHeaders, request0);
        }

        private final List readCertificateList(BufferedSource bufferedSource0) {
            int v = Cache.Companion.readInt$okhttp(bufferedSource0);
            if(v == -1) {
                return w.a;
            }
            try {
                CertificateFactory certificateFactory0 = CertificateFactory.getInstance("X.509");
                List list0 = new ArrayList(v);
                for(int v1 = 0; v1 < v; ++v1) {
                    String s = bufferedSource0.readUtf8LineStrict();
                    Buffer buffer0 = new Buffer();
                    ByteString byteString0 = ByteString.Companion.decodeBase64(s);
                    if(byteString0 == null) {
                        throw new IOException("Corrupt certificate in cache entry");
                    }
                    buffer0.write(byteString0);
                    ((ArrayList)list0).add(certificateFactory0.generateCertificate(buffer0.inputStream()));
                }
                return list0;
            }
            catch(CertificateException certificateException0) {
            }
            throw new IOException(certificateException0.getMessage());
        }

        @NotNull
        public final Response response(@NotNull Snapshot diskLruCache$Snapshot0) {
            q.g(diskLruCache$Snapshot0, "snapshot");
            String s = this.responseHeaders.get("Content-Type");
            String s1 = this.responseHeaders.get("Content-Length");
            Request request0 = new okhttp3.Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
            return new okhttp3.Response.Builder().request(request0).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(diskLruCache$Snapshot0, s, s1)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        private final void writeCertList(BufferedSink bufferedSink0, List list0) {
            try {
                bufferedSink0.writeDecimalLong(((long)list0.size())).writeByte(10);
                for(Object object0: list0) {
                    byte[] arr_b = ((Certificate)object0).getEncoded();
                    q.f(arr_b, "bytes");
                    bufferedSink0.writeUtf8(okio.ByteString.Companion.of$default(ByteString.Companion, arr_b, 0, 0, 3, null).base64()).writeByte(10);
                }
            }
            catch(CertificateEncodingException certificateEncodingException0) {
                throw new IOException(certificateEncodingException0.getMessage());
            }
        }

        public final void writeTo(@NotNull Editor diskLruCache$Editor0) {
            q.g(diskLruCache$Editor0, "editor");
            BufferedSink bufferedSink0 = Okio.buffer(diskLruCache$Editor0.newSink(0));
            try {
                bufferedSink0.writeUtf8(this.url.toString()).writeByte(10);
                bufferedSink0.writeUtf8(this.requestMethod).writeByte(10);
                bufferedSink0.writeDecimalLong(((long)this.varyHeaders.size())).writeByte(10);
                int v1 = this.varyHeaders.size();
                for(int v2 = 0; v2 < v1; ++v2) {
                    bufferedSink0.writeUtf8(this.varyHeaders.name(v2)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(v2)).writeByte(10);
                }
                bufferedSink0.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
                bufferedSink0.writeDecimalLong(((long)(this.responseHeaders.size() + 2))).writeByte(10);
                int v3 = this.responseHeaders.size();
                for(int v = 0; v < v3; ++v) {
                    bufferedSink0.writeUtf8(this.responseHeaders.name(v)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(v)).writeByte(10);
                }
                bufferedSink0.writeUtf8(Entry.SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
                bufferedSink0.writeUtf8(Entry.RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
                if(this.isHttps()) {
                    bufferedSink0.writeByte(10);
                    q.d(this.handshake);
                    bufferedSink0.writeUtf8(this.handshake.cipherSuite().javaName()).writeByte(10);
                    this.writeCertList(bufferedSink0, this.handshake.peerCertificates());
                    this.writeCertList(bufferedSink0, this.handshake.localCertificates());
                    bufferedSink0.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
                }
                goto label_34;
            }
            catch(Throwable throwable0) {
            }
            try {
                throw throwable0;
            }
            catch(Throwable throwable1) {
                d.l(bufferedSink0, throwable0);
                throw throwable1;
            }
        label_34:
            d.l(bufferedSink0, null);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001A\u00060\u0002R\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fR\u0018\u0010\u0004\u001A\u00060\u0002R\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u000E\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\u000FR\"\u0010\u0011\u001A\u00020\u00108\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lokhttp3/Cache$RealCacheRequest;", "Lokhttp3/internal/cache/CacheRequest;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "<init>", "(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "Lie/H;", "abort", "()V", "Lokio/Sink;", "body", "()Lokio/Sink;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "cacheOut", "Lokio/Sink;", "", "done", "Z", "getDone", "()Z", "setDone", "(Z)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class RealCacheRequest implements CacheRequest {
        @NotNull
        private final Sink body;
        @NotNull
        private final Sink cacheOut;
        private boolean done;
        @NotNull
        private final Editor editor;

        public RealCacheRequest(@NotNull Editor diskLruCache$Editor0) {
            q.g(diskLruCache$Editor0, "editor");
            Cache.this = cache0;
            super();
            this.editor = diskLruCache$Editor0;
            Sink sink0 = diskLruCache$Editor0.newSink(1);
            this.cacheOut = sink0;
            this.body = new ForwardingSink(/*ERROR_MISSING_ARG_2/*) {
                @Override  // okio.ForwardingSink
                public void close() {
                    Cache cache0 = this;
                    RealCacheRequest cache$RealCacheRequest0 = sink0;
                    synchronized(cache0) {
                        if(cache$RealCacheRequest0.getDone()) {
                            return;
                        }
                        cache$RealCacheRequest0.setDone(true);
                        cache0.setWriteSuccessCount$okhttp(cache0.getWriteSuccessCount$okhttp() + 1);
                    }
                    super.close();
                    RealCacheRequest.access$getEditor$p(sink0).commit();
                }
            };
        }

        @Override  // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache cache0 = Cache.this;
            synchronized(cache0) {
                if(this.done) {
                    return;
                }
                this.done = true;
                cache0.setWriteAbortCount$okhttp(cache0.getWriteAbortCount$okhttp() + 1);
            }
            Util.closeQuietly(this.cacheOut);
            try {
                this.editor.abort();
            }
            catch(IOException unused_ex) {
            }
        }

        public static final Editor access$getEditor$p(RealCacheRequest cache$RealCacheRequest0) {
            return cache$RealCacheRequest0.editor;
        }

        @Override  // okhttp3.internal.cache.CacheRequest
        @NotNull
        public Sink body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z) {
            this.done = z;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    @NotNull
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    @ie.d
    @NotNull
    public final File -deprecated_directory() {
        return this.cache.getDirectory();
    }

    static {
        Cache.Companion = new Companion(null);
    }

    public Cache(@NotNull File file0, long v) {
        q.g(file0, "directory");
        this(file0, v, FileSystem.SYSTEM);
    }

    public Cache(@NotNull File file0, long v, @NotNull FileSystem fileSystem0) {
        q.g(file0, "directory");
        q.g(fileSystem0, "fileSystem");
        super();
        this.cache = new DiskLruCache(fileSystem0, file0, 201105, 2, v, TaskRunner.INSTANCE);
    }

    private final void abortQuietly(Editor diskLruCache$Editor0) {
        if(diskLruCache$Editor0 != null) {
            try {
                diskLruCache$Editor0.abort();
            }
            catch(IOException unused_ex) {
            }
        }
    }

    @Override
    public void close() {
        this.cache.close();
    }

    public final void delete() {
        this.cache.delete();
    }

    @NotNull
    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() {
        this.cache.evictAll();
    }

    @Override
    public void flush() {
        this.cache.flush();
    }

    @Nullable
    public final Response get$okhttp(@NotNull Request request0) {
        Entry cache$Entry0;
        Snapshot diskLruCache$Snapshot0;
        q.g(request0, "request");
        String s = Cache.Companion.key(request0.url());
        try {
            diskLruCache$Snapshot0 = this.cache.get(s);
            if(diskLruCache$Snapshot0 == null) {
                return null;
            }
            goto label_5;
        }
        catch(IOException unused_ex) {
        }
        return null;
        try {
        label_5:
            cache$Entry0 = new Entry(diskLruCache$Snapshot0.getSource(0));
        }
        catch(IOException unused_ex) {
            Util.closeQuietly(diskLruCache$Snapshot0);
            return null;
        }
        Response response0 = cache$Entry0.response(diskLruCache$Snapshot0);
        if(!cache$Entry0.matches(request0, response0)) {
            ResponseBody responseBody0 = response0.body();
            if(responseBody0 != null) {
                Util.closeQuietly(responseBody0);
            }
            return null;
        }
        return response0;
    }

    @NotNull
    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final int hitCount() {
        synchronized(this) {
        }
        return this.hitCount;
    }

    public final void initialize() {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    @NotNull
    public static final String key(@NotNull HttpUrl httpUrl0) {
        return Cache.Companion.key(httpUrl0);
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final int networkCount() {
        synchronized(this) {
        }
        return this.networkCount;
    }

    @Nullable
    public final CacheRequest put$okhttp(@NotNull Response response0) {
        Editor diskLruCache$Editor0;
        q.g(response0, "response");
        String s = response0.request().method();
        if(HttpMethod.INSTANCE.invalidatesCache(response0.request().method())) {
            try {
                this.remove$okhttp(response0.request());
            }
            catch(IOException unused_ex) {
            }
            return null;
        }
        if(!q.b(s, "GET")) {
            return null;
        }
        Companion cache$Companion0 = Cache.Companion;
        if(cache$Companion0.hasVaryAll(response0)) {
            return null;
        }
        Entry cache$Entry0 = new Entry(response0);
        try {
            String s1 = cache$Companion0.key(response0.request().url());
            diskLruCache$Editor0 = null;
            diskLruCache$Editor0 = DiskLruCache.edit$default(this.cache, s1, 0L, 2, null);
            if(diskLruCache$Editor0 != null) {
                cache$Entry0.writeTo(diskLruCache$Editor0);
                return new RealCacheRequest(this, diskLruCache$Editor0);
            }
        }
        catch(IOException unused_ex) {
            this.abortQuietly(diskLruCache$Editor0);
        }
        return null;
    }

    public final void remove$okhttp(@NotNull Request request0) {
        q.g(request0, "request");
        String s = Cache.Companion.key(request0.url());
        this.cache.remove(s);
    }

    public final int requestCount() {
        synchronized(this) {
        }
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int v) {
        this.writeAbortCount = v;
    }

    public final void setWriteSuccessCount$okhttp(int v) {
        this.writeSuccessCount = v;
    }

    public final long size() {
        return this.cache.size();
    }

    public final void trackConditionalCacheHit$okhttp() {
        synchronized(this) {
            ++this.hitCount;
        }
    }

    public final void trackResponse$okhttp(@NotNull CacheStrategy cacheStrategy0) {
        synchronized(this) {
            q.g(cacheStrategy0, "cacheStrategy");
            ++this.requestCount;
            if(cacheStrategy0.getNetworkRequest() != null) {
                ++this.networkCount;
            }
            else if(cacheStrategy0.getCacheResponse() != null) {
                ++this.hitCount;
            }
        }
    }

    public final void update$okhttp(@NotNull Response response0, @NotNull Response response1) {
        Editor diskLruCache$Editor0;
        q.g(response0, "cached");
        q.g(response1, "network");
        Entry cache$Entry0 = new Entry(response1);
        ResponseBody responseBody0 = response0.body();
        q.e(responseBody0, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        Snapshot diskLruCache$Snapshot0 = ((CacheResponseBody)responseBody0).getSnapshot();
        try {
            diskLruCache$Editor0 = null;
            diskLruCache$Editor0 = diskLruCache$Snapshot0.edit();
            if(diskLruCache$Editor0 != null) {
                cache$Entry0.writeTo(diskLruCache$Editor0);
                diskLruCache$Editor0.commit();
            }
        }
        catch(IOException unused_ex) {
            this.abortQuietly(diskLruCache$Editor0);
        }
    }

    @NotNull
    public final Iterator urls() {
        return new Object() {
            private boolean canRemove;
            @NotNull
            private final Iterator delegate;
            @Nullable
            private String nextUrl;

            {
                this.delegate = cache0.getCache$okhttp().snapshots();
            }

            @Override
            public boolean hasNext() {
                Closeable closeable0;
                if(this.nextUrl != null) {
                    return true;
                }
                this.canRemove = false;
            label_3:
                if(this.delegate.hasNext()) {
                    try {
                        Object object0 = this.delegate.next();
                        closeable0 = (Closeable)object0;
                    }
                    catch(IOException unused_ex) {
                        goto label_3;
                    }
                    try {
                        this.nextUrl = Okio.buffer(((Snapshot)closeable0).getSource(0)).readUtf8LineStrict();
                        goto label_11;
                    }
                    catch(Throwable throwable0) {
                        try {
                            d.l(closeable0, throwable0);
                            throw throwable0;
                        label_11:
                            d.l(closeable0, null);
                            return true;
                        }
                        catch(IOException unused_ex) {
                            goto label_3;
                        }
                    }
                }
                return false;
            }

            @Override
            public Object next() {
                return this.next();
            }

            @NotNull
            public String next() {
                if(!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                String s = this.nextUrl;
                q.d(s);
                this.nextUrl = null;
                this.canRemove = true;
                return s;
            }

            @Override
            public void remove() {
                if(!this.canRemove) {
                    throw new IllegalStateException("remove() before next()");
                }
                this.delegate.remove();
            }
        };
    }

    public final int writeAbortCount() {
        synchronized(this) {
        }
        return this.writeAbortCount;
    }

    public final int writeSuccessCount() {
        synchronized(this) {
        }
        return this.writeSuccessCount;
    }
}

