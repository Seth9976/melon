package v3;

import H6.g;
import android.media.Spatializer;
import androidx.media3.common.b;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;

public final class d implements g {
    public final DefaultTrackSelector a;

    public d(DefaultTrackSelector defaultTrackSelector0) {
        this.a = defaultTrackSelector0;
    }

    @Override  // H6.g
    public final boolean apply(Object object0) {
        int v = -1;
        boolean z = true;
        DefaultTrackSelector defaultTrackSelector0 = this.a;
        synchronized(defaultTrackSelector0.c) {
            if(defaultTrackSelector0.g.m0 && !defaultTrackSelector0.f && (((b)object0).C != -1 && ((b)object0).C > 2)) {
                String s = ((b)object0).n;
                if(s == null) {
                label_19:
                    if(defaultTrackSelector0.h == null || !defaultTrackSelector0.h.a || !((Spatializer)defaultTrackSelector0.h.b).isAvailable() || !((Spatializer)defaultTrackSelector0.h.b).isEnabled() || !defaultTrackSelector0.h.b(((b)object0), defaultTrackSelector0.i)) {
                        z = false;
                    }
                }
                else {
                    switch(s) {
                        case "audio/ac3": {
                            v = 1;
                            break;
                        }
                        case "audio/ac4": {
                            v = 2;
                            break;
                        }
                        case "audio/eac3": {
                            v = 3;
                            break;
                        }
                        case "audio/eac3-joc": {
                            v = 0;
                        }
                    }
                    if(v != 0 && v != 1 && v != 2 && v != 3 || defaultTrackSelector0.h != null && defaultTrackSelector0.h.a) {
                        goto label_19;
                    }
                }
            }
            return z;
        }
    }
}

