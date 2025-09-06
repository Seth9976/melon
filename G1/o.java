package G1;

import F1.e;
import F1.f;
import F1.k;
import U4.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import w7.d;
import y1.c;

public final class o {
    public ArrayList a;
    public int b;
    public int c;
    public ArrayList d;
    public int e;
    public static int f;

    public final void a(ArrayList arrayList0) {
        int v = this.a.size();
        if(this.e != -1 && v > 0) {
            for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
                o o0 = (o)arrayList0.get(v1);
                if(this.e == o0.b) {
                    this.c(this.c, o0);
                }
            }
        }
        if(v == 0) {
            arrayList0.remove(this);
        }
    }

    public final int b(c c0, int v) {
        int v4;
        int v3;
        ArrayList arrayList0 = this.a;
        if(arrayList0.size() == 0) {
            return 0;
        }
        f f0 = (f)((e)arrayList0.get(0)).W;
        c0.t();
        f0.c(c0, false);
        for(int v2 = 0; v2 < arrayList0.size(); ++v2) {
            ((e)arrayList0.get(v2)).c(c0, false);
        }
        if(v == 0 && f0.E0 > 0) {
            k.a(f0, c0, arrayList0, 0);
        }
        if(v == 1 && f0.F0 > 0) {
            k.a(f0, c0, arrayList0, 1);
        }
        try {
            c0.p();
        }
        catch(Exception exception0) {
            System.err.println(exception0.toString() + "\n" + Arrays.toString(exception0.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        this.d = new ArrayList();
        for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
            e e0 = (e)arrayList0.get(v1);
            d d0 = new d(13);
            new WeakReference(e0);
            c.n(e0.K);
            c.n(e0.L);
            c.n(e0.M);
            c.n(e0.N);
            c.n(e0.O);
            this.d.add(d0);
        }
        if(v == 0) {
            v3 = c.n(f0.K);
            v4 = c.n(f0.M);
            c0.t();
            return v4 - v3;
        }
        v3 = c.n(f0.L);
        v4 = c.n(f0.N);
        c0.t();
        return v4 - v3;
    }

    public final void c(int v, o o0) {
        for(Object object0: this.a) {
            e e0 = (e)object0;
            ArrayList arrayList0 = o0.a;
            if(!arrayList0.contains(e0)) {
                arrayList0.add(e0);
            }
            int v1 = o0.b;
            if(v == 0) {
                e0.t0 = v1;
            }
            else {
                e0.u0 = v1;
            }
        }
        this.e = o0.b;
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = this.c;
        if(v == 0) {
            s = "Horizontal";
        }
        else {
            switch(v) {
                case 1: {
                    s = "Vertical";
                    break;
                }
                case 2: {
                    s = "Both";
                    break;
                }
                default: {
                    s = "Unknown";
                }
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append(" [");
        String s1 = x.g(this.b, "] <", stringBuilder0);
        for(Object object0: this.a) {
            StringBuilder stringBuilder1 = x.p(s1, " ");
            stringBuilder1.append(((e)object0).l0);
            s1 = stringBuilder1.toString();
        }
        return s1 + " >";
    }
}

