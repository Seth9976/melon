package com.google.android.exoplayer2.audio;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class AudioCapabilitiesReceiver {
    final class ExternalSurroundSoundSettingObserver extends ContentObserver {
        private final ContentResolver resolver;
        private final Uri settingUri;

        public ExternalSurroundSoundSettingObserver(Handler handler0, ContentResolver contentResolver0, Uri uri0) {
            super(handler0);
            this.resolver = contentResolver0;
            this.settingUri = uri0;
        }

        @Override  // android.database.ContentObserver
        public void onChange(boolean z) {
            AudioCapabilities audioCapabilities0 = AudioCapabilities.getCapabilities(AudioCapabilitiesReceiver.this.context);
            AudioCapabilitiesReceiver.this.onNewAudioCapabilities(audioCapabilities0);
        }

        public void register() {
            this.resolver.registerContentObserver(this.settingUri, false, this);
        }

        public void unregister() {
            this.resolver.unregisterContentObserver(this);
        }
    }

    final class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver {
        private HdmiAudioPlugBroadcastReceiver() {
        }

        public HdmiAudioPlugBroadcastReceiver(com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.1 audioCapabilitiesReceiver$10) {
        }

        @Override  // android.content.BroadcastReceiver
        public void onReceive(Context context0, Intent intent0) {
            if(!this.isInitialStickyBroadcast()) {
                AudioCapabilities audioCapabilities0 = AudioCapabilities.getCapabilities(context0, intent0);
                AudioCapabilitiesReceiver.this.onNewAudioCapabilities(audioCapabilities0);
            }
        }
    }

    public interface Listener {
        void onAudioCapabilitiesChanged(AudioCapabilities arg1);
    }

    AudioCapabilities audioCapabilities;
    private final Context context;
    private final ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver;
    private final Handler handler;
    private final Listener listener;
    private final BroadcastReceiver receiver;
    private boolean registered;

    public AudioCapabilitiesReceiver(Context context0, Listener audioCapabilitiesReceiver$Listener0) {
        Context context1 = context0.getApplicationContext();
        this.context = context1;
        this.listener = (Listener)Assertions.checkNotNull(audioCapabilitiesReceiver$Listener0);
        Handler handler0 = new Handler(Util.getLooper());
        this.handler = handler0;
        ExternalSurroundSoundSettingObserver audioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver0 = null;
        this.receiver = Util.SDK_INT < 21 ? null : new HdmiAudioPlugBroadcastReceiver(this, null);
        Uri uri0 = AudioCapabilities.getExternalSurroundSoundGlobalSettingUri();
        if(uri0 != null) {
            audioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver0 = new ExternalSurroundSoundSettingObserver(this, handler0, context1.getContentResolver(), uri0);
        }
        this.externalSurroundSoundSettingObserver = audioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver0;
    }

    private void onNewAudioCapabilities(AudioCapabilities audioCapabilities0) {
        if(this.registered && !audioCapabilities0.equals(this.audioCapabilities)) {
            this.audioCapabilities = audioCapabilities0;
            this.listener.onAudioCapabilitiesChanged(audioCapabilities0);
        }
    }

    public AudioCapabilities register() {
        if(this.registered) {
            return (AudioCapabilities)Assertions.checkNotNull(this.audioCapabilities);
        }
        this.registered = true;
        ExternalSurroundSoundSettingObserver audioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver0 = this.externalSurroundSoundSettingObserver;
        if(audioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver0 != null) {
            audioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver0.register();
        }
        Intent intent0 = null;
        if(this.receiver != null) {
            IntentFilter intentFilter0 = new IntentFilter("android.media.action.HDMI_AUDIO_PLUG");
            intent0 = this.context.registerReceiver(this.receiver, intentFilter0, null, this.handler);
        }
        AudioCapabilities audioCapabilities0 = AudioCapabilities.getCapabilities(this.context, intent0);
        this.audioCapabilities = audioCapabilities0;
        return audioCapabilities0;
    }

    public void unregister() {
        if(!this.registered) {
            return;
        }
        this.audioCapabilities = null;
        BroadcastReceiver broadcastReceiver0 = this.receiver;
        if(broadcastReceiver0 != null) {
            this.context.unregisterReceiver(broadcastReceiver0);
        }
        ExternalSurroundSoundSettingObserver audioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver0 = this.externalSurroundSoundSettingObserver;
        if(audioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver0 != null) {
            audioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver0.unregister();
        }
        this.registered = false;
    }

    class com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.1 {
    }

}

