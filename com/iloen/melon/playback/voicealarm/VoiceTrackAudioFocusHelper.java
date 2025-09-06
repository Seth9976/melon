package com.iloen.melon.playback.voicealarm;

import Cb.i;
import android.content.Context;
import android.media.AudioAttributes.Builder;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest.Builder;
import android.media.AudioFocusRequest;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.AudioManager;
import com.iloen.melon.fragments.mymusic.dna.d;
import com.iloen.melon.playback.OnCallStateChangedListener;
import com.iloen.melon.playback.PhoneCallReceiver;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import ie.j;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import l9.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0002¢\u0006\u0004\b\u000B\u0010\nJ\u000F\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000F\u0010\u000EJ\r\u0010\u0010\u001A\u00020\b¢\u0006\u0004\b\u0010\u0010\nJ\r\u0010\u0011\u001A\u00020\b¢\u0006\u0004\b\u0011\u0010\nJ\r\u0010\u0013\u001A\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001A\u00020\b¢\u0006\u0004\b\u0015\u0010\nJ\u0017\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001A\u00020\b¢\u0006\u0004\b\u0019\u0010\nJ\r\u0010\u001A\u001A\u00020\b¢\u0006\u0004\b\u001A\u0010\nJ\r\u0010\u001B\u001A\u00020\b¢\u0006\u0004\b\u001B\u0010\nJ\r\u0010\u001C\u001A\u00020\f¢\u0006\u0004\b\u001C\u0010\u000ER\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001DR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001ER\u001B\u0010$\u001A\u00020\u001F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#R\u001B\u0010)\u001A\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001A\u0004\b\'\u0010(R\u001B\u0010.\u001A\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010!\u001A\u0004\b,\u0010-R\u0018\u00100\u001A\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/iloen/melon/playback/voicealarm/VoiceTrackAudioFocusHelper;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "Landroid/content/Context;", "context", "Lcom/iloen/melon/playback/voicealarm/VoiceAlarmPlay;", "voiceAlarmPlay", "<init>", "(Landroid/content/Context;Lcom/iloen/melon/playback/voicealarm/VoiceAlarmPlay;)V", "Lie/H;", "audioFocusLoss", "()V", "audioFocusLossTransientCanDuck", "", "isCallStateIdle", "()Z", "isCallStateUnknown", "init", "destroy", "", "requestFocus", "()I", "abandonFocus", "focusChange", "onAudioFocusChange", "(I)V", "handleReadPhoneStatePermission", "initPhoneCallReceiver", "releasePhoneCallReceiver", "isCallState", "Landroid/content/Context;", "Lcom/iloen/melon/playback/voicealarm/VoiceAlarmPlay;", "Landroid/media/AudioManager;", "audioManager$delegate", "Lie/j;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager", "Landroid/media/AudioAttributes;", "audioAttributes$delegate", "getAudioAttributes", "()Landroid/media/AudioAttributes;", "audioAttributes", "Landroid/media/AudioFocusRequest;", "audioFocusRequest$delegate", "getAudioFocusRequest", "()Landroid/media/AudioFocusRequest;", "audioFocusRequest", "Lcom/iloen/melon/playback/PhoneCallReceiver;", "phoneCallReceiver", "Lcom/iloen/melon/playback/PhoneCallReceiver;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VoiceTrackAudioFocusHelper implements AudioManager.OnAudioFocusChangeListener {
    public static final int $stable = 8;
    @NotNull
    private final j audioAttributes$delegate;
    @NotNull
    private final j audioFocusRequest$delegate;
    @NotNull
    private final j audioManager$delegate;
    @NotNull
    private final Context context;
    @Nullable
    private PhoneCallReceiver phoneCallReceiver;
    @NotNull
    private final VoiceAlarmPlay voiceAlarmPlay;

    public VoiceTrackAudioFocusHelper(@NotNull Context context0, @NotNull VoiceAlarmPlay voiceAlarmPlay0) {
        q.g(context0, "context");
        q.g(voiceAlarmPlay0, "voiceAlarmPlay");
        super();
        this.context = context0;
        this.voiceAlarmPlay = voiceAlarmPlay0;
        this.audioManager$delegate = g.Q(new b(this, 0));
        this.audioAttributes$delegate = g.Q(new d(14));
        this.audioFocusRequest$delegate = g.Q(new b(this, 1));
    }

    public static AudioAttributes a() {
        return VoiceTrackAudioFocusHelper.audioAttributes_delegate$lambda$1();
    }

    public final void abandonFocus() {
        this.getAudioManager().abandonAudioFocusRequest(this.getAudioFocusRequest());
    }

    private static final AudioAttributes audioAttributes_delegate$lambda$1() {
        return new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
    }

    private final void audioFocusLoss() {
        this.voiceAlarmPlay.audioFocusLoss();
    }

    private final void audioFocusLossTransientCanDuck() {
    }

    private static final AudioFocusRequest audioFocusRequest_delegate$lambda$2(VoiceTrackAudioFocusHelper voiceTrackAudioFocusHelper0) {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(voiceTrackAudioFocusHelper0.getAudioAttributes()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(voiceTrackAudioFocusHelper0).build();
    }

    private static final AudioManager audioManager_delegate$lambda$0(VoiceTrackAudioFocusHelper voiceTrackAudioFocusHelper0) {
        Object object0 = voiceTrackAudioFocusHelper0.context.getSystemService("audio");
        q.e(object0, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager)object0;
    }

    public final void destroy() {
        this.releasePhoneCallReceiver();
        this.abandonFocus();
    }

    private final AudioAttributes getAudioAttributes() {
        Object object0 = this.audioAttributes$delegate.getValue();
        q.f(object0, "getValue(...)");
        return (AudioAttributes)object0;
    }

    private final AudioFocusRequest getAudioFocusRequest() {
        Object object0 = this.audioFocusRequest$delegate.getValue();
        q.f(object0, "getValue(...)");
        return (AudioFocusRequest)object0;
    }

    private final AudioManager getAudioManager() {
        return (AudioManager)this.audioManager$delegate.getValue();
    }

    public final void handleReadPhoneStatePermission() {
        if(Td.b.f(this.context, a.c)) {
            this.initPhoneCallReceiver();
            return;
        }
        this.releasePhoneCallReceiver();
    }

    public final void init() {
        this.handleReadPhoneStatePermission();
    }

    public final void initPhoneCallReceiver() {
        if(this.phoneCallReceiver == null) {
            PhoneCallReceiver phoneCallReceiver0 = new PhoneCallReceiver(this.context);
            phoneCallReceiver0.setOnCallStateChangedListener(new OnCallStateChangedListener() {
                @Override  // com.iloen.melon.playback.OnCallStateChangedListener
                public void onIncomingCallEnded() {
                }

                @Override  // com.iloen.melon.playback.OnCallStateChangedListener
                public void onIncomingCallMissed() {
                }

                @Override  // com.iloen.melon.playback.OnCallStateChangedListener
                public void onIncomingCallRinging() {
                    VoiceTrackAudioFocusHelper.this.audioFocusLoss();
                }

                @Override  // com.iloen.melon.playback.OnCallStateChangedListener
                public void onIncomingCallStarted() {
                    VoiceTrackAudioFocusHelper.this.audioFocusLoss();
                }

                @Override  // com.iloen.melon.playback.OnCallStateChangedListener
                public void onOutgoingCallEnded() {
                }

                @Override  // com.iloen.melon.playback.OnCallStateChangedListener
                public void onOutgoingCallStarted() {
                    VoiceTrackAudioFocusHelper.this.audioFocusLoss();
                }
            });
            this.phoneCallReceiver = phoneCallReceiver0;
        }
    }

    public final boolean isCallState() {
        boolean z = this.isCallStateUnknown();
        boolean z1 = this.isCallStateIdle();
        boolean z2 = !z && !z1;
        String s = i.o(this);
        StringBuilder stringBuilder0 = Y.q("isCallState() isCallState:", ", isCallStateUnknown:", z2, ", isCallStateIdle:", z);
        stringBuilder0.append(z1);
        LogU.Companion.d(s, stringBuilder0.toString());
        return z2;
    }

    private final boolean isCallStateIdle() {
        Integer integer0 = this.phoneCallReceiver == null ? null : this.phoneCallReceiver.getCurrentState();
        if(integer0 != null && ((int)integer0) == 0) {
            return true;
        }
        return integer0 == null || ((int)integer0) != 1 ? integer0 == null || ((int)integer0) != 2 : true;
    }

    private final boolean isCallStateUnknown() {
        return this.phoneCallReceiver == null;
    }

    @Override  // android.media.AudioManager$OnAudioFocusChangeListener
    public void onAudioFocusChange(int v) {
        switch(v) {
            case -3: {
                return;
            }
            case -2: 
            case -1: {
                this.audioFocusLoss();
            }
        }
    }

    public final void releasePhoneCallReceiver() {
        PhoneCallReceiver phoneCallReceiver0 = this.phoneCallReceiver;
        if(phoneCallReceiver0 != null) {
            phoneCallReceiver0.release();
        }
        this.phoneCallReceiver = null;
    }

    public final int requestFocus() {
        return this.getAudioManager().requestAudioFocus(this.getAudioFocusRequest());
    }
}

