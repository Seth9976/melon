package com.iloen.melon.playback.playlist.add.mv;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001C\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u001C\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001A\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007¨\u0006\u000BÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/mv/AddMVRepository;", "", "getMelonTvVdoStreamInApp", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v4x/response/MelonTvVdoStreamInAppRes;", "songId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMelonTvVdoRelateVdoList", "Lcom/iloen/melon/net/v4x/response/MelonTvVdoRelateVdoListRes;", "mvId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface AddMVRepository {
    @Nullable
    Object getMelonTvVdoRelateVdoList(@NotNull String arg1, @NotNull Continuation arg2);

    @Nullable
    Object getMelonTvVdoStreamInApp(@NotNull String arg1, @NotNull Continuation arg2);
}

