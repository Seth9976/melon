package com.bumptech.glide.load.engine;

import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ResourceRecycler {
    static final class ResourceRecyclerCallback implements Handler.Callback {
        static final int RECYCLE_RESOURCE = 1;

        @Override  // android.os.Handler$Callback
        public boolean handleMessage(Message message0) {
            if(message0.what == 1) {
                ((Resource)message0.obj).recycle();
                return true;
            }
            return false;
        }
    }

    private final Handler handler;
    private boolean isRecycling;

    public ResourceRecycler() {
        this.handler = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    }

    public void recycle(Resource resource0, boolean z) {
        synchronized(this) {
            if(this.isRecycling || z) {
                this.handler.obtainMessage(1, resource0).sendToTarget();
            }
            else {
                this.isRecycling = true;
                resource0.recycle();
                this.isRecycling = false;
            }
        }
    }
}

