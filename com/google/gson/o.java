package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.sql.c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public final class o {
    public final Excluder a;
    public final int b;
    public final a c;
    public final HashMap d;
    public final ArrayList e;
    public final ArrayList f;
    public final int g;
    public final int h;
    public final boolean i;
    public final i j;
    public int k;
    public final boolean l;
    public final com.google.gson.C.y m;
    public final com.google.gson.C.z n;
    public final ArrayDeque o;

    public o() {
        this.a = Excluder.c;
        this.b = 1;
        this.c = h.a;
        this.d = new HashMap();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = 2;
        this.h = 2;
        this.i = true;
        this.j = n.m;
        this.k = 0;
        this.l = true;
        this.m = n.o;
        this.n = n.p;
        this.o = new ArrayDeque();
    }

    public final n a() {
        F f2;
        F f1;
        ArrayList arrayList0 = this.e;
        ArrayList arrayList1 = this.f;
        ArrayList arrayList2 = new ArrayList(arrayList1.size() + arrayList0.size() + 3);
        arrayList2.addAll(arrayList0);
        Collections.reverse(arrayList2);
        ArrayList arrayList3 = new ArrayList(arrayList1);
        Collections.reverse(arrayList3);
        arrayList2.addAll(arrayList3);
        boolean z = c.a;
        int v = this.g;
        int v1 = this.h;
        if(v != 2 || v1 != 2) {
            F f0 = com.google.gson.internal.bind.c.b.a(v, v1);
            if(z) {
                f1 = c.c.a(v, v1);
                f2 = c.b.a(v, v1);
            }
            else {
                f1 = null;
                f2 = null;
            }
            arrayList2.add(f0);
            if(z) {
                arrayList2.add(f1);
                arrayList2.add(f2);
            }
        }
        HashMap hashMap0 = new HashMap(this.d);
        int v2 = this.k;
        ArrayList arrayList4 = new ArrayList(arrayList0);
        ArrayList arrayList5 = new ArrayList(arrayList1);
        ArrayList arrayList6 = new ArrayList(this.o);
        return new n(this.a, this.c, hashMap0, this.i, this.j, v2, this.l, this.b, arrayList4, arrayList5, arrayList2, this.m, this.n, arrayList6);
    }
}

