package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.ByteBufferUtil;

public class GifDrawableBytesTranscoder implements ResourceTranscoder {
    @Override  // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource transcode(Resource resource0, Options options0) {
        return new BytesResource(ByteBufferUtil.toBytes(((GifDrawable)resource0.get()).getBuffer()));
    }
}

