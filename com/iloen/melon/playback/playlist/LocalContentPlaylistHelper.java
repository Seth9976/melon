package com.iloen.melon.playback.playlist;

import com.gaudiolab.sol.android.SolMusicOne.LoudnessType;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.sol.PlaylistSolMetaUpdater;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nH\u0096@¢\u0006\u0004\b\u000B\u0010\fR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u000F\u001A\u00020\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0012\u001A\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/playback/playlist/LocalContentPlaylistHelper;", "Lcom/iloen/melon/playback/playlist/LocalDownloadablePlaylist;", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "<init>", "(Lcom/iloen/melon/playback/playlist/PlaylistId;)V", "", "Lcom/iloen/melon/playback/Playable;", "getPlayableList", "()Ljava/util/List;", "Lie/H;", "updateSolMetaDataBase", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lkotlinx/coroutines/CoroutineDispatcher;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lcom/iloen/melon/playback/playlist/sol/PlaylistSolMetaUpdater;", "solMetaUpdater", "Lcom/iloen/melon/playback/playlist/sol/PlaylistSolMetaUpdater;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class LocalContentPlaylistHelper implements LocalDownloadablePlaylist {
    public static final int $stable = 8;
    @NotNull
    private final CoroutineDispatcher defaultDispatcher;
    @NotNull
    private final LogU log;
    @NotNull
    private final PlaylistId playlistId;
    @NotNull
    private final PlaylistSolMetaUpdater solMetaUpdater;

    public LocalContentPlaylistHelper(@NotNull PlaylistId playlistId0) {
        q.g(playlistId0, "playlistId");
        super();
        this.playlistId = playlistId0;
        this.log = new LogU("LocalContentPlaylistHelper-" + playlistId0);
        this.defaultDispatcher = Dispatchers.getDefault();
        this.solMetaUpdater = new PlaylistSolMetaUpdater();
    }

    @NotNull
    public abstract List getPlayableList();

    @Override  // com.iloen.melon.playback.playlist.LocalDownloadablePlaylist
    @Nullable
    public Object updateSolMetaDataBase(@NotNull Continuation continuation0) {
        return LocalContentPlaylistHelper.updateSolMetaDataBase$suspendImpl(this, continuation0);
    }

    public static Object updateSolMetaDataBase$suspendImpl(LocalContentPlaylistHelper localContentPlaylistHelper0, Continuation continuation0) {
        boolean z = MelonSettingInfo.getAudioLoudnessType() != LoudnessType.kOff.ordinal();
        H h0 = H.a;
        if(!z) {
            return h0;
        }
        com.iloen.melon.playback.playlist.LocalContentPlaylistHelper.updateSolMetaDataBase.2 localContentPlaylistHelper$updateSolMetaDataBase$20 = new n(localContentPlaylistHelper0, null) {
            int label;

            {
                LocalContentPlaylistHelper.this = localContentPlaylistHelper0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.playlist.LocalContentPlaylistHelper.updateSolMetaDataBase.2(LocalContentPlaylistHelper.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.LocalContentPlaylistHelper.updateSolMetaDataBase.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Iterable iterable0 = p.P0(LocalContentPlaylistHelper.this.getPlayableList());
                ArrayList arrayList0 = new ArrayList();
                for(Object object1: iterable0) {
                    if(((Playable)object1).isOriginLocal()) {
                        arrayList0.add(object1);
                    }
                }
                LocalContentPlaylistHelper.this.solMetaUpdater.onUpdateSolMetaDataBase(arrayList0);
                return H.a;
            }
        };
        Object object0 = BuildersKt.withContext(localContentPlaylistHelper0.defaultDispatcher, localContentPlaylistHelper$updateSolMetaDataBase$20, continuation0);
        return object0 == a.a ? object0 : h0;
    }
}

