package com.bumptech.glide.load.resource.drawable;

import android.graphics.ImageDecoder.Source;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener;
import com.bumptech.glide.util.ByteBufferUtil;
import com.iloen.melon.utils.system.a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class AnimatedImageDecoder {
    static final class AnimatedImageDrawableResource implements Resource {
        private static final int ESTIMATED_NUMBER_OF_FRAMES = 2;
        private final AnimatedImageDrawable imageDrawable;

        public AnimatedImageDrawableResource(AnimatedImageDrawable animatedImageDrawable0) {
            this.imageDrawable = animatedImageDrawable0;
        }

        public AnimatedImageDrawable get() {
            return this.imageDrawable;
        }

        @Override  // com.bumptech.glide.load.engine.Resource
        public Object get() {
            return this.get();
        }

        @Override  // com.bumptech.glide.load.engine.Resource
        public Class getResourceClass() {
            return Drawable.class;
        }

        @Override  // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            int v = this.imageDrawable.getIntrinsicWidth();
            return 4 * (this.imageDrawable.getIntrinsicHeight() * v) * 2;
        }

        @Override  // com.bumptech.glide.load.engine.Resource
        public void recycle() {
            this.imageDrawable.stop();
            this.imageDrawable.clearAnimationCallbacks();
        }
    }

    static final class ByteBufferAnimatedImageDecoder implements ResourceDecoder {
        private final AnimatedImageDecoder delegate;

        public ByteBufferAnimatedImageDecoder(AnimatedImageDecoder animatedImageDecoder0) {
            this.delegate = animatedImageDecoder0;
        }

        @Override  // com.bumptech.glide.load.ResourceDecoder
        public Resource decode(Object object0, int v, int v1, Options options0) {
            return this.decode(((ByteBuffer)object0), v, v1, options0);
        }

        public Resource decode(ByteBuffer byteBuffer0, int v, int v1, Options options0) {
            ImageDecoder.Source imageDecoder$Source0 = a.f(byteBuffer0);
            return this.delegate.decode(imageDecoder$Source0, v, v1, options0);
        }

        @Override  // com.bumptech.glide.load.ResourceDecoder
        public boolean handles(Object object0, Options options0) {
            return this.handles(((ByteBuffer)object0), options0);
        }

        public boolean handles(ByteBuffer byteBuffer0, Options options0) {
            return this.delegate.handles(byteBuffer0);
        }
    }

    static final class StreamAnimatedImageDecoder implements ResourceDecoder {
        private final AnimatedImageDecoder delegate;

        public StreamAnimatedImageDecoder(AnimatedImageDecoder animatedImageDecoder0) {
            this.delegate = animatedImageDecoder0;
        }

        public Resource decode(InputStream inputStream0, int v, int v1, Options options0) {
            ImageDecoder.Source imageDecoder$Source0 = a.f(ByteBufferUtil.fromStream(inputStream0));
            return this.delegate.decode(imageDecoder$Source0, v, v1, options0);
        }

        @Override  // com.bumptech.glide.load.ResourceDecoder
        public Resource decode(Object object0, int v, int v1, Options options0) {
            return this.decode(((InputStream)object0), v, v1, options0);
        }

        public boolean handles(InputStream inputStream0, Options options0) {
            return this.delegate.handles(inputStream0);
        }

        @Override  // com.bumptech.glide.load.ResourceDecoder
        public boolean handles(Object object0, Options options0) {
            return this.handles(((InputStream)object0), options0);
        }
    }

    private final ArrayPool arrayPool;
    private final List imageHeaderParsers;

    private AnimatedImageDecoder(List list0, ArrayPool arrayPool0) {
        this.imageHeaderParsers = list0;
        this.arrayPool = arrayPool0;
    }

    public static ResourceDecoder byteBufferDecoder(List list0, ArrayPool arrayPool0) {
        return new ByteBufferAnimatedImageDecoder(new AnimatedImageDecoder(list0, arrayPool0));
    }

    public Resource decode(ImageDecoder.Source imageDecoder$Source0, int v, int v1, Options options0) {
        Drawable drawable0 = ImageDecoder.decodeDrawable(imageDecoder$Source0, new DefaultOnHeaderDecodedListener(v, v1, options0));
        if(!a.w(drawable0)) {
            throw new IOException("Received unexpected drawable type for animated image, failing: " + drawable0);
        }
        return new AnimatedImageDrawableResource(((AnimatedImageDrawable)drawable0));
    }

    public boolean handles(InputStream inputStream0) {
        return this.isHandled(ImageHeaderParserUtils.getType(this.imageHeaderParsers, inputStream0, this.arrayPool));
    }

    public boolean handles(ByteBuffer byteBuffer0) {
        return this.isHandled(ImageHeaderParserUtils.getType(this.imageHeaderParsers, byteBuffer0));
    }

    private boolean isHandled(ImageType imageHeaderParser$ImageType0) {
        return imageHeaderParser$ImageType0 == ImageType.ANIMATED_WEBP || Build.VERSION.SDK_INT >= 0x1F && imageHeaderParser$ImageType0 == ImageType.ANIMATED_AVIF;
    }

    public static ResourceDecoder streamDecoder(List list0, ArrayPool arrayPool0) {
        return new StreamAnimatedImageDecoder(new AnimatedImageDecoder(list0, arrayPool0));
    }
}

