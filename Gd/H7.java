package gd;

import A7.d;
import Ac.m4;
import U4.x;
import java.util.List;
import je.w;
import k8.Y;
import kotlin.jvm.internal.q;

public final class h7 extends m4 {
    public final boolean a;
    public final boolean b;
    public final List c;
    public final List d;
    public final List e;
    public final boolean f;
    public final String g;
    public final List h;
    public final int i;

    public h7(List list0, List list1, String s, int v) {
        this(true, false, w.a, list0, list1, false, s, w.a, v);
    }

    public h7(boolean z, boolean z1, List list0, List list1, List list2, boolean z2, String s, List list3, int v) {
        this.a = z;
        this.b = z1;
        this.c = list0;
        this.d = list1;
        this.e = list2;
        this.f = z2;
        this.g = s;
        this.h = list3;
        this.i = v;
    }

    public static h7 a(h7 h70, boolean z, boolean z1, List list0, List list1, boolean z2, String s, List list2, int v, int v1) {
        if((v1 & 1) != 0) {
            z = h70.a;
        }
        if((v1 & 2) != 0) {
            z1 = h70.b;
        }
        if((v1 & 4) != 0) {
            list0 = h70.c;
        }
        if((v1 & 8) != 0) {
            list1 = h70.d;
        }
        List list3 = h70.e;
        if((v1 & 0x20) != 0) {
            z2 = h70.f;
        }
        List list4 = (v1 & 0x80) == 0 ? list2 : h70.h;
        h70.getClass();
        q.g(list0, "selectedTagList");
        q.g(list1, "list");
        q.g(list3, "recommendList");
        q.g(list4, "relatedTagList");
        return new h7(z, z1, list0, list1, list3, z2, ((v1 & 0x40) == 0 ? s : h70.g), list4, ((v1 & 0x100) == 0 ? v : h70.i));
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h7)) {
            return false;
        }
        if(this.a != ((h7)object0).a) {
            return false;
        }
        if(this.b != ((h7)object0).b) {
            return false;
        }
        if(!q.b(this.c, ((h7)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((h7)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((h7)object0).e)) {
            return false;
        }
        if(this.f != ((h7)object0).f) {
            return false;
        }
        if(!q.b(this.g, ((h7)object0).g)) {
            return false;
        }
        return q.b(this.h, ((h7)object0).h) ? this.i == ((h7)object0).i : false;
    }

    @Override
    public final int hashCode() {
        int v = d.e(d.d(d.d(d.d(d.e(Boolean.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f);
        return this.g == null ? this.i + d.d(v * 0x1F, 0x1F, this.h) : this.i + d.d((v + this.g.hashCode()) * 0x1F, 0x1F, this.h);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Y.q("Success(showInputLayout=", ", showCloseButton=", this.a, ", selectedTagList=", this.b);
        stringBuilder0.append(this.c);
        stringBuilder0.append(", list=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", recommendList=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", showRelatedTagList=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", searchKeyword=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", relatedTagList=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", currentOrderIndex=");
        return x.g(this.i, ")", stringBuilder0);
    }
}

