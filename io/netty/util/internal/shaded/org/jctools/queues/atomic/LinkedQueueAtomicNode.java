package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReference;

public final class LinkedQueueAtomicNode extends AtomicReference {
    private static final long serialVersionUID = 2404266111789071508L;
    private Object value;

    public LinkedQueueAtomicNode() {
    }

    public LinkedQueueAtomicNode(Object object0) {
        this.spValue(object0);
    }

    public Object getAndNullValue() {
        this.spValue(null);
        return this.lpValue();
    }

    public Object lpValue() {
        return this.value;
    }

    public LinkedQueueAtomicNode lvNext() {
        return (LinkedQueueAtomicNode)this.get();
    }

    public void soNext(LinkedQueueAtomicNode linkedQueueAtomicNode0) {
        this.lazySet(linkedQueueAtomicNode0);
    }

    public void spNext(LinkedQueueAtomicNode linkedQueueAtomicNode0) {
        this.lazySet(linkedQueueAtomicNode0);
    }

    public void spValue(Object object0) {
        this.value = object0;
    }
}

