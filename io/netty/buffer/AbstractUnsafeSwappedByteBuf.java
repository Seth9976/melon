package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteOrder;

abstract class AbstractUnsafeSwappedByteBuf extends SwappedByteBuf {
    static final boolean $assertionsDisabled;
    private final boolean nativeByteOrder;
    private final AbstractByteBuf wrapped;

    public AbstractUnsafeSwappedByteBuf(AbstractByteBuf abstractByteBuf0) {
        super(abstractByteBuf0);
        this.wrapped = abstractByteBuf0;
        this.nativeByteOrder = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER == (this.order() == ByteOrder.BIG_ENDIAN);
    }

    public abstract int _getInt(AbstractByteBuf arg1, int arg2);

    public abstract long _getLong(AbstractByteBuf arg1, int arg2);

    public abstract short _getShort(AbstractByteBuf arg1, int arg2);

    public abstract void _setInt(AbstractByteBuf arg1, int arg2, int arg3);

    public abstract void _setLong(AbstractByteBuf arg1, int arg2, long arg3);

    public abstract void _setShort(AbstractByteBuf arg1, int arg2, short arg3);

    @Override  // io.netty.buffer.SwappedByteBuf
    public final char getChar(int v) {
        return (char)this.getShort(v);
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final double getDouble(int v) {
        return Double.longBitsToDouble(this.getLong(v));
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final float getFloat(int v) {
        return Float.intBitsToFloat(this.getInt(v));
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final int getInt(int v) {
        this.wrapped.checkIndex(v, 4);
        int v1 = this._getInt(this.wrapped, v);
        return this.nativeByteOrder ? v1 : Integer.reverseBytes(v1);
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final long getLong(int v) {
        this.wrapped.checkIndex(v, 8);
        long v1 = this._getLong(this.wrapped, v);
        return this.nativeByteOrder ? v1 : Long.reverseBytes(v1);
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final short getShort(int v) {
        this.wrapped.checkIndex(v, 2);
        short v1 = this._getShort(this.wrapped, v);
        return this.nativeByteOrder ? v1 : Short.reverseBytes(v1);
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final long getUnsignedInt(int v) {
        return ((long)this.getInt(v)) & 0xFFFFFFFFL;
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final int getUnsignedShort(int v) {
        return this.getShort(v) & 0xFFFF;
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final ByteBuf setChar(int v, int v1) {
        this.setShort(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final ByteBuf setDouble(int v, double f) {
        this.setLong(v, Double.doubleToRawLongBits(f));
        return this;
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final ByteBuf setFloat(int v, float f) {
        this.setInt(v, Float.floatToRawIntBits(f));
        return this;
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final ByteBuf setInt(int v, int v1) {
        this.wrapped.checkIndex(v, 4);
        AbstractByteBuf abstractByteBuf0 = this.wrapped;
        if(!this.nativeByteOrder) {
            v1 = Integer.reverseBytes(v1);
        }
        this._setInt(abstractByteBuf0, v, v1);
        return this;
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final ByteBuf setLong(int v, long v1) {
        this.wrapped.checkIndex(v, 8);
        AbstractByteBuf abstractByteBuf0 = this.wrapped;
        if(!this.nativeByteOrder) {
            v1 = Long.reverseBytes(v1);
        }
        this._setLong(abstractByteBuf0, v, v1);
        return this;
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final ByteBuf setShort(int v, int v1) {
        this.wrapped.checkIndex(v, 2);
        AbstractByteBuf abstractByteBuf0 = this.wrapped;
        int v2 = (short)v1;
        if(!this.nativeByteOrder) {
            v2 = Short.reverseBytes(((short)v2));
        }
        this._setShort(abstractByteBuf0, v, ((short)v2));
        return this;
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final ByteBuf writeChar(int v) {
        this.writeShort(v);
        return this;
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final ByteBuf writeDouble(double f) {
        this.writeLong(Double.doubleToRawLongBits(f));
        return this;
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final ByteBuf writeFloat(float f) {
        this.writeInt(Float.floatToRawIntBits(f));
        return this;
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final ByteBuf writeInt(int v) {
        this.wrapped.ensureWritable0(4);
        AbstractByteBuf abstractByteBuf0 = this.wrapped;
        int v1 = abstractByteBuf0.writerIndex;
        if(!this.nativeByteOrder) {
            v = Integer.reverseBytes(v);
        }
        this._setInt(abstractByteBuf0, v1, v);
        this.wrapped.writerIndex += 4;
        return this;
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final ByteBuf writeLong(long v) {
        this.wrapped.ensureWritable0(8);
        AbstractByteBuf abstractByteBuf0 = this.wrapped;
        int v1 = abstractByteBuf0.writerIndex;
        if(!this.nativeByteOrder) {
            v = Long.reverseBytes(v);
        }
        this._setLong(abstractByteBuf0, v1, v);
        this.wrapped.writerIndex += 8;
        return this;
    }

    @Override  // io.netty.buffer.SwappedByteBuf
    public final ByteBuf writeShort(int v) {
        this.wrapped.ensureWritable0(2);
        AbstractByteBuf abstractByteBuf0 = this.wrapped;
        int v1 = abstractByteBuf0.writerIndex;
        int v2 = (short)v;
        if(!this.nativeByteOrder) {
            v2 = Short.reverseBytes(((short)v2));
        }
        this._setShort(abstractByteBuf0, v1, ((short)v2));
        this.wrapped.writerIndex += 2;
        return this;
    }
}

