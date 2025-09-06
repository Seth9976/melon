package com.android.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Request.Priority;
import com.android.volley.Request;
import com.android.volley.Response;

public class ClearCacheRequest extends Request {
    private final Cache mCache;
    private final Runnable mCallback;

    public ClearCacheRequest(Cache cache0, Runnable runnable0) {
        super(0, null, null);
        this.mCache = cache0;
        this.mCallback = runnable0;
    }

    @Override  // com.android.volley.Request
    public void deliverResponse(Object object0) {
    }

    @Override  // com.android.volley.Request
    public Priority getPriority() {
        return Priority.IMMEDIATE;
    }

    @Override  // com.android.volley.Request
    public boolean isCanceled() {
        this.mCache.clear();
        if(this.mCallback != null) {
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.mCallback);
        }
        return true;
    }

    @Override  // com.android.volley.Request
    public Response parseNetworkResponse(NetworkResponse networkResponse0) {
        return null;
    }
}

