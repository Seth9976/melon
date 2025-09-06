package ed;

import H0.e;
import android.content.Context;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.fragment.app.I;
import androidx.lifecycle.f0;
import com.iloen.melon.net.v6x.response.SearchTagListRes.Response;
import com.melon.ui.W0;
import e.k;
import gd.A2;
import gd.C6;
import gd.E3;
import gd.F;
import gd.M;
import gd.Q7;
import gd.R5;
import gd.V1;
import gd.X1;
import gd.Z0;
import gd.c1;
import gd.e5;
import gd.h4;
import gd.l4;
import gd.n6;
import gd.p2;
import gd.q6;
import gd.s5;
import gd.u0;
import gd.w0;
import gd.w5;
import hd.Y1;
import hd.s1;
import ie.H;
import j5.l;
import java.util.ArrayList;
import java.util.List;
import jd.E1;
import jd.F1;
import jd.q2;
import jd.v1;
import je.n;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import p0.p;
import p8.s;
import t5.j;
import we.a;

public final class f implements a {
    public final int a;
    public final Object b;

    public f(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                ((j0)object0).c.invoke();
                return h0;
            }
            case 1: {
                ((g0)object0).b.a.invoke();
                return h0;
            }
            case 2: {
                ((c)object0).b.invoke(((c)object0).a);
                return h0;
            }
            case 3: {
                p p0 = ((F0)object0).k;
                M0 m00 = (M0)je.p.k0(p0);
                int v = 1;
                if(p0.size() > 1) {
                    p0.clear();
                    p0.add(m00);
                }
                if(m00 instanceof L0) {
                    b0 b00 = ((L0)m00).b;
                    int v1 = ((Number)b00.getValue()).intValue();
                    Response searchTagListRes$Response0 = ((L0)m00).a;
                    if(searchTagListRes$Response0 != null) {
                        ArrayList arrayList0 = searchTagListRes$Response0.tagList;
                        if(arrayList0 != null) {
                            v = arrayList0.size();
                        }
                    }
                    b00.setValue(((int)((v1 + 1) % v)));
                }
                return h0;
            }
            case 4: {
                e.w(((F)object0));
                return h0;
            }
            case 5: {
                if(((gd.b0)((M)object0).getViewModel()).isEnableLoadMore()) {
                    ((M)object0).sendUserEvent(new W0(null));
                }
                return h0;
            }
            case 6: {
                if(((u0)((gd.g0)object0).getViewModel()).isEnableLoadMore()) {
                    ((u0)((gd.g0)object0).getViewModel()).updateUserEvent(new W0(null));
                }
                return h0;
            }
            case 7: {
                e.w(((w0)object0));
                return h0;
            }
            case 8: {
                e.w(((c1)object0));
                return h0;
            }
            case 9: {
                Z0 z00 = new Z0(1, ((V1)object0), V1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 16);
                s s0 = ((V1)object0).getTiaraProperty();
                return new Jd.a(((V1)object0).g, z00, s0);
            }
            case 10: {
                e.w(((X1)object0));
                return h0;
            }
            case 11: {
                e.w(((p2)object0));
                return h0;
            }
            case 12: {
                e.w(((A2)object0));
                return h0;
            }
            case 13: {
                Context context0 = ((E3)object0).h;
                if(context0 != null) {
                    String[] arr_s = context0.getResources().getStringArray(0x7F030014);  // array:melondj_melgun_playlist
                    q.f(arr_s, "getStringArray(...)");
                    return n.N(arr_s);
                }
                q.m("context");
                throw null;
            }
            case 14: {
                e.w(((h4)object0));
                return h0;
            }
            case 15: {
                I i0 = ((l4)object0).requireParentFragment();
                q.f(i0, "requireParentFragment(...)");
                return i0;
            }
            case 16: {
                e.w(((e5)object0));
                return h0;
            }
            case 17: {
                e.w(((s5)object0));
                return h0;
            }
            case 18: {
                e.w(((w5)object0));
                return h0;
            }
            case 19: {
                if(((n6)((R5)object0).getViewModel()).isEnableLoadMore()) {
                    ((R5)object0).sendUserEvent(new W0(null));
                }
                return h0;
            }
            case 20: {
                if(((n6)object0).i != null) {
                    if(((n6)object0).i != null) {
                        if(((n6)object0).i != null) {
                            return k.A(new String[]{"인기", "최신", "업데이트"});
                        }
                        q.m("context");
                        throw null;
                    }
                    q.m("context");
                    throw null;
                }
                q.m("context");
                throw null;
            }
            case 21: {
                e.w(((q6)object0));
                return h0;
            }
            case 22: {
                if(((C6)object0).h != null) {
                    if(((C6)object0).h != null) {
                        if(((C6)object0).h != null) {
                            return k.A(new String[]{"인기", "최신", "업데이트"});
                        }
                        q.m("context");
                        throw null;
                    }
                    q.m("context");
                    throw null;
                }
                q.m("context");
                throw null;
            }
            case 23: {
                e.w(((Q7)object0));
                return h0;
            }
            case 24: {
                e.w(((s1)object0));
                return h0;
            }
            case 25: {
                e.w(((Y1)object0));
                return h0;
            }
            case 26: {
                return (j)((O0)((l)object0).n).getValue();
            }
            case 27: {
                ((v1)object0).dismiss();
                return h0;
            }
            case 28: {
                BuildersKt__Builders_commonKt.launch$default(f0.f(((F1)object0)), Dispatchers.getIO(), null, new E1(((F1)object0), null), 2, null);
                return h0;
            }
            default: {
                return ((List)((q2)object0).b).size();
            }
        }
    }
}

