package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;

abstract class MpscChunkedAtomicArrayQueueColdProducerFields extends BaseMpscLinkedAtomicArrayQueue {
    protected final long maxQueueCapacity;

    public MpscChunkedAtomicArrayQueueColdProducerFields(int v, int v1) {
        super(v);
        RangeUtil.checkGreaterThanOrEqual(v1, 4, "maxCapacity");
        RangeUtil.checkLessThan(Pow2.roundToPowerOfTwo(v), Pow2.roundToPowerOfTwo(v1), "initialCapacity");
        this.maxQueueCapacity = ((long)Pow2.roundToPowerOfTwo(v1)) << 1;
    }
}

