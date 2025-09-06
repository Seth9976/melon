package com.iloen.melon.custom.tablayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/custom/tablayout/MainTabView;", "Lcom/iloen/melon/custom/tablayout/TabView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MainTabView extends TabView {
    public MainTabView(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
    }

    @Override  // com.iloen.melon.custom.tablayout.TabView
    public final void c(boolean z) {
        View view0 = this.c;
        q.f(view0, "mLeftPadding");
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams viewGroup$LayoutParams1 = this.j.getLayoutParams();
        if(!z || this.getId() != 0) {
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).width = this.getResources().getDimensionPixelSize(0x7F0702C9);  // dimen:main_scroll_tab_item_default_padding
            viewGroup$LayoutParams1.width = this.getResources().getDimensionPixelSize(0x7F0702CD);  // dimen:main_scroll_tab_item_unselected_dot_width
            this.j.setPadding(0, 0, 0, 0);
        }
        else {
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).width = this.getResources().getDimensionPixelSize(0x7F0702CA);  // dimen:main_scroll_tab_item_dot_padding
            viewGroup$LayoutParams1.width = this.getResources().getDimensionPixelSize(0x7F0702CC);  // dimen:main_scroll_tab_item_selected_dot_width
            this.j.setPadding(this.getResources().getDimensionPixelSize(0x7F0702CB), 0, 0, 0);  // dimen:main_scroll_tab_item_selected_dot_padding
        }
        view0.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));
        view0.requestLayout();
        ViewUtils.showWhen(this.k, z);
        this.requestLayout();
    }
}

