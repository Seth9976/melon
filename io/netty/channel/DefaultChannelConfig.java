package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.util.IdentityHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DefaultChannelConfig implements ChannelConfig {
    private static final AtomicIntegerFieldUpdater AUTOREAD_UPDATER = null;
    private static final int DEFAULT_CONNECT_TIMEOUT = 30000;
    private static final MessageSizeEstimator DEFAULT_MSG_SIZE_ESTIMATOR;
    private static final AtomicReferenceFieldUpdater WATERMARK_UPDATER;
    private volatile ByteBufAllocator allocator;
    private volatile boolean autoClose;
    private volatile int autoRead;
    protected final Channel channel;
    private volatile int connectTimeoutMillis;
    private volatile int maxMessagesPerWrite;
    private volatile MessageSizeEstimator msgSizeEstimator;
    private volatile boolean pinEventExecutor;
    private volatile RecvByteBufAllocator rcvBufAllocator;
    private volatile WriteBufferWaterMark writeBufferWaterMark;
    private volatile int writeSpinCount;

    static {
        DefaultChannelConfig.DEFAULT_MSG_SIZE_ESTIMATOR = DefaultMessageSizeEstimator.DEFAULT;
        DefaultChannelConfig.AUTOREAD_UPDATER = AtomicIntegerFieldUpdater.newUpdater(DefaultChannelConfig.class, "autoRead");
        DefaultChannelConfig.WATERMARK_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultChannelConfig.class, WriteBufferWaterMark.class, "writeBufferWaterMark");
    }

    public DefaultChannelConfig(Channel channel0) {
        this(channel0, new AdaptiveRecvByteBufAllocator());
    }

    public DefaultChannelConfig(Channel channel0, RecvByteBufAllocator recvByteBufAllocator0) {
        this.allocator = ByteBufAllocator.DEFAULT;
        this.msgSizeEstimator = DefaultChannelConfig.DEFAULT_MSG_SIZE_ESTIMATOR;
        this.connectTimeoutMillis = 30000;
        this.writeSpinCount = 16;
        this.maxMessagesPerWrite = 0x7FFFFFFF;
        this.autoRead = 1;
        this.autoClose = true;
        this.writeBufferWaterMark = WriteBufferWaterMark.DEFAULT;
        this.pinEventExecutor = true;
        this.setRecvByteBufAllocator(recvByteBufAllocator0, channel0.metadata());
        this.channel = channel0;
    }

    public void autoReadCleared() {
    }

    @Override  // io.netty.channel.ChannelConfig
    public ByteBufAllocator getAllocator() {
        return this.allocator;
    }

    @Override  // io.netty.channel.ChannelConfig
    public int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override  // io.netty.channel.ChannelConfig
    @Deprecated
    public int getMaxMessagesPerRead() {
        try {
            return ((MaxMessagesRecvByteBufAllocator)this.getRecvByteBufAllocator()).maxMessagesPerRead();
        }
        catch(ClassCastException classCastException0) {
            throw new IllegalStateException("getRecvByteBufAllocator() must return an object of type MaxMessagesRecvByteBufAllocator", classCastException0);
        }
    }

    public int getMaxMessagesPerWrite() {
        return this.maxMessagesPerWrite;
    }

    @Override  // io.netty.channel.ChannelConfig
    public MessageSizeEstimator getMessageSizeEstimator() {
        return this.msgSizeEstimator;
    }

    @Override  // io.netty.channel.ChannelConfig
    public Object getOption(ChannelOption channelOption0) {
        ObjectUtil.checkNotNull(channelOption0, "option");
        if(channelOption0 == ChannelOption.CONNECT_TIMEOUT_MILLIS) {
            return this.getConnectTimeoutMillis();
        }
        if(channelOption0 == ChannelOption.MAX_MESSAGES_PER_READ) {
            return this.getMaxMessagesPerRead();
        }
        if(channelOption0 == ChannelOption.WRITE_SPIN_COUNT) {
            return this.getWriteSpinCount();
        }
        if(channelOption0 == ChannelOption.ALLOCATOR) {
            return this.getAllocator();
        }
        if(channelOption0 == ChannelOption.RCVBUF_ALLOCATOR) {
            return this.getRecvByteBufAllocator();
        }
        if(channelOption0 == ChannelOption.AUTO_READ) {
            return Boolean.valueOf(this.isAutoRead());
        }
        if(channelOption0 == ChannelOption.AUTO_CLOSE) {
            return Boolean.valueOf(this.isAutoClose());
        }
        if(channelOption0 == ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK) {
            return this.getWriteBufferHighWaterMark();
        }
        if(channelOption0 == ChannelOption.WRITE_BUFFER_LOW_WATER_MARK) {
            return this.getWriteBufferLowWaterMark();
        }
        if(channelOption0 == ChannelOption.WRITE_BUFFER_WATER_MARK) {
            return this.getWriteBufferWaterMark();
        }
        if(channelOption0 == ChannelOption.MESSAGE_SIZE_ESTIMATOR) {
            return this.getMessageSizeEstimator();
        }
        if(channelOption0 == ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP) {
            return Boolean.valueOf(this.getPinEventExecutorPerGroup());
        }
        return channelOption0 == ChannelOption.MAX_MESSAGES_PER_WRITE ? this.getMaxMessagesPerWrite() : null;
    }

    @Override  // io.netty.channel.ChannelConfig
    public Map getOptions() {
        return this.getOptions(null, new ChannelOption[]{ChannelOption.CONNECT_TIMEOUT_MILLIS, ChannelOption.MAX_MESSAGES_PER_READ, ChannelOption.WRITE_SPIN_COUNT, ChannelOption.ALLOCATOR, ChannelOption.AUTO_READ, ChannelOption.AUTO_CLOSE, ChannelOption.RCVBUF_ALLOCATOR, ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK, ChannelOption.WRITE_BUFFER_LOW_WATER_MARK, ChannelOption.WRITE_BUFFER_WATER_MARK, ChannelOption.MESSAGE_SIZE_ESTIMATOR, ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP, ChannelOption.MAX_MESSAGES_PER_WRITE});
    }

    public Map getOptions(Map map0, ChannelOption[] arr_channelOption) {
        if(map0 == null) {
            map0 = new IdentityHashMap();
        }
        for(int v = 0; v < arr_channelOption.length; ++v) {
            ChannelOption channelOption0 = arr_channelOption[v];
            map0.put(channelOption0, this.getOption(channelOption0));
        }
        return map0;
    }

    private boolean getPinEventExecutorPerGroup() {
        return this.pinEventExecutor;
    }

    @Override  // io.netty.channel.ChannelConfig
    public RecvByteBufAllocator getRecvByteBufAllocator() {
        return this.rcvBufAllocator;
    }

    @Override  // io.netty.channel.ChannelConfig
    public int getWriteBufferHighWaterMark() {
        return this.writeBufferWaterMark.high();
    }

    @Override  // io.netty.channel.ChannelConfig
    public int getWriteBufferLowWaterMark() {
        return this.writeBufferWaterMark.low();
    }

    @Override  // io.netty.channel.ChannelConfig
    public WriteBufferWaterMark getWriteBufferWaterMark() {
        return this.writeBufferWaterMark;
    }

    @Override  // io.netty.channel.ChannelConfig
    public int getWriteSpinCount() {
        return this.writeSpinCount;
    }

    @Override  // io.netty.channel.ChannelConfig
    public boolean isAutoClose() {
        return this.autoClose;
    }

    @Override  // io.netty.channel.ChannelConfig
    public boolean isAutoRead() {
        return this.autoRead == 1;
    }

    @Override  // io.netty.channel.ChannelConfig
    public ChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        this.allocator = (ByteBufAllocator)ObjectUtil.checkNotNull(byteBufAllocator0, "allocator");
        return this;
    }

    @Override  // io.netty.channel.ChannelConfig
    public ChannelConfig setAutoClose(boolean z) {
        this.autoClose = z;
        return this;
    }

    @Override  // io.netty.channel.ChannelConfig
    public ChannelConfig setAutoRead(boolean z) {
        boolean z1 = DefaultChannelConfig.AUTOREAD_UPDATER.getAndSet(this, ((int)z)) == 1;
        if(z && !z1) {
            this.channel.read();
            return this;
        }
        if(!z && z1) {
            this.autoReadCleared();
        }
        return this;
    }

    @Override  // io.netty.channel.ChannelConfig
    public ChannelConfig setConnectTimeoutMillis(int v) {
        ObjectUtil.checkPositiveOrZero(v, "connectTimeoutMillis");
        this.connectTimeoutMillis = v;
        return this;
    }

    @Override  // io.netty.channel.ChannelConfig
    @Deprecated
    public ChannelConfig setMaxMessagesPerRead(int v) {
        try {
            ((MaxMessagesRecvByteBufAllocator)this.getRecvByteBufAllocator()).maxMessagesPerRead(v);
            return this;
        }
        catch(ClassCastException classCastException0) {
            throw new IllegalStateException("getRecvByteBufAllocator() must return an object of type MaxMessagesRecvByteBufAllocator", classCastException0);
        }
    }

    public ChannelConfig setMaxMessagesPerWrite(int v) {
        this.maxMessagesPerWrite = ObjectUtil.checkPositive(v, "maxMessagesPerWrite");
        return this;
    }

    @Override  // io.netty.channel.ChannelConfig
    public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        this.msgSizeEstimator = (MessageSizeEstimator)ObjectUtil.checkNotNull(messageSizeEstimator0, "estimator");
        return this;
    }

    @Override  // io.netty.channel.ChannelConfig
    public boolean setOption(ChannelOption channelOption0, Object object0) {
        this.validate(channelOption0, object0);
        if(channelOption0 == ChannelOption.CONNECT_TIMEOUT_MILLIS) {
            this.setConnectTimeoutMillis(((int)(((Integer)object0))));
            return true;
        }
        if(channelOption0 == ChannelOption.MAX_MESSAGES_PER_READ) {
            this.setMaxMessagesPerRead(((int)(((Integer)object0))));
            return true;
        }
        if(channelOption0 == ChannelOption.WRITE_SPIN_COUNT) {
            this.setWriteSpinCount(((int)(((Integer)object0))));
            return true;
        }
        if(channelOption0 == ChannelOption.ALLOCATOR) {
            this.setAllocator(((ByteBufAllocator)object0));
            return true;
        }
        if(channelOption0 == ChannelOption.RCVBUF_ALLOCATOR) {
            this.setRecvByteBufAllocator(((RecvByteBufAllocator)object0));
            return true;
        }
        if(channelOption0 == ChannelOption.AUTO_READ) {
            this.setAutoRead(((Boolean)object0).booleanValue());
            return true;
        }
        if(channelOption0 == ChannelOption.AUTO_CLOSE) {
            this.setAutoClose(((Boolean)object0).booleanValue());
            return true;
        }
        if(channelOption0 == ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK) {
            this.setWriteBufferHighWaterMark(((int)(((Integer)object0))));
            return true;
        }
        if(channelOption0 == ChannelOption.WRITE_BUFFER_LOW_WATER_MARK) {
            this.setWriteBufferLowWaterMark(((int)(((Integer)object0))));
            return true;
        }
        if(channelOption0 == ChannelOption.WRITE_BUFFER_WATER_MARK) {
            this.setWriteBufferWaterMark(((WriteBufferWaterMark)object0));
            return true;
        }
        if(channelOption0 == ChannelOption.MESSAGE_SIZE_ESTIMATOR) {
            this.setMessageSizeEstimator(((MessageSizeEstimator)object0));
            return true;
        }
        if(channelOption0 == ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP) {
            this.setPinEventExecutorPerGroup(((Boolean)object0).booleanValue());
            return true;
        }
        if(channelOption0 == ChannelOption.MAX_MESSAGES_PER_WRITE) {
            this.setMaxMessagesPerWrite(((int)(((Integer)object0))));
            return true;
        }
        return false;
    }

    @Override  // io.netty.channel.ChannelConfig
    public boolean setOptions(Map map0) {
        ObjectUtil.checkNotNull(map0, "options");
        boolean z = true;
        for(Object object0: map0.entrySet()) {
            if(!this.setOption(((ChannelOption)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue())) {
                z = false;
            }
        }
        return z;
    }

    private ChannelConfig setPinEventExecutorPerGroup(boolean z) {
        this.pinEventExecutor = z;
        return this;
    }

    private void setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0, ChannelMetadata channelMetadata0) {
        ObjectUtil.checkNotNull(recvByteBufAllocator0, "allocator");
        ObjectUtil.checkNotNull(channelMetadata0, "metadata");
        if(recvByteBufAllocator0 instanceof MaxMessagesRecvByteBufAllocator) {
            ((MaxMessagesRecvByteBufAllocator)recvByteBufAllocator0).maxMessagesPerRead(channelMetadata0.defaultMaxMessagesPerRead());
        }
        this.setRecvByteBufAllocator(recvByteBufAllocator0);
    }

    @Override  // io.netty.channel.ChannelConfig
    public ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        this.rcvBufAllocator = (RecvByteBufAllocator)ObjectUtil.checkNotNull(recvByteBufAllocator0, "allocator");
        return this;
    }

    @Override  // io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferHighWaterMark(int v) {
        WriteBufferWaterMark writeBufferWaterMark0;
        ObjectUtil.checkPositiveOrZero(v, "writeBufferHighWaterMark");
        while(true) {
            writeBufferWaterMark0 = this.writeBufferWaterMark;
            if(v < writeBufferWaterMark0.low()) {
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DefaultChannelConfig.WATERMARK_UPDATER;
            WriteBufferWaterMark writeBufferWaterMark1 = new WriteBufferWaterMark(writeBufferWaterMark0.low(), v, false);
            do {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, writeBufferWaterMark0, writeBufferWaterMark1)) {
                    return this;
                }
            }
            while(atomicReferenceFieldUpdater0.get(this) == writeBufferWaterMark0);
        }
        throw new IllegalArgumentException("writeBufferHighWaterMark cannot be less than writeBufferLowWaterMark (" + writeBufferWaterMark0.low() + "): " + v);
    }

    @Override  // io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferLowWaterMark(int v) {
        WriteBufferWaterMark writeBufferWaterMark0;
        ObjectUtil.checkPositiveOrZero(v, "writeBufferLowWaterMark");
        while(true) {
            writeBufferWaterMark0 = this.writeBufferWaterMark;
            if(v > writeBufferWaterMark0.high()) {
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DefaultChannelConfig.WATERMARK_UPDATER;
            WriteBufferWaterMark writeBufferWaterMark1 = new WriteBufferWaterMark(v, writeBufferWaterMark0.high(), false);
            do {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, writeBufferWaterMark0, writeBufferWaterMark1)) {
                    return this;
                }
            }
            while(atomicReferenceFieldUpdater0.get(this) == writeBufferWaterMark0);
        }
        throw new IllegalArgumentException("writeBufferLowWaterMark cannot be greater than writeBufferHighWaterMark (" + writeBufferWaterMark0.high() + "): " + v);
    }

    @Override  // io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        this.writeBufferWaterMark = (WriteBufferWaterMark)ObjectUtil.checkNotNull(writeBufferWaterMark0, "writeBufferWaterMark");
        return this;
    }

    @Override  // io.netty.channel.ChannelConfig
    public ChannelConfig setWriteSpinCount(int v) {
        ObjectUtil.checkPositive(v, "writeSpinCount");
        if(v == 0x7FFFFFFF) {
            v = 0x7FFFFFFE;
        }
        this.writeSpinCount = v;
        return this;
    }

    public void validate(ChannelOption channelOption0, Object object0) {
        ((ChannelOption)ObjectUtil.checkNotNull(channelOption0, "option")).validate(object0);
    }
}

