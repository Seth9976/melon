package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import java.util.Map;

class EngineKeyFactory {
    public EngineKey buildKey(Object object0, Key key0, int v, int v1, Map map0, Class class0, Class class1, Options options0) {
        return new EngineKey(object0, key0, v, v1, map0, class0, class1, options0);
    }
}

