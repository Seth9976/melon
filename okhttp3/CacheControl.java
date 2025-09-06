package okhttp3;

import Tf.o;
import Tf.v;
import ie.d;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\u0011\u0018\u0000 !2\u00020\u0001:\u0002 !Bq\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\u0006\u0012\u0006\u0010\f\u001A\u00020\u0006\u0012\u0006\u0010\r\u001A\u00020\u0003\u0012\u0006\u0010\u000E\u001A\u00020\u0003\u0012\u0006\u0010\u000F\u001A\u00020\u0003\u0012\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0002\u0010\u0012J\r\u0010\u000F\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b\u0015J\r\u0010\u0005\u001A\u00020\u0006H\u0007\u00A2\u0006\u0002\b\u0016J\r\u0010\u000B\u001A\u00020\u0006H\u0007\u00A2\u0006\u0002\b\u0017J\r\u0010\f\u001A\u00020\u0006H\u0007\u00A2\u0006\u0002\b\u0018J\r\u0010\n\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b\u0019J\r\u0010\u0002\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b\u001AJ\r\u0010\u0004\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b\u001BJ\r\u0010\u000E\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b\u001CJ\r\u0010\r\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b\u001DJ\r\u0010\u0007\u001A\u00020\u0006H\u0007\u00A2\u0006\u0002\b\u001EJ\b\u0010\u001F\u001A\u00020\u0011H\u0016R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0013\u0010\u000F\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0013R\u0011\u0010\b\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0013R\u0013\u0010\u0005\u001A\u00020\u00068\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0014R\u0013\u0010\u000B\u001A\u00020\u00068\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0014R\u0013\u0010\f\u001A\u00020\u00068\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u0014R\u0013\u0010\n\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u0013R\u0013\u0010\u0002\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0013R\u0013\u0010\u000E\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u0013R\u0013\u0010\r\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0013R\u0013\u0010\u0007\u001A\u00020\u00068\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\u0014\u00A8\u0006\""}, d2 = {"Lokhttp3/CacheControl;", "", "noCache", "", "noStore", "maxAgeSeconds", "", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "headerValue", "", "(ZZIIZZZIIZZZLjava/lang/String;)V", "()Z", "()I", "-deprecated_immutable", "-deprecated_maxAgeSeconds", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_mustRevalidate", "-deprecated_noCache", "-deprecated_noStore", "-deprecated_noTransform", "-deprecated_onlyIfCached", "-deprecated_sMaxAgeSeconds", "toString", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CacheControl {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001A\u00020\u000EJ\u0006\u0010\u0003\u001A\u00020\u0000J\u0016\u0010\u000F\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u0011J\u0016\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0012\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u0011J\u0016\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u0011J\u0006\u0010\t\u001A\u00020\u0000J\u0006\u0010\n\u001A\u00020\u0000J\u0006\u0010\u000B\u001A\u00020\u0000J\u0006\u0010\f\u001A\u00020\u0000J\f\u0010\u0014\u001A\u00020\u0006*\u00020\u0015H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/CacheControl$Builder;", "", "()V", "immutable", "", "maxAgeSeconds", "", "maxStaleSeconds", "minFreshSeconds", "noCache", "noStore", "noTransform", "onlyIfCached", "build", "Lokhttp3/CacheControl;", "maxAge", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "maxStale", "minFresh", "clampToInt", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds;
        private int maxStaleSeconds;
        private int minFreshSeconds;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        public Builder() {
            this.maxAgeSeconds = -1;
            this.maxStaleSeconds = -1;
            this.minFreshSeconds = -1;
        }

        @NotNull
        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        private final int clampToInt(long v) {
            return v <= 0x7FFFFFFFL ? ((int)v) : 0x7FFFFFFF;
        }

        @NotNull
        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        @NotNull
        public final Builder maxAge(int v, @NotNull TimeUnit timeUnit0) {
            q.g(timeUnit0, "timeUnit");
            if(v < 0) {
                throw new IllegalArgumentException(("maxAge < 0: " + v).toString());
            }
            this.maxAgeSeconds = this.clampToInt(timeUnit0.toSeconds(((long)v)));
            return this;
        }

        @NotNull
        public final Builder maxStale(int v, @NotNull TimeUnit timeUnit0) {
            q.g(timeUnit0, "timeUnit");
            if(v < 0) {
                throw new IllegalArgumentException(("maxStale < 0: " + v).toString());
            }
            this.maxStaleSeconds = this.clampToInt(timeUnit0.toSeconds(((long)v)));
            return this;
        }

        @NotNull
        public final Builder minFresh(int v, @NotNull TimeUnit timeUnit0) {
            q.g(timeUnit0, "timeUnit");
            if(v < 0) {
                throw new IllegalArgumentException(("minFresh < 0: " + v).toString());
            }
            this.minFreshSeconds = this.clampToInt(timeUnit0.toSeconds(((long)v)));
            return this;
        }

        @NotNull
        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        @NotNull
        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        @NotNull
        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        @NotNull
        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\bH\u0007J\u001E\u0010\t\u001A\u00020\n*\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\b\b\u0002\u0010\r\u001A\u00020\nH\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lokhttp3/CacheControl$Companion;", "", "()V", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "parse", "headers", "Lokhttp3/Headers;", "indexOfElement", "", "", "characters", "startIndex", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final int indexOfElement(String s, String s1, int v) {
            int v1 = s.length();
            while(v < v1) {
                if(o.w0(s1, s.charAt(v))) {
                    return v;
                }
                ++v;
            }
            return s.length();
        }

        public static int indexOfElement$default(Companion cacheControl$Companion0, String s, String s1, int v, int v1, Object object0) {
            if((v1 & 2) != 0) {
                v = 0;
            }
            return cacheControl$Companion0.indexOfElement(s, s1, v);
        }

        @NotNull
        public final CacheControl parse(@NotNull Headers headers0) {
            int v10;
            String s5;
            int v6;
            q.g(headers0, "headers");
            int v = headers0.size();
            boolean z = true;
            int v1 = 0;
            String s = null;
            boolean z1 = false;
            boolean z2 = false;
            int v2 = -1;
            int v3 = -1;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            int v4 = -1;
            int v5 = -1;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            while(v1 < v) {
                String s1 = headers0.name(v1);
                String s2 = headers0.value(v1);
                if(v.j0(s1, "Cache-Control", true)) {
                    if(s == null) {
                        s = s2;
                    }
                    else {
                        z = false;
                    }
                    v6 = 0;
                    goto label_30;
                }
                else if(v.j0(s1, "Pragma", true)) {
                    z = false;
                    v6 = 0;
                label_30:
                    while(v6 < s2.length()) {
                        int v7 = this.indexOfElement(s2, "=,;", v6);
                        String s3 = s2.substring(v6, v7);
                        q.f(s3, "this as java.lang.String…ing(startIndex, endIndex)");
                        String s4 = o.e1(s3).toString();
                        if(v7 == s2.length() || s2.charAt(v7) == 44 || s2.charAt(v7) == 59) {
                            v10 = v7 + 1;
                            s5 = null;
                        }
                        else {
                            int v8 = Util.indexOfNonWhitespace(s2, v7 + 1);
                            if(v8 >= s2.length() || s2.charAt(v8) != 34) {
                                v10 = this.indexOfElement(s2, ",;", v8);
                                String s6 = s2.substring(v8, v10);
                                q.f(s6, "this as java.lang.String…ing(startIndex, endIndex)");
                                s5 = o.e1(s6).toString();
                            }
                            else {
                                int v9 = o.E0(s2, '\"', v8 + 1, 4);
                                s5 = s2.substring(v8 + 1, v9);
                                q.f(s5, "this as java.lang.String…ing(startIndex, endIndex)");
                                v10 = v9 + 1;
                            }
                        }
                        if("no-cache".equalsIgnoreCase(s4)) {
                            v6 = v10;
                            z1 = true;
                        }
                        else if("no-store".equalsIgnoreCase(s4)) {
                            v6 = v10;
                            z2 = true;
                        }
                        else {
                            if("max-age".equalsIgnoreCase(s4)) {
                                v2 = Util.toNonNegativeInt(s5, -1);
                            }
                            else if("s-maxage".equalsIgnoreCase(s4)) {
                                v3 = Util.toNonNegativeInt(s5, -1);
                            }
                            else if("private".equalsIgnoreCase(s4)) {
                                v6 = v10;
                                z3 = true;
                                continue;
                            }
                            else if("public".equalsIgnoreCase(s4)) {
                                v6 = v10;
                                z4 = true;
                                continue;
                            }
                            else if("must-revalidate".equalsIgnoreCase(s4)) {
                                v6 = v10;
                                z5 = true;
                                continue;
                            }
                            else if("max-stale".equalsIgnoreCase(s4)) {
                                v4 = Util.toNonNegativeInt(s5, 0x7FFFFFFF);
                            }
                            else if("min-fresh".equalsIgnoreCase(s4)) {
                                v5 = Util.toNonNegativeInt(s5, -1);
                            }
                            else if("only-if-cached".equalsIgnoreCase(s4)) {
                                v6 = v10;
                                z6 = true;
                                continue;
                            }
                            else if("no-transform".equalsIgnoreCase(s4)) {
                                v6 = v10;
                                z7 = true;
                                continue;
                            }
                            else if("immutable".equalsIgnoreCase(s4)) {
                                v6 = v10;
                                z8 = true;
                                continue;
                            }
                            v6 = v10;
                        }
                    }
                }
                ++v1;
            }
            return z ? new CacheControl(z1, z2, v2, v3, z3, z4, z5, v4, v5, z6, z7, z8, s, null) : new CacheControl(z1, z2, v2, v3, z3, z4, z5, v4, v5, z6, z7, z8, null, null);
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final CacheControl FORCE_CACHE;
    @NotNull
    public static final CacheControl FORCE_NETWORK;
    @Nullable
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    @d
    public final boolean -deprecated_immutable() {
        return this.immutable;
    }

    @d
    public final int -deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @d
    public final int -deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @d
    public final int -deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @d
    public final boolean -deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @d
    public final boolean -deprecated_noCache() {
        return this.noCache;
    }

    @d
    public final boolean -deprecated_noStore() {
        return this.noStore;
    }

    @d
    public final boolean -deprecated_noTransform() {
        return this.noTransform;
    }

    @d
    public final boolean -deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @d
    public final int -deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    static {
        CacheControl.Companion = new Companion(null);
        CacheControl.FORCE_NETWORK = new Builder().noCache().build();
        CacheControl.FORCE_CACHE = new Builder().onlyIfCached().maxStale(0x7FFFFFFF, TimeUnit.SECONDS).build();
    }

    private CacheControl(boolean z, boolean z1, int v, int v1, boolean z2, boolean z3, boolean z4, int v2, int v3, boolean z5, boolean z6, boolean z7, String s) {
        this.noCache = z;
        this.noStore = z1;
        this.maxAgeSeconds = v;
        this.sMaxAgeSeconds = v1;
        this.isPrivate = z2;
        this.isPublic = z3;
        this.mustRevalidate = z4;
        this.maxStaleSeconds = v2;
        this.minFreshSeconds = v3;
        this.onlyIfCached = z5;
        this.noTransform = z6;
        this.immutable = z7;
        this.headerValue = s;
    }

    public CacheControl(boolean z, boolean z1, int v, int v1, boolean z2, boolean z3, boolean z4, int v2, int v3, boolean z5, boolean z6, boolean z7, String s, DefaultConstructorMarker defaultConstructorMarker0) {
        this(z, z1, v, v1, z2, z3, z4, v2, v3, z5, z6, z7, s);
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    @NotNull
    public static final CacheControl parse(@NotNull Headers headers0) {
        return CacheControl.Companion.parse(headers0);
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @Override
    @NotNull
    public String toString() {
        String s = this.headerValue;
        if(s == null) {
            StringBuilder stringBuilder0 = new StringBuilder();
            if(this.noCache) {
                stringBuilder0.append("no-cache, ");
            }
            if(this.noStore) {
                stringBuilder0.append("no-store, ");
            }
            if(this.maxAgeSeconds != -1) {
                stringBuilder0.append("max-age=");
                stringBuilder0.append(this.maxAgeSeconds);
                stringBuilder0.append(", ");
            }
            if(this.sMaxAgeSeconds != -1) {
                stringBuilder0.append("s-maxage=");
                stringBuilder0.append(this.sMaxAgeSeconds);
                stringBuilder0.append(", ");
            }
            if(this.isPrivate) {
                stringBuilder0.append("private, ");
            }
            if(this.isPublic) {
                stringBuilder0.append("public, ");
            }
            if(this.mustRevalidate) {
                stringBuilder0.append("must-revalidate, ");
            }
            if(this.maxStaleSeconds != -1) {
                stringBuilder0.append("max-stale=");
                stringBuilder0.append(this.maxStaleSeconds);
                stringBuilder0.append(", ");
            }
            if(this.minFreshSeconds != -1) {
                stringBuilder0.append("min-fresh=");
                stringBuilder0.append(this.minFreshSeconds);
                stringBuilder0.append(", ");
            }
            if(this.onlyIfCached) {
                stringBuilder0.append("only-if-cached, ");
            }
            if(this.noTransform) {
                stringBuilder0.append("no-transform, ");
            }
            if(this.immutable) {
                stringBuilder0.append("immutable, ");
            }
            if(stringBuilder0.length() == 0) {
                return "";
            }
            stringBuilder0.delete(stringBuilder0.length() - 2, stringBuilder0.length());
            s = stringBuilder0.toString();
            q.f(s, "StringBuilder().apply(builderAction).toString()");
            this.headerValue = s;
        }
        return s;
    }
}

