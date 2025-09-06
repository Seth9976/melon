package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;
import vg.t;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0004\u001A\u00020\u00022\n\b\u0003\u0010\u0005\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\b\u0010\tJj\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u00062\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0003\u001A\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u000B\u001A\u0004\u0018\u00010\u00022\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\u00022\n\b\u0001\u0010\r\u001A\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u000E\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00120\u00062\n\b\u0003\u0010\u0005\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00150\u00062\n\b\u0003\u0010\u0005\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0016\u0010\u0014J\"\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00120\u00062\n\b\u0003\u0010\u0005\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0017\u0010\u0014J\"\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00120\u00062\n\b\u0003\u0010\u0005\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0018\u0010\u0014J\u001C\u0010\u001A\u001A\u00020\u00192\n\b\u0003\u0010\u0005\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u001A\u0010\u0014¨\u0006\u001BÀ\u0006\u0003"}, d2 = {"LBa/c;", "", "", "contentsId", "contentsTypeCode", "memberKey", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v6x/response/PromotionContentsBannerRes;", "g", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bannerType", "menuCode", "rowCount", "bnrSgmtCd", "bnrOrd", "Lcom/iloen/melon/net/v4x/response/AppBanerListRes;", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v6x/response/BannerRes;", "e", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/melon/net/res/MainMusicMiddleBannerRes;", "b", "c", "d", "Lcom/melon/net/res/MainMenuTabBannerRes;", "a", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface c {
    @Api(type = ApiType.V4, useAppVersion = true)
    @Nullable
    @f("/api/public/v1/banner/BN000050")
    Object a(@Nullable @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V4, useAppVersion = true)
    @Nullable
    @f("/api/public/v1/banner/BN000051")
    Object b(@Nullable @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.EMPTY, useAppVersion = true)
    @Nullable
    @f("/api/public/v1/banner/BN000047")
    Object c(@Nullable @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.EMPTY, useAppVersion = true)
    @Nullable
    @f("/api/public/v1/banner/BN000049")
    Object d(@Nullable @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V4, useAppVersion = true)
    @Nullable
    @f("/api/public/bypass/v1/banner/BN000040")
    Object e(@Nullable @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V4, useAppVersion = true)
    @Nullable
    @f("/promotion/appbanerList.json")
    Object f(@Nullable @t("bannerType") String arg1, @Nullable @t("contsId") String arg2, @Nullable @t("contsType") String arg3, @Nullable @t("menuCode") String arg4, @Nullable @t("rowsCnt") String arg5, @Nullable @t("bnrSgmtCd") String arg6, @Nullable @t("bnrOrd") String arg7, @NotNull Continuation arg8);

    @Api(type = ApiType.V4, useAppVersion = true)
    @Nullable
    @f("/api/public/v1/group/banner/BNG00003")
    Object g(@NotNull @t("contsId") String arg1, @NotNull @t("contsTypeCode") String arg2, @Nullable @t("memberKey") String arg3, @NotNull Continuation arg4);
}

