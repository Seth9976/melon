package x3;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class b extends LinkedHashMap {
    public final int a;

    public b() {
        this.a = 10;
    }

    @Override
    public final boolean removeEldestEntry(Map.Entry map$Entry0) {
        return this.size() > this.a;
    }
}

