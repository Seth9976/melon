package com.iloen.melon.fragments.comments;

import android.view.View;
import androidx.constraintlayout.widget.Group;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A%\u0010\u0005\u001A\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/constraintlayout/widget/Group;", "Lkotlin/Function1;", "Landroid/view/View;", "Lie/H;", "listener", "setAllOnClickListener", "(Landroidx/constraintlayout/widget/Group;Lwe/k;)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class CommentListRenewalViewHolderKt {
    public static final void setAllOnClickListener(@NotNull Group group0, @NotNull k k0) {
        q.g(group0, "<this>");
        q.g(k0, "listener");
        int[] arr_v = group0.getReferencedIds();
        q.f(arr_v, "getReferencedIds(...)");
        for(int v = 0; v < arr_v.length; ++v) {
            int v1 = arr_v[v];
            View view0 = group0.getRootView().findViewById(v1);
            if(view0 != null) {
                view0.setOnClickListener(new b(k0, 3));
            }
        }
    }

    private static final void setAllOnClickListener$lambda$1$lambda$0(k k0, View view0) {
        k0.invoke(view0);
    }
}

