package co.ab180.airbridge.internal.e0;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\u001A3\u0010\u0006\u001A\u00020\u00002\b\u0010\u0001\u001A\u0004\u0018\u00010\u00002\b\u0010\u0002\u001A\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u00002\u0006\u0010\u0005\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "gaid", "appSetId", "backupUUID", "", "hasDataBeforeAppSetIDCollected", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class g {
    @NotNull
    public static final String a(@Nullable String s, @Nullable String s1, @NotNull String s2, boolean z) {
        if(q.b(s, "00000000-0000-0000-0000-000000000000")) {
            s = null;
        }
        if(z) {
            return s == null ? s2 : s;
        }
        if(s != null) {
            s1 = s;
        }
        return s1 == null ? s2 : s1;
    }
}

