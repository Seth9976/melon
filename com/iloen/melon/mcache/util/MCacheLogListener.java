package com.iloen.melon.mcache.util;

import com.iloen.melon.mcache.error.MCacheError;

public interface MCacheLogListener {
    void onCacheHitLog(String arg1, long arg2);

    void onErrorLog(String arg1, String arg2, MCacheError arg3);
}

