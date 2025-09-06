package com.bumptech.glide.manager;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class TargetTracker implements LifecycleListener {
    private final Set targets;

    public TargetTracker() {
        this.targets = Collections.newSetFromMap(new WeakHashMap());
    }

    public void clear() {
        this.targets.clear();
    }

    public List getAll() {
        return Util.getSnapshot(this.targets);
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        for(Object object0: Util.getSnapshot(this.targets)) {
            ((Target)object0).onDestroy();
        }
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        for(Object object0: Util.getSnapshot(this.targets)) {
            ((Target)object0).onStart();
        }
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        for(Object object0: Util.getSnapshot(this.targets)) {
            ((Target)object0).onStop();
        }
    }

    public void track(Target target0) {
        this.targets.add(target0);
    }

    public void untrack(Target target0) {
        this.targets.remove(target0);
    }
}

