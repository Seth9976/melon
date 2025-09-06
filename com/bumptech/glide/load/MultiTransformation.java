package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

public class MultiTransformation implements Transformation {
    private final Collection transformations;

    public MultiTransformation(Collection collection0) {
        if(collection0.isEmpty()) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = collection0;
    }

    @SafeVarargs
    public MultiTransformation(Transformation[] arr_transformation) {
        if(arr_transformation.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = Arrays.asList(arr_transformation);
    }

    // 去混淆评级： 低(20)
    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof MultiTransformation ? this.transformations.equals(((MultiTransformation)object0).transformations) : false;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.transformations.hashCode();
    }

    @Override  // com.bumptech.glide.load.Transformation
    public Resource transform(Context context0, Resource resource0, int v, int v1) {
        Resource resource1 = resource0;
        for(Object object0: this.transformations) {
            Resource resource2 = ((Transformation)object0).transform(context0, resource1, v, v1);
            if(resource1 != null && !resource1.equals(resource0) && !resource1.equals(resource2)) {
                resource1.recycle();
            }
            resource1 = resource2;
        }
        return resource1;
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        for(Object object0: this.transformations) {
            ((Transformation)object0).updateDiskCacheKey(messageDigest0);
        }
    }
}

