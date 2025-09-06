package com.bumptech.glide.manager;

import android.util.Log;
import androidx.appcompat.app.o;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {
    private static final String TAG = "RequestTracker";
    private boolean isPaused;
    private final Set pendingRequests;
    private final Set requests;

    public RequestTracker() {
        this.requests = Collections.newSetFromMap(new WeakHashMap());
        this.pendingRequests = new HashSet();
    }

    public void addRequest(Request request0) {
        this.requests.add(request0);
    }

    public boolean clearAndRemove(Request request0) {
        if(request0 == null) {
            return true;
        }
        boolean z = this.requests.remove(request0);
        if(!this.pendingRequests.remove(request0) && !z) {
            return false;
        }
        request0.clear();
        return true;
    }

    public void clearRequests() {
        for(Object object0: Util.getSnapshot(this.requests)) {
            this.clearAndRemove(((Request)object0));
        }
        this.pendingRequests.clear();
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void pauseAllRequests() {
        this.isPaused = true;
        for(Object object0: Util.getSnapshot(this.requests)) {
            Request request0 = (Request)object0;
            if(request0.isRunning() || request0.isComplete()) {
                request0.clear();
                this.pendingRequests.add(request0);
            }
        }
    }

    public void pauseRequests() {
        this.isPaused = true;
        for(Object object0: Util.getSnapshot(this.requests)) {
            Request request0 = (Request)object0;
            if(request0.isRunning()) {
                request0.pause();
                this.pendingRequests.add(request0);
            }
        }
    }

    public void restartRequests() {
        for(Object object0: Util.getSnapshot(this.requests)) {
            Request request0 = (Request)object0;
            if(!request0.isComplete() && !request0.isCleared()) {
                request0.clear();
                if(this.isPaused) {
                    this.pendingRequests.add(request0);
                }
                else {
                    request0.begin();
                }
            }
        }
    }

    public void resumeRequests() {
        this.isPaused = false;
        for(Object object0: Util.getSnapshot(this.requests)) {
            Request request0 = (Request)object0;
            if(!request0.isComplete() && !request0.isRunning()) {
                request0.begin();
            }
        }
        this.pendingRequests.clear();
    }

    public void runRequest(Request request0) {
        this.requests.add(request0);
        if(!this.isPaused) {
            request0.begin();
            return;
        }
        request0.clear();
        if(Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.pendingRequests.add(request0);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(super.toString());
        stringBuilder0.append("{numRequests=");
        stringBuilder0.append(this.requests.size());
        stringBuilder0.append(", isPaused=");
        return o.s(stringBuilder0, this.isPaused, "}");
    }
}

