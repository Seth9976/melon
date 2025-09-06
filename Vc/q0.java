package Vc;

import H0.b;
import Vb.p0;
import com.melon.ui.K4;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class q0 implements K4 {
    public final String a;
    public final ArrayList b;
    public final p0 c;

    public q0(String s, ArrayList arrayList0, p0 p00) {
        q.g(s, "title");
        super();
        this.a = s;
        this.b = arrayList0;
        this.c = p00;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof q0 && q.b(this.a, ((q0)object0).a) && this.b.equals(((q0)object0).b) && this.c.equals(((q0)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + b.a(this.b, this.a.hashCode() * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "QuickPickSlotUiState(title=" + this.a + ", quickPickList=" + this.b + ", userEvent=" + this.c + ")";
    }
}

