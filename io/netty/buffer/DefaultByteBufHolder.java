package io.netty.buffer;

import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultByteBufHolder implements ByteBufHolder {
    private final ByteBuf data;

    public DefaultByteBufHolder(ByteBuf byteBuf0) {
        this.data = (ByteBuf)ObjectUtil.checkNotNull(byteBuf0, "data");
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return ByteBufUtil.ensureAccessible(this.data);
    }

    public final String contentToString() {
        return this.data.toString();
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder copy() {
        return this.replace(this.data.copy());
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder duplicate() {
        return this.replace(this.data.duplicate());
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 == null || this.getClass() != object0.getClass() ? false : this.data.equals(((DefaultByteBufHolder)object0).data);
    }

    @Override
    public int hashCode() {
        return this.data.hashCode();
    }

    @Override  // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.data.refCnt();
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.data.release();
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release(int v) {
        return this.data.release(v);
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder replace(ByteBuf byteBuf0) {
        return new DefaultByteBufHolder(byteBuf0);
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retain() {
        this.data.retain();
        return this;
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retain(int v) {
        this.data.retain(v);
        return this;
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retainedDuplicate() {
        return this.replace(this.data.retainedDuplicate());
    }

    @Override
    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + this.contentToString() + ')';
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder touch() {
        this.data.touch();
        return this;
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder touch(Object object0) {
        this.data.touch(object0);
        return this;
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }
}

