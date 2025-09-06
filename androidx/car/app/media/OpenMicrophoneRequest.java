package androidx.car.app.media;

import java.util.Objects;

public final class OpenMicrophoneRequest {
    private final CarAudioCallbackDelegate mCarAudioCallbackDelegate;

    private OpenMicrophoneRequest() {
        this.mCarAudioCallbackDelegate = null;
    }

    public OpenMicrophoneRequest(b b0) {
        throw null;
    }

    public CarAudioCallbackDelegate getCarAudioCallbackDelegate() {
        Objects.requireNonNull(this.mCarAudioCallbackDelegate);
        return this.mCarAudioCallbackDelegate;
    }
}

