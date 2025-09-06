package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

public interface RequestListener {
    boolean onLoadFailed(GlideException arg1, Object arg2, Target arg3, boolean arg4);

    boolean onResourceReady(Object arg1, Object arg2, Target arg3, DataSource arg4, boolean arg5);
}

