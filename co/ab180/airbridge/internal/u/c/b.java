package co.ab180.airbridge.internal.u.c;

import android.content.Intent;
import co.ab180.airbridge.common.OnFailure;
import co.ab180.airbridge.common.OnSuccess;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J1\u0010\n\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\u00022\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000BJ+\u0010\n\u001A\u00020\t2\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\fJE\u0010\n\u001A\u00020\u00122\u0006\u0010\u000E\u001A\u00020\r2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000F2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00110\u00042\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u0013¨\u0006\u0014"}, d2 = {"Lco/ab180/airbridge/internal/u/c/b;", "", "Landroid/content/Intent;", "intent", "Lco/ab180/airbridge/common/OnSuccess;", "Landroid/net/Uri;", "onSuccess", "Lco/ab180/airbridge/common/OnFailure;", "onFailure", "", "a", "(Landroid/content/Intent;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "(Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "", "channel", "", "option", "Lco/ab180/airbridge/common/AirbridgeTrackingLink;", "Lie/H;", "(Ljava/lang/String;Ljava/util/Map;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public interface b {
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
    public static final class a {
        public static void a(b b0, String s, Map map0, OnSuccess onSuccess0, OnFailure onFailure0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createTrackingLink");
            }
            if((v & 8) != 0) {
                onFailure0 = null;
            }
            b0.a(s, map0, onSuccess0, onFailure0);
        }

        public static boolean a(b b0, Intent intent0, OnSuccess onSuccess0, OnFailure onFailure0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleDeeplink");
            }
            if((v & 4) != 0) {
                onFailure0 = null;
            }
            return b0.a(intent0, onSuccess0, onFailure0);
        }

        public static boolean a(b b0, OnSuccess onSuccess0, OnFailure onFailure0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleDeferredDeeplink");
            }
            if((v & 2) != 0) {
                onFailure0 = null;
            }
            return b0.a(onSuccess0, onFailure0);
        }
    }

    void a(@NotNull String arg1, @NotNull Map arg2, @NotNull OnSuccess arg3, @Nullable OnFailure arg4);

    boolean a(@NotNull Intent arg1, @NotNull OnSuccess arg2, @Nullable OnFailure arg3);

    boolean a(@NotNull OnSuccess arg1, @Nullable OnFailure arg2);
}

