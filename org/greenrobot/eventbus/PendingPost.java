package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

final class PendingPost {
    Object event;
    PendingPost next;
    private static final List pendingPostPool;
    Subscription subscription;

    static {
        PendingPost.pendingPostPool = new ArrayList();
    }

    private PendingPost(Object object0, Subscription subscription0) {
        this.event = object0;
        this.subscription = subscription0;
    }

    public static PendingPost obtainPendingPost(Subscription subscription0, Object object0) {
        List list0 = PendingPost.pendingPostPool;
        synchronized(list0) {
            int v1 = list0.size();
            if(v1 > 0) {
                PendingPost pendingPost0 = (PendingPost)list0.remove(v1 - 1);
                pendingPost0.event = object0;
                pendingPost0.subscription = subscription0;
                pendingPost0.next = null;
                return pendingPost0;
            }
        }
        return new PendingPost(object0, subscription0);
    }

    public static void releasePendingPost(PendingPost pendingPost0) {
        pendingPost0.event = null;
        pendingPost0.subscription = null;
        pendingPost0.next = null;
        List list0 = PendingPost.pendingPostPool;
        synchronized(list0) {
            if(list0.size() < 10000) {
                list0.add(pendingPost0);
            }
        }
    }
}

