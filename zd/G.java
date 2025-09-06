package zd;

import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.types.StringIds;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import v9.p;

public final class g extends m {
    public final ArtistPlayListInfoBase a;

    public g(ArtistPlayListInfoBase artistPlayListInfoBase0) {
        this.a = artistPlayListInfoBase0;
    }

    @Override  // zd.m
    public final String a() {
        String s = this.a.plylstseq;
        return s == null ? "" : s;
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
        arrayList0.add(x.a);
        arrayList0.add(x.b);
        boolean z = this.i();
        arrayList0.add(MelonBottomSheetItem.a(x.h, z, null, 0x2F));
        arrayList0.add(x.n);
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof g ? q.b(this.a, ((g)object0).a) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 12;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // zd.m
    public final boolean i() {
        StringIds stringIds0 = StringIds.e(this.a.artistId);
        p p0 = StringIds.b;
        for(Object object0: stringIds0) {
            if(p0.test(((String)object0))) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    @Override  // zd.m
    public final boolean m() {
        return false;
    }

    @Override  // zd.m
    public final String q() {
        String s = this.a.ownernickname;
        return s == null ? "" : s;
    }

    @Override  // zd.Q
    public final String r() {
        String s = this.a.plylsttitle;
        return s == null ? "" : s;
    }

    @Override  // zd.m
    public final Object s() {
        return this.a.thumbimg;
    }

    @Override  // zd.m
    public final l t() {
        return l.a;
    }

    @Override
    public final String toString() {
        return "ArtistPlaylistType(data=" + this.a + ")";
    }
}

