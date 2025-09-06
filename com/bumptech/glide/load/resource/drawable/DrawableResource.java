package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

public abstract class DrawableResource implements Initializable, Resource {
    protected final Drawable drawable;

    public DrawableResource(Drawable drawable0) {
        this.drawable = (Drawable)Preconditions.checkNotNull(drawable0);
    }

    public final Drawable get() {
        Drawable.ConstantState drawable$ConstantState0 = this.drawable.getConstantState();
        return drawable$ConstantState0 == null ? this.drawable : drawable$ConstantState0.newDrawable();
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public Object get() {
        return this.get();
    }

    @Override  // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        Drawable drawable0 = this.drawable;
        if(drawable0 instanceof BitmapDrawable) {
            ((BitmapDrawable)drawable0).getBitmap().prepareToDraw();
            return;
        }
        if(drawable0 instanceof GifDrawable) {
            ((GifDrawable)drawable0).getFirstFrame().prepareToDraw();
        }
    }
}

