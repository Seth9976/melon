package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

@SuppressLint({"RestrictedApi"})
class MediaBrowserCompat.ItemReceiver extends ResultReceiver {
    @Override  // android.support.v4.os.ResultReceiver
    public final void onReceiveResult(int v, Bundle bundle0) {
        if(bundle0 != null) {
            bundle0 = V.D(bundle0);
        }
        if(v != 0 || bundle0 == null || !bundle0.containsKey("media_item")) {
            throw null;
        }
        MediaBrowserCompat.MediaItem mediaBrowserCompat$MediaItem0 = (MediaBrowserCompat.MediaItem)g.a(bundle0.getParcelable("media_item"), MediaBrowserCompat.MediaItem.CREATOR);
        throw null;
    }
}

