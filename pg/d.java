package pg;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;

public final class d implements BlockingQueue, RejectedExecutionHandler {
    public final AtomicInteger a;
    public final BlockingQueue b;

    public d() {
        LinkedBlockingQueue linkedBlockingQueue0 = new LinkedBlockingQueue();
        super();
        this.b = linkedBlockingQueue0;
        this.a = new AtomicInteger(0);
    }

    @Override
    public final boolean add(Object object0) {
        return this.b.add(((Runnable)object0));
    }

    @Override
    public final boolean addAll(Collection collection0) {
        q.g(collection0, "elements");
        return this.b.addAll(collection0);
    }

    @Override
    public final void clear() {
        this.b.clear();
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean contains(Object object0) {
        return (object0 == null ? true : object0 instanceof Runnable) ? this.b.contains(((Runnable)object0)) : false;
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        q.g(collection0, "elements");
        return this.b.containsAll(collection0);
    }

    @Override
    public final int drainTo(Collection collection0) {
        return this.b.drainTo(collection0);
    }

    @Override
    public final int drainTo(Collection collection0, int v) {
        return this.b.drainTo(collection0, v);
    }

    @Override
    public final Object element() {
        return (Runnable)this.b.element();
    }

    @Override
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return this.b.iterator();
    }

    @Override
    public final boolean offer(Object object0) {
        q.g(((Runnable)object0), "runnable");
        return this.a.get() == 0 ? false : this.b.offer(((Runnable)object0));
    }

    @Override
    public final boolean offer(Object object0, long v, TimeUnit timeUnit0) {
        return this.b.offer(((Runnable)object0), v, timeUnit0);
    }

    @Override
    public final Object peek() {
        return (Runnable)this.b.peek();
    }

    @Override
    public final Object poll() {
        return (Runnable)this.b.poll();
    }

    @Override
    public final Object poll(long v, TimeUnit timeUnit0) {
        q.g(timeUnit0, "unit");
        this.a.incrementAndGet();
        try {
            return (Runnable)this.b.poll(v, timeUnit0);
        }
        finally {
            this.a.decrementAndGet();
        }
    }

    @Override
    public final void put(Object object0) {
        this.b.put(((Runnable)object0));
    }

    @Override
    public final void rejectedExecution(Runnable runnable0, ThreadPoolExecutor threadPoolExecutor0) {
        q.g(runnable0, "r");
        q.g(threadPoolExecutor0, "executor");
        if(threadPoolExecutor0.isShutdown()) {
            d8.d.D(6, null, "already shutdown: task " + runnable0 + " is rejected from " + threadPoolExecutor0, Arrays.copyOf(new Object[0], 0));
            return;
        }
        if(!this.b.offer(runnable0)) {
            d8.d.D(6, null, "Unexpected problem: task " + runnable0 + " is rejected from " + threadPoolExecutor0, Arrays.copyOf(new Object[0], 0));
        }
    }

    @Override
    public final int remainingCapacity() {
        return this.b.remainingCapacity();
    }

    @Override
    public final Object remove() {
        return (Runnable)this.b.remove();
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean remove(Object object0) {
        return (object0 == null ? true : object0 instanceof Runnable) ? this.b.remove(((Runnable)object0)) : false;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        q.g(collection0, "elements");
        return this.b.removeAll(collection0);
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        q.g(collection0, "elements");
        return this.b.retainAll(collection0);
    }

    @Override
    public final int size() {
        return this.b.size();
    }

    @Override
    public final Object take() {
        Object object0;
        this.a.incrementAndGet();
        try {
            object0 = this.b.take();
            q.f(object0, "delegate.take()");
        }
        finally {
            this.a.decrementAndGet();
        }
        return (Runnable)object0;
    }

    @Override
    public final Object[] toArray() {
        return p.a(this);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        return p.b(this, arr_object);
    }
}

