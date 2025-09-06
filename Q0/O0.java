package Q0;

import E4.d;
import H8.i;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import d5.f;
import ie.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import je.C;
import kotlinx.coroutines.flow.MutableStateFlow;
import o0.j;

public final class o0 implements d {
    public final int a;
    public final Object b;

    public o0(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // E4.d
    public final Bundle a() {
        switch(this.a) {
            case 0: {
                Map map0 = ((j)this.b).b();
                Bundle bundle0 = new Bundle();
                for(Object object0: map0.entrySet()) {
                    String s = (String)((Map.Entry)object0).getKey();
                    List list0 = (List)((Map.Entry)object0).getValue();
                    bundle0.putParcelableArrayList(s, (list0 instanceof ArrayList ? ((ArrayList)list0) : new ArrayList(list0)));
                }
                return bundle0;
            }
            case 1: {
                i i0 = (i)this.b;
                for(Object object1: C.Z(((LinkedHashMap)i0.e)).entrySet()) {
                    String s1 = (String)((Map.Entry)object1).getKey();
                    i0.y(((MutableStateFlow)((Map.Entry)object1).getValue()).getValue(), s1);
                }
                for(Object object2: C.Z(((LinkedHashMap)i0.c)).entrySet()) {
                    String s2 = (String)((Map.Entry)object2).getKey();
                    i0.y(((d)((Map.Entry)object2).getValue()).a(), s2);
                }
                LinkedHashMap linkedHashMap0 = (LinkedHashMap)i0.b;
                if(linkedHashMap0.isEmpty()) {
                    return f.j(((m[])Arrays.copyOf(new m[0], 0)));
                }
                ArrayList arrayList0 = new ArrayList(linkedHashMap0.size());
                for(Object object3: linkedHashMap0.entrySet()) {
                    arrayList0.add(new m(((String)((Map.Entry)object3).getKey()), ((Map.Entry)object3).getValue()));
                }
                m[] arr_m = (m[])arrayList0.toArray(new m[0]);
                return f.j(((m[])Arrays.copyOf(arr_m, arr_m.length)));
            }
            default: {
                return ComponentActivity._init_$lambda$4(((ComponentActivity)this.b));
            }
        }
    }
}

