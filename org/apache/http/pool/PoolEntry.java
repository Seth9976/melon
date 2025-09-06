package org.apache.http.pool;

import java.util.concurrent.TimeUnit;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;
import va.e;

@ThreadSafe
public abstract class PoolEntry {
    private final Object conn;
    private final long created;
    @GuardedBy("this")
    private long expiry;
    private final String id;
    private final Object route;
    private volatile Object state;
    @GuardedBy("this")
    private long updated;
    private final long validUnit;

    public PoolEntry(String s, Object object0, Object object1) {
        this(s, object0, object1, 0L, TimeUnit.MILLISECONDS);
    }

    public PoolEntry(String s, Object object0, Object object1, long v, TimeUnit timeUnit0) {
        Args.notNull(object0, "Route");
        Args.notNull(object1, "Connection");
        Args.notNull(timeUnit0, "Time unit");
        this.id = s;
        this.route = object0;
        this.conn = object1;
        long v1 = System.currentTimeMillis();
        this.created = v1;
        this.validUnit = v > 0L ? timeUnit0.toMillis(v) + v1 : 0x7FFFFFFFFFFFFFFFL;
        this.expiry = this.validUnit;
    }

    public abstract void close();

    public Object getConnection() {
        return this.conn;
    }

    public long getCreated() {
        return this.created;
    }

    public long getExpiry() {
        synchronized(this) {
        }
        return this.expiry;
    }

    public String getId() {
        return this.id;
    }

    public Object getRoute() {
        return this.route;
    }

    public Object getState() {
        return this.state;
    }

    public long getUpdated() {
        synchronized(this) {
        }
        return this.updated;
    }

    public long getValidUnit() {
        return this.validUnit;
    }

    public abstract boolean isClosed();

    public boolean isExpired(long v) {
        synchronized(this) {
        }
        return v >= this.expiry;
    }

    public void setState(Object object0) {
        this.state = object0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[id:");
        stringBuilder0.append(this.id);
        stringBuilder0.append("][route:");
        stringBuilder0.append(this.route);
        stringBuilder0.append("][state:");
        return e.d(stringBuilder0, this.state, "]");
    }

    public void updateExpiry(long v, TimeUnit timeUnit0) {
        synchronized(this) {
            Args.notNull(timeUnit0, "Time unit");
            long v2 = System.currentTimeMillis();
            this.updated = v2;
            this.expiry = Math.min((v <= 0L ? 0x7FFFFFFFFFFFFFFFL : v2 + timeUnit0.toMillis(v)), this.validUnit);
        }
    }
}

