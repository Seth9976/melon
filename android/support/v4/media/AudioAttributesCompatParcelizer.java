package android.support.v4.media;

import P4.b;
import androidx.media.AudioAttributesCompat;

public final class AudioAttributesCompatParcelizer extends androidx.media.AudioAttributesCompatParcelizer {
    @Override  // androidx.media.AudioAttributesCompatParcelizer
    public static AudioAttributesCompat read(b b0) {
        return androidx.media.AudioAttributesCompatParcelizer.read(b0);
    }

    @Override  // androidx.media.AudioAttributesCompatParcelizer
    public static void write(AudioAttributesCompat audioAttributesCompat0, b b0) {
        androidx.media.AudioAttributesCompatParcelizer.write(audioAttributesCompat0, b0);
    }
}

