package com.kakao.emoticon.ui.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.w;
import com.kakao.digitalitem.image.lib.AnimatedItemImage;
import com.kakao.digitalitem.image.lib.AnimatedItemImageContainer;
import com.kakao.digitalitem.image.lib.AnimatedItemImageView.OnIndexChangeListener;
import com.kakao.digitalitem.image.lib.ImageFrame;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.R.style;
import com.kakao.emoticon.controller.EmoticonResourceLoader;
import com.kakao.emoticon.databinding.LayoutDialogEmoticonPreviewBinding;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.net.EmoticonApiError;
import com.kakao.emoticon.net.EmoticonApiLauncher;
import com.kakao.emoticon.net.EmoticonApiService;
import com.kakao.emoticon.net.EmoticonApiServiceImpl;
import com.kakao.emoticon.net.response.EmoticonInfo;
import com.kakao.emoticon.net.response.ItemSubType;
import com.kakao.emoticon.util.ActionTracker;
import com.kakao.emoticon.util.IntentUtils;
import d5.n;
import ie.H;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import we.k;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001A\u00020\u00072\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\n\u0010\u0004J-\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0018\u001A\u00020\u00072\u0006\u0010\u0017\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u001A\u0010\u0004J\u000F\u0010\u001B\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u001B\u0010\u0004J\u000F\u0010\u001C\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u001C\u0010\u0004J\u000F\u0010\u001D\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u001D\u0010\u0004J\u000F\u0010\u001E\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u001E\u0010\u0004J\u000F\u0010\u001F\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u001F\u0010\u0004J\u0019\u0010#\u001A\u0004\u0018\u00010\"2\u0006\u0010!\u001A\u00020 H\u0002\u00A2\u0006\u0004\b#\u0010$R\u0018\u0010%\u001A\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001A\u0004\u0018\u00010\'8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001A\u00020 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001A\u00020,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b-\u0010.R\u001C\u00100\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\"0/8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001A\u00020 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u0010+R\u0016\u00103\u001A\u00020,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u0010.R\u0016\u00104\u001A\u00020 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u0010+R\u0016\u00106\u001A\u0002058\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001A\u0002088\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b9\u0010:\u00A8\u0006<"}, d2 = {"Lcom/kakao/emoticon/ui/widget/EmoticonInfoDialogFragment;", "Landroidx/fragment/app/w;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "dismiss", "v", "onClick", "(Landroid/view/View;)V", "requestItemDetailInfo", "setEmoticonInfo", "playEmoticon", "stopEmoticon", "onMoreBtn", "removeAndPlayMessage", "", "resourceId", "Lcom/kakao/emoticon/model/EmoticonViewParam;", "createEmoticonViewParam", "(I)Lcom/kakao/emoticon/model/EmoticonViewParam;", "emoticonViewParam", "Lcom/kakao/emoticon/model/EmoticonViewParam;", "Lcom/kakao/emoticon/net/response/EmoticonInfo;", "emoticonInfoItem", "Lcom/kakao/emoticon/net/response/EmoticonInfo;", "currentPlayIdx", "I", "", "isMoreBtnOn", "Z", "", "emoticonPlayList", "Ljava/util/List;", "totalDurationTime", "isFirstLoop", "countedLoop", "Lcom/kakao/emoticon/databinding/LayoutDialogEmoticonPreviewBinding;", "binding", "Lcom/kakao/emoticon/databinding/LayoutDialogEmoticonPreviewBinding;", "Landroid/os/Handler;", "playTimerHandler", "Landroid/os/Handler;", "Companion", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonInfoDialogFragment extends w implements View.OnClickListener {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001A\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000BR\u0014\u0010\r\u001A\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000F\u0010\u000E¨\u0006\u0010"}, d2 = {"Lcom/kakao/emoticon/ui/widget/EmoticonInfoDialogFragment$Companion;", "", "<init>", "()V", "Lcom/kakao/emoticon/model/EmoticonViewParam;", "emoticonViewParam", "Landroidx/fragment/app/w;", "getInstance", "(Lcom/kakao/emoticon/model/EmoticonViewParam;)Landroidx/fragment/app/w;", "", "EMOTICON_ITEM", "Ljava/lang/String;", "", "PLAY_EMOTICON_COUNT", "I", "STICKER_PLAY_TIME", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final w getInstance(@Nullable EmoticonViewParam emoticonViewParam0) {
            if(emoticonViewParam0 != null) {
                w w0 = new EmoticonInfoDialogFragment();
                Bundle bundle0 = new Bundle();
                bundle0.putParcelable("emoticon_item", emoticonViewParam0);
                w0.setArguments(bundle0);
                return w0;
            }
            return null;
        }
    }

    public static final Companion Companion = null;
    private static final String EMOTICON_ITEM = "emoticon_item";
    private static final int PLAY_EMOTICON_COUNT = 5;
    private static final int STICKER_PLAY_TIME = 500;
    private HashMap _$_findViewCache;
    private LayoutDialogEmoticonPreviewBinding binding;
    private int countedLoop;
    private int currentPlayIdx;
    private EmoticonInfo emoticonInfoItem;
    private final List emoticonPlayList;
    private EmoticonViewParam emoticonViewParam;
    private boolean isFirstLoop;
    private boolean isMoreBtnOn;
    private final Handler playTimerHandler;
    private int totalDurationTime;

    static {
        EmoticonInfoDialogFragment.Companion = new Companion(null);
    }

    public EmoticonInfoDialogFragment() {
        this.emoticonPlayList = new ArrayList();
        this.isFirstLoop = true;
        this.playTimerHandler = new Handler(new Handler.Callback() {
            @Override  // android.os.Handler$Callback
            public final boolean handleMessage(Message message0) {
                EmoticonInfoDialogFragment.access$setCurrentPlayIdx$p(EmoticonInfoDialogFragment.this, EmoticonInfoDialogFragment.access$getCurrentPlayIdx$p(EmoticonInfoDialogFragment.this) + 1);
                if(EmoticonInfoDialogFragment.access$getCurrentPlayIdx$p(EmoticonInfoDialogFragment.this) == 3 && !EmoticonInfoDialogFragment.access$isMoreBtnOn$p(EmoticonInfoDialogFragment.this)) {
                    EmoticonInfoDialogFragment.access$onMoreBtn(EmoticonInfoDialogFragment.this);
                }
                if(EmoticonInfoDialogFragment.access$getCurrentPlayIdx$p(EmoticonInfoDialogFragment.this) == 5) {
                    EmoticonInfoDialogFragment.access$stopEmoticon(EmoticonInfoDialogFragment.this);
                    return false;
                }
                LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding0 = EmoticonInfoDialogFragment.access$getBinding$p(EmoticonInfoDialogFragment.this);
                EmoticonViewParam emoticonViewParam0 = (EmoticonViewParam)EmoticonInfoDialogFragment.access$getEmoticonPlayList$p(EmoticonInfoDialogFragment.this).get(EmoticonInfoDialogFragment.access$getCurrentPlayIdx$p(EmoticonInfoDialogFragment.this));
                ItemSubType itemSubType0 = null;
                layoutDialogEmoticonPreviewBinding0.emoticonView.loadEmoticon(emoticonViewParam0, null);
                EmoticonInfo emoticonInfo0 = EmoticonInfoDialogFragment.access$getEmoticonInfoItem$p(EmoticonInfoDialogFragment.this);
                if(emoticonInfo0 != null) {
                    itemSubType0 = emoticonInfo0.getItemSubType();
                }
                if(itemSubType0 == ItemSubType.STICKER) {
                    EmoticonInfoDialogFragment.access$removeAndPlayMessage(EmoticonInfoDialogFragment.this);
                }
                return false;
            }
        });
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap0 = this._$_findViewCache;
        if(hashMap0 != null) {
            hashMap0.clear();
        }
    }

    public View _$_findCachedViewById(int v) {
        if(this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view0 = (View)this._$_findViewCache.get(v);
        if(view0 == null) {
            View view1 = this.getView();
            if(view1 == null) {
                return null;
            }
            view0 = view1.findViewById(v);
            this._$_findViewCache.put(v, view0);
        }
        return view0;
    }

    public static final LayoutDialogEmoticonPreviewBinding access$getBinding$p(EmoticonInfoDialogFragment emoticonInfoDialogFragment0) {
        LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding0 = emoticonInfoDialogFragment0.binding;
        if(layoutDialogEmoticonPreviewBinding0 != null) {
            return layoutDialogEmoticonPreviewBinding0;
        }
        q.m("binding");
        throw null;
    }

    public static final EmoticonInfo access$getEmoticonInfoItem$p(EmoticonInfoDialogFragment emoticonInfoDialogFragment0) {
        return emoticonInfoDialogFragment0.emoticonInfoItem;
    }

    public static final void access$removeAndPlayMessage(EmoticonInfoDialogFragment emoticonInfoDialogFragment0) {
        emoticonInfoDialogFragment0.removeAndPlayMessage();
    }

    public static final void access$setBinding$p(EmoticonInfoDialogFragment emoticonInfoDialogFragment0, LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding0) {
        emoticonInfoDialogFragment0.binding = layoutDialogEmoticonPreviewBinding0;
    }

    public static final void access$setEmoticonViewParam$p(EmoticonInfoDialogFragment emoticonInfoDialogFragment0, EmoticonViewParam emoticonViewParam0) {
        emoticonInfoDialogFragment0.emoticonViewParam = emoticonViewParam0;
    }

    public static final void access$setMoreBtnOn$p(EmoticonInfoDialogFragment emoticonInfoDialogFragment0, boolean z) {
        emoticonInfoDialogFragment0.isMoreBtnOn = z;
    }

    private final EmoticonViewParam createEmoticonViewParam(int v) {
        try {
            EmoticonViewParam emoticonViewParam0 = this.emoticonViewParam;
            if(emoticonViewParam0 != null) {
                JSONObject jSONObject0 = new JSONObject();
                jSONObject0.put("item_id", emoticonViewParam0.getEmoticonId());
                jSONObject0.put("item_sub_type", emoticonViewParam0.getEmoticonType().getType());
                jSONObject0.put("item_ver", emoticonViewParam0.getEmoticonVersion());
                jSONObject0.put("resource_id", v);
                return EmoticonViewParam.get(jSONObject0.toString());
            }
        }
        catch(Exception unused_ex) {
        }
        return null;
    }

    @Override  // androidx.fragment.app.w
    public void dismiss() {
        this.playTimerHandler.removeMessages(0);
        super.dismiss();
    }

    @Nullable
    public static final w getInstance(@Nullable EmoticonViewParam emoticonViewParam0) {
        return EmoticonInfoDialogFragment.Companion.getInstance(emoticonViewParam0);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(@NotNull View view0) {
        q.g(view0, "v");
        LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding0 = this.binding;
        String s = null;
        if(layoutDialogEmoticonPreviewBinding0 != null) {
            if(view0.equals(layoutDialogEmoticonPreviewBinding0.root)) {
                this.dismiss();
                return;
            }
            LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding1 = this.binding;
            if(layoutDialogEmoticonPreviewBinding1 != null) {
                if(!view0.equals(layoutDialogEmoticonPreviewBinding1.tvEmoticonMore)) {
                    LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding2 = this.binding;
                    if(layoutDialogEmoticonPreviewBinding2 == null) {
                        q.m("binding");
                        throw null;
                    }
                    else if(!view0.equals(layoutDialogEmoticonPreviewBinding2.tvEmoticonMoreOver)) {
                        LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding3 = this.binding;
                        if(layoutDialogEmoticonPreviewBinding3 != null) {
                            if(view0.equals(layoutDialogEmoticonPreviewBinding3.rlShare)) {
                                ActionTracker.pushLog$default("A003", "04", null, 4, null);
                                if(this.emoticonInfoItem == null || TextUtils.isEmpty(this.emoticonInfoItem.getStoreUrl())) {
                                    return;
                                }
                                Context context0 = view0.getContext();
                                EmoticonInfo emoticonInfo0 = this.emoticonInfoItem;
                                if(emoticonInfo0 != null) {
                                    s = emoticonInfo0.getStoreUrl();
                                }
                                IntentUtils.shareItemUrl(context0, s + "?referer=sdk_longtap_share");
                                return;
                            }
                            LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding4 = this.binding;
                            if(layoutDialogEmoticonPreviewBinding4 != null) {
                                if(view0.equals(layoutDialogEmoticonPreviewBinding4.btnPlaybtn) && this.emoticonInfoItem != null) {
                                    ActionTracker.pushLog$default("A003", "05", null, 4, null);
                                    this.playEmoticon();
                                }
                                return;
                            }
                            q.m("binding");
                            throw null;
                        }
                        q.m("binding");
                        throw null;
                    }
                }
                ActionTracker.pushLog$default("A003", "03", null, 4, null);
                String s1 = this.emoticonViewParam == null ? null : this.emoticonViewParam.getEmoticonId();
                if(KakaoEmoticon.getApplication() != null) {
                    s = "com.iloen.melon";
                }
                IntentUtils.goToEmoticonStoreAndShowItem(s1, s, "longtap");
                this.dismiss();
                return;
            }
            q.m("binding");
            throw null;
        }
        q.m("binding");
        throw null;
    }

    @Override  // androidx.fragment.app.I
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        ViewGroup viewGroup0 = (ViewGroup)this.getView();
        if(viewGroup0 != null) {
            viewGroup0.removeAllViewsInLayout();
        }
        FragmentActivity fragmentActivity0 = this.requireActivity();
        q.f(fragmentActivity0, "requireActivity()");
        LayoutInflater layoutInflater0 = fragmentActivity0.getLayoutInflater();
        q.f(layoutInflater0, "requireActivity().layoutInflater");
        View view0 = this.onCreateView(layoutInflater0, viewGroup0, null);
        q.d(viewGroup0);
        viewGroup0.addView(view0);
    }

    @Override  // androidx.fragment.app.w
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.setStyle(2, style.EmoticonPreview_Dialog);
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        this.playTimerHandler.removeMessages(0);
        this.totalDurationTime = 0;
        this.currentPlayIdx = 0;
        LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding0 = LayoutDialogEmoticonPreviewBinding.inflate(layoutInflater0, viewGroup0, false);
        q.f(layoutDialogEmoticonPreviewBinding0, "LayoutDialogEmoticonPrev…flater, container, false)");
        this.binding = layoutDialogEmoticonPreviewBinding0;
        layoutDialogEmoticonPreviewBinding0.root.setOnClickListener(this);
        LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding1 = this.binding;
        if(layoutDialogEmoticonPreviewBinding1 != null) {
            layoutDialogEmoticonPreviewBinding1.tvEmoticonMore.setOnClickListener(this);
            LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding2 = this.binding;
            if(layoutDialogEmoticonPreviewBinding2 != null) {
                layoutDialogEmoticonPreviewBinding2.tvEmoticonMoreOver.setOnClickListener(this);
                LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding3 = this.binding;
                if(layoutDialogEmoticonPreviewBinding3 != null) {
                    layoutDialogEmoticonPreviewBinding3.rlShare.setOnClickListener(this);
                    LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding4 = this.binding;
                    if(layoutDialogEmoticonPreviewBinding4 != null) {
                        layoutDialogEmoticonPreviewBinding4.emoticonView.setOnTouchListener((View view0, MotionEvent motionEvent0) -> true);
                        LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding5 = this.binding;
                        if(layoutDialogEmoticonPreviewBinding5 != null) {
                            layoutDialogEmoticonPreviewBinding5.btnPlaybtn.setOnClickListener(this);
                            Bundle bundle1 = this.getArguments();
                            this.emoticonViewParam = bundle1 == null ? null : ((EmoticonViewParam)bundle1.getParcelable("emoticon_item"));
                            if(this.isMoreBtnOn) {
                                this.onMoreBtn();
                            }
                            this.requestItemDetailInfo();
                            LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding6 = this.binding;
                            if(layoutDialogEmoticonPreviewBinding6 != null) {
                                return layoutDialogEmoticonPreviewBinding6.root;
                            }
                            q.m("binding");
                            throw null;
                        }
                        q.m("binding");
                        throw null;
                    }
                    q.m("binding");
                    throw null;
                }
                q.m("binding");
                throw null;
            }
            q.m("binding");
            throw null;
        }
        q.m("binding");
        throw null;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 0})
        final class com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.onCreateView.1 implements View.OnTouchListener {
            public static final com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.onCreateView.1 INSTANCE;

            static {
                com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.onCreateView.1.INSTANCE = new com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.onCreateView.1();
            }

            public com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.onCreateView.1() {
                super();
            }

            // 检测为 Lambda 实现
            @Override  // android.view.View$OnTouchListener
            public final boolean onTouch(@Nullable View view0, @Nullable MotionEvent motionEvent0) [...]
        }

    }

    @Override  // androidx.fragment.app.w
    public void onDestroyView() {
        super.onDestroyView();
        this._$_clearFindViewByIdCache();
    }

    private final void onMoreBtn() {
        this.isMoreBtnOn = true;
        ValueAnimator valueAnimator0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300L);
        AnimatorSet animatorSet0 = new AnimatorSet();
        valueAnimator0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
            public final void onAnimationUpdate(@NotNull ValueAnimator valueAnimator0) {
                q.g(valueAnimator0, "animation");
                TextView textView0 = EmoticonInfoDialogFragment.access$getBinding$p(EmoticonInfoDialogFragment.this).tvEmoticonMoreOver;
                q.f(textView0, "binding.tvEmoticonMoreOver");
                Object object0 = valueAnimator0.getAnimatedValue();
                if(object0 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                textView0.setAlpha(((float)(((Float)object0))));
                EmoticonInfoDialogFragment.access$getBinding$p(EmoticonInfoDialogFragment.this).tvEmoticonMoreOver.requestLayout();
            }
        });
        animatorSet0.play(valueAnimator0);
        animatorSet0.start();
    }

    @Override  // androidx.fragment.app.w
    public void onStart() {
        super.onStart();
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            q.d(window0);
            window0.setLayout(-1, -1);
        }
    }

    private final void playEmoticon() {
        this.isFirstLoop = true;
        this.countedLoop = 0;
        LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding0 = this.binding;
        if(layoutDialogEmoticonPreviewBinding0 != null) {
            EmoticonViewParam emoticonViewParam0 = (EmoticonViewParam)this.emoticonPlayList.get(0);
            layoutDialogEmoticonPreviewBinding0.emoticonView.loadEmoticon(emoticonViewParam0, null);
            LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding1 = this.binding;
            if(layoutDialogEmoticonPreviewBinding1 != null) {
                q.f(layoutDialogEmoticonPreviewBinding1.btnPlaybtn, "binding.btnPlaybtn");
                layoutDialogEmoticonPreviewBinding1.btnPlaybtn.setVisibility(8);
                if((this.emoticonInfoItem == null ? null : this.emoticonInfoItem.getItemSubType()) == ItemSubType.STICKER) {
                    this.removeAndPlayMessage();
                    return;
                }
                LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding2 = this.binding;
                if(layoutDialogEmoticonPreviewBinding2 != null) {
                    com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.playEmoticon.1 emoticonInfoDialogFragment$playEmoticon$10 = new OnIndexChangeListener() {
                        @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageView$OnIndexChangeListener
                        public final void onIndexChange(@NotNull AnimatedItemImageContainer animatedItemImageContainer0, int v) {
                            q.g(animatedItemImageContainer0, "container");
                            if(v == 0 && EmoticonInfoDialogFragment.this.isFirstLoop) {
                                EmoticonInfoDialogFragment.this.countedLoop = 0;
                                EmoticonInfoDialogFragment.this.totalDurationTime = 0;
                                EmoticonInfoDialogFragment.this.isFirstLoop = false;
                            }
                            AnimatedItemImage animatedItemImage0 = animatedItemImageContainer0.getAnimatedImage();
                            q.f(animatedItemImage0, "container.animatedImage");
                            if(v + 1 < animatedItemImage0.getFrameCount()) {
                                try {
                                    ImageFrame imageFrame0 = animatedItemImageContainer0.getAnimatedImage().getFrame(v);
                                    q.f(imageFrame0, "container.animatedImage.getFrame(index)");
                                    EmoticonInfoDialogFragment.this.totalDurationTime += imageFrame0.getDuration();
                                }
                                catch(Exception exception0) {
                                    exception0.printStackTrace();
                                }
                                return;
                            }
                            ++EmoticonInfoDialogFragment.this.countedLoop;
                            if(EmoticonInfoDialogFragment.this.totalDurationTime < 1000) {
                                AnimatedItemImage animatedItemImage1 = animatedItemImageContainer0.getAnimatedImage();
                                q.f(animatedItemImage1, "container.animatedImage");
                                int v1 = animatedItemImage1.getLoopCount();
                                if(EmoticonInfoDialogFragment.this.countedLoop < v1) {
                                    return;
                                }
                            }
                            ++EmoticonInfoDialogFragment.this.currentPlayIdx;
                            if(EmoticonInfoDialogFragment.this.currentPlayIdx == 1 && !EmoticonInfoDialogFragment.this.isMoreBtnOn) {
                                EmoticonInfoDialogFragment.this.onMoreBtn();
                            }
                            if(EmoticonInfoDialogFragment.this.currentPlayIdx == 5) {
                                EmoticonInfoDialogFragment.this.stopEmoticon();
                                return;
                            }
                            EmoticonInfoDialogFragment.this.countedLoop = 0;
                            EmoticonInfoDialogFragment.this.totalDurationTime = 0;
                            EmoticonInfoDialogFragment.this.isFirstLoop = true;
                            LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding0 = EmoticonInfoDialogFragment.access$getBinding$p(EmoticonInfoDialogFragment.this);
                            com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.playEmoticon.1.1 emoticonInfoDialogFragment$playEmoticon$1$10 = new Runnable() {
                                @Override
                                public final void run() {
                                    try {
                                        LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding0 = EmoticonInfoDialogFragment.access$getBinding$p(EmoticonInfoDialogFragment.this);
                                        EmoticonViewParam emoticonViewParam0 = (EmoticonViewParam)EmoticonInfoDialogFragment.this.emoticonPlayList.get(EmoticonInfoDialogFragment.this.currentPlayIdx);
                                        layoutDialogEmoticonPreviewBinding0.emoticonView.loadEmoticon(emoticonViewParam0, null);
                                    }
                                    catch(Exception unused_ex) {
                                    }
                                }
                            };
                            layoutDialogEmoticonPreviewBinding0.emoticonView.postDelayed(emoticonInfoDialogFragment$playEmoticon$1$10, 0L);
                        }
                    };
                    layoutDialogEmoticonPreviewBinding2.emoticonView.setOnIndexChangeListener(emoticonInfoDialogFragment$playEmoticon$10);
                    return;
                }
                q.m("binding");
                throw null;
            }
            q.m("binding");
            throw null;
        }
        q.m("binding");
        throw null;
    }

    private final void removeAndPlayMessage() {
        this.playTimerHandler.removeMessages(0);
        this.playTimerHandler.sendEmptyMessageDelayed(0, 500L);
    }

    private final void requestItemDetailInfo() {
        EmoticonViewParam emoticonViewParam0 = this.emoticonViewParam;
        if(emoticonViewParam0 != null) {
            String s = emoticonViewParam0.getEmoticonId();
            if(s != null) {
                com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.requestItemDetailInfo.1.1 emoticonInfoDialogFragment$requestItemDetailInfo$1$10 = new k(null) {
                    final String $emoticonId;
                    int label;

                    {
                        this.$emoticonId = s;
                        super(1, continuation0);
                    }

                    @Override  // oe.a
                    @NotNull
                    public final Continuation create(@NotNull Continuation continuation0) {
                        q.g(continuation0, "completion");
                        return new com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.requestItemDetailInfo.1.1(this.$emoticonId, continuation0);
                    }

                    @Override  // we.k
                    public final Object invoke(Object object0) {
                        return ((com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.requestItemDetailInfo.1.1)this.create(((Continuation)object0))).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                n.D(object0);
                                EmoticonApiService emoticonApiService0 = EmoticonApiServiceImpl.INSTANCE.getApiClass();
                                this.label = 1;
                                Object object1 = emoticonApiService0.getEmoticonInfo(this.$emoticonId, this);
                                return object1 == a0 ? a0 : object1;
                            }
                            case 1: {
                                n.D(object0);
                                return object0;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.requestItemDetailInfo..inlined.let.lambda.1 emoticonInfoDialogFragment$requestItemDetailInfo$$inlined$let$lambda$10 = new we.n(this) {
                    int label;
                    private EmoticonInfo p$0;

                    {
                        EmoticonInfoDialogFragment.this = emoticonInfoDialogFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    @NotNull
                    public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                        q.g(continuation0, "completion");
                        Continuation continuation1 = new com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.requestItemDetailInfo..inlined.let.lambda.1(continuation0, EmoticonInfoDialogFragment.this);
                        continuation1.p$0 = (EmoticonInfo)object0;
                        return continuation1;
                    }

                    @Override  // we.n
                    public final Object invoke(Object object0, Object object1) {
                        return ((com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.requestItemDetailInfo..inlined.let.lambda.1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        n.D(object0);
                        EmoticonInfoDialogFragment.this.emoticonInfoItem = this.p$0;
                        EmoticonInfoDialogFragment.this.setEmoticonInfo();
                        return H.a;
                    }
                };
                com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.requestItemDetailInfo..inlined.let.lambda.2 emoticonInfoDialogFragment$requestItemDetailInfo$$inlined$let$lambda$20 = new we.n(this) {
                    int label;
                    private EmoticonApiError p$0;

                    {
                        EmoticonInfoDialogFragment.this = emoticonInfoDialogFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    @NotNull
                    public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                        q.g(continuation0, "completion");
                        Continuation continuation1 = new com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.requestItemDetailInfo..inlined.let.lambda.2(continuation0, EmoticonInfoDialogFragment.this);
                        continuation1.p$0 = (EmoticonApiError)object0;
                        return continuation1;
                    }

                    @Override  // we.n
                    public final Object invoke(Object object0, Object object1) {
                        return ((com.kakao.emoticon.ui.widget.EmoticonInfoDialogFragment.requestItemDetailInfo..inlined.let.lambda.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        n.D(object0);
                        EmoticonInfoDialogFragment.access$getBinding$p(EmoticonInfoDialogFragment.this).emoticonView.loadThumbnail(EmoticonInfoDialogFragment.this.emoticonViewParam, null);
                        LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding0 = EmoticonInfoDialogFragment.access$getBinding$p(EmoticonInfoDialogFragment.this);
                        q.f(layoutDialogEmoticonPreviewBinding0.tvEmoticonEmpty, "binding.tvEmoticonEmpty");
                        layoutDialogEmoticonPreviewBinding0.tvEmoticonEmpty.setVisibility(0);
                        return H.a;
                    }
                };
                EmoticonApiLauncher.launchMain$default(EmoticonApiLauncher.INSTANCE, emoticonInfoDialogFragment$requestItemDetailInfo$1$10, emoticonInfoDialogFragment$requestItemDetailInfo$$inlined$let$lambda$10, emoticonInfoDialogFragment$requestItemDetailInfo$$inlined$let$lambda$20, null, 8, null);
            }
        }
    }

    private final void setEmoticonInfo() {
        LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding0 = this.binding;
        if(layoutDialogEmoticonPreviewBinding0 != null) {
            TextView textView0 = layoutDialogEmoticonPreviewBinding0.tvEmoticonTitle;
            if(layoutDialogEmoticonPreviewBinding0 != null) {
                q.f(textView0, "binding.tvEmoticonTitle");
                textView0.setText((this.emoticonInfoItem == null ? null : this.emoticonInfoItem.getTitle()));
                LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding1 = this.binding;
                if(layoutDialogEmoticonPreviewBinding1 != null) {
                    q.f(layoutDialogEmoticonPreviewBinding1.tvEmoticonArtist, "binding.tvEmoticonArtist");
                    layoutDialogEmoticonPreviewBinding1.tvEmoticonArtist.setText((this.emoticonInfoItem == null ? null : this.emoticonInfoItem.getEditorName()));
                    EmoticonViewParam emoticonViewParam0 = this.emoticonViewParam;
                    q.d(emoticonViewParam0);
                    EmoticonViewParam emoticonViewParam1 = this.createEmoticonViewParam(emoticonViewParam0.getResourceId());
                    this.emoticonPlayList.add(emoticonViewParam1);
                    EmoticonInfo emoticonInfo0 = this.emoticonInfoItem;
                    q.d(emoticonInfo0);
                    int v = emoticonInfo0.getCount();
                    int v1 = 1;
                    if(1 <= v) {
                        while(true) {
                            EmoticonViewParam emoticonViewParam2 = this.emoticonViewParam;
                            q.d(emoticonViewParam2);
                            if(v1 != emoticonViewParam2.getResourceId()) {
                                EmoticonViewParam emoticonViewParam3 = this.createEmoticonViewParam(v1);
                                this.emoticonPlayList.add(emoticonViewParam3);
                                q.d(emoticonViewParam3);
                                EmoticonResourceLoader.INSTANCE.downloadEmoticon(emoticonViewParam3, null);
                                if(this.emoticonPlayList.size() != 5) {
                                    goto label_27;
                                }
                                break;
                            }
                        label_27:
                            if(v1 == v) {
                                break;
                            }
                            ++v1;
                        }
                    }
                    this.playEmoticon();
                    return;
                }
                q.m("binding");
                throw null;
            }
            q.m("binding");
            throw null;
        }
        q.m("binding");
        throw null;
    }

    private final void stopEmoticon() {
        this.countedLoop = 0;
        this.totalDurationTime = 0;
        this.isFirstLoop = true;
        this.currentPlayIdx = 0;
        if((this.emoticonInfoItem == null ? null : this.emoticonInfoItem.getItemSubType()) == ItemSubType.STICKER) {
            LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding0 = this.binding;
            if(layoutDialogEmoticonPreviewBinding0 != null) {
                EmoticonViewParam emoticonViewParam0 = (EmoticonViewParam)this.emoticonPlayList.get(0);
                layoutDialogEmoticonPreviewBinding0.emoticonView.loadEmoticon(emoticonViewParam0, null);
                goto label_16;
            }
            q.m("binding");
            throw null;
        }
        LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding1 = this.binding;
        if(layoutDialogEmoticonPreviewBinding1 != null) {
            EmoticonViewParam emoticonViewParam1 = (EmoticonViewParam)this.emoticonPlayList.get(0);
            layoutDialogEmoticonPreviewBinding1.emoticonView.loadThumbnail(emoticonViewParam1, null);
        label_16:
            LayoutDialogEmoticonPreviewBinding layoutDialogEmoticonPreviewBinding2 = this.binding;
            if(layoutDialogEmoticonPreviewBinding2 != null) {
                q.f(layoutDialogEmoticonPreviewBinding2.btnPlaybtn, "binding.btnPlaybtn");
                layoutDialogEmoticonPreviewBinding2.btnPlaybtn.setVisibility(0);
                return;
            }
            q.m("binding");
            throw null;
        }
        q.m("binding");
        throw null;
    }
}

