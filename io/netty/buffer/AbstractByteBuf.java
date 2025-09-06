package io.netty.buffer;

import U4.x;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public abstract class AbstractByteBuf extends ByteBuf {
    private static final String LEGACY_PROP_CHECK_ACCESSIBLE = "io.netty.buffer.bytebuf.checkAccessible";
    private static final String PROP_CHECK_ACCESSIBLE = "io.netty.buffer.checkAccessible";
    private static final String PROP_CHECK_BOUNDS = "io.netty.buffer.checkBounds";
    static final boolean checkAccessible;
    private static final boolean checkBounds;
    static final ResourceLeakDetector leakDetector;
    private static final InternalLogger logger;
    private int markedReaderIndex;
    private int markedWriterIndex;
    private int maxCapacity;
    int readerIndex;
    int writerIndex;

    static {
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(AbstractByteBuf.class);
        AbstractByteBuf.logger = internalLogger0;
        AbstractByteBuf.checkAccessible = SystemPropertyUtil.contains("io.netty.buffer.checkAccessible") ? SystemPropertyUtil.getBoolean("io.netty.buffer.checkAccessible", true) : SystemPropertyUtil.getBoolean("io.netty.buffer.bytebuf.checkAccessible", true);
        boolean z = SystemPropertyUtil.getBoolean("io.netty.buffer.checkBounds", true);
        AbstractByteBuf.checkBounds = z;
        if(internalLogger0.isDebugEnabled()) {
            internalLogger0.debug("-D{}: {}", "io.netty.buffer.checkAccessible", Boolean.valueOf(AbstractByteBuf.checkAccessible));
            internalLogger0.debug("-D{}: {}", "io.netty.buffer.checkBounds", Boolean.valueOf(z));
        }
        AbstractByteBuf.leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ByteBuf.class);
    }

    public AbstractByteBuf(int v) {
        ObjectUtil.checkPositiveOrZero(v, "maxCapacity");
        this.maxCapacity = v;
    }

    public abstract byte _getByte(int arg1);

    public abstract int _getInt(int arg1);

    public abstract int _getIntLE(int arg1);

    public abstract long _getLong(int arg1);

    public abstract long _getLongLE(int arg1);

    public abstract short _getShort(int arg1);

    public abstract short _getShortLE(int arg1);

    public abstract int _getUnsignedMedium(int arg1);

    public abstract int _getUnsignedMediumLE(int arg1);

    public abstract void _setByte(int arg1, int arg2);

    public abstract void _setInt(int arg1, int arg2);

    public abstract void _setIntLE(int arg1, int arg2);

    public abstract void _setLong(int arg1, long arg2);

    public abstract void _setLongLE(int arg1, long arg2);

    public abstract void _setMedium(int arg1, int arg2);

    public abstract void _setMediumLE(int arg1, int arg2);

    public abstract void _setShort(int arg1, int arg2);

    public abstract void _setShortLE(int arg1, int arg2);

    public final void adjustMarkers(int v) {
        int v1 = this.markedReaderIndex;
        if(v1 <= v) {
            this.markedReaderIndex = 0;
            int v2 = this.markedWriterIndex;
            if(v2 <= v) {
                this.markedWriterIndex = 0;
                return;
            }
            this.markedWriterIndex = v2 - v;
            return;
        }
        this.markedReaderIndex = v1 - v;
        this.markedWriterIndex -= v;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return this.isReadOnly() ? this : Unpooled.unmodifiableBuffer(this);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int bytesBefore(byte b) {
        return this.bytesBefore(this.readerIndex(), this.readableBytes(), b);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int bytesBefore(int v, byte b) {
        this.checkReadableBytes(v);
        return this.bytesBefore(this.readerIndex(), v, b);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int bytesBefore(int v, int v1, byte b) {
        int v2 = this.indexOf(v, v1 + v, b);
        return v2 >= 0 ? v2 - v : -1;
    }

    public final void checkDstIndex(int v, int v1, int v2) {
        this.checkReadableBytes(v);
        if(AbstractByteBuf.checkBounds) {
            AbstractByteBuf.checkRangeBounds("dstIndex", v1, v, v2);
        }
    }

    public final void checkDstIndex(int v, int v1, int v2, int v3) {
        this.checkIndex(v, v1);
        if(AbstractByteBuf.checkBounds) {
            AbstractByteBuf.checkRangeBounds("dstIndex", v2, v1, v3);
        }
    }

    public final void checkIndex(int v) {
        this.checkIndex(v, 1);
    }

    public final void checkIndex(int v, int v1) {
        this.ensureAccessible();
        this.checkIndex0(v, v1);
    }

    public final void checkIndex0(int v, int v1) {
        if(AbstractByteBuf.checkBounds) {
            AbstractByteBuf.checkRangeBounds("index", v, v1, this.capacity());
        }
    }

    private static void checkIndexBounds(int v, int v1, int v2) {
        if(v < 0 || v > v1 || v1 > v2) {
            throw new IndexOutOfBoundsException(String.format("readerIndex: %d, writerIndex: %d (expected: 0 <= readerIndex <= writerIndex <= capacity(%d))", v, v1, v2));
        }
    }

    public final void checkNewCapacity(int v) {
        this.ensureAccessible();
        if(AbstractByteBuf.checkBounds && (v < 0 || v > this.maxCapacity())) {
            StringBuilder stringBuilder0 = x.n(v, "newCapacity: ", " (expected: 0-");
            stringBuilder0.append(this.maxCapacity());
            stringBuilder0.append(')');
            throw new IllegalArgumentException(stringBuilder0.toString());
        }
    }

    private static void checkRangeBounds(String s, int v, int v1, int v2) {
        if(MathUtil.isOutOfBounds(v, v1, v2)) {
            throw new IndexOutOfBoundsException(String.format("%s: %d, length: %d (expected: range(0, %d))", s, v, v1, v2));
        }
    }

    private static void checkReadableBounds(ByteBuf byteBuf0, int v) {
        if(v > byteBuf0.readableBytes()) {
            throw new IndexOutOfBoundsException(String.format("length(%d) exceeds src.readableBytes(%d) where src is: %s", v, byteBuf0.readableBytes(), byteBuf0));
        }
    }

    public final void checkReadableBytes(int v) {
        this.checkReadableBytes0(ObjectUtil.checkPositiveOrZero(v, "minimumReadableBytes"));
    }

    private void checkReadableBytes0(int v) {
        this.ensureAccessible();
        if(AbstractByteBuf.checkBounds && this.readerIndex > this.writerIndex - v) {
            throw new IndexOutOfBoundsException(String.format("readerIndex(%d) + length(%d) exceeds writerIndex(%d): %s", this.readerIndex, v, this.writerIndex, this));
        }
    }

    public final void checkSrcIndex(int v, int v1, int v2, int v3) {
        this.checkIndex(v, v1);
        if(AbstractByteBuf.checkBounds) {
            AbstractByteBuf.checkRangeBounds("srcIndex", v2, v1, v3);
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        this.writerIndex = 0;
        this.readerIndex = 0;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int compareTo(ByteBuf byteBuf0) {
        return ByteBufUtil.compare(this, byteBuf0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int compareTo(Object object0) {
        return this.compareTo(((ByteBuf)object0));
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        return this.copy(this.readerIndex, this.readableBytes());
    }

    public final void discardMarks() {
        this.markedWriterIndex = 0;
        this.markedReaderIndex = 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        int v = this.readerIndex;
        if(v == 0) {
            this.ensureAccessible();
            return this;
        }
        int v1 = this.writerIndex;
        if(v != v1) {
            this.setBytes(0, this, v, v1 - v);
            this.writerIndex -= this.readerIndex;
            this.adjustMarkers(this.readerIndex);
            this.readerIndex = 0;
            return this;
        }
        this.ensureAccessible();
        this.adjustMarkers(this.readerIndex);
        this.readerIndex = 0;
        this.writerIndex = 0;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        int v = this.readerIndex;
        if(v > 0) {
            if(v == this.writerIndex) {
                this.ensureAccessible();
                this.adjustMarkers(this.readerIndex);
                this.readerIndex = 0;
                this.writerIndex = 0;
                return this;
            }
            if(v >= this.capacity() >>> 1) {
                this.setBytes(0, this, this.readerIndex, this.writerIndex - this.readerIndex);
                this.writerIndex -= this.readerIndex;
                this.adjustMarkers(this.readerIndex);
                this.readerIndex = 0;
                return this;
            }
        }
        this.ensureAccessible();
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        this.ensureAccessible();
        return new UnpooledDuplicatedByteBuf(this);
    }

    public final void ensureAccessible() {
        if(AbstractByteBuf.checkAccessible && !this.isAccessible()) {
            throw new IllegalReferenceCountException(0);
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public int ensureWritable(int v, boolean z) {
        this.ensureAccessible();
        ObjectUtil.checkPositiveOrZero(v, "minWritableBytes");
        if(v <= this.writableBytes()) {
            return 0;
        }
        int v1 = this.maxCapacity();
        int v2 = this.writerIndex();
        if(v > v1 - v2) {
            if(z && this.capacity() != v1) {
                this.capacity(v1);
                return 3;
            }
            return 1;
        }
        int v3 = this.maxFastWritableBytes();
        this.capacity((v3 < v ? this.alloc().calculateNewCapacity(v2 + v, v1) : v2 + v3));
        return 2;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int v) {
        this.ensureWritable0(ObjectUtil.checkPositiveOrZero(v, "minWritableBytes"));
        return this;
    }

    public final void ensureWritable0(int v) {
        int v1 = this.writerIndex();
        int v2 = v1 + v;
        if(((v2 > this.capacity() ? 0 : 1) & (v2 < 0 ? 0 : 1)) != 0) {
            this.ensureAccessible();
            return;
        }
        if(AbstractByteBuf.checkBounds && (v2 < 0 || v2 > this.maxCapacity)) {
            this.ensureAccessible();
            throw new IndexOutOfBoundsException(String.format("writerIndex(%d) + minWritableBytes(%d) exceeds maxCapacity(%d): %s", v1, v, this.maxCapacity, this));
        }
        int v3 = this.maxFastWritableBytes();
        this.capacity((v3 < v ? this.alloc().calculateNewCapacity(v2, this.maxCapacity) : v1 + v3));
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.buffer.ByteBuf
    public boolean equals(Object object0) {
        return object0 instanceof ByteBuf && ByteBufUtil.equals(this, ((ByteBuf)object0));
    }

    @Override  // io.netty.buffer.ByteBuf
    public int forEachByte(int v, int v1, ByteProcessor byteProcessor0) {
        this.checkIndex(v, v1);
        try {
            return this.forEachByteAsc0(v, v1 + v, byteProcessor0);
        }
        catch(Exception exception0) {
            PlatformDependent.throwException(exception0);
            return -1;
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor0) {
        this.ensureAccessible();
        try {
            return this.forEachByteAsc0(this.readerIndex, this.writerIndex, byteProcessor0);
        }
        catch(Exception exception0) {
            PlatformDependent.throwException(exception0);
            return -1;
        }
    }

    public int forEachByteAsc0(int v, int v1, ByteProcessor byteProcessor0) {
        while(v < v1) {
            if(!byteProcessor0.process(this._getByte(v))) {
                return v;
            }
            ++v;
        }
        return -1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int forEachByteDesc(int v, int v1, ByteProcessor byteProcessor0) {
        this.checkIndex(v, v1);
        try {
            return this.forEachByteDesc0(v1 + v - 1, v, byteProcessor0);
        }
        catch(Exception exception0) {
            PlatformDependent.throwException(exception0);
            return -1;
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor0) {
        this.ensureAccessible();
        try {
            return this.forEachByteDesc0(this.writerIndex - 1, this.readerIndex, byteProcessor0);
        }
        catch(Exception exception0) {
            PlatformDependent.throwException(exception0);
            return -1;
        }
    }

    public int forEachByteDesc0(int v, int v1, ByteProcessor byteProcessor0) {
        while(v >= v1) {
            if(!byteProcessor0.process(this._getByte(v))) {
                return v;
            }
            --v;
        }
        return -1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean getBoolean(int v) {
        return this.getByte(v) != 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte getByte(int v) {
        this.checkIndex(v);
        return this._getByte(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0) {
        this.getBytes(v, byteBuf0, byteBuf0.writableBytes());
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1) {
        this.getBytes(v, byteBuf0, byteBuf0.writerIndex(), v1);
        byteBuf0.writerIndex(byteBuf0.writerIndex() + v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b) {
        this.getBytes(v, arr_b, 0, arr_b.length);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public char getChar(int v) {
        return (char)this.getShort(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int v, int v1, Charset charset0) {
        return !CharsetUtil.US_ASCII.equals(charset0) && !CharsetUtil.ISO_8859_1.equals(charset0) ? this.toString(v, v1, charset0) : new AsciiString(ByteBufUtil.getBytes(this, v, v1, true), false);
    }

    @Override  // io.netty.buffer.ByteBuf
    public double getDouble(int v) {
        return Double.longBitsToDouble(this.getLong(v));
    }

    @Override  // io.netty.buffer.ByteBuf
    public float getFloat(int v) {
        return Float.intBitsToFloat(this.getInt(v));
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getInt(int v) {
        this.checkIndex(v, 4);
        return this._getInt(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getIntLE(int v) {
        this.checkIndex(v, 4);
        return this._getIntLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public long getLong(int v) {
        this.checkIndex(v, 8);
        return this._getLong(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public long getLongLE(int v) {
        this.checkIndex(v, 8);
        return this._getLongLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getMedium(int v) {
        int v1 = this.getUnsignedMedium(v);
        return (0x800000 & v1) == 0 ? v1 : v1 | 0xFF000000;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getMediumLE(int v) {
        int v1 = this.getUnsignedMediumLE(v);
        return (0x800000 & v1) == 0 ? v1 : v1 | 0xFF000000;
    }

    @Override  // io.netty.buffer.ByteBuf
    public short getShort(int v) {
        this.checkIndex(v, 2);
        return this._getShort(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public short getShortLE(int v) {
        this.checkIndex(v, 2);
        return this._getShortLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int v) {
        return (short)(this.getByte(v) & 0xFF);
    }

    @Override  // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int v) {
        return ((long)this.getInt(v)) & 0xFFFFFFFFL;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int v) {
        return ((long)this.getIntLE(v)) & 0xFFFFFFFFL;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int v) {
        this.checkIndex(v, 3);
        return this._getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int v) {
        this.checkIndex(v, 3);
        return this._getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int v) {
        return this.getShort(v) & 0xFFFF;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int v) {
        return this.getShortLE(v) & 0xFFFF;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int hashCode() {
        return ByteBufUtil.hashCode(this);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int indexOf(int v, int v1, byte b) {
        return v > v1 ? ByteBufUtil.lastIndexOf(this, v, v1, b) : ByteBufUtil.firstIndexOf(this, v, v1, b);
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        return this.writerIndex > this.readerIndex;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isReadable(int v) {
        return this.writerIndex - this.readerIndex >= v;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return this.capacity() > this.writerIndex;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isWritable(int v) {
        return this.capacity() - this.writerIndex >= v;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        this.markedReaderIndex = this.readerIndex;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf markWriterIndex() {
        this.markedWriterIndex = this.writerIndex;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return this.maxCapacity;
    }

    public final void maxCapacity(int v) {
        this.maxCapacity = v;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return this.maxCapacity() - this.writerIndex;
    }

    public SwappedByteBuf newSwappedByteBuf() {
        return new SwappedByteBuf(this);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return this.nioBuffer(this.readerIndex, this.readableBytes());
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return this.nioBuffers(this.readerIndex, this.readableBytes());
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder0) {
        if(byteOrder0 == this.order()) {
            return this;
        }
        ObjectUtil.checkNotNull(byteOrder0, "endianness");
        return this.newSwappedByteBuf();
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        return this.readByte() != 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte readByte() {
        this.checkReadableBytes0(1);
        int v = this.readerIndex;
        byte b = this._getByte(v);
        this.readerIndex = v + 1;
        return b;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel0, long v, int v1) {
        this.checkReadableBytes(v1);
        int v2 = this.getBytes(this.readerIndex, fileChannel0, v, v1);
        this.readerIndex += v2;
        return v2;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel0, int v) {
        this.checkReadableBytes(v);
        int v1 = this.getBytes(this.readerIndex, gatheringByteChannel0, v);
        this.readerIndex += v1;
        return v1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int v) {
        this.checkReadableBytes(v);
        if(v == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBuf byteBuf0 = this.alloc().buffer(v, this.maxCapacity);
        byteBuf0.writeBytes(this, this.readerIndex, v);
        this.readerIndex += v;
        return byteBuf0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0) {
        this.readBytes(byteBuf0, byteBuf0.writableBytes());
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v) {
        if(AbstractByteBuf.checkBounds && v > byteBuf0.writableBytes()) {
            throw new IndexOutOfBoundsException(String.format("length(%d) exceeds dst.writableBytes(%d) where dst is: %s", v, byteBuf0.writableBytes(), byteBuf0));
        }
        this.readBytes(byteBuf0, byteBuf0.writerIndex(), v);
        byteBuf0.writerIndex(byteBuf0.writerIndex() + v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v, int v1) {
        this.checkReadableBytes(v1);
        this.getBytes(this.readerIndex, byteBuf0, v, v1);
        this.readerIndex += v1;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream0, int v) {
        this.checkReadableBytes(v);
        this.getBytes(this.readerIndex, outputStream0, v);
        this.readerIndex += v;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.remaining();
        this.checkReadableBytes(v);
        this.getBytes(this.readerIndex, byteBuffer0);
        this.readerIndex += v;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] arr_b) {
        this.readBytes(arr_b, 0, arr_b.length);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] arr_b, int v, int v1) {
        this.checkReadableBytes(v1);
        this.getBytes(this.readerIndex, arr_b, v, v1);
        this.readerIndex += v1;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public char readChar() {
        return (char)this.readShort();
    }

    @Override  // io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int v, Charset charset0) {
        CharSequence charSequence0 = this.getCharSequence(this.readerIndex, v, charset0);
        this.readerIndex += v;
        return charSequence0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public double readDouble() {
        return Double.longBitsToDouble(this.readLong());
    }

    @Override  // io.netty.buffer.ByteBuf
    public float readFloat() {
        return Float.intBitsToFloat(this.readInt());
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readInt() {
        this.checkReadableBytes0(4);
        int v = this._getInt(this.readerIndex);
        this.readerIndex += 4;
        return v;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readIntLE() {
        this.checkReadableBytes0(4);
        int v = this._getIntLE(this.readerIndex);
        this.readerIndex += 4;
        return v;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long readLong() {
        this.checkReadableBytes0(8);
        long v = this._getLong(this.readerIndex);
        this.readerIndex += 8;
        return v;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long readLongLE() {
        this.checkReadableBytes0(8);
        long v = this._getLongLE(this.readerIndex);
        this.readerIndex += 8;
        return v;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readMedium() {
        int v = this.readUnsignedMedium();
        return (0x800000 & v) == 0 ? v : v | 0xFF000000;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readMediumLE() {
        int v = this.readUnsignedMediumLE();
        return (0x800000 & v) == 0 ? v : v | 0xFF000000;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int v) {
        this.checkReadableBytes(v);
        ByteBuf byteBuf0 = this.retainedSlice(this.readerIndex, v);
        this.readerIndex += v;
        return byteBuf0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public short readShort() {
        this.checkReadableBytes0(2);
        short v = this._getShort(this.readerIndex);
        this.readerIndex += 2;
        return v;
    }

    @Override  // io.netty.buffer.ByteBuf
    public short readShortLE() {
        this.checkReadableBytes0(2);
        short v = this._getShortLE(this.readerIndex);
        this.readerIndex += 2;
        return v;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int v) {
        this.checkReadableBytes(v);
        ByteBuf byteBuf0 = this.slice(this.readerIndex, v);
        this.readerIndex += v;
        return byteBuf0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return (short)(this.readByte() & 0xFF);
    }

    @Override  // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        return ((long)this.readInt()) & 0xFFFFFFFFL;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        return ((long)this.readIntLE()) & 0xFFFFFFFFL;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        this.checkReadableBytes0(3);
        int v = this._getUnsignedMedium(this.readerIndex);
        this.readerIndex += 3;
        return v;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        this.checkReadableBytes0(3);
        int v = this._getUnsignedMediumLE(this.readerIndex);
        this.readerIndex += 3;
        return v;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return this.readShort() & 0xFFFF;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        return this.readShortLE() & 0xFFFF;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readableBytes() {
        return this.writerIndex - this.readerIndex;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return this.readerIndex;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int v) {
        if(AbstractByteBuf.checkBounds) {
            AbstractByteBuf.checkIndexBounds(v, this.writerIndex, this.capacity());
        }
        this.readerIndex = v;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        this.readerIndex(this.markedReaderIndex);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf resetWriterIndex() {
        this.writerIndex(this.markedWriterIndex);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return this.duplicate().retain();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return this.slice().retain();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int v, int v1) {
        return this.slice(v, v1).retain();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int v, boolean z) {
        this.setByte(v, ((int)z));
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int v, int v1) {
        this.checkIndex(v);
        this._setByte(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0) {
        this.setBytes(v, byteBuf0, byteBuf0.readableBytes());
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1) {
        this.checkIndex(v, v1);
        ObjectUtil.checkNotNull(byteBuf0, "src");
        if(AbstractByteBuf.checkBounds) {
            AbstractByteBuf.checkReadableBounds(byteBuf0, v1);
        }
        this.setBytes(v, byteBuf0, byteBuf0.readerIndex(), v1);
        byteBuf0.readerIndex(byteBuf0.readerIndex() + v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b) {
        this.setBytes(v, arr_b, 0, arr_b.length);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setChar(int v, int v1) {
        this.setShort(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setCharSequence(int v, CharSequence charSequence0, Charset charset0) {
        return this.setCharSequence0(v, charSequence0, charset0, false);
    }

    private int setCharSequence0(int v, CharSequence charSequence0, Charset charset0, boolean z) {
        if(charset0.equals(CharsetUtil.UTF_8)) {
            int v1 = ByteBufUtil.utf8MaxBytes(charSequence0);
            if(z) {
                this.ensureWritable0(v1);
                this.checkIndex0(v, v1);
                return ByteBufUtil.writeUtf8(this, v, v1, charSequence0, charSequence0.length());
            }
            this.checkIndex(v, v1);
            return ByteBufUtil.writeUtf8(this, v, v1, charSequence0, charSequence0.length());
        }
        if(!charset0.equals(CharsetUtil.US_ASCII) && !charset0.equals(CharsetUtil.ISO_8859_1)) {
            byte[] arr_b = charSequence0.toString().getBytes(charset0);
            if(z) {
                this.ensureWritable0(arr_b.length);
            }
            this.setBytes(v, arr_b);
            return arr_b.length;
        }
        int v2 = charSequence0.length();
        if(z) {
            this.ensureWritable0(v2);
            this.checkIndex0(v, v2);
            return ByteBufUtil.writeAscii(this, v, charSequence0, v2);
        }
        this.checkIndex(v, v2);
        return ByteBufUtil.writeAscii(this, v, charSequence0, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int v, double f) {
        this.setLong(v, Double.doubleToRawLongBits(f));
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int v, float f) {
        this.setInt(v, Float.floatToRawIntBits(f));
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int v, int v1) {
        if(AbstractByteBuf.checkBounds) {
            AbstractByteBuf.checkIndexBounds(v, v1, this.capacity());
        }
        this.setIndex0(v, v1);
        return this;
    }

    public final void setIndex0(int v, int v1) {
        this.readerIndex = v;
        this.writerIndex = v1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int v, int v1) {
        this.checkIndex(v, 4);
        this._setInt(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        this.checkIndex(v, 4);
        this._setIntLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int v, long v1) {
        this.checkIndex(v, 8);
        this._setLong(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        this.checkIndex(v, 8);
        this._setLongLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int v, int v1) {
        this.checkIndex(v, 3);
        this._setMedium(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        this.checkIndex(v, 3);
        this._setMediumLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int v, int v1) {
        this.checkIndex(v, 2);
        this._setShort(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        this.checkIndex(v, 2);
        this._setShortLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int v, int v1) {
        if(v1 != 0) {
            this.checkIndex(v, v1);
            int v2 = v1 >>> 3;
            int v3 = v1 & 7;
            while(v2 > 0) {
                this._setLong(v, 0L);
                v += 8;
                --v2;
            }
            if(v3 == 4) {
                this._setInt(v, 0);
                return this;
            }
            if(v3 < 4) {
                while(v3 > 0) {
                    this._setByte(v, 0);
                    ++v;
                    --v3;
                }
                return this;
            }
            this._setInt(v, 0);
            int v4 = v + 4;
            for(int v5 = v3 - 4; v5 > 0; --v5) {
                this._setByte(v4, 0);
                ++v4;
            }
        }
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int v) {
        this.checkReadableBytes(v);
        this.readerIndex += v;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return this.slice(this.readerIndex, this.readableBytes());
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf slice(int v, int v1) {
        this.ensureAccessible();
        return new UnpooledSlicedByteBuf(this, v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public String toString() {
        if(this.refCnt() == 0) {
            return StringUtil.simpleClassName(this) + "(freed)";
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(StringUtil.simpleClassName(this));
        stringBuilder0.append("(ridx: ");
        stringBuilder0.append(this.readerIndex);
        stringBuilder0.append(", widx: ");
        stringBuilder0.append(this.writerIndex);
        stringBuilder0.append(", cap: ");
        stringBuilder0.append(this.capacity());
        if(this.maxCapacity != 0x7FFFFFFF) {
            stringBuilder0.append('/');
            stringBuilder0.append(this.maxCapacity);
        }
        ByteBuf byteBuf0 = this.unwrap();
        if(byteBuf0 != null) {
            stringBuilder0.append(", unwrapped: ");
            stringBuilder0.append(byteBuf0);
        }
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }

    @Override  // io.netty.buffer.ByteBuf
    public String toString(int v, int v1, Charset charset0) {
        return ByteBufUtil.decodeString(this, v, v1, charset0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public String toString(Charset charset0) {
        return this.toString(this.readerIndex, this.readableBytes(), charset0);
    }

    public final void trimIndicesToCapacity(int v) {
        if(this.writerIndex() > v) {
            this.setIndex0(Math.min(this.readerIndex(), v), v);
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return this.capacity() - this.writerIndex;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean z) {
        this.writeByte(((int)z));
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int v) {
        this.ensureWritable0(1);
        int v1 = this.writerIndex;
        this.writerIndex = v1 + 1;
        this._setByte(v1, v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream0, int v) {
        this.ensureWritable(v);
        int v1 = this.setBytes(this.writerIndex, inputStream0, v);
        if(v1 > 0) {
            this.writerIndex += v1;
        }
        return v1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel0, long v, int v1) {
        this.ensureWritable(v1);
        int v2 = this.setBytes(this.writerIndex, fileChannel0, v, v1);
        if(v2 > 0) {
            this.writerIndex += v2;
        }
        return v2;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel0, int v) {
        this.ensureWritable(v);
        int v1 = this.setBytes(this.writerIndex, scatteringByteChannel0, v);
        if(v1 > 0) {
            this.writerIndex += v1;
        }
        return v1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0) {
        this.writeBytes(byteBuf0, byteBuf0.readableBytes());
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v) {
        if(AbstractByteBuf.checkBounds) {
            AbstractByteBuf.checkReadableBounds(byteBuf0, v);
        }
        this.writeBytes(byteBuf0, byteBuf0.readerIndex(), v);
        byteBuf0.readerIndex(byteBuf0.readerIndex() + v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v, int v1) {
        this.ensureWritable(v1);
        this.setBytes(this.writerIndex, byteBuf0, v, v1);
        this.writerIndex += v1;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.remaining();
        this.ensureWritable0(v);
        this.setBytes(this.writerIndex, byteBuffer0);
        this.writerIndex += v;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] arr_b) {
        this.writeBytes(arr_b, 0, arr_b.length);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] arr_b, int v, int v1) {
        this.ensureWritable(v1);
        this.setBytes(this.writerIndex, arr_b, v, v1);
        this.writerIndex += v1;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int v) {
        this.writeShort(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence0, Charset charset0) {
        int v = this.setCharSequence0(this.writerIndex, charSequence0, charset0, true);
        this.writerIndex += v;
        return v;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double f) {
        this.writeLong(Double.doubleToRawLongBits(f));
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float f) {
        this.writeInt(Float.floatToRawIntBits(f));
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int v) {
        this.ensureWritable0(4);
        this._setInt(this.writerIndex, v);
        this.writerIndex += 4;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int v) {
        this.ensureWritable0(4);
        this._setIntLE(this.writerIndex, v);
        this.writerIndex += 4;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long v) {
        this.ensureWritable0(8);
        this._setLong(this.writerIndex, v);
        this.writerIndex += 8;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long v) {
        this.ensureWritable0(8);
        this._setLongLE(this.writerIndex, v);
        this.writerIndex += 8;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int v) {
        this.ensureWritable0(3);
        this._setMedium(this.writerIndex, v);
        this.writerIndex += 3;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int v) {
        this.ensureWritable0(3);
        this._setMediumLE(this.writerIndex, v);
        this.writerIndex += 3;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int v) {
        this.ensureWritable0(2);
        this._setShort(this.writerIndex, v);
        this.writerIndex += 2;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int v) {
        this.ensureWritable0(2);
        this._setShortLE(this.writerIndex, v);
        this.writerIndex += 2;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int v) {
        if(v == 0) {
            return this;
        }
        this.ensureWritable(v);
        int v1 = this.writerIndex;
        this.checkIndex0(v1, v);
        int v2 = v >>> 3;
        int v3 = v & 7;
        while(v2 > 0) {
            this._setLong(v1, 0L);
            v1 += 8;
            --v2;
        }
        if(v3 == 4) {
            this._setInt(v1, 0);
            v1 += 4;
        }
        else if(v3 < 4) {
            while(v3 > 0) {
                this._setByte(v1, 0);
                ++v1;
                --v3;
            }
        }
        else {
            this._setInt(v1, 0);
            v1 += 4;
            for(int v4 = v3 - 4; v4 > 0; --v4) {
                this._setByte(v1, 0);
                ++v1;
            }
        }
        this.writerIndex = v1;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return this.writerIndex;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int v) {
        if(AbstractByteBuf.checkBounds) {
            AbstractByteBuf.checkIndexBounds(this.readerIndex, v, this.capacity());
        }
        this.writerIndex = v;
        return this;
    }
}

