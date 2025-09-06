package com.kakao.emoticon.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q0;
import androidx.recyclerview.widget.w0;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.databinding.EmoticonSectionViewBinding;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.interfaces.EmoticonLoginClickListener;
import com.kakao.emoticon.interfaces.EmoticonUpdateListener;
import com.kakao.emoticon.net.EmoticonApiError;
import com.kakao.emoticon.net.response.Emoticon;
import com.kakao.emoticon.ui.EmoticonSectionView;
import com.kakao.emoticon.ui.EmoticonViewPagerCoordinator;
import com.kakao.emoticon.ui.GuideView;
import com.kakao.emoticon.ui.tab.DefaultItem;
import com.kakao.emoticon.ui.tab.EmoticonTabAdapter;
import com.kakao.emoticon.ui.tab.EmoticonTabItem;
import com.kakao.emoticon.ui.tab.ExpiredItem.OnItemRemoveListener;
import com.kakao.emoticon.ui.tab.ExpiredItem;
import com.kakao.emoticon.ui.tab.LoginItem;
import com.kakao.emoticon.ui.tab.SettingItem;
import com.kakao.emoticon.ui.tab.StoreItem;
import com.kakao.emoticon.ui.tab.TabItemTouchController;
import com.kakao.emoticon.ui.tab.TabItemTouchHelperCallback;
import com.kakao.emoticon.ui.tab.TabTouchListener;
import com.kakao.emoticon.ui.widget.EmptyRetryView;
import com.kakao.emoticon.util.ActionTracker;
import com.kakao.emoticon.util.IntentUtils;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\u00AA\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001YB\u001B\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001A\u00020\u000B2\b\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010\n\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E\u00A2\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001A\u00020\u000B\u00A2\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001A\u00020\u000B\u00A2\u0006\u0004\b\u0014\u0010\u0013J\r\u0010\u0015\u001A\u00020\u000B\u00A2\u0006\u0004\b\u0015\u0010\u0013J\r\u0010\u0016\u001A\u00020\u000B\u00A2\u0006\u0004\b\u0016\u0010\u0013J\u000F\u0010\u0017\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0013J\u000F\u0010\u0018\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0013J\u000F\u0010\u0019\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u0019\u0010\u0013J\u000F\u0010\u001A\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u001A\u0010\u0013J\u0015\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001BH\u0002\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u001F\u0010\u0013J\u000F\u0010 \u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b \u0010\u0013J\u000F\u0010!\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b!\u0010\u0013J\u000F\u0010\"\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\"\u0010\u0013J\u0017\u0010%\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020#H\u0002\u00A2\u0006\u0004\b%\u0010&R\u0018\u0010\'\u001A\u0004\u0018\u00010\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\'\u0010(R\u0018\u0010)\u001A\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001A\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b+\u0010*R\u001A\u0010-\u001A\b\u0012\u0004\u0012\u00020\u001C0,8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001A\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001A\u0002028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001A\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001A\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001A\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001A\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001A\u00020#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001A\u00020#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010BR\u0018\u0010E\u001A\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001A\u00020G8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001A\u00020J8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001A\u00020M8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001A\u00020P8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0003\u0010SR\u0018\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0005\u0010TR\u0013\u0010X\u001A\u0004\u0018\u00010U8F\u00A2\u0006\u0006\u001A\u0004\bV\u0010W\u00A8\u0006Z"}, d2 = {"Lcom/kakao/emoticon/controller/EmoticonSectionViewController;", "", "Landroid/content/Context;", "mContext", "Lcom/kakao/emoticon/interfaces/EmoticonClickListener;", "mEmoticonClickListener", "<init>", "(Landroid/content/Context;Lcom/kakao/emoticon/interfaces/EmoticonClickListener;)V", "", "message", "buttonText", "Lie/H;", "setLoginText", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/kakao/emoticon/interfaces/EmoticonLoginClickListener;", "loginClickListener", "setLoginClickListener", "(Lcom/kakao/emoticon/interfaces/EmoticonLoginClickListener;)V", "onDestroy", "()V", "onViewAppear", "onConfigurationChanged", "hideContentView", "initializeViews", "initDataOnBackground", "syncEmoticons", "reloadEmoticonTabs", "", "Lcom/kakao/emoticon/ui/tab/EmoticonTabItem;", "loadTabItems", "()Ljava/util/List;", "keyboardUpdateIfNeeded", "showEmptyView", "hideEmptyView", "showGuideViewIfNeeded", "", "animate", "hideGuideView", "(Z)V", "mLoginClickListener", "Lcom/kakao/emoticon/interfaces/EmoticonLoginClickListener;", "loginMessage", "Ljava/lang/String;", "loginButtonText", "", "emoticonTabItems", "Ljava/util/List;", "Lcom/kakao/emoticon/ui/GuideView;", "guideView", "Lcom/kakao/emoticon/ui/GuideView;", "Lcom/kakao/emoticon/ui/tab/EmoticonTabAdapter;", "tabAdapter", "Lcom/kakao/emoticon/ui/tab/EmoticonTabAdapter;", "Lcom/kakao/emoticon/ui/EmoticonViewPagerCoordinator;", "emoticonViewPagerCoordinator", "Lcom/kakao/emoticon/ui/EmoticonViewPagerCoordinator;", "Landroidx/recyclerview/widget/O;", "itemTouchHelper", "Landroidx/recyclerview/widget/O;", "Lcom/kakao/emoticon/ui/tab/TabItemTouchHelperCallback;", "tabTouchCallback", "Lcom/kakao/emoticon/ui/tab/TabItemTouchHelperCallback;", "Lcom/kakao/emoticon/ui/tab/TabTouchListener;", "tabTouchListener", "Lcom/kakao/emoticon/ui/tab/TabTouchListener;", "isDestroy", "Z", "isInitDataOnBackground", "Lcom/kakao/emoticon/databinding/EmoticonSectionViewBinding;", "binding", "Lcom/kakao/emoticon/databinding/EmoticonSectionViewBinding;", "Lcom/kakao/emoticon/controller/EmoticonManager$EmoticonCallback;", "emoticonCallback", "Lcom/kakao/emoticon/controller/EmoticonManager$EmoticonCallback;", "Lcom/kakao/emoticon/ui/tab/ExpiredItem$OnItemRemoveListener;", "expireRemoveListener", "Lcom/kakao/emoticon/ui/tab/ExpiredItem$OnItemRemoveListener;", "Lcom/kakao/emoticon/controller/EmoticonSectionViewController$ViewEventListener;", "viewEventListener", "Lcom/kakao/emoticon/controller/EmoticonSectionViewController$ViewEventListener;", "Lcom/kakao/emoticon/interfaces/EmoticonUpdateListener;", "emoticonUpdateListener", "Lcom/kakao/emoticon/interfaces/EmoticonUpdateListener;", "Landroid/content/Context;", "Lcom/kakao/emoticon/interfaces/EmoticonClickListener;", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "contentView", "ViewEventListener", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonSectionViewController {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000F\u0010\n\u001A\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004¨\u0006\u000B"}, d2 = {"Lcom/kakao/emoticon/controller/EmoticonSectionViewController$ViewEventListener;", "", "Lie/H;", "onReloadClicked", "()V", "", "hasWindowFocus", "onWindowFocusChanged", "(Z)V", "onRootViewAttached", "onRootViewDetached", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
    public interface ViewEventListener {
        void onReloadClicked();

        void onRootViewAttached();

        void onRootViewDetached();

        void onWindowFocusChanged(boolean arg1);
    }

    private EmoticonSectionViewBinding binding;
    private final EmoticonCallback emoticonCallback;
    private final List emoticonTabItems;
    private final EmoticonUpdateListener emoticonUpdateListener;
    private EmoticonViewPagerCoordinator emoticonViewPagerCoordinator;
    private final OnItemRemoveListener expireRemoveListener;
    private GuideView guideView;
    private boolean isDestroy;
    private boolean isInitDataOnBackground;
    private O itemTouchHelper;
    private String loginButtonText;
    private String loginMessage;
    private Context mContext;
    private EmoticonClickListener mEmoticonClickListener;
    private EmoticonLoginClickListener mLoginClickListener;
    private EmoticonTabAdapter tabAdapter;
    private TabItemTouchHelperCallback tabTouchCallback;
    private TabTouchListener tabTouchListener;
    private final ViewEventListener viewEventListener;

    public EmoticonSectionViewController(@Nullable Context context0, @Nullable EmoticonClickListener emoticonClickListener0) {
        this.mContext = context0;
        this.mEmoticonClickListener = emoticonClickListener0;
        this.emoticonTabItems = new ArrayList();
        this.tabAdapter = new EmoticonTabAdapter();
        this.emoticonCallback = new EmoticonCallback() {
            @Override  // com.kakao.emoticon.controller.EmoticonManager$EmoticonCallback
            public void onFailure(@NotNull EmoticonApiError emoticonApiError0) {
                q.g(emoticonApiError0, "errorResult");
                if(EmoticonSectionViewController.access$isDestroy$p(EmoticonSectionViewController.this)) {
                    return;
                }
                if(EmoticonManager.INSTANCE.getAllEmoticonList().isEmpty()) {
                    EmoticonSectionViewController.access$showEmptyView(EmoticonSectionViewController.this);
                    return;
                }
                EmoticonSectionViewController.access$reloadEmoticonTabs(EmoticonSectionViewController.this);
                EmoticonSectionViewController.access$hideEmptyView(EmoticonSectionViewController.this);
            }

            @Override  // com.kakao.emoticon.controller.EmoticonManager$EmoticonCallback
            public void onSuccess() {
                if(EmoticonSectionViewController.access$isDestroy$p(EmoticonSectionViewController.this)) {
                    return;
                }
                EmoticonSectionViewController.access$hideEmptyView(EmoticonSectionViewController.this);
                EmoticonSectionViewController.access$reloadEmoticonTabs(EmoticonSectionViewController.this);
            }
        };
        this.expireRemoveListener = new OnItemRemoveListener() {
            @Override  // com.kakao.emoticon.ui.tab.ExpiredItem$OnItemRemoveListener
            public final void onRemove(String s) {
                EmoticonSectionViewController.access$getTabAdapter$p(EmoticonSectionViewController.this).onItemDismiss(s);
            }
        };
        this.viewEventListener = new ViewEventListener() {
            @Override  // com.kakao.emoticon.controller.EmoticonSectionViewController$ViewEventListener
            public void onReloadClicked() {
                EmoticonSectionViewController.access$syncEmoticons(EmoticonSectionViewController.this);
            }

            @Override  // com.kakao.emoticon.controller.EmoticonSectionViewController$ViewEventListener
            public void onRootViewAttached() {
                EmoticonManager.INSTANCE.setEmoticonUpdateListener(EmoticonSectionViewController.access$getEmoticonUpdateListener$p(EmoticonSectionViewController.this));
                EmoticonSectionViewController.access$keyboardUpdateIfNeeded(EmoticonSectionViewController.this);
            }

            @Override  // com.kakao.emoticon.controller.EmoticonSectionViewController$ViewEventListener
            public void onRootViewDetached() {
                if(EmoticonSectionViewController.access$getGuideView$p(EmoticonSectionViewController.this) != null) {
                    EmoticonPreference emoticonPreference0 = EmoticonPreference.getInstance();
                    q.f(emoticonPreference0, "EmoticonPreference.getInstance()");
                    emoticonPreference0.setNormalCPGuideOnceDisplayed(true);
                    EmoticonSectionViewController.access$hideGuideView(EmoticonSectionViewController.this, false);
                }
            }

            @Override  // com.kakao.emoticon.controller.EmoticonSectionViewController$ViewEventListener
            public void onWindowFocusChanged(boolean z) {
                if(z) {
                    EmoticonSectionViewController.access$keyboardUpdateIfNeeded(EmoticonSectionViewController.this);
                }
            }
        };
        this.emoticonUpdateListener = new EmoticonUpdateListener() {
            @Override  // com.kakao.emoticon.interfaces.EmoticonUpdateListener
            public final void onSessionUpdated() {
                if(!EmoticonSectionViewController.access$isDestroy$p(EmoticonSectionViewController.this)) {
                    EmoticonSectionViewController.access$syncEmoticons(EmoticonSectionViewController.this);
                }
            }
        };
    }

    public static final EmoticonUpdateListener access$getEmoticonUpdateListener$p(EmoticonSectionViewController emoticonSectionViewController0) {
        return emoticonSectionViewController0.emoticonUpdateListener;
    }

    public static final GuideView access$getGuideView$p(EmoticonSectionViewController emoticonSectionViewController0) {
        return emoticonSectionViewController0.guideView;
    }

    public static final void access$hideEmptyView(EmoticonSectionViewController emoticonSectionViewController0) {
        emoticonSectionViewController0.hideEmptyView();
    }

    public static final void access$keyboardUpdateIfNeeded(EmoticonSectionViewController emoticonSectionViewController0) {
        emoticonSectionViewController0.keyboardUpdateIfNeeded();
    }

    public static final void access$reloadEmoticonTabs(EmoticonSectionViewController emoticonSectionViewController0) {
        emoticonSectionViewController0.reloadEmoticonTabs();
    }

    public static final void access$setBinding$p(EmoticonSectionViewController emoticonSectionViewController0, EmoticonSectionViewBinding emoticonSectionViewBinding0) {
        emoticonSectionViewController0.binding = emoticonSectionViewBinding0;
    }

    public static final void access$setDestroy$p(EmoticonSectionViewController emoticonSectionViewController0, boolean z) {
        emoticonSectionViewController0.isDestroy = z;
    }

    public static final void access$setEmoticonViewPagerCoordinator$p(EmoticonSectionViewController emoticonSectionViewController0, EmoticonViewPagerCoordinator emoticonViewPagerCoordinator0) {
        emoticonSectionViewController0.emoticonViewPagerCoordinator = emoticonViewPagerCoordinator0;
    }

    public static final void access$setGuideView$p(EmoticonSectionViewController emoticonSectionViewController0, GuideView guideView0) {
        emoticonSectionViewController0.guideView = guideView0;
    }

    public static final void access$setMContext$p(EmoticonSectionViewController emoticonSectionViewController0, Context context0) {
        emoticonSectionViewController0.mContext = context0;
    }

    public static final void access$setTabAdapter$p(EmoticonSectionViewController emoticonSectionViewController0, EmoticonTabAdapter emoticonTabAdapter0) {
        emoticonSectionViewController0.tabAdapter = emoticonTabAdapter0;
    }

    public static final void access$showEmptyView(EmoticonSectionViewController emoticonSectionViewController0) {
        emoticonSectionViewController0.showEmptyView();
    }

    public static final void access$syncEmoticons(EmoticonSectionViewController emoticonSectionViewController0) {
        emoticonSectionViewController0.syncEmoticons();
    }

    @Nullable
    public final View getContentView() {
        if(this.binding == null) {
            this.initializeViews();
        }
        EmoticonSectionViewBinding emoticonSectionViewBinding0 = this.binding;
        if(emoticonSectionViewBinding0 != null) {
            EmoticonSectionView emoticonSectionView0 = emoticonSectionViewBinding0.getRoot();
            if(emoticonSectionView0 != null) {
                emoticonSectionView0.setVisibility(0);
            }
        }
        EmoticonSectionViewBinding emoticonSectionViewBinding1 = this.binding;
        return emoticonSectionViewBinding1 != null ? emoticonSectionViewBinding1.getRoot() : null;
    }

    public final void hideContentView() {
        EmoticonSectionViewBinding emoticonSectionViewBinding0 = this.binding;
        if(emoticonSectionViewBinding0 != null) {
            EmoticonSectionView emoticonSectionView0 = emoticonSectionViewBinding0.getRoot();
            if(emoticonSectionView0 != null) {
                emoticonSectionView0.setVisibility(4);
            }
        }
    }

    private final void hideEmptyView() {
        EmoticonSectionViewBinding emoticonSectionViewBinding0 = this.binding;
        if(emoticonSectionViewBinding0 != null) {
            EmptyRetryView emptyRetryView0 = emoticonSectionViewBinding0.empty;
            if(emptyRetryView0 != null) {
                emptyRetryView0.setVisibility(8);
            }
        }
    }

    private final void hideGuideView(boolean z) {
        GuideView guideView0 = this.guideView;
        if(guideView0 != null) {
            guideView0.hideWithAnimation(z);
        }
        EmoticonSectionViewBinding emoticonSectionViewBinding0 = this.binding;
        if(emoticonSectionViewBinding0 != null) {
            RecyclerView recyclerView0 = emoticonSectionViewBinding0.tabRecyclerview;
            if(recyclerView0 != null) {
                recyclerView0.setVisibility(0);
            }
        }
        EmoticonSectionViewBinding emoticonSectionViewBinding1 = this.binding;
        if(emoticonSectionViewBinding1 != null) {
            View view0 = emoticonSectionViewBinding1.vBottomLine;
            if(view0 != null) {
                view0.setVisibility(0);
            }
        }
    }

    private final void initDataOnBackground() {
        EmoticonManager.INSTANCE.init(this.emoticonCallback);
    }

    private final void initializeViews() {
        EmoticonSectionViewBinding emoticonSectionViewBinding0 = EmoticonSectionViewBinding.inflate(LayoutInflater.from(this.mContext));
        emoticonSectionViewBinding0.getRoot().setViewEventListener(this.viewEventListener);
        emoticonSectionViewBinding0.empty.setViewEventListener(this.viewEventListener);
        emoticonSectionViewBinding0.tabRecyclerview.setHasFixedSize(true);
        TabTouchListener tabTouchListener0 = new TabTouchListener(emoticonSectionViewBinding0.keyboardViewpager);
        emoticonSectionViewBinding0.tabRecyclerview.addOnItemTouchListener(tabTouchListener0);
        q.f(emoticonSectionViewBinding0.tabRecyclerview, "tabRecyclerview");
        com.kakao.emoticon.controller.EmoticonSectionViewController.initializeViews..inlined.apply.lambda.1 emoticonSectionViewController$initializeViews$$inlined$apply$lambda$10 = new LinearLayoutManager(false, emoticonSectionViewBinding0) {
            @Override  // androidx.recyclerview.widget.LinearLayoutManager
            public boolean canScrollHorizontally() {
                return !this.mContext.isContentViewTouch();
            }
        };
        emoticonSectionViewBinding0.tabRecyclerview.setLayoutManager(emoticonSectionViewController$initializeViews$$inlined$apply$lambda$10);
        this.tabTouchListener = tabTouchListener0;
        q.f(emoticonSectionViewBinding0.tabRecyclerview, "tabRecyclerview");
        q0 q00 = emoticonSectionViewBinding0.tabRecyclerview.getItemAnimator();
        if(q00 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        }
        ((androidx.recyclerview.widget.q)q00).g = false;
        this.tabAdapter.setHasStableIds(true);
        q.f(emoticonSectionViewBinding0.tabRecyclerview, "tabRecyclerview");
        emoticonSectionViewBinding0.tabRecyclerview.setAdapter(this.tabAdapter);
        this.emoticonViewPagerCoordinator = new EmoticonViewPagerCoordinator(this.mContext, this.mEmoticonClickListener, emoticonSectionViewBinding0.keyboardViewpager, emoticonSectionViewBinding0.tabRecyclerview, this.tabAdapter);
        this.binding = emoticonSectionViewBinding0;
    }

    // 去混淆评级： 中等(70)
    private final void keyboardUpdateIfNeeded() {
    }

    private final List loadTabItems() {
        this.emoticonTabItems.clear();
        List list0 = EmoticonManager.INSTANCE.getEmoticonList(true);
        stringBuilder0.toString();
        for(Object object0: list0) {
            Emoticon emoticon0 = (Emoticon)object0;
            if(emoticon0.showAsExpiredItemView()) {
                ExpiredItem expiredItem0 = new ExpiredItem(emoticon0, this.expireRemoveListener);
                this.emoticonTabItems.add(expiredItem0);
            }
            else {
                DefaultItem defaultItem0 = new DefaultItem(emoticon0, this.mEmoticonClickListener);
                this.emoticonTabItems.add(defaultItem0);
            }
        }
        if(KakaoEmoticon.isEnabledLoginTab() && !KakaoEmoticon.isConnectedAccount()) {
            LoginItem loginItem0 = new LoginItem(this.mLoginClickListener, this.loginMessage, this.loginButtonText);
            this.emoticonTabItems.add(loginItem0);
        }
        if(KakaoEmoticon.isConnectedAccount()) {
            SettingItem settingItem0 = new SettingItem();
            this.emoticonTabItems.add(settingItem0);
        }
        if(KakaoEmoticon.isConnectedAccount() && IntentUtils.isInstalledApplication(KakaoEmoticon.getApplication(), "com.kakao.talk")) {
            StoreItem storeItem0 = new StoreItem();
            this.emoticonTabItems.add(storeItem0);
        }
        return this.emoticonTabItems;
    }

    public final void onConfigurationChanged() {
        TabTouchListener tabTouchListener0 = this.tabTouchListener;
        if(tabTouchListener0 != null) {
            tabTouchListener0.reset();
        }
        if(this.binding != null) {
            EmoticonViewPagerCoordinator emoticonViewPagerCoordinator0 = this.emoticonViewPagerCoordinator;
            if(emoticonViewPagerCoordinator0 != null) {
                emoticonViewPagerCoordinator0.onConfigurationChanged();
            }
        }
    }

    public final void onDestroy() {
        this.isDestroy = true;
        EmoticonManager.INSTANCE.setEmoticonUpdateListener(null);
        EmoticonManager.INSTANCE.removeSessionListener();
        this.mContext = null;
        this.mEmoticonClickListener = null;
        EmoticonSectionViewBinding emoticonSectionViewBinding0 = this.binding;
        if(emoticonSectionViewBinding0 != null) {
            EmoticonSectionView emoticonSectionView0 = emoticonSectionViewBinding0.getRoot();
            if(emoticonSectionView0 != null) {
                emoticonSectionView0.removeAllViews();
            }
        }
        EmoticonTabItem emoticonTabItem0 = this.tabAdapter.getSelectedItem();
        if(emoticonTabItem0 != null) {
            EmoticonPreference emoticonPreference0 = EmoticonPreference.getInstance();
            q.f(emoticonPreference0, "EmoticonPreference.getInstance()");
            emoticonPreference0.setTabIndex(emoticonTabItem0.getItemId());
        }
        this.tabAdapter.release();
        ActionTracker.INSTANCE.sendLog();
    }

    public final void onViewAppear() {
        if(!this.isInitDataOnBackground) {
            this.isInitDataOnBackground = true;
            this.initDataOnBackground();
        }
    }

    private final void reloadEmoticonTabs() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new n(null) {
            int label;
            private CoroutineScope p$;

            {
                EmoticonSectionViewController.this = emoticonSectionViewController0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonSectionViewController.reloadEmoticonTabs.1(EmoticonSectionViewController.this, continuation0);
                continuation1.p$ = (CoroutineScope)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonSectionViewController.reloadEmoticonTabs.1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                w0 w00;
                String s;
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                H h0 = H.a;
                if(!EmoticonSectionViewController.this.isDestroy && EmoticonSectionViewController.this.binding != null) {
                    EmoticonSectionViewController.this.showGuideViewIfNeeded();
                    EmoticonTabItem emoticonTabItem0 = EmoticonSectionViewController.this.tabAdapter.getSelectedItem();
                    boolean z = EmoticonSectionViewController.this.tabAdapter.getItemCount() == 0;
                    List list0 = EmoticonSectionViewController.this.loadTabItems();
                    EmoticonSectionViewController.this.tabAdapter.setItems(list0);
                    EmoticonViewPagerCoordinator emoticonViewPagerCoordinator0 = EmoticonSectionViewController.this.emoticonViewPagerCoordinator;
                    if(emoticonViewPagerCoordinator0 != null) {
                        emoticonViewPagerCoordinator0.setItems(list0);
                    }
                    EmoticonTabAdapter emoticonTabAdapter0 = EmoticonSectionViewController.this.tabAdapter;
                    if(emoticonTabItem0 == null) {
                        EmoticonPreference emoticonPreference0 = EmoticonPreference.getInstance();
                        q.f(emoticonPreference0, "EmoticonPreference.getInstance()");
                        s = emoticonPreference0.getTabIndex();
                    }
                    else {
                        s = emoticonTabItem0.getItemId();
                    }
                    emoticonTabAdapter0.setSelectedPosition(s);
                    RecyclerView recyclerView0 = null;
                    if(z) {
                        EmoticonTabAdapter emoticonTabAdapter1 = EmoticonSectionViewController.this.tabAdapter;
                        EmoticonSectionViewBinding emoticonSectionViewBinding0 = EmoticonSectionViewController.this.binding;
                        if(emoticonSectionViewBinding0 == null) {
                            w00 = null;
                        }
                        else {
                            RecyclerView recyclerView1 = emoticonSectionViewBinding0.tabRecyclerview;
                            w00 = recyclerView1 == null ? null : recyclerView1.getLayoutManager();
                        }
                        EmoticonPreference emoticonPreference1 = EmoticonPreference.getInstance();
                        q.f(emoticonPreference1, "EmoticonPreference.getInstance()");
                        emoticonTabAdapter1.scrollToTabPageIndex(((LinearLayoutManager)w00), emoticonPreference1.getTabIndex());
                    }
                    EmoticonSectionViewController.this.tabAdapter.notifyDataSetChanged();
                    EmoticonViewPagerCoordinator emoticonViewPagerCoordinator1 = EmoticonSectionViewController.this.emoticonViewPagerCoordinator;
                    if(emoticonViewPagerCoordinator1 != null) {
                        emoticonViewPagerCoordinator1.setCurrentItem(EmoticonSectionViewController.this.tabAdapter.getSelectedPosition());
                    }
                    if(KakaoEmoticon.isConnectedAccount() && EmoticonSectionViewController.this.tabTouchCallback == null) {
                        EmoticonSectionViewBinding emoticonSectionViewBinding1 = EmoticonSectionViewController.this.binding;
                        EmoticonSectionViewBinding emoticonSectionViewBinding2 = EmoticonSectionViewController.this.binding;
                        EmoticonSectionViewController.this.tabTouchCallback = new TabItemTouchHelperCallback((emoticonSectionViewBinding1 == null ? null : emoticonSectionViewBinding1.tabRecyclerview), EmoticonSectionViewController.this.tabAdapter, new TabItemTouchController(EmoticonSectionViewController.this.mContext, (emoticonSectionViewBinding2 == null ? null : emoticonSectionViewBinding2.getRoot())));
                        if(EmoticonSectionViewController.this.itemTouchHelper == null) {
                            EmoticonSectionViewController emoticonSectionViewController0 = EmoticonSectionViewController.this;
                            TabItemTouchHelperCallback tabItemTouchHelperCallback0 = emoticonSectionViewController0.tabTouchCallback;
                            q.d(tabItemTouchHelperCallback0);
                            O o0 = new O(tabItemTouchHelperCallback0);
                            EmoticonSectionViewBinding emoticonSectionViewBinding3 = EmoticonSectionViewController.this.binding;
                            if(emoticonSectionViewBinding3 != null) {
                                recyclerView0 = emoticonSectionViewBinding3.tabRecyclerview;
                            }
                            o0.c(recyclerView0);
                            emoticonSectionViewController0.itemTouchHelper = o0;
                        }
                    }
                }
                return h0;
            }
        }, 3, null);
    }

    public final void setLoginClickListener(@Nullable EmoticonLoginClickListener emoticonLoginClickListener0) {
        this.mLoginClickListener = emoticonLoginClickListener0;
    }

    public final void setLoginText(@Nullable String s, @Nullable String s1) {
        this.loginMessage = s;
        this.loginButtonText = s1;
    }

    private final void showEmptyView() {
        EmoticonSectionViewBinding emoticonSectionViewBinding0 = this.binding;
        if(emoticonSectionViewBinding0 != null) {
            EmptyRetryView emptyRetryView0 = emoticonSectionViewBinding0.empty;
            if(emptyRetryView0 != null) {
                emptyRetryView0.setVisibility(0);
            }
        }
        EmoticonSectionViewBinding emoticonSectionViewBinding1 = this.binding;
        if(emoticonSectionViewBinding1 != null) {
            EmptyRetryView emptyRetryView1 = emoticonSectionViewBinding1.empty;
            if(emptyRetryView1 != null) {
                emptyRetryView1.setReloadButton();
            }
        }
    }

    private final void showGuideViewIfNeeded() {
        if(KakaoEmoticon.isEnabledLoginTab() || KakaoEmoticon.isConnectedAccount()) {
            EmoticonPreference emoticonPreference0 = EmoticonPreference.getInstance();
            q.f(emoticonPreference0, "EmoticonPreference.getInstance()");
            if(!emoticonPreference0.isNormalCPGuideOnceDisplayed()) {
                EmoticonSectionViewBinding emoticonSectionViewBinding0 = this.binding;
                if(emoticonSectionViewBinding0 != null) {
                    RecyclerView recyclerView0 = emoticonSectionViewBinding0.tabRecyclerview;
                    if(recyclerView0 != null) {
                        recyclerView0.setVisibility(4);
                    }
                }
                EmoticonSectionViewBinding emoticonSectionViewBinding1 = this.binding;
                if(emoticonSectionViewBinding1 != null) {
                    View view0 = emoticonSectionViewBinding1.vBottomLine;
                    if(view0 != null) {
                        view0.setVisibility(4);
                    }
                }
                if(this.guideView != null && this.guideView.shouldRecreate()) {
                    EmoticonSectionViewBinding emoticonSectionViewBinding2 = this.binding;
                    if(emoticonSectionViewBinding2 != null) {
                        EmoticonSectionView emoticonSectionView0 = emoticonSectionViewBinding2.getRoot();
                        if(emoticonSectionView0 != null) {
                            emoticonSectionView0.removeView(this.guideView);
                        }
                    }
                    this.guideView = null;
                }
                if(this.guideView == null) {
                    View view1 = LayoutInflater.from(this.mContext).inflate(layout.emoticon_guide_2, null);
                    if(view1 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.kakao.emoticon.ui.GuideView");
                    }
                    this.guideView = (GuideView)view1;
                    EmoticonSectionViewBinding emoticonSectionViewBinding3 = this.binding;
                    if(emoticonSectionViewBinding3 != null) {
                        EmoticonSectionView emoticonSectionView1 = emoticonSectionViewBinding3.getRoot();
                        if(emoticonSectionView1 != null) {
                            emoticonSectionView1.addView(this.guideView);
                        }
                    }
                    GuideView guideView0 = this.guideView;
                    if(guideView0 != null) {
                        guideView0.setVisibility(0);
                    }
                    GuideView guideView1 = this.guideView;
                    q.d(guideView1);
                    View view2 = guideView1.findViewById(id.start);
                    if(view2 != null) {
                        view2.setOnClickListener(new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public final void onClick(View view0) {
                                EmoticonPreference emoticonPreference0 = EmoticonPreference.getInstance();
                                q.f(emoticonPreference0, "EmoticonPreference.getInstance()");
                                emoticonPreference0.setNormalCPGuideOnceDisplayed(true);
                                EmoticonSectionViewController.this.hideGuideView(true);
                            }
                        });
                    }
                }
            }
        }
    }

    private final void syncEmoticons() {
        EmoticonManager.requestSyncEmoticons$default(EmoticonManager.INSTANCE, this.emoticonCallback, null, 2, null);
    }
}

