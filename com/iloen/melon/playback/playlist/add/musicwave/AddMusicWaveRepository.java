package com.iloen.melon.playback.playlist.add.musicwave;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H¦@¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/musicwave/AddMusicWaveRepository;", "", "getMusicWavePlayInfo", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v6x/response/MusicWavePlayInfoRes;", "id", "", "type", "t", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface AddMusicWaveRepository {
    @Nullable
    Object getMusicWavePlayInfo(@NotNull String arg1, @NotNull String arg2, @NotNull String arg3, @NotNull Continuation arg4);
}

