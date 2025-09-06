package Vc;

import com.melon.ui.K4;

public final class r implements K4 {
    public final String a;
    public final B b;

    public r(String s, B b0) {
        this.a = s;
        this.b = b0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof r && this.a.equals(((r)object0).a) && this.b.equals(((r)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "LoginSlotUiState(userId=" + this.a + ", userEvent=" + this.b + ")";
    }
}

