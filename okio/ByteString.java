package okio;

import Tf.a;
import Tf.v;
import androidx.appcompat.app.o;
import ie.d;
import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okio.internal.-ByteString;
import okio.internal.-ByteStringNonJs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0016\u0018\u0000 v2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001vB\u0011\b\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u000E\u0010\tJ\r\u0010\u000F\u001A\u00020\u0000\u00A2\u0006\u0004\b\u000F\u0010\u0010J\r\u0010\u0011\u001A\u00020\u0000\u00A2\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001A\u00020\u0000\u00A2\u0006\u0004\b\u0012\u0010\u0010J\r\u0010\u0013\u001A\u00020\u0000\u00A2\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0017\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u0007H\u0010\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001A\u00020\u00002\u0006\u0010\u0018\u001A\u00020\u0000H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001B\u001A\u00020\u00002\u0006\u0010\u0018\u001A\u00020\u0000H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\u00002\u0006\u0010\u0018\u001A\u00020\u0000H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001AJ\u001F\u0010\u001F\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0018\u001A\u00020\u0000H\u0010\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010 \u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b \u0010\tJ\u000F\u0010!\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b!\u0010\tJ\u000F\u0010\"\u001A\u00020\u0000H\u0016\u00A2\u0006\u0004\b\"\u0010\u0010J\u000F\u0010#\u001A\u00020\u0000H\u0016\u00A2\u0006\u0004\b#\u0010\u0010J#\u0010\'\u001A\u00020\u00002\b\b\u0002\u0010%\u001A\u00020$2\b\b\u0002\u0010&\u001A\u00020$H\u0017\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010-\u001A\u00020*2\u0006\u0010)\u001A\u00020$H\u0010\u00A2\u0006\u0004\b+\u0010,J\u0018\u00100\u001A\u00020*2\u0006\u0010.\u001A\u00020$H\u0087\u0002\u00A2\u0006\u0004\b/\u0010,J\u000F\u00103\u001A\u00020$H\u0010\u00A2\u0006\u0004\b1\u00102J\u000F\u00104\u001A\u00020\u0003H\u0016\u00A2\u0006\u0004\b4\u00105J\u000F\u00107\u001A\u00020\u0003H\u0010\u00A2\u0006\u0004\b6\u00105J\u000F\u00109\u001A\u000208H\u0016\u00A2\u0006\u0004\b9\u0010:J\u0017\u0010>\u001A\u00020=2\u0006\u0010<\u001A\u00020;H\u0016\u00A2\u0006\u0004\b>\u0010?J\'\u0010>\u001A\u00020=2\u0006\u0010A\u001A\u00020@2\u0006\u0010B\u001A\u00020$2\u0006\u0010C\u001A\u00020$H\u0010\u00A2\u0006\u0004\bD\u0010EJ/\u0010I\u001A\u00020H2\u0006\u0010B\u001A\u00020$2\u0006\u0010F\u001A\u00020\u00002\u0006\u0010G\u001A\u00020$2\u0006\u0010C\u001A\u00020$H\u0016\u00A2\u0006\u0004\bI\u0010JJ/\u0010I\u001A\u00020H2\u0006\u0010B\u001A\u00020$2\u0006\u0010F\u001A\u00020\u00032\u0006\u0010G\u001A\u00020$2\u0006\u0010C\u001A\u00020$H\u0016\u00A2\u0006\u0004\bI\u0010KJ3\u0010N\u001A\u00020=2\b\b\u0002\u0010B\u001A\u00020$2\u0006\u0010L\u001A\u00020\u00032\b\b\u0002\u0010M\u001A\u00020$2\u0006\u0010C\u001A\u00020$H\u0016\u00A2\u0006\u0004\bN\u0010OJ\u0015\u0010Q\u001A\u00020H2\u0006\u0010P\u001A\u00020\u0000\u00A2\u0006\u0004\bQ\u0010RJ\u0015\u0010Q\u001A\u00020H2\u0006\u0010P\u001A\u00020\u0003\u00A2\u0006\u0004\bQ\u0010SJ\u0015\u0010U\u001A\u00020H2\u0006\u0010T\u001A\u00020\u0000\u00A2\u0006\u0004\bU\u0010RJ\u0015\u0010U\u001A\u00020H2\u0006\u0010T\u001A\u00020\u0003\u00A2\u0006\u0004\bU\u0010SJ!\u0010W\u001A\u00020$2\u0006\u0010F\u001A\u00020\u00002\b\b\u0002\u0010V\u001A\u00020$H\u0007\u00A2\u0006\u0004\bW\u0010XJ!\u0010W\u001A\u00020$2\u0006\u0010F\u001A\u00020\u00032\b\b\u0002\u0010V\u001A\u00020$H\u0017\u00A2\u0006\u0004\bW\u0010YJ!\u0010Z\u001A\u00020$2\u0006\u0010F\u001A\u00020\u00002\b\b\u0002\u0010V\u001A\u00020$H\u0007\u00A2\u0006\u0004\bZ\u0010XJ!\u0010Z\u001A\u00020$2\u0006\u0010F\u001A\u00020\u00032\b\b\u0002\u0010V\u001A\u00020$H\u0017\u00A2\u0006\u0004\bZ\u0010YJ\u001A\u0010\\\u001A\u00020H2\b\u0010F\u001A\u0004\u0018\u00010[H\u0096\u0002\u00A2\u0006\u0004\b\\\u0010]J\u000F\u0010^\u001A\u00020$H\u0016\u00A2\u0006\u0004\b^\u00102J\u0018\u0010_\u001A\u00020$2\u0006\u0010F\u001A\u00020\u0000H\u0096\u0002\u00A2\u0006\u0004\b_\u0010`J\u000F\u0010a\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\ba\u0010\tJ\u0017\u0010/\u001A\u00020*2\u0006\u0010.\u001A\u00020$H\u0007\u00A2\u0006\u0004\bb\u0010,J\u000F\u0010d\u001A\u00020$H\u0007\u00A2\u0006\u0004\bc\u00102J\u0017\u0010g\u001A\u00020=2\u0006\u0010f\u001A\u00020eH\u0002\u00A2\u0006\u0004\bg\u0010hJ\u0017\u0010j\u001A\u00020=2\u0006\u0010<\u001A\u00020iH\u0002\u00A2\u0006\u0004\bj\u0010kR\u001A\u0010\u0004\u001A\u00020\u00038\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0004\u0010l\u001A\u0004\bm\u00105R\"\u0010^\u001A\u00020$8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b^\u0010n\u001A\u0004\bo\u00102\"\u0004\bp\u0010qR$\u0010\b\u001A\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\b\u0010r\u001A\u0004\bs\u0010\t\"\u0004\bt\u0010uR\u0011\u0010d\u001A\u00020$8G\u00A2\u0006\u0006\u001A\u0004\bd\u00102\u00A8\u0006w"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "", "data", "<init>", "([B)V", "", "utf8", "()Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "string", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", "md5", "()Lokio/ByteString;", "sha1", "sha256", "sha512", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "key", "hmacSha1", "(Lokio/ByteString;)Lokio/ByteString;", "hmacSha256", "hmacSha512", "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "hex", "toAsciiLowercase", "toAsciiUppercase", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", "", "internalGet$okio", "(I)B", "internalGet", "index", "getByte", "get", "getSize$okio", "()I", "getSize", "toByteArray", "()[B", "internalArray$okio", "internalArray", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "out", "Lie/H;", "write", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "offset", "byteCount", "write$okio", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "target", "targetOffset", "copyInto", "(I[BII)V", "prefix", "startsWith", "(Lokio/ByteString;)Z", "([B)Z", "suffix", "endsWith", "fromIndex", "indexOf", "(Lokio/ByteString;I)I", "([BI)I", "lastIndexOf", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "compareTo", "(Lokio/ByteString;)I", "toString", "-deprecated_getByte", "-deprecated_size", "size", "Ljava/io/ObjectInputStream;", "in", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "[B", "getData$okio", "I", "getHashCode$okio", "setHashCode$okio", "(I)V", "Ljava/lang/String;", "getUtf8$okio", "setUtf8$okio", "(Ljava/lang/String;)V", "Companion", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class ByteString implements Serializable, Comparable {
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001A\u00020\u00072\n\u0010\t\u001A\u00020\n\"\u00020\u000BH\u0007J%\u0010\f\u001A\u00020\u0007*\u00020\n2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000EH\u0007\u00A2\u0006\u0002\b\bJ\u0011\u0010\f\u001A\u00020\u0007*\u00020\u0010H\u0007\u00A2\u0006\u0002\b\bJ\f\u0010\u0011\u001A\u00020\u0007*\u00020\u0012H\u0007J\u001B\u0010\u0013\u001A\u00020\u0007*\u00020\u00122\b\b\u0002\u0010\u0014\u001A\u00020\u0015H\u0007\u00A2\u0006\u0002\b\u0016J\u000E\u0010\u0017\u001A\u0004\u0018\u00010\u0007*\u00020\u0012H\u0007J\f\u0010\u0018\u001A\u00020\u0007*\u00020\u0012H\u0007J\u0019\u0010\u0019\u001A\u00020\u0007*\u00020\u001A2\u0006\u0010\u000F\u001A\u00020\u000EH\u0007\u00A2\u0006\u0002\b\u001BJ\u0017\u0010\u0017\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u001C\u001A\u00020\u0012H\u0007\u00A2\u0006\u0002\b\u001DJ\u0015\u0010\u0018\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u0012H\u0007\u00A2\u0006\u0002\b\u001EJ\u001D\u0010\u0016\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0015H\u0007\u00A2\u0006\u0002\b\u001FJ\u0015\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u0012H\u0007\u00A2\u0006\u0002\b J\u0015\u0010\b\u001A\u00020\u00072\u0006\u0010!\u001A\u00020\u0010H\u0007\u00A2\u0006\u0002\b\"J%\u0010\b\u001A\u00020\u00072\u0006\u0010#\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH\u0007\u00A2\u0006\u0002\b\"J\u001D\u0010\u001B\u001A\u00020\u00072\u0006\u0010$\u001A\u00020\u001A2\u0006\u0010\u000F\u001A\u00020\u000EH\u0007\u00A2\u0006\u0002\b%R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T\u00A2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004\u00A2\u0006\u0002\n\u0000\u00A8\u0006&"}, d2 = {"Lokio/ByteString$Companion;", "", "<init>", "()V", "serialVersionUID", "", "EMPTY", "Lokio/ByteString;", "of", "data", "", "", "toByteString", "offset", "", "byteCount", "Ljava/nio/ByteBuffer;", "encodeUtf8", "", "encode", "charset", "Ljava/nio/charset/Charset;", "encodeString", "decodeBase64", "decodeHex", "readByteString", "Ljava/io/InputStream;", "read", "string", "-deprecated_decodeBase64", "-deprecated_decodeHex", "-deprecated_encodeString", "-deprecated_encodeUtf8", "buffer", "-deprecated_of", "array", "inputstream", "-deprecated_read", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Companion {
        @d
        @Nullable
        public final ByteString -deprecated_decodeBase64(@NotNull String s) {
            q.g(s, "string");
            return this.decodeBase64(s);
        }

        @d
        @NotNull
        public final ByteString -deprecated_decodeHex(@NotNull String s) {
            q.g(s, "string");
            return this.decodeHex(s);
        }

        @d
        @NotNull
        public final ByteString -deprecated_encodeString(@NotNull String s, @NotNull Charset charset0) {
            q.g(s, "string");
            q.g(charset0, "charset");
            return this.encodeString(s, charset0);
        }

        @d
        @NotNull
        public final ByteString -deprecated_encodeUtf8(@NotNull String s) {
            q.g(s, "string");
            return this.encodeUtf8(s);
        }

        @d
        @NotNull
        public final ByteString -deprecated_of(@NotNull ByteBuffer byteBuffer0) {
            q.g(byteBuffer0, "buffer");
            return this.of(byteBuffer0);
        }

        @d
        @NotNull
        public final ByteString -deprecated_of(@NotNull byte[] arr_b, int v, int v1) {
            q.g(arr_b, "array");
            return this.of(arr_b, v, v1);
        }

        @d
        @NotNull
        public final ByteString -deprecated_read(@NotNull InputStream inputStream0, int v) {
            q.g(inputStream0, "inputstream");
            return this.read(inputStream0, v);
        }

        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final ByteString decodeBase64(@NotNull String s) {
            q.g(s, "<this>");
            byte[] arr_b = -Base64.decodeBase64ToArray(s);
            return arr_b == null ? null : new ByteString(arr_b);
        }

        @NotNull
        public final ByteString decodeHex(@NotNull String s) {
            q.g(s, "<this>");
            if(s.length() % 2 != 0) {
                throw new IllegalArgumentException(("Unexpected hex string: " + s).toString());
            }
            int v = s.length();
            byte[] arr_b = new byte[v / 2];
            for(int v1 = 0; v1 < v / 2; ++v1) {
                int v2 = -ByteStringNonJs.access$decodeHexDigit(s.charAt(v1 * 2));
                arr_b[v1] = (byte)(-ByteStringNonJs.access$decodeHexDigit(s.charAt(v1 * 2 + 1)) + (v2 << 4));
            }
            return new ByteString(arr_b);
        }

        @NotNull
        public final ByteString encodeString(@NotNull String s, @NotNull Charset charset0) {
            q.g(s, "<this>");
            q.g(charset0, "charset");
            byte[] arr_b = s.getBytes(charset0);
            q.f(arr_b, "getBytes(...)");
            return new ByteString(arr_b);
        }

        public static ByteString encodeString$default(Companion byteString$Companion0, String s, Charset charset0, int v, Object object0) {
            if((v & 1) != 0) {
                charset0 = a.a;
            }
            return byteString$Companion0.encodeString(s, charset0);
        }

        @NotNull
        public final ByteString encodeUtf8(@NotNull String s) {
            q.g(s, "<this>");
            ByteString byteString0 = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(s));
            byteString0.setUtf8$okio(s);
            return byteString0;
        }

        @NotNull
        public final ByteString of(@NotNull ByteBuffer byteBuffer0) {
            q.g(byteBuffer0, "<this>");
            byte[] arr_b = new byte[byteBuffer0.remaining()];
            byteBuffer0.get(arr_b);
            return new ByteString(arr_b);
        }

        @NotNull
        public final ByteString of(@NotNull byte[] arr_b) {
            q.g(arr_b, "data");
            byte[] arr_b1 = Arrays.copyOf(arr_b, arr_b.length);
            q.f(arr_b1, "copyOf(...)");
            return new ByteString(arr_b1);
        }

        @NotNull
        public final ByteString of(@NotNull byte[] arr_b, int v, int v1) {
            q.g(arr_b, "<this>");
            int v2 = -SegmentedByteString.resolveDefaultParameter(arr_b, v1);
            -SegmentedByteString.checkOffsetAndCount(arr_b.length, v, v2);
            return new ByteString(n.Z(arr_b, v, v2 + v));
        }

        public static ByteString of$default(Companion byteString$Companion0, byte[] arr_b, int v, int v1, int v2, Object object0) {
            if((v2 & 1) != 0) {
                v = 0;
            }
            if((v2 & 2) != 0) {
                v1 = 0xB669FD2E;
            }
            return byteString$Companion0.of(arr_b, v, v1);
        }

        @NotNull
        public final ByteString read(@NotNull InputStream inputStream0, int v) {
            q.g(inputStream0, "<this>");
            if(v < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + v).toString());
            }
            byte[] arr_b = new byte[v];
            for(int v1 = 0; v1 < v; v1 += v2) {
                int v2 = inputStream0.read(arr_b, v1, v - v1);
                if(v2 == -1) {
                    throw new EOFException();
                }
            }
            return new ByteString(arr_b);
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final ByteString EMPTY = null;
    @NotNull
    private final byte[] data;
    private transient int hashCode;
    private static final long serialVersionUID = 1L;
    @Nullable
    private transient String utf8;

    @d
    public final byte -deprecated_getByte(int v) {
        return this.getByte(v);
    }

    @d
    public final int -deprecated_size() {
        return this.size();
    }

    static {
        ByteString.Companion = new Companion(null);
        ByteString.EMPTY = new ByteString(new byte[0]);
    }

    public ByteString(@NotNull byte[] arr_b) {
        q.g(arr_b, "data");
        super();
        this.data = arr_b;
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        q.f(byteBuffer0, "asReadOnlyBuffer(...)");
        return byteBuffer0;
    }

    @NotNull
    public String base64() {
        return -Base64.encodeBase64$default(this.getData$okio(), null, 1, null);
    }

    // 去混淆评级： 低(20)
    @NotNull
    public String base64Url() {
        return -Base64.encodeBase64(this.getData$okio(), new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 0x4F, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 120, 0x79, 0x7A, 0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 0x5F});
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((ByteString)object0));
    }

    public int compareTo(@NotNull ByteString byteString0) {
        q.g(byteString0, "other");
        int v = this.size();
        int v1 = byteString0.size();
        int v2 = Math.min(v, v1);
        int v3 = 0;
        while(v3 < v2) {
            int v4 = this.getByte(v3) & 0xFF;
            int v5 = byteString0.getByte(v3) & 0xFF;
            if(v4 == v5) {
                ++v3;
                continue;
            }
            return v4 >= v5 ? 1 : -1;
        }
        if(v == v1) {
            return 0;
        }
        return v >= v1 ? 1 : -1;
    }

    public void copyInto(int v, @NotNull byte[] arr_b, int v1, int v2) {
        q.g(arr_b, "target");
        n.T(this.getData$okio(), v1, v, arr_b, v2 + v);
    }

    public static void copyInto$default(ByteString byteString0, int v, byte[] arr_b, int v1, int v2, int v3, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
        }
        if((v3 & 1) != 0) {
            v = 0;
        }
        if((v3 & 4) != 0) {
            v1 = 0;
        }
        byteString0.copyInto(v, arr_b, v1, v2);
    }

    @Nullable
    public static final ByteString decodeBase64(@NotNull String s) {
        return ByteString.Companion.decodeBase64(s);
    }

    @NotNull
    public static final ByteString decodeHex(@NotNull String s) {
        return ByteString.Companion.decodeHex(s);
    }

    @NotNull
    public ByteString digest$okio(@NotNull String s) {
        q.g(s, "algorithm");
        MessageDigest messageDigest0 = MessageDigest.getInstance(s);
        messageDigest0.update(this.data, 0, this.size());
        byte[] arr_b = messageDigest0.digest();
        q.d(arr_b);
        return new ByteString(arr_b);
    }

    @NotNull
    public static final ByteString encodeString(@NotNull String s, @NotNull Charset charset0) {
        return ByteString.Companion.encodeString(s, charset0);
    }

    @NotNull
    public static final ByteString encodeUtf8(@NotNull String s) {
        return ByteString.Companion.encodeUtf8(s);
    }

    public final boolean endsWith(@NotNull ByteString byteString0) {
        q.g(byteString0, "suffix");
        return this.rangeEquals(this.size() - byteString0.size(), byteString0, 0, byteString0.size());
    }

    public final boolean endsWith(@NotNull byte[] arr_b) {
        q.g(arr_b, "suffix");
        return this.rangeEquals(this.size() - arr_b.length, arr_b, 0, arr_b.length);
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 == this ? true : object0 instanceof ByteString && ((ByteString)object0).size() == this.getData$okio().length && ((ByteString)object0).rangeEquals(0, this.getData$okio(), 0, this.getData$okio().length);
    }

    public final byte getByte(int v) {
        return this.internalGet$okio(v);
    }

    @NotNull
    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return this.getData$okio().length;
    }

    @Nullable
    public final String getUtf8$okio() {
        return this.utf8;
    }

    @Override
    public int hashCode() {
        int v = this.getHashCode$okio();
        if(v != 0) {
            return v;
        }
        int v1 = Arrays.hashCode(this.getData$okio());
        this.setHashCode$okio(v1);
        return v1;
    }

    @NotNull
    public String hex() {
        char[] arr_c = new char[this.getData$okio().length * 2];
        byte[] arr_b = this.getData$okio();
        int v1 = 0;
        for(int v = 0; v < arr_b.length; ++v) {
            int v2 = arr_b[v];
            int v3 = v1 + 1;
            arr_c[v1] = -ByteString.getHEX_DIGIT_CHARS()[v2 >> 4 & 15];
            v1 += 2;
            arr_c[v3] = -ByteString.getHEX_DIGIT_CHARS()[v2 & 15];
        }
        return new String(arr_c);
    }

    @NotNull
    public ByteString hmac$okio(@NotNull String s, @NotNull ByteString byteString0) {
        q.g(s, "algorithm");
        q.g(byteString0, "key");
        try {
            Mac mac0 = Mac.getInstance(s);
            mac0.init(new SecretKeySpec(byteString0.toByteArray(), s));
            byte[] arr_b = mac0.doFinal(this.data);
            q.f(arr_b, "doFinal(...)");
            return new ByteString(arr_b);
        }
        catch(InvalidKeyException invalidKeyException0) {
            throw new IllegalArgumentException(invalidKeyException0);
        }
    }

    @NotNull
    public ByteString hmacSha1(@NotNull ByteString byteString0) {
        q.g(byteString0, "key");
        return this.hmac$okio("HmacSHA1", byteString0);
    }

    @NotNull
    public ByteString hmacSha256(@NotNull ByteString byteString0) {
        q.g(byteString0, "key");
        return this.hmac$okio("HmacSHA256", byteString0);
    }

    @NotNull
    public ByteString hmacSha512(@NotNull ByteString byteString0) {
        q.g(byteString0, "key");
        return this.hmac$okio("HmacSHA512", byteString0);
    }

    public final int indexOf(@NotNull ByteString byteString0) {
        q.g(byteString0, "other");
        return ByteString.indexOf$default(this, byteString0, 0, 2, null);
    }

    public final int indexOf(@NotNull ByteString byteString0, int v) {
        q.g(byteString0, "other");
        return this.indexOf(byteString0.internalArray$okio(), v);
    }

    public final int indexOf(@NotNull byte[] arr_b) {
        q.g(arr_b, "other");
        return ByteString.indexOf$default(this, arr_b, 0, 2, null);
    }

    public int indexOf(@NotNull byte[] arr_b, int v) {
        q.g(arr_b, "other");
        int v1 = this.getData$okio().length - arr_b.length;
        int v2 = Math.max(v, 0);
        if(v2 <= v1) {
            while(true) {
                if(-SegmentedByteString.arrayRangeEquals(this.getData$okio(), v2, arr_b, 0, arr_b.length)) {
                    return v2;
                }
                if(v2 == v1) {
                    break;
                }
                ++v2;
            }
        }
        return -1;
    }

    public static int indexOf$default(ByteString byteString0, ByteString byteString1, int v, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if((v1 & 2) != 0) {
            v = 0;
        }
        return byteString0.indexOf(byteString1, v);
    }

    public static int indexOf$default(ByteString byteString0, byte[] arr_b, int v, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if((v1 & 2) != 0) {
            v = 0;
        }
        return byteString0.indexOf(arr_b, v);
    }

    @NotNull
    public byte[] internalArray$okio() {
        return this.getData$okio();
    }

    public byte internalGet$okio(int v) {
        return this.getData$okio()[v];
    }

    public final int lastIndexOf(@NotNull ByteString byteString0) {
        q.g(byteString0, "other");
        return ByteString.lastIndexOf$default(this, byteString0, 0, 2, null);
    }

    public final int lastIndexOf(@NotNull ByteString byteString0, int v) {
        q.g(byteString0, "other");
        return this.lastIndexOf(byteString0.internalArray$okio(), v);
    }

    public final int lastIndexOf(@NotNull byte[] arr_b) {
        q.g(arr_b, "other");
        return ByteString.lastIndexOf$default(this, arr_b, 0, 2, null);
    }

    public int lastIndexOf(@NotNull byte[] arr_b, int v) {
        q.g(arr_b, "other");
        for(int v1 = Math.min(-SegmentedByteString.resolveDefaultParameter(this, v), this.getData$okio().length - arr_b.length); -1 < v1; --v1) {
            if(-SegmentedByteString.arrayRangeEquals(this.getData$okio(), v1, arr_b, 0, arr_b.length)) {
                return v1;
            }
        }
        return -1;
    }

    public static int lastIndexOf$default(ByteString byteString0, ByteString byteString1, int v, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if((v1 & 2) != 0) {
            v = 0xB669FD2E;
        }
        return byteString0.lastIndexOf(byteString1, v);
    }

    public static int lastIndexOf$default(ByteString byteString0, byte[] arr_b, int v, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if((v1 & 2) != 0) {
            v = 0xB669FD2E;
        }
        return byteString0.lastIndexOf(arr_b, v);
    }

    @NotNull
    public final ByteString md5() {
        return this.digest$okio("MD5");
    }

    @NotNull
    public static final ByteString of(@NotNull ByteBuffer byteBuffer0) {
        return ByteString.Companion.of(byteBuffer0);
    }

    @NotNull
    public static final ByteString of(@NotNull byte[] arr_b) {
        return ByteString.Companion.of(arr_b);
    }

    @NotNull
    public static final ByteString of(@NotNull byte[] arr_b, int v, int v1) {
        return ByteString.Companion.of(arr_b, v, v1);
    }

    public boolean rangeEquals(int v, @NotNull ByteString byteString0, int v1, int v2) {
        q.g(byteString0, "other");
        return byteString0.rangeEquals(v1, this.getData$okio(), v, v2);
    }

    public boolean rangeEquals(int v, @NotNull byte[] arr_b, int v1, int v2) {
        q.g(arr_b, "other");
        return v >= 0 && v <= this.getData$okio().length - v2 && v1 >= 0 && v1 <= arr_b.length - v2 && -SegmentedByteString.arrayRangeEquals(this.getData$okio(), v, arr_b, v1, v2);
    }

    @NotNull
    public static final ByteString read(@NotNull InputStream inputStream0, int v) {
        return ByteString.Companion.read(inputStream0, v);
    }

    private final void readObject(ObjectInputStream objectInputStream0) {
        int v = objectInputStream0.readInt();
        ByteString byteString0 = ByteString.Companion.read(objectInputStream0, v);
        ByteString.class.getDeclaredField("data").setAccessible(true);
        this.data = byteString0.data;
    }

    public final void setHashCode$okio(int v) {
        this.hashCode = v;
    }

    public final void setUtf8$okio(@Nullable String s) {
        this.utf8 = s;
    }

    @NotNull
    public final ByteString sha1() {
        return this.digest$okio("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return this.digest$okio("SHA-256");
    }

    @NotNull
    public final ByteString sha512() {
        return this.digest$okio("SHA-512");
    }

    public final int size() {
        return this.getSize$okio();
    }

    public final boolean startsWith(@NotNull ByteString byteString0) {
        q.g(byteString0, "prefix");
        return this.rangeEquals(0, byteString0, 0, byteString0.size());
    }

    public final boolean startsWith(@NotNull byte[] arr_b) {
        q.g(arr_b, "prefix");
        return this.rangeEquals(0, arr_b, 0, arr_b.length);
    }

    @NotNull
    public String string(@NotNull Charset charset0) {
        q.g(charset0, "charset");
        return new String(this.data, charset0);
    }

    @NotNull
    public final ByteString substring() {
        return ByteString.substring$default(this, 0, 0, 3, null);
    }

    @NotNull
    public final ByteString substring(int v) {
        return ByteString.substring$default(this, v, 0, 2, null);
    }

    @NotNull
    public ByteString substring(int v, int v1) {
        int v2 = -SegmentedByteString.resolveDefaultParameter(this, v1);
        if(v < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if(v2 > this.getData$okio().length) {
            throw new IllegalArgumentException(o.q(new StringBuilder("endIndex > length("), this.getData$okio().length, ')').toString());
        }
        if(v2 - v < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        return v != 0 || v2 != this.getData$okio().length ? new ByteString(n.Z(this.getData$okio(), v, v2)) : this;
    }

    public static ByteString substring$default(ByteString byteString0, int v, int v1, int v2, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if((v2 & 1) != 0) {
            v = 0;
        }
        if((v2 & 2) != 0) {
            v1 = 0xB669FD2E;
        }
        return byteString0.substring(v, v1);
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        for(int v = 0; v < this.getData$okio().length; ++v) {
            int v1 = this.getData$okio()[v];
            if(v1 >= 65 && v1 <= 90) {
                byte[] arr_b = this.getData$okio();
                byte[] arr_b1 = Arrays.copyOf(arr_b, arr_b.length);
                q.f(arr_b1, "copyOf(...)");
                int v2 = v + 1;
                arr_b1[v] = (byte)(v1 + 0x20);
                while(v2 < arr_b1.length) {
                    int v3 = arr_b1[v2];
                    if(v3 >= 65 && v3 <= 90) {
                        arr_b1[v2] = (byte)(v3 + 0x20);
                    }
                    ++v2;
                }
                return new ByteString(arr_b1);
            }
        }
        return this;
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        for(int v = 0; v < this.getData$okio().length; ++v) {
            int v1 = this.getData$okio()[v];
            if(v1 >= 97 && v1 <= 0x7A) {
                byte[] arr_b = this.getData$okio();
                byte[] arr_b1 = Arrays.copyOf(arr_b, arr_b.length);
                q.f(arr_b1, "copyOf(...)");
                int v2 = v + 1;
                arr_b1[v] = (byte)(v1 - 0x20);
                while(v2 < arr_b1.length) {
                    int v3 = arr_b1[v2];
                    if(v3 >= 97 && v3 <= 0x7A) {
                        arr_b1[v2] = (byte)(v3 - 0x20);
                    }
                    ++v2;
                }
                return new ByteString(arr_b1);
            }
        }
        return this;
    }

    @NotNull
    public byte[] toByteArray() {
        byte[] arr_b = this.getData$okio();
        byte[] arr_b1 = Arrays.copyOf(arr_b, arr_b.length);
        q.f(arr_b1, "copyOf(...)");
        return arr_b1;
    }

    @Override
    @NotNull
    public String toString() {
        if(this.getData$okio().length == 0) {
            return "[size=0]";
        }
        int v = -ByteString.access$codePointIndexToCharIndex(this.getData$okio(), 0x40);
        if(v == -1) {
            if(this.getData$okio().length <= 0x40) {
                return "[hex=" + this.hex() + ']';
            }
            StringBuilder stringBuilder0 = new StringBuilder("[size=");
            stringBuilder0.append(this.getData$okio().length);
            stringBuilder0.append(" hex=");
            int v1 = -SegmentedByteString.resolveDefaultParameter(this, 0x40);
            if(v1 > this.getData$okio().length) {
                throw new IllegalArgumentException(o.q(new StringBuilder("endIndex > length("), this.getData$okio().length, ')').toString());
            }
            if(v1 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            stringBuilder0.append((v1 == this.getData$okio().length ? this : new ByteString(n.Z(this.getData$okio(), 0, v1))).hex());
            stringBuilder0.append("…]");
            return stringBuilder0.toString();
        }
        String s = this.utf8();
        String s1 = s.substring(0, v);
        q.f(s1, "substring(...)");
        String s2 = v.p0(v.p0(v.p0(s1, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
        return v >= s.length() ? "[text=" + s2 + ']' : "[size=" + this.getData$okio().length + " text=" + s2 + "…]";
    }

    @NotNull
    public String utf8() {
        String s = this.getUtf8$okio();
        if(s == null) {
            s = _JvmPlatformKt.toUtf8String(this.internalArray$okio());
            this.setUtf8$okio(s);
        }
        return s;
    }

    public void write(@NotNull OutputStream outputStream0) {
        q.g(outputStream0, "out");
        outputStream0.write(this.data);
    }

    public void write$okio(@NotNull Buffer buffer0, int v, int v1) {
        q.g(buffer0, "buffer");
        -ByteString.commonWrite(this, buffer0, v, v1);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream0) {
        objectOutputStream0.writeInt(this.data.length);
        objectOutputStream0.write(this.data);
    }
}

