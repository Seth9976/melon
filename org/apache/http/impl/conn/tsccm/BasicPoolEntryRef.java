package org.apache.http.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import org.apache.http.conn.routing.HttpRoute;

@Deprecated
public class BasicPoolEntryRef extends WeakReference {
    public BasicPoolEntryRef(BasicPoolEntry basicPoolEntry0, ReferenceQueue referenceQueue0) {
        super(null, null);
        throw new RuntimeException("Stub!");
    }

    public final HttpRoute getRoute() {
        throw new RuntimeException("Stub!");
    }
}

