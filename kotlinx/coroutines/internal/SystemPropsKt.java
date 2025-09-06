package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, k = 4, mv = {2, 1, 0}, xi = 0x30)
public abstract class SystemPropsKt {
    // 去混淆评级： 低(20)
    public static final int getAVAILABLE_PROCESSORS() [...] // 潜在的解密器

    public static final int systemProp(@NotNull String s, int v, int v1, int v2) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(s, v, v1, v2);
    }

    public static final long systemProp(@NotNull String s, long v, long v1, long v2) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(s, v, v1, v2);
    }

    @Nullable
    public static final String systemProp(@NotNull String s) {
        return SystemPropsKt__SystemPropsKt.systemProp(s);
    }

    @NotNull
    public static final String systemProp(@NotNull String s, @NotNull String s1) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(s, s1);
    }

    public static final boolean systemProp(@NotNull String s, boolean z) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(s, z);
    }
}

