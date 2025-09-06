package org.apache.http.impl.client;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.BackoffManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.pool.ConnPoolControl;
import org.apache.http.util.Args;

public class AIMDBackoffManager implements BackoffManager {
    private double backoffFactor;
    private int cap;
    private final Clock clock;
    private final ConnPoolControl connPerRoute;
    private long coolDown;
    private final Map lastRouteBackoffs;
    private final Map lastRouteProbes;

    public AIMDBackoffManager(ConnPoolControl connPoolControl0) {
        this(connPoolControl0, new SystemClock());
    }

    public AIMDBackoffManager(ConnPoolControl connPoolControl0, Clock clock0) {
        this.coolDown = 5000L;
        this.backoffFactor = 0.5;
        this.cap = 2;
        this.clock = clock0;
        this.connPerRoute = connPoolControl0;
        this.lastRouteProbes = new HashMap();
        this.lastRouteBackoffs = new HashMap();
    }

    @Override  // org.apache.http.client.BackoffManager
    public void backOff(HttpRoute httpRoute0) {
        synchronized(this.connPerRoute) {
            int v1 = this.connPerRoute.getMaxPerRoute(httpRoute0);
            Long long0 = this.getLastUpdate(this.lastRouteBackoffs, httpRoute0);
            long v2 = this.clock.getCurrentTime();
            if(v2 - ((long)long0) < this.coolDown) {
                return;
            }
            int v3 = this.getBackedOffPoolSize(v1);
            this.connPerRoute.setMaxPerRoute(httpRoute0, v3);
            this.lastRouteBackoffs.put(httpRoute0, v2);
        }
    }

    private int getBackedOffPoolSize(int v) {
        return v > 1 ? ((int)Math.floor(this.backoffFactor * ((double)v))) : 1;
    }

    private Long getLastUpdate(Map map0, HttpRoute httpRoute0) {
        Long long0 = (Long)map0.get(httpRoute0);
        return long0 == null ? 0L : long0;
    }

    @Override  // org.apache.http.client.BackoffManager
    public void probe(HttpRoute httpRoute0) {
        synchronized(this.connPerRoute) {
            int v1 = this.connPerRoute.getMaxPerRoute(httpRoute0);
            int v2 = v1 >= this.cap ? this.cap : v1 + 1;
            Long long0 = this.getLastUpdate(this.lastRouteProbes, httpRoute0);
            Long long1 = this.getLastUpdate(this.lastRouteBackoffs, httpRoute0);
            long v3 = this.clock.getCurrentTime();
            if(v3 - ((long)long0) >= this.coolDown && v3 - ((long)long1) >= this.coolDown) {
                this.connPerRoute.setMaxPerRoute(httpRoute0, v2);
                this.lastRouteProbes.put(httpRoute0, v3);
            }
        }
    }

    public void setBackoffFactor(double f) {
        Args.check(f > 0.0 && f < 1.0, "Backoff factor must be 0.0 < f < 1.0");
        this.backoffFactor = f;
    }

    public void setCooldownMillis(long v) {
        Args.positive(this.coolDown, "Cool down");
        this.coolDown = v;
    }

    public void setPerHostConnectionCap(int v) {
        Args.positive(v, "Per host connection cap");
        this.cap = v;
    }
}

