package androidx.window.layout.adapter.sidecar;

import android.os.IBinder;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface.SidecarCallback;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.Map;
import java.util.WeakHashMap;

public class DistinctElementSidecarCallback implements SidecarInterface.SidecarCallback {
    private final Map mActivityWindowLayoutInfo;
    private final SidecarAdapter mAdapter;
    private final SidecarInterface.SidecarCallback mCallback;
    private SidecarDeviceState mLastDeviceState;
    private final Object mLock;

    public DistinctElementSidecarCallback(SidecarAdapter sidecarAdapter0, SidecarInterface.SidecarCallback sidecarInterface$SidecarCallback0) {
        this.mLock = new Object();
        this.mActivityWindowLayoutInfo = new WeakHashMap();
        this.mAdapter = sidecarAdapter0;
        this.mCallback = sidecarInterface$SidecarCallback0;
    }

    public DistinctElementSidecarCallback(SidecarInterface.SidecarCallback sidecarInterface$SidecarCallback0) {
        this.mLock = new Object();
        this.mActivityWindowLayoutInfo = new WeakHashMap();
        this.mAdapter = new SidecarAdapter();
        this.mCallback = sidecarInterface$SidecarCallback0;
    }

    public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState0) {
        if(sidecarDeviceState0 == null) {
            return;
        }
        synchronized(this.mLock) {
            if(this.mAdapter.isEqualSidecarDeviceState(this.mLastDeviceState, sidecarDeviceState0)) {
                return;
            }
            this.mLastDeviceState = sidecarDeviceState0;
            this.mCallback.onDeviceStateChanged(sidecarDeviceState0);
        }
    }

    public void onWindowLayoutChanged(IBinder iBinder0, SidecarWindowLayoutInfo sidecarWindowLayoutInfo0) {
        synchronized(this.mLock) {
            SidecarWindowLayoutInfo sidecarWindowLayoutInfo1 = (SidecarWindowLayoutInfo)this.mActivityWindowLayoutInfo.get(iBinder0);
            if(this.mAdapter.isEqualSidecarWindowLayoutInfo(sidecarWindowLayoutInfo1, sidecarWindowLayoutInfo0)) {
                return;
            }
            this.mActivityWindowLayoutInfo.put(iBinder0, sidecarWindowLayoutInfo0);
            this.mCallback.onWindowLayoutChanged(iBinder0, sidecarWindowLayoutInfo0);
        }
    }
}

