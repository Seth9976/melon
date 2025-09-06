package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

@TargetApi(17)
public final class DummySurface extends Surface {
    static class DummySurfaceThread extends HandlerThread implements Handler.Callback {
        private static final int MSG_INIT = 1;
        private static final int MSG_RELEASE = 2;
        private EGLSurfaceTexture eglSurfaceTexture;
        private Handler handler;
        private Error initError;
        private RuntimeException initException;
        private DummySurface surface;

        public DummySurfaceThread() {
            super("dummySurface");
        }

        @Override  // android.os.Handler$Callback
        public boolean handleMessage(Message message0) {
            switch(message0.what) {
                case 1: {
                    try {
                        try {
                            this.initInternal(message0.arg1);
                            goto label_34;
                        }
                        catch(RuntimeException runtimeException0) {
                        }
                        catch(Error error0) {
                            goto label_15;
                        }
                        Log.e("DummySurface", "Failed to initialize dummy surface", runtimeException0);
                        this.initException = runtimeException0;
                    }
                    catch(Throwable throwable0) {
                        goto label_26;
                    }
                    synchronized(this) {
                        this.notify();
                    }
                    return true;
                    try {
                    label_15:
                        Log.e("DummySurface", "Failed to initialize dummy surface", error0);
                        this.initError = error0;
                    }
                    catch(Throwable throwable0) {
                        goto label_26;
                    }
                    synchronized(this) {
                        this.notify();
                    }
                    return true;
                label_26:
                    synchronized(this) {
                        this.notify();
                    }
                    throw throwable0;
                label_34:
                    synchronized(this) {
                        this.notify();
                    }
                    return true;
                }
                case 2: {
                    try {
                        this.releaseInternal();
                    }
                    catch(Throwable throwable5) {
                        Log.e("DummySurface", "Failed to release dummy surface", throwable5);
                    }
                    finally {
                        this.quit();
                    }
                    return true;
                }
                default: {
                    return true;
                }
            }
        }

        public DummySurface init(int v) {
            this.start();
            Handler handler0 = new Handler(this.getLooper(), this);
            this.handler = handler0;
            this.eglSurfaceTexture = new EGLSurfaceTexture(handler0);
            synchronized(this) {
                boolean z = false;
                this.handler.obtainMessage(1, v, 0).sendToTarget();
                while(this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        this.wait();
                    }
                    catch(InterruptedException unused_ex) {
                        z = true;
                    }
                }
            }
            if(z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException0 = this.initException;
            if(runtimeException0 != null) {
                throw runtimeException0;
            }
            Error error0 = this.initError;
            if(error0 != null) {
                throw error0;
            }
            return (DummySurface)Assertions.checkNotNull(this.surface);
        }

        private void initInternal(int v) {
            Assertions.checkNotNull(this.eglSurfaceTexture);
            this.eglSurfaceTexture.init(v);
            this.surface = new DummySurface(this, this.eglSurfaceTexture.getSurfaceTexture(), v != 0, null);
        }

        public void release() {
            Assertions.checkNotNull(this.handler);
            this.handler.sendEmptyMessage(2);
        }

        private void releaseInternal() {
            Assertions.checkNotNull(this.eglSurfaceTexture);
            this.eglSurfaceTexture.release();
        }
    }

    private static final String TAG = "DummySurface";
    public final boolean secure;
    private static int secureMode;
    private static boolean secureModeInitialized;
    private final DummySurfaceThread thread;
    private boolean threadReleased;

    private DummySurface(DummySurfaceThread dummySurface$DummySurfaceThread0, SurfaceTexture surfaceTexture0, boolean z) {
        super(surfaceTexture0);
        this.thread = dummySurface$DummySurfaceThread0;
        this.secure = z;
    }

    public DummySurface(DummySurfaceThread dummySurface$DummySurfaceThread0, SurfaceTexture surfaceTexture0, boolean z, com.google.android.exoplayer2.video.DummySurface.1 dummySurface$10) {
        this(dummySurface$DummySurfaceThread0, surfaceTexture0, z);
    }

    private static void assertApiLevel17OrHigher() {
        if(Util.SDK_INT < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    private static int getSecureMode(Context context0) {
        if(GlUtil.isProtectedContentExtensionSupported(context0)) {
            return GlUtil.isSurfacelessContextExtensionSupported() ? 1 : 2;
        }
        return 0;
    }

    public static boolean isSecureSupported(Context context0) {
        boolean z = true;
        synchronized(DummySurface.class) {
            if(!DummySurface.secureModeInitialized) {
                DummySurface.secureMode = DummySurface.getSecureMode(context0);
                DummySurface.secureModeInitialized = true;
            }
            if(DummySurface.secureMode == 0) {
                z = false;
            }
            return z;
        }
    }

    public static DummySurface newInstanceV17(Context context0, boolean z) {
        DummySurface.assertApiLevel17OrHigher();
        int v = 0;
        Assertions.checkState(!z || DummySurface.isSecureSupported(context0));
        DummySurfaceThread dummySurface$DummySurfaceThread0 = new DummySurfaceThread();
        if(z) {
            v = DummySurface.secureMode;
        }
        return dummySurface$DummySurfaceThread0.init(v);
    }

    @Override  // android.view.Surface
    public void release() {
        super.release();
        synchronized(this.thread) {
            if(!this.threadReleased) {
                this.thread.release();
                this.threadReleased = true;
            }
        }
    }

    class com.google.android.exoplayer2.video.DummySurface.1 {
    }

}

