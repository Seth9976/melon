package com.bumptech.glide.integration.webp;

public class WebpFrameInfo {
    public final boolean blendPreviousFrame;
    public final boolean disposeBackgroundColor;
    public final int duration;
    public final int frameNumber;
    public final int height;
    public final int width;
    public final int xOffset;
    public final int yOffset;

    public WebpFrameInfo(int v, WebpFrame webpFrame0) {
        this.frameNumber = v;
        this.xOffset = webpFrame0.getXOffest();
        this.yOffset = webpFrame0.getYOffest();
        this.width = webpFrame0.getWidth();
        this.height = webpFrame0.getHeight();
        this.duration = webpFrame0.getDurationMs();
        this.blendPreviousFrame = webpFrame0.isBlendWithPreviousFrame();
        this.disposeBackgroundColor = webpFrame0.shouldDisposeToBackgroundColor();
    }

    @Override
    public String toString() {
        return "frameNumber=" + this.frameNumber + ", xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", blendPreviousFrame=" + this.blendPreviousFrame + ", disposeBackgroundColor=" + this.disposeBackgroundColor;
    }
}

