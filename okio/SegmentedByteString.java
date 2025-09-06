package okio;

import U4.x;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u000B\b\u0000\u0018\u00002\u00020\u0001B\u001F\b\u0000\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0001H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0001H\u0016\u00A2\u0006\u0004\b\u0016\u0010\nJ\u000F\u0010\u0017\u001A\u00020\u0001H\u0016\u00A2\u0006\u0004\b\u0017\u0010\nJ\u0017\u0010\u001B\u001A\u00020\u00012\u0006\u0010\u0018\u001A\u00020\u0010H\u0010\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001F\u0010\u001F\u001A\u00020\u00012\u0006\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u001C\u001A\u00020\u0001H\u0010\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010 \u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b \u0010\u0014J#\u0010$\u001A\u00020\u00012\b\b\u0002\u0010\"\u001A\u00020!2\b\b\u0002\u0010#\u001A\u00020!H\u0016\u00A2\u0006\u0004\b$\u0010%J\u0017\u0010*\u001A\u00020\'2\u0006\u0010&\u001A\u00020!H\u0010\u00A2\u0006\u0004\b(\u0010)J\u000F\u0010-\u001A\u00020!H\u0010\u00A2\u0006\u0004\b+\u0010,J\u000F\u0010.\u001A\u00020\u0003H\u0016\u00A2\u0006\u0004\b.\u0010/J\u000F\u00101\u001A\u000200H\u0016\u00A2\u0006\u0004\b1\u00102J\u0017\u00106\u001A\u0002052\u0006\u00104\u001A\u000203H\u0016\u00A2\u0006\u0004\b6\u00107J\'\u00106\u001A\u0002052\u0006\u00109\u001A\u0002082\u0006\u0010:\u001A\u00020!2\u0006\u0010;\u001A\u00020!H\u0010\u00A2\u0006\u0004\b<\u0010=J/\u0010A\u001A\u00020@2\u0006\u0010:\u001A\u00020!2\u0006\u0010>\u001A\u00020\u00012\u0006\u0010?\u001A\u00020!2\u0006\u0010;\u001A\u00020!H\u0016\u00A2\u0006\u0004\bA\u0010BJ/\u0010A\u001A\u00020@2\u0006\u0010:\u001A\u00020!2\u0006\u0010>\u001A\u00020\u00032\u0006\u0010?\u001A\u00020!2\u0006\u0010;\u001A\u00020!H\u0016\u00A2\u0006\u0004\bA\u0010CJ3\u0010F\u001A\u0002052\b\b\u0002\u0010:\u001A\u00020!2\u0006\u0010D\u001A\u00020\u00032\b\b\u0002\u0010E\u001A\u00020!2\u0006\u0010;\u001A\u00020!H\u0016\u00A2\u0006\u0004\bF\u0010GJ!\u0010I\u001A\u00020!2\u0006\u0010>\u001A\u00020\u00032\b\b\u0002\u0010H\u001A\u00020!H\u0016\u00A2\u0006\u0004\bI\u0010JJ!\u0010K\u001A\u00020!2\u0006\u0010>\u001A\u00020\u00032\b\b\u0002\u0010H\u001A\u00020!H\u0016\u00A2\u0006\u0004\bK\u0010JJ\u000F\u0010M\u001A\u00020\u0003H\u0010\u00A2\u0006\u0004\bL\u0010/J\u001A\u0010O\u001A\u00020@2\b\u0010>\u001A\u0004\u0018\u00010NH\u0096\u0002\u00A2\u0006\u0004\bO\u0010PJ\u000F\u0010Q\u001A\u00020!H\u0016\u00A2\u0006\u0004\bQ\u0010,J\u000F\u0010R\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\bR\u0010\u0014R \u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0004\u0010S\u001A\u0004\bT\u0010UR\u001A\u0010\u0006\u001A\u00020\u00058\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0006\u0010V\u001A\u0004\bW\u0010X\u00A8\u0006Y"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "", "", "segments", "", "directory", "<init>", "([[B[I)V", "toByteString", "()Lokio/ByteString;", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "", "string", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", "()Ljava/lang/String;", "hex", "toAsciiLowercase", "toAsciiUppercase", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "key", "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", "", "internalGet$okio", "(I)B", "internalGet", "getSize$okio", "()I", "getSize", "toByteArray", "()[B", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "out", "Lie/H;", "write", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "offset", "byteCount", "write$okio", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "target", "targetOffset", "copyInto", "(I[BII)V", "fromIndex", "indexOf", "([BI)I", "lastIndexOf", "internalArray$okio", "internalArray", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "[[B", "getSegments$okio", "()[[B", "[I", "getDirectory$okio", "()[I", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class SegmentedByteString extends ByteString {
    @NotNull
    private final transient int[] directory;
    @NotNull
    private final transient byte[][] segments;

    public SegmentedByteString(@NotNull byte[][] arr2_b, @NotNull int[] arr_v) {
        q.g(arr2_b, "segments");
        q.g(arr_v, "directory");
        super(ByteString.EMPTY.getData$okio());
        this.segments = arr2_b;
        this.directory = arr_v;
    }

    @Override  // okio.ByteString
    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(this.toByteArray()).asReadOnlyBuffer();
        q.f(byteBuffer0, "asReadOnlyBuffer(...)");
        return byteBuffer0;
    }

    @Override  // okio.ByteString
    @NotNull
    public String base64() {
        return this.toByteString().base64();
    }

    @Override  // okio.ByteString
    @NotNull
    public String base64Url() {
        return this.toByteString().base64Url();
    }

    @Override  // okio.ByteString
    public void copyInto(int v, @NotNull byte[] arr_b, int v1, int v2) {
        q.g(arr_b, "target");
        -SegmentedByteString.checkOffsetAndCount(this.size(), v, v2);
        -SegmentedByteString.checkOffsetAndCount(arr_b.length, v1, v2);
        int v3 = v2 + v;
        for(int v4 = okio.internal.-SegmentedByteString.segment(this, v); v < v3; ++v4) {
            int v5 = v4 == 0 ? 0 : this.getDirectory$okio()[v4 - 1];
            int v6 = Math.min(v3, this.getDirectory$okio()[v4]) - v;
            int v7 = v - v5 + this.getDirectory$okio()[this.getSegments$okio().length + v4];
            n.T(this.getSegments$okio()[v4], v1, v7, arr_b, v7 + v6);
            v1 += v6;
            v += v6;
        }
    }

    @Override  // okio.ByteString
    @NotNull
    public ByteString digest$okio(@NotNull String s) {
        q.g(s, "algorithm");
        MessageDigest messageDigest0 = MessageDigest.getInstance(s);
        byte[][] arr2_b = this.getSegments$okio();
        int v = 0;
        for(int v1 = 0; v < arr2_b.length; v1 = v3) {
            int v2 = this.getDirectory$okio()[arr2_b.length + v];
            int v3 = this.getDirectory$okio()[v];
            messageDigest0.update(this.getSegments$okio()[v], v2, v3 - v1);
            ++v;
        }
        byte[] arr_b = messageDigest0.digest();
        q.d(arr_b);
        return new ByteString(arr_b);
    }

    // 去混淆评级： 低(30)
    @Override  // okio.ByteString
    public boolean equals(@Nullable Object object0) {
        return object0 == this ? true : object0 instanceof ByteString && ((ByteString)object0).size() == this.size() && this.rangeEquals(0, ((ByteString)object0), 0, this.size());
    }

    @NotNull
    public final int[] getDirectory$okio() {
        return this.directory;
    }

    @NotNull
    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override  // okio.ByteString
    public int getSize$okio() {
        return this.getDirectory$okio()[this.getSegments$okio().length - 1];
    }

    @Override  // okio.ByteString
    public int hashCode() {
        int v = this.getHashCode$okio();
        if(v != 0) {
            return v;
        }
        byte[][] arr2_b = this.getSegments$okio();
        int v1 = 0;
        int v2 = 1;
        for(int v3 = 0; v1 < arr2_b.length; v3 = v5) {
            int v4 = this.getDirectory$okio()[arr2_b.length + v1];
            int v5 = this.getDirectory$okio()[v1];
            byte[] arr_b = this.getSegments$okio()[v1];
            int v6 = v5 - v3 + v4;
            while(v4 < v6) {
                v2 = v2 * 0x1F + arr_b[v4];
                ++v4;
            }
            ++v1;
        }
        this.setHashCode$okio(v2);
        return v2;
    }

    @Override  // okio.ByteString
    @NotNull
    public String hex() {
        return this.toByteString().hex();
    }

    @Override  // okio.ByteString
    @NotNull
    public ByteString hmac$okio(@NotNull String s, @NotNull ByteString byteString0) {
        q.g(s, "algorithm");
        q.g(byteString0, "key");
        try {
            Mac mac0 = Mac.getInstance(s);
            mac0.init(new SecretKeySpec(byteString0.toByteArray(), s));
            byte[][] arr2_b = this.getSegments$okio();
            int v = 0;
            for(int v1 = 0; v < arr2_b.length; v1 = v3) {
                int v2 = this.getDirectory$okio()[arr2_b.length + v];
                int v3 = this.getDirectory$okio()[v];
                mac0.update(this.getSegments$okio()[v], v2, v3 - v1);
                ++v;
            }
            byte[] arr_b = mac0.doFinal();
            q.f(arr_b, "doFinal(...)");
            return new ByteString(arr_b);
        }
        catch(InvalidKeyException invalidKeyException0) {
        }
        throw new IllegalArgumentException(invalidKeyException0);
    }

    @Override  // okio.ByteString
    public int indexOf(@NotNull byte[] arr_b, int v) {
        q.g(arr_b, "other");
        return this.toByteString().indexOf(arr_b, v);
    }

    @Override  // okio.ByteString
    @NotNull
    public byte[] internalArray$okio() {
        return this.toByteArray();
    }

    @Override  // okio.ByteString
    public byte internalGet$okio(int v) {
        -SegmentedByteString.checkOffsetAndCount(this.getDirectory$okio()[this.getSegments$okio().length - 1], v, 1L);
        int v1 = okio.internal.-SegmentedByteString.segment(this, v);
        return v1 == 0 ? this.getSegments$okio()[0][v + this.getDirectory$okio()[this.getSegments$okio().length]] : this.getSegments$okio()[v1][v - this.getDirectory$okio()[v1 - 1] + this.getDirectory$okio()[this.getSegments$okio().length + v1]];
    }

    @Override  // okio.ByteString
    public int lastIndexOf(@NotNull byte[] arr_b, int v) {
        q.g(arr_b, "other");
        return this.toByteString().lastIndexOf(arr_b, v);
    }

    @Override  // okio.ByteString
    public boolean rangeEquals(int v, @NotNull ByteString byteString0, int v1, int v2) {
        q.g(byteString0, "other");
        if(v >= 0 && v <= this.size() - v2) {
            int v3 = v2 + v;
            for(int v4 = okio.internal.-SegmentedByteString.segment(this, v); v < v3; ++v4) {
                int v5 = v4 == 0 ? 0 : this.getDirectory$okio()[v4 - 1];
                int v6 = Math.min(v3, this.getDirectory$okio()[v4]) - v;
                if(!byteString0.rangeEquals(v1, this.getSegments$okio()[v4], v - v5 + this.getDirectory$okio()[this.getSegments$okio().length + v4], v6)) {
                    return false;
                }
                v1 += v6;
                v += v6;
            }
            return true;
        }
        return false;
    }

    @Override  // okio.ByteString
    public boolean rangeEquals(int v, @NotNull byte[] arr_b, int v1, int v2) {
        q.g(arr_b, "other");
        if(v >= 0 && v <= this.size() - v2 && v1 >= 0 && v1 <= arr_b.length - v2) {
            int v3 = v2 + v;
            for(int v4 = okio.internal.-SegmentedByteString.segment(this, v); v < v3; ++v4) {
                int v5 = v4 == 0 ? 0 : this.getDirectory$okio()[v4 - 1];
                int v6 = Math.min(v3, this.getDirectory$okio()[v4]) - v;
                if(!-SegmentedByteString.arrayRangeEquals(this.getSegments$okio()[v4], v - v5 + this.getDirectory$okio()[this.getSegments$okio().length + v4], arr_b, v1, v6)) {
                    return false;
                }
                v1 += v6;
                v += v6;
            }
            return true;
        }
        return false;
    }

    @Override  // okio.ByteString
    @NotNull
    public String string(@NotNull Charset charset0) {
        q.g(charset0, "charset");
        return this.toByteString().string(charset0);
    }

    @Override  // okio.ByteString
    @NotNull
    public ByteString substring(int v, int v1) {
        int v2 = -SegmentedByteString.resolveDefaultParameter(this, v1);
        if(v < 0) {
            throw new IllegalArgumentException(("beginIndex=" + v + " < 0").toString());
        }
        if(v2 <= this.size()) {
            int v3 = v2 - v;
            if(v3 < 0) {
                throw new IllegalArgumentException(("endIndex=" + v2 + " < beginIndex=" + v).toString());
            }
            if(v == 0 && v2 == this.size()) {
                return this;
            }
            if(v == v2) {
                return ByteString.EMPTY;
            }
            int v4 = okio.internal.-SegmentedByteString.segment(this, v);
            int v5 = okio.internal.-SegmentedByteString.segment(this, v2 - 1);
            byte[][] arr2_b = (byte[][])n.a0(this.getSegments$okio(), v4, v5 + 1);
            int[] arr_v = new int[arr2_b.length * 2];
            int v6 = 0;
            if(v4 <= v5) {
                int v7 = v4;
                for(int v8 = 0; true; ++v8) {
                    arr_v[v8] = Math.min(this.getDirectory$okio()[v7] - v, v3);
                    arr_v[v8 + arr2_b.length] = this.getDirectory$okio()[this.getSegments$okio().length + v7];
                    if(v7 == v5) {
                        break;
                    }
                    ++v7;
                }
            }
            if(v4 != 0) {
                v6 = this.getDirectory$okio()[v4 - 1];
            }
            arr_v[arr2_b.length] = v - v6 + arr_v[arr2_b.length];
            return new SegmentedByteString(arr2_b, arr_v);
        }
        StringBuilder stringBuilder0 = x.n(v2, "endIndex=", " > length(");
        stringBuilder0.append(this.size());
        stringBuilder0.append(')');
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    @Override  // okio.ByteString
    @NotNull
    public ByteString toAsciiLowercase() {
        return this.toByteString().toAsciiLowercase();
    }

    @Override  // okio.ByteString
    @NotNull
    public ByteString toAsciiUppercase() {
        return this.toByteString().toAsciiUppercase();
    }

    @Override  // okio.ByteString
    @NotNull
    public byte[] toByteArray() {
        byte[] arr_b = new byte[this.size()];
        byte[][] arr2_b = this.getSegments$okio();
        int v = 0;
        int v2 = 0;
        for(int v1 = 0; v < arr2_b.length; v1 = v4) {
            int v3 = this.getDirectory$okio()[arr2_b.length + v];
            int v4 = this.getDirectory$okio()[v];
            int v5 = v4 - v1;
            n.T(this.getSegments$okio()[v], v2, v3, arr_b, v3 + v5);
            v2 += v5;
            ++v;
        }
        return arr_b;
    }

    private final ByteString toByteString() {
        return new ByteString(this.toByteArray());
    }

    @Override  // okio.ByteString
    @NotNull
    public String toString() {
        return this.toByteString().toString();
    }

    @Override  // okio.ByteString
    public void write(@NotNull OutputStream outputStream0) {
        q.g(outputStream0, "out");
        byte[][] arr2_b = this.getSegments$okio();
        int v = 0;
        for(int v1 = 0; v < arr2_b.length; v1 = v3) {
            int v2 = this.getDirectory$okio()[arr2_b.length + v];
            int v3 = this.getDirectory$okio()[v];
            outputStream0.write(this.getSegments$okio()[v], v2, v3 - v1);
            ++v;
        }
    }

    @Override  // okio.ByteString
    public void write$okio(@NotNull Buffer buffer0, int v, int v1) {
        q.g(buffer0, "buffer");
        int v2 = v + v1;
        for(int v3 = okio.internal.-SegmentedByteString.segment(this, v); v < v2; ++v3) {
            int v4 = v3 == 0 ? 0 : this.getDirectory$okio()[v3 - 1];
            int v5 = Math.min(v2, this.getDirectory$okio()[v3]) - v;
            int v6 = v - v4 + this.getDirectory$okio()[this.getSegments$okio().length + v3];
            Segment segment0 = new Segment(this.getSegments$okio()[v3], v6, v6 + v5, true, false);
            Segment segment1 = buffer0.head;
            if(segment1 == null) {
                segment0.prev = segment0;
                segment0.next = segment0;
                buffer0.head = segment0;
            }
            else {
                q.d(segment1);
                Segment segment2 = segment1.prev;
                q.d(segment2);
                segment2.push(segment0);
            }
            v += v5;
        }
        buffer0.setSize$okio(buffer0.size() + ((long)v1));
    }

    private final Object writeReplace() {
        ByteString byteString0 = this.toByteString();
        q.e(byteString0, "null cannot be cast to non-null type java.lang.Object");
        return byteString0;
    }
}

