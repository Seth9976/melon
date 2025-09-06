package ef;

import A8.L;
import A8.m;
import Hf.M;
import Me.S;
import Me.h;
import Se.p;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.media3.session.legacy.V;
import com.iloen.melon.constants.AddPosition;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.CARDINFO;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.popup.context.more.ExtraProperties.AddPositionInfo;
import com.melon.ui.popup.context.more.ExtraProperties;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import hd.N;
import hd.O;
import hd.Q;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import we.a;
import we.k;
import zd.y;

public final class c implements a {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;

    public c(Object object0, Object object1, Object object2, Object object3, Object object4, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        this.e = object3;
        this.f = object4;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                S s0 = (S)this.c;
                ef.a a0 = (ef.a)this.d;
                p p0 = (p)this.f;
                ea.c c0 = (ea.c)((V)this.b).c;
                h h0 = ((M)this.e).e();
                return h0 == null ? c0.h(s0, ef.a.a(ef.a.a(a0, null, false, null, null, 0x1F), null, p0.d(), null, null, 59)) : c0.h(s0, ef.a.a(ef.a.a(a0, null, false, null, h0.g(), 0x1F), null, p0.d(), null, null, 59));
            }
            case 1: {
                w0.h.a(((w0.h)this.b));
                q.f("월간Log", "getString(...)");
                L l0 = new L("월간Log", null, null, ((String)((H)this.d).a), null, null, null, null, 987);
                String s1 = ((CARDINFO)this.e).scheme;
                q.f(s1, "scheme");
                O o0 = new O(new m(23, null, null, null, s1), "SCHEME_BTN", l0);
                ((k)this.f).invoke(o0);
                return ie.H.a;
            }
            case 2: {
                w0.h.a(((w0.h)this.b));
                Context context0 = (Context)this.c;
                q.f("최근Log", "getString(...)");
                q.f("최근꽂힌곡", "getString(...)");
                SongInfoBase songInfoBase0 = (SongInfoBase)this.e;
                String s2 = songInfoBase0.songId == null ? "" : songInfoBase0.songId;
                q.f("곡", "getString(...)");
                L l1 = new L("최근Log", null, ((String)this.d), "최근꽂힌곡", s2, "곡", (songInfoBase0.songName == null ? "" : songInfoBase0.songName), null, 0x20B);
                Q q1 = new Q(Kd.h.c(songInfoBase0), l1);
                ((k)this.f).invoke(q1);
                return ie.H.a;
            }
            case 3: {
                w0.h.a(((w0.h)this.b));
                N n0 = new N(((Bitmap)((a)this.d).invoke()), true, ((L)this.e));
                ((k)this.c).invoke(n0);
                hd.S s3 = new hd.S(((A8.H)this.f), ((L)this.e));
                ((k)this.c).invoke(s3);
                return ie.H.a;
            }
            default: {
                w0.h.a(((w0.h)this.b));
                MelonBottomSheetItem melonBottomSheetItem0 = (MelonBottomSheetItem)this.c;
                if(melonBottomSheetItem0.e) {
                    k k0 = (k)this.d;
                    zd.Q q0 = (zd.Q)this.e;
                    zd.M m0 = melonBottomSheetItem0.a;
                    AddPosition addPosition0 = ((AddPositionInfo)(((ExtraProperties)this.f))).a;
                    if(addPosition0 == null) {
                        addPosition0 = AddPosition.b;
                    }
                    k0.invoke(new y(q0, m0, addPosition0));
                }
                return ie.H.a;
            }
        }
    }
}

