package Mc;

import Ac.p2;
import Bd.e;
import Cc.U3;
import F.s;
import Ic.e0;
import Id.d;
import Kc.c;
import Nb.h0;
import Nc.A1;
import Nc.B1;
import Nc.D1;
import Nc.E0;
import Nc.E1;
import Nc.F1;
import Nc.G0;
import Nc.L0;
import Nc.Y0;
import Nc.m0;
import Nc.n0;
import Nc.o0;
import Nc.t;
import Nc.v1;
import Nc.v;
import Nc.y1;
import Nc.z1;
import O.j;
import O.w;
import Oc.A;
import Oc.D;
import Oc.E;
import Oc.F;
import Oc.G;
import Oc.K;
import Oc.N;
import Oc.U;
import Oc.o;
import Oc.p;
import Oc.r;
import Oc.u;
import Oc.x;
import Qc.f;
import Qc.i;
import Rc.O;
import Uc.L;
import Uc.M;
import Uc.Q;
import a.a;
import android.view.KeyEvent;
import android.widget.ImageView;
import androidx.compose.runtime.a0;
import androidx.media3.session.f0;
import androidx.media3.session.w0;
import com.bumptech.glide.Glide;
import com.gaudiolab.sol.android.SolMusicOne.LoudnessType;
import com.iloen.melon.fragments.genre.Genre.More_Fragment_Type;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType2Res.RESPONSE.SONGLIST;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType2Res.RESPONSE;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType3Res.RESPONSE.ALBUMLIST;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType5Res.RESPONSE.GNRDETAILCONTENTS;
import com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.LICENSE1TYPE.ALBUM;
import com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.LICENSE1TYPE;
import com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.MASTERPIECETYPE;
import com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.MEGAZINETYPE.MEGAZINELIST;
import com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.MVTYPE;
import com.iloen.melon.net.v6x.response.ForuTabRes.Response;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.B4;
import com.melon.ui.E4;
import com.melon.ui.F4;
import com.melon.ui.J1;
import com.melon.ui.K4;
import com.melon.ui.X1;
import com.melon.ui.Z0;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.c1;
import com.melon.ui.d1;
import com.melon.ui.e1;
import com.melon.ui.g1;
import com.melon.ui.j2;
import com.melon.ui.k1;
import com.melon.ui.k2;
import com.melon.ui.w1;
import com.melon.ui.x1;
import d3.g;
import h7.u0;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import m0.b;
import we.k;
import y8.l;

public final class y implements k {
    public final int a;
    public final Object b;
    public final Object c;

