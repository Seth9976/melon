package k8;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.iloen.melon.utils.log.LogU;

public final class f0 implements ConnectionCallbacks {
    @Override  // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle0) {
        LogU.Companion.d("MusicBrowserActivity", "GoogleApiClient connected");
    }

    @Override  // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int v) {
    }
}

