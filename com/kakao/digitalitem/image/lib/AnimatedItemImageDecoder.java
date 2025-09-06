package com.kakao.digitalitem.image.lib;

import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.collection.u;
import java.io.File;
import java.lang.ref.WeakReference;

public final class AnimatedItemImageDecoder {
    interface AnimatedItemImageDecodeListener {
        void onDecoded(AnimatedItemImage arg1);
    }

    static final class DecodeExecute implements Runnable {
        private final int bitmapDensity;
        private final String cacheKey;
        private final boolean encrypted;
        private final File file;
        private final u imageCache;
        private final AnimatedItemImageDecodeListener listener;
        private final Type type;
        private final int viewHeight;
        private final int viewWidth;

        private DecodeExecute(String s, u u0, File file0, Type animatedItemImage$Type0, int v, boolean z, int v1, int v2, AnimatedItemImageDecodeListener animatedItemImageDecoder$AnimatedItemImageDecodeListener0) {
            this.cacheKey = s;
            this.imageCache = u0;
            this.file = file0;
            this.type = animatedItemImage$Type0;
            this.bitmapDensity = v;
            this.encrypted = z;
            this.listener = animatedItemImageDecoder$AnimatedItemImageDecodeListener0;
            this.viewWidth = v1;
            this.viewHeight = v2;
        }

        public DecodeExecute(String s, u u0, File file0, Type animatedItemImage$Type0, int v, boolean z, int v1, int v2, AnimatedItemImageDecodeListener animatedItemImageDecoder$AnimatedItemImageDecodeListener0, com.kakao.digitalitem.image.lib.AnimatedItemImageDecoder.1 animatedItemImageDecoder$10) {
            this(s, u0, file0, animatedItemImage$Type0, v, z, v1, v2, animatedItemImageDecoder$AnimatedItemImageDecodeListener0);
        }

        @Override
        public void run() {
            AnimatedItemImage animatedItemImage0 = (AnimatedItemImage)this.imageCache.get(this.cacheKey);
            if(animatedItemImage0 == null) {
                try {
                    animatedItemImage0 = ImageDecode.decodeImageFromPath(this.file.getAbsolutePath(), this.type, this.encrypted, this.viewWidth, this.viewHeight);
                }
                catch(FrameDecodeException unused_ex) {
                    return;
                }
                if(!Thread.currentThread().isInterrupted()) {
                    if(animatedItemImage0 != null) {
                        animatedItemImage0.setDensity(this.bitmapDensity);
                        this.imageCache.put(this.cacheKey, animatedItemImage0);
                    }
                    goto label_7;
                }
            }
            else {
            label_7:
                AnimatedItemImageDecodeListener animatedItemImageDecoder$AnimatedItemImageDecodeListener0 = this.listener;
                if(animatedItemImageDecoder$AnimatedItemImageDecodeListener0 != null) {
                    animatedItemImageDecoder$AnimatedItemImageDecodeListener0.onDecoded(animatedItemImage0);
                }
            }
        }
    }

    private static final int CACHE_COUNT = 0x80;
    private int bitmapDensity;
    private final SingleExecutor decodingExecutor;
    private final Handler handler;
    private u imageCache;
    private static boolean isLoaddedLibrary;

    static {
        try {
            System.loadLibrary("digitalitem_image_decoder");
            AnimatedItemImageDecoder.isLoaddedLibrary = true;
        }
        catch(Throwable throwable0) {
            AnimatedItemImageDecoder.isLoaddedLibrary = false;
            throwable0.printStackTrace();
        }
    }

    public AnimatedItemImageDecoder(Handler handler0) {
        this.bitmapDensity = 0xF0;
        this.handler = handler0;
        this.decodingExecutor = new SingleExecutor();
        this.resetCache();
    }

    public static SingleExecutor access$000(AnimatedItemImageDecoder animatedItemImageDecoder0) {
        return animatedItemImageDecoder0.decodingExecutor;
    }

    public static void access$100(AnimatedItemImageContainer animatedItemImageContainer0, AnimatedItemImage animatedItemImage0, boolean z) {
        AnimatedItemImageDecoder.setImageViewOnMainThread(animatedItemImageContainer0, animatedItemImage0, z);
    }

    public void cancelDecoding(int v) {
        this.decodingExecutor.cancel(v);
    }

    private void decodeImage(int v, String s, File file0, Type animatedItemImage$Type0, boolean z, int v1, int v2, AnimatedItemImageDecodeListener animatedItemImageDecoder$AnimatedItemImageDecodeListener0) {
        DecodeExecute animatedItemImageDecoder$DecodeExecute0 = new DecodeExecute(s, this.imageCache, file0, animatedItemImage$Type0, this.bitmapDensity, z, v1, v2, animatedItemImageDecoder$AnimatedItemImageDecodeListener0, null);
        this.decodingExecutor.execute(v, animatedItemImageDecoder$DecodeExecute0);
    }

