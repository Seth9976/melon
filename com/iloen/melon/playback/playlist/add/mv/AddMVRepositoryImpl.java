package com.iloen.melon.playback.playlist.add.mv;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001C\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001A\u00020\nH\u0096@¢\u0006\u0002\u0010\u000BJ\u001C\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u000E\u001A\u00020\nH\u0096@¢\u0006\u0002\u0010\u000BR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/mv/AddMVRepositoryImpl;", "Lcom/iloen/melon/playback/playlist/add/mv/AddMVRepository;", "remoteDatasource", "Lcom/iloen/melon/playback/playlist/add/mv/AddMvRemoteDataSource;", "<init>", "(Lcom/iloen/melon/playback/playlist/add/mv/AddMvRemoteDataSource;)V", "getMelonTvVdoStreamInApp", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v4x/response/MelonTvVdoStreamInAppRes;", "songId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMelonTvVdoRelateVdoList", "Lcom/iloen/melon/net/v4x/response/MelonTvVdoRelateVdoListRes;", "mvId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AddMVRepositoryImpl implements AddMVRepository {
    public static final int $stable;
    @NotNull
    private final AddMvRemoteDataSource remoteDatasource;

    @Inject
    public AddMVRepositoryImpl(@NotNull AddMvRemoteDataSource addMvRemoteDataSource0) {
        q.g(addMvRemoteDataSource0, "remoteDatasource");
        super();
        this.remoteDatasource = addMvRemoteDataSource0;
    }

    @Override  // com.iloen.melon.playback.playlist.add.mv.AddMVRepository
    @Nullable
    public Object getMelonTvVdoRelateVdoList(@NotNull String s, @NotNull Continuation continuation0) {
        return this.remoteDatasource.getMelonTvVdoRelateVdoList(s, continuation0);
    }

    @Override  // com.iloen.melon.playback.playlist.add.mv.AddMVRepository
    @Nullable
    public Object getMelonTvVdoStreamInApp(@NotNull String s, @NotNull Continuation continuation0) {
        return this.remoteDatasource.getMelonTvVdoStreamInApp(s, continuation0);
    }
}

