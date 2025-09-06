package androidx.media3.session.legacy;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.os.ResultReceiver;

public final class l extends u {
    public final ResultReceiver f;

    public l(Object object0, ResultReceiver resultReceiver0) {
        this.f = resultReceiver0;
        super(object0);
    }

    @Override  // androidx.media3.session.legacy.u
    public final void d(Object object0) {
        ResultReceiver resultReceiver0 = this.f;
        if((this.e & 2) != 0) {
            resultReceiver0.send(-1, null);
            return;
        }
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("media_item", g.a(((MediaBrowserCompat.MediaItem)object0), MediaItem.CREATOR));
        resultReceiver0.send(0, bundle0);
    }
}

