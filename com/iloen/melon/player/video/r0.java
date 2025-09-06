package com.iloen.melon.player.video;

import com.iloen.melon.playback.Playable;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import we.p;

public final class r0 implements p {
    public final VideoViewModel a;

    public r0(VideoViewModel videoViewModel0) {
        this.a = videoViewModel0;
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        MutableStateFlow mutableStateFlow0 = this.a.q;
        boolean z = ((Boolean)object0).booleanValue();
        q.g(((VideoStatus)object1), "videoStatus");
        if(((Playable)object2) != null && ((Playable)object2).isLivePreView()) {
            switch(WhenMappings.$EnumSwitchMapping$0[((VideoStatus)object1).ordinal()]) {
                case 1: {
                    return ((Boolean)mutableStateFlow0.getValue()).booleanValue() ? ControllerStatus.PREVIEW_FULL : ControllerStatus.PREVIEW_FULL_LAND;
                }
                case 2: {
                    if(VideoViewModelKt.isHalfOpened(((FoldingFeatureAndScreenLayout)object3))) {
                        return ControllerStatus.PREVIEW_NORMAL_LAND;
                    }
                    return z ? ControllerStatus.PREVIEW_NORMAL : ControllerStatus.PREVIEW_NORMAL_LAND;
                }
                default: {
                    return ControllerStatus.PREVIEW_NORMAL;
                }
            }
        }
        if(((Playable)object2) != null && ((Playable)object2).isLiveContent()) {
            switch(WhenMappings.$EnumSwitchMapping$0[((VideoStatus)object1).ordinal()]) {
                case 1: {
                    return ((Boolean)mutableStateFlow0.getValue()).booleanValue() ? ControllerStatus.LIVE_FULL : ControllerStatus.LIVE_FULL_LAND;
                }
                case 2: {
                    if(VideoViewModelKt.isHalfOpened(((FoldingFeatureAndScreenLayout)object3))) {
                        return ControllerStatus.LIVE_NORMAL_LAND;
                    }
                    return z ? ControllerStatus.LIVE_NORMAL : ControllerStatus.LIVE_NORMAL_LAND;
                }
                default: {
                    return ControllerStatus.LIVE_NORMAL;
                }
            }
        }
        switch(WhenMappings.$EnumSwitchMapping$0[((VideoStatus)object1).ordinal()]) {
            case 1: {
                return ((Boolean)mutableStateFlow0.getValue()).booleanValue() ? ControllerStatus.VOD_FULL : ControllerStatus.VOD_FULL_LAND;
            }
            case 2: {
                if(VideoViewModelKt.isHalfOpened(((FoldingFeatureAndScreenLayout)object3))) {
                    return ControllerStatus.VOD_NORMAL_LAND;
                }
                return z ? ControllerStatus.VOD_NORMAL : ControllerStatus.VOD_NORMAL_LAND;
            }
            default: {
                return ControllerStatus.VOD_NORMAL;
            }
        }
    }
}

