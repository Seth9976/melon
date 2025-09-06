package io.netty.buffer;

import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

final class UnsafeByteBufUtil {
    static final boolean $assertionsDisabled = false;
    private static final int MAX_HAND_ROLLED_SET_ZERO_BYTES = 0x40;
    private static final boolean UNALIGNED;
    private static final byte ZERO;

    static {
        UnsafeByteBufUtil.UNALIGNED = PlatformDependent.isUnaligned();
    }

    private static void batchSetZero(long v, int v1) {
        for(int v2 = 0; v2 < v1 / 8; ++v2) {
            PlatformDependent.putLong(v, 0L);
            v += 8L;
        }
        for(int v3 = 0; v3 < v1 % 8; ++v3) {
            PlatformDependent.putByte(((long)v3) + v, 0);
        }
    }

    private static void batchSetZero(byte[] arr_b, int v, int v1) {
        for(int v2 = 0; v2 < v1 / 8; ++v2) {
            PlatformDependent.putLong(arr_b, v, 0L);
            v += 8;
        }
        for(int v3 = 0; v3 < v1 % 8; ++v3) {
            PlatformDependent.putByte(arr_b, v + v3, 0);
        }
    }

    public static ByteBuf copy(AbstractByteBuf abstractByteBuf0, long v, int v1, int v2) {
        abstractByteBuf0.checkIndex(v1, v2);
        ByteBuf byteBuf0 = abstractByteBuf0.alloc().directBuffer(v2, abstractByteBuf0.maxCapacity());
        if(v2 != 0) {
            if(byteBuf0.hasMemoryAddress()) {
                PlatformDependent.copyMemory(v, byteBuf0.memoryAddress(), v2);
                byteBuf0.setIndex(0, v2);
                return byteBuf0;
            }
            byteBuf0.writeBytes(abstractByteBuf0, v1, v2);
        }
        return byteBuf0;
    }

    public static byte getByte(long v) {
        return PlatformDependent.getByte(v);
    }

    public static byte getByte(byte[] arr_b, int v) {
        return PlatformDependent.getByte(arr_b, v);
    }

    private static void getBytes(long v, byte[] arr_b, int v1, int v2, OutputStream outputStream0, int v3) {
        long v4 = v;
        do {
            int v5 = Math.min(v2, v3);
            PlatformDependent.copyMemory(v4, arr_b, v1, v5);
            outputStream0.write(arr_b, v1, v5);
            v3 -= v5;
            v4 += (long)v5;
        }
        while(v3 > 0);
    }

    public static void getBytes(AbstractByteBuf abstractByteBuf0, long v, int v1, ByteBuf byteBuf0, int v2, int v3) {
        abstractByteBuf0.checkIndex(v1, v3);
        ObjectUtil.checkNotNull(byteBuf0, "dst");
        if(MathUtil.isOutOfBounds(v2, v3, byteBuf0.capacity())) {
            throw new IndexOutOfBoundsException("dstIndex: " + v2);
        }
        if(byteBuf0.hasMemoryAddress()) {
            PlatformDependent.copyMemory(v, byteBuf0.memoryAddress() + ((long)v2), v3);
            return;
        }
        if(byteBuf0.hasArray()) {
            PlatformDependent.copyMemory(v, byteBuf0.array(), byteBuf0.arrayOffset() + v2, v3);
            return;
        }
        byteBuf0.setBytes(v2, abstractByteBuf0, v1, v3);
    }

    public static void getBytes(AbstractByteBuf abstractByteBuf0, long v, int v1, OutputStream outputStream0, int v2) {
        abstractByteBuf0.checkIndex(v1, v2);
        if(v2 != 0) {
            int v3 = Math.min(v2, 0x2000);
            if(v3 > 0x400 && abstractByteBuf0.alloc().isDirectBufferPooled()) {
                ByteBuf byteBuf0 = abstractByteBuf0.alloc().heapBuffer(v3);
                try {
                    UnsafeByteBufUtil.getBytes(v, byteBuf0.array(), byteBuf0.arrayOffset(), v3, outputStream0, v2);
                }
                finally {
                    byteBuf0.release();
                }
                return;
            }
            UnsafeByteBufUtil.getBytes(v, ByteBufUtil.threadLocalTempArray(v3), 0, v3, outputStream0, v2);
        }
    }

