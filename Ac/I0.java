package Ac;

import Bd.w;
import C8.e;
import androidx.fragment.app.I;
import androidx.viewpager.widget.j;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.track.Event;
import com.melon.ui.J0;
import com.melon.ui.comment.CommentAttachPagerViewModel;
import com.melon.ui.i3;
import com.melon.ui.j3;
import com.melon.ui.playermusic.BgType;
import com.melon.ui.playermusic.l;
import hd.i;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import ld.b;
import ld.c;
import ld.m;
import p8.s;
import q8.d;
import q8.h;
import rd.P;
import rd.Y0;
import rd.Z0;
import td.K0;
import td.b0;
import td.z;

public final class i0 implements j {
    public final int a;
    public final J0 b;

    public i0(J0 j00, int v) {
        this.a = v;
        this.b = j00;
        super();
    }

    private final void a(int v) {
    }

    private final void b(int v) {
    }

    private final void c(int v) {
    }

    private final void d(int v) {
    }

    private final void e(float f, int v, int v1) {
    }

    private final void f(float f, int v, int v1) {
    }

    private final void g(float f, int v, int v1) {
    }

    private final void h(float f, int v, int v1) {
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrollStateChanged(int v) {
        if(this.a != 0 && this.a != 1 && this.a != 2 && this.a != 3) {
            LogU.debug$default(((b0)this.b).h, "onPageScrollStateChanged() state=" + v, null, false, 6, null);
            ((b0)this.b).r.setValue(v);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrolled(int v, float f, int v1) {
        boolean z2;
        boolean z1;
        if(this.a != 0 && this.a != 1 && this.a != 2 && this.a != 3) {
            z z0 = ((b0)this.b).n;
            BgType bgType0 = null;
            BgType bgType1 = z0 == null ? null : z0.e[z0.c];
            MutableStateFlow mutableStateFlow0 = ((b0)this.b).w;
            if(v < ((b0)this.b).o) {
                if(z0 != null) {
                    bgType0 = z0.e[0];
                }
            }
            else if(z0 != null) {
                bgType0 = z0.e[z0.d];
            }
            z1 = l.g(bgType1);
            z2 = l.g(bgType0);
            mutableStateFlow0.setValue(Boolean.valueOf(((boolean)(z1 ^ z2))));
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageSelected(int v) {
        I i1;
        switch(this.a) {
            case 0: {
                j0 j00 = (j0)this.b;
                ((CommentAttachPagerViewModel)j00.getViewModel()).a = v;
                if(j00.getCurrentFragment() instanceof S) {
                    I i0 = j00.getCurrentFragment();
                    q.e(i0, "null cannot be cast to non-null type com.melon.ui.comment.CommentAttachFragment");
                    S s0 = (S)i0;
                }
                if(j00.j.length() != 0) {
                    j0.q(j00);
                }
                return;
            }
            case 1: {
                ((i3)((j3)this.b).getViewModel()).a = v;
                return;
            }
            case 2: {
                b b0 = (b)this.b;
                s s1 = null;
                LogU.debug$default(b0.h, "onPageSelected() position: " + v, null, false, 6, null);
                ((c)b0.getViewModel()).a = v;
                int v2 = b0.m().getPreviousIndex();
                if(b0.f == null) {
                    LogU.warn$default(b0.b, "getCurrentFragment() InvalidState", null, false, 6, null);
                    i1 = null;
                }
                else {
                    try {
                        i1 = b0.getChildFragmentManager().E(String.valueOf(v2));
                    }
                    catch(Exception unused_ex) {
                        n8.q q0 = b0.f;
                        if(q0 != null) {
                            i1 = q0.getItem(v2);
                            goto label_42;
                        }
                        q.m("pagerAdapter");
                        throw null;
                    }
                }
            label_42:
                if(i1 instanceof m) {
                    s1 = ((c)b0.getViewModel()).h;
                }
                else if(i1 instanceof MelonBaseFragment) {
                    s1 = ((MelonBaseFragment)i1).getTiaraProperty();
                }
                if(s1 != null) {
                    d d0 = new d();  // 初始化器: LQb/h;-><init>()V
                    new i(b0, 16).invoke(((h)d0.b));
                    d0.c(new w(s1, 8));
                    d0.b(new e(b0, v, 14));
                    d0.d(new w(s1, 9));
                    ((Event)d0.p()).track();
                }
                return;
            }
            case 3: {
                P p0 = (P)this.b;
                LogU.debug$default(p0.i, "onPageSelected() position=" + v + ", currentPagePosition=" + p0.n, null, false, 6, null);
                int v3 = p0.n;
                if(v3 < 0) {
                    p0.n = v;
                    return;
                }
                if(v3 < v) {
                    p0.n = v;
                    p0.sendUserEvent(Y0.a);
                    return;
                }
                if(v3 > v) {
                    p0.n = v;
                    p0.sendUserEvent(Z0.a);
                }
                return;
            }
            default: {
                b0 b00 = (b0)this.b;
                LogU.debug$default(b00.h, "onPageSelected() position=" + v + ", currentPagePosition=" + b00.o, null, false, 6, null);
                int v1 = b00.o;
                if(v1 < 0) {
                    b00.o = v;
                    return;
                }
                if(v1 < v) {
                    b00.o = v;
                    b00.sendUserEvent(td.J0.a);
                    return;
                }
                if(v1 > v) {
                    b00.o = v;
                    b00.sendUserEvent(K0.a);
                }
            }
        }
    }
}

