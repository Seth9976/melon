package com.bumptech.glide.load.resource.bitmap;

import android.graphics.ImageDecoder.Source;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import com.iloen.melon.utils.system.a;
import java.io.InputStream;

public final class InputStreamBitmapImageDecoderResourceDecoder implements ResourceDecoder {
    private final BitmapImageDecoderResourceDecoder wrapped;

    public InputStreamBitmapImageDecoderResourceDecoder() {
        this.wrapped = new BitmapImageDecoderResourceDecoder();
    }

    public Resource decode(InputStream inputStream0, int v, int v1, Options options0) {
        ImageDecoder.Source imageDecoder$Source0 = a.f(ByteBufferUtil.fromStream(inputStream0));
        return this.wrapped.decode(imageDecoder$Source0, v, v1, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((InputStream)object0), v, v1, options0);
    }

    public boolean handles(InputStream inputStream0, Options options0) {
        return true;
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((InputStream)object0), options0);
    }
}

