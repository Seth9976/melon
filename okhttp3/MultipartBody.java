package okhttp3;

import ie.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u00020\u0001:\u0003,+-B\'\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0010\u001A\u00020\u000F2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0018\u0010\u0017J\u000F\u0010\u001C\u001A\u00020\u0019H\u0007¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001F\u001A\u00020\u0012H\u0007¢\u0006\u0004\b\u001D\u0010\u001EJ\u0015\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b \u0010!J\u000F\u0010\"\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001A\u00020$2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\'R\u0017\u0010\u0005\u001A\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0005\u0010(\u001A\u0004\b\u0005\u0010\u0017R\u001D\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007¢\u0006\f\n\u0004\b\b\u0010)\u001A\u0004\b\b\u0010!R\u0014\u0010\u0016\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010(R\u0016\u0010\"\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010*R\u0011\u0010\u001C\u001A\u00020\u00198G¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001BR\u0011\u0010\u001F\u001A\u00020\u00128G¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u001E¨\u0006."}, d2 = {"Lokhttp3/MultipartBody;", "Lokhttp3/RequestBody;", "Lokio/ByteString;", "boundaryByteString", "Lokhttp3/MediaType;", "type", "", "Lokhttp3/MultipartBody$Part;", "parts", "<init>", "(Lokio/ByteString;Lokhttp3/MediaType;Ljava/util/List;)V", "Lokio/BufferedSink;", "sink", "", "countBytes", "", "writeOrCountBytes", "(Lokio/BufferedSink;Z)J", "", "index", "part", "(I)Lokhttp3/MultipartBody$Part;", "contentType", "()Lokhttp3/MediaType;", "-deprecated_type", "", "-deprecated_boundary", "()Ljava/lang/String;", "boundary", "-deprecated_size", "()I", "size", "-deprecated_parts", "()Ljava/util/List;", "contentLength", "()J", "Lie/H;", "writeTo", "(Lokio/BufferedSink;)V", "Lokio/ByteString;", "Lokhttp3/MediaType;", "Ljava/util/List;", "J", "Companion", "Builder", "Part", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MultipartBody extends RequestBody {
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000B\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u0003J \u0010\u000B\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020\u00032\b\u0010\u000E\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000F\u001A\u00020\u0010J\u0018\u0010\u0011\u001A\u00020\u00002\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u000F\u001A\u00020\u0010J\u000E\u0010\u0011\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\bJ\u000E\u0010\u0011\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u0010J\u0006\u0010\u0015\u001A\u00020\u0016J\u000E\u0010\u0017\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\nR\u000E\u0010\u0002\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokhttp3/MultipartBody$Builder;", "", "boundary", "", "(Ljava/lang/String;)V", "Lokio/ByteString;", "parts", "", "Lokhttp3/MultipartBody$Part;", "type", "Lokhttp3/MediaType;", "addFormDataPart", "name", "value", "filename", "body", "Lokhttp3/RequestBody;", "addPart", "headers", "Lokhttp3/Headers;", "part", "build", "Lokhttp3/MultipartBody;", "setType", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder {
        @NotNull
        private final ByteString boundary;
        @NotNull
        private final List parts;
        @NotNull
        private MediaType type;

        public Builder() {
            this(null, 1, null);
        }

        public Builder(@NotNull String s) {
            q.g(s, "boundary");
            super();
            this.boundary = ByteString.Companion.encodeUtf8(s);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        public Builder(String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "20e26434-386d-47fb-befe-c7390a313888";
                q.f("20e26434-386d-47fb-befe-c7390a313888", "randomUUID().toString()");
            }
            this(s);
        }

        @NotNull
        public final Builder addFormDataPart(@NotNull String s, @NotNull String s1) {
            q.g(s, "name");
            q.g(s1, "value");
            this.addPart(Part.Companion.createFormData(s, s1));
            return this;
        }

        @NotNull
        public final Builder addFormDataPart(@NotNull String s, @Nullable String s1, @NotNull RequestBody requestBody0) {
            q.g(s, "name");
            q.g(requestBody0, "body");
            this.addPart(Part.Companion.createFormData(s, s1, requestBody0));
            return this;
        }

        @NotNull
        public final Builder addPart(@Nullable Headers headers0, @NotNull RequestBody requestBody0) {
            q.g(requestBody0, "body");
            this.addPart(Part.Companion.create(headers0, requestBody0));
            return this;
        }

        @NotNull
        public final Builder addPart(@NotNull Part multipartBody$Part0) {
            q.g(multipartBody$Part0, "part");
            this.parts.add(multipartBody$Part0);
            return this;
        }

        @NotNull
        public final Builder addPart(@NotNull RequestBody requestBody0) {
            q.g(requestBody0, "body");
            this.addPart(Part.Companion.create(requestBody0));
            return this;
        }

        @NotNull
        public final MultipartBody build() {
            if(this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            MediaType mediaType0 = this.type;
            List list0 = Util.toImmutableList(this.parts);
            return new MultipartBody(this.boundary, mediaType0, list0);
        }

        @NotNull
        public final Builder setType(@NotNull MediaType mediaType0) {
            q.g(mediaType0, "type");
            if(!q.b(mediaType0.type(), "multipart")) {
                throw new IllegalArgumentException(("multipart != " + mediaType0).toString());
            }
            this.type = mediaType0;
            return this;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u000B\u001A\u00020\b*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0007\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\r\u001A\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000ER\u0014\u0010\u0010\u001A\u00020\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001A\u00020\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001A\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000ER\u0014\u0010\u0015\u001A\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000ER\u0014\u0010\u0016\u001A\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000ER\u0014\u0010\u0017\u001A\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u000E¨\u0006\u0018"}, d2 = {"Lokhttp3/MultipartBody$Companion;", "", "<init>", "()V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "key", "Lie/H;", "appendQuotedString$okhttp", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "appendQuotedString", "Lokhttp3/MediaType;", "ALTERNATIVE", "Lokhttp3/MediaType;", "", "COLONSPACE", "[B", "CRLF", "DASHDASH", "DIGEST", "FORM", "MIXED", "PARALLEL", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final void appendQuotedString$okhttp(@NotNull StringBuilder stringBuilder0, @NotNull String s) {
            q.g(stringBuilder0, "<this>");
            q.g(s, "key");
            stringBuilder0.append('\"');
            int v = s.length();
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = s.charAt(v1);
                if(v2 == 10) {
                    stringBuilder0.append("%0A");
                }
                else {
                    switch(v2) {
                        case 13: {
                            stringBuilder0.append("%0D");
                            break;
                        }
                        case 34: {
                            stringBuilder0.append("%22");
                            break;
                        }
                        default: {
                            stringBuilder0.append(((char)v2));
                        }
                    }
                }
            }
            stringBuilder0.append('\"');
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB\u0019\b\u0002\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\b\tJ\u000F\u0010\u0002\u001A\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\nR\u0013\u0010\u0004\u001A\u00020\u00058\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0007R\u0015\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\b¨\u0006\f"}, d2 = {"Lokhttp3/MultipartBody$Part;", "", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "(Lokhttp3/Headers;Lokhttp3/RequestBody;)V", "()Lokhttp3/RequestBody;", "()Lokhttp3/Headers;", "-deprecated_body", "-deprecated_headers", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Part {
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001A\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0007J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\bH\u0007J\u0018\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0007J\"\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0007\u001A\u00020\bH\u0007¨\u0006\u000E"}, d2 = {"Lokhttp3/MultipartBody$Part$Companion;", "", "()V", "create", "Lokhttp3/MultipartBody$Part;", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "createFormData", "name", "", "value", "filename", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class okhttp3.MultipartBody.Part.Companion {
            private okhttp3.MultipartBody.Part.Companion() {
            }

            public okhttp3.MultipartBody.Part.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final Part create(@Nullable Headers headers0, @NotNull RequestBody requestBody0) {
                q.g(requestBody0, "body");
                if((headers0 == null ? null : headers0.get("Content-Type")) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if((headers0 == null ? null : headers0.get("Content-Length")) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Length");
                }
                return new Part(headers0, requestBody0, null);
            }

            @NotNull
            public final Part create(@NotNull RequestBody requestBody0) {
                q.g(requestBody0, "body");
                return this.create(null, requestBody0);
            }

            @NotNull
            public final Part createFormData(@NotNull String s, @NotNull String s1) {
                q.g(s, "name");
                q.g(s1, "value");
                return this.createFormData(s, null, okhttp3.RequestBody.Companion.create$default(RequestBody.Companion, s1, null, 1, null));
            }

            @NotNull
            public final Part createFormData(@NotNull String s, @Nullable String s1, @NotNull RequestBody requestBody0) {
                q.g(s, "name");
                q.g(requestBody0, "body");
                StringBuilder stringBuilder0 = new StringBuilder();
                stringBuilder0.append("form-data; name=");
                Companion multipartBody$Companion0 = MultipartBody.Companion;
                multipartBody$Companion0.appendQuotedString$okhttp(stringBuilder0, s);
                if(s1 != null) {
                    stringBuilder0.append("; filename=");
                    multipartBody$Companion0.appendQuotedString$okhttp(stringBuilder0, s1);
                }
                String s2 = stringBuilder0.toString();
                q.f(s2, "StringBuilder().apply(builderAction).toString()");
                return this.create(new okhttp3.Headers.Builder().addUnsafeNonAscii("Content-Disposition", s2).build(), requestBody0);
            }
        }

        @NotNull
        public static final okhttp3.MultipartBody.Part.Companion Companion;
        @NotNull
        private final RequestBody body;
        @Nullable
        private final Headers headers;

        @d
        @NotNull
        public final RequestBody -deprecated_body() {
            return this.body;
        }

        @d
        @Nullable
        public final Headers -deprecated_headers() {
            return this.headers;
        }

        static {
            Part.Companion = new okhttp3.MultipartBody.Part.Companion(null);
        }

        private Part(Headers headers0, RequestBody requestBody0) {
            this.headers = headers0;
            this.body = requestBody0;
        }

        public Part(Headers headers0, RequestBody requestBody0, DefaultConstructorMarker defaultConstructorMarker0) {
            this(headers0, requestBody0);
        }

        @NotNull
        public final RequestBody body() {
            return this.body;
        }

        @NotNull
        public static final Part create(@Nullable Headers headers0, @NotNull RequestBody requestBody0) {
            return Part.Companion.create(headers0, requestBody0);
        }

        @NotNull
        public static final Part create(@NotNull RequestBody requestBody0) {
            return Part.Companion.create(requestBody0);
        }

        @NotNull
        public static final Part createFormData(@NotNull String s, @NotNull String s1) {
            return Part.Companion.createFormData(s, s1);
        }

        @NotNull
        public static final Part createFormData(@NotNull String s, @Nullable String s1, @NotNull RequestBody requestBody0) {
            return Part.Companion.createFormData(s, s1, requestBody0);
        }

        @Nullable
        public final Headers headers() {
            return this.headers;
        }
    }

    @NotNull
    public static final MediaType ALTERNATIVE;
    @NotNull
    private static final byte[] COLONSPACE;
    @NotNull
    private static final byte[] CRLF;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final byte[] DASHDASH;
    @NotNull
    public static final MediaType DIGEST;
    @NotNull
    public static final MediaType FORM;
    @NotNull
    public static final MediaType MIXED;
    @NotNull
    public static final MediaType PARALLEL;
    @NotNull
    private final ByteString boundaryByteString;
    private long contentLength;
    @NotNull
    private final MediaType contentType;
    @NotNull
    private final List parts;
    @NotNull
    private final MediaType type;

    @d
    @NotNull
    public final String -deprecated_boundary() {
        return this.boundary();
    }

    @d
    @NotNull
    public final List -deprecated_parts() {
        return this.parts;
    }

    @d
    public final int -deprecated_size() {
        return this.size();
    }

    @d
    @NotNull
    public final MediaType -deprecated_type() {
        return this.type;
    }

    static {
        MultipartBody.Companion = new Companion(null);
        MultipartBody.MIXED = MediaType.Companion.get("multipart/mixed");
        MultipartBody.ALTERNATIVE = MediaType.Companion.get("multipart/alternative");
        MultipartBody.DIGEST = MediaType.Companion.get("multipart/digest");
        MultipartBody.PARALLEL = MediaType.Companion.get("multipart/parallel");
        MultipartBody.FORM = MediaType.Companion.get("multipart/form-data");
        MultipartBody.COLONSPACE = new byte[]{58, 0x20};
        MultipartBody.CRLF = new byte[]{13, 10};
        MultipartBody.DASHDASH = new byte[]{45, 45};
    }

    public MultipartBody(@NotNull ByteString byteString0, @NotNull MediaType mediaType0, @NotNull List list0) {
        q.g(byteString0, "boundaryByteString");
        q.g(mediaType0, "type");
        q.g(list0, "parts");
        super();
        this.boundaryByteString = byteString0;
        this.type = mediaType0;
        this.parts = list0;
        this.contentType = MediaType.Companion.get(mediaType0 + "; boundary=" + this.boundary());
        this.contentLength = -1L;
    }

    @NotNull
    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    @Override  // okhttp3.RequestBody
    public long contentLength() {
        long v = this.contentLength;
        if(v == -1L) {
            v = this.writeOrCountBytes(null, true);
            this.contentLength = v;
        }
        return v;
    }

    @Override  // okhttp3.RequestBody
    @NotNull
    public MediaType contentType() {
        return this.contentType;
    }

    @NotNull
    public final Part part(int v) {
        return (Part)this.parts.get(v);
    }

    @NotNull
    public final List parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    @NotNull
    public final MediaType type() {
        return this.type;
    }

    private final long writeOrCountBytes(BufferedSink bufferedSink0, boolean z) {
        BufferedSink bufferedSink1;
        if(z) {
            bufferedSink0 = new Buffer();
            bufferedSink1 = bufferedSink0;
        }
        else {
            bufferedSink1 = null;
        }
        int v = this.parts.size();
        long v1 = 0L;
        for(int v2 = 0; v2 < v; ++v2) {
            Part multipartBody$Part0 = (Part)this.parts.get(v2);
            Headers headers0 = multipartBody$Part0.headers();
            RequestBody requestBody0 = multipartBody$Part0.body();
            q.d(bufferedSink0);
            bufferedSink0.write(MultipartBody.DASHDASH);
            bufferedSink0.write(this.boundaryByteString);
            bufferedSink0.write(MultipartBody.CRLF);
            if(headers0 != null) {
                int v3 = headers0.size();
                for(int v4 = 0; v4 < v3; ++v4) {
                    bufferedSink0.writeUtf8(headers0.name(v4)).write(MultipartBody.COLONSPACE).writeUtf8(headers0.value(v4)).write(MultipartBody.CRLF);
                }
            }
            MediaType mediaType0 = requestBody0.contentType();
            if(mediaType0 != null) {
                bufferedSink0.writeUtf8("Content-Type: ").writeUtf8(mediaType0.toString()).write(MultipartBody.CRLF);
            }
            long v5 = requestBody0.contentLength();
            if(v5 != -1L) {
                bufferedSink0.writeUtf8("Content-Length: ").writeDecimalLong(v5).write(MultipartBody.CRLF);
            }
            else if(z) {
                q.d(bufferedSink1);
                ((Buffer)bufferedSink1).clear();
                return -1L;
            }
            byte[] arr_b = MultipartBody.CRLF;
            bufferedSink0.write(arr_b);
            if(z) {
                v1 += v5;
            }
            else {
                requestBody0.writeTo(bufferedSink0);
            }
            bufferedSink0.write(arr_b);
        }
        q.d(bufferedSink0);
        bufferedSink0.write(MultipartBody.DASHDASH);
        bufferedSink0.write(this.boundaryByteString);
        bufferedSink0.write(MultipartBody.DASHDASH);
        bufferedSink0.write(MultipartBody.CRLF);
        if(z) {
            q.d(bufferedSink1);
            ((Buffer)bufferedSink1).clear();
            return ((Buffer)bufferedSink1).size() + v1;
        }
        return v1;
    }

    @Override  // okhttp3.RequestBody
    public void writeTo(@NotNull BufferedSink bufferedSink0) {
        q.g(bufferedSink0, "sink");
        this.writeOrCountBytes(bufferedSink0, false);
    }
}

