package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

abstract class PendingBytesTracker implements Handle {
    static final class ChannelOutboundBufferPendingBytesTracker extends PendingBytesTracker {
        private final ChannelOutboundBuffer buffer;

        public ChannelOutboundBufferPendingBytesTracker(ChannelOutboundBuffer channelOutboundBuffer0, Handle messageSizeEstimator$Handle0) {
            super(messageSizeEstimator$Handle0, null);
            this.buffer = channelOutboundBuffer0;
        }

        @Override  // io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long v) {
            this.buffer.decrementPendingOutboundBytes(v);
        }

        @Override  // io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long v) {
            this.buffer.incrementPendingOutboundBytes(v);
        }
    }

    static final class DefaultChannelPipelinePendingBytesTracker extends PendingBytesTracker {
        private final DefaultChannelPipeline pipeline;

        public DefaultChannelPipelinePendingBytesTracker(DefaultChannelPipeline defaultChannelPipeline0) {
            super(defaultChannelPipeline0.estimatorHandle(), null);
            this.pipeline = defaultChannelPipeline0;
        }

        @Override  // io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long v) {
            this.pipeline.decrementPendingOutboundBytes(v);
        }

        @Override  // io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long v) {
            this.pipeline.incrementPendingOutboundBytes(v);
        }
    }

    static final class NoopPendingBytesTracker extends PendingBytesTracker {
        public NoopPendingBytesTracker(Handle messageSizeEstimator$Handle0) {
            super(messageSizeEstimator$Handle0, null);
        }

        @Override  // io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long v) {
        }

        @Override  // io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long v) {
        }
    }

    private final Handle estimatorHandle;

    private PendingBytesTracker(Handle messageSizeEstimator$Handle0) {
        this.estimatorHandle = (Handle)ObjectUtil.checkNotNull(messageSizeEstimator$Handle0, "estimatorHandle");
    }

    public PendingBytesTracker(Handle messageSizeEstimator$Handle0, io.netty.channel.PendingBytesTracker.1 pendingBytesTracker$10) {
        this(messageSizeEstimator$Handle0);
    }

    public abstract void decrementPendingOutboundBytes(long arg1);

    public abstract void incrementPendingOutboundBytes(long arg1);

    public static PendingBytesTracker newTracker(Channel channel0) {
        if(channel0.pipeline() instanceof DefaultChannelPipeline) {
            return new DefaultChannelPipelinePendingBytesTracker(((DefaultChannelPipeline)channel0.pipeline()));
        }
        ChannelOutboundBuffer channelOutboundBuffer0 = channel0.unsafe().outboundBuffer();
        Handle messageSizeEstimator$Handle0 = channel0.config().getMessageSizeEstimator().newHandle();
        return channelOutboundBuffer0 == null ? new NoopPendingBytesTracker(messageSizeEstimator$Handle0) : new ChannelOutboundBufferPendingBytesTracker(channelOutboundBuffer0, messageSizeEstimator$Handle0);
    }

    @Override  // io.netty.channel.MessageSizeEstimator$Handle
    public final int size(Object object0) {
        return this.estimatorHandle.size(object0);
    }

    class io.netty.channel.PendingBytesTracker.1 {
    }

}

