package androidx.media3.session.legacy;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.os.ResultReceiver;
import java.util.List;

public final class m extends u {
    public final ResultReceiver f;

    public m(Object object0, ResultReceiver resultReceiver0) {
        this.f = resultReceiver0;
        super(object0);
    }

    @Override  // androidx.media3.session.legacy.u
    public final void d(Object object0) {
        ResultReceiver resultReceiver0 = this.f;
        if((this.e & 4) == 0 && ((List)object0) != null) {
            Bundle bundle0 = new Bundle();
            bundle0.putParcelableArray("search_results", ((Parcelable[])g.b(((List)object0), MediaItem.CREATOR).toArray(new MediaItem[0])));
            resultReceiver0.send(0, bundle0);
            return;
        }
        resultReceiver0.send(-1, null);
    }
}

