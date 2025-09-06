package com.bumptech.glide.load;

import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class ImageHeaderParserUtils {
    interface OrientationReader {
        int getOrientationAndRewind(ImageHeaderParser arg1);
    }

    interface TypeReader {
        ImageType getTypeAndRewind(ImageHeaderParser arg1);
    }

    private static final int MARK_READ_LIMIT = 0x500000;

    public static int getOrientation(List list0, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder0, ArrayPool arrayPool0) {
        return ImageHeaderParserUtils.getOrientationInternal(list0, new OrientationReader() {
            @Override  // com.bumptech.glide.load.ImageHeaderParserUtils$OrientationReader
            public int getOrientationAndRewind(ImageHeaderParser imageHeaderParser0) {
                int v;
                RecyclableBufferedInputStream recyclableBufferedInputStream0 = null;
                try {
                    recyclableBufferedInputStream0 = new RecyclableBufferedInputStream(new FileInputStream(parcelFileDescriptorRewinder0.rewindAndGet().getFileDescriptor()), arrayPool0);
                    v = imageHeaderParser0.getOrientation(recyclableBufferedInputStream0, arrayPool0);
                }
                catch(Throwable throwable0) {
                    if(recyclableBufferedInputStream0 != null) {
                        recyclableBufferedInputStream0.release();
                    }
                    parcelFileDescriptorRewinder0.rewindAndGet();
                    throw throwable0;
                }
                recyclableBufferedInputStream0.release();
                parcelFileDescriptorRewinder0.rewindAndGet();
                return v;
            }
        });
    }

    public static int getOrientation(List list0, InputStream inputStream0, ArrayPool arrayPool0) {
        if(inputStream0 == null) {
            return -1;
        }
        if(!inputStream0.markSupported()) {
            inputStream0 = new RecyclableBufferedInputStream(inputStream0, arrayPool0);
        }
        inputStream0.mark(0x500000);
        return ImageHeaderParserUtils.getOrientationInternal(list0, new OrientationReader() {
            @Override  // com.bumptech.glide.load.ImageHeaderParserUtils$OrientationReader
            public int getOrientationAndRewind(ImageHeaderParser imageHeaderParser0) {
                try {
                    return imageHeaderParser0.getOrientation(inputStream0, arrayPool0);
                }
                finally {
                    inputStream0.reset();
                }
            }
        });
    }

    public static int getOrientation(List list0, ByteBuffer byteBuffer0, ArrayPool arrayPool0) {
        return byteBuffer0 == null ? -1 : ImageHeaderParserUtils.getOrientationInternal(list0, new OrientationReader() {
            @Override  // com.bumptech.glide.load.ImageHeaderParserUtils$OrientationReader
            public int getOrientationAndRewind(ImageHeaderParser imageHeaderParser0) {
                try {
                    return imageHeaderParser0.getOrientation(byteBuffer0, arrayPool0);
                }
                finally {
                    ByteBufferUtil.rewind(byteBuffer0);
                }
            }
        });
    }

    private static int getOrientationInternal(List list0, OrientationReader imageHeaderParserUtils$OrientationReader0) {
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = imageHeaderParserUtils$OrientationReader0.getOrientationAndRewind(((ImageHeaderParser)list0.get(v1)));
            if(v2 != -1) {
                return v2;
            }
        }
        return -1;
    }

    public static ImageType getType(List list0, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder0, ArrayPool arrayPool0) {
        return ImageHeaderParserUtils.getTypeInternal(list0, new TypeReader() {
            @Override  // com.bumptech.glide.load.ImageHeaderParserUtils$TypeReader
            public ImageType getTypeAndRewind(ImageHeaderParser imageHeaderParser0) {
                ImageType imageHeaderParser$ImageType0;
                RecyclableBufferedInputStream recyclableBufferedInputStream0 = null;
                try {
                    recyclableBufferedInputStream0 = new RecyclableBufferedInputStream(new FileInputStream(parcelFileDescriptorRewinder0.rewindAndGet().getFileDescriptor()), arrayPool0);
                    imageHeaderParser$ImageType0 = imageHeaderParser0.getType(recyclableBufferedInputStream0);
                }
                catch(Throwable throwable0) {
                    if(recyclableBufferedInputStream0 != null) {
                        recyclableBufferedInputStream0.release();
                    }
                    parcelFileDescriptorRewinder0.rewindAndGet();
                    throw throwable0;
                }
                recyclableBufferedInputStream0.release();
                parcelFileDescriptorRewinder0.rewindAndGet();
                return imageHeaderParser$ImageType0;
            }
        });
    }

    public static ImageType getType(List list0, InputStream inputStream0, ArrayPool arrayPool0) {
        if(inputStream0 == null) {
            return ImageType.UNKNOWN;
        }
        if(!inputStream0.markSupported()) {
            inputStream0 = new RecyclableBufferedInputStream(inputStream0, arrayPool0);
        }
        inputStream0.mark(0x500000);
        return ImageHeaderParserUtils.getTypeInternal(list0, new TypeReader() {
            @Override  // com.bumptech.glide.load.ImageHeaderParserUtils$TypeReader
            public ImageType getTypeAndRewind(ImageHeaderParser imageHeaderParser0) {
                try {
                    return imageHeaderParser0.getType(inputStream0);
                }
                finally {
                    inputStream0.reset();
                }
            }
        });
    }

    public static ImageType getType(List list0, ByteBuffer byteBuffer0) {
        return byteBuffer0 == null ? ImageType.UNKNOWN : ImageHeaderParserUtils.getTypeInternal(list0, new TypeReader() {
            @Override  // com.bumptech.glide.load.ImageHeaderParserUtils$TypeReader
            public ImageType getTypeAndRewind(ImageHeaderParser imageHeaderParser0) {
                try {
                    return imageHeaderParser0.getType(byteBuffer0);
                }
                finally {
                    ByteBufferUtil.rewind(byteBuffer0);
                }
            }
        });
    }

    private static ImageType getTypeInternal(List list0, TypeReader imageHeaderParserUtils$TypeReader0) {
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ImageType imageHeaderParser$ImageType0 = imageHeaderParserUtils$TypeReader0.getTypeAndRewind(((ImageHeaderParser)list0.get(v1)));
            if(imageHeaderParser$ImageType0 != ImageType.UNKNOWN) {
                return imageHeaderParser$ImageType0;
            }
        }
        return ImageType.UNKNOWN;
    }
}

