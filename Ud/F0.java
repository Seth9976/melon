package ud;

import com.iloen.melon.net.v4x.common.ContsTypeCode;
import java.util.ArrayList;

public final class f0 extends g0 {
    public final ArrayList a;
    public final ContsTypeCode b;

    public f0(ContsTypeCode contsTypeCode0, ArrayList arrayList0) {
        this.a = arrayList0;
        this.b = contsTypeCode0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof f0 && this.a.equals(((f0)object0).a) && this.b.equals(((f0)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ShowMultiCreatorPopup(creatorInfo=" + this.a + ", contsTypeCode=" + this.b + ")";
    }
}

