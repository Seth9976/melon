package com.bumptech.glide.request;

public final class ErrorRequestCoordinator implements Request, RequestCoordinator {
    private volatile Request error;
    private RequestState errorState;
    private final RequestCoordinator parent;
    private volatile Request primary;
    private RequestState primaryState;
    private final Object requestLock;

    public ErrorRequestCoordinator(Object object0, RequestCoordinator requestCoordinator0) {
        this.primaryState = RequestState.CLEARED;
        this.errorState = RequestState.CLEARED;
        this.requestLock = object0;
        this.parent = requestCoordinator0;
    }

    @Override  // com.bumptech.glide.request.Request
    public void begin() {
        synchronized(this.requestLock) {
            RequestState requestCoordinator$RequestState0 = RequestState.RUNNING;
            if(this.primaryState != requestCoordinator$RequestState0) {
                this.primaryState = requestCoordinator$RequestState0;
                this.primary.begin();
            }
        }
    }

    @Override  // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request0) {
        synchronized(this.requestLock) {
            return this.parentCanNotifyCleared() && request0.equals(this.primary);
        }
    }

    @Override  // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request0) {
        synchronized(this.requestLock) {
            return this.parentCanNotifyStatusChanged() && this.isValidRequestForStatusChanged(request0);
        }
    }

    @Override  // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request request0) {
        synchronized(this.requestLock) {
        }
        return this.parentCanSetImage();
    }

    @Override  // com.bumptech.glide.request.Request
    public void clear() {
        synchronized(this.requestLock) {
            RequestState requestCoordinator$RequestState0 = RequestState.CLEARED;
            this.primaryState = requestCoordinator$RequestState0;
            this.primary.clear();
            if(this.errorState != requestCoordinator$RequestState0) {
                this.errorState = requestCoordinator$RequestState0;
                this.error.clear();
            }
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
            return this.primary.isAnyResourceSet() || this.error.isAnyResourceSet();
        }
    }

    @Override  // com.bumptech.glide.request.Request
    public boolean isCleared() {
        synchronized(this.requestLock) {
        }
        return this.primaryState == RequestState.CLEARED && this.errorState == RequestState.CLEARED;
    }

    @Override  // com.bumptech.glide.request.Request
    public boolean isComplete() {
        synchronized(this.requestLock) {
        }
        return this.primaryState == RequestState.SUCCESS || this.errorState == RequestState.SUCCESS;
    }

    // 去混淆评级： 低(30)
    @Override  // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request0) {
        return request0 instanceof ErrorRequestCoordinator && this.primary.isEquivalentTo(((ErrorRequestCoordinator)request0).primary) && this.error.isEquivalentTo(((ErrorRequestCoordinator)request0).error);
    }

    @Override  // com.bumptech.glide.request.Request
    public boolean isRunning() {
        synchronized(this.requestLock) {
        }
        return this.primaryState == RequestState.RUNNING || this.errorState == RequestState.RUNNING;
    }

    // 去混淆评级： 低(20)
    private boolean isValidRequestForStatusChanged(Request request0) {
        return this.primaryState == RequestState.FAILED ? request0.equals(this.error) && (this.errorState == RequestState.SUCCESS || this.errorState == RequestState.FAILED) : request0.equals(this.primary);
    }

    @Override  // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request0) {
        synchronized(this.requestLock) {
            if(!request0.equals(this.error)) {
                this.primaryState = RequestState.FAILED;
                RequestState requestCoordinator$RequestState0 = RequestState.RUNNING;
                if(this.errorState != requestCoordinator$RequestState0) {
                    this.errorState = requestCoordinator$RequestState0;
                    this.error.begin();
                }
                return;
            }
            this.errorState = RequestState.FAILED;
            RequestCoordinator requestCoordinator0 = this.parent;
            if(requestCoordinator0 != null) {
                requestCoordinator0.onRequestFailed(this);
            }
        }
    }

    @Override  // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request0) {
        synchronized(this.requestLock) {
            if(request0.equals(this.primary)) {
                this.primaryState = RequestState.SUCCESS;
            }
            else if(request0.equals(this.error)) {
                this.errorState = RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator0 = this.parent;
            if(requestCoordinator0 != null) {
                requestCoordinator0.onRequestSuccess(this);
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
            RequestState requestCoordinator$RequestState0 = RequestState.RUNNING;
            if(this.primaryState == requestCoordinator$RequestState0) {
                this.primaryState = RequestState.PAUSED;
                this.primary.pause();
            }
            if(this.errorState == requestCoordinator$RequestState0) {
                this.errorState = RequestState.PAUSED;
                this.error.pause();
            }
        }
    }

    public void setRequests(Request request0, Request request1) {
        this.primary = request0;
        this.error = request1;
    }
}

