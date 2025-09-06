package com.kakaoent.trevi.ad.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001A\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001A\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0013\u0010\u0007\u001A\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0013\u0010\b\u001A\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0005J#\u0010\r\u001A\u00020\u0003*\u00020\u00022\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\r\u0010\u000EJ!\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/kakaoent/trevi/ad/util/AudioBecomingNoisyReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Intent;", "", "isEarphoneDeviceGetOffed", "(Landroid/content/Intent;)Z", "isBlueToothEarphoneGetOffed", "isBluetoothPreviousConnected", "isBluetoothDisconnected", "", "key", "", "state", "checkState", "(Landroid/content/Intent;Ljava/lang/String;I)Z", "Landroid/content/Context;", "context", "intent", "Lie/H;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class AudioBecomingNoisyReceiver extends BroadcastReceiver {
    private final boolean checkState(Intent intent0, String s, int v) {
        return intent0.getIntExtra(s, -1) == v;
    }

    // 去混淆评级： 低(20)
    private final boolean isBlueToothEarphoneGetOffed(Intent intent0) {
        return this.isBluetoothPreviousConnected(intent0) && this.isBluetoothDisconnected(intent0);
    }

    private final boolean isBluetoothDisconnected(Intent intent0) {
        return this.checkState(intent0, "android.media.extra.SCO_AUDIO_STATE", 0);
    }

    private final boolean isBluetoothPreviousConnected(Intent intent0) {
        return this.checkState(intent0, "android.media.extra.SCO_AUDIO_PREVIOUS_STATE", 1);
    }

    private final boolean isEarphoneDeviceGetOffed(Intent intent0) {
        return "android.media.AUDIO_BECOMING_NOISY".equals(intent0.getAction());
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context0, @Nullable Intent intent0) {
        q.g(context0, "context");
        if(intent0 != null && (this.isEarphoneDeviceGetOffed(intent0) || this.isBlueToothEarphoneGetOffed(intent0))) {
            throw null;
        }
    }
}

