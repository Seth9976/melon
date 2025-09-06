package io.netty.buffer;

import androidx.appcompat.app.o;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.Recycler.EnhancedHandle;
import io.netty.util.ResourceLeakDetector.LeakListener;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

public final class ByteBufUtil {
    static final class HexUtil {
        private static final char[] BYTE2CHAR;
        private static final String[] BYTE2HEX;
        private static final String[] BYTEPADDING;
        private static final String[] HEXDUMP_ROWPREFIXES;
        private static final char[] HEXDUMP_TABLE;
        private static final String[] HEXPADDING;

        static {
            HexUtil.BYTE2CHAR = new char[0x100];
            HexUtil.HEXDUMP_TABLE = new char[0x400];
            HexUtil.HEXPADDING = new String[16];
            HexUtil.HEXDUMP_ROWPREFIXES = new String[0x1000];
            HexUtil.BYTE2HEX = new String[0x100];
            HexUtil.BYTEPADDING = new String[16];
            char[] arr_c = "0123456789abcdef".toCharArray();
            for(int v1 = 0; v1 < 0x100; ++v1) {
                HexUtil.HEXDUMP_TABLE[v1 << 1] = arr_c[v1 >>> 4 & 15];
                HexUtil.HEXDUMP_TABLE[(v1 << 1) + 1] = arr_c[v1 & 15];
            }
            for(int v2 = 0; true; ++v2) {
                String[] arr_s = HexUtil.HEXPADDING;
                if(v2 >= arr_s.length) {
                    break;
                }
                int v3 = arr_s.length - v2;
                StringBuilder stringBuilder0 = new StringBuilder(v3 * 3);
                for(int v4 = 0; v4 < v3; ++v4) {
                    stringBuilder0.append("   ");
                }
                HexUtil.HEXPADDING[v2] = stringBuilder0.toString();
            }
            for(int v5 = 0; true; ++v5) {
                String[] arr_s1 = HexUtil.HEXDUMP_ROWPREFIXES;
                if(v5 >= arr_s1.length) {
                    break;
                }
                StringBuilder stringBuilder1 = new StringBuilder(12);
                stringBuilder1.append("\n");
                stringBuilder1.append(Long.toHexString(((long)(v5 << 4)) & 0xFFFFFFFFL | 0x100000000L));
                stringBuilder1.setCharAt(stringBuilder1.length() - 9, '|');
                stringBuilder1.append('|');
                arr_s1[v5] = stringBuilder1.toString();
            }
            for(int v6 = 0; true; ++v6) {
                String[] arr_s2 = HexUtil.BYTE2HEX;
                if(v6 >= arr_s2.length) {
                    break;
                }
                arr_s2[v6] = " " + StringUtil.byteToHexStringPadded(v6);
            }
            for(int v7 = 0; true; ++v7) {
                String[] arr_s3 = HexUtil.BYTEPADDING;
                if(v7 >= arr_s3.length) {
                    break;
                }
                int v8 = arr_s3.length - v7;
                StringBuilder stringBuilder2 = new StringBuilder(v8);
                for(int v9 = 0; v9 < v8; ++v9) {
                    stringBuilder2.append(' ');
                }
                HexUtil.BYTEPADDING[v7] = stringBuilder2.toString();
            }
            for(int v = 0; true; ++v) {
                char[] arr_c1 = HexUtil.BYTE2CHAR;
                if(v >= arr_c1.length) {
                    break;
                }
                arr_c1[v] = v <= 0x1F || v >= 0x7F ? '.' : ((char)v);
            }
        }

        public static String access$000(ByteBuf byteBuf0, int v, int v1) {
            return HexUtil.hexDump(byteBuf0, v, v1);
        }

        public static String access$100(byte[] arr_b, int v, int v1) {
            return HexUtil.hexDump(arr_b, v, v1);
        }

        public static String access$400(ByteBuf byteBuf0, int v, int v1) {
            return HexUtil.prettyHexDump(byteBuf0, v, v1);
        }

        public static void access$500(StringBuilder stringBuilder0, ByteBuf byteBuf0, int v, int v1) {
            HexUtil.appendPrettyHexDump(stringBuilder0, byteBuf0, v, v1);
        }

        private static void appendHexDumpRowPrefix(StringBuilder stringBuilder0, int v, int v1) {
            String[] arr_s = HexUtil.HEXDUMP_ROWPREFIXES;
            if(v < arr_s.length) {
                stringBuilder0.append(arr_s[v]);
                return;
            }
            stringBuilder0.append("\n");
            stringBuilder0.append(Long.toHexString(((long)v1) & 0xFFFFFFFFL | 0x100000000L));
            stringBuilder0.setCharAt(stringBuilder0.length() - 9, '|');
            stringBuilder0.append('|');
        }

        private static void appendPrettyHexDump(StringBuilder stringBuilder0, ByteBuf byteBuf0, int v, int v1) {
            if(!MathUtil.isOutOfBounds(v, v1, byteBuf0.capacity())) {
                if(v1 == 0) {
                    return;
                }
                stringBuilder0.append("         +-------------------------------------------------+\n         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |\n+--------+-------------------------------------------------+----------------+");
                for(int v2 = 0; v2 < v1 >>> 4; ++v2) {
                    int v3 = (v2 << 4) + v;
                    HexUtil.appendHexDumpRowPrefix(stringBuilder0, v2, v3);
                    int v4 = v3 + 16;
                    for(int v5 = v3; v5 < v4; ++v5) {
                        stringBuilder0.append(HexUtil.BYTE2HEX[byteBuf0.getUnsignedByte(v5)]);
                    }
                    stringBuilder0.append(" |");
                    while(v3 < v4) {
                        stringBuilder0.append(HexUtil.BYTE2CHAR[byteBuf0.getUnsignedByte(v3)]);
                        ++v3;
                    }
                    stringBuilder0.append('|');
                }
                if((v1 & 15) != 0) {
                    int v6 = (v1 >>> 4 << 4) + v;
                    HexUtil.appendHexDumpRowPrefix(stringBuilder0, v1 >>> 4, v6);
                    int v7 = v + v1;
                    for(int v8 = v6; v8 < v7; ++v8) {
                        stringBuilder0.append(HexUtil.BYTE2HEX[byteBuf0.getUnsignedByte(v8)]);
                    }
                    stringBuilder0.append(HexUtil.HEXPADDING[v1 & 15]);
                    stringBuilder0.append(" |");
                    while(v6 < v7) {
                        stringBuilder0.append(HexUtil.BYTE2CHAR[byteBuf0.getUnsignedByte(v6)]);
                        ++v6;
                    }
                    stringBuilder0.append(HexUtil.BYTEPADDING[v1 & 15]);
                    stringBuilder0.append('|');
                }
                stringBuilder0.append("\n+--------+-------------------------------------------------+----------------+");
                return;
            }
            StringBuilder stringBuilder1 = o.t(v, v1, "expected: 0 <= offset(", ") <= offset + length(", ") <= buf.capacity(");
            stringBuilder1.append(byteBuf0.capacity());
            stringBuilder1.append(')');
            throw new IndexOutOfBoundsException(stringBuilder1.toString());
        }

        private static String hexDump(ByteBuf byteBuf0, int v, int v1) {
            ObjectUtil.checkPositiveOrZero(v1, "length");
            if(v1 == 0) {
                return "";
            }
            int v2 = v + v1;
            char[] arr_c = new char[v1 << 1];
            for(int v3 = 0; v < v2; v3 += 2) {
                int v4 = byteBuf0.getUnsignedByte(v);
                System.arraycopy(HexUtil.HEXDUMP_TABLE, v4 << 1, arr_c, v3, 2);
                ++v;
            }
            return new String(arr_c);
        }

