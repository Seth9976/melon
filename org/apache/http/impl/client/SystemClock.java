package org.apache.http.impl.client;

class SystemClock implements Clock {
    @Override  // org.apache.http.impl.client.Clock
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
}

