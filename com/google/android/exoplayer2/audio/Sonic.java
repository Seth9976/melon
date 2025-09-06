package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class Sonic {
    private static final int AMDF_FREQUENCY = 4000;
    private static final int BYTES_PER_SAMPLE = 2;
    private static final int MAXIMUM_PITCH = 400;
    private static final int MINIMUM_PITCH = 65;
    private final int channelCount;
    private final short[] downSampleBuffer;
    private short[] inputBuffer;
    private int inputFrameCount;
    private final int inputSampleRateHz;
    private int maxDiff;
    private final int maxPeriod;
    private final int maxRequiredFrameCount;
    private int minDiff;
    private final int minPeriod;
    private int newRatePosition;
    private int oldRatePosition;
    private short[] outputBuffer;
    private int outputFrameCount;
    private final float pitch;
    private short[] pitchBuffer;
    private int pitchFrameCount;
    private int prevMinDiff;
    private int prevPeriod;
    private final float rate;
    private int remainingInputToCopyFrameCount;
    private final float speed;

    public Sonic(int v, int v1, float f, float f1, int v2) {
        this.inputSampleRateHz = v;
        this.channelCount = v1;
        this.speed = f;
        this.pitch = f1;
        this.rate = ((float)v) / ((float)v2);
        this.minPeriod = v / 400;
        this.maxPeriod = v / 65;
        int v3 = v / 65 * 2;
        this.maxRequiredFrameCount = v3;
        this.downSampleBuffer = new short[v3];
        this.inputBuffer = new short[v3 * v1];
        this.outputBuffer = new short[v3 * v1];
        this.pitchBuffer = new short[v3 * v1];
    }

    private void adjustRate(float f, int v) {
        int v5;
        int v4;
        if(this.outputFrameCount == v) {
            return;
        }
        int v1 = this.inputSampleRateHz;
        int v2 = (int)(((float)v1) / f);
        while(v2 > 0x4000 || v1 > 0x4000) {
            v2 /= 2;
            v1 /= 2;
        }
        this.moveNewSamplesToPitchBuffer(v);
        for(int v3 = 0; true; ++v3) {
            v4 = this.pitchFrameCount;
            boolean z = true;
            if(v3 >= v4 - 1) {
                break;
            }
            while(true) {
                v5 = this.oldRatePosition;
                int v6 = this.newRatePosition;
                if((v5 + 1) * v2 <= v6 * v1) {
                    break;
                }
                this.outputBuffer = this.ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, 1);
                for(int v7 = 0; true; ++v7) {
                    int v8 = this.channelCount;
                    if(v7 >= v8) {
                        break;
                    }
                    short[] arr_v = this.outputBuffer;
                    int v9 = this.outputFrameCount * v8 + v7;
                    arr_v[v9] = this.interpolate(this.pitchBuffer, v8 * v3 + v7, v1, v2);
                }
                ++this.newRatePosition;
                ++this.outputFrameCount;
            }
            this.oldRatePosition = v5 + 1;
            if(v5 + 1 == v1) {
                this.oldRatePosition = 0;
                if(v6 != v2) {
                    z = false;
                }
                Assertions.checkState(z);
                this.newRatePosition = 0;
            }
        }
        this.removePitchFrames(v4 - 1);
    }

    private void changeSpeed(float f) {
        int v2;
        int v = this.inputFrameCount;
        if(v < this.maxRequiredFrameCount) {
            return;
        }
        int v1 = 0;
        do {
            if(this.remainingInputToCopyFrameCount > 0) {
                v2 = this.copyInputToOutput(v1);
            }
            else {
                int v3 = this.findPitchPeriod(this.inputBuffer, v1);
                if(((double)f) > 1.0) {
                    v1 = v3 + this.skipPitchPeriod(this.inputBuffer, v1, f, v3) + v1;
                    continue;
                }
                else {
                    v2 = this.insertPitchPeriod(this.inputBuffer, v1, f, v3);
                }
            }
            v1 += v2;
        }
        while(this.maxRequiredFrameCount + v1 <= v);
        this.removeProcessedInputFrames(v1);
    }

    private int copyInputToOutput(int v) {
        int v1 = Math.min(this.maxRequiredFrameCount, this.remainingInputToCopyFrameCount);
        this.copyToOutput(this.inputBuffer, v, v1);
        this.remainingInputToCopyFrameCount -= v1;
        return v1;
    }

    private void copyToOutput(short[] arr_v, int v, int v1) {
        short[] arr_v1 = this.ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, v1);
        this.outputBuffer = arr_v1;
        System.arraycopy(arr_v, v * this.channelCount, arr_v1, this.outputFrameCount * this.channelCount, this.channelCount * v1);
        this.outputFrameCount += v1;
    }

    private void downSampleInput(short[] arr_v, int v, int v1) {
        int v2 = this.maxRequiredFrameCount / v1;
        int v3 = v1 * this.channelCount;
        int v4 = v * this.channelCount;
        for(int v5 = 0; v5 < v2; ++v5) {
            int v7 = 0;
            for(int v6 = 0; v6 < v3; ++v6) {
                v7 += arr_v[v5 * v3 + v4 + v6];
            }
            this.downSampleBuffer[v5] = (short)(v7 / v3);
        }
    }

    private short[] ensureSpaceForAdditionalFrames(short[] arr_v, int v, int v1) {
        int v2 = arr_v.length / this.channelCount;
        return v + v1 > v2 ? Arrays.copyOf(arr_v, (v2 * 3 / 2 + v1) * this.channelCount) : arr_v;
    }

    private int findPitchPeriod(short[] arr_v, int v) {
        int v2;
        int v1 = this.inputSampleRateHz <= 4000 ? 1 : this.inputSampleRateHz / 4000;
        if(this.channelCount != 1 || v1 != 1) {
            this.downSampleInput(arr_v, v, v1);
            int v3 = this.findPitchPeriodInRange(this.downSampleBuffer, 0, this.minPeriod / v1, this.maxPeriod / v1);
            if(v1 == 1) {
                v2 = v3;
            }
            else {
                int v4 = v3 * v1;
                int v5 = v4 - v1 * 4;
                int v6 = v4 + v1 * 4;
                int v7 = this.minPeriod;
                if(v5 < v7) {
                    v5 = v7;
                }
                int v8 = this.maxPeriod;
                if(v6 > v8) {
                    v6 = v8;
                }
                if(this.channelCount == 1) {
                    v2 = this.findPitchPeriodInRange(arr_v, v, v5, v6);
                }
                else {
                    this.downSampleInput(arr_v, v, 1);
                    v2 = this.findPitchPeriodInRange(this.downSampleBuffer, 0, v5, v6);
                }
            }
        }
        else {
            v2 = this.findPitchPeriodInRange(arr_v, v, this.minPeriod, this.maxPeriod);
        }
        int v9 = this.previousPeriodBetter(this.minDiff, this.maxDiff) ? this.prevPeriod : v2;
        this.prevMinDiff = this.minDiff;
        this.prevPeriod = v2;
        return v9;
    }

    private int findPitchPeriodInRange(short[] arr_v, int v, int v1, int v2) {
        int v3 = v * this.channelCount;
        int v4 = 0xFF;
        int v5 = 1;
        int v6 = 0;
        int v7 = 0;
        while(v1 <= v2) {
            int v9 = 0;
            for(int v8 = 0; v8 < v1; ++v8) {
                v9 += Math.abs(arr_v[v3 + v8] - arr_v[v3 + v1 + v8]);
            }
            if(v9 * v6 < v5 * v1) {
                v6 = v1;
                v5 = v9;
            }
            if(v9 * v4 > v7 * v1) {
                v4 = v1;
                v7 = v9;
            }
            ++v1;
        }
        this.minDiff = v5 / v6;
        this.maxDiff = v7 / v4;
        return v6;
    }

    public void flush() {
        this.inputFrameCount = 0;
        this.outputFrameCount = 0;
        this.pitchFrameCount = 0;
        this.oldRatePosition = 0;
        this.newRatePosition = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.prevPeriod = 0;
        this.prevMinDiff = 0;
        this.minDiff = 0;
        this.maxDiff = 0;
    }

    public void getOutput(ShortBuffer shortBuffer0) {
        int v = Math.min(shortBuffer0.remaining() / this.channelCount, this.outputFrameCount);
        shortBuffer0.put(this.outputBuffer, 0, this.channelCount * v);
        int v1 = this.outputFrameCount - v;
        this.outputFrameCount = v1;
        System.arraycopy(this.outputBuffer, v * this.channelCount, this.outputBuffer, 0, v1 * this.channelCount);
    }

    public int getOutputSize() {
        return this.outputFrameCount * this.channelCount * 2;
    }

    private int insertPitchPeriod(short[] arr_v, int v, float f, int v1) {
        int v2;
        if(Float.compare(f, 0.5f) < 0) {
            v2 = (int)(((float)v1) * f / (1.0f - f));
        }
        else {
            this.remainingInputToCopyFrameCount = (int)((2.0f * f - 1.0f) * ((float)v1) / (1.0f - f));
            v2 = v1;
        }
        int v3 = v1 + v2;
        short[] arr_v1 = this.ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, v3);
        this.outputBuffer = arr_v1;
        System.arraycopy(arr_v, v * this.channelCount, arr_v1, this.outputFrameCount * this.channelCount, this.channelCount * v1);
        Sonic.overlapAdd(v2, this.channelCount, this.outputBuffer, this.outputFrameCount + v1, arr_v, v + v1, arr_v, v);
        this.outputFrameCount += v3;
        return v2;
    }

    private short interpolate(short[] arr_v, int v, int v1, int v2) {
        int v3 = (this.oldRatePosition + 1) * v2;
        int v4 = v3 - this.newRatePosition * v1;
        int v5 = v3 - this.oldRatePosition * v2;
        return (short)(((v5 - v4) * arr_v[v + this.channelCount] + arr_v[v] * v4) / v5);
    }

    private void moveNewSamplesToPitchBuffer(int v) {
        int v1 = this.outputFrameCount - v;
        short[] arr_v = this.ensureSpaceForAdditionalFrames(this.pitchBuffer, this.pitchFrameCount, v1);
        this.pitchBuffer = arr_v;
        System.arraycopy(this.outputBuffer, v * this.channelCount, arr_v, this.pitchFrameCount * this.channelCount, this.channelCount * v1);
        this.outputFrameCount = v;
        this.pitchFrameCount += v1;
    }

    private static void overlapAdd(int v, int v1, short[] arr_v, int v2, short[] arr_v1, int v3, short[] arr_v2, int v4) {
        for(int v5 = 0; v5 < v1; ++v5) {
            int v6 = v2 * v1 + v5;
            int v7 = v4 * v1 + v5;
            int v8 = v3 * v1 + v5;
            for(int v9 = 0; v9 < v; ++v9) {
                arr_v[v6] = (short)((arr_v2[v7] * v9 + (v - v9) * arr_v1[v8]) / v);
                v6 += v1;
                v8 += v1;
                v7 += v1;
            }
        }
    }

    private boolean previousPeriodBetter(int v, int v1) {
        return v != 0 && this.prevPeriod != 0 && v1 <= v * 3 ? v * 2 > this.prevMinDiff * 3 : false;
    }

    private void processStreamInput() {
        int v = this.outputFrameCount;
        float f = this.speed / this.pitch;
        float f1 = this.rate * this.pitch;
        if(((double)f) > 1.00001 || ((double)f) < 0.99999) {
            this.changeSpeed(f);
        }
        else {
            this.copyToOutput(this.inputBuffer, 0, this.inputFrameCount);
            this.inputFrameCount = 0;
        }
        if(f1 != 1.0f) {
            this.adjustRate(f1, v);
        }
    }

    public void queueEndOfStream() {
        int v3;
        int v = this.inputFrameCount;
        int v1 = this.outputFrameCount + ((int)((((float)v) / (this.speed / this.pitch) + ((float)this.pitchFrameCount)) / (this.rate * this.pitch) + 0.5f));
        this.inputBuffer = this.ensureSpaceForAdditionalFrames(this.inputBuffer, v, this.maxRequiredFrameCount * 2 + v);
        for(int v2 = 0; true; ++v2) {
            v3 = this.maxRequiredFrameCount;
            int v4 = this.channelCount;
            if(v2 >= v3 * 2 * v4) {
                break;
            }
            this.inputBuffer[v4 * v + v2] = 0;
        }
        this.inputFrameCount = v3 * 2 + this.inputFrameCount;
        this.processStreamInput();
        if(this.outputFrameCount > v1) {
            this.outputFrameCount = v1;
        }
        this.inputFrameCount = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.pitchFrameCount = 0;
    }

    public void queueInput(ShortBuffer shortBuffer0) {
        int v = shortBuffer0.remaining() / this.channelCount;
        short[] arr_v = this.ensureSpaceForAdditionalFrames(this.inputBuffer, this.inputFrameCount, v);
        this.inputBuffer = arr_v;
        shortBuffer0.get(arr_v, this.inputFrameCount * this.channelCount, this.channelCount * v * 2 / 2);
        this.inputFrameCount += v;
        this.processStreamInput();
    }

    private void removePitchFrames(int v) {
        if(v == 0) {
            return;
        }
        System.arraycopy(this.pitchBuffer, v * this.channelCount, this.pitchBuffer, 0, (this.pitchFrameCount - v) * this.channelCount);
        this.pitchFrameCount -= v;
    }

    private void removeProcessedInputFrames(int v) {
        int v1 = this.inputFrameCount - v;
        System.arraycopy(this.inputBuffer, v * this.channelCount, this.inputBuffer, 0, this.channelCount * v1);
        this.inputFrameCount = v1;
    }

    private int skipPitchPeriod(short[] arr_v, int v, float f, int v1) {
        int v2;
        if(Float.compare(f, 2.0f) >= 0) {
            v2 = (int)(((float)v1) / (f - 1.0f));
        }
        else {
            this.remainingInputToCopyFrameCount = (int)((2.0f - f) * ((float)v1) / (f - 1.0f));
            v2 = v1;
        }
        short[] arr_v1 = this.ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, v2);
        this.outputBuffer = arr_v1;
        Sonic.overlapAdd(v2, this.channelCount, arr_v1, this.outputFrameCount, arr_v, v, arr_v, v + v1);
        this.outputFrameCount += v2;
        return v2;
    }
}

