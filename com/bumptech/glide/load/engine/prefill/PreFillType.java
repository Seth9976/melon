package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap.Config;
import androidx.appcompat.app.o;
import com.bumptech.glide.util.Preconditions;

public final class PreFillType {
    public static class Builder {
        private Bitmap.Config config;
        private final int height;
        private int weight;
        private final int width;

        public Builder(int v) {
            this(v, v);
        }

        public Builder(int v, int v1) {
            this.weight = 1;
            if(v <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if(v1 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            }
            this.width = v;
            this.height = v1;
        }

        public PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }

        public Bitmap.Config getConfig() {
            return this.config;
        }

        public Builder setConfig(Bitmap.Config bitmap$Config0) {
            this.config = bitmap$Config0;
            return this;
        }

        public Builder setWeight(int v) {
            if(v <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.weight = v;
            return this;
        }
    }

    static final Bitmap.Config DEFAULT_CONFIG;
    private final Bitmap.Config config;
    private final int height;
    private final int weight;
    private final int width;

    static {
        PreFillType.DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    }

    public PreFillType(int v, int v1, Bitmap.Config bitmap$Config0, int v2) {
        this.config = (Bitmap.Config)Preconditions.checkNotNull(bitmap$Config0, "Config must not be null");
        this.width = v;
        this.height = v1;
        this.weight = v2;
    }

    @Override
    public boolean equals(Object object0) {
        return object0 instanceof PreFillType && this.height == ((PreFillType)object0).height && this.width == ((PreFillType)object0).width && this.weight == ((PreFillType)object0).weight && this.config == ((PreFillType)object0).config;
    }

    public Bitmap.Config getConfig() {
        return this.config;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    @Override
    public int hashCode() {
        return (this.config.hashCode() + (this.width * 0x1F + this.height) * 0x1F) * 0x1F + this.weight;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PreFillSize{width=");
        stringBuilder0.append(this.width);
        stringBuilder0.append(", height=");
        stringBuilder0.append(this.height);
        stringBuilder0.append(", config=");
        stringBuilder0.append(this.config);
        stringBuilder0.append(", weight=");
        return o.q(stringBuilder0, this.weight, '}');
    }
}

