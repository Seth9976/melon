package com.melon.ui;

import Ac.Z1;
import Zc.N;
import android.content.Context;
import androidx.fragment.app.l0;
import com.iloen.melon.playback.playlist.add.AddFailType.AddAllBan;
import com.iloen.melon.playback.playlist.add.AddFailType.MusicWaveOpen;
import com.iloen.melon.playback.playlist.add.AddFailType.SectionRepeatInterrupt;
import com.iloen.melon.playback.playlist.add.AddFailType.ShowNetworkPopup;
import com.iloen.melon.playback.playlist.add.AddFailType.SmartPlaylistAlert;
import com.iloen.melon.playback.playlist.add.AddFailType;
import com.iloen.melon.playback.playlist.add.AddResult.Failure;
import com.iloen.melon.playback.playlist.add.AddResult;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import we.k;

public final class e implements a {
    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, b b0, Context context0, k k0, CoroutineScope coroutineScope0) {
        q.g(l00, "fragmentManager");
        q.g(b0, "event");
        q.g(k0, "sendUserEvent");
        q.g(coroutineScope0, "coroutineScope");
        AddResult addResult0 = b0.a;
        if(addResult0 instanceof Failure) {
            AddFailType addFailType0 = ((Failure)addResult0).getType();
            if(!(addFailType0 instanceof SectionRepeatInterrupt)) {
                com.melon.ui.popup.b b1 = com.melon.ui.popup.b.a;
                if(addFailType0 instanceof SmartPlaylistAlert) {
                    if(context0 != null) {
                        com.melon.ui.popup.b.d(b1, l00, context0.getString(((SmartPlaylistAlert)((Failure)addResult0).getType()).getPopupData().getTitle()), context0.getString(((SmartPlaylistAlert)((Failure)addResult0).getType()).getPopupData().getMsg()), false, false, false, null, null, null, null, null, 2040);
                    }
                }
                else if(addFailType0 instanceof AddAllBan) {
                    if(context0 != null) {
                        com.melon.ui.popup.b.x(l00, context0.getString(((AddAllBan)((Failure)addResult0).getType()).getPopupData().getTitle()), context0.getString(((AddAllBan)((Failure)addResult0).getType()).getPopupData().getMsg()), false, false, "취소", "확인", new N(22, b0, k0), null, null, null, 0xC38);
                    }
                }
                else if(addFailType0 instanceof ShowNetworkPopup) {
                    if(context0 != null) {
                        com.melon.ui.popup.b.d(b1, l00, "안내", ((ShowNetworkPopup)((Failure)addResult0).getType()).getMsg(), false, false, false, null, null, null, null, null, 2040);
                    }
                }
                else if(addFailType0 instanceof MusicWaveOpen) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new d(addResult0, null), 3, null);
                }
            }
            else if(context0 != null) {
                com.melon.ui.popup.b.s(context0, l00, new Z1(20, coroutineScope0, b0, k0), null);
            }
        }
    }
}

