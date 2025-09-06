package cb;

import Bd.m;
import E9.w;
import Vb.p0;
import com.iloen.melon.playback.playlist.db.d;
import com.iloen.melon.utils.log.LogU;
import com.melon.data.database.MelonDatabase_Impl;
import com.melon.data.database.entity.LocalPlaybackLogEntity;
import d5.n;
import ea.b;
import java.util.Date;
import java.util.List;
import kb.D;
import oe.c;

public final class g {
    public final D a;

    public g(D d0) {
        this.a = d0;
    }

    public final Object a(String s, c c0) {
        a a0;
        if(c0 instanceof a) {
            a0 = (a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new a(this, c0);
        }
        Integer integer0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(integer0);
                try {
                    a0.B = 1;
                    integer0 = new Integer(((int)(((Integer)w.N(((MelonDatabase_Impl)((b)((D)this.a.b).b).a), false, true, new d(s, 7))))));
                    if(integer0 == a1) {
                        return a1;
                    label_18:
                        n.D(integer0);
                    }
                    return new Integer(integer0.intValue());
                }
                catch(Exception unused_ex) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Integer(-1);
    }

    public final Object b(List list0, c c0) {
        cb.b b0;
        if(c0 instanceof cb.b) {
            b0 = (cb.b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new cb.b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new cb.b(this, c0);
        }
        Integer integer0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(integer0);
                try {
                    b0.B = 1;
                    integer0 = this.a.i(list0);
                    if(integer0 == a0) {
                        return a0;
                    label_18:
                        n.D(integer0);
                    }
                    return new Integer(integer0.intValue());
                }
                catch(Exception unused_ex) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Integer(-1);
    }

    public final Object c(int v, c c0) {
        long v3;
        cb.c c1;
        if(c0 instanceof cb.c) {
            c1 = (cb.c)c0;
            int v1 = c1.E;
            if((v1 & 0x80000000) == 0) {
                c1 = new cb.c(this, c0);
            }
            else {
                c1.E = v1 ^ 0x80000000;
            }
        }
        else {
            c1 = new cb.c(this, c0);
        }
        Object object0 = c1.B;
        ne.a a0 = ne.a.a;
        switch(c1.E) {
            case 0: {
                n.D(object0);
                long v2 = System.currentTimeMillis();
                c1.r = v;
                c1.w = v2 - 2678400000L;
                c1.E = 1;
                object0 = this.a(String.valueOf(v2 - 2678400000L), c1);
                if(object0 == a0) {
                    return a0;
                }
                v3 = v2 - 2678400000L;
                break;
            }
            case 1: {
                v3 = c1.w;
                v = c1.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return (List)object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Date date0 = new Date(v3);
        LogU.Companion.d("LocalPlaybackLogUseCase", "fetchPlaybackLog() - beginOfValidTime:" + date0 + ", deleted:" + ((Number)object0).intValue());
        c1.r = v;
        c1.w = v3;
        c1.E = 2;
        object0 = this.d(v, c1);
        return object0 == a0 ? a0 : ((List)object0);
    }

    public final Object d(int v, c c0) {
        cb.d d0;
        if(c0 instanceof cb.d) {
            d0 = (cb.d)c0;
            int v1 = d0.B;
            if((v1 & 0x80000000) == 0) {
                d0 = new cb.d(this, c0);
            }
            else {
                d0.B = v1 ^ 0x80000000;
            }
        }
        else {
            d0 = new cb.d(this, c0);
        }
        List list0 = d0.r;
        ne.a a0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(list0);
                try {
                    d0.B = 1;
                    list0 = (List)w.N(((MelonDatabase_Impl)((b)((D)this.a.b).b).a), true, false, new m(v, 6));
                    return list0 == a0 ? a0 : list0;
                label_19:
                    n.D(list0);
                    return list0;
                }
                catch(Exception unused_ex) {
                    return je.w.a;
                }
            }
            case 1: {
                goto label_19;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object e(c c0) {
        e e0;
        if(c0 instanceof e) {
            e0 = (e)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new e(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new e(this, c0);
        }
        Integer integer0 = e0.r;
        ne.a a0 = ne.a.a;
        int v1 = 0;
        switch(e0.B) {
            case 0: {
                n.D(integer0);
                try {
                    e0.B = 1;
                    Integer integer1 = new Integer(((int)(((Integer)w.N(((MelonDatabase_Impl)((b)((D)this.a.b).b).a), true, false, new dc.c(20))))));
                    if(integer1 == a0) {
                        return a0;
                    }
                    integer0 = integer1;
                    v1 = integer0.intValue();
                    break;
                label_21:
                    n.D(integer0);
                    v1 = integer0.intValue();
                }
                catch(Exception unused_ex) {
                }
                break;
            }
            case 1: {
                goto label_21;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Integer(v1);
    }

    public final Object f(LocalPlaybackLogEntity localPlaybackLogEntity0, c c0) {
        f f0;
        if(c0 instanceof f) {
            f0 = (f)c0;
            int v = f0.B;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, c0);
            }
            else {
                f0.B = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, c0);
        }
        Long long0 = f0.r;
        ne.a a0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                n.D(long0);
                try {
                    f0.B = 1;
                    b b0 = (b)((D)this.a.b).b;
                    localPlaybackLogEntity0.getClass();
                    Long long1 = new Long(((long)(((Long)w.N(((MelonDatabase_Impl)b0.a), false, true, new p0(21, b0, localPlaybackLogEntity0))))));
                    if(long1 == a0) {
                        return a0;
                    }
                    long0 = long1;
                    return new Long(long0.longValue());
                label_22:
                    n.D(long0);
                    return new Long(long0.longValue());
                }
                catch(Exception unused_ex) {
                    break;
                }
            }
            case 1: {
                goto label_22;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Long(-1L);
    }
}

