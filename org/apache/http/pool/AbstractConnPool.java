package org.apache.http.pool;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@ThreadSafe
public abstract class AbstractConnPool implements ConnPool, ConnPoolControl {
    private final LinkedList available;
    private final ConnFactory connFactory;
    private volatile int defaultMaxPerRoute;
    private volatile boolean isShutDown;
    private final Set leased;
    private final Lock lock;
    private final Map maxPerRoute;
    private volatile int maxTotal;
    private final LinkedList pending;
    private final Map routeToPool;

    public AbstractConnPool(ConnFactory connFactory0, int v, int v1) {
        this.connFactory = (ConnFactory)Args.notNull(connFactory0, "Connection factory");
        this.defaultMaxPerRoute = Args.notNegative(v, "Max per route value");
        this.maxTotal = Args.notNegative(v1, "Max total value");
        this.lock = new ReentrantLock();
        this.routeToPool = new HashMap();
        this.leased = new HashSet();
        this.available = new LinkedList();
        this.pending = new LinkedList();
        this.maxPerRoute = new HashMap();
    }

    public void closeExpired() {
        this.enumAvailable(new PoolEntryCallback() {
            @Override  // org.apache.http.pool.PoolEntryCallback
            public void process(PoolEntry poolEntry0) {
                if(poolEntry0.isExpired(System.currentTimeMillis())) {
                    poolEntry0.close();
                }
            }
        });
    }

    public void closeIdle(long v, TimeUnit timeUnit0) {
        Args.notNull(timeUnit0, "Time unit");
        long v1 = timeUnit0.toMillis(v);
        if(v1 < 0L) {
            v1 = 0L;
        }
        this.enumAvailable(new PoolEntryCallback() {
            @Override  // org.apache.http.pool.PoolEntryCallback
            public void process(PoolEntry poolEntry0) {
                if(poolEntry0.getUpdated() <= System.currentTimeMillis() - v1) {
                    poolEntry0.close();
                }
            }
        });
    }

    public abstract PoolEntry createEntry(Object arg1, Object arg2);

