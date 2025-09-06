package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.utils.DropShadow;

public interface DrawingContent extends Content {
    void draw(Canvas arg1, Matrix arg2, int arg3, DropShadow arg4);

    void getBounds(RectF arg1, Matrix arg2, boolean arg3);
}

