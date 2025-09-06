package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

final class NonOwnedDrawableResource extends DrawableResource {
    private NonOwnedDrawableResource(Drawable drawable0) {
        super(drawable0);
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public Class getResourceClass() {
        return this.drawable.getClass();
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        int v = this.drawable.getIntrinsicWidth();
        return Math.max(1, this.drawable.getIntrinsicHeight() * v * 4);
    }

    public static Resource newInstance(Drawable drawable0) {
        return drawable0 != null ? new NonOwnedDrawableResource(drawable0) : null;
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }
}

