package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;
import java.util.ArrayList;

@SuppressLint({"RestrictedApi"})
class MediaBrowserCompat.SearchResultReceiver extends ResultReceiver {
    @Override  // android.support.v4.os.ResultReceiver
    public final void onReceiveResult(int v, Bundle bundle0) {
        if(bundle0 != null) {
            bundle0 = V.D(bundle0);
        }
        if(v != 0 || bundle0 == null || !bundle0.containsKey("search_results")) {
            throw null;
        }
        Parcelable[] arr_parcelable = bundle0.getParcelableArray("search_results");
        arr_parcelable.getClass();
        ArrayList arrayList0 = new ArrayList(arr_parcelable.length);
        for(int v1 = 0; v1 < arr_parcelable.length; ++v1) {
            arrayList0.add(((MediaBrowserCompat.MediaItem)g.a(arr_parcelable[v1], MediaBrowserCompat.MediaItem.CREATOR)));
        }
        throw null;
    }
}

