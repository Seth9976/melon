package org.apache.http.impl.conn.tsccm;

import java.util.LinkedList;
import java.util.Queue;
import org.apache.http.conn.routing.HttpRoute;

@Deprecated
public class RouteSpecificPool {
    protected final LinkedList freeEntries;
    protected final int maxEntries;
    protected int numEntries;
    protected final HttpRoute route;
    protected final Queue waitingThreads;

    public RouteSpecificPool(HttpRoute httpRoute0, int v) {
        throw new RuntimeException("Stub!");
    }

    public BasicPoolEntry allocEntry(Object object0) {
        throw new RuntimeException("Stub!");
    }

    public void createdEntry(BasicPoolEntry basicPoolEntry0) {
        throw new RuntimeException("Stub!");
    }

    public boolean deleteEntry(BasicPoolEntry basicPoolEntry0) {
        throw new RuntimeException("Stub!");
    }

    public void dropEntry() {
        throw new RuntimeException("Stub!");
    }

    public void freeEntry(BasicPoolEntry basicPoolEntry0) {
        throw new RuntimeException("Stub!");
    }

    public int getCapacity() {
        throw new RuntimeException("Stub!");
    }

    public final int getEntryCount() {
        throw new RuntimeException("Stub!");
    }

    public final int getMaxEntries() {
        throw new RuntimeException("Stub!");
    }

    public final HttpRoute getRoute() {
        throw new RuntimeException("Stub!");
    }

    public boolean hasThread() {
        throw new RuntimeException("Stub!");
    }

    public boolean isUnused() {
        throw new RuntimeException("Stub!");
    }

    public WaitingThread nextThread() {
        throw new RuntimeException("Stub!");
    }

    public void queueThread(WaitingThread waitingThread0) {
        throw new RuntimeException("Stub!");
    }

    public void removeThread(WaitingThread waitingThread0) {
        throw new RuntimeException("Stub!");
    }
}

