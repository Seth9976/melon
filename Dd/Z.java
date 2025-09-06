package dd;

import Cc.U2;
import Uc.p;
import X0.u;
import X0.x;
import cd.G1;
import cd.H1;
import cd.I1;
import cd.J1;
import cd.K1;
import cd.Z0;
import cd.o2;
import cd.p2;
import cd.q2;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.DjApplyMainRes.RESPONSE.TAGLIST;
import com.iloen.melon.net.v5x.response.CastBrandDetailRes.RESPONSE.PROGRAMLIST;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.FOOTER;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.NEWALBUMS.ALBUM;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.POPULARSONG.CONTENTS;
import com.iloen.melon.net.v5x.response.ProgramBase.Cast;
import com.iloen.melon.net.v6x.response.BrandDetailMagazineListRes.RESPONSE.MAGAZINE.LINK;
import com.iloen.melon.net.v6x.response.BrandDetailMagazineListRes.RESPONSE.MAGAZINE;
import com.iloen.melon.net.v6x.response.BrandDetailMagazineListRes.RESPONSE;
import com.iloen.melon.net.v6x.response.BrandDetailVideoListRes.RESPONSE.VIDEOLIST;
import com.iloen.melon.net.v6x.response.DjBrandDetailRecmSongListRes.RESPONSE.RECMSONGLIST;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.ResourceUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.MusicDnaMainRes.RESPONSE.MYDNA.CARD;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.ui.K4;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.c1;
import com.melon.ui.d1;
import com.melon.ui.i;
import com.melon.ui.interfaces.StringProviderImpl;
import gd.A0;
import gd.B0;
import gd.B1;
import gd.C1;
import gd.D1;
import gd.D5;
import gd.E5;
import gd.F0;
import gd.F5;
import gd.P5;
import gd.V1;
import gd.b2;
import gd.c2;
import gd.c6;
import gd.d2;
import gd.e3;
import gd.f1;
import gd.f2;
import gd.g1;
import gd.g2;
import gd.h1;
import gd.h2;
import gd.h8;
import gd.i1;
import gd.j5;
import gd.l8;
import gd.n2;
import gd.r1;
import gd.r2;
import gd.s2;
import gd.t2;
import gd.u2;
import gd.u6;
import gd.y0;
import gd.y2;
import gd.z0;
import gd.z1;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import je.w;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.internal.TreeJsonEncoderKt;
import kotlinx.serialization.modules.SerializersModuleCollector.DefaultImpls;
import p8.b;
import p8.s;
import pc.l1;
import q8.a;
import q8.c;
import q8.f;
import va.e;
import we.k;

public final class z implements k {
    public final int a;
    public final Object b;

