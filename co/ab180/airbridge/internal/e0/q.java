package co.ab180.airbridge.internal.e0;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u001A8\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"K", "V", "", "a", "(Ljava/util/Map;)Ljava/util/Map;", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class q {
    public static final Map a(Map map0) {
        kotlin.jvm.internal.q.g(map0, "$this$filterIsInstance");
        Map map1 = new LinkedHashMap();
        Iterator iterator0 = map0.entrySet().iterator();
        if(!iterator0.hasNext()) {
            return map1;
        }
        Object object0 = iterator0.next();
        ((Map.Entry)object0).getKey();
        kotlin.jvm.internal.q.k();
        throw null;
    }
}

