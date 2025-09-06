package N4;

import U4.x;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

public final class b0 {
    public final HashMap a;
    public final View b;
    public final ArrayList c;

    public b0(View view0) {
        this.a = new HashMap();
        this.c = new ArrayList();
        this.b = view0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof b0 && this.b == ((b0)object0).b && this.a.equals(((b0)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() + this.b.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = x.p(("TransitionValues@" + Integer.toHexString(this.hashCode()) + ":\n"), "    view = ");
        stringBuilder0.append(this.b);
        stringBuilder0.append("\n");
        String s = stringBuilder0.toString() + "    values:";
        HashMap hashMap0 = this.a;
        for(Object object0: hashMap0.keySet()) {
            s = s + "    " + ((String)object0) + ": " + hashMap0.get(((String)object0)) + "\n";
        }
        return s;
    }
}

