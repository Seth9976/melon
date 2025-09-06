package Ic;

import A7.d;
import Ac.m4;
import Cc.U3;
import java.util.List;
import kotlin.jvm.internal.q;
import we.a;

public final class z extends m4 {
    public final s a;
    public final List b;
    public final int c;
    public final a d;
    public final U3 e;

    public z(s s0, List list0, int v, a a0, U3 u30) {
        this.a = s0;
        this.b = list0;
        this.c = v;
        this.d = a0;
        this.e = u30;
    }

    public static z a(z z0, List list0, U3 u30, int v) {
        s s0 = z0.a;
        int v1 = z0.c;
        a a0 = z0.d;
        if((v & 16) != 0) {
            u30 = z0.e;
        }
        z0.getClass();
        q.g(list0, "listUiState");
        return new z(s0, list0, v1, a0, u30);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof z)) {
            return false;
        }
        if(!q.b(this.a, ((z)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((z)object0).b)) {
            return false;
        }
        if(this.c != ((z)object0).c) {
            return false;
        }
        return q.b(this.d, ((z)object0).d) ? q.b(this.e, ((z)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.b(this.c, d.d(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F);
        int v1 = 0;
        int v2 = this.d == null ? 0 : this.d.hashCode();
        U3 u30 = this.e;
        if(u30 != null) {
            v1 = u30.hashCode();
        }
        return (v + v2) * 0x1F + v1;
    }

    @Override
    public final String toString() {
        return "Screen(headerUiState=" + this.a + ", listUiState=" + this.b + ", commentHolderIndex=" + this.c + ", popupAction=" + this.d + ", toolBarUiState=" + this.e + ")";
    }
}

