package pc;

import A7.d;
import U4.x;
import android.content.Context;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import d5.n;
import java.util.ArrayList;
import kc.L1;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.c;

public final class p1 extends w1 {
    public final String c;
    public final String d;
    public final StatsElementsBase e;
    public n1 f;

    public p1(String s, String s1, StatsElementsBase statsElementsBase0) {
        q.g(s1, "menuId");
        super();
        this.c = s;
        this.d = s1;
        this.e = statsElementsBase0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof p1)) {
            return false;
        }
        if(!q.b(this.c, ((p1)object0).c)) {
            return false;
        }
        return q.b(this.d, ((p1)object0).d) ? q.b(this.e, ((p1)object0).e) : false;
    }

    @Override  // pc.w1
    public final Object h(String s, String s1, Continuation continuation0) {
        o1 o10;
        if(continuation0 instanceof o1) {
            o10 = (o1)continuation0;
            int v = o10.E;
            if((v & 0x80000000) == 0) {
                o10 = new o1(this, ((c)continuation0));
            }
            else {
                o10.E = v ^ 0x80000000;
            }
        }
        else {
            o10 = new o1(this, ((c)continuation0));
        }
        Object object0 = o10.B;
        a a0 = a.a;
        switch(o10.E) {
            case 0: {
                n.D(object0);
                o10.r = s;
                o10.w = s1;
                o10.E = 1;
                object0 = ((L1)this.b).d(this.c, "1", o10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                s1 = o10.w;
                s = o10.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ArrayList arrayList0 = Playable.makeList(((StreamGetSongInfoRes)ApiResultKt.getOrThrow(((ApiResult)object0))).response.contentsInfo, s1, null, this.e);
        q.d(arrayList0);
        n1 n10 = new n1(arrayList0, this.e, false);
        this.f = n10;
        o10.r = null;
        o10.w = null;
        o10.E = 2;
        Object object1 = n10.h(s, s1, o10);
        return object1 == a0 ? a0 : object1;
    }

    @Override
    public final int hashCode() {
        int v = x.b(this.c.hashCode() * 0x1F, 0x1F, this.d);
        return this.e == null ? v : v + this.e.hashCode();
    }

    @Override  // pc.w1
    public final Object j(d1 d10, Context context0, String s, Continuation continuation0) {
        n1 n10 = this.f;
        if(n10 != null) {
            return n10.j(d10, context0, s, continuation0);
        }
        q.m("songsType");
        throw null;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("SongsBySongId(songIdsWithCommaDivider=", this.c, ", menuId=", this.d, ", statsElement=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

