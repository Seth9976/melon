package com.bumptech.glide.request.target;

import U4.x;
import com.bumptech.glide.util.Util;

@Deprecated
public abstract class SimpleTarget extends BaseTarget {
    private final int height;
    private final int width;

    public SimpleTarget() {
        this(0x80000000, 0x80000000);
    }

    public SimpleTarget(int v, int v1) {
        this.width = v;
        this.height = v1;
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void getSize(SizeReadyCallback sizeReadyCallback0) {
        if(Util.isValidDimensions(this.width, this.height)) {
            sizeReadyCallback0.onSizeReady(this.width, this.height);
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        stringBuilder0.append(this.width);
        stringBuilder0.append(" and height: ");
        throw new IllegalArgumentException(x.g(this.height, ", either provide dimensions in the constructor or call override()", stringBuilder0));
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback sizeReadyCallback0) {
    }
}

