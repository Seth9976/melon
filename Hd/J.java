package hd;

import A8.L;
import A8.m;
import Hc.N;
import Jc.K;
import Kd.g;
import android.content.Context;
import android.net.Uri.Builder;
import android.net.Uri;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.CHNLINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.SPAMINFO;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.melon.ui.s4;
import ie.H;
import java.io.Serializable;
import java.util.Collection;
import je.p;
import k8.t;
import kotlin.jvm.internal.q;
import va.e0;
import va.o;
import we.a;
import we.k;

public final class j implements a {
    public final int a;
    public final Object b;
    public final int c;
    public final Serializable d;
    public final Object e;
    public final Object f;

    public j(N n0, SPAMINFO loadPgnRes$result$SPAMINFO0, Ua.a a0, int v, CHNLINFO loadPgnRes$result$CHNLINFO0) {
        this.a = 2;
        super();
        this.b = n0;
        this.d = loadPgnRes$result$SPAMINFO0;
        this.e = a0;
        this.c = v;
        this.f = loadPgnRes$result$CHNLINFO0;
    }

    public j(Context context0, int v, String s, g g0, k k0, int v1) {
        this.a = v1;
        this.b = context0;
        this.c = v;
        this.d = s;
        this.e = g0;
        this.f = k0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                q.f("월간Log", "getString(...)");
                q.f("앨범", "getString(...)");
                L l0 = new L("월간Log", null, String.valueOf(this.c + 1), ((String)this.d), ((g)this.e).c, "앨범", ((g)this.e).d, null, 0x20B);
                O o0 = new O(new m(30, ((g)this.e).c, null, null, null), "ALBUM_THUMB", l0);
                ((k)this.f).invoke(o0);
                return H.a;
            }
            case 1: {
                q.f("월간Log", "getString(...)");
                q.f("곡", "getString(...)");
                L l1 = new L("월간Log", null, String.valueOf(this.c + 1), ((String)this.d), ((g)this.e).a, "곡", ((g)this.e).b, null, 0x20B);
                Q q0 = new Q(((g)this.e), l1);
                ((k)this.f).invoke(q0);
                return H.a;
            }
            default: {
                N n0 = (N)this.b;
                SPAMINFO loadPgnRes$result$SPAMINFO0 = (SPAMINFO)this.d;
                Ua.a a0 = (Ua.a)this.e;
                CHNLINFO loadPgnRes$result$CHNLINFO0 = (CHNLINFO)this.f;
                if(!((e0)o.a()).m()) {
                    n0.d.invoke(s4.a);
                    return H.a;
                }
                if(loadPgnRes$result$SPAMINFO0 != null && loadPgnRes$result$SPAMINFO0.breakmemberflag) {
                    n0.h(a0.a);
                    return H.a;
                }
                Object object0 = p.Q0(((Collection)n0.h.getValue())).get(this.c + 1);
                q.e(object0, "null cannot be cast to non-null type com.melon.ui.detail.holder.DetailHolderUiState.CommentListItemUiState");
                String s = null;
                String s1 = loadPgnRes$result$CHNLINFO0 == null ? null : loadPgnRes$result$CHNLINFO0.reprtWindowUrl;
                if(s1 != null && s1.length() != 0) {
                    if(loadPgnRes$result$CHNLINFO0 != null) {
                        s = loadPgnRes$result$CHNLINFO0.reprtWindowUrl;
                    }
                    Uri.Builder uri$Builder0 = Uri.parse(s).buildUpon().appendQueryParameter("templateType", "m.list").appendQueryParameter("cmtPocType", "m.web");
                    MelonAppBase.Companion.getClass();
                    Uri.Builder uri$Builder1 = uri$Builder0.appendQueryParameter("pocId", t.a().getMelonCpId()).appendQueryParameter("chnlSeq", String.valueOf(((K)object0).a));
                    String s2 = ((K)object0).b;
                    if(s2 == null) {
                        s2 = "";
                    }
                    Navigator.openUrl(uri$Builder1.appendQueryParameter("contsRefValue", s2).appendQueryParameter("cmtSeq", String.valueOf(((K)object0).G)).build().toString(), OpenType.FullScreenWithBar);
                }
                return H.a;
            }
        }
    }
}

