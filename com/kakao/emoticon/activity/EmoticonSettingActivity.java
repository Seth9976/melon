package com.kakao.emoticon.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.fragment.app.q0;
import androidx.viewpager.widget.j;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.activity.fragment.EmoticonDownloadFragment;
import com.kakao.emoticon.activity.fragment.EmoticonEditFragment;
import com.kakao.emoticon.databinding.ActivityKakaoEmoticonSettingsBinding;
import com.kakao.emoticon.util.IntentUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\t\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000B\u0010\u0003R(\u0010\u000E\u001A\u0004\u0018\u00010\f2\b\u0010\r\u001A\u0004\u0018\u00010\f8\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001A\u0004\u0018\u00010\u00122\b\u0010\r\u001A\u0004\u0018\u00010\u00128\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001B\u001A\u00020\u001A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001E\u001A\u00020\u001D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001F¨\u0006!"}, d2 = {"Lcom/kakao/emoticon/activity/EmoticonSettingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Lie/H;", "initView", "startDownloadRefreshing", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "Lcom/kakao/emoticon/activity/fragment/EmoticonEditFragment;", "<set-?>", "emoticonEditFragment", "Lcom/kakao/emoticon/activity/fragment/EmoticonEditFragment;", "getEmoticonEditFragment", "()Lcom/kakao/emoticon/activity/fragment/EmoticonEditFragment;", "Lcom/kakao/emoticon/activity/fragment/EmoticonDownloadFragment;", "emoticonDownloadFragment", "Lcom/kakao/emoticon/activity/fragment/EmoticonDownloadFragment;", "getEmoticonDownloadFragment", "()Lcom/kakao/emoticon/activity/fragment/EmoticonDownloadFragment;", "", "isFirstSelected", "Z", "Lcom/kakao/emoticon/databinding/ActivityKakaoEmoticonSettingsBinding;", "binding", "Lcom/kakao/emoticon/databinding/ActivityKakaoEmoticonSettingsBinding;", "Landroid/view/View$OnClickListener;", "tabOnClickListener", "Landroid/view/View$OnClickListener;", "SectionsPagerAdapter", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonSettingActivity extends AppCompatActivity {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/kakao/emoticon/activity/EmoticonSettingActivity$SectionsPagerAdapter;", "Landroidx/fragment/app/q0;", "Landroidx/fragment/app/l0;", "fm", "<init>", "(Lcom/kakao/emoticon/activity/EmoticonSettingActivity;Landroidx/fragment/app/l0;)V", "", "position", "Landroidx/fragment/app/I;", "getItem", "(I)Landroidx/fragment/app/I;", "getCount", "()I", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
    public final class SectionsPagerAdapter extends q0 {
        public SectionsPagerAdapter(@NotNull l0 l00) {
            q.g(l00, "fm");
            EmoticonSettingActivity.this = emoticonSettingActivity0;
            super(l00);
        }

        @Override  // androidx.viewpager.widget.a
        public int getCount() {
            return 2;
        }

        @Override  // androidx.fragment.app.q0
        @NotNull
        public I getItem(int v) {
            if(v != 0) {
                if(EmoticonSettingActivity.this.getEmoticonDownloadFragment() == null) {
                    EmoticonDownloadFragment emoticonDownloadFragment0 = new EmoticonDownloadFragment();
                    EmoticonSettingActivity.this.emoticonDownloadFragment = emoticonDownloadFragment0;
                }
                I i0 = EmoticonSettingActivity.this.getEmoticonDownloadFragment();
                if(i0 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.kakao.emoticon.activity.fragment.EmoticonDownloadFragment");
                }
                return i0;
            }
            if(EmoticonSettingActivity.this.getEmoticonEditFragment() == null) {
                EmoticonEditFragment emoticonEditFragment0 = new EmoticonEditFragment();
                EmoticonSettingActivity.this.emoticonEditFragment = emoticonEditFragment0;
            }
            I i1 = EmoticonSettingActivity.this.getEmoticonEditFragment();
            if(i1 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.kakao.emoticon.activity.fragment.EmoticonEditFragment");
            }
            return i1;
        }
    }

    private HashMap _$_findViewCache;
    private ActivityKakaoEmoticonSettingsBinding binding;
    @Nullable
    private EmoticonDownloadFragment emoticonDownloadFragment;
    @Nullable
    private EmoticonEditFragment emoticonEditFragment;
    private boolean isFirstSelected;
    private final View.OnClickListener tabOnClickListener;

    public EmoticonSettingActivity() {
        this.isFirstSelected = true;
        this.tabOnClickListener = new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public final void onClick(View view0) {
                if(q.b(EmoticonSettingActivity.access$getBinding$p(EmoticonSettingActivity.this).radioEdit, view0)) {
                    ActivityKakaoEmoticonSettingsBinding activityKakaoEmoticonSettingsBinding0 = EmoticonSettingActivity.access$getBinding$p(EmoticonSettingActivity.this);
                    q.f(activityKakaoEmoticonSettingsBinding0.container, "binding.container");
                    activityKakaoEmoticonSettingsBinding0.container.setCurrentItem(0);
                    return;
                }
                if(q.b(EmoticonSettingActivity.access$getBinding$p(EmoticonSettingActivity.this).radioDownload, view0)) {
                    ActivityKakaoEmoticonSettingsBinding activityKakaoEmoticonSettingsBinding1 = EmoticonSettingActivity.access$getBinding$p(EmoticonSettingActivity.this);
                    q.f(activityKakaoEmoticonSettingsBinding1.container, "binding.container");
                    activityKakaoEmoticonSettingsBinding1.container.setCurrentItem(1);
                    EmoticonSettingActivity.access$startDownloadRefreshing(EmoticonSettingActivity.this);
                    return;
                }
                q.f(view0, "v");
                if(view0.getId() == id.rl_back) {
                    EmoticonSettingActivity.this.onBackPressed();
                    return;
                }
                if(view0.getId() == id.rl_go_store) {
                    IntentUtils.goToEmoticonStoreAlert(EmoticonSettingActivity.this, "com.iloen.melon", "my");
                }
            }
        };
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
            view0 = this.findViewById(v);
            this._$_findViewCache.put(v, view0);
        }
        return view0;
    }

    public static final ActivityKakaoEmoticonSettingsBinding access$getBinding$p(EmoticonSettingActivity emoticonSettingActivity0) {
        ActivityKakaoEmoticonSettingsBinding activityKakaoEmoticonSettingsBinding0 = emoticonSettingActivity0.binding;
        if(activityKakaoEmoticonSettingsBinding0 != null) {
            return activityKakaoEmoticonSettingsBinding0;
        }
        q.m("binding");
        throw null;
    }

    public static final EmoticonDownloadFragment access$getEmoticonDownloadFragment$p(EmoticonSettingActivity emoticonSettingActivity0) {
        return emoticonSettingActivity0.emoticonDownloadFragment;
    }

    public static final EmoticonEditFragment access$getEmoticonEditFragment$p(EmoticonSettingActivity emoticonSettingActivity0) {
        return emoticonSettingActivity0.emoticonEditFragment;
    }

    public static final View.OnClickListener access$getTabOnClickListener$p(EmoticonSettingActivity emoticonSettingActivity0) {
        return emoticonSettingActivity0.tabOnClickListener;
    }

    public static final void access$setBinding$p(EmoticonSettingActivity emoticonSettingActivity0, ActivityKakaoEmoticonSettingsBinding activityKakaoEmoticonSettingsBinding0) {
        emoticonSettingActivity0.binding = activityKakaoEmoticonSettingsBinding0;
    }

    @Nullable
    public final EmoticonDownloadFragment getEmoticonDownloadFragment() {
        return this.emoticonDownloadFragment;
    }

    @Nullable
    public final EmoticonEditFragment getEmoticonEditFragment() {
        return this.emoticonEditFragment;
    }

    private final void initView() {
        ActivityKakaoEmoticonSettingsBinding activityKakaoEmoticonSettingsBinding0 = this.binding;
        if(activityKakaoEmoticonSettingsBinding0 != null) {
            q.f(activityKakaoEmoticonSettingsBinding0.container, "binding.container");
            l0 l00 = this.getSupportFragmentManager();
            q.f(l00, "supportFragmentManager");
            SectionsPagerAdapter emoticonSettingActivity$SectionsPagerAdapter0 = new SectionsPagerAdapter(this, l00);
            activityKakaoEmoticonSettingsBinding0.container.setAdapter(emoticonSettingActivity$SectionsPagerAdapter0);
            ActivityKakaoEmoticonSettingsBinding activityKakaoEmoticonSettingsBinding1 = this.binding;
            if(activityKakaoEmoticonSettingsBinding1 != null) {
                com.kakao.emoticon.activity.EmoticonSettingActivity.initView.1 emoticonSettingActivity$initView$10 = new j() {
                    @Override  // androidx.viewpager.widget.j
                    public void onPageScrollStateChanged(int v) {
                    }

                    @Override  // androidx.viewpager.widget.j
                    public void onPageScrolled(int v, float f, int v1) {
                    }

                    @Override  // androidx.viewpager.widget.j
                    public void onPageSelected(int v) {
                        switch(v) {
                            case 0: {
                                ActivityKakaoEmoticonSettingsBinding activityKakaoEmoticonSettingsBinding0 = EmoticonSettingActivity.access$getBinding$p(EmoticonSettingActivity.this);
                                q.f(activityKakaoEmoticonSettingsBinding0.radioEdit, "binding.radioEdit");
                                activityKakaoEmoticonSettingsBinding0.radioEdit.setChecked(true);
                                return;
                            }
                            case 1: {
                                ActivityKakaoEmoticonSettingsBinding activityKakaoEmoticonSettingsBinding1 = EmoticonSettingActivity.access$getBinding$p(EmoticonSettingActivity.this);
                                q.f(activityKakaoEmoticonSettingsBinding1.radioDownload, "binding.radioDownload");
                                activityKakaoEmoticonSettingsBinding1.radioDownload.setChecked(true);
                                EmoticonSettingActivity.this.startDownloadRefreshing();
                            }
                        }
                    }
                };
                activityKakaoEmoticonSettingsBinding1.container.addOnPageChangeListener(emoticonSettingActivity$initView$10);
                ActivityKakaoEmoticonSettingsBinding activityKakaoEmoticonSettingsBinding2 = this.binding;
                if(activityKakaoEmoticonSettingsBinding2 != null) {
                    activityKakaoEmoticonSettingsBinding2.radioEdit.setOnClickListener(this.tabOnClickListener);
                    ActivityKakaoEmoticonSettingsBinding activityKakaoEmoticonSettingsBinding3 = this.binding;
                    if(activityKakaoEmoticonSettingsBinding3 != null) {
                        activityKakaoEmoticonSettingsBinding3.radioDownload.setOnClickListener(this.tabOnClickListener);
                        this.findViewById(id.rl_back).setOnClickListener(this.tabOnClickListener);
                        this.findViewById(id.rl_go_store).setOnClickListener(this.tabOnClickListener);
                        if(!IntentUtils.isInstalledApplication(KakaoEmoticon.getApplication(), "com.kakao.talk")) {
                            View view0 = this.findViewById(0x7F0A0A03);  // id:rl_go_store
                            q.f(view0, "findViewById<View>(R.id.rl_go_store)");
                            view0.setVisibility(8);
                        }
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
        q.m("binding");
        throw null;
    }

    @Override  // androidx.activity.ComponentActivity
    public void onBackPressed() {
        EmoticonEditFragment emoticonEditFragment0 = this.emoticonEditFragment;
        if(emoticonEditFragment0 != null) {
            emoticonEditFragment0.onBackPressed();
        }
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        ActivityKakaoEmoticonSettingsBinding activityKakaoEmoticonSettingsBinding0 = ActivityKakaoEmoticonSettingsBinding.inflate(LayoutInflater.from(this));
        q.f(activityKakaoEmoticonSettingsBinding0, "ActivityKakaoEmoticonSet…ayoutInflater.from(this))");
        this.binding = activityKakaoEmoticonSettingsBinding0;
        this.setContentView(activityKakaoEmoticonSettingsBinding0.getRoot());
        this.initView();
    }

    private final void startDownloadRefreshing() {
        if(this.isFirstSelected) {
            this.isFirstSelected = false;
            if(this.isFinishing() || this.emoticonDownloadFragment != null) {
                EmoticonDownloadFragment emoticonDownloadFragment0 = this.emoticonDownloadFragment;
                if(emoticonDownloadFragment0 != null) {
                    emoticonDownloadFragment0.startRefreshing();
                }
            }
        }
    }
}

