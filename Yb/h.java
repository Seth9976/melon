package Yb;

import com.iloen.melon.drm.CollectionRulesDcf;
import com.iloen.melon.drm.DcfFile;
import kotlin.jvm.internal.q;

public final class h extends m {
    public final String c;
    public final DcfFile d;
    public final CollectionRulesDcf e;
    public final String f;

    public h(String s, DcfFile dcfFile0, CollectionRulesDcf collectionRulesDcf0) {
        super(s, null);
        this.c = s;
        this.d = dcfFile0;
        this.e = collectionRulesDcf0;
        this.f = "DrmException.AutoExtensionNotAllowed";
    }

    @Override  // Sb.a
    public final String b() {
        return this.f;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h)) {
            return false;
        }
        if(!q.b(this.c, ((h)object0).c)) {
            return false;
        }
        return q.b(this.d, ((h)object0).d) ? q.b(this.e, ((h)object0).e) : false;
    }

    @Override
    public final String getMessage() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        return this.e.hashCode() + (this.d.hashCode() + this.c.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "AutoExtensionNotAllowed(message=" + this.c + ", file=" + this.d + ", dcfInfo=" + this.e + ")";
    }
}

