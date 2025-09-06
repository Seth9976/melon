package co.ab180.airbridge.internal.e0;

import De.t;
import kotlin.Metadata;
import kotlin.jvm.internal.z;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
final class v extends z {
    public static final t a;

    static {
        v.a = new v();
    }

    public v() {
        super(s.class, "minor", "getMinor()I", 0);
    }

    @Override  // kotlin.jvm.internal.z
    @Nullable
    public Object get(@Nullable Object object0) {
        return ((s)object0).b();
    }
}

