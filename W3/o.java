package w3;

import E1.a;
import java.util.ArrayList;
import java.util.Collections;

public final class o {
    public final int a;
    public final ArrayList b;
    public final n[] c;
    public int d;
    public int e;
    public int f;
    public int g;
    public static final a h;
    public static final a i;

    static {
        o.h = new a(25);
        o.i = new a(26);
    }

    public o(int v) {
        this.a = v;
        this.c = new n[5];
        this.b = new ArrayList();
        this.d = -1;
    }

    public final void a(int v, float f) {
        n n0;
        ArrayList arrayList0 = this.b;
        if(this.d != 1) {
            Collections.sort(arrayList0, o.h);
            this.d = 1;
        }
        int v1 = this.g;
        n[] arr_n = this.c;
        if(v1 > 0) {
            this.g = v1 - 1;
            n0 = arr_n[v1 - 1];
        }
        else {
            n0 = new n();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        int v2 = this.e;
        this.e = v2 + 1;
        n0.a = v2;
        n0.b = v;
        n0.c = f;
        arrayList0.add(n0);
        this.f += v;
        while(true) {
            int v3 = this.f;
            int v4 = this.a;
            if(v3 <= v4) {
                break;
            }
            int v5 = v3 - v4;
            n n1 = (n)arrayList0.get(0);
            int v6 = n1.b;
            if(v6 <= v5) {
                this.f -= v6;
                arrayList0.remove(0);
                int v7 = this.g;
                if(v7 >= 5) {
                    continue;
                }
                this.g = v7 + 1;
                arr_n[v7] = n1;
            }
            else {
                n1.b = v6 - v5;
                this.f -= v5;
            }
        }
    }

    public final float b() {
        ArrayList arrayList0 = this.b;
        if(this.d != 0) {
            Collections.sort(arrayList0, o.i);
            this.d = 0;
        }
        float f = 0.5f * ((float)this.f);
        int v1 = 0;
        for(int v = 0; v < arrayList0.size(); ++v) {
            n n0 = (n)arrayList0.get(v);
            v1 += n0.b;
            if(((float)v1) >= f) {
                return n0.c;
            }
        }
        return arrayList0.isEmpty() ? NaNf : ((n)com.iloen.melon.utils.a.i(1, arrayList0)).c;
    }
}

