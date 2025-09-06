package j3;

import android.media.AudioRouting.OnRoutingChangedListener;
import android.media.AudioRouting;
import d5.m;

public final class q implements AudioRouting.OnRoutingChangedListener {
    public final m a;

    public q(m m0) {
        this.a = m0;
    }

    @Override  // android.media.AudioRouting$OnRoutingChangedListener
    public final void onRoutingChanged(AudioRouting audioRouting0) {
        m m0 = this.a;
        if(((q)m0.d) != null && audioRouting0.getRoutedDevice() != null) {
            ((e)m0.c).b(audioRouting0.getRoutedDevice());
        }
    }
}

