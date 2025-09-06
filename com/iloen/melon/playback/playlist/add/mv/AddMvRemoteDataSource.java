package com.iloen.melon.playback.playlist.add.mv;

import Ba.Q;
import Ba.x;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001E\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\t\u001A\u00020\bH\u0086@¢\u0006\u0004\b\f\u0010\rJ\u001E\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\n2\u0006\u0010\u000E\u001A\u00020\bH\u0086@¢\u0006\u0004\b\u0010\u0010\rR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/mv/AddMvRemoteDataSource;", "", "LBa/x;", "tvApi", "LBa/Q;", "vodApi", "<init>", "(LBa/x;LBa/Q;)V", "", "songId", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v4x/response/MelonTvVdoStreamInAppRes;", "getMelonTvVdoStreamInApp", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mvId", "Lcom/iloen/melon/net/v4x/response/MelonTvVdoRelateVdoListRes;", "getMelonTvVdoRelateVdoList", "LBa/x;", "LBa/Q;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AddMvRemoteDataSource {
    public static final int $stable;
    @NotNull
    private final x tvApi;
    @NotNull
    private final Q vodApi;

    @Inject
    public AddMvRemoteDataSource(@NotNull x x0, @NotNull Q q0) {
        q.g(x0, "tvApi");
        q.g(q0, "vodApi");
        super();
        this.tvApi = x0;
        this.vodApi = q0;
    }

    @Nullable
    public final Object getMelonTvVdoRelateVdoList(@NotNull String s, @NotNull Continuation continuation0) {
        return this.vodApi.getMelonTvVdoRelateVdoList(s, continuation0);
    }

    @Nullable
    public final Object getMelonTvVdoStreamInApp(@NotNull String s, @NotNull Continuation continuation0) {
        return this.tvApi.getMelonTvVdoStreamInApp(s, continuation0);
    }
}

