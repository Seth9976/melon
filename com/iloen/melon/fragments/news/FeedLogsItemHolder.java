package com.iloen.melon.fragments.news;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.I;
import com.iloen.melon.fragments.main.common.ViewableCheckViewHolderForMelonBase;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.viewable.ViewableCheck.Builder;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001A\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0011\u001A\u00020\u000F2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00022\u0006\u0010\r\u001A\u00020\f2\u000E\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u000EH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001A\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001A\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0015\u001A\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001A\u001A\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001DR\u0017\u0010\u001E\u001A\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u0015\u001A\u0004\b\u001F\u0010\u0018R\u0017\u0010!\u001A\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010$R\u0014\u0010%\u001A\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0015¨\u0006&"}, d2 = {"Lcom/iloen/melon/fragments/news/FeedLogsItemHolder;", "Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolderForMelonBase;", "Landroid/view/View;", "view", "Lcom/iloen/melon/fragments/news/OnActionListener;", "onActionListener", "<init>", "(Landroid/view/View;Lcom/iloen/melon/fragments/news/OnActionListener;)V", "Landroidx/fragment/app/I;", "getCurrentFragment", "()Landroidx/fragment/app/I;", "targetView", "", "index", "Lkotlin/Function0;", "Lie/H;", "callback", "addAndStartViewableCheck", "(Landroid/view/View;ILwe/a;)V", "Landroid/widget/ImageView;", "profileDefalutImage", "Landroid/widget/ImageView;", "profileImage", "getProfileImage", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "message", "Landroid/widget/TextView;", "getMessage", "()Landroid/widget/TextView;", "contentImage", "getContentImage", "Landroid/widget/FrameLayout;", "contentGroup", "Landroid/widget/FrameLayout;", "getContentGroup", "()Landroid/widget/FrameLayout;", "contentDefaultImage", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FeedLogsItemHolder extends ViewableCheckViewHolderForMelonBase {
    public static final int $stable = 8;
    @NotNull
    private final ImageView contentDefaultImage;
    @NotNull
    private final FrameLayout contentGroup;
    @NotNull
    private final ImageView contentImage;
    @NotNull
    private final TextView message;
    @NotNull
    private final ImageView profileDefalutImage;
    @NotNull
    private final ImageView profileImage;

    public FeedLogsItemHolder(@NotNull View view0, @Nullable OnActionListener onActionListener0) {
        q.g(view0, "view");
        super(view0);
        View view1 = view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
        q.e(view1, "null cannot be cast to non-null type android.widget.ImageView");
        this.profileDefalutImage = (ImageView)view1;
        View view2 = view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        q.e(view2, "null cannot be cast to non-null type android.widget.ImageView");
        this.profileImage = (ImageView)view2;
        View view3 = view0.findViewById(0x7F0A0C62);  // id:tv_detail
        q.e(view3, "null cannot be cast to non-null type android.widget.TextView");
        this.message = (TextView)view3;
        View view4 = view0.findViewById(0x7F0A069A);  // id:iv_thumb
        q.e(view4, "null cannot be cast to non-null type android.widget.ImageView");
        this.contentImage = (ImageView)view4;
        View view5 = view0.findViewById(0x7F0A0339);  // id:content_layout
        q.f(view5, "findViewById(...)");
        this.contentGroup = (FrameLayout)view5;
        View view6 = view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        q.e(view6, "null cannot be cast to non-null type android.widget.ImageView");
        this.contentDefaultImage = (ImageView)view6;
        Context context0 = view0.getContext();
        if(context0 != null) {
            ViewUtils.setDefaultImage(((ImageView)view1), ScreenUtils.dipToPixel(context0, 44.0f), true);
            ViewUtils.setDefaultImage(((ImageView)view6), ScreenUtils.dipToPixel(context0, 44.0f), false);
            ((ImageView)view2).setContentDescription("프로필");
            ((ImageView)view4).setImportantForAccessibility(2);
        }
        view0.addOnAttachStateChangeListener(this);
        this.setOnImpLogListener(onActionListener0);
    }

    @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder
    public void addAndStartViewableCheck(@Nullable View view0, int v, @Nullable a a0) {
        if(view0 != null && !this.hasViewableCheck(v) && a0 != null) {
            Builder viewableCheck$Builder0 = new Builder(view0);
            viewableCheck$Builder0.setCallback(a0);
            viewableCheck$Builder0.setIgnoreIntersectionChecker(false);
            this.addViewableCheck(v, viewableCheck$Builder0.build());
            if(q.b(this.isForegroundFragment(), Boolean.TRUE)) {
                this.viewableCheckStart(v);
            }
        }
    }

    @NotNull
    public final FrameLayout getContentGroup() {
        return this.contentGroup;
    }

    @NotNull
    public final ImageView getContentImage() {
        return this.contentImage;
    }

    @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder
    @Nullable
    public I getCurrentFragment() {
        return null;
    }

    @NotNull
    public final TextView getMessage() {
        return this.message;
    }

    @NotNull
    public final ImageView getProfileImage() {
        return this.profileImage;
    }
}

