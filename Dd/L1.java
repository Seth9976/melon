package Dd;

import Kd.h;
import android.os.Bundle;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.K4;
import com.melon.ui.n;
import gd.X1;
import gd.c1;
import gd.p2;
import gd.w0;
import ie.H;
import java.util.Collections;
import java.util.List;
import k8.Y;
import kotlin.jvm.internal.q;
import p8.f;
import we.a;

public final class l1 implements a {
    public final int a;
    public final K4 b;
    public final n1 c;

    public l1(n1 n10, F1 f10) {
        this.a = 4;
        super();
        this.c = n10;
        this.b = f10;
    }

    public l1(K4 k40, n1 n10, int v) {
        this.a = v;
        this.b = k40;
        this.c = n10;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        String s7;
        H h0 = H.a;
        String s = null;
        K4 k40 = this.b;
        n1 n10 = this.c;
        String s1 = "";
        switch(this.a) {
            case 0: {
                String s4 = ((K1)n10.getViewModel()).getMenuId();
                MelonLinkExecutor.open(MelonLinkInfo.a(((q1)k40).a, s4));
                f f1 = ((K1)n10.getViewModel()).i();
                if(f1 != null) {
                    String s5 = n10.getContext() == null ? null : "페이지이동";
                    if(s5 == null) {
                        s5 = "";
                    }
                    f1.a = s5;
                    f1.d = ActionKind.ClickContent;
                    String s6 = n10.getContext() == null ? null : "배너";
                    if(s6 == null) {
                        s6 = "";
                    }
                    f1.y = s6;
                    f1.u = ((K1)n10.getViewModel()).g;
                    BannerBase bannerBase0 = ((q1)k40).a;
                    if(bannerBase0 != null) {
                        s = bannerBase0.banerseq;
                    }
                    if(s != null) {
                        s1 = s;
                    }
                    f1.e = s1;
                    f1.a().track();
                }
                return h0;
            }
            case 1: {
                switch(((d2)k40).d) {
                    case "TITLE_TYPE_ARTIST": {
                        String s10 = ((K1)n10.getViewModel()).e;
                        String s11 = ((K1)n10.getViewModel()).g;
                        q.g(s10, "brandDjKey");
                        q.g(s11, "djTitle");
                        c1 c10 = new c1();
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("argBrandDjKey", s10);
                        bundle1.putString("argBrandTitle", s11);
                        c10.setArguments(bundle1);
                        Navigator.INSTANCE.open(c10);
                        s7 = n10.getContext() == null ? null : "추천아티스트";
                        if(s7 == null) {
                            s7 = "";
                        }
                        break;
                    }
                    case "TITLE_TYPE_MAGAZINE": {
                        String s8 = ((K1)n10.getViewModel()).e;
                        String s9 = ((K1)n10.getViewModel()).g;
                        q.g(s8, "brandDjKey");
                        q.g(s9, "djTitle");
                        w0 w00 = new w0();
                        Bundle bundle0 = new Bundle();
                        bundle0.putString("argBrandDjKey", s8);
                        bundle0.putString("argBrandTitle", s9);
                        w00.setArguments(bundle0);
                        Navigator.INSTANCE.open(w00);
                        s7 = n10.getContext() == null ? null : "매거진";
                        if(s7 == null) {
                            s7 = "";
                        }
                        break;
                    }
                    case "TITLE_TYPE_PLAYLIST": {
                        String s12 = ((K1)n10.getViewModel()).e;
                        String s13 = ((K1)n10.getViewModel()).g;
                        Navigator.INSTANCE.openMelonDjBrandPlaylist(s12, s13);
                        s7 = n10.getContext() == null ? null : "플레이리스트";
                        if(s7 == null) {
                            s7 = "";
                        }
                        break;
                    }
                    case "TITLE_TYPE_SONG": {
                        String s16 = ((K1)n10.getViewModel()).e;
                        String s17 = ((K1)n10.getViewModel()).g;
                        Navigator.INSTANCE.openMelonDjBrandRecmSong(s16, s17);
                        s7 = n10.getContext() == null ? null : "추천곡";
                        if(s7 == null) {
                            s7 = "";
                        }
                        break;
                    }
                    case "TITLE_TYPE_STATION": {
                        String s18 = ((K1)n10.getViewModel()).e;
                        q.g(s18, "brandDjKey");
                        X1 x10 = new X1();
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("argBrandDjKey", s18);
                        bundle3.putString("argBrandTitle", "");
                        x10.setArguments(bundle3);
                        Navigator.INSTANCE.open(x10);
                        s7 = n10.getContext() == null ? null : "스테이션";
                        if(s7 == null) {
                            s7 = "";
                        }
                        break;
                    }
                    case "TITLE_TYPE_VIDEO": {
                        String s14 = ((K1)n10.getViewModel()).e;
                        String s15 = ((K1)n10.getViewModel()).g;
                        q.g(s14, "brandDjKey");
                        q.g(s15, "djTitle");
                        p2 p20 = new p2();
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("argBrandDjKey", s14);
                        bundle2.putString("argBrandTitle", s15);
                        p20.setArguments(bundle2);
                        Navigator.INSTANCE.open(p20);
                        s7 = n10.getContext() == null ? null : "추천비디오";
                        if(s7 == null) {
                            s7 = "";
                        }
                        break;
                    }
                    default: {
                        s7 = "";
                    }
                }
                f f2 = ((K1)n10.getViewModel()).i();
                if(f2 != null) {
                    String s19 = n10.getContext() == null ? null : "페이지이동";
                    if(s19 == null) {
                        s19 = "";
                    }
                    f2.a = s19;
                    f2.y = s7;
                    if(n10.getContext() != null) {
                        s1 = "전체보기";
                    }
                    f2.F = s1;
                    f2.u = ((K1)n10.getViewModel()).g;
                    f2.a().track();
                }
                return h0;
            }
            case 2: {
                Navigator.openAlbumInfo(((F1)k40).a.c);
                f f3 = ((K1)n10.getViewModel()).i();
                if(f3 != null) {
                    String s20 = n10.getContext() == null ? null : "페이지이동";
                    if(s20 == null) {
                        s20 = "";
                    }
                    f3.a = s20;
                    f3.d = ActionKind.ClickContent;
                    if(n10.getContext() != null) {
                        s1 = "추천곡";
                    }
                    f3.y = s1;
                    f3.c(((F1)k40).b + 1);
                    f3.u = ((K1)n10.getViewModel()).g;
                    f3.e = ((F1)k40).a.a;
                    f3.f = Y.i(ContsTypeCode.SONG, "code(...)");
                    f3.g = ((F1)k40).a.b;
                    f3.a().track();
                }
                return h0;
            }
            case 3: {
                Navigator.openSongInfo(((F1)k40).a.a);
                f f4 = ((K1)n10.getViewModel()).i();
                if(f4 != null) {
                    String s21 = n10.getContext() == null ? null : "페이지이동";
                    if(s21 == null) {
                        s21 = "";
                    }
                    f4.a = s21;
                    f4.d = ActionKind.ClickContent;
                    if(n10.getContext() != null) {
                        s1 = "추천곡";
                    }
                    f4.y = s1;
                    f4.c(((F1)k40).b + 1);
                    f4.u = ((K1)n10.getViewModel()).g;
                    f4.e = ((F1)k40).a.a;
                    f4.f = Y.i(ContsTypeCode.SONG, "code(...)");
                    f4.g = ((F1)k40).a.b;
                    f4.a().track();
                }
                return h0;
            }
            default: {
                String s2 = ((K1)n10.getViewModel()).getMenuId();
                List list0 = Collections.singletonList(h.b(((F1)k40).a, s2));
                q.f(list0, "singletonList(...)");
                n10.sendUserEvent(new n(list0, ((K1)n10.getViewModel()).getMenuId(), false, false, null, 0x7C));
                f f0 = ((K1)n10.getViewModel()).i();
                if(f0 != null) {
                    String s3 = n10.getContext() == null ? null : "음악재생";
                    if(s3 == null) {
                        s3 = "";
                    }
                    f0.a = s3;
                    f0.d = ActionKind.PlayMusic;
                    if(n10.getContext() != null) {
                        s1 = "추천곡";
                    }
                    f0.y = s1;
                    f0.c(((F1)k40).b + 1);
                    f0.u = ((K1)n10.getViewModel()).g;
                    f0.e = ((F1)k40).a.a;
                    f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                    f0.g = ((F1)k40).a.b;
                    f0.a().track();
                }
                return h0;
            }
        }
    }
}

