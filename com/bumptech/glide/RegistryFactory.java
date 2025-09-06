package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.os.Trace;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.DirectResourceLoader;
import com.bumptech.glide.load.model.FileLoader.FileDescriptorFactory;
import com.bumptech.glide.load.model.FileLoader.StreamFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader.AssetFileDescriptorFactory;
import com.bumptech.glide.load.model.ResourceLoader.UriFactory;
import com.bumptech.glide.load.model.ResourceUriLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.UnitModelLoader.Factory;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader.InputStreamFactory;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.util.GlideSuppliers.GlideSupplier;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.List;

final class RegistryFactory {
    public static Registry createAndInitRegistry(Glide glide0, List list0, AppGlideModule appGlideModule0) {
        Context context0 = glide0.getGlideContext().getApplicationContext();
        Registry registry0 = new Registry();
        RegistryFactory.initializeDefaults(context0, registry0, glide0.getBitmapPool(), glide0.getArrayPool(), glide0.getGlideContext().getExperiments());
        RegistryFactory.initializeModules(context0, glide0, registry0, list0, appGlideModule0);
        return registry0;
    }

    private static void initializeDefaults(Context context0, Registry registry0, BitmapPool bitmapPool0, ArrayPool arrayPool0, GlideExperiments glideExperiments0) {
        ByteBufferBitmapDecoder byteBufferBitmapDecoder0;
        StreamBitmapDecoder streamBitmapDecoder0;
        registry0.register(new DefaultImageHeaderParser());
        int v = Build.VERSION.SDK_INT;
        if(v >= 27) {
            registry0.register(new ExifInterfaceImageHeaderParser());
        }
        Resources resources0 = context0.getResources();
        List list0 = registry0.getImageHeaderParsers();
        ByteBufferGifDecoder byteBufferGifDecoder0 = new ByteBufferGifDecoder(context0, list0, bitmapPool0, arrayPool0);
        ResourceDecoder resourceDecoder0 = VideoDecoder.parcel(bitmapPool0);
        Downsampler downsampler0 = new Downsampler(registry0.getImageHeaderParsers(), resources0.getDisplayMetrics(), bitmapPool0, arrayPool0);
        if(v < 28 || !glideExperiments0.isEnabled(EnableImageDecoderForBitmaps.class)) {
            byteBufferBitmapDecoder0 = new ByteBufferBitmapDecoder(downsampler0);
            streamBitmapDecoder0 = new StreamBitmapDecoder(downsampler0, arrayPool0);
        }
        else {
            streamBitmapDecoder0 = new InputStreamBitmapImageDecoderResourceDecoder();
            byteBufferBitmapDecoder0 = new ByteBufferBitmapImageDecoderResourceDecoder();
        }
        Class class0 = ByteBuffer.class;
        Class class1 = Drawable.class;
        Class class2 = InputStream.class;
        if(v >= 28) {
            registry0.append("Animation", class2, class1, AnimatedImageDecoder.streamDecoder(list0, arrayPool0));
            registry0.append("Animation", class0, class1, AnimatedImageDecoder.byteBufferDecoder(list0, arrayPool0));
        }
        ResourceDrawableDecoder resourceDrawableDecoder0 = new ResourceDrawableDecoder(context0);
        BitmapEncoder bitmapEncoder0 = new BitmapEncoder(arrayPool0);
        BitmapBytesTranscoder bitmapBytesTranscoder0 = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder0 = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver0 = context0.getContentResolver();
        Registry registry1 = registry0.append(class0, new ByteBufferEncoder()).append(class2, new StreamEncoder(arrayPool0));
        Class class3 = Bitmap.class;
        registry1.append("Bitmap", class0, class3, byteBufferBitmapDecoder0).append("Bitmap", class2, class3, streamBitmapDecoder0);
        Class class4 = ParcelFileDescriptor.class;
        registry0.append("Bitmap", class4, class3, new ParcelFileDescriptorBitmapDecoder(downsampler0));
        ResourceDecoder resourceDecoder1 = VideoDecoder.asset(bitmapPool0);
        registry0.append("Bitmap", AssetFileDescriptor.class, class3, resourceDecoder1);
        Registry registry2 = registry0.append("Bitmap", class4, class3, resourceDecoder0);
        Class class5 = AssetFileDescriptor.class;
        Registry registry3 = registry2.append(class3, class3, Factory.getInstance()).append("Bitmap", class3, class3, new UnitBitmapDecoder()).append(class3, bitmapEncoder0);
        BitmapDrawableDecoder bitmapDrawableDecoder0 = new BitmapDrawableDecoder(resources0, byteBufferBitmapDecoder0);
        Class class6 = BitmapDrawable.class;
        Registry registry4 = registry3.append("BitmapDrawable", class0, class6, bitmapDrawableDecoder0).append("BitmapDrawable", class2, class6, new BitmapDrawableDecoder(resources0, streamBitmapDecoder0)).append("BitmapDrawable", class4, class6, new BitmapDrawableDecoder(resources0, resourceDecoder0)).append(class6, new BitmapDrawableEncoder(bitmapPool0, bitmapEncoder0));
        StreamGifDecoder streamGifDecoder0 = new StreamGifDecoder(list0, byteBufferGifDecoder0, arrayPool0);
        Class class7 = GifDrawable.class;
        Registry registry5 = registry4.append("Animation", class2, class7, streamGifDecoder0).append("Animation", class0, class7, byteBufferGifDecoder0).append(class7, new GifDrawableEncoder()).append(GifDecoder.class, GifDecoder.class, Factory.getInstance());
        GifFrameResourceDecoder gifFrameResourceDecoder0 = new GifFrameResourceDecoder(bitmapPool0);
        Registry registry6 = registry5.append("Bitmap", GifDecoder.class, class3, gifFrameResourceDecoder0);
        Class class8 = Uri.class;
        Registry registry7 = registry6.append(class8, class1, resourceDrawableDecoder0).append(class8, class3, new ResourceBitmapDecoder(resourceDrawableDecoder0, bitmapPool0)).register(new com.bumptech.glide.load.resource.bytes.ByteBufferRewinder.Factory());
        com.bumptech.glide.load.model.ByteBufferFileLoader.Factory byteBufferFileLoader$Factory0 = new com.bumptech.glide.load.model.ByteBufferFileLoader.Factory();
        Class class9 = File.class;
        registry7.append(class9, class0, byteBufferFileLoader$Factory0).append(class9, class2, new StreamFactory()).append(class9, class9, new FileDecoder()).append(class9, class4, new FileDescriptorFactory()).append(class9, class9, Factory.getInstance()).register(new com.bumptech.glide.load.data.InputStreamRewinder.Factory(arrayPool0));
        registry0.register(new com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.Factory());
        ModelLoaderFactory modelLoaderFactory0 = DirectResourceLoader.inputStreamFactory(context0);
        ModelLoaderFactory modelLoaderFactory1 = DirectResourceLoader.assetFileDescriptorFactory(context0);
        ModelLoaderFactory modelLoaderFactory2 = DirectResourceLoader.drawableFactory(context0);
        Class class10 = Integer.TYPE;
        registry0.append(class10, class2, modelLoaderFactory0).append(Integer.class, class2, modelLoaderFactory0).append(class10, class5, modelLoaderFactory1).append(Integer.class, class5, modelLoaderFactory1).append(class10, class1, modelLoaderFactory2).append(Integer.class, class1, modelLoaderFactory2).append(class8, class2, ResourceUriLoader.newStreamFactory(context0)).append(class8, class5, ResourceUriLoader.newAssetFileDescriptorFactory(context0));
        UriFactory resourceLoader$UriFactory0 = new UriFactory(resources0);
        AssetFileDescriptorFactory resourceLoader$AssetFileDescriptorFactory0 = new AssetFileDescriptorFactory(resources0);
        com.bumptech.glide.load.model.ResourceLoader.StreamFactory resourceLoader$StreamFactory0 = new com.bumptech.glide.load.model.ResourceLoader.StreamFactory(resources0);
        registry0.append(Integer.class, class8, resourceLoader$UriFactory0).append(class10, class8, resourceLoader$UriFactory0).append(Integer.class, class5, resourceLoader$AssetFileDescriptorFactory0).append(class10, class5, resourceLoader$AssetFileDescriptorFactory0).append(Integer.class, class2, resourceLoader$StreamFactory0).append(class10, class2, resourceLoader$StreamFactory0);
        com.bumptech.glide.load.model.DataUrlLoader.StreamFactory dataUrlLoader$StreamFactory0 = new com.bumptech.glide.load.model.DataUrlLoader.StreamFactory();
        Registry registry8 = registry0.append(String.class, class2, dataUrlLoader$StreamFactory0).append(class8, class2, new com.bumptech.glide.load.model.DataUrlLoader.StreamFactory());
        com.bumptech.glide.load.model.StringLoader.StreamFactory stringLoader$StreamFactory0 = new com.bumptech.glide.load.model.StringLoader.StreamFactory();
        Registry registry9 = registry8.append(String.class, class2, stringLoader$StreamFactory0);
        com.bumptech.glide.load.model.StringLoader.FileDescriptorFactory stringLoader$FileDescriptorFactory0 = new com.bumptech.glide.load.model.StringLoader.FileDescriptorFactory();
        Registry registry10 = registry9.append(String.class, class4, stringLoader$FileDescriptorFactory0);
        com.bumptech.glide.load.model.StringLoader.AssetFileDescriptorFactory stringLoader$AssetFileDescriptorFactory0 = new com.bumptech.glide.load.model.StringLoader.AssetFileDescriptorFactory();
        registry10.append(String.class, class5, stringLoader$AssetFileDescriptorFactory0).append(class8, class2, new com.bumptech.glide.load.model.AssetUriLoader.StreamFactory(context0.getAssets())).append(class8, class5, new com.bumptech.glide.load.model.AssetUriLoader.FileDescriptorFactory(context0.getAssets())).append(class8, class2, new com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader.Factory(context0)).append(class8, class2, new com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader.Factory(context0));
        if(v >= 29) {
            registry0.append(class8, class2, new InputStreamFactory(context0));
            registry0.append(class8, class4, new com.bumptech.glide.load.model.stream.QMediaStoreUriLoader.FileDescriptorFactory(context0));
        }
        Registry registry11 = registry0.append(class8, class2, new com.bumptech.glide.load.model.UriLoader.StreamFactory(contentResolver0)).append(class8, class4, new com.bumptech.glide.load.model.UriLoader.FileDescriptorFactory(contentResolver0)).append(class8, class5, new com.bumptech.glide.load.model.UriLoader.AssetFileDescriptorFactory(contentResolver0)).append(class8, class2, new com.bumptech.glide.load.model.UrlUriLoader.StreamFactory());
        com.bumptech.glide.load.model.stream.UrlLoader.StreamFactory urlLoader$StreamFactory0 = new com.bumptech.glide.load.model.stream.UrlLoader.StreamFactory();
        Registry registry12 = registry11.append(URL.class, class2, urlLoader$StreamFactory0).append(class8, class9, new com.bumptech.glide.load.model.MediaStoreFileLoader.Factory(context0));
        com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Factory httpGlideUrlLoader$Factory0 = new com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Factory();
        Registry registry13 = registry12.append(GlideUrl.class, class2, httpGlideUrlLoader$Factory0);
        ByteBufferFactory byteArrayLoader$ByteBufferFactory0 = new ByteBufferFactory();
        Registry registry14 = registry13.append(byte[].class, class0, byteArrayLoader$ByteBufferFactory0);
        com.bumptech.glide.load.model.ByteArrayLoader.StreamFactory byteArrayLoader$StreamFactory0 = new com.bumptech.glide.load.model.ByteArrayLoader.StreamFactory();
        Registry registry15 = registry14.append(byte[].class, class2, byteArrayLoader$StreamFactory0).append(class8, class8, Factory.getInstance()).append(class1, class1, Factory.getInstance()).append(class1, class1, new UnitDrawableDecoder()).register(class3, class6, new BitmapDrawableTranscoder(resources0)).register(class3, byte[].class, bitmapBytesTranscoder0);
        DrawableBytesTranscoder drawableBytesTranscoder0 = new DrawableBytesTranscoder(bitmapPool0, bitmapBytesTranscoder0, gifDrawableBytesTranscoder0);
        registry15.register(class1, byte[].class, drawableBytesTranscoder0).register(class7, byte[].class, gifDrawableBytesTranscoder0);
        ResourceDecoder resourceDecoder2 = VideoDecoder.byteBuffer(bitmapPool0);
        registry0.append(class0, class3, resourceDecoder2);
        registry0.append(class0, class6, new BitmapDrawableDecoder(resources0, resourceDecoder2));
    }

