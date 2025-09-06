package c9;

import android.content.Context;
import com.android.volley.Response.Listener;
import com.iloen.melon.net.v4x.response.TmpManageIsCallRes;
import com.iloen.melon.utils.log.LogU;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

public final class h implements Listener {
    public final Context a;

    public h(Context context0) {
        this.a = context0;
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        if(((TmpManageIsCallRes)object0) != null && ((TmpManageIsCallRes)object0).isSuccessful()) {
            if("Y".equals(((TmpManageIsCallRes)object0).response.tmpCall)) {
                BuildersKt__Builders_commonKt.launch$default(((CoroutineScope)i.d.getValue()), null, null, new g(this.a, null), 3, null);
                return;
            }
            LogU.debug$default(i.b, "requestTmpManage() skip login promotion.", null, false, 6, null);
            return;
        }
        LogU.warn$default(i.b, "requestTmpManage() failed", null, false, 6, null);
    }
}

