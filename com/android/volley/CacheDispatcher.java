package com.android.volley;

import android.os.Process;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class CacheDispatcher extends Thread {
    static class WaitingRequestManager implements NetworkRequestCompleteListener {
        private final CacheDispatcher mCacheDispatcher;
        private final Map mWaitingRequests;

        public WaitingRequestManager(CacheDispatcher cacheDispatcher0) {
            this.mWaitingRequests = new HashMap();
            this.mCacheDispatcher = cacheDispatcher0;
        }

        public static boolean a(WaitingRequestManager cacheDispatcher$WaitingRequestManager0, Request request0) {
            return cacheDispatcher$WaitingRequestManager0.maybeAddToWaitingRequests(request0);
        }

        private boolean maybeAddToWaitingRequests(Request request0) {
            synchronized(this) {
                String s = request0.getCacheKey();
                if(this.mWaitingRequests.containsKey(s)) {
                    List list0 = (List)this.mWaitingRequests.get(s);
                    if(list0 == null) {
                        list0 = new ArrayList();
                    }
                    request0.addMarker("waiting-for-response");
                    list0.add(request0);
                    this.mWaitingRequests.put(s, list0);
                    if(VolleyLog.DEBUG) {
                        VolleyLog.d("Request for cacheKey=%s is in flight, putting on hold.", new Object[]{s});
                    }
                    return true;
                }
                this.mWaitingRequests.put(s, null);
                request0.setNetworkRequestCompleteListener(this);
                if(VolleyLog.DEBUG) {
                    VolleyLog.d("new request, sending to network %s", new Object[]{s});
                }
                return false;
            }
        }

        @Override  // com.android.volley.Request$NetworkRequestCompleteListener
        public void onNoUsableResponseReceived(Request request0) {
            synchronized(this) {
                String s = request0.getCacheKey();
                List list0 = (List)this.mWaitingRequests.remove(s);
                if(list0 != null && !list0.isEmpty()) {
                    if(VolleyLog.DEBUG) {
                        VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", new Object[]{list0.size(), s});
                    }
                    Request request1 = (Request)list0.remove(0);
                    this.mWaitingRequests.put(s, list0);
                    request1.setNetworkRequestCompleteListener(this);
                    try {
                        this.mCacheDispatcher.mNetworkQueue.put(request1);
                    }
                    catch(InterruptedException interruptedException0) {
                        VolleyLog.e("Couldn\'t add request to queue. %s", new Object[]{interruptedException0.toString()});
                        Thread.currentThread().interrupt();
                        this.mCacheDispatcher.quit();
                    }
                }
            }
        }

        @Override  // com.android.volley.Request$NetworkRequestCompleteListener
        public void onResponseReceived(Request request0, Response response0) {
            List list0;
            if(response0.cacheEntry != null && !response0.cacheEntry.isExpired()) {
                String s = request0.getCacheKey();
                synchronized(this) {
                    list0 = (List)this.mWaitingRequests.remove(s);
                }
                if(list0 != null) {
                    if(VolleyLog.DEBUG) {
                        VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", new Object[]{list0.size(), s});
                    }
                    for(Object object0: list0) {
                        this.mCacheDispatcher.mDelivery.postResponse(((Request)object0), response0);
                    }
                }
                return;
            }
            this.onNoUsableResponseReceived(request0);
        }
    }

    private static final boolean DEBUG;
    private final Cache mCache;
    private final BlockingQueue mCacheQueue;
    private final ResponseDelivery mDelivery;
    private final BlockingQueue mNetworkQueue;
    private volatile boolean mQuit;
    private final WaitingRequestManager mWaitingRequestManager;

    static {
        CacheDispatcher.DEBUG = VolleyLog.DEBUG;
    }

    public CacheDispatcher(BlockingQueue blockingQueue0, BlockingQueue blockingQueue1, Cache cache0, ResponseDelivery responseDelivery0) {
        this.mQuit = false;
        this.mCacheQueue = blockingQueue0;
        this.mNetworkQueue = blockingQueue1;
        this.mCache = cache0;
        this.mDelivery = responseDelivery0;
        this.mWaitingRequestManager = new WaitingRequestManager(this);
    }

    private void processRequest() {
        this.processRequest(((Request)this.mCacheQueue.take()));
    }

    public void processRequest(Request request0) {
        request0.addMarker("cache-queue-take");
        if(request0.isCanceled()) {
            request0.finish("cache-discard-canceled");
            return;
        }
        String s = request0.getCacheKey();
        Entry cache$Entry0 = this.mCache.get(s);
        if(cache$Entry0 == null) {
            request0.addMarker("cache-miss");
            if(WaitingRequestManager.a(this.mWaitingRequestManager, request0)) {
                return;
            }
            this.mNetworkQueue.put(request0);
            return;
        }
        if(cache$Entry0.isExpired()) {
            request0.addMarker("cache-hit-expired");
            request0.setCacheEntry(cache$Entry0);
            if(!WaitingRequestManager.a(this.mWaitingRequestManager, request0)) {
                this.mNetworkQueue.put(request0);
            }
            return;
        }
        request0.addMarker("cache-hit");
        Response response0 = request0.parseNetworkResponse(new NetworkResponse(cache$Entry0.data, cache$Entry0.responseHeaders));
        request0.addMarker("cache-hit-parsed");
        if(!cache$Entry0.refreshNeeded()) {
            this.mDelivery.postResponse(request0, response0);
            return;
        }
        request0.addMarker("cache-hit-refresh-needed");
        request0.setCacheEntry(cache$Entry0);
        response0.intermediate = true;
        if(!WaitingRequestManager.a(this.mWaitingRequestManager, request0)) {
            com.android.volley.CacheDispatcher.1 cacheDispatcher$10 = new Runnable() {
                @Override
                public void run() {
                    try {
                        CacheDispatcher.this.mNetworkQueue.put(request0);
                    }
                    catch(InterruptedException unused_ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            };
            this.mDelivery.postResponse(request0, response0, cacheDispatcher$10);
            return;
        }
        this.mDelivery.postResponse(request0, response0);
    }

    public void quit() {
        this.mQuit = true;
        this.interrupt();
    }

    @Override
    public void run() {
        if(CacheDispatcher.DEBUG) {
            VolleyLog.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.mCache.initialize();
        while(true) {
            try {
            label_4:
                this.processRequest();
                goto label_4;
            }
            catch(InterruptedException unused_ex) {
            }
            if(this.mQuit) {
                break;
            }
            VolleyLog.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
        }
        Thread.currentThread().interrupt();
    }
}

