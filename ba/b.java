package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;
import vg.t;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\u00042\b\b\u0003\u0010\b\u001A\u00020\u00022\b\b\u0003\u0010\t\u001A\u00020\u0002H§@¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u00042\b\b\u0003\u0010\b\u001A\u00020\u0002H§@¢\u0006\u0004\b\u000E\u0010\u0007¨\u0006\u000FÀ\u0006\u0003"}, d2 = {"LBa/b;", "", "", "artistIds", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v4x/response/ArtistListArtistInfoRes;", "b", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "artistId", "categoryCode", "Lcom/iloen/melon/net/v6x/response/ArtistMusicRecmtrackSongListRes;", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v6x/response/ArtistMusicReqSongListRes;", "c", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface b {
    @Api(type = ApiType.V6_1)
    @Nullable
    @f("/artist/music/recmtrack/songList.json")
    Object a(@NotNull @t("artistId") String arg1, @NotNull @t("categoryCode") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V4)
    @Nullable
    @f("/artist/listArtistInfo.json")
    Object b(@NotNull @t("artistIds") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6_2)
    @Nullable
    @f("/artist/music/repSongList.json")
    Object c(@NotNull @t("artistId") String arg1, @NotNull Continuation arg2);
}

