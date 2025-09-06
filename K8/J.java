package k8;

import Nb.g;
import Nb.o0;
import Nb.p;
import android.app.Service;
import com.iloen.melon.playback.voicealarm.AlarmPlayService;
import com.iloen.melon.playback.voicealarm.AlarmPlayService_GeneratedInjector;
import fe.a;
import ge.b;

public final class j implements g, o0, p, AlarmPlayService_GeneratedInjector, a {
    public final Service a;
    public final o b;
    public final b c;
    public final b d;
    public final b e;
    public final b f;
    public final b g;

    public j(o o0, Service service0) {
        this.b = o0;
        this.a = service0;
        this.c = ge.a.a(new i(o0, this, 2, 0));
        this.d = ge.a.a(new i(o0, this, 3, 0));
        this.e = ge.a.a(new i(o0, this, 1, 0));
        this.f = ge.a.a(new i(o0, this, 4, 0));
        this.g = ge.a.a(new i(o0, this, 0, 0));
    }

    @Override  // com.iloen.melon.playback.voicealarm.AlarmPlayService_GeneratedInjector
    public final void injectAlarmPlayService(AlarmPlayService alarmPlayService0) {
    }
}

