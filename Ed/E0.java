package ed;

import A7.d;
import com.iloen.melon.net.v6x.response.SearchHotKeywordAndMenuListRes.RESPONSE;

public final class e0 extends f0 {
    public final RESPONSE a;

    public e0(RESPONSE searchHotKeywordAndMenuListRes$RESPONSE0) {
        this.a = searchHotKeywordAndMenuListRes$RESPONSE0;
    }

    @Override  // ed.f0
    public final f0 a() {
        return new d0(this.a);
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof e0 && this.a.equals(((e0)object0).a);
    }

    @Override
    public final int hashCode() {
        return d.e(this.a.hashCode() * 0x1F, 0x1F, true);
    }

    @Override
    public final String toString() {
        return "Expand(data=" + this.a + ", isNowData=true, currentPage=0)";
    }
}

