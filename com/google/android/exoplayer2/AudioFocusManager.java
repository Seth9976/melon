package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest.Builder;
import android.media.AudioFocusRequest;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.AudioManager;
import android.os.Handler;
import b3.Z;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

final class AudioFocusManager {
    class AudioFocusListener implements AudioManager.OnAudioFocusChangeListener {
        private final Handler eventHandler;

        public AudioFocusListener(Handler handler0) {
            this.eventHandler = handler0;
        }

        private void lambda$onAudioFocusChange$0(int v) {
            AudioFocusManager.this.handlePlatformAudioFocusChange(v);
        }

        @Override  // android.media.AudioManager$OnAudioFocusChangeListener
        public void onAudioFocusChange(int v) {
            a a0 = new a(this, v);
            this.eventHandler.post(a0);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerCommand {
    }

    public interface PlayerControl {
        void executePlayerCommand(int arg1);

        void setVolumeMultiplier(float arg1);
    }

    private static final int AUDIO_FOCUS_STATE_HAVE_FOCUS = 1;
    private static final int AUDIO_FOCUS_STATE_LOSS_TRANSIENT = 2;
    private static final int AUDIO_FOCUS_STATE_LOSS_TRANSIENT_DUCK = 3;
    private static final int AUDIO_FOCUS_STATE_NO_FOCUS = 0;
    public static final int PLAYER_COMMAND_DO_NOT_PLAY = -1;
    public static final int PLAYER_COMMAND_PLAY_WHEN_READY = 1;
    public static final int PLAYER_COMMAND_WAIT_FOR_CALLBACK = 0;
    private static final String TAG = "AudioFocusManager";
    private static final float VOLUME_MULTIPLIER_DEFAULT = 1.0f;
    private static final float VOLUME_MULTIPLIER_DUCK = 0.2f;
    private AudioAttributes audioAttributes;
    private AudioFocusRequest audioFocusRequest;
    private int audioFocusState;
    private final AudioManager audioManager;
    private int focusGain;
    private final AudioFocusListener focusListener;
    private PlayerControl playerControl;
    private boolean rebuildAudioFocusRequest;
    private float volumeMultiplier;

    public AudioFocusManager(Context context0, Handler handler0, PlayerControl audioFocusManager$PlayerControl0) {
        this.volumeMultiplier = 1.0f;
        this.audioManager = (AudioManager)context0.getApplicationContext().getSystemService("audio");
        this.playerControl = audioFocusManager$PlayerControl0;
        this.focusListener = new AudioFocusListener(this, handler0);
        this.audioFocusState = 0;
    }

    private void abandonAudioFocus() {
        if(this.audioFocusState == 0) {
            return;
        }
        if(Util.SDK_INT >= 26) {
            this.abandonAudioFocusV26();
        }
        else {
            this.abandonAudioFocusDefault();
        }
        this.setAudioFocusState(0);
    }

    private void abandonAudioFocusDefault() {
        this.audioManager.abandonAudioFocus(this.focusListener);
    }

    private void abandonAudioFocusV26() {
        AudioFocusRequest audioFocusRequest0 = this.audioFocusRequest;
        if(audioFocusRequest0 != null) {
            this.audioManager.abandonAudioFocusRequest(audioFocusRequest0);
        }
    }

    private static int convertAudioAttributesToFocusGain(AudioAttributes audioAttributes0) {
        if(audioAttributes0 == null) {
            return 0;
        }
        int v = audioAttributes0.usage;
        switch(v) {
            case 0: {
                Log.w("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            }
            case 3: {
                return 0;
            }
            case 2: 
            case 4: {
                return 2;
            }
            case 11: {
                return audioAttributes0.contentType == 1 ? 2 : 3;
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 12: 
            case 13: {
                return 3;
            }
            case 1: 
            case 14: {
                return 1;
            }
            case 16: {
                return Util.SDK_INT < 19 ? 2 : 4;
            }
            default: {
                Z.q(37, v, "Unidentified audio usage: ", "AudioFocusManager");
                return 0;
            }
        }
    }

    private void executePlayerCommand(int v) {
        PlayerControl audioFocusManager$PlayerControl0 = this.playerControl;
        if(audioFocusManager$PlayerControl0 != null) {
            audioFocusManager$PlayerControl0.executePlayerCommand(v);
        }
    }

    public AudioManager.OnAudioFocusChangeListener getFocusListener() {
        return this.focusListener;
    }

    public float getVolumeMultiplier() {
        return this.volumeMultiplier;
    }

    private void handlePlatformAudioFocusChange(int v) {
        if(v != -3 && v != -2) {
            switch(v) {
                case -1: {
                    this.executePlayerCommand(-1);
                    this.abandonAudioFocus();
                    return;
                }
                case 1: {
                    this.setAudioFocusState(1);
                    this.executePlayerCommand(1);
                    return;
                }
                default: {
                    Z.q(38, v, "Unknown focus change type: ", "AudioFocusManager");
                    return;
                }
            }
        }
        if(v != -2 && !this.willPauseWhenDucked()) {
            this.setAudioFocusState(3);
            return;
        }
        this.executePlayerCommand(0);
        this.setAudioFocusState(2);
    }

    public void release() {
        this.playerControl = null;
        this.abandonAudioFocus();
    }

    private int requestAudioFocus() {
        if(this.audioFocusState == 1) {
            return 1;
        }
        if((Util.SDK_INT < 26 ? this.requestAudioFocusDefault() : this.requestAudioFocusV26()) == 1) {
            this.setAudioFocusState(1);
            return 1;
        }
        this.setAudioFocusState(0);
        return -1;
    }

    private int requestAudioFocusDefault() {
        int v = Util.getStreamTypeForAudioUsage(((AudioAttributes)Assertions.checkNotNull(this.audioAttributes)).usage);
        return this.audioManager.requestAudioFocus(this.focusListener, v, this.focusGain);
    }

    private int requestAudioFocusV26() {
        AudioFocusRequest audioFocusRequest0 = this.audioFocusRequest;
        if(audioFocusRequest0 == null || this.rebuildAudioFocusRequest) {
            AudioFocusRequest.Builder audioFocusRequest$Builder0 = audioFocusRequest0 == null ? new AudioFocusRequest.Builder(this.focusGain) : new AudioFocusRequest.Builder(this.audioFocusRequest);
            boolean z = this.willPauseWhenDucked();
            this.audioFocusRequest = audioFocusRequest$Builder0.setAudioAttributes(((AudioAttributes)Assertions.checkNotNull(this.audioAttributes)).getAudioAttributesV21()).setWillPauseWhenDucked(z).setOnAudioFocusChangeListener(this.focusListener).build();
            this.rebuildAudioFocusRequest = false;
        }
        return this.audioManager.requestAudioFocus(this.audioFocusRequest);
    }

    public void setAudioAttributes(AudioAttributes audioAttributes0) {
        if(!Util.areEqual(this.audioAttributes, audioAttributes0)) {
            this.audioAttributes = audioAttributes0;
            int v = AudioFocusManager.convertAudioAttributesToFocusGain(audioAttributes0);
            this.focusGain = v;
            Assertions.checkArgument(v == 0 || v == 1, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
        }
    }

    private void setAudioFocusState(int v) {
        if(this.audioFocusState != v) {
            this.audioFocusState = v;
            float f = v == 3 ? 0.2f : 1.0f;
            if(this.volumeMultiplier != f) {
                this.volumeMultiplier = f;
                PlayerControl audioFocusManager$PlayerControl0 = this.playerControl;
                if(audioFocusManager$PlayerControl0 != null) {
                    audioFocusManager$PlayerControl0.setVolumeMultiplier(f);
                }
            }
        }
    }

    private boolean shouldAbandonAudioFocus(int v) {
        return v == 1 || this.focusGain != 1;
    }

    public int updateAudioFocus(boolean z, int v) {
        if(this.shouldAbandonAudioFocus(v)) {
            this.abandonAudioFocus();
            return z ? 1 : -1;
        }
        return z ? this.requestAudioFocus() : -1;
    }

    private boolean willPauseWhenDucked() {
        return this.audioAttributes != null && this.audioAttributes.contentType == 1;
    }
}

