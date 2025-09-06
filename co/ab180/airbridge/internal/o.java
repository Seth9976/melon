package co.ab180.airbridge.internal;

import co.ab180.airbridge.internal.w.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001B\u0010\u0004\u001A\u00020\u00022\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001A\u00020\u00022\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H&\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\u0004\u001A\u00020\u0006H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0004\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH&\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0004\u001A\u0004\u0018\u00010\u00062\b\u0010\u0010\u001A\u0004\u0018\u00010\u0006H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0004\u0010\u0011J\u0015\u0010\u0012\u001A\u0004\u0018\u00010\u0006H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0012\u0010\fJ#\u0010\u0004\u001A\u00020\u00152\u0006\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00020\u0006H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0004\u0010\u0016J3\u0010\u0004\u001A\u00020\r2\u001E\u0010\u0019\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0018\u0012\u0004\u0012\u00020\r0\u0017H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0004\u0010\u001AJ\u0019\u0010\u000E\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001BH&\u00A2\u0006\u0004\b\u000E\u0010\u001DJ\u0019\u0010\u0004\u001A\u00020\u001B2\b\b\u0002\u0010\u001E\u001A\u00020\u001BH&\u00A2\u0006\u0004\b\u0004\u0010\u001DJ\u0017\u0010\u001F\u001A\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u001BH&\u00A2\u0006\u0004\b\u001F\u0010 J\u0013\u0010\u000E\u001A\u00020\rH\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u000E\u0010\fJ\u001B\u0010\u0004\u001A\u00020\u00062\u0006\u0010\"\u001A\u00020!H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0004\u0010#J\u0013\u0010\u001F\u001A\u00020\rH\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u001F\u0010\fJ7\u0010\u0004\u001A\u00020\u00062\u0006\u0010%\u001A\u00020$2\b\u0010&\u001A\u0004\u0018\u00010\u00062\u0006\u0010\'\u001A\u00020\u00062\b\u0010)\u001A\u0004\u0018\u00010(H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0004\u0010*J\u0019\u0010\u0012\u001A\u00020\r2\b\u0010+\u001A\u0004\u0018\u00010\u0006H&\u00A2\u0006\u0004\b\u0012\u0010,J\u0019\u0010\u000E\u001A\u00020\r2\b\u0010-\u001A\u0004\u0018\u00010\u0006H&\u00A2\u0006\u0004\b\u000E\u0010,J\u0019\u0010\u001F\u001A\u00020\r2\b\u0010.\u001A\u0004\u0018\u00010\u0006H&\u00A2\u0006\u0004\b\u001F\u0010,J!\u0010\u0004\u001A\u00020\r2\u0006\u0010/\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u0001H&\u00A2\u0006\u0004\b\u0004\u00100J\u000F\u0010\u0004\u001A\u00020\rH&\u00A2\u0006\u0004\b\u0004\u0010\u000FJ!\u0010\u0004\u001A\u00020\r2\u0006\u0010/\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u0006H&\u00A2\u0006\u0004\b\u0004\u00101J\u000F\u0010\u0012\u001A\u00020\rH&\u00A2\u0006\u0004\b\u0012\u0010\u000FJ\u000F\u0010\b\u001A\u00020\rH&\u00A2\u0006\u0004\b\b\u0010\u000FJ\u001F\u0010\u001F\u001A\u00020\r2\u0006\u0010/\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\u001F\u00101J\u0017\u0010\u0004\u001A\u00020\r2\u0006\u0010/\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\u0004\u0010,J\u000F\u0010\u001F\u001A\u00020\rH&\u00A2\u0006\u0004\b\u001F\u0010\u000FJ/\u0010\u0004\u001A\u0002042\u0006\u00102\u001A\u00020\u00062\u0012\u00103\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0018H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0004\u00105\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u00066"}, d2 = {"Lco/ab180/airbridge/internal/o;", "", "", "value", "a", "(Ljava/lang/Boolean;)Z", "", "link", "e", "(Ljava/lang/String;)Z", "f", "()Ljava/lang/String;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lie/H;", "c", "()V", "dataString", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "trackingLink", "touchPointType", "Lco/ab180/airbridge/internal/network/response/TrackingLinkResult;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "onSuccess", "(Lwe/k;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "(J)J", "timeInMillis", "b", "(J)Z", "Lco/ab180/airbridge/internal/w/b;", "eventSeed", "(Lco/ab180/airbridge/internal/w/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "priority", "tag", "message", "", "throwable", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "id", "(Ljava/lang/String;)V", "email", "phone", "key", "(Ljava/lang/String;Ljava/lang/Object;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "channel", "params", "Lco/ab180/airbridge/common/AirbridgeTrackingLink;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public interface o {
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
    public static final class a {
        public static long a(o o0, long v, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateBackgroundedTimestamp");
            }
            if((v1 & 1) != 0) {
                v = System.currentTimeMillis();
            }
            return o0.a(v);
        }

        public static boolean a(o o0, Boolean boolean0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: firstOpen");
            }
            if((v & 1) != 0) {
                boolean0 = null;
            }
            return o0.a(boolean0);
        }

        public static long b(o o0, long v, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateEventTransmitIntervalTimestamp");
            }
            if((v1 & 1) != 0) {
                v = System.currentTimeMillis();
            }
            return o0.c(v);
        }
    }

    long a(long arg1);

    @Nullable
    Object a(int arg1, @Nullable String arg2, @NotNull String arg3, @Nullable Throwable arg4, @NotNull Continuation arg5);

    @Nullable
    Object a(@NotNull b arg1, @NotNull Continuation arg2);

    @Nullable
    Object a(@NotNull String arg1, @NotNull String arg2, @NotNull Continuation arg3);

    @Nullable
    Object a(@NotNull String arg1, @NotNull Map arg2, @NotNull Continuation arg3);

    @Nullable
    Object a(@Nullable String arg1, @NotNull Continuation arg2);

    @Nullable
    Object a(@NotNull Continuation arg1);

    @Nullable
    Object a(@NotNull k arg1, @NotNull Continuation arg2);

    void a();

    void a(@NotNull String arg1);

    void a(@NotNull String arg1, @Nullable Object arg2);

    void a(@NotNull String arg1, @Nullable String arg2);

    boolean a(@Nullable Boolean arg1);

    @Nullable
    Object b(@NotNull Continuation arg1);

    void b();

    void b(@Nullable String arg1);

    void b(@NotNull String arg1, @NotNull String arg2);

    boolean b(long arg1);

    long c(long arg1);

    @Nullable
    Object c(@NotNull Continuation arg1);

    void c();

    void c(@Nullable String arg1);

    @Nullable
    Object d(@NotNull Continuation arg1);

    void d();

    void d(@Nullable String arg1);

    void e();

    boolean e(@Nullable String arg1);

    @NotNull
    String f();
}

