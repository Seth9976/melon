package com.airbnb.lottie.model.content;

import S1.a;

public enum LBlendMode {
    NORMAL,
    MULTIPLY,
    SCREEN,
    OVERLAY,
    DARKEN,
    LIGHTEN,
    COLOR_DODGE,
    COLOR_BURN,
    HARD_LIGHT,
    SOFT_LIGHT,
    DIFFERENCE,
    EXCLUSION,
    HUE,
    SATURATION,
    COLOR,
    LUMINOSITY,
    ADD,
    HARD_MIX;

    private static LBlendMode[] $values() [...] // Inlined contents

    public a toNativeBlendMode() {
        switch(this.ordinal()) {
            case 1: {
                return a.c;
            }
            case 2: {
                return a.d;
            }
            case 3: {
                return a.e;
            }
            case 4: {
                return a.f;
            }
            case 5: {
                return a.g;
            }
            case 16: {
                return a.b;
            }
            default: {
                return null;
            }
        }
    }
}

