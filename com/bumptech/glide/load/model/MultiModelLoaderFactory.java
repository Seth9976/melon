package com.bumptech.glide.load.model;

import b2.d;
import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultiModelLoaderFactory {
    static class EmptyModelLoader implements ModelLoader {
        @Override  // com.bumptech.glide.load.model.ModelLoader
        public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
            return null;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoader
        public boolean handles(Object object0) {
            return false;
        }
    }

    static class Entry {
        final Class dataClass;
        final ModelLoaderFactory factory;
        private final Class modelClass;

        public Entry(Class class0, Class class1, ModelLoaderFactory modelLoaderFactory0) {
            this.modelClass = class0;
            this.dataClass = class1;
            this.factory = modelLoaderFactory0;
        }

        public boolean handles(Class class0) {
            return this.modelClass.isAssignableFrom(class0);
        }

        // 去混淆评级： 低(20)
        public boolean handles(Class class0, Class class1) {
            return this.handles(class0) && this.dataClass.isAssignableFrom(class1);
        }
    }

    static class Factory {
        public MultiModelLoader build(List list0, d d0) {
            return new MultiModelLoader(list0, d0);
        }
    }

    private static final Factory DEFAULT_FACTORY;
    private static final ModelLoader EMPTY_MODEL_LOADER;
    private final Set alreadyUsedEntries;
    private final List entries;
    private final Factory factory;
    private final d throwableListPool;

    static {
        MultiModelLoaderFactory.DEFAULT_FACTORY = new Factory();
        MultiModelLoaderFactory.EMPTY_MODEL_LOADER = new EmptyModelLoader();
    }

    public MultiModelLoaderFactory(d d0) {
        this(d0, MultiModelLoaderFactory.DEFAULT_FACTORY);
    }

    public MultiModelLoaderFactory(d d0, Factory multiModelLoaderFactory$Factory0) {
        this.entries = new ArrayList();
        this.alreadyUsedEntries = new HashSet();
        this.throwableListPool = d0;
        this.factory = multiModelLoaderFactory$Factory0;
    }

    private void add(Class class0, Class class1, ModelLoaderFactory modelLoaderFactory0, boolean z) {
        Entry multiModelLoaderFactory$Entry0 = new Entry(class0, class1, modelLoaderFactory0);
        this.entries.add((z ? this.entries.size() : 0), multiModelLoaderFactory$Entry0);
    }

    public void append(Class class0, Class class1, ModelLoaderFactory modelLoaderFactory0) {
        synchronized(this) {
            this.add(class0, class1, modelLoaderFactory0, true);
        }
    }

    private ModelLoader build(Entry multiModelLoaderFactory$Entry0) {
        return (ModelLoader)Preconditions.checkNotNull(multiModelLoaderFactory$Entry0.factory.build(this));
    }

    public ModelLoader build(Class class0, Class class1) {
        ModelLoader modelLoader1;
        ModelLoader modelLoader0;
        ArrayList arrayList0;
        __monitor_enter(this);
        try {
            arrayList0 = new ArrayList();
            boolean z = false;
            for(Object object0: this.entries) {
                Entry multiModelLoaderFactory$Entry0 = (Entry)object0;
                if(this.alreadyUsedEntries.contains(multiModelLoaderFactory$Entry0)) {
                    z = true;
                }
                else if(multiModelLoaderFactory$Entry0.handles(class0, class1)) {
                    this.alreadyUsedEntries.add(multiModelLoaderFactory$Entry0);
                    arrayList0.add(this.build(multiModelLoaderFactory$Entry0));
                    this.alreadyUsedEntries.remove(multiModelLoaderFactory$Entry0);
                }
            }
            if(arrayList0.size() > 1) {
                modelLoader0 = this.factory.build(arrayList0, this.throwableListPool);
                goto label_17;
            }
            goto label_19;
        }
        catch(Throwable throwable0) {
            goto label_28;
        }
    label_17:
        __monitor_exit(this);
        return modelLoader0;
        try {
        label_19:
            if(arrayList0.size() == 1) {
                modelLoader1 = (ModelLoader)arrayList0.get(0);
                goto label_21;
            }
            goto label_23;
        }
        catch(Throwable throwable0) {
            goto label_28;
        }
    label_21:
        __monitor_exit(this);
        return modelLoader1;
    label_23:
        if(z) {
            __monitor_exit(this);
            return MultiModelLoaderFactory.emptyModelLoader();
        }
        try {
            throw new NoModelLoaderAvailableException(class0, class1);
        }
        catch(Throwable throwable0) {
        }
        try {
        label_28:
            this.alreadyUsedEntries.clear();
            throw throwable0;
        }
        catch(Throwable throwable1) {
            __monitor_exit(this);
            throw throwable1;
        }
    }

    public List build(Class class0) {
        List list0;
        __monitor_enter(this);
        try {
            list0 = new ArrayList();
            for(Object object0: this.entries) {
                Entry multiModelLoaderFactory$Entry0 = (Entry)object0;
                if(!this.alreadyUsedEntries.contains(multiModelLoaderFactory$Entry0) && multiModelLoaderFactory$Entry0.handles(class0)) {
                    this.alreadyUsedEntries.add(multiModelLoaderFactory$Entry0);
                    ((ArrayList)list0).add(this.build(multiModelLoaderFactory$Entry0));
                    this.alreadyUsedEntries.remove(multiModelLoaderFactory$Entry0);
                }
            }
        }
        catch(Throwable throwable0) {
            try {
                this.alreadyUsedEntries.clear();
                throw throwable0;
            }
            catch(Throwable throwable1) {
                __monitor_exit(this);
                throw throwable1;
            }
        }
        __monitor_exit(this);
        return list0;
    }

    private static ModelLoader emptyModelLoader() {
        return MultiModelLoaderFactory.EMPTY_MODEL_LOADER;
    }

    public List getDataClasses(Class class0) {
        synchronized(this) {
            List list0 = new ArrayList();
            for(Object object0: this.entries) {
                Entry multiModelLoaderFactory$Entry0 = (Entry)object0;
                if(!((ArrayList)list0).contains(multiModelLoaderFactory$Entry0.dataClass) && multiModelLoaderFactory$Entry0.handles(class0)) {
                    ((ArrayList)list0).add(multiModelLoaderFactory$Entry0.dataClass);
                }
            }
            return list0;
        }
    }

    private ModelLoaderFactory getFactory(Entry multiModelLoaderFactory$Entry0) {
        return multiModelLoaderFactory$Entry0.factory;
    }

    public void prepend(Class class0, Class class1, ModelLoaderFactory modelLoaderFactory0) {
        synchronized(this) {
            this.add(class0, class1, modelLoaderFactory0, false);
        }
    }

    public List remove(Class class0, Class class1) {
        synchronized(this) {
            List list0 = new ArrayList();
            Iterator iterator0 = this.entries.iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                Entry multiModelLoaderFactory$Entry0 = (Entry)object0;
                if(multiModelLoaderFactory$Entry0.handles(class0, class1)) {
                    iterator0.remove();
                    ((ArrayList)list0).add(this.getFactory(multiModelLoaderFactory$Entry0));
                }
            }
            return list0;
        }
    }

    public List replace(Class class0, Class class1, ModelLoaderFactory modelLoaderFactory0) {
        synchronized(this) {
            List list0 = this.remove(class0, class1);
            this.append(class0, class1, modelLoaderFactory0);
            return list0;
        }
    }
}

