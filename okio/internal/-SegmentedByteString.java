package okio.internal;

import U4.x;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.o;

@Metadata(d1 = {"\u0000L\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\u001A+\u0010\u0005\u001A\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0001H\u0000\u00A2\u0006\u0004\b\u0005\u0010\u0006\u001A\u001B\u0010\t\u001A\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001A\u00020\u0001H\u0000\u00A2\u0006\u0004\b\t\u0010\n\u001A7\u0010\u000F\u001A\u00020\r*\u00020\u00072\u001E\u0010\u000E\u001A\u001A\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\u000BH\u0080\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u000F\u0010\u0010\u001AD\u0010\u000F\u001A\u00020\r*\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u00012\u001E\u0010\u000E\u001A\u001A\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\u000BH\u0082\b\u00A2\u0006\u0004\b\u000F\u0010\u0013\u001A$\u0010\u0015\u001A\u00020\u0014*\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u0001H\u0080\b\u00A2\u0006\u0004\b\u0015\u0010\u0016\u001A\u001C\u0010\u0018\u001A\u00020\u0017*\u00020\u00072\u0006\u0010\b\u001A\u00020\u0001H\u0080\b\u00A2\u0006\u0004\b\u0018\u0010\u0019\u001A\u0014\u0010\u001A\u001A\u00020\u0001*\u00020\u0007H\u0080\b\u00A2\u0006\u0004\b\u001A\u0010\u001B\u001A\u0014\u0010\u001C\u001A\u00020\f*\u00020\u0007H\u0080\b\u00A2\u0006\u0004\b\u001C\u0010\u001D\u001A,\u0010\"\u001A\u00020\r*\u00020\u00072\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\u00012\u0006\u0010!\u001A\u00020\u0001H\u0080\b\u00A2\u0006\u0004\b\"\u0010#\u001A4\u0010\'\u001A\u00020&*\u00020\u00072\u0006\u0010 \u001A\u00020\u00012\u0006\u0010$\u001A\u00020\u00142\u0006\u0010%\u001A\u00020\u00012\u0006\u0010!\u001A\u00020\u0001H\u0080\b\u00A2\u0006\u0004\b\'\u0010(\u001A4\u0010\'\u001A\u00020&*\u00020\u00072\u0006\u0010 \u001A\u00020\u00012\u0006\u0010$\u001A\u00020\f2\u0006\u0010%\u001A\u00020\u00012\u0006\u0010!\u001A\u00020\u0001H\u0080\b\u00A2\u0006\u0004\b\'\u0010)\u001A4\u0010,\u001A\u00020\r*\u00020\u00072\u0006\u0010 \u001A\u00020\u00012\u0006\u0010*\u001A\u00020\f2\u0006\u0010+\u001A\u00020\u00012\u0006\u0010!\u001A\u00020\u0001H\u0080\b\u00A2\u0006\u0004\b,\u0010-\u001A\u001E\u0010/\u001A\u00020&*\u00020\u00072\b\u0010$\u001A\u0004\u0018\u00010.H\u0080\b\u00A2\u0006\u0004\b/\u00100\u001A\u0014\u00101\u001A\u00020\u0001*\u00020\u0007H\u0080\b\u00A2\u0006\u0004\b1\u0010\u001B\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00A8\u00062"}, d2 = {"", "", "value", "fromIndex", "toIndex", "binarySearch", "([IIII)I", "Lokio/SegmentedByteString;", "pos", "segment", "(Lokio/SegmentedByteString;I)I", "Lkotlin/Function3;", "", "Lie/H;", "action", "forEachSegment", "(Lokio/SegmentedByteString;Lwe/o;)V", "beginIndex", "endIndex", "(Lokio/SegmentedByteString;IILwe/o;)V", "Lokio/ByteString;", "commonSubstring", "(Lokio/SegmentedByteString;II)Lokio/ByteString;", "", "commonInternalGet", "(Lokio/SegmentedByteString;I)B", "commonGetSize", "(Lokio/SegmentedByteString;)I", "commonToByteArray", "(Lokio/SegmentedByteString;)[B", "Lokio/Buffer;", "buffer", "offset", "byteCount", "commonWrite", "(Lokio/SegmentedByteString;Lokio/Buffer;II)V", "other", "otherOffset", "", "commonRangeEquals", "(Lokio/SegmentedByteString;ILokio/ByteString;II)Z", "(Lokio/SegmentedByteString;I[BII)Z", "target", "targetOffset", "commonCopyInto", "(Lokio/SegmentedByteString;I[BII)V", "", "commonEquals", "(Lokio/SegmentedByteString;Ljava/lang/Object;)Z", "commonHashCode", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class -SegmentedByteString {
    public static final int binarySearch(@NotNull int[] arr_v, int v, int v1, int v2) {
        q.g(arr_v, "<this>");
        int v3 = v2 - 1;
        while(v1 <= v3) {
            int v4 = v1 + v3 >>> 1;
            int v5 = arr_v[v4];
            if(v5 < v) {
                v1 = v4 + 1;
                continue;
            }
            if(v5 > v) {
                v3 = v4 - 1;
                continue;
            }
            return v4;
        }
        return -v1 - 1;
    }

    public static final void commonCopyInto(@NotNull SegmentedByteString segmentedByteString0, int v, @NotNull byte[] arr_b, int v1, int v2) {
        q.g(segmentedByteString0, "<this>");
        q.g(arr_b, "target");
        okio.-SegmentedByteString.checkOffsetAndCount(segmentedByteString0.size(), v, v2);
        okio.-SegmentedByteString.checkOffsetAndCount(arr_b.length, v1, v2);
        int v3 = v2 + v;
        for(int v4 = -SegmentedByteString.segment(segmentedByteString0, v); v < v3; ++v4) {
            int v5 = v4 == 0 ? 0 : segmentedByteString0.getDirectory$okio()[v4 - 1];
            int v6 = Math.min(v3, segmentedByteString0.getDirectory$okio()[v4]) - v;
            int v7 = v - v5 + segmentedByteString0.getDirectory$okio()[segmentedByteString0.getSegments$okio().length + v4];
            n.T(segmentedByteString0.getSegments$okio()[v4], v1, v7, arr_b, v7 + v6);
            v1 += v6;
            v += v6;
        }
    }

    public static final boolean commonEquals(@NotNull SegmentedByteString segmentedByteString0, @Nullable Object object0) {
        q.g(segmentedByteString0, "<this>");
        return object0 == segmentedByteString0 ? true : object0 instanceof ByteString && ((ByteString)object0).size() == segmentedByteString0.size() && segmentedByteString0.rangeEquals(0, ((ByteString)object0), 0, segmentedByteString0.size());
    }

    public static final int commonGetSize(@NotNull SegmentedByteString segmentedByteString0) {
        q.g(segmentedByteString0, "<this>");
        return segmentedByteString0.getDirectory$okio()[segmentedByteString0.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(@NotNull SegmentedByteString segmentedByteString0) {
        q.g(segmentedByteString0, "<this>");
        int v = segmentedByteString0.getHashCode$okio();
        if(v != 0) {
            return v;
        }
        byte[][] arr2_b = segmentedByteString0.getSegments$okio();
        int v1 = 0;
        int v2 = 1;
        for(int v3 = 0; v1 < arr2_b.length; v3 = v5) {
            int v4 = segmentedByteString0.getDirectory$okio()[arr2_b.length + v1];
            int v5 = segmentedByteString0.getDirectory$okio()[v1];
            byte[] arr_b = segmentedByteString0.getSegments$okio()[v1];
            int v6 = v5 - v3 + v4;
            while(v4 < v6) {
                v2 = v2 * 0x1F + arr_b[v4];
                ++v4;
            }
            ++v1;
        }
        segmentedByteString0.setHashCode$okio(v2);
        return v2;
    }

    public static final byte commonInternalGet(@NotNull SegmentedByteString segmentedByteString0, int v) {
        q.g(segmentedByteString0, "<this>");
        okio.-SegmentedByteString.checkOffsetAndCount(segmentedByteString0.getDirectory$okio()[segmentedByteString0.getSegments$okio().length - 1], v, 1L);
        int v1 = -SegmentedByteString.segment(segmentedByteString0, v);
        return v1 == 0 ? segmentedByteString0.getSegments$okio()[0][v + segmentedByteString0.getDirectory$okio()[segmentedByteString0.getSegments$okio().length]] : segmentedByteString0.getSegments$okio()[v1][v - segmentedByteString0.getDirectory$okio()[v1 - 1] + segmentedByteString0.getDirectory$okio()[segmentedByteString0.getSegments$okio().length + v1]];
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString segmentedByteString0, int v, @NotNull ByteString byteString0, int v1, int v2) {
        q.g(segmentedByteString0, "<this>");
        q.g(byteString0, "other");
        if(v >= 0 && v <= segmentedByteString0.size() - v2) {
            int v3 = v2 + v;
            for(int v4 = -SegmentedByteString.segment(segmentedByteString0, v); v < v3; ++v4) {
                int v5 = v4 == 0 ? 0 : segmentedByteString0.getDirectory$okio()[v4 - 1];
                int v6 = Math.min(v3, segmentedByteString0.getDirectory$okio()[v4]) - v;
                if(!byteString0.rangeEquals(v1, segmentedByteString0.getSegments$okio()[v4], v - v5 + segmentedByteString0.getDirectory$okio()[segmentedByteString0.getSegments$okio().length + v4], v6)) {
                    return false;
                }
                v1 += v6;
                v += v6;
            }
            return true;
        }
        return false;
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString segmentedByteString0, int v, @NotNull byte[] arr_b, int v1, int v2) {
        q.g(segmentedByteString0, "<this>");
        q.g(arr_b, "other");
        if(v >= 0 && v <= segmentedByteString0.size() - v2 && v1 >= 0 && v1 <= arr_b.length - v2) {
            int v3 = v2 + v;
            for(int v4 = -SegmentedByteString.segment(segmentedByteString0, v); v < v3; ++v4) {
                int v5 = v4 == 0 ? 0 : segmentedByteString0.getDirectory$okio()[v4 - 1];
                int v6 = Math.min(v3, segmentedByteString0.getDirectory$okio()[v4]) - v;
                if(!okio.-SegmentedByteString.arrayRangeEquals(segmentedByteString0.getSegments$okio()[v4], v - v5 + segmentedByteString0.getDirectory$okio()[segmentedByteString0.getSegments$okio().length + v4], arr_b, v1, v6)) {
                    return false;
                }
                v1 += v6;
                v += v6;
            }
            return true;
        }
        return false;
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull SegmentedByteString segmentedByteString0, int v, int v1) {
        q.g(segmentedByteString0, "<this>");
        int v2 = okio.-SegmentedByteString.resolveDefaultParameter(segmentedByteString0, v1);
        if(v < 0) {
            throw new IllegalArgumentException(("beginIndex=" + v + " < 0").toString());
        }
        if(v2 <= segmentedByteString0.size()) {
            int v3 = v2 - v;
            if(v3 < 0) {
                throw new IllegalArgumentException(("endIndex=" + v2 + " < beginIndex=" + v).toString());
            }
            if(v == 0 && v2 == segmentedByteString0.size()) {
                return segmentedByteString0;
            }
            if(v == v2) {
                return ByteString.EMPTY;
            }
            int v4 = -SegmentedByteString.segment(segmentedByteString0, v);
            int v5 = -SegmentedByteString.segment(segmentedByteString0, v2 - 1);
            byte[][] arr2_b = (byte[][])n.a0(segmentedByteString0.getSegments$okio(), v4, v5 + 1);
            int[] arr_v = new int[arr2_b.length * 2];
            int v6 = 0;
            if(v4 <= v5) {
                int v7 = v4;
                for(int v8 = 0; true; ++v8) {
                    arr_v[v8] = Math.min(segmentedByteString0.getDirectory$okio()[v7] - v, v3);
                    arr_v[v8 + arr2_b.length] = segmentedByteString0.getDirectory$okio()[segmentedByteString0.getSegments$okio().length + v7];
                    if(v7 == v5) {
                        break;
                    }
                    ++v7;
                }
            }
            if(v4 != 0) {
                v6 = segmentedByteString0.getDirectory$okio()[v4 - 1];
            }
            arr_v[arr2_b.length] = v - v6 + arr_v[arr2_b.length];
            return new SegmentedByteString(arr2_b, arr_v);
        }
        StringBuilder stringBuilder0 = x.n(v2, "endIndex=", " > length(");
        stringBuilder0.append(segmentedByteString0.size());
        stringBuilder0.append(')');
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull SegmentedByteString segmentedByteString0) {
        q.g(segmentedByteString0, "<this>");
        byte[] arr_b = new byte[segmentedByteString0.size()];
        byte[][] arr2_b = segmentedByteString0.getSegments$okio();
        int v = 0;
        int v2 = 0;
        for(int v1 = 0; v < arr2_b.length; v1 = v4) {
            int v3 = segmentedByteString0.getDirectory$okio()[arr2_b.length + v];
            int v4 = segmentedByteString0.getDirectory$okio()[v];
            int v5 = v4 - v1;
            n.T(segmentedByteString0.getSegments$okio()[v], v2, v3, arr_b, v3 + v5);
            v2 += v5;
            ++v;
        }
        return arr_b;
    }

    public static final void commonWrite(@NotNull SegmentedByteString segmentedByteString0, @NotNull Buffer buffer0, int v, int v1) {
        q.g(segmentedByteString0, "<this>");
        q.g(buffer0, "buffer");
        int v2 = v + v1;
        for(int v3 = -SegmentedByteString.segment(segmentedByteString0, v); v < v2; ++v3) {
            int v4 = v3 == 0 ? 0 : segmentedByteString0.getDirectory$okio()[v3 - 1];
            int v5 = Math.min(v2, segmentedByteString0.getDirectory$okio()[v3]) - v;
            int v6 = v - v4 + segmentedByteString0.getDirectory$okio()[segmentedByteString0.getSegments$okio().length + v3];
            Segment segment0 = new Segment(segmentedByteString0.getSegments$okio()[v3], v6, v6 + v5, true, false);
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

    private static final void forEachSegment(SegmentedByteString segmentedByteString0, int v, int v1, o o0) {
        for(int v2 = -SegmentedByteString.segment(segmentedByteString0, v); v < v1; ++v2) {
            int v3 = v2 == 0 ? 0 : segmentedByteString0.getDirectory$okio()[v2 - 1];
            int v4 = Math.min(v1, segmentedByteString0.getDirectory$okio()[v2]) - v;
            o0.invoke(segmentedByteString0.getSegments$okio()[v2], ((int)(v - v3 + segmentedByteString0.getDirectory$okio()[segmentedByteString0.getSegments$okio().length + v2])), v4);
            v += v4;
        }
    }

    public static final void forEachSegment(@NotNull SegmentedByteString segmentedByteString0, @NotNull o o0) {
        q.g(segmentedByteString0, "<this>");
        q.g(o0, "action");
        byte[][] arr2_b = segmentedByteString0.getSegments$okio();
        int v = 0;
        for(int v1 = 0; v < arr2_b.length; v1 = v3) {
            int v2 = segmentedByteString0.getDirectory$okio()[arr2_b.length + v];
            int v3 = segmentedByteString0.getDirectory$okio()[v];
            o0.invoke(segmentedByteString0.getSegments$okio()[v], v2, ((int)(v3 - v1)));
            ++v;
        }
    }

    public static final int segment(@NotNull SegmentedByteString segmentedByteString0, int v) {
        q.g(segmentedByteString0, "<this>");
        int v1 = -SegmentedByteString.binarySearch(segmentedByteString0.getDirectory$okio(), v + 1, 0, segmentedByteString0.getSegments$okio().length);
        return v1 < 0 ? ~v1 : v1;
    }
}

