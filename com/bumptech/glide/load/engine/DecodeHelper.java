package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

final class DecodeHelper {
    private final List cacheKeys;
    private DiskCacheProvider diskCacheProvider;
    private DiskCacheStrategy diskCacheStrategy;
    private GlideContext glideContext;
    private int height;
    private boolean isCacheKeysSet;
    private boolean isLoadDataSet;
    private boolean isScaleOnlyOrNoTransform;
    private boolean isTransformationRequired;
    private final List loadData;
    private Object model;
    private Options options;
    private Priority priority;
    private Class resourceClass;
    private Key signature;
    private Class transcodeClass;
    private Map transformations;
    private int width;

    public DecodeHelper() {
        this.loadData = new ArrayList();
        this.cacheKeys = new ArrayList();
    }

    public void clear() {
        this.glideContext = null;
        this.model = null;
        this.signature = null;
        this.resourceClass = null;
        this.transcodeClass = null;
        this.options = null;
        this.priority = null;
        this.transformations = null;
        this.diskCacheStrategy = null;
        this.loadData.clear();
        this.isLoadDataSet = false;
        this.cacheKeys.clear();
        this.isCacheKeysSet = false;
    }

    public ArrayPool getArrayPool() {
        return this.glideContext.getArrayPool();
    }

    public List getCacheKeys() {
        if(!this.isCacheKeysSet) {
            this.isCacheKeysSet = true;
            this.cacheKeys.clear();
            List list0 = this.getLoadData();
            int v = list0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                LoadData modelLoader$LoadData0 = (LoadData)list0.get(v1);
                if(!this.cacheKeys.contains(modelLoader$LoadData0.sourceKey)) {
                    this.cacheKeys.add(modelLoader$LoadData0.sourceKey);
                }
                for(int v2 = 0; v2 < modelLoader$LoadData0.alternateKeys.size(); ++v2) {
                    Object object0 = modelLoader$LoadData0.alternateKeys.get(v2);
                    if(!this.cacheKeys.contains(object0)) {
                        Object object1 = modelLoader$LoadData0.alternateKeys.get(v2);
                        this.cacheKeys.add(object1);
                    }
                }
            }
        }
        return this.cacheKeys;
    }

    public DiskCache getDiskCache() {
        return this.diskCacheProvider.getDiskCache();
    }

    public DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public int getHeight() {
        return this.height;
    }

    public List getLoadData() {
        if(!this.isLoadDataSet) {
            this.isLoadDataSet = true;
            this.loadData.clear();
            List list0 = this.glideContext.getRegistry().getModelLoaders(this.model);
            int v = list0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                LoadData modelLoader$LoadData0 = ((ModelLoader)list0.get(v1)).buildLoadData(this.model, this.width, this.height, this.options);
                if(modelLoader$LoadData0 != null) {
                    this.loadData.add(modelLoader$LoadData0);
                }
            }
        }
        return this.loadData;
    }

    public LoadPath getLoadPath(Class class0) {
        return this.glideContext.getRegistry().getLoadPath(class0, this.resourceClass, this.transcodeClass);
    }

    public Class getModelClass() {
        return this.model.getClass();
    }

    public List getModelLoaders(File file0) {
        return this.glideContext.getRegistry().getModelLoaders(file0);
    }

    public Options getOptions() {
        return this.options;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public List getRegisteredResourceClasses() {
        return this.glideContext.getRegistry().getRegisteredResourceClasses(this.model.getClass(), this.resourceClass, this.transcodeClass);
    }

    public ResourceEncoder getResultEncoder(Resource resource0) {
        return this.glideContext.getRegistry().getResultEncoder(resource0);
    }

    public DataRewinder getRewinder(Object object0) {
        return this.glideContext.getRegistry().getRewinder(object0);
    }

    public Key getSignature() {
        return this.signature;
    }

    public Encoder getSourceEncoder(Object object0) {
        return this.glideContext.getRegistry().getSourceEncoder(object0);
    }

    public Class getTranscodeClass() {
        return this.transcodeClass;
    }

    public Transformation getTransformation(Class class0) {
        Transformation transformation0 = (Transformation)this.transformations.get(class0);
        if(transformation0 == null) {
            for(Object object0: this.transformations.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                if(((Class)map$Entry0.getKey()).isAssignableFrom(class0)) {
                    transformation0 = (Transformation)map$Entry0.getValue();
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        if(transformation0 == null) {
            if(this.transformations.isEmpty() && this.isTransformationRequired) {
                throw new IllegalArgumentException("Missing transformation for " + class0 + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return UnitTransformation.get();
        }
        return transformation0;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean hasLoadPath(Class class0) {
        return this.getLoadPath(class0) != null;
    }

    public void init(GlideContext glideContext0, Object object0, Key key0, int v, int v1, DiskCacheStrategy diskCacheStrategy0, Class class0, Class class1, Priority priority0, Options options0, Map map0, boolean z, boolean z1, DiskCacheProvider decodeJob$DiskCacheProvider0) {
        this.glideContext = glideContext0;
        this.model = object0;
        this.signature = key0;
        this.width = v;
        this.height = v1;
        this.diskCacheStrategy = diskCacheStrategy0;
        this.resourceClass = class0;
        this.diskCacheProvider = decodeJob$DiskCacheProvider0;
        this.transcodeClass = class1;
        this.priority = priority0;
        this.options = options0;
        this.transformations = map0;
        this.isTransformationRequired = z;
        this.isScaleOnlyOrNoTransform = z1;
    }

    public boolean isResourceEncoderAvailable(Resource resource0) {
        return this.glideContext.getRegistry().isResourceEncoderAvailable(resource0);
    }

    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public boolean isSourceKey(Key key0) {
        List list0 = this.getLoadData();
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            if(((LoadData)list0.get(v1)).sourceKey.equals(key0)) {
                return true;
            }
        }
        return false;
    }
}

