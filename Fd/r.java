package Fd;

import A0.c;
import com.iloen.melon.net.v6x.response.SearchKeywordContent;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.m;
import ie.H;
import kotlin.jvm.internal.q;
import p8.g;
import w0.h;
import we.a;

public final class r implements a {
    public final int a;
    public final h b;
    public final SearchKeywordContent c;
    public final D d;
    public final Z e;
    public final int f;

    public r(h h0, D d0, Z z0, SearchKeywordContent searchKeywordContent0, int v) {
        this.a = 0;
        super();
        this.b = h0;
        this.d = d0;
        this.e = z0;
        this.c = searchKeywordContent0;
        this.f = v;
    }

    public r(h h0, SearchKeywordContent searchKeywordContent0, D d0, Z z0, int v, int v1) {
        this.a = v1;
        this.b = h0;
        this.c = searchKeywordContent0;
        this.d = d0;
        this.e = z0;
        this.f = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                h.a(this.b);
                ((Y)this.d.getViewModel()).e(this.e, this.c, this.f);
                Y y3 = (Y)this.d.getViewModel();
                y3.getClass();
                y3.d(this.c);
                MelonLinkInfo melonLinkInfo2 = new MelonLinkInfo();
                melonLinkInfo2.c = this.c.getScheme();
                MelonLinkExecutor.open(melonLinkInfo2);
                return H.a;
            }
            case 1: {
                h.a(this.b);
                SearchKeywordContent searchKeywordContent1 = this.c;
                String s6 = searchKeywordContent1.getContentsId();
                D d1 = this.d;
                Y y4 = (Y)d1.getViewModel();
                c c1 = y4.c;
                int v1 = this.f;
                if(this.e == Z.a) {
                    String s7 = searchKeywordContent1.getContentsId();
                    String s8 = searchKeywordContent1.getContentsTypeCode();
                    String s9 = searchKeywordContent1.getTitle();
                    c1.getClass();
                    q.g(s7, "contentsId");
                    q.g(s8, "contentsTypeCode");
                    q.g(s9, "contentsName");
                    g g2 = c1.z();
                    g2.a = "";
                    g2.d = ActionKind.PlayMusic;
                    g2.y = "";
                    g2.z = "";
                    g2.c(v1 + 1);
                    g2.e = s7;
                    g2.f = c.A(s8);
                    g2.g = s9;
                    g2.a().track();
                }
                else {
                    String s10 = searchKeywordContent1.getContentsId();
                    String s11 = searchKeywordContent1.getContentsTypeCode();
                    String s12 = searchKeywordContent1.getTitle();
                    c1.getClass();
                    q.g(s10, "contentsId");
                    q.g(s11, "contentsTypeCode");
                    q.g(s12, "contentsName");
                    q.g(y4.k, "keyword");
                    g g3 = c1.z();
                    g3.a = "";
                    g3.d = ActionKind.PlayMusic;
                    g3.y = "";
                    g3.z = "";
                    g3.c(v1 + 1);
                    g3.e = s10;
                    g3.f = c.A(s11);
                    g3.g = s12;
                    g3.X = y4.k;
                    g3.Y = "suggest";
                    g3.a().track();
                }
                ((Y)d1.getViewModel()).d(searchKeywordContent1);
                d1.sendUserEvent(new m(s6, ((Y)d1.getViewModel()).getMenuId(), null, null, 0x30));
                return H.a;
            }
            default: {
                h.a(this.b);
                SearchKeywordContent searchKeywordContent0 = this.c;
                boolean z = q.b(searchKeywordContent0.getContentsTypeCode(), "N10001");
                int v = this.f;
                Z z1 = this.e;
                D d0 = this.d;
                if(z) {
                    Y y0 = (Y)d0.getViewModel();
                    c c0 = y0.c;
                    if(z1 == Z.a) {
                        String s = searchKeywordContent0.getContentsId();
                        String s1 = searchKeywordContent0.getContentsTypeCode();
                        String s2 = searchKeywordContent0.getTitle();
                        c0.getClass();
                        q.g(s, "contentsId");
                        q.g(s1, "contentsTypeCode");
                        q.g(s2, "contentsName");
                        g g0 = c0.z();
                        g0.a = "";
                        g0.d = ActionKind.ClickContent;
                        g0.y = "";
                        g0.z = "";
                        g0.c(v + 1);
                        g0.e = s;
                        g0.f = c.A(s1);
                        g0.g = s2;
                        g0.a().track();
                    }
                    else {
                        String s3 = searchKeywordContent0.getContentsId();
                        String s4 = searchKeywordContent0.getContentsTypeCode();
                        String s5 = searchKeywordContent0.getTitle();
                        c0.getClass();
                        q.g(s3, "contentsId");
                        q.g(s4, "contentsTypeCode");
                        q.g(s5, "contentsName");
                        q.g(y0.k, "keyword");
                        g g1 = c0.z();
                        g1.a = "";
                        g1.d = ActionKind.ClickContent;
                        g1.y = "";
                        g1.z = "";
                        g1.c(v + 1);
                        g1.e = s3;
                        g1.f = c.A(s4);
                        g1.g = s5;
                        g1.X = y0.k;
                        g1.Y = "suggest";
                        g1.a().track();
                    }
                    Y y1 = (Y)d0.getViewModel();
                    y1.getClass();
                    y1.d(searchKeywordContent0);
                    MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                    melonLinkInfo0.c = searchKeywordContent0.getTrackAlbumScheme();
                    MelonLinkExecutor.open(melonLinkInfo0);
                    return H.a;
                }
                ((Y)d0.getViewModel()).e(z1, searchKeywordContent0, v);
                Y y2 = (Y)d0.getViewModel();
                y2.getClass();
                y2.d(searchKeywordContent0);
                MelonLinkInfo melonLinkInfo1 = new MelonLinkInfo();
                melonLinkInfo1.c = searchKeywordContent0.getScheme();
                MelonLinkExecutor.open(melonLinkInfo1);
                return H.a;
            }
        }
    }
}

