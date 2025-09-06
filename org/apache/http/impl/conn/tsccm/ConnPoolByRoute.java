package org.apache.http.impl.conn.tsccm;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;

@Deprecated
public class ConnPoolByRoute extends AbstractConnPool {
    protected Queue freeConnections;
    protected final int maxTotalConnections;
    protected final ClientConnectionOperator operator;
    protected final Map routeToPool;
    protected Queue waitingThreads;

    public ConnPoolByRoute(ClientConnectionOperator clientConnectionOperator0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public BasicPoolEntry createEntry(RouteSpecificPool routeSpecificPool0, ClientConnectionOperator clientConnectionOperator0) {
        throw new RuntimeException("Stub!");
    }

    public Queue createFreeConnQueue() {
        throw new RuntimeException("Stub!");
    }

    public Map createRouteToPoolMap() {
        throw new RuntimeException("Stub!");
    }

    public Queue createWaitingThreadQueue() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void deleteClosedConnections() {
        throw new RuntimeException("Stub!");
    }

    public void deleteEntry(BasicPoolEntry basicPoolEntry0) {
        throw new RuntimeException("Stub!");
    }

    public void deleteLeastUsedEntry() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void freeEntry(BasicPoolEntry basicPoolEntry0, boolean z, long v, TimeUnit timeUnit0) {
        throw new RuntimeException("Stub!");
    }

    public int getConnectionsInPool(HttpRoute httpRoute0) {
        throw new RuntimeException("Stub!");
    }

    public BasicPoolEntry getEntryBlocking(HttpRoute httpRoute0, Object object0, long v, TimeUnit timeUnit0, WaitingThreadAborter waitingThreadAborter0) {
        throw new RuntimeException("Stub!");
    }

    public BasicPoolEntry getFreeEntry(RouteSpecificPool routeSpecificPool0, Object object0) {
        throw new RuntimeException("Stub!");
    }

    public RouteSpecificPool getRoutePool(HttpRoute httpRoute0, boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void handleLostEntry(HttpRoute httpRoute0) {
        throw new RuntimeException("Stub!");
    }

    public RouteSpecificPool newRouteSpecificPool(HttpRoute httpRoute0) {
        throw new RuntimeException("Stub!");
    }

    public WaitingThread newWaitingThread(Condition condition0, RouteSpecificPool routeSpecificPool0) {
        throw new RuntimeException("Stub!");
    }

    public void notifyWaitingThread(RouteSpecificPool routeSpecificPool0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public PoolEntryRequest requestPoolEntry(HttpRoute httpRoute0, Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void shutdown() {
        throw new RuntimeException("Stub!");
    }
}

