package o4;

import android.adservices.adselection.GetAdSelectionDataOutcome;
import java.util.Arrays;
import kotlin.jvm.internal.q;

public final class l {
    public final long a;
    public final byte[] b;

    public l(GetAdSelectionDataOutcome getAdSelectionDataOutcome0) {
        q.g(getAdSelectionDataOutcome0, "response");
        long v = getAdSelectionDataOutcome0.getAdSelectionId();
        byte[] arr_b = getAdSelectionDataOutcome0.getAdSelectionData();
        super();
        this.a = v;
        this.b = arr_b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof l ? this.a == ((l)object0).a && Arrays.equals(this.b, ((l)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = Long.hashCode(this.a);
        return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
    }

    @Override
    public final String toString() {
        return "GetAdSelectionDataOutcome: adSelectionId=" + this.a + ", adSelectionData=" + this.b;
    }
}

