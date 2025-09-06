package com.iloen.melon.fragments.friend;

import B9.e;
import B9.m;
import E9.w;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.common.ListMarker;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.FollowToggleButton;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.UserInfoBase;
import com.iloen.melon.net.v4x.request.DeleteHiddenFriendReq;
import com.iloen.melon.net.v4x.request.InsertHiddenFriendReq;
import com.iloen.melon.net.v4x.response.DeleteHiddenFriendRes;
import com.iloen.melon.net.v4x.response.InsertHiddenFriendRes;
import com.iloen.melon.net.v6x.request.ListFollowerAlphabetReq.Params;
import com.iloen.melon.net.v6x.request.ListFollowerAlphabetReq;
import com.iloen.melon.net.v6x.request.ListFollowerDjReq;
import com.iloen.melon.net.v6x.request.ListFollowerOriginReq;
import com.iloen.melon.net.v6x.request.ListFollowerRecentActReq;
import com.iloen.melon.net.v6x.request.ListFollowerRecentAddReq;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes.RESPONSE.USERLIST;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import e.k;
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
import v9.i;
import va.e0;
import va.o;
import we.a;

@Metadata(d1 = {"\u0000\u009E\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 a2\u00020\u0001:\u0003abcB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u000E\u001A\u00020\u00042\b\u0010\r\u001A\u0004\u0018\u00010\tH\u0016\u00A2\u0006\u0004\b\u000E\u0010\fJ-\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00112\b\u0010\r\u001A\u0004\u0018\u00010\tH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u0006H\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010 \u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u001BH\u0014\u00A2\u0006\u0004\b \u0010!J\u001B\u0010%\u001A\u0006\u0012\u0002\b\u00030$2\u0006\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b(\u0010)J\u000F\u0010+\u001A\u00020*H\u0014\u00A2\u0006\u0004\b+\u0010,J\u001F\u00101\u001A\u00020\u00042\u0006\u0010.\u001A\u00020-2\u0006\u00100\u001A\u00020/H\u0014\u00A2\u0006\u0004\b1\u00102J\u001B\u00104\u001A\u0006\u0012\u0002\b\u0003032\u0006\u0010\u0017\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b4\u00105J\u001B\u00106\u001A\u0006\u0012\u0002\b\u0003032\u0006\u0010\u0017\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b6\u00105J\u001B\u00107\u001A\u0006\u0012\u0002\b\u0003032\u0006\u0010\u0017\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b7\u00105J\u001B\u00108\u001A\u0006\u0012\u0002\b\u0003032\u0006\u0010\u0017\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b8\u00105J\u001B\u00109\u001A\u0006\u0012\u0002\b\u0003032\u0006\u0010\u0017\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b9\u00105J\u0019\u0010;\u001A\u00020\u00042\b\b\u0002\u0010:\u001A\u00020\u001BH\u0002\u00A2\u0006\u0004\b;\u0010<J\u000F\u0010=\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b=\u0010\u0003J\u000F\u0010>\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b>\u0010\u0003J3\u0010C\u001A\u00020\u00042\u0006\u0010?\u001A\u00020\u00062\f\u0010A\u001A\b\u0012\u0004\u0012\u00020\u00060@2\f\u0010B\u001A\b\u0012\u0004\u0012\u00020/0@H\u0002\u00A2\u0006\u0004\bC\u0010DJ3\u0010E\u001A\u00020\u00042\u0006\u0010?\u001A\u00020\u00062\f\u0010A\u001A\b\u0012\u0004\u0012\u00020\u00060@2\f\u0010B\u001A\b\u0012\u0004\u0012\u00020/0@H\u0002\u00A2\u0006\u0004\bE\u0010DJ\u001D\u0010F\u001A\u00020\u00042\f\u0010B\u001A\b\u0012\u0004\u0012\u00020/0@H\u0002\u00A2\u0006\u0004\bF\u0010GJ%\u0010L\u001A\u00020\u00042\u0006\u0010I\u001A\u00020H2\f\u0010K\u001A\b\u0012\u0004\u0012\u00020\u00040JH\u0002\u00A2\u0006\u0004\bL\u0010MJ%\u0010N\u001A\u00020\u00042\u0006\u0010I\u001A\u00020H2\f\u0010K\u001A\b\u0012\u0004\u0012\u00020\u00040JH\u0002\u00A2\u0006\u0004\bN\u0010MR$\u0010P\u001A\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bP\u0010Q\u001A\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0016\u0010V\u001A\u00020/8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bZ\u0010YR)\u0010`\u001A\u0010\u0012\f\u0012\n [*\u0004\u0018\u00010\u00060\u00060@8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\\\u0010]\u001A\u0004\b^\u0010_\u00A8\u0006d"}, d2 = {"Lcom/iloen/melon/fragments/friend/FollowerFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lie/H;", "setEditMode", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "isEditMode", "isDoneUserAction", "onEditButtonClick", "(ZZ)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "Lcom/iloen/melon/net/HttpRequest;", "getRequestRecent", "(Lv9/i;)Lcom/iloen/melon/net/HttpRequest;", "getRequestAlphabet", "getRequestDj", "getRequestOrigin", "getRequestHidden", "typeHidden", "setToolbar", "(Z)V", "checkAndHideMarkedFriend", "checkAndUnhideMarkedFriend", "menuId", "", "memberKeyList", "markedPositionList", "requestHide", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "requestUnHide", "processData", "(Ljava/util/List;)V", "Lcom/iloen/melon/net/v4x/common/UserInfoBase;", "data", "Lkotlin/Function0;", "onComplete", "follow", "(Lcom/iloen/melon/net/v4x/common/UserInfoBase;Lwe/a;)V", "unfollow", "Lcom/iloen/melon/fragments/friend/FollowerFragment$EditButtonEnableListener;", "editButtonEnableListener", "Lcom/iloen/melon/fragments/friend/FollowerFragment$EditButtonEnableListener;", "getEditButtonEnableListener", "()Lcom/iloen/melon/fragments/friend/FollowerFragment$EditButtonEnableListener;", "setEditButtonEnableListener", "(Lcom/iloen/melon/fragments/friend/FollowerFragment$EditButtonEnableListener;)V", "filterIndex", "I", "followerCount", "Ljava/lang/String;", "nickname", "kotlin.jvm.PlatformType", "filterTexts$delegate", "Lie/j;", "getFilterTexts", "()Ljava/util/List;", "filterTexts", "Companion", "EditButtonEnableListener", "FollowerAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FollowerFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0016\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/friend/FollowerFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_NICKNAME", "ORIGIN_CODE_ALL", "ORIGIN_CODE_HIDDEN", "PAGE_SIZE", "", "MAX_SELECTABLE_COUNT", "SORT_RECENT", "SORT_ALPHABET", "SORT_DJ", "SORT_ORIGIN", "SORT_HIDDEN", "ADD", "", "DELETE", "newInstance", "Lcom/iloen/melon/fragments/friend/FollowerFragment;", "myNickName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final FollowerFragment newInstance(@NotNull String s) {
            q.g(s, "myNickName");
            FollowerFragment followerFragment0 = new FollowerFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argNickName", s);
            followerFragment0.setArguments(bundle0);
            return followerFragment0;
        }

        public static FollowerFragment newInstance$default(Companion followerFragment$Companion0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                s = "";
            }
            return followerFragment$Companion0.newInstance(s);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/friend/FollowerFragment$EditButtonEnableListener;", "", "", "enable", "Lie/H;", "onEditButtonEnableStateChange", "(Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface EditButtonEnableListener {
        void onEditButtonEnableStateChange(boolean arg1);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0082\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\'\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0018\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u0017\u001A\u00020\n2\u0006\u0010\u001A\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010!\u001A\u00020\u00032\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\nH\u0016¢\u0006\u0004\b!\u0010\"J\'\u0010$\u001A\u00020\u001B2\u0006\u0010#\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\nH\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010&\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u0010\'¨\u0006)"}, d2 = {"Lcom/iloen/melon/fragments/friend/FollowerFragment$FollowerAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/ListFollowingFollowerRes$RESPONSE$USERLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/friend/FollowerFragment;Landroid/content/Context;Ljava/util/List;)V", "", "getHeaderViewItemCount", "()I", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "marked", "Lie/H;", "setMarked", "(IZ)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_TOP_FILTER", "I", "VIEW_TYPE_FRIEND", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class FollowerAdapter extends p {
        private final int VIEW_TYPE_FRIEND;
        private final int VIEW_TYPE_TOP_FILTER;

        public FollowerAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            FollowerFragment.this = followerFragment0;
            super(context0, list0);
            this.VIEW_TYPE_TOP_FILTER = 1;
            this.VIEW_TYPE_FRIEND = 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return !this.isInEditMode();
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? this.VIEW_TYPE_FRIEND : this.VIEW_TYPE_TOP_FILTER;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            ArrayList arrayList1;
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            if(httpResponse0 instanceof ListFollowingFollowerRes) {
                RESPONSE listFollowingFollowerRes$RESPONSE0 = ((ListFollowingFollowerRes)httpResponse0).response;
                if(listFollowingFollowerRes$RESPONSE0 == null) {
                    arrayList1 = null;
                }
                else {
                    ArrayList arrayList0 = listFollowingFollowerRes$RESPONSE0.userList;
                    if(arrayList0 == null) {
                        arrayList1 = null;
                    }
                    else {
                        arrayList1 = new ArrayList();
                        for(Object object0: arrayList0) {
                            if(!q.b(((USERLIST)object0).withdrawyn, "Y")) {
                                arrayList1.add(object0);
                            }
                        }
                    }
                }
                this.addAll(arrayList1);
                this.setHasMore(((ListFollowingFollowerRes)httpResponse0).hasMore());
                this.setMenuId("");
                this.updateModifiedTime(s);
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            int v3;
            q.g(o00, "viewHolder");
            int v2 = 0;
            if(o00 instanceof e) {
                MelonTextView melonTextView0 = ((e)o00).b;
                MelonTextView melonTextView1 = ((e)o00).a;
                FollowerFragment followerFragment0 = FollowerFragment.this;
                if(followerFragment0.followerCount.length() <= 0) {
                    v2 = 4;
                }
                melonTextView1.setVisibility(v2);
                q.f("전체 %s명", "getString(...)");
                l1.D(new Object[]{followerFragment0.followerCount}, 1, "전체 %s명", melonTextView1);
                List list0 = FollowerFragment.this.getFilterTexts();
                melonTextView0.setText(((String)je.p.n0(FollowerFragment.this.filterIndex, list0)));
                melonTextView0.setOnClickListener(new g(FollowerFragment.this, o00, 0));
                return;
            }
            if(o00 instanceof m) {
                USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0 = (USERLIST)this.getItem(v1);
                if(listFollowingFollowerRes$RESPONSE$USERLIST0 != null) {
                    String s = listFollowingFollowerRes$RESPONSE$USERLIST0.mypageimg;
                    if(s == null) {
                        s = null;
                    }
                    else if(s.length() == 0) {
                        s = listFollowingFollowerRes$RESPONSE$USERLIST0.fbimageurl;
                    }
                    View view0 = ((m)o00).a;
                    ImageView imageView0 = ((m)o00).i;
                    ImageView imageView1 = ((m)o00).c;
                    FollowToggleButton followToggleButton0 = ((m)o00).h;
                    ((m)o00).c(s);
                    ((m)o00).b(listFollowingFollowerRes$RESPONSE$USERLIST0.memberDjIconType);
                    String s1 = StringUtils.getFriendDisplayName(listFollowingFollowerRes$RESPONSE$USERLIST0.memberkey, listFollowingFollowerRes$RESPONSE$USERLIST0.membernickname);
                    ((m)o00).e.setText(s1);
                    ViewUtils.showWhen(((m)o00).g, listFollowingFollowerRes$RESPONSE$USERLIST0.isOfficial);
                    ((m)o00).a(listFollowingFollowerRes$RESPONSE$USERLIST0.myPageDesc);
                    String s2 = listFollowingFollowerRes$RESPONSE$USERLIST0.frendaddorigin;
                    if(s2 == null) {
                        v3 = -1;
                    }
                    else {
                        switch(s2) {
                            case "F": {
                                v3 = 0x7F0803EA;  // drawable:ic_common_facebook_16
                                break;
                            }
                            case "K": {
                                v3 = 0x7F0803F7;  // drawable:ic_common_kakao_16
                                break;
                            }
                            case "P": {
                                v3 = 0x7F0803EE;  // drawable:ic_common_friend_16
                                break;
                            }
                            default: {
                                v3 = -1;
                            }
                        }
                    }
                    if(v3 == -1) {
                        imageView1.setVisibility(8);
                    }
                    else {
                        imageView1.setVisibility(0);
                        imageView1.setImageResource(v3);
                    }
                    boolean z = this.isInEditMode();
                    ViewUtils.showWhen(imageView0, z);
                    ViewUtils.hideWhen(followToggleButton0, z);
                    if(z) {
                        h h0 = (View view0) -> FollowerFragment.this.onItemClick(view0, v);
                        o00.itemView.setOnClickListener(h0);
                        if(this.isMarked(v1)) {
                            imageView0.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                            view0.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                            return;
                        }
                        imageView0.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                        view0.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                        return;
                    }
                    view0.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                    com.iloen.melon.fragments.friend.i i0 = new com.iloen.melon.fragments.friend.i(listFollowingFollowerRes$RESPONSE$USERLIST0, 0);
                    ViewUtils.setOnClickListener(o00.itemView, i0);
                    if(listFollowingFollowerRes$RESPONSE$USERLIST0.ismyfriend) {
                        followToggleButton0.setType(1);
                    }
                    else {
                        followToggleButton0.setType(0);
                    }
                    ViewUtils.setOnClickListener(followToggleButton0, new j(listFollowingFollowerRes$RESPONSE$USERLIST0, FollowerFragment.this, o00, 0));
                }
            }
        }

        private static final void onBindViewImpl$lambda$3(FollowerFragment followerFragment0, O0 o00, View view0) {
            if(followerFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = followerFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                    bottomSingleFilterListPopup0.setFilterItem(followerFragment0.getFilterTexts(), followerFragment0.filterIndex);
                    bottomSingleFilterListPopup0.setFilterListener(new com.iloen.melon.fragments.friend.e(followerFragment0, o00, 0));
                    bottomSingleFilterListPopup0.setOnDismissListener(followerFragment0.mDialogDismissListener);
                    followerFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        private static final void onBindViewImpl$lambda$3$lambda$2(FollowerFragment followerFragment0, O0 o00, int v) {
            followerFragment0.filterIndex = v;
            j0 j00 = followerFragment0.getAdapter();
            FollowerAdapter followerFragment$FollowerAdapter0 = j00 instanceof FollowerAdapter ? ((FollowerAdapter)j00) : null;
            if(followerFragment$FollowerAdapter0 != null) {
                followerFragment$FollowerAdapter0.clear(true);
            }
            String s = (String)je.p.n0(followerFragment0.filterIndex, followerFragment0.getFilterTexts());
            ((e)o00).b.setText(s);
            followerFragment0.startFetch("filter change");
        }

        // 检测为 Lambda 实现
        private static final void onBindViewImpl$lambda$5(FollowerFragment followerFragment0, int v, View view0) [...]

        private static final void onBindViewImpl$lambda$6(USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0, View view0) {
            Navigator.openUserMain(listFollowingFollowerRes$RESPONSE$USERLIST0.memberkey);
        }

        private static final void onBindViewImpl$lambda$9(USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0, FollowerFragment followerFragment0, O0 o00, View view0) {
            if(listFollowingFollowerRes$RESPONSE$USERLIST0.ismyfriend) {
                followerFragment0.unfollow(listFollowingFollowerRes$RESPONSE$USERLIST0, new f(listFollowingFollowerRes$RESPONSE$USERLIST0, o00, 0));
                return;
            }
            followerFragment0.follow(listFollowingFollowerRes$RESPONSE$USERLIST0, new f(listFollowingFollowerRes$RESPONSE$USERLIST0, o00, 1));
        }

        private static final H onBindViewImpl$lambda$9$lambda$7(USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0, O0 o00) {
            listFollowingFollowerRes$RESPONSE$USERLIST0.ismyfriend = false;
            ((m)o00).h.setType(0);
            return H.a;
        }

        private static final H onBindViewImpl$lambda$9$lambda$8(USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0, O0 o00) {
            listFollowingFollowerRes$RESPONSE$USERLIST0.ismyfriend = true;
            ((m)o00).h.setType(1);
            return H.a;
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return v == this.VIEW_TYPE_TOP_FILTER ? z6.f.p(viewGroup0, 0.0f, 6) : w.M(viewGroup0);
        }

        @Override  // com.iloen.melon.adapters.common.j
        public void setMarked(int v, boolean z) {
            if(z && this.getMarkedCount() >= 20) {
                l0 l00 = FollowerFragment.this.getChildFragmentManager();
                String s = this.getContext().getString(0x7F130474, new Object[]{20});  // string:friend_list_multi_select_limit "선택은 한번에 최대 %1$d명까지 가능합니다."
                b.d(b.a, l00, "안내", s, false, false, false, null, null, null, null, null, 2040);
                return;
            }
            super.setMarked(v, z);
        }
    }

    public static final int $stable = 0;
    private static final boolean ADD = true;
    @NotNull
    private static final String ARG_NICKNAME = "argNickName";
    @NotNull
    public static final Companion Companion = null;
    private static final boolean DELETE = false;
    private static final int MAX_SELECTABLE_COUNT = 20;
    @NotNull
    private static final String ORIGIN_CODE_ALL = "A";
    @NotNull
    private static final String ORIGIN_CODE_HIDDEN = "H";
    private static final int PAGE_SIZE = 100;
    private static final int SORT_ALPHABET = 1;
    private static final int SORT_DJ = 2;
    private static final int SORT_HIDDEN = 4;
    private static final int SORT_ORIGIN = 3;
    private static final int SORT_RECENT = 0;
    @NotNull
    private static final String TAG = "FollowerFragment";
    @Nullable
    private EditButtonEnableListener editButtonEnableListener;
    private int filterIndex;
    @NotNull
    private final ie.j filterTexts$delegate;
    @NotNull
    private String followerCount;
    @NotNull
    private String nickname;

    static {
        FollowerFragment.Companion = new Companion(null);
        FollowerFragment.$stable = 8;
    }

    public FollowerFragment() {
        this.followerCount = "";
        this.nickname = "";
        this.filterTexts$delegate = d3.g.Q(new d(this, 0));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public ToolBar buildToolBar() {
        int v = this.filterIndex == 4 ? 0x200 : 0x1FF;
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        ToolBar toolBar0 = ToolBar.f(((ToolBar)view0), v);
        q.f(toolBar0, "initLayoutType(...)");
        return toolBar0;
    }

    private final void checkAndHideMarkedFriend() {
        String s1;
        FollowerAdapter followerFragment$FollowerAdapter0 = this.mAdapter instanceof FollowerAdapter ? ((FollowerAdapter)this.mAdapter) : null;
        if(followerFragment$FollowerAdapter0 == null) {
            LogU.Companion.e("FollowerFragment", "checkAndHideMarkedFriend() invalid state.");
            return;
        }
        ArrayList arrayList0 = this.getMarkedList(false).d;
        q.d(arrayList0);
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object0: arrayList0) {
            q.d(((Integer)object0));
            USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0 = (USERLIST)followerFragment$FollowerAdapter0.getItem(((int)(((Integer)object0))));
            if(listFollowingFollowerRes$RESPONSE$USERLIST0 == null) {
                s1 = "";
            }
            else {
                String s = listFollowingFollowerRes$RESPONSE$USERLIST0.memberkey;
                if(s != null) {
                    s1 = s;
                }
            }
            arrayList1.add(s1);
        }
        ArrayList arrayList2 = new ArrayList();
        for(Object object1: arrayList1) {
            if(((String)object1).length() > 0) {
                arrayList2.add(object1);
            }
        }
        if(!arrayList2.isEmpty()) {
            b.x(this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F130473, new Object[]{arrayList2.size()}), false, false, null, null, new c(this, arrayList2, arrayList0, 0), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
        }
    }

    private static final H checkAndHideMarkedFriend$lambda$13(FollowerFragment followerFragment0, List list0, List list1) {
        String s = followerFragment0.mMenuId;
        q.f(s, "mMenuId");
        q.d(list1);
        followerFragment0.requestHide(s, list0, list1);
        return H.a;
    }

    private final void checkAndUnhideMarkedFriend() {
        String s1;
        FollowerAdapter followerFragment$FollowerAdapter0 = this.mAdapter instanceof FollowerAdapter ? ((FollowerAdapter)this.mAdapter) : null;
        if(followerFragment$FollowerAdapter0 == null) {
            LogU.Companion.e("FollowerFragment", "checkAndRequestUnhideMarkedFriend() invalid state.");
            return;
        }
        ArrayList arrayList0 = this.getMarkedList(false).d;
        q.d(arrayList0);
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object0: arrayList0) {
            q.d(((Integer)object0));
            USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0 = (USERLIST)followerFragment$FollowerAdapter0.getItem(((int)(((Integer)object0))));
            if(listFollowingFollowerRes$RESPONSE$USERLIST0 == null) {
                s1 = "";
            }
            else {
                String s = listFollowingFollowerRes$RESPONSE$USERLIST0.memberkey;
                if(s != null) {
                    s1 = s;
                }
            }
            arrayList1.add(s1);
        }
        ArrayList arrayList2 = new ArrayList();
        for(Object object1: arrayList1) {
            if(((String)object1).length() > 0) {
                arrayList2.add(object1);
            }
        }
        if(!arrayList2.isEmpty()) {
            b.x(this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F130475, new Object[]{arrayList2.size()}), false, false, null, null, new c(this, arrayList2, arrayList0, 1), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
        }
    }

    private static final H checkAndUnhideMarkedFriend$lambda$16(FollowerFragment followerFragment0, List list0, List list1) {
        String s = followerFragment0.mMenuId;
        q.f(s, "mMenuId");
        q.d(list1);
        followerFragment0.requestUnHide(s, list0, list1);
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new FollowerAdapter(this, context0, null);
    }

    private static final List filterTexts_delegate$lambda$0(FollowerFragment followerFragment0) {
        String[] arr_s;
        Context context0 = followerFragment0.getContext();
        if(context0 == null) {
            arr_s = null;
        }
        else {
            Resources resources0 = context0.getResources();
            arr_s = resources0 == null ? null : resources0.getStringArray(0x7F030038);  // array:sortingbar_follower
        }
        return arr_s != null ? k.A(Arrays.copyOf(arr_s, arr_s.length)) : je.w.a;
    }

    private final void follow(UserInfoBase userInfoBase0, a a0) {
        if(StringIds.a(userInfoBase0.memberkey, StringIds.i)) {
            this.updateLike("-1", "N10022", true, this.getMenuId(), new OnJobFinishListener() {
                @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                public void onJobComplete(String s, int v, boolean z) {
                    q.g(s, "errorMsg");
                    if(!a0.isFragmentValid()) {
                        return;
                    }
                    if(s.length() == 0) {
                        this.$onComplete.invoke();
                    }
                }

                @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                public void onStartAsyncTask() {
                }
            });
            return;
        }
        this.addOrDeleteFriend(userInfoBase0.memberkey, this.getMenuId(), true, new X8.a() {
            @Override  // X8.a
            public void onJobComplete(String s) {
                if(!a0.isFragmentValid()) {
                    return;
                }
                if(s != null && s.length() != 0) {
                    return;
                }
                this.$onComplete.invoke();
            }
        });
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.D0.buildUpon().appendQueryParameter("sortIndex", String.valueOf(this.filterIndex)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Nullable
    public final EditButtonEnableListener getEditButtonEnableListener() {
        return this.editButtonEnableListener;
    }

    private final List getFilterTexts() {
        return (List)this.filterTexts$delegate.getValue();
    }

    private final HttpRequest getRequestAlphabet(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.friend.FollowerFragment.FollowerAdapter");
        this.setToolbar(false);
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((FollowerAdapter)j00).clear(false);
        }
        Params listFollowerAlphabetReq$Params0 = new Params();
        listFollowerAlphabetReq$Params0.startIndex = i1.equals(i0) ? 1 : ((FollowerAdapter)j00).getCount() + 1;
        listFollowerAlphabetReq$Params0.pageSize = 100;
        listFollowerAlphabetReq$Params0.originCode = "A";
        return new ListFollowerAlphabetReq(this.getContext(), listFollowerAlphabetReq$Params0);
    }

    private final HttpRequest getRequestDj(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.friend.FollowerFragment.FollowerAdapter");
        this.setToolbar(false);
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((FollowerAdapter)j00).clear(false);
        }
        com.iloen.melon.net.v6x.request.ListFollowerDjReq.Params listFollowerDjReq$Params0 = new com.iloen.melon.net.v6x.request.ListFollowerDjReq.Params();
        listFollowerDjReq$Params0.startIndex = i1.equals(i0) ? 1 : ((FollowerAdapter)j00).getCount() + 1;
        listFollowerDjReq$Params0.pageSize = 100;
        listFollowerDjReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        return new ListFollowerDjReq(this.getContext(), listFollowerDjReq$Params0);
    }

    private final HttpRequest getRequestHidden(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.friend.FollowerFragment.FollowerAdapter");
        int v = 1;
        this.setToolbar(true);
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((FollowerAdapter)j00).clear(false);
        }
        com.iloen.melon.net.v6x.request.ListFollowerRecentActReq.Params listFollowerRecentActReq$Params0 = new com.iloen.melon.net.v6x.request.ListFollowerRecentActReq.Params();
        if(!i1.equals(i0)) {
            v = ((FollowerAdapter)j00).getCount() + 1;
        }
        listFollowerRecentActReq$Params0.startIndex = v;
        listFollowerRecentActReq$Params0.pageSize = 100;
        listFollowerRecentActReq$Params0.originCode = "H";
        return new ListFollowerRecentActReq(this.getContext(), listFollowerRecentActReq$Params0);
    }

    private final HttpRequest getRequestOrigin(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.friend.FollowerFragment.FollowerAdapter");
        this.setToolbar(false);
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((FollowerAdapter)j00).clear(false);
        }
        com.iloen.melon.net.v6x.request.ListFollowerOriginReq.Params listFollowerOriginReq$Params0 = new com.iloen.melon.net.v6x.request.ListFollowerOriginReq.Params();
        listFollowerOriginReq$Params0.startIndex = i1.equals(i0) ? 1 : ((FollowerAdapter)j00).getCount() + 1;
        listFollowerOriginReq$Params0.pageSize = 100;
        return new ListFollowerOriginReq(this.getContext(), listFollowerOriginReq$Params0);
    }

    private final HttpRequest getRequestRecent(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.friend.FollowerFragment.FollowerAdapter");
        this.setToolbar(false);
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((FollowerAdapter)j00).clear(false);
        }
        com.iloen.melon.net.v6x.request.ListFollowerRecentAddReq.Params listFollowerRecentAddReq$Params0 = new com.iloen.melon.net.v6x.request.ListFollowerRecentAddReq.Params();
        listFollowerRecentAddReq$Params0.startIndex = i1.equals(i0) ? 1 : ((FollowerAdapter)j00).getCount() + 1;
        listFollowerRecentAddReq$Params0.pageSize = 100;
        listFollowerRecentAddReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        return new ListFollowerRecentAddReq(this.getContext(), listFollowerRecentAddReq$Params0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            bundle0 = bundle1;
        }
        if(bundle0 != null) {
            String s = bundle0.getString("argNickName", "");
            q.f(s, "getString(...)");
            this.nickname = s;
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D027C, viewGroup0, false);  // layout:follower_main
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onEditButtonClick(boolean z, boolean z1) {
        LogU.Companion.d("FollowerFragment", "onEditButtonClick() isEditMode: " + z);
        j0 j00 = this.getAdapter();
        ListMarker listMarker0 = j00 instanceof ListMarker ? ((ListMarker)j00) : null;
        if(listMarker0 != null) {
            listMarker0.setMarkedMode(z);
            this.getAdapter().notifyDataSetChanged();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull v9.h h0, @NotNull String s) {
        HttpRequest httpRequest0;
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        switch(this.filterIndex) {
            case 0: {
                httpRequest0 = this.getRequestRecent(i0);
                break;
            }
            case 1: {
                httpRequest0 = this.getRequestAlphabet(i0);
                break;
            }
            case 2: {
                httpRequest0 = this.getRequestDj(i0);
                break;
            }
            case 3: {
                httpRequest0 = this.getRequestOrigin(i0);
                break;
            }
            case 4: {
                httpRequest0 = this.getRequestHidden(i0);
                break;
            }
            default: {
                httpRequest0 = null;
            }
        }
        if(httpRequest0 != null) {
            EditButtonEnableListener followerFragment$EditButtonEnableListener0 = this.editButtonEnableListener;
            if(followerFragment$EditButtonEnableListener0 != null) {
                followerFragment$EditButtonEnableListener0.onEditButtonEnableStateChange(false);
            }
            RequestBuilder.newInstance(httpRequest0).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.friend.e(this, i0, 4)).errorListener(new com.iloen.melon.fragments.friend.b(this, 2)).request();
        }
        return true;
    }

    private static final void onFetchStart$lambda$1(FollowerFragment followerFragment0, i i0, ListFollowingFollowerRes listFollowingFollowerRes0) {
        String s;
        if(!followerFragment0.prepareFetchComplete(listFollowingFollowerRes0)) {
            followerFragment0.followerCount = "0";
            followerFragment0.mAdapter.notifyDataSetChanged();
            return;
        }
        RESPONSE listFollowingFollowerRes$RESPONSE0 = listFollowingFollowerRes0.response;
        if(listFollowingFollowerRes$RESPONSE0 == null) {
            s = "";
        }
        else {
            s = listFollowingFollowerRes$RESPONSE0.friendCnt;
            if(s == null) {
                s = "";
            }
        }
        followerFragment0.followerCount = s;
        EditButtonEnableListener followerFragment$EditButtonEnableListener0 = followerFragment0.editButtonEnableListener;
        if(followerFragment$EditButtonEnableListener0 != null) {
            followerFragment$EditButtonEnableListener0.onEditButtonEnableStateChange(true);
        }
        followerFragment0.performFetchComplete(i0, listFollowingFollowerRes0);
    }

    private static final void onFetchStart$lambda$2(FollowerFragment followerFragment0, VolleyError volleyError0) {
        followerFragment0.performFetchError(volleyError0);
        followerFragment0.followerCount = "";
        followerFragment0.mAdapter.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@NotNull ToolBarItem toolBar$ToolBarItem0, int v) {
        q.g(toolBar$ToolBarItem0, "item");
        if(v == 26 || v == 27) {
            if(!this.isLoginUser()) {
                ToastManager.showShort(0x7F1308D1);  // string:retry_after_login "로그인 후 이용해 주세요."
                return;
            }
            if(this.mAdapter instanceof FollowerAdapter) {
                if(this.getMarkedList(false).d.size() > 0) {
                    if(this.filterIndex == 4) {
                        this.checkAndUnhideMarkedFriend();
                        return;
                    }
                    this.checkAndHideMarkedFriend();
                    return;
                }
                String s = this.getString(0x7F13046E);  // string:friend_dlg_body_delete_select_content "친구를 선택해 주세요."
                q.f(s, "getString(...)");
                l0 l00 = this.getChildFragmentManager();
                String s1 = this.getString(0x7F1300CD);  // string:alert_dlg_title_delete_confirm "안내"
                b.d(b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
            }
        }
    }

    private final void processData(List list0) {
        j0 j00 = this.getAdapter();
        FollowerAdapter followerFragment$FollowerAdapter0 = j00 instanceof FollowerAdapter ? ((FollowerAdapter)j00) : null;
        if(followerFragment$FollowerAdapter0 != null) {
            followerFragment$FollowerAdapter0.setUnmarkedAll();
            for(int v = list0.size() - 1; v >= 0; --v) {
                followerFragment$FollowerAdapter0.remove(((Number)list0.get(v)).intValue());
            }
        }
        this.updateToolBar(true);
        if(this.getItemCount() <= 0) {
            this.setEditMode(false, this.nickname);
            this.startFetch("all data delete");
        }
    }

    private final void requestHide(String s, List list0, List list1) {
        this.showProgress(true);
        RequestBuilder.newInstance(new InsertHiddenFriendReq(this.getContext(), new ArrayList(list0), s)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.friend.a(this, list1, 1)).errorListener(new com.iloen.melon.fragments.friend.b(this, 1)).request();
    }

    private static final void requestHide$lambda$17(FollowerFragment followerFragment0, List list0, InsertHiddenFriendRes insertHiddenFriendRes0) {
        followerFragment0.showProgress(false);
        if(insertHiddenFriendRes0 != null && insertHiddenFriendRes0.isSuccessful()) {
            followerFragment0.processData(list0);
        }
    }

    private static final void requestHide$lambda$18(FollowerFragment followerFragment0, VolleyError volleyError0) {
        followerFragment0.showProgress(false);
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final void requestUnHide(String s, List list0, List list1) {
        this.showProgress(true);
        RequestBuilder.newInstance(new DeleteHiddenFriendReq(this.getContext(), new ArrayList(list0), s)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.friend.a(this, list1, 0)).errorListener(new com.iloen.melon.fragments.friend.b(this, 0)).request();
    }

    private static final void requestUnHide$lambda$19(FollowerFragment followerFragment0, List list0, DeleteHiddenFriendRes deleteHiddenFriendRes0) {
        followerFragment0.showProgress(false);
        if(deleteHiddenFriendRes0 != null && deleteHiddenFriendRes0.isSuccessful()) {
            followerFragment0.processData(list0);
        }
    }

    private static final void requestUnHide$lambda$20(FollowerFragment followerFragment0, VolleyError volleyError0) {
        followerFragment0.showProgress(false);
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    public final void setEditButtonEnableListener(@Nullable EditButtonEnableListener followerFragment$EditButtonEnableListener0) {
        this.editButtonEnableListener = followerFragment$EditButtonEnableListener0;
    }

    public final void setEditMode() {
        this.setEditMode(true, (this.getContext() == null ? null : "팔로워"), false, true);
    }

    private final void setToolbar(boolean z) {
        ToolBar toolBar0 = this.mToolBar;
        toolBar0.g();
        toolBar0.k((z ? 0x7F131091 : 0x7F131082), (z ? 27 : 26));  // string:toolbar_unhide_friend "숨김 해제"
    }

    public static void setToolbar$default(FollowerFragment followerFragment0, boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            z = false;
        }
        followerFragment0.setToolbar(z);
    }

    private final void unfollow(UserInfoBase userInfoBase0, a a0) {
        if(StringIds.a(userInfoBase0.memberkey, StringIds.i)) {
            this.updateLike("-1", "N10022", false, this.getMenuId(), new OnJobFinishListener() {
                @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                public void onJobComplete(String s, int v, boolean z) {
                    q.g(s, "errorMsg");
                    if(!a0.isFragmentValid()) {
                        return;
                    }
                    if(s.length() == 0) {
                        this.$onComplete.invoke();
                    }
                }

                @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                public void onStartAsyncTask() {
                }
            });
            return;
        }
        this.addOrDeleteFriend(userInfoBase0.memberkey, this.getMenuId(), false, new X8.a() {
            @Override  // X8.a
            public void onJobComplete(String s) {
                if(!a0.isFragmentValid()) {
                    return;
                }
                if(s != null && s.length() != 0) {
                    return;
                }
                this.$onComplete.invoke();
            }
        });
    }
}

