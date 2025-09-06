package com.bumptech.glide.manager;

class ApplicationLifecycle implements Lifecycle {
    @Override  // com.bumptech.glide.manager.Lifecycle
    public void addListener(LifecycleListener lifecycleListener0) {
        lifecycleListener0.onStart();
    }

    @Override  // com.bumptech.glide.manager.Lifecycle
    public void removeListener(LifecycleListener lifecycleListener0) {
    }
}

