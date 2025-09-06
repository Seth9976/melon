package com.iloen.melon.fragments.news;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/news/FeedLogsTitleHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FeedLogsTitleHolder extends O0 {
    public static final int $stable = 8;
    @NotNull
    private final TextView title;

    public FeedLogsTitleHolder(@NotNull View view0) {
        q.g(view0, "view");
        super(view0);
        View view1 = view0.findViewById(0x7F0A0B8D);  // id:title
        q.e(view1, "null cannot be cast to non-null type android.widget.TextView");
        this.title = (TextView)view1;
    }

    @NotNull
    public final TextView getTitle() {
        return this.title;
    }
}

