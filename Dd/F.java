package dd;

import com.iloen.melon.fragments.artistchannel.ArtistPickFragment.Companion;
import com.iloen.melon.fragments.artistchannel.ArtistPickFragment;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.Navigator;
import h;
import i;
import kotlin.jvm.internal.q;
import p8.b;
import we.k;

public final class f implements k {
    public final Content a;
    public final g b;
    public final Flexible c;
    public final int d;
    public final String e;
    public final int f;
    public final int g;

    public f(Content flexibleRes$RESPONSE$Flexible$Content0, g g0, Flexible flexibleRes$RESPONSE$Flexible0, int v, String s, int v1, int v2) {
        this.a = flexibleRes$RESPONSE$Flexible$Content0;
        this.b = g0;
        this.c = flexibleRes$RESPONSE$Flexible0;
        this.d = v;
        this.e = s;
        this.f = v1;
        this.g = v2;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((i)object0), "userEvent");
        Content flexibleRes$RESPONSE$Flexible$Content0 = this.a;
        g g0 = this.b;
        String s = this.e;
        Flexible flexibleRes$RESPONSE$Flexible0 = this.c;
        int v = this.d;
        int v1 = this.f;
        int v2 = this.g;
        String s1 = "";
        if(((i)object0) instanceof f) {
            if(q.b("N10091", "")) {
                String s2 = flexibleRes$RESPONSE$Flexible$Content0.getScheme();
                if(s2 == null || s2.length() == 0) {
                    String s3 = flexibleRes$RESPONSE$Flexible$Content0.getArtistId();
                    if(s3 != null) {
                        Navigator.open(Companion.newInstance$default(ArtistPickFragment.Companion, s3, null, null, 6, null));
                    }
                }
                else {
                    MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                    melonLinkInfo0.a = flexibleRes$RESPONSE$Flexible$Content0.getLinkType();
                    melonLinkInfo0.b = flexibleRes$RESPONSE$Flexible$Content0.getLinkUrl();
                    melonLinkInfo0.c = flexibleRes$RESPONSE$Flexible$Content0.getScheme();
                    H.e(g0, "", "", melonLinkInfo0, 8);
                }
            }
            else {
                MelonLinkInfo melonLinkInfo1 = new MelonLinkInfo();
                melonLinkInfo1.a = flexibleRes$RESPONSE$Flexible$Content0.getLinkType();
                melonLinkInfo1.b = flexibleRes$RESPONSE$Flexible$Content0.getLinkUrl();
                melonLinkInfo1.c = flexibleRes$RESPONSE$Flexible$Content0.getScheme();
                H.e(g0, "", "", melonLinkInfo1, 8);
            }
            boolean z = q.b("", "N10096");
            String s4 = flexibleRes$RESPONSE$Flexible0.getSlotId();
            if(s4 != null) {
                s1 = s4;
            }
            H.m(g0, flexibleRes$RESPONSE$Flexible$Content0, v, s, v1, z, s1, flexibleRes$RESPONSE$Flexible0.getStatsElements(), v2, null, null, 0x300);
            return ie.H.a;
        }
        if(((i)object0) instanceof h) {
            H.i(g0, "", "", "", "");
            String s5 = flexibleRes$RESPONSE$Flexible0.getSlotId();
            if(s5 != null) {
                s1 = s5;
            }
            H.m(g0, flexibleRes$RESPONSE$Flexible$Content0, v, s, v1, true, s1, flexibleRes$RESPONSE$Flexible0.getStatsElements(), v2, null, null, 0x300);
            return ie.H.a;
        }
        if(((i)object0) instanceof g) {
            String s6 = flexibleRes$RESPONSE$Flexible0.getSlotId();
            if(s6 == null) {
                s6 = "";
            }
            String s7 = flexibleRes$RESPONSE$Flexible$Content0.getTitle();
            H.a(g0, "", v, "", b.a(""), (s7 == null ? "" : s7), s6, flexibleRes$RESPONSE$Flexible0.getStatsElements(), v2, null, 0x610);
        }
        return ie.H.a;
    }
}

