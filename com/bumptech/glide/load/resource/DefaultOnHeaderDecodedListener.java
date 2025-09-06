package com.bumptech.glide.load.resource;

import android.graphics.ColorSpace.Named;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder.DecodeException;
import android.graphics.ImageDecoder.ImageInfo;
import android.graphics.ImageDecoder.OnHeaderDecodedListener;
import android.graphics.ImageDecoder.OnPartialImageListener;
import android.graphics.ImageDecoder.Source;
import android.graphics.ImageDecoder;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Size;
import androidx.window.layout.util.a;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import k5.s;

public final class DefaultOnHeaderDecodedListener implements ImageDecoder.OnHeaderDecodedListener {
    private static final String TAG = "ImageDecoder";
    private final DecodeFormat decodeFormat;
    private final HardwareConfigState hardwareConfigState;
    private final boolean isHardwareConfigAllowed;
    private final PreferredColorSpace preferredColorSpace;
    private final int requestedHeight;
    private final int requestedWidth;
    private final DownsampleStrategy strategy;

    public DefaultOnHeaderDecodedListener(int v, int v1, Options options0) {
        this.hardwareConfigState = HardwareConfigState.getInstance();
        this.requestedWidth = v;
        this.requestedHeight = v1;
        this.decodeFormat = (DecodeFormat)options0.get(Downsampler.DECODE_FORMAT);
        this.strategy = (DownsampleStrategy)options0.get(DownsampleStrategy.OPTION);
        this.isHardwareConfigAllowed = options0.get(Downsampler.ALLOW_HARDWARE_CONFIG) != null && ((Boolean)options0.get(Downsampler.ALLOW_HARDWARE_CONFIG)).booleanValue();
        this.preferredColorSpace = (PreferredColorSpace)options0.get(Downsampler.PREFERRED_COLOR_SPACE);
    }

    @Override  // android.graphics.ImageDecoder$OnHeaderDecodedListener
    public void onHeaderDecoded(ImageDecoder imageDecoder0, ImageDecoder.ImageInfo imageDecoder$ImageInfo0, ImageDecoder.Source imageDecoder$Source0) {
        if(this.hardwareConfigState.isHardwareConfigAllowed(this.requestedWidth, this.requestedHeight, this.isHardwareConfigAllowed, false)) {
            a.m(imageDecoder0);
        }
        else {
            a.x(imageDecoder0);
        }
        if(this.decodeFormat == DecodeFormat.PREFER_RGB_565) {
            a.B(imageDecoder0);
        }
        imageDecoder0.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() {
            @Override  // android.graphics.ImageDecoder$OnPartialImageListener
            public boolean onPartialImage(ImageDecoder.DecodeException imageDecoder$DecodeException0) {
                return false;
            }
        });
        Size size0 = s.f(imageDecoder$ImageInfo0);
        int v = this.requestedWidth == 0x80000000 ? size0.getWidth() : this.requestedWidth;
        int v1 = this.requestedHeight == 0x80000000 ? size0.getHeight() : this.requestedHeight;
        int v2 = size0.getWidth();
        int v3 = size0.getHeight();
        float f = this.strategy.getScaleFactor(v2, v3, v, v1);
        int v4 = Math.round(((float)size0.getWidth()) * f);
        int v5 = Math.round(((float)size0.getHeight()) * f);
        if(Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size0.getWidth() + "x" + size0.getHeight() + "] to [" + v4 + "x" + v5 + "] scaleFactor: " + f);
        }
        s.g(imageDecoder0, v4, v5);
        PreferredColorSpace preferredColorSpace0 = this.preferredColorSpace;
        if(preferredColorSpace0 != null) {
            if(Build.VERSION.SDK_INT >= 28) {
                com.iloen.melon.utils.system.a.p(imageDecoder0, ColorSpace.get((preferredColorSpace0 != PreferredColorSpace.DISPLAY_P3 || imageDecoder$ImageInfo0.getColorSpace() == null || !imageDecoder$ImageInfo0.getColorSpace().isWideGamut() ? ColorSpace.Named.SRGB : ColorSpace.Named.DISPLAY_P3)));
                return;
            }
            com.iloen.melon.utils.system.a.p(imageDecoder0, ColorSpace.get(ColorSpace.Named.SRGB));
        }
    }
}