    private static void initializeModules(Context context0, Glide glide0, Registry registry0, List list0, AppGlideModule appGlideModule0) {
        for(Object object0: list0) {
            GlideModule glideModule0 = (GlideModule)object0;
            try {
                glideModule0.registerComponents(context0, glide0, registry0);
            }
            catch(AbstractMethodError abstractMethodError0) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you\'re using Glide v4. You\'ll need to find and remove (or update) the offending dependency. The v3 module name is: " + glideModule0.getClass().getName(), abstractMethodError0);
            }
        }
        if(appGlideModule0 != null) {
            appGlideModule0.registerComponents(context0, glide0, registry0);
        }
    }

    public static GlideSupplier lazilyCreateAndInitializeRegistry(Glide glide0, List list0, AppGlideModule appGlideModule0) {
        return new GlideSupplier() {
            private boolean isInitializing;

            public Registry get() {
                if(!this.isInitializing) {
                    Trace.beginSection("Glide registry");
                    this.isInitializing = true;
                    try {
                        return RegistryFactory.createAndInitRegistry(glide0, list0, appGlideModule0);
                    }
                    finally {
                        this.isInitializing = false;
                        Trace.endSection();
                    }
                }
                throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you\'re using the provided Registry rather calling glide.getRegistry()!");
            }

            @Override  // com.bumptech.glide.util.GlideSuppliers$GlideSupplier
            public Object get() {
                return this.get();
            }
        };
    }
}

