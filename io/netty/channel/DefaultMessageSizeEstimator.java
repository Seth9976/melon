package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.util.internal.ObjectUtil;

public final class DefaultMessageSizeEstimator implements MessageSizeEstimator {
    static final class HandleImpl implements Handle {
        private final int unknownSize;

        private HandleImpl(int v) {
            this.unknownSize = v;
        }

        public HandleImpl(int v, io.netty.channel.DefaultMessageSizeEstimator.1 defaultMessageSizeEstimator$10) {
            this(v);
        }

        @Override  // io.netty.channel.MessageSizeEstimator$Handle
        public int size(Object object0) {
            if(object0 instanceof ByteBuf) {
                return ((ByteBuf)object0).readableBytes();
            }
            if(object0 instanceof ByteBufHolder) {
                return ((ByteBufHolder)object0).content().readableBytes();
            }
            return object0 instanceof FileRegion ? 0 : this.unknownSize;
        }
    }

    public static final MessageSizeEstimator DEFAULT;
    private final Handle handle;

    static {
        DefaultMessageSizeEstimator.DEFAULT = new DefaultMessageSizeEstimator(8);
    }

    public DefaultMessageSizeEstimator(int v) {
        ObjectUtil.checkPositiveOrZero(v, "unknownSize");
        this.handle = new HandleImpl(v, null);
    }

    @Override  // io.netty.channel.MessageSizeEstimator
    public Handle newHandle() {
        return this.handle;
    }

    class io.netty.channel.DefaultMessageSizeEstimator.1 {
    }

}