    public static void getBytes(AbstractByteBuf abstractByteBuf0, long v, int v1, ByteBuffer byteBuffer0) {
        abstractByteBuf0.checkIndex(v1, byteBuffer0.remaining());
        if(byteBuffer0.remaining() == 0) {
            return;
        }
        if(byteBuffer0.isDirect()) {
            if(byteBuffer0.isReadOnly()) {
                throw new ReadOnlyBufferException();
            }
            PlatformDependent.copyMemory(v, PlatformDependent.directBufferAddress(byteBuffer0) + ((long)byteBuffer0.position()), byteBuffer0.remaining());
            byteBuffer0.position(byteBuffer0.remaining() + byteBuffer0.position());
            return;
        }
        if(byteBuffer0.hasArray()) {
            PlatformDependent.copyMemory(v, byteBuffer0.array(), byteBuffer0.position() + byteBuffer0.arrayOffset(), byteBuffer0.remaining());
            byteBuffer0.position(byteBuffer0.remaining() + byteBuffer0.position());
            return;
        }
        byteBuffer0.put(abstractByteBuf0.nioBuffer());
    }

    public static void getBytes(AbstractByteBuf abstractByteBuf0, long v, int v1, byte[] arr_b, int v2, int v3) {
        abstractByteBuf0.checkIndex(v1, v3);
        ObjectUtil.checkNotNull(arr_b, "dst");
        if(MathUtil.isOutOfBounds(v2, v3, arr_b.length)) {
            throw new IndexOutOfBoundsException("dstIndex: " + v2);
        }
        if(v3 != 0) {
            PlatformDependent.copyMemory(v, arr_b, v2, v3);
        }
    }

