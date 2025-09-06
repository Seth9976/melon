package qb;

import com.iloen.melon.utils.NameValuePairList;

public final class q extends u {
    public final NameValuePairList a;

    public q(NameValuePairList nameValuePairList0) {
        this.a = nameValuePairList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof q ? kotlin.jvm.internal.q.b(this.a, ((q)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OpenDownloadUrl(param=" + this.a + ")";
    }
}

