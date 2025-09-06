package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

public class UnitTranscoder implements ResourceTranscoder {
    private static final UnitTranscoder UNIT_TRANSCODER;

    static {
        UnitTranscoder.UNIT_TRANSCODER = new UnitTranscoder();
    }

    public static ResourceTranscoder get() {
        return UnitTranscoder.UNIT_TRANSCODER;
    }

    @Override  // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource transcode(Resource resource0, Options options0) {
        return resource0;
    }
}

