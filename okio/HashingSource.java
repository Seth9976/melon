package okio;

import ie.d;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001A2\u00020\u00012\u00020\u0002:\u0001\u001AB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\u0006\u0010\rB!\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u0006\u0010\u0010J\u0018\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0013H\u0016J\r\u0010\u0017\u001A\u00020\u000FH\u0007¢\u0006\u0002\b\u0019R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001A\u00020\u000F8G¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001B"}, d2 = {"Lokio/HashingSource;", "Lokio/ForwardingSource;", "Lokio/Source;", "source", "digest", "Ljava/security/MessageDigest;", "<init>", "(Lokio/Source;Ljava/security/MessageDigest;)V", "algorithm", "", "(Lokio/Source;Ljava/lang/String;)V", "mac", "Ljavax/crypto/Mac;", "(Lokio/Source;Ljavax/crypto/Mac;)V", "key", "Lokio/ByteString;", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "messageDigest", "read", "", "sink", "Lokio/Buffer;", "byteCount", "hash", "()Lokio/ByteString;", "-deprecated_hash", "Companion", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class HashingSource extends ForwardingSource implements Source {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\t\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0018\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0007J\u0018\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0007J\u0018\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0007¨\u0006\u0010"}, d2 = {"Lokio/HashingSource$Companion;", "", "<init>", "()V", "md5", "Lokio/HashingSource;", "source", "Lokio/Source;", "sha1", "sha256", "sha512", "hmacSha1", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final HashingSource hmacSha1(@NotNull Source source0, @NotNull ByteString byteString0) {
            q.g(source0, "source");
            q.g(byteString0, "key");
            return new HashingSource(source0, byteString0, "HmacSHA1");
        }

        @NotNull
        public final HashingSource hmacSha256(@NotNull Source source0, @NotNull ByteString byteString0) {
            q.g(source0, "source");
            q.g(byteString0, "key");
            return new HashingSource(source0, byteString0, "HmacSHA256");
        }

        @NotNull
        public final HashingSource hmacSha512(@NotNull Source source0, @NotNull ByteString byteString0) {
            q.g(source0, "source");
            q.g(byteString0, "key");
            return new HashingSource(source0, byteString0, "HmacSHA512");
        }

        @NotNull
        public final HashingSource md5(@NotNull Source source0) {
            q.g(source0, "source");
            return new HashingSource(source0, "MD5");
        }

        @NotNull
        public final HashingSource sha1(@NotNull Source source0) {
            q.g(source0, "source");
            return new HashingSource(source0, "SHA-1");
        }

        @NotNull
        public final HashingSource sha256(@NotNull Source source0) {
            q.g(source0, "source");
            return new HashingSource(source0, "SHA-256");
        }

        @NotNull
        public final HashingSource sha512(@NotNull Source source0) {
            q.g(source0, "source");
            return new HashingSource(source0, "SHA-512");
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private final Mac mac;
    @Nullable
    private final MessageDigest messageDigest;

    @d
    @NotNull
    public final ByteString -deprecated_hash() {
        return this.hash();
    }

    static {
        HashingSource.Companion = new Companion(null);
    }

    public HashingSource(@NotNull Source source0, @NotNull String s) {
        q.g(source0, "source");
        q.g(s, "algorithm");
        MessageDigest messageDigest0 = MessageDigest.getInstance(s);
        q.f(messageDigest0, "getInstance(...)");
        this(source0, messageDigest0);
    }

    public HashingSource(@NotNull Source source0, @NotNull MessageDigest messageDigest0) {
        q.g(source0, "source");
        q.g(messageDigest0, "digest");
        super(source0);
        this.messageDigest = messageDigest0;
        this.mac = null;
    }

    public HashingSource(@NotNull Source source0, @NotNull Mac mac0) {
        q.g(source0, "source");
        q.g(mac0, "mac");
        super(source0);
        this.mac = mac0;
        this.messageDigest = null;
    }

    public HashingSource(@NotNull Source source0, @NotNull ByteString byteString0, @NotNull String s) {
        q.g(source0, "source");
        Mac mac0;
        q.g(byteString0, "key");
        q.g(s, "algorithm");
        try {
            mac0 = Mac.getInstance(s);
            mac0.init(new SecretKeySpec(byteString0.toByteArray(), s));
        }
        catch(InvalidKeyException invalidKeyException0) {
            throw new IllegalArgumentException(invalidKeyException0);
        }
        this(source0, mac0);
    }

    @NotNull
    public final ByteString hash() {
        byte[] arr_b;
        MessageDigest messageDigest0 = this.messageDigest;
        if(messageDigest0 == null) {
            q.d(this.mac);
            arr_b = this.mac.doFinal();
        }
        else {
            arr_b = messageDigest0.digest();
        }
        q.d(arr_b);
        return new ByteString(arr_b);
    }

    @NotNull
    public static final HashingSource hmacSha1(@NotNull Source source0, @NotNull ByteString byteString0) {
        return HashingSource.Companion.hmacSha1(source0, byteString0);
    }

    @NotNull
    public static final HashingSource hmacSha256(@NotNull Source source0, @NotNull ByteString byteString0) {
        return HashingSource.Companion.hmacSha256(source0, byteString0);
    }

    @NotNull
    public static final HashingSource hmacSha512(@NotNull Source source0, @NotNull ByteString byteString0) {
        return HashingSource.Companion.hmacSha512(source0, byteString0);
    }

    @NotNull
    public static final HashingSource md5(@NotNull Source source0) {
        return HashingSource.Companion.md5(source0);
    }

    @Override  // okio.ForwardingSource, okio.Source
    public long read(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "sink");
        long v1 = super.read(buffer0, v);
        if(v1 != -1L) {
            long v2 = buffer0.size() - v1;
            long v3 = buffer0.size();
            Segment segment0 = buffer0.head;
            q.d(segment0);
            while(v3 > v2) {
                segment0 = segment0.prev;
                q.d(segment0);
                v3 -= (long)(segment0.limit - segment0.pos);
            }
            while(v3 < buffer0.size()) {
                int v4 = (int)(((long)segment0.pos) + v2 - v3);
                MessageDigest messageDigest0 = this.messageDigest;
                if(messageDigest0 == null) {
                    q.d(this.mac);
                    this.mac.update(segment0.data, v4, segment0.limit - v4);
                }
                else {
                    messageDigest0.update(segment0.data, v4, segment0.limit - v4);
                }
                v3 += (long)(segment0.limit - segment0.pos);
                segment0 = segment0.next;
                q.d(segment0);
                v2 = v3;
            }
        }
        return v1;
    }

    @NotNull
    public static final HashingSource sha1(@NotNull Source source0) {
        return HashingSource.Companion.sha1(source0);
    }

    @NotNull
    public static final HashingSource sha256(@NotNull Source source0) {
        return HashingSource.Companion.sha256(source0);
    }

    @NotNull
    public static final HashingSource sha512(@NotNull Source source0) {
        return HashingSource.Companion.sha512(source0);
    }
}

