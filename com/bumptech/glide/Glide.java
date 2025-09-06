package com.bumptech.glide;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType.Builder;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Glide implements ComponentCallbacks2 {
    public interface RequestOptionsFactory {
        RequestOptions build();
    }

    private static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final String DESTROYED_ACTIVITY_WARNING = "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).";
    private static final String TAG = "Glide";
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;
    private BitmapPreFiller bitmapPreFiller;
    private final ConnectivityMonitorFactory connectivityMonitorFactory;
    private final RequestOptionsFactory defaultRequestOptionsFactory;
    private final Engine engine;
    private static volatile Glide glide;
    private final GlideContext glideContext;
    private static volatile boolean isInitializing;
    private final List managers;
    private final MemoryCache memoryCache;
    private MemoryCategory memoryCategory;
    private final RequestManagerRetriever requestManagerRetriever;

    public Glide(Context context0, Engine engine0, MemoryCache memoryCache0, BitmapPool bitmapPool0, ArrayPool arrayPool0, RequestManagerRetriever requestManagerRetriever0, ConnectivityMonitorFactory connectivityMonitorFactory0, int v, RequestOptionsFactory glide$RequestOptionsFactory0, Map map0, List list0, List list1, AppGlideModule appGlideModule0, GlideExperiments glideExperiments0) {
        this.managers = new ArrayList();
        this.memoryCategory = MemoryCategory.NORMAL;
        this.engine = engine0;
        this.bitmapPool = bitmapPool0;
        this.arrayPool = arrayPool0;
        this.memoryCache = memoryCache0;
        this.requestManagerRetriever = requestManagerRetriever0;
        this.connectivityMonitorFactory = connectivityMonitorFactory0;
        this.defaultRequestOptionsFactory = glide$RequestOptionsFactory0;
        this.glideContext = new GlideContext(context0, arrayPool0, RegistryFactory.lazilyCreateAndInitializeRegistry(this, list1, appGlideModule0), new ImageViewTargetFactory(), glide$RequestOptionsFactory0, map0, list0, engine0, glideExperiments0, v);
    }

    public static void checkAndInitializeGlide(Context context0, GeneratedAppGlideModule generatedAppGlideModule0) {
        if(!Glide.isInitializing) {
            try {
                Glide.isInitializing = true;
                Glide.initializeGlide(context0, generatedAppGlideModule0);
                Glide.isInitializing = false;
                return;
            }
            catch(Throwable throwable0) {
                Glide.isInitializing = false;
                throw throwable0;
            }
        }
        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
    }

    public void clearDiskCache() {
        Util.assertBackgroundThread();
        this.engine.clearDiskCache();
    }

    public void clearMemory() {
        Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
        this.arrayPool.clearMemory();
    }

    public static void enableHardwareBitmaps() {
        HardwareConfigState.getInstance().unblockHardwareBitmaps();
    }

    public static Glide get(Context context0) {
        if(Glide.glide == null) {
            GeneratedAppGlideModule generatedAppGlideModule0 = Glide.getAnnotationGeneratedGlideModules(context0.getApplicationContext());
            Class class0 = Glide.class;
            synchronized(class0) {
                if(Glide.glide == null) {
                    Glide.checkAndInitializeGlide(context0, generatedAppGlideModule0);
                }
            }
        }
        return Glide.glide;
    }

    // 去混淆评级： 低(30)
    private static GeneratedAppGlideModule getAnnotationGeneratedGlideModules(Context context0) {
        return new GeneratedAppGlideModuleImpl(context0.getApplicationContext());
    }

    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public ConnectivityMonitorFactory getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    public Context getContext() {
        return this.glideContext.getBaseContext();
    }

    public GlideContext getGlideContext() {
        return this.glideContext;
    }

    public static File getPhotoCacheDir(Context context0) {
        return Glide.getPhotoCacheDir(context0, "image_manager_disk_cache");
    }

    public static File getPhotoCacheDir(Context context0, String s) {
        File file0 = context0.getCacheDir();
        if(file0 != null) {
            File file1 = new File(file0, s);
            return file1.isDirectory() || file1.mkdirs() ? file1 : null;
        }
        if(Log.isLoggable("Glide", 6)) {
            Log.e("Glide", "default disk cache dir is null");
        }
        return null;
    }

    public Registry getRegistry() {
        return this.glideContext.getRegistry();
    }

    public RequestManagerRetriever getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    private static RequestManagerRetriever getRetriever(Context context0) {
        Preconditions.checkNotNull(context0, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return Glide.get(context0).getRequestManagerRetriever();
    }

    public static void init(Context context0, GlideBuilder glideBuilder0) {
        GeneratedAppGlideModule generatedAppGlideModule0 = Glide.getAnnotationGeneratedGlideModules(context0);
        synchronized(Glide.class) {
            if(Glide.glide != null) {
                Glide.tearDown();
            }
            Glide.initializeGlide(context0, glideBuilder0, generatedAppGlideModule0);
        }
    }

    @Deprecated
    public static void init(Glide glide0) {
        synchronized(Glide.class) {
            if(Glide.glide != null) {
                Glide.tearDown();
            }
            Glide.glide = glide0;
        }
    }

    private static void initializeGlide(Context context0, GeneratedAppGlideModule generatedAppGlideModule0) {
        Glide.initializeGlide(context0, new GlideBuilder(), generatedAppGlideModule0);
    }

    private static void initializeGlide(Context context0, GlideBuilder glideBuilder0, GeneratedAppGlideModule generatedAppGlideModule0) {
        Context context1 = context0.getApplicationContext();
        List list0 = generatedAppGlideModule0 != null && !generatedAppGlideModule0.isManifestParsingEnabled() ? Collections.EMPTY_LIST : new ManifestParser(context1).parse();
        if(generatedAppGlideModule0 != null && !generatedAppGlideModule0.getExcludedModuleClasses().isEmpty()) {
            Set set0 = generatedAppGlideModule0.getExcludedModuleClasses();
            Iterator iterator0 = list0.iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                GlideModule glideModule0 = (GlideModule)object0;
                if(set0.contains(glideModule0.getClass())) {
                    if(Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + glideModule0);
                    }
                    iterator0.remove();
                }
            }
        }
        if(Log.isLoggable("Glide", 3)) {
            for(Object object1: list0) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + ((GlideModule)object1).getClass());
            }
        }
        glideBuilder0.setRequestManagerFactory((generatedAppGlideModule0 == null ? null : generatedAppGlideModule0.getRequestManagerFactory()));
        for(Object object2: list0) {
            ((GlideModule)object2).applyOptions(context1, glideBuilder0);
        }
        if(generatedAppGlideModule0 != null) {
            generatedAppGlideModule0.applyOptions(context1, glideBuilder0);
        }
        Glide glide0 = glideBuilder0.build(context1, list0, generatedAppGlideModule0);
        context1.registerComponentCallbacks(glide0);
        Glide.glide = glide0;
    }

    public static boolean isInitialized() {
        synchronized(Glide.class) {
        }
        return Glide.glide != null;
    }

    @Override  // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration0) {
    }

    @Override  // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.clearMemory();
    }

    @Override  // android.content.ComponentCallbacks2
    public void onTrimMemory(int v) {
        this.trimMemory(v);
    }

    public void preFillBitmapPool(Builder[] arr_preFillType$Builder) {
        synchronized(this) {
            if(this.bitmapPreFiller == null) {
                DecodeFormat decodeFormat0 = (DecodeFormat)this.defaultRequestOptionsFactory.build().getOptions().get(Downsampler.DECODE_FORMAT);
                this.bitmapPreFiller = new BitmapPreFiller(this.memoryCache, this.bitmapPool, decodeFormat0);
            }
            this.bitmapPreFiller.preFill(arr_preFillType$Builder);
        }
    }

    public void registerRequestManager(RequestManager requestManager0) {
        synchronized(this.managers) {
            if(!this.managers.contains(requestManager0)) {
                this.managers.add(requestManager0);
                return;
            }
        }
        throw new IllegalStateException("Cannot register already registered manager");
    }

    public boolean removeFromManagers(Target target0) {
        synchronized(this.managers) {
            for(Object object0: this.managers) {
                if(((RequestManager)object0).untrack(target0)) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
            return false;
        }
    }

    public MemoryCategory setMemoryCategory(MemoryCategory memoryCategory0) {
        Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(memoryCategory0.getMultiplier());
        this.bitmapPool.setSizeMultiplier(memoryCategory0.getMultiplier());
        MemoryCategory memoryCategory1 = this.memoryCategory;
        this.memoryCategory = memoryCategory0;
        return memoryCategory1;
    }

    public static void tearDown() {
        synchronized(Glide.class) {
            if(Glide.glide != null) {
                Glide.glide.getContext().getApplicationContext().unregisterComponentCallbacks(Glide.glide);
                Glide.glide.engine.shutdown();
            }
            Glide.glide = null;
        }
    }

    private static void throwIncorrectGlideModule(Exception exception0) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you\'ve manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exception0);
    }

    public void trimMemory(int v) {
        Util.assertMainThread();
        synchronized(this.managers) {
            for(Object object0: this.managers) {
                ((RequestManager)object0).onTrimMemory(v);
            }
        }
        this.memoryCache.trimMemory(v);
        this.bitmapPool.trimMemory(v);
        this.arrayPool.trimMemory(v);
    }

    public void unregisterRequestManager(RequestManager requestManager0) {
        synchronized(this.managers) {
            if(this.managers.contains(requestManager0)) {
                this.managers.remove(requestManager0);
                return;
            }
        }
        throw new IllegalStateException("Cannot unregister not yet registered manager");
    }

    @Deprecated
    public static RequestManager with(Activity activity0) {
        return Glide.with(activity0.getApplicationContext());
    }

    @Deprecated
    public static RequestManager with(Fragment fragment0) {
        Activity activity0 = fragment0.getActivity();
        Preconditions.checkNotNull(activity0, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return Glide.with(activity0.getApplicationContext());
    }

    public static RequestManager with(Context context0) {
        return Glide.getRetriever(context0).get(context0);
    }

    public static RequestManager with(View view0) {
        return Glide.getRetriever(view0.getContext()).get(view0);
    }

    public static RequestManager with(FragmentActivity fragmentActivity0) {
        return Glide.getRetriever(fragmentActivity0).get(fragmentActivity0);
    }

    public static RequestManager with(I i0) {
        return Glide.getRetriever(i0.getContext()).get(i0);
    }
}

