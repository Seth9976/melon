package com.iloen.melon.playback.playlist.sol;

import Cc.U2;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import ie.H;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xc.F;
import y8.f;
import y8.s;
import y8.t;
import y8.v;
import y8.w;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000EJ.\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u000FH\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J\u001E\u0010\u001B\u001A\u00020\u001A2\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0086@¢\u0006\u0004\b\u001B\u0010\u001CR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001D¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/playback/playlist/sol/PlaylistSolMetaRepository;", "", "Ly8/w;", "remoteDataSource", "<init>", "(Ly8/w;)V", "Ly8/t;", "solMetaData", "", "isExistSolMeta", "(Ly8/t;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/Playable;", "playable", "getSolMeta", "(Lcom/iloen/melon/playback/Playable;)Ly8/t;", "", "cId", "cType", "metaType", "Lcom/melon/net/ApiResult;", "Lcom/melon/net/res/SolInfoRes;", "getSolInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Ly8/v;", "solMetaDataList", "Lie/H;", "insertSolMetaList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ly8/w;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistSolMetaRepository {
    public static final int $stable = 8;
    @NotNull
    private final w remoteDataSource;

    @Inject
    public PlaylistSolMetaRepository(@NotNull w w0) {
        q.g(w0, "remoteDataSource");
        super();
        this.remoteDataSource = w0;
    }

    @Nullable
    public final Object getSolInfo(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull Continuation continuation0) {
        return this.remoteDataSource.a.g(s1, s, s2, continuation0);
    }

    @NotNull
    public final t getSolMeta(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        q.f("", "getContentId(...)");
        String s = playable0.getCtype().getValue();
        q.f(s, "getValue(...)");
        return PlayableExtensionsKt.isDolby(playable0) ? new t("", s, "SO0200", "", null) : new t("", s, "SO0100", "", null);
    }

    @Nullable
    public final Object insertSolMetaList(@NotNull List list0, @NotNull Continuation continuation0) {
        s s0 = f.d().a.b();
        v[] arr_v = (v[])list0.toArray(new v[0]);
        v[] arr_v1 = (v[])Arrays.copyOf(arr_v, arr_v.length);
        s0.getClass();
        arr_v1.getClass();
        H h0 = E9.w.P(((androidx.room.H)s0.a), continuation0, new F(2, s0, arr_v1), false, true);
        a a0 = a.a;
        H h1 = H.a;
        if(h0 != a0) {
            h0 = h1;
        }
        if(h0 != a0) {
            h0 = h1;
        }
        return h0 == a0 ? h0 : h1;
    }

    @Nullable
    public final Object isExistSolMeta(@NotNull t t0, @NotNull Continuation continuation0) {
        return E9.w.P(((androidx.room.H)f.d().a.b().a), continuation0, new U2(10, t0.a, t0.b, t0.c), true, false);
    }
}

