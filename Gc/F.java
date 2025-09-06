package gc;

import android.content.Context;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.audio.DefaultAudioSink.Builder;
import androidx.media3.session.legacy.V;
import com.gaudiolab.sol.android.Parameters;
import com.gaudiolab.sol.android.SolMusicOne.LoudnessType;
import com.gaudiolab.sol.android.SolMusicOne;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import j3.s;
import kotlin.jvm.internal.q;
import p8.e;
import sd.j;
import y8.a;
import y8.l;
import y8.m;

public final class f extends DefaultRenderersFactory {
    @Override  // androidx.media3.exoplayer.DefaultRenderersFactory
    public final s a(Context context0) {
        q.g(context0, "context");
        DefaultAudioSink.Builder defaultAudioSink$Builder0 = new DefaultAudioSink.Builder(context0);
        if(y8.f.b().c.isEnable) {
            LogU.Companion.d("AudioEffectController", "initialize");
            SolMusicOne solMusicOne0 = new SolMusicOne("P0eLaJoV8ZVRjcOSwLmBfA==");
            a.b = new m(solMusicOne0, y8.f.b(), context0.getAssets(), new e(29), new j(22));
            a.a = solMusicOne0;
            l.a.d();
            Parameters parameters0 = y8.f.b().c;
            int v = MelonSettingInfo.getAudioLoudnessType();
            LoudnessType solMusicOne$LoudnessType0 = LoudnessType.kOff;
            if(v != solMusicOne$LoudnessType0.ordinal()) {
                solMusicOne$LoudnessType0 = LoudnessType.kLSC_QualitySecure;
                if(v != solMusicOne$LoudnessType0.ordinal()) {
                    LoudnessType solMusicOne$LoudnessType1 = LoudnessType.kLSC_Transparent;
                    if(v == solMusicOne$LoudnessType1.ordinal()) {
                        solMusicOne$LoudnessType0 = solMusicOne$LoudnessType1;
                    }
                }
            }
            parameters0.loudnessType = solMusicOne$LoudnessType0;
            m m0 = a.b;
            q.d(m0);
            defaultAudioSink$Builder0.c = new V(new m[]{m0});
        }
        return defaultAudioSink$Builder0.a();
    }
}

