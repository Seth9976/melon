package com.kakao.emoticon.controller;

import com.kakao.emoticon.net.response.ItemSubType;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
public final class EmoticonResourceLoader.WhenMappings {
    public static final int[] $EnumSwitchMapping$0;

    static {
        int[] arr_v = new int[ItemSubType.values().length];
        EmoticonResourceLoader.WhenMappings.$EnumSwitchMapping$0 = arr_v;
        arr_v[ItemSubType.EMOTICON.ordinal()] = 1;
        arr_v[ItemSubType.SOUND_EMOTICON.ordinal()] = 2;
        arr_v[ItemSubType.ANIMATED_STICKER.ordinal()] = 3;
        arr_v[ItemSubType.SOUND_STICKER.ordinal()] = 4;
        arr_v[ItemSubType.STICKER.ordinal()] = 5;
    }
}