        private static String hexDump(byte[] arr_b, int v, int v1) {
            ObjectUtil.checkPositiveOrZero(v1, "length");
            if(v1 == 0) {
                return "";
            }
            int v2 = v + v1;
            char[] arr_c = new char[v1 << 1];
            for(int v3 = 0; v < v2; v3 += 2) {
                System.arraycopy(HexUtil.HEXDUMP_TABLE, (arr_b[v] & 0xFF) << 1, arr_c, v3, 2);
                ++v;
            }
            return new String(arr_c);
        }

        private static String prettyHexDump(ByteBuf byteBuf0, int v, int v1) {
            if(v1 == 0) {
                return "";
            }
            StringBuilder stringBuilder0 = new StringBuilder((v1 / 16 + ((v1 & 15) == 0 ? 0 : 1) + 4) * 80);
            HexUtil.appendPrettyHexDump(stringBuilder0, byteBuf0, v, v1);
            return stringBuilder0.toString();
        }
    }

    static final class SWARByteSearch {
        public static long access$200(byte b) {
            return (((long)b) & 0xFFL) * 0x101010101010101L;
        }

        public static int access$300(long v, long v1, boolean z) {
            return SWARByteSearch.firstAnyPattern(v, v1, z);
        }

        private static long compilePattern(byte b) [...] // Inlined contents

        private static int firstAnyPattern(long v, long v1, boolean z) {
            long v2 = ~(v ^ v1 | ((v ^ v1) & 0x7F7F7F7F7F7F7F7FL) + 0x7F7F7F7F7F7F7F7FL | 0x7F7F7F7F7F7F7F7FL);
            return z ? Long.numberOfLeadingZeros(v2) >>> 3 : Long.numberOfTrailingZeros(v2) >>> 3;
        }
    }

    static final class ThreadLocalDirectByteBuf extends UnpooledDirectByteBuf {
        private static final ObjectPool RECYCLER;
        private final EnhancedHandle handle;

