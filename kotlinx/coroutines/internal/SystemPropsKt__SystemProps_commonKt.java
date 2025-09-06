package kotlinx.coroutines.internal;

import Tf.v;
import com.iloen.melon.utils.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0001H\u0000\u001A,\u0010\u0000\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u0005H\u0000\u001A,\u0010\u0000\u001A\u00020\b2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\b2\b\b\u0002\u0010\u0006\u001A\u00020\b2\b\b\u0002\u0010\u0007\u001A\u00020\bH\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00032\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0000¨\u0006\t"}, d2 = {"systemProp", "", "propertyName", "", "defaultValue", "", "minValue", "maxValue", "", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/internal/SystemPropsKt")
abstract class SystemPropsKt__SystemProps_commonKt {
    public static final int systemProp(@NotNull String s, int v, int v1, int v2) {
        return (int)SystemPropsKt.systemProp(s, ((long)v), ((long)v1), ((long)v2));
    }

    public static final long systemProp(@NotNull String s, long v, long v1, long v2) {
        String s1 = SystemPropsKt.systemProp(s);
        if(s1 == null) {
            return v;
        }
        Long long0 = v.u0(s1);
        if(long0 == null) {
            throw new IllegalStateException(("System property \'" + s + "\' has unrecognized value \'" + s1 + '\'').toString());
        }
        long v3 = (long)long0;
        if(v1 <= v3 && v3 <= v2) {
            return v3;
        }
        StringBuilder stringBuilder0 = new StringBuilder("System property \'");
        stringBuilder0.append(s);
        stringBuilder0.append("\' should be in range ");
        stringBuilder0.append(v1);
        a.s(v2, "..", ", but is \'", stringBuilder0);
        stringBuilder0.append(v3);
        stringBuilder0.append('\'');
        throw new IllegalStateException(stringBuilder0.toString().toString());
    }

    @NotNull
    public static final String systemProp(@NotNull String s, @NotNull String s1) {
        String s2 = SystemPropsKt.systemProp(s);
        return s2 == null ? s1 : s2;
    }

    public static final boolean systemProp(@NotNull String s, boolean z) {
        String s1 = SystemPropsKt.systemProp(s);
        return s1 == null ? z : Boolean.parseBoolean(s1);
    }

    public static int systemProp$default(String s, int v, int v1, int v2, int v3, Object object0) {
        if((v3 & 4) != 0) {
            v1 = 1;
        }
        if((v3 & 8) != 0) {
            v2 = 0x7FFFFFFF;
        }
        return SystemPropsKt.systemProp(s, v, v1, v2);
    }

    public static long systemProp$default(String s, long v, long v1, long v2, int v3, Object object0) {
        if((v3 & 4) != 0) {
            v1 = 1L;
        }
        if((v3 & 8) != 0) {
            v2 = 0x7FFFFFFFFFFFFFFFL;
        }
        return SystemPropsKt.systemProp(s, v, v1, v2);
    }
}

