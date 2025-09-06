package com.bumptech.glide.load.model;

import b2.d;
import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelLoaderRegistry {
    static class ModelLoaderCache {
        static class Entry {
            final List loaders;

            public Entry(List list0) {
                this.loaders = list0;
            }
        }

        private final Map cachedModelLoaders;

        public ModelLoaderCache() {
            this.cachedModelLoaders = new HashMap();
        }

        public void clear() {
            this.cachedModelLoaders.clear();
        }

        public List get(Class class0) {
            Entry modelLoaderRegistry$ModelLoaderCache$Entry0 = (Entry)this.cachedModelLoaders.get(class0);
            return modelLoaderRegistry$ModelLoaderCache$Entry0 == null ? null : modelLoaderRegistry$ModelLoaderCache$Entry0.loaders;
        }

        public void put(Class class0, List list0) {
            Entry modelLoaderRegistry$ModelLoaderCache$Entry0 = new Entry(list0);
            if(((Entry)this.cachedModelLoaders.put(class0, modelLoaderRegistry$ModelLoaderCache$Entry0)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + class0);
            }
        }
    }

    private final ModelLoaderCache cache;
    private final MultiModelLoaderFactory multiModelLoaderFactory;

    public ModelLoaderRegistry(d d0) {
        this(new MultiModelLoaderFactory(d0));
    }

    private ModelLoaderRegistry(MultiModelLoaderFactory multiModelLoaderFactory0) {
        this.cache = new ModelLoaderCache();
        this.multiModelLoaderFactory = multiModelLoaderFactory0;
    }

    public void append(Class class0, Class class1, ModelLoaderFactory modelLoaderFactory0) {
        synchronized(this) {
            this.multiModelLoaderFactory.append(class0, class1, modelLoaderFactory0);
            this.cache.clear();
        }
    }

    public ModelLoader build(Class class0, Class class1) {
        synchronized(this) {
            return this.multiModelLoaderFactory.build(class0, class1);
        }
    }

    private static Class getClass(Object object0) {
        return object0.getClass();
    }

    public List getDataClasses(Class class0) {
        synchronized(this) {
            return this.multiModelLoaderFactory.getDataClasses(class0);
        }
    }

    public List getModelLoaders(Object object0) {
        List list0 = this.getModelLoadersForClass(ModelLoaderRegistry.getClass(object0));
        if(list0.isEmpty()) {
            throw new NoModelLoaderAvailableException(object0);
        }
        int v = list0.size();
        List list1 = Collections.EMPTY_LIST;
        boolean z = true;
        for(int v1 = 0; v1 < v; ++v1) {
            ModelLoader modelLoader0 = (ModelLoader)list0.get(v1);
            if(modelLoader0.handles(object0)) {
                if(z) {
                    list1 = new ArrayList(v - v1);
                    z = false;
                }
                list1.add(modelLoader0);
            }
        }
        if(list1.isEmpty()) {
            throw new NoModelLoaderAvailableException(object0, list0);
        }
        return list1;
    }

    private List getModelLoadersForClass(Class class0) {
        synchronized(this) {
            List list0 = this.cache.get(class0);
            if(list0 == null) {
                list0 = Collections.unmodifiableList(this.multiModelLoaderFactory.build(class0));
                this.cache.put(class0, list0);
            }
            return list0;
        }
    }

    public void prepend(Class class0, Class class1, ModelLoaderFactory modelLoaderFactory0) {
        synchronized(this) {
            this.multiModelLoaderFactory.prepend(class0, class1, modelLoaderFactory0);
            this.cache.clear();
        }
    }

    public void remove(Class class0, Class class1) {
        synchronized(this) {
            this.tearDown(this.multiModelLoaderFactory.remove(class0, class1));
            this.cache.clear();
        }
    }

    public void replace(Class class0, Class class1, ModelLoaderFactory modelLoaderFactory0) {
        synchronized(this) {
            this.tearDown(this.multiModelLoaderFactory.replace(class0, class1, modelLoaderFactory0));
            this.cache.clear();
        }
    }

    private void tearDown(List list0) {
        for(Object object0: list0) {
            ((ModelLoaderFactory)object0).teardown();
        }
    }
}

