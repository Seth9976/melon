package com.melon.data.newlogin;

import android.content.Context;
import android.content.SharedPreferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/melon/data/newlogin/KakaoUserIdLocalDataSourceImpl;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class KakaoUserIdLocalDataSourceImpl {
    public final Context a;
    public final MutableStateFlow b;

    @Inject
    public KakaoUserIdLocalDataSourceImpl(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
        SharedPreferences sharedPreferences0 = context0.getSharedPreferences("kakao_session_store", 0);
        this.b = StateFlowKt.MutableStateFlow(((long)(sharedPreferences0 == null ? -1L : sharedPreferences0.getLong("KakaoId", -1L))));
    }
}

