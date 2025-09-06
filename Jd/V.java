package jd;

import H0.e;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import b.t;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.Meta.Builder;
import ie.H;
import kotlin.jvm.internal.q;
import r8.f;
import we.a;

public final class v implements a {
    public final int a;
    public final A b;

    public v(A a0, int v) {
        this.a = v;
        this.b = a0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        String s = null;
        H h0 = H.a;
        A a0 = this.b;
        switch(this.a) {
            case 0: {
                I i1 = a0.getChildFragmentManager().E("MusicWaveImageViewerDialogFragment");
                if(i1 != null) {
                    ((a2)i1).dismiss();
                }
                return h0;
            }
            case 1: {
                a0.sendUserEvent(O.a);
                return h0;
            }
            case 2: {
                e.w(a0);
                return h0;
            }
            case 3: {
                String s1 = a0.getContext() == null ? null : "페이지이동";
                String s2 = a0.getContext() == null ? null : "팝업";
                String s3 = a0.getContext() == null ? null : "로그인";
                Builder meta$Builder0 = new Builder().id(((M0)a0.getViewModel()).g().e);
                if(a0.getContext() != null) {
                    s = "뮤직웨이브";
                }
                a0.sendUserEvent(new f0(null, null, s1, s2, s3, meta$Builder0.type(s).name(((M0)a0.getViewModel()).g().b).build(), 3));
                Navigator.openLoginView(f.f);
                return h0;
            }
            case 4: {
                FragmentActivity fragmentActivity0 = a0.getActivity();
                if(fragmentActivity0 != null) {
                    t t0 = fragmentActivity0.getOnBackPressedDispatcher();
                    if(t0 != null) {
                        t0.c();
                    }
                }
                return h0;
            }
            default: {
                I i0 = a0.requireParentFragment();
                q.f(i0, "requireParentFragment(...)");
                return i0;
            }
        }
    }
}

