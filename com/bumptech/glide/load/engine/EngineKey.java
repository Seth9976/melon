package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

class EngineKey implements Key {
    private int hashCode;
    private final int height;
    private final Object model;
    private final Options options;
    private final Class resourceClass;
    private final Key signature;
    private final Class transcodeClass;
    private final Map transformations;
    private final int width;

    public EngineKey(Object object0, Key key0, int v, int v1, Map map0, Class class0, Class class1, Options options0) {
        this.model = Preconditions.checkNotNull(object0);
        this.signature = (Key)Preconditions.checkNotNull(key0, "Signature must not be null");
        this.width = v;
        this.height = v1;
        this.transformations = (Map)Preconditions.checkNotNull(map0);
        this.resourceClass = (Class)Preconditions.checkNotNull(class0, "Resource class must not be null");
        this.transcodeClass = (Class)Preconditions.checkNotNull(class1, "Transcode class must not be null");
        this.options = (Options)Preconditions.checkNotNull(options0);
    }

    // 去混淆评级： 中等(70)
    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof EngineKey && this.model.equals(((EngineKey)object0).model) && this.signature.equals(((EngineKey)object0).signature) && this.height == ((EngineKey)object0).height && this.width == ((EngineKey)object0).width && this.transformations.equals(((EngineKey)object0).transformations) && this.resourceClass.equals(((EngineKey)object0).resourceClass) && this.transcodeClass.equals(((EngineKey)object0).transcodeClass) && this.options.equals(((EngineKey)object0).options);
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        if(this.hashCode == 0) {
            this.hashCode = this.options.hashCode() + (this.transcodeClass.hashCode() + (this.resourceClass.hashCode() + (this.transformations.hashCode() + (((this.signature.hashCode() + this.model.hashCode() * 0x1F) * 0x1F + this.width) * 0x1F + this.height) * 0x1F) * 0x1F) * 0x1F) * 0x1F;
        }
        return this.hashCode;
    }

    @Override
    public String toString() {
        return "EngineKey{model=" + this.model + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.resourceClass + ", transcodeClass=" + this.transcodeClass + ", signature=" + this.signature + ", hashCode=" + this.hashCode + ", transformations=" + this.transformations + ", options=" + this.options + '}';
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        throw new UnsupportedOperationException();
    }
}

