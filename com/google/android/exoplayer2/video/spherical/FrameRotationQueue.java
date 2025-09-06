package com.google.android.exoplayer2.video.spherical;

import android.opengl.Matrix;
import com.google.android.exoplayer2.util.TimedValueQueue;

public final class FrameRotationQueue {
    private final float[] recenterMatrix;
    private boolean recenterMatrixComputed;
    private final float[] rotationMatrix;
    private final TimedValueQueue rotations;

    public FrameRotationQueue() {
        this.recenterMatrix = new float[16];
        this.rotationMatrix = new float[16];
        this.rotations = new TimedValueQueue();
    }

    public static void computeRecenterMatrix(float[] arr_f, float[] arr_f1) {
        Matrix.setIdentityM(arr_f, 0);
        float f = arr_f1[10];
        float f1 = arr_f1[8];
        float f2 = (float)Math.sqrt(f1 * f1 + f * f);
        float f3 = arr_f1[10];
        arr_f[0] = f3 / f2;
        float f4 = arr_f1[8];
        arr_f[2] = f4 / f2;
        arr_f[8] = -f4 / f2;
        arr_f[10] = f3 / f2;
    }

    private static void getRotationMatrixFromAngleAxis(float[] arr_f, float[] arr_f1) {
        float f = arr_f1[0];
        float f1 = -arr_f1[1];
        float f2 = -arr_f1[2];
        float f3 = Matrix.length(f, f1, f2);
        if(f3 != 0.0f) {
            Matrix.setRotateM(arr_f, 0, ((float)Math.toDegrees(f3)), f / f3, f1 / f3, f2 / f3);
            return;
        }
        Matrix.setIdentityM(arr_f, 0);
    }

    public boolean pollRotationMatrix(float[] arr_f, long v) {
        float[] arr_f1 = (float[])this.rotations.pollFloor(v);
        if(arr_f1 == null) {
            return false;
        }
        FrameRotationQueue.getRotationMatrixFromAngleAxis(this.rotationMatrix, arr_f1);
        if(!this.recenterMatrixComputed) {
            FrameRotationQueue.computeRecenterMatrix(this.recenterMatrix, this.rotationMatrix);
            this.recenterMatrixComputed = true;
        }
        Matrix.multiplyMM(arr_f, 0, this.recenterMatrix, 0, this.rotationMatrix, 0);
        return true;
    }

    public void reset() {
        this.rotations.clear();
        this.recenterMatrixComputed = false;
    }

    public void setRotation(long v, float[] arr_f) {
        this.rotations.add(v, arr_f);
    }
}

