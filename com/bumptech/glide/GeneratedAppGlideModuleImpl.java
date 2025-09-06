package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.integration.okhttp3.MelonOkHttpGlideModule;
import com.bumptech.glide.integration.webp.WebpGlideLibraryModule;
import com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory;
import java.util.Collections;
import java.util.Set;

final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final MelonOkHttpGlideModule appGlideModule;

    public GeneratedAppGlideModuleImpl(Context context0) {
        this.appGlideModule = new MelonOkHttpGlideModule();
        if(Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.bumptech.glide.integration.okhttp3.MelonOkHttpGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.webp.WebpGlideLibraryModule");
        }
    }

    @Override  // com.bumptech.glide.module.AppGlideModule
    public void applyOptions(Context context0, GlideBuilder glideBuilder0) {
        this.appGlideModule.applyOptions(context0, glideBuilder0);
    }

    @Override  // com.bumptech.glide.GeneratedAppGlideModule
    public Set getExcludedModuleClasses() {
        return Collections.EMPTY_SET;
    }

    public GeneratedRequestManagerFactory getRequestManagerFactory() {
        return new GeneratedRequestManagerFactory();
    }

    @Override  // com.bumptech.glide.GeneratedAppGlideModule
    public RequestManagerFactory getRequestManagerFactory() {
        return this.getRequestManagerFactory();
    }

    @Override  // com.bumptech.glide.module.AppGlideModule
    public boolean isManifestParsingEnabled() {
        return false;
    }

    @Override  // com.bumptech.glide.module.LibraryGlideModule
    public void registerComponents(Context context0, Glide glide0, Registry registry0) {
        new WebpGlideLibraryModule().registerComponents(context0, glide0, registry0);
        this.appGlideModule.registerComponents(context0, glide0, registry0);
    }
}

