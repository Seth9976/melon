package com.airbnb.lottie.model;

public class Marker {
    private static final String CARRIAGE_RETURN = "\r";
    public final float durationFrames;
    private final String name;
    public final float startFrame;

    public Marker(String s, float f, float f1) {
        this.name = s;
        this.durationFrames = f1;
        this.startFrame = f;
    }

    public float getDurationFrames() {
        return this.durationFrames;
    }

    public String getName() {
        return this.name;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    // 去混淆评级： 低(40)
    public boolean matchesName(String s) {
        return this.name.equalsIgnoreCase(s) ? true : this.name.endsWith("\r") && this.name.substring(0, this.name.length() - 1).equalsIgnoreCase(s);
    }
}

