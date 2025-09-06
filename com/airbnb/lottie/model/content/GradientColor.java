package com.airbnb.lottie.model.content;

import U4.x;
import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.Arrays;

public class GradientColor {
    private final int[] colors;
    private final float[] positions;

    public GradientColor(float[] arr_f, int[] arr_v) {
        this.positions = arr_f;
        this.colors = arr_v;
    }

    private void copyFrom(GradientColor gradientColor0) {
        for(int v = 0; true; ++v) {
            int[] arr_v = gradientColor0.colors;
            if(v >= arr_v.length) {
                break;
            }
            this.positions[v] = gradientColor0.positions[v];
            this.colors[v] = arr_v[v];
        }
    }

    public GradientColor copyWithPositions(float[] arr_f) {
        int[] arr_v = new int[arr_f.length];
        for(int v = 0; v < arr_f.length; ++v) {
            arr_v[v] = this.getColorForPosition(arr_f[v]);
        }
        return new GradientColor(arr_f, arr_v);
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && this.getClass() == object0.getClass() && Arrays.equals(this.positions, ((GradientColor)object0).positions) && Arrays.equals(this.colors, ((GradientColor)object0).colors);
    }

    private int getColorForPosition(float f) {
        int v = Arrays.binarySearch(this.positions, f);
        if(v >= 0) {
            return this.colors[v];
        }
        if(-(v + 1) == 0) {
            return this.colors[0];
        }
        int[] arr_v = this.colors;
        if(-(v + 1) == arr_v.length - 1) {
            return arr_v[arr_v.length - 1];
        }
        int v1 = -(v + 1) - 1;
        float f1 = this.positions[v1];
        return GammaEvaluator.evaluate((f - f1) / (this.positions[-(v + 1)] - f1), arr_v[v1], arr_v[-(v + 1)]);
    }

    public int[] getColors() {
        return this.colors;
    }

    public float[] getPositions() {
        return this.positions;
    }

    public int getSize() {
        return this.colors.length;
    }

    @Override
    public int hashCode() {
        int v = Arrays.hashCode(this.positions);
        return Arrays.hashCode(this.colors) + v * 0x1F;
    }

    public void lerp(GradientColor gradientColor0, GradientColor gradientColor1, float f) {
        if(gradientColor0.equals(gradientColor1)) {
            this.copyFrom(gradientColor0);
            return;
        }
        if(f <= 0.0f) {
            this.copyFrom(gradientColor0);
            return;
        }
        if(f >= 1.0f) {
            this.copyFrom(gradientColor1);
            return;
        }
        if(gradientColor0.colors.length == gradientColor1.colors.length) {
            for(int v = 0; true; ++v) {
                int[] arr_v = gradientColor0.colors;
                if(v >= arr_v.length) {
                    break;
                }
                this.positions[v] = MiscUtils.lerp(gradientColor0.positions[v], gradientColor1.positions[v], f);
                this.colors[v] = GammaEvaluator.evaluate(f, gradientColor0.colors[v], gradientColor1.colors[v]);
            }
            for(int v1 = arr_v.length; true; ++v1) {
                float[] arr_f = this.positions;
                if(v1 >= arr_f.length) {
                    break;
                }
                arr_f[v1] = arr_f[gradientColor0.colors.length - 1];
                this.colors[v1] = this.colors[gradientColor0.colors.length - 1];
            }
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
        stringBuilder0.append(gradientColor0.colors.length);
        stringBuilder0.append(" vs ");
        throw new IllegalArgumentException(x.g(gradientColor1.colors.length, ")", stringBuilder0));
    }
}

