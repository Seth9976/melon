package hd;

import com.iloen.melon.utils.log.LogU;
import kotlinx.coroutines.CoroutineExceptionHandler.Key;
import kotlinx.coroutines.CoroutineExceptionHandler;
import me.a;
import me.i;

public final class g1 extends a implements CoroutineExceptionHandler {
    public final m1 b;

    public g1(Key coroutineExceptionHandler$Key0, m1 m10) {
        this.b = m10;
        super(coroutineExceptionHandler$Key0);
    }

    @Override  // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(i i0, Throwable throwable0) {
        LogU.debug$default(this.b.f, "shareImage exceptionHandler : " + throwable0, null, false, 6, null);
        L l0 = new L(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        this.b.sendUiEvent(l0);
    }
}

