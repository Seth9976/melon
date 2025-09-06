package com.iloen.melon.fragments.shortform;

import android.text.TextUtils;
import androidx.fragment.app.I;
import com.iloen.melon.popup.LikeAnimationPopup;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.task.request.LikeUpdateAsyncTask;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ToastManager;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.o;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendUtils;", "", "<init>", "()V", "Landroidx/fragment/app/I;", "fragment", "", "contsId", "contsTypeCode", "", "isLike", "menuId", "Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$OnJobFinishListener;", "listener", "Lie/H;", "updateLike", "(Landroidx/fragment/app/I;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$OnJobFinishListener;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TrendUtils {
    public static final int $stable;
    @NotNull
    public static final TrendUtils INSTANCE;

    static {
        TrendUtils.INSTANCE = new TrendUtils();
    }

    public static final void updateLike(@NotNull I i0, @Nullable String s, @NotNull String s1, boolean z, @Nullable String s2, @Nullable OnJobFinishListener likeUpdateAsyncTask$OnJobFinishListener0) {
        q.g(i0, "fragment");
        q.g(s1, "contsTypeCode");
        if(TextUtils.isEmpty(s) || TextUtils.isEmpty(s1)) {
            return;
        }
        if(!NetUtils.isConnected()) {
            ToastManager.show(0x7F1303DA);  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
            return;
        }
        if(!((e0)o.a()).m()) {
            ToastManager.show(0x7F13057D);  // string:main_more_menu_login_text "로그인 해주세요."
            return;
        }
        if(z && !q.b("N10022", s1)) {
            new LikeAnimationPopup(i0.requireActivity()).show();
        }
        q.f("N20001", "value");
        q.d(s);
        LikeUpdateAsyncTask likeUpdateAsyncTask0 = new LikeUpdateAsyncTask("N20001", s, s1, z, s2, "");
        likeUpdateAsyncTask0.setOnJobFinishListener(likeUpdateAsyncTask$OnJobFinishListener0);
        likeUpdateAsyncTask0.execute(null);
    }

    public static void updateLike$default(I i0, String s, String s1, boolean z, String s2, OnJobFinishListener likeUpdateAsyncTask$OnJobFinishListener0, int v, Object object0) {
        if((v & 0x20) != 0) {
            likeUpdateAsyncTask$OnJobFinishListener0 = null;
        }
        TrendUtils.updateLike(i0, s, s1, z, s2, likeUpdateAsyncTask$OnJobFinishListener0);
    }
}

