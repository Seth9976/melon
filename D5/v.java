package d5;

import A3.g;
import Ba.l;
import D2.E0;
import De.I;
import G4.b;
import I6.V;
import I6.p0;
import V4.k;
import android.database.Cursor;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Trace;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import androidx.datastore.preferences.protobuf.j0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.O;
import androidx.room.z;
import androidx.work.impl.WorkDatabase_Impl;
import c2.B0;
import c2.K;
import c2.W;
import c2.c0;
import com.iloen.melon.custom.S0;
import com.iloen.melon.custom.r1;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import e1.u;
import h7.u0;
import ha.A;
import ha.B;
import ha.C;
import ha.D;
import ha.E;
import ha.f;
import ha.h;
import ha.p;
import ha.r;
import ha.s;
import ha.t;
import ha.w;
import ha.x;
import ha.y;
import i.n.i.b.a.s.e.Ua;
import i.n.i.b.a.s.e.V3;
import i.n.i.b.a.s.e.cd;
import i.n.i.b.a.s.e.e7;
import i.n.i.b.a.s.e.ie;
import i.n.i.b.a.s.e.kd;
import i.n.i.b.a.s.e.va;
import j.a;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;
import jeb.synthetic.FIN;
import kotlin.jvm.internal.q;
import o3.d;
import o3.i;
import o3.m;
import oe.c;
import rf.J;
import rf.j;
import va.e0;
import va.o;

public class v implements b, c2.v, r1, cd, a, i {
    public Object a;
    public Object b;

    public v(E0 e00) {
        this.a = e00;
        this.b = new Object();
    }

    public v(p0 p00, int[] arr_v) {
        this.a = V.p(p00);
        this.b = arr_v;
    }

    public v(z z0, b b0) {
        q.g(b0, "actual");
        this.b = z0;
        this.a = b0;
    }

    public v(Object object0, Object object1) {
        this.a = object0;
        this.b = object1;
        super();
    }

    public v(j j0) {
        Iterator iterator0 = ((j0)j0.a.a.entrySet()).iterator();
        this.a = iterator0;
        if(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            this.b = (Map.Entry)object0;
        }
    }

