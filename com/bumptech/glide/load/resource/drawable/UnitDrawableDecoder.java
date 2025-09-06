package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

public class UnitDrawableDecoder implements ResourceDecoder {
    public Resource decode(Drawable drawable0, int v, int v1, Options options0) {
        return NonOwnedDrawableResource.newInstance(drawable0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((Drawable)object0), v, v1, options0);
    }

    public boolean handles(Drawable drawable0, Options options0) {
        return true;
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((Drawable)object0), options0);
    }
}

