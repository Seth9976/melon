package co.ab180.airbridge.internal.a0;

import co.ab180.airbridge.internal.network.body.EventBody;
import co.ab180.airbridge.internal.network.body.EventChunk;
import co.ab180.airbridge.internal.network.body.ReportChunk;
import co.ab180.airbridge.internal.network.model.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J/\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001B\u0010\u0007\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u000BJ#\u0010\u0007\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\rJ\u001B\u0010\u000E\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u000E\u0010\u000BJ7\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u00022\u0006\u0010\u0012\u001A\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0013J\u001B\u0010\u0007\u001A\u00020\u00162\u0006\u0010\u0015\u001A\u00020\u0014H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0017J#\u0010\u0007\u001A\u00020\u001C2\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u001AH¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u001DJ+\u0010\u0007\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020 H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lco/ab180/airbridge/internal/a0/a;", "", "", "channel", "", "params", "Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkInfo;", "a", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackingLink", "Lco/ab180/airbridge/internal/network/response/TrackingLinkResult;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchPointType", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "deviceUUID", "installEventUUID", "", "timeout", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lco/ab180/airbridge/internal/network/body/EventBody;", "body", "Lco/ab180/airbridge/internal/network/response/DeferredDeeplinkResult;", "(Lco/ab180/airbridge/internal/network/body/EventBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "requestedAt", "Lco/ab180/airbridge/internal/network/body/EventChunk;", "chunk", "Lco/ab180/airbridge/internal/e0/d0;", "(JLco/ab180/airbridge/internal/network/body/EventChunk;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lco/ab180/airbridge/internal/network/model/d;", "logLevel", "Lco/ab180/airbridge/internal/network/body/ReportChunk;", "(Lco/ab180/airbridge/internal/network/model/d;JLco/ab180/airbridge/internal/network/body/ReportChunk;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public interface a {
    @Nullable
    Object a(long arg1, @NotNull EventChunk arg2, @NotNull Continuation arg3);

    @Nullable
    Object a(@NotNull EventBody arg1, @NotNull Continuation arg2);

    @Nullable
    Object a(@NotNull d arg1, long arg2, @NotNull ReportChunk arg3, @NotNull Continuation arg4);

    @Nullable
    Object a(@NotNull String arg1, @NotNull String arg2, int arg3, @NotNull Continuation arg4);

    @Nullable
    Object a(@NotNull String arg1, @NotNull String arg2, @NotNull Continuation arg3);

    @Nullable
    Object a(@NotNull String arg1, @NotNull Map arg2, @NotNull Continuation arg3);

    @Nullable
    Object a(@NotNull String arg1, @NotNull Continuation arg2);

    @Nullable
    Object b(@NotNull String arg1, @NotNull Continuation arg2);
}

