package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public final class UnitTransformation implements Transformation {
    private static final Transformation TRANSFORMATION;

    static {
        UnitTransformation.TRANSFORMATION = new UnitTransformation();
    }

    public static UnitTransformation get() {
        return (UnitTransformation)UnitTransformation.TRANSFORMATION;
    }

    @Override  // com.bumptech.glide.load.Transformation
    public Resource transform(Context context0, Resource resource0, int v, int v1) {
        return resource0;
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
    }
}

