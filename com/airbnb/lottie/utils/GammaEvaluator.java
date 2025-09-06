package com.airbnb.lottie.utils;

public class GammaEvaluator {
    private static float EOCF_sRGB(float f) {
        return f <= 0.04045f ? f / 12.92f : ((float)Math.pow((f + 0.055f) / 1.055f, 2.4));
    }

    private static float OECF_sRGB(float f) {
        return f <= 0.003131f ? f * 12.92f : ((float)(Math.pow(f, 0.416667) * 1.055 - 0.055));
    }

    public static int evaluate(float f, int v, int v1) {
        if(v == v1 || f <= 0.0f) {
            return v;
        }
        if(f >= 1.0f) {
            return v1;
        }
        float f1 = ((float)(v >> 24 & 0xFF)) / 255.0f;
        float f2 = GammaEvaluator.EOCF_sRGB(((float)(v >> 16 & 0xFF)) / 255.0f);
        float f3 = GammaEvaluator.EOCF_sRGB(((float)(v >> 8 & 0xFF)) / 255.0f);
        float f4 = GammaEvaluator.EOCF_sRGB(((float)(v & 0xFF)) / 255.0f);
        return Math.round(GammaEvaluator.OECF_sRGB((GammaEvaluator.EOCF_sRGB(((float)(v1 & 0xFF)) / 255.0f) - f4) * f + f4) * 255.0f) | (Math.round(GammaEvaluator.OECF_sRGB((GammaEvaluator.EOCF_sRGB(((float)(v1 >> 16 & 0xFF)) / 255.0f) - f2) * f + f2) * 255.0f) << 16 | Math.round(((((float)(v1 >> 24 & 0xFF)) / 255.0f - f1) * f + f1) * 255.0f) << 24 | Math.round(GammaEvaluator.OECF_sRGB((GammaEvaluator.EOCF_sRGB(((float)(v1 >> 8 & 0xFF)) / 255.0f) - f3) * f + f3) * 255.0f) << 8);
    }
}

