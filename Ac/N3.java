package Ac;

import com.melon.net.res.v3.CommentConfig;
import java.util.List;
import kotlin.jvm.internal.q;

public final class n3 extends o3 {
    public final CommentConfig a;
    public final List b;

    public n3(CommentConfig commentConfig0, List list0) {
        this.a = commentConfig0;
        this.b = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof n3)) {
            return false;
        }
        return q.b(this.a, ((n3)object0).a) ? q.b(this.b, ((n3)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.b.hashCode() : this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Success(configure=" + this.a + ", list=" + this.b + ")";
    }
}

