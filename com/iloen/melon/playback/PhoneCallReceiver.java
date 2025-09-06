package com.iloen.melon.playback;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyCallback.CallStateListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\n\u001A\u00020\t2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u0015\u0010\u000E\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\f¢\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0010\u001A\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0014\u001A\u00020\u00138\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001A\u00020\f8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u000FR\u0016\u0010\u001C\u001A\u00020\u001B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR$\u0010\u001F\u001A\u0004\u0018\u00010\u001E8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010&\u001A\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b&\u0010\'R\u001E\u0010)\u001A\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000E¢\u0006\f\n\u0004\b)\u0010*\u0012\u0004\b+\u0010\u0011¨\u0006-"}, d2 = {"Lcom/iloen/melon/playback/PhoneCallReceiver;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "tagString", "msg", "Lie/H;", "logAudioFocus", "(Ljava/lang/String;Ljava/lang/String;)V", "", "state", "handleCallStateChanged", "(I)V", "release", "()V", "Landroid/content/Context;", "Landroid/telephony/TelephonyManager;", "telephonyManager", "Landroid/telephony/TelephonyManager;", "currentState", "I", "getCurrentState", "()I", "setCurrentState", "", "isIncoming", "Z", "Lcom/iloen/melon/playback/OnCallStateChangedListener;", "onCallStateChangedListener", "Lcom/iloen/melon/playback/OnCallStateChangedListener;", "getOnCallStateChangedListener", "()Lcom/iloen/melon/playback/OnCallStateChangedListener;", "setOnCallStateChangedListener", "(Lcom/iloen/melon/playback/OnCallStateChangedListener;)V", "Landroid/telephony/TelephonyCallback;", "telephonyCallback", "Landroid/telephony/TelephonyCallback;", "Landroid/telephony/PhoneStateListener;", "callStateChangedListener", "Landroid/telephony/PhoneStateListener;", "getCallStateChangedListener$annotations", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PhoneCallReceiver {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/playback/PhoneCallReceiver$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "PhoneCallReceiver";
    @Nullable
    private PhoneStateListener callStateChangedListener;
    @NotNull
    private final Context context;
    private int currentState;
    private boolean isIncoming;
    @Nullable
    private OnCallStateChangedListener onCallStateChangedListener;
    @Nullable
    private TelephonyCallback telephonyCallback;
    @NotNull
    private TelephonyManager telephonyManager;

    static {
        PhoneCallReceiver.Companion = new Companion(null);
        PhoneCallReceiver.$stable = 8;
    }

    public PhoneCallReceiver(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.context = context0;
        Object object0 = context0.getSystemService("phone");
        q.e(object0, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        this.telephonyManager = (TelephonyManager)object0;
        com.iloen.melon.playback.PhoneCallReceiver.1 phoneCallReceiver$10 = new TelephonyCallback.CallStateListener() {
            @Override  // android.telephony.TelephonyCallback$CallStateListener
            public void onCallStateChanged(int v) {
                Y.t("onCallStateChanged() state:", v, LogU.Companion, "PhoneCallReceiver");
                PhoneCallReceiver.this.handleCallStateChanged(v);
            }
        };
        this.telephonyCallback = phoneCallReceiver$10;
        this.telephonyManager.registerTelephonyCallback(context0.getMainExecutor(), phoneCallReceiver$10);

        @Metadata(d1 = {"\u0000\u001D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/iloen/melon/playback/PhoneCallReceiver$3", "Landroid/telephony/PhoneStateListener;", "", "state", "", "phoneNumber", "Lie/H;", "onCallStateChanged", "(ILjava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.playback.PhoneCallReceiver.3 extends PhoneStateListener {
            public com.iloen.melon.playback.PhoneCallReceiver.3(PhoneCallReceiver phoneCallReceiver0) {
            }

            @Override  // android.telephony.PhoneStateListener
            public void onCallStateChanged(int v, String s) {
                PhoneCallReceiver.this.handleCallStateChanged(v);
            }
        }

    }

    private static void getCallStateChangedListener$annotations() {
    }

    public final int getCurrentState() {
        return this.currentState;
    }

    @Nullable
    public final OnCallStateChangedListener getOnCallStateChangedListener() {
        return this.onCallStateChangedListener;
    }

    public final void handleCallStateChanged(int v) {
        int v1 = this.currentState;
        if(v1 == v) {
            this.logAudioFocus("PhoneCallReceiver", "onCallStateChanged() currentState == newState");
            return;
        }
        this.currentState = v;
        switch(v) {
            case 0: {
                this.logAudioFocus("PhoneCallReceiver", "onCallStateChanged() CALL_STATE_IDLE");
                if(this.isIncoming) {
                    switch(v1) {
                        case 1: {
                            OnCallStateChangedListener onCallStateChangedListener0 = this.onCallStateChangedListener;
                            if(onCallStateChangedListener0 != null) {
                                onCallStateChangedListener0.onIncomingCallMissed();
                            }
                            break;
                        }
                        case 2: {
                            OnCallStateChangedListener onCallStateChangedListener1 = this.onCallStateChangedListener;
                            if(onCallStateChangedListener1 != null) {
                                onCallStateChangedListener1.onIncomingCallEnded();
                            }
                        }
                    }
                }
                else {
                    OnCallStateChangedListener onCallStateChangedListener2 = this.onCallStateChangedListener;
                    if(onCallStateChangedListener2 != null) {
                        onCallStateChangedListener2.onOutgoingCallEnded();
                    }
                }
                this.isIncoming = false;
                return;
            }
            case 1: {
                this.logAudioFocus("PhoneCallReceiver", "onCallStateChanged() CALL_STATE_RINGING");
                this.isIncoming = true;
                OnCallStateChangedListener onCallStateChangedListener3 = this.onCallStateChangedListener;
                if(onCallStateChangedListener3 != null) {
                    onCallStateChangedListener3.onIncomingCallRinging();
                    return;
                }
                break;
            }
            case 2: {
                this.logAudioFocus("PhoneCallReceiver", "onCallStateChanged() CALL_STATE_OFFHOOK");
                if(this.isIncoming) {
                    OnCallStateChangedListener onCallStateChangedListener4 = this.onCallStateChangedListener;
                    if(onCallStateChangedListener4 != null) {
                        onCallStateChangedListener4.onIncomingCallStarted();
                        return;
                    }
                }
                else {
                    OnCallStateChangedListener onCallStateChangedListener5 = this.onCallStateChangedListener;
                    if(onCallStateChangedListener5 != null) {
                        onCallStateChangedListener5.onOutgoingCallStarted();
                        return;
                    }
                }
                break;
            }
        }
    }

    private final void logAudioFocus(String s, String s1) {
        LogU.Companion.d(s, s1);
        DevLog.Companion.get("AudioFocus").put(s + " : " + s1);
    }

    public final void release() {
        this.logAudioFocus("PhoneCallReceiver", "release()");
        TelephonyCallback telephonyCallback0 = this.telephonyCallback;
        if(telephonyCallback0 != null) {
            this.telephonyManager.unregisterTelephonyCallback(telephonyCallback0);
        }
    }

    public final void setCurrentState(int v) {
        this.currentState = v;
    }

    public final void setOnCallStateChangedListener(@Nullable OnCallStateChangedListener onCallStateChangedListener0) {
        this.onCallStateChangedListener = onCallStateChangedListener0;
    }
}

