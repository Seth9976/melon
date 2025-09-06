package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.GlideSuppliers.GlideSupplier;
import com.bumptech.glide.util.GlideSuppliers;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

public class GlideContext extends ContextWrapper {
    static final TransitionOptions DEFAULT_TRANSITION_OPTIONS;
    private final ArrayPool arrayPool;
    private final List defaultRequestListeners;
    private RequestOptions defaultRequestOptions;
    private final RequestOptionsFactory defaultRequestOptionsFactory;
    private final Map defaultTransitionOptions;
    private final Engine engine;
    private final GlideExperiments experiments;
    private final ImageViewTargetFactory imageViewTargetFactory;
    private final int logLevel;
    private final GlideSupplier registry;

    static {
        GlideContext.DEFAULT_TRANSITION_OPTIONS = new GenericTransitionOptions();
    }

    public GlideContext(Context context0, ArrayPool arrayPool0, GlideSupplier glideSuppliers$GlideSupplier0, ImageViewTargetFactory imageViewTargetFactory0, RequestOptionsFactory glide$RequestOptionsFactory0, Map map0, List list0, Engine engine0, GlideExperiments glideExperiments0, int v) {
        super(context0.getApplicationContext());
        this.arrayPool = arrayPool0;
        this.imageViewTargetFactory = imageViewTargetFactory0;
        this.defaultRequestOptionsFactory = glide$RequestOptionsFactory0;
        this.defaultRequestListeners = list0;
        this.defaultTransitionOptions = map0;
        this.engine = engine0;
        this.experiments = glideExperiments0;
        this.logLevel = v;
        this.registry = GlideSuppliers.memorize(glideSuppliers$GlideSupplier0);
    }

    public ViewTarget buildImageViewTarget(ImageView imageView0, Class class0) {
        return this.imageViewTargetFactory.buildTarget(imageView0, class0);
    }

    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public List getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    public RequestOptions getDefaultRequestOptions() {
        synchronized(this) {
            if(this.defaultRequestOptions == null) {
                this.defaultRequestOptions = (RequestOptions)this.defaultRequestOptionsFactory.build().lock();
            }
            return this.defaultRequestOptions;
        }
    }

    public TransitionOptions getDefaultTransitionOptions(Class class0) {
        TransitionOptions transitionOptions0 = (TransitionOptions)this.defaultTransitionOptions.get(class0);
        if(transitionOptions0 == null) {
            for(Object object0: this.defaultTransitionOptions.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                if(((Class)map$Entry0.getKey()).isAssignableFrom(class0)) {
                    transitionOptions0 = (TransitionOptions)map$Entry0.getValue();
                }
            }
        }
        return transitionOptions0 == null ? GlideContext.DEFAULT_TRANSITION_OPTIONS : transitionOptions0;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public GlideExperiments getExperiments() {
        return this.experiments;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public Registry getRegistry() {
        return (Registry)this.registry.get();
    }
}

