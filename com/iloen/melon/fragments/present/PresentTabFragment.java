package com.iloen.melon.fragments.present;

import B.a;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.I;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonPagerFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\b\u0007\u0018\u0000 \u001B2\u00020\u0001:\u0002\u001B\u001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001A\u00020\u00158\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001A\u0010\u0019¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentTabFragment;", "Lcom/iloen/melon/fragments/MelonPagerFragment;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/custom/tablayout/TabInfo;", "makeTabInfo", "()Ljava/util/ArrayList;", "tabInfo", "", "position", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "makeTabFragment", "(Lcom/iloen/melon/custom/tablayout/TabInfo;I)Lcom/iloen/melon/fragments/MelonBaseFragment;", "", "TAG", "Ljava/lang/String;", "TAB_RECEIVE", "I", "TAB_SEND", "Companion", "ITEM", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PresentTabFragment extends MelonPagerFragment {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentTabFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/present/PresentTabFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PresentTabFragment newInstance() {
            return new PresentTabFragment();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentTabFragment$ITEM;", "", "<init>", "()V", "PRODUCT", "", "getPRODUCT", "()I", "SONG", "getSONG", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ITEM {
        public static final int $stable;
        @NotNull
        public static final ITEM INSTANCE;
        private static final int PRODUCT;
        private static final int SONG;

        static {
            ITEM.INSTANCE = new ITEM();
            ITEM.SONG = 1;
        }

        public final int getPRODUCT() [...] // 潜在的解密器

        public final int getSONG() [...] // 潜在的解密器
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    private final int TAB_RECEIVE;
    private final int TAB_SEND;
    @NotNull
    private final String TAG;

    static {
        PresentTabFragment.Companion = new Companion(null);
        PresentTabFragment.$stable = 8;
    }

    public PresentTabFragment() {
        this.TAG = "PresentTabFragment";
        this.TAB_SEND = 1;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public I makeTabFragment(TabInfo tabInfo0, int v) {
        return this.makeTabFragment(tabInfo0, v);
    }

    @NotNull
    public MelonBaseFragment makeTabFragment(@NotNull TabInfo tabInfo0, int v) {
        q.g(tabInfo0, "tabInfo");
        return v == this.TAB_RECEIVE ? PresentReceivedListFragment.Companion.newInstance() : PresentSendListFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    @NotNull
    public ArrayList makeTabInfo() {
        ArrayList arrayList0 = new ArrayList();
        String s = this.getActivity() == null ? null : "받은 선물";
        TabInfo tabInfo0 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
        tabInfo0.a = 0;
        tabInfo0.b = s;
        tabInfo0.c = 0;
        tabInfo0.d = null;
        tabInfo0.e = this.TAB_RECEIVE;
        tabInfo0.f = 0;
        tabInfo0.g = 0;
        tabInfo0.h = 0;
        tabInfo0.i = 0x7F080820;  // drawable:selector_dot
        tabInfo0.j = -1.0f;
        tabInfo0.k = -1.0f;
        tabInfo0.l = -1.0f;
        tabInfo0.m = -1.0f;
        tabInfo0.n = 1.0f;
        tabInfo0.o = -1;
        arrayList0.add(tabInfo0);
        String s1 = this.getActivity() == null ? null : "보낸 선물";
        TabInfo tabInfo1 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
        tabInfo1.a = 0;
        tabInfo1.b = s1;
        tabInfo1.c = 0;
        tabInfo1.d = null;
        tabInfo1.e = this.TAB_SEND;
        tabInfo1.f = 0;
        tabInfo1.g = 0;
        tabInfo1.h = 0;
        tabInfo1.i = 0x7F080820;  // drawable:selector_dot
        tabInfo1.j = -1.0f;
        tabInfo1.k = -1.0f;
        tabInfo1.l = -1.0f;
        tabInfo1.m = -1.0f;
        tabInfo1.n = 1.0f;
        tabInfo1.o = -1;
        arrayList0.add(tabInfo1);
        return arrayList0;
    }

    @NotNull
    public static final PresentTabFragment newInstance() {
        return PresentTabFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle((this.getActivity() == null ? null : "선물"));
        }
    }
}

