package ed;

import com.melon.net.res.SearchMainContentRes.ArchivingThemeItem;
import kotlin.jvm.internal.q;
import we.k;

public final class c {
    public final ArchivingThemeItem a;
    public final k b;

    public c(ArchivingThemeItem searchMainContentRes$ArchivingThemeItem0, k k0) {
        q.g(searchMainContentRes$ArchivingThemeItem0, "data");
        super();
        this.a = searchMainContentRes$ArchivingThemeItem0;
        this.b = k0;
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

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ArchiveThemeItem(data=" + this.a + ", clickAction=" + this.b + ")";
    }
}

