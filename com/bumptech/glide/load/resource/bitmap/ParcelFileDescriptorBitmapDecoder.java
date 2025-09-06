package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder {
    private static final int MAXIMUM_FILE_BYTE_SIZE_FOR_FILE_DESCRIPTOR_DECODER = 0x20000000;
    private final Downsampler downsampler;

    public ParcelFileDescriptorBitmapDecoder(Downsampler downsampler0) {
        this.downsampler = downsampler0;
    }

    public Resource decode(ParcelFileDescriptor parcelFileDescriptor0, int v, int v1, Options options0) {
        return this.downsampler.decode(parcelFileDescriptor0, v, v1, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((ParcelFileDescriptor)object0), v, v1, options0);
    }

    // 去混淆评级： 低(20)
    public boolean handles(ParcelFileDescriptor parcelFileDescriptor0, Options options0) {
        return this.isSafeToTryDecoding(parcelFileDescriptor0) && this.downsampler.handles(parcelFileDescriptor0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((ParcelFileDescriptor)object0), options0);
    }

    // 去混淆评级： 低(20)
    private boolean isSafeToTryDecoding(ParcelFileDescriptor parcelFileDescriptor0) {
        return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER) ? parcelFileDescriptor0.getStatSize() <= 0x20000000L : true;
    }
}

