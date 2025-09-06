package i.n.i.b.a.s.e;

import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.Collections;

public final class o7 {
    public final ArrayList a;
    public final n7[] b;
    public int c;
    public int d;
    public int e;
    public int f;

    public o7() {
        this.b = new n7[5];
        this.a = new ArrayList();
        this.c = -1;
    }

    public final float a() {
        ArrayList arrayList0 = this.a;
        if(this.c != 0) {
            Collections.sort(arrayList0, new A0(7));
            this.c = 0;
        }
        float f = 0.5f * ((float)this.e);
        int v1 = 0;
        for(int v = 0; v < arrayList0.size(); ++v) {
            n7 n70 = (n7)arrayList0.get(v);
            v1 += n70.b;
            if(((float)v1) >= f) {
                return n70.c;
            }
        }
        return arrayList0.isEmpty() ? NaNf : ((n7)a.i(1, arrayList0)).c;
    }

    public final void b(int v, float f, ae ae0) {
        n7 n70;
        ArrayList arrayList0 = this.a;
        if(this.c != 1) {
            Collections.sort(arrayList0, new A0(6));
            this.c = 1;
        }
        int v1 = this.f;
        n7[] arr_n7 = this.b;
        if(v1 > 0) {
            this.f = v1 - 1;
            n70 = arr_n7[v1 - 1];
        }
        else {
            n70 = new n7();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        int v2 = this.d;
        this.d = v2 + 1;
        n70.a = v2;
        n70.b = v;
        n70.c = f;
        n70.d = ae0;
        arrayList0.add(n70);
        this.e += v;
        int v3;
        while((v3 = this.e) > 2000) {
            n7 n71 = (n7)arrayList0.get(0);
            int v4 = n71.b;
            if(v4 <= v3 - 2000) {
                this.e -= v4;
                arrayList0.remove(0);
                int v5 = this.f;
                if(v5 >= 5) {
                    continue;
                }
                this.f = v5 + 1;
                arr_n7[v5] = n71;
            }
            else {
                n71.b = v4 - (v3 - 2000);
                this.e -= v3 - 2000;
            }
        }
    }

    public final ArrayList c() {
        ArrayList arrayList0 = this.a;
        if(this.c != 1) {
            Collections.sort(arrayList0, new A0(6));
            this.c = 1;
        }
        ArrayList arrayList1 = new ArrayList(arrayList0.size());
        for(Object object0: arrayList0) {
            arrayList1.add(((n7)object0).d);
        }
        return arrayList1;
    }
}

