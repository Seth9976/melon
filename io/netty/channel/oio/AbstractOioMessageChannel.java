package io.netty.channel.oio;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.RecvByteBufAllocator.Handle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class AbstractOioMessageChannel extends AbstractOioChannel {
    private final List readBuf;

    public AbstractOioMessageChannel(Channel channel0) {
        super(channel0);
        this.readBuf = new ArrayList();
    }

    @Override  // io.netty.channel.oio.AbstractOioChannel
    public void doRead() {
        Throwable throwable1;
        int v1;
        if(this.readPending) {
            int v = 0;
            boolean z = false;
            this.readPending = false;
            ChannelConfig channelConfig0 = this.config();
            ChannelPipeline channelPipeline0 = this.pipeline();
            Handle recvByteBufAllocator$Handle0 = this.unsafe().recvBufAllocHandle();
            recvByteBufAllocator$Handle0.reset(channelConfig0);
            try {
                do {
                    v1 = 1;
                    int v2 = this.doReadMessages(this.readBuf);
                    if(v2 == 0) {
                        break;
                    }
                    if(v2 < 0) {
                        goto label_15;
                    }
                    recvByteBufAllocator$Handle0.incMessagesRead(v2);
                }
                while(recvByteBufAllocator$Handle0.continueReading());
                goto label_20;
            label_15:
                v = 1;
            }
            catch(Throwable throwable0) {
                throwable1 = throwable0;
                goto label_21;
            }
        label_20:
            throwable1 = null;
        label_21:
            int v3 = this.readBuf.size();
            if(v3 > 0) {
                for(int v4 = 0; v4 < v3; ++v4) {
                    this.readPending = false;
                    channelPipeline0.fireChannelRead(this.readBuf.get(v4));
                }
                this.readBuf.clear();
                recvByteBufAllocator$Handle0.readComplete();
                channelPipeline0.fireChannelReadComplete();
                z = true;
            }
            if(throwable1 != null) {
                if(!(throwable1 instanceof IOException)) {
                    v1 = v;
                }
                channelPipeline0.fireExceptionCaught(throwable1);
                v = v1;
            }
            if(v != 0) {
                if(this.isOpen()) {
                    this.unsafe().close(this.unsafe().voidPromise());
                }
            }
            else if(this.readPending || channelConfig0.isAutoRead() || !z && this.isActive()) {
                this.read();
            }
        }
    }

    public abstract int doReadMessages(List arg1);
}

