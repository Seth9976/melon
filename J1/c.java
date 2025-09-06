package J1;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;

public final class c {
    public final float[] a;
    public final ColorMatrix b;
    public final ColorMatrix c;
    public float d;
    public float e;
    public float f;
    public float g;

    public c() {
        this.a = new float[20];
        this.b = new ColorMatrix();
        this.c = new ColorMatrix();
        this.d = 1.0f;
        this.e = 1.0f;
        this.f = 1.0f;
        this.g = 1.0f;
    }

    public final void a(ImageView imageView0) {
        float f9;
        float f8;
        float f7;
        int v1;
        ColorMatrix colorMatrix0 = this.b;
        colorMatrix0.reset();
        float f = this.e;
        float[] arr_f = this.a;
        int v = 1;
        if(Float.compare(f, 1.0f) == 0) {
            v1 = 0;
        }
        else {
            float f1 = 0.2999f * (1.0f - f);
            float f2 = 0.587f * (1.0f - f);
            float f3 = (1.0f - f) * 0.114f;
            arr_f[0] = f1 + f;
            arr_f[1] = f2;
            arr_f[2] = f3;
            arr_f[3] = 0.0f;
            arr_f[4] = 0.0f;
            arr_f[5] = f1;
            arr_f[6] = f2 + f;
            arr_f[7] = f3;
            arr_f[8] = 0.0f;
            arr_f[9] = 0.0f;
            arr_f[10] = f1;
            arr_f[11] = f2;
            arr_f[12] = f3 + f;
            arr_f[13] = 0.0f;
            arr_f[14] = 0.0f;
            arr_f[15] = 0.0f;
            arr_f[16] = 0.0f;
            arr_f[17] = 0.0f;
            arr_f[18] = 1.0f;
            arr_f[19] = 0.0f;
            colorMatrix0.set(arr_f);
            v1 = 1;
        }
        float f4 = this.f;
        ColorMatrix colorMatrix1 = this.c;
        if(Float.compare(f4, 1.0f) != 0) {
            colorMatrix1.setScale(f4, f4, f4, 1.0f);
            colorMatrix0.postConcat(colorMatrix1);
            v1 = 1;
        }
        float f5 = this.g;
        if(f5 != 1.0f) {
            if(f5 <= 0.0f) {
                f5 = 0.01f;
            }
            float f6 = 5000.0f / f5 / 100.0f;
            if(Float.compare(f6, 66.0f) > 0) {
                f7 = ((float)Math.pow(f6 - 60.0f, -0.133205)) * 329.69873f;
                f8 = ((float)Math.pow(f6 - 60.0f, 0.075515)) * 288.122162f;
            }
            else {
                f8 = ((float)Math.log(f6)) * 99.470802f - 161.119568f;
                f7 = 255.0f;
            }
            if(Float.compare(f6, 66.0f) >= 0) {
                f9 = 255.0f;
            }
            else if(f6 > 19.0f) {
                f9 = ((float)Math.log(f6 - 10.0f)) * 138.517731f - 305.0448f;
            }
            else {
                f9 = 0.0f;
            }
            arr_f[0] = Math.min(255.0f, Math.max(f7, 0.0f)) / 255.0f;
            arr_f[1] = 0.0f;
            arr_f[2] = 0.0f;
            arr_f[3] = 0.0f;
            arr_f[4] = 0.0f;
            arr_f[5] = 0.0f;
            arr_f[6] = Math.min(255.0f, Math.max(f8, 0.0f)) / 228.012512f;
            arr_f[7] = 0.0f;
            arr_f[8] = 0.0f;
            arr_f[9] = 0.0f;
            arr_f[10] = 0.0f;
            arr_f[11] = 0.0f;
            arr_f[12] = Math.min(255.0f, Math.max(f9, 0.0f)) / 205.93042f;
            arr_f[13] = 0.0f;
            arr_f[14] = 0.0f;
            arr_f[15] = 0.0f;
            arr_f[16] = 0.0f;
            arr_f[17] = 0.0f;
            arr_f[18] = 1.0f;
            arr_f[19] = 0.0f;
            colorMatrix1.set(arr_f);
            colorMatrix0.postConcat(colorMatrix1);
            v1 = 1;
        }
        float f10 = this.d;
        if(f10 == 1.0f) {
            v = v1;
        }
        else {
            arr_f[0] = f10;
            arr_f[1] = 0.0f;
            arr_f[2] = 0.0f;
            arr_f[3] = 0.0f;
            arr_f[4] = 0.0f;
            arr_f[5] = 0.0f;
            arr_f[6] = f10;
            arr_f[7] = 0.0f;
            arr_f[8] = 0.0f;
            arr_f[9] = 0.0f;
            arr_f[10] = 0.0f;
            arr_f[11] = 0.0f;
            arr_f[12] = f10;
            arr_f[13] = 0.0f;
            arr_f[14] = 0.0f;
            arr_f[15] = 0.0f;
            arr_f[16] = 0.0f;
            arr_f[17] = 0.0f;
            arr_f[18] = 1.0f;
            arr_f[19] = 0.0f;
            colorMatrix1.set(arr_f);
            colorMatrix0.postConcat(colorMatrix1);
        }
        if(v != 0) {
            imageView0.setColorFilter(new ColorMatrixColorFilter(colorMatrix0));
            return;
        }
        imageView0.clearColorFilter();
    }
}

