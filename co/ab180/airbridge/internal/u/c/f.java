package co.ab180.airbridge.internal.u.c;

import co.ab180.airbridge.common.OnFailure;
import co.ab180.airbridge.common.OnSuccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J5\u0010\n\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\u00022\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000BJ5\u0010\f\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\u00022\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\f\u0010\u000B¨\u0006\r"}, d2 = {"Lco/ab180/airbridge/internal/u/c/f;", "", "", "trackingLink", "Lco/ab180/airbridge/common/OnSuccess;", "Lie/H;", "onSuccess", "Lco/ab180/airbridge/common/OnFailure;", "onFailure", "", "c", "(Ljava/lang/String;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "b", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public interface f {
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
    public static final class a {
        public static boolean a(f f0, String s, OnSuccess onSuccess0, OnFailure onFailure0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: click");
            }
            if((v & 2) != 0) {
                onSuccess0 = null;
            }
            if((v & 4) != 0) {
                onFailure0 = null;
            }
            return f0.b(s, onSuccess0, onFailure0);
        }

        public static boolean b(f f0, String s, OnSuccess onSuccess0, OnFailure onFailure0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: impression");
            }
            if((v & 2) != 0) {
                onSuccess0 = null;
            }
            if((v & 4) != 0) {
                onFailure0 = null;
            }
            return f0.c(s, onSuccess0, onFailure0);
        }
    }

    boolean b(@NotNull String arg1, @Nullable OnSuccess arg2, @Nullable OnFailure arg3);

    boolean c(@NotNull String arg1, @Nullable OnSuccess arg2, @Nullable OnFailure arg3);
}

