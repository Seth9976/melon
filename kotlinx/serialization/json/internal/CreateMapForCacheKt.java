package kotlinx.serialization.json.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001A(\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"createMapForCache", "", "K", "V", "initialCapacity", "", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class CreateMapForCacheKt {
    @NotNull
    public static final Map createMapForCache(int v) {
        return new ConcurrentHashMap(v);
    }
}

