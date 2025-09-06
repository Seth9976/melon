package com.kakao.digitalitem.image.lib;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public interface AnimatedItemImageContainer {
    AnimatedItemImage getAnimatedImage();

    int getAnimatedViewHeight();

    int getAnimatedViewWidth();

    Object getAsyncTaskTagObject();

    void playSoundIfSoundEmoticon();

    void setAnimatedImage(AnimatedItemImage arg1);

    void setAsyncTaskTagObject(Object arg1);

    void setBackgroundResource(int arg1);

    void setImageBitmap(Bitmap arg1);

    void setImageDrawable(Drawable arg1);

    void setOnPreparedListener(OnPreparedListener arg1);

    void setPlayMethod(PlayMethod arg1);

    void setSoundPath(String arg1);

    void startAnimation();

    void stopAnimation();
}

