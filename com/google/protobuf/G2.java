package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public final class g2 extends LinkedHashMap {
    public boolean a;
    public static final g2 b;

    static {
        g2 g20 = new g2();
        g2.b = g20;
        g20.a = false;
    }

    public g2() {
        this.a = true;
    }

    public static int a(Object object0) {
        if(object0 instanceof byte[]) {
            int v1 = ((byte[])object0).length;
            for(int v = 0; v < ((byte[])object0).length; ++v) {
                v1 = v1 * 0x1F + ((byte[])object0)[v];
            }
            return v1 == 0 ? 1 : v1;
        }
        if(object0 instanceof G1) {
            throw new UnsupportedOperationException();
        }
        return object0.hashCode();
    }

    public final void b() {
        if(!this.a) {
            throw new UnsupportedOperationException();
        }
    }

    public final g2 c() {
        if(this.isEmpty()) {
            return new g2();
        }
        g2 g20 = new g2(this);  // 初始化器: Ljava/util/LinkedHashMap;-><init>(Ljava/util/Map;)V
        g20.a = true;
        return g20;
    }

    @Override
    public final void clear() {
        this.b();
        super.clear();
    }

    // 去混淆评级： 低(20)
    @Override
    public final Set entrySet() {
        return this.isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 instanceof Map) {
            if(this != ((Map)object0)) {
                if(this.size() == ((Map)object0).size()) {
                    Iterator iterator0 = this.entrySet().iterator();
                    while(true) {
                        if(!iterator0.hasNext()) {
                            return true;
                        }
                        Object object1 = iterator0.next();
                        if(!((Map)object0).containsKey(((Map.Entry)object1).getKey())) {
                            break;
                        }
                        Object object2 = ((Map.Entry)object1).getValue();
                        Object object3 = ((Map)object0).get(((Map.Entry)object1).getKey());
                        if((!(object2 instanceof byte[]) || !(object3 instanceof byte[]) ? object2.equals(object3) : Arrays.equals(((byte[])object2), ((byte[])object3)))) {
                            continue;
                        }
                        return false;
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        for(Object object0: this.entrySet()) {
            int v1 = g2.a(((Map.Entry)object0).getKey());
            v += g2.a(((Map.Entry)object0).getValue()) ^ v1;
        }
        return v;
    }

    @Override
    public final Object put(Object object0, Object object1) {
        this.b();
        object0.getClass();
        object1.getClass();
        return super.put(object0, object1);
    }

    @Override
    public final void putAll(Map map0) {
        this.b();
        for(Object object0: map0.keySet()) {
            object0.getClass();
            map0.get(object0).getClass();
        }
        super.putAll(map0);
    }

    @Override
    public final Object remove(Object object0) {
        this.b();
        return super.remove(object0);
    }
}

