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
import com.iloen.melon.net.v6x.request.ListFollowerDjReq;
import com.iloen.melon.net.v6x.request.ListFollowerRecentAddReq.Params;
import com.iloen.melon.net.v6x.request.ListFollowerRecentAddReq;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes.RESPONSE.USERLIST;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.Navigator;
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
import v9.h;
import v9.i;
import va.e0;
import va.o;
import we.a;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u0000 =2\u00020\u0001:\u0002=>B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0007\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000E\u001A\u00020\f2\u0006\u0010\n\u001A\u00020\t2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ%\u0010\u0010\u001A\u00020\f2\u0006\u0010\n\u001A\u00020\t2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u000FJ\u000F\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\u0014H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u0017J-\u0010 \u001A\u0004\u0018\u00010\u001F2\u0006\u0010\u001B\u001A\u00020\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0014H\u0016\u00A2\u0006\u0004\b \u0010!J\'\u0010&\u001A\u00020%2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010#\u001A\u00020\"2\u0006\u0010$\u001A\u00020\u0011H\u0014\u00A2\u0006\u0004\b&\u0010\'J\u001B\u0010+\u001A\u0006\u0012\u0002\b\u00030*2\u0006\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b+\u0010,J\u000F\u0010.\u001A\u00020-H\u0014\u00A2\u0006\u0004\b.\u0010/R\u0018\u00100\u001A\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u00101R\u0016\u00104\u001A\u0002038\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u00105R)\u0010<\u001A\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010\u00110\u0011068BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b8\u00109\u001A\u0004\b:\u0010;\u00A8\u0006?"}, d2 = {"Lcom/iloen/melon/fragments/friend/OtherFollowerFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpRequest;", "getRequest", "(Lv9/i;)Lcom/iloen/melon/net/HttpRequest;", "Lcom/iloen/melon/net/v4x/common/UserInfoBase;", "data", "Lkotlin/Function0;", "Lie/H;", "onComplete", "follow", "(Lcom/iloen/melon/net/v4x/common/UserInfoBase;Lwe/a;)V", "unfollow", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "otherMemberKey", "Ljava/lang/String;", "followerCount", "", "filterIndex", "I", "", "kotlin.jvm.PlatformType", "filterTexts$delegate", "Lie/j;", "getFilterTexts", "()Ljava/util/List;", "filterTexts", "Companion", "FollowerAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class OtherFollowerFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/friend/OtherFollowerFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_OTHER_MEMBER_KEY", "SORT_RECENT", "", "SORT_DJ", "ADD", "", "DELETE", "newInstance", "Lcom/iloen/melon/fragments/friend/OtherFollowerFragment;", "otherMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final OtherFollowerFragment newInstance(@Nullable String s) {
            OtherFollowerFragment otherFollowerFragment0 = new OtherFollowerFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argOtherMemberKey", s);
            otherFollowerFragment0.setArguments(bundle0);
            return otherFollowerFragment0;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0010\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0018\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ\'\u0010!\u001A\u00020 2\u0006\u0010\u001F\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u0013H\u0016¢\u0006\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010$¨\u0006&"}, d2 = {"Lcom/iloen/melon/fragments/friend/OtherFollowerFragment$FollowerAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/ListFollowingFollowerRes$RESPONSE$USERLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/friend/OtherFollowerFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_TOP_FILTER", "I", "VIEW_TYPE_FRIEND", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class FollowerAdapter extends p {
        private final int VIEW_TYPE_FRIEND;
        private final int VIEW_TYPE_TOP_FILTER;

        public FollowerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.VIEW_TYPE_TOP_FILTER = 1;
            this.VIEW_TYPE_FRIEND = 2;
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
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            int v2 = 0;
            if(o00 instanceof m) {
                USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0 = (USERLIST)this.getItem(v1);
                if(listFollowingFollowerRes$RESPONSE$USERLIST0 != null) {
                    com.iloen.melon.fragments.friend.i i0 = new com.iloen.melon.fragments.friend.i(listFollowingFollowerRes$RESPONSE$USERLIST0, 2);
                    ViewUtils.setOnClickListener(o00.itemView, i0);
                    FollowToggleButton followToggleButton0 = ((m)o00).h;
                    ((m)o00).c(listFollowingFollowerRes$RESPONSE$USERLIST0.mypageimg);
                    ((m)o00).b(listFollowingFollowerRes$RESPONSE$USERLIST0.memberDjIconType);
                    ((m)o00).e.setText(listFollowingFollowerRes$RESPONSE$USERLIST0.membernickname);
                    ViewUtils.showWhen(((m)o00).g, listFollowingFollowerRes$RESPONSE$USERLIST0.isOfficial);
                    ((m)o00).a(listFollowingFollowerRes$RESPONSE$USERLIST0.myPageDesc);
                    if(q.b(listFollowingFollowerRes$RESPONSE$USERLIST0.memberkey, u.v(((e0)o.a()).j()))) {
                        followToggleButton0.setVisibility(8);
                    }
                    else {
                        followToggleButton0.setVisibility(0);
                        ViewUtils.setOnClickListener(followToggleButton0, new j(listFollowingFollowerRes$RESPONSE$USERLIST0, OtherFollowerFragment.this, o00, 2));
                    }
                    if(listFollowingFollowerRes$RESPONSE$USERLIST0.ismyfriend) {
                        followToggleButton0.setType(1);
                        return;
                    }
                    followToggleButton0.setType(0);
                }
            }
            else if(o00 instanceof e) {
                MelonTextView melonTextView0 = ((e)o00).b;
                MelonTextView melonTextView1 = ((e)o00).a;
                OtherFollowerFragment otherFollowerFragment0 = OtherFollowerFragment.this;
                if(otherFollowerFragment0.followerCount.length() <= 0) {
                    v2 = 4;
                }
                melonTextView1.setVisibility(v2);
                q.f("전체 %s명", "getString(...)");
                l1.D(new Object[]{otherFollowerFragment0.followerCount}, 1, "전체 %s명", melonTextView1);
                List list0 = OtherFollowerFragment.this.getFilterTexts();
                melonTextView0.setText(((String)je.p.n0(OtherFollowerFragment.this.filterIndex, list0)));
                melonTextView0.setOnClickListener(new g(OtherFollowerFragment.this, o00, 2));
            }
        }

        private static final void onBindViewImpl$lambda$1(USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0, View view0) {
            Navigator.openUserMain(listFollowingFollowerRes$RESPONSE$USERLIST0.memberkey);
        }

        private static final void onBindViewImpl$lambda$4(USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0, OtherFollowerFragment otherFollowerFragment0, O0 o00, View view0) {
            if(listFollowingFollowerRes$RESPONSE$USERLIST0.ismyfriend) {
                otherFollowerFragment0.unfollow(listFollowingFollowerRes$RESPONSE$USERLIST0, new f(listFollowingFollowerRes$RESPONSE$USERLIST0, o00, 4));
                return;
            }
            otherFollowerFragment0.follow(listFollowingFollowerRes$RESPONSE$USERLIST0, new f(listFollowingFollowerRes$RESPONSE$USERLIST0, o00, 5));
        }

        private static final H onBindViewImpl$lambda$4$lambda$2(USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0, O0 o00) {
            listFollowingFollowerRes$RESPONSE$USERLIST0.ismyfriend = false;
            ((m)o00).h.setType(0);
            return H.a;
        }

        private static final H onBindViewImpl$lambda$4$lambda$3(USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0, O0 o00) {
            listFollowingFollowerRes$RESPONSE$USERLIST0.ismyfriend = true;
            ((m)o00).h.setType(1);
            return H.a;
        }

        private static final void onBindViewImpl$lambda$7(OtherFollowerFragment otherFollowerFragment0, O0 o00, View view0) {
            if(otherFollowerFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = otherFollowerFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                    bottomSingleFilterListPopup0.setFilterItem(otherFollowerFragment0.getFilterTexts(), otherFollowerFragment0.filterIndex);
                    bottomSingleFilterListPopup0.setFilterListener(new com.iloen.melon.fragments.friend.e(otherFollowerFragment0, o00, 2));
                    bottomSingleFilterListPopup0.setOnDismissListener(otherFollowerFragment0.mDialogDismissListener);
                    otherFollowerFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        private static final void onBindViewImpl$lambda$7$lambda$6(OtherFollowerFragment otherFollowerFragment0, O0 o00, int v) {
            otherFollowerFragment0.filterIndex = v;
            String s = (String)je.p.n0(otherFollowerFragment0.filterIndex, otherFollowerFragment0.getFilterTexts());
            ((e)o00).b.setText(s);
            otherFollowerFragment0.startFetch("filter change");
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return v == this.VIEW_TYPE_TOP_FILTER ? z6.f.p(viewGroup0, 0.0f, 6) : w.M(viewGroup0);
        }
    }

    public static final int $stable = 0;
    private static final boolean ADD = true;
    @NotNull
    private static final String ARG_OTHER_MEMBER_KEY = "argOtherMemberKey";
    @NotNull
    public static final Companion Companion = null;
    private static final boolean DELETE = false;
    private static final int SORT_DJ = 1;
    private static final int SORT_RECENT = 0;
    @NotNull
    private static final String TAG = "OtherFollowerFragment";
    private int filterIndex;
    @NotNull
    private final ie.j filterTexts$delegate;
    @NotNull
    private String followerCount;
    @Nullable
    private String otherMemberKey;

    static {
        OtherFollowerFragment.Companion = new Companion(null);
        OtherFollowerFragment.$stable = 8;
    }

    public OtherFollowerFragment() {
        this.otherMemberKey = "";
        this.followerCount = "";
        this.filterTexts$delegate = d3.g.Q(new d(this, 2));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new FollowerAdapter(this, context0, null);
    }

    private static final List filterTexts_delegate$lambda$0(OtherFollowerFragment otherFollowerFragment0) {
        String[] arr_s;
        Context context0 = otherFollowerFragment0.getContext();
        if(context0 == null) {
            arr_s = null;
        }
        else {
            Resources resources0 = context0.getResources();
            arr_s = resources0 == null ? null : resources0.getStringArray(0x7F030044);  // array:sortingbar_other_follower
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
        return l1.e(MelonContentUris.H0.buildUpon(), this.otherMemberKey, "toString(...)");
    }

    private final List getFilterTexts() {
        return (List)this.filterTexts$delegate.getValue();
    }

    private final HttpRequest getRequest(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.friend.OtherFollowerFragment.FollowerAdapter");
        i i1 = i.b;
        int v = 1;
        switch(this.filterIndex) {
            case 0: {
                Params listFollowerRecentAddReq$Params0 = new Params();
                if(!i1.equals(i0)) {
                    v = ((FollowerAdapter)j00).getCount() + 1;
                }
                listFollowerRecentAddReq$Params0.startIndex = v;
                listFollowerRecentAddReq$Params0.pageSize = 100;
                listFollowerRecentAddReq$Params0.targetMemberKey = this.otherMemberKey;
                return new ListFollowerRecentAddReq(this.getContext(), listFollowerRecentAddReq$Params0);
            }
            case 1: {
                com.iloen.melon.net.v6x.request.ListFollowerDjReq.Params listFollowerDjReq$Params0 = new com.iloen.melon.net.v6x.request.ListFollowerDjReq.Params();
                if(!i1.equals(i0)) {
                    v = ((FollowerAdapter)j00).getCount() + 1;
                }
                listFollowerDjReq$Params0.startIndex = v;
                listFollowerDjReq$Params0.pageSize = 100;
                listFollowerDjReq$Params0.targetMemberKey = this.otherMemberKey;
                return new ListFollowerDjReq(this.getContext(), listFollowerDjReq$Params0);
            }
            default: {
                return null;
            }
        }
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
        return layoutInflater0.inflate(0x7F0D058C, viewGroup0, false);  // layout:other_following_main
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.friend.OtherFollowerFragment.FollowerAdapter");
        if(i.b.equals(i0)) {
            ((FollowerAdapter)j00).clear(false);
        }
        RequestBuilder.newInstance(this.getRequest(i0)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.friend.e(this, i0, 6)).errorListener(new l(this, 2)).request();
        return true;
    }

    private static final void onFetchStart$lambda$1(OtherFollowerFragment otherFollowerFragment0, i i0, ListFollowingFollowerRes listFollowingFollowerRes0) {
        String s;
        if(!otherFollowerFragment0.prepareFetchComplete(listFollowingFollowerRes0)) {
            otherFollowerFragment0.followerCount = "0";
            otherFollowerFragment0.mAdapter.notifyDataSetChanged();
            return;
        }
        if(listFollowingFollowerRes0 == null) {
            s = "";
        }
        else {
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
        }
        otherFollowerFragment0.followerCount = s;
        otherFollowerFragment0.performFetchComplete(i0, listFollowingFollowerRes0);
    }

    private static final void onFetchStart$lambda$2(OtherFollowerFragment otherFollowerFragment0, VolleyError volleyError0) {
        otherFollowerFragment0.performFetchError(volleyError0);
        otherFollowerFragment0.followerCount = "";
        otherFollowerFragment0.mAdapter.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.otherMemberKey = bundle0.getString("argOtherMemberKey");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argOtherMemberKey", this.otherMemberKey);
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

