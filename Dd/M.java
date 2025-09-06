package dd;

import cd.I2;
import cd.J2;
import cd.K2;
import cd.c1;
import cd.d1;
import cd.e0;
import cd.e1;
import cd.e2;
import cd.f0;
import cd.f2;
import cd.g0;
import cd.g2;
import cd.h2;
import cd.r0;
import cd.s0;
import cd.t0;
import com.iloen.melon.fragments.artistchannel.ArtistPickFragment.Companion;
import com.iloen.melon.fragments.artistchannel.ArtistPickFragment;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINECONTENT;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAGCONTENTS;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import f;
import g;
import h;
import i.n.i.b.a.s.e.M3;
import i;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.q;
import p8.b;
import q8.a;
import q8.c;
import we.k;

public final class m implements k {
    public final int a;
    public final Serializable b;
    public final int c;
    public final Object d;
    public final int e;
    public final Object f;

    public m(Content flexibleRes$RESPONSE$Flexible$Content0, H h0, int v, String s, int v1, int v2) {
        this.a = v2;
        this.b = flexibleRes$RESPONSE$Flexible$Content0;
        this.f = h0;
        this.c = v;
        this.d = s;
        this.e = v1;
        super();
    }

    public m(MAGAZINECONTENT mainMusicRes$RESPONSE$MAGAZINECONTENT0, C c0, int v, int v1, MAGAZINE mainMusicRes$RESPONSE$MAGAZINE0) {
        this.a = 5;
        super();
        this.f = mainMusicRes$RESPONSE$MAGAZINECONTENT0;
        this.d = c0;
        this.c = v;
        this.e = v1;
        this.b = mainMusicRes$RESPONSE$MAGAZINE0;
    }

    public m(H h0, Content flexibleRes$RESPONSE$Flexible$Content0, int v, String s, int v1, int v2) {
        this.a = v2;
        this.f = h0;
        this.b = flexibleRes$RESPONSE$Flexible$Content0;
        this.c = v;
        this.d = s;
        this.e = v1;
        super();
    }

    public m(O o0, int v, int v1, TAGCONTENTS mainMusicRes$RESPONSE$TAGCONTENTS0, CONTENTS mainMusicRes$RESPONSE$TAG$CONTENTS0) {
        this.a = 6;
        super();
        this.f = o0;
        this.c = v;
        this.e = v1;
        this.d = mainMusicRes$RESPONSE$TAGCONTENTS0;
        this.b = mainMusicRes$RESPONSE$TAG$CONTENTS0;
    }

    public m(V v0, com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS mainMusicRes$RESPONSE$VIDEO$CONTENTS0, VIDEO mainMusicRes$RESPONSE$VIDEO0, int v1, int v2) {
        this.a = 7;
        super();
        this.f = v0;
        this.d = mainMusicRes$RESPONSE$VIDEO$CONTENTS0;
        this.b = mainMusicRes$RESPONSE$VIDEO0;
        this.c = v1;
        this.e = v2;
    }

