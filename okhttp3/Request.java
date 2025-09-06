package okhttp3;

import Tf.v;
import e.k;
import ie.d;
import ie.m;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001*BA\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t\u0012\u0016\u0010\n\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010\u000B\u00A2\u0006\u0002\u0010\rJ\u000F\u0010\b\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0002\b\u001BJ\r\u0010\u000F\u001A\u00020\u0010H\u0007\u00A2\u0006\u0002\b\u001CJ\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u001E\u001A\u00020\u0005J\r\u0010\u0006\u001A\u00020\u0007H\u0007\u00A2\u0006\u0002\b\u001FJ\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050 2\u0006\u0010\u001E\u001A\u00020\u0005J\r\u0010\u0004\u001A\u00020\u0005H\u0007\u00A2\u0006\u0002\b!J\u0006\u0010\"\u001A\u00020#J\b\u0010$\u001A\u0004\u0018\u00010\u0001J#\u0010$\u001A\u0004\u0018\u0001H%\"\u0004\b\u0000\u0010%2\u000E\u0010&\u001A\n\u0012\u0006\b\u0001\u0012\u0002H%0\f\u00A2\u0006\u0002\u0010\'J\b\u0010(\u001A\u00020\u0005H\u0016J\r\u0010\u0002\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b)R\u0015\u0010\b\u001A\u0004\u0018\u00010\t8\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u000ER\u0011\u0010\u000F\u001A\u00020\u00108G\u00A2\u0006\u0006\u001A\u0004\b\u000F\u0010\u0011R\u0013\u0010\u0006\u001A\u00020\u00078\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0012R\u0011\u0010\u0013\u001A\u00020\u00148F\u00A2\u0006\u0006\u001A\u0004\b\u0013\u0010\u0015R\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0010X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001A\u00020\u00058\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0017R$\u0010\n\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010\u000BX\u0080\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u001A\u00A8\u0006+"}, d2 = {"Lokhttp3/Request;", "", "url", "Lokhttp3/HttpUrl;", "method", "", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "tags", "", "Ljava/lang/Class;", "(Lokhttp3/HttpUrl;Ljava/lang/String;Lokhttp3/Headers;Lokhttp3/RequestBody;Ljava/util/Map;)V", "()Lokhttp3/RequestBody;", "cacheControl", "Lokhttp3/CacheControl;", "()Lokhttp3/CacheControl;", "()Lokhttp3/Headers;", "isHttps", "", "()Z", "lazyCacheControl", "()Ljava/lang/String;", "getTags$okhttp", "()Ljava/util/Map;", "()Lokhttp3/HttpUrl;", "-deprecated_body", "-deprecated_cacheControl", "header", "name", "-deprecated_headers", "", "-deprecated_method", "newBuilder", "Lokhttp3/Request$Builder;", "tag", "T", "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "toString", "-deprecated_url", "Builder", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Request {
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00A2\u0006\u0002\u0010\u0002B\u000F\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u00A2\u0006\u0002\u0010\u0005J\u0018\u0010%\u001A\u00020\u00002\u0006\u0010&\u001A\u00020\u00132\u0006\u0010\'\u001A\u00020\u0013H\u0016J\b\u0010(\u001A\u00020\u0004H\u0016J\u0010\u0010)\u001A\u00020\u00002\u0006\u0010)\u001A\u00020*H\u0016J\u0014\u0010+\u001A\u00020\u00002\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0017J\b\u0010,\u001A\u00020\u0000H\u0016J\b\u0010-\u001A\u00020\u0000H\u0016J\u0018\u0010.\u001A\u00020\u00002\u0006\u0010&\u001A\u00020\u00132\u0006\u0010\'\u001A\u00020\u0013H\u0016J\u0010\u0010\f\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020/H\u0016J\u001A\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0012\u001A\u00020\u00132\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0016J\u0010\u00100\u001A\u00020\u00002\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u00101\u001A\u00020\u00002\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u00102\u001A\u00020\u00002\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u00103\u001A\u00020\u00002\u0006\u0010&\u001A\u00020\u0013H\u0016J-\u00104\u001A\u00020\u0000\"\u0004\b\u0000\u001052\u000E\u00106\u001A\n\u0012\u0006\b\u0000\u0012\u0002H50\u001A2\b\u00104\u001A\u0004\u0018\u0001H5H\u0016\u00A2\u0006\u0002\u00107J\u0012\u00104\u001A\u00020\u00002\b\u00104\u001A\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u001F\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u000208H\u0016J\u0010\u0010\u001F\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u0013H\u0016J\u0010\u0010\u001F\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020 H\u0016R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\u00020\rX\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0012\u001A\u00020\u0013X\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001A\u0012\u0004\u0012\u00020\u00010\u0019X\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u001C\u0010\u001F\u001A\u0004\u0018\u00010 X\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00A8\u00069"}, d2 = {"Lokhttp3/Request$Builder;", "", "()V", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;)V", "body", "Lokhttp3/RequestBody;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "headers", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "method", "", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "tags", "", "Ljava/lang/Class;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "url", "Lokhttp3/HttpUrl;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", "addHeader", "name", "value", "build", "cacheControl", "Lokhttp3/CacheControl;", "delete", "get", "head", "header", "Lokhttp3/Headers;", "patch", "post", "put", "removeHeader", "tag", "T", "type", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Ljava/net/URL;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static class Builder {
        @Nullable
        private RequestBody body;
        @NotNull
        private okhttp3.Headers.Builder headers;
        @NotNull
        private String method;
        @NotNull
        private Map tags;
        @Nullable
        private HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new okhttp3.Headers.Builder();
        }

        public Builder(@NotNull Request request0) {
            q.g(request0, "request");
            super();
            this.tags = new LinkedHashMap();
            this.url = request0.url();
            this.method = request0.method();
            this.body = request0.body();
            this.tags = request0.getTags$okhttp().isEmpty() ? new LinkedHashMap() : C.a0(request0.getTags$okhttp());
            this.headers = request0.headers().newBuilder();
        }

        @NotNull
        public Builder addHeader(@NotNull String s, @NotNull String s1) {
            q.g(s, "name");
            q.g(s1, "value");
            this.headers.add(s, s1);
            return this;
        }

        @NotNull
        public Request build() {
            HttpUrl httpUrl0 = this.url;
            if(httpUrl0 == null) {
                throw new IllegalStateException("url == null");
            }
            return new Request(httpUrl0, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
        }

        @NotNull
        public Builder cacheControl(@NotNull CacheControl cacheControl0) {
            q.g(cacheControl0, "cacheControl");
            String s = cacheControl0.toString();
            return s.length() == 0 ? this.removeHeader("Cache-Control") : this.header("Cache-Control", s);
        }

        @NotNull
        public final Builder delete() {
            return Builder.delete$default(this, null, 1, null);
        }

        @NotNull
        public Builder delete(@Nullable RequestBody requestBody0) {
            return this.method("DELETE", requestBody0);
        }

        public static Builder delete$default(Builder request$Builder0, RequestBody requestBody0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if((v & 1) != 0) {
                requestBody0 = Util.EMPTY_REQUEST;
            }
            return request$Builder0.delete(requestBody0);
        }

        @NotNull
        public Builder get() {
            return this.method("GET", null);
        }

        @Nullable
        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        @NotNull
        public final okhttp3.Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @NotNull
        public final String getMethod$okhttp() {
            return this.method;
        }

        @NotNull
        public final Map getTags$okhttp() {
            return this.tags;
        }

        @Nullable
        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        @NotNull
        public Builder head() {
            return this.method("HEAD", null);
        }

        @NotNull
        public Builder header(@NotNull String s, @NotNull String s1) {
            q.g(s, "name");
            q.g(s1, "value");
            this.headers.set(s, s1);
            return this;
        }

        @NotNull
        public Builder headers(@NotNull Headers headers0) {
            q.g(headers0, "headers");
            this.headers = headers0.newBuilder();
            return this;
        }

        @NotNull
        public Builder method(@NotNull String s, @Nullable RequestBody requestBody0) {
            q.g(s, "method");
            if(s.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if(requestBody0 == null) {
                if(HttpMethod.requiresRequestBody(s)) {
                    throw new IllegalArgumentException(("method " + s + " must have a request body.").toString());
                }
            }
            else if(!HttpMethod.permitsRequestBody(s)) {
                throw new IllegalArgumentException(("method " + s + " must not have a request body.").toString());
            }
            this.method = s;
            this.body = requestBody0;
            return this;
        }

        @NotNull
        public Builder patch(@NotNull RequestBody requestBody0) {
            q.g(requestBody0, "body");
            return this.method("PATCH", requestBody0);
        }

        @NotNull
        public Builder post(@NotNull RequestBody requestBody0) {
            q.g(requestBody0, "body");
            return this.method("POST", requestBody0);
        }

        @NotNull
        public Builder put(@NotNull RequestBody requestBody0) {
            q.g(requestBody0, "body");
            return this.method("PUT", requestBody0);
        }

        @NotNull
        public Builder removeHeader(@NotNull String s) {
            q.g(s, "name");
            this.headers.removeAll(s);
            return this;
        }

        public final void setBody$okhttp(@Nullable RequestBody requestBody0) {
            this.body = requestBody0;
        }

        public final void setHeaders$okhttp(@NotNull okhttp3.Headers.Builder headers$Builder0) {
            q.g(headers$Builder0, "<set-?>");
            this.headers = headers$Builder0;
        }

        public final void setMethod$okhttp(@NotNull String s) {
            q.g(s, "<set-?>");
            this.method = s;
        }

        public final void setTags$okhttp(@NotNull Map map0) {
            q.g(map0, "<set-?>");
            this.tags = map0;
        }

        public final void setUrl$okhttp(@Nullable HttpUrl httpUrl0) {
            this.url = httpUrl0;
        }

        @NotNull
        public Builder tag(@NotNull Class class0, @Nullable Object object0) {
            q.g(class0, "type");
            if(object0 == null) {
                this.tags.remove(class0);
                return this;
            }
            if(this.tags.isEmpty()) {
                this.tags = new LinkedHashMap();
            }
            Map map0 = this.tags;
            Object object1 = class0.cast(object0);
            q.d(object1);
            map0.put(class0, object1);
            return this;
        }

        @NotNull
        public Builder tag(@Nullable Object object0) {
            return this.tag(Object.class, object0);
        }

        @NotNull
        public Builder url(@NotNull String s) {
            q.g(s, "url");
            if(v.r0(s, "ws:", true)) {
                String s1 = s.substring(3);
                q.f(s1, "this as java.lang.String).substring(startIndex)");
                return this.url(HttpUrl.Companion.get("http:" + s1));
            }
            if(v.r0(s, "wss:", true)) {
                String s2 = s.substring(4);
                q.f(s2, "this as java.lang.String).substring(startIndex)");
                s = "https:" + s2;
            }
            return this.url(HttpUrl.Companion.get(s));
        }

        @NotNull
        public Builder url(@NotNull URL uRL0) {
            q.g(uRL0, "url");
            String s = uRL0.toString();
            q.f(s, "url.toString()");
            return this.url(HttpUrl.Companion.get(s));
        }

        @NotNull
        public Builder url(@NotNull HttpUrl httpUrl0) {
            q.g(httpUrl0, "url");
            this.url = httpUrl0;
            return this;
        }
    }

    @Nullable
    private final RequestBody body;
    @NotNull
    private final Headers headers;
    @Nullable
    private CacheControl lazyCacheControl;
    @NotNull
    private final String method;
    @NotNull
    private final Map tags;
    @NotNull
    private final HttpUrl url;

    @d
    @Nullable
    public final RequestBody -deprecated_body() {
        return this.body;
    }

    @d
    @NotNull
    public final CacheControl -deprecated_cacheControl() {
        return this.cacheControl();
    }

    @d
    @NotNull
    public final Headers -deprecated_headers() {
        return this.headers;
    }

    @d
    @NotNull
    public final String -deprecated_method() {
        return this.method;
    }

    @d
    @NotNull
    public final HttpUrl -deprecated_url() {
        return this.url;
    }

    public Request(@NotNull HttpUrl httpUrl0, @NotNull String s, @NotNull Headers headers0, @Nullable RequestBody requestBody0, @NotNull Map map0) {
        q.g(httpUrl0, "url");
        q.g(s, "method");
        q.g(headers0, "headers");
        q.g(map0, "tags");
        super();
        this.url = httpUrl0;
        this.method = s;
        this.headers = headers0;
        this.body = requestBody0;
        this.tags = map0;
    }

    @Nullable
    public final RequestBody body() {
        return this.body;
    }

    @NotNull
    public final CacheControl cacheControl() {
        CacheControl cacheControl0 = this.lazyCacheControl;
        if(cacheControl0 == null) {
            cacheControl0 = CacheControl.Companion.parse(this.headers);
            this.lazyCacheControl = cacheControl0;
        }
        return cacheControl0;
    }

    @NotNull
    public final Map getTags$okhttp() {
        return this.tags;
    }

    @Nullable
    public final String header(@NotNull String s) {
        q.g(s, "name");
        return this.headers.get(s);
    }

    @NotNull
    public final List headers(@NotNull String s) {
        q.g(s, "name");
        return this.headers.values(s);
    }

    @NotNull
    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    @NotNull
    public final String method() {
        return this.method;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @Nullable
    public final Object tag() {
        return this.tag(Object.class);
    }

    @Nullable
    public final Object tag(@NotNull Class class0) {
        q.g(class0, "type");
        return class0.cast(this.tags.get(class0));
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Request{method=");
        stringBuilder0.append(this.method);
        stringBuilder0.append(", url=");
        stringBuilder0.append(this.url);
        if(this.headers.size() != 0) {
            stringBuilder0.append(", headers=[");
            int v = 0;
            for(Object object0: this.headers) {
                if(v >= 0) {
                    String s = (String)((m)object0).a;
                    String s1 = (String)((m)object0).b;
                    if(v > 0) {
                        stringBuilder0.append(", ");
                    }
                    stringBuilder0.append(s);
                    stringBuilder0.append(':');
                    stringBuilder0.append(s1);
                    ++v;
                    continue;
                }
                k.O();
                throw null;
            }
            stringBuilder0.append(']');
        }
        if(!this.tags.isEmpty()) {
            stringBuilder0.append(", tags=");
            stringBuilder0.append(this.tags);
        }
        stringBuilder0.append('}');
        String s2 = stringBuilder0.toString();
        q.f(s2, "StringBuilder().apply(builderAction).toString()");
        return s2;
    }

    @NotNull
    public final HttpUrl url() {
        return this.url;
    }
}

