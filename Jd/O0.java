package jd;

import com.melon.ui.q4;
import i.n.i.b.a.s.e.M3;
import kb.E;
import kb.F;
import kb.G;
import kb.H;
import kb.I;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowCollector;

public final class o0 implements FlowCollector {
    public final M0 a;

    public o0(M0 m00) {
        this.a = m00;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        M0 m00 = this.a;
        if(((I)object0) instanceof H) {
            m00.sendUiEvent(new jd.I(((H)(((I)object0))).a, ((H)(((I)object0))).b));
            return ie.H.a;
        }
        if(((I)object0) instanceof E) {
            m00.sendUiEvent(D.a);
            q.f("문제가 발생했습니다.\n잠시후 이용하시기 바랍니다.", "getString(...)");
            m00.sendUiEvent(new q4(28, "", "문제가 발생했습니다.\n잠시후 이용하시기 바랍니다.", null, null));
            return ie.H.a;
        }
        if(((I)object0) instanceof F) {
            q.f("네트워크 연결 확인", "getString(...)");
            q.f("데이터 네트워크 차단 상태입니다.\n차단 해제 또는 Wi-Fi설정 후 사용해주세요.", "getString(...)");
            m00.sendUiEvent(new q4(28, "네트워크 연결 확인", "데이터 네트워크 차단 상태입니다.\n차단 해제 또는 Wi-Fi설정 후 사용해주세요.", null, null));
            return ie.H.a;
        }
        if(!(((I)object0) instanceof G)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        m00.sendUiEvent(new jd.H(((G)(((I)object0))).a, ((G)(((I)object0))).b));
        return ie.H.a;
    }
}

