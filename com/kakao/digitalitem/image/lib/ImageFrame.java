package com.kakao.digitalitem.image.lib;

import U4.x;
import android.annotation.SuppressLint;
import androidx.appcompat.app.o;

public final class ImageFrame {
    public static class Builder {
        private int blend;
        private int dispose;
        private int duration;
        private int[] frame;
        private int frameIndex;
        private int height;
        private int width;
        private int x;
        private int y;

        public ImageFrame build() {
            return new ImageFrame(this.frame, this.frameIndex, this.x, this.y, this.width, this.height, this.duration, this.dispose, this.blend, null);
        }

        public Builder setBlend(int v) {
            this.blend = v;
            return this;
        }

        public Builder setDispose(int v) {
            this.dispose = v;
            return this;
        }

        public Builder setDuration(int v) {
            this.duration = v;
            return this;
        }

        public Builder setFrame(int[] arr_v) {
            this.frame = arr_v;
            return this;
        }

        public Builder setFrameIndex(int v) {
            this.frameIndex = v;
            return this;
        }

        public Builder setHeight(int v) {
            this.height = v;
            return this;
        }

        public Builder setWidth(int v) {
            this.width = v;
            return this;
        }

        public Builder setX(int v) {
            this.x = v;
            return this;
        }

        public Builder setY(int v) {
            this.y = v;
            return this;
        }
    }

    private final int blend;
    private final int dispose;
    private final int duration;
    private final int[] frame;
    private final int frameIndex;
    private final int height;
    private final int width;
    private final int x;
    private final int y;

    private ImageFrame(int[] arr_v, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
        this.frame = arr_v;
        this.frameIndex = v;
        this.x = v1;
        this.y = v2;
        this.width = v3;
        this.height = v4;
        this.duration = v5;
        this.dispose = v6;
        this.blend = v7;
    }

    public ImageFrame(int[] arr_v, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7, com.kakao.digitalitem.image.lib.ImageFrame.1 imageFrame$10) {
        this(arr_v, v, v1, v2, v3, v4, v5, v6, v7);
    }

    public int getBlend() {
        return this.blend;
    }

    public int getDispose() {
        return this.dispose;
    }

    public int getDuration() {
        return this.duration;
    }

    public int[] getFrame() {
        return this.frame;
    }

    public int getFrameIndex() {
        return this.frameIndex;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    @SuppressLint({"DefaultLocale"})
    public String toString() {
        StringBuilder stringBuilder0 = o.t(this.x, this.y, "{x: ", ", y: ", ", width: ");
        x.x(stringBuilder0, this.width, ", height: ", this.height, ", \nframeIndex: ");
        x.x(stringBuilder0, this.frameIndex, ", duration: ", this.duration, ", dispose: ");
        stringBuilder0.append(this.dispose);
        stringBuilder0.append(", frame: ");
        stringBuilder0.append((this.frame == null ? 0 : this.frame.length));
        stringBuilder0.append("}\n");
        return stringBuilder0.toString();
    }

    class com.kakao.digitalitem.image.lib.ImageFrame.1 {
    }

}

