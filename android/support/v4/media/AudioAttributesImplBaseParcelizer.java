package android.support.v4.media;

import P4.b;
import androidx.media.AudioAttributesImplBase;

public final class AudioAttributesImplBaseParcelizer extends androidx.media.AudioAttributesImplBaseParcelizer {
    @Override  // androidx.media.AudioAttributesImplBaseParcelizer
    public static AudioAttributesImplBase read(b b0) {
        return androidx.media.AudioAttributesImplBaseParcelizer.read(b0);
    }

    @Override  // androidx.media.AudioAttributesImplBaseParcelizer
    public static void write(AudioAttributesImplBase audioAttributesImplBase0, b b0) {
        androidx.media.AudioAttributesImplBaseParcelizer.write(audioAttributesImplBase0, b0);
    }
}

