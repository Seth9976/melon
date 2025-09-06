package a3;

import com.google.android.gms.cast.framework.media.RemoteMediaClient.MediaChannelResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;

public final class j implements ResultCallback {
    public final n a;

    public j(n n0) {
        this.a = n0;
    }

    @Override  // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result0) {
        MediaChannelResult remoteMediaClient$MediaChannelResult0 = (MediaChannelResult)result0;
        n n0 = this.a;
        if(n0.p != null) {
            n0.v0(this);
            n0.l.b();
        }
    }
}

