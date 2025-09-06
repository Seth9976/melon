package okhttp3;

import Tf.a;
import d8.d;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH&¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0014"}, d2 = {"Lokhttp3/RequestBody;", "", "<init>", "()V", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "", "contentLength", "()J", "Lokio/BufferedSink;", "sink", "Lie/H;", "writeTo", "(Lokio/BufferedSink;)V", "", "isDuplex", "()Z", "isOneShot", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class RequestBody {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001A\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0007J.\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\fH\u0007J\u001A\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\t\u001A\u00020\u000EH\u0007J\u001A\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\t\u001A\u00020\u000FH\u0007J\u001D\u0010\u0010\u001A\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J1\u0010\u0011\u001A\u00020\u0004*\u00020\n2\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\fH\u0007¢\u0006\u0002\b\u0003J\u001D\u0010\u0011\u001A\u00020\u0004*\u00020\u000E2\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001D\u0010\u0011\u001A\u00020\u0004*\u00020\u000F2\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003¨\u0006\u0012"}, d2 = {"Lokhttp3/RequestBody$Companion;", "", "()V", "create", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "file", "Ljava/io/File;", "content", "", "offset", "", "byteCount", "", "Lokio/ByteString;", "asRequestBody", "toRequestBody", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final RequestBody create(@NotNull File file0, @Nullable MediaType mediaType0) {
            q.g(file0, "<this>");
            return new RequestBody() {
                @Override  // okhttp3.RequestBody
                public long contentLength() {
                    return this.$this_asRequestBody.length();
                }

                @Override  // okhttp3.RequestBody
                @Nullable
                public MediaType contentType() {
                    return file0;
                }

                @Override  // okhttp3.RequestBody
                public void writeTo(@NotNull BufferedSink bufferedSink0) {
                    q.g(bufferedSink0, "sink");
                    Source source0 = Okio.source(this.$this_asRequestBody);
                    try {
                        bufferedSink0.writeAll(source0);
                    }
                    catch(Throwable throwable0) {
                        d.l(source0, throwable0);
                        throw throwable0;
                    }
                    d.l(source0, null);
                }
            };
        }

        @NotNull
        public final RequestBody create(@NotNull String s, @Nullable MediaType mediaType0) {
            q.g(s, "<this>");
            Charset charset0 = a.a;
            if(mediaType0 != null) {
                Charset charset1 = MediaType.charset$default(mediaType0, null, 1, null);
                if(charset1 == null) {
                    mediaType0 = MediaType.Companion.parse(mediaType0 + "; charset=utf-8");
                }
                else {
                    charset0 = charset1;
                }
            }
            byte[] arr_b = s.getBytes(charset0);
            q.f(arr_b, "this as java.lang.String).getBytes(charset)");
            return this.create(arr_b, mediaType0, 0, arr_b.length);
        }

        @ie.d
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType0, @NotNull File file0) {
            q.g(file0, "file");
            return this.create(file0, mediaType0);
        }

        @ie.d
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType0, @NotNull String s) {
            q.g(s, "content");
            return this.create(s, mediaType0);
        }

        @ie.d
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType0, @NotNull ByteString byteString0) {
            q.g(byteString0, "content");
            return this.create(byteString0, mediaType0);
        }

        @ie.d
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType0, @NotNull byte[] arr_b) {
            q.g(arr_b, "content");
            return Companion.create$default(this, mediaType0, arr_b, 0, 0, 12, null);
        }

        @ie.d
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType0, @NotNull byte[] arr_b, int v) {
            q.g(arr_b, "content");
            return Companion.create$default(this, mediaType0, arr_b, v, 0, 8, null);
        }

        @ie.d
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType0, @NotNull byte[] arr_b, int v, int v1) {
            q.g(arr_b, "content");
            return this.create(arr_b, mediaType0, v, v1);
        }

        @NotNull
        public final RequestBody create(@NotNull ByteString byteString0, @Nullable MediaType mediaType0) {
            q.g(byteString0, "<this>");
            return new RequestBody() {
                @Override  // okhttp3.RequestBody
                public long contentLength() {
                    return (long)this.$this_toRequestBody.size();
                }

                @Override  // okhttp3.RequestBody
                @Nullable
                public MediaType contentType() {
                    return byteString0;
                }

                @Override  // okhttp3.RequestBody
                public void writeTo(@NotNull BufferedSink bufferedSink0) {
                    q.g(bufferedSink0, "sink");
                    bufferedSink0.write(this.$this_toRequestBody);
                }
            };
        }

        @NotNull
        public final RequestBody create(@NotNull byte[] arr_b) {
            q.g(arr_b, "<this>");
            return Companion.create$default(this, arr_b, null, 0, 0, 7, null);
        }

        @NotNull
        public final RequestBody create(@NotNull byte[] arr_b, @Nullable MediaType mediaType0) {
            q.g(arr_b, "<this>");
            return Companion.create$default(this, arr_b, mediaType0, 0, 0, 6, null);
        }

        @NotNull
        public final RequestBody create(@NotNull byte[] arr_b, @Nullable MediaType mediaType0, int v) {
            q.g(arr_b, "<this>");
            return Companion.create$default(this, arr_b, mediaType0, v, 0, 4, null);
        }

        @NotNull
        public final RequestBody create(@NotNull byte[] arr_b, @Nullable MediaType mediaType0, int v, int v1) {
            q.g(arr_b, "<this>");
            Util.checkOffsetAndCount(arr_b.length, v, v1);
            return new RequestBody() {
                @Override  // okhttp3.RequestBody
                public long contentLength() {
                    return (long)arr_b;
                }

                @Override  // okhttp3.RequestBody
                @Nullable
                public MediaType contentType() {
                    return v1;
                }

                @Override  // okhttp3.RequestBody
                public void writeTo(@NotNull BufferedSink bufferedSink0) {
                    q.g(bufferedSink0, "sink");
                    bufferedSink0.write(v, this.$offset, arr_b);
                }
            };
        }

        public static RequestBody create$default(Companion requestBody$Companion0, File file0, MediaType mediaType0, int v, Object object0) {
            if((v & 1) != 0) {
                mediaType0 = null;
            }
            return requestBody$Companion0.create(file0, mediaType0);
        }

        public static RequestBody create$default(Companion requestBody$Companion0, String s, MediaType mediaType0, int v, Object object0) {
            if((v & 1) != 0) {
                mediaType0 = null;
            }
            return requestBody$Companion0.create(s, mediaType0);
        }

        public static RequestBody create$default(Companion requestBody$Companion0, MediaType mediaType0, byte[] arr_b, int v, int v1, int v2, Object object0) {
            if((v2 & 4) != 0) {
                v = 0;
            }
            if((v2 & 8) != 0) {
                v1 = arr_b.length;
            }
            return requestBody$Companion0.create(mediaType0, arr_b, v, v1);
        }

        public static RequestBody create$default(Companion requestBody$Companion0, ByteString byteString0, MediaType mediaType0, int v, Object object0) {
            if((v & 1) != 0) {
                mediaType0 = null;
            }
            return requestBody$Companion0.create(byteString0, mediaType0);
        }

        public static RequestBody create$default(Companion requestBody$Companion0, byte[] arr_b, MediaType mediaType0, int v, int v1, int v2, Object object0) {
            if((v2 & 1) != 0) {
                mediaType0 = null;
            }
            if((v2 & 2) != 0) {
                v = 0;
            }
            if((v2 & 4) != 0) {
                v1 = arr_b.length;
            }
            return requestBody$Companion0.create(arr_b, mediaType0, v, v1);
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        RequestBody.Companion = new Companion(null);
    }

    public long contentLength() {
        return -1L;
    }

    @Nullable
    public abstract MediaType contentType();

    @NotNull
    public static final RequestBody create(@NotNull File file0, @Nullable MediaType mediaType0) {
        return RequestBody.Companion.create(file0, mediaType0);
    }

    @NotNull
    public static final RequestBody create(@NotNull String s, @Nullable MediaType mediaType0) {
        return RequestBody.Companion.create(s, mediaType0);
    }

    @ie.d
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType0, @NotNull File file0) {
        return RequestBody.Companion.create(mediaType0, file0);
    }

    @ie.d
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType0, @NotNull String s) {
        return RequestBody.Companion.create(mediaType0, s);
    }

    @ie.d
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType0, @NotNull ByteString byteString0) {
        return RequestBody.Companion.create(mediaType0, byteString0);
    }

    @ie.d
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType0, @NotNull byte[] arr_b) {
        return RequestBody.Companion.create(mediaType0, arr_b);
    }

    @ie.d
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType0, @NotNull byte[] arr_b, int v) {
        return RequestBody.Companion.create(mediaType0, arr_b, v);
    }

    @ie.d
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType0, @NotNull byte[] arr_b, int v, int v1) {
        return RequestBody.Companion.create(mediaType0, arr_b, v, v1);
    }

    @NotNull
    public static final RequestBody create(@NotNull ByteString byteString0, @Nullable MediaType mediaType0) {
        return RequestBody.Companion.create(byteString0, mediaType0);
    }

    @NotNull
    public static final RequestBody create(@NotNull byte[] arr_b) {
        return RequestBody.Companion.create(arr_b);
    }

    @NotNull
    public static final RequestBody create(@NotNull byte[] arr_b, @Nullable MediaType mediaType0) {
        return RequestBody.Companion.create(arr_b, mediaType0);
    }

    @NotNull
    public static final RequestBody create(@NotNull byte[] arr_b, @Nullable MediaType mediaType0, int v) {
        return RequestBody.Companion.create(arr_b, mediaType0, v);
    }

    @NotNull
    public static final RequestBody create(@NotNull byte[] arr_b, @Nullable MediaType mediaType0, int v, int v1) {
        return RequestBody.Companion.create(arr_b, mediaType0, v, v1);
    }

    public boolean isDuplex() [...] // Inlined contents

    public boolean isOneShot() [...] // Inlined contents

    public abstract void writeTo(@NotNull BufferedSink arg1);
}

