package Q0;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.provider.Settings.Global;
import android.view.View;
import androidx.compose.runtime.s;
import h7.u0;
import java.util.LinkedHashMap;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted.Companion;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

public abstract class q1 {
    public static final LinkedHashMap a;

    static {
        q1.a = new LinkedHashMap();
    }

    public static final StateFlow a(Context context0) {
        LinkedHashMap linkedHashMap0 = q1.a;
        synchronized(linkedHashMap0) {
            StateFlow stateFlow0 = linkedHashMap0.get(context0);
            if(stateFlow0 == null) {
                ContentResolver contentResolver0 = context0.getContentResolver();
                Uri uri0 = Settings.Global.getUriFor("animator_duration_scale");
                Channel channel0 = ChannelKt.Channel$default(-1, null, null, 6, null);
                stateFlow0 = FlowKt.stateIn(FlowKt.flow(new o1(contentResolver0, uri0, new p1(channel0, u0.s(Looper.getMainLooper())), channel0, context0, null)), CoroutineScopeKt.MainScope(), Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), Settings.Global.getFloat(context0.getContentResolver(), "animator_duration_scale", 1.0f));
                linkedHashMap0.put(context0, stateFlow0);
            }
            return stateFlow0;
        }
    }

    public static final s b(View view0) {
        Object object0 = view0.getTag(0x7F0A009E);  // id:androidx_compose_ui_view_composition_context
        return object0 instanceof s ? ((s)object0) : null;
    }
}

