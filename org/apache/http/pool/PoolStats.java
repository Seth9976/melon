package org.apache.http.pool;

import U4.x;
import org.apache.http.annotation.Immutable;

@Immutable
public class PoolStats {
    private final int available;
    private final int leased;
    private final int max;
    private final int pending;

    public PoolStats(int v, int v1, int v2, int v3) {
        this.leased = v;
        this.pending = v1;
        this.available = v2;
        this.max = v3;
    }

    public int getAvailable() {
        return this.available;
    }

    public int getLeased() {
        return this.leased;
    }

    public int getMax() {
        return this.max;
    }

    public int getPending() {
        return this.pending;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[leased: ");
        stringBuilder0.append(this.leased);
        stringBuilder0.append("; pending: ");
        stringBuilder0.append(this.pending);
        stringBuilder0.append("; available: ");
        stringBuilder0.append(this.available);
        stringBuilder0.append("; max: ");
        return x.g(this.max, "]", stringBuilder0);
    }
}

