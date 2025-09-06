package v8;

import androidx.lifecycle.K;
import androidx.lifecycle.L;
import androidx.lifecycle.m0;
import com.iloen.melon.MelonAppBase;
import k8.t;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

public abstract class a extends m0 {
    public static final int $stable = 8;
    @NotNull
    private final L _response;
    @NotNull
    private final CoroutineDispatcher ioDispatcher;

    public a() {
        this.ioDispatcher = Dispatchers.getIO();
        this._response = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
    }

    @NotNull
    public final CoroutineDispatcher getIoDispatcher() {
        return this.ioDispatcher;
    }

    @NotNull
    public final K getResponse() {
        return this._response;
    }

    public abstract String getTag();

    @NotNull
    public final L get_response() {
        return this._response;
    }

    @Override  // androidx.lifecycle.m0
    public void onCleared() {
        super.onCleared();
        MelonAppBase.Companion.getClass();
        t.a().getRequestQueue().cancelAll(this.getTag());
    }
}

