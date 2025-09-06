package Ca;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;
import vg.t;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u0002H§@¢\u0006\u0004\b\t\u0010\u0007J \u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u0002H§@¢\u0006\u0004\b\u000B\u0010\u0007J \u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u0002H§@¢\u0006\u0004\b\r\u0010\u0007J8\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u00022\n\b\u0001\u0010\u000E\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000F\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00140\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0013\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"LCa/a;", "", "", "albumId", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v6x/response/AlbumInfoRes;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v6x/response/AlbumSongListRes;", "f", "Lcom/iloen/melon/net/v6x/response/AlbumContentsListRes;", "b", "Lcom/iloen/melon/net/v6x/response/AlbumSongDownListRes;", "e", "rating", "memberKey", "Lcom/iloen/melon/net/v4x/response/AlbumSetGradeRes;", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "randomKey", "Lcom/iloen/melon/net/v4x/response/AlbumSuggestedContentsRes;", "c", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface a {
    @Api(type = ApiType.V6_3, useAppVersion = true)
    @Nullable
    @f("/album/info.json")
    Object a(@NotNull @t("albumId") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/album/contents/list.json")
    Object b(@NotNull @t("albumId") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/album/suggestedContents.json")
    Object c(@NotNull @t("albumId") String arg1, @NotNull @t("randomKey") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/album/setGrade.json")
    Object d(@NotNull @t("albumId") String arg1, @Nullable @t("value") String arg2, @Nullable @t("memberKey") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/album/song/down/list.json")
    Object e(@NotNull @t("albumId") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6_2, useAppVersion = true)
    @Nullable
    @f("/album/song/list.json")
    Object f(@NotNull @t("albumId") String arg1, @NotNull Continuation arg2);
}

