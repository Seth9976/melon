package com.google.android.gms.cast.framework.media.widget;

import android.widget.ImageView;
import com.google.android.gms.cast.framework.media.uicontroller.UIMediaController;

public interface ControlButtonsContainer {
    ImageView getButtonImageViewAt(int arg1);

    int getButtonSlotCount();

    int getButtonTypeAt(int arg1);

    UIMediaController getUIMediaController();
}

