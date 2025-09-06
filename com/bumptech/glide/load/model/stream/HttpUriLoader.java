package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.UrlUriLoader.StreamFactory;
import com.bumptech.glide.load.model.UrlUriLoader;

@Deprecated
public class HttpUriLoader extends UrlUriLoader {
    @Deprecated
    public static class Factory extends StreamFactory {
    }

    public HttpUriLoader(ModelLoader modelLoader0) {
        super(modelLoader0);
    }
}

