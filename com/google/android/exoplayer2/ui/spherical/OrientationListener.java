package com.google.android.exoplayer2.ui.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import com.google.android.exoplayer2.video.spherical.FrameRotationQueue;

final class OrientationListener implements SensorEventListener {
    public interface Listener {
        void onOrientationChange(float[] arg1, float arg2);
    }

    private final float[] angles;
    private final float[] deviceOrientationMatrix4x4;
    private final Display display;
    private final Listener[] listeners;
    private final float[] recenterMatrix4x4;
    private boolean recenterMatrixComputed;
    private final float[] tempMatrix4x4;

    public OrientationListener(Display display0, Listener[] arr_orientationListener$Listener) {
        this.deviceOrientationMatrix4x4 = new float[16];
        this.tempMatrix4x4 = new float[16];
        this.recenterMatrix4x4 = new float[16];
        this.angles = new float[3];
        this.display = display0;
        this.listeners = arr_orientationListener$Listener;
    }

    private float extractRoll(float[] arr_f) {
        SensorManager.remapCoordinateSystem(arr_f, 1, 0x83, this.tempMatrix4x4);
        SensorManager.getOrientation(this.tempMatrix4x4, this.angles);
        return this.angles[2];
    }

    private void notifyListeners(float[] arr_f, float f) {
        Listener[] arr_orientationListener$Listener = this.listeners;
        for(int v = 0; v < arr_orientationListener$Listener.length; ++v) {
            arr_orientationListener$Listener[v].onOrientationChange(arr_f, f);
        }
    }

    @Override  // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor0, int v) {
    }

    @Override  // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent0) {
        SensorManager.getRotationMatrixFromVector(this.deviceOrientationMatrix4x4, sensorEvent0.values);
        int v = this.display.getRotation();
        this.rotateAroundZ(this.deviceOrientationMatrix4x4, v);
        float f = this.extractRoll(this.deviceOrientationMatrix4x4);
        OrientationListener.rotateYtoSky(this.deviceOrientationMatrix4x4);
        this.recenter(this.deviceOrientationMatrix4x4);
        this.notifyListeners(this.deviceOrientationMatrix4x4, f);
    }

    private void recenter(float[] arr_f) {
        if(!this.recenterMatrixComputed) {
            FrameRotationQueue.computeRecenterMatrix(this.recenterMatrix4x4, arr_f);
            this.recenterMatrixComputed = true;
        }
        System.arraycopy(arr_f, 0, this.tempMatrix4x4, 0, this.tempMatrix4x4.length);
        Matrix.multiplyMM(arr_f, 0, this.tempMatrix4x4, 0, this.recenterMatrix4x4, 0);
    }

    private void rotateAroundZ(float[] arr_f, int v) {
        if(v != 0) {
            int v1 = 0x81;
            int v2 = 1;
            switch(v) {
                case 1: {
                    v2 = 0x81;
                    v1 = 2;
                    break;
                }
                case 2: {
                    v2 = 130;
                    break;
                }
                case 3: {
                    v1 = 130;
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
            System.arraycopy(arr_f, 0, this.tempMatrix4x4, 0, this.tempMatrix4x4.length);
            SensorManager.remapCoordinateSystem(this.tempMatrix4x4, v1, v2, arr_f);
        }
    }

    private static void rotateYtoSky(float[] arr_f) {
        Matrix.rotateM(arr_f, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }
}

