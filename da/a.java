package Da;

import com.melon.net.Api;
import com.melon.net.ApiType;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.l;
import vg.o;
import vg.q;
import vg.t;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J2\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u000E\b\u0001\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u0005H§@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000BÀ\u0006\u0003"}, d2 = {"LDa/a;", "", "", "Lokhttp3/MultipartBody$Part;", "images", "", "memberKey", "Lcom/melon/net/ApiResult;", "Lcom/melon/net/res/MyMusicOrcRes;", "a", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface a {
    @Api(type = ApiType.V6)
    @Nullable
    @l
    @o("/mymusic/ocr.json")
    Object a(@NotNull @q List arg1, @Nullable @t("memberKey") String arg2, @NotNull Continuation arg3);
}

