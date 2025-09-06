package com.google.android.exoplayer2.ui.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.spherical.FrameRotationQueue;
import com.google.android.exoplayer2.video.spherical.Projection;
import com.google.android.exoplayer2.video.spherical.ProjectionDecoder;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

final class SceneRenderer implements VideoFrameMetadataListener, CameraMotionListener {
    private volatile int defaultStereoMode;
    private final AtomicBoolean frameAvailable;
    private final FrameRotationQueue frameRotationQueue;
    private byte[] lastProjectionData;
    private int lastStereoMode;
    private final TimedValueQueue projectionQueue;
    private final ProjectionRenderer projectionRenderer;
    private final AtomicBoolean resetRotationAtNextFrame;
    private final float[] rotationMatrix;
    private final TimedValueQueue sampleTimestampQueue;
    private SurfaceTexture surfaceTexture;
    private final float[] tempMatrix;
    private int textureId;

    public SceneRenderer() {
        this.frameAvailable = new AtomicBoolean();
        this.resetRotationAtNextFrame = new AtomicBoolean(true);
        this.projectionRenderer = new ProjectionRenderer();
        this.frameRotationQueue = new FrameRotationQueue();
        this.sampleTimestampQueue = new TimedValueQueue();
        this.projectionQueue = new TimedValueQueue();
        this.rotationMatrix = new float[16];
        this.tempMatrix = new float[16];
        this.defaultStereoMode = 0;
        this.lastStereoMode = -1;
    }

    public void drawFrame(float[] arr_f, boolean z) {
        GLES20.glClear(0x4000);
        GlUtil.checkGlError();
        if(this.frameAvailable.compareAndSet(true, false)) {
            ((SurfaceTexture)Assertions.checkNotNull(this.surfaceTexture)).updateTexImage();
            GlUtil.checkGlError();
            if(this.resetRotationAtNextFrame.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.rotationMatrix, 0);
            }
            long v = this.surfaceTexture.getTimestamp();
            Long long0 = (Long)this.sampleTimestampQueue.poll(v);
            if(long0 != null) {
                this.frameRotationQueue.pollRotationMatrix(this.rotationMatrix, ((long)long0));
            }
            Projection projection0 = (Projection)this.projectionQueue.pollFloor(v);
            if(projection0 != null) {
                this.projectionRenderer.setProjection(projection0);
            }
        }
        Matrix.multiplyMM(this.tempMatrix, 0, arr_f, 0, this.rotationMatrix, 0);
        this.projectionRenderer.draw(this.textureId, this.tempMatrix, z);
    }

    public SurfaceTexture init() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        GlUtil.checkGlError();
        this.projectionRenderer.init();
        GlUtil.checkGlError();
        this.textureId = GlUtil.createExternalTexture();
        SurfaceTexture surfaceTexture0 = new SurfaceTexture(this.textureId);
        this.surfaceTexture = surfaceTexture0;
        surfaceTexture0.setOnFrameAvailableListener(new a(this));
        return this.surfaceTexture;
    }

    private void lambda$init$0(SurfaceTexture surfaceTexture0) {
        this.frameAvailable.set(true);
    }

    @Override  // com.google.android.exoplayer2.video.spherical.CameraMotionListener
    public void onCameraMotion(long v, float[] arr_f) {
        this.frameRotationQueue.setRotation(v, arr_f);
    }

    @Override  // com.google.android.exoplayer2.video.spherical.CameraMotionListener
    public void onCameraMotionReset() {
        this.sampleTimestampQueue.clear();
        this.frameRotationQueue.reset();
        this.resetRotationAtNextFrame.set(true);
    }

    @Override  // com.google.android.exoplayer2.video.VideoFrameMetadataListener
    public void onVideoFrameAboutToBeRendered(long v, long v1, Format format0, MediaFormat mediaFormat0) {
        this.sampleTimestampQueue.add(v1, v);
        this.setProjection(format0.projectionData, format0.stereoMode, v1);
    }

    public void setDefaultStereoMode(int v) {
        this.defaultStereoMode = v;
    }

    private void setProjection(byte[] arr_b, int v, long v1) {
        byte[] arr_b1 = this.lastProjectionData;
        int v2 = this.lastStereoMode;
        this.lastProjectionData = arr_b;
        if(v == -1) {
            v = this.defaultStereoMode;
        }
        this.lastStereoMode = v;
        if(v2 == v && Arrays.equals(arr_b1, this.lastProjectionData)) {
            return;
        }
        Projection projection0 = this.lastProjectionData == null ? null : ProjectionDecoder.decode(this.lastProjectionData, this.lastStereoMode);
        if(projection0 == null || !ProjectionRenderer.isSupported(projection0)) {
            projection0 = Projection.createEquirectangular(this.lastStereoMode);
        }
        this.projectionQueue.add(v1, projection0);
    }

    public void shutdown() {
        this.projectionRenderer.shutdown();
    }
}

