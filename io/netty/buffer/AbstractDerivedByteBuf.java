package io.netty.buffer;

import io.netty.util.ReferenceCounted;
import java.nio.ByteBuffer;

@Deprecated
public abstract class AbstractDerivedByteBuf extends AbstractByteBuf {
    public AbstractDerivedByteBuf(int v) {
        super(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int v, int v1) {
        return this.nioBuffer(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean isAccessible() {
        return this.isAccessible0();
    }

    public boolean isAccessible0() {
        return this.unwrap().isAccessible();
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isContiguous() {
        return this.unwrap().isContiguous();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public boolean isReadOnly() {
        return this.unwrap().isReadOnly();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        return this.unwrap().nioBuffer(v, v1);
    }

    @Override  // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.refCnt0();
    }

    public int refCnt0() {
        return this.unwrap().refCnt();
    }

    @Override  // io.netty.util.ReferenceCounted
    public final boolean release() {
        return this.release0();
    }

    @Override  // io.netty.util.ReferenceCounted
    public final boolean release(int v) {
        return this.release0(v);
    }

    public boolean release0() {
        return this.unwrap().release();
    }

    public boolean release0(int v) {
        return this.unwrap().release(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf retain() {
        return this.retain0();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf retain(int v) {
        return this.retain0(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    public ByteBuf retain0() {
        this.unwrap().retain();
        return this;
    }

    public ByteBuf retain0(int v) {
        this.unwrap().retain(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf touch() {
        return this.touch0();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf touch(Object object0) {
        return this.touch0(object0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }

    public ByteBuf touch0() {
        this.unwrap().touch();
        return this;
    }

    public ByteBuf touch0(Object object0) {
        this.unwrap().touch(object0);
        return this;
    }
}

