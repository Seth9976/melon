package androidx.car.app.media;

import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public final class OpenMicrophoneResponse {
    private final CarAudioCallbackDelegate mCarAudioCallbackDelegate;
    private final ParcelFileDescriptor mCarMicrophoneDescriptor;

    private OpenMicrophoneResponse() {
        this.mCarMicrophoneDescriptor = null;
        this.mCarAudioCallbackDelegate = null;
    }

    public OpenMicrophoneResponse(c c0) {
        throw null;
    }

    public CarAudioCallbackDelegate getCarAudioCallback() {
        Objects.requireNonNull(this.mCarAudioCallbackDelegate);
        return this.mCarAudioCallbackDelegate;
    }

    public InputStream getCarMicrophoneInputStream() {
        ParcelFileDescriptor parcelFileDescriptor0 = this.mCarMicrophoneDescriptor;
        if(parcelFileDescriptor0 == null) {
            try {
                ParcelFileDescriptor[] arr_parcelFileDescriptor = ParcelFileDescriptor.createReliablePipe();
                arr_parcelFileDescriptor[1].close();
                return new ParcelFileDescriptor.AutoCloseInputStream(arr_parcelFileDescriptor[0]);
            }
            catch(IOException iOException0) {
                throw new IllegalStateException(iOException0);
            }
        }
        return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor0);
    }
}