    public m(n n0, int v, String s, int v1, Content flexibleRes$RESPONSE$Flexible$Content0) {
        this.a = 0;
        super();
        this.f = n0;
        this.c = v;
        this.d = s;
        this.e = v1;
        this.b = flexibleRes$RESPONSE$Flexible$Content0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s = null;
        String s1 = "";
        ie.H h0 = ie.H.a;
        Serializable serializable0 = this.b;
        Object object1 = this.d;
        Object object2 = this.f;
        switch(this.a) {
            case 0: {
                q.g(((g0)object0), "userEvent");
                if(((g0)object0) instanceof e0) {
                    Content flexibleRes$RESPONSE$Flexible$Content0 = ((e0)(((g0)object0))).a.a;
                    MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                    melonLinkInfo0.a = flexibleRes$RESPONSE$Flexible$Content0.getLinkType();
                    melonLinkInfo0.b = flexibleRes$RESPONSE$Flexible$Content0.getLinkUrl();
                    melonLinkInfo0.c = flexibleRes$RESPONSE$Flexible$Content0.getScheme();
                    H.e(((n)object2), "", "", melonLinkInfo0, 8);
                    H.m(((n)object2), flexibleRes$RESPONSE$Flexible$Content0, this.c, ((String)object1), this.e, false, null, null, 0, null, null, 0x3E0);
                    return h0;
                }
                if(!(((g0)object0) instanceof f0)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                H.a(((n)object2), "", 0, null, null, null, null, null, 0, null, 0x7FC);
                return h0;
            }
            case 1: {
                q.g(((t0)object0), "userEvent");
                int v2 = this.c;
                if(((t0)object0) instanceof r0) {
                    List list0 = ((Content)serializable0).getImgList();
                    if(list0 != null) {
                        s = list0.isEmpty() ? "" : ((String)list0.get(0));
                    }
                    H.m(((p)object2), ((Content)serializable0), v2, ((String)object1), this.e, false, null, null, 0, (s == null ? "" : s), "", 0xE0);
                    MelonLinkInfo melonLinkInfo1 = new MelonLinkInfo();
                    melonLinkInfo1.a = ((Content)serializable0).getLinkType();
                    melonLinkInfo1.b = ((Content)serializable0).getLinkUrl();
                    melonLinkInfo1.c = ((Content)serializable0).getScheme();
                    H.e(((p)object2), "", "", melonLinkInfo1, 8);
                    return h0;
                }
                if(!(((t0)object0) instanceof s0)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                H.a(((p)object2), "", v2, null, null, null, null, null, 0, null, 0x7FC);
                return h0;
            }
            case 2: {
                q.g(((i)object0), "userEvent");
                int v3 = this.c;
                if(((i)object0) instanceof f) {
                    MelonLinkInfo melonLinkInfo2 = new MelonLinkInfo();
                    melonLinkInfo2.a = ((Content)serializable0).getLinkType();
                    melonLinkInfo2.b = ((Content)serializable0).getLinkUrl();
                    melonLinkInfo2.c = ((Content)serializable0).getScheme();
                    H.e(((r)object2), "", "", melonLinkInfo2, 8);
                    boolean z = q.b("", "N10096");
                    H.m(((r)object2), ((Content)serializable0), v3, ((String)object1), this.e, z, null, null, 0, null, null, 0x3E0);
                    return h0;
                }
                if(((i)object0) instanceof g) {
                    H.a(((r)object2), "", v3, null, null, null, null, null, 0, null, 0x7FC);
                }
                return h0;
            }
            case 3: {
                q.g(((i)object0), "userEvent");
                int v4 = this.c;
                int v5 = this.e;
                if(((i)object0) instanceof f) {
                    if(q.b("N10091", "")) {
                        String s5 = ((Content)serializable0).getScheme();
                        if(s5 == null || s5.length() == 0) {
                            String s6 = ((Content)serializable0).getArtistId();
                            if(s6 != null) {
                                Navigator.open(Companion.newInstance$default(ArtistPickFragment.Companion, s6, null, null, 6, null));
                            }
                        }
                        else {
                            MelonLinkInfo melonLinkInfo3 = new MelonLinkInfo();
                            melonLinkInfo3.a = ((Content)serializable0).getLinkType();
                            melonLinkInfo3.b = ((Content)serializable0).getLinkUrl();
                            melonLinkInfo3.c = ((Content)serializable0).getScheme();
                            H.e(((t)object2), "", "", melonLinkInfo3, 8);
                        }
                    }
                    else {
                        MelonLinkInfo melonLinkInfo4 = new MelonLinkInfo();
                        melonLinkInfo4.a = ((Content)serializable0).getLinkType();
                        melonLinkInfo4.b = ((Content)serializable0).getLinkUrl();
                        melonLinkInfo4.c = ((Content)serializable0).getScheme();
                        H.e(((t)object2), "", "", melonLinkInfo4, 8);
                    }
                    H.m(((t)object2), ((Content)serializable0), v4, ((String)object1), v5, q.b("", "N10096"), null, null, 0, null, null, 0x3E0);
                    return h0;
                }
                if(((i)object0) instanceof h) {
                    H.i(((t)object2), "", "", "", "");
                    H.m(((t)object2), ((Content)serializable0), v4, ((String)object1), v5, true, null, null, 0, null, null, 0x3E0);
                    return h0;
                }
                if(((i)object0) instanceof g) {
                    String s7 = b.a("");
                    String s8 = ((Content)serializable0).getTitle();
                    H.a(((t)object2), "", v4, "", s7, (s8 == null ? "" : s8), null, null, 0, null, 2000);
                }
                return h0;
            }
            case 4: {
                q.g(((i)object0), "userEvent");
                int v6 = this.c;
                int v7 = this.e;
                if(((i)object0) instanceof f) {
                    if(q.b("N10091", "")) {
                        String s9 = ((Content)serializable0).getScheme();
                        if(s9 == null || s9.length() == 0) {
                            String s10 = ((Content)serializable0).getArtistId();
                            if(s10 != null) {
                                Navigator.open(Companion.newInstance$default(ArtistPickFragment.Companion, s10, null, null, 6, null));
                            }
                        }
                        else {
                            MelonLinkInfo melonLinkInfo5 = new MelonLinkInfo();
                            melonLinkInfo5.a = ((Content)serializable0).getLinkType();
                            melonLinkInfo5.b = ((Content)serializable0).getLinkUrl();
                            melonLinkInfo5.c = ((Content)serializable0).getScheme();
                            H.e(((y)object2), "", "", melonLinkInfo5, 8);
                        }
                    }
                    else {
                        MelonLinkInfo melonLinkInfo6 = new MelonLinkInfo();
                        melonLinkInfo6.a = ((Content)serializable0).getLinkType();
                        melonLinkInfo6.b = ((Content)serializable0).getLinkUrl();
                        melonLinkInfo6.c = ((Content)serializable0).getScheme();
                        H.e(((y)object2), "", "", melonLinkInfo6, 8);
                    }
                    H.m(((y)object2), ((Content)serializable0), v6, ((String)object1), v7, q.b("", "N10096"), null, null, 0, null, null, 0x3E0);
                    return h0;
                }
                if(((i)object0) instanceof h) {
                    H.i(((y)object2), "", "", "", "");
                    H.m(((y)object2), ((Content)serializable0), v6, ((String)object1), v7, true, null, null, 0, null, null, 0x3E0);
                    return h0;
                }
                if(((i)object0) instanceof g) {
                    String s11 = b.a("");
                    String s12 = ((Content)serializable0).getTitle();
                    H.a(((y)object2), "", v6, "", s11, (s12 == null ? "" : s12), null, null, 0, null, 2000);
                }
                return h0;
            }
            case 5: {
                q.g(((e1)object0), "event");
                int v8 = this.c;
                if(((e1)object0) instanceof d1) {
                    MelonLinkExecutor.open(MelonLinkInfo.b(((MAGAZINECONTENT)object2)));
                    List list1 = ((MAGAZINE)serializable0).getContents();
                    int v9 = this.e;
                    if(list1 != null) {
                        com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE.CONTENTS mainMusicRes$RESPONSE$MAGAZINE$CONTENTS0 = (com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE.CONTENTS)list1.get(v9);
                        if(mainMusicRes$RESPONSE$MAGAZINE$CONTENTS0 != null) {
                            s = mainMusicRes$RESPONSE$MAGAZINE$CONTENTS0.getTitle();
                        }
                    }
                    if(s == null) {
                        s = "";
                    }
                    ((C)object1).getClass();
                    Uc.p p1 = H.c(((C)object1), ActionKind.ClickContent, null, v9, v8, null, false, null, 0, null, 1010);
                    a a0 = (a)p1.d;
                    if(a0 == null) {
                        a a1 = new a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
                        a1.g = s;
                        a1.f = ((MAGAZINECONTENT)object2).getImgUrl();
                        p1.d = a1;
                    }
                    else {
                        a0.g = s;
                        a0.f = ((MAGAZINECONTENT)object2).getImgUrl();
                    }
                    q8.f f0 = (q8.f)p1.e;
                    if(f0 == null) {
                        q8.f f1 = new q8.f();  // 初始化器: Ljava/lang/Object;-><init>()V
                        f1.a = ((MAGAZINECONTENT)object2).getContsId();
                        f1.b = ((MAGAZINECONTENT)object2).getTitle();
                        p1.e = f1;
                    }
                    else {
                        f0.a = ((MAGAZINECONTENT)object2).getContsId();
                        f0.b = ((MAGAZINECONTENT)object2).getTitle();
                    }
                    LinkedHashMap linkedHashMap1 = (LinkedHashMap)p1.g;
                    c c1 = new c();
                    String s13 = ((MAGAZINECONTENT)object2).getContsId();
                    if(s13 != null) {
                        s1 = s13;
                    }
                    c1.a.put("toros_event_meta_id", s1);
                    linkedHashMap1.putAll(c1.a);
                    p1.p().track();
                    return h0;
                }
                if(!(((e1)object0) instanceof c1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                String s14 = ((MAGAZINECONTENT)object2).getContsId();
                String s15 = ((MAGAZINECONTENT)object2).getContsId();
                String s16 = ((MAGAZINECONTENT)object2).getContsTypeCode();
                if(s16 == null) {
                    s16 = "";
                }
                String s17 = b.a(s16);
                String s18 = ((MAGAZINECONTENT)object2).getTitle();
                H.a(((C)object1), (s14 == null ? "" : s14), v8, (s15 == null ? "" : s15), s17, (s18 == null ? "" : s18), null, null, 0, ((c1)(((e1)object0))).a, 0x3D0);
                return h0;
            }
            case 6: {
                q.g(((h2)object0), "userEvent");
                int v10 = this.c;
                int v11 = this.e;
                if(((h2)object0) instanceof e2) {
                    MelonLinkInfo melonLinkInfo7 = new MelonLinkInfo();
                    melonLinkInfo7.a = "";
                    melonLinkInfo7.b = "";
                    melonLinkInfo7.c = "";
                    MelonLinkExecutor.open(melonLinkInfo7);
                    O.p(((O)object2), ((e2)(((h2)object0))).a.a, v10, v11, ((e2)(((h2)object0))).b);
                    return h0;
                }
                if(((h2)object0) instanceof g2) {
                    ((O)object2).g(((TAGCONTENTS)object1).plylstseq);
                    O.p(((O)object2), ((g2)(((h2)object0))).a.a, v10, v11, ((g2)(((h2)object0))).b);
                    return h0;
                }
                if(!(((h2)object0) instanceof f2)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                String s19 = ((TAGCONTENTS)object1).plylstseq;
                q.f(s19, "plylstseq");
                H.a(((O)object2), s19, v11, null, null, null, null, null, 0, ((CONTENTS)serializable0).getTagName(), 1020);
                return h0;
            }
            default: {
                q.g(((K2)object0), "event");
                int v = this.c;
                int v1 = this.e;
                if(((K2)object0) instanceof J2) {
                    ((V)object2).j(((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS)object1).mvId);
                    String s2 = ((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS)object1).mvId;
                    Uc.p p0 = H.c(((V)object2), ActionKind.PlayVideo, null, 0, v1, (s2 == null ? "" : s2), false, ((VIDEO)serializable0).getStatsElements(), v, "", 102);
                    p0.e(new z(((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS)object1), 5));
                    LinkedHashMap linkedHashMap0 = (LinkedHashMap)p0.g;
                    c c0 = new c();
                    String s3 = ((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS)object1).mvId;
                    if(s3 != null) {
                        s1 = s3;
                    }
                    c0.a.put("toros_event_meta_id", s1);
                    linkedHashMap0.putAll(c0.a);
                    p0.p().track();
                    return h0;
                }
                if(!(((K2)object0) instanceof I2)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                String s4 = ((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS)object1).mvId;
                H.a(((V)object2), (s4 == null ? "" : s4), v1, null, null, null, "", ((VIDEO)serializable0).getStatsElements(), v, null, 0x63C);
                return h0;
            }
        }
    }
}

