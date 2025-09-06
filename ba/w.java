package Ba;

import com.melon.data.service.UpdateTrackListRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.a;
import vg.f;
import vg.i;
import vg.p;
import vg.s;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0004\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\u00052\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0004\u001A\u00020\u0002H§@¢\u0006\u0004\b\n\u0010\bJ*\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u00052\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\f\u001A\u00020\u000BH§@¢\u0006\u0004\b\u000E\u0010\u000F¨\u0006\u0010À\u0006\u0003"}, d2 = {"LBa/w;", "", "", "melonToken", "smartMemberKey", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/mcp/response/PlaylistsSmartUpdatedInfoRes;", "c", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/mcp/response/PlaylistsSmartGetRes;", "b", "Lcom/melon/data/service/UpdateTrackListRequest;", "updateTrackListRequest", "Lcom/iloen/melon/net/mcp/response/PlaylistsSmartEditRes;", "a", "(Ljava/lang/String;Lcom/melon/data/service/UpdateTrackListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface w {
    @Nullable
    @p("/playlists/smart")
    Object a(@NotNull @i("melonToken") String arg1, @NotNull @a UpdateTrackListRequest arg2, @NotNull Continuation arg3);

    @Nullable
    @f("/playlists/smart/{smartMemberKey}")
    Object b(@NotNull @i("melonToken") String arg1, @NotNull @s("smartMemberKey") String arg2, @NotNull Continuation arg3);

    @Nullable
    @f("/playlists/smart/{smartMemberKey}/updated-info")
    Object c(@NotNull @i("melonToken") String arg1, @NotNull @s("smartMemberKey") String arg2, @NotNull Continuation arg3);
}