        static {
            ThreadLocalDirectByteBuf.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
                public ThreadLocalDirectByteBuf newObject(Handle objectPool$Handle0) {
                    return new ThreadLocalDirectByteBuf(objectPool$Handle0, null);
                }

                @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
                public Object newObject(Handle objectPool$Handle0) {
                    return this.newObject(objectPool$Handle0);
                }
            });
        }

        private ThreadLocalDirectByteBuf(Handle objectPool$Handle0) {
            super(UnpooledByteBufAllocator.DEFAULT, 0x100, 0x7FFFFFFF);
            this.handle = (EnhancedHandle)objectPool$Handle0;
        }

        public ThreadLocalDirectByteBuf(Handle objectPool$Handle0, io.netty.buffer.ByteBufUtil.1 byteBufUtil$10) {
            this(objectPool$Handle0);
        }

        @Override  // io.netty.buffer.UnpooledDirectByteBuf
        public void deallocate() {
            if(this.capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
                return;
            }
            this.clear();
            this.handle.unguardedRecycle(this);
        }

        public static ThreadLocalDirectByteBuf newInstance() {
            ThreadLocalDirectByteBuf byteBufUtil$ThreadLocalDirectByteBuf0 = (ThreadLocalDirectByteBuf)ThreadLocalDirectByteBuf.RECYCLER.get();
            byteBufUtil$ThreadLocalDirectByteBuf0.resetRefCnt();
            return byteBufUtil$ThreadLocalDirectByteBuf0;
        }
    }

    static final class ThreadLocalUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        private static final ObjectPool RECYCLER;
        private final EnhancedHandle handle;

        static {
            ThreadLocalUnsafeDirectByteBuf.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
                public ThreadLocalUnsafeDirectByteBuf newObject(Handle objectPool$Handle0) {
                    return new ThreadLocalUnsafeDirectByteBuf(objectPool$Handle0, null);
                }

                @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
                public Object newObject(Handle objectPool$Handle0) {
                    return this.newObject(objectPool$Handle0);
                }
            });
        }

        private ThreadLocalUnsafeDirectByteBuf(Handle objectPool$Handle0) {
            super(UnpooledByteBufAllocator.DEFAULT, 0x100, 0x7FFFFFFF);
            this.handle = (EnhancedHandle)objectPool$Handle0;
        }

        public ThreadLocalUnsafeDirectByteBuf(Handle objectPool$Handle0, io.netty.buffer.ByteBufUtil.1 byteBufUtil$10) {
            this(objectPool$Handle0);
        }

        @Override  // io.netty.buffer.UnpooledDirectByteBuf
        public void deallocate() {
            if(this.capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
                return;
            }
            this.clear();
            this.handle.unguardedRecycle(this);
        }

        public static ThreadLocalUnsafeDirectByteBuf newInstance() {
            ThreadLocalUnsafeDirectByteBuf byteBufUtil$ThreadLocalUnsafeDirectByteBuf0 = (ThreadLocalUnsafeDirectByteBuf)ThreadLocalUnsafeDirectByteBuf.RECYCLER.get();
            byteBufUtil$ThreadLocalUnsafeDirectByteBuf0.resetRefCnt();
            return byteBufUtil$ThreadLocalUnsafeDirectByteBuf0;
        }
    }

    static final boolean $assertionsDisabled = false;
    private static final FastThreadLocal BYTE_ARRAYS = null;
    static final ByteBufAllocator DEFAULT_ALLOCATOR = null;
    private static final ByteProcessor FIND_NON_ASCII = null;
    private static final int MAX_BYTES_PER_CHAR_UTF8 = 0;
    private static final int MAX_CHAR_BUFFER_SIZE = 0;
    static final int MAX_TL_ARRAY_LEN = 0x400;
    private static final int THREAD_LOCAL_BUFFER_SIZE = 0;
    static final int WRITE_CHUNK_SIZE = 0x2000;
    private static final byte WRITE_UTF_UNKNOWN = 0x3F;
    private static final InternalLogger logger;

    static {
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(ByteBufUtil.class);
        ByteBufUtil.logger = internalLogger0;
        ByteBufUtil.BYTE_ARRAYS = new FastThreadLocal() {
            @Override  // io.netty.util.concurrent.FastThreadLocal
            public Object initialValue() {
                return this.initialValue();
            }

            public byte[] initialValue() {
                return PlatformDependent.allocateUninitializedArray(0x400);
            }
        };
        ByteBufUtil.MAX_BYTES_PER_CHAR_UTF8 = (int)CharsetUtil.encoder(CharsetUtil.UTF_8).maxBytesPerChar();
        internalLogger0.debug("-Dio.netty.allocator.type: {}", "pooled");
        ByteBufUtil.DEFAULT_ALLOCATOR = PooledByteBufAllocator.DEFAULT;
        int v = SystemPropertyUtil.getInt("io.netty.threadLocalDirectBufferSize", 0);
        ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE = v;
        internalLogger0.debug("-Dio.netty.threadLocalDirectBufferSize: {}", v);
        int v1 = SystemPropertyUtil.getInt("io.netty.maxThreadLocalCharBufferSize", 0x4000);
        ByteBufUtil.MAX_CHAR_BUFFER_SIZE = v1;
        internalLogger0.debug("-Dio.netty.maxThreadLocalCharBufferSize: {}", v1);
        ByteBufUtil.FIND_NON_ASCII = new ByteProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b >= 0;
            }
        };
    }

    public static void appendPrettyHexDump(StringBuilder stringBuilder0, ByteBuf byteBuf0) {
        ByteBufUtil.appendPrettyHexDump(stringBuilder0, byteBuf0, byteBuf0.readerIndex(), byteBuf0.readableBytes());
    }

    public static void appendPrettyHexDump(StringBuilder stringBuilder0, ByteBuf byteBuf0, int v, int v1) {
        HexUtil.access$500(stringBuilder0, byteBuf0, v, v1);
    }

    private static CharSequence checkCharSequenceBounds(CharSequence charSequence0, int v, int v1) {
        if(!MathUtil.isOutOfBounds(v, v1 - v, charSequence0.length())) {
            return charSequence0;
        }
        StringBuilder stringBuilder0 = o.t(v, v1, "expected: 0 <= start(", ") <= end (", ") <= seq.length(");
        stringBuilder0.append(charSequence0.length());
        stringBuilder0.append(')');
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public static int compare(ByteBuf byteBuf0, ByteBuf byteBuf1) {
        long v6;
        boolean z = false;
        if(byteBuf0 == byteBuf1) {
            return 0;
        }
        int v = byteBuf0.readableBytes();
        int v1 = byteBuf1.readableBytes();
        int v2 = Math.min(v, v1);
        int v3 = byteBuf0.readerIndex();
        int v4 = byteBuf1.readerIndex();
        if(v2 >>> 2 > 0) {
            if(byteBuf0.order() == ByteOrder.BIG_ENDIAN) {
                z = true;
            }
            int v5 = v2 >>> 2 << 2;
            if(byteBuf0.order() != byteBuf1.order()) {
                v6 = z ? ByteBufUtil.compareUintBigEndianA(byteBuf0, byteBuf1, v3, v4, v5) : ByteBufUtil.compareUintBigEndianB(byteBuf0, byteBuf1, v3, v4, v5);
            }
            else if(z) {
                v6 = ByteBufUtil.compareUintBigEndian(byteBuf0, byteBuf1, v3, v4, v5);
            }
            else {
                v6 = ByteBufUtil.compareUintLittleEndian(byteBuf0, byteBuf1, v3, v4, v5);
            }
            if(v6 != 0L) {
                return (int)Math.min(0x7FFFFFFFL, Math.max(0xFFFFFFFF80000000L, v6));
            }
            v3 += v5;
            v4 += v5;
        }
        int v7 = (v2 & 3) + v3;
        while(v3 < v7) {
            int v8 = byteBuf0.getUnsignedByte(v3) - byteBuf1.getUnsignedByte(v4);
            if(v8 != 0) {
                return v8;
            }
            ++v3;
            ++v4;
        }
        return v - v1;
    }

    private static long compareUintBigEndian(ByteBuf byteBuf0, ByteBuf byteBuf1, int v, int v1, int v2) {
        int v3 = v2 + v;
        while(v < v3) {
            long v4 = byteBuf0.getUnsignedInt(v) - byteBuf1.getUnsignedInt(v1);
            if(v4 != 0L) {
                return v4;
            }
            v += 4;
            v1 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianA(ByteBuf byteBuf0, ByteBuf byteBuf1, int v, int v1, int v2) {
        int v3 = v2 + v;
        while(v < v3) {
            long v4 = byteBuf0.getUnsignedInt(v) - ByteBufUtil.uintFromLE(byteBuf1.getUnsignedIntLE(v1));
            if(v4 != 0L) {
                return v4;
            }
            v += 4;
            v1 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianB(ByteBuf byteBuf0, ByteBuf byteBuf1, int v, int v1, int v2) {
        int v3 = v2 + v;
        while(v < v3) {
            long v4 = ByteBufUtil.uintFromLE(byteBuf0.getUnsignedIntLE(v)) - byteBuf1.getUnsignedInt(v1);
            if(v4 != 0L) {
                return v4;
            }
            v += 4;
            v1 += 4;
        }
        return 0L;
    }

    private static long compareUintLittleEndian(ByteBuf byteBuf0, ByteBuf byteBuf1, int v, int v1, int v2) {
        int v3 = v2 + v;
        while(v < v3) {
            long v4 = ByteBufUtil.uintFromLE(byteBuf0.getUnsignedIntLE(v)) - ByteBufUtil.uintFromLE(byteBuf1.getUnsignedIntLE(v1));
            if(v4 != 0L) {
                return v4;
            }
            v += 4;
            v1 += 4;
        }
        return 0L;
    }

    public static void copy(AsciiString asciiString0, int v, ByteBuf byteBuf0, int v1) {
        if(!MathUtil.isOutOfBounds(v, v1, asciiString0.length())) {
            ((ByteBuf)ObjectUtil.checkNotNull(byteBuf0, "dst")).writeBytes(asciiString0.array(), asciiString0.arrayOffset() + v, v1);
            return;
        }
        StringBuilder stringBuilder0 = o.t(v, v1, "expected: 0 <= srcIdx(", ") <= srcIdx + length(", ") <= srcLen(");
        stringBuilder0.append(asciiString0.length());
        stringBuilder0.append(')');
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public static void copy(AsciiString asciiString0, int v, ByteBuf byteBuf0, int v1, int v2) {
        if(!MathUtil.isOutOfBounds(v, v2, asciiString0.length())) {
            ((ByteBuf)ObjectUtil.checkNotNull(byteBuf0, "dst")).setBytes(v1, asciiString0.array(), asciiString0.arrayOffset() + v, v2);
            return;
        }
        StringBuilder stringBuilder0 = o.t(v, v2, "expected: 0 <= srcIdx(", ") <= srcIdx + length(", ") <= srcLen(");
        stringBuilder0.append(asciiString0.length());
        stringBuilder0.append(')');
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public static void copy(AsciiString asciiString0, ByteBuf byteBuf0) {
        ByteBufUtil.copy(asciiString0, 0, byteBuf0, asciiString0.length());
    }

    public static byte decodeHexByte(CharSequence charSequence0, int v) {
        return StringUtil.decodeHexByte(charSequence0, v);
    }

    public static byte[] decodeHexDump(CharSequence charSequence0) {
        return StringUtil.decodeHexDump(charSequence0, 0, charSequence0.length());
    }

    public static byte[] decodeHexDump(CharSequence charSequence0, int v, int v1) {
        return StringUtil.decodeHexDump(charSequence0, v, v1);
    }

    public static String decodeString(ByteBuf byteBuf0, int v, int v1, Charset charset0) {
        byte[] arr_b;
        if(v1 == 0) {
            return "";
        }
        if(byteBuf0.hasArray()) {
            arr_b = byteBuf0.array();
            int v2 = byteBuf0.arrayOffset() + v;
            return CharsetUtil.US_ASCII.equals(charset0) ? new String(arr_b, 0, v2, v1) : new String(arr_b, v2, v1, charset0);
        }
        arr_b = ByteBufUtil.threadLocalTempArray(v1);
        byteBuf0.getBytes(v, arr_b, 0, v1);
        return CharsetUtil.US_ASCII.equals(charset0) ? new String(arr_b, 0, 0, v1) : new String(arr_b, 0, v1, charset0);
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator0, CharBuffer charBuffer0, Charset charset0) {
        return ByteBufUtil.encodeString0(byteBufAllocator0, false, charBuffer0, charset0, 0);
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator0, CharBuffer charBuffer0, Charset charset0, int v) {
        return ByteBufUtil.encodeString0(byteBufAllocator0, false, charBuffer0, charset0, v);
    }

    public static ByteBuf encodeString0(ByteBufAllocator byteBufAllocator0, boolean z, CharBuffer charBuffer0, Charset charset0, int v) {
        CharsetEncoder charsetEncoder0 = CharsetUtil.encoder(charset0);
        int v1 = ((int)(((double)charBuffer0.remaining()) * ((double)charsetEncoder0.maxBytesPerChar()))) + v;
        ByteBuf byteBuf0 = z ? byteBufAllocator0.heapBuffer(v1) : byteBufAllocator0.buffer(v1);
        try {
            try {
                ByteBuffer byteBuffer0 = byteBuf0.internalNioBuffer(byteBuf0.readerIndex(), v1);
                int v2 = byteBuffer0.position();
                CoderResult coderResult0 = charsetEncoder0.encode(charBuffer0, byteBuffer0, true);
                if(!coderResult0.isUnderflow()) {
                    coderResult0.throwException();
                }
                CoderResult coderResult1 = charsetEncoder0.flush(byteBuffer0);
                if(!coderResult1.isUnderflow()) {
                    coderResult1.throwException();
                }
                byteBuf0.writerIndex(byteBuf0.writerIndex() + byteBuffer0.position() - v2);
                return byteBuf0;
            }
            catch(CharacterCodingException characterCodingException0) {
            }
            throw new IllegalStateException(characterCodingException0);
        }
        catch(Throwable throwable0) {
        }
        byteBuf0.release();
        throw throwable0;
    }

    public static ByteBuf ensureAccessible(ByteBuf byteBuf0) {
        if(!byteBuf0.isAccessible()) {
            throw new IllegalReferenceCountException(byteBuf0.refCnt());
        }
        return byteBuf0;
    }

    public static boolean ensureWritableSuccess(int v) {
        return v == 0 || v == 2;
    }

    public static boolean equals(ByteBuf byteBuf0, int v, ByteBuf byteBuf1, int v1, int v2) {
        ObjectUtil.checkNotNull(byteBuf0, "a");
        ObjectUtil.checkNotNull(byteBuf1, "b");
        ObjectUtil.checkPositiveOrZero(v, "aStartIndex");
        ObjectUtil.checkPositiveOrZero(v1, "bStartIndex");
        ObjectUtil.checkPositiveOrZero(v2, "length");
        if(byteBuf0.writerIndex() - v2 >= v && byteBuf1.writerIndex() - v2 >= v1) {
            int v3 = v2 >>> 3;
            int v4 = v2 & 7;
            if(byteBuf0.order() == byteBuf1.order()) {
                while(v3 > 0) {
                    if(byteBuf0.getLong(v) != byteBuf1.getLong(v1)) {
                        return false;
                    }
                    v += 8;
                    v1 += 8;
                    --v3;
                }
            }
            else {
                while(v3 > 0) {
                    if(byteBuf0.getLong(v) != ByteBufUtil.swapLong(byteBuf1.getLong(v1))) {
                        return false;
                    }
                    v += 8;
                    v1 += 8;
                    --v3;
                }
            }
            while(v4 > 0) {
                if(byteBuf0.getByte(v) != byteBuf1.getByte(v1)) {
                    return false;
                }
                ++v;
                ++v1;
                --v4;
            }
            return true;
        }
        return false;
    }

    public static boolean equals(ByteBuf byteBuf0, ByteBuf byteBuf1) {
        if(byteBuf0 == byteBuf1) {
            return true;
        }
        int v = byteBuf0.readableBytes();
        return v == byteBuf1.readableBytes() ? ByteBufUtil.equals(byteBuf0, byteBuf0.readerIndex(), byteBuf1, byteBuf1.readerIndex(), v) : false;
    }

    public static int firstIndexOf(AbstractByteBuf abstractByteBuf0, int v, int v1, byte b) {
        int v2 = Math.max(v, 0);
        if(v2 < v1 && abstractByteBuf0.capacity() != 0) {
            abstractByteBuf0.checkIndex(v2, v1 - v2);
            return ByteBufUtil.linearFirstIndexOf(abstractByteBuf0, v2, v1, b);
        }
        return -1;
    }

    private static void getBytes(ByteBuffer byteBuffer0, byte[] arr_b, int v, int v1, OutputStream outputStream0, int v2) {
        do {
            int v3 = Math.min(v1, v2);
            byteBuffer0.get(arr_b, v, v3);
            outputStream0.write(arr_b, v, v3);
            v2 -= v3;
        }
        while(v2 > 0);
    }

    public static byte[] getBytes(ByteBuf byteBuf0) {
        return ByteBufUtil.getBytes(byteBuf0, byteBuf0.readerIndex(), byteBuf0.readableBytes());
    }

    public static byte[] getBytes(ByteBuf byteBuf0, int v, int v1) {
        return ByteBufUtil.getBytes(byteBuf0, v, v1, true);
    }

    public static byte[] getBytes(ByteBuf byteBuf0, int v, int v1, boolean z) {
        int v2 = byteBuf0.capacity();
        if(MathUtil.isOutOfBounds(v, v1, v2)) {
            throw new IndexOutOfBoundsException(o.q(o.t(v, v1, "expected: 0 <= start(", ") <= start + length(", ") <= buf.capacity("), v2, ')'));
        }
        if(byteBuf0.hasArray()) {
            int v3 = byteBuf0.arrayOffset() + v;
            byte[] arr_b = byteBuf0.array();
            return z || v3 != 0 || v1 != arr_b.length ? Arrays.copyOfRange(arr_b, v3, v1 + v3) : arr_b;
        }
        byte[] arr_b1 = PlatformDependent.allocateUninitializedArray(v1);
        byteBuf0.getBytes(v, arr_b1);
        return arr_b1;
    }

    public static int hashCode(ByteBuf byteBuf0) {
        int v4;
        int v = byteBuf0.readableBytes();
        int v1 = v >>> 2;
        int v2 = v & 3;
        int v3 = byteBuf0.readerIndex();
        if(byteBuf0.order() == ByteOrder.BIG_ENDIAN) {
            v4 = 1;
            while(v1 > 0) {
                v4 = v4 * 0x1F + byteBuf0.getInt(v3);
                v3 += 4;
                --v1;
            }
        }
        else {
            v4 = 1;
            while(v1 > 0) {
                v4 = v4 * 0x1F + ByteBufUtil.swapInt(byteBuf0.getInt(v3));
                v3 += 4;
                --v1;
            }
        }
        while(v2 > 0) {
            v4 = v4 * 0x1F + byteBuf0.getByte(v3);
            --v2;
            ++v3;
        }
        return v4 == 0 ? 1 : v4;
    }

    public static String hexDump(ByteBuf byteBuf0) {
        return ByteBufUtil.hexDump(byteBuf0, byteBuf0.readerIndex(), byteBuf0.readableBytes());
    }

    public static String hexDump(ByteBuf byteBuf0, int v, int v1) {
        return HexUtil.access$000(byteBuf0, v, v1);
    }

    public static String hexDump(byte[] arr_b) {
        return ByteBufUtil.hexDump(arr_b, 0, arr_b.length);
    }

    public static String hexDump(byte[] arr_b, int v, int v1) {
        return HexUtil.access$100(arr_b, v, v1);
    }

    public static int indexOf(ByteBuf byteBuf0, int v, int v1, byte b) {
        return byteBuf0.indexOf(v, v1, b);
    }

    public static int indexOf(ByteBuf byteBuf0, ByteBuf byteBuf1) {
        if(byteBuf1 == null || byteBuf0 == null || byteBuf0.readableBytes() > byteBuf1.readableBytes()) {
            return -1;
        }
        int v = byteBuf1.readableBytes();
        int v1 = byteBuf0.readableBytes();
        if(v1 == 0) {
            return 0;
        }
        if(v1 == 1) {
            return byteBuf1.indexOf(byteBuf1.readerIndex(), byteBuf1.writerIndex(), byteBuf0.getByte(byteBuf0.readerIndex()));
        }
        int v2 = byteBuf0.readerIndex();
        int v3 = byteBuf1.readerIndex();
        long v4 = ByteBufUtil.maxSuf(byteBuf0, v1, v2, true);
        long v5 = ByteBufUtil.maxSuf(byteBuf0, v1, v2, false);
        int v6 = Math.max(((int)(v4 >> 0x20)), ((int)(v5 >> 0x20)));
        int v7 = Math.max(((int)v4), ((int)v5));
        int v8 = v1 - v7;
        if(ByteBufUtil.equals(byteBuf0, v2, byteBuf0, v2 + v7, Math.min(v8, v6 + 1))) {
            int v9 = -1;
            int v10 = 0;
            while(v10 <= v - v1) {
                int v11;
                for(v11 = Math.max(v6, v9) + 1; v11 < v1 && byteBuf0.getByte(v11 + v2) == byteBuf1.getByte(v11 + v10 + v3); ++v11) {
                }
                if(v11 > v) {
                    return -1;
                }
                if(v11 >= v1) {
                    int v12;
                    for(v12 = v6; v12 > v9 && byteBuf0.getByte(v12 + v2) == byteBuf1.getByte(v12 + v10 + v3); --v12) {
                    }
                    if(v12 <= v9) {
                        return v10 + v3;
                    }
                    v10 += v7;
                    v9 = v8 - 1;
                }
                else {
                    v10 += v11 - v6;
                    v9 = -1;
                }
            }
            return -1;
        }
        int v13 = Math.max(v6 + 1, v1 - v6 - 1);
        int v14 = 0;
        while(v14 <= v - v1) {
            int v15;
            for(v15 = v6 + 1; v15 < v1 && byteBuf0.getByte(v15 + v2) == byteBuf1.getByte(v15 + v14 + v3); ++v15) {
            }
            if(v15 > v) {
                return -1;
            }
            if(v15 >= v1) {
                int v16;
                for(v16 = v6; v16 >= 0 && byteBuf0.getByte(v16 + v2) == byteBuf1.getByte(v16 + v14 + v3); --v16) {
                }
                if(v16 < 0) {
                    return v14 + v3;
                }
                v14 += v13 + 1;
            }
            else {
                v14 += v15 - v6;
            }
        }
        return -1;
    }

    public static boolean isAccessible(ByteBuf byteBuf0) {
        return byteBuf0.isAccessible();
    }

    private static boolean isAscii(ByteBuf byteBuf0, int v, int v1) {
        return byteBuf0.forEachByte(v, v1, ByteBufUtil.FIND_NON_ASCII) == -1;
    }

    public static boolean isText(ByteBuf byteBuf0, int v, int v1, Charset charset0) {
        ObjectUtil.checkNotNull(byteBuf0, "buf");
        ObjectUtil.checkNotNull(charset0, "charset");
        int v2 = byteBuf0.readerIndex();
        if(v >= 0 && v1 >= 0 && v <= byteBuf0.readableBytes() + v2 - v1) {
            if(charset0.equals(CharsetUtil.UTF_8)) {
                return ByteBufUtil.isUtf8(byteBuf0, v, v1);
            }
            if(charset0.equals(CharsetUtil.US_ASCII)) {
                return ByteBufUtil.isAscii(byteBuf0, v, v1);
            }
            CharsetDecoder charsetDecoder0 = CharsetUtil.decoder(charset0, CodingErrorAction.REPORT, CodingErrorAction.REPORT);
            try {
                if(byteBuf0.nioBufferCount() == 1) {
                    charsetDecoder0.decode(byteBuf0.nioBuffer(v, v1));
                    return true;
                }
                ByteBuf byteBuf1 = byteBuf0.alloc().heapBuffer(v1);
                try {
                    byteBuf1.writeBytes(byteBuf0, v, v1);
                    charsetDecoder0.decode(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v1));
                    return true;
                }
                finally {
                    byteBuf1.release();
                }
            }
            catch(CharacterCodingException unused_ex) {
                return false;
            }
        }
        throw new IndexOutOfBoundsException("index: " + v + " length: " + v1);
    }

    public static boolean isText(ByteBuf byteBuf0, Charset charset0) {
        return ByteBufUtil.isText(byteBuf0, byteBuf0.readerIndex(), byteBuf0.readableBytes(), charset0);
    }

    private static boolean isUtf8(ByteBuf byteBuf0, int v, int v1) {
        int v2 = v1 + v;
        while(v < v2) {
            int v3 = v + 1;
            int v4 = byteBuf0.getByte(v);
            if((v4 & 0x80) == 0) {
                v = v3;
            }
            else {
                if((v4 & 0xE0) == 0xC0) {
                    if(v3 >= v2) {
                        return false;
                    }
                    v += 2;
                    if((byteBuf0.getByte(v3) & 0xC0) != 0x80) {
                        return false;
                    }
                    if((v4 & 0xFF) >= 0xC2) {
                        continue;
                    }
                    return false;
                }
                if((v4 & 0xF0) == 0xE0) {
                    if(v3 > v2 - 2) {
                        return false;
                    }
                    int v5 = v + 2;
                    int v6 = byteBuf0.getByte(v3);
                    v += 3;
                    if((v6 & 0xC0) != 0x80 || (byteBuf0.getByte(v5) & 0xC0) != 0x80 || (v4 & 15) == 0 && (v6 & 0xFF) < 0xA0) {
                        return false;
                    }
                    if((v4 & 15) != 13 || (v6 & 0xFF) <= 0x9F) {
                        continue;
                    }
                    return false;
                }
                if((v4 & 0xF8) != 0xF0 || v3 > v2 - 3) {
                    return false;
                }
                int v7 = byteBuf0.getByte(v3);
                int v8 = v + 3;
                int v9 = byteBuf0.getByte(v + 2);
                v += 4;
                if((v7 & 0xC0) != 0x80 || (v9 & 0xC0) != 0x80 || (byteBuf0.getByte(v8) & 0xC0) != 0x80 || (v4 & 0xFF) > 0xF4 || (v4 & 0xFF) == 0xF0 && (v7 & 0xFF) < 0x90 || (v4 & 0xFF) == 0xF4 && (v7 & 0xFF) > 0x8F) {
                    return false;
                }
                if(false) {
                    break;
                }
            }
        }
        return true;
    }

    public static int lastIndexOf(AbstractByteBuf abstractByteBuf0, int v, int v1, byte b) {
        int v2 = abstractByteBuf0.capacity();
        int v3 = Math.min(v, v2);
        if(v3 >= 0 && v2 != 0) {
            abstractByteBuf0.checkIndex(v1, v3 - v1);
            for(int v4 = v3 - 1; v4 >= v1; --v4) {
                if(abstractByteBuf0._getByte(v4) == b) {
                    return v4;
                }
            }
        }
        return -1;
    }

    private static int linearFirstIndexOf(AbstractByteBuf abstractByteBuf0, int v, int v1, byte b) {
        while(v < v1) {
            if(abstractByteBuf0._getByte(v) == b) {
                return v;
            }
            ++v;
        }
        return -1;
    }

    private static long maxSuf(ByteBuf byteBuf0, int v, int v1, boolean z) {
        int v4;
        int v2 = -1;
    alab1:
        while(true) {
            int v3 = 1;
            v4 = 1;
            while(true) {
                int v5 = v1 + v3;
                if(v5 >= v) {
                    break alab1;
                }
                int v6 = byteBuf0.getByte(v5);
                int v7 = byteBuf0.getByte(v2 + v3);
                if(!z) {
                    if(v6 > v7) {
                        v4 = v5 - v2;
                        v3 = 1;
                        v1 = v5;
                        continue;
                    }
                }
                else if(v6 < v7) {
                    v4 = v5 - v2;
                    v3 = 1;
                    v1 = v5;
                    continue;
                }
                if(v6 != v7) {
                    v2 = v1;
                    ++v1;
                    break;
                }
                if(v3 == v4) {
                    v1 += v4;
                    v3 = 1;
                }
                else {
                    ++v3;
                }
            }
        }
        return (((long)v2) << 0x20) + ((long)v4);
    }

    public static String prettyHexDump(ByteBuf byteBuf0) {
        return ByteBufUtil.prettyHexDump(byteBuf0, byteBuf0.readerIndex(), byteBuf0.readableBytes());
    }

    public static String prettyHexDump(ByteBuf byteBuf0, int v, int v1) {
        return HexUtil.access$400(byteBuf0, v, v1);
    }

    public static ByteBuf readBytes(ByteBufAllocator byteBufAllocator0, ByteBuf byteBuf0, int v) {
        ByteBuf byteBuf1 = byteBufAllocator0.buffer(v);
        try {
            byteBuf0.readBytes(byteBuf1);
            return byteBuf1;
        }
        catch(Throwable throwable0) {
            byteBuf1.release();
            throw throwable0;
        }
    }

    public static void readBytes(ByteBufAllocator byteBufAllocator0, ByteBuffer byteBuffer0, int v, int v1, OutputStream outputStream0) {
        if(byteBuffer0.hasArray()) {
            outputStream0.write(byteBuffer0.array(), byteBuffer0.arrayOffset() + v, v1);
            return;
        }
        int v2 = Math.min(v1, 0x2000);
        byteBuffer0.clear().position(v);
        if(v1 <= 0x400 || !byteBufAllocator0.isDirectBufferPooled()) {
            ByteBufUtil.getBytes(byteBuffer0, ByteBufUtil.threadLocalTempArray(v2), 0, v2, outputStream0, v1);
            return;
        }
        ByteBuf byteBuf0 = byteBufAllocator0.heapBuffer(v2);
        try {
            ByteBufUtil.getBytes(byteBuffer0, byteBuf0.array(), byteBuf0.arrayOffset(), v2, outputStream0, v1);
        }
        finally {
            byteBuf0.release();
        }
    }

    public static int readIntBE(ByteBuf byteBuf0) {
        return byteBuf0.order() == ByteOrder.BIG_ENDIAN ? byteBuf0.readInt() : ByteBufUtil.swapInt(byteBuf0.readInt());
    }

    public static int readUnsignedShortBE(ByteBuf byteBuf0) {
        return byteBuf0.order() == ByteOrder.BIG_ENDIAN ? byteBuf0.readUnsignedShort() : ByteBufUtil.swapShort(((short)byteBuf0.readUnsignedShort())) & 0xFFFF;
    }

    public static int reserveAndWriteUtf8(ByteBuf byteBuf0, CharSequence charSequence0, int v) {
        return ByteBufUtil.reserveAndWriteUtf8Seq(byteBuf0, charSequence0, 0, charSequence0.length(), v);
    }

    public static int reserveAndWriteUtf8(ByteBuf byteBuf0, CharSequence charSequence0, int v, int v1, int v2) {
        return ByteBufUtil.reserveAndWriteUtf8Seq(byteBuf0, ByteBufUtil.checkCharSequenceBounds(charSequence0, v, v1), v, v1, v2);
    }

    private static int reserveAndWriteUtf8Seq(ByteBuf byteBuf0, CharSequence charSequence0, int v, int v1, int v2) {
        while(true) {
            if(!(byteBuf0 instanceof WrappedCompositeByteBuf)) {
                if(byteBuf0 instanceof AbstractByteBuf) {
                    ((AbstractByteBuf)byteBuf0).ensureWritable0(v2);
                    int v3 = ByteBufUtil.writeUtf8(((AbstractByteBuf)byteBuf0), ((AbstractByteBuf)byteBuf0).writerIndex, v2, charSequence0, v, v1);
                    ((AbstractByteBuf)byteBuf0).writerIndex += v3;
                    return v3;
                }
                if(!(byteBuf0 instanceof WrappedByteBuf)) {
                    break;
                }
            }
            byteBuf0 = byteBuf0.unwrap();
        }
        byte[] arr_b = charSequence0.subSequence(v, v1).toString().getBytes(CharsetUtil.UTF_8);
        byteBuf0.writeBytes(arr_b);
        return arr_b.length;
    }

    private static int safeArrayWriteUtf8(byte[] arr_b, int v, CharSequence charSequence0, int v1, int v2) {
        int v3 = v;
        while(v1 < v2) {
            int v4 = 0x3F;
            int v5 = charSequence0.charAt(v1);
            if(v5 < 0x80) {
                arr_b[v3] = (byte)v5;
                ++v3;
            }
            else if(v5 < 0x800) {
                int v6 = v3 + 1;
                arr_b[v3] = (byte)(v5 >> 6 | 0xC0);
                v3 += 2;
                arr_b[v6] = (byte)(v5 & 0x3F | 0x80);
            }
            else if(!StringUtil.isSurrogate(((char)v5))) {
                arr_b[v3] = (byte)(v5 >> 12 | 0xE0);
                int v11 = v3 + 2;
                arr_b[v3 + 1] = (byte)(0x3F & v5 >> 6 | 0x80);
                v3 += 3;
                arr_b[v11] = (byte)(v5 & 0x3F | 0x80);
            }
            else if(Character.isHighSurrogate(((char)v5))) {
                ++v1;
                if(v1 == v2) {
                    arr_b[v3] = 0x3F;
                    return v3 + 1 - v;
                }
                int v7 = charSequence0.charAt(v1);
                if(Character.isLowSurrogate(((char)v7))) {
                    int v9 = Character.toCodePoint(((char)v5), ((char)v7));
                    arr_b[v3] = (byte)(v9 >> 18 | 0xF0);
                    arr_b[v3 + 1] = (byte)(v9 >> 12 & 0x3F | 0x80);
                    int v10 = v3 + 3;
                    arr_b[v3 + 2] = (byte)(v9 >> 6 & 0x3F | 0x80);
                    v3 += 4;
                    arr_b[v10] = (byte)(v9 & 0x3F | 0x80);
                }
                else {
                    int v8 = v3 + 1;
                    arr_b[v3] = 0x3F;
                    v3 += 2;
                    if(!Character.isHighSurrogate(((char)v7))) {
                        v4 = v7;
                    }
                    arr_b[v8] = (byte)v4;
                }
            }
            else {
                arr_b[v3] = 0x3F;
                ++v3;
            }
            ++v1;
        }
        return v3 - v;
    }

    private static int safeDirectWriteUtf8(ByteBuffer byteBuffer0, int v, CharSequence charSequence0, int v1, int v2) {
        int v3 = v;
        while(v1 < v2) {
            int v4 = 0x3F;
            int v5 = charSequence0.charAt(v1);
            if(v5 < 0x80) {
                byteBuffer0.put(v3, ((byte)v5));
                ++v3;
            }
            else if(v5 < 0x800) {
                int v6 = v3 + 1;
                byteBuffer0.put(v3, ((byte)(v5 >> 6 | 0xC0)));
                v3 += 2;
                byteBuffer0.put(v6, ((byte)(v5 & 0x3F | 0x80)));
            }
            else if(!StringUtil.isSurrogate(((char)v5))) {
                byteBuffer0.put(v3, ((byte)(v5 >> 12 | 0xE0)));
                int v11 = v3 + 2;
                byteBuffer0.put(v3 + 1, ((byte)(0x3F & v5 >> 6 | 0x80)));
                v3 += 3;
                byteBuffer0.put(v11, ((byte)(v5 & 0x3F | 0x80)));
            }
            else if(Character.isHighSurrogate(((char)v5))) {
                ++v1;
                if(v1 == v2) {
                    byteBuffer0.put(v3, 0x3F);
                    return v3 + 1 - v;
                }
                int v7 = charSequence0.charAt(v1);
                if(Character.isLowSurrogate(((char)v7))) {
                    int v9 = Character.toCodePoint(((char)v5), ((char)v7));
                    byteBuffer0.put(v3, ((byte)(v9 >> 18 | 0xF0)));
                    byteBuffer0.put(v3 + 1, ((byte)(v9 >> 12 & 0x3F | 0x80)));
                    int v10 = v3 + 3;
                    byteBuffer0.put(v3 + 2, ((byte)(v9 >> 6 & 0x3F | 0x80)));
                    v3 += 4;
                    byteBuffer0.put(v10, ((byte)(v9 & 0x3F | 0x80)));
                }
                else {
                    int v8 = v3 + 1;
                    byteBuffer0.put(v3, 0x3F);
                    v3 += 2;
                    if(!Character.isHighSurrogate(((char)v7))) {
                        v4 = (byte)v7;
                    }
                    byteBuffer0.put(v8, ((byte)v4));
                }
            }
            else {
                byteBuffer0.put(v3, 0x3F);
                ++v3;
            }
            ++v1;
        }
        return v3 - v;
    }

    private static int safeWriteUtf8(AbstractByteBuf abstractByteBuf0, int v, CharSequence charSequence0, int v1, int v2) {
        int v3 = v;
        while(v1 < v2) {
            int v4 = 0x3F;
            int v5 = charSequence0.charAt(v1);
            if(v5 < 0x80) {
                abstractByteBuf0._setByte(v3, ((int)(((byte)v5))));
                ++v3;
            }
            else if(v5 < 0x800) {
                int v6 = v3 + 1;
                abstractByteBuf0._setByte(v3, ((int)(((byte)(v5 >> 6 | 0xC0)))));
                v3 += 2;
                abstractByteBuf0._setByte(v6, ((int)(((byte)(v5 & 0x3F | 0x80)))));
            }
            else if(!StringUtil.isSurrogate(((char)v5))) {
                abstractByteBuf0._setByte(v3, ((int)(((byte)(v5 >> 12 | 0xE0)))));
                int v11 = v3 + 2;
                abstractByteBuf0._setByte(v3 + 1, ((int)(((byte)(0x3F & v5 >> 6 | 0x80)))));
                v3 += 3;
                abstractByteBuf0._setByte(v11, ((int)(((byte)(v5 & 0x3F | 0x80)))));
            }
            else if(Character.isHighSurrogate(((char)v5))) {
                ++v1;
                if(v1 == v2) {
                    abstractByteBuf0._setByte(v3, 0x3F);
                    return v3 + 1 - v;
                }
                int v7 = charSequence0.charAt(v1);
                if(Character.isLowSurrogate(((char)v7))) {
                    int v9 = Character.toCodePoint(((char)v5), ((char)v7));
                    abstractByteBuf0._setByte(v3, ((int)(((byte)(v9 >> 18 | 0xF0)))));
                    abstractByteBuf0._setByte(v3 + 1, ((int)(((byte)(v9 >> 12 & 0x3F | 0x80)))));
                    int v10 = v3 + 3;
                    abstractByteBuf0._setByte(v3 + 2, ((int)(((byte)(v9 >> 6 & 0x3F | 0x80)))));
                    v3 += 4;
                    abstractByteBuf0._setByte(v10, ((int)(((byte)(v9 & 0x3F | 0x80)))));
                }
                else {
                    int v8 = v3 + 1;
                    abstractByteBuf0._setByte(v3, 0x3F);
                    v3 += 2;
                    if(!Character.isHighSurrogate(((char)v7))) {
                        v4 = v7;
                    }
                    abstractByteBuf0._setByte(v8, v4);
                }
            }
            else {
                abstractByteBuf0._setByte(v3, 0x3F);
                ++v3;
            }
            ++v1;
        }
        return v3 - v;
    }

    public static void setLeakListener(LeakListener resourceLeakDetector$LeakListener0) {
        AbstractByteBuf.leakDetector.setLeakListener(resourceLeakDetector$LeakListener0);
    }

    public static ByteBuf setShortBE(ByteBuf byteBuf0, int v, int v1) {
        return byteBuf0.order() == ByteOrder.BIG_ENDIAN ? byteBuf0.setShort(v, v1) : byteBuf0.setShort(v, ByteBufUtil.swapShort(((short)v1)));
    }

    public static int swapInt(int v) {
        return Integer.reverseBytes(v);
    }

    public static long swapLong(long v) {
        return Long.reverseBytes(v);
    }

    public static int swapMedium(int v) {
        int v1 = v >>> 16 & 0xFF | (v << 16 & 0xFF0000 | 0xFF00 & v);
        return (0x800000 & v1) == 0 ? v1 : v1 | 0xFF000000;
    }

    public static short swapShort(short v) {
        return Short.reverseBytes(v);
    }

    public static ByteBuf threadLocalDirectBuffer() {
        if(ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE <= 0) {
            return null;
        }
        return PlatformDependent.hasUnsafe() ? ThreadLocalUnsafeDirectByteBuf.newInstance() : ThreadLocalDirectByteBuf.newInstance();
    }

    public static byte[] threadLocalTempArray(int v) {
        return v > 0x400 ? PlatformDependent.allocateUninitializedArray(v) : ((byte[])ByteBufUtil.BYTE_ARRAYS.get());
    }

    private static long uintFromLE(long v) {
        return Long.reverseBytes(v) >>> 0x20;
    }

    private static int unrolledFirstIndexOf(AbstractByteBuf abstractByteBuf0, int v, int v1, byte b) {
        if(abstractByteBuf0._getByte(v) == b) {
            return v;
        }
        if(v1 == 1) {
            return -1;
        }
        if(abstractByteBuf0._getByte(v + 1) == b) {
            return v + 1;
        }
        if(v1 == 2) {
            return -1;
        }
        if(abstractByteBuf0._getByte(v + 2) == b) {
            return v + 2;
        }
        if(v1 == 3) {
            return -1;
        }
        if(abstractByteBuf0._getByte(v + 3) == b) {
            return v + 3;
        }
        if(v1 == 4) {
            return -1;
        }
        if(abstractByteBuf0._getByte(v + 4) == b) {
            return v + 4;
        }
        if(v1 == 5) {
            return -1;
        }
        if(abstractByteBuf0._getByte(v + 5) == b) {
            return v + 5;
        }
        if(v1 == 6) {
            return -1;
        }
        return abstractByteBuf0._getByte(v + 6) == b ? v + 6 : -1;
    }

    private static int unsafeWriteUtf8(byte[] arr_b, long v, int v1, CharSequence charSequence0, int v2, int v3) {
        long v4 = v + ((long)v1);
        int v5 = v2;
        long v6 = v4;
        while(v5 < v3) {
            int v7 = 0x3F;
            int v8 = charSequence0.charAt(v5);
            if(v8 < 0x80) {
                PlatformDependent.putByte(arr_b, v6, ((byte)v8));
                ++v6;
            }
            else if(v8 < 0x800) {
                long v9 = v6 + 1L;
                PlatformDependent.putByte(arr_b, v6, ((byte)(v8 >> 6 | 0xC0)));
                v6 += 2L;
                PlatformDependent.putByte(arr_b, v9, ((byte)(v8 & 0x3F | 0x80)));
            }
            else if(!StringUtil.isSurrogate(((char)v8))) {
                PlatformDependent.putByte(arr_b, v6, ((byte)(v8 >> 12 | 0xE0)));
                long v14 = v6 + 2L;
                PlatformDependent.putByte(arr_b, v6 + 1L, ((byte)(v8 >> 6 & 0x3F | 0x80)));
                v6 += 3L;
                PlatformDependent.putByte(arr_b, v14, ((byte)(v8 & 0x3F | 0x80)));
            }
            else if(Character.isHighSurrogate(((char)v8))) {
                ++v5;
                if(v5 == v3) {
                    PlatformDependent.putByte(arr_b, v6, 0x3F);
                    return (int)(v6 + 1L - v4);
                }
                int v10 = charSequence0.charAt(v5);
                if(Character.isLowSurrogate(((char)v10))) {
                    int v12 = Character.toCodePoint(((char)v8), ((char)v10));
                    PlatformDependent.putByte(arr_b, v6, ((byte)(v12 >> 18 | 0xF0)));
                    PlatformDependent.putByte(arr_b, v6 + 1L, ((byte)(v12 >> 12 & 0x3F | 0x80)));
                    long v13 = v6 + 3L;
                    PlatformDependent.putByte(arr_b, v6 + 2L, ((byte)(v12 >> 6 & 0x3F | 0x80)));
                    v6 += 4L;
                    PlatformDependent.putByte(arr_b, v13, ((byte)(v12 & 0x3F | 0x80)));
                }
                else {
                    long v11 = v6 + 1L;
                    PlatformDependent.putByte(arr_b, v6, 0x3F);
                    v6 += 2L;
                    if(!Character.isHighSurrogate(((char)v10))) {
                        v7 = v10;
                    }
                    PlatformDependent.putByte(arr_b, v11, ((byte)v7));
                }
            }
            else {
                PlatformDependent.putByte(arr_b, v6, 0x3F);
                ++v6;
            }
            ++v5;
        }
        return (int)(v6 - v4);
    }

    private static int utf8ByteCount(CharSequence charSequence0, int v, int v1) {
        if(charSequence0 instanceof AsciiString) {
            return v1 - v;
        }
        int v2;
        for(v2 = v; v2 < v1 && charSequence0.charAt(v2) < 0x80; ++v2) {
        }
        return v2 >= v1 ? v2 - v : v2 - v + ByteBufUtil.utf8BytesNonAscii(charSequence0, v2, v1);
    }

    public static int utf8Bytes(CharSequence charSequence0) {
        return ByteBufUtil.utf8ByteCount(charSequence0, 0, charSequence0.length());
    }

    public static int utf8Bytes(CharSequence charSequence0, int v, int v1) {
        return ByteBufUtil.utf8ByteCount(ByteBufUtil.checkCharSequenceBounds(charSequence0, v, v1), v, v1);
    }

    private static int utf8BytesNonAscii(CharSequence charSequence0, int v, int v1) {
        int v2 = 0;
        while(v < v1) {
            int v3 = charSequence0.charAt(v);
            if(v3 < 0x800) {
                v2 = (0x7F - v3 >>> 0x1F) + 1 + v2;
            }
            else if(!StringUtil.isSurrogate(((char)v3))) {
                v2 += 3;
            }
            else if(Character.isHighSurrogate(((char)v3))) {
                ++v;
                if(v == v1) {
                    return v2 + 1;
                }
                v2 += (Character.isLowSurrogate(charSequence0.charAt(v)) ? 4 : 2);
            }
            else {
                ++v2;
            }
            ++v;
        }
        return v2;
    }

    public static int utf8MaxBytes(int v) {
        return v * ByteBufUtil.MAX_BYTES_PER_CHAR_UTF8;
    }

    // 去混淆评级： 低(20)
    public static int utf8MaxBytes(CharSequence charSequence0) {
        return charSequence0 instanceof AsciiString ? charSequence0.length() : ByteBufUtil.utf8MaxBytes(charSequence0.length());
    }

    public static int writeAscii(AbstractByteBuf abstractByteBuf0, int v, CharSequence charSequence0, int v1) {
        if(charSequence0 instanceof AsciiString) {
            ByteBufUtil.writeAsciiString(abstractByteBuf0, v, ((AsciiString)charSequence0), 0, v1);
            return v1;
        }
        ByteBufUtil.writeAsciiCharSequence(abstractByteBuf0, v, charSequence0, v1);
        return v1;
    }

    public static int writeAscii(ByteBuf byteBuf0, CharSequence charSequence0) {
        while(true) {
            if(!(byteBuf0 instanceof WrappedCompositeByteBuf)) {
                if(byteBuf0 instanceof AbstractByteBuf) {
                    int v = charSequence0.length();
                    ((AbstractByteBuf)byteBuf0).ensureWritable0(v);
                    if(charSequence0 instanceof AsciiString) {
                        ByteBufUtil.writeAsciiString(((AbstractByteBuf)byteBuf0), ((AbstractByteBuf)byteBuf0).writerIndex, ((AsciiString)charSequence0), 0, v);
                    }
                    else {
                        ByteBufUtil.writeAscii(((AbstractByteBuf)byteBuf0), ((AbstractByteBuf)byteBuf0).writerIndex, charSequence0, v);
                    }
                    ((AbstractByteBuf)byteBuf0).writerIndex += v;
                    return v;
                }
                if(!(byteBuf0 instanceof WrappedByteBuf)) {
                    break;
                }
            }
            byteBuf0 = byteBuf0.unwrap();
        }
        byte[] arr_b = charSequence0.toString().getBytes(CharsetUtil.US_ASCII);
        byteBuf0.writeBytes(arr_b);
        return arr_b.length;
    }

    public static ByteBuf writeAscii(ByteBufAllocator byteBufAllocator0, CharSequence charSequence0) {
        ByteBuf byteBuf0 = byteBufAllocator0.buffer(charSequence0.length());
        ByteBufUtil.writeAscii(byteBuf0, charSequence0);
        return byteBuf0;
    }

    private static int writeAsciiCharSequence(AbstractByteBuf abstractByteBuf0, int v, CharSequence charSequence0, int v1) {
        int v2 = 0;
        while(v2 < v1) {
            abstractByteBuf0._setByte(v, AsciiString.c2b(charSequence0.charAt(v2)));
            ++v2;
            ++v;
        }
        return v1;
    }

    public static void writeAsciiString(AbstractByteBuf abstractByteBuf0, int v, AsciiString asciiString0, int v1, int v2) {
        int v3 = asciiString0.arrayOffset() + v1;
        int v4 = v2 - v1;
        if(abstractByteBuf0.hasArray()) {
            PlatformDependent.copyMemory(asciiString0.array(), v3, abstractByteBuf0.array(), abstractByteBuf0.arrayOffset() + v, ((long)v4));
            return;
        }
        if(abstractByteBuf0.hasMemoryAddress()) {
            PlatformDependent.copyMemory(asciiString0.array(), v3, abstractByteBuf0.memoryAddress() + ((long)v), ((long)v4));
            return;
        }
        if(abstractByteBuf0.hasArray()) {
            System.arraycopy(asciiString0.array(), v3, abstractByteBuf0.array(), abstractByteBuf0.arrayOffset() + v, v4);
            return;
        }
        abstractByteBuf0.setBytes(v, asciiString0.array(), v3, v4);
    }

    public static ByteBuf writeMediumBE(ByteBuf byteBuf0, int v) {
        return byteBuf0.order() == ByteOrder.BIG_ENDIAN ? byteBuf0.writeMedium(v) : byteBuf0.writeMedium(ByteBufUtil.swapMedium(v));
    }

    public static ByteBuf writeShortBE(ByteBuf byteBuf0, int v) {
        return byteBuf0.order() == ByteOrder.BIG_ENDIAN ? byteBuf0.writeShort(v) : byteBuf0.writeShort(ByteBufUtil.swapShort(((short)v)));
    }

    public static int writeUtf8(AbstractByteBuf abstractByteBuf0, int v, int v1, CharSequence charSequence0, int v2) {
        return ByteBufUtil.writeUtf8(abstractByteBuf0, v, v1, charSequence0, 0, v2);
    }

    public static int writeUtf8(AbstractByteBuf abstractByteBuf0, int v, int v1, CharSequence charSequence0, int v2, int v3) {
        if(charSequence0 instanceof AsciiString) {
            ByteBufUtil.writeAsciiString(abstractByteBuf0, v, ((AsciiString)charSequence0), v2, v3);
            return v3 - v2;
        }
        if(abstractByteBuf0.hasArray()) {
            return ByteBufUtil.unsafeWriteUtf8(abstractByteBuf0.array(), 0L, abstractByteBuf0.arrayOffset() + v, charSequence0, v2, v3);
        }
        return abstractByteBuf0.hasMemoryAddress() ? ByteBufUtil.unsafeWriteUtf8(null, abstractByteBuf0.memoryAddress(), v, charSequence0, v2, v3) : ByteBufUtil.safeWriteUtf8(abstractByteBuf0, v, charSequence0, v2, v3);
    }

    public static int writeUtf8(ByteBuf byteBuf0, CharSequence charSequence0) {
        int v = charSequence0.length();
        return ByteBufUtil.reserveAndWriteUtf8Seq(byteBuf0, charSequence0, 0, v, ByteBufUtil.utf8MaxBytes(v));
    }

    public static int writeUtf8(ByteBuf byteBuf0, CharSequence charSequence0, int v, int v1) {
        ByteBufUtil.checkCharSequenceBounds(charSequence0, v, v1);
        return ByteBufUtil.reserveAndWriteUtf8Seq(byteBuf0, charSequence0, v, v1, ByteBufUtil.utf8MaxBytes(v1 - v));
    }

    public static ByteBuf writeUtf8(ByteBufAllocator byteBufAllocator0, CharSequence charSequence0) {
        ByteBuf byteBuf0 = byteBufAllocator0.buffer(ByteBufUtil.utf8MaxBytes(charSequence0));
        ByteBufUtil.writeUtf8(byteBuf0, charSequence0);
        return byteBuf0;
    }
}

