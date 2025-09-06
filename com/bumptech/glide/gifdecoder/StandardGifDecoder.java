package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class StandardGifDecoder implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 0xFF;
    private static final int MAX_STACK_SIZE = 0x1000;
    private static final int NULL_CODE = -1;
    private static final String TAG = "StandardGifDecoder";
    private int[] act;
    private Bitmap.Config bitmapConfig;
    private final BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public StandardGifDecoder(BitmapProvider gifDecoder$BitmapProvider0) {
        this.pct = new int[0x100];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = gifDecoder$BitmapProvider0;
        this.header = new GifHeader();
    }

    public StandardGifDecoder(BitmapProvider gifDecoder$BitmapProvider0, GifHeader gifHeader0, ByteBuffer byteBuffer0) {
        this(gifDecoder$BitmapProvider0, gifHeader0, byteBuffer0, 1);
    }

    public StandardGifDecoder(BitmapProvider gifDecoder$BitmapProvider0, GifHeader gifHeader0, ByteBuffer byteBuffer0, int v) {
        this(gifDecoder$BitmapProvider0);
        this.setData(gifHeader0, byteBuffer0, v);
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    private int averageColorsNear(int v, int v1, int v2) {
        int v3 = v;
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        while(v3 < this.sampleSize + v) {
            byte[] arr_b = this.mainPixels;
            if(v3 >= arr_b.length || v3 >= v1) {
                break;
            }
            int v9 = this.act[arr_b[v3] & 0xFF];
            if(v9 != 0) {
                v4 += v9 >> 24 & 0xFF;
                v5 += v9 >> 16 & 0xFF;
                v6 += v9 >> 8 & 0xFF;
                v7 += v9 & 0xFF;
                ++v8;
            }
            ++v3;
        }
        int v10 = v + v2;
        for(int v11 = v10; v11 < this.sampleSize + v10; ++v11) {
            byte[] arr_b1 = this.mainPixels;
            if(v11 >= arr_b1.length || v11 >= v1) {
                break;
            }
            int v12 = this.act[arr_b1[v11] & 0xFF];
            if(v12 != 0) {
                v4 += v12 >> 24 & 0xFF;
                v5 += v12 >> 16 & 0xFF;
                v6 += v12 >> 8 & 0xFF;
                v7 += v12 & 0xFF;
                ++v8;
            }
        }
        return v8 == 0 ? 0 : v4 / v8 << 24 | v5 / v8 << 16 | v6 / v8 << 8 | v7 / v8;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.header = null;
        byte[] arr_b = this.mainPixels;
        if(arr_b != null) {
            this.bitmapProvider.release(arr_b);
        }
        int[] arr_v = this.mainScratch;
        if(arr_v != null) {
            this.bitmapProvider.release(arr_v);
        }
        Bitmap bitmap0 = this.previousImage;
        if(bitmap0 != null) {
            this.bitmapProvider.release(bitmap0);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] arr_b1 = this.block;
        if(arr_b1 != null) {
            this.bitmapProvider.release(arr_b1);
        }
    }

    private void copyCopyIntoScratchRobust(GifFrame gifFrame0) {
        int v17;
        int v11;
        int[] arr_v = this.mainScratch;
        int v = this.sampleSize;
        int v1 = gifFrame0.ih / v;
        int v2 = gifFrame0.iy / v;
        int v3 = gifFrame0.iw / v;
        int v4 = gifFrame0.ix / v;
        boolean z = this.framePointer == 0;
        int v5 = this.downsampledWidth;
        int v6 = this.downsampledHeight;
        byte[] arr_b = this.mainPixels;
        int[] arr_v1 = this.act;
        Boolean boolean0 = this.isFirstFrameTransparent;
        int v7 = 8;
        int v9 = 0;
        int v10 = 1;
        for(int v8 = 0; v9 < v1; v8 = v17) {
            if(gifFrame0.interlace) {
                if(v8 >= v1) {
                    switch(v10 + 1) {
                        case 2: {
                            v10 = 2;
                            v8 = 4;
                            break;
                        }
                        case 3: {
                            v10 = 3;
                            v7 = 4;
                            v8 = 2;
                            break;
                        }
                        case 4: {
                            v10 = 4;
                            v8 = 1;
                            v7 = 2;
                            break;
                        }
                        default: {
                            ++v10;
                        }
                    }
                }
                v11 = v8 + v7;
            }
            else {
                v11 = v8;
                v8 = v9;
            }
            int v12 = v8 + v2;
            if(v12 < v6) {
                int v13 = v12 * v5;
                int v14 = v13 + v4;
                int v15 = v14 + v3;
                int v16 = v13 + v5;
                if(v16 < v15) {
                    v15 = v16;
                }
                v17 = v11;
                int v18 = v9 * v * gifFrame0.iw;
                if(v == 1) {
                    for(int v19 = v14; v19 < v15; ++v19) {
                        int v20 = arr_v1[arr_b[v18] & 0xFF];
                        if(v20 != 0) {
                            arr_v[v19] = v20;
                        }
                        else if(z && boolean0 == null) {
                            boolean0 = Boolean.TRUE;
                        }
                        ++v18;
                    }
                }
                else {
                    int v21 = (v15 - v14) * v + v18;
                    for(int v22 = v14; v22 < v15; ++v22) {
                        int v23 = this.averageColorsNear(v18, v21, gifFrame0.iw);
                        if(v23 != 0) {
                            arr_v[v22] = v23;
                        }
                        else if(z && boolean0 == null) {
                            boolean0 = Boolean.TRUE;
                        }
                        v18 += v;
                    }
                }
            }
            else {
                v17 = v11;
            }
            ++v9;
        }
        if(this.isFirstFrameTransparent == null) {
            this.isFirstFrameTransparent = Boolean.valueOf((boolean0 == null ? false : boolean0.booleanValue()));
        }
    }

    private void copyIntoScratchFast(GifFrame gifFrame0) {
        int[] arr_v = this.mainScratch;
        int v = gifFrame0.ih;
        int v1 = gifFrame0.iy;
        int v2 = gifFrame0.iw;
        int v3 = gifFrame0.ix;
        boolean z = this.framePointer == 0;
        int v4 = this.downsampledWidth;
        byte[] arr_b = this.mainPixels;
        int[] arr_v1 = this.act;
        int v6 = -1;
        for(int v5 = 0; v5 < v; ++v5) {
            int v7 = (v5 + v1) * v4;
            int v8 = v7 + v3;
            int v9 = v8 + v2;
            int v10 = v7 + v4;
            if(v10 < v9) {
                v9 = v10;
            }
            int v11 = gifFrame0.iw * v5;
            for(int v12 = v8; v12 < v9; ++v12) {
                int v13 = arr_b[v11];
                int v14 = v13 & 0xFF;
                if(v14 != v6) {
                    int v15 = arr_v1[v14];
                    if(v15 == 0) {
                        v6 = v13;
                    }
                    else {
                        arr_v[v12] = v15;
                    }
                }
                ++v11;
            }
        }
        this.isFirstFrameTransparent = Boolean.valueOf(this.isFirstFrameTransparent != null && this.isFirstFrameTransparent.booleanValue() || this.isFirstFrameTransparent == null && z && v6 != -1);
    }

    private void decodeBitmapData(GifFrame gifFrame0) {
        int v25;
        int v1;
        int v;
        if(gifFrame0 != null) {
            this.rawData.position(gifFrame0.bufferFrameStart);
        }
        if(gifFrame0 == null) {
            v = this.header.width;
            v1 = this.header.height;
        }
        else {
            v = gifFrame0.iw;
            v1 = gifFrame0.ih;
        }
        int v2 = v * v1;
        if(this.mainPixels == null || this.mainPixels.length < v2) {
            this.mainPixels = this.bitmapProvider.obtainByteArray(v2);
        }
        byte[] arr_b = this.mainPixels;
        if(this.prefix == null) {
            this.prefix = new short[0x1000];
        }
        short[] arr_v = this.prefix;
        if(this.suffix == null) {
            this.suffix = new byte[0x1000];
        }
        byte[] arr_b1 = this.suffix;
        if(this.pixelStack == null) {
            this.pixelStack = new byte[0x1001];
        }
        byte[] arr_b2 = this.pixelStack;
        int v3 = this.readByte();
        int v4 = (1 << v3) + 2;
        int v5 = (1 << v3 + 1) - 1;
        for(int v6 = 0; v6 < 1 << v3; ++v6) {
            arr_v[v6] = 0;
            arr_b1[v6] = (byte)v6;
        }
        byte[] arr_b3 = this.block;
        int v7 = v3 + 1;
        int v8 = v4;
        int v9 = v5;
        int v10 = 0;
        int v11 = 0;
        int v12 = 0;
        int v13 = 0;
        int v14 = 0;
        int v15 = 0;
        int v16 = 0;
        int v17 = 0;
        int v18 = -1;
        while(v10 < v2) {
            if(v11 == 0) {
                v11 = this.readBlock();
                if(v11 <= 0) {
                    this.status = 3;
                    break;
                }
                v12 = 0;
            }
            v14 += (arr_b3[v12] & 0xFF) << v13;
            ++v12;
            --v11;
            int v19 = v13 + 8;
            int v20 = v8;
            int v21 = v7;
            int v22 = v18;
            int v23 = v16;
            while(true) {
                if(v19 >= v21) {
                    int v24 = v14 & v9;
                    v14 >>= v21;
                    v19 -= v21;
                    if(v24 == 1 << v3) {
                        v21 = v3 + 1;
                        v20 = v4;
                        v9 = v5;
                        v22 = -1;
                        continue;
                    }
                    else if(v24 == (1 << v3) + 1) {
                        v16 = v23;
                        v8 = v20;
                        break;
                    }
                    else {
                        if(v22 == -1) {
                            arr_b[v15] = arr_b1[v24];
                            ++v15;
                            ++v10;
                            v22 = v24;
                            v23 = v22;
                        }
                        else {
                            if(v24 >= v20) {
                                arr_b2[v17] = (byte)v23;
                                ++v17;
                                v25 = v22;
                            }
                            else {
                                v25 = v24;
                            }
                            while(v25 >= 1 << v3) {
                                arr_b2[v17] = arr_b1[v25];
                                ++v17;
                                v25 = arr_v[v25];
                            }
                            int v26 = arr_b1[v25] & 0xFF;
                            byte b = (byte)v26;
                            arr_b[v15] = b;
                            while(true) {
                                ++v15;
                                ++v10;
                                if(v17 <= 0) {
                                    break;
                                }
                                --v17;
                                arr_b[v15] = arr_b2[v17];
                            }
                            if(v20 < 0x1000) {
                                arr_v[v20] = (short)v22;
                                arr_b1[v20] = b;
                                ++v20;
                                if((v20 & v9) == 0 && v20 < 0x1000) {
                                    ++v21;
                                    v9 += v20;
                                }
                            }
                            v22 = v24;
                            v23 = v26;
                        }
                        continue;
                    }
                }
                v8 = v20;
                v16 = v23;
                break;
            }
            v13 = v19;
            v18 = v22;
            v7 = v21;
        }
        Arrays.fill(arr_b, v15, v2, 0);
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return this.mainScratch.length * 4 + (this.rawData.limit() + this.mainPixels.length);
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public ByteBuffer getData() {
        return this.rawData;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int v) {
        if(v >= 0) {
            return v >= this.header.frameCount ? -1 : ((GifFrame)this.header.frames.get(v)).delay;
        }
        return -1;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.header.frameCount;
    }

    private GifHeaderParser getHeaderParser() {
        if(this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.header.height;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int getLoopCount() {
        int v = this.header.loopCount;
        return v == -1 ? 1 : v;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    private Bitmap getNextBitmap() {
        Bitmap bitmap0 = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, (this.isFirstFrameTransparent == null || this.isFirstFrameTransparent.booleanValue() ? Bitmap.Config.ARGB_8888 : this.bitmapConfig));
        bitmap0.setHasAlpha(true);
        return bitmap0;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        if(this.header.frameCount > 0) {
            return this.framePointer < 0 ? 0 : this.getDelay(this.framePointer);
        }
        return 0;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public Bitmap getNextFrame() {
        synchronized(this) {
            if(this.header.frameCount <= 0 || this.framePointer < 0) {
                if(Log.isLoggable("StandardGifDecoder", 3)) {
                    Log.d("StandardGifDecoder", "Unable to decode frame, frameCount=" + this.header.frameCount + ", framePointer=" + this.framePointer);
                }
                this.status = 1;
            }
            if(this.status != 1 && this.status != 2) {
                this.status = 0;
                if(this.block == null) {
                    this.block = this.bitmapProvider.obtainByteArray(0xFF);
                }
                GifFrame gifFrame0 = (GifFrame)this.header.frames.get(this.framePointer);
                int v1 = this.framePointer - 1;
                GifFrame gifFrame1 = v1 < 0 ? null : ((GifFrame)this.header.frames.get(v1));
                int[] arr_v = gifFrame0.lct == null ? this.header.gct : gifFrame0.lct;
                this.act = arr_v;
                if(arr_v == null) {
                    if(Log.isLoggable("StandardGifDecoder", 3)) {
                        Log.d("StandardGifDecoder", "No valid color table found for frame #" + this.framePointer);
                    }
                    this.status = 1;
                    return null;
                }
                if(gifFrame0.transparency) {
                    System.arraycopy(arr_v, 0, this.pct, 0, arr_v.length);
                    this.act = this.pct;
                    this.pct[gifFrame0.transIndex] = 0;
                    if(gifFrame0.dispose == 2 && this.framePointer == 0) {
                        this.isFirstFrameTransparent = Boolean.TRUE;
                    }
                }
                return this.setPixels(gifFrame0, gifFrame1);
            }
            if(Log.isLoggable("StandardGifDecoder", 3)) {
                Log.d("StandardGifDecoder", "Unable to decode frame, status=" + this.status);
            }
            return null;
        }
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.status;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        int v = this.header.loopCount;
        if(v == -1) {
            return 1;
        }
        return v == 0 ? 0 : v + 1;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.header.width;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(InputStream inputStream0, int v) {
        if(inputStream0 == null) {
            this.status = 2;
        }
        else {
            try {
                ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream((v <= 0 ? 0x4000 : v + 0x1000));
                byte[] arr_b = new byte[0x4000];
                int v1;
                while((v1 = inputStream0.read(arr_b, 0, 0x4000)) != -1) {
                    byteArrayOutputStream0.write(arr_b, 0, v1);
                }
                byteArrayOutputStream0.flush();
                this.read(byteArrayOutputStream0.toByteArray());
                goto label_14;
            }
            catch(IOException iOException0) {
            }
            Log.w("StandardGifDecoder", "Error reading data from stream", iOException0);
        }
    label_14:
        if(inputStream0 != null) {
            try {
                inputStream0.close();
                return this.status;
            }
            catch(IOException iOException1) {
                Log.w("StandardGifDecoder", "Error closing stream", iOException1);
            }
        }
        return this.status;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(byte[] arr_b) {
        synchronized(this) {
            GifHeader gifHeader0 = this.getHeaderParser().setData(arr_b).parseHeader();
            this.header = gifHeader0;
            if(arr_b != null) {
                this.setData(gifHeader0, arr_b);
            }
            return this.status;
        }
    }

    private int readBlock() {
        int v = this.readByte();
        if(v <= 0) {
            return v;
        }
        this.rawData.get(this.block, 0, Math.min(v, this.rawData.remaining()));
        return v;
    }

    private int readByte() {
        return this.rawData.get() & 0xFF;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void setData(GifHeader gifHeader0, ByteBuffer byteBuffer0) {
        synchronized(this) {
            this.setData(gifHeader0, byteBuffer0, 1);
        }
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void setData(GifHeader gifHeader0, ByteBuffer byteBuffer0, int v) {
        synchronized(this) {
            if(v > 0) {
                int v2 = Integer.highestOneBit(v);
                this.status = 0;
                this.header = gifHeader0;
                this.framePointer = -1;
                ByteBuffer byteBuffer1 = byteBuffer0.asReadOnlyBuffer();
                this.rawData = byteBuffer1;
                byteBuffer1.position(0);
                this.rawData.order(ByteOrder.LITTLE_ENDIAN);
                this.savePrevious = false;
                for(Object object0: gifHeader0.frames) {
                    if(((GifFrame)object0).dispose == 3) {
                        this.savePrevious = true;
                        break;
                    }
                    if(false) {
                        break;
                    }
                }
                this.sampleSize = v2;
                int v3 = gifHeader0.width;
                this.downsampledWidth = v3 / v2;
                int v4 = gifHeader0.height;
                this.downsampledHeight = v4 / v2;
                this.mainPixels = this.bitmapProvider.obtainByteArray(v3 * v4);
                this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
                return;
            }
        }
        throw new IllegalArgumentException("Sample size must be >=0, not: " + v);
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void setData(GifHeader gifHeader0, byte[] arr_b) {
        synchronized(this) {
            this.setData(gifHeader0, ByteBuffer.wrap(arr_b));
        }
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(Bitmap.Config bitmap$Config0) {
        Bitmap.Config bitmap$Config1 = Bitmap.Config.ARGB_8888;
        if(bitmap$Config0 != bitmap$Config1) {
            Bitmap.Config bitmap$Config2 = Bitmap.Config.RGB_565;
            if(bitmap$Config0 != bitmap$Config2) {
                throw new IllegalArgumentException("Unsupported format: " + bitmap$Config0 + ", must be one of " + bitmap$Config1 + " or " + bitmap$Config2);
            }
        }
        this.bitmapConfig = bitmap$Config0;
    }

    private Bitmap setPixels(GifFrame gifFrame0, GifFrame gifFrame1) {
        int[] arr_v = this.mainScratch;
        int v = 0;
        if(gifFrame1 == null) {
            Bitmap bitmap0 = this.previousImage;
            if(bitmap0 != null) {
                this.bitmapProvider.release(bitmap0);
            }
            this.previousImage = null;
            Arrays.fill(arr_v, 0);
        }
        if(gifFrame1 != null && gifFrame1.dispose == 3 && this.previousImage == null) {
            Arrays.fill(arr_v, 0);
        }
        if(gifFrame1 != null) {
            int v1 = gifFrame1.dispose;
            if(v1 > 0) {
                switch(v1) {
                    case 2: {
                        if(!gifFrame0.transparency) {
                            int v2 = this.header.bgColor;
                            if(gifFrame0.lct == null || this.header.bgIndex != gifFrame0.transIndex) {
                                v = v2;
                            }
                        }
                        int v3 = this.sampleSize;
                        int v4 = gifFrame1.ih / v3;
                        int v5 = gifFrame1.iy / v3;
                        int v6 = gifFrame1.iw / v3;
                        int v7 = this.downsampledWidth;
                        int v8 = v5 * v7 + gifFrame1.ix / v3;
                        int v9 = v4 * v7 + v8;
                        while(v8 < v9) {
                            int v10 = v8 + v6;
                            for(int v11 = v8; v11 < v10; ++v11) {
                                arr_v[v11] = v;
                            }
                            v8 += this.downsampledWidth;
                        }
                        break;
                    }
                    case 3: {
                        Bitmap bitmap1 = this.previousImage;
                        if(bitmap1 != null) {
                            bitmap1.getPixels(arr_v, 0, this.downsampledWidth, 0, 0, this.downsampledWidth, this.downsampledHeight);
                        }
                    }
                }
            }
        }
        this.decodeBitmapData(gifFrame0);
        if(gifFrame0.interlace || this.sampleSize != 1) {
            this.copyCopyIntoScratchRobust(gifFrame0);
        }
        else {
            this.copyIntoScratchFast(gifFrame0);
        }
        if(this.savePrevious && (gifFrame0.dispose == 0 || gifFrame0.dispose == 1)) {
            if(this.previousImage == null) {
                this.previousImage = this.getNextBitmap();
            }
            this.previousImage.setPixels(arr_v, 0, this.downsampledWidth, 0, 0, this.downsampledWidth, this.downsampledHeight);
        }
        Bitmap bitmap2 = this.getNextBitmap();
        bitmap2.setPixels(arr_v, 0, this.downsampledWidth, 0, 0, this.downsampledWidth, this.downsampledHeight);
        return bitmap2;
    }
}

