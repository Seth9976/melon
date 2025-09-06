package androidx.media;

import P4.b;
import P4.d;

public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(b b0) {
        AudioAttributesCompat audioAttributesCompat0 = new AudioAttributesCompat();
        d d0 = audioAttributesCompat0.a;
        if(b0.e(1)) {
            d0 = b0.h();
        }
        audioAttributesCompat0.a = (AudioAttributesImpl)d0;
        return audioAttributesCompat0;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat0, b b0) {
        b0.getClass();
        AudioAttributesImpl audioAttributesImpl0 = audioAttributesCompat0.a;
        b0.i(1);
        b0.l(audioAttributesImpl0);
    }
}