    public void enumAvailable(PoolEntryCallback poolEntryCallback0) {
        this.lock.lock();
        try {
            Iterator iterator0 = this.available.iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                PoolEntry poolEntry0 = (PoolEntry)object0;
                poolEntryCallback0.process(poolEntry0);
                if(poolEntry0.isClosed()) {
                    this.getPool(poolEntry0.getRoute()).remove(poolEntry0);
                    iterator0.remove();
                }
            }
            this.purgePoolMap();
        }
        finally {
            this.lock.unlock();
        }
    }

    public void enumLeased(PoolEntryCallback poolEntryCallback0) {
        this.lock.lock();
        try {
            for(Object object0: this.leased) {
                poolEntryCallback0.process(((PoolEntry)object0));
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        int v = this.defaultMaxPerRoute;
        this.lock.unlock();
        return v;
    }

    private int getMax(Object object0) {
        Integer integer0 = (Integer)this.maxPerRoute.get(object0);
        return integer0 == null ? this.defaultMaxPerRoute : ((int)integer0);
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public int getMaxPerRoute(Object object0) {
        Args.notNull(object0, "Route");
        this.lock.lock();
        try {
            return this.getMax(object0);
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public int getMaxTotal() {
        this.lock.lock();
        int v = this.maxTotal;
        this.lock.unlock();
        return v;
    }

    private RouteSpecificPool getPool(Object object0) {
        RouteSpecificPool routeSpecificPool0 = (RouteSpecificPool)this.routeToPool.get(object0);
        if(routeSpecificPool0 == null) {
            routeSpecificPool0 = new RouteSpecificPool(object0) {
                @Override  // org.apache.http.pool.RouteSpecificPool
                public PoolEntry createEntry(Object object0) {
                    return AbstractConnPool.this.createEntry(object0, object0);
                }
            };
            this.routeToPool.put(object0, routeSpecificPool0);
        }
        return routeSpecificPool0;
    }

    private PoolEntry getPoolEntryBlocking(Object object0, Object object1, long v, TimeUnit timeUnit0, PoolEntryFuture poolEntryFuture0) {
        PoolEntry poolEntry0;
        Date date0 = Long.compare(v, 0L) <= 0 ? null : new Date(timeUnit0.toMillis(v) + System.currentTimeMillis());
        this.lock.lock();
        try {
            RouteSpecificPool routeSpecificPool0 = this.getPool(object0);
            do {
                Asserts.check(!this.isShutDown, "Connection pool shut down");
                while(true) {
                    poolEntry0 = routeSpecificPool0.getFree(object1);
                    if(poolEntry0 == null || !poolEntry0.isClosed() && !poolEntry0.isExpired(System.currentTimeMillis())) {
                        break;
                    }
                    poolEntry0.close();
                    this.available.remove(poolEntry0);
                    routeSpecificPool0.free(poolEntry0, false);
                }
                if(poolEntry0 != null) {
                    this.available.remove(poolEntry0);
                    this.leased.add(poolEntry0);
                    return poolEntry0;
                }
                int v2 = this.getMax(object0);
                int v3 = Math.max(0, routeSpecificPool0.getAllocatedCount() + 1 - v2);
                if(v3 > 0) {
                    for(int v4 = 0; v4 < v3; ++v4) {
                        PoolEntry poolEntry1 = routeSpecificPool0.getLastUsed();
                        if(poolEntry1 == null) {
                            break;
                        }
                        poolEntry1.close();
                        this.available.remove(poolEntry1);
                        routeSpecificPool0.remove(poolEntry1);
                    }
                }
                if(routeSpecificPool0.getAllocatedCount() < v2) {
                    int v5 = Math.max(this.maxTotal - this.leased.size(), 0);
                    if(v5 > 0) {
                        if(this.available.size() > v5 - 1 && !this.available.isEmpty()) {
                            PoolEntry poolEntry2 = (PoolEntry)this.available.removeLast();
                            poolEntry2.close();
                            this.getPool(poolEntry2.getRoute()).remove(poolEntry2);
                        }
                        PoolEntry poolEntry3 = routeSpecificPool0.add(this.connFactory.create(object0));
                        this.leased.add(poolEntry3);
                        return poolEntry3;
                    }
                }
                try {
                    routeSpecificPool0.queue(poolEntryFuture0);
                    this.pending.add(poolEntryFuture0);
                    boolean z = poolEntryFuture0.await(date0);
                }
                catch(Throwable throwable0) {
                    routeSpecificPool0.unqueue(poolEntryFuture0);
                    this.pending.remove(poolEntryFuture0);
                    throw throwable0;
                }
                routeSpecificPool0.unqueue(poolEntryFuture0);
                this.pending.remove(poolEntryFuture0);
            }
            while(z || date0 == null || date0.getTime() > System.currentTimeMillis());
        }
        finally {
            this.lock.unlock();
        }
        throw new TimeoutException("Timeout waiting for connection");
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public PoolStats getStats(Object object0) {
        Args.notNull(object0, "Route");
        this.lock.lock();
        try {
            RouteSpecificPool routeSpecificPool0 = this.getPool(object0);
            return new PoolStats(routeSpecificPool0.getLeasedCount(), routeSpecificPool0.getPendingCount(), routeSpecificPool0.getAvailableCount(), this.getMax(object0));
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        this.lock.lock();
        try {
            return new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
        }
        finally {
            this.lock.unlock();
        }
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    public Future lease(Object object0, Object object1) {
        return this.lease(object0, object1, null);
    }

    @Override  // org.apache.http.pool.ConnPool
    public Future lease(Object object0, Object object1, FutureCallback futureCallback0) {
        Args.notNull(object0, "Route");
        Asserts.check(!this.isShutDown, "Connection pool shut down");
        return new PoolEntryFuture(this.lock, futureCallback0) {
            @Override  // org.apache.http.pool.PoolEntryFuture
            public Object getPoolEntry(long v, TimeUnit timeUnit0) {
                return this.getPoolEntry(v, timeUnit0);
            }

            public PoolEntry getPoolEntry(long v, TimeUnit timeUnit0) {
                return AbstractConnPool.this.getPoolEntryBlocking(object0, object1, v, timeUnit0, this);
            }
        };
    }

    public void onLease(PoolEntry poolEntry0) {
    }

    public void onRelease(PoolEntry poolEntry0) {
    }

    private void purgePoolMap() {
        Iterator iterator0 = this.routeToPool.entrySet().iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            RouteSpecificPool routeSpecificPool0 = (RouteSpecificPool)((Map.Entry)object0).getValue();
            if(routeSpecificPool0.getPendingCount() + routeSpecificPool0.getAllocatedCount() == 0) {
                iterator0.remove();
            }
        }
    }

    @Override  // org.apache.http.pool.ConnPool
    public void release(Object object0, boolean z) {
        this.release(((PoolEntry)object0), z);
    }

    public void release(PoolEntry poolEntry0, boolean z) {
        this.lock.lock();
        try {
            if(this.leased.remove(poolEntry0)) {
                RouteSpecificPool routeSpecificPool0 = this.getPool(poolEntry0.getRoute());
                routeSpecificPool0.free(poolEntry0, z);
                if(!z || this.isShutDown) {
                    poolEntry0.close();
                }
                else {
                    this.available.addFirst(poolEntry0);
                }
                PoolEntryFuture poolEntryFuture0 = routeSpecificPool0.nextPending();
                if(poolEntryFuture0 == null) {
                    poolEntryFuture0 = (PoolEntryFuture)this.pending.poll();
                }
                else {
                    this.pending.remove(poolEntryFuture0);
                }
                if(poolEntryFuture0 != null) {
                    poolEntryFuture0.wakeup();
                }
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int v) {
        Args.notNegative(v, "Max per route value");
        this.lock.lock();
        this.defaultMaxPerRoute = v;
        this.lock.unlock();
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public void setMaxPerRoute(Object object0, int v) {
        Args.notNull(object0, "Route");
        Args.notNegative(v, "Max per route value");
        this.lock.lock();
        try {
            this.maxPerRoute.put(object0, v);
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public void setMaxTotal(int v) {
        Args.notNegative(v, "Max value");
        this.lock.lock();
        this.maxTotal = v;
        this.lock.unlock();
    }

    public void shutdown() {
        if(this.isShutDown) {
            return;
        }
        this.isShutDown = true;
        this.lock.lock();
        try {
            for(Object object0: this.available) {
                ((PoolEntry)object0).close();
            }
            for(Object object1: this.leased) {
                ((PoolEntry)object1).close();
            }
            for(Object object2: this.routeToPool.values()) {
                ((RouteSpecificPool)object2).shutdown();
            }
            this.routeToPool.clear();
            this.leased.clear();
            this.available.clear();
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "[leased: " + this.leased + "][available: " + this.available + "][pending: " + this.pending + "]";
    }
}

