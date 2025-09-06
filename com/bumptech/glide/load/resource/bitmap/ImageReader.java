package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

interface ImageReader {
    public static final class ByteArrayReader implements ImageReader {
        private final ArrayPool byteArrayPool;
        private final byte[] bytes;
        private final List parsers;

        public ByteArrayReader(byte[] arr_b, List list0, ArrayPool arrayPool0) {
            this.bytes = arr_b;
            this.parsers = list0;
            this.byteArrayPool = arrayPool0;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options bitmapFactory$Options0) {
            return BitmapFactory.decodeByteArray(this.bytes, 0, this.bytes.length, bitmapFactory$Options0);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() {
            ByteBuffer byteBuffer0 = ByteBuffer.wrap(this.bytes);
            return ImageHeaderParserUtils.getOrientation(this.parsers, byteBuffer0, this.byteArrayPool);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageType getImageType() {
            ByteBuffer byteBuffer0 = ByteBuffer.wrap(this.bytes);
            return ImageHeaderParserUtils.getType(this.parsers, byteBuffer0);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }
    }

    public static final class ByteBufferReader implements ImageReader {
        private final ByteBuffer buffer;
        private final ArrayPool byteArrayPool;
        private final List parsers;

        public ByteBufferReader(ByteBuffer byteBuffer0, List list0, ArrayPool arrayPool0) {
            this.buffer = byteBuffer0;
            this.parsers = list0;
            this.byteArrayPool = arrayPool0;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options bitmapFactory$Options0) {
            return BitmapFactory.decodeStream(this.stream(), null, bitmapFactory$Options0);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() {
            ByteBuffer byteBuffer0 = ByteBufferUtil.rewind(this.buffer);
            return ImageHeaderParserUtils.getOrientation(this.parsers, byteBuffer0, this.byteArrayPool);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageType getImageType() {
            ByteBuffer byteBuffer0 = ByteBufferUtil.rewind(this.buffer);
            return ImageHeaderParserUtils.getType(this.parsers, byteBuffer0);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }

        private InputStream stream() {
            return ByteBufferUtil.toStream(ByteBufferUtil.rewind(this.buffer));
        }
    }

    public static final class FileReader implements ImageReader {
        private final ArrayPool byteArrayPool;
        private final File file;
        private final List parsers;

        public FileReader(File file0, List list0, ArrayPool arrayPool0) {
            this.file = file0;
            this.parsers = list0;
            this.byteArrayPool = arrayPool0;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options bitmapFactory$Options0) {
            Bitmap bitmap0;
            RecyclableBufferedInputStream recyclableBufferedInputStream0 = null;
            try {
                recyclableBufferedInputStream0 = new RecyclableBufferedInputStream(new FileInputStream(this.file), this.byteArrayPool);
                bitmap0 = BitmapFactory.decodeStream(recyclableBufferedInputStream0, null, bitmapFactory$Options0);
            }
            catch(Throwable throwable0) {
                if(recyclableBufferedInputStream0 != null) {
                    try {
                        recyclableBufferedInputStream0.close();
                    }
                    catch(IOException unused_ex) {
                    }
                }
                throw throwable0;
            }
            try {
                recyclableBufferedInputStream0.close();
            }
            catch(IOException unused_ex) {
            }
            return bitmap0;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() {
            int v;
            Throwable throwable1;
            RecyclableBufferedInputStream recyclableBufferedInputStream0;
            try {
                recyclableBufferedInputStream0 = new RecyclableBufferedInputStream(new FileInputStream(this.file), this.byteArrayPool);
            }
            catch(Throwable throwable0) {
                recyclableBufferedInputStream0 = null;
                throwable1 = throwable0;
                goto label_9;
            }
            try {
                v = ImageHeaderParserUtils.getOrientation(this.parsers, recyclableBufferedInputStream0, this.byteArrayPool);
                goto label_12;
            }
            catch(Throwable throwable1) {
            }
        label_9:
            if(recyclableBufferedInputStream0 != null) {
                try {
                    recyclableBufferedInputStream0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable1;
            try {
            label_12:
                recyclableBufferedInputStream0.close();
            }
            catch(IOException unused_ex) {
            }
            return v;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageType getImageType() {
            ImageType imageHeaderParser$ImageType0;
            Throwable throwable1;
            RecyclableBufferedInputStream recyclableBufferedInputStream0;
            try {
                recyclableBufferedInputStream0 = new RecyclableBufferedInputStream(new FileInputStream(this.file), this.byteArrayPool);
            }
            catch(Throwable throwable0) {
                recyclableBufferedInputStream0 = null;
                throwable1 = throwable0;
                goto label_9;
            }
            try {
                imageHeaderParser$ImageType0 = ImageHeaderParserUtils.getType(this.parsers, recyclableBufferedInputStream0, this.byteArrayPool);
                goto label_12;
            }
            catch(Throwable throwable1) {
            }
        label_9:
            if(recyclableBufferedInputStream0 != null) {
                try {
                    recyclableBufferedInputStream0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable1;
            try {
            label_12:
                recyclableBufferedInputStream0.close();
            }
            catch(IOException unused_ex) {
            }
            return imageHeaderParser$ImageType0;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }
    }

    public static final class InputStreamImageReader implements ImageReader {
        private final ArrayPool byteArrayPool;
        private final InputStreamRewinder dataRewinder;
        private final List parsers;

        public InputStreamImageReader(InputStream inputStream0, List list0, ArrayPool arrayPool0) {
            this.byteArrayPool = (ArrayPool)Preconditions.checkNotNull(arrayPool0);
            this.parsers = (List)Preconditions.checkNotNull(list0);
            this.dataRewinder = new InputStreamRewinder(inputStream0, arrayPool0);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options bitmapFactory$Options0) {
            return BitmapFactory.decodeStream(this.dataRewinder.rewindAndGet(), null, bitmapFactory$Options0);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() {
            InputStream inputStream0 = this.dataRewinder.rewindAndGet();
            return ImageHeaderParserUtils.getOrientation(this.parsers, inputStream0, this.byteArrayPool);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageType getImageType() {
            InputStream inputStream0 = this.dataRewinder.rewindAndGet();
            return ImageHeaderParserUtils.getType(this.parsers, inputStream0, this.byteArrayPool);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
            this.dataRewinder.fixMarkLimits();
        }
    }

    public static final class ParcelFileDescriptorImageReader implements ImageReader {
        private final ArrayPool byteArrayPool;
        private final ParcelFileDescriptorRewinder dataRewinder;
        private final List parsers;

        public ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor0, List list0, ArrayPool arrayPool0) {
            this.byteArrayPool = (ArrayPool)Preconditions.checkNotNull(arrayPool0);
            this.parsers = (List)Preconditions.checkNotNull(list0);
            this.dataRewinder = new ParcelFileDescriptorRewinder(parcelFileDescriptor0);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options bitmapFactory$Options0) {
            return BitmapFactory.decodeFileDescriptor(this.dataRewinder.rewindAndGet().getFileDescriptor(), null, bitmapFactory$Options0);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() {
            return ImageHeaderParserUtils.getOrientation(this.parsers, this.dataRewinder, this.byteArrayPool);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageType getImageType() {
            return ImageHeaderParserUtils.getType(this.parsers, this.dataRewinder, this.byteArrayPool);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }
    }

    Bitmap decodeBitmap(BitmapFactory.Options arg1);

    int getImageOrientation();

    ImageType getImageType();

    void stopGrowingBuffers();
}

