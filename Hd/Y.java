package hd;

import A8.H;
import A8.L;
import K.m;
import Q0.k0;
import X0.i;
import android.content.Context;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.CARDINFO;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.popup.context.more.ExtraProperties.AddPositionInfo;
import com.melon.ui.popup.context.more.ExtraProperties;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import ef.c;
import java.io.Serializable;
import kotlin.jvm.internal.q;
import w0.h;
import we.a;
import we.k;
import we.o;
import zd.Q;

public final class y implements o {
    public final int a;
    public final Object b;
    public final k c;
    public final Object d;
    public final Object e;

    public y(Context context0, Serializable serializable0, Serializable serializable1, k k0, int v) {
        this.a = v;
        this.b = context0;
        this.d = serializable0;
        this.e = serializable1;
        this.c = k0;
        super();
    }

    public y(MelonBottomSheetItem melonBottomSheetItem0, k k0, Q q0, AddPositionInfo extraProperties$AddPositionInfo0) {
        this.a = 3;
        super();
        this.b = melonBottomSheetItem0;
        this.c = k0;
        this.d = q0;
        this.e = extraProperties$AddPositionInfo0;
    }

    public y(k k0, a a0, L l0, H h0) {
        this.a = 2;
        super();
        this.c = k0;
        this.b = a0;
        this.d = l0;
        this.e = h0;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        switch(this.a) {
            case 0: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object4 = ((p)(((l)object1))).k(k0.i);
                m m1 = ((p)(((l)object1))).N();
                if(m1 == androidx.compose.runtime.k.a) {
                    m1 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, true, null, new i(0), new c(((h)object4), ((Context)this.b), ((kotlin.jvm.internal.H)this.d), ((CARDINFO)this.e), this.c, 1));
                ((p)(((l)object1))).p(false);
                return q1;
            }
            case 1: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object5 = ((p)(((l)object1))).k(k0.i);
                m m2 = ((p)(((l)object1))).N();
                if(m2 == androidx.compose.runtime.k.a) {
                    m2 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q2 = androidx.compose.foundation.q.l(((r0.q)object0), m2, null, true, null, new i(0), new c(((h)object5), ((Context)this.b), ((String)this.d), ((SongInfoBase)this.e), this.c, 2));
                ((p)(((l)object1))).p(false);
                return q2;
            }
            case 2: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object6 = ((p)(((l)object1))).k(k0.i);
                m m3 = ((p)(((l)object1))).N();
                if(m3 == androidx.compose.runtime.k.a) {
                    m3 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q3 = androidx.compose.foundation.q.l(((r0.q)object0), m3, null, true, null, new i(0), new c(((h)object6), this.c, ((a)this.b), ((L)this.d), ((H)this.e), 3));
                ((p)(((l)object1))).p(false);
                return q3;
            }
            default: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object3 = ((p)(((l)object1))).k(k0.i);
                m m0 = ((p)(((l)object1))).N();
                if(m0 == androidx.compose.runtime.k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new c(((h)object3), ((MelonBottomSheetItem)this.b), this.c, ((Q)this.d), ((ExtraProperties)this.e), 4));
                ((p)(((l)object1))).p(false);
                return q0;
            }
        }
    }
}

