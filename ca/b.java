package Ca;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;
import vg.t;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0007\u0010\bJ@\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u00052\b\b\u0001\u0010\n\u001A\u00020\t2\b\b\u0001\u0010\u000B\u001A\u00020\t2\b\b\u0001\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\r\u0010\u000EJ,\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u00052\b\b\u0001\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0010\u0010\bJ,\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00110\u00052\b\b\u0001\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0012\u0010\bJ,\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u00052\b\b\u0001\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0014\u0010\b¨\u0006\u0015À\u0006\u0003"}, d2 = {"LCa/b;", "", "", "plylstSeq", "memberKey", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v6x/response/MyMusicPlaylistInformRes;", "b", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "startIndex", "pageSize", "Lcom/iloen/melon/net/v6x/response/MyMusicPlaylistListSongRes;", "a", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v6x/response/MyMusicPlaylistPlayListSongRes;", "c", "Lcom/iloen/melon/net/v6x/response/MyMusicPlaylistDownloadListSongRes;", "d", "Lcom/iloen/melon/net/v6x/response/MyMusicPlaylistScrapListSongRes;", "e", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface b {
    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/mymusic/playlist/listSong.json")
    Object a(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("plylstSeq") String arg3, @Nullable @t("memberKey") String arg4, @NotNull Continuation arg5);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/mymusic/playlist/inform.json")
    Object b(@NotNull @t("plylstSeq") String arg1, @Nullable @t("memberKey") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/mymusic/playlist/play/listSong.json")
    Object c(@NotNull @t("plylstSeq") String arg1, @Nullable @t("memberKey") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/mymusic/playlist/download/listSong.json")
    Object d(@NotNull @t("plylstSeq") String arg1, @Nullable @t("memberKey") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/mymusic/playlist/scrap/listSong.json")
    Object e(@NotNull @t("plylstSeq") String arg1, @Nullable @t("memberKey") String arg2, @NotNull Continuation arg3);
}

