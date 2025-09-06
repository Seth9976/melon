package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

final class AudioBecomingNoisyManager {
    final class AudioBecomingNoisyReceiver extends BroadcastReceiver implements Runnable {
        private final Handler eventHandler;
        private final EventListener listener;

        public AudioBecomingNoisyReceiver(Handler handler0, EventListener audioBecomingNoisyManager$EventListener0) {
            this.eventHandler = handler0;
            this.listener = audioBecomingNoisyManager$EventListener0;
        }

        @Override  // android.content.BroadcastReceiver
        public void onReceive(Context context0, Intent intent0) {
            if("android.media.AUDIO_BECOMING_NOISY".equals(intent0.getAction())) {
                this.eventHandler.post(this);
            }
        }

        @Override
        public void run() {
            if(AudioBecomingNoisyManager.this.receiverRegistered) {
                this.listener.onAudioBecomingNoisy();
            }
        }
    }

    public interface EventListener {
        void onAudioBecomingNoisy();
    }

    private final Context context;
    private final AudioBecomingNoisyReceiver receiver;
    private boolean receiverRegistered;

    public AudioBecomingNoisyManager(Context context0, Handler handler0, EventListener audioBecomingNoisyManager$EventListener0) {
        this.context = context0.getApplicationContext();
        this.receiver = new AudioBecomingNoisyReceiver(this, handler0, audioBecomingNoisyManager$EventListener0);
    }

    public void setEnabled(boolean z) {
        if(z && !this.receiverRegistered) {
            IntentFilter intentFilter0 = new IntentFilter("android.media.AUDIO_BECOMING_NOISY");
            this.context.registerReceiver(this.receiver, intentFilter0);
            this.receiverRegistered = true;
            return;
        }
        if(!z && this.receiverRegistered) {
            this.context.unregisterReceiver(this.receiver);
            this.receiverRegistered = false;
        }
    }
}

