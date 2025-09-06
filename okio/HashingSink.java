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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001E2\u00020\u00012\u00020\u0002:\u0001\u001EB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u0006\u0010\rB!\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u000F\u001A\u00020\u000E\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u0006\u0010\u0010J\u001F\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u001A\u001A\u00020\u000EH\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001B\u001A\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0016\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001DR\u0011\u0010\u001A\u001A\u00020\u000E8G¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0019¨\u0006\u001F"}, d2 = {"Lokio/HashingSink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "sink", "Ljava/security/MessageDigest;", "digest", "<init>", "(Lokio/Sink;Ljava/security/MessageDigest;)V", "", "algorithm", "(Lokio/Sink;Ljava/lang/String;)V", "Ljavax/crypto/Mac;", "mac", "(Lokio/Sink;Ljavax/crypto/Mac;)V", "Lokio/ByteString;", "key", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "Lokio/Buffer;", "source", "", "byteCount", "Lie/H;", "write", "(Lokio/Buffer;J)V", "-deprecated_hash", "()Lokio/ByteString;", "hash", "messageDigest", "Ljava/security/MessageDigest;", "Ljavax/crypto/Mac;", "Companion", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class HashingSink extends ForwardingSink implements Sink {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\t\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0018\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0007J\u0018\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0007J\u0018\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0007¨\u0006\u0010"}, d2 = {"Lokio/HashingSink$Companion;", "", "<init>", "()V", "md5", "Lokio/HashingSink;", "sink", "Lokio/Sink;", "sha1", "sha256", "sha512", "hmacSha1", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final HashingSink hmacSha1(@NotNull Sink sink0, @NotNull ByteString byteString0) {
            q.g(sink0, "sink");
            q.g(byteString0, "key");
            return new HashingSink(sink0, byteString0, "HmacSHA1");
        }

        @NotNull
        public final HashingSink hmacSha256(@NotNull Sink sink0, @NotNull ByteString byteString0) {
            q.g(sink0, "sink");
            q.g(byteString0, "key");
            return new HashingSink(sink0, byteString0, "HmacSHA256");
        }

        @NotNull
        public final HashingSink hmacSha512(@NotNull Sink sink0, @NotNull ByteString byteString0) {
            q.g(sink0, "sink");
            q.g(byteString0, "key");
            return new HashingSink(sink0, byteString0, "HmacSHA512");
        }

        @NotNull
        public final HashingSink md5(@NotNull Sink sink0) {
            q.g(sink0, "sink");
            return new HashingSink(sink0, "MD5");
        }

        @NotNull
        public final HashingSink sha1(@NotNull Sink sink0) {
            q.g(sink0, "sink");
            return new HashingSink(sink0, "SHA-1");
        }

        @NotNull
        public final HashingSink sha256(@NotNull Sink sink0) {
            q.g(sink0, "sink");
            return new HashingSink(sink0, "SHA-256");
        }

        @NotNull
        public final HashingSink sha512(@NotNull Sink sink0) {
            q.g(sink0, "sink");
            return new HashingSink(sink0, "SHA-512");
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
        HashingSink.Companion = new Companion(null);
    }

    public HashingSink(@NotNull Sink sink0, @NotNull String s) {
        q.g(sink0, "sink");
        q.g(s, "algorithm");
        MessageDigest messageDigest0 = MessageDigest.getInstance(s);
        q.f(messageDigest0, "getInstance(...)");
        this(sink0, messageDigest0);
    }

    public HashingSink(@NotNull Sink sink0, @NotNull MessageDigest messageDigest0) {
        q.g(sink0, "sink");
        q.g(messageDigest0, "digest");
        super(sink0);
        this.messageDigest = messageDigest0;
        this.mac = null;
    }

    public HashingSink(@NotNull Sink sink0, @NotNull Mac mac0) {
        q.g(sink0, "sink");
        q.g(mac0, "mac");
        super(sink0);
        this.mac = mac0;
        this.messageDigest = null;
    }

    public HashingSink(@NotNull Sink sink0, @NotNull ByteString byteString0, @NotNull String s) {
        q.g(sink0, "sink");
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
        this(sink0, mac0);
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
    public static final HashingSink hmacSha1(@NotNull Sink sink0, @NotNull ByteString byteString0) {
        return HashingSink.Companion.hmacSha1(sink0, byteString0);
    }

    @NotNull
    public static final HashingSink hmacSha256(@NotNull Sink sink0, @NotNull ByteString byteString0) {
        return HashingSink.Companion.hmacSha256(sink0, byteString0);
    }

    @NotNull
    public static final HashingSink hmacSha512(@NotNull Sink sink0, @NotNull ByteString byteString0) {
        return HashingSink.Companion.hmacSha512(sink0, byteString0);
    }

    @NotNull
    public static final HashingSink md5(@NotNull Sink sink0) {
        return HashingSink.Companion.md5(sink0);
    }

    @NotNull
    public static final HashingSink sha1(@NotNull Sink sink0) {
        return HashingSink.Companion.sha1(sink0);
    }

    @NotNull
    public static final HashingSink sha256(@NotNull Sink sink0) {
        return HashingSink.Companion.sha256(sink0);
    }

    @NotNull
    public static final HashingSink sha512(@NotNull Sink sink0) {
        return HashingSink.Companion.sha512(sink0);
    }

    @Override  // okio.ForwardingSink, okio.Sink
    public void write(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "source");
        -SegmentedByteString.checkOffsetAndCount(buffer0.size(), 0L, v);
        Segment segment0 = buffer0.head;
        q.d(segment0);
        long v1 = 0L;
        while(v1 < v) {
            int v2 = (int)Math.min(v - v1, segment0.limit - segment0.pos);
            MessageDigest messageDigest0 = this.messageDigest;
            if(messageDigest0 == null) {
                q.d(this.mac);
                this.mac.update(segment0.data, segment0.pos, v2);
            }
            else {
                messageDigest0.update(segment0.data, segment0.pos, v2);
            }
            v1 += (long)v2;
            segment0 = segment0.next;
            q.d(segment0);
        }
        super.write(buffer0, v);
    }
}

