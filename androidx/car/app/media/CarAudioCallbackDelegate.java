package androidx.car.app.media;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import java.util.Objects;

public class CarAudioCallbackDelegate {
    static class CarAudioCallbackStub extends Stub {
        private final a mCarAudioCallback;

        public CarAudioCallbackStub() {
        }

        public CarAudioCallbackStub(a a0) {
        }

        @Override  // androidx.car.app.media.ICarAudioCallback
        public void onStopRecording() {
            throw null;
        }
    }

    private final ICarAudioCallback mCallback;

    private CarAudioCallbackDelegate() {
        this.mCallback = null;
    }

    private CarAudioCallbackDelegate(a a0) {
        this.mCallback = new CarAudioCallbackStub(a0);
    }

    @SuppressLint({"ExecutorRegistration"})
    public static CarAudioCallbackDelegate create(a a0) {
        return new CarAudioCallbackDelegate(a0);
    }

    public void onStopRecording() {
        try {
            Objects.requireNonNull(this.mCallback);
            this.mCallback.onStopRecording();
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }
}

