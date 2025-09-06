package io.netty.util.internal.shaded.org.jctools.queues;

public final class IndexedQueueSizeUtil {
    public interface IndexedQueue {
        int capacity();

        long lvConsumerIndex();

        long lvProducerIndex();
    }

    public static boolean isEmpty(IndexedQueue indexedQueueSizeUtil$IndexedQueue0) {
        return indexedQueueSizeUtil$IndexedQueue0.lvConsumerIndex() >= indexedQueueSizeUtil$IndexedQueue0.lvProducerIndex();
    }

    public static int size(IndexedQueue indexedQueueSizeUtil$IndexedQueue0) {
        long v2;
        long v1;
        for(long v = indexedQueueSizeUtil$IndexedQueue0.lvConsumerIndex(); true; v = v2) {
            v1 = indexedQueueSizeUtil$IndexedQueue0.lvProducerIndex();
            v2 = indexedQueueSizeUtil$IndexedQueue0.lvConsumerIndex();
            if(v == v2) {
                break;
            }
        }
        long v3 = v1 - v2;
        if(v3 > 0x7FFFFFFFL) {
            return 0x7FFFFFFF;
        }
        if(v3 < 0L) {
            return 0;
        }
        return indexedQueueSizeUtil$IndexedQueue0.capacity() == -1 || v3 <= ((long)indexedQueueSizeUtil$IndexedQueue0.capacity()) ? ((int)v3) : indexedQueueSizeUtil$IndexedQueue0.capacity();
    }
}

