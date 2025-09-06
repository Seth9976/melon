package wc;

import Ac.m4;
import Cb.j;
import Cc.U3;
import Cc.a3;
import Cc.s0;
import H8.q;
import Hc.i;
import Hd.F0;
import I7.c;
import Ic.A;
import Ic.I;
import Ic.J;
import Ic.K;
import Ic.U;
import Ic.V;
import Ic.o;
import Ic.v;
import Ic.x;
import Ic.z;
import Jc.B;
import Jc.C;
import Jc.D;
import Jc.E;
import Jc.F;
import Jc.G;
import Jc.H0;
import Jc.H;
import Jc.I0;
import Jc.L;
import Jc.M;
import Jc.N;
import Jc.O;
import Jc.P;
import Jc.S;
import Jc.T;
import Jc.W;
import Jc.X;
import Jc.Y;
import Jc.Z;
import Jc.a0;
import Jc.b0;
import Jc.c0;
import Jc.d0;
import Jc.e0;
import Ua.h;
import Ua.n;
import Ud.g;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.fragments.detail.AlbumDetailContentsArtistNoteFragment;
import com.iloen.melon.fragments.detail.AlbumDetailContentsMagazineFragment;
import com.iloen.melon.fragments.detail.AlbumDetailContentsMvFragment;
import com.iloen.melon.fragments.detail.AlbumDetailContentsOtherVerFragment;
import com.iloen.melon.fragments.detail.AlbumDetailContentsPhotoFragment;
import com.iloen.melon.fragments.detail.AlbumDetailContentsSeriesFragment;
import com.iloen.melon.fragments.detail.DetailContentsAlbumInfoFragment.AlbumInfoParam;
import com.iloen.melon.fragments.detail.DetailContentsAlbumInfoFragment;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment.Companion;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfoList;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoItem;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes;
import com.iloen.melon.net.v5x.response.DetailBaseRes.ALBUM;
import com.iloen.melon.net.v5x.response.DetailBaseRes.MAGAZINE;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PHOTO;
import com.iloen.melon.net.v5x.response.DetailBaseRes.STATION;
import com.iloen.melon.net.v5x.response.DetailBaseRes.TICKET;
import com.iloen.melon.net.v5x.response.DetailBaseRes.VIDEO;
import com.iloen.melon.net.v6x.response.AlbumContentsListRes;
import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE.ALBUMINFO;
import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE.ARTISTNOTEINFO;
import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE.BOOKLETIMGLIST;
import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE.CREDITLIST;
import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE.MILLIONSINFO;
import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE.OPENHIRISINGINFO;
import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE.OPENSPOTLIGHTINFO;
import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE.PREVHIRISINGINFO;
import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE.PREVSPOTLIGHTINFO;
import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE.TOTAVRGSCOREINFO;
import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.AlbumSongListRes.RESPONSE.CDLIST;
import com.iloen.melon.net.v6x.response.AlbumSongListRes;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes.RESPONSE.Banner;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.FamilyAppHelper;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.A4;
import com.melon.ui.B4;
import com.melon.ui.F4;
import com.melon.ui.J4;
import com.melon.ui.K4;
import com.melon.ui.L2;
import com.melon.ui.N3;
import com.melon.ui.Q;
import com.melon.ui.Z0;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.b3;
import com.melon.ui.c1;
import com.melon.ui.d1;
import com.melon.ui.detail.holder.DetailHolderUiState.CreditItemUiState;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.n4;
import com.melon.ui.q3;
import com.melon.ui.t3;
import com.melon.ui.z4;
import eb.y;
import h7.u0;
import i.n.i.b.a.s.e.M3;
import ie.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mb.k;
import p8.s;
import td.m0;
import td.z1;
import w4.f;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lwc/w;", "LHc/i;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class w extends i {
    public final h h;
    public final c i;
    public final q j;
    public final k k;
    public final n4 l;
    public final t3 m;
    public final b3 n;
    public final y o;
    public final Q p;
    public final CoroutineDispatcher q;
    public final LogU r;
    public String s;
    public boolean t;
    public final ContsTypeCode u;
    public final MutableStateFlow v;
    public final g w;
    public final r x;
    public static final int y;

    public w(h h0, c c0, q q0, k k0, n4 n40, t3 t30, b3 b30, y y0, Q q1, n n0, StringProviderImpl stringProviderImpl0, CoroutineDispatcher coroutineDispatcher0) {
        kotlin.jvm.internal.q.g(k0, "loginUseCase");
        super(n0, stringProviderImpl0);
        this.h = h0;
        this.i = c0;
        this.j = q0;
        this.k = k0;
        this.l = n40;
        this.m = t30;
        this.n = b30;
        this.o = y0;
        this.p = q1;
        this.q = coroutineDispatcher0;
        LogU logU0 = new LogU("AlbumDetailViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.r = logU0;
        kotlin.jvm.internal.q.f(ContsTypeCode.ALBUM, "ALBUM");
        this.u = ContsTypeCode.ALBUM;
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(J4.a);
        this.v = mutableStateFlow0;
        FlowKt.asStateFlow(mutableStateFlow0);
        g g0 = new g(new u(0));
        g0.c = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.w = g0;
        this.x = d3.g.Q(new z1(3, stringProviderImpl0, this));
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new t(this, null), 3, null);
    }

    @Override  // Hc.i
    public final String d() {
        return this.p();
    }

    @Override  // Hc.i
    public final ContsTypeCode e() {
        return this.u;
    }

    @Override  // Hc.i
    public final s0 f() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(new Cc.r(0x7F080405, 0x7F1302F5, new d(this, 0)));  // drawable:ic_common_play_01
        arrayList0.add(new Cc.r(0x7F08040E, 0x7F1302F7, new d(this, 2)));  // drawable:ic_common_shuffle_01
        arrayList0.add(new Cc.r(0x7F080154, 0x7F1302F6, new d(this, 6)));  // drawable:btn_common_mixup_16
        return new s0(arrayList0);
    }

    @Override  // Hc.i
    public final Object g(String s, String s1, Continuation continuation0) {
        return w.s(this, s, s1, ((oe.c)continuation0));
    }

    @Override  // Hc.i
    public final List getSelectedPlayableList() {
        Iterable iterable0 = this.u();
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            if(((X)object0).M) {
                arrayList0.add(object0);
            }
        }
        List list0 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object1: arrayList0) {
            list0.add(((X)object1).a);
        }
        return list0;
    }

    @Override  // Hc.i
    public final p8.f h() {
        s s0 = this.getTiaraProperty();
        if(s0 != null) {
            p8.f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            f0.b = s0.a;
            f0.c = s0.b;
            f0.I = s0.c;
            f0.o = this.p();
            f0.p = this.b.a(0x7F130EF0);  // string:tiara_meta_type_album "앨범"
            f0.q = this.q();
            return f0;
        }
        return null;
    }

    @Override  // Hc.i
    public final p8.f i() {
        s s0 = this.getTiaraProperty();
        if(s0 != null) {
            p8.f f0 = new p8.i();  // 初始化器: Lp8/f;-><init>()V
            f0.b = s0.a;
            f0.c = s0.b;
            f0.I = s0.c;
            f0.N = "1727140957b6fc5c5a";
            f0.O = "app_user_id";
            return f0;
        }
        return null;
    }

    @Override  // Hc.i
    public final void k() {
        this.y(false);
    }

    @Override  // Hc.i
    public final void m(List list0) {
        kotlin.jvm.internal.q.g(list0, "list");
        z z0 = this.t();
        if(z0 != null) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: z0.b) {
                if(!(((e0)object0) instanceof H)) {
                    arrayList0.add(object0);
                }
            }
            ArrayList arrayList1 = p.Q0(arrayList0);
            arrayList1.addAll(list0);
            this.updateUiState(new Hd.w(z.a(z0, arrayList1, null, 29), 2));
        }
    }

    public static m4 o(kotlin.jvm.internal.H h0, kotlin.jvm.internal.H h1, AlbumSongListRes albumSongListRes0, w w0, AlbumContentsListRes albumContentsListRes0, PromotionContentsBannerRes promotionContentsBannerRes0, d1 d10) {
        Banner promotionContentsBannerRes$RESPONSE$Banner0;
        String s92;
        String s91;
        String s87;
        String s86;
        String s84;
        String s83;
        String s81;
        String s80;
        String s45;
        String s44;
        ArrayList arrayList6;
        String s20;
        Iterator iterator2;
        kotlin.jvm.internal.q.g(d10, "it");
        if(d10 instanceof Z0) {
            return new Ic.r(((Z0)d10).a);
        }
        if(d10 instanceof b1) {
            return new Ic.w(((b1)d10).a);
        }
        if(d10 instanceof c1) {
            RESPONSE albumInfoRes$RESPONSE0 = (RESPONSE)((c1)d10).a;
            h0.a = albumInfoRes$RESPONSE0.bbschannelseq;
            h1.a = albumInfoRes$RESPONSE0.bbsContsRefValue;
            ArrayList arrayList0 = new ArrayList();
            String s = "";
            if(albumSongListRes0 != null) {
                ArrayList arrayList1 = albumSongListRes0.response == null ? null : albumSongListRes0.response.cdList;
                if(arrayList1 != null && !arrayList1.isEmpty()) {
                    String s1 = albumSongListRes0.response.totSongCnt;
                    kotlin.jvm.internal.q.f(s1, "totSongCnt");
                    String s2 = albumSongListRes0.response.totPlayTime;
                    kotlin.jvm.internal.q.f(s2, "totPlayTime");
                    arrayList0.add(new W(s1, s2, false, new b(w0, 0)));
                    int v = albumSongListRes0.response.cdList.size();
                    ArrayList arrayList2 = albumSongListRes0.response.cdList;
                    kotlin.jvm.internal.q.f(arrayList2, "cdList");
                    int v1 = 0;
                    Iterator iterator0 = arrayList2.iterator();
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        if(v1 >= 0) {
                            CDLIST albumSongListRes$RESPONSE$CDLIST0 = (CDLIST)object0;
                            if(v > 1) {
                                String s3 = albumSongListRes$RESPONSE$CDLIST0.cdNo;
                                kotlin.jvm.internal.q.f(s3, "cdNo");
                                arrayList0.add(new F(s3, v1 == 0));
                            }
                            ArrayList arrayList3 = albumSongListRes$RESPONSE$CDLIST0.songList;
                            kotlin.jvm.internal.q.f(arrayList3, "songList");
                            int v2 = 0;
                            boolean z = false;
                            for(Object object1: arrayList3) {
                                if(v2 >= 0) {
                                    String s4 = ((SongInfoBase)object1).getComposer();
                                    if(s4 != null && s4.length() != 0) {
                                        String s6 = ((SongInfoBase)object1).getComposer();
                                        String s7 = ((SongInfoBase)object1).getMovement();
                                        if(s7 == null) {
                                            s7 = "";
                                        }
                                        arrayList0.add(new G((s6 == null ? "" : s6), s7, z, v2 == 0));
                                        iterator2 = iterator0;
                                        z = false;
                                    }
                                    else {
                                        String s5 = ((SongInfoBase)object1).getMovement();
                                        if(s5 == null || s5.length() == 0) {
                                            Playable playable0 = Playable.from(((SongInfoBase)object1), w0.getMenuId(), null);
                                            kotlin.jvm.internal.q.d(playable0);
                                            iterator2 = iterator0;
                                            arrayList0.add(new X(playable0, ((SongInfoBase)object1).canService, albumSongListRes$RESPONSE$CDLIST0.cdNo, "N10002", ((SongInfoBase)object1).albumId, ((SongInfoBase)object1).cType, ((SongInfoBase)object1).songName, ((SongInfoBase)object1).getArtistNames(), ((SongInfoBase)object1).isTitleSong, ((SongInfoBase)object1).isAdult, ((SongInfoBase)object1).isHitSong, ((SongInfoBase)object1).isFree, ((SongInfoBase)object1).isHoldback, ((SongInfoBase)object1).getTrackNo(), ((SongInfoBase)object1).albumImg, ((SongInfoBase)object1).songId, null, new wc.c(w0, 0), new z1(4, w0, playable0), new wc.c(w0, 1), new wc.c(w0, 2), new wc.c(w0, 3), false, false));
                                            z = true;
                                        }
                                    }
                                    iterator0 = iterator2;
                                    ++v2;
                                    continue;
                                }
                                e.k.O();
                                throw null;
                            }
                            ++v1;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                }
            }
            ARTISTNOTEINFO albumInfoRes$RESPONSE$ARTISTNOTEINFO0 = albumInfoRes$RESPONSE0.artistNoteInfo;
            if(albumInfoRes$RESPONSE$ARTISTNOTEINFO0 != null) {
                String s8 = w0.p();
                boolean z1 = albumInfoRes$RESPONSE0.artistNoteAllButtonFlag;
                String s9 = albumInfoRes$RESPONSE$ARTISTNOTEINFO0.getArtistImg();
                String s10 = albumInfoRes$RESPONSE$ARTISTNOTEINFO0.getArtistName();
                arrayList0.add(new E(s8, z1, (s9 == null ? "" : s9), (s10 == null ? "" : s10), (albumInfoRes$RESPONSE$ARTISTNOTEINFO0.issueDate == null ? "" : albumInfoRes$RESPONSE$ARTISTNOTEINFO0.issueDate), (albumInfoRes$RESPONSE$ARTISTNOTEINFO0.artistNote == null ? "" : albumInfoRes$RESPONSE$ARTISTNOTEINFO0.artistNote), new d(w0, 1)));
            }
            w0.getClass();
            String s11 = albumInfoRes$RESPONSE0.albumType;
            String s12 = ProtocolUtils.getGenreNamesToSlash(albumInfoRes$RESPONSE0.genreList);
            String s13 = albumInfoRes$RESPONSE0.issueDate;
            String s14 = albumInfoRes$RESPONSE0.sellCnpy;
            String s15 = albumInfoRes$RESPONSE0.planCnpy;
            String s16 = albumInfoRes$RESPONSE0.reportPreview;
            String s17 = albumInfoRes$RESPONSE0.report;
            String s18 = albumInfoRes$RESPONSE0.albumInfo.albumName;
            String s19 = albumInfoRes$RESPONSE0.albumInfo.getArtistNames();
            ArrayList arrayList4 = albumInfoRes$RESPONSE0.creditList;
            if(arrayList4 == null) {
                s20 = s11;
                arrayList6 = null;
            }
            else {
                s20 = s11;
                ArrayList arrayList5 = new ArrayList(je.q.Q(10, arrayList4));
                for(Object object2: arrayList4) {
                    arrayList5.add(new DetailHolderUiState.CreditItemUiState(((CREDITLIST)object2).roleName, ((CREDITLIST)object2).artistName));
                }
                arrayList6 = arrayList5;
            }
            arrayList0.add(new B(s20, s12, s13, s14, s15, s16, s17, s18, s19, arrayList6, new b(w0, 6)));
            ArrayList arrayList7 = albumInfoRes$RESPONSE0.prevSpotLightInfoList;
            if(arrayList7 != null) {
                ArrayList arrayList8 = new ArrayList(je.q.Q(10, arrayList7));
                int v3 = 0;
                for(Object object3: arrayList7) {
                    if(v3 >= 0) {
                        String s21 = ((PREVSPOTLIGHTINFO)object3).spotlightSeq;
                        kotlin.jvm.internal.q.f(s21, "spotlightSeq");
                        String s22 = ((PREVSPOTLIGHTINFO)object3).title;
                        String s23 = ((PREVSPOTLIGHTINFO)object3).regDate;
                        String s24 = ((PREVSPOTLIGHTINFO)object3).imageBgColor;
                        String s25 = ((PREVSPOTLIGHTINFO)object3).imageUrl;
                        String s26 = ((PREVSPOTLIGHTINFO)object3).logoImageUrl;
                        LinkInfoBase linkInfoBase0 = ((PREVSPOTLIGHTINFO)object3).link;
                        arrayList8.add(new Z(s21, (s22 == null ? "" : s22), (s23 == null ? "" : s23), (s24 == null ? "" : s24), (s25 == null ? "" : s25), (s26 == null ? "" : s26), new Ic.u((linkInfoBase0.linktype == null ? "" : linkInfoBase0.linktype), (linkInfoBase0.linkurl == null ? "" : linkInfoBase0.linkurl), ""), new b(w0, 2), String.valueOf(v3 + 1)));
                        ++v3;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
                arrayList0.add(new Y(p.P0(arrayList8)));
            }
            ArrayList arrayList9 = albumInfoRes$RESPONSE0.prevHiRisingInfoList;
            if(arrayList9 != null) {
                ArrayList arrayList10 = new ArrayList(je.q.Q(10, arrayList9));
                int v4 = 0;
                for(Object object4: arrayList9) {
                    if(v4 >= 0) {
                        String s27 = ((PREVHIRISINGINFO)object4).hiRisingSeq;
                        kotlin.jvm.internal.q.f(s27, "hiRisingSeq");
                        String s28 = ((PREVHIRISINGINFO)object4).title;
                        String s29 = ((PREVHIRISINGINFO)object4).regDate;
                        String s30 = ((PREVHIRISINGINFO)object4).imageBgColor;
                        String s31 = ((PREVHIRISINGINFO)object4).imageUrl;
                        String s32 = ((PREVHIRISINGINFO)object4).logoImageUrl;
                        LinkInfoBase linkInfoBase1 = ((PREVHIRISINGINFO)object4).link;
                        arrayList10.add(new M(s27, (s28 == null ? "" : s28), (s29 == null ? "" : s29), (s30 == null ? "" : s30), (s31 == null ? "" : s31), (s32 == null ? "" : s32), new Ic.u((linkInfoBase1.linktype == null ? "" : linkInfoBase1.linktype), (linkInfoBase1.linkurl == null ? "" : linkInfoBase1.linkurl), ""), new b(w0, 3), String.valueOf(v4 + 1)));
                        ++v4;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
                arrayList0.add(new L(p.P0(arrayList10)));
            }
            if(albumContentsListRes0 != null) {
                com.iloen.melon.net.v6x.response.AlbumContentsListRes.RESPONSE albumContentsListRes$RESPONSE0 = albumContentsListRes0.response;
                if(albumContentsListRes$RESPONSE0 != null) {
                    List list0 = albumContentsListRes$RESPONSE0.mvList;
                    if(list0 != null) {
                        boolean z2 = albumContentsListRes$RESPONSE0.mvAllButtonFlag;
                        String s33 = w0.p();
                        ArrayList arrayList11 = new ArrayList(je.q.Q(10, list0));
                        int v5 = 0;
                        for(Object object5: list0) {
                            if(v5 >= 0) {
                                String s34 = ((VIDEO)object5).mv169Img;
                                String s35 = ((VIDEO)object5).mvId;
                                String s36 = ((VIDEO)object5).mvName;
                                String s37 = ((VIDEO)object5).getArtistNames();
                                String s38 = ((VIDEO)object5).playTime;
                                String s39 = ((VIDEO)object5).adultGrade;
                                arrayList11.add(new c0((s34 == null ? "" : s34), (s35 == null ? "" : s35), (s36 == null ? "" : s36), s37, (s38 == null ? "" : s38), (s39 == null ? "" : s39), new wc.g(w0, v5, 0)));
                                ++v5;
                                continue;
                            }
                            e.k.O();
                            throw null;
                        }
                        arrayList0.add(new d0(z2, s33, arrayList11, new d(w0, 5)));
                    }
                    List list1 = albumContentsListRes$RESPONSE0.magazineList;
                    if(list1 != null) {
                        boolean z3 = albumContentsListRes0.response == null ? false : albumContentsListRes0.response.magazineAllButtonFlag;
                        ArrayList arrayList12 = new ArrayList(je.q.Q(10, list1));
                        int v6 = 0;
                        for(Object object6: list1) {
                            if(v6 >= 0) {
                                String s40 = ((MAGAZINE)object6).contsId;
                                String s41 = ((MAGAZINE)object6).contsImg;
                                String s42 = ((MAGAZINE)object6).contsName;
                                String s43 = ((MAGAZINE)object6).cateName;
                                if(s43 == null || s43.length() <= 0) {
                                    s44 = s43;
                                    s45 = ProtocolUtils.getArtistNames(((MAGAZINE)object6).artistList);
                                }
                                else {
                                    s44 = s43;
                                    s45 = ((MAGAZINE)object6).cateName;
                                }
                                arrayList12.add(new N(s40, s42, s41, s44, (s45 == null ? "" : s45), ((MAGAZINE)object6).link, String.format(w0.b.a(0x7F130BA8), Arrays.copyOf(new Object[]{list1.size(), ((int)(v6 + 1))}, 2)), new wc.g(w0, v6, 1)));  // string:talkback_number_out_of_number "%1$d개중 %2$d번째"
                                ++v6;
                                continue;
                            }
                            e.k.O();
                            throw null;
                        }
                        arrayList0.add(new O(arrayList12, new d(w0, 7), z3));
                    }
                    List list2 = albumContentsListRes$RESPONSE0.otherVersionAlbumList;
                    if(list2 != null) {
                        boolean z4 = albumContentsListRes0.response == null ? false : albumContentsListRes0.response.otherVersionAllButtonFlag;
                        String s46 = w0.p();
                        ArrayList arrayList13 = new ArrayList(je.q.Q(10, list2));
                        for(Object object7: list2) {
                            String s47 = ((ALBUM)object7).albumId;
                            String s48 = ((ALBUM)object7).albumName;
                            String s49 = ((ALBUM)object7).albumImg;
                            String s50 = ((ALBUM)object7).getArtistNames();
                            String s51 = ((ALBUM)object7).issueDate;
                            arrayList13.add(new C((s48 == null ? "" : s48), (s47 == null ? "" : s47), (s51 == null ? "" : s51), (s49 == null ? "" : s49), s50, new wc.c(w0, 4), new wc.c(w0, 5)));
                        }
                        arrayList0.add(new D(z4, s46, arrayList13, new d(w0, 3)));
                    }
                    List list3 = albumContentsListRes$RESPONSE0.seriesAlbumList;
                    if(list3 != null) {
                        boolean z5 = albumContentsListRes0.response == null ? false : albumContentsListRes0.response.seriesAllButtonFlag;
                        String s52 = w0.p();
                        ArrayList arrayList14 = new ArrayList(je.q.Q(10, list3));
                        for(Object object8: list3) {
                            String s53 = ((ALBUM)object8).albumId;
                            String s54 = ((ALBUM)object8).albumName;
                            String s55 = ((ALBUM)object8).albumImg;
                            String s56 = ((ALBUM)object8).getArtistNames();
                            String s57 = ((ALBUM)object8).issueDate;
                            arrayList14.add(new S((s54 == null ? "" : s54), (s53 == null ? "" : s53), (s57 == null ? "" : s57), (s55 == null ? "" : s55), s56, new wc.c(w0, 6), new wc.c(w0, 7)));
                        }
                        arrayList0.add(new T(z5, s52, arrayList14, new d(w0, 9)));
                    }
                    List list4 = albumContentsListRes$RESPONSE0.stationList;
                    if(list4 != null) {
                        boolean z6 = albumContentsListRes$RESPONSE0.stationAllButtonFlag;
                        ArrayList arrayList15 = new ArrayList();
                        int v7 = 0;
                        for(Object object9: list4) {
                            if(v7 >= 0) {
                                String s58 = ((STATION)object9).castTitle;
                                String s59 = ((STATION)object9).progTitle;
                                String s60 = ((STATION)object9).verticalImgUrl;
                                String s61 = s60 == null || s60.length() == 0 ? ((STATION)object9).castImg : ((STATION)object9).verticalImgUrl;
                                kotlin.jvm.internal.q.d(s61);
                                String s62 = ProtocolUtils.getArtistNames(((STATION)object9).artistList);
                                arrayList15.add(new H0((s58 == null ? "" : s58), (s59 == null ? "" : s59), s61, (s62 == null ? "" : s62), new wc.f(w0, ((STATION)object9), v7, 0), new wc.f(w0, ((STATION)object9), v7, 1)));
                                ++v7;
                                continue;
                            }
                            e.k.O();
                            throw null;
                        }
                        arrayList0.add(new a0(arrayList15, new d(w0, 4), z6));
                    }
                    List list5 = albumContentsListRes$RESPONSE0.ticketList;
                    if(list5 != null) {
                        ArrayList arrayList16 = new ArrayList();
                        for(Object object10: list5) {
                            String s63 = ((TICKET)object10).linktype;
                            if(s63 == null) {
                                s63 = "";
                            }
                            String s64 = ((TICKET)object10).linkurl;
                            if(s64 == null) {
                                s64 = "";
                            }
                            String s65 = ((TICKET)object10).appSchemaUrl;
                            if(s65 == null) {
                                s65 = "";
                            }
                            Ic.u u0 = new Ic.u(s63, s64, s65);
                            String s66 = ((TICKET)object10).title;
                            if(s66 == null) {
                                s66 = "";
                            }
                            String s67 = ((TICKET)object10).posterImg;
                            if(s67 == null) {
                                s67 = "";
                            }
                            String s68 = ((TICKET)object10).text;
                            if(s68 == null) {
                                s68 = "";
                            }
                            String s69 = ((TICKET)object10).placeName;
                            if(s69 == null) {
                                s69 = "";
                            }
                            String s70 = ((TICKET)object10).startDt;
                            if(s70 == null) {
                                s70 = "";
                            }
                            String s71 = ((TICKET)object10).endDt;
                            arrayList16.add(new I0(s66, s67, s68, s69, s70, (s71 == null ? "" : s71), u0, new b(w0, 5)));
                        }
                        arrayList0.add(new b0(arrayList16));
                    }
                    List list6 = albumContentsListRes$RESPONSE0.photoList;
                    if(list6 != null) {
                        boolean z7 = albumContentsListRes$RESPONSE0.photoAllButtonFlag;
                        ArrayList arrayList17 = new ArrayList(je.q.Q(10, list6));
                        for(Object object11: list6) {
                            arrayList17.add(new PhotoItem(((PHOTO)object11).photoId, "", null, null, null, 16, null));
                        }
                        ArrayList arrayList18 = new ArrayList();
                        int v8 = 0;
                        for(Object object12: list6) {
                            if(v8 >= 0) {
                                arrayList18.add(new P(((PHOTO)object12).photoId, ((PHOTO)object12).photoImg, arrayList17, ((PHOTO)object12), new F0(w0, v8, arrayList17, 26)));
                                ++v8;
                                continue;
                            }
                            e.k.O();
                            throw null;
                        }
                        arrayList0.add(new Jc.Q(arrayList18, new d(w0, 8), z7));
                    }
                }
            }
            SongInfoBase songInfoBase0 = albumInfoRes$RESPONSE0.titleSong;
            if(songInfoBase0 != null) {
                String s72 = songInfoBase0.songId;
                if(s72 != null && w0.t) {
                    w0.t = false;
                    w0.sendUiEvent(new A4(s72, (albumInfoRes$RESPONSE0.menuId == null ? "" : albumInfoRes$RESPONSE0.menuId), w0.getStatsElements()));
                }
            }
            com.iloen.melon.net.v6x.response.PromotionContentsBannerRes.RESPONSE promotionContentsBannerRes$RESPONSE0 = promotionContentsBannerRes0 == null ? null : promotionContentsBannerRes0.response;
            ALBUMINFO albumInfoRes$RESPONSE$ALBUMINFO0 = albumInfoRes$RESPONSE0.albumInfo;
            MILLIONSINFO albumInfoRes$RESPONSE$MILLIONSINFO0 = albumInfoRes$RESPONSE0.millionsinfo;
            OPENSPOTLIGHTINFO albumInfoRes$RESPONSE$OPENSPOTLIGHTINFO0 = albumInfoRes$RESPONSE0.openSpotLightInfo;
            OPENHIRISINGINFO albumInfoRes$RESPONSE$OPENHIRISINGINFO0 = albumInfoRes$RESPONSE0.openHiRisingInfo;
            TOTAVRGSCOREINFO albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0 = albumInfoRes$RESPONSE0.totAvrgScoreInfo;
            if(albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0 == null) {
                albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0 = null;
            }
            else {
                MutableStateFlow mutableStateFlow0 = w0.v;
                do {
                    Object object13 = mutableStateFlow0.getValue();
                    K4 k40 = (K4)object13;
                }
                while(!mutableStateFlow0.compareAndSet(object13, new Ic.y((albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0.totAvrgScore == null ? "" : albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0.totAvrgScore), (albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0.ptCpnMprco == null ? "" : albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0.ptCpnMprco))));
            }
            String s73 = albumInfoRes$RESPONSE$ALBUMINFO0 == null ? null : albumInfoRes$RESPONSE$ALBUMINFO0.albumName;
            String s74 = albumInfoRes$RESPONSE$ALBUMINFO0 == null ? null : albumInfoRes$RESPONSE$ALBUMINFO0.albumImg;
            String s75 = albumInfoRes$RESPONSE$ALBUMINFO0 == null ? null : albumInfoRes$RESPONSE$ALBUMINFO0.albumImgLarge;
            String s76 = albumInfoRes$RESPONSE$ALBUMINFO0 == null ? null : albumInfoRes$RESPONSE$ALBUMINFO0.issueDate;
            ArrayList arrayList19 = new ArrayList();
            if(albumInfoRes$RESPONSE$ALBUMINFO0 != null) {
                ArrayList arrayList20 = albumInfoRes$RESPONSE$ALBUMINFO0.artistList;
                if(arrayList20 != null) {
                    for(Object object14: arrayList20) {
                        String s77 = ((ArtistsInfoBase)object14).getArtistId();
                        String s78 = ((ArtistsInfoBase)object14).getArtistName();
                        String s79 = ((ArtistsInfoBase)object14).getArtistImg();
                        arrayList19.add(new o((s77 == null ? "" : s77), (s78 == null ? "" : s78), (s79 == null ? "" : s79)));
                    }
                }
            }
            Ic.n n0 = new Ic.n((s73 == null ? "" : s73), (s74 == null ? "" : s74), (s75 == null ? "" : s75), (s76 == null ? "" : s76), arrayList19);
            boolean z8 = kotlin.jvm.internal.q.b((albumInfoRes$RESPONSE$MILLIONSINFO0 == null ? null : albumInfoRes$RESPONSE$MILLIONSINFO0.isCounting), "Y");
            if(albumInfoRes$RESPONSE$MILLIONSINFO0 == null) {
                s80 = null;
            }
            else {
                LinkInfoBase linkInfoBase2 = albumInfoRes$RESPONSE$MILLIONSINFO0.link;
                s80 = linkInfoBase2 == null ? null : linkInfoBase2.linktype;
            }
            if(s80 == null) {
                s80 = "";
            }
            if(albumInfoRes$RESPONSE$MILLIONSINFO0 == null) {
                s81 = null;
            }
            else {
                LinkInfoBase linkInfoBase3 = albumInfoRes$RESPONSE$MILLIONSINFO0.link;
                s81 = linkInfoBase3 == null ? null : linkInfoBase3.linkurl;
            }
            if(s81 == null) {
                s81 = "";
            }
            Ic.u u1 = new Ic.u(s80, s81, "");
            String s82 = albumInfoRes$RESPONSE$MILLIONSINFO0 == null ? null : albumInfoRes$RESPONSE$MILLIONSINFO0.reachingInfo;
            if(albumInfoRes$RESPONSE$MILLIONSINFO0 == null) {
                s83 = null;
            }
            else {
                LinkInfoBase linkInfoBase4 = albumInfoRes$RESPONSE$MILLIONSINFO0.link;
                s83 = linkInfoBase4 == null ? null : linkInfoBase4.linktype;
            }
            if(s83 == null) {
                s83 = "";
            }
            if(albumInfoRes$RESPONSE$MILLIONSINFO0 == null) {
                s84 = null;
            }
            else {
                LinkInfoBase linkInfoBase5 = albumInfoRes$RESPONSE$MILLIONSINFO0.link;
                s84 = linkInfoBase5 == null ? null : linkInfoBase5.linkurl;
            }
            if(s84 == null) {
                s84 = "";
            }
            Ic.u u2 = new Ic.u(s83, s84, "");
            boolean z9 = kotlin.jvm.internal.q.b(albumInfoRes$RESPONSE0.spotLightButtonFlag, "Y");
            String s85 = albumInfoRes$RESPONSE$OPENSPOTLIGHTINFO0 == null ? null : albumInfoRes$RESPONSE$OPENSPOTLIGHTINFO0.spotlightSeq;
            if(s85 == null) {
                s85 = "";
            }
            if(albumInfoRes$RESPONSE$OPENSPOTLIGHTINFO0 == null) {
                s86 = null;
            }
            else {
                LinkInfoBase linkInfoBase6 = albumInfoRes$RESPONSE$OPENSPOTLIGHTINFO0.link;
                s86 = linkInfoBase6 == null ? null : linkInfoBase6.linktype;
            }
            if(s86 == null) {
                s86 = "";
            }
            if(albumInfoRes$RESPONSE$OPENSPOTLIGHTINFO0 == null) {
                s87 = null;
            }
            else {
                LinkInfoBase linkInfoBase7 = albumInfoRes$RESPONSE$OPENSPOTLIGHTINFO0.link;
                s87 = linkInfoBase7 == null ? null : linkInfoBase7.linkurl;
            }
            if(s87 == null) {
                s87 = "";
            }
            Ic.u u3 = new Ic.u(s86, s87, "");
            String s88 = albumInfoRes$RESPONSE$OPENSPOTLIGHTINFO0 == null ? null : albumInfoRes$RESPONSE$OPENSPOTLIGHTINFO0.buttonBgColor;
            if(s88 == null) {
                s88 = "";
            }
            String s89 = albumInfoRes$RESPONSE$OPENSPOTLIGHTINFO0 == null ? null : albumInfoRes$RESPONSE$OPENSPOTLIGHTINFO0.buttonFontColor;
            if(s89 == null) {
                s89 = "";
            }
            A a0 = new A(s85, u3, s88, s89);
            boolean z10 = kotlin.jvm.internal.q.b(albumInfoRes$RESPONSE0.hiRisingButtonFlag, "Y");
            String s90 = albumInfoRes$RESPONSE$OPENHIRISINGINFO0 == null ? null : albumInfoRes$RESPONSE$OPENHIRISINGINFO0.hiRisingSeq;
            if(s90 == null) {
                s90 = "";
            }
            if(albumInfoRes$RESPONSE$OPENHIRISINGINFO0 == null) {
                s91 = null;
            }
            else {
                LinkInfoBase linkInfoBase8 = albumInfoRes$RESPONSE$OPENHIRISINGINFO0.link;
                s91 = linkInfoBase8 == null ? null : linkInfoBase8.linktype;
            }
            if(s91 == null) {
                s91 = "";
            }
            if(albumInfoRes$RESPONSE$OPENHIRISINGINFO0 == null) {
                s92 = null;
            }
            else {
                LinkInfoBase linkInfoBase9 = albumInfoRes$RESPONSE$OPENHIRISINGINFO0.link;
                s92 = linkInfoBase9 == null ? null : linkInfoBase9.linkurl;
            }
            if(s92 == null) {
                s92 = "";
            }
            Ic.u u4 = new Ic.u(s91, s92, "");
            String s93 = albumInfoRes$RESPONSE$OPENHIRISINGINFO0 == null ? null : albumInfoRes$RESPONSE$OPENHIRISINGINFO0.buttonBgColor;
            if(s93 == null) {
                s93 = "";
            }
            String s94 = albumInfoRes$RESPONSE$OPENHIRISINGINFO0 == null ? null : albumInfoRes$RESPONSE$OPENHIRISINGINFO0.buttonFontColor;
            if(s94 == null) {
                s94 = "";
            }
            Ic.t t0 = new Ic.t(s90, u4, s93, s94);
            boolean z11 = albumInfoRes$RESPONSE0.isDolbyAtmos;
            boolean z12 = albumInfoRes$RESPONSE0.isMasterPiece;
            String s95 = albumInfoRes$RESPONSE0.albumFlacInfo == null ? "" : albumInfoRes$RESPONSE0.albumFlacInfo;
            String s96 = albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0 == null ? null : albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0.title;
            if(s96 == null) {
                s96 = "";
            }
            String s97 = albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0 == null ? null : albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0.text;
            if(s97 == null) {
                s97 = "";
            }
            v v9 = new v(s96, s97);
            String s98 = albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0 == null ? null : albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0.totAvrgScore;
            if(s98 == null) {
                s98 = "";
            }
            String s99 = albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0 == null ? null : albumInfoRes$RESPONSE$TOTAVRGSCOREINFO0.ptCpnMprco;
            if(s99 == null) {
                s99 = "";
            }
            x x0 = new x(v9, new Ic.y(s98, s99));
            ArrayList arrayList21 = new ArrayList();
            if(albumInfoRes$RESPONSE0.bookletImgList != null && !albumInfoRes$RESPONSE0.bookletImgList.isEmpty()) {
                ArrayList arrayList22 = albumInfoRes$RESPONSE0.bookletImgList;
                kotlin.jvm.internal.q.f(arrayList22, "bookletImgList");
                for(Object object15: arrayList22) {
                    String s100 = ((BOOKLETIMGLIST)object15).bookletImgUrl;
                    kotlin.jvm.internal.q.f(s100, "bookletImgUrl");
                    arrayList21.add(new Ic.q(s100));
                }
            }
            else if(albumInfoRes$RESPONSE$ALBUMINFO0 != null && (albumInfoRes$RESPONSE$ALBUMINFO0.albumImgLarge != null && albumInfoRes$RESPONSE$ALBUMINFO0.albumImgLarge.length() > 0)) {
                arrayList21.add(new Ic.q((albumInfoRes$RESPONSE$ALBUMINFO0.albumImgLarge == null ? "" : albumInfoRes$RESPONSE$ALBUMINFO0.albumImgLarge)));
            }
            String s101 = albumInfoRes$RESPONSE0.albumPrice == null ? "" : albumInfoRes$RESPONSE0.albumPrice;
            String s102 = albumInfoRes$RESPONSE0.albumPriceFlac16 == null ? "" : albumInfoRes$RESPONSE0.albumPriceFlac16;
            String s103 = albumInfoRes$RESPONSE0.albumPriceFlac24 == null ? "" : albumInfoRes$RESPONSE0.albumPriceFlac24;
            String s104 = albumInfoRes$RESPONSE0.albumMessage == null ? "" : albumInfoRes$RESPONSE0.albumMessage;
            if(promotionContentsBannerRes$RESPONSE0 == null) {
                promotionContentsBannerRes$RESPONSE$Banner0 = null;
            }
            else {
                ArrayList arrayList23 = promotionContentsBannerRes$RESPONSE0.banners;
                promotionContentsBannerRes$RESPONSE$Banner0 = arrayList23 == null ? null : ((Banner)p.m0(arrayList23));
            }
            String s105 = promotionContentsBannerRes$RESPONSE$Banner0 == null ? null : promotionContentsBannerRes$RESPONSE$Banner0.bannerSeq;
            boolean z13 = Cb.i.l(promotionContentsBannerRes$RESPONSE$Banner0);
            String s106 = promotionContentsBannerRes$RESPONSE$Banner0 == null ? null : promotionContentsBannerRes$RESPONSE$Banner0.imgUrl;
            String s107 = promotionContentsBannerRes$RESPONSE$Banner0 == null ? null : promotionContentsBannerRes$RESPONSE$Banner0.bgColor;
            String s108 = promotionContentsBannerRes$RESPONSE$Banner0 == null ? null : promotionContentsBannerRes$RESPONSE$Banner0.linktype;
            if(s108 == null) {
                s108 = "";
            }
            String s109 = promotionContentsBannerRes$RESPONSE$Banner0 == null ? null : promotionContentsBannerRes$RESPONSE$Banner0.linkurl;
            if(s109 == null) {
                s109 = "";
            }
            String s110 = promotionContentsBannerRes$RESPONSE$Banner0 == null ? null : promotionContentsBannerRes$RESPONSE$Banner0.scheme;
            if(s110 != null) {
                s = s110;
            }
            Ic.s s111 = new Ic.s(n0, z8, u1, (s82 == null ? "" : s82), u2, z9, a0, z10, t0, z11, z12, s95, x0, arrayList21, s101, s102, s103, s104, new Ic.p((s105 == null ? "" : s105), z13, (s106 == null ? "" : s106), (s107 == null ? "" : s107), new Ic.u(s108, s109, s)), new e(albumInfoRes$RESPONSE0, w0, 1));
            ArrayList arrayList24 = new ArrayList();
            for(Object object16: arrayList0) {
                if(!(((e0)object16) instanceof H)) {
                    arrayList24.add(object16);
                }
            }
            return new z(s111, arrayList0, arrayList24.size(), new e(albumInfoRes$RESPONSE0, w0, 0), new U3(1000, false, true, 0, new b(w0, 1)));
        }
        if(!(d10 instanceof a1)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return null;
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        return w.w(this, g10, ((oe.c)continuation0));
    }

    @Override  // Hc.i
    public final void onUserEvent(Pc.e e0) {
        String s = "";
        kotlin.jvm.internal.q.g(e0, "userEvent");
        super.onUserEvent(e0);
        String s1 = "onUserEvent() event: " + Cb.i.o(e0);
        LogU.debug$default(this.r, s1, null, false, 6, null);
        U3 u30 = null;
        if(e0 instanceof J) {
            u0.L(this, Dispatchers.getIO(), new wc.o(e0, null, this), 2);
            return;
        }
        if(e0 instanceof Ic.e0) {
            this.n(new Hc.P(((Ic.e0)e0).b, ((Ic.e0)e0).a));
            return;
        }
        if(e0 instanceof Ic.O) {
            u0.L(this, Dispatchers.getIO(), new wc.v(this, ((Ic.O)e0).a, null), 2);
            return;
        }
        if(e0 instanceof Ic.Q) {
            X x0 = ((Ic.Q)e0).a;
            LogU.debug$default(this.r, "selectItem() item: " + x0, null, false, 6, null);
            X x1 = x0 == null ? null : x0;
            if(x1 != null) {
                z z0 = this.t();
                if(z0 != null) {
                    boolean z1 = false;
                    List list0 = this.w.b(z0.b, x1);
                    if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                        for(Object object0: list0) {
                            e0 e00 = (e0)object0;
                            if((e00 instanceof Ud.h ? ((Ud.h)e00).isSelected() : false)) {
                                z1 = true;
                                break;
                            }
                        }
                    }
                    Object object1 = null;
                    ArrayList arrayList0 = p.Q0(list0);
                    for(Object object2: arrayList0) {
                        if(((e0)object2) instanceof W) {
                            object1 = object2;
                            break;
                        }
                    }
                    if(((e0)object1) != null) {
                        arrayList0.set(arrayList0.indexOf(((W)(((e0)object1)))), W.a(((W)(((e0)object1))), z1));
                    }
                    ArrayList arrayList1 = E9.h.W(arrayList0);
                    ArrayList arrayList2 = new ArrayList();
                    for(Object object3: arrayList1) {
                        if(((e0)object3) instanceof X && ((X)(((e0)object3))).M) {
                            arrayList2.add(object3);
                        }
                    }
                    U3 u31 = z0.e;
                    if(u31 != null) {
                        u30 = U3.a(u31, 0, !arrayList2.isEmpty(), arrayList2.size(), 21);
                    }
                    this.updateUiState(new m0(z0, arrayList0, u30, 3));
                }
            }
            if(x0.c != null && x0.c.length() != 0) {
                this.trackTiaraEventLog(new a(this, e0, 4));
            }
        }
        else {
            if(e0 instanceof Ic.c0) {
                u0.L(this, Dispatchers.getIO(), new wc.q(e0, null, this), 2);
                return;
            }
            if(e0 instanceof U) {
                Navigator.openAlbumInfo(this.p());
                this.trackTiaraEventLog(new a(this, e0, 5));
                return;
            }
            if(e0 instanceof Ic.T) {
                X x2 = ((Ic.T)e0).a;
                String s2 = x2.r;
                if(s2 != null) {
                    s = s2;
                }
                this.sendUiEvent(new A4(s, this.getMenuId(), this.getStatsElements()));
                if(x2.c != null && x2.c.length() != 0) {
                    this.trackTiaraEventLog(new a(this, e0, 8));
                }
            }
            else if(e0 instanceof Ic.S) {
                String s3 = this.getMenuId();
                this.sendUiEvent(new F4(((Ic.S)e0).a.a, s3));
                String s4 = ((Ic.S)e0).a.c;
                if(s4 != null && s4.length() != 0) {
                    this.trackTiaraEventLog(new a(this, e0, 9));
                }
            }
            else {
                StringProviderImpl stringProviderImpl0 = this.b;
                if(e0 instanceof Ic.H) {
                    String s5 = this.p();
                    Navigator.open(AlbumDetailContentsArtistNoteFragment.Companion.newInstance(s5));
                    p8.f f0 = this.h();
                    if(f0 != null) {
                        f0.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.y = stringProviderImpl0.a(0x7F130DE4);  // string:tiara_common_layer1_artist_note "아티스트노트"
                        f0.F = stringProviderImpl0.a(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f0.a().track();
                    }
                    return;
                }
                if(e0 instanceof Ic.B) {
                    String s6 = this.q();
                    B b0 = ((Ic.B)e0).a;
                    Navigator.INSTANCE.open(DetailContentsAlbumInfoFragment.Companion.newInstance(new AlbumInfoParam(s6, (b0.i == null ? "" : b0.i), b0.b, b0.c, b0.g, b0.a, b0.d, b0.e, b0.j)));
                    return;
                }
                if(e0 instanceof V) {
                    MelonLinkExecutor.open(ye.a.Z(((V)e0).a.g));
                    this.trackTiaraEventLog(new a(this, e0, 0));
                    return;
                }
                if(e0 instanceof I) {
                    MelonLinkExecutor.open(ye.a.Z(((I)e0).a.g));
                    this.trackTiaraEventLog(new a(this, e0, 1));
                    return;
                }
                if(e0 instanceof Ic.a0) {
                    String s7 = this.getMenuId();
                    Navigator.openMvInfo$default(((Ic.a0)e0).a.b, s7, null, false, 12, null);
                    this.trackTiaraEventLog(new a(this, e0, 2));
                    return;
                }
                if(e0 instanceof Ic.M) {
                    PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = PhotoInfoList.Companion.buildArtistInfoParams(((Ic.M)e0).a.c, false, ((Ic.M)e0).b, ((Ic.M)e0).a.c.size(), "");
                    Navigator.open(Companion.newInstance$default(PhotoDetailViewFragment.Companion, photoDetailViewFragment$PhotoInfoList0, false, false, 6, null));
                    p8.f f1 = this.h();
                    if(f1 != null) {
                        f1.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f1.d = ActionKind.ClickContent;
                        f1.y = stringProviderImpl0.a(0x7F130DDC);  // string:tiara_common_layer1_album_photo "이앨범의포토"
                        f1.e = ((Ic.M)e0).a.a;
                        f1.f = stringProviderImpl0.a(0x7F130F9C);  // string:tiara_photo_meta_type_photo "포토"
                        f1.a().track();
                    }
                    return;
                }
                if(e0 instanceof K) {
                    MelonLinkExecutor.open(MelonLinkInfo.b(((K)e0).a.f));
                    this.trackTiaraEventLog(new a(this, e0, 3));
                    return;
                }
                if(e0 instanceof Ic.b0) {
                    String s8 = this.p();
                    Navigator.open(AlbumDetailContentsMvFragment.Companion.newInstance(s8));
                    p8.f f2 = this.h();
                    if(f2 != null) {
                        f2.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f2.y = stringProviderImpl0.a(0x7F130DE1);  // string:tiara_common_layer1_album_video "이앨범의비디오"
                        f2.F = stringProviderImpl0.a(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f2.a().track();
                    }
                    return;
                }
                if(e0 instanceof Ic.N) {
                    String s9 = this.p();
                    Navigator.open(AlbumDetailContentsPhotoFragment.Companion.newInstance(s9));
                    p8.f f3 = this.h();
                    if(f3 != null) {
                        f3.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f3.y = stringProviderImpl0.a(0x7F130DDC);  // string:tiara_common_layer1_album_photo "이앨범의포토"
                        f3.F = stringProviderImpl0.a(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f3.a().track();
                    }
                    return;
                }
                if(e0 instanceof Ic.L) {
                    String s10 = this.p();
                    Navigator.open(AlbumDetailContentsMagazineFragment.Companion.newInstance(s10));
                    p8.f f4 = this.h();
                    if(f4 != null) {
                        f4.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f4.y = stringProviderImpl0.a(0x7F130DDA);  // string:tiara_common_layer1_album_magazine "이앨범의매거진"
                        f4.F = stringProviderImpl0.a(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f4.a().track();
                    }
                    return;
                }
                if(e0 instanceof Ic.C) {
                    Navigator.openAlbumInfo(((Ic.C)e0).a.b);
                    p8.f f5 = this.h();
                    if(f5 != null) {
                        f5.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f5.d = ActionKind.ClickContent;
                        f5.y = stringProviderImpl0.a(0x7F130DDB);  // string:tiara_common_layer1_album_other_version "이앨범의다른버전"
                        f5.C = String.valueOf(((Ic.C)e0).b + 1);
                        f5.a().track();
                    }
                    return;
                }
                if(e0 instanceof Ic.D) {
                    String s11 = this.getMenuId();
                    this.sendUiEvent(new Jc.y(((Ic.D)e0).a.b, s11));
                    p8.f f6 = this.h();
                    if(f6 != null) {
                        f6.a = stringProviderImpl0.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                        f6.d = ActionKind.PlayMusic;
                        f6.y = stringProviderImpl0.a(0x7F130DDB);  // string:tiara_common_layer1_album_other_version "이앨범의다른버전"
                        f6.C = String.valueOf(((Ic.D)e0).b + 1);
                        f6.a().track();
                    }
                    return;
                }
                if(e0 instanceof Ic.E) {
                    String s12 = this.p();
                    Navigator.open(AlbumDetailContentsOtherVerFragment.Companion.newInstance(s12));
                    p8.f f7 = this.h();
                    if(f7 != null) {
                        f7.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f7.y = stringProviderImpl0.a(0x7F130DDB);  // string:tiara_common_layer1_album_other_version "이앨범의다른버전"
                        f7.F = stringProviderImpl0.a(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f7.a().track();
                    }
                    return;
                }
                if(e0 instanceof Ic.F) {
                    Navigator.openAlbumInfo(((Ic.F)e0).a.b);
                    p8.f f8 = this.h();
                    if(f8 != null) {
                        f8.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f8.d = ActionKind.ClickContent;
                        f8.y = stringProviderImpl0.a(0x7F130DDD);  // string:tiara_common_layer1_album_series "이앨범의시리즈"
                        f8.C = String.valueOf(((Ic.F)e0).b + 1);
                        f8.a().track();
                    }
                    return;
                }
                if(e0 instanceof Ic.G) {
                    String s13 = this.getMenuId();
                    this.sendUiEvent(new Jc.z(((Ic.G)e0).a.b, s13));
                    p8.f f9 = this.h();
                    if(f9 != null) {
                        f9.a = stringProviderImpl0.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                        f9.d = ActionKind.PlayMusic;
                        f9.y = stringProviderImpl0.a(0x7F130DDD);  // string:tiara_common_layer1_album_series "이앨범의시리즈"
                        f9.C = String.valueOf(((Ic.G)e0).b + 1);
                        f9.a().track();
                    }
                    return;
                }
                if(e0 instanceof Ic.P) {
                    String s14 = this.p();
                    Navigator.open(AlbumDetailContentsSeriesFragment.Companion.newInstance(s14));
                    p8.f f10 = this.h();
                    if(f10 != null) {
                        f10.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f10.y = stringProviderImpl0.a(0x7F130DDD);  // string:tiara_common_layer1_album_series "이앨범의시리즈"
                        f10.F = stringProviderImpl0.a(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f10.a().track();
                    }
                    return;
                }
                if(e0 instanceof Ic.Z) {
                    FamilyAppHelper.getFamilyApp(v9.f.a).openApp(((Ic.Z)e0).a);
                    p8.f f11 = this.h();
                    if(f11 != null) {
                        f11.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f11.y = stringProviderImpl0.a(0x7F130E1E);  // string:tiara_common_layer1_ticket "티켓"
                        f11.B = ((Ic.Z)e0).a.b;
                        f11.a().track();
                    }
                    return;
                }
                if(e0 instanceof Ic.W) {
                    Navigator.INSTANCE.openCastEpisodeDetail(((Ic.W)e0).a);
                    this.trackTiaraEventLog(new a(this, e0, 6));
                    return;
                }
                if(e0 instanceof Ic.X) {
                    String s15 = this.getMenuId();
                    this.sendUiEvent(new z4(((Ic.X)e0).a, s15));
                    this.trackTiaraEventLog(new a(this, e0, 7));
                    return;
                }
                if(e0 instanceof Ic.Y) {
                    String s16 = this.p();
                    Navigator.INSTANCE.openAlbumStation(s16);
                    p8.f f12 = this.h();
                    if(f12 != null) {
                        f12.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f12.y = stringProviderImpl0.a(0x7F130DE0);  // string:tiara_common_layer1_album_station "이앨범의스테이션"
                        f12.F = stringProviderImpl0.a(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f12.a().track();
                    }
                    return;
                }
                if(e0 instanceof N3) {
                    T2.a a0 = f0.h(this);
                    boolean z2 = this.isLoginUser();
                    td.L l0 = new td.L(1, this, w.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 23);
                    L0 l00 = this.getProgressUpdater();
                    this.l.b(((N3)e0), a0, z2, l0, l00);
                    return;
                }
                if(e0 instanceof q3) {
                    T2.a a1 = f0.h(this);
                    boolean z3 = this.isLoginUser();
                    td.L l1 = new td.L(1, this, w.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 24);
                    L0 l01 = this.getProgressUpdater();
                    this.m.a(((q3)e0), a1, z3, l1, l01);
                    return;
                }
                if(e0 instanceof L2) {
                    T2.a a2 = f0.h(this);
                    boolean z4 = this.isLoginUser();
                    td.L l2 = new td.L(1, this, w.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 25);
                    L0 l02 = this.getProgressUpdater();
                    this.n.b(((L2)e0), a2, z4, l2, l02);
                    return;
                }
                if(e0 instanceof Ed.a) {
                    BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new wc.p(e0, null, this), 2, null);
                    return;
                }
                if(e0 instanceof com.melon.ui.q) {
                    T2.a a3 = f0.h(this);
                    td.L l3 = new td.L(1, this, w.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 26);
                    this.p.d(((com.melon.ui.q)e0), a3, l3);
                }
            }
        }
    }

    public final String p() {
        String s = this.s;
        if(s != null) {
            return s;
        }
        kotlin.jvm.internal.q.m("albumId");
        throw null;
    }

    public final String q() {
        z z0 = this.t();
        Ic.n n0 = z0 == null ? null : z0.a.a;
        return n0 == null ? "" : n0.a;
    }

    public static ArrayList r(w w0) {
        Iterable iterable0 = w0.u();
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            if(((X)object0).b) {
                arrayList0.add(object0);
            }
        }
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object1: arrayList0) {
            arrayList1.add(((X)object1).a);
        }
        return arrayList1;
    }

    public static Object s(w w0, String s, String s1, oe.c c0) {
        wc.h h0;
        if(c0 instanceof wc.h) {
            h0 = (wc.h)c0;
            int v = h0.B;
            if((v & 0x80000000) == 0) {
                h0 = new wc.h(w0, c0);
            }
            else {
                h0.B = v ^ 0x80000000;
            }
        }
        else {
            h0 = new wc.h(w0, c0);
        }
        Object object0 = h0.r;
        ne.a a0 = ne.a.a;
        switch(h0.B) {
            case 0: {
                d5.n.D(object0);
                LogU.info$default(w0.r, "getLikeUiState() contentsId: " + s + ", contentsTypeCode: " + s1, null, false, 6, null);
                kotlin.jvm.internal.q.f("N20001", "value");
                h0.B = 1;
                object0 = w0.j.h(s, s1, "N20001", h0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((Na.f)object0) instanceof Na.e) {
            Object object1 = ((Na.e)(((Na.f)object0))).a;
            j.b(((MyMusicLikeInformContentsLikeRes)object1).notification, false, 3);
            if(!j.d(((MyMusicLikeInformContentsLikeRes)object1))) {
                object1 = null;
            }
            if(((MyMusicLikeInformContentsLikeRes)object1) != null) {
                com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes.RESPONSE myMusicLikeInformContentsLikeRes$RESPONSE0 = ((MyMusicLikeInformContentsLikeRes)object1).response;
                if(myMusicLikeInformContentsLikeRes$RESPONSE0 != null) {
                    return new Hc.P(ProtocolUtils.parseInt(myMusicLikeInformContentsLikeRes$RESPONSE0.summcnt, 0), ProtocolUtils.parseBoolean(myMusicLikeInformContentsLikeRes$RESPONSE0.likeyn));
                }
            }
        }
        return J4.a;
    }

    public final z t() {
        Object object0 = this.getUiState().getValue();
        return object0 instanceof z ? ((z)object0) : null;
    }

    public final List u() {
        z z0 = this.t();
        if(z0 != null) {
            List list0 = new ArrayList();
            for(Object object0: z0.b) {
                if(object0 instanceof X) {
                    list0.add(object0);
                }
            }
            return list0;
        }
        return je.w.a;
    }

    public final boolean v() {
        Iterable iterable0 = this.u();
        if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
            return false;
        }
        for(Object object0: iterable0) {
            if(!((X)object0).b) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public static Object w(w w0, g1 g10, oe.c c0) {
        kotlin.jvm.internal.H h21;
        kotlin.jvm.internal.H h20;
        PromotionContentsBannerRes promotionContentsBannerRes3;
        AlbumContentsListRes albumContentsListRes3;
        AlbumSongListRes albumSongListRes8;
        Deferred deferred16;
        String s2;
        L0 l01;
        kotlin.jvm.internal.H h19;
        kotlin.jvm.internal.H h18;
        w w8;
        int v11;
        Object object6;
        AlbumSongListRes albumSongListRes4;
        PromotionContentsBannerRes promotionContentsBannerRes1;
        w w6;
        kotlin.jvm.internal.H h15;
        kotlin.jvm.internal.H h14;
        AlbumContentsListRes albumContentsListRes1;
        AlbumSongListRes albumSongListRes2;
        Deferred deferred13;
        kotlin.jvm.internal.H h11;
        kotlin.jvm.internal.H h10;
        w w4;
        int v9;
        Object object4;
        Deferred deferred12;
        int v8;
        Deferred deferred11;
        AlbumSongListRes albumSongListRes1;
        kotlin.jvm.internal.H h9;
        kotlin.jvm.internal.H h8;
        int v7;
        w w3;
        int v4;
        Deferred deferred10;
        kotlin.jvm.internal.H h5;
        int v3;
        Deferred deferred9;
        kotlin.jvm.internal.H h4;
        w w1;
        Deferred deferred5;
        int v2;
        int v1;
        kotlin.jvm.internal.H h3;
        Deferred deferred4;
        kotlin.jvm.internal.H h2;
        Deferred deferred3;
        Deferred deferred0;
        String s1;
        L0 l00;
        wc.i i0;
        CoroutineDispatcher coroutineDispatcher0 = w0.q;
        if(c0 instanceof wc.i) {
            i0 = (wc.i)c0;
            int v = i0.b0;
            if((v & 0x80000000) == 0) {
                i0 = new wc.i(w0, c0);
            }
            else {
                i0.b0 = v ^ 0x80000000;
            }
        }
        else {
            i0 = new wc.i(w0, c0);
        }
        Object object0 = i0.Y;
        ne.a a0 = ne.a.a;
        switch(i0.b0) {
            case 0: {
                d5.n.D(object0);
                String s = "onFetchStart() fetchType: " + Cb.i.o(g10);
                LogU.info$default(w0.r, s, null, false, 6, null);
                kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                kotlin.jvm.internal.H h1 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                l00 = w0.getProgressUpdater();
                s1 = "AlbumDetailViewModel";
                if(l00 == null) {
                    deferred0 = u0.j(w0, coroutineDispatcher0, new wc.k(w0, null), 2);
                    Deferred deferred1 = u0.j(w0, coroutineDispatcher0, new l(w0, null), 2);
                    Deferred deferred2 = u0.j(w0, coroutineDispatcher0, new wc.j(w0, null), 2);
                    deferred3 = u0.j(w0, coroutineDispatcher0, new m(w0, null), 2);
                    i0.r = w0;
                    i0.w = h0;
                    i0.B = h1;
                    i0.D = null;
                    i0.E = null;
                    i0.G = deferred0;
                    i0.I = deferred2;
                    i0.M = deferred3;
                    i0.W = 0;
                    i0.X = 0;
                    i0.b0 = 1;
                    Object object1 = deferred1.await(i0);
                    if(object1 == a0) {
                        return a0;
                    }
                    h2 = h1;
                    deferred4 = deferred2;
                    h3 = h0;
                    object0 = object1;
                    v1 = 0;
                    v2 = 0;
                    goto label_89;
                }
                else {
                    l00.a("AlbumDetailViewModel true", true);
                    try {
                        deferred5 = u0.j(w0, coroutineDispatcher0, new wc.k(w0, null), 2);
                        Deferred deferred6 = u0.j(w0, coroutineDispatcher0, new l(w0, null), 2);
                        Deferred deferred7 = u0.j(w0, coroutineDispatcher0, new wc.j(w0, null), 2);
                        Deferred deferred8 = u0.j(w0, coroutineDispatcher0, new m(w0, null), 2);
                        i0.r = w0;
                        i0.w = h0;
                        i0.B = h1;
                        i0.D = l00;
                        i0.E = "AlbumDetailViewModel";
                        i0.G = deferred5;
                        i0.I = deferred7;
                        i0.M = deferred8;
                        i0.W = 0;
                        i0.X = 0;
                        i0.b0 = 5;
                        Object object2 = deferred6.await(i0);
                        if(object2 == a0) {
                            return a0;
                        }
                        w1 = w0;
                        h4 = h0;
                        object0 = object2;
                        deferred9 = deferred7;
                        v3 = 0;
                        h5 = h1;
                        deferred10 = deferred8;
                        v4 = 0;
                        goto label_215;
                    }
                    catch(Throwable throwable0) {
                        k8.Y.v(s1, " false", l00, false);
                        throw throwable0;
                    }
                }
                break;
            }
            case 1: {
                int v5 = i0.X;
                int v6 = i0.W;
                deferred3 = i0.M;
                deferred4 = i0.I;
                deferred0 = i0.G;
                kotlin.jvm.internal.H h6 = i0.B;
                kotlin.jvm.internal.H h7 = i0.w;
                w w2 = i0.r;
                d5.n.D(object0);
                v1 = v6;
                w0 = w2;
                h3 = h7;
                h2 = h6;
                v2 = v5;
            label_89:
                AlbumSongListRes albumSongListRes0 = (AlbumSongListRes)E9.h.H(((Na.f)object0));
                i0.r = w0;
                i0.w = h3;
                i0.B = h2;
                i0.D = null;
                i0.E = null;
                i0.G = deferred0;
                i0.I = null;
                i0.M = deferred3;
                i0.N = albumSongListRes0;
                i0.W = v1;
                i0.X = v2;
                i0.b0 = 2;
                Object object3 = deferred4.await(i0);
                if(object3 == a0) {
                    return a0;
                }
                w3 = w0;
                v7 = v2;
                h8 = h2;
                h9 = h3;
                albumSongListRes1 = albumSongListRes0;
                object0 = object3;
                deferred11 = deferred3;
                v8 = v1;
                deferred12 = deferred0;
                goto label_123;
            }
            case 2: {
                v7 = i0.X;
                v8 = i0.W;
                albumSongListRes1 = i0.N;
                deferred11 = i0.M;
                deferred12 = i0.G;
                h8 = i0.B;
                h9 = i0.w;
                w3 = i0.r;
                d5.n.D(object0);
            label_123:
                AlbumContentsListRes albumContentsListRes0 = (AlbumContentsListRes)E9.h.H(((Na.f)object0));
                i0.r = w3;
                i0.w = h9;
                i0.B = h8;
                i0.D = null;
                i0.E = null;
                i0.G = deferred12;
                i0.I = null;
                i0.M = null;
                i0.N = albumSongListRes1;
                i0.S = albumContentsListRes0;
                i0.W = v8;
                i0.X = v7;
                i0.b0 = 3;
                object4 = deferred11.await(i0);
                if(object4 == a0) {
                    return a0;
                }
                v9 = v7;
                w4 = w3;
                h10 = h9;
                h11 = h8;
                deferred13 = deferred12;
                albumSongListRes2 = albumSongListRes1;
                albumContentsListRes1 = albumContentsListRes0;
                goto label_163;
            }
            case 3: {
                int v10 = i0.X;
                v8 = i0.W;
                albumContentsListRes1 = i0.S;
                AlbumSongListRes albumSongListRes3 = i0.N;
                Deferred deferred14 = i0.G;
                kotlin.jvm.internal.H h12 = i0.B;
                kotlin.jvm.internal.H h13 = i0.w;
                w w5 = i0.r;
                d5.n.D(object0);
                v9 = v10;
                w4 = w5;
                h10 = h13;
                h11 = h12;
                deferred13 = deferred14;
                albumSongListRes2 = albumSongListRes3;
                object4 = object0;
            label_163:
                PromotionContentsBannerRes promotionContentsBannerRes0 = (PromotionContentsBannerRes)E9.h.H(((Na.f)object4));
                i0.r = w4;
                i0.w = h10;
                i0.B = h11;
                i0.D = null;
                i0.E = null;
                i0.G = null;
                i0.I = null;
                i0.M = null;
                i0.N = albumSongListRes2;
                i0.S = albumContentsListRes1;
                i0.T = promotionContentsBannerRes0;
                i0.V = w4;
                i0.W = v8;
                i0.X = v9;
                i0.b0 = 4;
                object0 = deferred13.await(i0);
                if(object0 == a0) {
                    return a0;
                }
                h14 = h11;
                h15 = h10;
                w6 = w4;
                promotionContentsBannerRes1 = promotionContentsBannerRes0;
                albumSongListRes4 = albumSongListRes2;
                goto label_200;
            }
            case 4: {
                w4 = i0.V;
                PromotionContentsBannerRes promotionContentsBannerRes2 = i0.T;
                albumContentsListRes1 = i0.S;
                AlbumSongListRes albumSongListRes5 = i0.N;
                kotlin.jvm.internal.H h16 = i0.B;
                kotlin.jvm.internal.H h17 = i0.w;
                w w7 = i0.r;
                d5.n.D(object0);
                promotionContentsBannerRes1 = promotionContentsBannerRes2;
                albumSongListRes4 = albumSongListRes5;
                h14 = h16;
                w6 = w7;
                h15 = h17;
            label_200:
                K4 k40 = w4.handleDefaultHttpResponseResult(((Na.b)object0), new a3(h15, h14, albumSongListRes4, w6, albumContentsListRes1, promotionContentsBannerRes1, 9));
                if(k40 != null) {
                    w6.updateUiState(new hd.z1(k40, 9));
                }
                break;
            }
            case 5: {
                try {
                    v3 = i0.X;
                    v4 = i0.W;
                    deferred10 = i0.M;
                    deferred9 = i0.I;
                    deferred5 = i0.G;
                    s1 = i0.E;
                    l00 = i0.D;
                    h5 = i0.B;
                    h4 = i0.w;
                    w1 = i0.r;
                    d5.n.D(object0);
                label_215:
                    AlbumSongListRes albumSongListRes6 = (AlbumSongListRes)E9.h.H(((Na.f)object0));
                    i0.r = w1;
                    i0.w = h4;
                    i0.B = h5;
                    i0.D = l00;
                    i0.E = s1;
                    i0.G = deferred5;
                    i0.I = null;
                    i0.M = deferred10;
                    i0.N = albumSongListRes6;
                    i0.W = v4;
                    i0.X = v3;
                    i0.b0 = 6;
                    Object object5 = deferred9.await(i0);
                    if(object5 == a0) {
                        return a0;
                    }
                    Deferred deferred15 = deferred10;
                    AlbumSongListRes albumSongListRes7 = albumSongListRes6;
                    object0 = object5;
                    goto label_245;
                label_234:
                    v3 = i0.X;
                    v4 = i0.W;
                    albumSongListRes7 = i0.N;
                    deferred15 = i0.M;
                    deferred5 = i0.G;
                    s1 = i0.E;
                    l00 = i0.D;
                    h5 = i0.B;
                    h4 = i0.w;
                    w1 = i0.r;
                    d5.n.D(object0);
                label_245:
                    AlbumContentsListRes albumContentsListRes2 = (AlbumContentsListRes)E9.h.H(((Na.f)object0));
                    i0.r = w1;
                    i0.w = h4;
                    i0.B = h5;
                    i0.D = l00;
                    i0.E = s1;
                    i0.G = deferred5;
                    i0.I = null;
                    i0.M = null;
                    i0.N = albumSongListRes7;
                    i0.S = albumContentsListRes2;
                    i0.W = v4;
                    i0.X = v3;
                    i0.b0 = 7;
                    object6 = deferred15.await(i0);
                    if(object6 == a0) {
                        return a0;
                    }
                    v11 = v3;
                    w8 = w1;
                    h18 = h4;
                    h19 = h5;
                    l01 = l00;
                    s2 = s1;
                    deferred16 = deferred5;
                    albumSongListRes8 = albumSongListRes7;
                    albumContentsListRes3 = albumContentsListRes2;
                    goto label_285;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            }
            case 6: {
                goto label_234;
            }
            case 7: {
                try {
                    int v12 = i0.X;
                    v4 = i0.W;
                    albumContentsListRes3 = i0.S;
                    albumSongListRes8 = i0.N;
                    deferred16 = i0.G;
                    s2 = i0.E;
                    l01 = i0.D;
                    h19 = i0.B;
                    h18 = i0.w;
                    w w9 = i0.r;
                    d5.n.D(object0);
                    object6 = object0;
                    v11 = v12;
                    w8 = w9;
                label_285:
                    promotionContentsBannerRes3 = (PromotionContentsBannerRes)E9.h.H(((Na.f)object6));
                    i0.r = w8;
                    i0.w = h18;
                    i0.B = h19;
                    i0.D = l01;
                    i0.E = s2;
                    i0.G = null;
                    i0.I = null;
                    i0.M = null;
                    i0.N = albumSongListRes8;
                    i0.S = albumContentsListRes3;
                    i0.T = promotionContentsBannerRes3;
                    i0.V = w8;
                    i0.W = v4;
                    i0.X = v11;
                    i0.b0 = 8;
                    object0 = deferred16.await(i0);
                }
                catch(Throwable throwable0) {
                    s1 = s2;
                    l00 = l01;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                if(object0 == a0) {
                    return a0;
                }
                try {
                    s1 = s2;
                    l00 = l01;
                    h20 = h19;
                    h21 = h18;
                    w6 = w8;
                    K4 k41 = w8.handleDefaultHttpResponseResult(((Na.b)object0), new a3(h21, h20, albumSongListRes8, w8, albumContentsListRes3, promotionContentsBannerRes3, 9));
                    goto label_329;
                label_315:
                    w8 = i0.V;
                    PromotionContentsBannerRes promotionContentsBannerRes4 = i0.T;
                    albumContentsListRes3 = i0.S;
                    albumSongListRes8 = i0.N;
                    s1 = i0.E;
                    l00 = i0.D;
                    kotlin.jvm.internal.H h22 = i0.B;
                    kotlin.jvm.internal.H h23 = i0.w;
                    w w10 = i0.r;
                    d5.n.D(object0);
                    h20 = h22;
                    h21 = h23;
                    w6 = w10;
                    k41 = w8.handleDefaultHttpResponseResult(((Na.b)object0), new a3(h21, h20, albumSongListRes8, w10, albumContentsListRes3, promotionContentsBannerRes4, 9));
                label_329:
                    if(k41 != null) {
                        w6.updateUiState(new hd.z1(k41, 9));
                    }
                    goto label_331;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            }
            case 8: {
                goto label_315;
            label_331:
                k8.Y.v(s1, " false", l00, false);
                h15 = h21;
                h14 = h20;
                break;
            }
            case 9: {
                d5.n.D(object0);
                return ie.H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        w6.getClass();
        u0.L(w6, Dispatchers.getIO(), new Hc.d(w6, null), 2);
        i.j(w6, ((p8.g)w6.h()));
        String s3 = (String)h15.a;
        String s4 = "";
        if(s3 == null) {
            s3 = "";
        }
        String s5 = (String)h14.a;
        if(s5 != null) {
            s4 = s5;
        }
        i0.r = null;
        i0.w = null;
        i0.B = null;
        i0.D = null;
        i0.E = null;
        i0.G = null;
        i0.I = null;
        i0.M = null;
        i0.N = null;
        i0.S = null;
        i0.T = null;
        i0.V = null;
        i0.b0 = 9;
        if(w6.l(s3, s4) == a0) {
            try {
                return a0;
            }
            catch(Throwable throwable0) {
            }
            k8.Y.v(s1, " false", l00, false);
            throw throwable0;
        }
        return ie.H.a;
    }

    public final void x(boolean z) {
        ArrayList arrayList0 = w.r(this);
        if(!arrayList0.isEmpty()) {
            this.sendUiEvent(new B4(20, this.getMenuId(), arrayList0, z));
        }
        else if(this.v()) {
            ToastManager.show(0x7F13038A);  // string:empty_list_song "재생 가능한 곡이 없습니다."
        }
        p8.f f0 = this.h();
        if(f0 != null) {
            f0.a = this.b.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.d = ActionKind.PlayMusic;
            f0.y = this.b.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
            f0.F = this.b.a((z ? 0x7F130D9C : 0x7F130CF9));  // string:tiara_click_copy_shuffle_play "셔플재생"
            f0.a().track();
        }
    }

    public final void y(boolean z) {
        LogU.debug$default(this.r, "selectAll() select: " + z, null, false, 6, null);
        z z1 = this.t();
        if(z1 != null) {
            List list0 = this.w.a(z1.b, z);
            boolean z2 = false;
            if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                for(Object object0: list0) {
                    e0 e00 = (e0)object0;
                    if((e00 instanceof Ud.h ? ((Ud.h)e00).isSelected() : false)) {
                        z2 = true;
                        break;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            Object object1 = null;
            ArrayList arrayList0 = p.Q0(list0);
            for(Object object2: arrayList0) {
                if(((e0)object2) instanceof W) {
                    object1 = object2;
                    break;
                }
            }
            if(((e0)object1) != null) {
                arrayList0.set(arrayList0.indexOf(((W)(((e0)object1)))), W.a(((W)(((e0)object1))), z2));
            }
            this.updateUiState(new Ic.f0(z1, arrayList0, 2));
        }
    }
}

