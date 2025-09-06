package androidx.media;

import P4.b;

public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(b b0) {
        AudioAttributesImplBase audioAttributesImplBase0 = new AudioAttributesImplBase();
        audioAttributesImplBase0.a = b0.f(audioAttributesImplBase0.a, 1);
        audioAttributesImplBase0.b = b0.f(audioAttributesImplBase0.b, 2);
        audioAttributesImplBase0.c = b0.f(audioAttributesImplBase0.c, 3);
        audioAttributesImplBase0.d = b0.f(audioAttributesImplBase0.d, 4);
        return audioAttributesImplBase0;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase0, b b0) {
        b0.getClass();
        b0.j(audioAttributesImplBase0.a, 1);
        b0.j(audioAttributesImplBase0.b, 2);
        b0.j(audioAttributesImplBase0.c, 3);
        b0.j(audioAttributesImplBase0.d, 4);
    }
}

