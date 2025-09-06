package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;

public final class CoalescingBufferQueue extends AbstractCoalescingBufferQueue {
    private final Channel channel;

    public CoalescingBufferQueue(Channel channel0) {
        this(channel0, 4);
    }

    public CoalescingBufferQueue(Channel channel0, int v) {
        this(channel0, v, false);
    }

    public CoalescingBufferQueue(Channel channel0, int v, boolean z) {
        super((z ? channel0 : null), v);
        this.channel = (Channel)ObjectUtil.checkNotNull(channel0, "channel");
    }

    @Override  // io.netty.channel.AbstractCoalescingBufferQueue
    public ByteBuf compose(ByteBufAllocator byteBufAllocator0, ByteBuf byteBuf0, ByteBuf byteBuf1) {
        if(byteBuf0 instanceof CompositeByteBuf) {
            ((CompositeByteBuf)byteBuf0).addComponent(true, byteBuf1);
            return (CompositeByteBuf)byteBuf0;
        }
        return this.composeIntoComposite(byteBufAllocator0, byteBuf0, byteBuf1);
    }

    public void releaseAndFailAll(Throwable throwable0) {
        this.releaseAndFailAll(this.channel, throwable0);
    }

    public ByteBuf remove(int v, ChannelPromise channelPromise0) {
        return this.remove(this.channel.alloc(), v, channelPromise0);
    }

    @Override  // io.netty.channel.AbstractCoalescingBufferQueue
    public ByteBuf removeEmptyValue() {
        return Unpooled.EMPTY_BUFFER;
    }
}

