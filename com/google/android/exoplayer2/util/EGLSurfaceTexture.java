package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@TargetApi(17)
public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    public static final class GlException extends RuntimeException {
        private GlException(String s) {
            super(s);
        }

        public GlException(String s, com.google.android.exoplayer2.util.EGLSurfaceTexture.1 eGLSurfaceTexture$10) {
            this(s);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SecureMode {
    }

    public interface TextureImageListener {
        void onFrameAvailable();
    }

    private static final int[] EGL_CONFIG_ATTRIBUTES = null;
    private static final int EGL_PROTECTED_CONTENT_EXT = 0x32C0;
    private static final int EGL_SURFACE_HEIGHT = 1;
    private static final int EGL_SURFACE_WIDTH = 1;
    public static final int SECURE_MODE_NONE = 0;
    public static final int SECURE_MODE_PROTECTED_PBUFFER = 2;
    public static final int SECURE_MODE_SURFACELESS_CONTEXT = 1;
    private final TextureImageListener callback;
    private EGLContext context;
    private EGLDisplay display;
    private final Handler handler;
    private EGLSurface surface;
    private SurfaceTexture texture;
    private final int[] textureIdHolder;

    static {
        EGLSurfaceTexture.EGL_CONFIG_ATTRIBUTES = new int[]{0x3040, 4, 0x3024, 8, 0x3023, 8, 0x3022, 8, 0x3021, 8, 0x3025, 0, 0x3027, 0x3038, 0x3033, 4, 0x3038};
    }

    public EGLSurfaceTexture(Handler handler0) {
        this(handler0, null);
    }

    public EGLSurfaceTexture(Handler handler0, TextureImageListener eGLSurfaceTexture$TextureImageListener0) {
        this.handler = handler0;
        this.callback = eGLSurfaceTexture$TextureImageListener0;
        this.textureIdHolder = new int[1];
    }

    private static EGLConfig chooseEGLConfig(EGLDisplay eGLDisplay0) {
        EGLConfig[] arr_eGLConfig = new EGLConfig[1];
        int[] arr_v = new int[1];
        boolean z = EGL14.eglChooseConfig(eGLDisplay0, EGLSurfaceTexture.EGL_CONFIG_ATTRIBUTES, 0, arr_eGLConfig, 0, 1, arr_v, 0);
        if(z && arr_v[0] > 0) {
            EGLConfig eGLConfig0 = arr_eGLConfig[0];
            if(eGLConfig0 != null) {
                return eGLConfig0;
            }
        }
        throw new GlException(Util.formatInvariant("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", new Object[]{Boolean.valueOf(z), ((int)arr_v[0]), arr_eGLConfig[0]}), null);
    }

    private static EGLContext createEGLContext(EGLDisplay eGLDisplay0, EGLConfig eGLConfig0, int v) {
        EGLContext eGLContext0 = EGL14.eglCreateContext(eGLDisplay0, eGLConfig0, EGL14.EGL_NO_CONTEXT, (v == 0 ? new int[]{0x3098, 2, 0x3038} : new int[]{0x3098, 2, 0x32C0, 1, 0x3038}), 0);
        if(eGLContext0 == null) {
            throw new GlException("eglCreateContext failed", null);
        }
        return eGLContext0;
    }

    private static EGLSurface createEGLSurface(EGLDisplay eGLDisplay0, EGLConfig eGLConfig0, EGLContext eGLContext0, int v) {
        int[] arr_v;
        EGLSurface eGLSurface0;
        switch(v) {
            case 1: {
                eGLSurface0 = EGL14.EGL_NO_SURFACE;
                goto label_8;
            }
            case 2: {
                arr_v = new int[]{0x3057, 1, 0x3056, 1, 0x32C0, 1, 0x3038};
                break;
            }
            default: {
                arr_v = new int[]{0x3057, 1, 0x3056, 1, 0x3038};
            }
        }
        eGLSurface0 = EGL14.eglCreatePbufferSurface(eGLDisplay0, eGLConfig0, arr_v, 0);
        if(eGLSurface0 == null) {
            throw new GlException("eglCreatePbufferSurface failed", null);
        }
    label_8:
        if(!EGL14.eglMakeCurrent(eGLDisplay0, eGLSurface0, eGLSurface0, eGLContext0)) {
            throw new GlException("eglMakeCurrent failed", null);
        }
        return eGLSurface0;
    }

    private void dispatchOnFrameAvailable() {
        TextureImageListener eGLSurfaceTexture$TextureImageListener0 = this.callback;
        if(eGLSurfaceTexture$TextureImageListener0 != null) {
            eGLSurfaceTexture$TextureImageListener0.onFrameAvailable();
        }
    }

    private static void generateTextureIds(int[] arr_v) {
        GLES20.glGenTextures(1, arr_v, 0);
        GlUtil.checkGlError();
    }

    private static EGLDisplay getDefaultDisplay() {
        EGLDisplay eGLDisplay0 = EGL14.eglGetDisplay(0);
        if(eGLDisplay0 == null) {
            throw new GlException("eglGetDisplay failed", null);
        }
        int[] arr_v = new int[2];
        if(!EGL14.eglInitialize(eGLDisplay0, arr_v, 0, arr_v, 1)) {
            throw new GlException("eglInitialize failed", null);
        }
        return eGLDisplay0;
    }

    public SurfaceTexture getSurfaceTexture() {
        return (SurfaceTexture)Assertions.checkNotNull(this.texture);
    }

    public void init(int v) {
        EGLDisplay eGLDisplay0 = EGLSurfaceTexture.getDefaultDisplay();
        this.display = eGLDisplay0;
        EGLConfig eGLConfig0 = EGLSurfaceTexture.chooseEGLConfig(eGLDisplay0);
        EGLContext eGLContext0 = EGLSurfaceTexture.createEGLContext(this.display, eGLConfig0, v);
        this.context = eGLContext0;
        this.surface = EGLSurfaceTexture.createEGLSurface(this.display, eGLConfig0, eGLContext0, v);
        EGLSurfaceTexture.generateTextureIds(this.textureIdHolder);
        SurfaceTexture surfaceTexture0 = new SurfaceTexture(this.textureIdHolder[0]);
        this.texture = surfaceTexture0;
        surfaceTexture0.setOnFrameAvailableListener(this);
    }

    @Override  // android.graphics.SurfaceTexture$OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture0) {
        this.handler.post(this);
    }

    public void release() {
        this.handler.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture0 = this.texture;
            if(surfaceTexture0 != null) {
                surfaceTexture0.release();
                GLES20.glDeleteTextures(1, this.textureIdHolder, 0);
            }
        }
        finally {
            if(this.display != null && !this.display.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglMakeCurrent(this.display, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            }
            if(this.surface != null && !this.surface.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.display, this.surface);
            }
            EGLContext eGLContext0 = this.context;
            if(eGLContext0 != null) {
                EGL14.eglDestroyContext(this.display, eGLContext0);
            }
            if(Util.SDK_INT >= 19) {
                EGL14.eglReleaseThread();
            }
            if(this.display != null && !this.display.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.display);
            }
            this.display = null;
            this.context = null;
            this.surface = null;
            this.texture = null;
        }
    }

    @Override
    public void run() {
        this.dispatchOnFrameAvailable();
        SurfaceTexture surfaceTexture0 = this.texture;
        if(surfaceTexture0 != null) {
            try {
                surfaceTexture0.updateTexImage();
            }
            catch(RuntimeException unused_ex) {
            }
        }
    }

    class com.google.android.exoplayer2.util.EGLSurfaceTexture.1 {
    }

}

