package com.bumptech.glide.util;

import com.bumptech.glide.ListPreloader.PreloadSizeProvider;

public class FixedPreloadSizeProvider implements PreloadSizeProvider {
    private final int[] size;

    public FixedPreloadSizeProvider(int v, int v1) {
        this.size = new int[]{v, v1};
    }

    @Override  // com.bumptech.glide.ListPreloader$PreloadSizeProvider
    public int[] getPreloadSize(Object object0, int v, int v1) {
        return this.size;
    }
}

