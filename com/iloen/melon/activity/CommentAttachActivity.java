package com.iloen.melon.activity;

import Ac.Y;
import Ac.j0;
import Ac.u0;
import android.os.Bundle;
import androidx.fragment.app.I;
import b.a;
import java.util.ArrayList;
import kotlin.Metadata;
import l8.m;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001A\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/iloen/melon/activity/CommentAttachActivity;", "Lcom/iloen/melon/activity/PopupFragmentActivity;", "<init>", "()V", "Landroidx/fragment/app/I;", "getAddFragment", "()Landroidx/fragment/app/I;", "addFragment", "Companion", "l8/m", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommentAttachActivity extends PopupFragmentActivity {
    public static final int $stable = 8;
    @NotNull
    public static final String ARG_ATTACH_RESULT_VALUES = "argAttachResultValues";
    @NotNull
    public static final String ARG_COMMENT_ATTACH_TYPE = "argCommentAttachType";
    @NotNull
    public static final String ARG_VIDEO_LINK_PERMIT = "argVideoLinkPermit";
    @NotNull
    public static final m Companion = null;
    @NotNull
    private static final String TAG = "CommentAttachActivity";

    static {
        CommentAttachActivity.Companion = new m();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    @NotNull
    public I getAddFragment() {
        String s = this.getIntent().getStringExtra("argCommentAttachType");
        if(s == null) {
            s = "music_song";
        }
        ArrayList arrayList0 = this.getIntent().getStringArrayListExtra("argVideoLinkPermit");
        if(arrayList0 == null) {
            arrayList0 = new ArrayList();
        }
        if(s.equals("music_song")) {
            return new j0();
        }
        if(s.equals("video")) {
            return new u0();
        }
        I i0 = new Y();
        Bundle bundle0 = new Bundle();
        bundle0.putStringArrayList("argPermit", arrayList0);
        i0.setArguments(bundle0);
        return i0;
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeCancelled() {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeCommitted(I i0, boolean z) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeProgressed(a a0) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeStarted(I i0, boolean z) {
    }
}

