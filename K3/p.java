package k3;

import android.media.MediaDrmException;
import h3.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class p implements t {
    @Override  // k3.t
    public final void a(c c0) {
    }

    @Override  // k3.t
    public final int b() {
        return 1;
    }

    @Override  // k3.t
    public final a c(byte[] arr_b) {
        throw new IllegalStateException();
    }

    @Override  // k3.t
    public final void closeSession(byte[] arr_b) {
    }

    @Override  // k3.t
    public final boolean e(String s, byte[] arr_b) {
        throw new IllegalStateException();
    }

    @Override  // k3.t
    public final r getKeyRequest(byte[] arr_b, List list0, int v, HashMap hashMap0) {
        throw new IllegalStateException();
    }

    @Override  // k3.t
    public final s getProvisionRequest() {
        throw new IllegalStateException();
    }

    @Override  // k3.t
    public final byte[] openSession() {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override  // k3.t
    public final byte[] provideKeyResponse(byte[] arr_b, byte[] arr_b1) {
        throw new IllegalStateException();
    }

    @Override  // k3.t
    public final void provideProvisionResponse(byte[] arr_b) {
        throw new IllegalStateException();
    }

    @Override  // k3.t
    public final Map queryKeyStatus(byte[] arr_b) {
        throw new IllegalStateException();
    }

    @Override  // k3.t
    public final void release() {
    }

    @Override  // k3.t
    public final void restoreKeys(byte[] arr_b, byte[] arr_b1) {
        throw new IllegalStateException();
    }
}

