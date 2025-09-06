package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

public class GifDrawableResource extends DrawableResource implements Initializable {
    public GifDrawableResource(GifDrawable gifDrawable0) {
        super(gifDrawable0);
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public Class getResourceClass() {
        return GifDrawable.class;
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return ((GifDrawable)this.drawable).getSize();
    }

    @Override  // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        ((GifDrawable)this.drawable).getFirstFrame().prepareToDraw();
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        ((GifDrawable)this.drawable).stop();
        ((GifDrawable)this.drawable).recycle();
    }
}

