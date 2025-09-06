package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class c {
    public final HashMap a;
    public final HashMap b;

    public c(HashMap hashMap0) {
        this.b = hashMap0;
        this.a = new HashMap();
        for(Object object0: hashMap0.entrySet()) {
            r r0 = (r)((Map.Entry)object0).getValue();
            List list0 = (List)this.a.get(r0);
            if(list0 == null) {
                list0 = new ArrayList();
                this.a.put(r0, list0);
            }
            list0.add(((d)((Map.Entry)object0).getKey()));
        }
    }

    public static void a(List list0, D d0, r r0, Object object0) {
        if(list0 != null) {
            for(int v = list0.size() - 1; v >= 0; --v) {
                d d1 = (d)list0.get(v);
                Method method0 = d1.b;
                try {
                    int v1 = d1.a;
                    switch(v1) {
                        case 0: {
                            method0.invoke(object0, null);
                            break;
                        }
                        case 1: {
                            method0.invoke(object0, d0);
                            break;
                        }
                        default: {
                            if(v1 == 2) {
                                method0.invoke(object0, d0, r0);
                            }
                        }
                    }
                }
                catch(InvocationTargetException invocationTargetException0) {
                    throw new RuntimeException("Failed to call observer method", invocationTargetException0.getCause());
                }
                catch(IllegalAccessException illegalAccessException0) {
                    throw new RuntimeException(illegalAccessException0);
                }
            }
        }
    }
}

