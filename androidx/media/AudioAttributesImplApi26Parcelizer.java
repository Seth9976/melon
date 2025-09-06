package androidx.media;

import P4.b;
import android.media.AudioAttributes;

public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(b b0) {
        AudioAttributesImplApi26 audioAttributesImplApi260 = new AudioAttributesImplApi26();
        audioAttributesImplApi260.a = (AudioAttributes)b0.g(audioAttributesImplApi260.a, 1);
        audioAttributesImplApi260.b = b0.f(audioAttributesImplApi260.b, 2);
        return audioAttributesImplApi260;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi260, b b0) {
        b0.getClass();
        b0.k(audioAttributesImplApi260.a, 1);
        b0.j(audioAttributesImplApi260.b, 2);
    }
}

