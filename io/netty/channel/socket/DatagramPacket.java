package io.netty.channel.socket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.util.ReferenceCounted;
import java.net.InetSocketAddress;

public class DatagramPacket extends DefaultAddressedEnvelope implements ByteBufHolder {
    public DatagramPacket(ByteBuf byteBuf0, InetSocketAddress inetSocketAddress0) {
        super(byteBuf0, inetSocketAddress0);
    }

    public DatagramPacket(ByteBuf byteBuf0, InetSocketAddress inetSocketAddress0, InetSocketAddress inetSocketAddress1) {
        super(byteBuf0, inetSocketAddress0, inetSocketAddress1);
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return (ByteBuf)super.content();
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder copy() {
        return this.copy();
    }

    public DatagramPacket copy() {
        return this.replace(((ByteBuf)this.content()).copy());
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder duplicate() {
        return this.duplicate();
    }

    public DatagramPacket duplicate() {
        return this.replace(((ByteBuf)this.content()).duplicate());
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder replace(ByteBuf byteBuf0) {
        return this.replace(byteBuf0);
    }

    public DatagramPacket replace(ByteBuf byteBuf0) {
        return new DatagramPacket(byteBuf0, ((InetSocketAddress)this.recipient()), ((InetSocketAddress)this.sender()));
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retain() {
        return this.retain();
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.channel.DefaultAddressedEnvelope
    public AddressedEnvelope retain() {
        return this.retain();
    }

    @Override  // io.netty.channel.DefaultAddressedEnvelope
    public AddressedEnvelope retain(int v) {
        return this.retain(v);
    }

    public DatagramPacket retain() {
        super.retain();
        return this;
    }

    public DatagramPacket retain(int v) {
        super.retain(v);
        return this;
    }

    @Override  // io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retainedDuplicate() {
        return this.retainedDuplicate();
    }

    public DatagramPacket retainedDuplicate() {
        return this.replace(((ByteBuf)this.content()).retainedDuplicate());
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder touch(Object object0) {
        return this.touch(object0);
    }

    @Override  // io.netty.channel.DefaultAddressedEnvelope
    public AddressedEnvelope touch() {
        return this.touch();
    }

    @Override  // io.netty.channel.DefaultAddressedEnvelope
    public AddressedEnvelope touch(Object object0) {
        return this.touch(object0);
    }

    public DatagramPacket touch() {
        super.touch();
        return this;
    }

    public DatagramPacket touch(Object object0) {
        super.touch(object0);
        return this;
    }

    @Override  // io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }
}

