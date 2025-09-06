package okhttp3;

import ie.d;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0002#\"B%\b\u0000\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0012\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u000F¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u000F¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u000F¢\u0006\u0004\b\u0017\u0010\u0015J\u0015\u0010\u0018\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u000F¢\u0006\u0004\b\u0018\u0010\u0015J\u000F\u0010\u001A\u001A\u00020\u0019H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\fH\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u001F\u0010 R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010!R\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u0011\u0010\u0012\u001A\u00020\u000F8G¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0011¨\u0006$"}, d2 = {"Lokhttp3/FormBody;", "Lokhttp3/RequestBody;", "", "", "encodedNames", "encodedValues", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Lokio/BufferedSink;", "sink", "", "countBytes", "", "writeOrCountBytes", "(Lokio/BufferedSink;Z)J", "", "-deprecated_size", "()I", "size", "index", "encodedName", "(I)Ljava/lang/String;", "name", "encodedValue", "value", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "contentLength", "()J", "Lie/H;", "writeTo", "(Lokio/BufferedSink;)V", "Ljava/util/List;", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FormBody extends RequestBody {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u0007J\u0016\u0010\f\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u0007J\u0006\u0010\r\u001A\u00020\u000ER\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lokhttp3/FormBody$Builder;", "", "charset", "Ljava/nio/charset/Charset;", "(Ljava/nio/charset/Charset;)V", "names", "", "", "values", "add", "name", "value", "addEncoded", "build", "Lokhttp3/FormBody;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder {
        @Nullable
        private final Charset charset;
        @NotNull
        private final List names;
        @NotNull
        private final List values;

        public Builder() {
            this(null, 1, null);
        }

        public Builder(@Nullable Charset charset0) {
            this.charset = charset0;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public Builder(Charset charset0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                charset0 = null;
            }
            this(charset0);
        }

        @NotNull
        public final Builder add(@NotNull String s, @NotNull String s1) {
            q.g(s, "name");
            q.g(s1, "value");
            String s2 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, " \"\':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.charset, 91, null);
            this.names.add(s2);
            String s3 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, s1, 0, 0, " \"\':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.charset, 91, null);
            this.values.add(s3);
            return this;
        }

        @NotNull
        public final Builder addEncoded(@NotNull String s, @NotNull String s1) {
            q.g(s, "name");
            q.g(s1, "value");
            String s2 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, " \"\':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.charset, 83, null);
            this.names.add(s2);
            String s3 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, s1, 0, 0, " \"\':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.charset, 83, null);
            this.values.add(s3);
            return this;
        }

        @NotNull
        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/FormBody$Companion;", "", "()V", "CONTENT_TYPE", "Lokhttp3/MediaType;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class okhttp3.FormBody.Companion {
        private okhttp3.FormBody.Companion() {
        }

        public okhttp3.FormBody.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    private static final MediaType CONTENT_TYPE;
    @NotNull
    public static final okhttp3.FormBody.Companion Companion;
    @NotNull
    private final List encodedNames;
    @NotNull
    private final List encodedValues;

    @d
    public final int -deprecated_size() {
        return this.size();
    }

    static {
        FormBody.Companion = new okhttp3.FormBody.Companion(null);
        FormBody.CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");
    }

    public FormBody(@NotNull List list0, @NotNull List list1) {
        q.g(list0, "encodedNames");
        q.g(list1, "encodedValues");
        super();
        this.encodedNames = Util.toImmutableList(list0);
        this.encodedValues = Util.toImmutableList(list1);
    }

    @Override  // okhttp3.RequestBody
    public long contentLength() {
        return this.writeOrCountBytes(null, true);
    }

    @Override  // okhttp3.RequestBody
    @NotNull
    public MediaType contentType() {
        return FormBody.CONTENT_TYPE;
    }

    @NotNull
    public final String encodedName(int v) {
        return (String)this.encodedNames.get(v);
    }

    @NotNull
    public final String encodedValue(int v) {
        return (String)this.encodedValues.get(v);
    }

    @NotNull
    public final String name(int v) {
        String s = this.encodedName(v);
        return Companion.percentDecode$okhttp$default(HttpUrl.Companion, s, 0, 0, true, 3, null);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    @NotNull
    public final String value(int v) {
        String s = this.encodedValue(v);
        return Companion.percentDecode$okhttp$default(HttpUrl.Companion, s, 0, 0, true, 3, null);
    }

    private final long writeOrCountBytes(BufferedSink bufferedSink0, boolean z) {
        Buffer buffer0;
        if(z) {
            buffer0 = new Buffer();
        }
        else {
            q.d(bufferedSink0);
            buffer0 = bufferedSink0.getBuffer();
        }
        int v = this.encodedNames.size();
        for(int v1 = 0; v1 < v; ++v1) {
            if(v1 > 0) {
                buffer0.writeByte(38);
            }
            buffer0.writeUtf8(((String)this.encodedNames.get(v1)));
            buffer0.writeByte(61);
            buffer0.writeUtf8(((String)this.encodedValues.get(v1)));
        }
        if(z) {
            buffer0.clear();
            return buffer0.size();
        }
        return 0L;
    }

    @Override  // okhttp3.RequestBody
    public void writeTo(@NotNull BufferedSink bufferedSink0) {
        q.g(bufferedSink0, "sink");
        this.writeOrCountBytes(bufferedSink0, false);
    }
}

