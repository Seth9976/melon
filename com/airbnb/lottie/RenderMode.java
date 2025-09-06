package com.airbnb.lottie;

public enum RenderMode {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    private static RenderMode[] $values() [...] // Inlined contents

    public boolean useSoftwareRendering(int v, boolean z, int v1) {
        switch(this.ordinal()) {
            case 1: {
                return false;
            }
            case 2: {
                return true;
            }
            default: {
                if(z && v < 28) {
                    return true;
                }
                return v1 <= 4 ? v <= 25 : true;
            }
        }
    }
}

