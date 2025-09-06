package org.apache.http.pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@NotThreadSafe
abstract class RouteSpecificPool {
    private final LinkedList available;
    private final Set leased;
    private final LinkedList pending;
    private final Object route;

    public RouteSpecificPool(Object object0) {
        this.route = object0;
        this.leased = new HashSet();
        this.available = new LinkedList();
        this.pending = new LinkedList();
    }

    public PoolEntry add(Object object0) {
        PoolEntry poolEntry0 = this.createEntry(object0);
        this.leased.add(poolEntry0);
        return poolEntry0;
    }

    public abstract PoolEntry createEntry(Object arg1);

    public void free(PoolEntry poolEntry0, boolean z) {
        Args.notNull(poolEntry0, "Pool entry");
        Asserts.check(this.leased.remove(poolEntry0), "Entry %s has not been leased from this pool", new Object[]{poolEntry0});
        if(z) {
            this.available.addFirst(poolEntry0);
        }
    }

    public int getAllocatedCount() {
        return this.leased.size() + this.available.size();
    }

    public int getAvailableCount() {
        return this.available.size();
    }

    public PoolEntry getFree(Object object0) {
        if(!this.available.isEmpty()) {
            if(object0 != null) {
                Iterator iterator0 = this.available.iterator();
                while(iterator0.hasNext()) {
                    Object object1 = iterator0.next();
                    PoolEntry poolEntry0 = (PoolEntry)object1;
                    if(object0.equals(poolEntry0.getState())) {
                        iterator0.remove();
                        this.leased.add(poolEntry0);
                        return poolEntry0;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            Iterator iterator1 = this.available.iterator();
            while(iterator1.hasNext()) {
                Object object2 = iterator1.next();
                PoolEntry poolEntry1 = (PoolEntry)object2;
                if(poolEntry1.getState() == null) {
                    iterator1.remove();
                    this.leased.add(poolEntry1);
                    return poolEntry1;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    public PoolEntry getLastUsed() {
        return this.available.isEmpty() ? null : ((PoolEntry)this.available.getLast());
    }

    public int getLeasedCount() {
        return this.leased.size();
    }

    public int getPendingCount() {
        return this.pending.size();
    }

    public final Object getRoute() {
        return this.route;
    }

    public PoolEntryFuture nextPending() {
        return (PoolEntryFuture)this.pending.poll();
    }

    public void queue(PoolEntryFuture poolEntryFuture0) {
        if(poolEntryFuture0 == null) {
            return;
        }
        this.pending.add(poolEntryFuture0);
    }

    public boolean remove(PoolEntry poolEntry0) {
        Args.notNull(poolEntry0, "Pool entry");
        return this.available.remove(poolEntry0) || this.leased.remove(poolEntry0);
    }

    public void shutdown() {
        for(Object object0: this.pending) {
            ((PoolEntryFuture)object0).cancel(true);
        }
        this.pending.clear();
        for(Object object1: this.available) {
            ((PoolEntry)object1).close();
        }
        this.available.clear();
        for(Object object2: this.leased) {
            ((PoolEntry)object2).close();
        }
        this.leased.clear();
    }

    @Override
    public String toString() {
        return "[route: " + this.route + "][leased: " + this.leased.size() + "][available: " + this.available.size() + "][pending: " + this.pending.size() + "]";
    }

    public void unqueue(PoolEntryFuture poolEntryFuture0) {
        if(poolEntryFuture0 == null) {
            return;
        }
        this.pending.remove(poolEntryFuture0);
    }
}

