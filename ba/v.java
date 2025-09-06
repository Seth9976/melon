package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;
import vg.t;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0003\u0010\u0004\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\u00052\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0003\u0010\t\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u000B\u0010\bJ8\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\u00052\b\b\u0003\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\f\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\r\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\b\u000F\u0010\u0010J*\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00110\u00052\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0003\u0010\u0004\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u0012\u0010\bJ\"\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u00052\n\b\u0003\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\b\u0014\u0010\u0015J8\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00180\u00052\b\b\u0003\u0010\u0003\u001A\u00020\u00022\n\b\u0001\u0010\u0016\u001A\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0017\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\b\u0019\u0010\u0010J\u0016\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0005H\u00A7@\u00A2\u0006\u0004\b\u001B\u0010\u001CJ \u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u001E0\u00052\b\b\u0001\u0010\u001D\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u001F\u0010\u0015J4\u0010%\u001A\b\u0012\u0004\u0012\u00020$0\u00052\b\b\u0003\u0010!\u001A\u00020 2\b\b\u0003\u0010\"\u001A\u00020 2\b\b\u0003\u0010#\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b%\u0010&J4\u0010)\u001A\b\u0012\u0004\u0012\u00020(0\u00052\b\b\u0003\u0010!\u001A\u00020 2\b\b\u0003\u0010\"\u001A\u00020 2\b\b\u0003\u0010\'\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b)\u0010&J>\u0010,\u001A\b\u0012\u0004\u0012\u00020+0\u00052\b\b\u0003\u0010!\u001A\u00020 2\b\b\u0003\u0010\"\u001A\u00020 2\b\b\u0003\u0010*\u001A\u00020\u00022\b\b\u0003\u0010\'\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b,\u0010-JR\u00102\u001A\b\u0012\u0004\u0012\u0002010\u00052\b\b\u0003\u0010!\u001A\u00020 2\b\b\u0003\u0010\"\u001A\u00020 2\b\b\u0003\u0010*\u001A\u00020\u00022\b\b\u0001\u0010.\u001A\u00020\u00022\b\b\u0001\u0010/\u001A\u00020\u00022\b\b\u0001\u00100\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b2\u00103J4\u00105\u001A\b\u0012\u0004\u0012\u0002040\u00052\b\b\u0003\u0010!\u001A\u00020 2\b\b\u0003\u0010\"\u001A\u00020 2\b\b\u0003\u0010\'\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b5\u0010&\u00A8\u00066\u00C0\u0006\u0003"}, d2 = {"LBa/v;", "", "", "memberKey", "filterCodes", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes;", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "excludeRedDot", "Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes;", "g", "excludeNoticeSeqs", "excludeBadgeKey", "Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes;", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v5x/response/FlexibleRes;", "c", "Lcom/iloen/melon/net/v4x/response/AuthLocationRes;", "i", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "longitude", "latitude", "Lcom/iloen/melon/net/v4x/response/ForULocationLogRes;", "d", "Lcom/iloen/melon/net/v6x/response/ChartTop100ListRes;", "j", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chartType", "Lcom/iloen/melon/net/v6x/response/ChartHot100ListRes;", "h", "", "startIndex", "pageSize", "grnCode", "Lcom/iloen/melon/net/v5x/response/ChartTopDailySongChartListRes;", "e", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gnrCode", "Lcom/iloen/melon/net/v5x/response/ChartTopWeeklySongChartListRes;", "k", "isRecom", "Lcom/iloen/melon/net/v5x/response/ChartTopMonthlySongChartListRes;", "f", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "genre", "year", "type", "Lcom/iloen/melon/net/v4x/response/AgeSongChartListRes;", "l", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v5x/response/DailySongChartListRes;", "m", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface v {
    @Api(type = ApiType.V6_8, useAppVersion = true)
    @Nullable
    @f("/main/music.json")
    Object a(@NotNull @t("memberKey") String arg1, @NotNull @t("filterCodes") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/main/music/listUpperFeed.json")
    Object b(@NotNull @t("memberKey") String arg1, @Nullable @t("excludeNoticeSeqs") String arg2, @Nullable @t("excludeBadgeKey") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V6_9, useAppVersion = true)
    @Nullable
    @f("/main/music/flexible.json")
    Object c(@NotNull @t("memberKey") String arg1, @NotNull @t("filterCodes") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V4, useAppVersion = true)
    @Nullable
    @f("/mymusic/foru/locationLog.json")
    Object d(@NotNull @t("memberKey") String arg1, @Nullable @t("longitude") String arg2, @Nullable @t("latitude") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V5, useAppVersion = true)
    @Nullable
    @f("/chart/top/daily/songChartList.json")
    Object e(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("grnCode") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V5, useAppVersion = true)
    @Nullable
    @f("/chart/top/monthly/songChartList.json")
    Object f(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("isRecom") String arg3, @NotNull @t("gnrCode") String arg4, @NotNull Continuation arg5);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/specialgift/banner.json")
    Object g(@NotNull @t("memberKey") String arg1, @NotNull @t("excludeRedDots") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/chart/hot100/list.json")
    Object h(@NotNull @t("chartType") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V4, useAppVersion = true)
    @Nullable
    @f("/auth/location.json")
    Object i(@Nullable @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/chart/ent/songChartList.json")
    Object j(@NotNull Continuation arg1);

    @Api(type = ApiType.V5, useAppVersion = true)
    @Nullable
    @f("/chart/top/weekly/songChartList.json")
    Object k(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("gnrCode") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V4, useAppVersion = false)
    @Nullable
    @f("/chart/age/songChartList.json")
    Object l(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("isRecom") String arg3, @NotNull @t("genre") String arg4, @NotNull @t("year") String arg5, @NotNull @t("type") String arg6, @NotNull Continuation arg7);

    @Api(type = ApiType.V5, useAppVersion = true)
    @Nullable
    @f("/chart/daily/songChartList.json")
    Object m(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("gnrCode") String arg3, @NotNull Continuation arg4);
}

