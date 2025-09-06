package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradientColorParser implements ValueParser {
    private int colorPoints;

    public GradientColorParser(int v) {
        this.colorPoints = v;
    }

    private GradientColor addOpacityStopsToGradientIfNeeded(GradientColor gradientColor0, List list0) {
        int v = this.colorPoints * 4;
        if(list0.size() <= v) {
            return gradientColor0;
        }
        float[] arr_f = gradientColor0.getPositions();
        int[] arr_v = gradientColor0.getColors();
        int v1 = (list0.size() - v) / 2;
        float[] arr_f1 = new float[v1];
        float[] arr_f2 = new float[v1];
        int v3 = 0;
        while(v < list0.size()) {
            if(v % 2 == 0) {
                arr_f1[v3] = (float)(((Float)list0.get(v)));
            }
            else {
                arr_f2[v3] = (float)(((Float)list0.get(v)));
                ++v3;
            }
            ++v;
        }
        float[] arr_f3 = GradientColorParser.mergeUniqueElements(gradientColor0.getPositions(), arr_f1);
        int[] arr_v1 = new int[arr_f3.length];
        for(int v2 = 0; v2 < arr_f3.length; ++v2) {
            float f = arr_f3[v2];
            int v4 = Arrays.binarySearch(arr_f, f);
            int v5 = Arrays.binarySearch(arr_f1, f);
            if(v4 < 0 || v5 > 0) {
                if(v5 < 0) {
                    v5 = -(v5 + 1);
                }
                arr_v1[v2] = this.getColorInBetweenColorStops(f, arr_f2[v5], arr_f, arr_v);
            }
            else {
                arr_v1[v2] = this.getColorInBetweenOpacityStops(f, arr_v[v4], arr_f1, arr_f2);
            }
        }
        return new GradientColor(arr_f3, arr_v1);
    }

    public int getColorInBetweenColorStops(float f, float f1, float[] arr_f, int[] arr_v) {
        if(arr_v.length >= 2 && f != arr_f[0]) {
            int v = 1;
            while(v < arr_f.length) {
                float f2 = arr_f[v];
                if(f2 < f && v != arr_f.length - 1) {
                    ++v;
                    continue;
                }
                if(v == arr_f.length - 1 && f >= f2) {
                    return Color.argb(((int)(f1 * 255.0f)), Color.red(arr_v[v]), Color.green(arr_v[v]), Color.blue(arr_v[v]));
                }
                float f3 = arr_f[v - 1];
                int v1 = GammaEvaluator.evaluate((f - f3) / (f2 - f3), arr_v[v - 1], arr_v[v]);
                return Color.argb(((int)(f1 * 255.0f)), Color.red(v1), Color.green(v1), Color.blue(v1));
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return arr_v[0];
    }

    private int getColorInBetweenOpacityStops(float f, int v, float[] arr_f, float[] arr_f1) {
        if(arr_f1.length >= 2 && f > arr_f[0]) {
            int v1 = 1;
            while(v1 < arr_f.length) {
                float f1 = arr_f[v1];
                int v2 = Float.compare(f1, f);
                if(v2 < 0 && v1 != arr_f.length - 1) {
                    ++v1;
                    continue;
                }
                if(v2 <= 0) {
                    return Color.argb(((int)(arr_f1[v1] * 255.0f)), Color.red(v), Color.green(v), Color.blue(v));
                }
                float f2 = arr_f[v1 - 1];
                return Color.argb(((int)(MiscUtils.lerp(arr_f1[v1 - 1], arr_f1[v1], (f - f2) / (f1 - f2)) * 255.0f)), Color.red(v), Color.green(v), Color.blue(v));
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return Color.argb(((int)(arr_f1[0] * 255.0f)), Color.red(v), Color.green(v), Color.blue(v));
    }

    public static float[] mergeUniqueElements(float[] arr_f, float[] arr_f1) {
        if(arr_f.length == 0) {
            return arr_f1;
        }
        if(arr_f1.length == 0) {
            return arr_f;
        }
        int v = arr_f.length + arr_f1.length;
        float[] arr_f2 = new float[v];
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        for(int v1 = 0; true; ++v1) {
            float f = NaNf;
            if(v1 >= v) {
                break;
            }
            float f1 = v3 >= arr_f.length ? NaNf : arr_f[v3];
            if(v4 < arr_f1.length) {
                f = arr_f1[v4];
            }
            if(Float.isNaN(f) || f1 < f) {
                arr_f2[v1] = f1;
                ++v3;
            }
            else if(Float.isNaN(f1) || f < f1) {
                arr_f2[v1] = f;
                ++v4;
            }
            else {
                arr_f2[v1] = f1;
                ++v3;
                ++v4;
                ++v2;
            }
        }
        return v2 == 0 ? arr_f2 : Arrays.copyOf(arr_f2, v - v2);
    }

    public GradientColor parse(JsonReader jsonReader0, float f) {
        ArrayList arrayList0 = new ArrayList();
        boolean z = jsonReader0.peek() == Token.BEGIN_ARRAY;
        if(z) {
            jsonReader0.beginArray();
        }
        while(jsonReader0.hasNext()) {
            arrayList0.add(((float)jsonReader0.nextDouble()));
        }
        if(arrayList0.size() == 4 && ((float)(((Float)arrayList0.get(0)))) == 1.0f) {
            arrayList0.set(0, 0.0f);
            arrayList0.add(1.0f);
            arrayList0.add(((Float)arrayList0.get(1)));
            arrayList0.add(((Float)arrayList0.get(2)));
            arrayList0.add(((Float)arrayList0.get(3)));
            this.colorPoints = 2;
        }
        if(z) {
            jsonReader0.endArray();
        }
        if(this.colorPoints == -1) {
            this.colorPoints = arrayList0.size() / 4;
        }
        int v1 = this.colorPoints;
        float[] arr_f = new float[v1];
        int[] arr_v = new int[v1];
        int v2 = 0;
        int v3 = 0;
        for(int v = 0; v < this.colorPoints * 4; ++v) {
            double f1 = (double)(((float)(((Float)arrayList0.get(v)))));
            if(v % 4 != 0) {
                switch(v % 4) {
                    case 1: {
                        v2 = (int)(f1 * 255.0);
                        break;
                    }
                    case 2: {
                        v3 = (int)(f1 * 255.0);
                        break;
                    }
                    case 3: {
                        arr_v[v / 4] = Color.argb(0xFF, v2, v3, ((int)(f1 * 255.0)));
                    }
                }
            }
            else if(v / 4 <= 0 || arr_f[v / 4 - 1] < ((float)f1)) {
                arr_f[v / 4] = (float)f1;
            }
            else {
                arr_f[v / 4] = ((float)f1) + 0.01f;
            }
        }
        return this.addOpacityStopsToGradientIfNeeded(new GradientColor(arr_f, arr_v), arrayList0);
    }

    @Override  // com.airbnb.lottie.parser.ValueParser
    public Object parse(JsonReader jsonReader0, float f) {
        return this.parse(jsonReader0, f);
    }
}

