package o0;

import androidx.collection.K;
import androidx.media3.session.legacy.V;
import h7.u0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import je.x;
import kotlin.jvm.internal.r;
import we.a;
import we.k;

public final class j implements i {
    public final k a;
    public final K b;
    public K c;

    public j(Map map0, k k0) {
        K k1;
        this.a = k0;
        if(map0 == null || map0.isEmpty()) {
            k1 = null;
        }
        else {
            k1 = new K(map0.size());
            for(Object object0: map0.entrySet()) {
                k1.l(((Map.Entry)object0).getKey(), ((Map.Entry)object0).getValue());
            }
        }
        this.b = k1;
    }

    @Override  // o0.i
    public final boolean a(Object object0) {
        return ((Boolean)this.a.invoke(object0)).booleanValue();
    }

    @Override  // o0.i
    public final Map b() {
        long[] arr_v3;
        long[] arr_v2;
        K k0 = this.b;
        if(k0 == null && this.c == null) {
            return x.a;
        }
        Map map0 = new HashMap((k0 == null ? 0 : k0.e) + (this.c == null ? 0 : this.c.e));
        if(k0 == null) {
        label_27:
            K k1 = this.c;
            if(k1 != null) {
                Object[] arr_object2 = k1.b;
                Object[] arr_object3 = k1.c;
                long[] arr_v1 = k1.a;
                int v7 = arr_v1.length - 2;
                if(v7 >= 0) {
                    int v8 = 0;
                    for(int v = 0; true; v = 0) {
                        long v9 = arr_v1[v8];
                        if((~v9 << 7 & v9 & 0x8080808080808080L) == 0x8080808080808080L) {
                            arr_v3 = arr_v1;
                        }
                        else {
                            int v10 = 8 - (~(v8 - v7) >>> 0x1F);
                            int v11 = 0;
                            while(v11 < v10) {
                                if((v9 & 0xFFL) < 0x80L) {
                                    int v12 = (v8 << 3) + v11;
                                    Object object0 = arr_object2[v12];
                                    List list0 = (List)arr_object3[v12];
                                    String s = (String)object0;
                                    if(list0.size() == 1) {
                                        Object object1 = ((a)list0.get(0)).invoke();
                                        if(object1 != null) {
                                            if(!this.a(object1)) {
                                                throw new IllegalStateException((object1 + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().").toString());
                                            }
                                            map0.put(s, e.k.e(new Object[]{object1}));
                                        }
                                        arr_v2 = arr_v1;
                                    }
                                    else {
                                        int v13 = list0.size();
                                        ArrayList arrayList0 = new ArrayList(v13);
                                        while(v < v13) {
                                            Object object2 = ((a)list0.get(v)).invoke();
                                            if(object2 != null && !this.a(object2)) {
                                                throw new IllegalStateException((object2 + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().").toString());
                                            }
                                            arrayList0.add(object2);
                                            ++v;
                                        }
                                        arr_v2 = arr_v1;
                                        map0.put(s, arrayList0);
                                    }
                                }
                                else {
                                    arr_v2 = arr_v1;
                                }
                                v9 >>= 8;
                                ++v11;
                                arr_v1 = arr_v2;
                                v = 0;
                            }
                            arr_v3 = arr_v1;
                            if(v10 != 8) {
                                break;
                            }
                        }
                        if(v8 == v7) {
                            break;
                        }
                        ++v8;
                        arr_v1 = arr_v3;
                    }
                }
            }
        }
        else {
            Object[] arr_object = k0.b;
            Object[] arr_object1 = k0.c;
            long[] arr_v = k0.a;
            int v1 = arr_v.length - 2;
            if(v1 >= 0) {
                int v2 = 0;
                while(true) {
                    long v3 = arr_v[v2];
                    if((~v3 << 7 & v3 & 0x8080808080808080L) == 0x8080808080808080L) {
                        goto label_24;
                    }
                    int v4 = 8 - (~(v2 - v1) >>> 0x1F);
                    for(int v5 = 0; v5 < v4; ++v5) {
                        if((v3 & 0xFFL) < 0x80L) {
                            int v6 = (v2 << 3) + v5;
                            map0.put(((String)arr_object[v6]), ((List)arr_object1[v6]));
                        }
                        v3 >>= 8;
                    }
                    if(v4 == 8) {
                    label_24:
                        if(v2 != v1) {
                            ++v2;
                            continue;
                        }
                    }
                    goto label_27;
                }
            }
            else {
                goto label_27;
            }
        }
        return map0;
    }

    @Override  // o0.i
    public final Object c(String s) {
        K k0 = this.b;
        List list0 = k0 == null ? null : ((List)k0.j(s));
        if(list0 != null && !list0.isEmpty()) {
            if(list0.size() > 1 && k0 != null) {
                List list1 = list0.subList(1, list0.size());
                int v = k0.f(s);
                if(v < 0) {
                    v = ~v;
                }
                Object[] arr_object = k0.c;
                Object object0 = arr_object[v];
                k0.b[v] = s;
                arr_object[v] = list1;
                List list2 = (List)object0;
            }
            return list0.get(0);
        }
        return null;
    }

    @Override  // o0.i
    public final h d(String s, a a0) {
        int v = s.length();
        for(int v1 = 0; v1 < v; ++v1) {
            if(!u0.K(s.charAt(v1))) {
                K k0 = this.c;
                if(k0 == null) {
                    k0 = new K();
                    this.c = k0;
                }
                ArrayList arrayList0 = k0.g(s);
                if(arrayList0 == null) {
                    arrayList0 = new ArrayList();
                    k0.l(s, arrayList0);
                }
                arrayList0.add(a0);
                h h0 = new V();  // 初始化器: Ljava/lang/Object;-><init>()V
                h0.a = k0;
                h0.b = s;
                h0.c = (r)a0;
                return h0;
            }
        }
        throw new IllegalArgumentException("Registered key is empty or blank");
    }
}