    public z(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        ArrayList arrayList7;
        String s14;
        String s5;
        w w0 = w.a;
        int v = 0;
        String s = "";
        H h0 = H.a;
        Object object1 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((Z0)object0), "userEvent");
                if(!(((Z0)object0) instanceof Z0)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                MelonLinkExecutor.open(MelonLinkInfo.b(((FOOTER)object1)));
                return h0;
            }
            case 1: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = ((ALBUM)object1) == null ? null : ((ALBUM)object1).albumId;
                ((f)object0).c = ((ALBUM)object1) == null ? null : ((ALBUM)object1).albumName;
                ((f)object0).b = Y.i(ContsTypeCode.ALBUM, "code(...)");
                ((f)object0).h = ProtocolUtils.getArtistNames((((ALBUM)object1) == null ? null : ((ALBUM)object1).artistList));
                return h0;
            }
            case 2: {
                q.g(((K1)object0), "userEvent");
                if(((K1)object0) instanceof I1) {
                    G1 g10 = ((I1)(((K1)object0))).a;
                    dd.H.e(((K)object1), g10.b.getContsId(), g10.b.getContsTypeCode(), null, 12);
                    String s2 = g10.b.getSongId() == null ? "" : g10.b.getSongId();
                    String s3 = g10.b.getSongName() == null ? "" : g10.b.getSongName();
                    String s4 = g10.b.getTypeTitle();
                    if(s4 != null) {
                        s = s4;
                    }
                    p p0 = dd.H.c(((K)object1), null, "", 0, g10.a, null, false, null, 0, null, 0x3F5);
                    p0.e(new U2(6, s2, s3, s));
                    p0.p().track();
                    return h0;
                }
                if(((K1)object0) instanceof J1) {
                    G1 g11 = ((J1)(((K1)object0))).a;
                    CONTENTS mainMusicRes$RESPONSE$POPULARSONG$CONTENTS0 = g11.b;
                    ArrayList arrayList0 = mainMusicRes$RESPONSE$POPULARSONG$CONTENTS0.getArtistList();
                    if(arrayList0 == null || arrayList0.size() != 1) {
                        s5 = null;
                    }
                    else {
                        ArrayList arrayList1 = mainMusicRes$RESPONSE$POPULARSONG$CONTENTS0.getArtistList();
                        if(arrayList1 == null) {
                            s5 = null;
                        }
                        else {
                            ArtistInfoBase artistInfoBase0 = (ArtistInfoBase)arrayList1.get(0);
                            s5 = artistInfoBase0 == null ? null : artistInfoBase0.getArtistId();
                        }
                    }
                    l1 l10 = new l1((mainMusicRes$RESPONSE$POPULARSONG$CONTENTS0.getSongId() == null ? "" : mainMusicRes$RESPONSE$POPULARSONG$CONTENTS0.getSongId()), (mainMusicRes$RESPONSE$POPULARSONG$CONTENTS0.getSongName() == null ? "" : mainMusicRes$RESPONSE$POPULARSONG$CONTENTS0.getSongName()), s5, ((K)object1).f);
                    s s6 = ((K)object1).b().b;
                    String s7 = s6 == null ? null : s6.c;
                    if(s7 == null) {
                        s7 = "";
                    }
                    ((K)object1).k(new i(s7, l10));
                    String s8 = mainMusicRes$RESPONSE$POPULARSONG$CONTENTS0.getSongId() == null ? "" : mainMusicRes$RESPONSE$POPULARSONG$CONTENTS0.getSongId();
                    String s9 = mainMusicRes$RESPONSE$POPULARSONG$CONTENTS0.getSongName() == null ? "" : mainMusicRes$RESPONSE$POPULARSONG$CONTENTS0.getSongName();
                    String s10 = mainMusicRes$RESPONSE$POPULARSONG$CONTENTS0.getTypeTitle();
                    if(s10 != null) {
                        s = s10;
                    }
                    p p1 = dd.H.c(((K)object1), ActionKind.PlayMusic, "", 0, g11.a, null, false, null, 0, "", 500);
                    p1.e(new U2(5, s8, s9, s));
                    c c0 = new c();
                    c0.b(new v(4));
                    ((LinkedHashMap)p1.g).putAll(c0.a);
                    p1.p().track();
                    return h0;
                }
                if(!(((K1)object0) instanceof H1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                G1 g12 = ((H1)(((K1)object0))).a;
                CONTENTS mainMusicRes$RESPONSE$POPULARSONG$CONTENTS1 = g12.b;
                String s11 = mainMusicRes$RESPONSE$POPULARSONG$CONTENTS1.getSongId();
                if(s11 == null) {
                    s11 = "";
                }
                String s12 = Y.i(ContsTypeCode.SONG, "code(...)");
                String s13 = mainMusicRes$RESPONSE$POPULARSONG$CONTENTS1.getSongName();
                dd.H.a(((K)object1), s11, g12.a, (mainMusicRes$RESPONSE$POPULARSONG$CONTENTS1.getSongId() == null ? "" : mainMusicRes$RESPONSE$POPULARSONG$CONTENTS1.getSongId()), s12, (s13 == null ? "" : s13), null, null, 0, null, 0x5D0);
                return h0;
            }
            case 3: {
                q.g(((q2)object0), "tabUserEvent");
                if(((q2)object0) instanceof o2) {
                    ((O)object1).getClass();
                    p p2 = dd.H.c(((O)object1), ActionKind.ClickContent, null, ((o2)(((q2)object0))).b, 0, null, false, null, 0, null, 0x3FA);
                    p2.e(new z(((o2)(((q2)object0))).a, 4));
                    p2.p().track();
                    return h0;
                }
                if(!(((q2)object0) instanceof p2)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS mainMusicRes$RESPONSE$TAG$CONTENTS0 = ((p2)(((q2)object0))).a;
                melonLinkInfo0.a = mainMusicRes$RESPONSE$TAG$CONTENTS0 == null ? null : mainMusicRes$RESPONSE$TAG$CONTENTS0.linktype;
                melonLinkInfo0.b = mainMusicRes$RESPONSE$TAG$CONTENTS0 == null ? null : mainMusicRes$RESPONSE$TAG$CONTENTS0.linkurl;
                melonLinkInfo0.c = mainMusicRes$RESPONSE$TAG$CONTENTS0 == null ? null : mainMusicRes$RESPONSE$TAG$CONTENTS0.scheme;
                MelonLinkExecutor.open(melonLinkInfo0);
                ((O)object1).getClass();
                p p3 = dd.H.c(((O)object1), null, null, ((p2)(((q2)object0))).b, 0, null, false, null, 0, null, 986);
                a a0 = (a)p3.d;
                if(a0 == null) {
                    a a1 = new a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
                    a1.a(new v(6));
                    p3.d = a1;
                }
                else {
                    a0.a(new v(6));
                }
                c c1 = new c();
                c1.c(new v(5));
                ((LinkedHashMap)p3.g).putAll(c1.a);
                p3.p().track();
                return h0;
            }
            case 4: {
                q.g(((f)object0), "$this$eventMeta");
                if(((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS)object1) == null) {
                    s14 = "";
                }
                else {
                    s14 = ((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS)object1).getTagSeq();
                    if(s14 == null) {
                        s14 = "";
                    }
                }
                ((f)object0).a = s14;
                if(((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS)object1) != null) {
                    String s15 = ((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS)object1).getTagName();
                    if(s15 != null) {
                        s = s15;
                    }
                }
                ((f)object0).g = s;
                return h0;
            }
            case 5: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = ((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS)object1).mvId;
                ((f)object0).b = "";
                ((f)object0).c = ((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS)object1).getTitle();
                return h0;
            }
            case 6: {
                q.g(((f)object0), "$this$eventMeta");
                DjPlayListInfoBase djPlayListInfoBase0 = ((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.WEEKLYDJ.CONTENTS)object1).getPlaylist();
                ((f)object0).a = djPlayListInfoBase0 == null ? null : djPlayListInfoBase0.plylstseq;
                DjPlayListInfoBase djPlayListInfoBase1 = ((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.WEEKLYDJ.CONTENTS)object1).getPlaylist();
                String s16 = djPlayListInfoBase1 == null ? null : djPlayListInfoBase1.contsTypeCode;
                if(s16 != null) {
                    s = s16;
                }
                ((f)object0).b = b.a(s);
                return h0;
            }
            case 7: {
                return ObjectSerializer.a(((ObjectSerializer)object1), ((ClassSerialDescriptorBuilder)object0));
            }
            case 8: {
                return PluginGeneratedSerialDescriptor.a(((PluginGeneratedSerialDescriptor)object1), ((int)(((Integer)object0))));
            }
            case 9: {
                return TripleSerializer.a(((TripleSerializer)object1), ((ClassSerialDescriptorBuilder)object0));
            }
            case 10: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                String s17 = ((ed.Z.a)object1).getString(0x7F130C2B);  // string:talkback_search_hotkeyword_collapse_btn "인기검색어 접기"
                q.f(s17, "getString(...)");
                u.h(((x)object0), s17);
                return h0;
            }
            case 11: {
                return TreeJsonEncoderKt.a(((kotlin.jvm.internal.H)object1), ((JsonElement)object0));
            }
            case 12: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), String.format("", Arrays.copyOf(new Object[]{((gd.v)object1).e}, 1)));
                return h0;
            }
            case 13: {
                if(((d1)object0) instanceof c1) {
                    RESPONSE brandDetailMagazineListRes$RESPONSE0 = (RESPONSE)((c1)(((d1)object0))).a;
                    ArrayList arrayList2 = brandDetailMagazineListRes$RESPONSE0.magazineList;
                    if(arrayList2 != null) {
                        w0 = new ArrayList(je.q.Q(10, arrayList2));
                        for(Object object2: arrayList2) {
                            if(v >= 0) {
                                String s18 = ((MAGAZINE)object2).mStorySeq;
                                String s19 = ((MAGAZINE)object2).mStoryTitle;
                                String s20 = ((MAGAZINE)object2).rsrvDate;
                                String s21 = ((MAGAZINE)object2).listImg;
                                LINK brandDetailMagazineListRes$RESPONSE$MAGAZINE$LINK0 = ((MAGAZINE)object2).link;
                                ((ArrayList)w0).add(new y0(s18, s19, s20, s21, (brandDetailMagazineListRes$RESPONSE$MAGAZINE$LINK0 == null ? null : brandDetailMagazineListRes$RESPONSE$MAGAZINE$LINK0.linktype), (brandDetailMagazineListRes$RESPONSE$MAGAZINE$LINK0 == null ? null : brandDetailMagazineListRes$RESPONSE$MAGAZINE$LINK0.linkurl)));
                                ++v;
                                continue;
                            }
                            e.k.O();
                            throw null;
                        }
                    }
                    ((F0)object1).a.d(w0, brandDetailMagazineListRes$RESPONSE0.hasMore);
                    return new B0(je.p.P0(((F0)object1).a.a));
                }
                if(((d1)object0) instanceof com.melon.ui.Z0) {
                    return new z0(((com.melon.ui.Z0)(((d1)object0))).a);
                }
                if(((d1)object0) instanceof a1) {
                    ((F0)object1).cancelFetch();
                    return null;
                }
                if(!(((d1)object0) instanceof b1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return new A0(((b1)(((d1)object0))).a);
            }
            case 14: {
                return gd.a1.c(((gd.a1)object1), ((d1)object0));
            }
            case 15: {
                q.g(((K4)object0), "it");
                return (i1)object1;
            }
            case 16: {
                if(((d1)object0) instanceof c1) {
                    com.iloen.melon.net.v6x.response.DjBrandRecommendArtistRes.RESPONSE djBrandRecommendArtistRes$RESPONSE0 = (com.iloen.melon.net.v6x.response.DjBrandRecommendArtistRes.RESPONSE)((c1)(((d1)object0))).a;
                    ArrayList arrayList3 = djBrandRecommendArtistRes$RESPONSE0.contentsList;
                    if(arrayList3 != null) {
                        w0 = new ArrayList(je.q.Q(10, arrayList3));
                        for(Object object3: arrayList3) {
                            ((ArrayList)w0).add(new f1(((ArtistsInfoBase)object3).getArtistId(), ((ArtistsInfoBase)object3).getArtistName(), q.b("N", "Y") || q.b("N", "N"), ((ArtistsInfoBase)object3).getArtistImg(), q.b("N", "Y")));
                        }
                    }
                    ((r1)object1).j = je.p.q0(w0, ",", null, null, new ed.s(13), 30);
                    Boolean boolean0 = djBrandRecommendArtistRes$RESPONSE0.hasMore;
                    q.f(boolean0, "hasMore");
                    ((r1)object1).a.d(w0, boolean0.booleanValue());
                    return new i1(je.p.P0(((r1)object1).a.a));
                }
                if(((d1)object0) instanceof com.melon.ui.Z0) {
                    return new g1(((com.melon.ui.Z0)(((d1)object0))).a);
                }
                if(((d1)object0) instanceof a1) {
                    ((r1)object1).cancelFetch();
                    return null;
                }
                if(!(((d1)object0) instanceof b1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return new h1(((b1)(((d1)object0))).a);
            }
            case 17: {
                if(((d1)object0) instanceof c1) {
                    com.iloen.melon.net.v6x.response.DjBrandDetailRecmSongListRes.RESPONSE djBrandDetailRecmSongListRes$RESPONSE0 = (com.iloen.melon.net.v6x.response.DjBrandDetailRecmSongListRes.RESPONSE)((c1)(((d1)object0))).a;
                    ArrayList arrayList4 = djBrandDetailRecmSongListRes$RESPONSE0.recmSongList;
                    if(arrayList4 != null) {
                        w0 = new ArrayList(je.q.Q(10, arrayList4));
                        for(Object object4: arrayList4) {
                            ((ArrayList)w0).add(new z1(((RECMSONGLIST)object4).songId, ((RECMSONGLIST)object4).songName, ProtocolUtils.getArtistNames(((RECMSONGLIST)object4).artistList), ((RECMSONGLIST)object4).albumId, ((RECMSONGLIST)object4).albumImg, ((RECMSONGLIST)object4).canService, ((RECMSONGLIST)object4).isAdult, ((RECMSONGLIST)object4).isFree, ((RECMSONGLIST)object4).isHoldback, ((RECMSONGLIST)object4), false, false));
                        }
                    }
                    boolean z = djBrandDetailRecmSongListRes$RESPONSE0.hasMore;
                    Pc.b b0 = ((V1)object1).a;
                    b0.d(w0, z);
                    String s22 = djBrandDetailRecmSongListRes$RESPONSE0.songCount == null || djBrandDetailRecmSongListRes$RESPONSE0.songCount.length() == 0 ? "" : e.h(djBrandDetailRecmSongListRes$RESPONSE0.songCount, ((V1)object1).g.a(0x7F130A63));  // string:song "곡"
                    String s23 = djBrandDetailRecmSongListRes$RESPONSE0.playTime;
                    if(s23 != null) {
                        s = s23;
                    }
                    return new D1(je.p.P0(b0.a), false, s22, s);
                }
                if(((d1)object0) instanceof com.melon.ui.Z0) {
                    return new B1(((com.melon.ui.Z0)(((d1)object0))).a);
                }
                if(((d1)object0) instanceof a1) {
                    ((V1)object1).cancelFetch();
                    return null;
                }
                if(!(((d1)object0) instanceof b1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return new C1(((b1)(((d1)object0))).a);
            }
            case 18: {
                if(((d1)object0) instanceof c1) {
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = ((com.iloen.melon.net.v5x.response.CastBrandDetailRes.RESPONSE)((c1)(((d1)object0))).a).programList;
                    if(arrayList6 != null) {
                        if(arrayList6.size() == 1) {
                            arrayList5.add(new d2(((PROGRAMLIST)je.p.k0(arrayList6)).progSeq, ((PROGRAMLIST)je.p.k0(arrayList6)).progTitle));
                            List list0 = ((PROGRAMLIST)je.p.k0(arrayList6)).castList;
                            if(list0 != null) {
                                for(Object object5: list0) {
                                    if(v >= 0) {
                                        String s24 = ((Cast)object5).castSeq;
                                        String s25 = ((Cast)object5).castTitle;
                                        String s26 = ((Cast)object5).castDate;
                                        String s27 = ((Cast)object5).verticalImgUrl;
                                        arrayList5.add(new b2(s24, s25, s26, (s27 == null || s27.length() <= 0 ? ((Cast)object5).castImgUrl : ((Cast)object5).verticalImgUrl)));
                                        ++v;
                                        continue;
                                    }
                                    e.k.O();
                                    throw null;
                                }
                            }
                        }
                        else {
                            for(Object object6: arrayList6) {
                                if(v >= 0) {
                                    String s28 = ((PROGRAMLIST)object6).progSeq;
                                    String s29 = ((PROGRAMLIST)object6).progTitle;
                                    boolean z1 = ((PROGRAMLIST)object6).moreData;
                                    List list1 = ((PROGRAMLIST)object6).castList;
                                    if(list1 == null) {
                                        arrayList7 = w0;
                                    }
                                    else {
                                        Iterable iterable0 = je.p.K0(3, list1);
                                        arrayList7 = new ArrayList(je.q.Q(10, iterable0));
                                        for(Object object7: iterable0) {
                                            Cast programBase$Cast0 = (Cast)object7;
                                            arrayList7.add(new b2(programBase$Cast0.castSeq, programBase$Cast0.castTitle, programBase$Cast0.castDate, (programBase$Cast0.verticalImgUrl == null || programBase$Cast0.verticalImgUrl.length() <= 0 ? programBase$Cast0.castImgUrl : programBase$Cast0.verticalImgUrl)));
                                        }
                                    }
                                    arrayList5.add(new c2(arrayList7, z1, s28, s29));
                                    ++v;
                                    continue;
                                }
                                e.k.O();
                                throw null;
                            }
                        }
                    }
                    return new h2(arrayList5);
                }
                if(((d1)object0) instanceof com.melon.ui.Z0) {
                    return new f2(((com.melon.ui.Z0)(((d1)object0))).a);
                }
                if(((d1)object0) instanceof a1) {
                    ((n2)object1).cancelFetch();
                    return null;
                }
                if(!(((d1)object0) instanceof b1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return new g2(((b1)(((d1)object0))).a);
            }
            case 19: {
                if(((d1)object0) instanceof c1) {
                    com.iloen.melon.net.v6x.response.BrandDetailVideoListRes.RESPONSE brandDetailVideoListRes$RESPONSE0 = (com.iloen.melon.net.v6x.response.BrandDetailVideoListRes.RESPONSE)((c1)(((d1)object0))).a;
                    ArrayList arrayList8 = brandDetailVideoListRes$RESPONSE0.videoList;
                    if(arrayList8 != null) {
                        w0 = new ArrayList(je.q.Q(10, arrayList8));
                        for(Object object8: arrayList8) {
                            if(v >= 0) {
                                String s30 = ((VIDEOLIST)object8).mvId;
                                String s31 = ((VIDEOLIST)object8).mvName;
                                String s32 = ((VIDEOLIST)object8).issueDate;
                                String s33 = ((VIDEOLIST)object8).mv169Img;
                                int v1 = ResourceUtils.getMvAdultGradeIcon(((VIDEOLIST)object8).adultGrade);
                                String s34 = ((VIDEOLIST)object8).playTime;
                                if(s34 == null) {
                                    s34 = "";
                                }
                                String s35 = Cb.k.f(s34);
                                StringProviderImpl stringProviderImpl0 = ((y2)object1).d;
                                String s36 = ((VIDEOLIST)object8).mvName;
                                String s37 = stringProviderImpl0.a(0x7F130AD2);  // string:talkback_artist "아티스트"
                                String s38 = ((VIDEOLIST)object8).getArtistNames();
                                String s39 = Cb.k.e(((VIDEOLIST)object8).playTime);
                                StringBuilder stringBuilder0 = new StringBuilder(U4.x.m(com.iloen.melon.utils.a.o(s36, ", ", s37, ": ", s38), ", ", s39));
                                if("19".equals(((VIDEOLIST)object8).adultGrade)) {
                                    stringBuilder0.append(", ");
                                    stringBuilder0.append(stringProviderImpl0.a(0x7F130B3D));  // string:talkback_grade_19 "19세 미만 청소년 이용불가 콘텐츠"
                                }
                                stringBuilder0.append(", ");
                                stringBuilder0.append(stringProviderImpl0.a(0x7F130B19));  // string:talkback_do_play "재생하기"
                                String s40 = stringBuilder0.toString();
                                q.f(s40, "toString(...)");
                                String s41 = stringProviderImpl0.b(0x7F130BA8, new Object[]{brandDetailVideoListRes$RESPONSE0.videoList.size(), ((int)(v + 1))});  // string:talkback_number_out_of_number "%1$d개중 %2$d번째"
                                String s42 = ((VIDEOLIST)object8).contstypecode;
                                com.iloen.melon.net.v6x.response.BrandDetailVideoListRes.RESPONSE.VIDEOLIST.LINK brandDetailVideoListRes$RESPONSE$VIDEOLIST$LINK0 = ((VIDEOLIST)object8).link;
                                ((ArrayList)w0).add(new r2(s30, s31, s32, s33, v1, s35, s40, s41, s42, (brandDetailVideoListRes$RESPONSE$VIDEOLIST$LINK0 == null ? null : brandDetailVideoListRes$RESPONSE$VIDEOLIST$LINK0.linktype), (brandDetailVideoListRes$RESPONSE$VIDEOLIST$LINK0 == null ? null : brandDetailVideoListRes$RESPONSE$VIDEOLIST$LINK0.linkurl)));
                                ++v;
                                continue;
                            }
                            e.k.O();
                            throw null;
                        }
                    }
                    ((y2)object1).a.d(w0, brandDetailVideoListRes$RESPONSE0.hasMore);
                    return new u2(je.p.P0(((y2)object1).a.a));
                }
                if(((d1)object0) instanceof com.melon.ui.Z0) {
                    return new s2(((com.melon.ui.Z0)(((d1)object0))).a);
                }
                if(((d1)object0) instanceof a1) {
                    ((y2)object1).cancelFetch();
                    return null;
                }
                if(!(((d1)object0) instanceof b1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return new t2(((b1)(((d1)object0))).a);
            }
            case 20: {
                return e3.c(((e3)object1), ((d1)object0));
            }
            case 21: {
                K4 k40 = (K4)object0;
                String s43 = ((com.iloen.melon.net.v4x.response.DjApplyMainRes.RESPONSE)object1).content;
                String s44 = ((com.iloen.melon.net.v4x.response.DjApplyMainRes.RESPONSE)object1).thumbImg;
                String s45 = ((com.iloen.melon.net.v4x.response.DjApplyMainRes.RESPONSE)object1).plylstTitle;
                String s46 = ((com.iloen.melon.net.v4x.response.DjApplyMainRes.RESPONSE)object1).memberNickName;
                String s47 = ((com.iloen.melon.net.v4x.response.DjApplyMainRes.RESPONSE)object1).plylstSeq;
                ArrayList arrayList9 = ((com.iloen.melon.net.v4x.response.DjApplyMainRes.RESPONSE)object1).tagList;
                if(arrayList9 != null) {
                    w0 = new ArrayList(je.q.Q(10, arrayList9));
                    for(Object object9: arrayList9) {
                        String s48 = ((TAGLIST)object9).tagSeq;
                        if(s48 == null) {
                            s48 = "";
                        }
                        String s49 = ((TAGLIST)object9).tagName;
                        if(s49 == null) {
                            s49 = "";
                        }
                        ((ArrayList)w0).add(new m(s48, s49));
                    }
                }
                return new j5(s43, s44, s47, s45, s46, w0, true);
            }
            case 22: {
                if(((d1)object0) instanceof c1) {
                    com.iloen.melon.net.v4x.response.DjApplyMainRes.RESPONSE djApplyMainRes$RESPONSE0 = (com.iloen.melon.net.v4x.response.DjApplyMainRes.RESPONSE)((c1)(((d1)object0))).a;
                    String s50 = djApplyMainRes$RESPONSE0.myPageImg;
                    String s51 = djApplyMainRes$RESPONSE0.memberNickName;
                    String s52 = djApplyMainRes$RESPONSE0.myPageDesc;
                    String s53 = djApplyMainRes$RESPONSE0.thumbImg;
                    String s54 = djApplyMainRes$RESPONSE0.plylstSeq;
                    String s55 = djApplyMainRes$RESPONSE0.plylstTitle;
                    ArrayList arrayList10 = djApplyMainRes$RESPONSE0.tagList;
                    if(arrayList10 != null) {
                        w0 = new ArrayList(je.q.Q(10, arrayList10));
                        for(Object object10: arrayList10) {
                            String s56 = ((TAGLIST)object10).tagSeq;
                            if(s56 == null) {
                                s56 = "";
                            }
                            String s57 = ((TAGLIST)object10).tagName;
                            if(s57 == null) {
                                s57 = "";
                            }
                            ((ArrayList)w0).add(new m(s56, s57));
                        }
                    }
                    return new F5(s50, s51, s52, s53, s54, w0, s55);
                }
                if(((d1)object0) instanceof com.melon.ui.Z0) {
                    return new D5(((com.melon.ui.Z0)(((d1)object0))).a);
                }
                if(((d1)object0) instanceof a1) {
                    ((P5)object1).cancelFetch();
                    return null;
                }
                if(!(((d1)object0) instanceof b1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return new E5(((b1)(((d1)object0))).a);
            }
            case 23: {
                K4 k41 = (K4)object0;
                return (D5)object1;
            }
            case 24: {
                q.g(((K4)object0), "it");
                return (c6)object1;
            }
            case 25: {
                q.g(((K4)object0), "it");
                return (u6)object1;
            }
            case 26: {
                q.g(((x)object0), "$this$semantics");
                String s58 = ((h8)object1).b;
                if(s58 != null) {
                    s = s58;
                }
                u.h(((x)object0), s);
                return h0;
            }
            case 27: {
                q.g(((K4)object0), "it");
                return (l8)object1;
            }
            case 28: {
                return DefaultImpls.a(((KSerializer)object1), ((List)object0));
            }
            default: {
                q.g(((x)object0), "$this$semantics");
                String s1 = ((CARD)object1).title + "," + ((CARD)object1).subTitle + "," + ((CARD)object1).desc;
                q.f(s1, "toString(...)");
                u.h(((x)object0), s1);
                return h0;
            }
        }
    }
}

