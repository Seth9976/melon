package co.ab180.airbridge.internal.b0;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001A\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001A\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\bH&¢\u0006\u0004\b\u0007\u0010\tJ\u0013\u0010\u000B\u001A\u00020\nH¦@ø\u0001\u0000¢\u0006\u0004\b\u000B\u0010\u0006JE\u0010\u0005\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\f2\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000E2\u0014\u0010\u0010\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000EH¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0012J\'\u0010\u0005\u001A\u00020\u00152\u0006\u0010\u0013\u001A\u00020\f2\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/internal/b0/i;", "", "", "f", "()Ljava/lang/String;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "Lie/H;", "()V", "Lco/ab180/airbridge/internal/network/model/AppInfo;", "b", "", "locationCollectionEnabled", "", "deviceAlias", "iabtcf", "Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "(ZLjava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chkInstallReferrer", "facebookAppId", "Lco/ab180/airbridge/internal/b0/d;", "(ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public interface i {
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
    public static final class a {
        public static Object a(i i0, boolean z, String s, Continuation continuation0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createEventBodyPart");
            }
            if((v & 2) != 0) {
                s = null;
            }
            return i0.a(z, s, continuation0);
        }
    }

    @Nullable
    Object a(@NotNull Continuation arg1);

    @Nullable
    Object a(boolean arg1, @Nullable String arg2, @NotNull Continuation arg3);

    @Nullable
    Object a(boolean arg1, @NotNull Map arg2, @Nullable Map arg3, @NotNull Continuation arg4);

    @Nullable
    Object b(@NotNull Continuation arg1);

    @Nullable
    Object c(@NotNull Continuation arg1);

    void c();

    @NotNull
    String f();
}

