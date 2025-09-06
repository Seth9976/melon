package f2;

import androidx.appcompat.app.o;
import java.util.ArrayList;

public final class a {
    public final ArrayList a;
    public final d b;
    public int c;
    public boolean d;

    public a(d d0, ArrayList arrayList0) {
        ArrayList arrayList1 = new ArrayList();
        this.a = arrayList1;
        if(arrayList0.size() > 0) {
            throw o.g(0, arrayList0);
        }
        ArrayList arrayList2 = d0.b;
        if(!arrayList2.contains(this)) {
            arrayList2.add(this);
            int v = arrayList1.size();
            if(v - 1 >= 0) {
                throw o.g(v - 1, arrayList1);
            }
            int v1 = arrayList1.size();
            if(v1 - 1 >= 0) {
                throw o.g(v1 - 1, arrayList1);
            }
        }
        this.b = d0;
    }
}

