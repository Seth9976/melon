package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

public final class UnitBitmapDecoder implements ResourceDecoder {
    static final class NonOwnedBitmapResource implements Resource {
        private final Bitmap bitmap;

        public NonOwnedBitmapResource(Bitmap bitmap0) {
            this.bitmap = bitmap0;
        }

        public Bitmap get() {
            return this.bitmap;
        }

        @Override  // com.bumptech.glide.load.engine.Resource
        public Object get() {
            return this.get();
        }

        @Override  // com.bumptech.glide.load.engine.Resource
        public Class getResourceClass() {
            return Bitmap.class;
        }

        @Override  // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return Util.getBitmapByteSize(this.bitmap);
        }

        @Override  // com.bumptech.glide.load.engine.Resource
        public void recycle() {
        }
    }

    public Resource decode(Bitmap bitmap0, int v, int v1, Options options0) {
        return new NonOwnedBitmapResource(bitmap0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((Bitmap)object0), v, v1, options0);
    }

    public boolean handles(Bitmap bitmap0, Options options0) {
        return true;
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((Bitmap)object0), options0);
    }
}

