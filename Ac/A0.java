package Ac;

import com.melon.ui.K4;
import java.util.ArrayList;

public final class a0 implements K4 {
    public final ArrayList a;

    public a0(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof a0 && this.a.equals(((a0)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "CommentAttachLinkVideoScreen(list=" + this.a + ")";
    }
}

