package com.iloen.melon.fragments.tabs;

import Yc.a;
import ad.j;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.I;
import androidx.fragment.app.N0;
import androidx.fragment.app.l0;
import com.iloen.melon.utils.log.LogU;
import ed.Z;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0007\u0018\u0000 32\u00020\u0001:\u000243B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\b2\b\u0010\f\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001A\u00020\u000F¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0019\u001A\u00020\b2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00132\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001B\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ\u0015\u0010 \u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u0002¢\u0006\u0004\b \u0010\u0005J\u000F\u0010!\u001A\u00020\u000FH\u0016¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001A\u00020#2\u0006\u0010\u001B\u001A\u00020\u000F¢\u0006\u0004\b$\u0010%R0\u0010(\u001A\u001E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00060&j\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0006`\'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b*\u0010+R$\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\f\u0010,\u001A\u0004\b-\u0010.\"\u0004\b/\u0010\u000ER\u0011\u00101\u001A\u0002008F¢\u0006\u0006\u001A\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/iloen/melon/fragments/tabs/BottomTabPagerAdapter;", "Landroidx/fragment/app/N0;", "Landroidx/fragment/app/l0;", "fm", "<init>", "(Landroidx/fragment/app/l0;)V", "Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment;", "bottomTabBaseFragment", "Lie/H;", "setBottomTabEventListener", "(Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment;)V", "Lcom/iloen/melon/fragments/tabs/BottomTabPagerAdapter$BottomTabPagerEventListener;", "listener", "setBottomTabPagerEventListener", "(Lcom/iloen/melon/fragments/tabs/BottomTabPagerAdapter$BottomTabPagerEventListener;)V", "", "tabIndex", "getFragment", "(I)Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment;", "Landroid/os/Parcelable;", "saveState", "()Landroid/os/Parcelable;", "state", "Ljava/lang/ClassLoader;", "loader", "restoreState", "(Landroid/os/Parcelable;Ljava/lang/ClassLoader;)V", "position", "Landroidx/fragment/app/I;", "getItem", "(I)Landroidx/fragment/app/I;", "fragmentManager", "restoreBottomTabState", "getCount", "()I", "", "createCacheKey", "(I)Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "bottomTabHashMap", "Ljava/util/HashMap;", "tabFragmentCreatedCnt", "I", "Lcom/iloen/melon/fragments/tabs/BottomTabPagerAdapter$BottomTabPagerEventListener;", "getListener", "()Lcom/iloen/melon/fragments/tabs/BottomTabPagerAdapter$BottomTabPagerEventListener;", "setListener", "", "isAllTabFragmentCreated", "()Z", "Companion", "BottomTabPagerEventListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BottomTabPagerAdapter extends N0 {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/tabs/BottomTabPagerAdapter$BottomTabPagerEventListener;", "", "Lie/H;", "onAllTabFragmentCreated", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface BottomTabPagerEventListener {
        void onAllTabFragmentCreated();
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/tabs/BottomTabPagerAdapter$Companion;", "", "<init>", "()V", "TAG", "", "STATE_SUPER_STATE", "STATE_PAGE_KEY_PREFIX", "itemCount", "", "TAB_MUSIC", "TAB_FORU", "TAB_SEARCH", "TAB_LIBRARY", "TAB_MENU", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String STATE_PAGE_KEY_PREFIX = "bottom_tab_page:";
    @NotNull
    private static final String STATE_SUPER_STATE = "superState";
    public static final int TAB_FORU = 1;
    public static final int TAB_LIBRARY = 3;
    public static final int TAB_MENU = 4;
    public static final int TAB_MUSIC = 0;
    public static final int TAB_SEARCH = 2;
    @NotNull
    public static final String TAG = "BottomTabPagerAdapter";
    @NotNull
    private final HashMap bottomTabHashMap;
    public static final int itemCount = 5;
    @Nullable
    private BottomTabPagerEventListener listener;
    private int tabFragmentCreatedCnt;

    static {
        BottomTabPagerAdapter.Companion = new Companion(null);
        BottomTabPagerAdapter.$stable = 8;
    }

    public BottomTabPagerAdapter(@NotNull l0 l00) {
        q.g(l00, "fm");
        super(l00);
        this.bottomTabHashMap = new HashMap();
    }

    @NotNull
    public final String createCacheKey(int v) {
        return "bottom_tab_page:" + v;
    }

    @Override  // androidx.viewpager.widget.a
    public int getCount() [...] // Inlined contents

    @Nullable
    public final BottomTabBaseFragment getFragment(int v) {
        return (BottomTabBaseFragment)this.bottomTabHashMap.get(v);
    }

    @Override  // androidx.fragment.app.N0
    @NotNull
    public I getItem(int v) {
        I i1;
        I i0 = (BottomTabBaseFragment)this.bottomTabHashMap.get(v);
        if(i0 != null) {
            return i0;
        }
        switch(v) {
            case 0: {
                i1 = new j();
                break;
            }
            case 1: {
                i1 = new Uc.j();
                break;
            }
            case 2: {
                i1 = new Z();
                break;
            }
            case 3: {
                i1 = new a();
                break;
            }
            default: {
                i1 = new Zc.a();
            }
        }
        this.setBottomTabEventListener(((BottomTabBaseFragment)i1));
        this.bottomTabHashMap.put(v, i1);
        return i1;
    }

    @Nullable
    public final BottomTabPagerEventListener getListener() {
        return this.listener;
    }

    public final boolean isAllTabFragmentCreated() {
        return this.tabFragmentCreatedCnt >= 5;
    }

    public final void restoreBottomTabState(@NotNull l0 l00) {
        int v;
        q.g(l00, "fragmentManager");
        List list0 = l00.c.f();
        q.f(list0, "getFragments(...)");
        for(Object object0: list0) {
            I i0 = (I)object0;
            if(i0 instanceof BottomTabBaseFragment) {
                ((BottomTabBaseFragment)i0).restoreState();
                try {
                    if(((BottomTabBaseFragment)i0) instanceof j) {
                        v = 0;
                    }
                    else if(((BottomTabBaseFragment)i0) instanceof Uc.j) {
                        v = 1;
                    }
                    else if(((BottomTabBaseFragment)i0) instanceof Z) {
                        v = 2;
                    }
                    else if(((BottomTabBaseFragment)i0) instanceof a) {
                        v = 3;
                    }
                    else {
                        if(!(((BottomTabBaseFragment)i0) instanceof Zc.a)) {
                            continue;
                        }
                        v = 4;
                    }
                    this.bottomTabHashMap.put(v, i0);
                    ++this.tabFragmentCreatedCnt;
                }
                catch(Exception exception0) {
                    com.iloen.melon.utils.a.v("restoreBottomTabState() - ", exception0.getMessage(), LogU.Companion, "BottomTabPagerAdapter");
                }
            }
        }
    }

    @Override  // androidx.fragment.app.N0
    public void restoreState(@Nullable Parcelable parcelable0, @Nullable ClassLoader classLoader0) {
        Parcelable parcelable1 = null;
        Bundle bundle0 = parcelable0 instanceof Bundle ? ((Bundle)parcelable0) : null;
        if(bundle0 != null) {
            parcelable1 = bundle0.getParcelable("superState");
        }
        super.restoreState(parcelable1, classLoader0);
    }

    @Override  // androidx.fragment.app.N0
    @NotNull
    public Parcelable saveState() {
        Parcelable parcelable0 = super.saveState();
        Parcelable parcelable1 = new Bundle();
        ((Bundle)parcelable1).putParcelable("superState", parcelable0);
        for(int v = 0; v < 5; ++v) {
            BottomTabBaseFragment bottomTabBaseFragment0 = (BottomTabBaseFragment)this.bottomTabHashMap.get(v);
            if(bottomTabBaseFragment0 != null && bottomTabBaseFragment0.getActivity() != null && !bottomTabBaseFragment0.requireActivity().isFinishing() && bottomTabBaseFragment0.isAdded()) {
                this.getFragmentManager().a0(((Bundle)parcelable1), this.createCacheKey(v), bottomTabBaseFragment0);
                if(bottomTabBaseFragment0.isInnerFragmentCreated()) {
                    bottomTabBaseFragment0.saveState();
                }
            }
        }
        return parcelable1;
    }

    private final void setBottomTabEventListener(BottomTabBaseFragment bottomTabBaseFragment0) {
        bottomTabBaseFragment0.setBottomTabEventListener(new BottomTabEventListener() {
            @Override  // com.iloen.melon.fragments.tabs.BottomTabBaseFragment$BottomTabEventListener
            public void onFragmentViewCreated(BottomTabBaseFragment bottomTabBaseFragment0) {
                q.g(bottomTabBaseFragment0, "fragment");
                ++BottomTabPagerAdapter.this.tabFragmentCreatedCnt;
                if(BottomTabPagerAdapter.this.tabFragmentCreatedCnt >= 5) {
                    BottomTabPagerEventListener bottomTabPagerAdapter$BottomTabPagerEventListener0 = BottomTabPagerAdapter.this.getListener();
                    if(bottomTabPagerAdapter$BottomTabPagerEventListener0 != null) {
                        bottomTabPagerAdapter$BottomTabPagerEventListener0.onAllTabFragmentCreated();
                    }
                }
            }
        });
    }

    public final void setBottomTabPagerEventListener(@Nullable BottomTabPagerEventListener bottomTabPagerAdapter$BottomTabPagerEventListener0) {
        this.listener = bottomTabPagerAdapter$BottomTabPagerEventListener0;
    }

    public final void setListener(@Nullable BottomTabPagerEventListener bottomTabPagerAdapter$BottomTabPagerEventListener0) {
        this.listener = bottomTabPagerAdapter$BottomTabPagerEventListener0;
    }
}

