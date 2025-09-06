package com.iloen.melon.fragments;

import android.os.Bundle;

public interface FragmentStack extends CacheTag {
    boolean excludingTagArguments();

    String getFragmentTag();

    boolean isAppEntryPointFragment();

    boolean isBringToFrontFragment();

    boolean isPlayerFragment();

    boolean isPlaylistFragment();

    boolean isTopLevelFragment();

    void onNewArguments(Bundle arg1);

    boolean shouldOnResume();
}

