package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;

interface EngineJobListener {
    void onEngineJobCancelled(EngineJob arg1, Key arg2);

    void onEngineJobComplete(EngineJob arg1, Key arg2, EngineResource arg3);
}

