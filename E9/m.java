package E9;

import A7.d;
import U4.x;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.util.Log;
import androidx.appcompat.app.o;
import androidx.media3.session.legacy.MediaBrowserCompat.MediaItem;
import androidx.media3.session.legacy.MediaSessionCompat.Token;
import androidx.media3.session.legacy.V;
import androidx.media3.session.legacy.g;
import androidx.media3.session.legacy.i;
import androidx.media3.session.legacy.j;
import androidx.media3.session.n0;
import com.inisoft.media.MediaPlayer.TrackInfo;
import com.inisoft.media.MediaPlayer.TrackRepresentation;
import com.kakaoent.leonplayer.core.LeonPlayerImpl;
import com.kakaoent.leonplayer.core.a;
import i.n.i.b.a.s.e.F3;
import i.n.i.b.a.s.e.Vb;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import l4.t;
import l4.y;
import l4.z;

public final class m extends Handler {
    public final int a;
    public Object b;
    public Object c;

    public m(n n0, n n1, Looper looper0) {
        this.a = 0;
        this.c = n0;
        super(looper0);
        this.b = n1;
    }

    public m(i i0) {
        this.a = 2;
        super();
        this.b = new WeakReference(i0);
    }

    public m(n0 n00, Looper looper0) {
        this.a = 1;
        this.c = n00;
        super(looper0);
    }

    public m(t t0, String s) {
        this.a = 3;
        super(Looper.myLooper());
        this.b = t0;
        this.c = s;
    }

