package hd;

import androidx.fragment.app.FragmentActivity;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.K4;
import com.melon.ui.n0;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import we.a;

public final class p1 implements a {
    public final int a;
    public final s1 b;
    public final K4 c;

    public p1(s1 s10, K4 k40, int v) {
        this.a = v;
        this.b = s10;
        this.c = k40;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            s1 s10 = this.b;
            FragmentActivity fragmentActivity0 = s10.getActivity();
            if(fragmentActivity0 != null) {
                String s = s10.f.length() == 0 ? ((String)((I1)this.c).a.get(0)) : s10.f;
                c.a(fragmentActivity0, ((I1)this.c).a, s, "MusicDnaMonthlyLogFragment", true, new o1(s10, 1));
                n0 n00 = s10.getViewModel();
                q.f("선택", "getString(...)");
                q.f("지난 월간로그 보러가기", "getString(...)");
                q.f("선택팝업", "getString(...)");
                q.f("월간로그이동", "getString(...)");
                O1.f(((O1)n00), "선택", ActionKind.ClickContent, "지난 월간로그 보러가기", "선택팝업", null, "월간로그이동", null, null, null, null, null, null, 0xFD0);
            }
            return H.a;
        }
        s1 s11 = this.b;
        FragmentActivity fragmentActivity1 = s11.getActivity();
        if(fragmentActivity1 != null) {
            String s1 = ((O1)s11.getViewModel()).f;
            o1 o10 = new o1(s11, 0);
            c.a(fragmentActivity1, ((List)((H1)this.c).i), s1, "MusicDnaMonthlyLogFragment", false, o10);
            n0 n01 = s11.getViewModel();
            q.f("선택", "getString(...)");
            q.f("감상그래프", "getString(...)");
            q.f("선택팝업", "getString(...)");
            q.f("전월선택", "getString(...)");
            O1.f(((O1)n01), "선택", ActionKind.ClickContent, "감상그래프", "선택팝업", null, "전월선택", null, null, null, null, null, null, 0xFD0);
        }
        return H.a;
    }
}

