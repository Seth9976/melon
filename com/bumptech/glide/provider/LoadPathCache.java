package com.bumptech.glide.provider;

import androidx.collection.f;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LoadPathCache {
    private static final LoadPath NO_PATHS_SIGNAL;
    private final f cache;
    private final AtomicReference keyRef;

    static {
        List list0 = Collections.EMPTY_LIST;
        UnitTranscoder unitTranscoder0 = new UnitTranscoder();
        List list1 = Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, list0, unitTranscoder0, null));
        LoadPathCache.NO_PATHS_SIGNAL = new LoadPath(Object.class, Object.class, Object.class, list1, null);
    }

    public LoadPathCache() {
        this.cache = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.keyRef = new AtomicReference();
    }

    public LoadPath get(Class class0, Class class1, Class class2) {
        LoadPath loadPath0;
        MultiClassKey multiClassKey0 = this.getKey(class0, class1, class2);
        synchronized(this.cache) {
            loadPath0 = (LoadPath)this.cache.get(multiClassKey0);
        }
        this.keyRef.set(multiClassKey0);
        return loadPath0;
    }

    private MultiClassKey getKey(Class class0, Class class1, Class class2) {
        MultiClassKey multiClassKey0 = (MultiClassKey)this.keyRef.getAndSet(null);
        if(multiClassKey0 == null) {
            multiClassKey0 = new MultiClassKey();
        }
        multiClassKey0.set(class0, class1, class2);
        return multiClassKey0;
    }

    public boolean isEmptyLoadPath(LoadPath loadPath0) {
        return LoadPathCache.NO_PATHS_SIGNAL.equals(loadPath0);
    }

    public void put(Class class0, Class class1, Class class2, LoadPath loadPath0) {
        synchronized(this.cache) {
            f f1 = this.cache;
            MultiClassKey multiClassKey0 = new MultiClassKey(class0, class1, class2);
            if(loadPath0 == null) {
                loadPath0 = LoadPathCache.NO_PATHS_SIGNAL;
            }
            f1.put(multiClassKey0, loadPath0);
        }
    }
}

