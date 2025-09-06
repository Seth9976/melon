package com.iloen.melon.playback.playlist.add.musicwave;

import Ba.B;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0006H\u0086@¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/musicwave/AddMusicWaveDataSource;", "", "LBa/B;", "api", "<init>", "(LBa/B;)V", "", "id", "type", "t", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v6x/response/MusicWavePlayInfoRes;", "getMusicWavePlayInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LBa/B;", "getApi", "()LBa/B;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AddMusicWaveDataSource {
    public static final int $stable = 8;
    @NotNull
    private final B api;

    @Inject
    public AddMusicWaveDataSource(@NotNull B b0) {
        q.g(b0, "api");
        super();
        this.api = b0;
    }

    @NotNull
    public final B getApi() {
        return this.api;
    }

    @Nullable
    public final Object getMusicWavePlayInfo(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull Continuation continuation0) {
        return this.api.getMusicWavePlayInfo(s, s1, s2, continuation0);
    }
}

