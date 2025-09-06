package com.iloen.melon.fragments.settings;

import we.a;

public final class p implements a {
    public final int a;
    public final SettingBannedContentsFragment b;

    public p(SettingBannedContentsFragment settingBannedContentsFragment0, int v) {
        this.a = v;
        this.b = settingBannedContentsFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return GenreItemDecoration.spacingPixel_delegate$lambda$0(this.b);
            }
            case 1: {
                return GenreItemDecoration.lastBottomSpacingPixel_delegate$lambda$1(this.b);
            }
            case 2: {
                return GenreItemDecoration.leftRightEdgeMarginPixel_delegate$lambda$2(this.b);
            }
            case 3: {
                return SettingBannedContentsFragment.arrayFilterText_delegate$lambda$1(this.b);
            }
            case 4: {
                return SettingBannedContentsFragment.itemDecoration_delegate$lambda$2(this.b);
            }
            default: {
                return SettingBannedContentsFragment.arrayBannedExplain_delegate$lambda$0(this.b);
            }
        }
    }
}

