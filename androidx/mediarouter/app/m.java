package androidx.mediarouter.app;

import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import l4.Q;

public final class m implements View.OnClickListener {
    public final MediaRouteControllerDialog a;

    public m(MediaRouteControllerDialog mediaRouteControllerDialog0) {
        this.a = mediaRouteControllerDialog0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        MediaRouteControllerDialog mediaRouteControllerDialog0 = this.a;
        AccessibilityManager accessibilityManager0 = mediaRouteControllerDialog0.J0;
        int v = view0.getId();
        int v1 = 1;
        switch(v) {
            case 0x1020019: 
            case 0x102001A: {
                if(mediaRouteControllerDialog0.i.g()) {
                    Q q0 = mediaRouteControllerDialog0.g;
                    if(v == 0x1020019) {
                        v1 = 2;
                    }
                    q0.getClass();
                    Q.l(v1);
                }
                mediaRouteControllerDialog0.dismiss();
                return;
            }
            case 0x7F0A084D: {  // id:mr_close
                mediaRouteControllerDialog0.dismiss();
                return;
            }
            case 0x7F0A084F: {  // id:mr_control_playback_ctrl
                if(mediaRouteControllerDialog0.o0 != null) {
                    int v2 = 0;
                    PlaybackStateCompat playbackStateCompat0 = mediaRouteControllerDialog0.q0;
                    if(playbackStateCompat0 != null) {
                        if(playbackStateCompat0.getState() != 3) {
                            v1 = 0;
                            goto label_27;
                        }
                        else if((mediaRouteControllerDialog0.q0.getActions() & 0x202L) == 0L) {
                        label_27:
                            if(v1 != 0 && (mediaRouteControllerDialog0.q0.getActions() & 1L) != 0L) {
                                mediaRouteControllerDialog0.o0.getTransportControls().stop();
                                v2 = 0x7F1306CA;  // string:mr_controller_stop "Stop"
                            }
                            else if(v1 == 0 && (mediaRouteControllerDialog0.q0.getActions() & 0x204L) != 0L) {
                                mediaRouteControllerDialog0.o0.getTransportControls().play();
                                v2 = 0x7F1306C9;  // string:mr_controller_play "Play"
                            }
                        }
                        else {
                            mediaRouteControllerDialog0.o0.getTransportControls().pause();
                            v2 = 0x7F1306C8;  // string:mr_controller_pause "Pause"
                        }
                        if(accessibilityManager0 != null && accessibilityManager0.isEnabled() && v2 != 0) {
                            AccessibilityEvent accessibilityEvent0 = AccessibilityEvent.obtain(0x4000);
                            accessibilityEvent0.setPackageName("com.iloen.melon");
                            accessibilityEvent0.setClassName("androidx.mediarouter.app.m");
                            accessibilityEvent0.getText().add(mediaRouteControllerDialog0.j.getString(v2));
                            accessibilityManager0.sendAccessibilityEvent(accessibilityEvent0);
                        }
                    }
                }
            }
        }
    }
}

