package i3;

import android.content.Context;
import android.media.metrics.PlaybackMetrics.Builder;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent.Builder;
import android.media.metrics.TrackChangeEvent;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import b3.A;
import b3.K;
import b3.m0;
import b3.o0;
import b3.p0;
import e3.x;
import java.util.HashMap;
import s3.z;

public final class j implements b {
    public boolean A;
    public final Context a;
    public final g b;
    public final PlaybackSession c;
    public final long d;
    public final o0 e;
    public final m0 f;
    public final HashMap g;
    public final HashMap h;
    public String i;
    public PlaybackMetrics.Builder j;
    public int k;
    public int l;
    public int m;
    public K n;
    public B7.b o;
    public B7.b p;
    public B7.b q;
    public androidx.media3.common.b r;
    public androidx.media3.common.b s;
    public androidx.media3.common.b t;
    public boolean u;
    public int v;
    public boolean w;
    public int x;
    public int y;
    public int z;

    public j(Context context0, PlaybackSession playbackSession0) {
        this.a = context0.getApplicationContext();
        this.c = playbackSession0;
        this.e = new o0();
        this.f = new m0();
        this.h = new HashMap();
        this.g = new HashMap();
        this.d = SystemClock.elapsedRealtime();
        this.l = 0;
        this.m = 0;
        g g0 = new g();
        this.b = g0;
        g0.d = this;
    }

    public final boolean a(B7.b b0) {
        return b0 != null && ((String)b0.b).equals(this.b.f);
    }

    public final void b() {
        PlaybackMetrics.Builder playbackMetrics$Builder0 = this.j;
        if(playbackMetrics$Builder0 != null && this.A) {
            playbackMetrics$Builder0.setAudioUnderrunCount(this.z);
            this.j.setVideoFramesDropped(this.x);
            this.j.setVideoFramesPlayed(this.y);
            Long long0 = (Long)this.g.get(this.i);
            this.j.setNetworkTransferDurationMillis((long0 == null ? 0L : ((long)long0)));
            Long long1 = (Long)this.h.get(this.i);
            this.j.setNetworkBytesRead((long1 == null ? 0L : ((long)long1)));
            this.j.setStreamSource((long1 == null || ((long)long1) <= 0L ? 0 : 1));
            PlaybackMetrics playbackMetrics0 = this.j.build();
            this.c.reportPlaybackMetrics(playbackMetrics0);
        }
        this.j = null;
        this.i = null;
        this.z = 0;
        this.x = 0;
        this.y = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.A = false;
    }

    public final void c(p0 p00, z z0) {
        PlaybackMetrics.Builder playbackMetrics$Builder0 = this.j;
        if(z0 != null) {
            int v = p00.b(z0.a);
            if(v != -1) {
                int v1 = 0;
                p00.f(v, this.f, false);
                o0 o00 = this.e;
                p00.n(this.f.c, o00);
                A a0 = o00.c.b;
                int v2 = 2;
                if(a0 != null) {
                    Uri uri0 = a0.a;
                    String s = a0.b;
                    if(s == null) {
                        v1 = x.F(uri0);
                        goto label_23;
                    }
                    else {
                    alab1:
                        switch(s) {
                            case "application/dash+xml": {
                            label_23:
                                switch(v1) {
                                    case 0: {
                                        v1 = 3;
                                        break alab1;
                                    }
                                    case 1: {
                                        v1 = 5;
                                        break alab1;
                                    }
                                    case 2: {
                                        v1 = 4;
                                        break alab1;
                                    }
                                    default: {
                                        v1 = 1;
                                        break alab1;
                                    }
                                }
                            }
                            case "application/vnd.ms-sstr+xml": {
                                v1 = 5;
                                break;
                            }
                            case "application/x-mpegURL": {
                                v1 = 4;
                                break;
                            }
                            case "application/x-rtsp": {
                                v1 = 1;
                                break;
                            }
                            default: {
                                v1 = 1;
                            }
                        }
                    }
                }
                playbackMetrics$Builder0.setStreamType(v1);
                if(o00.m != 0x8000000000000001L && !o00.k && !o00.i && !o00.a()) {
                    playbackMetrics$Builder0.setMediaDurationMillis(x.Z(o00.m));
                }
                if(!o00.a()) {
                    v2 = 1;
                }
                playbackMetrics$Builder0.setPlaybackType(v2);
                this.A = true;
            }
        }
    }

    public final void d(a a0, String s) {
        if((a0.d == null || !a0.d.b()) && s.equals(this.i)) {
            this.b();
        }
        this.g.remove(s);
        this.h.remove(s);
    }

    public final void e(int v, long v1, androidx.media3.common.b b0, int v2) {
        TrackChangeEvent.Builder trackChangeEvent$Builder0 = h.n(v).setTimeSinceCreatedMillis(v1 - this.d);
        if(b0 == null) {
            i.u(trackChangeEvent$Builder0);
        }
        else {
            int v3 = 3;
            i.D(trackChangeEvent$Builder0);
            switch(v2) {
                case 1: {
                    v3 = 2;
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    v3 = 4;
                    break;
                }
                default: {
                    v3 = 1;
                }
            }
            trackChangeEvent$Builder0.setTrackChangeReason(v3);
            String s = b0.m;
            if(s != null) {
                trackChangeEvent$Builder0.setContainerMimeType(s);
            }
            String s1 = b0.n;
            if(s1 != null) {
                trackChangeEvent$Builder0.setSampleMimeType(s1);
            }
            String s2 = b0.k;
            if(s2 != null) {
                trackChangeEvent$Builder0.setCodecName(s2);
            }
            int v4 = b0.j;
            if(v4 != -1) {
                trackChangeEvent$Builder0.setBitrate(v4);
            }
            int v5 = b0.u;
            if(v5 != -1) {
                trackChangeEvent$Builder0.setWidth(v5);
            }
            int v6 = b0.v;
            if(v6 != -1) {
                trackChangeEvent$Builder0.setHeight(v6);
            }
            int v7 = b0.C;
            if(v7 != -1) {
                trackChangeEvent$Builder0.setChannelCount(v7);
            }
            int v8 = b0.D;
            if(v8 != -1) {
                trackChangeEvent$Builder0.setAudioSampleRate(v8);
            }
            String s3 = b0.d;
            if(s3 != null) {
                String[] arr_s = s3.split("-", -1);
                Pair pair0 = Pair.create(arr_s[0], (arr_s.length < 2 ? null : arr_s[1]));
                trackChangeEvent$Builder0.setLanguage(((String)pair0.first));
                Object object0 = pair0.second;
                if(object0 != null) {
                    trackChangeEvent$Builder0.setLanguageRegion(((String)object0));
                }
            }
            float f = b0.w;
            if(f != -1.0f) {
                trackChangeEvent$Builder0.setVideoFrameRate(f);
            }
        }
        this.A = true;
        TrackChangeEvent trackChangeEvent0 = trackChangeEvent$Builder0.build();
        this.c.reportTrackChangeEvent(trackChangeEvent0);
    }
}

