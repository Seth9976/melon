package com.bumptech.glide.load.model;

public interface ModelLoaderFactory {
    ModelLoader build(MultiModelLoaderFactory arg1);

    void teardown();
}

