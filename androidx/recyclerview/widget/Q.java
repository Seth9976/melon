package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

public final class q extends q0 {
    public boolean g;
    public ArrayList h;
    public ArrayList i;
    public ArrayList j;
    public ArrayList k;
    public ArrayList l;
    public ArrayList m;
    public ArrayList n;
    public ArrayList o;
    public ArrayList p;
    public ArrayList q;
    public ArrayList r;
    public static TimeInterpolator s;

    @Override  // androidx.recyclerview.widget.q0
    public final boolean a(O0 o00, O0 o01, p0 p00, p0 p01) {
        int v3;
        int v2;
        int v = p00.a;
        int v1 = p00.b;
        if(o01.shouldIgnore()) {
            v2 = p00.b;
            v3 = p00.a;
        }
        else {
            v3 = p01.a;
            v2 = p01.b;
        }
        if(o00 == o01) {
            return this.g(o00, v, v1, v3, v2);
        }
        float f = o00.itemView.getTranslationX();
        float f1 = o00.itemView.getTranslationY();
        float f2 = o00.itemView.getAlpha();
        this.l(o00);
        o00.itemView.setTranslationX(f);
        o00.itemView.setTranslationY(f1);
        o00.itemView.setAlpha(f2);
        this.l(o01);
        o01.itemView.setTranslationX(((float)(-((int)(((float)(v3 - v)) - f)))));
        o01.itemView.setTranslationY(((float)(-((int)(((float)(v2 - v1)) - f1)))));
        o01.itemView.setAlpha(0.0f);
        ArrayList arrayList0 = this.k;
        o o0 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        o0.a = o00;
        o0.b = o01;
        o0.c = v;
        o0.d = v1;
        o0.e = v3;
        o0.f = v2;
        arrayList0.add(o0);
        return true;
    }

    @Override  // androidx.recyclerview.widget.q0
    public final void d(O0 o00) {
        ArrayList arrayList0 = this.l;
        ArrayList arrayList1 = this.m;
        ArrayList arrayList2 = this.n;
        View view0 = o00.itemView;
        view0.animate().cancel();
        ArrayList arrayList3 = this.j;
        for(int v = arrayList3.size() - 1; v >= 0; --v) {
            if(((p)arrayList3.get(v)).a == o00) {
                view0.setTranslationY(0.0f);
                view0.setTranslationX(0.0f);
                this.c(o00);
                arrayList3.remove(v);
            }
        }
        this.j(this.k, o00);
        if(this.h.remove(o00)) {
            view0.setAlpha(1.0f);
            this.c(o00);
        }
        if(this.i.remove(o00)) {
            view0.setAlpha(1.0f);
            this.c(o00);
        }
        for(int v1 = arrayList2.size() - 1; v1 >= 0; --v1) {
            ArrayList arrayList4 = (ArrayList)arrayList2.get(v1);
            this.j(arrayList4, o00);
            if(arrayList4.isEmpty()) {
                arrayList2.remove(v1);
            }
        }
        for(int v2 = arrayList1.size() - 1; v2 >= 0; --v2) {
            ArrayList arrayList5 = (ArrayList)arrayList1.get(v2);
            for(int v3 = arrayList5.size() - 1; v3 >= 0; --v3) {
                if(((p)arrayList5.get(v3)).a == o00) {
                    view0.setTranslationY(0.0f);
                    view0.setTranslationX(0.0f);
                    this.c(o00);
                    arrayList5.remove(v3);
                    if(arrayList5.isEmpty()) {
                        arrayList1.remove(v2);
                    }
                    break;
                }
            }
        }
        for(int v4 = arrayList0.size() - 1; v4 >= 0; --v4) {
            ArrayList arrayList6 = (ArrayList)arrayList0.get(v4);
            if(arrayList6.remove(o00)) {
                view0.setAlpha(1.0f);
                this.c(o00);
                if(arrayList6.isEmpty()) {
                    arrayList0.remove(v4);
                }
            }
        }
        this.q.remove(o00);
        this.o.remove(o00);
        this.r.remove(o00);
        this.p.remove(o00);
        this.i();
    }

