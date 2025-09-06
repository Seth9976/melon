package o4;

import android.adservices.adselection.AdSelectionOutcome;
import android.net.Uri;
import kotlin.jvm.internal.q;

public final class k {
    public final long a;
    public final Uri b;

    static {
        Uri uri0 = Uri.EMPTY;
        q.f(uri0, "EMPTY");
        new k(uri0, 0L);
    }

    public k(AdSelectionOutcome adSelectionOutcome0) {
        q.g(adSelectionOutcome0, "response");
        long v = adSelectionOutcome0.getAdSelectionId();
        Uri uri0 = adSelectionOutcome0.getRenderUri();
        q.f(uri0, "response.renderUri");
        super();
        this.a = v;
        this.b = uri0;
    }

    public k(Uri uri0, long v) {
        this.a = v;
        this.b = uri0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof k ? this.a == ((k)object0).a && q.b(this.b, ((k)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + Long.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        return "AdSelectionOutcome: adSelectionId=" + this.a + ", renderUri=" + this.b;
    }
}

