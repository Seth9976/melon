package Ba;

import e1.u;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.o;
import vg.f;
import vg.i;
import vg.t;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001J6\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\b\u0010\tJ6\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u000B\u0010\tJ6\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\f\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\r\u0010\tJ6\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u000E\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u000F\u0010\tJ6\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u000E\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u0010\u0010\tJ,\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\b\u0011\u0010\u0012J6\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0013\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u0014\u0010\tJ6\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u0015\u0010\tJ6\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u0016\u0010\tJ6\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u0017\u0010\t\u00A8\u0006\u0018\u00C0\u0006\u0003"}, d2 = {"LBa/y;", "", "", "token", "memberKey", "songIds", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/mcp/response/MixupPlayResponseBase;", "g", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "albumId", "e", "artistId", "a", "playlistId", "j", "k", "c", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "genreCode", "h", "f", "i", "b", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface y {
    @Nullable
    @f("/playlists/mix-up/artist")
    Object a(@NotNull @i("melonToken") String arg1, @Nullable @t("memberKey") String arg2, @NotNull @t("artistId") String arg3, @NotNull Continuation arg4);

    @Nullable
    @f("/playlists/mix-up/more")
    Object b(@NotNull @i("melonToken") String arg1, @Nullable @t("memberKey") String arg2, @NotNull @t("songIds") String arg3, @NotNull Continuation arg4);

    @Nullable
    @f("/playlists/mix-up/playlist/dj/top")
    Object c(@NotNull @i("melonToken") String arg1, @Nullable @t("memberKey") String arg2, @NotNull Continuation arg3);

    // 去混淆评级： 低(30)
    static Object d(y y0, String s, oe.i i0) {
        q.f("", "getToken(...)");
        return y0.g("", u.w(((e0)o.a()).j()), s, i0);
    }

    @Nullable
    @f("/playlists/mix-up/album")
    Object e(@NotNull @i("melonToken") String arg1, @Nullable @t("memberKey") String arg2, @NotNull @t("albumId") String arg3, @NotNull Continuation arg4);

    @Nullable
    @f("/playlists/mix-up/playlist/mix")
    Object f(@NotNull @i("melonToken") String arg1, @Nullable @t("memberKey") String arg2, @NotNull @t("songIds") String arg3, @NotNull Continuation arg4);

    @Nullable
    @f("/playlists/mix-up/songs")
    Object g(@NotNull @i("melonToken") String arg1, @Nullable @t("memberKey") String arg2, @NotNull @t("songIds") String arg3, @NotNull Continuation arg4);

    @Nullable
    @f("/playlists/mix-up/genre")
    Object h(@NotNull @i("melonToken") String arg1, @Nullable @t("memberKey") String arg2, @NotNull @t("genreCode") String arg3, @NotNull Continuation arg4);

    @Nullable
    @f("/playlists/mix-up/mix-maker")
    Object i(@NotNull @i("melonToken") String arg1, @Nullable @t("memberKey") String arg2, @NotNull @t("songIds") String arg3, @NotNull Continuation arg4);

    @Nullable
    @f("/playlists/mix-up/playlist")
    Object j(@NotNull @i("melonToken") String arg1, @Nullable @t("memberKey") String arg2, @NotNull @t("playlistId") String arg3, @NotNull Continuation arg4);

    @Nullable
    @f("/playlists/mix-up/playlist/dj")
    Object k(@NotNull @i("melonToken") String arg1, @Nullable @t("memberKey") String arg2, @NotNull @t("playlistId") String arg3, @NotNull Continuation arg4);
}