    @Override  // androidx.recyclerview.widget.q0
    public final void e() {
        ArrayList arrayList0 = this.n;
        ArrayList arrayList1 = this.l;
        ArrayList arrayList2 = this.m;
        ArrayList arrayList3 = this.k;
        ArrayList arrayList4 = this.i;
        ArrayList arrayList5 = this.h;
        ArrayList arrayList6 = this.j;
        for(int v = arrayList6.size() - 1; v >= 0; --v) {
            p p0 = (p)arrayList6.get(v);
            View view0 = p0.a.itemView;
            view0.setTranslationY(0.0f);
            view0.setTranslationX(0.0f);
            this.c(p0.a);
            arrayList6.remove(v);
        }
        for(int v1 = arrayList5.size() - 1; v1 >= 0; --v1) {
            this.c(((O0)arrayList5.get(v1)));
            arrayList5.remove(v1);
        }
        for(int v2 = arrayList4.size() - 1; v2 >= 0; --v2) {
            O0 o00 = (O0)arrayList4.get(v2);
            o00.itemView.setAlpha(1.0f);
            this.c(o00);
            arrayList4.remove(v2);
        }
        for(int v3 = arrayList3.size() - 1; v3 >= 0; --v3) {
            o o0 = (o)arrayList3.get(v3);
            O0 o01 = o0.a;
            if(o01 != null) {
                this.k(o0, o01);
            }
            O0 o02 = o0.b;
            if(o02 != null) {
                this.k(o0, o02);
            }
        }
        arrayList3.clear();
        if(!this.f()) {
            return;
        }
        for(int v4 = arrayList2.size() - 1; v4 >= 0; --v4) {
            ArrayList arrayList7 = (ArrayList)arrayList2.get(v4);
            for(int v5 = arrayList7.size() - 1; v5 >= 0; --v5) {
                p p1 = (p)arrayList7.get(v5);
                View view1 = p1.a.itemView;
                view1.setTranslationY(0.0f);
                view1.setTranslationX(0.0f);
                this.c(p1.a);
                arrayList7.remove(v5);
                if(arrayList7.isEmpty()) {
                    arrayList2.remove(arrayList7);
                }
            }
        }
        for(int v6 = arrayList1.size() - 1; v6 >= 0; --v6) {
            ArrayList arrayList8 = (ArrayList)arrayList1.get(v6);
            for(int v7 = arrayList8.size() - 1; v7 >= 0; --v7) {
                O0 o03 = (O0)arrayList8.get(v7);
                o03.itemView.setAlpha(1.0f);
                this.c(o03);
                arrayList8.remove(v7);
                if(arrayList8.isEmpty()) {
                    arrayList1.remove(arrayList8);
                }
            }
        }
        for(int v8 = arrayList0.size() - 1; v8 >= 0; --v8) {
            ArrayList arrayList9 = (ArrayList)arrayList0.get(v8);
            for(int v9 = arrayList9.size() - 1; v9 >= 0; --v9) {
                o o1 = (o)arrayList9.get(v9);
                O0 o04 = o1.a;
                if(o04 != null) {
                    this.k(o1, o04);
                }
                O0 o05 = o1.b;
                if(o05 != null) {
                    this.k(o1, o05);
                }
                if(arrayList9.isEmpty()) {
                    arrayList0.remove(arrayList9);
                }
            }
        }
        q.h(this.q);
        q.h(this.p);
        q.h(this.o);
        q.h(this.r);
        ArrayList arrayList10 = this.b;
        if(arrayList10.size() > 0) {
            throw androidx.appcompat.app.o.g(0, arrayList10);
        }
        arrayList10.clear();
    }

    // 去混淆评级： 中等(110)
    @Override  // androidx.recyclerview.widget.q0
    public final boolean f() {
        return !this.i.isEmpty() || !this.k.isEmpty() || !this.j.isEmpty() || !this.h.isEmpty() || !this.p.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.r.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.n.isEmpty();
    }

    public final boolean g(O0 o00, int v, int v1, int v2, int v3) {
        View view0 = o00.itemView;
        int v4 = v + ((int)view0.getTranslationX());
        int v5 = v1 + ((int)o00.itemView.getTranslationY());
        this.l(o00);
        int v6 = v2 - v4;
        int v7 = v3 - v5;
        if(v6 == 0 && v7 == 0) {
            this.c(o00);
            return false;
        }
        if(v6 != 0) {
            view0.setTranslationX(((float)(-v6)));
        }
        if(v7 != 0) {
            view0.setTranslationY(((float)(-v7)));
        }
        ArrayList arrayList0 = this.j;
        p p0 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
        p0.a = o00;
        p0.b = v4;
        p0.c = v5;
        p0.d = v2;
        p0.e = v3;
        arrayList0.add(p0);
        return true;
    }

    public static void h(ArrayList arrayList0) {
        for(int v = arrayList0.size() - 1; v >= 0; --v) {
            ((O0)arrayList0.get(v)).itemView.animate().cancel();
        }
    }

    public final void i() {
        if(!this.f()) {
            ArrayList arrayList0 = this.b;
            if(arrayList0.size() > 0) {
                throw androidx.appcompat.app.o.g(0, arrayList0);
            }
            arrayList0.clear();
        }
    }

    public final void j(ArrayList arrayList0, O0 o00) {
        for(int v = arrayList0.size() - 1; v >= 0; --v) {
            o o0 = (o)arrayList0.get(v);
            if(this.k(o0, o00) && o0.a == null && o0.b == null) {
                arrayList0.remove(o0);
            }
        }
    }

    public final boolean k(o o0, O0 o00) {
        if(o0.b == o00) {
            o0.b = null;
        }
        else if(o0.a == o00) {
            o0.a = null;
        }
        else {
            return false;
        }
        o00.itemView.setAlpha(1.0f);
        o00.itemView.setTranslationX(0.0f);
        o00.itemView.setTranslationY(0.0f);
        this.c(o00);
        return true;
    }

    public final void l(O0 o00) {
        if(q.s == null) {
            q.s = new ValueAnimator().getInterpolator();
        }
        o00.itemView.animate().setInterpolator(q.s);
        this.d(o00);
    }
}

