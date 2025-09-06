package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;

public interface Transformation extends Key {
    Resource transform(Context arg1, Resource arg2, int arg3, int arg4);
}

