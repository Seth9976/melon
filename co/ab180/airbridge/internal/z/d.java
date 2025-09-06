package co.ab180.airbridge.internal.z;

import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u001A2\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0002H\u0080\u0004¢\u0006\u0004\b\u0004\u0010\u0005\u001A$\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0080\b¢\u0006\u0004\b\u0004\u0010\u0006\u001A.\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0001*\u0006\u0012\u0002\b\u00030\u00012\u0010\u0010\b\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0007H\u0080\u0004¢\u0006\u0004\b\u0004\u0010\t¨\u0006\n"}, d2 = {"T", "Lco/ab180/airbridge/internal/z/c;", "LDe/d;", "clazz", "a", "(Lco/ab180/airbridge/internal/z/c;LDe/d;)Lco/ab180/airbridge/internal/z/c;", "(Lco/ab180/airbridge/internal/z/c;)Lco/ab180/airbridge/internal/z/c;", "", "classes", "(Lco/ab180/airbridge/internal/z/c;[LDe/d;)Lco/ab180/airbridge/internal/z/c;", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class d {
    public static final c a(c c0) {
        q.g(c0, "$this$bind");
        q.k();
        throw null;
    }

    @NotNull
    public static final c a(@NotNull c c0, @NotNull De.d d0) {
        c0.m().add(df.d.v(d0).getName());
        return c0;
    }

    @NotNull
    public static final c a(@NotNull c c0, @NotNull De.d[] arr_d) {
        HashSet hashSet0 = c0.m();
        ArrayList arrayList0 = new ArrayList(arr_d.length);
        for(int v = 0; v < arr_d.length; ++v) {
            arrayList0.add(df.d.v(arr_d[v]).getName());
        }
        hashSet0.addAll(arrayList0);
        return c0;
    }
}

