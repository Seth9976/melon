package com.iloen.melon.fragments.musicmessage;

import B.a;
import Cc.P0;
import F8.x;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.f0;
import androidx.fragment.app.l0;
import androidx.media3.session.H0;
import androidx.media3.session.a0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.iloen.melon.activity.FriendSelectActivity;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.common.TargetMemberInfoBase;
import com.iloen.melon.net.v4x.request.MusicMessageDeleteMusicMsgInboxReq;
import com.iloen.melon.net.v4x.response.MusicMessageDeleteMusicMsgInboxRes;
import com.iloen.melon.net.v6x.request.MusicMessageDeleteBanUserReq;
import com.iloen.melon.net.v6x.request.MusicMessageInsertBanUserReq.Params;
import com.iloen.melon.net.v6x.request.MusicMessageInsertBanUserReq;
import com.iloen.melon.net.v6x.request.MusicMessageListMusicMsgInboxReq;
import com.iloen.melon.net.v6x.response.MusicMessageDeleteBanUserRes;
import com.iloen.melon.net.v6x.response.MusicMessageInsertBanUserRes;
import com.iloen.melon.net.v6x.response.MusicMessageListMusicMsgInboxRes.RESPONSE.INBOXLIST.TARGETMEMBERINFOLIST;
import com.iloen.melon.net.v6x.response.MusicMessageListMusicMsgInboxRes.RESPONSE.INBOXLIST;
import com.iloen.melon.net.v6x.response.MusicMessageListMusicMsgInboxRes;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.B1;
import com.melon.ui.K1;
import com.melon.ui.k2;
import e.b;
import e1.u;
import ie.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.o;
import zd.M;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 R2\u00020\u0001:\u0002RSB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\t\u0010\bJ-\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J!\u0010\u0012\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u000E2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0015\u001A\u00020\u0014H\u0014\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u001B\u0010\u001A\u001A\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u0018\u001A\u00020\u0017H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001D\u001A\u00020\u001CH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\u0014H\u0014\u00A2\u0006\u0004\b\u001F\u0010\u0016J\u000F\u0010!\u001A\u00020 H\u0016\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b#\u0010\u0016J\'\u0010)\u001A\u00020\u00142\u0006\u0010%\u001A\u00020$2\u0006\u0010\'\u001A\u00020&2\u0006\u0010(\u001A\u00020 H\u0014\u00A2\u0006\u0004\b)\u0010*J\r\u0010+\u001A\u00020\u0006\u00A2\u0006\u0004\b+\u0010\u0003J\u0019\u0010/\u001A\u000E\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,\u00A2\u0006\u0004\b/\u00100J%\u00106\u001A\u00020\u00062\u0006\u00102\u001A\u0002012\u0006\u00103\u001A\u0002012\u0006\u00105\u001A\u000204\u00A2\u0006\u0004\b6\u00107J%\u00108\u001A\u00020\u00062\u0006\u00102\u001A\u0002012\u0006\u00103\u001A\u0002012\u0006\u00105\u001A\u000204\u00A2\u0006\u0004\b8\u00107J\u000F\u00109\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b9\u0010\u0003J\'\u0010:\u001A\u00020\u00062\u0006\u00102\u001A\u0002012\u0006\u00103\u001A\u0002012\u0006\u00105\u001A\u000204H\u0002\u00A2\u0006\u0004\b:\u00107J\u001F\u0010=\u001A\u00020\u00062\u0006\u00102\u001A\u0002012\u0006\u0010<\u001A\u00020;H\u0002\u00A2\u0006\u0004\b=\u0010>J\u001F\u0010?\u001A\u00020\u00062\u0006\u00102\u001A\u0002012\u0006\u0010<\u001A\u00020;H\u0002\u00A2\u0006\u0004\b?\u0010>J\u001F\u0010B\u001A\u00020\u00062\u0006\u0010@\u001A\u0002012\u0006\u0010A\u001A\u00020\u0014H\u0002\u00A2\u0006\u0004\bB\u0010CR\"\u0010D\u001A\u00020\u000E8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bD\u0010E\u001A\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010J\u001A\u00020\u000E8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bJ\u0010E\u001A\u0004\bK\u0010G\"\u0004\bL\u0010IR\"\u0010P\u001A\u0010\u0012\f\u0012\n O*\u0004\u0018\u00010N0N0M8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bP\u0010Q\u00A8\u0006T"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageListFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "onRestoreInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "hasScrolledLine", "()Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "handleNotificationStatusWithEmptyView", "", "getCacheKey", "()Ljava/lang/String;", "shouldShowMiniPlayer", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "clearData", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "getMelonArrayAdapter", "()Lcom/iloen/melon/adapters/common/p;", "", "adapterposition", "dataposition", "Lcom/iloen/melon/net/v6x/response/MusicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST;", "item", "openEditor", "(IILcom/iloen/melon/net/v6x/response/MusicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST;)V", "openContextListPopup", "openFindFriends", "deleteItem", "Lcom/iloen/melon/net/v6x/response/MusicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST;", "targetMember", "blockUser", "(ILcom/iloen/melon/net/v6x/response/MusicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST;)V", "unblockUser", "adapterPosition", "isBlocked", "updateBlockIconStatus", "(IZ)V", "mBtnWrite", "Landroid/view/View;", "getMBtnWrite", "()Landroid/view/View;", "setMBtnWrite", "(Landroid/view/View;)V", "mBtnBlock", "getMBtnBlock", "setMBtnBlock", "Le/b;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "searchActivityResult", "Le/b;", "Companion", "MusicMessageListAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicMessageListFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000B\u001A\u00020\fH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageListFragment$Companion;", "", "<init>", "()V", "TAG", "", "ROW_COUNT", "", "MAX_CONTENTS_COUNT", "CONTEXT_MENU_DELETE", "CONTEXT_MENU_BLOCK", "newInstance", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageListFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MusicMessageListFragment newInstance() {
            MusicMessageListFragment musicMessageListFragment0 = new MusicMessageListFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", u.v(((e0)o.a()).j()));
            bundle0.putBoolean("argIsLoginRequired", true);
            musicMessageListFragment0.setArguments(bundle0);
            return musicMessageListFragment0;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\'\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageListFragment$MusicMessageListAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/MusicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/musicmessage/MusicMessageListFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class MusicMessageListAdapter extends p {
        public MusicMessageListAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            MusicMessageListFragment.this = musicMessageListFragment0;
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            Object object0 = this.getItem(v1);
            q.f(object0, "getItem(...)");
            MusicMessageBaseViewHolder musicMessageBaseViewHolder0 = o00 instanceof MusicMessageBaseViewHolder ? ((MusicMessageBaseViewHolder)o00) : null;
            if(musicMessageBaseViewHolder0 != null) {
                musicMessageBaseViewHolder0.bindView(((INBOXLIST)object0), v, v1);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = this.mInflater.inflate(0x7F0D0560, viewGroup0, false);  // layout:musicmessage_list_item
            q.f(view0, "inflate(...)");
            return new MusicMessageListViewHolder(view0, MusicMessageListFragment.this);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[M.values().length];
            try {
                arr_v[102] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[103] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[93] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    public static final int CONTEXT_MENU_BLOCK = 2;
    public static final int CONTEXT_MENU_DELETE = 1;
    @NotNull
    public static final Companion Companion = null;
    public static final int MAX_CONTENTS_COUNT = 10;
    public static final int ROW_COUNT = 30;
    @NotNull
    public static final String TAG = "MusicMessageListFragment";
    public View mBtnBlock;
    public View mBtnWrite;
    @NotNull
    private final b searchActivityResult;

    static {
        MusicMessageListFragment.Companion = new Companion(null);
        MusicMessageListFragment.$stable = 8;
    }

    public MusicMessageListFragment() {
        b b0 = this.registerForActivityResult(new f0(2), new a0(this, 28));
        q.f(b0, "registerForActivityResult(...)");
        this.searchActivityResult = b0;
    }

    private final void blockUser(int v, TARGETMEMBERINFOLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0) {
        LogU.Companion.d("MusicMessageListFragment", "blockUser : " + musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0);
        l0 l00 = this.getChildFragmentManager();
        String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        String s1 = this.getString(0x7F1300C8);  // string:alert_dlg_music_message_insert_block_user_confirm "%1$s님을 차단하시겠습니까?\n차단된 
                                                 // 사람에게는\n메시지를 보내거나 받을 수 없습니다.\n\n차단 해제는 [프로필> 프로필 설정> 메시지 차단 목록 관리] 및\n[메시지 리스트> 메시지 
                                                 // 레이어]에서 가능합니다."
        q.f(s1, "getString(...)");
        com.melon.ui.popup.b.x(l00, s, String.format(s1, Arrays.copyOf(new Object[]{musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0.targetnickname}, 1)), false, false, null, null, new h(this, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0, v, 0), null, null, null, 0xEF8);
    }

    private static final H blockUser$lambda$20(MusicMessageListFragment musicMessageListFragment0, TARGETMEMBERINFOLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0, int v) {
        Params musicMessageInsertBanUserReq$Params0 = new Params();
        musicMessageInsertBanUserReq$Params0.memberKeyBan = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0.targetmemberkey;
        RequestBuilder.newInstance(new MusicMessageInsertBanUserReq(musicMessageListFragment0.getContext(), musicMessageInsertBanUserReq$Params0)).tag("MusicMessageEditorFragment").listener(new i(musicMessageListFragment0, v, 0)).errorListener(new e(1)).request();
        return H.a;
    }

    private static final void blockUser$lambda$20$lambda$18(MusicMessageListFragment musicMessageListFragment0, int v, MusicMessageInsertBanUserRes musicMessageInsertBanUserRes0) {
        if(musicMessageListFragment0.isFragmentValid() && musicMessageInsertBanUserRes0.isSuccessful()) {
            musicMessageListFragment0.updateBlockIconStatus(v, true);
        }
    }

    private static final void blockUser$lambda$20$lambda$19(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    public final void clearData() {
        this.getMelonArrayAdapter().clear(false);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        v9.e e0 = new v9.e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.j = this.getString(0x7F130916);  // string:select_friend_melon "멜론친구 선택하기"
        e0.m = new j(this, 0);
        j0 j00 = new MusicMessageListAdapter(this, context0, null);
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    private static final void createRecyclerViewAdapter$lambda$5$lambda$4(MusicMessageListFragment musicMessageListFragment0, View view0) {
        musicMessageListFragment0.openFindFriends();
    }

    private final void deleteItem(int v, int v1, INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0) {
        LogU.Companion.d("MusicMessageListFragment", "deleteItem adapterposition: " + v + ", dataposition: " + v1);
        com.melon.ui.popup.b.x(this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F1300C3), false, false, null, null, new P0(this, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, v, 5), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
    }

    private static final H deleteItem$lambda$14(MusicMessageListFragment musicMessageListFragment0, INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, int v) {
        com.iloen.melon.net.v4x.request.MusicMessageDeleteMusicMsgInboxReq.Params musicMessageDeleteMusicMsgInboxReq$Params0 = new com.iloen.melon.net.v4x.request.MusicMessageDeleteMusicMsgInboxReq.Params();
        musicMessageDeleteMusicMsgInboxReq$Params0.groupYn = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.groupyn;
        musicMessageDeleteMusicMsgInboxReq$Params0.inboxSeq = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.inboxseq;
        RequestBuilder.newInstance(new MusicMessageDeleteMusicMsgInboxReq(musicMessageListFragment0.getContext(), musicMessageDeleteMusicMsgInboxReq$Params0)).tag("MusicMessageListFragment").listener(new W5.e(musicMessageListFragment0, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, v, 7)).errorListener(new e(3)).request();
        return H.a;
    }

    private static final void deleteItem$lambda$14$lambda$12(MusicMessageListFragment musicMessageListFragment0, INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, int v, MusicMessageDeleteMusicMsgInboxRes musicMessageDeleteMusicMsgInboxRes0) {
        if(musicMessageDeleteMusicMsgInboxRes0 != null && musicMessageDeleteMusicMsgInboxRes0.isSuccessful() && musicMessageListFragment0.isFragmentValid()) {
            ToastManager.showShort(0x7F130716);  // string:music_message_is_deleted "메시지가 삭제되었습니다."
            musicMessageListFragment0.getMelonArrayAdapter().remove(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0);
            musicMessageListFragment0.getMelonArrayAdapter().notifyItemRemoved(v);
            musicMessageListFragment0.getMelonArrayAdapter().notifyItemRangeChanged(v, musicMessageListFragment0.getMelonArrayAdapter().getCount());
            if(musicMessageListFragment0.getMelonArrayAdapter().getCount() == 0) {
                musicMessageListFragment0.startFetch();
            }
        }
    }

    private static final void deleteItem$lambda$14$lambda$13(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.G.buildUpon().appendPath("musicMessage"), "userKey", this.mUserKey, "toString(...)");
    }

    @NotNull
    public final View getMBtnBlock() {
        View view0 = this.mBtnBlock;
        if(view0 != null) {
            return view0;
        }
        q.m("mBtnBlock");
        throw null;
    }

    @NotNull
    public final View getMBtnWrite() {
        View view0 = this.mBtnWrite;
        if(view0 != null) {
            return view0;
        }
        q.m("mBtnWrite");
        throw null;
    }

    @NotNull
    public final p getMelonArrayAdapter() {
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.adapters.common.MelonArrayAdapter<kotlin.Any, androidx.recyclerview.widget.RecyclerView.ViewHolder>");
        return (p)j00;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean handleNotificationStatusWithEmptyView() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    public static void i0(MusicMessageListFragment musicMessageListFragment0, INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, int v, MusicMessageDeleteMusicMsgInboxRes musicMessageDeleteMusicMsgInboxRes0) {
        MusicMessageListFragment.deleteItem$lambda$14$lambda$12(musicMessageListFragment0, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, v, musicMessageDeleteMusicMsgInboxRes0);
    }

    public static void l0(MusicMessageListFragment musicMessageListFragment0, ActivityResult activityResult0) {
        MusicMessageListFragment.searchActivityResult$lambda$1(musicMessageListFragment0, activityResult0);
    }

    @NotNull
    public static final MusicMessageListFragment newInstance() {
        return MusicMessageListFragment.Companion.newInstance();
    }

    public static void o0(MusicMessageListFragment musicMessageListFragment0, v9.i i0, MusicMessageListMusicMsgInboxRes musicMessageListMusicMsgInboxRes0) {
        MusicMessageListFragment.onFetchStart$lambda$9(musicMessageListFragment0, i0, musicMessageListMusicMsgInboxRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        LogU.Companion.d("MusicMessageListFragment", "onCreate()");
        super.onCreate(bundle0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(this.getActivity()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02A9, viewGroup0, false);  // layout:fragment_detail_basic
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull v9.i i0, @NotNull v9.h h0, @NotNull String s) {
        int v;
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        LogU.Companion.d("MusicMessageListFragment", "onFetchStart reason: " + s);
        if(v9.i.c.equals(i0)) {
            v = this.getMelonArrayAdapter().getCount() + 1;
        }
        else {
            this.clearData();
            v = 1;
        }
        com.iloen.melon.net.v6x.request.MusicMessageListMusicMsgInboxReq.Params musicMessageListMusicMsgInboxReq$Params0 = new com.iloen.melon.net.v6x.request.MusicMessageListMusicMsgInboxReq.Params();
        musicMessageListMusicMsgInboxReq$Params0.startIndex = v;
        musicMessageListMusicMsgInboxReq$Params0.pageSize = 30;
        RequestBuilder.newInstance(new MusicMessageListMusicMsgInboxReq(this.getContext(), musicMessageListMusicMsgInboxReq$Params0)).tag("MusicMessageListFragment").listener(new H0(12, this, i0)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$9(MusicMessageListFragment musicMessageListFragment0, v9.i i0, MusicMessageListMusicMsgInboxRes musicMessageListMusicMsgInboxRes0) {
        if(!musicMessageListFragment0.prepareFetchComplete(musicMessageListMusicMsgInboxRes0)) {
            return;
        }
        musicMessageListFragment0.performFetchComplete(i0, musicMessageListMusicMsgInboxRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "savedInstanceState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            x x0 = new x(1);
            String s = this.getString(0x7F130BA0);  // string:talkback_musicmessage_send_btn "음악메세지 보내기 버튼"
            q.f(s, "getString(...)");
            x0.d = s;
            F8.o o0 = a.s(1);
            x0.c = new j(this, 1);
            o0.g(x0);
            titleBar0.a(o0);
            titleBar0.setTitle("메시지");
            titleBar0.f(false);
        }
    }

    private static final void onViewCreated$lambda$3$lambda$2(MusicMessageListFragment musicMessageListFragment0, View view0) {
        musicMessageListFragment0.openFindFriends();
    }

    public final void openContextListPopup(int v, int v1, @NotNull INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0) {
        q.g(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, "item");
        boolean z = Receiver.d(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist);
        boolean z1 = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist == null || musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist.size() <= 0 ? false : ProtocolUtils.parseBoolean(((TargetMemberInfoBase)musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist.get(0)).targetbanyn);
        TARGETMEMBERINFOLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0 = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist == null ? null : ((TARGETMEMBERINFOLIST)je.p.m0(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist));
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(zd.x.l0);
        if(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0 != null) {
            if(z1) {
                arrayList0.add(zd.x.u0);
            }
            else {
                arrayList0.add(zd.x.t0);
            }
        }
        com.melon.ui.popup.b.t(this.getChildFragmentManager(), arrayList0, (k2 k20) -> {
            q.g(k20, "moreListPopupOnEvent");
            if(k20 instanceof K1) {
                switch(((K1)k20).b.a.ordinal()) {
                    case 93: {
                        this.deleteItem(v, v1, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0);
                        return H.a;
                    }
                    case 102: 
                    case 103: {
                        if(z) {
                            l0 l00 = this.getChildFragmentManager();
                            String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                            String s1 = this.getString(0x7F130472);  // string:friend_is_withidraw_member "탈퇴한 회원입니다."
                            com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, s, s1, false, false, false, null, null, null, null, null, 2040);
                            return H.a;
                        }
                        break;
                    }
                    default: {
                        return H.a;
                    }
                }
                if(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0 != null) {
                    if(z1) {
                        this.unblockUser(v1, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0);
                        return H.a;
                    }
                    this.blockUser(v1, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0);
                    return H.a;
                }
            }
            else if(k20 instanceof B1) {
                this.deleteItem(v, v1, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0);
            }
            return H.a;
        });
    }

    // 检测为 Lambda 实现
    private static final H openContextListPopup$lambda$16(boolean z, MusicMessageListFragment musicMessageListFragment0, TARGETMEMBERINFOLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0, int v, int v1, INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, boolean z1, k2 k20) [...]

    public final void openEditor(int v, int v1, @NotNull INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0) {
        q.g(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, "item");
        LogU.Companion.d("MusicMessageListFragment", "openEditor adapterposition: " + v + ", dataposition: " + v1);
        this.openMusicMessagePage(Receiver.a(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist), musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.inboxseq, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.groupyn);
        musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.msgenoconfmcnt = "0";
        this.getMelonArrayAdapter().notifyItemChanged(v);
    }

    private final void openFindFriends() {
        LogU.Companion.d("MusicMessageListFragment", "openFindFriends");
        Intent intent0 = new Intent(this.getActivity(), FriendSelectActivity.class);
        intent0.putExtra("argTabTitleName", "친구 선택하기");
        intent0.putExtra("argMaxResultCount", 10);
        intent0.putExtra("argWhereRUFrom", 0);
        this.searchActivityResult.b(intent0);
    }

    private static final void searchActivityResult$lambda$1(MusicMessageListFragment musicMessageListFragment0, ActivityResult activityResult0) {
        String s1;
        String s;
        q.g(activityResult0, "result");
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                ArrayList arrayList0 = intent0.getParcelableArrayListExtra("argSearchResultValues");
                if(arrayList0 == null || arrayList0.size() != 1) {
                    s = null;
                    s1 = "Y";
                }
                else {
                    s = ((Receiver)arrayList0.get(0)).a;
                    s1 = "N";
                }
                musicMessageListFragment0.openMusicMessagePage(arrayList0, s, s1);
            }
        }
    }

    public final void setMBtnBlock(@NotNull View view0) {
        q.g(view0, "<set-?>");
        this.mBtnBlock = view0;
    }

    public final void setMBtnWrite(@NotNull View view0) {
        q.g(view0, "<set-?>");
        this.mBtnWrite = view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return true;
    }

    private final void unblockUser(int v, TARGETMEMBERINFOLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0) {
        LogU.Companion.d("MusicMessageListFragment", "unblockUser : " + musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0);
        l0 l00 = this.getChildFragmentManager();
        String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        String s1 = this.getString(0x7F1300C6);  // string:alert_dlg_music_message_delete_block_user_confirm "%1$s님을 차단해제하시겠습니까?"
        q.f(s1, "getString(...)");
        com.melon.ui.popup.b.x(l00, s, String.format(s1, Arrays.copyOf(new Object[]{musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0.targetnickname}, 1)), false, false, null, null, new h(this, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0, v, 1), null, null, null, 0xEF8);
    }

    private static final H unblockUser$lambda$24(MusicMessageListFragment musicMessageListFragment0, TARGETMEMBERINFOLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0, int v) {
        com.iloen.melon.net.v6x.request.MusicMessageDeleteBanUserReq.Params musicMessageDeleteBanUserReq$Params0 = new com.iloen.melon.net.v6x.request.MusicMessageDeleteBanUserReq.Params();
        musicMessageDeleteBanUserReq$Params0.memberKeyBan = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0.targetmemberkey;
        RequestBuilder.newInstance(new MusicMessageDeleteBanUserReq(musicMessageListFragment0.getContext(), musicMessageDeleteBanUserReq$Params0)).tag("MusicMessageEditorFragment").listener(new i(musicMessageListFragment0, v, 1)).errorListener(new e(2)).request();
        return H.a;
    }

    private static final void unblockUser$lambda$24$lambda$22(MusicMessageListFragment musicMessageListFragment0, int v, MusicMessageDeleteBanUserRes musicMessageDeleteBanUserRes0) {
        if(musicMessageListFragment0.isFragmentValid() && musicMessageDeleteBanUserRes0.isSuccessful()) {
            musicMessageListFragment0.updateBlockIconStatus(v, false);
        }
    }

    private static final void unblockUser$lambda$24$lambda$23(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final void updateBlockIconStatus(int v, boolean z) {
        INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0 = null;
        MusicMessageListAdapter musicMessageListFragment$MusicMessageListAdapter0 = this.mAdapter instanceof MusicMessageListAdapter ? ((MusicMessageListAdapter)this.mAdapter) : null;
        if(musicMessageListFragment$MusicMessageListAdapter0 != null) {
            musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0 = (INBOXLIST)musicMessageListFragment$MusicMessageListAdapter0.getItem(v);
        }
        if(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0 != null) {
            ArrayList arrayList0 = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist;
            if(arrayList0 != null) {
                TARGETMEMBERINFOLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0 = (TARGETMEMBERINFOLIST)je.p.m0(arrayList0);
                if(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0 != null) {
                    musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0.targetbanyn = z ? "Y" : "N";
                }
            }
            this.mAdapter.notifyItemChanged(v);
        }
    }
}

