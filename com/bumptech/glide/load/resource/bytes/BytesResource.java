package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class BytesResource implements Resource {
    private final byte[] bytes;

    public BytesResource(byte[] arr_b) {
        this.bytes = (byte[])Preconditions.checkNotNull(arr_b);
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public Object get() {
        return this.get();
    }

    public byte[] get() {
        return this.bytes;
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public Class getResourceClass() {
        return byte[].class;
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.bytes.length;
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }
}

