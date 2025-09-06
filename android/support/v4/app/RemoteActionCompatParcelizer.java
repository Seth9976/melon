package android.support.v4.app;

import P4.b;
import androidx.core.app.RemoteActionCompat;

public final class RemoteActionCompatParcelizer extends androidx.core.app.RemoteActionCompatParcelizer {
    @Override  // androidx.core.app.RemoteActionCompatParcelizer
    public static RemoteActionCompat read(b b0) {
        return androidx.core.app.RemoteActionCompatParcelizer.read(b0);
    }

    @Override  // androidx.core.app.RemoteActionCompatParcelizer
    public static void write(RemoteActionCompat remoteActionCompat0, b b0) {
        androidx.core.app.RemoteActionCompatParcelizer.write(remoteActionCompat0, b0);
    }
}

