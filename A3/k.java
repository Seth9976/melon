package a3;

import E9.w;
import U4.x;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.MediaChannelResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import e3.b;

public final class k implements ResultCallback {
    public final n a;

    public k(n n0) {
        this.a = n0;
    }

    @Override  // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result0) {
        int v = ((MediaChannelResult)result0).getStatus().getStatusCode();
        if(v != 0 && v != 2103) {
            StringBuilder stringBuilder0 = x.n(v, "Seek failed. Error code ", ": ");
            stringBuilder0.append(w.B(v));
            b.p("CastPlayer", stringBuilder0.toString());
        }
        n n0 = this.a;
        int v1 = n0.w - 1;
        n0.w = v1;
        if(v1 == 0) {
            n0.u = n0.x;
            n0.x = -1;
            n0.y = 0x8000000000000001L;
        }
    }
}

