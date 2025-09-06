package com.iloen.melon.playback.playlist.musicwave;

import com.melon.net.ApiResult;
import ie.H;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\f\u001A\u00020\u000B2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/playback/playlist/musicwave/MusicWavePlaylistRepositoryImpl;", "Lcom/iloen/melon/playback/playlist/musicwave/MusicWavePlaylistRepository;", "Lcom/iloen/melon/playback/playlist/musicwave/MusicWavePlaylistRemoteDataSource;", "remoteDataSource", "<init>", "(Lcom/iloen/melon/playback/playlist/musicwave/MusicWavePlaylistRemoteDataSource;)V", "", "memberKey", "id", "type", "songId", "Lie/H;", "enterMusicWaveChannel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/iloen/melon/playback/playlist/musicwave/MusicWavePlaylistRemoteDataSource;", "getRemoteDataSource", "()Lcom/iloen/melon/playback/playlist/musicwave/MusicWavePlaylistRemoteDataSource;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWavePlaylistRepositoryImpl implements MusicWavePlaylistRepository {
    public static final int $stable = 8;
    @NotNull
    private final MusicWavePlaylistRemoteDataSource remoteDataSource;

    @Inject
    public MusicWavePlaylistRepositoryImpl(@NotNull MusicWavePlaylistRemoteDataSource musicWavePlaylistRemoteDataSource0) {
        q.g(musicWavePlaylistRemoteDataSource0, "remoteDataSource");
        super();
        this.remoteDataSource = musicWavePlaylistRemoteDataSource0;
    }

    @Override  // com.iloen.melon.playback.playlist.musicwave.MusicWavePlaylistRepository
    public void enterMusicWaveChannel(@Nullable String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s1, "id");
        q.g(s2, "type");
        q.g(s3, "songId");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(s, s1, s2, s3, null) {
            final String $id;
            final String $memberKey;
            final String $songId;
            final String $type;
            int I$0;
            private Object L$0;
            Object L$1;
            int label;

            {
                MusicWavePlaylistRepositoryImpl.this = musicWavePlaylistRepositoryImpl0;
                this.$memberKey = s;
                this.$id = s1;
                this.$type = s2;
                this.$songId = s3;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.playback.playlist.musicwave.MusicWavePlaylistRepositoryImpl.enterMusicWaveChannel.1(MusicWavePlaylistRepositoryImpl.this, this.$memberKey, this.$id, this.$type, this.$songId, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.musicwave.MusicWavePlaylistRepositoryImpl.enterMusicWaveChannel.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        try {
                            this.L$0 = null;
                            this.L$1 = null;
                            this.I$0 = 0;
                            this.label = 1;
                            object0 = MusicWavePlaylistRepositoryImpl.this.getRemoteDataSource().enterMusicWaveChannel(this.$memberKey, this.$id, this.$type, this.$songId, this);
                            if(object0 == a0) {
                                return a0;
                            }
                            goto label_14;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 1: {
                        CoroutineScope coroutineScope1 = (CoroutineScope)this.L$1;
                        try {
                            d5.n.D(object0);
                        label_14:
                            ApiResult apiResult0 = (ApiResult)object0;
                            return H.a;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                d5.n.t(throwable0);
                return H.a;
            }
        }, 3, null);
    }

    @NotNull
    public final MusicWavePlaylistRemoteDataSource getRemoteDataSource() {
        return this.remoteDataSource;
    }
}

