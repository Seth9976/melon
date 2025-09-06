package com.bumptech.glide.request;

public class ThumbnailRequestCoordinator implements Request, RequestCoordinator {
    private volatile Request full;
    private RequestState fullState;
    private boolean isRunningDuringBegin;
    private final RequestCoordinator parent;
    private final Object requestLock;
    private volatile Request thumb;
    private RequestState thumbState;

    public ThumbnailRequestCoordinator(Object object0, RequestCoordinator requestCoordinator0) {
        this.fullState = RequestState.CLEARED;
        this.thumbState = RequestState.CLEARED;
        this.requestLock = object0;
        this.parent = requestCoordinator0;
    }

    @Override  // com.bumptech.glide.request.Request
    public void begin() {
        synchronized(this.requestLock) {
            this.isRunningDuringBegin = true;
            try {
                if(this.fullState != RequestState.SUCCESS) {
                    RequestState requestCoordinator$RequestState0 = RequestState.RUNNING;
                    if(this.thumbState != requestCoordinator$RequestState0) {
                        this.thumbState = requestCoordinator$RequestState0;
                        this.thumb.begin();
                    }
                }
                if(this.isRunningDuringBegin) {
                    RequestState requestCoordinator$RequestState1 = RequestState.RUNNING;
                    if(this.fullState != requestCoordinator$RequestState1) {
                        this.fullState = requestCoordinator$RequestState1;
                        this.full.begin();
                    }
                }
            }
            finally {
                this.isRunningDuringBegin = false;
            }
        }
    }

    @Override  // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request0) {
        synchronized(this.requestLock) {
            return this.parentCanNotifyCleared() && request0.equals(this.full) && this.fullState != RequestState.PAUSED;
        }
    }

    @Override  // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request0) {
        synchronized(this.requestLock) {
            return this.parentCanNotifyStatusChanged() && request0.equals(this.full) && !this.isAnyResourceSet();
        }
    }

    @Override  // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request request0) {
        synchronized(this.requestLock) {
            return this.parentCanSetImage() && (request0.equals(this.full) || this.fullState != RequestState.SUCCESS);
        }
    }

    @Override  // com.bumptech.glide.request.Request
    public void clear() {
        synchronized(this.requestLock) {
            this.isRunningDuringBegin = false;
            this.fullState = RequestState.CLEARED;
            this.thumbState = RequestState.CLEARED;
            this.thumb.clear();
            this.full.clear();
        }
    }

    @Override  // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        synchronized(this.requestLock) {
            RequestCoordinator requestCoordinator0 = this.parent;
            return requestCoordinator0 == null ? this : requestCoordinator0.getRoot();
        }
    }

    @Override  // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        synchronized(this.requestLock) {
            return this.thumb.isAnyResourceSet() || this.full.isAnyResourceSet();
        }
    }

    @Override  // com.bumptech.glide.request.Request
    public boolean isCleared() {
        synchronized(this.requestLock) {
        }
        return this.fullState == RequestState.CLEARED;
    }

    @Override  // com.bumptech.glide.request.Request
    public boolean isComplete() {
        synchronized(this.requestLock) {
        }
        return this.fullState == RequestState.SUCCESS;
    }

    @Override  // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request0) {
        if(request0 instanceof ThumbnailRequestCoordinator) {
            if(this.full == null) {
                if(((ThumbnailRequestCoordinator)request0).full == null) {
                    return this.thumb == null ? ((ThumbnailRequestCoordinator)request0).thumb == null : this.thumb.isEquivalentTo(((ThumbnailRequestCoordinator)request0).thumb);
                }
            }
            else if(this.full.isEquivalentTo(((ThumbnailRequestCoordinator)request0).full)) {
                return this.thumb == null ? ((ThumbnailRequestCoordinator)request0).thumb == null : this.thumb.isEquivalentTo(((ThumbnailRequestCoordinator)request0).thumb);
            }
        }
        return false;
    }

    @Override  // com.bumptech.glide.request.Request
    public boolean isRunning() {
        synchronized(this.requestLock) {
        }
        return this.fullState == RequestState.RUNNING;
    }

    @Override  // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request0) {
        synchronized(this.requestLock) {
            if(!request0.equals(this.full)) {
                this.thumbState = RequestState.FAILED;
                return;
            }
            this.fullState = RequestState.FAILED;
            RequestCoordinator requestCoordinator0 = this.parent;
            if(requestCoordinator0 != null) {
                requestCoordinator0.onRequestFailed(this);
            }
        }
    }

    @Override  // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request0) {
        synchronized(this.requestLock) {
            if(request0.equals(this.thumb)) {
                this.thumbState = RequestState.SUCCESS;
                return;
            }
            this.fullState = RequestState.SUCCESS;
            RequestCoordinator requestCoordinator0 = this.parent;
            if(requestCoordinator0 != null) {
                requestCoordinator0.onRequestSuccess(this);
            }
            if(!this.thumbState.isComplete()) {
                this.thumb.clear();
            }
        }
    }

    private boolean parentCanNotifyCleared() {
        return this.parent == null || this.parent.canNotifyCleared(this);
    }

    private boolean parentCanNotifyStatusChanged() {
        return this.parent == null || this.parent.canNotifyStatusChanged(this);
    }

    private boolean parentCanSetImage() {
        return this.parent == null || this.parent.canSetImage(this);
    }

    @Override  // com.bumptech.glide.request.Request
    public void pause() {
        synchronized(this.requestLock) {
            if(!this.thumbState.isComplete()) {
                this.thumbState = RequestState.PAUSED;
                this.thumb.pause();
            }
            if(!this.fullState.isComplete()) {
                this.fullState = RequestState.PAUSED;
                this.full.pause();
            }
        }
    }

    public void setRequests(Request request0, Request request1) {
        this.full = request0;
        this.thumb = request1;
    }
}

