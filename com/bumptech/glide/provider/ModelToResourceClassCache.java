package com.bumptech.glide.provider;

import androidx.collection.f;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ModelToResourceClassCache {
    private final f registeredResourceClassCache;
    private final AtomicReference resourceClassKeyRef;

    public ModelToResourceClassCache() {
        this.resourceClassKeyRef = new AtomicReference();
        this.registeredResourceClassCache = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
    }

    public void clear() {
        synchronized(this.registeredResourceClassCache) {
            this.registeredResourceClassCache.clear();
        }
    }

    public List get(Class class0, Class class1, Class class2) {
        List list0;
        MultiClassKey multiClassKey0 = (MultiClassKey)this.resourceClassKeyRef.getAndSet(null);
        if(multiClassKey0 == null) {
            multiClassKey0 = new MultiClassKey(class0, class1, class2);
        }
        else {
            multiClassKey0.set(class0, class1, class2);
        }
        synchronized(this.registeredResourceClassCache) {
            list0 = (List)this.registeredResourceClassCache.get(multiClassKey0);
        }
        this.resourceClassKeyRef.set(multiClassKey0);
        return list0;
    }

    public void put(Class class0, Class class1, Class class2, List list0) {
        synchronized(this.registeredResourceClassCache) {
            MultiClassKey multiClassKey0 = new MultiClassKey(class0, class1, class2);
            this.registeredResourceClassCache.put(multiClassKey0, list0);
        }
    }
}

