package com.iloen.melon.utils;

import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.types.MelonLinkInfo;
import v9.g;

public interface FamilyApp {
    void openApp();

    void openApp(BannerBase arg1);

    void openApp(BannerBase arg1, g arg2);

    void openApp(MelonLinkInfo arg1);

    void openApp(MelonLinkInfo arg1, g arg2);

    void openApp(String arg1);

    void openApp(String arg1, g arg2);

    void openApp(g arg1);
}

