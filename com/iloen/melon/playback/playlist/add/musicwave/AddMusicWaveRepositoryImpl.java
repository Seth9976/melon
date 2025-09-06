package com.iloen.melon.playback.playlist.add.musicwave;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\fH\u0096@¢\u0006\u0002\u0010\u000FR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/musicwave/AddMusicWaveRepositoryImpl;", "Lcom/iloen/melon/playback/playlist/add/musicwave/AddMusicWaveRepository;", "dataSource", "Lcom/iloen/melon/playback/playlist/add/musicwave/AddMusicWaveDataSource;", "<init>", "(Lcom/iloen/melon/playback/playlist/add/musicwave/AddMusicWaveDataSource;)V", "getDataSource", "()Lcom/iloen/melon/playback/playlist/add/musicwave/AddMusicWaveDataSource;", "getMusicWavePlayInfo", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v6x/response/MusicWavePlayInfoRes;", "id", "", "type", "t", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AddMusicWaveRepositoryImpl implements AddMusicWaveRepository {
    public static final int $stable = 8;
    @NotNull
    private final AddMusicWaveDataSource dataSource;

    @Inject
    public AddMusicWaveRepositoryImpl(@NotNull AddMusicWaveDataSource addMusicWaveDataSource0) {
        q.g(addMusicWaveDataSource0, "dataSource");
        super();
        this.dataSource = addMusicWaveDataSource0;
    }

    @NotNull
    public final AddMusicWaveDataSource getDataSource() {
        return this.dataSource;
    }

    @Override  // com.iloen.melon.playback.playlist.add.musicwave.AddMusicWaveRepository
    @Nullable
    public Object getMusicWavePlayInfo(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull Continuation continuation0) {
        return this.dataSource.getMusicWavePlayInfo(s, s1, s2, continuation0);
    }
}

