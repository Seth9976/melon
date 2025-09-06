package com.iloen.melon.fragments.mymusic;

import A8.M;
import G8.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.fragment.app.w;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.eventbus.EventAudioSync.Finish;
import com.iloen.melon.fragments.local.LocalContentPagerFragment;
import com.iloen.melon.fragments.local.LocalFolderListFragment;
import com.iloen.melon.fragments.local.LocalPlaylistFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.CheckProductSrcFlagReq;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v4x.response.CheckProductSrcFlagRes.RESPONSE;
import com.iloen.melon.net.v4x.response.CheckProductSrcFlagRes;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.DcfUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import d3.g;
import e.k;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r8.f;
import v9.l;
import va.e0;
import va.o;
import we.n;

@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0006*\u0001K\b\u0007\u0018\u0000 N2\u00020\u0001:\u0002NOB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0014\u00A2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\u0010\u0010\u000EJ\u0017\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u000EJ-\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001B\u001A\u00020\f2\u0006\u0010\u001A\u001A\u00020\u00172\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u0003J\u000F\u0010\u001E\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u0003J\u000F\u0010\u001F\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0003J\u0011\u0010!\u001A\u0004\u0018\u00010 H\u0014\u00A2\u0006\u0004\b!\u0010\"J\'\u0010)\u001A\u00020(2\u0006\u0010$\u001A\u00020#2\u0006\u0010&\u001A\u00020%2\u0006\u0010\'\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b)\u0010*J\u001B\u0010.\u001A\u0006\u0012\u0002\b\u00030-2\u0006\u0010,\u001A\u00020+H\u0014\u00A2\u0006\u0004\b.\u0010/J\u0017\u00102\u001A\u00020\f2\u0006\u00101\u001A\u000200H\u0007\u00A2\u0006\u0004\b2\u00103J\u000F\u00104\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b4\u0010\u0003J\u0017\u00106\u001A\u00020\f2\u0006\u00105\u001A\u00020(H\u0002\u00A2\u0006\u0004\b6\u00107J\u000F\u00108\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b8\u0010\u0003R\"\u0010:\u001A\u0002098\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b:\u0010;\u001A\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010@\u001A\u00020(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001A\u00020(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010AR\u0016\u0010C\u001A\u00020(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010D\u001A\u00020(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010AR\u0014\u0010F\u001A\u00020E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001A\u00020H8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001A\u00020K8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bL\u0010M\u00A8\u0006P"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/LockerFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "inState", "onRestoreInstanceState", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onStop", "onResume", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lcom/iloen/melon/eventbus/EventAudioSync$Finish;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventAudioSync$Finish;)V", "registerIsLoginFlow", "isLogin", "setUIWithLogin", "(Z)V", "startMediaScan", "Lmb/k;", "loginUseCase", "Lmb/k;", "getLoginUseCase", "()Lmb/k;", "setLoginUseCase", "(Lmb/k;)V", "mIsPurchaseOpen", "Z", "mIsSaveContentOpen", "mIsPurchaseStreamingShow", "mIsLogin", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "", "updateTime", "J", "com/iloen/melon/fragments/mymusic/LockerFragment$mScanStatusListener$1", "mScanStatusListener", "Lcom/iloen/melon/fragments/mymusic/LockerFragment$mScanStatusListener$1;", "Companion", "LockerAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LockerFragment extends Hilt_LockerFragment {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u0019H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00020\tX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\tX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0014\u0010\u000E\u001A\u00020\tX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000BR\u0014\u0010\u0010\u001A\u00020\tX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000BR\u0014\u0010\u0012\u001A\u00020\tX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000BR\u0014\u0010\u0014\u001A\u00020\tX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u000B¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/LockerFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_PURCHASE_OPEN", "ARG_SAVE_CONTENT_OPEN", "VIEW_TYPE_TITLE", "", "getVIEW_TYPE_TITLE", "()I", "VIEW_TYPE_DETAIL", "getVIEW_TYPE_DETAIL", "VIEW_TYPE_NONE_SHOW", "getVIEW_TYPE_NONE_SHOW", "VIEW_TYPE_FOOTER", "getVIEW_TYPE_FOOTER", "GROUP_PURCHASE", "getGROUP_PURCHASE", "GROUP_SAVE", "getGROUP_SAVE", "newInstance", "Lcom/iloen/melon/fragments/mymusic/LockerFragment;", "isPurchaseOpen", "", "isSaveContentOpen", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(20)
        public final int getGROUP_PURCHASE() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        public final int getGROUP_SAVE() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        public final int getVIEW_TYPE_DETAIL() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        public final int getVIEW_TYPE_FOOTER() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        public final int getVIEW_TYPE_NONE_SHOW() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        public final int getVIEW_TYPE_TITLE() [...] // 潜在的解密器

        @NotNull
        public final LockerFragment newInstance(boolean z, boolean z1) {
            LockerFragment lockerFragment0 = new LockerFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("argPurchaseOpen", z);
            bundle0.putBoolean("argSaveContentOpen", z1);
            lockerFragment0.setArguments(bundle0);
            return lockerFragment0;
        }

        public static LockerFragment newInstance$default(Companion lockerFragment$Companion0, boolean z, boolean z1, int v, Object object0) {
            if((v & 1) != 0) {
                z = false;
            }
            if((v & 2) != 0) {
                z1 = false;
            }
            return lockerFragment$Companion0.newInstance(z, z1);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001E\u001F !B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\f\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R!\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00150\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C¨\u0006\""}, d2 = {"Lcom/iloen/melon/fragments/mymusic/LockerFragment$LockerAdapter;", "Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/O0;", "<init>", "(Lcom/iloen/melon/fragments/mymusic/LockerFragment;)V", "", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "holder", "Lie/H;", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;I)V", "getItemCount", "()I", "", "Lv9/l;", "purchaseItems", "Ljava/util/List;", "saveBaseItems", "items$delegate", "Lie/j;", "getItems", "()Ljava/util/List;", "items", "LockerTitleItemViewHolder", "LockerDetailViewHolder", "LockerUpdateViewHolder", "LockerNonShowViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LockerAdapter extends j0 {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001A\u00020\u00028\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\"\u0010\r\u001A\u00020\f8\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/LockerFragment$LockerAdapter$LockerDetailViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/mymusic/LockerFragment$LockerAdapter;Landroid/view/View;)V", "detailViewLayout", "Landroid/view/View;", "getDetailViewLayout$app_playstoreProdRelease", "()Landroid/view/View;", "setDetailViewLayout$app_playstoreProdRelease", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "tvDetail", "Landroid/widget/TextView;", "getTvDetail$app_playstoreProdRelease", "()Landroid/widget/TextView;", "setTvDetail$app_playstoreProdRelease", "(Landroid/widget/TextView;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class LockerDetailViewHolder extends O0 {
            @NotNull
            private View detailViewLayout;
            @NotNull
            private TextView tvDetail;

            public LockerDetailViewHolder(@NotNull View view0) {
                q.g(view0, "itemView");
                LockerAdapter.this = lockerFragment$LockerAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A03BC);  // id:detail_layout
                q.f(view1, "findViewById(...)");
                this.detailViewLayout = view1;
                View view2 = view0.findViewById(0x7F0A03BF);  // id:detail_tv
                q.e(view2, "null cannot be cast to non-null type android.widget.TextView");
                this.tvDetail = (TextView)view2;
            }

            @NotNull
            public final View getDetailViewLayout$app_playstoreProdRelease() {
                return this.detailViewLayout;
            }

            @NotNull
            public final TextView getTvDetail$app_playstoreProdRelease() {
                return this.tvDetail;
            }

            public final void setDetailViewLayout$app_playstoreProdRelease(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.detailViewLayout = view0;
            }

            public final void setTvDetail$app_playstoreProdRelease(@NotNull TextView textView0) {
                q.g(textView0, "<set-?>");
                this.tvDetail = textView0;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/LockerFragment$LockerAdapter$LockerNonShowViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/mymusic/LockerFragment$LockerAdapter;Landroid/view/View;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class LockerNonShowViewHolder extends O0 {
            public LockerNonShowViewHolder(@NotNull View view0) {
                q.g(view0, "itemView");
                LockerAdapter.this = lockerFragment$LockerAdapter0;
                super(view0);
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001A\u00020\u00028\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\"\u0010\f\u001A\u00020\u00028\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001A\u0004\b\r\u0010\t\"\u0004\b\u000E\u0010\u000BR\"\u0010\u0010\u001A\u00020\u000F8\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001A\u00020\u00168\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\"\u0010\u001D\u001A\u00020\u00168\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u001D\u0010\u0018\u001A\u0004\b\u001E\u0010\u001A\"\u0004\b\u001F\u0010\u001C¨\u0006 "}, d2 = {"Lcom/iloen/melon/fragments/mymusic/LockerFragment$LockerAdapter$LockerTitleItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/mymusic/LockerFragment$LockerAdapter;Landroid/view/View;)V", "titleLayout", "Landroid/view/View;", "getTitleLayout$app_playstoreProdRelease", "()Landroid/view/View;", "setTitleLayout$app_playstoreProdRelease", "(Landroid/view/View;)V", "underLine", "getUnderLine$app_playstoreProdRelease", "setUnderLine$app_playstoreProdRelease", "Landroid/widget/TextView;", "tvItem", "Landroid/widget/TextView;", "getTvItem$app_playstoreProdRelease", "()Landroid/widget/TextView;", "setTvItem$app_playstoreProdRelease", "(Landroid/widget/TextView;)V", "Landroid/widget/ImageView;", "ivIcon", "Landroid/widget/ImageView;", "getIvIcon$app_playstoreProdRelease", "()Landroid/widget/ImageView;", "setIvIcon$app_playstoreProdRelease", "(Landroid/widget/ImageView;)V", "ivArrow", "getIvArrow$app_playstoreProdRelease", "setIvArrow$app_playstoreProdRelease", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class LockerTitleItemViewHolder extends O0 {
            @NotNull
            private ImageView ivArrow;
            @NotNull
            private ImageView ivIcon;
            @NotNull
            private View titleLayout;
            @NotNull
            private TextView tvItem;
            @NotNull
            private View underLine;

            public LockerTitleItemViewHolder(@NotNull View view0) {
                q.g(view0, "itemView");
                LockerAdapter.this = lockerFragment$LockerAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0D6A);  // id:under_line
                q.f(view1, "findViewById(...)");
                this.underLine = view1;
                View view2 = view0.findViewById(0x7F0A0B9E);  // id:title_layout
                q.f(view2, "findViewById(...)");
                this.titleLayout = view2;
                View view3 = view0.findViewById(0x7F0A05D3);  // id:item_tv
                q.e(view3, "null cannot be cast to non-null type android.widget.TextView");
                this.tvItem = (TextView)view3;
                View view4 = view0.findViewById(0x7F0A07A7);  // id:locker_img
                q.e(view4, "null cannot be cast to non-null type android.widget.ImageView");
                this.ivIcon = (ImageView)view4;
                View view5 = view0.findViewById(0x7F0A077B);  // id:list_arrow_iv
                q.e(view5, "null cannot be cast to non-null type android.widget.ImageView");
                this.ivArrow = (ImageView)view5;
            }

            @NotNull
            public final ImageView getIvArrow$app_playstoreProdRelease() {
                return this.ivArrow;
            }

            @NotNull
            public final ImageView getIvIcon$app_playstoreProdRelease() {
                return this.ivIcon;
            }

            @NotNull
            public final View getTitleLayout$app_playstoreProdRelease() {
                return this.titleLayout;
            }

            @NotNull
            public final TextView getTvItem$app_playstoreProdRelease() {
                return this.tvItem;
            }

            @NotNull
            public final View getUnderLine$app_playstoreProdRelease() {
                return this.underLine;
            }

            public final void setIvArrow$app_playstoreProdRelease(@NotNull ImageView imageView0) {
                q.g(imageView0, "<set-?>");
                this.ivArrow = imageView0;
            }

            public final void setIvIcon$app_playstoreProdRelease(@NotNull ImageView imageView0) {
                q.g(imageView0, "<set-?>");
                this.ivIcon = imageView0;
            }

            public final void setTitleLayout$app_playstoreProdRelease(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.titleLayout = view0;
            }

            public final void setTvItem$app_playstoreProdRelease(@NotNull TextView textView0) {
                q.g(textView0, "<set-?>");
                this.tvItem = textView0;
            }

            public final void setUnderLine$app_playstoreProdRelease(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.underLine = view0;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001A\u00020\u00068\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\"\u0010\r\u001A\u00020\u00028\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001A\u00020\u00028\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u0013\u0010\u000E\u001A\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/LockerFragment$LockerAdapter$LockerUpdateViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/mymusic/LockerFragment$LockerAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "tvUpdate", "Landroid/widget/TextView;", "getTvUpdate$app_playstoreProdRelease", "()Landroid/widget/TextView;", "setTvUpdate$app_playstoreProdRelease", "(Landroid/widget/TextView;)V", "updateLayout", "Landroid/view/View;", "getUpdateLayout$app_playstoreProdRelease", "()Landroid/view/View;", "setUpdateLayout$app_playstoreProdRelease", "(Landroid/view/View;)V", "footerDesc2", "getFooterDesc2$app_playstoreProdRelease", "setFooterDesc2$app_playstoreProdRelease", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class LockerUpdateViewHolder extends O0 {
            @NotNull
            private View footerDesc2;
            @NotNull
            private TextView tvUpdate;
            @NotNull
            private View updateLayout;

            public LockerUpdateViewHolder(@NotNull View view0) {
                q.g(view0, "itemView");
                LockerAdapter.this = lockerFragment$LockerAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0D77);  // id:update_layout
                q.f(view1, "findViewById(...)");
                this.updateLayout = view1;
                View view2 = view0.findViewById(0x7F0A0D78);  // id:update_tv
                q.e(view2, "null cannot be cast to non-null type android.widget.TextView");
                this.tvUpdate = (TextView)view2;
                View view3 = view0.findViewById(0x7F0A071D);  // id:layout_footer_desc2
                q.f(view3, "findViewById(...)");
                this.footerDesc2 = view3;
            }

            @NotNull
            public final View getFooterDesc2$app_playstoreProdRelease() {
                return this.footerDesc2;
            }

            @NotNull
            public final TextView getTvUpdate$app_playstoreProdRelease() {
                return this.tvUpdate;
            }

            @NotNull
            public final View getUpdateLayout$app_playstoreProdRelease() {
                return this.updateLayout;
            }

            public final void setFooterDesc2$app_playstoreProdRelease(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.footerDesc2 = view0;
            }

            public final void setTvUpdate$app_playstoreProdRelease(@NotNull TextView textView0) {
                q.g(textView0, "<set-?>");
                this.tvUpdate = textView0;
            }

            public final void setUpdateLayout$app_playstoreProdRelease(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.updateLayout = view0;
            }
        }

        @NotNull
        private final j items$delegate;
        @NotNull
        private final List purchaseItems;
        @NotNull
        private final List saveBaseItems;

        public LockerAdapter() {
            this.purchaseItems = k.A(new l[]{l.f, l.g, l.h, l.i, l.j});
            this.saveBaseItems = k.A(new l[]{l.k, l.l, l.m, l.n, l.o});
            this.items$delegate = g.Q(new com.iloen.melon.fragments.mymusic.k(this, 0));
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemCount() {
            return this.getItems().size();
        }

        // 去混淆评级： 低(32)
        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            if(((l)this.getItems().get(v)).b == 100 && !LockerFragment.this.mIsLogin) {
                return 2;
            }
            if(((l)this.getItems().get(v)).a == 1) {
                if(((l)this.getItems().get(v)).equals(l.h)) {
                    return !LockerFragment.this.mIsPurchaseOpen || !LockerFragment.this.mIsPurchaseStreamingShow ? 2 : 1;
                }
                if(((l)this.getItems().get(v)).b == 100) {
                    return LockerFragment.this.mIsPurchaseOpen ? 1 : 2;
                }
                return ((l)this.getItems().get(v)).b != 101 || !LockerFragment.this.mIsSaveContentOpen ? 2 : 1;
            }
            return ((l)this.getItems().get(v)).a;
        }

        private final List getItems() {
            return (List)this.items$delegate.getValue();
        }

        private static final ArrayList items_delegate$lambda$1(LockerAdapter lockerFragment$LockerAdapter0) {
            ArrayList arrayList0 = new ArrayList();
            arrayList0.addAll(lockerFragment$LockerAdapter0.purchaseItems);
            arrayList0.addAll(lockerFragment$LockerAdapter0.saveBaseItems);
            if(!StorageUtils.isScopedStorage()) {
                arrayList0.add(l.p);
            }
            arrayList0.add(l.q);
            arrayList0.add(l.r);
            arrayList0.add(l.s);
            return arrayList0;
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onBindViewHolder(@NotNull O0 o00, int v) {
            q.g(o00, "holder");
            if(o00 instanceof LockerTitleItemViewHolder) {
                ((LockerTitleItemViewHolder)o00).getTvItem$app_playstoreProdRelease().setText(((l)this.getItems().get(v)).c);
                ((LockerTitleItemViewHolder)o00).getIvIcon$app_playstoreProdRelease().setImageResource(((l)this.getItems().get(v)).d);
                l l0 = (l)this.getItems().get(v);
                ViewUtils.showWhen(((LockerTitleItemViewHolder)o00).getIvArrow$app_playstoreProdRelease(), l0.e);
                if(l0.equals(l.f)) {
                    ViewUtils.hideWhen(((LockerTitleItemViewHolder)o00).getUnderLine$app_playstoreProdRelease(), LockerFragment.this.mIsLogin);
                    if(LockerFragment.this.mIsPurchaseOpen) {
                        ((LockerTitleItemViewHolder)o00).getIvArrow$app_playstoreProdRelease().setBackgroundResource(0x7F080095);  // drawable:arrow_list_close_s
                    }
                    else {
                        ((LockerTitleItemViewHolder)o00).getIvArrow$app_playstoreProdRelease().setBackgroundResource(0x7F080098);  // drawable:arrow_list_open_s
                    }
                    ViewUtils.setOnClickListener(((LockerTitleItemViewHolder)o00).getTitleLayout$app_playstoreProdRelease(), new h(LockerFragment.this, this, v, 0));
                    return;
                }
                if(l0.equals(l.k)) {
                    ViewUtils.hideWhen(((LockerTitleItemViewHolder)o00).getUnderLine$app_playstoreProdRelease(), !LockerFragment.this.mIsLogin);
                    if(LockerFragment.this.mIsSaveContentOpen) {
                        ((LockerTitleItemViewHolder)o00).getIvArrow$app_playstoreProdRelease().setBackgroundResource(0x7F080095);  // drawable:arrow_list_close_s
                    }
                    else {
                        ((LockerTitleItemViewHolder)o00).getIvArrow$app_playstoreProdRelease().setBackgroundResource(0x7F080098);  // drawable:arrow_list_open_s
                    }
                    ViewUtils.setOnClickListener(((LockerTitleItemViewHolder)o00).getTitleLayout$app_playstoreProdRelease(), new h(LockerFragment.this, this, v, 1));
                    return;
                }
                if(l0.equals(l.q)) {
                    ViewUtils.setOnClickListener(((LockerTitleItemViewHolder)o00).getTitleLayout$app_playstoreProdRelease(), new i(6));
                    return;
                }
                if(l0.equals(l.r)) {
                    ViewUtils.setOnClickListener(((LockerTitleItemViewHolder)o00).getTitleLayout$app_playstoreProdRelease(), new com.iloen.melon.fragments.mymusic.j(LockerFragment.this, 1));
                }
            }
            else if(o00 instanceof LockerDetailViewHolder) {
                l l1 = (l)this.getItems().get(v);
                ((LockerDetailViewHolder)o00).getTvDetail$app_playstoreProdRelease().setText(l1.c);
                if(l1.equals(l.g)) {
                    ViewUtils.setOnClickListener(((LockerDetailViewHolder)o00).getDetailViewLayout$app_playstoreProdRelease(), new i(7));
                    return;
                }
                if(l1.equals(l.h)) {
                    ViewUtils.showWhen(((LockerDetailViewHolder)o00).getDetailViewLayout$app_playstoreProdRelease(), LockerFragment.this.mIsPurchaseStreamingShow);
                    ViewUtils.setOnClickListener(((LockerDetailViewHolder)o00).getDetailViewLayout$app_playstoreProdRelease(), new i(8));
                    return;
                }
                if(l1.equals(l.i)) {
                    ViewUtils.setOnClickListener(((LockerDetailViewHolder)o00).getDetailViewLayout$app_playstoreProdRelease(), new i(0));
                    return;
                }
                if(l1.equals(l.j)) {
                    ViewUtils.setOnClickListener(((LockerDetailViewHolder)o00).getDetailViewLayout$app_playstoreProdRelease(), new i(1));
                    return;
                }
                if(l1.equals(l.l)) {
                    ViewUtils.setOnClickListener(((LockerDetailViewHolder)o00).getDetailViewLayout$app_playstoreProdRelease(), new com.iloen.melon.fragments.mymusic.j(LockerFragment.this, 0));
                    return;
                }
                if(l1.equals(l.m)) {
                    ViewUtils.setOnClickListener(((LockerDetailViewHolder)o00).getDetailViewLayout$app_playstoreProdRelease(), new i(2));
                    return;
                }
                if(l1.equals(l.n)) {
                    ViewUtils.setOnClickListener(((LockerDetailViewHolder)o00).getDetailViewLayout$app_playstoreProdRelease(), new i(3));
                    return;
                }
                if(l1.equals(l.o)) {
                    ViewUtils.setOnClickListener(((LockerDetailViewHolder)o00).getDetailViewLayout$app_playstoreProdRelease(), new i(4));
                    return;
                }
                if(l1.equals(l.p)) {
                    ViewUtils.setOnClickListener(((LockerDetailViewHolder)o00).getDetailViewLayout$app_playstoreProdRelease(), new i(5));
                }
            }
            else if(o00 instanceof LockerUpdateViewHolder) {
                ViewUtils.setOnClickListener(((LockerUpdateViewHolder)o00).getTvUpdate$app_playstoreProdRelease(), new e(1, LockerFragment.this, this));
                ViewUtils.showWhen(((LockerUpdateViewHolder)o00).getFooterDesc2$app_playstoreProdRelease(), StorageUtils.isScopedStorage());
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
            @oe.e(c = "com.iloen.melon.fragments.mymusic.LockerFragment$LockerAdapter$onBindViewHolder$4$1", f = "LockerFragment.kt", l = {357}, m = "invokeSuspend")
            final class com.iloen.melon.fragments.mymusic.LockerFragment.LockerAdapter.onBindViewHolder.4.1 extends oe.i implements n {
                Object L$0;
                int label;

                public com.iloen.melon.fragments.mymusic.LockerFragment.LockerAdapter.onBindViewHolder.4.1(LockerFragment lockerFragment0, Continuation continuation0) {
                    LockerFragment.this = lockerFragment0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.mymusic.LockerFragment.LockerAdapter.onBindViewHolder.4.1(LockerFragment.this, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.mymusic.LockerFragment.LockerAdapter.onBindViewHolder.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            Flow flow0 = FlowKt.flow(new b(2, null));  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                            this.L$0 = null;
                            this.label = 1;
                            object0 = FlowKt.first(flow0, this);
                            if(object0 == a0) {
                                return a0;
                            }
                            break;
                        }
                        case 1: {
                            Flow flow1 = (Flow)this.L$0;
                            d5.n.D(object0);
                            break;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    if(((Boolean)object0).booleanValue()) {
                        FragmentActivity fragmentActivity0 = LockerFragment.this.requireActivity();
                        q.f(fragmentActivity0, "requireActivity(...)");
                        G8.e.b(fragmentActivity0, false);
                        return H.a;
                    }
                    DcfUtils.executeDcfExtension();
                    return H.a;
                }
            }


            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
            @oe.e(c = "com.iloen.melon.fragments.mymusic.LockerFragment$LockerAdapter$onBindViewHolder$9$1", f = "LockerFragment.kt", l = {398}, m = "invokeSuspend")
            final class com.iloen.melon.fragments.mymusic.LockerFragment.LockerAdapter.onBindViewHolder.9.1 extends oe.i implements n {
                Object L$0;
                int label;

                public com.iloen.melon.fragments.mymusic.LockerFragment.LockerAdapter.onBindViewHolder.9.1(LockerFragment lockerFragment0, Continuation continuation0) {
                    LockerFragment.this = lockerFragment0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.mymusic.LockerFragment.LockerAdapter.onBindViewHolder.9.1(LockerFragment.this, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.mymusic.LockerFragment.LockerAdapter.onBindViewHolder.9.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            Flow flow0 = FlowKt.flow(new b(2, null));  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                            this.L$0 = null;
                            this.label = 1;
                            object0 = FlowKt.first(flow0, this);
                            if(object0 == a0) {
                                return a0;
                            }
                            break;
                        }
                        case 1: {
                            Flow flow1 = (Flow)this.L$0;
                            d5.n.D(object0);
                            break;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    if(((Boolean)object0).booleanValue() && !G8.e.a()) {
                        FragmentActivity fragmentActivity0 = LockerFragment.this.requireActivity();
                        q.f(fragmentActivity0, "requireActivity(...)");
                        G8.e.b(fragmentActivity0, false);
                        return H.a;
                    }
                    LocalPlaylistFragment.Companion.newInstance().open();
                    return H.a;
                }
            }

        }

        private static final void onBindViewHolder$lambda$10(LockerFragment lockerFragment0, View view0) {
            D d0 = lockerFragment0.getViewLifecycleOwner();
            q.f(d0, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new com.iloen.melon.fragments.mymusic.LockerFragment.LockerAdapter.onBindViewHolder.9.1(lockerFragment0, null), 3, null);
        }

        private static final void onBindViewHolder$lambda$11(View view0) {
            LocalContentPagerFragment.newInstanceForSong().open();
        }

        private static final void onBindViewHolder$lambda$12(View view0) {
            LocalContentPagerFragment.newInstanceForFlac().open();
        }

        private static final void onBindViewHolder$lambda$13(View view0) {
            Navigator.INSTANCE.openLocalContentMv();
        }

        private static final void onBindViewHolder$lambda$14(View view0) {
            LocalFolderListFragment.Companion.newInstance().open();
        }

        private static final void onBindViewHolder$lambda$15(LockerFragment lockerFragment0, LockerAdapter lockerFragment$LockerAdapter0, View view0) {
            lockerFragment0.updateTime = System.currentTimeMillis();
            lockerFragment0.startMediaScan();
            lockerFragment$LockerAdapter0.notifyDataSetChanged();
        }

        private static final void onBindViewHolder$lambda$2(LockerFragment lockerFragment0, LockerAdapter lockerFragment$LockerAdapter0, int v, View view0) {
            lockerFragment0.mIsPurchaseOpen = !lockerFragment0.mIsPurchaseOpen;
            lockerFragment$LockerAdapter0.notifyItemChanged(v);
        }

        private static final void onBindViewHolder$lambda$3(LockerFragment lockerFragment0, LockerAdapter lockerFragment$LockerAdapter0, int v, View view0) {
            lockerFragment0.mIsSaveContentOpen = !lockerFragment0.mIsSaveContentOpen;
            lockerFragment$LockerAdapter0.notifyItemChanged(v);
        }

        private static final void onBindViewHolder$lambda$4(View view0) {
            if(((e0)o.a()).m()) {
                Navigator.INSTANCE.openDownloadManager();
                return;
            }
            Navigator.openLoginView(f.f);
        }

        private static final void onBindViewHolder$lambda$5(LockerFragment lockerFragment0, View view0) {
            D d0 = lockerFragment0.getViewLifecycleOwner();
            q.f(d0, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new com.iloen.melon.fragments.mymusic.LockerFragment.LockerAdapter.onBindViewHolder.4.1(lockerFragment0, null), 3, null);
        }

        private static final void onBindViewHolder$lambda$6(View view0) {
            Navigator.openUrl(M.z, OpenType.DefaultWebViewWithMiniPlayer);
        }

        private static final void onBindViewHolder$lambda$7(View view0) {
            Navigator.openUrl(M.A, OpenType.DefaultWebViewWithMiniPlayer);
        }

        private static final void onBindViewHolder$lambda$8(View view0) {
            Navigator.openUrl(M.C, OpenType.DefaultWebViewWithMiniPlayer);
        }

        private static final void onBindViewHolder$lambda$9(View view0) {
            Navigator.openUrl(M.B, OpenType.DefaultWebViewWithMiniPlayer);
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == 0) {
                View view0 = LayoutInflater.from(LockerFragment.this.getContext()).inflate(0x7F0D0568, viewGroup0, false);  // layout:mymusic_locker_item
                q.f(view0, "inflate(...)");
                return new LockerTitleItemViewHolder(this, view0);
            }
            switch(v) {
                case 1: {
                    View view2 = LayoutInflater.from(LockerFragment.this.getContext()).inflate(0x7F0D0567, viewGroup0, false);  // layout:mymusic_locker_detail_item
                    q.f(view2, "inflate(...)");
                    return new LockerDetailViewHolder(this, view2);
                }
                case 3: {
                    View view3 = LayoutInflater.from(LockerFragment.this.getContext()).inflate(0x7F0D056A, viewGroup0, false);  // layout:mymusic_locker_update
                    q.f(view3, "inflate(...)");
                    return new LockerUpdateViewHolder(this, view3);
                }
                default: {
                    View view1 = LayoutInflater.from(LockerFragment.this.getContext()).inflate(0x7F0D048F, viewGroup0, false);  // layout:listitem_emtpy_space
                    q.f(view1, "inflate(...)");
                    return new LockerNonShowViewHolder(this, view1);
                }
            }
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_PURCHASE_OPEN;
    @NotNull
    private static final String ARG_SAVE_CONTENT_OPEN;
    @NotNull
    public static final Companion Companion;
    private static final int GROUP_PURCHASE;
    private static final int GROUP_SAVE;
    @NotNull
    private static final String TAG;
    private static final int VIEW_TYPE_DETAIL;
    private static final int VIEW_TYPE_FOOTER;
    private static final int VIEW_TYPE_NONE_SHOW;
    private static final int VIEW_TYPE_TITLE;
    @NotNull
    private final LogU log;
    @Inject
    public mb.k loginUseCase;
    private boolean mIsLogin;
    private boolean mIsPurchaseOpen;
    private boolean mIsPurchaseStreamingShow;
    private boolean mIsSaveContentOpen;
    @NotNull
    private final com.iloen.melon.fragments.mymusic.LockerFragment.mScanStatusListener.1 mScanStatusListener;
    private long updateTime;

    static {
        LockerFragment.Companion = new Companion(null);
        LockerFragment.$stable = 8;
        LockerFragment.TAG = "LockerFragment";
        LockerFragment.ARG_PURCHASE_OPEN = "argPurchaseOpen";
        LockerFragment.ARG_SAVE_CONTENT_OPEN = "argSaveContentOpen";
        LockerFragment.VIEW_TYPE_DETAIL = 1;
        LockerFragment.VIEW_TYPE_NONE_SHOW = 2;
        LockerFragment.VIEW_TYPE_FOOTER = 3;
        LockerFragment.GROUP_PURCHASE = 100;
        LockerFragment.GROUP_SAVE = 101;
    }

    public LockerFragment() {
        this.log = new LogU("LockerFragment");
        this.mScanStatusListener = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context context0, Intent intent0) {
                q.g(context0, "context");
                q.g(intent0, "intent");
                String s = intent0.getAction();
                LogU.Companion.d("LockerFragment", "onReceive() intent: " + intent0);
                if("com.iloen.melon.intent.action.MEDIA_SCANNER_COMPLETED".equals(s)) {
                    l0 l00 = LockerFragment.this.getParentFragmentManager();
                    if(l00 != null && !l00.T() && !l00.K) {
                        l00.C();
                        vd.e e0 = null;
                        w w0 = com.melon.ui.popup.b.b(l00, "BlockingProgressDialogFragment", null, null, 12);
                        if(w0 != null) {
                            if(w0 instanceof vd.e) {
                                e0 = (vd.e)w0;
                            }
                            if(e0 != null) {
                                e0.dismissAllowingStateLoss();
                            }
                        }
                    }
                }
            }
        };
    }

    public static final String access$getARG_PURCHASE_OPEN$cp() [...] // 潜在的解密器

    public static final String access$getARG_SAVE_CONTENT_OPEN$cp() [...] // 潜在的解密器

    public static final int access$getGROUP_PURCHASE$cp() [...] // 潜在的解密器

    public static final int access$getGROUP_SAVE$cp() [...] // 潜在的解密器

    public static final String access$getTAG$cp() [...] // 潜在的解密器

    public static final int access$getVIEW_TYPE_DETAIL$cp() [...] // 潜在的解密器

    public static final int access$getVIEW_TYPE_FOOTER$cp() [...] // 潜在的解密器

    public static final int access$getVIEW_TYPE_NONE_SHOW$cp() [...] // 潜在的解密器

    public static final int access$getVIEW_TYPE_TITLE$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new LockerAdapter(this);
    }

    public static void d0(LockerFragment lockerFragment0, CheckProductSrcFlagRes checkProductSrcFlagRes0) {
        LockerFragment.onResume$lambda$1(lockerFragment0, checkProductSrcFlagRes0);
    }

    public static void e0(VolleyError volleyError0) {
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.N.toString();
        q.f(s, "toString(...)");
        return s;
    }

    @NotNull
    public final mb.k getLoginUseCase() {
        mb.k k0 = this.loginUseCase;
        if(k0 != null) {
            return k0;
        }
        q.m("loginUseCase");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @Nullable
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "mymusicStoragebox");
    }

    @NotNull
    public static final LockerFragment newInstance(boolean z, boolean z1) {
        return LockerFragment.Companion.newInstance(z, z1);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.setUIWithLogin(this.isLoginUser());
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        RecyclerView recyclerView0 = view0 instanceof RecyclerView ? ((RecyclerView)view0) : null;
        if(recyclerView0 != null) {
            recyclerView0.setHasFixedSize(true);
        }
        if(recyclerView0 != null) {
            recyclerView0.setLayoutManager(new LinearLayoutManager(this.getContext()));
        }
        if(recyclerView0 != null) {
            recyclerView0.setAdapter(this.mAdapter);
        }
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0569, viewGroup0, false);  // layout:mymusic_locker_recyclerview
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull Finish eventAudioSync$Finish0) {
        q.g(eventAudioSync$Finish0, "event");
        vd.e e0 = null;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new G8.k(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        LogConstantsKt.debug(this.log, "event() EventAudioSync.Finish complete", this.updateTime);
        if(eventAudioSync$Finish0.getType() <= 2) {
            l0 l00 = this.getParentFragmentManager();
            if(l00 != null && !l00.T() && !l00.K) {
                l00.C();
                w w0 = com.melon.ui.popup.b.b(l00, "BlockingProgressDialogFragment", null, null, 12);
                if(w0 != null) {
                    if(w0 instanceof vd.e) {
                        e0 = (vd.e)w0;
                    }
                    if(e0 != null) {
                        e0.dismissAllowingStateLoss();
                    }
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull v9.i i0, @NotNull v9.h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.mIsPurchaseOpen = bundle0.getBoolean("argPurchaseOpen");
        this.mIsSaveContentOpen = bundle0.getBoolean("argSaveContentOpen");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        RequestBuilder.newInstance(new CheckProductSrcFlagReq(this.getContext(), "PPS")).tag("LockerFragment").listener(new B(this, 6)).errorListener(new W(5)).request();
    }

    private static final void onResume$lambda$1(LockerFragment lockerFragment0, CheckProductSrcFlagRes checkProductSrcFlagRes0) {
        if(lockerFragment0.isFragmentValid() && checkProductSrcFlagRes0 != null && checkProductSrcFlagRes0.isSuccessful()) {
            RESPONSE checkProductSrcFlagRes$RESPONSE0 = checkProductSrcFlagRes0.response;
            if(checkProductSrcFlagRes$RESPONSE0 != null) {
                lockerFragment0.mIsPurchaseStreamingShow = checkProductSrcFlagRes$RESPONSE0.hasSrc;
                lockerFragment0.mAdapter.notifyDataSetChanged();
            }
        }
    }

    private static final void onResume$lambda$2(VolleyError volleyError0) {
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putBoolean("argPurchaseOpen", this.mIsPurchaseOpen);
        bundle0.putBoolean("argSaveContentOpen", this.mIsSaveContentOpen);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("com.iloen.melon.intent.action.MEDIA_SCANNER_COMPLETED");
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            E9.w.S(fragmentActivity0, this.mScanStatusListener, intentFilter0, "com.iloen.melon.permission.SIG_PERMISSION");
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        super.onStop();
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            fragmentActivity0.unregisterReceiver(this.mScanStatusListener);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.getString(0x7F130775));  // string:mymusic_menu_download "다운로드"
            titleBar0.f(true);
        }
        this.registerIsLoginFlow();
    }

    private final void registerIsLoginFlow() {
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            int label;

            {
                LockerFragment.this = lockerFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.mymusic.LockerFragment.registerIsLoginFlow.1(LockerFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.mymusic.LockerFragment.registerIsLoginFlow.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = FlowKt.drop(FlowKt.distinctUntilChanged(((e0)LockerFragment.this.getLoginUseCase()).n()), 1);
                        com.iloen.melon.fragments.mymusic.LockerFragment.registerIsLoginFlow.1.1 lockerFragment$registerIsLoginFlow$1$10 = new n(null) {
                            boolean Z$0;
                            int label;

                            {
                                LockerFragment.this = lockerFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.mymusic.LockerFragment.registerIsLoginFlow.1.1(LockerFragment.this, continuation0);
                                continuation1.Z$0 = ((Boolean)object0).booleanValue();
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.mymusic.LockerFragment.registerIsLoginFlow.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                boolean z = this.Z$0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                LogU logU0 = new LogU("LockerFragment");
                                logU0.setCategory(Category.Login);
                                logU0.setUseThreadInfo(true);
                                LogU.debug$default(logU0, "LockerFragment - isLogin: " + z, null, false, 6, null);
                                LockerFragment.this.setUIWithLogin(z);
                                return H.a;
                            }
                        };
                        this.label = 1;
                        return FlowKt.collectLatest(flow0, lockerFragment$registerIsLoginFlow$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    public final void setLoginUseCase(@NotNull mb.k k0) {
        q.g(k0, "<set-?>");
        this.loginUseCase = k0;
    }

    private final void setUIWithLogin(boolean z) {
        this.mIsLogin = z;
        this.mAdapter.notifyDataSetChanged();
    }

    private final void startMediaScan() {
        if(!this.isFragmentValid()) {
            LogU.Companion.w("LockerFragment", "startMediaScan() invalid fragment");
            return;
        }
        l0 l00 = this.getParentFragmentManager();
        String s = this.getString(0x7F130984);  // string:setting_file_management_update_dialog_msg "파일 목록 업데이트 중입니다.\n잠시만 기다려 주세요."
        if(l00 != null && !l00.T() && !l00.K) {
            l00.C();
            if(com.melon.ui.popup.b.b(l00, "BlockingProgressDialogFragment", null, new sd.j(7), 4) == null) {
                vd.e e0 = new vd.e();
                e0.f = s;
                e0.showNow(l00, "BlockingProgressDialogFragment");
            }
        }
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        I8.e.b(context0, "From locker fragment.", true);
    }
}

