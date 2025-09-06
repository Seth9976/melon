package com.melon.ui;

import com.iloen.melon.utils.log.LogU;
import kotlinx.coroutines.CoroutineExceptionHandler.Key;
import kotlinx.coroutines.CoroutineExceptionHandler;
import me.a;
import me.i;

public final class i1 extends a implements CoroutineExceptionHandler {
    public final k1 b;

    public i1(Key coroutineExceptionHandler$Key0, k1 k10) {
        this.b = k10;
        super(coroutineExceptionHandler$Key0);
    }

    @Override  // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(i i0, Throwable throwable0) {
        LogU.debug$default(this.b.log, "exceptionHandler throwable:" + throwable0, null, false, 6, null);
    }
}

