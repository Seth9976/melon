package zd;

import com.iloen.melon.net.v4x.response.ArtistPlylstMainInfoRes.RESPONSE;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import java.util.ArrayList;
import je.p;
import kotlin.jvm.internal.q;
import sd.j;

public final class f extends m {
    public final RESPONSE a;

    public f(RESPONSE artistPlylstMainInfoRes$RESPONSE0) {
        q.g(artistPlylstMainInfoRes$RESPONSE0, "data");
        super();
        this.a = artistPlylstMainInfoRes$RESPONSE0;
    }

    @Override  // zd.m
    public final String a() {
        String s = this.a.plylstSeq;
        q.f(s, "plylstSeq");
        return s;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String b() {
        q.f("N10016", "code(...)");
        return "N10016";
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(x.e);
        arrayList0.add(x.c);
        arrayList0.add(MelonBottomSheetItem.a(x.h, true, null, 0x2F));
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f ? q.b(this.a, ((f)object0).a) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 18;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // zd.m
    public final boolean m() {
        return false;
    }

    @Override  // zd.m
    public final String q() {
        ArrayList arrayList0 = this.a.artistList;
        if(arrayList0 != null) {
            String s = p.q0(arrayList0, ", ", null, null, new j(26), 30);
            return s == null ? "" : s;
        }
        return "";
    }

    @Override  // zd.Q
    public final String r() {
        String s = this.a.plylstTitle;
        q.f(s, "plylstTitle");
        return s;
    }

    @Override  // zd.m
    public final Object s() {
        return this.a.thumbImg;
    }

    @Override
    public final String toString() {
        return "ArtistPlaylistDetailType(data=" + this.a + ")";
    }
}

