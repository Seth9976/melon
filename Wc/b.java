package wc;

import Cc.V3;
import Cc.W3;
import Ic.I;
import Ic.V;
import Ic.z;
import Jc.B;
import Jc.I0;
import Jc.M;
import Jc.X;
import Jc.Z;
import Jc.e0;
import Jd.c;
import Jd.d;
import Jd.e;
import Jd.f;
import androidx.lifecycle.f0;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.kakao.tiara.data.ActionKind;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import we.k;
import ye.a;

public final class b implements k {
    public final int a;
    public final w b;

    public b(w w0, int v) {
        this.a = v;
        this.b = w0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        e e0;
        H h0 = H.a;
        w w0 = this.b;
        switch(this.a) {
            case 0: {
                w0.y(((Boolean)object0).booleanValue());
                return h0;
            }
            case 1: {
                q.g(((W3)object0), "toolBarUserEvent");
                if(!(((W3)object0) instanceof V3)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                switch(((V3)(((W3)object0))).b) {
                    case 0: {
                        e0 = e.c;
                        break;
                    }
                    case 1: {
                        e0 = c.c;
                        break;
                    }
                    case 2: {
                        e0 = Jd.b.c;
                        break;
                    }
                    case 14: {
                        e0 = f.c;
                        break;
                    }
                    case 0x1F: {
                        e0 = d.c;
                        break;
                    }
                    default: {
                        e0 = null;
                    }
                }
                if(e0 != null) {
                    z z0 = w0.t();
                    if(z0 != null) {
                        ArrayList arrayList0 = new ArrayList();
                        for(Object object1: z0.b) {
                            if(((e0)object1) instanceof X && ((X)(((e0)object1))).M) {
                                arrayList0.add(object1);
                            }
                        }
                        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                        for(Object object2: arrayList0) {
                            q.e(((e0)object2), "null cannot be cast to non-null type com.melon.ui.detail.holder.DetailHolderUiState.SongUiState");
                            String s = w0.getMenuId();
                            ((X)(((e0)object2))).a.setMenuid(s);
                            arrayList1.add(((X)(((e0)object2))).a);
                        }
                        BuildersKt__Builders_commonKt.launch$default(f0.h(w0), null, null, new n(e0, w0, arrayList1, null), 3, null);
                    }
                }
                return h0;
            }
            case 2: {
                q.g(((Z)object0), "uiState");
                w0.onUserEvent(new V(((Z)object0)));
                return h0;
            }
            case 3: {
                q.g(((M)object0), "uiState");
                w0.onUserEvent(new I(((M)object0)));
                return h0;
            }
            case 4: {
                q.g(((p8.f)object0), "$this$trackTiaraEventLog");
                ((p8.f)object0).a = w0.b.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                ((p8.f)object0).d = ActionKind.PlayMusic;
                ((p8.f)object0).y = w0.b.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                ((p8.f)object0).F = w0.b.a(0x7F130D53);  // string:tiara_click_copy_mixup "믹스업"
                ((p8.f)object0).e = w0.p();
                ((p8.f)object0).f = Y.i(ContsTypeCode.ALBUM_MIXUP, "code(...)");
                ((p8.f)object0).g = w0.q();
                ((p8.f)object0).W = "1000003099";
                return (p8.f)object0;
            }
            case 5: {
                q.g(((I0)object0), "uiState");
                w0.onUserEvent(new Ic.Z(a.Z(((I0)object0).g)));
                return h0;
            }
            default: {
                q.g(((B)object0), "uiState");
                w0.onUserEvent(new Ic.B(((B)object0)));
                return h0;
            }
        }
    }
}

