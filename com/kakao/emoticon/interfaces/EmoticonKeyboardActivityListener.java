package com.kakao.emoticon.interfaces;

import android.content.res.Configuration;

public interface EmoticonKeyboardActivityListener {
    void onConfigurationChanged(Configuration arg1);

    void onDestroy();

    void onPause();

    void onResume();
}

