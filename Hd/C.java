package hd;

import Tf.v;
import androidx.fragment.app.FragmentActivity;
import com.iloen.melon.popup.CommonFilterPopup.Companion;
import com.iloen.melon.popup.CommonFilterPopup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import je.p;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.q;
import v9.j;
import we.k;

public abstract class c {
    public static void a(FragmentActivity fragmentActivity0, List list0, String s, String s1, boolean z, k k0) {
        q.g(list0, "logMonthList");
        q.g(s, "currentMonth");
        if(list0.isEmpty()) {
            return;
        }
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        ArrayList arrayList0 = new ArrayList();
        HashMap hashMap0 = new HashMap();
        int v = 0;
        int v1 = 0;
        for(Object object0: list0) {
            String s2 = (String)object0;
            if(s2.length() == 6) {
                String s3 = s2.substring(0, 4);
                q.f(s3, "substring(...)");
                String s4 = s2.substring(4, s2.length());
                q.f(s4, "substring(...)");
                linkedHashSet0.add(s3 + "년");
                if(v1 != linkedHashSet0.size()) {
                    arrayList0 = new ArrayList();
                }
                j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                j0.b = v.t0(s4) + "월";
                j0.c = s4;
                arrayList0.add(j0);
                hashMap0.put(s3 + "년", arrayList0);
                v1 = linkedHashSet0.size();
            }
        }
        ArrayList arrayList1 = new ArrayList(linkedHashSet0);
        ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
        for(Object object1: arrayList1) {
            j j1 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j1.b = (String)object1;
            j1.e = (List)hashMap0.get(((String)object1));
            arrayList2.add(j1);
        }
        List list1 = p.P0(arrayList2);
        F f0 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
        F f1 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
        if(s.length() > 0 && s.length() == 6) {
            String s5 = s.substring(0, 4);
            q.f(s5, "substring(...)");
            String s6 = s.substring(4, s.length());
            q.f(s6, "substring(...)");
            int v2 = 0;
            Iterator iterator2 = arrayList1.iterator();
            while(true) {
                if(!iterator2.hasNext()) {
                    v2 = -1;
                    break;
                }
                Object object2 = iterator2.next();
                q.d(((String)object2));
                q.f("년", "getString(...)");
                if(s5.equals(v.p0(((String)object2), "년", ""))) {
                    break;
                }
                ++v2;
            }
            f0.a = v2;
            if(v2 < 0) {
                f0.a = 0;
            }
            ArrayList arrayList3 = (ArrayList)hashMap0.get(arrayList1.get(f0.a));
            if(arrayList3 != null) {
                Iterator iterator3 = arrayList3.iterator();
                while(true) {
                    if(!iterator3.hasNext()) {
                        v = -1;
                        break;
                    }
                    Object object3 = iterator3.next();
                    if(s6.equals(((j)object3).c)) {
                        break;
                    }
                    ++v;
                }
            }
            f1.a = v;
        }
        int v3 = f0.a;
        int v4 = f1.a;
        b b0 = new b(z, f0, f1, arrayList1, hashMap0, fragmentActivity0, k0);
        Companion.newInstance$default(CommonFilterPopup.Companion, 0x7F1307D1, "LIST_TYPE_DEPTH_TWO_HORIZONTAL", list1, v3, v4, 0, b0, 0x20, null).show(fragmentActivity0.getSupportFragmentManager(), s1);  // string:order_by "정렬"
    }
}

