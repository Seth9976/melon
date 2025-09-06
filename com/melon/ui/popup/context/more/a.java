package com.melon.ui.popup.context.more;

import A7.d;
import U4.x;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import zd.D0;
import zd.M;

public final class a extends D0 {
    public final String a;
    public final List b;
    public final String c;

    public a(String s, List list0, String s1) {
        q.g(s, "title");
        super();
        this.a = s;
        this.b = list0;
        this.c = s1;
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.b));
        for(Object object0: this.b) {
            M m0 = M.p1;
            String s = (String)((m)object0).a;
            String s1 = "";
            if(s == null) {
                s = "";
            }
            String s2 = (String)((m)object0).b;
            if(s2 != null) {
                s1 = s2;
            }
            arrayList0.add(new MelonBottomSheetItem(m0, -1, null, null, new ArtistInfo(s, s1), 28));
        }
        return p.Q0(arrayList0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        if(!q.b(this.a, ((a)object0).a)) {
            return false;
        }
        return q.b(this.b, ((a)object0).b) ? q.b(this.c, ((a)object0).c) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 0x20;
    }

    @Override
    public final int hashCode() {
        int v = d.d(this.a.hashCode() * 0x1F, 0x1F, this.b);
        return this.c == null ? v : v + this.c.hashCode();
    }

    @Override  // zd.D0
    public final String p() {
        return this.c == null ? "" : this.c;
    }

    @Override  // zd.Q
    public final String r() {
        return this.a;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ArtistSelectPopupType(title=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", artistInfoList=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", menuId=");
        return x.m(stringBuilder0, this.c, ")");
    }
}

