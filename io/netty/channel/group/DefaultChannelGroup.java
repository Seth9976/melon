package io.netty.channel.group;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelId;
import io.netty.channel.ServerChannel;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultChannelGroup extends AbstractSet implements ChannelGroup {
    private volatile boolean closed;
    private final EventExecutor executor;
    private final String name;
    private static final AtomicInteger nextId;
    private final ConcurrentMap nonServerChannels;
    private final ChannelFutureListener remover;
    private final ConcurrentMap serverChannels;
    private final boolean stayClosed;
    private final VoidChannelGroupFuture voidFuture;

    static {
        DefaultChannelGroup.nextId = new AtomicInteger();
    }

    public DefaultChannelGroup(EventExecutor eventExecutor0) {
        this(eventExecutor0, false);
    }

    // 去混淆评级： 低(20)
    public DefaultChannelGroup(EventExecutor eventExecutor0, boolean z) {
        this("group-0x1", eventExecutor0, z);
    }

    public DefaultChannelGroup(String s, EventExecutor eventExecutor0) {
        this(s, eventExecutor0, false);
    }

    public DefaultChannelGroup(String s, EventExecutor eventExecutor0, boolean z) {
        this.serverChannels = PlatformDependent.newConcurrentHashMap();
        this.nonServerChannels = PlatformDependent.newConcurrentHashMap();
        this.remover = new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                Channel channel0 = channelFuture0.channel();
                DefaultChannelGroup.this.remove(channel0);
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        };
        this.voidFuture = new VoidChannelGroupFuture(this);
        ObjectUtil.checkNotNull(s, "name");
        this.name = s;
        this.executor = eventExecutor0;
        this.stayClosed = z;
    }

    public boolean add(Channel channel0) {
        boolean z = (channel0 instanceof ServerChannel ? this.serverChannels : this.nonServerChannels).putIfAbsent(channel0.id(), channel0) == null;
        if(z) {
            channel0.closeFuture().addListener(this.remover);
        }
        if(this.stayClosed && this.closed) {
            channel0.close();
        }
        return z;
    }

    @Override
    public boolean add(Object object0) {
        return this.add(((Channel)object0));
    }

    @Override
    public void clear() {
        this.nonServerChannels.clear();
        this.serverChannels.clear();
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture close() {
        return this.close(ChannelMatchers.all());
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture close(ChannelMatcher channelMatcher0) {
        ObjectUtil.checkNotNull(channelMatcher0, "matcher");
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(this.size());
        if(this.stayClosed) {
            this.closed = true;
        }
        for(Object object0: this.serverChannels.values()) {
            Channel channel0 = (Channel)object0;
            if(channelMatcher0.matches(channel0)) {
                linkedHashMap0.put(channel0, channel0.close());
            }
        }
        for(Object object1: this.nonServerChannels.values()) {
            Channel channel1 = (Channel)object1;
            if(channelMatcher0.matches(channel1)) {
                linkedHashMap0.put(channel1, channel1.close());
            }
        }
        return new DefaultChannelGroupFuture(this, linkedHashMap0, this.executor);
    }

    public int compareTo(ChannelGroup channelGroup0) {
        int v = this.name().compareTo(channelGroup0.name());
        return v == 0 ? System.identityHashCode(this) - System.identityHashCode(channelGroup0) : v;
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((ChannelGroup)object0));
    }

    @Override
    public boolean contains(Object object0) {
        if(object0 instanceof ServerChannel) {
            return this.serverChannels.containsValue(object0);
        }
        return object0 instanceof Channel ? this.nonServerChannels.containsValue(object0) : false;
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture deregister() {
        return this.deregister(ChannelMatchers.all());
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture deregister(ChannelMatcher channelMatcher0) {
        ObjectUtil.checkNotNull(channelMatcher0, "matcher");
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(this.size());
        for(Object object0: this.serverChannels.values()) {
            Channel channel0 = (Channel)object0;
            if(channelMatcher0.matches(channel0)) {
                linkedHashMap0.put(channel0, channel0.deregister());
            }
        }
        for(Object object1: this.nonServerChannels.values()) {
            Channel channel1 = (Channel)object1;
            if(channelMatcher0.matches(channel1)) {
                linkedHashMap0.put(channel1, channel1.deregister());
            }
        }
        return new DefaultChannelGroupFuture(this, linkedHashMap0, this.executor);
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture disconnect() {
        return this.disconnect(ChannelMatchers.all());
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture disconnect(ChannelMatcher channelMatcher0) {
        ObjectUtil.checkNotNull(channelMatcher0, "matcher");
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(this.size());
        for(Object object0: this.serverChannels.values()) {
            Channel channel0 = (Channel)object0;
            if(channelMatcher0.matches(channel0)) {
                linkedHashMap0.put(channel0, channel0.disconnect());
            }
        }
        for(Object object1: this.nonServerChannels.values()) {
            Channel channel1 = (Channel)object1;
            if(channelMatcher0.matches(channel1)) {
                linkedHashMap0.put(channel1, channel1.disconnect());
            }
        }
        return new DefaultChannelGroupFuture(this, linkedHashMap0, this.executor);
    }

    @Override
    public boolean equals(Object object0) {
        return this == object0;
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public Channel find(ChannelId channelId0) {
        Channel channel0 = (Channel)this.nonServerChannels.get(channelId0);
        return channel0 == null ? ((Channel)this.serverChannels.get(channelId0)) : channel0;
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroup flush() {
        return this.flush(ChannelMatchers.all());
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroup flush(ChannelMatcher channelMatcher0) {
        for(Object object0: this.nonServerChannels.values()) {
            Channel channel0 = (Channel)object0;
            if(channelMatcher0.matches(channel0)) {
                channel0.flush();
            }
        }
        return this;
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture flushAndWrite(Object object0) {
        return this.writeAndFlush(object0);
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture flushAndWrite(Object object0, ChannelMatcher channelMatcher0) {
        return this.writeAndFlush(object0, channelMatcher0);
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean isEmpty() {
        return this.nonServerChannels.isEmpty() && this.serverChannels.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new CombinedIterator(this.serverChannels.values().iterator(), this.nonServerChannels.values().iterator());
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public String name() {
        return this.name;
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture newCloseFuture() {
        return this.newCloseFuture(ChannelMatchers.all());
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture newCloseFuture(ChannelMatcher channelMatcher0) {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(this.size());
        for(Object object0: this.serverChannels.values()) {
            Channel channel0 = (Channel)object0;
            if(channelMatcher0.matches(channel0)) {
                linkedHashMap0.put(channel0, channel0.closeFuture());
            }
        }
        for(Object object1: this.nonServerChannels.values()) {
            Channel channel1 = (Channel)object1;
            if(channelMatcher0.matches(channel1)) {
                linkedHashMap0.put(channel1, channel1.closeFuture());
            }
        }
        return new DefaultChannelGroupFuture(this, linkedHashMap0, this.executor);
    }

    @Override
    public boolean remove(Object object0) {
        Channel channel0;
        if(object0 instanceof ChannelId) {
            channel0 = (Channel)this.nonServerChannels.remove(object0);
            if(channel0 == null) {
                channel0 = (Channel)this.serverChannels.remove(object0);
            }
        }
        else if(!(object0 instanceof Channel)) {
            channel0 = null;
        }
        else if(((Channel)object0) instanceof ServerChannel) {
            ChannelId channelId0 = ((Channel)object0).id();
            channel0 = (Channel)this.serverChannels.remove(channelId0);
        }
        else {
            ChannelId channelId1 = ((Channel)object0).id();
            channel0 = (Channel)this.nonServerChannels.remove(channelId1);
        }
        if(channel0 == null) {
            return false;
        }
        channel0.closeFuture().removeListener(this.remover);
        return true;
    }

    private static Object safeDuplicate(Object object0) {
        if(object0 instanceof ByteBuf) {
            return ((ByteBuf)object0).retainedDuplicate();
        }
        return object0 instanceof ByteBufHolder ? ((ByteBufHolder)object0).retainedDuplicate() : ReferenceCountUtil.retain(object0);
    }

    @Override
    public int size() {
        return this.serverChannels.size() + this.nonServerChannels.size();
    }

    @Override
    public Object[] toArray() {
        ArrayList arrayList0 = new ArrayList(this.size());
        arrayList0.addAll(this.serverChannels.values());
        arrayList0.addAll(this.nonServerChannels.values());
        return arrayList0.toArray();
    }

    @Override
    public Object[] toArray(Object[] arr_object) {
        ArrayList arrayList0 = new ArrayList(this.size());
        arrayList0.addAll(this.serverChannels.values());
        arrayList0.addAll(this.nonServerChannels.values());
        return arrayList0.toArray(arr_object);
    }

    @Override
    public String toString() {
        return StringUtil.simpleClassName(this) + "(name: " + this.name() + ", size: " + this.size() + ')';
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture write(Object object0) {
        return this.write(object0, ChannelMatchers.all());
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture write(Object object0, ChannelMatcher channelMatcher0) {
        return this.write(object0, channelMatcher0, false);
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture write(Object object0, ChannelMatcher channelMatcher0, boolean z) {
        ChannelGroupFuture channelGroupFuture0;
        ObjectUtil.checkNotNull(object0, "message");
        ObjectUtil.checkNotNull(channelMatcher0, "matcher");
        if(z) {
            for(Object object1: this.nonServerChannels.values()) {
                Channel channel0 = (Channel)object1;
                if(channelMatcher0.matches(channel0)) {
                    channel0.write(DefaultChannelGroup.safeDuplicate(object0), channel0.voidPromise());
                }
            }
            channelGroupFuture0 = this.voidFuture;
        }
        else {
            LinkedHashMap linkedHashMap0 = new LinkedHashMap(this.nonServerChannels.size());
            for(Object object2: this.nonServerChannels.values()) {
                Channel channel1 = (Channel)object2;
                if(channelMatcher0.matches(channel1)) {
                    linkedHashMap0.put(channel1, channel1.write(DefaultChannelGroup.safeDuplicate(object0)));
                }
            }
            channelGroupFuture0 = new DefaultChannelGroupFuture(this, linkedHashMap0, this.executor);
        }
        ReferenceCountUtil.release(object0);
        return channelGroupFuture0;
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture writeAndFlush(Object object0) {
        return this.writeAndFlush(object0, ChannelMatchers.all());
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture writeAndFlush(Object object0, ChannelMatcher channelMatcher0) {
        return this.writeAndFlush(object0, channelMatcher0, false);
    }

    @Override  // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture writeAndFlush(Object object0, ChannelMatcher channelMatcher0, boolean z) {
        ChannelGroupFuture channelGroupFuture0;
        ObjectUtil.checkNotNull(object0, "message");
        if(z) {
            for(Object object1: this.nonServerChannels.values()) {
                Channel channel0 = (Channel)object1;
                if(channelMatcher0.matches(channel0)) {
                    channel0.writeAndFlush(DefaultChannelGroup.safeDuplicate(object0), channel0.voidPromise());
                }
            }
            channelGroupFuture0 = this.voidFuture;
        }
        else {
            LinkedHashMap linkedHashMap0 = new LinkedHashMap(this.nonServerChannels.size());
            for(Object object2: this.nonServerChannels.values()) {
                Channel channel1 = (Channel)object2;
                if(channelMatcher0.matches(channel1)) {
                    linkedHashMap0.put(channel1, channel1.writeAndFlush(DefaultChannelGroup.safeDuplicate(object0)));
                }
            }
            channelGroupFuture0 = new DefaultChannelGroupFuture(this, linkedHashMap0, this.executor);
        }
        ReferenceCountUtil.release(object0);
        return channelGroupFuture0;
    }
}

