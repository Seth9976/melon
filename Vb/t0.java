package Vb;

import Pd.i;
import Ub.q;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

public final class t0 {
    public final i a;
    public final q b;
    public final LogU c;
    public final c d;
    public final MutableStateFlow e;
    public final StateFlow f;

    public t0(i i0, q q0) {
        kotlin.jvm.internal.q.g(i0, "appVisibilityManager");
        kotlin.jvm.internal.q.g(q0, "playbackManager");
        super();
        this.a = i0;
        this.b = q0;
        this.c = Companion.create$default(LogU.Companion, "MelonPlayerRules", false, Category.Playback, 2, null);
        this.d = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(new s0(MelonSettingInfo.getPlaybackRetryCount(), MelonSettingInfo.getPlaybackErrorCount(), MelonSettingInfo.isKeepScreenOnDuringPlayback()));
        this.e = mutableStateFlow0;
        this.f = FlowKt.asStateFlow(mutableStateFlow0);
    }
}

