package com.kakao.emoticon.image;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.kakao.digitalitem.image.lib.AnimatedItemImage.Type;
import com.kakao.digitalitem.image.lib.AnimatedItemImageContainer;
import com.kakao.digitalitem.image.lib.AnimatedItemImageDecoder;
import com.kakao.digitalitem.image.lib.AnimatedItemImageView;
import com.kakao.digitalitem.image.lib.SingleExecutor;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.Future;

public enum AnimatedItemImageLoader {
    static final class DownloadExecute implements Runnable {
        private final File file;
        private final DownloadListener listener;
        private final String url;

        private DownloadExecute(String s, File file0, DownloadListener animatedItemImageLoader$DownloadListener0) {
            this.url = s;
            this.file = file0;
            this.listener = animatedItemImageLoader$DownloadListener0;
        }

        public DownloadExecute(String s, File file0, DownloadListener animatedItemImageLoader$DownloadListener0, com.kakao.emoticon.image.AnimatedItemImageLoader.1 animatedItemImageLoader$10) {
            this(s, file0, animatedItemImageLoader$DownloadListener0);
        }

        @Override
        public void run() {
            if(!Thread.interrupted() && !Thread.interrupted()) {
                DownloadListener animatedItemImageLoader$DownloadListener0 = this.listener;
                if(animatedItemImageLoader$DownloadListener0 != null) {
                    animatedItemImageLoader$DownloadListener0.onDownloadCompleted(this.file);
                }
            }
        }
    }

    public interface DownloadListener {
        void onDownloadCompleted(File arg1);
    }

    INSTANCE;

    private final SparseArray downloadFutures;
    private final SingleExecutor downloadingExecutor;
    private final Handler handler;
    private final AnimatedItemImageDecoder imageDecoder;

    private AnimatedItemImageLoader() {
        Handler handler0 = new Handler(Looper.getMainLooper());
        this.handler = handler0;
        AnimatedItemImageDecoder animatedItemImageDecoder0 = new AnimatedItemImageDecoder(handler0);
        this.imageDecoder = animatedItemImageDecoder0;
        animatedItemImageDecoder0.setBitmapDensity(0xF0);
        this.downloadingExecutor = new SingleExecutor();
        this.downloadFutures = new SparseArray();
    }

    private void cancelDownloadFuture(int v) {
        Future future0 = (Future)this.downloadFutures.get(v);
        if(future0 != null) {
            future0.cancel(true);
            this.downloadFutures.remove(v);
        }
    }

    public void cancelLoadingImage(AnimatedItemImageView animatedItemImageView0) {
        int v = animatedItemImageView0.hashCode();
        this.downloadingExecutor.cancel(v);
        this.imageDecoder.cancelDecoding(v);
        this.cancelDownloadFuture(v);
    }

    private boolean decodeImage(File file0, AnimatedItemImageContainer animatedItemImageContainer0, boolean z, Type animatedItemImage$Type0, boolean z1) {
        if(file0 != null && file0.exists()) {
            this.imageDecoder.loadImage(file0, animatedItemImageContainer0, z, animatedItemImage$Type0, z1);
            return true;
        }
        return false;
    }

    private void download(AnimatedItemImageContainer animatedItemImageContainer0, boolean z, String s, File file0, Type animatedItemImage$Type0, boolean z1) {
        DownloadExecute animatedItemImageLoader$DownloadExecute0 = new DownloadExecute(s, file0, new DownloadListener() {
            @Override  // com.kakao.emoticon.image.AnimatedItemImageLoader$DownloadListener
            public void onDownloadCompleted(File file0) {
                com.kakao.emoticon.image.AnimatedItemImageLoader.1.1 animatedItemImageLoader$1$10 = new Runnable() {
                    @Override
                    public void run() {
                        AnimatedItemImageLoader.this.decodeImage(file0, com.kakao.emoticon.image.AnimatedItemImageLoader.1.this.val$container, com.kakao.emoticon.image.AnimatedItemImageLoader.1.this.val$isWrapContent, com.kakao.emoticon.image.AnimatedItemImageLoader.1.this.val$type, com.kakao.emoticon.image.AnimatedItemImageLoader.1.this.val$isDecrypt);
                    }
                };
                AnimatedItemImageLoader.this.handler.post(animatedItemImageLoader$1$10);
            }
        }, null);
        this.downloadingExecutor.execute(animatedItemImageContainer0.hashCode(), animatedItemImageLoader$DownloadExecute0);
    }

    private static String getExtension(String s) {
        return s.substring(s.lastIndexOf(".") + 1, s.length()).toLowerCase(Locale.US);
    }

    public void loadImage(AnimatedItemImageContainer animatedItemImageContainer0, String s, Type animatedItemImage$Type0, boolean z) {
        File file0 = new File(s);
        if(this.decodeImage(file0, animatedItemImageContainer0, z, animatedItemImage$Type0, true)) {
            this.downloadingExecutor.cancel(animatedItemImageContainer0.hashCode());
            return;
        }
        this.download(animatedItemImageContainer0, z, s, file0, animatedItemImage$Type0, false);
    }

    public void loadImage(AnimatedItemImageContainer animatedItemImageContainer0, String s, boolean z) {
        File file0 = new File(s);
        Type animatedItemImage$Type0 = Type.toType(AnimatedItemImageLoader.getExtension(s));
        if(this.decodeImage(file0, animatedItemImageContainer0, z, animatedItemImage$Type0, false)) {
            this.downloadingExecutor.cancel(animatedItemImageContainer0.hashCode());
            return;
        }
        this.download(animatedItemImageContainer0, z, s, file0, animatedItemImage$Type0, false);
    }

    public void resetMemoryCache() {
        this.imageDecoder.resetCache();
    }
}

