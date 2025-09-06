package Nb;

import Bf.a;
import Cb.i;
import U4.F;
import Ub.q;
import b3.E;
import b3.O;
import b3.P;
import b3.S;
import b3.m;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import gc.G;
import gc.y;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

public final class t0 implements P {
    public final S a;
    public final q b;
    public final LogU c;

    public t0(S s0, q q0, CoroutineScope coroutineScope0) {
        kotlin.jvm.internal.q.g(q0, "playbackManager");
        kotlin.jvm.internal.q.g(coroutineScope0, "coroutine");
        super();
        this.a = s0;
        this.b = q0;
        this.c = Companion.create$default(LogU.Companion, "PlayerListener", false, Category.Playback, 2, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new s0(this, null), 3, null);
    }

    @Override  // b3.P
    public final void M(S s0, O o0) {
        String s2;
        kotlin.jvm.internal.q.g(s0, "player");
        String s1 = F.a0(s0.getPlaybackState());
        StringBuilder stringBuilder0 = new StringBuilder();
        m m0 = o0.a;
        int v = m0.a.size();
        stringBuilder0.append("Event Count: " + v);
        for(int v1 = 0; v1 < v; ++v1) {
            switch(m0.b(v1)) {
                case 0: {
                    s2 = "EVENT_TIMELINE_CHANGED";
                    break;
                }
                case 1: {
                    s2 = "EVENT_MEDIA_ITEM_TRANSITION";
                    break;
                }
                case 2: {
                    s2 = "EVENT_TRACKS_CHANGED";
                    break;
                }
                case 3: {
                    s2 = "EVENT_IS_LOADING_CHANGED";
                    break;
                }
                case 4: {
                    s2 = "EVENT_PLAYBACK_STATE_CHANGED";
                    break;
                }
                case 5: {
                    s2 = "EVENT_PLAY_WHEN_READY_CHANGED";
                    break;
                }
                case 6: {
                    s2 = "EVENT_PLAYBACK_SUPPRESSION_REASON_CHANGED";
                    break;
                }
                case 7: {
                    s2 = "EVENT_IS_PLAYING_CHANGED";
                    break;
                }
                case 8: {
                    s2 = "EVENT_REPEAT_MODE_CHANGED";
                    break;
                }
                case 9: {
                    s2 = "EVENT_SHUFFLE_MODE_ENABLED_CHANGED";
                    break;
                }
                case 10: {
                    s2 = "EVENT_PLAYER_ERROR";
                    break;
                }
                case 11: {
                    s2 = "EVENT_POSITION_DISCONTINUITY";
                    break;
                }
                case 12: {
                    s2 = "EVENT_PLAYBACK_PARAMETERS_CHANGED";
                    break;
                }
                case 13: {
                    s2 = "EVENT_AVAILABLE_COMMANDS_CHANGED";
                    break;
                }
                case 14: {
                    s2 = "EVENT_MEDIA_METADATA_CHANGED";
                    break;
                }
                case 15: {
                    s2 = "EVENT_PLAYLIST_METADATA_CHANGED";
                    break;
                }
                case 16: {
                    s2 = "EVENT_SEEK_BACK_INCREMENT_CHANGED";
                    break;
                }
                case 17: {
                    s2 = "EVENT_SEEK_FORWARD_INCREMENT_CHANGED";
                    break;
                }
                case 18: {
                    s2 = "EVENT_MAX_SEEK_TO_PREVIOUS_POSITION_CHANGED";
                    break;
                }
                case 19: {
                    s2 = "EVENT_TRACK_SELECTION_PARAMETERS_CHANGED";
                    break;
                }
                case 20: {
                    s2 = "EVENT_AUDIO_ATTRIBUTES_CHANGED";
                    break;
                }
                case 21: {
                    s2 = "EVENT_AUDIO_SESSION_ID";
                    break;
                }
                case 22: {
                    s2 = "EVENT_VOLUME_CHANGED";
                    break;
                }
                case 23: {
                    s2 = "EVENT_SKIP_SILENCE_ENABLED_CHANGED";
                    break;
                }
                case 24: {
                    s2 = "EVENT_SURFACE_SIZE_CHANGED";
                    break;
                }
                case 25: {
                    s2 = "EVENT_VIDEO_SIZE_CHANGED";
                    break;
                }
                case 26: {
                    s2 = "EVENT_RENDERED_FIRST_FRAME";
                    break;
                }
                case 27: {
                    s2 = "EVENT_CUES";
                    break;
                }
                case 28: {
                    s2 = "EVENT_METADATA";
                    break;
                }
                case 29: {
                    s2 = "EVENT_DEVICE_INFO_CHANGED";
                    break;
                }
                case 30: {
                    s2 = "EVENT_DEVICE_VOLUME_CHANGED";
                    break;
                }
                default: {
                    s2 = "Unknown";
                }
            }
            i.a(stringBuilder0, s2);
        }
        LogConstantsKt.infoOnlyDebugMode(this.c, "onEvents() [" + s1 + "] " + stringBuilder0.toString());
        if(m0.a(new int[]{4, 5, 14, 0, 22, 8, 9, 11})) {
            this.a(s0);
        }
    }

    public final void a(S s0) {
        int v = s0.getPlaybackState();
        E e0 = s0.W();
        G g0 = null;
        b3.G g1 = e0 == null ? null : e0.d;
        S s1 = s0 instanceof y ? s0 : null;
        if(((y)s1) != null) {
            a a0 = ((y)s1).n.e;
            if(a0 instanceof G) {
                g0 = (G)a0;
            }
        }
        p0 p00 = new p0(v, s0, e0, g1, g0, this);
        MutableStateFlow mutableStateFlow0 = this.b.b;
        do {
            Object object0 = mutableStateFlow0.getValue();
        }
        while(!mutableStateFlow0.compareAndSet(object0, p00.invoke(object0)));
    }
}

