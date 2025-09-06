package lc;

import com.iloen.melon.playback.Playable;
import e.k;
import e1.b;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import je.p;
import je.w;
import kotlin.jvm.internal.q;
import nc.C0;
import oc.O;
import oc.j0;

public final class h {
    public static boolean a(int v, O o0) {
        q.g(o0, "curState");
        return o0.d().contains(v);
    }

    public static j0 b(List list0, O o0) {
        q.g(list0, "indices");
        q.g(o0, "curState");
        if(list0.isEmpty()) {
            return new j0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        if(list0.size() != p.T0(list0).size()) {
            return new j0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        if(!(list0 instanceof Collection) || !list0.isEmpty()) {
            for(Object object0: list0) {
                int v = ((Number)object0).intValue();
                if(v < 0 || v >= b.B(o0).size()) {
                    return new j0();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    public static int c(O o0) {
        q.g(o0, "curState");
        int v = o0.b();
        List list0 = o0.d();
        int v1 = list0.indexOf(v);
        return v1 == -1 ? -1 : ((Number)list0.get((v1 + 1) % list0.size())).intValue();
    }

    public static int d(O o0) {
        q.g(o0, "curState");
        int v = o0.b();
        List list0 = o0.d();
        int v1 = list0.indexOf(v);
        return v1 == -1 ? -1 : ((Number)list0.get((list0.size() + (v1 - 1)) % list0.size())).intValue();
    }

    public static List e(List list0, int v, List list1) {
        q.g(list0, "selectRepeatTrackIdList");
        q.g(list1, "playableList");
        List list2 = null;
        if(!list0.isEmpty() && p.d0(list0, (((Playable)p.n0(v, list1)) == null ? null : ""))) {
            HashMap hashMap0 = new HashMap();
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, list1));
            int v1 = 0;
            Iterator iterator0 = list1.iterator();
            while(iterator0.hasNext()) {
                iterator0.next();
                if(v1 >= 0) {
                    hashMap0.put("", v1);
                    arrayList0.add(H.a);
                    ++v1;
                    continue;
                }
                k.O();
                throw null;
            }
            ArrayList arrayList1 = new ArrayList();
            for(Object object0: list0) {
                Integer integer0 = (Integer)hashMap0.get(((String)object0));
                if(integer0 != null) {
                    arrayList1.add(integer0);
                }
            }
            List list3 = p.I0(arrayList1);
            if(list3.size() > 1) {
                list2 = list3;
            }
            if(list2 != null) {
                return list2;
            }
        }
        return w.a;
    }

    public static List f(List list0, int v, List list1) {
        q.g(list0, "selectRepeatSongIdList");
        q.g(list1, "playableList");
        List list2 = null;
        if(!list0.isEmpty() && p.d0(list0, (((Playable)p.n0(v, list1)) == null ? null : ""))) {
            HashMap hashMap0 = new HashMap();
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, list1));
            int v1 = 0;
            Iterator iterator0 = list1.iterator();
            while(iterator0.hasNext()) {
                iterator0.next();
                if(v1 >= 0) {
                    hashMap0.put("", v1);
                    arrayList0.add(H.a);
                    ++v1;
                    continue;
                }
                k.O();
                throw null;
            }
            ArrayList arrayList1 = new ArrayList();
            for(Object object0: list0) {
                Integer integer0 = (Integer)hashMap0.get(((String)object0));
                if(integer0 != null) {
                    arrayList1.add(integer0);
                }
            }
            List list3 = p.I0(arrayList1);
            if(list3.size() > 1) {
                list2 = list3;
            }
            if(list2 != null) {
                return list2;
            }
        }
        return w.a;
    }

    public static ArrayList g(C0 c00) {
        q.g(c00, "curState");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: c00.d) {
            String s = ((Playable)p.n0(((Number)object0).intValue(), b.B(c00))) == null ? null : "";
            if(s != null) {
                arrayList0.add(s);
            }
        }
        return arrayList0;
    }

    public static ArrayList h(O o0) {
        q.g(o0, "curState");
        Iterable iterable0 = o0.d();
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            String s = ((Playable)p.n0(((Number)object0).intValue(), b.B(o0))) == null ? null : "";
            if(s != null) {
                arrayList0.add(s);
            }
        }
        return arrayList0;
    }

    public static boolean i(O o0) {
        q.g(o0, "curState");
        return !o0.d().isEmpty();
    }
}

