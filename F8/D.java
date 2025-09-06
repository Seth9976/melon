package F8;

import android.app.Activity;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.utils.log.LogU;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler.Key;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import me.a;
import me.i;

public final class d extends a implements CoroutineExceptionHandler {
    public final Activity b;

    public d(Key coroutineExceptionHandler$Key0, MusicBrowserActivity musicBrowserActivity0) {
        this.b = musicBrowserActivity0;
        super(coroutineExceptionHandler$Key0);
    }

    @Override  // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(i i0, Throwable throwable0) {
        LogU.Companion.d("TitleBar", "delegateAccessibilityFocus() " + throwable0.getMessage());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new e(this.b, null), 3, null);
    }
}

