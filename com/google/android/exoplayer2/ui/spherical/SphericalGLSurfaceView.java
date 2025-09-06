package com.google.android.exoplayer2.ui.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.WindowManager;
import b.l;
import com.google.android.exoplayer2.Player.VideoComponent;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class SphericalGLSurfaceView extends GLSurfaceView {
    class Renderer implements GLSurfaceView.Renderer, Listener, com.google.android.exoplayer2.ui.spherical.TouchTracker.Listener {
        private final float[] deviceOrientationMatrix;
        private float deviceRoll;
        private final float[] projectionMatrix;
        private final SceneRenderer scene;
        private final float[] tempMatrix;
        private float touchPitch;
        private final float[] touchPitchMatrix;
        private final float[] touchYawMatrix;
        private final float[] viewMatrix;
        private final float[] viewProjectionMatrix;

        public Renderer(SceneRenderer sceneRenderer0) {
            this.projectionMatrix = new float[16];
            this.viewProjectionMatrix = new float[16];
            float[] arr_f = new float[16];
            this.deviceOrientationMatrix = arr_f;
            float[] arr_f1 = new float[16];
            this.touchPitchMatrix = arr_f1;
            float[] arr_f2 = new float[16];
            this.touchYawMatrix = arr_f2;
            this.viewMatrix = new float[16];
            this.tempMatrix = new float[16];
            this.scene = sceneRenderer0;
            Matrix.setIdentityM(arr_f, 0);
            Matrix.setIdentityM(arr_f1, 0);
            Matrix.setIdentityM(arr_f2, 0);
            this.deviceRoll = 3.141593f;
        }

        // 去混淆评级： 低(30)
        private float calculateFieldOfViewInYDirection(float f) {
            return f > 1.0f ? ((float)(Math.toDegrees(Math.atan(1.0 / ((double)f))) * 2.0)) : 90.0f;
        }

        @Override  // android.opengl.GLSurfaceView$Renderer
        public void onDrawFrame(GL10 gL100) {
            synchronized(this) {
                Matrix.multiplyMM(this.tempMatrix, 0, this.deviceOrientationMatrix, 0, this.touchYawMatrix, 0);
                Matrix.multiplyMM(this.viewMatrix, 0, this.touchPitchMatrix, 0, this.tempMatrix, 0);
            }
            Matrix.multiplyMM(this.viewProjectionMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
            this.scene.drawFrame(this.viewProjectionMatrix, false);
        }

        @Override  // com.google.android.exoplayer2.ui.spherical.OrientationListener$Listener
        public void onOrientationChange(float[] arr_f, float f) {
            synchronized(this) {
                System.arraycopy(arr_f, 0, this.deviceOrientationMatrix, 0, this.deviceOrientationMatrix.length);
                this.deviceRoll = -f;
                this.updatePitchMatrix();
            }
        }

        @Override  // com.google.android.exoplayer2.ui.spherical.TouchTracker$Listener
        public void onScrollChange(PointF pointF0) {
            synchronized(this) {
                this.touchPitch = pointF0.y;
                this.updatePitchMatrix();
                Matrix.setRotateM(this.touchYawMatrix, 0, -pointF0.x, 0.0f, 1.0f, 0.0f);
            }
        }

        @Override  // android.opengl.GLSurfaceView$Renderer
        public void onSurfaceChanged(GL10 gL100, int v, int v1) {
            GLES20.glViewport(0, 0, v, v1);
            float f = ((float)v) / ((float)v1);
            Matrix.perspectiveM(this.projectionMatrix, 0, this.calculateFieldOfViewInYDirection(f), f, 0.1f, 100.0f);
        }

        @Override  // android.opengl.GLSurfaceView$Renderer
        public void onSurfaceCreated(GL10 gL100, EGLConfig eGLConfig0) {
            synchronized(this) {
                SurfaceTexture surfaceTexture0 = this.scene.init();
                SphericalGLSurfaceView.this.onSurfaceTextureAvailable(surfaceTexture0);
            }
        }

        private void updatePitchMatrix() {
            Matrix.setRotateM(this.touchPitchMatrix, 0, -this.touchPitch, ((float)Math.cos(this.deviceRoll)), ((float)Math.sin(this.deviceRoll)), 0.0f);
        }
    }

    private static final int FIELD_OF_VIEW_DEGREES = 90;
    private static final float PX_PER_DEGREES = 25.0f;
    static final float UPRIGHT_ROLL = 3.141593f;
    private static final float Z_FAR = 100.0f;
    private static final float Z_NEAR = 0.1f;
    private boolean isOrientationListenerRegistered;
    private boolean isStarted;
    private final Handler mainHandler;
    private final OrientationListener orientationListener;
    private final Sensor orientationSensor;
    private final SceneRenderer scene;
    private final SensorManager sensorManager;
    private Surface surface;
    private SurfaceTexture surfaceTexture;
    private final TouchTracker touchTracker;
    private boolean useSensorRotation;
    private VideoComponent videoComponent;

    public SphericalGLSurfaceView(Context context0) {
        this(context0, null);
    }

    public SphericalGLSurfaceView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.mainHandler = new Handler(Looper.getMainLooper());
        SensorManager sensorManager0 = (SensorManager)Assertions.checkNotNull(context0.getSystemService("sensor"));
        this.sensorManager = sensorManager0;
        Sensor sensor0 = Util.SDK_INT < 18 ? null : sensorManager0.getDefaultSensor(15);
        if(sensor0 == null) {
            sensor0 = sensorManager0.getDefaultSensor(11);
        }
        this.orientationSensor = sensor0;
        SceneRenderer sceneRenderer0 = new SceneRenderer();
        this.scene = sceneRenderer0;
        Renderer sphericalGLSurfaceView$Renderer0 = new Renderer(this, sceneRenderer0);
        TouchTracker touchTracker0 = new TouchTracker(context0, sphericalGLSurfaceView$Renderer0, 25.0f);
        this.touchTracker = touchTracker0;
        this.orientationListener = new OrientationListener(((WindowManager)Assertions.checkNotNull(((WindowManager)context0.getSystemService("window")))).getDefaultDisplay(), new Listener[]{touchTracker0, sphericalGLSurfaceView$Renderer0});
        this.useSensorRotation = true;
        this.setEGLContextClientVersion(2);
        this.setRenderer(sphericalGLSurfaceView$Renderer0);
        this.setOnTouchListener(touchTracker0);
    }

    public static void b(SphericalGLSurfaceView sphericalGLSurfaceView0, SurfaceTexture surfaceTexture0) {
        sphericalGLSurfaceView0.lambda$onSurfaceTextureAvailable$1(surfaceTexture0);
    }

    // 检测为 Lambda 实现
    private void lambda$onDetachedFromWindow$0() [...]

    private void lambda$onSurfaceTextureAvailable$1(SurfaceTexture surfaceTexture0) {
        SurfaceTexture surfaceTexture1 = this.surfaceTexture;
        Surface surface0 = this.surface;
        this.surfaceTexture = surfaceTexture0;
        Surface surface1 = new Surface(surfaceTexture0);
        this.surface = surface1;
        VideoComponent player$VideoComponent0 = this.videoComponent;
        if(player$VideoComponent0 != null) {
            player$VideoComponent0.setVideoSurface(surface1);
        }
        SphericalGLSurfaceView.releaseSurface(surfaceTexture1, surface0);
    }

    @Override  // android.opengl.GLSurfaceView
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b b0 = () -> {
            Surface surface0 = this.surface;
            if(surface0 != null) {
                VideoComponent player$VideoComponent0 = this.videoComponent;
                if(player$VideoComponent0 != null) {
                    player$VideoComponent0.clearVideoSurface(surface0);
                }
                SphericalGLSurfaceView.releaseSurface(this.surfaceTexture, this.surface);
                this.surfaceTexture = null;
                this.surface = null;
            }
        };
        this.mainHandler.post(b0);
    }

    @Override  // android.opengl.GLSurfaceView
    public void onPause() {
        this.isStarted = false;
        this.updateOrientationListenerRegistration();
        super.onPause();
    }

    @Override  // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.isStarted = true;
        this.updateOrientationListenerRegistration();
    }

    private void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture0) {
        l l0 = new l(16, this, surfaceTexture0);
        this.mainHandler.post(l0);
    }

    private static void releaseSurface(SurfaceTexture surfaceTexture0, Surface surface0) {
        if(surfaceTexture0 != null) {
            surfaceTexture0.release();
        }
        if(surface0 != null) {
            surface0.release();
        }
    }

    public void setDefaultStereoMode(int v) {
        this.scene.setDefaultStereoMode(v);
    }

    public void setSingleTapListener(SingleTapListener singleTapListener0) {
        this.touchTracker.setSingleTapListener(singleTapListener0);
    }

    public void setUseSensorRotation(boolean z) {
        this.useSensorRotation = z;
        this.updateOrientationListenerRegistration();
    }

    public void setVideoComponent(VideoComponent player$VideoComponent0) {
        VideoComponent player$VideoComponent1 = this.videoComponent;
        if(player$VideoComponent0 != player$VideoComponent1) {
            if(player$VideoComponent1 != null) {
                Surface surface0 = this.surface;
                if(surface0 != null) {
                    player$VideoComponent1.clearVideoSurface(surface0);
                }
                this.videoComponent.clearVideoFrameMetadataListener(this.scene);
                this.videoComponent.clearCameraMotionListener(this.scene);
            }
            this.videoComponent = player$VideoComponent0;
            if(player$VideoComponent0 != null) {
                player$VideoComponent0.setVideoFrameMetadataListener(this.scene);
                this.videoComponent.setCameraMotionListener(this.scene);
                this.videoComponent.setVideoSurface(this.surface);
            }
        }
    }

    private void updateOrientationListenerRegistration() {
        boolean z = this.useSensorRotation && this.isStarted;
        Sensor sensor0 = this.orientationSensor;
        if(sensor0 != null && z != this.isOrientationListenerRegistered) {
            if(z) {
                this.sensorManager.registerListener(this.orientationListener, sensor0, 0);
            }
            else {
                this.sensorManager.unregisterListener(this.orientationListener);
            }
            this.isOrientationListenerRegistered = z;
        }
    }
}

