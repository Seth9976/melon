package Wa;

import com.iloen.melon.utils.NameValuePairList;
import kotlin.jvm.internal.q;

public final class m extends p {
    public final NameValuePairList a;

    public m(NameValuePairList nameValuePairList0) {
        this.a = nameValuePairList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m ? q.b(this.a, ((m)object0).a) : false;
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

