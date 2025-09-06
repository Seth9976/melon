package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;
import vg.t;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0003\u0010\u0004\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00052\b\b\u0003\u0010\t\u001A\u00020\u00022\b\b\u0003\u0010\n\u001A\u00020\u0002H§@¢\u0006\u0004\b\f\u0010\bJ \u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u00052\b\b\u0003\u0010\t\u001A\u00020\u0002H§@¢\u0006\u0004\b\u000E\u0010\u000FJ,\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00110\u00052\n\b\u0003\u0010\t\u001A\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0010\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0012\u0010\bJ\"\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u00052\n\b\u0003\u0010\t\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0014\u0010\u000F¨\u0006\u0015À\u0006\u0003"}, d2 = {"LBa/u;", "", "", "dolbyYN", "dolbyEmbedYN", "Lcom/melon/net/ApiResult;", "Lcom/melon/net/res/NavigationMenuListRes;", "b", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memberKey", "excludeRedDots", "Lcom/melon/net/res/NavigationMenuBenefitRes;", "e", "Lcom/melon/net/res/InfoCommerceAndBtnVer6Res;", "d", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "artistId", "Lcom/iloen/melon/net/v4x/response/InformArtistRes;", "a", "Lcom/iloen/melon/net/v6x/response/FeedLogsNewsCountRes;", "c", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface u {
    @Api(type = ApiType.V4, useAppVersion = true)
    @Nullable
    @f("/main/mymusic/informArtist.json")
    Object a(@Nullable @t("memberKey") String arg1, @NotNull @t("artistId") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/navigationmenu/list.json")
    Object b(@NotNull @t("dolbyYN") String arg1, @NotNull @t("dolbyEmbedYN") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/feedlogs/newsCount.json")
    Object c(@Nullable @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6_2)
    @Nullable
    @f("/personal/infoCommerceAndBtn.json")
    Object d(@NotNull @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/navigationmenu/benefit.json")
    Object e(@NotNull @t("memberKey") String arg1, @NotNull @t("excludeRedDots") String arg2, @NotNull Continuation arg3);
}

