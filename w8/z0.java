package w8;

import Cb.j;
import bb.f;
import bb.h;
import bb.k;
import bb.l;
import bb.o;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

public final class z0 implements FlowCollector {
    public static final z0 a;

    static {
        z0.a = new z0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(((o)object0) instanceof h) {
            j.b(((h)(((o)object0))).a, false, 3);
            return H.a;
        }
        if(((o)object0) instanceof k) {
            ToastManager.showShort(0x7F1308D1);  // string:retry_after_login "로그인 후 이용해 주세요."
            return H.a;
        }
        if(((o)object0) instanceof f) {
            String s = ((f)(((o)object0))).a.getMessage();
            if(s != null) {
                LogU.Companion.e("LikeableWidget", s);
                ToastManager.showShort(s);
                return H.a;
            }
        }
        else {
            if(((o)object0) instanceof l) {
                ToastManager.showShort(((l)(((o)object0))).a);
                return H.a;
            }
            LogU.Companion.d("LikeableWidget", "processLikeChangeIntent() - unhandled useCaseResult: " + ((o)object0));
        }
        return H.a;
    }
}

