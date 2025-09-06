package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;

class PemValue extends AbstractReferenceCounted implements PemEncoded {
    private final ByteBuf content;
    private final boolean sensitive;

    public PemValue(ByteBuf byteBuf0, boolean z) {
        this.content = (ByteBuf)ObjectUtil.checkNotNull(byteBuf0, "content");
        this.sensitive = z;
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        int v = this.refCnt();
        if(v <= 0) {
            throw new IllegalReferenceCountException(v);
        }
        return this.content;
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder copy() {
        return this.copy();
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded copy() {
        return this.copy();
    }

    public PemValue copy() {
        return this.replace(this.content.copy());
    }

    @Override  // io.netty.util.AbstractReferenceCounted
    public void deallocate() {
        if(this.sensitive) {
            SslUtils.zeroout(this.content);
        }
        this.content.release();
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder duplicate() {
        return this.duplicate();
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded duplicate() {
        return this.duplicate();
    }

    public PemValue duplicate() {
        return this.replace(this.content.duplicate());
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public boolean isSensitive() {
        return this.sensitive;
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder replace(ByteBuf byteBuf0) {
        return this.replace(byteBuf0);
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded replace(ByteBuf byteBuf0) {
        return this.replace(byteBuf0);
    }

    public PemValue replace(ByteBuf byteBuf0) {
        return new PemValue(byteBuf0, this.sensitive);
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retain() {
        return this.retain();
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded retain() {
        return this.retain();
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded retain(int v) {
        return this.retain(v);
    }

    public PemValue retain() {
        return (PemValue)super.retain();
    }

    public PemValue retain(int v) {
        return (PemValue)super.retain(v);
    }

    @Override  // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retainedDuplicate() {
        return this.retainedDuplicate();
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded retainedDuplicate() {
        return this.retainedDuplicate();
    }

    public PemValue retainedDuplicate() {
        return this.replace(this.content.retainedDuplicate());
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder touch(Object object0) {
        return this.touch(object0);
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded touch() {
        return this.touch();
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded touch(Object object0) {
        return this.touch(object0);
    }

    public PemValue touch() {
        return (PemValue)super.touch();
    }

    public PemValue touch(Object object0) {
        this.content.touch(object0);
        return this;
    }

    @Override  // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }
}

