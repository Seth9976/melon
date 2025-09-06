package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0006\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0007B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0006\u0012\u0006\u0010\u0004\u001A\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000B\u001A\u00020\u0006HÆ\u0003J\t\u0010\f\u001A\u00020\u0006HÆ\u0003J\u001D\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00062\b\b\u0002\u0010\u0004\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\nHÖ\u0001J\b\u0010\u0012\u001A\u00020\u0003H\u0016R\u0010\u0010\t\u001A\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001A\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/http2/Header;", "", "name", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "Lokio/ByteString;", "(Lokio/ByteString;Ljava/lang/String;)V", "(Lokio/ByteString;Lokio/ByteString;)V", "hpackSize", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Header {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http2/Header$Companion;", "", "()V", "PSEUDO_PREFIX", "Lokio/ByteString;", "RESPONSE_STATUS", "RESPONSE_STATUS_UTF8", "", "TARGET_AUTHORITY", "TARGET_AUTHORITY_UTF8", "TARGET_METHOD", "TARGET_METHOD_UTF8", "TARGET_PATH", "TARGET_PATH_UTF8", "TARGET_SCHEME", "TARGET_SCHEME_UTF8", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final ByteString PSEUDO_PREFIX = null;
    @NotNull
    public static final ByteString RESPONSE_STATUS = null;
    @NotNull
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    @NotNull
    public static final ByteString TARGET_AUTHORITY = null;
    @NotNull
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    @NotNull
    public static final ByteString TARGET_METHOD = null;
    @NotNull
    public static final String TARGET_METHOD_UTF8 = ":method";
    @NotNull
    public static final ByteString TARGET_PATH = null;
    @NotNull
    public static final String TARGET_PATH_UTF8 = ":path";
    @NotNull
    public static final ByteString TARGET_SCHEME = null;
    @NotNull
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    @NotNull
    public final ByteString name;
    @NotNull
    public final ByteString value;

    static {
        Header.Companion = new Companion(null);
        Header.PSEUDO_PREFIX = ByteString.Companion.encodeUtf8(":");
        Header.RESPONSE_STATUS = ByteString.Companion.encodeUtf8(":status");
        Header.TARGET_METHOD = ByteString.Companion.encodeUtf8(":method");
        Header.TARGET_PATH = ByteString.Companion.encodeUtf8(":path");
        Header.TARGET_SCHEME = ByteString.Companion.encodeUtf8(":scheme");
        Header.TARGET_AUTHORITY = ByteString.Companion.encodeUtf8(":authority");
    }

    public Header(@NotNull String s, @NotNull String s1) {
        q.g(s, "name");
        q.g(s1, "value");
        this(ByteString.Companion.encodeUtf8(s), ByteString.Companion.encodeUtf8(s1));
    }

    public Header(@NotNull ByteString byteString0, @NotNull String s) {
        q.g(byteString0, "name");
        q.g(s, "value");
        this(byteString0, ByteString.Companion.encodeUtf8(s));
    }

    public Header(@NotNull ByteString byteString0, @NotNull ByteString byteString1) {
        q.g(byteString0, "name");
        q.g(byteString1, "value");
        super();
        this.name = byteString0;
        this.value = byteString1;
        this.hpackSize = byteString1.size() + (byteString0.size() + 0x20);
    }

    @NotNull
    public final ByteString component1() {
        return this.name;
    }

    @NotNull
    public final ByteString component2() {
        return this.value;
    }

    @NotNull
    public final Header copy(@NotNull ByteString byteString0, @NotNull ByteString byteString1) {
        q.g(byteString0, "name");
        q.g(byteString1, "value");
        return new Header(byteString0, byteString1);
    }

    public static Header copy$default(Header header0, ByteString byteString0, ByteString byteString1, int v, Object object0) {
        if((v & 1) != 0) {
            byteString0 = header0.name;
        }
        if((v & 2) != 0) {
            byteString1 = header0.value;
        }
        return header0.copy(byteString0, byteString1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Header)) {
            return false;
        }
        return q.b(this.name, ((Header)object0).name) ? q.b(this.value, ((Header)object0).value) : false;
    }

    @Override
    public int hashCode() {
        return this.value.hashCode() + this.name.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }
}

