package bb;

import A7.d;
import kotlin.jvm.internal.q;

public final class n extends o {
    public final String a;
    public final boolean b;
    public final int c;
    public final String d;

    public n(int v, String s, String s1, boolean z) {
        q.g(s, "contentId");
        q.g(s1, "contsTypeCode");
        super();
        this.a = s;
        this.b = z;
        this.c = v;
        this.d = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof n)) {
            return false;
        }
        if(!q.b(this.a, ((n)object0).a)) {
            return false;
        }
        if(this.b != ((n)object0).b) {
            return false;
        }
        return this.c == ((n)object0).c ? q.b(this.d, ((n)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + d.b(this.c, d.e(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F);
    }

    @Override
    public final String toString() {
        return "UpdateLikeStateCount(contentId=" + this.a + ", isLike=" + this.b + ", likeCount=" + this.c + ", contsTypeCode=" + this.d + ")";
    }
}

