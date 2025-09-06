package com.iloen.melon.fragments.friend;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.FollowToggleButton;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.UserInfoBase;
import com.iloen.melon.net.v6x.request.ListFollowingAlphabetReq.Params;
import com.iloen.melon.net.v6x.request.ListFollowingAlphabetReq;
import com.iloen.melon.net.v6x.request.ListFollowingDjReq;
import com.iloen.melon.net.v6x.request.ListFollowingOriginReq;
import com.iloen.melon.net.v6x.request.ListFollowingRecentAddReq;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes.RESPONSE.USERLIST;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.ui.ViewUtils;
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
import v9.e;
import v9.h;
import v9.i;
import va.e0;
import va.o;
import we.a;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u0000 62\u00020\u0001:\u000267B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ\u001B\u0010\t\u001A\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\t\u0010\bJ\u001B\u0010\n\u001A\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\n\u0010\bJ\u001B\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u000B\u0010\bJ\u000F\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u001A\u001A\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\'\u0010 \u001A\u00020\u001F2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\fH\u0014\u00A2\u0006\u0004\b \u0010!J\u001B\u0010%\u001A\u0006\u0012\u0002\b\u00030$2\u0006\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b(\u0010)R\u0016\u0010*\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001A\u00020,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b-\u0010.R)\u00105\u001A\u0010\u0012\f\u0012\n 0*\u0004\u0018\u00010\f0\f0/8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b1\u00102\u001A\u0004\b3\u00104\u00A8\u00068"}, d2 = {"Lcom/iloen/melon/fragments/friend/FollowingFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpRequest;", "getRequestRecent", "(Lv9/i;)Lcom/iloen/melon/net/HttpRequest;", "getRequestAlphabet", "getRequestDj", "getRequestOrigin", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "followingCount", "Ljava/lang/String;", "", "filterIndex", "I", "", "kotlin.jvm.PlatformType", "filterTexts$delegate", "Lie/j;", "getFilterTexts", "()Ljava/util/List;", "filterTexts", "Companion", "FollowingAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FollowingFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001A\u00020\u0011R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/friend/FollowingFragment$Companion;", "", "<init>", "()V", "TAG", "", "SORT_RECENT", "", "SORT_ALPHABET", "SORT_DJ", "SORT_ORIGIN", "ADD", "", "DELETE", "ORIGIN_CODE_ALL", "PAGE_SIZE", "newInstance", "Lcom/iloen/melon/fragments/friend/FollowingFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final FollowingFragment newInstance() {
            return new FollowingFragment();
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0082\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000F\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\n2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J%\u0010\u0011\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\n2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000F\u0010\u0013\u001A\u00020\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\'\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u001A\u001A\u00020\u0019H\u0014¢\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010 \u001A\u00020\u00122\u0006\u0010\u001E\u001A\u00020\u00122\u0006\u0010\u001F\u001A\u00020\u0012H\u0016¢\u0006\u0004\b \u0010!J\u001F\u0010%\u001A\u00020\u00032\u0006\u0010#\u001A\u00020\"2\u0006\u0010$\u001A\u00020\u0012H\u0016¢\u0006\u0004\b%\u0010&J\'\u0010(\u001A\u00020\r2\u0006\u0010\'\u001A\u00020\u00032\u0006\u0010\u001E\u001A\u00020\u00122\u0006\u0010\u001F\u001A\u00020\u0012H\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010*\u001A\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001A\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b,\u0010+¨\u0006-"}, d2 = {"Lcom/iloen/melon/fragments/friend/FollowingFragment$FollowingAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/ListFollowingFollowerRes$RESPONSE$USERLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/friend/FollowingFragment;Landroid/content/Context;Ljava/util/List;)V", "Lcom/iloen/melon/net/v4x/common/UserInfoBase;", "data", "Lkotlin/Function0;", "Lie/H;", "onComplete", "follow", "(Lcom/iloen/melon/net/v4x/common/UserInfoBase;Lwe/a;)V", "unfollow", "", "getHeaderViewItemCount", "()I", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_TOP_FILTER", "I", "VIEW_TYPE_FRIEND", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class FollowingAdapter extends p {
        private final int VIEW_TYPE_FRIEND;
        private final int VIEW_TYPE_TOP_FILTER;

        public FollowingAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            FollowingFragment.this = followingFragment0;
            super(context0, list0);
            this.VIEW_TYPE_TOP_FILTER = 1;
            this.VIEW_TYPE_FRIEND = 2;
        }

        private final void follow(UserInfoBase userInfoBase0, a a0) {
            if(StringIds.a(userInfoBase0.memberkey, StringIds.i)) {
                String s = this.getMenuId();
                com.iloen.melon.fragments.friend.FollowingFragment.FollowingAdapter.follow.1 followingFragment$FollowingAdapter$follow$10 = new OnJobFinishListener() {
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
                };
                FollowingFragment.this.updateLike("-1", "N10022", true, s, followingFragment$FollowingAdapter$follow$10);
                return;
            }
            String s1 = userInfoBase0.memberkey;
            String s2 = this.getMenuId();
            com.iloen.melon.fragments.friend.FollowingFragment.FollowingAdapter.follow.2 followingFragment$FollowingAdapter$follow$20 = new X8.a() {
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
            };
            FollowingFragment.this.addOrDeleteFriend(s1, s2, true, followingFragment$FollowingAdapter$follow$20);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? this.VIEW_TYPE_TOP_FILTER : this.VIEW_TYPE_FRIEND;
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
                e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
                e0.d = -1;
                e0.e = -1;
                e0.g = -1;
                e0.i = -1;
                e0.k = -1;
                e0.l = -1;
                e0.f = FollowingFragment.this.getString(0x7F130446);  // string:following_empty_msg "친구가 없습니다. 친구를 추가하고 친구들과 음악을 공유해 보세요."
                this.setEmptyViewInfo(e0);
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            int v3;
            q.g(o00, "viewHolder");
            int v2 = 0;
            if(o00 instanceof B9.e) {
                MelonTextView melonTextView0 = ((B9.e)o00).b;
                MelonTextView melonTextView1 = ((B9.e)o00).a;
                FollowingFragment followingFragment0 = FollowingFragment.this;
                if(followingFragment0.followingCount.length() <= 0) {
                    v2 = 4;
                }
                melonTextView1.setVisibility(v2);
                q.f("전체 %s명", "getString(...)");
                l1.D(new Object[]{followingFragment0.followingCount}, 1, "전체 %s명", melonTextView1);
                List list0 = FollowingFragment.this.getFilterTexts();
                melonTextView0.setText(((String)je.p.n0(FollowingFragment.this.filterIndex, list0)));
                melonTextView0.setOnClickListener(new g(FollowingFragment.this, o00, 1));
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
                    ImageView imageView0 = ((m)o00).c;
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
                        imageView0.setVisibility(8);
                    }
                    else {
                        imageView0.setVisibility(0);
                        imageView0.setImageResource(v3);
                    }
                    ViewUtils.showWhen(followToggleButton0, true);
                    com.iloen.melon.fragments.friend.i i0 = new com.iloen.melon.fragments.friend.i(listFollowingFollowerRes$RESPONSE$USERLIST0, 1);
                    ViewUtils.setOnClickListener(o00.itemView, i0);
                    if(listFollowingFollowerRes$RESPONSE$USERLIST0.ismyfriend) {
                        followToggleButton0.setType(1);
                    }
                    else {
                        followToggleButton0.setType(0);
                    }
                    ViewUtils.setOnClickListener(followToggleButton0, new j(listFollowingFollowerRes$RESPONSE$USERLIST0, this, o00, 1));
                }
            }
        }

        private static final void onBindViewImpl$lambda$4(FollowingFragment followingFragment0, O0 o00, View view0) {
            if(followingFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = followingFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                    bottomSingleFilterListPopup0.setFilterItem(followingFragment0.getFilterTexts(), followingFragment0.filterIndex);
                    bottomSingleFilterListPopup0.setFilterListener(new com.iloen.melon.fragments.friend.e(followingFragment0, o00, 1));
                    bottomSingleFilterListPopup0.setOnDismissListener(followingFragment0.mDialogDismissListener);
                    followingFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        private static final void onBindViewImpl$lambda$4$lambda$3(FollowingFragment followingFragment0, O0 o00, int v) {
            followingFragment0.filterIndex = v;
            j0 j00 = followingFragment0.getAdapter();
            FollowingAdapter followingFragment$FollowingAdapter0 = j00 instanceof FollowingAdapter ? ((FollowingAdapter)j00) : null;
            if(followingFragment$FollowingAdapter0 != null) {
                followingFragment$FollowingAdapter0.clear(true);
            }
            String s = (String)je.p.n0(followingFragment0.filterIndex, followingFragment0.getFilterTexts());
            ((B9.e)o00).b.setText(s);
            followingFragment0.startFetch("filter change");
        }

        private static final void onBindViewImpl$lambda$6(USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0, View view0) {
            Navigator.openUserMain(listFollowingFollowerRes$RESPONSE$USERLIST0.memberkey);
        }

        private static final void onBindViewImpl$lambda$9(USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0, FollowingAdapter followingFragment$FollowingAdapter0, O0 o00, View view0) {
            if(listFollowingFollowerRes$RESPONSE$USERLIST0.ismyfriend) {
                followingFragment$FollowingAdapter0.unfollow(listFollowingFollowerRes$RESPONSE$USERLIST0, new f(listFollowingFollowerRes$RESPONSE$USERLIST0, o00, 2));
                return;
            }
            followingFragment$FollowingAdapter0.follow(listFollowingFollowerRes$RESPONSE$USERLIST0, new f(listFollowingFollowerRes$RESPONSE$USERLIST0, o00, 3));
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

        private final void unfollow(UserInfoBase userInfoBase0, a a0) {
            if(StringIds.a(userInfoBase0.memberkey, StringIds.i)) {
                String s = this.getMenuId();
                com.iloen.melon.fragments.friend.FollowingFragment.FollowingAdapter.unfollow.1 followingFragment$FollowingAdapter$unfollow$10 = new OnJobFinishListener() {
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
                };
                FollowingFragment.this.updateLike("-1", "N10022", false, s, followingFragment$FollowingAdapter$unfollow$10);
                return;
            }
            String s1 = userInfoBase0.memberkey;
            String s2 = this.getMenuId();
            com.iloen.melon.fragments.friend.FollowingFragment.FollowingAdapter.unfollow.2 followingFragment$FollowingAdapter$unfollow$20 = new X8.a() {
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
            };
            FollowingFragment.this.addOrDeleteFriend(s1, s2, false, followingFragment$FollowingAdapter$unfollow$20);
        }
    }

    public static final int $stable = 0;
    private static final boolean ADD = true;
    @NotNull
    public static final Companion Companion = null;
    private static final boolean DELETE = false;
    @NotNull
    private static final String ORIGIN_CODE_ALL = "A";
    private static final int PAGE_SIZE = 100;
    private static final int SORT_ALPHABET = 1;
    private static final int SORT_DJ = 2;
    private static final int SORT_ORIGIN = 3;
    private static final int SORT_RECENT = 0;
    @NotNull
    private static final String TAG = "FollowingFragment";
    private int filterIndex;
    @NotNull
    private final ie.j filterTexts$delegate;
    @NotNull
    private String followingCount;

    static {
        FollowingFragment.Companion = new Companion(null);
        FollowingFragment.$stable = 8;
    }

    public FollowingFragment() {
        this.followingCount = "";
        this.filterTexts$delegate = d3.g.Q(new d(this, 1));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new FollowingAdapter(this, context0, null);
    }

    private static final List filterTexts_delegate$lambda$0(FollowingFragment followingFragment0) {
        String[] arr_s;
        Context context0 = followingFragment0.getContext();
        if(context0 == null) {
            arr_s = null;
        }
        else {
            Resources resources0 = context0.getResources();
            arr_s = resources0 == null ? null : resources0.getStringArray(0x7F030039);  // array:sortingbar_following
        }
        return arr_s != null ? k.A(Arrays.copyOf(arr_s, arr_s.length)) : je.w.a;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.C0.buildUpon().appendQueryParameter("memberKey", u.v(((e0)o.a()).j())).appendQueryParameter("filterIndex", String.valueOf(this.filterIndex)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final List getFilterTexts() {
        return (List)this.filterTexts$delegate.getValue();
    }

    private final HttpRequest getRequestAlphabet(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.friend.FollowingFragment.FollowingAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((FollowingAdapter)j00).clear(false);
        }
        Params listFollowingAlphabetReq$Params0 = new Params();
        listFollowingAlphabetReq$Params0.startIndex = i1.equals(i0) ? 1 : ((FollowingAdapter)j00).getCount() + 1;
        listFollowingAlphabetReq$Params0.pageSize = 100;
        listFollowingAlphabetReq$Params0.originCode = "A";
        return new ListFollowingAlphabetReq(this.getContext(), listFollowingAlphabetReq$Params0);
    }

    private final HttpRequest getRequestDj(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.friend.FollowingFragment.FollowingAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((FollowingAdapter)j00).clear(false);
        }
        com.iloen.melon.net.v6x.request.ListFollowingDjReq.Params listFollowingDjReq$Params0 = new com.iloen.melon.net.v6x.request.ListFollowingDjReq.Params();
        listFollowingDjReq$Params0.startIndex = i1.equals(i0) ? 1 : ((FollowingAdapter)j00).getCount() + 1;
        listFollowingDjReq$Params0.pageSize = 100;
        listFollowingDjReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        return new ListFollowingDjReq(this.getContext(), listFollowingDjReq$Params0);
    }

    private final HttpRequest getRequestOrigin(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.friend.FollowingFragment.FollowingAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((FollowingAdapter)j00).clear(false);
        }
        com.iloen.melon.net.v6x.request.ListFollowingOriginReq.Params listFollowingOriginReq$Params0 = new com.iloen.melon.net.v6x.request.ListFollowingOriginReq.Params();
        listFollowingOriginReq$Params0.startIndex = i1.equals(i0) ? 1 : ((FollowingAdapter)j00).getCount() + 1;
        listFollowingOriginReq$Params0.pageSize = 100;
        return new ListFollowingOriginReq(this.getContext(), listFollowingOriginReq$Params0);
    }

    private final HttpRequest getRequestRecent(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.friend.FollowingFragment.FollowingAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((FollowingAdapter)j00).clear(false);
        }
        com.iloen.melon.net.v6x.request.ListFollowingRecentAddReq.Params listFollowingRecentAddReq$Params0 = new com.iloen.melon.net.v6x.request.ListFollowingRecentAddReq.Params();
        listFollowingRecentAddReq$Params0.startIndex = i1.equals(i0) ? 1 : ((FollowingAdapter)j00).getCount() + 1;
        listFollowingRecentAddReq$Params0.pageSize = 100;
        listFollowingRecentAddReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        return new ListFollowingRecentAddReq(this.getContext(), listFollowingRecentAddReq$Params0);
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
        return layoutInflater0.inflate(0x7F0D027E, viewGroup0, false);  // layout:following_main
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
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
            default: {
                httpRequest0 = null;
            }
        }
        if(httpRequest0 != null) {
            RequestBuilder.newInstance(httpRequest0).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.friend.e(this, i0, 5)).errorListener(new l(this, 0)).request();
        }
        return true;
    }

    private static final void onFetchStart$lambda$1(FollowingFragment followingFragment0, i i0, ListFollowingFollowerRes listFollowingFollowerRes0) {
        String s;
        if(!followingFragment0.prepareFetchComplete(listFollowingFollowerRes0)) {
            followingFragment0.followingCount = "0";
            followingFragment0.mAdapter.notifyDataSetChanged();
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
        followingFragment0.followingCount = s;
        followingFragment0.performFetchComplete(i0, listFollowingFollowerRes0);
    }

    private static final void onFetchStart$lambda$2(FollowingFragment followingFragment0, VolleyError volleyError0) {
        followingFragment0.performFetchError(volleyError0);
        followingFragment0.followingCount = "";
        followingFragment0.mAdapter.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }
}