    public Object A(int v, int v1, String s, String s1, c c0) {
        p p0;
        if(c0 instanceof p) {
            p0 = (p)c0;
            int v2 = p0.B;
            if((v2 & 0x80000000) == 0) {
                p0 = new p(this, c0);
            }
            else {
                p0.B = v2 ^ 0x80000000;
            }
        }
        else {
            p0 = new p(this, c0);
        }
        Object object0 = p0.r;
        ne.a a0 = ne.a.a;
        switch(p0.B) {
            case 0: {
                n.D(object0);
                p0.B = 1;
                object0 = ((l)((S0)this.a).b).D(v, v1, s, s1, p0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object B(int v, int v1, String s, c c0) {
        ha.q q0;
        if(c0 instanceof ha.q) {
            q0 = (ha.q)c0;
            int v2 = q0.B;
            if((v2 & 0x80000000) == 0) {
                q0 = new ha.q(this, c0);
            }
            else {
                q0.B = v2 ^ 0x80000000;
            }
        }
        else {
            q0 = new ha.q(this, c0);
        }
        Object object0 = q0.r;
        ne.a a0 = ne.a.a;
        switch(q0.B) {
            case 0: {
                n.D(object0);
                q0.B = 1;
                object0 = ((l)((S0)this.a).b).t(v, v1, s, q0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object C(c c0) {
        r r0;
        if(c0 instanceof r) {
            r0 = (r)c0;
            int v = r0.B;
            if((v & 0x80000000) == 0) {
                r0 = new r(this, c0);
            }
            else {
                r0.B = v ^ 0x80000000;
            }
        }
        else {
            r0 = new r(this, c0);
        }
        Object object0 = r0.r;
        ne.a a0 = ne.a.a;
        switch(r0.B) {
            case 0: {
                n.D(object0);
                r0.B = 1;
                object0 = ((l)((S0)this.a).b).n(u.v(((e0)o.a()).j()), r0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object D(int v, int v1, String s, c c0) {
        s s1;
        if(c0 instanceof s) {
            s1 = (s)c0;
            int v2 = s1.B;
            if((v2 & 0x80000000) == 0) {
                s1 = new s(this, c0);
            }
            else {
                s1.B = v2 ^ 0x80000000;
            }
        }
        else {
            s1 = new s(this, c0);
        }
        Object object0 = s1.r;
        ne.a a0 = ne.a.a;
        switch(s1.B) {
            case 0: {
                n.D(object0);
                s1.B = 1;
                object0 = ((l)((S0)this.a).b).g(v, v1, s, s1);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object E(String s, c c0) {
        t t0;
        if(c0 instanceof t) {
            t0 = (t)c0;
            int v = t0.B;
            if((v & 0x80000000) == 0) {
                t0 = new t(this, c0);
            }
            else {
                t0.B = v ^ 0x80000000;
            }
        }
        else {
            t0 = new t(this, c0);
        }
        Object object0 = t0.r;
        ne.a a0 = ne.a.a;
        switch(t0.B) {
            case 0: {
                n.D(object0);
                t0.B = 1;
                object0 = ((l)((S0)this.a).b).A(s, t0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object F(String s, c c0) {
        ha.u u0;
        if(c0 instanceof ha.u) {
            u0 = (ha.u)c0;
            int v = u0.B;
            if((v & 0x80000000) == 0) {
                u0 = new ha.u(this, c0);
            }
            else {
                u0.B = v ^ 0x80000000;
            }
        }
        else {
            u0 = new ha.u(this, c0);
        }
        Object object0 = u0.r;
        ne.a a0 = ne.a.a;
        switch(u0.B) {
            case 0: {
                n.D(object0);
                u0.B = 1;
                object0 = ((l)((S0)this.a).b).v(s, u0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object G(String s, String s1, int v, String s2, c c0) {
        ha.v v1;
        if(c0 instanceof ha.v) {
            v1 = (ha.v)c0;
            int v2 = v1.B;
            if((v2 & 0x80000000) == 0) {
                v1 = new ha.v(this, c0);
            }
            else {
                v1.B = v2 ^ 0x80000000;
            }
        }
        else {
            v1 = new ha.v(this, c0);
        }
        Object object0 = v1.r;
        ne.a a0 = ne.a.a;
        switch(v1.B) {
            case 0: {
                n.D(object0);
                v1.B = 1;
                object0 = ((l)((S0)this.a).b).e(s, s1, v, s2, v1);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object H(c c0) {
        w w0;
        if(c0 instanceof w) {
            w0 = (w)c0;
            int v = w0.B;
            if((v & 0x80000000) == 0) {
                w0 = new w(this, c0);
            }
            else {
                w0.B = v ^ 0x80000000;
            }
        }
        else {
            w0 = new w(this, c0);
        }
        Object object0 = w0.r;
        ne.a a0 = ne.a.a;
        switch(w0.B) {
            case 0: {
                n.D(object0);
                w0.B = 1;
                object0 = ((l)((S0)this.a).b).o(w0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object I(String s, c c0) {
        x x0;
        if(c0 instanceof x) {
            x0 = (x)c0;
            int v = x0.B;
            if((v & 0x80000000) == 0) {
                x0 = new x(this, c0);
            }
            else {
                x0.B = v ^ 0x80000000;
            }
        }
        else {
            x0 = new x(this, c0);
        }
        Object object0 = x0.r;
        ne.a a0 = ne.a.a;
        switch(x0.B) {
            case 0: {
                n.D(object0);
                x0.B = 1;
                object0 = ((l)((S0)this.a).b).m(s, x0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object J(int v, int v1, String s, String s1, String s2, c c0) {
        y y0;
        if(c0 instanceof y) {
            y0 = (y)c0;
            int v2 = y0.B;
            if((v2 & 0x80000000) == 0) {
                y0 = new y(this, c0);
            }
            else {
                y0.B = v2 ^ 0x80000000;
            }
        }
        else {
            y0 = new y(this, c0);
        }
        Object object0 = y0.r;
        ne.a a0 = ne.a.a;
        switch(y0.B) {
            case 0: {
                n.D(object0);
                y0.B = 1;
                object0 = ((l)((S0)this.a).b).x(s, v, v1, s1, s2, y0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object K(String s, c c0) {
        ha.z z0;
        if(c0 instanceof ha.z) {
            z0 = (ha.z)c0;
            int v = z0.B;
            if((v & 0x80000000) == 0) {
                z0 = new ha.z(this, c0);
            }
            else {
                z0.B = v ^ 0x80000000;
            }
        }
        else {
            z0 = new ha.z(this, c0);
        }
        Object object0 = z0.r;
        ne.a a0 = ne.a.a;
        switch(z0.B) {
            case 0: {
                n.D(object0);
                z0.B = 1;
                object0 = ((l)((S0)this.a).b).f(s, z0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object L(String s, c c0) {
        A a0;
        if(c0 instanceof A) {
            a0 = (A)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new A(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new A(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                a0.B = 1;
                object0 = ((l)((S0)this.a).b).l(s, a0);
                return object0 == a1 ? a1 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object M(int v, int v1, String s, String s1, String s2, c c0) {
        B b0;
        if(c0 instanceof B) {
            b0 = (B)c0;
            int v2 = b0.B;
            if((v2 & 0x80000000) == 0) {
                b0 = new B(this, c0);
            }
            else {
                b0.B = v2 ^ 0x80000000;
            }
        }
        else {
            b0 = new B(this, c0);
        }
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                b0.B = 1;
                object0 = ((l)((S0)this.a).b).h(v, v1, s, s1, s2, b0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object N(String s, String s1, c c0) {
        C c1;
        if(c0 instanceof C) {
            c1 = (C)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new C(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new C(this, c0);
        }
        Object object0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                c1.B = 1;
                object0 = ((l)((S0)this.a).b).a(s, s1, u.v(((e0)o.a()).j()), u.w(((e0)o.a()).j()), c1);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public ArrayList O(String s) {
        O o0 = O.c(1, "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
        o0.k(1, s);
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        Cursor cursor0 = E9.w.R(workDatabase_Impl0, o0, false);
        try {
            ArrayList arrayList0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                arrayList0.add(cursor0.getString(0));
            }
            return arrayList0;
        }
        finally {
            cursor0.close();
            o0.release();
        }
    }

    public Object P(String s, c c0) {
        D d0;
        if(c0 instanceof D) {
            d0 = (D)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new D(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new D(this, c0);
        }
        Object object0 = d0.r;
        ne.a a0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                d0.B = 1;
                object0 = ((l)((S0)this.a).b).z(s, d0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public void Q() {
        String s = (String)this.a;
        if(((FileChannel)this.b) == null) {
            try {
                File file0 = new File(s);
                File file1 = file0.getParentFile();
                if(file1 != null) {
                    file1.mkdirs();
                }
                FileChannel fileChannel0 = new FileOutputStream(file0).getChannel();
                this.b = fileChannel0;
                if(fileChannel0 != null) {
                    fileChannel0.lock();
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        else {
            return;
        }
        FileChannel fileChannel1 = (FileChannel)this.b;
        if(fileChannel1 != null) {
            fileChannel1.close();
        }
        this.b = null;
        throw new IllegalStateException("Unable to lock file: \'" + s + "\'.", throwable0);
    }

    public Object R(String s, String s1, String s2, c c0) {
        E e0;
        if(c0 instanceof E) {
            e0 = (E)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new E(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new E(this, c0);
        }
        Object object0 = e0.r;
        ne.a a0 = ne.a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                e0.B = 1;
                object0 = ((l)((S0)this.a).b).w(s, s1, s2, e0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public k S(d5.j j0) {
        q.g(j0, "id");
        synchronized(this.b) {
            return ((E0)this.a).c(j0);
        }
    }

    public List T(String s) {
        q.g(s, "workSpecId");
        synchronized(this.b) {
            return ((E0)this.a).d(s);
        }
    }

    public k U(d5.j j0) {
        synchronized(this.b) {
            return ((E0)this.a).e(j0);
        }
    }

    public void V(int v, g g0) {
        Iterator iterator0 = (Iterator)this.a;
        while(true) {
            Map.Entry map$Entry0 = (Map.Entry)this.b;
            if(map$Entry0 == null || ((rf.k)map$Entry0.getKey()).a >= v) {
                break;
            }
            rf.k k0 = (rf.k)((Map.Entry)this.b).getKey();
            Object object0 = ((Map.Entry)this.b).getValue();
            J j0 = k0.b;
            int v1 = k0.a;
            if(k0.c) {
                for(Object object1: ((List)object0)) {
                    if(j0 == J.e) {
                        g0.O(v1, 3);
                        ((rf.a)object1).d(g0);
                        g0.O(v1, 4);
                    }
                    else {
                        g0.O(v1, j0.b);
                        rf.g.k(g0, j0, object1);
                    }
                }
            }
            else if(j0 == J.e) {
                g0.O(v1, 3);
                ((rf.a)object0).d(g0);
                g0.O(v1, 4);
            }
            else {
                g0.O(v1, j0.b);
                rf.g.k(g0, j0, object0);
            }
            if(iterator0.hasNext()) {
                Object object2 = iterator0.next();
                this.b = (Map.Entry)object2;
            }
            else {
                this.b = null;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.cd
    public kd a() {
        return new e(10, ((cd)this.a).a(), ((List)this.b));
    }

    public ie b(int v) {
        for(int v1 = 0; true; ++v1) {
            int[] arr_v = (int[])this.a;
            if(v1 >= arr_v.length) {
                break;
            }
            if(v == arr_v[v1]) {
                return ((e7[])this.b)[v1];
            }
        }
        Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + v);
        return new V3();
    }

    public Object c(String s, String s1, c c0) {
        ha.b b0;
        if(c0 instanceof ha.b) {
            b0 = (ha.b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new ha.b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new ha.b(this, c0);
        }
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                b0.B = 1;
                object0 = ((l)((S0)this.a).b).u(s, s1, u.v(((e0)o.a()).j()), b0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // j.a
    public boolean d(j.b b0, Menu menu0) {
        return ((a)this.a).d(b0, menu0);
    }

    @Override  // j.a
    public void e(j.b b0) {
        ((a)this.a).e(b0);
        androidx.appcompat.app.D d0 = (androidx.appcompat.app.D)this.b;
        if(d0.M != null) {
            d0.l.getDecorView().removeCallbacks(d0.N);
        }
        if(d0.I != null) {
            c0 c00 = d0.S;
            if(c00 != null) {
                c00.b();
            }
            c0 c01 = W.a(d0.I);
            c01.a(0.0f);
            d0.S = c01;
            c01.d(new androidx.appcompat.app.r(this, 2));
        }
        ((androidx.appcompat.app.i)d0.n).onSupportActionModeFinished(d0.G);
        d0.G = null;
        K.c(d0.V);
        d0.J();
    }

    @Override  // j.a
    public boolean f(j.b b0, MenuItem menuItem0) {
        return ((a)this.a).f(b0, menuItem0);
    }

    public boolean g(d5.j j0) {
        synchronized(this.b) {
            return ((E0)this.a).a.containsKey(j0);
        }
    }

    public P0.c0 h(E9.u u0) {
        P0.c0 c01;
        MediaCodec mediaCodec0;
        String s = ((m)u0.a).a;
        P0.c0 c00 = null;
        try {
            Trace.beginSection(("createCodec:" + s));
            mediaCodec0 = null;
            mediaCodec0 = MediaCodec.createByCodecName(s);
            d d0 = new d(mediaCodec0, ((HandlerThread)((o3.b)this.b).get()));
            c01 = new P0.c0(mediaCodec0, ((HandlerThread)((o3.b)this.a).get()), d0, ((d5.m)u0.f));
        }
        catch(Exception exception0) {
            goto label_17;
        }
        try {
            Trace.endSection();
            Surface surface0 = (Surface)u0.d;
            boolean z = surface0 != null || !((m)u0.a).h;
            P0.c0.b(c01, ((MediaFormat)u0.b), surface0, ((MediaCrypto)u0.e), 0);
            return c01;
        }
        catch(Exception exception0) {
            c00 = c01;
        }
    label_17:
        if(c00 != null) {
            c00.release();
        }
        else if(mediaCodec0 != null) {
            mediaCodec0.release();
        }
        throw exception0;
    }

    public Object i(String s, String s1, String s2, String s3, String s4, c c0) {
        ha.c c1;
        if(c0 instanceof ha.c) {
            c1 = (ha.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new ha.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new ha.c(this, c0);
        }
        Object object0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                c1.B = 1;
                l l0 = (l)((S0)this.a).b;
                if(s1 == null) {
                    s1 = "";
                }
                object0 = l0.q(s, s1, "add", s2, s3, s4, c1);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // o3.i
    public o3.j j(E9.u u0) {
        return this.h(u0);
    }

    @Override  // G4.b
    public G4.a k(String s) {
        G4.a a0;
        int v1;
        q.g(s, "fileName");
        z z0 = (z)this.b;
        if(!s.equals(":memory:")) {
            s = z0.c.a.getDatabasePath(s).getAbsolutePath();
            q.d(s);
        }
        boolean z1 = true;
        y4.b b0 = new y4.b(s, !z0.a && !z0.b && !s.equals(":memory:"));
        ReentrantLock reentrantLock0 = b0.a;
        reentrantLock0.lock();
        v v0 = b0.b;
        if(v0 != null) {
            try {
                v0.Q();
            }
            catch(Throwable throwable0) {
                z1 = false;
                goto label_46;
            }
        }
        try {
            v1 = FIN.finallyOpen$NT();
            if(z0.b) {
                FIN.finallyExec$NT(v1);
                throw new IllegalStateException("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?");
            }
            a0 = ((b)this.a).k(s);
            if(z0.a) {
                if(z0.c.g == androidx.room.D.c) {
                    u0.w("PRAGMA synchronous = NORMAL", a0);
                }
                else {
                    u0.w("PRAGMA synchronous = FULL", a0);
                }
                z.b(a0);
                z0.d.onOpen(a0);
            }
            else {
                try {
                    z0.b = true;
                    z.a(z0, a0);
                }
                finally {
                    z0.b = false;
                }
            }
            FIN.finallyCodeBegin$NT(v1);
            if(v0 != null) {
                FileChannel fileChannel0 = (FileChannel)v0.b;
                if(fileChannel0 != null) {
                    try {
                        fileChannel0.close();
                    }
                    finally {
                        v0.b = null;
                    }
                }
            }
            goto label_52;
        }
        catch(Throwable throwable0) {
        }
        try {
        label_46:
            if(!z1) {
                throw new IllegalStateException("Unable to open database \'" + s + "\'. Was a proper path / name used in Room\'s database builder?", throwable0);
            }
            throw throwable0;
        }
        catch(Throwable throwable1) {
        }
        reentrantLock0.unlock();
        throw throwable1;
    label_52:
        FIN.finallyCodeEnd$NT(v1);
        reentrantLock0.unlock();
        return a0;
    }

    public Object l(String s, c c0) {
        ha.d d0;
        if(c0 instanceof ha.d) {
            d0 = (ha.d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new ha.d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new ha.d(this, c0);
        }
        Object object0 = d0.r;
        ne.a a0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                d0.B = 1;
                object0 = ((l)((S0)this.a).b).i(s, d0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // j.a
    public boolean m(j.b b0, Menu menu0) {
        K.c(((androidx.appcompat.app.D)this.b).V);
        return ((a)this.a).m(b0, menu0);
    }

    public Object n(String s, String s1, c c0) {
        ha.e e0;
        if(c0 instanceof ha.e) {
            e0 = (ha.e)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new ha.e(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new ha.e(this, c0);
        }
        Object object0 = e0.r;
        ne.a a0 = ne.a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                e0.B = 1;
                object0 = ((l)((S0)this.a).b).s(s, s1, e0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object o(int v, int v1, String s, c c0) {
        f f0;
        if(c0 instanceof f) {
            f0 = (f)c0;
            int v2 = f0.B;
            if((v2 & 0x80000000) == 0) {
                f0 = new f(this, c0);
            }
            else {
                f0.B = v2 ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, c0);
        }
        Object object0 = f0.r;
        ne.a a0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                n.D(object0);
                f0.B = 1;
                object0 = ((l)((S0)this.a).b).k(v, v1, s, f0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // com.iloen.melon.custom.r1
    public void onToolBarAnimationEnd(boolean z) {
        V4.u.F(((RecyclerView)this.b));
    }

    @Override  // com.iloen.melon.custom.r1
    public void onToolBarAnimationStart(boolean z) {
        I.V(((Hc.w)this.a), true, true);
    }

    public Object p(int v, int v1, String s, c c0) {
        ha.g g0;
        if(c0 instanceof ha.g) {
            g0 = (ha.g)c0;
            int v2 = g0.B;
            if((v2 & 0x80000000) == 0) {
                g0 = new ha.g(this, c0);
            }
            else {
                g0.B = v2 ^ 0x80000000;
            }
        }
        else {
            g0 = new ha.g(this, c0);
        }
        Object object0 = g0.r;
        ne.a a0 = ne.a.a;
        switch(g0.B) {
            case 0: {
                n.D(object0);
                g0.B = 1;
                object0 = ((l)((S0)this.a).b).c(v, v1, s, g0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object q(int v, int v1, String s, String s1, c c0) {
        h h0;
        if(c0 instanceof h) {
            h0 = (h)c0;
            int v2 = h0.B;
            if((v2 & 0x80000000) == 0) {
                h0 = new h(this, c0);
            }
            else {
                h0.B = v2 ^ 0x80000000;
            }
        }
        else {
            h0 = new h(this, c0);
        }
        Object object0 = h0.r;
        ne.a a0 = ne.a.a;
        switch(h0.B) {
            case 0: {
                n.D(object0);
                h0.B = 1;
                object0 = ((l)((S0)this.a).b).j(v, v1, s, s1, h0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object r(int v, int v1, String s, c c0) {
        ha.i i0;
        if(c0 instanceof ha.i) {
            i0 = (ha.i)c0;
            int v2 = i0.B;
            if((v2 & 0x80000000) == 0) {
                i0 = new ha.i(this, c0);
            }
            else {
                i0.B = v2 ^ 0x80000000;
            }
        }
        else {
            i0 = new ha.i(this, c0);
        }
        Object object0 = i0.r;
        ne.a a0 = ne.a.a;
        switch(i0.B) {
            case 0: {
                n.D(object0);
                i0.B = 1;
                object0 = ((l)((S0)this.a).b).B(v, v1, s, i0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // c2.v
    public B0 s(View view0, B0 b00) {
        com.google.android.material.internal.D d0 = (com.google.android.material.internal.D)this.a;
        com.google.android.material.internal.E e0 = (com.google.android.material.internal.E)this.b;
        com.google.android.material.internal.E e1 = new com.google.android.material.internal.E();  // 初始化器: Ljava/lang/Object;-><init>()V
        e1.a = e0.a;
        e1.b = e0.b;
        e1.c = e0.c;
        e1.d = e0.d;
        return d0.k(view0, b00, e1);
    }

    public Object t(int v, int v1, String s, c c0) {
        ha.j j0;
        if(c0 instanceof ha.j) {
            j0 = (ha.j)c0;
            int v2 = j0.B;
            if((v2 & 0x80000000) == 0) {
                j0 = new ha.j(this, c0);
            }
            else {
                j0.B = v2 ^ 0x80000000;
            }
        }
        else {
            j0 = new ha.j(this, c0);
        }
        Object object0 = j0.r;
        ne.a a0 = ne.a.a;
        switch(j0.B) {
            case 0: {
                n.D(object0);
                j0.B = 1;
                object0 = ((l)((S0)this.a).b).b(v, v1, s, j0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.cd
    public kd u(va va0, Ua ua0) {
        return new e(10, ((cd)this.a).u(va0, ua0), ((List)this.b));
    }

    public Object v(int v, int v1, String s, String s1, c c0) {
        ha.k k0;
        if(c0 instanceof ha.k) {
            k0 = (ha.k)c0;
            int v2 = k0.B;
            if((v2 & 0x80000000) == 0) {
                k0 = new ha.k(this, c0);
            }
            else {
                k0.B = v2 ^ 0x80000000;
            }
        }
        else {
            k0 = new ha.k(this, c0);
        }
        Object object0 = k0.r;
        ne.a a0 = ne.a.a;
        switch(k0.B) {
            case 0: {
                n.D(object0);
                k0.B = 1;
                object0 = ((l)((S0)this.a).b).r(v, v1, s, s1, k0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object w(String s, c c0) {
        ha.l l0;
        if(c0 instanceof ha.l) {
            l0 = (ha.l)c0;
            int v = l0.B;
            if((v & 0x80000000) == 0) {
                l0 = new ha.l(this, c0);
            }
            else {
                l0.B = v ^ 0x80000000;
            }
        }
        else {
            l0 = new ha.l(this, c0);
        }
        Object object0 = l0.r;
        ne.a a0 = ne.a.a;
        switch(l0.B) {
            case 0: {
                n.D(object0);
                l0.B = 1;
                object0 = ((l)((S0)this.a).b).d(s, u.v(((e0)o.a()).j()), l0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object x(int v, int v1, String s, String s1, c c0) {
        ha.m m0;
        if(c0 instanceof ha.m) {
            m0 = (ha.m)c0;
            int v2 = m0.B;
            if((v2 & 0x80000000) == 0) {
                m0 = new ha.m(this, c0);
            }
            else {
                m0.B = v2 ^ 0x80000000;
            }
        }
        else {
            m0 = new ha.m(this, c0);
        }
        Object object0 = m0.r;
        ne.a a0 = ne.a.a;
        switch(m0.B) {
            case 0: {
                n.D(object0);
                m0.B = 1;
                object0 = ((l)((S0)this.a).b).C(v, v1, s, s1, m0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object y(String s, c c0) {
        ha.n n0;
        if(c0 instanceof ha.n) {
            n0 = (ha.n)c0;
            int v = n0.B;
            if((v & 0x80000000) == 0) {
                n0 = new ha.n(this, c0);
            }
            else {
                n0.B = v ^ 0x80000000;
            }
        }
        else {
            n0 = new ha.n(this, c0);
        }
        Object object0 = n0.r;
        ne.a a0 = ne.a.a;
        switch(n0.B) {
            case 0: {
                n.D(object0);
                n0.B = 1;
                object0 = ((l)((S0)this.a).b).y(s, n0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object z(int v, int v1, String s, String s1, c c0) {
        ha.o o0;
        if(c0 instanceof ha.o) {
            o0 = (ha.o)c0;
            int v2 = o0.B;
            if((v2 & 0x80000000) == 0) {
                o0 = new ha.o(this, c0);
            }
            else {
                o0.B = v2 ^ 0x80000000;
            }
        }
        else {
            o0 = new ha.o(this, c0);
        }
        Object object0 = o0.r;
        ne.a a0 = ne.a.a;
        switch(o0.B) {
            case 0: {
                n.D(object0);
                o0.B = 1;
                object0 = ((l)((S0)this.a).b).p(v, v1, s, s1, o0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

