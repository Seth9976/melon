package androidx.media;

import P4.b;
import android.media.AudioAttributes;

public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(b b0) {
        AudioAttributesImplApi21 audioAttributesImplApi210 = new AudioAttributesImplApi21();
        audioAttributesImplApi210.a = (AudioAttributes)b0.g(audioAttributesImplApi210.a, 1);
        audioAttributesImplApi210.b = b0.f(audioAttributesImplApi210.b, 2);
        return audioAttributesImplApi210;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi210, b b0) {
        b0.getClass();
        b0.k(audioAttributesImplApi210.a, 1);
        b0.j(audioAttributesImplApi210.b, 2);
    }
}

