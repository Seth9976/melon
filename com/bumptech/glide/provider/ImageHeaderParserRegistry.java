package com.bumptech.glide.provider;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

public final class ImageHeaderParserRegistry {
    private final List parsers;

    public ImageHeaderParserRegistry() {
        this.parsers = new ArrayList();
    }

    public void add(ImageHeaderParser imageHeaderParser0) {
        synchronized(this) {
            this.parsers.add(imageHeaderParser0);
        }
    }

    public List getParsers() {
        synchronized(this) {
        }
        return this.parsers;
    }
}

