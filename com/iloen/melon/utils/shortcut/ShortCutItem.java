package com.iloen.melon.utils.shortcut;

import android.net.Uri;
import r8.f;

public class ShortCutItem {
    public static final ShortCutItem MELON;
    public static final ShortCutItem MELON_ALARM;
    public static final ShortCutItem MELON_CHART;
    public static final ShortCutItem MELON_DJ;
    public static final ShortCutItem MELON_SEARCH;
    public final int a;
    public final int b;
    public final String c;
    public final Uri d;

    static {
        ShortCutItem.MELON = new ShortCutItem(0x7F130A05, 0x7F0805D1, "id_melon_home", ShortCutItem.a(f.d, "W501"));  // string:shortcut_melon "멜론"
        ShortCutItem.MELON_DJ = new ShortCutItem(0x7F130A08, 0x7F0805D0, "id_melon_dj", ShortCutItem.a(f.p, "W503"));  // string:shortcut_melon_dj "멜론DJ"
        ShortCutItem.MELON_SEARCH = new ShortCutItem(0x7F130A09, 0x7F0805D4, "id_melon_search", ShortCutItem.a(f.q, "W510"));  // string:shortcut_melon_search "음악검색"
        ShortCutItem.MELON_CHART = new ShortCutItem(0x7F130A07, 0x7F0805CF, "id_melon_chart", ShortCutItem.a(f.r, "W512"));  // string:shortcut_melon_chart "멜론차트"
        ShortCutItem.MELON_ALARM = new ShortCutItem(0x7F130A06, 0x7F0805CF, "id_melon_alarm", ShortCutItem.a(f.s, "W513"));  // string:shortcut_melon_alarm "음악알람"
    }

    public ShortCutItem(int v, int v1, String s, Uri uri0) {
        this.a = v;
        this.b = v1;
        this.c = s;
        this.d = uri0;
    }

    public static Uri a(Uri uri0, String s) {
        return uri0.buildUpon().appendQueryParameter("ref", s).build();
    }

    public int getImageId() {
        return this.b;
    }

    public String getShortcutId() {
        return this.c;
    }

    public Uri getShortcutUri() {
        return this.d;
    }

    public int getStringId() {
        return this.a;
    }
}

