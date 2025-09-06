package com.iloen.melon.custom;

import android.content.Context;
import android.os.Environment;
import android.util.AttributeSet;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.utils.system.ToastManager;

public class LocalPlaylistCreatingInputBarView extends PlaylistCreatingInputBarView {
    public LocalPlaylistCreatingInputBarView(Context context0) {
        this(context0, null);
    }

    public LocalPlaylistCreatingInputBarView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.isInEditMode();
    }

    @Override  // com.iloen.melon.custom.PlaylistCreatingInputBarView
    public final boolean a() {
        if(!"mounted".equals(Environment.getExternalStorageState())) {
            ToastManager.showShort(0x7F1308DE);  // string:sdcard_donot_add_playlist "내장 메모리가 사용 중일때 플레이리스트를 생성할 수 없습니다."
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.custom.PlaylistCreatingInputBarView
    public MelonLimits.TextLimit getTextLimit() {
        return MelonLimits.TextLimit.e;
    }
}

