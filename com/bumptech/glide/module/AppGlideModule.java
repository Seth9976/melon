package com.bumptech.glide.module;

import android.content.Context;
import com.bumptech.glide.GlideBuilder;

public abstract class AppGlideModule extends LibraryGlideModule implements AppliesOptions {
    @Override  // com.bumptech.glide.module.AppliesOptions
    public void applyOptions(Context context0, GlideBuilder glideBuilder0) {
    }

    public boolean isManifestParsingEnabled() {
        return true;
    }
}

