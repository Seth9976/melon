package com.bumptech.glide;

import b2.d;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder.Factory;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Registry {
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String s) {
            super(s);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Class class0, Class class1) {
            super("Failed to find any ModelLoaders for model: " + class0 + " and data: " + class1);
        }

        public NoModelLoaderAvailableException(Object object0) {
            super("Failed to find any ModelLoaders registered for model class: " + object0.getClass());
        }

        public NoModelLoaderAvailableException(Object object0, List list0) {
            super("Found ModelLoaders for model class: " + list0 + ", but none that handle this specific model instance: " + object0);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class class0) {
            super("Failed to find result encoder for resource class: " + class0 + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class class0) {
            super("Failed to find source encoder for data class: " + class0);
        }
    }

    public static final String BUCKET_ANIMATION = "Animation";
    private static final String BUCKET_APPEND_ALL = "legacy_append";
    public static final String BUCKET_BITMAP = "Bitmap";
    public static final String BUCKET_BITMAP_DRAWABLE = "BitmapDrawable";
    @Deprecated
    public static final String BUCKET_GIF = "Animation";
    private static final String BUCKET_PREPEND_ALL = "legacy_prepend_all";
    private final DataRewinderRegistry dataRewinderRegistry;
    private final ResourceDecoderRegistry decoderRegistry;
    private final EncoderRegistry encoderRegistry;
    private final ImageHeaderParserRegistry imageHeaderParserRegistry;
    private final LoadPathCache loadPathCache;
    private final ModelLoaderRegistry modelLoaderRegistry;
    private final ModelToResourceClassCache modelToResourceClassCache;
    private final ResourceEncoderRegistry resourceEncoderRegistry;
    private final d throwableListPool;
    private final TranscoderRegistry transcoderRegistry;

    public Registry() {
        this.modelToResourceClassCache = new ModelToResourceClassCache();
        this.loadPathCache = new LoadPathCache();
        d d0 = FactoryPools.threadSafeList();
        this.throwableListPool = d0;
        this.modelLoaderRegistry = new ModelLoaderRegistry(d0);
        this.encoderRegistry = new EncoderRegistry();
        this.decoderRegistry = new ResourceDecoderRegistry();
        this.resourceEncoderRegistry = new ResourceEncoderRegistry();
        this.dataRewinderRegistry = new DataRewinderRegistry();
        this.transcoderRegistry = new TranscoderRegistry();
        this.imageHeaderParserRegistry = new ImageHeaderParserRegistry();
        this.setResourceDecoderBucketPriorityList(Arrays.asList(new String[]{"Animation", "Bitmap", "BitmapDrawable"}));
    }

    public Registry append(Class class0, Encoder encoder0) {
        this.encoderRegistry.append(class0, encoder0);
        return this;
    }

    public Registry append(Class class0, ResourceEncoder resourceEncoder0) {
        this.resourceEncoderRegistry.append(class0, resourceEncoder0);
        return this;
    }

    public Registry append(Class class0, Class class1, ResourceDecoder resourceDecoder0) {
        this.append("legacy_append", class0, class1, resourceDecoder0);
        return this;
    }

    public Registry append(Class class0, Class class1, ModelLoaderFactory modelLoaderFactory0) {
        this.modelLoaderRegistry.append(class0, class1, modelLoaderFactory0);
        return this;
    }

    public Registry append(String s, Class class0, Class class1, ResourceDecoder resourceDecoder0) {
        this.decoderRegistry.append(s, resourceDecoder0, class0, class1);
        return this;
    }

    private List getDecodePaths(Class class0, Class class1, Class class2) {
        List list0 = new ArrayList();
        for(Object object0: this.decoderRegistry.getResourceClasses(class0, class1)) {
            Class class3 = (Class)object0;
            for(Object object1: this.transcoderRegistry.getTranscodeClasses(class3, class2)) {
                ((ArrayList)list0).add(new DecodePath(class0, class3, ((Class)object1), this.decoderRegistry.getDecoders(class0, class3), this.transcoderRegistry.get(class3, ((Class)object1)), this.throwableListPool));
            }
        }
        return list0;
    }

    public List getImageHeaderParsers() {
        List list0 = this.imageHeaderParserRegistry.getParsers();
        if(list0.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return list0;
    }

    public LoadPath getLoadPath(Class class0, Class class1, Class class2) {
        LoadPath loadPath0 = this.loadPathCache.get(class0, class1, class2);
        LoadPath loadPath1 = null;
        if(this.loadPathCache.isEmptyLoadPath(loadPath0)) {
            return null;
        }
        if(loadPath0 == null) {
            List list0 = this.getDecodePaths(class0, class1, class2);
            if(!list0.isEmpty()) {
                loadPath1 = new LoadPath(class0, class1, class2, list0, this.throwableListPool);
            }
            this.loadPathCache.put(class0, class1, class2, loadPath1);
            return loadPath1;
        }
        return loadPath0;
    }

    public List getModelLoaders(Object object0) {
        return this.modelLoaderRegistry.getModelLoaders(object0);
    }

    public List getRegisteredResourceClasses(Class class0, Class class1, Class class2) {
        List list0 = this.modelToResourceClassCache.get(class0, class1, class2);
        if(list0 == null) {
            list0 = new ArrayList();
            for(Object object0: this.modelLoaderRegistry.getDataClasses(class0)) {
                for(Object object1: this.decoderRegistry.getResourceClasses(((Class)object0), class1)) {
                    Class class3 = (Class)object1;
                    if(!this.transcoderRegistry.getTranscodeClasses(class3, class2).isEmpty() && !((ArrayList)list0).contains(class3)) {
                        ((ArrayList)list0).add(class3);
                    }
                }
            }
            List list1 = Collections.unmodifiableList(list0);
            this.modelToResourceClassCache.put(class0, class1, class2, list1);
        }
        return list0;
    }

    public ResourceEncoder getResultEncoder(Resource resource0) {
        Class class0 = resource0.getResourceClass();
        ResourceEncoder resourceEncoder0 = this.resourceEncoderRegistry.get(class0);
        if(resourceEncoder0 == null) {
            throw new NoResultEncoderAvailableException(resource0.getResourceClass());
        }
        return resourceEncoder0;
    }

    public DataRewinder getRewinder(Object object0) {
        return this.dataRewinderRegistry.build(object0);
    }

    public Encoder getSourceEncoder(Object object0) {
        Class class0 = object0.getClass();
        Encoder encoder0 = this.encoderRegistry.getEncoder(class0);
        if(encoder0 == null) {
            throw new NoSourceEncoderAvailableException(object0.getClass());
        }
        return encoder0;
    }

    public boolean isResourceEncoderAvailable(Resource resource0) {
        Class class0 = resource0.getResourceClass();
        return this.resourceEncoderRegistry.get(class0) != null;
    }

    public Registry prepend(Class class0, Encoder encoder0) {
        this.encoderRegistry.prepend(class0, encoder0);
        return this;
    }

    public Registry prepend(Class class0, ResourceEncoder resourceEncoder0) {
        this.resourceEncoderRegistry.prepend(class0, resourceEncoder0);
        return this;
    }

    public Registry prepend(Class class0, Class class1, ResourceDecoder resourceDecoder0) {
        this.prepend("legacy_prepend_all", class0, class1, resourceDecoder0);
        return this;
    }

    public Registry prepend(Class class0, Class class1, ModelLoaderFactory modelLoaderFactory0) {
        this.modelLoaderRegistry.prepend(class0, class1, modelLoaderFactory0);
        return this;
    }

    public Registry prepend(String s, Class class0, Class class1, ResourceDecoder resourceDecoder0) {
        this.decoderRegistry.prepend(s, resourceDecoder0, class0, class1);
        return this;
    }

    public Registry register(ImageHeaderParser imageHeaderParser0) {
        this.imageHeaderParserRegistry.add(imageHeaderParser0);
        return this;
    }

    public Registry register(Factory dataRewinder$Factory0) {
        this.dataRewinderRegistry.register(dataRewinder$Factory0);
        return this;
    }

    @Deprecated
    public Registry register(Class class0, Encoder encoder0) {
        return this.append(class0, encoder0);
    }

    @Deprecated
    public Registry register(Class class0, ResourceEncoder resourceEncoder0) {
        return this.append(class0, resourceEncoder0);
    }

    public Registry register(Class class0, Class class1, ResourceTranscoder resourceTranscoder0) {
        this.transcoderRegistry.register(class0, class1, resourceTranscoder0);
        return this;
    }

    public Registry replace(Class class0, Class class1, ModelLoaderFactory modelLoaderFactory0) {
        this.modelLoaderRegistry.replace(class0, class1, modelLoaderFactory0);
        return this;
    }

    public final Registry setResourceDecoderBucketPriorityList(List list0) {
        ArrayList arrayList0 = new ArrayList(list0.size());
        arrayList0.add("legacy_prepend_all");
        for(Object object0: list0) {
            arrayList0.add(((String)object0));
        }
        arrayList0.add("legacy_append");
        this.decoderRegistry.setBucketPriorityList(arrayList0);
        return this;
    }
}

