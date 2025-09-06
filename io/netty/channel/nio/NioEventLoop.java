package io.netty.channel.nio;

import U4.x;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.EventLoopException;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop.ChannelsReadOnlyIterator;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.IntSupplier;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReflectionUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public final class NioEventLoop extends SingleThreadEventLoop {
    static final class SelectorTuple {
        final Selector selector;
        final Selector unwrappedSelector;

        public SelectorTuple(Selector selector0) {
            this.unwrappedSelector = selector0;
            this.selector = selector0;
        }

        public SelectorTuple(Selector selector0, Selector selector1) {
            this.unwrappedSelector = selector0;
            this.selector = selector1;
        }
    }

    static final boolean $assertionsDisabled = false;
    private static final long AWAKE = -1L;
    private static final int CLEANUP_INTERVAL = 0x100;
    private static final boolean DISABLE_KEY_SET_OPTIMIZATION = false;
    private static final int MIN_PREMATURE_SELECTOR_RETURNS = 3;
    private static final long NONE = 0x7FFFFFFFFFFFFFFFL;
    private static final int SELECTOR_AUTO_REBUILD_THRESHOLD;
    private int cancelledKeys;
    private volatile int ioRatio;
    private static final InternalLogger logger;
    private boolean needsToSelectAgain;
    private final AtomicLong nextWakeupNanos;
    private final SelectorProvider provider;
    private final IntSupplier selectNowSupplier;
    private final SelectStrategy selectStrategy;
    private SelectedSelectionKeySet selectedKeys;
    private Selector selector;
    private Selector unwrappedSelector;

    static {
        NioEventLoop.logger = InternalLoggerFactory.getInstance(NioEventLoop.class);
        int v = 0;
        NioEventLoop.DISABLE_KEY_SET_OPTIMIZATION = SystemPropertyUtil.getBoolean("io.netty.noKeySetOptimization", false);
        if(SystemPropertyUtil.get("sun.nio.ch.bugLevel") == null) {
            try {
                AccessController.doPrivileged(new PrivilegedAction() {
                    @Override
                    public Object run() {
                        return this.run();
                    }

                    public Void run() {
                        System.setProperty("sun.nio.ch.bugLevel", "");
                        return null;
                    }
                });
            }
            catch(SecurityException securityException0) {
                NioEventLoop.logger.debug("Unable to get/set System Property: sun.nio.ch.bugLevel", securityException0);
            }
        }
        int v1 = SystemPropertyUtil.getInt("io.netty.selectorAutoRebuildThreshold", 0x200);
        if(v1 >= 3) {
            v = v1;
        }
        NioEventLoop.SELECTOR_AUTO_REBUILD_THRESHOLD = v;
        InternalLogger internalLogger0 = NioEventLoop.logger;
        if(internalLogger0.isDebugEnabled()) {
            internalLogger0.debug("-Dio.netty.noKeySetOptimization: {}", Boolean.valueOf(NioEventLoop.DISABLE_KEY_SET_OPTIMIZATION));
            internalLogger0.debug("-Dio.netty.selectorAutoRebuildThreshold: {}", v);
        }
    }

    public NioEventLoop(NioEventLoopGroup nioEventLoopGroup0, Executor executor0, SelectorProvider selectorProvider0, SelectStrategy selectStrategy0, RejectedExecutionHandler rejectedExecutionHandler0, EventLoopTaskQueueFactory eventLoopTaskQueueFactory0, EventLoopTaskQueueFactory eventLoopTaskQueueFactory1) {
        super(nioEventLoopGroup0, executor0, false, NioEventLoop.newTaskQueue(eventLoopTaskQueueFactory0), NioEventLoop.newTaskQueue(eventLoopTaskQueueFactory1), rejectedExecutionHandler0);
        this.selectNowSupplier = () -> NioEventLoop.this.selector.selectNow();
        this.nextWakeupNanos = new AtomicLong(-1L);
        this.ioRatio = 50;
        this.provider = (SelectorProvider)ObjectUtil.checkNotNull(selectorProvider0, "selectorProvider");
        this.selectStrategy = (SelectStrategy)ObjectUtil.checkNotNull(selectStrategy0, "selectStrategy");
        SelectorTuple nioEventLoop$SelectorTuple0 = this.openSelector();
        this.selector = nioEventLoop$SelectorTuple0.selector;
        this.unwrappedSelector = nioEventLoop$SelectorTuple0.unwrappedSelector;
    }

    @Override  // io.netty.util.concurrent.AbstractScheduledEventExecutor
    public boolean afterScheduledTaskSubmitted(long v) {
        return v < this.nextWakeupNanos.get();
    }

    @Override  // io.netty.util.concurrent.AbstractScheduledEventExecutor
    public boolean beforeScheduledTaskSubmitted(long v) {
        return v < this.nextWakeupNanos.get();
    }

    public void cancel(SelectionKey selectionKey0) {
        selectionKey0.cancel();
        int v = this.cancelledKeys + 1;
        this.cancelledKeys = v;
        if(v >= 0x100) {
            this.cancelledKeys = 0;
            this.needsToSelectAgain = true;
        }
    }

    @Override  // io.netty.util.concurrent.SingleThreadEventExecutor
    public void cleanup() {
        try {
            this.selector.close();
        }
        catch(IOException iOException0) {
            NioEventLoop.logger.warn("Failed to close a selector.", iOException0);
        }
    }

    private void closeAll() {
        this.selectAgain();
        Set set0 = this.selector.keys();
        ArrayList arrayList0 = new ArrayList(set0.size());
        for(Object object0: set0) {
            SelectionKey selectionKey0 = (SelectionKey)object0;
            Object object1 = selectionKey0.attachment();
            if(object1 instanceof AbstractNioChannel) {
                arrayList0.add(((AbstractNioChannel)object1));
            }
            else {
                selectionKey0.cancel();
                NioEventLoop.invokeChannelUnregistered(((NioTask)object1), selectionKey0, null);
            }
        }
        for(Object object2: arrayList0) {
            ((AbstractNioChannel)object2).unsafe().close(((AbstractNioChannel)object2).unsafe().voidPromise());
        }
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    private static void handleLoopException(Throwable throwable0) {
        NioEventLoop.logger.warn("Unexpected exception in the selector loop.", throwable0);
        try {
            Thread.sleep(1000L);
        }
        catch(InterruptedException unused_ex) {
        }
    }

    private static void invokeChannelUnregistered(NioTask nioTask0, SelectionKey selectionKey0, Throwable throwable0) {
        try {
            nioTask0.channelUnregistered(selectionKey0.channel(), throwable0);
        }
        catch(Exception exception0) {
            NioEventLoop.logger.warn("Unexpected exception while running NioTask.channelUnregistered()", exception0);
        }
    }

    private static Queue newTaskQueue(EventLoopTaskQueueFactory eventLoopTaskQueueFactory0) {
        return eventLoopTaskQueueFactory0 == null ? NioEventLoop.newTaskQueue0(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS) : eventLoopTaskQueueFactory0.newTaskQueue(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
    }

    @Override  // io.netty.util.concurrent.SingleThreadEventExecutor
    public Queue newTaskQueue(int v) {
        return NioEventLoop.newTaskQueue0(v);
    }

    private static Queue newTaskQueue0(int v) {
        return v == 0x7FFFFFFF ? PlatformDependent.newMpscQueue() : PlatformDependent.newMpscQueue(v);
    }

    private SelectorTuple openSelector() {
        AbstractSelector abstractSelector0;
        try {
            abstractSelector0 = this.provider.openSelector();
        }
        catch(IOException iOException0) {
            throw new ChannelException("failed to open a new selector", iOException0);
        }
        if(NioEventLoop.DISABLE_KEY_SET_OPTIMIZATION) {
            return new SelectorTuple(abstractSelector0);
        }
        Object object0 = AccessController.doPrivileged(new PrivilegedAction() {
            @Override
            public Object run() {
                try {
                    return Class.forName("sun.nio.ch.SelectorImpl", false, PlatformDependent.getSystemClassLoader());
                }
                catch(Throwable object0) {
                    return object0;
                }
            }
        });
        if(object0 instanceof Class && ((Class)object0).isAssignableFrom(abstractSelector0.getClass())) {
            SelectedSelectionKeySet selectedSelectionKeySet0 = new SelectedSelectionKeySet();
            Object object1 = AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    try {
                        Field field0 = ((Class)object0).getDeclaredField("selectedKeys");
                        Field field1 = ((Class)object0).getDeclaredField("publicSelectedKeys");
                        Throwable throwable0 = ReflectionUtil.trySetAccessible(field0, true);
                        if(throwable0 != null) {
                            return throwable0;
                        }
                        Throwable throwable1 = ReflectionUtil.trySetAccessible(field1, true);
                        if(throwable1 != null) {
                            return throwable1;
                        }
                        field0.set(abstractSelector0, selectedSelectionKeySet0);
                        field1.set(abstractSelector0, selectedSelectionKeySet0);
                        return null;
                    }
                    catch(NoSuchFieldException object0) {
                    }
                    catch(IllegalAccessException object0) {
                    }
                    return object0;
                }
            });
            if(object1 instanceof Exception) {
                this.selectedKeys = null;
                NioEventLoop.logger.trace("failed to instrument a special java.util.Set into: {}", abstractSelector0, ((Exception)object1));
                return new SelectorTuple(abstractSelector0);
            }
            this.selectedKeys = selectedSelectionKeySet0;
            NioEventLoop.logger.trace("instrumented a special java.util.Set into: {}", abstractSelector0);
            return new SelectorTuple(abstractSelector0, new SelectedSelectionKeySetSelector(abstractSelector0, selectedSelectionKeySet0));
        }
        if(object0 instanceof Throwable) {
            NioEventLoop.logger.trace("failed to instrument a special java.util.Set into: {}", abstractSelector0, ((Throwable)object0));
        }
        return new SelectorTuple(abstractSelector0);
    }

    private void processSelectedKey(SelectionKey selectionKey0, AbstractNioChannel abstractNioChannel0) {
        NioUnsafe abstractNioChannel$NioUnsafe0 = abstractNioChannel0.unsafe();
        if(!selectionKey0.isValid()) {
            try {
                if(abstractNioChannel0.eventLoop() == this) {
                    goto label_3;
                }
            }
            catch(Throwable unused_ex) {
            }
            return;
        label_3:
            abstractNioChannel$NioUnsafe0.close(abstractNioChannel$NioUnsafe0.voidPromise());
            return;
        }
        try {
            int v = selectionKey0.readyOps();
            if((v & 8) != 0) {
                selectionKey0.interestOps(selectionKey0.interestOps() & -9);
                abstractNioChannel$NioUnsafe0.finishConnect();
            }
            if((v & 4) != 0) {
                abstractNioChannel$NioUnsafe0.forceFlush();
            }
            if((v & 17) == 0 && v != 0) {
                return;
            }
            abstractNioChannel$NioUnsafe0.read();
        }
        catch(CancelledKeyException unused_ex) {
            abstractNioChannel$NioUnsafe0.close(abstractNioChannel$NioUnsafe0.voidPromise());
        }
    }

    private static void processSelectedKey(SelectionKey selectionKey0, NioTask nioTask0) {
        try {
            try {
                nioTask0.channelReady(selectionKey0.channel(), selectionKey0);
            }
            catch(Exception exception0) {
                selectionKey0.cancel();
                NioEventLoop.invokeChannelUnregistered(nioTask0, selectionKey0, exception0);
                return;
            }
        }
        catch(Throwable throwable0) {
            selectionKey0.cancel();
            NioEventLoop.invokeChannelUnregistered(nioTask0, selectionKey0, null);
            throw throwable0;
        }
        if(!selectionKey0.isValid()) {
            NioEventLoop.invokeChannelUnregistered(nioTask0, selectionKey0, null);
        }
    }

    private void processSelectedKeys() {
        if(this.selectedKeys != null) {
            this.processSelectedKeysOptimized();
            return;
        }
        this.processSelectedKeysPlain(this.selector.selectedKeys());
    }

    private void processSelectedKeysOptimized() {
        for(int v = 0; true; ++v) {
            SelectedSelectionKeySet selectedSelectionKeySet0 = this.selectedKeys;
            if(v >= selectedSelectionKeySet0.size) {
                break;
            }
            SelectionKey[] arr_selectionKey = selectedSelectionKeySet0.keys;
            SelectionKey selectionKey0 = arr_selectionKey[v];
            arr_selectionKey[v] = null;
            Object object0 = selectionKey0.attachment();
            if(object0 instanceof AbstractNioChannel) {
                this.processSelectedKey(selectionKey0, ((AbstractNioChannel)object0));
            }
            else {
                NioEventLoop.processSelectedKey(selectionKey0, ((NioTask)object0));
            }
            if(this.needsToSelectAgain) {
                this.selectedKeys.reset(v + 1);
                this.selectAgain();
                v = -1;
            }
        }
    }

    private void processSelectedKeysPlain(Set set0) {
        if(!set0.isEmpty()) {
            Iterator iterator0 = set0.iterator();
            while(true) {
                Object object0 = iterator0.next();
                SelectionKey selectionKey0 = (SelectionKey)object0;
                Object object1 = selectionKey0.attachment();
                iterator0.remove();
                if(object1 instanceof AbstractNioChannel) {
                    this.processSelectedKey(selectionKey0, ((AbstractNioChannel)object1));
                }
                else {
                    NioEventLoop.processSelectedKey(selectionKey0, ((NioTask)object1));
                }
                if(!iterator0.hasNext()) {
                    break;
                }
                if(this.needsToSelectAgain) {
                    this.selectAgain();
                    Set set1 = this.selector.selectedKeys();
                    if(set1.isEmpty()) {
                        break;
                    }
                    iterator0 = set1.iterator();
                }
            }
        }
    }

    public void rebuildSelector() {
        if(!this.inEventLoop()) {
            this.execute(() -> {
                SelectorTuple nioEventLoop$SelectorTuple0;
                Selector selector0 = NioEventLoop.this.selector;
                if(selector0 != null) {
                    try {
                        nioEventLoop$SelectorTuple0 = NioEventLoop.this.openSelector();
                    }
                    catch(Exception exception0) {
                        NioEventLoop.logger.warn("Failed to create a new Selector.", exception0);
                        return;
                    }
                    int v = 0;
                    for(Object object0: selector0.keys()) {
                        SelectionKey selectionKey0 = (SelectionKey)object0;
                        Object object1 = selectionKey0.attachment();
                        try {
                            if(!selectionKey0.isValid() || selectionKey0.channel().keyFor(nioEventLoop$SelectorTuple0.unwrappedSelector) != null) {
                                continue;
                            }
                            int v1 = selectionKey0.interestOps();
                            selectionKey0.cancel();
                            SelectionKey selectionKey1 = selectionKey0.channel().register(nioEventLoop$SelectorTuple0.unwrappedSelector, v1, object1);
                            if(object1 instanceof AbstractNioChannel) {
                                ((AbstractNioChannel)object1).selectionKey = selectionKey1;
                            }
                        }
                        catch(Exception exception1) {
                            NioEventLoop.logger.warn("Failed to re-register a Channel to the new Selector.", exception1);
                            if(object1 instanceof AbstractNioChannel) {
                                ((AbstractNioChannel)object1).unsafe().close(((AbstractNioChannel)object1).unsafe().voidPromise());
                            }
                            else {
                                NioEventLoop.invokeChannelUnregistered(((NioTask)object1), selectionKey0, exception1);
                            }
                            continue;
                        }
                        ++v;
                    }
                    try {
                        NioEventLoop.this.selector = nioEventLoop$SelectorTuple0.selector;
                        NioEventLoop.this.unwrappedSelector = nioEventLoop$SelectorTuple0.unwrappedSelector;
                        selector0.close();
                    }
                    catch(Throwable throwable0) {
                        if(NioEventLoop.logger.isWarnEnabled()) {
                            NioEventLoop.logger.warn("Failed to close the old Selector.", throwable0);
                        }
                    }
                    InternalLogger internalLogger0 = NioEventLoop.logger;
                    if(internalLogger0.isInfoEnabled()) {
                        internalLogger0.info("Migrated " + v + " channel(s) to the new Selector.");
                    }
                }
            });
            return;
        }
        this.rebuildSelector0();

        class io.netty.channel.nio.NioEventLoop.6 implements Runnable {
            @Override
            public void run() {
                NioEventLoop.this.rebuildSelector0();
            }
        }

    }

    // 检测为 Lambda 实现
    private void rebuildSelector0() [...]

    public void register(SelectableChannel selectableChannel0, int v, NioTask nioTask0) {
        ObjectUtil.checkNotNull(selectableChannel0, "ch");
        if(v == 0) {
            throw new IllegalArgumentException("interestOps must be non-zero.");
        }
        if((~selectableChannel0.validOps() & v) == 0) {
            ObjectUtil.checkNotNull(nioTask0, "task");
            if(this.isShutdown()) {
                throw new IllegalStateException("event loop shut down");
            }
            if(this.inEventLoop()) {
                this.register0(selectableChannel0, v, nioTask0);
                return;
            }
            try {
                this.submit(() -> try {
                    this.val$ch.register(NioEventLoop.this.unwrappedSelector, this.val$interestOps, this.val$task);
                }
                catch(Exception exception0) {
                    throw new EventLoopException("failed to register a channel", exception0);
                }).sync();
            }
            catch(InterruptedException unused_ex) {
                Thread.currentThread().interrupt();
            }
            return;
        }
        StringBuilder stringBuilder0 = x.n(v, "invalid interestOps: ", "(validOps: ");
        stringBuilder0.append(selectableChannel0.validOps());
        stringBuilder0.append(')');
        throw new IllegalArgumentException(stringBuilder0.toString());

        class io.netty.channel.nio.NioEventLoop.5 implements Runnable {
            public io.netty.channel.nio.NioEventLoop.5(SelectableChannel selectableChannel0, int v, NioTask nioTask0) {
            }

            @Override
            public void run() {
                NioEventLoop.this.register0(this.val$ch, this.val$interestOps, this.val$task);
            }
        }

    }

    // 检测为 Lambda 实现
    private void register0(SelectableChannel selectableChannel0, int v, NioTask nioTask0) [...]

    @Override  // io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return this.selector.keys().size() - this.cancelledKeys;
    }

    @Override  // io.netty.channel.SingleThreadEventLoop
    public Iterator registeredChannelsIterator() {
        Set set0 = this.selector.keys();
        return set0.isEmpty() ? ChannelsReadOnlyIterator.empty() : new Iterator() {
            boolean isDone;
            Channel next;
            final Iterator selectionKeyIterator;

            {
                Set set0 = set0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.selectionKeyIterator = ((Set)ObjectUtil.checkNotNull(set0, "selectionKeys")).iterator();
            }

            @Override
            public boolean hasNext() {
                if(this.isDone) {
                    return false;
                }
                if(this.next == null) {
                    Channel channel0 = this.nextOrDone();
                    this.next = channel0;
                    return channel0 != null;
                }
                return true;
            }

            public Channel next() {
                if(this.isDone) {
                    throw new NoSuchElementException();
                }
                Channel channel0 = this.next;
                if(channel0 == null) {
                    channel0 = this.nextOrDone();
                    if(channel0 == null) {
                        throw new NoSuchElementException();
                    }
                }
                this.next = this.nextOrDone();
                return channel0;
            }

            @Override
            public Object next() {
                return this.next();
            }

            private Channel nextOrDone() {
                Iterator iterator0 = this.selectionKeyIterator;
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    SelectionKey selectionKey0 = (SelectionKey)object0;
                    if(selectionKey0.isValid()) {
                        Object object1 = selectionKey0.attachment();
                        if(object1 instanceof AbstractNioChannel) {
                            return (AbstractNioChannel)object1;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
                this.isDone = true;
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        };
    }

    @Override  // io.netty.util.concurrent.SingleThreadEventExecutor
    public void run() {
        long v6;
        boolean z1;
        int v4;
        int v1;
        int v;
        while(true) {
            v = 0;
            try {
            label_1:
                boolean z = this.hasTasks();
                v1 = this.selectStrategy.calculateStrategy(this.selectNowSupplier, z);
                switch(v1) {
                    case -2: {
                        goto label_119;
                    }
                    case -3: 
                    case -1: {
                        goto label_5;
                    }
                }
            }
            catch(IOException iOException0) {
                goto label_17;
            }
            catch(CancelledKeyException cancelledKeyException0) {
                v4 = v;
                cancelledKeyException1 = cancelledKeyException0;
                goto label_81;
            }
            catch(Error error0) {
                throw error0;
            }
            catch(Throwable throwable0) {
                v4 = v;
                throwable1 = throwable0;
                goto label_91;
            }
            goto label_44;
            try {
                try {
                label_5:
                    long v2 = this.nextScheduledTaskDeadlineNanos();
                    if(v2 == -1L) {
                        v2 = 0x7FFFFFFFFFFFFFFFL;
                    }
                    this.nextWakeupNanos.set(v2);
                    try {
                        if(!this.hasTasks()) {
                            v1 = this.select(v2);
                        }
                    }
                    finally {
                        this.nextWakeupNanos.lazySet(-1L);
                    }
                    goto label_44;
                }
                catch(IOException iOException0) {
                }
            label_17:
                this.rebuildSelector0();
            }
            catch(CancelledKeyException cancelledKeyException0) {
                v4 = v;
                cancelledKeyException1 = cancelledKeyException0;
                goto label_81;
            }
            catch(Error error0) {
                throw error0;
            }
            catch(Throwable throwable0) {
                v4 = v;
                throwable1 = throwable0;
                goto label_91;
            }
            try {
                NioEventLoop.handleLoopException(iOException0);
                goto label_26;
            }
            catch(CancelledKeyException cancelledKeyException1) {
            }
            catch(Error error0) {
                throw error0;
            }
            catch(Throwable throwable1) {
                v4 = 0;
                goto label_91;
            }
            v4 = 0;
            goto label_81;
            try {
            label_26:
                if(!this.isShuttingDown()) {
                    continue;
                }
                this.closeAll();
                if(!this.confirmShutdown()) {
                    continue;
                }
                break;
            }
            catch(Error error1) {
                throw error1;
            }
            catch(Throwable throwable2) {
                NioEventLoop.handleLoopException(throwable2);
            }
        }
        return;
    label_44:
        v4 = v + 1;
        this.cancelledKeys = 0;
        this.needsToSelectAgain = false;
        int v5 = this.ioRatio;
        if(v5 == 100) {
        label_60:
            if(v1 > 0) {
                try {
                    this.processSelectedKeys();
                }
                catch(Throwable throwable4) {
                    try {
                        this.runAllTasks();
                        throw throwable4;
                    label_66:
                        z1 = this.runAllTasks();
                    label_67:
                        if(!z1 && v1 <= 0) {
                            if(this.unexpectedSelectorWakeup(v4)) {
                                v4 = 0;
                            }
                            goto label_109;
                        }
                        else if(v4 > 3) {
                            InternalLogger internalLogger0 = NioEventLoop.logger;
                            if(internalLogger0.isDebugEnabled()) {
                                internalLogger0.debug("Selector.select() returned prematurely {} times in a row for Selector {}.", v, this.selector);
                            }
                        }
                        v4 = 0;
                        goto label_109;
                    }
                    catch(CancelledKeyException cancelledKeyException1) {
                        goto label_81;
                    }
                    catch(Error error0) {
                        throw error0;
                    }
                    catch(Throwable throwable1) {
                        goto label_91;
                    }
                }
            }
            goto label_66;
        }
        else {
            try {
                if(v1 <= 0) {
                    z1 = this.runAllTasks(0L);
                    goto label_67;
                }
                else {
                    v6 = System.nanoTime();
                    goto label_53;
                }
                goto label_60;
            }
            catch(CancelledKeyException cancelledKeyException1) {
                goto label_81;
            }
            catch(Error error0) {
                throw error0;
            }
            catch(Throwable throwable1) {
                goto label_91;
            }
            try {
            label_53:
                this.processSelectedKeys();
                z1 = this.runAllTasks((System.nanoTime() - v6) * ((long)(100 - v5)) / ((long)v5));
            }
            catch(Throwable throwable3) {
                try {
                    this.runAllTasks((System.nanoTime() - v6) * ((long)(100 - v5)) / ((long)v5));
                    throw throwable3;
                }
                catch(CancelledKeyException cancelledKeyException1) {
                    goto label_81;
                }
                catch(Error error0) {
                    throw error0;
                }
                catch(Throwable throwable1) {
                    goto label_91;
                }
            }
        }
        goto label_67;
        try {
        label_81:
            InternalLogger internalLogger1 = NioEventLoop.logger;
            if(internalLogger1.isDebugEnabled()) {
                internalLogger1.debug("CancelledKeyException raised by a Selector {} - JDK bug?", this.selector, cancelledKeyException1);
            }
        }
        catch(Throwable throwable5) {
            goto label_94;
        }
        try {
            if(this.isShuttingDown()) {
                this.closeAll();
                if(this.confirmShutdown()) {
                    return;
                }
            }
        }
        catch(Error error2) {
            throw error2;
            try {
                throw error0;
            label_91:
                NioEventLoop.handleLoopException(throwable1);
            }
            catch(Throwable throwable5) {
                try {
                label_94:
                    if(this.isShuttingDown()) {
                        this.closeAll();
                        if(this.confirmShutdown()) {
                            return;
                        }
                    }
                }
                catch(Error error3) {
                    throw error3;
                }
                catch(Throwable throwable7) {
                    NioEventLoop.handleLoopException(throwable7);
                }
                throw throwable5;
            }
            try {
                if(this.isShuttingDown()) {
                    this.closeAll();
                    if(this.confirmShutdown()) {
                        return;
                    }
                }
                v = v4;
                goto label_1;
            }
            catch(Error error4) {
            }
            catch(Throwable throwable6) {
                NioEventLoop.handleLoopException(throwable6);
                v = v4;
                goto label_1;
            }
            throw error4;
            try {
            label_109:
                if(this.isShuttingDown()) {
                    this.closeAll();
                    if(this.confirmShutdown()) {
                        return;
                    }
                }
                v = v4;
                goto label_1;
            }
            catch(Error error5) {
            }
            catch(Throwable throwable6) {
                NioEventLoop.handleLoopException(throwable6);
                v = v4;
                goto label_1;
            }
            throw error5;
        }
        catch(Throwable throwable6) {
            NioEventLoop.handleLoopException(throwable6);
        }
        v = v4;
        goto label_1;
        try {
        label_119:
            if(!this.isShuttingDown()) {
                goto label_1;
            }
            this.closeAll();
            if(!this.confirmShutdown()) {
                goto label_1;
            }
        }
        catch(Error error6) {
            throw error6;
        }
        catch(Throwable throwable8) {
            NioEventLoop.handleLoopException(throwable8);
            goto label_1;
        }
    }

    private int select(long v) {
        if(v == 0x7FFFFFFFFFFFFFFFL) {
            return this.selector.select();
        }
        long v1 = AbstractScheduledEventExecutor.deadlineToDelayNanos(v + 995000L);
        return v1 / 1000000L > 0L ? this.selector.select(v1 / 1000000L) : this.selector.selectNow();
    }

    private void selectAgain() {
        try {
            this.needsToSelectAgain = false;
            this.selector.selectNow();
        }
        catch(Throwable throwable0) {
            NioEventLoop.logger.warn("Failed to update SelectionKeys.", throwable0);
        }
    }

    // 检测为 Lambda 实现
    public int selectNow() [...]

    public SelectorProvider selectorProvider() {
        return this.provider;
    }

    public void setIoRatio(int v) {
        if(v <= 0 || v > 100) {
            throw new IllegalArgumentException("ioRatio: " + v + " (expected: 0 < ioRatio <= 100)");
        }
        this.ioRatio = v;
    }

    private boolean unexpectedSelectorWakeup(int v) {
        if(Thread.interrupted()) {
            InternalLogger internalLogger0 = NioEventLoop.logger;
            if(internalLogger0.isDebugEnabled()) {
                internalLogger0.debug("Selector.select() returned prematurely because Thread.currentThread().interrupt() was called. Use NioEventLoop.shutdownGracefully() to shutdown the NioEventLoop.");
            }
            return true;
        }
        if(NioEventLoop.SELECTOR_AUTO_REBUILD_THRESHOLD > 0 && v >= NioEventLoop.SELECTOR_AUTO_REBUILD_THRESHOLD) {
            NioEventLoop.logger.warn("Selector.select() returned prematurely {} times in a row; rebuilding Selector {}.", v, this.selector);
            this.rebuildSelector();
            return true;
        }
        return false;
    }

    public Selector unwrappedSelector() {
        return this.unwrappedSelector;
    }

    @Override  // io.netty.util.concurrent.SingleThreadEventExecutor
    public void wakeup(boolean z) {
        if(!z && this.nextWakeupNanos.getAndSet(-1L) != -1L) {
            this.selector.wakeup();
        }
    }

    class io.netty.channel.nio.NioEventLoop.1 implements IntSupplier {
        @Override  // io.netty.util.IntSupplier
        public int get() {
            return NioEventLoop.this.selectNow();
        }
    }

}

