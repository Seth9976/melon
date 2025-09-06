package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;

public class DefaultAddressedEnvelope implements AddressedEnvelope {
    private final Object message;
    private final SocketAddress recipient;
    private final SocketAddress sender;

    public DefaultAddressedEnvelope(Object object0, SocketAddress socketAddress0) {
        this(object0, socketAddress0, null);
    }

    public DefaultAddressedEnvelope(Object object0, SocketAddress socketAddress0, SocketAddress socketAddress1) {
        ObjectUtil.checkNotNull(object0, "message");
        if(socketAddress0 == null && socketAddress1 == null) {
            throw new NullPointerException("recipient and sender");
        }
        this.message = object0;
        this.sender = socketAddress1;
        this.recipient = socketAddress0;
    }

    @Override  // io.netty.channel.AddressedEnvelope
    public Object content() {
        return this.message;
    }

    @Override  // io.netty.channel.AddressedEnvelope
    public SocketAddress recipient() {
        return this.recipient;
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.message instanceof ReferenceCounted ? ((ReferenceCounted)this.message).refCnt() : 1;
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release() {
        return ReferenceCountUtil.release(this.message);
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release(int v) {
        return ReferenceCountUtil.release(this.message, v);
    }

    @Override  // io.netty.channel.AddressedEnvelope
    public AddressedEnvelope retain() {
        ReferenceCountUtil.retain(this.message);
        return this;
    }

    @Override  // io.netty.channel.AddressedEnvelope
    public AddressedEnvelope retain(int v) {
        ReferenceCountUtil.retain(this.message, v);
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

    @Override  // io.netty.channel.AddressedEnvelope
    public SocketAddress sender() {
        return this.sender;
    }

    @Override
    public String toString() {
        return this.sender == null ? StringUtil.simpleClassName(this) + "(=> " + this.recipient + ", " + this.message + ')' : StringUtil.simpleClassName(this) + '(' + this.sender + " => " + this.recipient + ", " + this.message + ')';
    }

    @Override  // io.netty.channel.AddressedEnvelope
    public AddressedEnvelope touch() {
        ReferenceCountUtil.touch(this.message);
        return this;
    }

    @Override  // io.netty.channel.AddressedEnvelope
    public AddressedEnvelope touch(Object object0) {
        ReferenceCountUtil.touch(this.message, object0);
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

