package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;

public interface ResourceDecoder {
    Resource decode(Object arg1, int arg2, int arg3, Options arg4);

    boolean handles(Object arg1, Options arg2);
}

