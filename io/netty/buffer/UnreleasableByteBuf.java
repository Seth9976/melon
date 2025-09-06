package io.netty.buffer;

import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;

final class UnreleasableByteBuf extends WrappedByteBuf {
    private SwappedByteBuf swappedBuf;

    public UnreleasableByteBuf(ByteBuf byteBuf0) {
        if(byteBuf0 instanceof UnreleasableByteBuf) {
            byteBuf0 = byteBuf0.unwrap();
        }
        super(byteBuf0);
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf asReadOnly() {
        return this.buf.isReadOnly() ? this : new UnreleasableByteBuf(this.buf.asReadOnly());
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf duplicate() {
        return new UnreleasableByteBuf(this.buf.duplicate());
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf order(ByteOrder byteOrder0) {
        if(ObjectUtil.checkNotNull(byteOrder0, "endianness") == this.order()) {
            return this;
        }
        SwappedByteBuf swappedByteBuf0 = this.swappedBuf;
        if(swappedByteBuf0 == null) {
            swappedByteBuf0 = new SwappedByteBuf(this);
            this.swappedBuf = swappedByteBuf0;
        }
        return swappedByteBuf0;
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf readRetainedSlice(int v) {
        return this.readSlice(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf readSlice(int v) {
        return new UnreleasableByteBuf(this.buf.readSlice(v));
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public boolean release() {
        return false;
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public boolean release(int v) {
        return false;
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf retain() [...] // Inlined contents

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf retain(int v) [...] // Inlined contents

    @Override  // io.netty.buffer.WrappedByteBuf
    public ReferenceCounted retain() {
        return this;
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ReferenceCounted retain(int v) {
        return this;
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf retainedDuplicate() {
        return this.duplicate();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf retainedSlice() {
        return this.slice();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf retainedSlice(int v, int v1) {
        return this.slice(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf slice() {
        return new UnreleasableByteBuf(this.buf.slice());
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf slice(int v, int v1) {
        return new UnreleasableByteBuf(this.buf.slice(v, v1));
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf touch() [...] // Inlined contents

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf touch(Object object0) [...] // Inlined contents

    @Override  // io.netty.buffer.WrappedByteBuf
    public ReferenceCounted touch() {
        return this;
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ReferenceCounted touch(Object object0) {
        return this;
    }
}

