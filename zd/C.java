package zd;

import android.net.Uri;
import com.iloen.melon.playback.Playable;
import com.melon.ui.k2;
import java.util.ArrayList;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;

public final class c extends m {
    public final List a;
    public final Uri b;

    public c(List list0, Uri uri0) {
        q.g(list0, "playableList");
        super();
        this.a = list0;
        this.b = uri0;
    }

    @Override  // zd.m
    public final String a() {
        String s = ((Playable)p.m0(this.a)) == null ? null : "";
        return s == null ? "" : s;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String b() {
        q.f("N10002", "code(...)");
        return "N10002";
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(x.a);
        arrayList0.add(x.d);
        arrayList0.add(x.r);
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c)) {
            return false;
        }
        return q.b(this.a, ((c)object0).a) ? q.b(this.b, ((c)object0).b) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 36;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
    }

    @Override  // zd.m
    public final boolean m() {
        return false;
    }

    @Override  // zd.m
    public final String p() {
        String s = ((Playable)p.m0(this.a)) == null ? null : "";
        return s == null ? "" : s;
    }

    @Override  // zd.m
    public final String q() {
        String s = ((Playable)p.m0(this.a)) == null ? null : "";
        return s == null ? "" : s;
    }

    @Override  // zd.Q
    public final String r() {
        String s = ((Playable)p.m0(this.a)) == null ? null : "";
        return s == null ? "" : s;
    }

    @Override  // zd.m
    public final Object s() {
        return this.b;
    }

    @Override
    public final String toString() {
        return "AlbumMyType(playableList=" + this.a + ", imgUri=" + this.b + ")";
    }

    @Override  // zd.m
    public final k2 u() {
        return null;
    }
}

