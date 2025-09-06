package G1;

import java.util.ArrayList;

public class g implements e {
    public p a;
    public boolean b;
    public boolean c;
    public final p d;
    public int e;
    public int f;
    public int g;
    public int h;
    public h i;
    public boolean j;
    public final ArrayList k;
    public final ArrayList l;

    public g(p p0) {
        this.a = null;
        this.b = false;
        this.c = false;
        this.e = 1;
        this.h = 1;
        this.i = null;
        this.j = false;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.d = p0;
    }

    @Override  // G1.e
    public final void a(e e0) {
        ArrayList arrayList0 = this.l;
        for(Object object0: arrayList0) {
            if(!((g)object0).j) {
                return;
            }
            if(false) {
                break;
            }
        }
        this.c = true;
        p p0 = this.a;
        if(p0 != null) {
            p0.a(this);
        }
        if(this.b) {
            this.d.a(this);
            return;
        }
        g g0 = null;
        int v = 0;
        for(Object object1: arrayList0) {
            g g1 = (g)object1;
            if(!(g1 instanceof h)) {
                ++v;
                g0 = g1;
            }
        }
        if(g0 == null || v != 1 || !g0.j) {
        label_32:
            p p1 = this.a;
            if(p1 != null) {
                p1.a(this);
            }
        }
        else {
            h h0 = this.i;
            if(h0 == null) {
                this.d(g0.g + this.f);
                goto label_32;
            }
            else if(h0.j) {
                this.f = this.h * h0.g;
                this.d(g0.g + this.f);
                goto label_32;
            }
        }
    }

    public final void b(p p0) {
        this.k.add(p0);
        if(this.j) {
            p0.a(p0);
        }
    }

    public final void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void d(int v) {
        if(!this.j) {
            this.j = true;
            this.g = v;
            for(Object object0: this.k) {
                ((e)object0).a(((e)object0));
            }
        }
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.d.b.l0);
        stringBuilder0.append(":");
        switch(this.e) {
            case 1: {
                s = "UNKNOWN";
                break;
            }
            case 2: {
                s = "HORIZONTAL_DIMENSION";
                break;
            }
            case 3: {
                s = "VERTICAL_DIMENSION";
                break;
            }
            case 4: {
                s = "LEFT";
                break;
            }
            case 5: {
                s = "RIGHT";
                break;
            }
            case 6: {
                s = "TOP";
                break;
            }
            case 7: {
                s = "BOTTOM";
                break;
            }
            case 8: {
                s = "BASELINE";
                break;
            }
            default: {
                s = "null";
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append("(");
        Integer integer0 = this.j ? this.g : "unresolved";
        stringBuilder0.append(integer0);
        stringBuilder0.append(") <t=");
        stringBuilder0.append(this.l.size());
        stringBuilder0.append(":d=");
        stringBuilder0.append(this.k.size());
        stringBuilder0.append(">");
        return stringBuilder0.toString();
    }
}

