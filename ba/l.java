package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.c;
import vg.e;
import vg.f;
import vg.o;
import vg.s;
import vg.t;

@Metadata(d1 = {"\u0000\u00F2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JV\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0004\u001A\u00020\u00022\b\b\u0003\u0010\u0005\u001A\u00020\u00022\b\b\u0001\u0010\u0006\u001A\u00020\u00022\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u00022\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\b\u000B\u0010\fJ \u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\t2\b\b\u0001\u0010\r\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u000F\u0010\u0010J4\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00140\t2\b\b\u0001\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u0010\b\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u0015\u0010\u0016J@\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00180\t2\b\b\u0001\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u0010\u0017\u001A\u00020\u00022\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\b\u0019\u0010\u001AJ4\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u001B0\t2\b\b\u0001\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u0010\b\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u001C\u0010\u0016J@\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u001D0\t2\b\b\u0001\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u0010\u0017\u001A\u00020\u00022\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\b\u001E\u0010\u001AJ>\u0010\"\u001A\b\u0012\u0004\u0012\u00020!0\t2\b\b\u0001\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u0010\u001F\u001A\u00020\u00022\b\b\u0001\u0010 \u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\"\u0010\u001AJJ\u0010$\u001A\b\u0012\u0004\u0012\u00020#0\t2\b\b\u0001\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u0010\u001F\u001A\u00020\u00022\b\b\u0001\u0010 \u001A\u00020\u00022\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\b$\u0010%J\"\u0010\'\u001A\b\u0012\u0004\u0012\u00020&0\t2\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\b\'\u0010\u0010J\u0016\u0010)\u001A\b\u0012\u0004\u0012\u00020(0\tH\u00A7@\u00A2\u0006\u0004\b)\u0010*J@\u0010,\u001A\b\u0012\u0004\u0012\u00020+0\t2\b\b\u0001\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u0010 \u001A\u00020\u00022\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\b,\u0010\u001AJ \u0010/\u001A\b\u0012\u0004\u0012\u00020.0\t2\b\b\u0001\u0010-\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b/\u0010\u0010J@\u00103\u001A\b\u0012\u0004\u0012\u0002020\t2\b\b\u0001\u0010-\u001A\u00020\u00022\n\b\u0001\u00100\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u00101\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b3\u00104J4\u00106\u001A\b\u0012\u0004\u0012\u0002050\t2\b\b\u0001\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u0010\u0017\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b6\u0010\u0016J4\u00108\u001A\b\u0012\u0004\u0012\u0002070\t2\b\b\u0001\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u0010\u0017\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b8\u0010\u0016J@\u0010:\u001A\b\u0012\u0004\u0012\u0002090\t2\b\b\u0001\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u0010\u0017\u001A\u00020\u00022\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\b:\u0010\u001AJ4\u0010<\u001A\b\u0012\u0004\u0012\u00020;0\t2\b\b\u0001\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u0010\u0017\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b<\u0010\u0016J4\u0010>\u001A\b\u0012\u0004\u0012\u00020=0\t2\b\b\u0001\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u0010\u0017\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b>\u0010\u0016J*\u0010A\u001A\b\u0012\u0004\u0012\u00020@0\t2\b\b\u0001\u0010?\u001A\u00020\u00022\b\b\u0001\u0010\b\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\bA\u0010BJ\"\u0010D\u001A\b\u0012\u0004\u0012\u00020C0\t2\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\bD\u0010\u0010J6\u0010H\u001A\b\u0012\u0004\u0012\u00020G0\t2\b\b\u0001\u0010E\u001A\u00020\u00022\b\b\u0001\u0010F\u001A\u00020\u00022\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\bH\u0010IJ@\u0010L\u001A\b\u0012\u0004\u0012\u00020K0\t2\b\b\u0001\u0010\u001F\u001A\u00020\u00022\b\b\u0001\u00101\u001A\u00020\u00022\b\b\u0003\u0010J\u001A\u00020\u00022\n\b\u0003\u0010\b\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\bL\u0010MJ4\u0010O\u001A\b\u0012\u0004\u0012\u00020G0\t2\b\b\u0001\u0010E\u001A\u00020\u00022\b\b\u0001\u0010N\u001A\u00020\u00022\b\b\u0003\u0010\b\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\bO\u0010IJ\"\u0010Q\u001A\b\u0012\u0004\u0012\u00020P0\t2\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\bQ\u0010\u0010J \u0010T\u001A\b\u0012\u0004\u0012\u00020S0\t2\b\b\u0001\u0010R\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\bT\u0010\u0010J \u0010V\u001A\b\u0012\u0004\u0012\u00020U0\t2\b\b\u0001\u0010R\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\bV\u0010\u0010J \u0010Y\u001A\b\u0012\u0004\u0012\u00020X0\t2\b\b\u0001\u0010W\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\bY\u0010\u0010JH\u0010\\\u001A\b\u0012\u0004\u0012\u00020[0\t2\b\b\u0001\u0010R\u001A\u00020\u00022\b\b\u0001\u00100\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00112\b\b\u0001\u00101\u001A\u00020\u00022\b\b\u0001\u0010Z\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\\\u0010]J \u0010_\u001A\b\u0012\u0004\u0012\u00020^0\t2\b\b\u0003\u0010\b\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b_\u0010\u0010J*\u0010a\u001A\b\u0012\u0004\u0012\u00020`0\t2\b\b\u0001\u0010\u0017\u001A\u00020\u00022\b\b\u0003\u0010\b\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\ba\u0010B\u00A8\u0006b\u00C0\u0006\u0003"}, d2 = {"LBa/l;", "", "", "plylstSeq", "songIds", "type", "moveType", "ocrGroupId", "memberKey", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v4x/response/DjPlaylistAddDjSongRes;", "q", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "term", "Lcom/iloen/melon/net/v6x/response/DjPopularTermPlayListsRes;", "A", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "startIndex", "pageSize", "Lcom/iloen/melon/net/v6x/response/DjMelgunLikeMemberListRes;", "g", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "brandDjKey", "Lcom/iloen/melon/net/v6x/response/DjBrandLikeMemberRes;", "C", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v6x/response/DjMelgunFollowerListRes;", "t", "Lcom/iloen/melon/net/v6x/response/DjBrandFollowerRes;", "r", "mode", "sortBy", "Lcom/iloen/melon/net/v6x/response/DjPlaylistListV6Res;", "p", "Lcom/iloen/melon/net/v6x/response/PowerDjListRes;", "h", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v5x/response/DjThemeListLikeTagRes;", "m", "Lcom/iloen/melon/net/v4x/response/DjThemeListBoardRes;", "o", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v6x/response/MelgunDjplaylistListRes;", "D", "tagSeq", "Lcom/iloen/melon/net/v5x/response/DjTagInformV5Res;", "v", "lastIndexKey", "orderBy", "Lcom/iloen/melon/net/v4x/response/DjTagPlylstListRes;", "e", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v6x/response/DjBrandDetailDjplaylistListRes;", "c", "Lcom/iloen/melon/net/v6x/response/DjBrandDetailRecmSongListRes;", "B", "Lcom/iloen/melon/net/v6x/response/DjBrandRecommendArtistRes;", "j", "Lcom/iloen/melon/net/v6x/response/BrandDetailVideoListRes;", "b", "Lcom/iloen/melon/net/v6x/response/BrandDetailMagazineListRes;", "k", "pageType", "Lcom/iloen/melon/net/v4x/response/DjApplyMainRes;", "s", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v4x/response/DjApplyInsertRes;", "z", "playlistSeq", "normalChangeYN", "Lcom/iloen/melon/net/HttpResponse;", "w", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "targetMemberKey", "Lcom/iloen/melon/net/v6x/response/DjSmartPlaylistListRes;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eventSeq", "u", "Lcom/iloen/melon/net/v6x/response/DjHomeMainRes;", "y", "keyword", "Lcom/iloen/melon/net/v4x/response/DjThemeListRelTagSearchRes;", "l", "Lcom/iloen/melon/net/v6x/response/DjTagSearchAutoCompleteRes;", "i", "tagCount", "Lcom/iloen/melon/net/v5x/response/DjThemeListRecmTagRes;", "f", "searchType", "Lcom/iloen/melon/net/v4x/response/DjThemeListPlystSearchRes;", "x", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v6x/response/DjMelgunInformProfileRes;", "n", "Lcom/iloen/melon/net/v6x/response/DjBrandInformProfileRes;", "d", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface l {
    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/dj/popular/{term}/playlists.json")
    Object A(@NotNull @s("term") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6_1, useAppVersion = false)
    @Nullable
    @f("/dj/brandDetail/recmSong/list.json")
    Object B(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("brandDjKey") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/dj/brand/likeMember/list.json")
    Object C(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("brandDjKey") String arg3, @Nullable @t("memberKey") String arg4, @NotNull Continuation arg5);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/dj/melgun/djplaylist/list.json")
    Object D(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("sortBy") String arg3, @Nullable @t("memberKey") String arg4, @NotNull Continuation arg5);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/dj/connected/playlist/list.json")
    Object a(@NotNull @t("mode") String arg1, @NotNull @t("orderBy") String arg2, @NotNull @t("targetMemberKey") String arg3, @Nullable @t("memberKey") String arg4, @NotNull Continuation arg5);

    @Api(type = ApiType.V6_1, useAppVersion = false)
    @Nullable
    @f("/dj/brandDetail/video/list.json")
    Object b(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("brandDjKey") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V6_1, useAppVersion = false)
    @Nullable
    @f("/dj/brandDetail/djplaylist/list.json")
    Object c(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("brandDjKey") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/dj/brand/informProfile.json")
    Object d(@NotNull @t("brandDjKey") String arg1, @NotNull @t("memberKey") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V4, useAppVersion = false)
    @Nullable
    @f("/dj/tag/plylstlist.json")
    Object e(@NotNull @t("tagSeq") String arg1, @Nullable @t("lastIndexKey") String arg2, @t("pageSize") int arg3, @NotNull @t("orderBy") String arg4, @NotNull Continuation arg5);

    @Api(type = ApiType.V5, useAppVersion = false)
    @Nullable
    @f("/dj/theme/listRecmTag.json")
    Object f(@NotNull @t("tagCnt") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/dj/melgun/likemember/list.json")
    Object g(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("memberKey") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/powerdj/list.json")
    Object h(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("mode") String arg3, @NotNull @t("sortBy") String arg4, @Nullable @t("memberKey") String arg5, @NotNull Continuation arg6);

    @Api(type = ApiType.V6_1, useAppVersion = false)
    @Nullable
    @f("/dj/tag/search/autocomplete.json")
    Object i(@NotNull @t("keyword") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6_1, useAppVersion = false)
    @Nullable
    @f("/dj/brandDetail/recmArtist/list.json")
    Object j(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("brandDjKey") String arg3, @Nullable @t("memberKey") String arg4, @NotNull Continuation arg5);

    @Api(type = ApiType.V6_1, useAppVersion = false)
    @Nullable
    @f("/dj/brandDetail/magazine/list.json")
    Object k(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("brandDjKey") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V4, useAppVersion = false)
    @Nullable
    @f("/dj/theme/listRelTagSearch.json")
    Object l(@NotNull @t("keyword") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V5, useAppVersion = false)
    @Nullable
    @f("/dj/theme/listLikeTag.json")
    Object m(@Nullable @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/dj/melgun/informProfile.json")
    Object n(@NotNull @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V5, useAppVersion = false)
    @Nullable
    @f("/dj/theme/listBoard.json")
    Object o(@NotNull Continuation arg1);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/dj/home/djplaylist/list.json")
    Object p(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("mode") String arg3, @NotNull @t("sortBy") String arg4, @NotNull Continuation arg5);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @e
    @o("/dj/playlist/song/add.json")
    Object q(@NotNull @c("plylstSeq") String arg1, @NotNull @c("songIds") String arg2, @NotNull @c("type") String arg3, @NotNull @c("moveType") String arg4, @Nullable @c("ocrGroupId") String arg5, @Nullable @c("memberKey") String arg6, @NotNull Continuation arg7);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/dj/brand/follower/list.json")
    Object r(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("brandDjKey") String arg3, @Nullable @t("memberKey") String arg4, @NotNull Continuation arg5);

    @Api(type = ApiType.V4, useAppVersion = true)
    @Nullable
    @f("/dj/apply/main.json")
    Object s(@NotNull @t("pageType") String arg1, @NotNull @t("memberKey") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/dj/melgun/follower/list.json")
    Object t(@t("startIndex") int arg1, @t("pageSize") int arg2, @NotNull @t("memberKey") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @e
    @o("dj/playlist/event/apply.json")
    Object u(@NotNull @c("plylstSeq") String arg1, @NotNull @c("eventSeq") String arg2, @NotNull @c("memberKey") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V5, useAppVersion = false)
    @Nullable
    @f("/dj/tag/inform.json")
    Object v(@NotNull @t("tagSeq") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V4, useAppVersion = true)
    @Nullable
    @e
    @o("/dj/apply/reject.json")
    Object w(@NotNull @c("plylstSeq") String arg1, @NotNull @c("nomalChngYn") String arg2, @Nullable @c("memberKey") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V4, useAppVersion = false)
    @Nullable
    @f("/dj/theme/listPlylstSearch.json")
    Object x(@NotNull @t("keyword") String arg1, @t("lastIndexKey") int arg2, @t("pageSize") int arg3, @NotNull @t("orderBy") String arg4, @NotNull @t("searchType") String arg5, @NotNull Continuation arg6);

    @Api(type = ApiType.V6_2, useAppVersion = true)
    @Nullable
    @f("/dj/home/main.json")
    Object y(@Nullable @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V4, useAppVersion = true)
    @Nullable
    @e
    @o("/dj/apply/insert.json")
    Object z(@Nullable @c("memberKey") String arg1, @NotNull Continuation arg2);
}