    public boolean isLoaddedLibrary() {
        return AnimatedItemImageDecoder.isLoaddedLibrary;
    }

    private static boolean isSameSize(AnimatedItemImageContainer animatedItemImageContainer0, AnimatedItemImage animatedItemImage0) {
        return animatedItemImage0 != null && animatedItemImageContainer0 != null && animatedItemImageContainer0.getAnimatedViewHeight() == animatedItemImage0.getHeight() && animatedItemImageContainer0.getAnimatedViewWidth() == animatedItemImage0.getWidth();
    }

    public void loadImage(File file0, AnimatedItemImageContainer animatedItemImageContainer0, boolean z, Type animatedItemImage$Type0, boolean z1) {
        String s = file0.getAbsolutePath();
        int v = animatedItemImageContainer0.hashCode();
        AnimatedItemImage animatedItemImage0 = (AnimatedItemImage)this.imageCache.get(s);
        if(animatedItemImage0 != null && animatedItemImage0.isAllFrameDecodeSucceed()) {
            if(AnimatedItemImageDecoder.isSameSize(animatedItemImageContainer0, animatedItemImage0)) {
                this.decodingExecutor.cancel(v);
                AnimatedItemImageDecoder.setImageViewOnMainThread(animatedItemImageContainer0, animatedItemImage0, z);
                return;
            }
            this.imageCache.remove(s);
        }
        WeakReference weakReference0 = new WeakReference(animatedItemImageContainer0);
        this.decodeImage(v, s, file0, animatedItemImage$Type0, z1, animatedItemImageContainer0.getAnimatedViewWidth(), animatedItemImageContainer0.getAnimatedViewHeight(), new AnimatedItemImageDecodeListener() {
            @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageDecoder$AnimatedItemImageDecodeListener
            public void onDecoded(AnimatedItemImage animatedItemImage0) {
                com.kakao.digitalitem.image.lib.AnimatedItemImageDecoder.1.1 animatedItemImageDecoder$1$10 = new Runnable() {
                    @Override
                    public void run() {
                        if(com.kakao.digitalitem.image.lib.AnimatedItemImageDecoder.1.this.val$containerRef.get() == null) {
                        label_6:
                            AnimatedItemImageDecoder.access$100(com.kakao.digitalitem.image.lib.AnimatedItemImageDecoder.1.this.val$container, animatedItemImage0, com.kakao.digitalitem.image.lib.AnimatedItemImageDecoder.1.this.val$isWrapContent);
                            if(AnimatedItemImageDecoder.access$000(AnimatedItemImageDecoder.this) != null) {
                                AnimatedItemImageDecoder.access$000(AnimatedItemImageDecoder.this).remove(com.kakao.digitalitem.image.lib.AnimatedItemImageDecoder.1.this.val$decodingQueueKey);
                            }
                        }
                        else {
                            Object object0 = ((AnimatedItemImageContainer)com.kakao.digitalitem.image.lib.AnimatedItemImageDecoder.1.this.val$containerRef.get()).getAsyncTaskTagObject();
                            if(!(object0 instanceof String) || com.kakao.digitalitem.image.lib.AnimatedItemImageDecoder.1.this.val$cacheKey.equals(object0)) {
                                goto label_6;
                            }
                            else if(AnimatedItemImageDecoder.access$000(AnimatedItemImageDecoder.this) != null) {
                                AnimatedItemImageDecoder.access$000(AnimatedItemImageDecoder.this).remove(com.kakao.digitalitem.image.lib.AnimatedItemImageDecoder.1.this.val$decodingQueueKey);
                            }
                        }
                    }
                };
                AnimatedItemImageDecoder.this.handler.post(animatedItemImageDecoder$1$10);
            }
        });
    }

    public void resetCache() {
        u u0 = this.imageCache;
        if(u0 != null) {
            u0.evictAll();
            this.imageCache = null;
        }
        this.imageCache = new u(0x80);
    }

    public void setBitmapDensity(int v) {
        this.bitmapDensity = v;
    }

    private static void setImageViewOnMainThread(AnimatedItemImageContainer animatedItemImageContainer0, AnimatedItemImage animatedItemImage0, boolean z) {
        if(animatedItemImageContainer0 != null && animatedItemImage0 != null) {
            if(z && animatedItemImageContainer0 instanceof ImageView) {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = ((ImageView)animatedItemImageContainer0).getLayoutParams();
                if(viewGroup$LayoutParams0 != null) {
                    viewGroup$LayoutParams0.height = -2;
                    viewGroup$LayoutParams0.width = -2;
                }
            }
            animatedItemImageContainer0.setAnimatedImage(animatedItemImage0);
        }
    }
}

