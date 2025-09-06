package d5;

import E9.h;
import E9.w;
import I6.V;
import I6.p0;
import M7.H;
import Me.Q;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.room.O;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.k;
import androidx.work.impl.WorkDatabase_Impl;
import c2.W;
import d2.c;
import ea.a;
import ea.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import je.p;
import jf.l;
import jf.m;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import l4.u;
import qf.e;
import vf.f;

public final class i implements l {
    public Object a;
    public Object b;
    public Object c;
    public Object d;

    public i(p0 p00, v v0, a a0, b b0) {
        V v1 = p00 == null ? p0.e : V.p(p00);
        this.a = v1;
        this.b = v0;
        this.c = a0;
        this.d = b0;
    }

    public i(Object object0, Object object1, Object object2, Object object3) {
        this.a = object0;
        this.b = object1;
        this.c = object2;
        this.d = object3;
        super();
    }

    public i(String s, String s1) {
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new HashSet();
        Bundle bundle0 = new Bundle();
        this.a = bundle0;
        if(s == null) {
            throw new NullPointerException("id must not be null");
        }
        bundle0.putString("id", s);
        if(s1 == null) {
            throw new NullPointerException("name must not be null");
        }
        bundle0.putString("name", s1);
    }

    public void a(ArrayList arrayList0) {
        if(arrayList0 == null) {
            throw new IllegalArgumentException("filters must not be null");
        }
        if(!arrayList0.isEmpty()) {
            for(Object object0: arrayList0) {
                IntentFilter intentFilter0 = (IntentFilter)object0;
                if(intentFilter0 != null) {
                    ArrayList arrayList1 = (ArrayList)this.c;
                    if(!arrayList1.contains(intentFilter0)) {
                        arrayList1.add(intentFilter0);
                    }
                }
            }
        }
    }

    public void b(ArrayList arrayList0) {
        if(!arrayList0.isEmpty()) {
            for(Object object0: arrayList0) {
                String s = (String)object0;
                ArrayList arrayList1 = (ArrayList)this.b;
                if(TextUtils.isEmpty(s)) {
                    throw new IllegalArgumentException("groupMemberId must not be empty");
                }
                if(!arrayList1.contains(s)) {
                    arrayList1.add(s);
                }
            }
        }
    }

    public Flow c(String s, String s1, String s2, String s3, List list0) {
        q.g(s, "playlistId");
        q.g(s2, "playlistName");
        q.g(list0, "selectedList");
        q.g(s3, "ocrGroupId");
        return FlowKt.catch(FlowKt.flow(new Pa.a(list0, this, s, s1, s2, s3, null)), new H(3, 1, null));
    }

    public u d() {
        Bundle bundle0 = (Bundle)this.a;
        bundle0.putParcelableArrayList("controlFilters", new ArrayList(((ArrayList)this.c)));
        bundle0.putStringArrayList("groupMemberIds", new ArrayList(((ArrayList)this.b)));
        bundle0.putStringArrayList("allowedPackages", new ArrayList(((HashSet)this.d)));
        return new u(bundle0);
    }

    public void e(Object object0, ArrayList arrayList0, HashSet hashSet0) {
        if(arrayList0.contains(object0)) {
            return;
        }
        if(hashSet0.contains(object0)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet0.add(object0);
        ArrayList arrayList1 = (ArrayList)((androidx.collection.V)this.b).get(object0);
        if(arrayList1 != null) {
            int v = arrayList1.size();
            for(int v1 = 0; v1 < v; ++v1) {
                this.e(arrayList1.get(v1), arrayList0, hashSet0);
            }
        }
        hashSet0.remove(object0);
        arrayList0.add(object0);
    }

    public g f(j j0) {
        q.g(j0, "id");
        O o0 = O.c(2, "SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?");
        o0.k(1, j0.a);
        o0.a(2, ((long)j0.b));
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        Cursor cursor0 = w.R(workDatabase_Impl0, o0, false);
        try {
            int v1 = h.y(cursor0, "work_spec_id");
            int v2 = h.y(cursor0, "generation");
            int v3 = h.y(cursor0, "system_id");
            return cursor0.moveToFirst() ? new g(cursor0.getString(v1), cursor0.getInt(v2), cursor0.getInt(v3)) : null;
        }
        finally {
            cursor0.close();
            o0.release();
        }
    }

    public void g(g g0) {
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        workDatabase_Impl0.beginTransaction();
        try {
            ((d5.b)this.b).p(g0);
            workDatabase_Impl0.setTransactionSuccessful();
        }
        finally {
            workDatabase_Impl0.endTransaction();
        }
    }

    public boolean h(Q q0) {
        q.g(q0, "descriptor");
        if(!q.b(((Q)this.b), q0)) {
            i i0 = (i)this.a;
            return i0 == null ? false : i0.h(q0);
        }
        return true;
    }

    public void i() {
        int v2;
        k k0 = (k)this.b;
        k k1 = (k)this.a;
        ViewPager2 viewPager20 = (ViewPager2)this.d;
        int v = 0x1020048;
        W.l(viewPager20, 0x1020048);
        boolean z = false;
        W.i(viewPager20, 0);
        W.l(viewPager20, 0x1020049);
        W.i(viewPager20, 0);
        W.l(viewPager20, 0x1020046);
        W.i(viewPager20, 0);
        W.l(viewPager20, 0x1020047);
        W.i(viewPager20, 0);
        if(viewPager20.getAdapter() != null) {
            int v1 = viewPager20.getAdapter().getItemCount();
            if(v1 != 0 && viewPager20.B) {
                if(viewPager20.getOrientation() == 0) {
                    if(viewPager20.g.getLayoutDirection() == 1) {
                        z = true;
                        v2 = 0x1020048;
                    }
                    else {
                        v2 = 0x1020049;
                    }
                    if(z) {
                        v = 0x1020049;
                    }
                    if(viewPager20.d < v1 - 1) {
                        W.m(viewPager20, new c(v2, null), null, k1);
                    }
                    if(viewPager20.d > 0) {
                        W.m(viewPager20, new c(v, null), null, k0);
                    }
                }
                else {
                    if(viewPager20.d < v1 - 1) {
                        W.m(viewPager20, new c(0x1020047, null), null, k1);
                    }
                    if(viewPager20.d > 0) {
                        W.m(viewPager20, new c(0x1020046, null), null, k0);
                    }
                }
            }
        }
    }

    @Override  // jf.l
    public void k() {
        ((H8.q)this.b).k();
        ((ArrayList)((o9.b)this.c).a).add(new vf.a(((Ne.b)p.E0(((ArrayList)this.d)))));
    }

    @Override  // jf.l
    public m l(e e0) {
        return ((H8.q)this.a).l(e0);
    }

    @Override  // jf.l
    public l m(qf.b b0, e e0) {
        return ((H8.q)this.a).m(b0, e0);
    }

    @Override  // jf.l
    public void n(e e0, qf.b b0, e e1) {
        ((H8.q)this.a).n(e0, b0, e1);
    }

    @Override  // jf.l
    public void o(e e0, Object object0) {
        ((H8.q)this.a).o(e0, object0);
    }

    @Override  // jf.l
    public void p(e e0, f f0) {
        ((H8.q)this.a).p(e0, f0);
    }
}

