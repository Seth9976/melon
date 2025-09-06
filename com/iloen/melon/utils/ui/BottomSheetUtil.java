package com.iloen.melon.utils.ui;

import androidx.fragment.app.I;
import com.iloen.melon.fragments.MelonBottomSheetBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/utils/ui/BottomSheetUtil;", "", "Landroidx/fragment/app/I;", "fragment", "Lie/H;", "dismissBottomSheetFragment", "(Landroidx/fragment/app/I;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BottomSheetUtil {
    public static final int $stable;
    @NotNull
    public static final BottomSheetUtil INSTANCE;

    static {
        BottomSheetUtil.INSTANCE = new BottomSheetUtil();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final void dismissBottomSheetFragment(@Nullable I i0) {
        if((i0 == null ? null : i0.getParentFragment()) instanceof MelonBottomSheetBaseFragment) {
            I i1 = i0.getParentFragment();
            q.e(i1, "null cannot be cast to non-null type com.iloen.melon.fragments.MelonBottomSheetBaseFragment");
            ((MelonBottomSheetBaseFragment)i1).dismiss();
        }
    }
}

