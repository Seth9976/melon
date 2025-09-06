package td;

import Cc.U3;
import E9.w;
import F.f;
import G4.a;
import G4.c;
import Ic.z;
import Nb.i;
import android.content.Context;
import androidx.compose.runtime.b0;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.userstore.VolatileDatabase_Impl;
import com.iloen.melon.userstore.entity.TagEntity;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.K4;
import gd.Z7;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.q;
import m0.b;
import m9.l;
import q8.d;
import q8.h;
import sd.j;
import we.k;
import zc.U;

public final class m0 implements k {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public m0(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    public m0(ArrayList arrayList0, String s, String s1) {
        this.a = 2;
        super();
        this.c = s;
        this.d = s1;
        this.b = arrayList0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        Object object1 = this.d;
        Object object2 = this.c;
        Object object3 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                Playable playable0 = (Playable)((n0)object3).b.invoke();
                ((n0)object3).b(((d)object0), ActionKind.ClickContent, playable0);
                ((h)((d)object0).b).a = ((n0)object3).a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                ((d)object0).b(new k0(((n0)object3), 8));
                ((d)object0).e(new i(((String)object2), ((String)object1), 7));
                return h0;
            }
            case 1: {
                q.g(((androidx.compose.runtime.H)object0), "$this$DisposableEffect");
                return new f(((vd.h)object3), ((k)object2), ((b0)object1), 3);
            }
            case 2: {
                try(c c0 = ((a)object0).l0(((String)object2))) {
                    c0.e(1, ((String)object1));
                    Iterator iterator0 = ((ArrayList)object3).iterator();
                    for(int v = 2; true; ++v) {
                        if(!iterator0.hasNext()) {
                            break;
                        }
                        Object object4 = iterator0.next();
                        c0.e(v, ((String)object4));
                    }
                    c0.j0();
                    return Q1.c.F(((a)object0));
                }
            }
            case 3: {
                q.g(((K4)object0), "it");
                return z.a(((z)object3), ((ArrayList)object2), ((U3)object1), 13);
            }
            case 4: {
                a a0 = (a)object0;
                ((x9.c)object3).getClass();
                q.g(((String)object2), "tagName");
                q.g(((String)object1), "tagSeq");
                TagEntity tagEntity0 = new TagEntity();
                tagEntity0.setTagName(((String)object2));
                tagEntity0.setTagSeq(((String)object1));
                tagEntity0.setTimestamp(System.currentTimeMillis());
                VolatileDatabase_Impl volatileDatabase_Impl0 = (VolatileDatabase_Impl)((x9.c)object3).b;
                w.N(volatileDatabase_Impl0, false, true, new l(27, ((x9.c)object3), tagEntity0));
                if(((int)(((Integer)w.N(volatileDatabase_Impl0, true, false, new j(19))))) > 5) {
                    ((Integer)w.N(volatileDatabase_Impl0, false, true, new j(18))).getClass();
                }
                return h0;
            }
            case 5: {
                q.g(((O.w)object0), "$this$MelonLazyColumn");
                O.w.c(((O.w)object0), new b(0x20DD55F9, new D8.b(2, ((com.melon.ui.popup.context.more.a)object2), ((k)object1)), true));
                ((O.j)(((O.w)object0))).u(((ArrayList)object3).size(), null, new xd.d(0, ((ArrayList)object3)), new b(0xBEF78951, new Z7(((ArrayList)object3), ((k)object1), ((ArrayList)object3), 1), true));
                return h0;
            }
            default: {
                q.g(((A0.f)object0), "$this$Canvas");
                int v2 = ((ArrayList)object3).size();
                float f = -90.0f;
                for(int v1 = 0; v1 < v2; ++v1) {
                    A0.f.Z(((A0.f)object0), ((U)object2).a(((Context)object1), v1), f, ((Number)((ArrayList)object3).get(v1)).floatValue(), true, 0L, 0L, 0.0f, null, 0x3F0);
                    f += ((Number)((ArrayList)object3).get(v1)).floatValue();
                }
                return h0;
            }
        }
    }
}

