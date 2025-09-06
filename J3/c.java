package j3;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import e3.x;

public final class c extends AudioDeviceCallback {
    public final e a;

    public c(e e0) {
        this.a = e0;
        super();
    }

    @Override  // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] arr_audioDeviceInfo) {
        b b0 = b.c(this.a.a, this.a.i, this.a.h);
        this.a.a(b0);
    }

    @Override  // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] arr_audioDeviceInfo) {
        e e0 = this.a;
        if(x.j(arr_audioDeviceInfo, e0.h)) {
            e0.h = null;
        }
        e0.a(b.c(e0.a, e0.i, e0.h));
    }
}

