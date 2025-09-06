package androidx.mediarouter.app;

import android.app.PendingIntent.CanceledException;
import android.app.PendingIntent;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View;

public final class h implements View.OnClickListener {
    public final int a;
    public final MediaRouteControllerDialog b;

    public h(MediaRouteControllerDialog mediaRouteControllerDialog0, int v) {
        this.a = v;
        this.b = mediaRouteControllerDialog0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                MediaRouteControllerDialog mediaRouteControllerDialog1 = this.b;
                boolean z = mediaRouteControllerDialog1.A0;
                mediaRouteControllerDialog1.A0 = !z;
                if(!z) {
                    mediaRouteControllerDialog1.Z.setVisibility(0);
                }
                mediaRouteControllerDialog1.G0 = mediaRouteControllerDialog1.A0 ? mediaRouteControllerDialog1.H0 : mediaRouteControllerDialog1.I0;
                mediaRouteControllerDialog1.q(true);
                return;
            }
            case 1: {
                this.b.dismiss();
                return;
            }
            default: {
                MediaRouteControllerDialog mediaRouteControllerDialog0 = this.b;
                MediaControllerCompat mediaControllerCompat0 = mediaRouteControllerDialog0.o0;
                if(mediaControllerCompat0 != null) {
                    PendingIntent pendingIntent0 = mediaControllerCompat0.getSessionActivity();
                    if(pendingIntent0 != null) {
                        try {
                            pendingIntent0.send();
                            mediaRouteControllerDialog0.dismiss();
                        }
                        catch(PendingIntent.CanceledException unused_ex) {
                            Log.e("MediaRouteCtrlDialog", pendingIntent0 + " was not sent, it had been canceled.");
                        }
                    }
                }
            }
        }
    }
}