    public static int getInt(long v) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            int v1 = PlatformDependent.getInt(v);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? v1 : Integer.reverseBytes(v1);
        }
        int v2 = PlatformDependent.getByte(v);
        int v3 = PlatformDependent.getByte(v + 1L);
        int v4 = PlatformDependent.getByte(v + 2L);
        return PlatformDependent.getByte(v + 3L) & 0xFF | (v2 << 24 | (v3 & 0xFF) << 16 | (v4 & 0xFF) << 8);
    }

    public static int getInt(byte[] arr_b, int v) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            int v1 = PlatformDependent.getInt(arr_b, v);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? v1 : Integer.reverseBytes(v1);
        }
        int v2 = PlatformDependent.getByte(arr_b, v);
        int v3 = PlatformDependent.getByte(arr_b, v + 1);
        int v4 = PlatformDependent.getByte(arr_b, v + 2);
        return PlatformDependent.getByte(arr_b, v + 3) & 0xFF | (v2 << 24 | (v3 & 0xFF) << 16 | (v4 & 0xFF) << 8);
    }

    public static int getIntLE(long v) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            int v1 = PlatformDependent.getInt(v);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(v1) : v1;
        }
        int v2 = PlatformDependent.getByte(v);
        int v3 = PlatformDependent.getByte(v + 1L);
        int v4 = PlatformDependent.getByte(v + 2L);
        return PlatformDependent.getByte(v + 3L) << 24 | (v2 & 0xFF | (v3 & 0xFF) << 8 | (v4 & 0xFF) << 16);
    }

    public static int getIntLE(byte[] arr_b, int v) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            int v1 = PlatformDependent.getInt(arr_b, v);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(v1) : v1;
        }
        int v2 = PlatformDependent.getByte(arr_b, v);
        int v3 = PlatformDependent.getByte(arr_b, v + 1);
        int v4 = PlatformDependent.getByte(arr_b, v + 2);
        return PlatformDependent.getByte(arr_b, v + 3) << 24 | (v2 & 0xFF | (v3 & 0xFF) << 8 | (v4 & 0xFF) << 16);
    }

    public static long getLong(long v) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            long v1 = PlatformDependent.getLong(v);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? v1 : Long.reverseBytes(v1);
        }
        long v2 = ((long)PlatformDependent.getByte(v)) << 56 | (((long)PlatformDependent.getByte(v + 1L)) & 0xFFL) << 0x30 | (((long)PlatformDependent.getByte(v + 2L)) & 0xFFL) << 40 | (((long)PlatformDependent.getByte(v + 3L)) & 0xFFL) << 0x20 | (((long)PlatformDependent.getByte(v + 4L)) & 0xFFL) << 24 | (((long)PlatformDependent.getByte(v + 5L)) & 0xFFL) << 16 | (((long)PlatformDependent.getByte(v + 6L)) & 0xFFL) << 8;
        return ((long)PlatformDependent.getByte(v + 7L)) & 0xFFL | v2;
    }

    public static long getLong(byte[] arr_b, int v) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            long v1 = PlatformDependent.getLong(arr_b, v);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? v1 : Long.reverseBytes(v1);
        }
        long v2 = ((long)PlatformDependent.getByte(arr_b, v)) << 56 | (((long)PlatformDependent.getByte(arr_b, v + 1)) & 0xFFL) << 0x30 | (((long)PlatformDependent.getByte(arr_b, v + 2)) & 0xFFL) << 40 | (((long)PlatformDependent.getByte(arr_b, v + 3)) & 0xFFL) << 0x20 | (((long)PlatformDependent.getByte(arr_b, v + 4)) & 0xFFL) << 24 | (((long)PlatformDependent.getByte(arr_b, v + 5)) & 0xFFL) << 16 | (((long)PlatformDependent.getByte(arr_b, v + 6)) & 0xFFL) << 8;
        return ((long)PlatformDependent.getByte(arr_b, v + 7)) & 0xFFL | v2;
    }

    public static long getLongLE(long v) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            long v1 = PlatformDependent.getLong(v);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(v1) : v1;
        }
        long v2 = ((long)PlatformDependent.getByte(v)) & 0xFFL | (((long)PlatformDependent.getByte(v + 1L)) & 0xFFL) << 8 | (((long)PlatformDependent.getByte(v + 2L)) & 0xFFL) << 16 | (((long)PlatformDependent.getByte(v + 3L)) & 0xFFL) << 24 | (((long)PlatformDependent.getByte(v + 4L)) & 0xFFL) << 0x20 | (((long)PlatformDependent.getByte(v + 5L)) & 0xFFL) << 40 | (0xFFL & ((long)PlatformDependent.getByte(v + 6L))) << 0x30;
        return ((long)PlatformDependent.getByte(v + 7L)) << 56 | v2;
    }

    public static long getLongLE(byte[] arr_b, int v) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            long v1 = PlatformDependent.getLong(arr_b, v);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(v1) : v1;
        }
        long v2 = ((long)PlatformDependent.getByte(arr_b, v)) & 0xFFL | (((long)PlatformDependent.getByte(arr_b, v + 1)) & 0xFFL) << 8 | (((long)PlatformDependent.getByte(arr_b, v + 2)) & 0xFFL) << 16 | (((long)PlatformDependent.getByte(arr_b, v + 3)) & 0xFFL) << 24 | (((long)PlatformDependent.getByte(arr_b, v + 4)) & 0xFFL) << 0x20 | (((long)PlatformDependent.getByte(arr_b, v + 5)) & 0xFFL) << 40 | (0xFFL & ((long)PlatformDependent.getByte(arr_b, v + 6))) << 0x30;
        return ((long)PlatformDependent.getByte(arr_b, v + 7)) << 56 | v2;
    }

    public static short getShort(long v) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            short v1 = PlatformDependent.getShort(v);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? v1 : Short.reverseBytes(v1);
        }
        int v2 = PlatformDependent.getByte(v);
        return (short)(PlatformDependent.getByte(v + 1L) & 0xFF | v2 << 8);
    }

    public static short getShort(byte[] arr_b, int v) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            short v1 = PlatformDependent.getShort(arr_b, v);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? v1 : Short.reverseBytes(v1);
        }
        int v2 = PlatformDependent.getByte(arr_b, v);
        return (short)(PlatformDependent.getByte(arr_b, v + 1) & 0xFF | v2 << 8);
    }

    public static short getShortLE(long v) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            short v1 = PlatformDependent.getShort(v);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(v1) : v1;
        }
        int v2 = PlatformDependent.getByte(v);
        return (short)(PlatformDependent.getByte(v + 1L) << 8 | v2 & 0xFF);
    }

    public static short getShortLE(byte[] arr_b, int v) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            short v1 = PlatformDependent.getShort(arr_b, v);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(v1) : v1;
        }
        int v2 = PlatformDependent.getByte(arr_b, v);
        return (short)(PlatformDependent.getByte(arr_b, v + 1) << 8 | v2 & 0xFF);
    }

    public static int getUnsignedMedium(long v) {
        int v1;
        if(UnsafeByteBufUtil.UNALIGNED) {
            v1 = (PlatformDependent.getByte(v) & 0xFF) << 16;
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? PlatformDependent.getShort(v + 1L) & 0xFFFF | v1 : Short.reverseBytes(PlatformDependent.getShort(v + 1L)) & 0xFFFF | v1;
        }
        v1 = (PlatformDependent.getByte(v) & 0xFF) << 16 | (PlatformDependent.getByte(v + 1L) & 0xFF) << 8;
        return PlatformDependent.getByte(v + 2L) & 0xFF | v1;
    }

    public static int getUnsignedMedium(byte[] arr_b, int v) {
        int v1;
        if(UnsafeByteBufUtil.UNALIGNED) {
            v1 = (PlatformDependent.getByte(arr_b, v) & 0xFF) << 16;
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? PlatformDependent.getShort(arr_b, v + 1) & 0xFFFF | v1 : Short.reverseBytes(PlatformDependent.getShort(arr_b, v + 1)) & 0xFFFF | v1;
        }
        v1 = (PlatformDependent.getByte(arr_b, v) & 0xFF) << 16 | (PlatformDependent.getByte(arr_b, v + 1) & 0xFF) << 8;
        return PlatformDependent.getByte(arr_b, v + 2) & 0xFF | v1;
    }

    public static int getUnsignedMediumLE(long v) {
        int v1;
        if(UnsafeByteBufUtil.UNALIGNED) {
            v1 = PlatformDependent.getByte(v) & 0xFF;
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? (Short.reverseBytes(PlatformDependent.getShort(v + 1L)) & 0xFFFF) << 8 | v1 : (PlatformDependent.getShort(v + 1L) & 0xFFFF) << 8 | v1;
        }
        v1 = PlatformDependent.getByte(v) & 0xFF | (PlatformDependent.getByte(v + 1L) & 0xFF) << 8;
        return (PlatformDependent.getByte(v + 2L) & 0xFF) << 16 | v1;
    }

    public static int getUnsignedMediumLE(byte[] arr_b, int v) {
        int v1;
        if(UnsafeByteBufUtil.UNALIGNED) {
            v1 = PlatformDependent.getByte(arr_b, v) & 0xFF;
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? (Short.reverseBytes(PlatformDependent.getShort(arr_b, v + 1)) & 0xFFFF) << 8 | v1 : (PlatformDependent.getShort(arr_b, v + 1) & 0xFFFF) << 8 | v1;
        }
        v1 = PlatformDependent.getByte(arr_b, v) & 0xFF | (PlatformDependent.getByte(arr_b, v + 1) & 0xFF) << 8;
        return (PlatformDependent.getByte(arr_b, v + 2) & 0xFF) << 16 | v1;
    }

    public static UnpooledUnsafeDirectByteBuf newUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator0, int v, int v1) {
        return PlatformDependent.useDirectBufferNoCleaner() ? new UnpooledUnsafeNoCleanerDirectByteBuf(byteBufAllocator0, v, v1) : new UnpooledUnsafeDirectByteBuf(byteBufAllocator0, v, v1);
    }

    public static void setByte(long v, int v1) {
        PlatformDependent.putByte(v, ((byte)v1));
    }

    public static void setByte(byte[] arr_b, int v, int v1) {
        PlatformDependent.putByte(arr_b, v, ((byte)v1));
    }

    public static int setBytes(AbstractByteBuf abstractByteBuf0, long v, int v1, InputStream inputStream0, int v2) {
        abstractByteBuf0.checkIndex(v1, v2);
        ByteBuf byteBuf0 = abstractByteBuf0.alloc().heapBuffer(v2);
        try {
            byte[] arr_b = byteBuf0.array();
            int v4 = byteBuf0.arrayOffset();
            int v5 = inputStream0.read(arr_b, v4, v2);
            if(v5 > 0) {
                PlatformDependent.copyMemory(arr_b, v4, v, ((long)v5));
            }
            return v5;
        }
        finally {
            byteBuf0.release();
        }
    }

    public static void setBytes(AbstractByteBuf abstractByteBuf0, long v, int v1, ByteBuf byteBuf0, int v2, int v3) {
        abstractByteBuf0.checkIndex(v1, v3);
        ObjectUtil.checkNotNull(byteBuf0, "src");
        if(MathUtil.isOutOfBounds(v2, v3, byteBuf0.capacity())) {
            throw new IndexOutOfBoundsException("srcIndex: " + v2);
        }
        if(v3 != 0) {
            if(byteBuf0.hasMemoryAddress()) {
                PlatformDependent.copyMemory(byteBuf0.memoryAddress() + ((long)v2), v, v3);
                return;
            }
            if(byteBuf0.hasArray()) {
                PlatformDependent.copyMemory(byteBuf0.array(), byteBuf0.arrayOffset() + v2, v, ((long)v3));
                return;
            }
            byteBuf0.getBytes(v2, abstractByteBuf0, v1, v3);
        }
    }

    public static void setBytes(AbstractByteBuf abstractByteBuf0, long v, int v1, ByteBuffer byteBuffer0) {
        int v2 = byteBuffer0.remaining();
        if(v2 == 0) {
            return;
        }
        if(byteBuffer0.isDirect()) {
            abstractByteBuf0.checkIndex(v1, v2);
            PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer0) + ((long)byteBuffer0.position()), v, v2);
            byteBuffer0.position(byteBuffer0.position() + v2);
            return;
        }
        if(byteBuffer0.hasArray()) {
            abstractByteBuf0.checkIndex(v1, v2);
            PlatformDependent.copyMemory(byteBuffer0.array(), byteBuffer0.position() + byteBuffer0.arrayOffset(), v, ((long)v2));
            byteBuffer0.position(byteBuffer0.position() + v2);
            return;
        }
        if(v2 < 8) {
            UnsafeByteBufUtil.setSingleBytes(abstractByteBuf0, v, v1, byteBuffer0, v2);
            return;
        }
        abstractByteBuf0.internalNioBuffer(v1, v2).put(byteBuffer0);
    }

    public static void setBytes(AbstractByteBuf abstractByteBuf0, long v, int v1, byte[] arr_b, int v2, int v3) {
        abstractByteBuf0.checkIndex(v1, v3);
        ObjectUtil.checkNotNull(arr_b, "src");
        if(MathUtil.isOutOfBounds(v2, v3, arr_b.length)) {
            throw new IndexOutOfBoundsException("srcIndex: " + v2);
        }
        if(v3 != 0) {
            PlatformDependent.copyMemory(arr_b, v2, v, ((long)v3));
        }
    }

    public static void setInt(long v, int v1) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            if(!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                v1 = Integer.reverseBytes(v1);
            }
            PlatformDependent.putInt(v, v1);
            return;
        }
        PlatformDependent.putByte(v, ((byte)(v1 >>> 24)));
        PlatformDependent.putByte(v + 1L, ((byte)(v1 >>> 16)));
        PlatformDependent.putByte(v + 2L, ((byte)(v1 >>> 8)));
        PlatformDependent.putByte(v + 3L, ((byte)v1));
    }

    public static void setInt(byte[] arr_b, int v, int v1) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            if(!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                v1 = Integer.reverseBytes(v1);
            }
            PlatformDependent.putInt(arr_b, v, v1);
            return;
        }
        PlatformDependent.putByte(arr_b, v, ((byte)(v1 >>> 24)));
        PlatformDependent.putByte(arr_b, v + 1, ((byte)(v1 >>> 16)));
        PlatformDependent.putByte(arr_b, v + 2, ((byte)(v1 >>> 8)));
        PlatformDependent.putByte(arr_b, v + 3, ((byte)v1));
    }

    public static void setIntLE(long v, int v1) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            if(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                v1 = Integer.reverseBytes(v1);
            }
            PlatformDependent.putInt(v, v1);
            return;
        }
        PlatformDependent.putByte(v, ((byte)v1));
        PlatformDependent.putByte(v + 1L, ((byte)(v1 >>> 8)));
        PlatformDependent.putByte(v + 2L, ((byte)(v1 >>> 16)));
        PlatformDependent.putByte(v + 3L, ((byte)(v1 >>> 24)));
    }

    public static void setIntLE(byte[] arr_b, int v, int v1) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            if(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                v1 = Integer.reverseBytes(v1);
            }
            PlatformDependent.putInt(arr_b, v, v1);
            return;
        }
        PlatformDependent.putByte(arr_b, v, ((byte)v1));
        PlatformDependent.putByte(arr_b, v + 1, ((byte)(v1 >>> 8)));
        PlatformDependent.putByte(arr_b, v + 2, ((byte)(v1 >>> 16)));
        PlatformDependent.putByte(arr_b, v + 3, ((byte)(v1 >>> 24)));
    }

    public static void setLong(long v, long v1) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            if(!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                v1 = Long.reverseBytes(v1);
            }
            PlatformDependent.putLong(v, v1);
            return;
        }
        PlatformDependent.putByte(v, ((byte)(((int)(v1 >>> 56)))));
        PlatformDependent.putByte(v + 1L, ((byte)(((int)(v1 >>> 0x30)))));
        PlatformDependent.putByte(v + 2L, ((byte)(((int)(v1 >>> 40)))));
        PlatformDependent.putByte(v + 3L, ((byte)(((int)(v1 >>> 0x20)))));
        PlatformDependent.putByte(v + 4L, ((byte)(((int)(v1 >>> 24)))));
        PlatformDependent.putByte(v + 5L, ((byte)(((int)(v1 >>> 16)))));
        PlatformDependent.putByte(v + 6L, ((byte)(((int)(v1 >>> 8)))));
        PlatformDependent.putByte(v + 7L, ((byte)(((int)v1))));
    }

    public static void setLong(byte[] arr_b, int v, long v1) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            if(!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                v1 = Long.reverseBytes(v1);
            }
            PlatformDependent.putLong(arr_b, v, v1);
            return;
        }
        PlatformDependent.putByte(arr_b, v, ((byte)(((int)(v1 >>> 56)))));
        PlatformDependent.putByte(arr_b, v + 1, ((byte)(((int)(v1 >>> 0x30)))));
        PlatformDependent.putByte(arr_b, v + 2, ((byte)(((int)(v1 >>> 40)))));
        PlatformDependent.putByte(arr_b, v + 3, ((byte)(((int)(v1 >>> 0x20)))));
        PlatformDependent.putByte(arr_b, v + 4, ((byte)(((int)(v1 >>> 24)))));
        PlatformDependent.putByte(arr_b, v + 5, ((byte)(((int)(v1 >>> 16)))));
        PlatformDependent.putByte(arr_b, v + 6, ((byte)(((int)(v1 >>> 8)))));
        PlatformDependent.putByte(arr_b, v + 7, ((byte)(((int)v1))));
    }

    public static void setLongLE(long v, long v1) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            if(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                v1 = Long.reverseBytes(v1);
            }
            PlatformDependent.putLong(v, v1);
            return;
        }
        PlatformDependent.putByte(v, ((byte)(((int)v1))));
        PlatformDependent.putByte(v + 1L, ((byte)(((int)(v1 >>> 8)))));
        PlatformDependent.putByte(v + 2L, ((byte)(((int)(v1 >>> 16)))));
        PlatformDependent.putByte(v + 3L, ((byte)(((int)(v1 >>> 24)))));
        PlatformDependent.putByte(v + 4L, ((byte)(((int)(v1 >>> 0x20)))));
        PlatformDependent.putByte(v + 5L, ((byte)(((int)(v1 >>> 40)))));
        PlatformDependent.putByte(v + 6L, ((byte)(((int)(v1 >>> 0x30)))));
        PlatformDependent.putByte(v + 7L, ((byte)(((int)(v1 >>> 56)))));
    }

    public static void setLongLE(byte[] arr_b, int v, long v1) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            if(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                v1 = Long.reverseBytes(v1);
            }
            PlatformDependent.putLong(arr_b, v, v1);
            return;
        }
        PlatformDependent.putByte(arr_b, v, ((byte)(((int)v1))));
        PlatformDependent.putByte(arr_b, v + 1, ((byte)(((int)(v1 >>> 8)))));
        PlatformDependent.putByte(arr_b, v + 2, ((byte)(((int)(v1 >>> 16)))));
        PlatformDependent.putByte(arr_b, v + 3, ((byte)(((int)(v1 >>> 24)))));
        PlatformDependent.putByte(arr_b, v + 4, ((byte)(((int)(v1 >>> 0x20)))));
        PlatformDependent.putByte(arr_b, v + 5, ((byte)(((int)(v1 >>> 40)))));
        PlatformDependent.putByte(arr_b, v + 6, ((byte)(((int)(v1 >>> 0x30)))));
        PlatformDependent.putByte(arr_b, v + 7, ((byte)(((int)(v1 >>> 56)))));
    }

    public static void setMedium(long v, int v1) {
        PlatformDependent.putByte(v, ((byte)(v1 >>> 16)));
        if(UnsafeByteBufUtil.UNALIGNED) {
            int v2 = (short)v1;
            if(!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                v2 = Short.reverseBytes(((short)v2));
            }
            PlatformDependent.putShort(v + 1L, ((short)v2));
            return;
        }
        PlatformDependent.putByte(v + 1L, ((byte)(v1 >>> 8)));
        PlatformDependent.putByte(v + 2L, ((byte)v1));
    }

    public static void setMedium(byte[] arr_b, int v, int v1) {
        PlatformDependent.putByte(arr_b, v, ((byte)(v1 >>> 16)));
        if(UnsafeByteBufUtil.UNALIGNED) {
            int v2 = (short)v1;
            if(!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                v2 = Short.reverseBytes(((short)v2));
            }
            PlatformDependent.putShort(arr_b, v + 1, ((short)v2));
            return;
        }
        PlatformDependent.putByte(arr_b, v + 1, ((byte)(v1 >>> 8)));
        PlatformDependent.putByte(arr_b, v + 2, ((byte)v1));
    }

    public static void setMediumLE(long v, int v1) {
        PlatformDependent.putByte(v, ((byte)v1));
        if(UnsafeByteBufUtil.UNALIGNED) {
            int v2 = (short)(v1 >>> 8);
            if(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                v2 = Short.reverseBytes(((short)v2));
            }
            PlatformDependent.putShort(v + 1L, ((short)v2));
            return;
        }
        PlatformDependent.putByte(v + 1L, ((byte)(v1 >>> 8)));
        PlatformDependent.putByte(v + 2L, ((byte)(v1 >>> 16)));
    }

    public static void setMediumLE(byte[] arr_b, int v, int v1) {
        PlatformDependent.putByte(arr_b, v, ((byte)v1));
        if(UnsafeByteBufUtil.UNALIGNED) {
            int v2 = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(((short)(v1 >>> 8))) : ((short)(v1 >>> 8));
            PlatformDependent.putShort(arr_b, v + 1, ((short)v2));
            return;
        }
        PlatformDependent.putByte(arr_b, v + 1, ((byte)(v1 >>> 8)));
        PlatformDependent.putByte(arr_b, v + 2, ((byte)(v1 >>> 16)));
    }

    public static void setShort(long v, int v1) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            int v2 = (short)v1;
            if(!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                v2 = Short.reverseBytes(((short)v2));
            }
            PlatformDependent.putShort(v, ((short)v2));
            return;
        }
        PlatformDependent.putByte(v, ((byte)(v1 >>> 8)));
        PlatformDependent.putByte(v + 1L, ((byte)v1));
    }

    public static void setShort(byte[] arr_b, int v, int v1) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            int v2 = (short)v1;
            if(!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                v2 = Short.reverseBytes(((short)v2));
            }
            PlatformDependent.putShort(arr_b, v, ((short)v2));
            return;
        }
        PlatformDependent.putByte(arr_b, v, ((byte)(v1 >>> 8)));
        PlatformDependent.putByte(arr_b, v + 1, ((byte)v1));
    }

    public static void setShortLE(long v, int v1) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            int v2 = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(((short)v1)) : ((short)v1);
            PlatformDependent.putShort(v, ((short)v2));
            return;
        }
        PlatformDependent.putByte(v, ((byte)v1));
        PlatformDependent.putByte(v + 1L, ((byte)(v1 >>> 8)));
    }

    public static void setShortLE(byte[] arr_b, int v, int v1) {
        if(UnsafeByteBufUtil.UNALIGNED) {
            int v2 = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(((short)v1)) : ((short)v1);
            PlatformDependent.putShort(arr_b, v, ((short)v2));
            return;
        }
        PlatformDependent.putByte(arr_b, v, ((byte)v1));
        PlatformDependent.putByte(arr_b, v + 1, ((byte)(v1 >>> 8)));
    }

    private static void setSingleBytes(AbstractByteBuf abstractByteBuf0, long v, int v1, ByteBuffer byteBuffer0, int v2) {
        abstractByteBuf0.checkIndex(v1, v2);
        int v3 = byteBuffer0.position();
        int v4 = byteBuffer0.limit();
        while(v3 < v4) {
            PlatformDependent.putByte(v, byteBuffer0.get(v3));
            ++v;
            ++v3;
        }
        byteBuffer0.position(v4);
    }

    public static void setZero(long v, int v1) {
        if(v1 != 0) {
            if(v1 > 0x40) {
                PlatformDependent.setMemory(v, v1, 0);
                return;
            }
            if(UnsafeByteBufUtil.UNALIGNED) {
                UnsafeByteBufUtil.batchSetZero(v, v1);
                return;
            }
            int v2 = UnsafeByteBufUtil.zeroTillAligned(v, v1);
            v += (long)v2;
            v1 -= v2;
            if(v1 != 0) {
                UnsafeByteBufUtil.batchSetZero(v, v1);
            }
        }
    }

    public static void setZero(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return;
        }
        if(UnsafeByteBufUtil.UNALIGNED && v1 <= 0x40) {
            UnsafeByteBufUtil.batchSetZero(arr_b, v, v1);
            return;
        }
        PlatformDependent.setMemory(arr_b, v, ((long)v1), 0);
    }

    private static int zeroTillAligned(long v, int v1) {
        int v2 = Math.min(((int)(v % 8L)), v1);
        for(int v3 = 0; v3 < v2; ++v3) {
            PlatformDependent.putByte(((long)v3) + v, 0);
        }
        return v2;
    }
}

