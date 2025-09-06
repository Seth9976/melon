package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.target.Target;

@Deprecated
public abstract class ExperimentalRequestListener implements RequestListener {
    public void onRequestStarted(Object object0) {
    }

    public abstract boolean onResourceReady(Object arg1, Object arg2, Target arg3, DataSource arg4, boolean arg5, boolean arg6);
}

