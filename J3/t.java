package j3;

import B3.c;
import android.media.AudioAttributes.Builder;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack.Builder;
import android.media.AudioTrack;
import b3.d;
import com.iloen.melon.utils.player.a;
import e3.x;

public final class t {
    public static final t a;
    public static final t b;

    static {
        t.a = new t();  // 初始化器: Ljava/lang/Object;-><init>()V
        t.b = new t();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public AudioTrack a(c c0, d d0, int v) {
        boolean z = c0.d;
        AudioFormat audioFormat0 = x.o(c0.b, c0.c, c0.a);
        AudioAttributes audioAttributes0 = t.b(d0, z);
        AudioTrack.Builder audioTrack$Builder0 = new AudioTrack.Builder().setAudioAttributes(audioAttributes0).setAudioFormat(audioFormat0).setTransferMode(1).setBufferSizeInBytes(c0.f).setSessionId(v);
        a.n(audioTrack$Builder0, c0.e);
        return audioTrack$Builder0.build();
    }

    // 去混淆评级： 低(20)
    public static AudioAttributes b(d d0, boolean z) {
        return z ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : ((AudioAttributes)d0.b().a);
    }

    public static int c(int v) {
        switch(v) {
            case 5: {
                return 80000;
            }
            case 7: {
                return 192000;
            }
            case 9: {
                return 40000;
            }
            case 10: {
                return 100000;
            }
            case 11: {
                return 16000;
            }
            case 12: {
                return 7000;
            }
            case 14: {
                return 3062500;
            }
            case 15: {
                return 8000;
            }
            case 16: {
                return 256000;
            }
            case 17: {
                return 336000;
            }
            case 6: 
            case 18: {
                return 768000;
            }
            case 20: {
                return 0xF906;
            }
            case 8: 
            case 30: {
                return 2250000;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
}