    @Override  // android.os.Handler
    public void handleMessage(Message message0) {
        String s5;
        String s7;
        String s6;
        switch(this.a) {
            case 0: {
                n n0 = (n)this.b;
                n n1 = (n)this.c;
                Vb vb0 = n1.d;
                int v = message0.what;
                String s = "";
            alab1:
                switch(v) {
                    case 0: {
                        break;
                    }
                    case 200: {
                        int v10 = message0.arg1;
                        int v11 = message0.arg2;
                        if(v10 != 701) {
                            if(v10 == 702) {
                                if(n1.p == 0x8000000000000001L) {
                                    s6 = " start time not set";
                                }
                                else {
                                    long v12 = SystemClock.elapsedRealtime() - n1.p;
                                    n1.q += v12;
                                    s6 = " for " + ((float)v12) / 1000.0f + " accumulated " + ((float)n1.q) / 1000.0f;
                                }
                                s = s6;
                                n1.p = 0x8000000000000001L;
                            }
                        }
                        else if(n1.p == 0x8000000000000001L) {
                            n1.p = SystemClock.elapsedRealtime();
                        }
                        StringBuilder stringBuilder1 = x.n(v10, "Info (", " ");
                        switch(v10) {
                            case 1: {
                                s7 = "UNKNOWN";
                                break;
                            }
                            case 3: {
                                s7 = "VIDEO_RENDERING_START";
                                break;
                            }
                            case 700: {
                                s7 = "VIDEO_TRACK_LAGGING";
                                break;
                            }
                            case 701: {
                                s7 = "BUFFERING_START";
                                break;
                            }
                            case 702: {
                                s7 = "BUFFERING_END";
                                break;
                            }
                            case 704: {
                                s7 = "MAX_BUFFER_SIZE";
                                break;
                            }
                            case 800: {
                                s7 = "BAD_INTERLEAVING";
                                break;
                            }
                            case 801: {
                                s7 = "NOT_SEEKABLE";
                                break;
                            }
                            case 802: {
                                s7 = "METADATA_UPDATE";
                                break;
                            }
                            case 901: {
                                s7 = "UNSUPPORTED_SUBTITLE";
                                break;
                            }
                            case 902: {
                                s7 = "SUBTITLE_TIMED_OUT";
                                break;
                            }
                            case 100000: {
                                s7 = "CUSTOM_BASE";
                                break;
                            }
                            case 100001: {
                                s7 = "TIMEDTEXT_TRACK_CHANGED";
                                break;
                            }
                            case 100103: {
                                s7 = "CURRENT_STREAMING_BANDWIDTH";
                                break;
                            }
                            case 100104: {
                                s7 = "CURRENT_PLAYING_BANDWIDTH";
                                break;
                            }
                            case 100105: {
                                s7 = "TUNNELED_VIDEO_PLAYBACK_ENABLED";
                                break;
                            }
                            case 100106: {
                                s7 = "VIDEO_TRACK_SWITCHED";
                                break;
                            }
                            case 100201: {
                                s7 = "MEDIA_INFO_TIMEDTEXT_ERROR";
                                break;
                            }
                            case 110000: {
                                s7 = "VENDOR_CUSTOM_BASE";
                                break;
                            }
                            case 110001: {
                                s7 = "SIMPLE_MEDIA_FORMAT";
                                break;
                            }
                            case 1000001: {
                                s7 = "BUFFER_STATUS";
                                break;
                            }
                            case 1000002: {
                                s7 = "CURRENT_BANDWIDTH";
                                break;
                            }
                            case 1000010: {
                                s7 = "ADAPTIVE_CURRENT_STREAM_BANDWIDTH";
                                break;
                            }
                            case 1000011: {
                                s7 = "ADAPTIVE_CURRENT_PLAYING_BANDWIDTH";
                                break;
                            }
                            case 1000051: {
                                s7 = "SEGMENT_REWIND";
                                break;
                            }
                            case 1000052: {
                                s7 = "SEGMENT_JUMP";
                                break;
                            }
                            case 1000061: {
                                s7 = "AWS_MEDIA_ANALYTICS";
                                break;
                            }
                            default: {
                                s7 = "undef";
                            }
                        }
                        d.t(stringBuilder1, s7, ",", v11, ")");
                        stringBuilder1.append(s);
                        Log.d("MediaPlayer", stringBuilder1.toString());
                        a a5 = n1.j;
                        if(a5 != null) {
                            LeonPlayerImpl.b(a5.a, n0, message0.arg1, message0.arg2, message0.obj);
                        }
                        break;
                    }
                    case 202: {
                        Log.d("MediaPlayer", "MEDIA_LICENSE_RESPONSE event");
                        return;
                    label_14:
                        switch(v) {
                            case 1: {
                                Log.d("MediaPlayer", "MEDIA_PREPARED event");
                                n1.n = vb0.X;
                                MediaPlayer.TrackInfo[] arr_mediaPlayer$TrackInfo = n1.i();
                                n1.o = 0;
                                for(int v4 = 0; v4 < arr_mediaPlayer$TrackInfo.length; ++v4) {
                                    MediaPlayer.TrackInfo mediaPlayer$TrackInfo0 = arr_mediaPlayer$TrackInfo[v4];
                                    if(mediaPlayer$TrackInfo0.c == 1 && !vb0.L) {
                                        MediaPlayer.TrackRepresentation[] arr_mediaPlayer$TrackRepresentation = mediaPlayer$TrackInfo0.g;
                                        for(int v5 = 0; v5 < arr_mediaPlayer$TrackRepresentation.length; ++v5) {
                                            int v6 = n1.o;
                                            int v7 = arr_mediaPlayer$TrackRepresentation[v5].b.h;
                                            if(v7 == -1) {
                                                v7 = 0;
                                            }
                                            n1.o = Math.max(v6, v7);
                                        }
                                    }
                                }
                                a a2 = n1.f;
                                if(a2 != null) {
                                    LeonPlayerImpl.a(a2.a, n0);
                                    return;
                                }
                                break alab1;
                            }
                            case 2: {
                                Log.d("MediaPlayer", "MEDIA_PLAYBACK_COMPLETE event");
                                a a0 = n1.g;
                                if(a0 != null) {
                                    LeonPlayerImpl.g(a0.a, n0);
                                }
                                n1.b(false);
                                return;
                            }
                            case 3: {
                                Log.d("MediaPlayer", "MEDIA_BUFFERING_UPDATE event, " + message0.arg1);
                                a a3 = n1.i;
                                if(a3 != null) {
                                    LeonPlayerImpl.f(a3.a, n0, message0.arg1);
                                    return;
                                }
                                break alab1;
                            }
                            case 4: {
                                Log.d("MediaPlayer", "MEDIA_SEEK_COMPLETE event");
                                a a4 = n1.l;
                                if(a4 != null) {
                                    LeonPlayerImpl.c(a4.a, n0);
                                    return;
                                }
                                break alab1;
                            }
                            case 5: {
                                Log.d("MediaPlayer", "MEDIA_SET_VIDEO_SIZE event, " + message0.arg1 + ", " + message0.arg2);
                                return;
                            }
                            case 98: {
                                Log.d("MediaPlayer", "MEDIA_TIMED_TEXT_CUES event");
                                if(n1.k != null) {
                                    List list0 = (List)message0.obj;
                                    int v8 = list0.size();
                                    r[] arr_r = new r[v8];
                                    for(int v9 = 0; v9 < list0.size(); ++v9) {
                                        Object object0 = list0.get(v9);
                                        String s1 = null;
                                        if(object0 instanceof F3) {
                                            CharSequence charSequence0 = ((F3)object0).a;
                                            if(charSequence0 == null) {
                                                charSequence0 = "";
                                            }
                                            String s2 = ((F3)object0).q;
                                            if(s2 == null) {
                                                s2 = null;
                                            }
                                            String s3 = ((F3)object0).r;
                                            if(s3 != null) {
                                                s1 = s3;
                                            }
                                            arr_r[v9] = new r(charSequence0, s2, s1);
                                        }
                                        else if(object0 == null) {
                                            arr_r[v9] = new r("", null, null);
                                        }
                                        else {
                                            Log.w("MediaPlayer", "invalid cue format " + object0);
                                        }
                                    }
                                    if(v8 > 0) {
                                        for(int v1 = 0; v1 < v8; ++v1) {
                                            r r0 = arr_r[v1];
                                            String s4 = r0.c;
                                            if(r0.b == null) {
                                                s5 = s4 == null ? "null" : "ttml:" + s4;
                                            }
                                            else {
                                                s5 = "vtt:" + r0.b;
                                            }
                                            Log.d("MediaPlayer", "onTimedTextCues(" + r0.a + ") [" + s5 + "]");
                                        }
                                    }
                                    else {
                                        Log.d("MediaPlayer", "onTimedTextCues() [null]");
                                    }
                                    LeonPlayerImpl.h(n1.k.a, n0, arr_r);
                                    return;
                                }
                                break alab1;
                            }
                            case 99: {
                                Log.d("MediaPlayer", "MEDIA_TIMED_TEXT event");
                                return;
                            }
                            case 100: {
                                int v2 = message0.arg1;
                                int v3 = message0.arg2;
                                StringBuilder stringBuilder0 = o.t(v2, v3, "Error (", ",", ",");
                                stringBuilder0.append(Integer.toHexString(v3));
                                stringBuilder0.append(")");
                                Log.e("MediaPlayer", stringBuilder0.toString());
                                boolean z = n1.h == null ? false : LeonPlayerImpl.e(n1.h.a, n0, v2, v3);
                                a a1 = n1.g;
                                if(a1 != null && !z) {
                                    LeonPlayerImpl.g(a1.a, n0);
                                }
                                n1.b(false);
                                n1.c.v();
                                return;
                            }
                            default: {
                                Log.e("MediaPlayer", "Unknown message type " + message0.what);
                                return;
                            }
                        }
                    }
                    case 300: {
                        Log.d("MediaPlayer", "MEDIA_QOE_ALERT event");
                        return;
                    }
                    case 400: {
                        Log.d("MediaPlayer", "MEDIA_META_DATA event");
                        if(n1.m != null) {
                            Object object1 = message0.obj;
                            if(object1 instanceof byte[]) {
                                q q0 = new q();  // 初始化器: Ljava/lang/Object;-><init>()V
                                q0.a = (byte[])object1;
                                Log.d("MediaPlayer", "onTimedMetaDataAvailable([" + Arrays.toString(((byte[])object1)) + "])");
                                LeonPlayerImpl.d(n1.m.a, n0, q0);
                                return;
                            }
                        }
                        break;
                    }
                    default: {
                        goto label_14;
                    }
                }
                return;
            }
            case 2: {
                WeakReference weakReference0 = (WeakReference)this.c;
                if(weakReference0 != null) {
                    Messenger messenger0 = (Messenger)weakReference0.get();
                    i i0 = (i)((WeakReference)this.b).get();
                    if(messenger0 != null && i0 != null) {
                        Bundle bundle0 = message0.getData();
                        V.f(bundle0);
                        try {
                            switch(message0.what) {
                                case 1: {
                                    V.f(bundle0.getBundle("data_root_hints"));
                                    bundle0.getString("data_media_item_id");
                                    MediaSessionCompat.Token mediaSessionCompat$Token0 = (MediaSessionCompat.Token)g.a(bundle0.getParcelable("data_media_session_token"), MediaSessionCompat.Token.CREATOR);
                                    return;
                                }
                                case 2: {
                                    break;
                                }
                                case 3: {
                                    V.f(bundle0.getBundle("data_options"));
                                    V.f(bundle0.getBundle("data_notify_children_changed_options"));
                                    String s8 = bundle0.getString("data_media_item_id");
                                    g.b(bundle0.getParcelableArrayList("data_media_item_list"), MediaBrowserCompat.MediaItem.CREATOR);
                                    if(i0.g == messenger0) {
                                        if(s8 != null && i0.e.get(s8) != null) {
                                            throw new ClassCastException();
                                        }
                                        if(j.b) {
                                            Log.d("MediaBrowserCompat", "onLoadChildren for id that isn\'t subscribed id=" + s8);
                                            return;
                                        }
                                    }
                                    break;
                                }
                                default: {
                                    Log.w("MediaBrowserCompat", "Unhandled message: " + message0 + "\n  Client version: 1\n  Service version: " + message0.arg1);
                                    return;
                                }
                            }
                        }
                        catch(BadParcelableException unused_ex) {
                            Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                        }
                    }
                }
                return;
            }
            case 3: {
                t t0 = (t)this.b;
                Messenger messenger1 = message0.replyTo;
                int v13 = message0.what;
                int v14 = message0.arg1;
                Object object2 = message0.obj;
                Bundle bundle1 = message0.getData();
                switch(v13) {
                    case 7: {
                        int v15 = bundle1.getInt("volume", -1);
                        String s9 = bundle1.getString("routeId");
                        if(v15 >= 0 && s9 != null) {
                            z z1 = t0.b(s9);
                            if(z1 == null) {
                                Log.w("MR2ProviderService", "setRouteVolume: Couldn\'t find a controller for routeId=" + s9);
                                return;
                            }
                            z1.g(v15);
                            return;
                        }
                        break;
                    }
                    case 8: {
                        int v16 = bundle1.getInt("volume", 0);
                        String s10 = bundle1.getString("routeId");
                        if(v16 != 0 && s10 != null) {
                            z z2 = t0.b(s10);
                            if(z2 == null) {
                                Log.w("MR2ProviderService", "updateRouteVolume: Couldn\'t find a controller for routeId=" + s10);
                                return;
                            }
                            z2.j(v16);
                            return;
                        }
                        break;
                    }
                    case 9: {
                        if(object2 instanceof Intent) {
                            String s11 = (String)this.c;
                            t0.getClass();
                            if(t0.getSessionInfo(s11) == null) {
                                Log.w("MR2ProviderService", "onCustomCommand: Couldn\'t find a session");
                                return;
                            }
                            y y0 = t0.c(s11);
                            if(y0 == null) {
                                Log.w("MR2ProviderService", "onControlRequest: Couldn\'t find a controller");
                                l4.i.C(t0, ((long)v14));
                                return;
                            }
                            y0.d(((Intent)object2), new l4.q(s11, ((Intent)object2), messenger1, v14));
                            return;
                        }
                        break;
                    }
                    default: {
                        return;
                    }
                }
                return;
            }
            default: {
                super.handleMessage(message0);
            }
        }
    }
}

