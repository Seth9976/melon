package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue {
    public interface RequestFilter {
        boolean apply(Request arg1);
    }

    public interface RequestFinishedListener {
        void onRequestFinished(Request arg1);
    }

    private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;
    private final Cache mCache;
    private CacheDispatcher mCacheDispatcher;
    private final PriorityBlockingQueue mCacheQueue;
    private final Set mCurrentRequests;
    private final ResponseDelivery mDelivery;
    private final NetworkDispatcher[] mDispatchers;
    private final List mFinishedListeners;
    private final Network mNetwork;
    private final PriorityBlockingQueue mNetworkQueue;
    private final AtomicInteger mSequenceGenerator;

    public RequestQueue(Cache cache0, Network network0) {
        this(cache0, network0, 4);
    }

    public RequestQueue(Cache cache0, Network network0, int v) {
        this(cache0, network0, v, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(Cache cache0, Network network0, int v, ResponseDelivery responseDelivery0) {
        this.mSequenceGenerator = new AtomicInteger();
        this.mCurrentRequests = new HashSet();
        this.mCacheQueue = new PriorityBlockingQueue();
        this.mNetworkQueue = new PriorityBlockingQueue();
        this.mFinishedListeners = new ArrayList();
        this.mCache = cache0;
        this.mNetwork = network0;
        this.mDispatchers = new NetworkDispatcher[v];
        this.mDelivery = responseDelivery0;
    }

    public Request add(Request request0) {
        request0.setRequestQueue(this);
        synchronized(this.mCurrentRequests) {
            this.mCurrentRequests.add(request0);
        }
        request0.setSequence(this.getSequenceNumber());
        request0.addMarker("add-to-queue");
        if(!request0.shouldCache()) {
            this.mNetworkQueue.add(request0);
            return request0;
        }
        this.mCacheQueue.add(request0);
        return request0;
    }

    public void addRequestFinishedListener(RequestFinishedListener requestQueue$RequestFinishedListener0) {
        synchronized(this.mFinishedListeners) {
            this.mFinishedListeners.add(requestQueue$RequestFinishedListener0);
        }
    }

    public void cancelAll(RequestFilter requestQueue$RequestFilter0) {
        synchronized(this.mCurrentRequests) {
            for(Object object0: this.mCurrentRequests) {
                Request request0 = (Request)object0;
                if(requestQueue$RequestFilter0.apply(request0)) {
                    request0.cancel();
                }
            }
        }
    }

    public void cancelAll(Object object0) {
        if(object0 == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        this.cancelAll(new RequestFilter() {
            @Override  // com.android.volley.RequestQueue$RequestFilter
            public boolean apply(Request request0) {
                return request0.getTag() == object0;
            }
        });
    }

    public void finish(Request request0) {
        synchronized(this.mCurrentRequests) {
            this.mCurrentRequests.remove(request0);
        }
        synchronized(this.mFinishedListeners) {
            for(Object object0: this.mFinishedListeners) {
                ((RequestFinishedListener)object0).onRequestFinished(request0);
            }
        }
    }

    public Cache getCache() {
        return this.mCache;
    }

    public int getSequenceNumber() {
        return this.mSequenceGenerator.incrementAndGet();
    }

    public void removeRequestFinishedListener(RequestFinishedListener requestQueue$RequestFinishedListener0) {
        synchronized(this.mFinishedListeners) {
            this.mFinishedListeners.remove(requestQueue$RequestFinishedListener0);
        }
    }

    public void start() {
        this.stop();
        CacheDispatcher cacheDispatcher0 = new CacheDispatcher(this.mCacheQueue, this.mNetworkQueue, this.mCache, this.mDelivery);
        this.mCacheDispatcher = cacheDispatcher0;
        cacheDispatcher0.start();
        for(int v = 0; v < this.mDispatchers.length; ++v) {
            NetworkDispatcher networkDispatcher0 = new NetworkDispatcher(this.mNetworkQueue, this.mNetwork, this.mCache, this.mDelivery);
            this.mDispatchers[v] = networkDispatcher0;
            networkDispatcher0.start();
        }
    }

    public void stop() {
        CacheDispatcher cacheDispatcher0 = this.mCacheDispatcher;
        if(cacheDispatcher0 != null) {
            cacheDispatcher0.quit();
        }
        NetworkDispatcher[] arr_networkDispatcher = this.mDispatchers;
        for(int v = 0; v < arr_networkDispatcher.length; ++v) {
            NetworkDispatcher networkDispatcher0 = arr_networkDispatcher[v];
            if(networkDispatcher0 != null) {
                networkDispatcher0.quit();
            }
        }
    }
}

