package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;
import vg.s;
import vg.t;
import vg.u;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J:\u0010\b\u001A\u00020\u00072\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0003\u0010\u0004\u001A\u00020\u00022\u0014\b\u0001\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H§@¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"LBa/k;", "", "", "path", "nonUseCpIdKey", "", "options", "Lcom/melon/net/res/StreamingPathRes;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface k {
    @Api(type = ApiType.V4, useCache = false)
    @Nullable
    @f("cds/delivery/{path}/streaming_path.json")
    Object a(@NotNull @s("path") String arg1, @NotNull @t("nonUseUrlCpIdKey") String arg2, @NotNull @u Map arg3, @NotNull Continuation arg4);
}