    public y(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public y(KeyEvent keyEvent0, h0 h00, w0 w00, f0 f00) {
        this.a = 2;
        super();
        this.b = keyEvent0;
        this.c = h00;
    }

    public y(ArrayList arrayList0, i i0, ArrayList arrayList1) {
        this.a = 24;
        super();
        this.b = arrayList0;
        this.c = arrayList1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s6;
        E0 e02;
        String s = "";
        int v = 0;
        boolean z = true;
        Object object1 = null;
        H h0 = H.a;
        Object object2 = this.c;
        Object object3 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                w.a(((w)object0), new b(1453069206, new e(((B)object2), 8), true));
                s s1 = new s(5, ((A)object3).a);
                b b0 = new b(0xBEF78951, new d(1, ((A)object3).a), true);
                ((j)(((w)object0))).u(((A)object3).a.size(), null, s1, b0);
                return h0;
            }
            case 1: {
                q.g(((k2)object0), "popupEvent");
                if(((k2)object0) instanceof X1) {
                    ((I)object3).handleMoreListPopupOnEvent(((I)object3), new c(1, ((I)object3), I.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 27), ((zd.d)object2), ((k2)object0));
                    return h0;
                }
                if(((k2)object0) instanceof w1) {
                    ((I)object3).handleMoreListPopupOnEvent(((I)object3), new c(1, ((I)object3), I.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 28), ((zd.d)object2), ((k2)object0));
                    return h0;
                }
                if(((k2)object0) instanceof J1) {
                    ((I)object3).handleMoreListPopupOnEvent(((I)object3), new c(1, ((I)object3), I.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 29), ((zd.d)object2), ((k2)object0));
                    return h0;
                }
                if(((k2)object0) instanceof x1) {
                    ((I)object3).handleMoreListPopupOnEvent(((I)object3), new Mc.H(1, ((I)object3), I.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 0), ((zd.d)object2), ((k2)object0));
                    return h0;
                }
                if(((k2)object0) instanceof j2 && q.b(((j2)(((k2)object0))).c, "N10002")) {
                    ((I)object3).sendUserEvent(new e0(((j2)(((k2)object0))).a, ((j2)(((k2)object0))).b));
                }
                return h0;
            }
            case 2: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("onMediaButtonEvent() keyEvent: " + ((KeyEvent)object3));
                ((h0)object2).getClass();
                return h0;
            }
            case 3: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("updateCacheOptions()");
                Cb.i.a(((StringBuilder)object0), "previous: " + ((Ob.c)object3));
                Cb.i.a(((StringBuilder)object0), "options: " + ((Ob.c)object2));
                return h0;
            }
            case 4: {
                q.g(((o0)object0), "userEvent");
                if(((o0)object0) instanceof m0) {
                    ALBUM genreDetailRes$RESPONSE$GNRDETAILCONTENTS$LICENSE1TYPE$ALBUM0 = ((LICENSE1TYPE)object2).album;
                    if(genreDetailRes$RESPONSE$GNRDETAILCONTENTS$LICENSE1TYPE$ALBUM0 != null) {
                        String s2 = genreDetailRes$RESPONSE$GNRDETAILCONTENTS$LICENSE1TYPE$ALBUM0.albumId;
                        if(s2 != null) {
                            s = s2;
                        }
                    }
                    ((o)object3).c(s, ((o)object3).getMenuId(), ((LICENSE1TYPE)object2).statsElements);
                    return h0;
                }
                if(!(((o0)object0) instanceof n0)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                ALBUM genreDetailRes$RESPONSE$GNRDETAILCONTENTS$LICENSE1TYPE$ALBUM1 = ((LICENSE1TYPE)object2).album;
                if(genreDetailRes$RESPONSE$GNRDETAILCONTENTS$LICENSE1TYPE$ALBUM1 != null) {
                    object1 = genreDetailRes$RESPONSE$GNRDETAILCONTENTS$LICENSE1TYPE$ALBUM1.albumId;
                }
                Navigator.openAlbumInfo(((String)object1));
                return h0;
            }
            case 5: {
                q.g(((Y0)object0), "it");
                g.X(((o)object3).getMenuId(), "D21", "T01", "", "V2", "", ((MVTYPE)object2).mv.contsTypeCode, ((MVTYPE)object2).mv.mvId, ((o)object3).f());
                Navigator.openMvInfo$default(((MVTYPE)object2).mv.mvId, ((o)object3).getMenuId(), null, false, 12, null);
                return h0;
            }
            case 6: {
                q.g(((G0)object0), "it");
                g.X(((o)object3).getMenuId(), "O59", "T05", "", "V2", "", "", "", ((o)object3).f());
                String s3 = ((o)object3).f();
                Navigator.INSTANCE.openGenreMore(More_Fragment_Type.GUI_MORE_MASTERPIECE, s3, ((MASTERPIECETYPE)object2).gnrContsSeq, null, null);
                return h0;
            }
            case 7: {
                q.g(((L0)object0), "it");
                g.X(((o)object3).getMenuId(), "D21", "T01", "", "V1", "", "", ((MEGAZINELIST)object2).megazineSeq, ((o)object3).f());
                MelonLinkExecutor.open(MelonLinkInfo.b(((MEGAZINELIST)object2)));
                return h0;
            }
            case 8: {
                q.g(((K4)object0), "it");
                ArrayList arrayList0 = new ArrayList();
                for(Object object4: ((List)object3)) {
                    if(((v1)object4).i) {
                        arrayList0.add(object4);
                    }
                }
                int v1 = arrayList0.size();
                E0 e00 = ((r)object2).a;
                if(v1 <= 0) {
                    z = false;
                }
                return r.a(E0.a(e00, z), ((List)object3), U3.a(((r)object2).c, 0, false, v1, 23));
            }
            case 9: {
                q.g(((F1)object0), "userEvent");
                if(((F1)object0) instanceof D1) {
                    r r0 = ((x)object3).f();
                    if(r0 == null) {
                        return h0;
                    }
                    int v2 = ((D1)(((F1)object0))).b;
                    if(r0.a.a.b == v2) {
                        return h0;
                    }
                    ((x)object3).j = v2 == 0 ? "POP" : "NEW";
                    k1.startFetch$default(((x)object3), true, null, null, 6, null);
                    return h0;
                }
                if(((F1)object0).equals(E1.a)) {
                    if(((x)object3).f() == null) {
                        return h0;
                    }
                    r r1 = ((x)object3).f();
                    if(r1 != null && (r1.a != null && !r1.a.d)) {
                        v = 1;
                    }
                    ((x)object3).selectAll(((boolean)v));
                    return h0;
                }
                if(!((F1)object0).equals(E1.b)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                if(((List)object2) != null) {
                    ArrayList arrayList1 = new ArrayList(je.q.Q(10, ((List)object2)));
                    for(Object object5: ((List)object2)) {
                        arrayList1.add(Playable.from(((SongInfoBase)object5), ((x)object3).getMenuId(), null));
                    }
                    ((x)object3).sendUiEvent(new B4(28, ((x)object3).getMenuId(), arrayList1, false));
                }
                return h0;
            }
            case 10: {
                q.g(((K4)object0), "it");
                ArrayList arrayList2 = new ArrayList();
                for(Object object6: ((Iterable)object3)) {
                    if(((v1)object6).i) {
                        arrayList2.add(object6);
                    }
                }
                int v3 = arrayList2.size();
                E0 e01 = ((r)object2).a;
                if(v3 <= 0) {
                    z = false;
                }
                return r.a(E0.a(e01, z), ((List)object3), U3.a(((r)object2).c, 0, false, v3, 23));
            }
            case 11: {
                q.g(((d1)object0), "fetchResult");
                if(((d1)object0) instanceof Z0) {
                    object1 = ((x)object3).f();
                    return object1 != null ? object1 : new Oc.q(((Z0)(((d1)object0))).a);
                }
                if(((d1)object0) instanceof b1) {
                    return new p(Q1.c.q(((b1)(((d1)object0))).a));
                }
                if(((d1)object0) instanceof c1) {
                    RESPONSE genreDetailGuiType2Res$RESPONSE0 = (RESPONSE)((c1)(((d1)object0))).a;
                    ((x)object3).getClass();
                    ArrayList arrayList3 = genreDetailGuiType2Res$RESPONSE0.songList;
                    q.f(arrayList3, "songList");
                    ArrayList arrayList4 = new ArrayList(je.q.Q(10, arrayList3));
                    for(Object object7: arrayList3) {
                        q.d(((SONGLIST)object7));
                        arrayList4.add(a.P(((SONGLIST)object7), ((x)object3).getMenuId(), new y(12, ((x)object3), ((SONGLIST)object7))));
                    }
                    ((x)object3).a.d(arrayList4, genreDetailGuiType2Res$RESPONSE0.hasMore);
                    if(q.b(((g1)object2), new e1(null))) {
                        object1 = ((x)object3).f();
                    }
                    if(object1 != null) {
                        ArrayList arrayList5 = je.p.A0(object1.b, arrayList4);
                        return r.a(((x)object3).e(genreDetailGuiType2Res$RESPONSE0.songList), arrayList5, object1.c);
                    }
                    return new r(((x)object3).e(genreDetailGuiType2Res$RESPONSE0.songList), arrayList4, new U3(1000, false, true, 0, new Mc.q(((x)object3), 12)));
                }
                if(!(((d1)object0) instanceof a1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return object1;
            }
            case 12: {
                q.g(((B1)object0), "userEvent");
                if(((B1)object0) instanceof Nc.w1) {
                    v1 v10 = ((Nc.w1)(((B1)object0))).a;
                    LogU.debug$default(((x)object3).k, "selectItem() selectItem\'s songName:" + v10.a, null, false, 6, null);
                    r r2 = ((x)object3).f();
                    if(r2 == null) {
                        return h0;
                    }
                    List list0 = r2.b;
                    if(list0.isEmpty()) {
                        return h0;
                    }
                    LogU.debug$default(((x)object3).k, "selectItem() songList\'s size:" + list0.size(), null, false, 6, null);
                    ((x)object3).updateUiState(new y(8, ((x)object3).l.b(list0, v10), r2));
                    return h0;
                }
                if(((B1)object0) instanceof Nc.x1) {
                    Playable playable0 = Playable.from(((SONGLIST)object2), ((x)object3).getMenuId(), null);
                    q.f(playable0, "from(...)");
                    ((x)object3).sendUiEvent(new F4(playable0, ((x)object3).getMenuId()));
                    return h0;
                }
                if(((B1)object0) instanceof A1) {
                    u0.L(((x)object3), Dispatchers.getIO(), new u(((SONGLIST)object2), ((x)object3), null), 2);
                    return h0;
                }
                if(((B1)object0) instanceof y1) {
                    String s4 = ((SONGLIST)object2).songId;
                    if(s4 != null) {
                        s = s4;
                    }
                    ((x)object3).d(s, ((x)object3).getMenuId(), null);
                    return h0;
                }
                if(!(((B1)object0) instanceof z1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                Navigator.openAlbumInfo(((SONGLIST)object2).albumId);
                return h0;
            }
            case 13: {
                q.g(((Nc.y)object0), "userEvent");
                if(!(((Nc.y)object0) instanceof t) && !(((Nc.y)object0) instanceof Nc.w) && !(((Nc.y)object0) instanceof Nc.u)) {
                    if(((Nc.y)object0) instanceof Nc.x) {
                        Playable playable1 = Playable.from(((ALBUMLIST)object3), ((D)object2).getMenuId(), null);
                        q.f(playable1, "from(...)");
                        ((D)object2).sendUiEvent(new E4(playable1, ((D)object2).getMenuId()));
                        return h0;
                    }
                    if(!(((Nc.y)object0) instanceof v)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    if(((ALBUMLIST)object3).canService) {
                        String s5 = ((ALBUMLIST)object3).albumId;
                        if(s5 != null) {
                            s = s5;
                        }
                        ((D)object2).c(s, ((D)object2).getMenuId(), null);
                        return h0;
                    }
                    Playable playable2 = Playable.from(((ALBUMLIST)object3), ((D)object2).getMenuId(), null);
                    q.f(playable2, "from(...)");
                    ((D)object2).sendUiEvent(new E4(playable2, ((D)object2).getMenuId()));
                    return h0;
                }
                Navigator.openAlbumInfo(((ALBUMLIST)object3).albumId);
                return h0;
            }
            case 14: {
                q.g(((K4)object0), "it");
                U3 u30 = ((Oc.H)object3).c;
                ArrayList arrayList6 = new ArrayList();
                for(Object object8: ((List)object2)) {
                    if(((v1)object8).i) {
                        arrayList6.add(object8);
                    }
                }
                return Oc.H.a(((Oc.H)object3), null, ((List)object2), U3.a(u30, 0, false, arrayList6.size(), 23), 1);
            }
            case 15: {
                q.g(((F1)object0), "userEvent");
                if(((F1)object0) instanceof D1) {
                    Object object9 = ((N)object3).getUiState().getValue();
                    if(object9 instanceof G) {
                        object1 = (G)object9;
                    }
                    if(object1 == null) {
                        Oc.H h1 = ((N)object3).f();
                        if(h1 == null) {
                            return h0;
                        }
                        e02 = h1.a;
                    }
                    else {
                        e02 = object1.a;
                    }
                    int v4 = ((D1)(((F1)object0))).b;
                    if(e02.a.b == v4) {
                        return h0;
                    }
                    if(v4 == 0) {
                        s6 = "N10002";
                        q.f("N10002", "code(...)");
                    }
                    else {
                        s6 = "N10001";
                        q.f("N10001", "code(...)");
                    }
                    ((N)object3).k = s6;
                    k1.startFetch$default(((N)object3), true, null, null, 6, null);
                    return h0;
                }
                if(((F1)object0).equals(E1.a)) {
                    if(((N)object3).f() == null) {
                        return h0;
                    }
                    Oc.H h2 = ((N)object3).f();
                    if(h2 != null) {
                        Iterable iterable0 = h2.b;
                        if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                            for(Object object10: iterable0) {
                                if(!((v1)object10).i) {
                                    continue;
                                }
                                ((N)object3).selectAll(((boolean)v));
                                return h0;
                            }
                        }
                        v = 1;
                    }
                    ((N)object3).selectAll(((boolean)v));
                    return h0;
                }
                if(!((F1)object0).equals(E1.b)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                if(((List)object2) != null) {
                    ArrayList arrayList7 = new ArrayList(je.q.Q(10, ((List)object2)));
                    for(Object object11: ((List)object2)) {
                        arrayList7.add(Playable.from(((SongInfoBase)object11), ((N)object3).getMenuId(), null));
                    }
                    ((N)object3).sendUiEvent(new B4(28, ((N)object3).getMenuId(), arrayList7, false));
                }
                return h0;
            }
            case 16: {
                q.g(((K4)object0), "it");
                U3 u31 = ((Oc.H)object3).c;
                ArrayList arrayList8 = new ArrayList();
                for(Object object12: ((Iterable)object2)) {
                    if(((v1)object12).i) {
                        arrayList8.add(object12);
                    }
                }
                return Oc.H.a(((Oc.H)object3), null, ((List)object2), U3.a(u31, 0, false, arrayList8.size(), 23), 1);
            }
            case 17: {
                q.g(((d1)object0), "fetchResult");
                if(((d1)object0) instanceof Z0) {
                    Oc.H h3 = ((N)object3).f();
                    if(h3 != null) {
                        return h3;
                    }
                    Object object13 = ((N)object3).getUiState().getValue();
                    if(object13 instanceof G) {
                        object1 = (G)object13;
                    }
                    return object1 != null ? object1 : new F(((Z0)(((d1)object0))).a);
                }
                if(((d1)object0) instanceof b1) {
                    return new E(Q1.c.q(((b1)(((d1)object0))).a));
                }
                if(((d1)object0) instanceof c1) {
                    com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE genreDetailGuiType4Res$RESPONSE0 = (com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE)((c1)(((d1)object0))).a;
                    if(q.b(((String)object2), "N10001")) {
                        ((N)object3).getClass();
                        ArrayList arrayList9 = genreDetailGuiType4Res$RESPONSE0.songList;
                        q.f(arrayList9, "songList");
                        ArrayList arrayList10 = new ArrayList(je.q.Q(10, arrayList9));
                        for(Object object14: arrayList9) {
                            if(v >= 0) {
                                q.d(((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.SONGLIST)object14));
                                arrayList10.add(a.P(((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.SONGLIST)object14), ((N)object3).getMenuId(), new y(19, ((N)object3), ((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.SONGLIST)object14))));
                                ++v;
                                continue;
                            }
                            e.k.O();
                            throw null;
                        }
                        ((N)object3).a.d(arrayList10, genreDetailGuiType4Res$RESPONSE0.hasMore);
                        Oc.H h4 = ((N)object3).f();
                        return h4 == null ? new Oc.H(((N)object3).e(genreDetailGuiType4Res$RESPONSE0.songList), arrayList10, new U3(1000, false, true, 0, new Mc.q(((N)object3), 14))) : Oc.H.a(h4, ((N)object3).e(genreDetailGuiType4Res$RESPONSE0.songList), je.p.A0(h4.b, arrayList10), null, 4);
                    }
                    ((N)object3).getClass();
                    ArrayList arrayList11 = genreDetailGuiType4Res$RESPONSE0.albumList;
                    q.f(arrayList11, "albumList");
                    ArrayList arrayList12 = new ArrayList(je.q.Q(10, arrayList11));
                    for(Object object15: arrayList11) {
                        if(v >= 0) {
                            q.d(((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.ALBUMLIST)object15));
                            arrayList12.add(Q1.c.W(((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.ALBUMLIST)object15), new y(18, ((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.ALBUMLIST)object15), ((N)object3))));
                            ++v;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                    ((N)object3).a.d(arrayList12, genreDetailGuiType4Res$RESPONSE0.hasMore);
                    Object object16 = ((N)object3).getUiState().getValue();
                    G g0 = object16 instanceof G ? ((G)object16) : null;
                    return g0 == null ? new G(((N)object3).e(null), arrayList12) : new G(((N)object3).e(null), je.p.A0(g0.b, arrayList12));
                }
                if(!(((d1)object0) instanceof a1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return object1;
            }
            case 18: {
                q.g(((Nc.y)object0), "userEvent");
                if(!(((Nc.y)object0) instanceof t) && !(((Nc.y)object0) instanceof Nc.w) && !(((Nc.y)object0) instanceof Nc.u)) {
                    if(((Nc.y)object0) instanceof Nc.x) {
                        Playable playable3 = Playable.from(((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.ALBUMLIST)object3), ((N)object2).getMenuId(), null);
                        q.f(playable3, "from(...)");
                        ((N)object2).sendUiEvent(new E4(playable3, ((N)object2).getMenuId()));
                        return h0;
                    }
                    if(!(((Nc.y)object0) instanceof v)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    if(((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.ALBUMLIST)object3).canService) {
                        String s7 = ((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.ALBUMLIST)object3).albumId;
                        if(s7 != null) {
                            s = s7;
                        }
                        ((N)object2).c(s, ((N)object2).getMenuId(), null);
                        return h0;
                    }
                    Playable playable4 = Playable.from(((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.ALBUMLIST)object3), ((N)object2).getMenuId(), null);
                    q.f(playable4, "from(...)");
                    ((N)object2).sendUiEvent(new E4(playable4, ((N)object2).getMenuId()));
                    return h0;
                }
                Navigator.openAlbumInfo(((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.ALBUMLIST)object3).albumId);
                return h0;
            }
            case 19: {
                q.g(((B1)object0), "userEvent");
                if(((B1)object0) instanceof Nc.w1) {
                    v1 v11 = ((Nc.w1)(((B1)object0))).a;
                    Oc.H h5 = ((N)object3).f();
                    if(h5 == null) {
                        return h0;
                    }
                    List list1 = h5.b;
                    if(list1.isEmpty()) {
                        return h0;
                    }
                    ((N)object3).updateUiState(new y(14, h5, ((N)object3).m.b(list1, v11)));
                    return h0;
                }
                if(((B1)object0) instanceof Nc.x1) {
                    Playable playable5 = Playable.from(((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.SONGLIST)object2), ((N)object3).getMenuId(), null);
                    q.f(playable5, "from(...)");
                    ((N)object3).sendUiEvent(new F4(playable5, ((N)object3).getMenuId()));
                    return h0;
                }
                if(((B1)object0) instanceof A1) {
                    u0.L(((N)object3), Dispatchers.getIO(), new K(((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.SONGLIST)object2), ((N)object3), null), 2);
                    return h0;
                }
                if(((B1)object0) instanceof y1) {
                    String s8 = ((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.SONGLIST)object2).songId;
                    if(s8 != null) {
                        s = s8;
                    }
                    ((N)object3).d(s, ((N)object3).getMenuId(), null);
                    return h0;
                }
                if(!(((B1)object0) instanceof z1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                Navigator.openAlbumInfo(((com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res.RESPONSE.SONGLIST)object2).albumId);
                return h0;
            }
            case 20: {
                q.g(((Nc.e)object0), "userEvent");
                if(((Nc.e)object0) instanceof Nc.b) {
                    Navigator.openAlbumInfo(((com.iloen.melon.net.v5x.response.GenreDetailGuiType5Res.RESPONSE.GNRDETAILCONTENTS.AGEARTISTLIST.ALBUMLIST)object3).albumId);
                    return h0;
                }
                if(((Nc.e)object0) instanceof Nc.c) {
                    String s9 = ((com.iloen.melon.net.v5x.response.GenreDetailGuiType5Res.RESPONSE.GNRDETAILCONTENTS.AGEARTISTLIST.ALBUMLIST)object3).albumId;
                    if(s9 != null) {
                        s = s9;
                    }
                    ((U)object2).c(s, ((U)object2).getMenuId(), null);
                    return h0;
                }
                if(!(((Nc.e)object0) instanceof Nc.d)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                Navigator.openAlbumInfo(((com.iloen.melon.net.v5x.response.GenreDetailGuiType5Res.RESPONSE.GNRDETAILCONTENTS.AGEARTISTLIST.ALBUMLIST)object3).albumId);
                return h0;
            }
            case 21: {
                q.g(((Nc.o)object0), "userEvent");
                if(!(((Nc.o)object0) instanceof Nc.o)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                Navigator.INSTANCE.openGenreMore(More_Fragment_Type.GUI_MORE_ARTIST, ((U)object3).d, null, ((GNRDETAILCONTENTS)object2).filterTypeFlg, ((GNRDETAILCONTENTS)object2).filterTypeCode);
                return h0;
            }
            case 22: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                Ld.p p0 = new Ld.p(12, new Ac.F(25), ((i)object3).c);
                s s10 = new s(13, ((i)object3).c);
                b b1 = new b(0xBEF78951, new p2(((i)object3).c, ((i)object3), ((f)object2), 3), true);
                ((j)(((w)object0))).u(((i)object3).c.size(), p0, s10, b1);
                return h0;
            }
            case 23: {
                q.g(((K4)object0), "it");
                return new i(((ArrayList)object2), ((Qc.w)object3).d, false);
            }
            case 24: {
                q.g(((K4)object0), "it");
                ArrayList arrayList13 = new ArrayList();
                for(Object object17: ((ArrayList)object3)) {
                    if(((Qc.v)object17).f) {
                        arrayList13.add(object17);
                    }
                }
                if(arrayList13.size() > 0) {
                    v = 1;
                }
                ((ArrayList)object2).addAll(((ArrayList)object3));
                return new i(((ArrayList)object2), true, ((boolean)v));
            }
            case 25: {
                q.g(((ImageView)object0), "imageView");
                Glide.with(((ImageView)object0).getContext()).asBitmap().load(((O)object3).g).into(new F8.u(2, ((a0)object2), ((ImageView)object0)));
                return h0;
            }
            case 26: {
                q.g(((K4)object0), "it");
                boolean z1 = MelonSettingInfo.isEqualizerStatusOn();
                int v5 = ((y8.k)object2).b;
                int v6 = v5 == 11 || v5 == 12 ? 0 : 1;
                boolean z2 = v5 == 11;
                boolean z3 = v5 == 12;
                LoudnessType solMusicOne$LoudnessType0 = y8.f.b().c.loudnessType;
                q.f(solMusicOne$LoudnessType0, "loudnessType");
                int v7 = v5 == 6 ? 1 : 0;
                y8.p p1 = l.b().f;
                float[] arr_f = ((y8.k)object2).e;
                float f = y8.f.b().c.targetLoudness;
                return v5 == 6 ? new U8.r(z1, v6, z2, z3, solMusicOne$LoudnessType0, v7, p1, arr_f, f, new U3(0x3F3, false, false, 0, new Mc.q(((U8.w)object3), 22))) : new U8.r(z1, v6, z2, z3, solMusicOne$LoudnessType0, v7, p1, arr_f, f, new U3(1010, false, false, 0, new Mc.q(((U8.w)object3), 22)));
            }
            case 27: {
                q.g(((q8.b)object0), "$this$common");
                p8.s s11 = ((Uc.q)object2).a;
                ((q8.b)object0).a = s11 == null ? null : s11.a;
                p8.s s12 = ((Uc.q)object2).a;
                ((q8.b)object0).b = s12 == null ? null : s12.b;
                ((q8.j)object3).getClass();
                p8.s s13 = ((Uc.q)object2).a;
                if(s13 != null) {
                    object1 = s13.c;
                }
                if(object1 != null) {
                    s = object1;
                }
                ((q8.j)object3).a = s;
                return h0;
            }
            case 28: {
                if(((d1)object0) instanceof c1) {
                    Response foruTabRes$Response0 = (Response)((c1)(((d1)object0))).a;
                    Uc.q q0 = ((Q)object3).k;
                    String s14 = foruTabRes$Response0.section;
                    String s15 = foruTabRes$Response0.page;
                    String s16 = foruTabRes$Response0.menuId != null && foruTabRes$Response0.menuId.length() > 0 ? foruTabRes$Response0.menuId : null;
                    if(s16 == null) {
                        s16 = "1000003238";
                    }
                    q0.a = new p8.s(s14, s15, s16, null);
                    M m0 = new M(((Q)object3), foruTabRes$Response0, null);
                    BuildersKt__Builders_commonKt.launch$default(((CoroutineScope)object2), ((Q)object3).p, null, m0, 2, null);
                    return null;
                }
                if(((d1)object0) instanceof Z0) {
                    ((Q)object3).updateUiState(new L(((d1)object0), 0));
                    return null;
                }
                if(((d1)object0) instanceof b1) {
                    ((Q)object3).updateUiState(new L(((d1)object0), 1));
                    return null;
                }
                if(!(((d1)object0) instanceof a1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return null;
            }
            default: {
                q.g(((StringBuilder)object0), "$this$buildError");
                ((StringBuilder)object0).append("onPreparedMediaItem() Invalid PrepareItem");
                Cb.i.a(((StringBuilder)object0), "mediaItem: " + ((b3.E)object3).a);
                Cb.i.a(((StringBuilder)object0), "preparedItem: " + ((ac.q)object2).a.a);
                return h0;
            }
        }
    }
}

