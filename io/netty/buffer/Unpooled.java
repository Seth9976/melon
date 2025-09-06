package io.netty.buffer;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class Unpooled {
    static final boolean $assertionsDisabled;
    private static final ByteBufAllocator ALLOC;
    public static final ByteOrder BIG_ENDIAN;
    public static final ByteBuf EMPTY_BUFFER;
    public static final ByteOrder LITTLE_ENDIAN;

    static {
        Unpooled.ALLOC = UnpooledByteBufAllocator.DEFAULT;
        Unpooled.BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        Unpooled.LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        Unpooled.EMPTY_BUFFER = UnpooledByteBufAllocator.DEFAULT.buffer(0, 0);
    }

    public static ByteBuf buffer() {
        return Unpooled.ALLOC.heapBuffer();
    }

    public static ByteBuf buffer(int v) {
        return Unpooled.ALLOC.heapBuffer(v);
    }

    public static ByteBuf buffer(int v, int v1) {
        return Unpooled.ALLOC.heapBuffer(v, v1);
    }

    public static CompositeByteBuf compositeBuffer() {
        return Unpooled.compositeBuffer(16);
    }

    public static CompositeByteBuf compositeBuffer(int v) {
        return new CompositeByteBuf(Unpooled.ALLOC, false, v);
    }

    public static ByteBuf copiedBuffer(ByteBuf byteBuf0) {
        int v = byteBuf0.readableBytes();
        if(v > 0) {
            ByteBuf byteBuf1 = Unpooled.buffer(v);
            byteBuf1.writeBytes(byteBuf0, byteBuf0.readerIndex(), v);
            return byteBuf1;
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(CharSequence charSequence0, int v, int v1, Charset charset0) {
        ObjectUtil.checkNotNull(charSequence0, "string");
        if(v1 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        if(charSequence0 instanceof CharBuffer) {
            if(((CharBuffer)charSequence0).hasArray()) {
                return Unpooled.copiedBuffer(((CharBuffer)charSequence0).array(), ((CharBuffer)charSequence0).position() + ((CharBuffer)charSequence0).arrayOffset() + v, v1, charset0);
            }
            CharBuffer charBuffer0 = ((CharBuffer)charSequence0).slice();
            charBuffer0.limit(v1);
            charBuffer0.position(v);
            return Unpooled.copiedBuffer(charBuffer0, charset0);
        }
        return Unpooled.copiedBuffer(CharBuffer.wrap(charSequence0, v, v1 + v), charset0);
    }

    public static ByteBuf copiedBuffer(CharSequence charSequence0, Charset charset0) {
        ObjectUtil.checkNotNull(charSequence0, "string");
        if(CharsetUtil.UTF_8.equals(charset0)) {
            return Unpooled.copiedBufferUtf8(charSequence0);
        }
        if(CharsetUtil.US_ASCII.equals(charset0)) {
            return Unpooled.copiedBufferAscii(charSequence0);
        }
        return charSequence0 instanceof CharBuffer ? Unpooled.copiedBuffer(((CharBuffer)charSequence0), charset0) : Unpooled.copiedBuffer(CharBuffer.wrap(charSequence0), charset0);
    }

    public static ByteBuf copiedBuffer(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.remaining();
        if(v == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        byte[] arr_b = PlatformDependent.allocateUninitializedArray(v);
        ByteBuffer byteBuffer1 = byteBuffer0.duplicate();
        byteBuffer1.get(arr_b);
        return Unpooled.wrappedBuffer(arr_b).order(byteBuffer1.order());
    }

    private static ByteBuf copiedBuffer(CharBuffer charBuffer0, Charset charset0) {
        return ByteBufUtil.encodeString0(Unpooled.ALLOC, true, charBuffer0, charset0, 0);
    }

    public static ByteBuf copiedBuffer(byte[] arr_b) {
        return arr_b.length == 0 ? Unpooled.EMPTY_BUFFER : Unpooled.wrappedBuffer(((byte[])arr_b.clone()));
    }

    public static ByteBuf copiedBuffer(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        byte[] arr_b1 = PlatformDependent.allocateUninitializedArray(v1);
        System.arraycopy(arr_b, v, arr_b1, 0, v1);
        return Unpooled.wrappedBuffer(arr_b1);
    }

    public static ByteBuf copiedBuffer(char[] arr_c, int v, int v1, Charset charset0) {
        ObjectUtil.checkNotNull(arr_c, "array");
        return v1 == 0 ? Unpooled.EMPTY_BUFFER : Unpooled.copiedBuffer(CharBuffer.wrap(arr_c, v, v1), charset0);
    }

    public static ByteBuf copiedBuffer(char[] arr_c, Charset charset0) {
        ObjectUtil.checkNotNull(arr_c, "array");
        return Unpooled.copiedBuffer(arr_c, 0, arr_c.length, charset0);
    }

    public static ByteBuf copiedBuffer(ByteBuf[] arr_byteBuf) {
        switch(arr_byteBuf.length) {
            case 0: {
                return Unpooled.EMPTY_BUFFER;
            }
            case 1: {
                return Unpooled.copiedBuffer(arr_byteBuf[0]);
            }
            default: {
                ByteOrder byteOrder0 = null;
                int v2 = 0;
                for(int v1 = 0; v1 < arr_byteBuf.length; ++v1) {
                    ByteBuf byteBuf0 = arr_byteBuf[v1];
                    int v3 = byteBuf0.readableBytes();
                    if(v3 > 0) {
                        if(0x7FFFFFFF - v2 < v3) {
                            throw new IllegalArgumentException("The total length of the specified buffers is too big.");
                        }
                        v2 += v3;
                        if(byteOrder0 == null) {
                            byteOrder0 = byteBuf0.order();
                        }
                        else if(!byteOrder0.equals(byteBuf0.order())) {
                            throw new IllegalArgumentException("inconsistent byte order");
                        }
                    }
                }
                if(v2 == 0) {
                    return Unpooled.EMPTY_BUFFER;
                }
                byte[] arr_b = PlatformDependent.allocateUninitializedArray(v2);
                int v4 = 0;
                for(int v = 0; v < arr_byteBuf.length; ++v) {
                    ByteBuf byteBuf1 = arr_byteBuf[v];
                    int v5 = byteBuf1.readableBytes();
                    byteBuf1.getBytes(byteBuf1.readerIndex(), arr_b, v4, v5);
                    v4 += v5;
                }
                return Unpooled.wrappedBuffer(arr_b).order(byteOrder0);
            }
        }
    }

    public static ByteBuf copiedBuffer(ByteBuffer[] arr_byteBuffer) {
        switch(arr_byteBuffer.length) {
            case 0: {
                return Unpooled.EMPTY_BUFFER;
            }
            case 1: {
                return Unpooled.copiedBuffer(arr_byteBuffer[0]);
            }
            default: {
                ByteOrder byteOrder0 = null;
                int v2 = 0;
                for(int v1 = 0; v1 < arr_byteBuffer.length; ++v1) {
                    ByteBuffer byteBuffer0 = arr_byteBuffer[v1];
                    int v3 = byteBuffer0.remaining();
                    if(v3 > 0) {
                        if(0x7FFFFFFF - v2 < v3) {
                            throw new IllegalArgumentException("The total length of the specified buffers is too big.");
                        }
                        v2 += v3;
                        if(byteOrder0 == null) {
                            byteOrder0 = byteBuffer0.order();
                        }
                        else if(!byteOrder0.equals(byteBuffer0.order())) {
                            throw new IllegalArgumentException("inconsistent byte order");
                        }
                    }
                }
                if(v2 == 0) {
                    return Unpooled.EMPTY_BUFFER;
                }
                byte[] arr_b = PlatformDependent.allocateUninitializedArray(v2);
                int v4 = 0;
                for(int v = 0; v < arr_byteBuffer.length; ++v) {
                    ByteBuffer byteBuffer1 = arr_byteBuffer[v].duplicate();
                    int v5 = byteBuffer1.remaining();
                    byteBuffer1.get(arr_b, v4, v5);
                    v4 += v5;
                }
                return Unpooled.wrappedBuffer(arr_b).order(byteOrder0);
            }
        }
    }

    public static ByteBuf copiedBuffer(byte[][] arr2_b) {
        switch(arr2_b.length) {
            case 0: {
                return Unpooled.EMPTY_BUFFER;
            }
            case 1: {
                byte[] arr_b3 = arr2_b[0];
                return arr_b3.length == 0 ? Unpooled.EMPTY_BUFFER : Unpooled.copiedBuffer(arr_b3);
            }
            default: {
                int v1 = 0;
                for(int v = 0; v < arr2_b.length; ++v) {
                    byte[] arr_b = arr2_b[v];
                    if(0x7FFFFFFF - v1 < arr_b.length) {
                        throw new IllegalArgumentException("The total length of the specified arrays is too big.");
                    }
                    v1 += arr_b.length;
                }
                if(v1 == 0) {
                    return Unpooled.EMPTY_BUFFER;
                }
                byte[] arr_b1 = PlatformDependent.allocateUninitializedArray(v1);
                int v3 = 0;
                for(int v2 = 0; v2 < arr2_b.length; ++v2) {
                    byte[] arr_b2 = arr2_b[v2];
                    System.arraycopy(arr_b2, 0, arr_b1, v3, arr_b2.length);
                    v3 += arr_b2.length;
                }
                return Unpooled.wrappedBuffer(arr_b1);
            }
        }
    }

    private static ByteBuf copiedBufferAscii(CharSequence charSequence0) {
        int v = charSequence0.length();
        ByteBuf byteBuf0 = Unpooled.ALLOC.heapBuffer(v);
        try {
            ByteBufUtil.writeAscii(byteBuf0, charSequence0);
            return byteBuf0;
        }
        catch(Throwable throwable0) {
            byteBuf0.release();
            throw throwable0;
        }
    }

    private static ByteBuf copiedBufferUtf8(CharSequence charSequence0) {
        int v = ByteBufUtil.utf8Bytes(charSequence0);
        ByteBuf byteBuf0 = Unpooled.ALLOC.heapBuffer(v);
        try {
            ByteBufUtil.writeUtf8(byteBuf0, charSequence0);
            return byteBuf0;
        }
        catch(Throwable throwable0) {
            byteBuf0.release();
            throw throwable0;
        }
    }

    public static ByteBuf copyBoolean(boolean z) {
        ByteBuf byteBuf0 = Unpooled.buffer(1);
        byteBuf0.writeBoolean(z);
        return byteBuf0;
    }

    public static ByteBuf copyBoolean(boolean[] arr_z) {
        if(arr_z != null && arr_z.length != 0) {
            ByteBuf byteBuf0 = Unpooled.buffer(arr_z.length);
            for(int v = 0; v < arr_z.length; ++v) {
                byteBuf0.writeBoolean(arr_z[v]);
            }
            return byteBuf0;
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public static ByteBuf copyDouble(double f) {
        ByteBuf byteBuf0 = Unpooled.buffer(8);
        byteBuf0.writeDouble(f);
        return byteBuf0;
    }

    public static ByteBuf copyDouble(double[] arr_f) {
        if(arr_f != null && arr_f.length != 0) {
            ByteBuf byteBuf0 = Unpooled.buffer(arr_f.length * 8);
            for(int v = 0; v < arr_f.length; ++v) {
                byteBuf0.writeDouble(arr_f[v]);
            }
            return byteBuf0;
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public static ByteBuf copyFloat(float f) {
        ByteBuf byteBuf0 = Unpooled.buffer(4);
        byteBuf0.writeFloat(f);
        return byteBuf0;
    }

    public static ByteBuf copyFloat(float[] arr_f) {
        if(arr_f != null && arr_f.length != 0) {
            ByteBuf byteBuf0 = Unpooled.buffer(arr_f.length * 4);
            for(int v = 0; v < arr_f.length; ++v) {
                byteBuf0.writeFloat(arr_f[v]);
            }
            return byteBuf0;
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public static ByteBuf copyInt(int v) {
        ByteBuf byteBuf0 = Unpooled.buffer(4);
        byteBuf0.writeInt(v);
        return byteBuf0;
    }

    public static ByteBuf copyInt(int[] arr_v) {
        if(arr_v != null && arr_v.length != 0) {
            ByteBuf byteBuf0 = Unpooled.buffer(arr_v.length * 4);
            for(int v = 0; v < arr_v.length; ++v) {
                byteBuf0.writeInt(arr_v[v]);
            }
            return byteBuf0;
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public static ByteBuf copyLong(long v) {
        ByteBuf byteBuf0 = Unpooled.buffer(8);
        byteBuf0.writeLong(v);
        return byteBuf0;
    }

    public static ByteBuf copyLong(long[] arr_v) {
        if(arr_v != null && arr_v.length != 0) {
            ByteBuf byteBuf0 = Unpooled.buffer(arr_v.length * 8);
            for(int v = 0; v < arr_v.length; ++v) {
                byteBuf0.writeLong(arr_v[v]);
            }
            return byteBuf0;
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public static ByteBuf copyMedium(int v) {
        ByteBuf byteBuf0 = Unpooled.buffer(3);
        byteBuf0.writeMedium(v);
        return byteBuf0;
    }

    public static ByteBuf copyMedium(int[] arr_v) {
        if(arr_v != null && arr_v.length != 0) {
            ByteBuf byteBuf0 = Unpooled.buffer(arr_v.length * 3);
            for(int v = 0; v < arr_v.length; ++v) {
                byteBuf0.writeMedium(arr_v[v]);
            }
            return byteBuf0;
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public static ByteBuf copyShort(int v) {
        ByteBuf byteBuf0 = Unpooled.buffer(2);
        byteBuf0.writeShort(v);
        return byteBuf0;
    }

    public static ByteBuf copyShort(int[] arr_v) {
        if(arr_v != null && arr_v.length != 0) {
            ByteBuf byteBuf0 = Unpooled.buffer(arr_v.length * 2);
            for(int v = 0; v < arr_v.length; ++v) {
                byteBuf0.writeShort(arr_v[v]);
            }
            return byteBuf0;
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public static ByteBuf copyShort(short[] arr_v) {
        if(arr_v != null && arr_v.length != 0) {
            ByteBuf byteBuf0 = Unpooled.buffer(arr_v.length * 2);
            for(int v = 0; v < arr_v.length; ++v) {
                byteBuf0.writeShort(((int)arr_v[v]));
            }
            return byteBuf0;
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public static ByteBuf directBuffer() {
        return Unpooled.ALLOC.directBuffer();
    }

    public static ByteBuf directBuffer(int v) {
        return Unpooled.ALLOC.directBuffer(v);
    }

    public static ByteBuf directBuffer(int v, int v1) {
        return Unpooled.ALLOC.directBuffer(v, v1);
    }

    @Deprecated
    public static ByteBuf unmodifiableBuffer(ByteBuf byteBuf0) {
        ByteOrder byteOrder0 = byteBuf0.order();
        ByteOrder byteOrder1 = Unpooled.BIG_ENDIAN;
        return byteOrder0 == byteOrder1 ? new ReadOnlyByteBuf(byteBuf0) : new ReadOnlyByteBuf(byteBuf0.order(byteOrder1)).order(Unpooled.LITTLE_ENDIAN);
    }

    @Deprecated
    public static ByteBuf unmodifiableBuffer(ByteBuf[] arr_byteBuf) {
        return Unpooled.wrappedUnmodifiableBuffer(true, arr_byteBuf);
    }

    public static ByteBuf unreleasableBuffer(ByteBuf byteBuf0) {
        return new UnreleasableByteBuf(byteBuf0);
    }

    public static ByteBuf wrappedBuffer(int v, ByteWrapper compositeByteBuf$ByteWrapper0, Object[] arr_object) {
    alab1:
        switch(arr_object.length) {
            case 0: {
                break;
            }
            case 1: {
                return compositeByteBuf$ByteWrapper0.isEmpty(arr_object[0]) ? Unpooled.EMPTY_BUFFER : compositeByteBuf$ByteWrapper0.wrap(arr_object[0]);
            label_3:
                for(int v1 = 0; true; ++v1) {
                    if(v1 >= arr_object.length) {
                        break alab1;
                    }
                    Object object0 = arr_object[v1];
                    if(object0 == null) {
                        return Unpooled.EMPTY_BUFFER;
                    }
                    if(!compositeByteBuf$ByteWrapper0.isEmpty(object0)) {
                        return new CompositeByteBuf(Unpooled.ALLOC, false, v, compositeByteBuf$ByteWrapper0, arr_object, v1);
                    }
                }
            }
            default: {
                goto label_3;
            }
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(int v, ByteBuf[] arr_byteBuf) {
        if(arr_byteBuf.length != 0) {
            if(arr_byteBuf.length != 1) {
                for(int v1 = 0; v1 < arr_byteBuf.length; ++v1) {
                    ByteBuf byteBuf0 = arr_byteBuf[v1];
                    if(byteBuf0.isReadable()) {
                        return new CompositeByteBuf(Unpooled.ALLOC, false, v, arr_byteBuf, v1);
                    }
                    byteBuf0.release();
                }
                return Unpooled.EMPTY_BUFFER;
            }
            ByteBuf byteBuf1 = arr_byteBuf[0];
            if(byteBuf1.isReadable()) {
                return Unpooled.wrappedBuffer(byteBuf1.order(Unpooled.BIG_ENDIAN));
            }
            byteBuf1.release();
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(int v, ByteBuffer[] arr_byteBuffer) {
        return Unpooled.wrappedBuffer(v, CompositeByteBuf.BYTE_BUFFER_WRAPPER, arr_byteBuffer);
    }

    public static ByteBuf wrappedBuffer(int v, byte[][] arr2_b) {
        return Unpooled.wrappedBuffer(v, CompositeByteBuf.BYTE_ARRAY_WRAPPER, arr2_b);
    }

    public static ByteBuf wrappedBuffer(long v, int v1, boolean z) {
        return new WrappedUnpooledUnsafeDirectByteBuf(Unpooled.ALLOC, v, v1, z);
    }

    public static ByteBuf wrappedBuffer(ByteBuf byteBuf0) {
        if(byteBuf0.isReadable()) {
            return byteBuf0.slice();
        }
        byteBuf0.release();
        return Unpooled.EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(ByteBuffer byteBuffer0) {
        if(!byteBuffer0.hasRemaining()) {
            return Unpooled.EMPTY_BUFFER;
        }
        if(!byteBuffer0.isDirect() && byteBuffer0.hasArray()) {
            return Unpooled.wrappedBuffer(byteBuffer0.array(), byteBuffer0.position() + byteBuffer0.arrayOffset(), byteBuffer0.remaining()).order(byteBuffer0.order());
        }
        if(PlatformDependent.hasUnsafe()) {
            if(byteBuffer0.isReadOnly()) {
                return byteBuffer0.isDirect() ? new ReadOnlyUnsafeDirectByteBuf(Unpooled.ALLOC, byteBuffer0) : new ReadOnlyByteBufferBuf(Unpooled.ALLOC, byteBuffer0);
            }
            return new UnpooledUnsafeDirectByteBuf(Unpooled.ALLOC, byteBuffer0, byteBuffer0.remaining());
        }
        return byteBuffer0.isReadOnly() ? new ReadOnlyByteBufferBuf(Unpooled.ALLOC, byteBuffer0) : new UnpooledDirectByteBuf(Unpooled.ALLOC, byteBuffer0, byteBuffer0.remaining());
    }

    public static ByteBuf wrappedBuffer(byte[] arr_b) {
        return arr_b.length == 0 ? Unpooled.EMPTY_BUFFER : new UnpooledHeapByteBuf(Unpooled.ALLOC, arr_b, arr_b.length);
    }

    public static ByteBuf wrappedBuffer(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        return v != 0 || v1 != arr_b.length ? Unpooled.wrappedBuffer(arr_b).slice(v, v1) : Unpooled.wrappedBuffer(arr_b);
    }

    public static ByteBuf wrappedBuffer(ByteBuf[] arr_byteBuf) {
        return Unpooled.wrappedBuffer(arr_byteBuf.length, arr_byteBuf);
    }

    public static ByteBuf wrappedBuffer(ByteBuffer[] arr_byteBuffer) {
        return Unpooled.wrappedBuffer(arr_byteBuffer.length, arr_byteBuffer);
    }

    public static ByteBuf wrappedBuffer(byte[][] arr2_b) {
        return Unpooled.wrappedBuffer(arr2_b.length, arr2_b);
    }

    private static ByteBuf wrappedUnmodifiableBuffer(boolean z, ByteBuf[] arr_byteBuf) {
        switch(arr_byteBuf.length) {
            case 0: {
                return Unpooled.EMPTY_BUFFER;
            }
            case 1: {
                return arr_byteBuf[0].asReadOnly();
            }
            default: {
                if(z) {
                    arr_byteBuf = (ByteBuf[])Arrays.copyOf(arr_byteBuf, arr_byteBuf.length, ByteBuf[].class);
                }
                return new FixedCompositeByteBuf(Unpooled.ALLOC, arr_byteBuf);
            }
        }
    }

    public static ByteBuf wrappedUnmodifiableBuffer(ByteBuf[] arr_byteBuf) {
        return Unpooled.wrappedUnmodifiableBuffer(false, arr_byteBuf);
    }
}

