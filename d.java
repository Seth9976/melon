import Cc.R1;
import Cc.S1;
import Cc.c1;
import Cc.m3;
import Cc.q0;
import Dd.J;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.response.FlexibleRes.BadgeType;
import com.iloen.melon.net.v5x.response.FlexibleRes.ImageDpType;
import com.iloen.melon.net.v5x.response.FlexibleRes.ImageType;
import com.iloen.melon.net.v5x.response.FlexibleRes.LogoType;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import com.iloen.melon.utils.color.ColorUtils;
import ie.m;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.q;
import r0.a;
import r0.n;
import r1.f;
import we.k;

public abstract class d {
    public static final void a(e e0, l l0, int v) {
        m m2;
        m m1;
        int v9;
        float f;
        String s11;
        String s8;
        n n1;
        Content flexibleRes$RESPONSE$Flexible$Content1;
        String s2;
        q.g(e0, "uiState");
        boolean z = e0.b;
        p p0 = (p)l0;
        p0.c0(-1826142029);
        int v1 = v | (p0.i(e0) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            Content flexibleRes$RESPONSE$Flexible$Content0 = e0.a;
            k k0 = e0.c;
            V v2 = androidx.compose.runtime.k.a;
            String s = "";
            if(ImageDpType.MULTIPLE == flexibleRes$RESPONSE$Flexible$Content0.getImageDpType()) {
                p0.a0(1753760908);
                Collection collection0 = flexibleRes$RESPONSE$Flexible$Content0.getImgList();
                List list0 = collection0 == null || collection0.isEmpty() ? e.k.z((flexibleRes$RESPONSE$Flexible$Content0.getImgUrl() == null ? "" : flexibleRes$RESPONSE$Flexible$Content0.getImgUrl())) : flexibleRes$RESPONSE$Flexible$Content0.getImgList();
                if(list0 == null) {
                    p0.a0(1753884690);
                }
                else {
                    p0.a0(0x688A2813);
                    String s1 = flexibleRes$RESPONSE$Flexible$Content0.getTitle();
                    boolean z1 = p0.g(k0);
                    boolean z2 = p0.i(e0);
                    b b0 = p0.N();
                    if(z1 || z2 || b0 == v2) {
                        b0 = new b(k0, e0, 0);
                        p0.l0(b0);
                    }
                    com.google.firebase.b.c(list0, (s1 == null ? "" : s1), 0.0f, 0.0f, 0, b0, p0, 0);
                }
                p0.p(false);
            }
            else {
                p0.a0(1754367609);
                int v3 = BadgeType.EVENT == flexibleRes$RESPONSE$Flexible$Content0.getBadgeType() ? 0x7F08057D : 0;  // drawable:ic_music_event
                if(!z) {
                    s2 = flexibleRes$RESPONSE$Flexible$Content0.getTitle();
                    if(s2 == null) {
                        s2 = "";
                    }
                }
                else if(q.b("", "N10007") || q.b("", "N10003") || q.b("", "N10004") || q.b("", "N10005") || q.b("", "N10009") || q.b("", "")) {
                    s2 = flexibleRes$RESPONSE$Flexible$Content0.getTitle();
                    if(s2 == null) {
                        s2 = "";
                    }
                }
                else {
                    s2 = "";
                }
                boolean z3 = p0.g(k0);
                boolean z4 = p0.i(e0);
                b b1 = p0.N();
                if(z3 || z4 || b1 == v2) {
                    b1 = new b(k0, e0, 1);
                    p0.l0(b1);
                }
                n n0 = n.a;
                r0.q q0 = m3.b(n0, b1);
                M m0 = M.p.d(r0.d.a, false);
                int v4 = p0.P;
                i0 i00 = p0.m();
                r0.q q1 = a.d(p0, q0);
                P0.k.y.getClass();
                i i0 = j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m0, j.f);
                w.x(p0, i00, j.e);
                h h0 = j.g;
                if(p0.O || !q.b(p0.N(), v4)) {
                    A7.d.q(v4, p0, v4, h0);
                }
                w.x(p0, q1, j.d);
                if(q.b("", "N10003")) {
                    p0.a0(-447905605);
                    String s3 = flexibleRes$RESPONSE$Flexible$Content0.getSubTitle() == null ? "" : flexibleRes$RESPONSE$Flexible$Content0.getSubTitle();
                    String s4 = flexibleRes$RESPONSE$Flexible$Content0.getImgUrl() == null ? "" : flexibleRes$RESPONSE$Flexible$Content0.getImgUrl();
                    long v5 = flexibleRes$RESPONSE$Flexible$Content0.getPlayTime();
                    String s5 = flexibleRes$RESPONSE$Flexible$Content0.getAdultGrade();
                    boolean z5 = e0.b;
                    boolean z6 = p0.g(k0);
                    boolean z7 = p0.i(e0);
                    b b2 = p0.N();
                    if(z6 || z7 || b2 == v2) {
                        b2 = new b(k0, e0, 2);
                        p0.l0(b2);
                    }
                    flexibleRes$RESPONSE$Flexible$Content1 = flexibleRes$RESPONSE$Flexible$Content0;
                    n1 = n0;
                    q0.g(null, s4, s2, null, null, s3, null, null, v5, null, s5, 2, 1, b2, null, 144.0f, 255.0f, v3, z5, p0, 0, 0x1B01B0, 541401);
                }
                else {
                    flexibleRes$RESPONSE$Flexible$Content1 = flexibleRes$RESPONSE$Flexible$Content0;
                    n1 = n0;
                    if(q.b("", "N10091")) {
                        p0.a0(-447208818);
                        String s6 = flexibleRes$RESPONSE$Flexible$Content1.getImgUrl();
                        if(s6 == null) {
                            s6 = "";
                        }
                        if(z) {
                            s8 = "";
                        }
                        else {
                            String s7 = flexibleRes$RESPONSE$Flexible$Content1.getSubTitle();
                            s8 = s7 == null ? "" : s7;
                        }
                        boolean z8 = p0.g(k0);
                        boolean z9 = p0.i(e0);
                        b b3 = p0.N();
                        if(z8 || z9 || b3 == v2) {
                            b3 = new b(k0, e0, 3);
                            p0.l0(b3);
                        }
                        q0.a(s6, s2, null, null, s8, null, null, 144.0f, 132.0f, 2.0f, 2, 1, b3, v3, p0, 0x36C00000);
                    }
                    else if(q.b("", "N10078")) {
                        p0.a0(-1122783606);
                        String s9 = flexibleRes$RESPONSE$Flexible$Content1.getTitle();
                        String s10 = flexibleRes$RESPONSE$Flexible$Content1.getSubTitle();
                        boolean z10 = e0.b;
                        boolean z11 = p0.g(k0);
                        boolean z12 = p0.i(e0);
                        J j0 = p0.N();
                        if(z11 || z12 || j0 == v2) {
                            j0 = new J(12, k0, e0);
                            p0.l0(j0);
                        }
                        R1.a(new S1(flexibleRes$RESPONSE$Flexible$Content1, (s9 == null ? "" : s9), (s10 == null ? "" : s10), v3, z10, j0), p0, 0);
                    }
                    else if(q.b("", "N10098")) {
                        p0.a0(0xE57369AB);
                        if(z) {
                            s11 = "";
                        }
                        else {
                            s11 = flexibleRes$RESPONSE$Flexible$Content1.getSubTitle();
                            if(s11 == null) {
                                s11 = "";
                            }
                        }
                        String s12 = flexibleRes$RESPONSE$Flexible$Content1.getTopicTitle();
                        String s13 = flexibleRes$RESPONSE$Flexible$Content1.getImgUrl();
                        if(s13 != null) {
                            s = s13;
                        }
                        boolean z13 = p0.g(k0);
                        boolean z14 = p0.i(e0);
                        b b4 = p0.N();
                        if(z13 || z14 || b4 == v2) {
                            b4 = new b(k0, e0, 4);
                            p0.l0(b4);
                        }
                        q0.h(s, s2, null, null, s11, null, null, (s12 == null ? "" : s12), 255.0f, 144.0f, 2, 1, null, b4, v3, p0, 0x36000000);
                    }
                    else if(q.b("", "N10096")) {
                        p0.a0(0xE57DBF34);
                        String s14 = flexibleRes$RESPONSE$Flexible$Content1.getImgUrl();
                        if(s14 == null) {
                            s14 = "";
                        }
                        ImageType flexibleRes$ImageType0 = flexibleRes$RESPONSE$Flexible$Content1.getImageType() == null ? ImageType.ALBUM : flexibleRes$RESPONSE$Flexible$Content1.getImageType();
                        String s15 = flexibleRes$RESPONSE$Flexible$Content1.getSubTitle();
                        String s16 = flexibleRes$RESPONSE$Flexible$Content1.getBgColor();
                        if(s16 != null) {
                            s = s16;
                        }
                        long v6 = y0.M.c(ColorUtils.getColorFromHexStr(s));
                        boolean z15 = p0.g(k0);
                        boolean z16 = p0.i(e0);
                        b b5 = p0.N();
                        if(z15 || z16 || b5 == v2) {
                            b5 = new b(k0, e0, 5);
                            p0.l0(b5);
                        }
                        q0.d(s14, flexibleRes$ImageType0, v6, s2, (s15 == null ? "" : s15), v3, b5, p0, 0);
                    }
                    else {
                        p0.a0(-444197013);
                        ContsTypeCode contsTypeCode0 = ContsTypeCode.MELON_MAGAZINE;
                        if(q.b("", "N10007")) {
                            f = 255.0f;
                        }
                        else if(q.b("", "N10025") || q.b("", "N10082")) {
                            f = 102.0f;
                        }
                        else if(!q.b("", "N10004") && !q.b("", "")) {
                            f = 144.0f;
                        }
                        else {
                            f = 192.0f;
                        }
                        String s17 = flexibleRes$RESPONSE$Flexible$Content1.getSubTitle();
                        if(s17 == null) {
                            s17 = "";
                        }
                        String s18 = flexibleRes$RESPONSE$Flexible$Content1.getImgUrl() == null ? "" : flexibleRes$RESPONSE$Flexible$Content1.getImgUrl();
                        T.d d0 = q.b("", "N10006") ? T.e.a : T.e.b(4.0f);
                        boolean z17 = e.k.A(new String[]{"N10006", contsTypeCode0.code(), "N10004", ""}).contains("");
                        boolean z18 = e0.b;
                        boolean z19 = p0.g(k0);
                        boolean z20 = p0.i(e0);
                        b b6 = p0.N();
                        if(z19 || z20 || b6 == v2) {
                            b6 = new b(k0, e0, 6);
                            p0.l0(b6);
                        }
                        boolean z21 = p0.g(k0);
                        boolean z22 = p0.i(e0);
                        b b7 = p0.N();
                        if(z21 || z22 || b7 == v2) {
                            b7 = new b(k0, e0, 7);
                            p0.l0(b7);
                        }
                        q0.b(s18, s2, null, null, s17, null, null, !z17, null, f, 0.0f, 0, 0.0f, 0.0f, 2, 1, d0, b6, b7, null, null, v3, z18, p0, 0, 0x36000, 0x583D6C);
                    }
                }
                p0.p(false);
                if(flexibleRes$RESPONSE$Flexible$Content1.getLogoType() == null) {
                    p0.a0(0xE51A1BE5);
                }
                else {
                    p0.a0(-442754087);
                    LogoType flexibleRes$LogoType0 = flexibleRes$RESPONSE$Flexible$Content1.getLogoType();
                    int v7 = -1;
                    int v8 = flexibleRes$LogoType0 == null ? -1 : c.a[flexibleRes$LogoType0.ordinal()];
                    if(v8 == 1) {
                        v9 = 0x7F08067F;  // drawable:img_station_logo_02
                    }
                    else {
                        switch(v8) {
                            case 2: {
                                v9 = 0x7F08064B;  // drawable:img_magazine_logo_01
                                break;
                            }
                            case 3: {
                                v9 = 0x7F08031F;  // drawable:common_ic_symbol
                                break;
                            }
                            case 4: {
                                v9 = 0x7F080662;  // drawable:img_only_logo
                                break;
                            }
                            case 5: {
                                v9 = 0x7F080320;  // drawable:common_img_logo_musicwave10
                                break;
                            }
                            default: {
                                v9 = 0;
                            }
                        }
                    }
                    LogoType flexibleRes$LogoType1 = flexibleRes$RESPONSE$Flexible$Content1.getLogoType();
                    switch((flexibleRes$LogoType1 == null ? -1 : c.a[flexibleRes$LogoType1.ordinal()])) {
                        case 3: {
                            m1 = new m(new f(6.0f), new f(6.0f));
                            break;
                        }
                        case 5: {
                            m1 = new m(new f(10.0f), new f(10.0f));
                            break;
                        }
                        default: {
                            m1 = new m(new f(10.0f), new f(7.0f));
                        }
                    }
                    float f1 = ((f)m1.a).a;
                    float f2 = ((f)m1.b).a;
                    LogoType flexibleRes$LogoType2 = flexibleRes$RESPONSE$Flexible$Content1.getLogoType();
                    if(flexibleRes$LogoType2 != null) {
                        v7 = c.a[flexibleRes$LogoType2.ordinal()];
                    }
                    switch(v7) {
                        case 3: {
                            m2 = new m(new f(24.0f), new f(24.0f));
                            break;
                        }
                        case 5: {
                            m2 = new m(new f(84.0f), new f(10.0f));
                            break;
                        }
                        default: {
                            m2 = new m(new f(72.0f), new f(17.0f));
                        }
                    }
                    c1.n(androidx.compose.foundation.layout.d.o(androidx.compose.foundation.layout.a.n(n1, f1, f2, 0.0f, 0.0f, 12), ((f)m2.a).a, ((f)m2.b).a), v9, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FFC);
                }
                p0.p(false);
                p0.p(true);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.a(e0, v, 8);
        }
    }
}

