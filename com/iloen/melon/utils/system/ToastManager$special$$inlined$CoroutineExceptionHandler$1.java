package com.iloen.melon.utils.system;

import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineExceptionHandler.Key;
import kotlinx.coroutines.CoroutineExceptionHandler;
import me.a;
import me.i;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001F\u0010\b\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/iloen/melon/utils/system/ToastManager$special$$inlined$CoroutineExceptionHandler$1", "Lme/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lme/i;", "context", "", "exception", "Lie/H;", "handleException", "(Lme/i;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ToastManager.special..inlined.CoroutineExceptionHandler.1 extends a implements CoroutineExceptionHandler {
    public ToastManager.special..inlined.CoroutineExceptionHandler.1(Key coroutineExceptionHandler$Key0) {
        super(coroutineExceptionHandler$Key0);
    }

    @Override  // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(i i0, Throwable throwable0) {
        LogU.Companion.e("ToastManager", throwable0.toString());
    }
}

