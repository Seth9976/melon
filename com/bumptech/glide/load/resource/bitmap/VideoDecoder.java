package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Option.CacheKeyUpdater;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import va.e;

public class VideoDecoder implements ResourceDecoder {
    static final class AssetFileDescriptorInitializer implements MediaInitializer {
        private AssetFileDescriptorInitializer() {
        }

        public AssetFileDescriptorInitializer(com.bumptech.glide.load.resource.bitmap.VideoDecoder.1 videoDecoder$10) {
        }

        public void initializeExtractor(MediaExtractor mediaExtractor0, AssetFileDescriptor assetFileDescriptor0) {
            mediaExtractor0.setDataSource(assetFileDescriptor0.getFileDescriptor(), assetFileDescriptor0.getStartOffset(), assetFileDescriptor0.getLength());
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer
        public void initializeExtractor(MediaExtractor mediaExtractor0, Object object0) {
            this.initializeExtractor(mediaExtractor0, ((AssetFileDescriptor)object0));
        }

        public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever0, AssetFileDescriptor assetFileDescriptor0) {
            mediaMetadataRetriever0.setDataSource(assetFileDescriptor0.getFileDescriptor(), assetFileDescriptor0.getStartOffset(), assetFileDescriptor0.getLength());
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer
        public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever0, Object object0) {
            this.initializeRetriever(mediaMetadataRetriever0, ((AssetFileDescriptor)object0));
        }
    }

    static final class ByteBufferInitializer implements MediaInitializer {
        private MediaDataSource getMediaDataSource(ByteBuffer byteBuffer0) {
            return new MediaDataSource() {
                @Override
                public void close() {
                }

                @Override  // android.media.MediaDataSource
                public long getSize() {
                    return (long)byteBuffer0.limit();
                }

                @Override  // android.media.MediaDataSource
                public int readAt(long v, byte[] arr_b, int v1, int v2) {
                    if(v >= ((long)byteBuffer0.limit())) {
                        return -1;
                    }
                    byteBuffer0.position(((int)v));
                    int v3 = Math.min(v2, byteBuffer0.remaining());
                    byteBuffer0.get(arr_b, v1, v3);
                    return v3;
                }
            };
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer
        public void initializeExtractor(MediaExtractor mediaExtractor0, Object object0) {
            this.initializeExtractor(mediaExtractor0, ((ByteBuffer)object0));
        }

        public void initializeExtractor(MediaExtractor mediaExtractor0, ByteBuffer byteBuffer0) {
            mediaExtractor0.setDataSource(this.getMediaDataSource(byteBuffer0));
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer
        public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever0, Object object0) {
            this.initializeRetriever(mediaMetadataRetriever0, ((ByteBuffer)object0));
        }

        public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever0, ByteBuffer byteBuffer0) {
            mediaMetadataRetriever0.setDataSource(this.getMediaDataSource(byteBuffer0));
        }
    }

    interface MediaInitializer {
        void initializeExtractor(MediaExtractor arg1, Object arg2);

        void initializeRetriever(MediaMetadataRetriever arg1, Object arg2);
    }

    static class MediaMetadataRetrieverFactory {
        public MediaMetadataRetriever build() {
            return new MediaMetadataRetriever();
        }
    }

    static final class ParcelFileDescriptorInitializer implements MediaInitializer {
        public void initializeExtractor(MediaExtractor mediaExtractor0, ParcelFileDescriptor parcelFileDescriptor0) {
            mediaExtractor0.setDataSource(parcelFileDescriptor0.getFileDescriptor());
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer
        public void initializeExtractor(MediaExtractor mediaExtractor0, Object object0) {
            this.initializeExtractor(mediaExtractor0, ((ParcelFileDescriptor)object0));
        }

        public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever0, ParcelFileDescriptor parcelFileDescriptor0) {
            mediaMetadataRetriever0.setDataSource(parcelFileDescriptor0.getFileDescriptor());
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer
        public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever0, Object object0) {
            this.initializeRetriever(mediaMetadataRetriever0, ((ParcelFileDescriptor)object0));
        }
    }

