package androidx.car.app;

import U4.x;
import android.view.Surface;

public final class SurfaceContainer {
    private final int mDpi;
    private final int mHeight;
    private final Surface mSurface;
    private final int mWidth;

    private SurfaceContainer() {
        this.mSurface = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDpi = 0;
    }

    public SurfaceContainer(Surface surface0, int v, int v1, int v2) {
        this.mSurface = surface0;
        this.mWidth = v;
        this.mHeight = v1;
        this.mDpi = v2;
    }

    public int getDpi() {
        return this.mDpi;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public int getWidth() {
        return this.mWidth;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[");
        stringBuilder0.append(this.mSurface);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.mWidth);
        stringBuilder0.append("x");
        stringBuilder0.append(this.mHeight);
        stringBuilder0.append(", dpi: ");
        return x.g(this.mDpi, "]", stringBuilder0);
    }
}

