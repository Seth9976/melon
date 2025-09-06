package e1;

import androidx.appcompat.app.o;
import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import je.p;
import je.u;
import kotlin.jvm.internal.q;

public final class w {
    public final ArrayList a;

    public w(v[] arr_v) {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        if(arr_v.length <= 0) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: linkedHashMap0.entrySet()) {
                String s = (String)((Map.Entry)object0).getKey();
                List list0 = (List)((Map.Entry)object0).getValue();
                if(list0.size() != 1) {
                    throw new IllegalArgumentException(o.r(a.n("\'", s, "\' must be unique. Actual [ ["), p.q0(list0, null, null, null, null, 0x3F), ']').toString());
                }
                u.U(arrayList0, list0);
            }
            ArrayList arrayList1 = new ArrayList(arrayList0);
            this.a = arrayList1;
            if(arrayList1.size() > 0) {
                throw o.g(0, arrayList1);
            }
            return;
        }
        v v0 = arr_v[0];
        throw null;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof w && q.b(this.a, ((w)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

