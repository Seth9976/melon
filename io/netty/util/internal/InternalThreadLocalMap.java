package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InternalThreadLocalMap extends UnpaddedInternalThreadLocalMap {
    private static final int ARRAY_LIST_CAPACITY_EXPAND_THRESHOLD = 0x40000000;
    private static final int ARRAY_LIST_CAPACITY_MAX_SIZE = 0x7FFFFFF7;
    private static final int DEFAULT_ARRAY_LIST_INITIAL_CAPACITY = 8;
    private static final int HANDLER_SHARABLE_CACHE_INITIAL_CAPACITY = 4;
    private static final int INDEXED_VARIABLE_TABLE_INITIAL_SIZE = 0x20;
    private static final int STRING_BUILDER_INITIAL_SIZE;
    private static final int STRING_BUILDER_MAX_SIZE;
    public static final Object UNSET;
    public static final int VARIABLES_TO_REMOVE_INDEX;
    private ArrayList arrayList;
    private Map charsetDecoderCache;
    private Map charsetEncoderCache;
    private BitSet cleanerFlags;
    private IntegerHolder counterHashCode;
    private int futureListenerStackDepth;
    private Map handlerSharableCache;
    private Object[] indexedVariables;
    private int localChannelReaderStackDepth;
    private static final InternalLogger logger;
    private static final AtomicInteger nextIndex;
    private ThreadLocalRandom random;
    public long rp1;
    public long rp2;
    public long rp3;
    public long rp4;
    public long rp5;
    public long rp6;
    public long rp7;
    public long rp8;
    private static final ThreadLocal slowThreadLocalMap;
    private StringBuilder stringBuilder;
    private Map typeParameterMatcherFindCache;
    private Map typeParameterMatcherGetCache;

    static {
        InternalThreadLocalMap.slowThreadLocalMap = new ThreadLocal();
        InternalThreadLocalMap.nextIndex = new AtomicInteger();
        InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX = InternalThreadLocalMap.nextVariableIndex();
        InternalThreadLocalMap.UNSET = new Object();
        int v = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.initialSize", 0x400);
        InternalThreadLocalMap.STRING_BUILDER_INITIAL_SIZE = v;
        int v1 = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.maxSize", 0x1000);
        InternalThreadLocalMap.STRING_BUILDER_MAX_SIZE = v1;
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(InternalThreadLocalMap.class);
        InternalThreadLocalMap.logger = internalLogger0;
        internalLogger0.debug("-Dio.netty.threadLocalMap.stringBuilder.initialSize: {}", v);
        internalLogger0.debug("-Dio.netty.threadLocalMap.stringBuilder.maxSize: {}", v1);
    }

    private InternalThreadLocalMap() {
        this.indexedVariables = InternalThreadLocalMap.newIndexedVariableTable();
    }

    public ArrayList arrayList() {
        return this.arrayList(8);
    }

    public ArrayList arrayList(int v) {
        ArrayList arrayList0 = this.arrayList;
        if(arrayList0 == null) {
            ArrayList arrayList1 = new ArrayList(v);
            this.arrayList = arrayList1;
            return arrayList1;
        }
        arrayList0.clear();
        arrayList0.ensureCapacity(v);
        return arrayList0;
    }

    public Map charsetDecoderCache() {
        Map map0 = this.charsetDecoderCache;
        if(map0 == null) {
            map0 = new IdentityHashMap();
            this.charsetDecoderCache = map0;
        }
        return map0;
    }

    public Map charsetEncoderCache() {
        Map map0 = this.charsetEncoderCache;
        if(map0 == null) {
            map0 = new IdentityHashMap();
            this.charsetEncoderCache = map0;
        }
        return map0;
    }

    @Deprecated
    public IntegerHolder counterHashCode() {
        return this.counterHashCode;
    }

    public static void destroy() {
        InternalThreadLocalMap.slowThreadLocalMap.remove();
    }

    private void expandIndexedVariableTableAndSet(int v, Object object0) {
        int v5;
        Object[] arr_object = this.indexedVariables;
        if(v < 0x40000000) {
            int v1 = v >>> 1 | v;
            int v2 = v1 | v1 >>> 2;
            int v3 = v2 | v2 >>> 4;
            int v4 = v3 | v3 >>> 8;
            v5 = (v4 | v4 >>> 16) + 1;
        }
        else {
            v5 = 0x7FFFFFF7;
        }
        Object[] arr_object1 = Arrays.copyOf(arr_object, v5);
        Arrays.fill(arr_object1, arr_object.length, arr_object1.length, InternalThreadLocalMap.UNSET);
        arr_object1[v] = object0;
        this.indexedVariables = arr_object1;
    }

    private static InternalThreadLocalMap fastGet(FastThreadLocalThread fastThreadLocalThread0) {
        InternalThreadLocalMap internalThreadLocalMap0 = fastThreadLocalThread0.threadLocalMap();
        if(internalThreadLocalMap0 == null) {
            internalThreadLocalMap0 = new InternalThreadLocalMap();
            fastThreadLocalThread0.setThreadLocalMap(internalThreadLocalMap0);
        }
        return internalThreadLocalMap0;
    }

    public int futureListenerStackDepth() {
        return this.futureListenerStackDepth;
    }

    public static InternalThreadLocalMap get() {
        Thread thread0 = Thread.currentThread();
        return thread0 instanceof FastThreadLocalThread ? InternalThreadLocalMap.fastGet(((FastThreadLocalThread)thread0)) : InternalThreadLocalMap.slowGet();
    }

    public static InternalThreadLocalMap getIfSet() {
        Thread thread0 = Thread.currentThread();
        return thread0 instanceof FastThreadLocalThread ? ((FastThreadLocalThread)thread0).threadLocalMap() : ((InternalThreadLocalMap)InternalThreadLocalMap.slowThreadLocalMap.get());
    }

    public Map handlerSharableCache() {
        Map map0 = this.handlerSharableCache;
        if(map0 == null) {
            map0 = new WeakHashMap(4);
            this.handlerSharableCache = map0;
        }
        return map0;
    }

    public Object indexedVariable(int v) {
        return v >= this.indexedVariables.length ? InternalThreadLocalMap.UNSET : this.indexedVariables[v];
    }

    public boolean isCleanerFlagSet(int v) {
        return this.cleanerFlags != null && this.cleanerFlags.get(v);
    }

    public boolean isIndexedVariableSet(int v) {
        return v < this.indexedVariables.length && this.indexedVariables[v] != InternalThreadLocalMap.UNSET;
    }

    public static int lastVariableIndex() {
        return InternalThreadLocalMap.nextIndex.get() - 1;
    }

    public int localChannelReaderStackDepth() {
        return this.localChannelReaderStackDepth;
    }

    private static Object[] newIndexedVariableTable() {
        Object[] arr_object = new Object[0x20];
        Arrays.fill(arr_object, InternalThreadLocalMap.UNSET);
        return arr_object;
    }

    public static int nextVariableIndex() {
        AtomicInteger atomicInteger0 = InternalThreadLocalMap.nextIndex;
        int v = atomicInteger0.getAndIncrement();
        if(v < 0x7FFFFFF7 && v >= 0) {
            return v;
        }
        atomicInteger0.set(0x7FFFFFF7);
        throw new IllegalStateException("too many thread-local indexed variables");
    }

    public ThreadLocalRandom random() {
        ThreadLocalRandom threadLocalRandom0 = this.random;
        if(threadLocalRandom0 == null) {
            threadLocalRandom0 = new ThreadLocalRandom();
            this.random = threadLocalRandom0;
        }
        return threadLocalRandom0;
    }

    public static void remove() {
        Thread thread0 = Thread.currentThread();
        if(thread0 instanceof FastThreadLocalThread) {
            ((FastThreadLocalThread)thread0).setThreadLocalMap(null);
            return;
        }
        InternalThreadLocalMap.slowThreadLocalMap.remove();
    }

    public Object removeIndexedVariable(int v) {
        Object[] arr_object = this.indexedVariables;
        if(v < arr_object.length) {
            Object object0 = arr_object[v];
            arr_object[v] = InternalThreadLocalMap.UNSET;
            return object0;
        }
        return InternalThreadLocalMap.UNSET;
    }

    public void setCleanerFlag(int v) {
        if(this.cleanerFlags == null) {
            this.cleanerFlags = new BitSet();
        }
        this.cleanerFlags.set(v);
    }

    @Deprecated
    public void setCounterHashCode(IntegerHolder integerHolder0) {
        this.counterHashCode = integerHolder0;
    }

    public void setFutureListenerStackDepth(int v) {
        this.futureListenerStackDepth = v;
    }

    public boolean setIndexedVariable(int v, Object object0) {
        Object[] arr_object = this.indexedVariables;
        if(v < arr_object.length) {
            Object object1 = arr_object[v];
            arr_object[v] = object0;
            return object1 == InternalThreadLocalMap.UNSET;
        }
        this.expandIndexedVariableTableAndSet(v, object0);
        return true;
    }

    public void setLocalChannelReaderStackDepth(int v) {
        this.localChannelReaderStackDepth = v;
    }

    public int size() {
        int v = this.futureListenerStackDepth == 0 ? 0 : 1;
        if(this.localChannelReaderStackDepth != 0) {
            ++v;
        }
        if(this.handlerSharableCache != null) {
            ++v;
        }
        if(this.counterHashCode != null) {
            ++v;
        }
        if(this.random != null) {
            ++v;
        }
        if(this.typeParameterMatcherGetCache != null) {
            ++v;
        }
        if(this.typeParameterMatcherFindCache != null) {
            ++v;
        }
        if(this.stringBuilder != null) {
            ++v;
        }
        if(this.charsetEncoderCache != null) {
            ++v;
        }
        if(this.charsetDecoderCache != null) {
            ++v;
        }
        if(this.arrayList != null) {
            ++v;
        }
        Object object0 = this.indexedVariable(InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX);
        return object0 == null || object0 == InternalThreadLocalMap.UNSET ? v : ((Set)object0).size() + v;
    }

    private static InternalThreadLocalMap slowGet() {
        ThreadLocal threadLocal0 = InternalThreadLocalMap.slowThreadLocalMap;
        InternalThreadLocalMap internalThreadLocalMap0 = (InternalThreadLocalMap)threadLocal0.get();
        if(internalThreadLocalMap0 == null) {
            internalThreadLocalMap0 = new InternalThreadLocalMap();
            threadLocal0.set(internalThreadLocalMap0);
        }
        return internalThreadLocalMap0;
    }

    public StringBuilder stringBuilder() {
        StringBuilder stringBuilder0 = this.stringBuilder;
        if(stringBuilder0 == null) {
            StringBuilder stringBuilder1 = new StringBuilder(InternalThreadLocalMap.STRING_BUILDER_INITIAL_SIZE);
            this.stringBuilder = stringBuilder1;
            return stringBuilder1;
        }
        if(stringBuilder0.capacity() > InternalThreadLocalMap.STRING_BUILDER_MAX_SIZE) {
            stringBuilder0.setLength(InternalThreadLocalMap.STRING_BUILDER_INITIAL_SIZE);
            stringBuilder0.trimToSize();
        }
        stringBuilder0.setLength(0);
        return stringBuilder0;
    }

    public Map typeParameterMatcherFindCache() {
        Map map0 = this.typeParameterMatcherFindCache;
        if(map0 == null) {
            map0 = new IdentityHashMap();
            this.typeParameterMatcherFindCache = map0;
        }
        return map0;
    }

    public Map typeParameterMatcherGetCache() {
        Map map0 = this.typeParameterMatcherGetCache;
        if(map0 == null) {
            map0 = new IdentityHashMap();
            this.typeParameterMatcherGetCache = map0;
        }
        return map0;
    }
}

