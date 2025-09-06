package com.bumptech.glide.module;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;

@Deprecated
public interface GlideModule extends AppliesOptions, RegistersComponents {
    @Override  // com.bumptech.glide.module.AppliesOptions
    void applyOptions(Context arg1, GlideBuilder arg2);

    @Override  // com.bumptech.glide.module.RegistersComponents
    void registerComponents(Context arg1, Glide arg2, Registry arg3);
}

