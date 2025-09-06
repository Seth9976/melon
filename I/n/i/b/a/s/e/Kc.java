package i.n.i.b.a.s.e;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class kc extends LinkedHashMap {
    public final int a;

    public kc(int v, float f, boolean z, int v1) {
        this.a = v1;
        super(v, f, z);
    }

    @Override
    public final boolean removeEldestEntry(Map.Entry map$Entry0) {
        return this.size() > 4;
    }
}