    static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        public VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = null;
    public static final long DEFAULT_FRAME = -1L;
    static final int DEFAULT_FRAME_OPTION = 2;
    public static final Option FRAME_OPTION = null;
    private static final List PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX = null;
    private static final String TAG = "VideoDecoder";
    public static final Option TARGET_FRAME = null;
    private static final String WEBM_MIME_TYPE = "video/webm";
    private final BitmapPool bitmapPool;
    private final MediaMetadataRetrieverFactory factory;
    private final MediaInitializer initializer;

    static {
        VideoDecoder.TARGET_FRAME = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new CacheKeyUpdater() {
            private final ByteBuffer buffer;

            {
                this.buffer = ByteBuffer.allocate(8);
            }

            public void update(byte[] arr_b, Long long0, MessageDigest messageDigest0) {
                messageDigest0.update(arr_b);
                synchronized(this.buffer) {
                    this.buffer.position(0);
                    messageDigest0.update(this.buffer.putLong(((long)long0)).array());
                }
            }

            @Override  // com.bumptech.glide.load.Option$CacheKeyUpdater
            public void update(byte[] arr_b, Object object0, MessageDigest messageDigest0) {
                this.update(arr_b, ((Long)object0), messageDigest0);
            }
        });
        VideoDecoder.FRAME_OPTION = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new CacheKeyUpdater() {
            private final ByteBuffer buffer;

            {
                this.buffer = ByteBuffer.allocate(4);
            }

            public void update(byte[] arr_b, Integer integer0, MessageDigest messageDigest0) {
                if(integer0 == null) {
                    return;
                }
                messageDigest0.update(arr_b);
                synchronized(this.buffer) {
                    this.buffer.position(0);
                    messageDigest0.update(this.buffer.putInt(((int)integer0)).array());
                }
            }

            @Override  // com.bumptech.glide.load.Option$CacheKeyUpdater
            public void update(byte[] arr_b, Object object0, MessageDigest messageDigest0) {
                this.update(arr_b, ((Integer)object0), messageDigest0);
            }
        });
        VideoDecoder.DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
        VideoDecoder.PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX = Collections.unmodifiableList(Arrays.asList(new String[]{"TP1A", "TD1A.220804.031"}));
    }

    public VideoDecoder(BitmapPool bitmapPool0, MediaInitializer videoDecoder$MediaInitializer0) {
        this(bitmapPool0, videoDecoder$MediaInitializer0, VideoDecoder.DEFAULT_FACTORY);
    }

    public VideoDecoder(BitmapPool bitmapPool0, MediaInitializer videoDecoder$MediaInitializer0, MediaMetadataRetrieverFactory videoDecoder$MediaMetadataRetrieverFactory0) {
        this.bitmapPool = bitmapPool0;
        this.initializer = videoDecoder$MediaInitializer0;
        this.factory = videoDecoder$MediaMetadataRetrieverFactory0;
    }

    public static ResourceDecoder asset(BitmapPool bitmapPool0) {
        return new VideoDecoder(bitmapPool0, new AssetFileDescriptorInitializer(null));
    }

    public static ResourceDecoder byteBuffer(BitmapPool bitmapPool0) {
        return new VideoDecoder(bitmapPool0, new ByteBufferInitializer());
    }

    @TargetApi(30)
    private static Bitmap correctHdr180DegVideoFrameOrientation(MediaMetadataRetriever mediaMetadataRetriever0, Bitmap bitmap0) {
        if(VideoDecoder.isHdr180RotationFixRequired()) {
            try {
                if(VideoDecoder.isHDR(mediaMetadataRetriever0) && Math.abs(Integer.parseInt(mediaMetadataRetriever0.extractMetadata(24))) == 180) {
                    goto label_6;
                }
            }
            catch(NumberFormatException unused_ex) {
                if(Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Exception trying to extract HDR transfer function or rotation");
                }
            }
            return bitmap0;
        label_6:
            if(Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
            }
            Matrix matrix0 = new Matrix();
            matrix0.postRotate(180.0f, ((float)bitmap0.getWidth()) / 2.0f, ((float)bitmap0.getHeight()) / 2.0f);
            return Bitmap.createBitmap(bitmap0, 0, 0, bitmap0.getWidth(), bitmap0.getHeight(), matrix0, true);
        }
        return bitmap0;
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        Bitmap bitmap0;
        long v2 = (long)(((Long)options0.get(VideoDecoder.TARGET_FRAME)));
        if(v2 < 0L && v2 != -1L) {
            throw new IllegalArgumentException(e.a(v2, "Requested frame must be non-negative, or DEFAULT_FRAME, given: "));
        }
        Integer integer0 = (Integer)options0.get(VideoDecoder.FRAME_OPTION);
        if(integer0 == null) {
            integer0 = 2;
        }
        DownsampleStrategy downsampleStrategy0 = (DownsampleStrategy)options0.get(DownsampleStrategy.OPTION);
        if(downsampleStrategy0 == null) {
            downsampleStrategy0 = DownsampleStrategy.DEFAULT;
        }
        MediaMetadataRetriever mediaMetadataRetriever0 = this.factory.build();
        boolean z = false;
        try {
            this.initializer.initializeRetriever(mediaMetadataRetriever0, object0);
            bitmap0 = this.decodeFrame(object0, mediaMetadataRetriever0, v2, ((int)integer0), v, v1, downsampleStrategy0);
        }
        catch(Throwable throwable0) {
            if(Build.VERSION.SDK_INT < 29) {
                mediaMetadataRetriever0.release();
            }
            else if(mediaMetadataRetriever0 instanceof AutoCloseable) {
                mediaMetadataRetriever0.close();
            }
            else if(mediaMetadataRetriever0 instanceof ExecutorService) {
                ExecutorService executorService0 = (ExecutorService)mediaMetadataRetriever0;
                if(executorService0 != ForkJoinPool.commonPool()) {
                    boolean z1 = executorService0.isTerminated();
                    if(!z1) {
                        executorService0.shutdown();
                        while(!z1) {
                            try {
                                z1 = executorService0.awaitTermination(1L, TimeUnit.DAYS);
                            }
                            catch(InterruptedException unused_ex) {
                                if(z) {
                                    continue;
                                }
                                executorService0.shutdownNow();
                                z = true;
                            }
                        }
                        if(z) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
            else {
                if(mediaMetadataRetriever0 == null) {
                    throw new IllegalArgumentException();
                }
                mediaMetadataRetriever0.release();
            }
            throw throwable0;
        }
        if(Build.VERSION.SDK_INT >= 29) {
            if(mediaMetadataRetriever0 instanceof AutoCloseable) {
                mediaMetadataRetriever0.close();
                return BitmapResource.obtain(bitmap0, this.bitmapPool);
            }
            if(!(mediaMetadataRetriever0 instanceof ExecutorService)) {
                goto label_61;
            }
            ExecutorService executorService1 = (ExecutorService)mediaMetadataRetriever0;
            if(executorService1 != ForkJoinPool.commonPool()) {
                boolean z2 = executorService1.isTerminated();
                if(!z2) {
                    executorService1.shutdown();
                    while(!z2) {
                        try {
                            z2 = executorService1.awaitTermination(1L, TimeUnit.DAYS);
                        }
                        catch(InterruptedException unused_ex) {
                            if(z) {
                                continue;
                            }
                            executorService1.shutdownNow();
                            z = true;
                        }
                    }
                    if(z) {
                        Thread.currentThread().interrupt();
                        return BitmapResource.obtain(bitmap0, this.bitmapPool);
                    label_61:
                        if(mediaMetadataRetriever0 == null) {
                            throw new IllegalArgumentException();
                        }
                        mediaMetadataRetriever0.release();
                        return BitmapResource.obtain(bitmap0, this.bitmapPool);
                    }
                }
            }
        }
        else {
            mediaMetadataRetriever0.release();
        }
        return BitmapResource.obtain(bitmap0, this.bitmapPool);
    }

    private Bitmap decodeFrame(Object object0, MediaMetadataRetriever mediaMetadataRetriever0, long v, int v1, int v2, int v3, DownsampleStrategy downsampleStrategy0) {
        if(this.isUnsupportedFormat(object0, mediaMetadataRetriever0)) {
            throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
        }
        Bitmap bitmap0 = Build.VERSION.SDK_INT < 27 || v2 == 0x80000000 || v3 == 0x80000000 || downsampleStrategy0 == DownsampleStrategy.NONE ? null : VideoDecoder.decodeScaledFrame(mediaMetadataRetriever0, v, v1, v2, v3, downsampleStrategy0);
        if(bitmap0 == null) {
            bitmap0 = VideoDecoder.decodeOriginalFrame(mediaMetadataRetriever0, v, v1);
        }
        Bitmap bitmap1 = VideoDecoder.correctHdr180DegVideoFrameOrientation(mediaMetadataRetriever0, bitmap0);
        if(bitmap1 == null) {
            throw new VideoDecoderException();
        }
        return bitmap1;
    }

    private static Bitmap decodeOriginalFrame(MediaMetadataRetriever mediaMetadataRetriever0, long v, int v1) {
        return mediaMetadataRetriever0.getFrameAtTime(v, v1);
    }

    @TargetApi(27)
    private static Bitmap decodeScaledFrame(MediaMetadataRetriever mediaMetadataRetriever0, long v, int v1, int v2, int v3, DownsampleStrategy downsampleStrategy0) {
        try {
            int v4 = Integer.parseInt(mediaMetadataRetriever0.extractMetadata(18));
            int v5 = Integer.parseInt(mediaMetadataRetriever0.extractMetadata(19));
            switch(Integer.parseInt(mediaMetadataRetriever0.extractMetadata(24))) {
                case 90: 
                case 270: {
                    int v6 = v5;
                    v5 = v4;
                    v4 = v6;
                }
            }
            float f = downsampleStrategy0.getScaleFactor(v4, v5, v2, v3);
            return mediaMetadataRetriever0.getScaledFrameAtTime(v, v1, Math.round(((float)v4) * f), Math.round(f * ((float)v5)));
        }
        catch(Throwable throwable0) {
            if(Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", throwable0);
            }
            return null;
        }
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return true;
    }

    private static boolean isHDR(MediaMetadataRetriever mediaMetadataRetriever0) {
        String s = mediaMetadataRetriever0.extractMetadata(36);
        String s1 = mediaMetadataRetriever0.extractMetadata(35);
        int v = Integer.parseInt(s);
        return (v == 6 || v == 7) && Integer.parseInt(s1) == 6;
    }

    public static boolean isHdr180RotationFixRequired() {
        return !Build.MODEL.startsWith("Pixel") || Build.VERSION.SDK_INT != 33 ? Build.VERSION.SDK_INT >= 30 && Build.VERSION.SDK_INT < 33 : VideoDecoder.isTBuildRequiringRotationFix();
    }

    private static boolean isTBuildRequiringRotationFix() {
        for(Object object0: VideoDecoder.PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX) {
            if(Build.ID.startsWith(((String)object0))) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    private boolean isUnsupportedFormat(Object object0, MediaMetadataRetriever mediaMetadataRetriever0) {
        int v1;
        MediaExtractor mediaExtractor1;
        MediaExtractor mediaExtractor0 = null;
        if(Build.DEVICE != null && Build.DEVICE.matches(".+_cheets|cheets_.+")) {
            try {
                if(!"video/webm".equals(mediaMetadataRetriever0.extractMetadata(12))) {
                    return false;
                }
                mediaExtractor1 = new MediaExtractor();
            }
            catch(Throwable throwable0) {
                goto label_16;
            }
            try {
                this.initializer.initializeExtractor(mediaExtractor1, object0);
                int v = mediaExtractor1.getTrackCount();
                v1 = 0;
                while(true) {
                    if(v1 >= v) {
                        goto label_28;
                    }
                    if("video/x-vnd.on2.vp8".equals(mediaExtractor1.getTrackFormat(v1).getString("mime"))) {
                        goto label_24;
                    }
                    ++v1;
                }
            }
            catch(Throwable throwable0) {
                mediaExtractor0 = mediaExtractor1;
            }
        label_16:
            try {
                if(Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Exception trying to extract track info for a webm video on CrOS.", throwable0);
                }
                return false;
            }
            finally {
                if(mediaExtractor0 != null) {
                    mediaExtractor0.release();
                }
            }
        label_24:
            mediaExtractor1.release();
            return true;
        label_28:
            mediaExtractor1.release();
            return false;
        }
        return false;
    }

    public static ResourceDecoder parcel(BitmapPool bitmapPool0) {
        return new VideoDecoder(bitmapPool0, new ParcelFileDescriptorInitializer());
    }
}

