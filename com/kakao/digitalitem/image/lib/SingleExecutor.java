package com.kakao.digitalitem.image.lib;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class SingleExecutor {
    private static final int SIZE_LIMIT = 0x80;
    private final ExecutorService executorService;
    private final Map queue;

    public SingleExecutor() {
        this.executorService = Executors.newSingleThreadExecutor();
        this.queue = new ConcurrentHashMap(0x80) {
            @Override
            public Object put(Object object0, Object object1) {
                return this.put(((Integer)object0), ((Future)object1));
            }

            public Future put(Integer integer0, Future future0) {
                if(this.size() >= 0x80) {
                    for(Object object0: this.keySet()) {
                        if(this.removeFutureIfDone(((int)(((Integer)object0))))) {
                            break;
                        }
                    }
                }
                return (Future)super.put(integer0, future0);
            }

            private boolean removeFutureIfDone(int v) {
                Future future0 = (Future)this.get(v);
                if(future0 != null && future0.isDone()) {
                    this.remove(v);
                    return true;
                }
                return false;
            }
        };
    }

    public void cancel(int v) {
        Future future0 = (Future)this.queue.remove(v);
        if(future0 != null) {
            future0.cancel(true);
        }
    }

    public void execute(int v, Runnable runnable0) {
        Future future0 = this.executorService.submit(runnable0);
        Future future1 = (Future)this.queue.put(v, future0);
        if(future1 != null) {
            future1.cancel(true);
        }
    }

    public void remove(int v) {
        this.queue.remove(v);
    }
}

