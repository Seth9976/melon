package com.bumptech.glide;

import com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory;
import com.bumptech.glide.module.AppGlideModule;
import java.util.HashSet;
import java.util.Set;

abstract class GeneratedAppGlideModule extends AppGlideModule {
    public Set getExcludedModuleClasses() {
        return new HashSet();
    }

    public RequestManagerFactory getRequestManagerFactory() {
        return null;
    }
}

