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

public final class b1 extends w1 {
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final StatsElementsBase g;
    public Z0 h;

    public b1(String s, String s1, String s2, String s3, StatsElementsBase statsElementsBase0) {
        q.g(s, "playlistId");
        q.g(s3, "menuId");
        super();
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = s3;
        this.g = statsElementsBase0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof b1)) {
            return false;
        }
        if(!q.b(this.c, ((b1)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((b1)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((b1)object0).e)) {
            return false;
        }
        return q.b(this.f, ((b1)object0).f) ? q.b(this.g, ((b1)object0).g) : false;
    }

    @Override  // pc.w1
    public final Object h(String s, String s1, Continuation continuation0) {
        a1 a10;
        if(continuation0 instanceof a1) {
            a10 = (a1)continuation0;
            int v = a10.E;
            if((v & 0x80000000) == 0) {
                a10 = new a1(this, ((c)continuation0));
            }
            else {
                a10.E = v ^ 0x80000000;
            }
        }
        else {
            a10 = new a1(this, ((c)continuation0));
        }
        Object object0 = a10.B;
        a a0 = a.a;
        switch(a10.E) {
            case 0: {
                n.D(object0);
                a10.r = s;
                a10.w = s1;
                a10.E = 1;
                object0 = ((L1)this.b).d(this.d, "1", a10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                s1 = a10.w;
                s = a10.r;
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
        ArrayList arrayList0 = Playable.makeList(((StreamGetSongInfoRes)ApiResultKt.getOrThrow(((ApiResult)object0))).response.contentsInfo, s1, null, this.g);
        q.d(arrayList0);
        Z0 z00 = new Z0(this.g, this.c, this.e, arrayList0);
        this.h = z00;
        a10.r = null;
        a10.w = null;
        a10.E = 2;
        Object object1 = z00.h(s, s1, a10);
        return object1 == a0 ? a0 : object1;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(x.b(this.c.hashCode() * 0x1F, 0x1F, this.d), 0x1F, this.e), 0x1F, this.f);
        return this.g == null ? v : v + this.g.hashCode();
    }

    @Override  // pc.w1
    public final Object j(d1 d10, Context context0, String s, Continuation continuation0) {
        Z0 z00 = this.h;
        if(z00 != null) {
            return z00.j(d10, context0, s, continuation0);
        }
        q.m("mixPlaylistType");
        throw null;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("MixPlaylistBySongId(playlistId=", this.c, ", songIdsWithCommaDivider=", this.d, ", title=");
        d.u(stringBuilder0, this.e, ", menuId=", this.f, ", statsElement=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

