package com.iloen.melon.fragments.friend;

import B.a;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.f0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import cd.V2;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.FollowToggleButton;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.DjPlaylistDetailFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.ListRecmFriendReq.Params;
import com.iloen.melon.net.v4x.request.ListRecmFriendReq;
import com.iloen.melon.net.v4x.request.MyMusicFriendListInviteUserReq;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v4x.response.ListRecmFriendRes.RESPONSE.USERLIST;
import com.iloen.melon.net.v4x.response.ListRecmFriendRes.RESPONSE;
import com.iloen.melon.net.v4x.response.ListRecmFriendRes;
import com.iloen.melon.net.v4x.response.MyMusicFriendListInviteUserRes;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.sns.target.SnsManager.SnsType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.cipher.RijndaelAlgorithmUtils;
import com.iloen.melon.utils.contacts.ContactAccessor;
import com.iloen.melon.utils.contacts.ContactInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.sdk.share.ShareClient;
import com.kakao.tiara.data.ActionKind;
import e.b;
import e1.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import p8.O;
import p8.f;
import p8.g;
import p8.s;
import pc.t;
import t9.D;
import t9.F;
import v9.e;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class FriendAddFragment extends MetaContentBaseFragment {
    public class FriendAddAdapter extends p {
        class HeaderViewHolder extends O0 {
            private View contactInviteLayout;
            private View kakaoInviteLayout;
            private View melonAddLayout;

            public HeaderViewHolder(View view0) {
                super(view0);
                this.melonAddLayout = view0.findViewById(0x7F0A07F2);  // id:melon_add_layout
                this.kakaoInviteLayout = view0.findViewById(0x7F0A06C5);  // id:kakao_invite_layout
                this.contactInviteLayout = view0.findViewById(0x7F0A0319);  // id:contact_invite_layout
            }

            public static View a(HeaderViewHolder friendAddFragment$FriendAddAdapter$HeaderViewHolder0) {
                return friendAddFragment$FriendAddAdapter$HeaderViewHolder0.contactInviteLayout;
            }

            public static View b(HeaderViewHolder friendAddFragment$FriendAddAdapter$HeaderViewHolder0) {
                return friendAddFragment$FriendAddAdapter$HeaderViewHolder0.kakaoInviteLayout;
            }

            public static View c(HeaderViewHolder friendAddFragment$FriendAddAdapter$HeaderViewHolder0) {
                return friendAddFragment$FriendAddAdapter$HeaderViewHolder0.melonAddLayout;
            }
        }

        class RecommandHeadHolder extends O0 {
            public RecommandHeadHolder(View view0) {
                super(view0);
            }
        }

        class RecommandHolder extends O0 {
            private ImageView attachDefaultThumbIv;
            private TextView attachInfoTv;
            private View attachLayout;
            private View attachLinearTextLayout;
            private ImageView attachPlayIv;
            private ImageView attachThumbIv;
            private TextView attachTitleTv;
            private ImageView attachUserDefaultThumbIv;
            private TextView attachUserInfoTv;
            private View attachUserLayout;
            private BorderImageView attachUserThumbIv;
            private TextView attachUserTitleTv;
            private TextView countHomeTv;
            private TextView countSongTv;
            private ImageView defaultThumbIv;
            private ImageView djIconIv;
            private View extraContainer;
            private FollowToggleButton followButton;
            private TextView genreTv;
            private ImageView newIv;
            private TextView reasonTv;
            private ImageView snsIconIv;
            private BorderImageView thumbIv;
            private View underline;
            private TextView userNicknameTv;
            private View userThumbLayout;

            public RecommandHolder(View view0) {
                super(view0);
                this.reasonTv = (TextView)view0.findViewById(0x7F0A09C1);  // id:reason_tv
                this.userThumbLayout = view0.findViewById(0x7F0A00BF);  // id:artist_thumb_layout
                ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.defaultThumbIv = imageView0;
                ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(friendAddFragment$FriendAddAdapter0.getContext(), 65.0f), true);
                this.thumbIv = (BorderImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                ImageView imageView1 = (ImageView)view0.findViewById(0x7F0A0653);  // id:iv_new
                this.newIv = imageView1;
                imageView1.setVisibility(8);
                ImageView imageView2 = (ImageView)view0.findViewById(0x7F0A06A7);  // id:iv_thumbnail_circle_badge
                this.djIconIv = imageView2;
                imageView2.setVisibility(8);
                this.snsIconIv = (ImageView)view0.findViewById(0x7F0A068D);  // id:iv_sns_icon
                this.userNicknameTv = (TextView)view0.findViewById(0x7F0A0D4D);  // id:tv_user_nickname
                FollowToggleButton followToggleButton0 = (FollowToggleButton)view0.findViewById(0x7F0A04D3);  // id:follow_toggle_button
                this.followButton = followToggleButton0;
                followToggleButton0.setVisibility(0);
                View view1 = view0.findViewById(0x7F0A0483);  // id:extra_container
                this.extraContainer = view1;
                view1.setVisibility(0);
                this.genreTv = (TextView)view0.findViewById(0x7F0A0C83);  // id:tv_genre
                TextView textView0 = (TextView)view0.findViewById(0x7F0A0C52);  // id:tv_count_song
                this.countSongTv = textView0;
                textView0.setVisibility(0);
                TextView textView1 = (TextView)view0.findViewById(0x7F0A0C51);  // id:tv_count_home
                this.countHomeTv = textView1;
                textView1.setVisibility(0);
                View view2 = view0.findViewById(0x7F0A00CB);  // id:attached_layout
                this.attachLayout = view2;
                this.attachThumbIv = (ImageView)view2.findViewById(0x7F0A069A);  // id:iv_thumb
                this.attachDefaultThumbIv = (ImageView)this.attachLayout.findViewById(0x7F0A069E);  // id:iv_thumb_default
                this.attachPlayIv = (ImageView)this.attachLayout.findViewById(0x7F0A0B6F);  // id:thumb_btn_play
                this.attachLinearTextLayout = this.attachLayout.findViewById(0x7F0A0775);  // id:linear_text_layout
                this.attachInfoTv = (TextView)this.attachLayout.findViewById(0x7F0A0C8D);  // id:tv_info
                this.attachTitleTv = (TextView)this.attachLayout.findViewById(0x7F0A0D34);  // id:tv_title
                View view3 = view0.findViewById(0x7F0A00CA);  // id:attached_circle_layout
                this.attachUserLayout = view3;
                ImageView imageView3 = (ImageView)view3.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.attachUserDefaultThumbIv = imageView3;
                ViewUtils.setDefaultImage(imageView3, ScreenUtils.dipToPixel(friendAddFragment$FriendAddAdapter0.getContext(), 48.0f), true);
                this.attachUserThumbIv = (BorderImageView)this.attachUserLayout.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.attachUserLayout.findViewById(0x7F0A08EE).setVisibility(0);  // id:othermusic_home_layout
                this.attachUserInfoTv = (TextView)this.attachUserLayout.findViewById(0x7F0A057E);  // id:info_tv
                this.attachUserTitleTv = (TextView)this.attachUserLayout.findViewById(0x7F0A00C2);  // id:artist_tv
                this.underline = view0.findViewById(0x7F0A0D6B);  // id:underline
            }

            public static ImageView a(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.attachDefaultThumbIv;
            }

            public static TextView b(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.attachInfoTv;
            }

            public static View c(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.attachLayout;
            }

            public static View d(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.attachLinearTextLayout;
            }

            public static ImageView e(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.attachPlayIv;
            }

            public static ImageView f(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.attachThumbIv;
            }

            public static TextView g(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.attachTitleTv;
            }

            public static TextView h(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.attachUserInfoTv;
            }

            public static View i(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.attachUserLayout;
            }

            public static BorderImageView j(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.attachUserThumbIv;
            }

            public static TextView k(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.attachUserTitleTv;
            }

            public static TextView l(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.countHomeTv;
            }

            public static TextView m(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.countSongTv;
            }

            public static FollowToggleButton n(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.followButton;
            }

            public static TextView o(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.genreTv;
            }

            public static TextView p(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.reasonTv;
            }

            public static BorderImageView q(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.thumbIv;
            }

            public static View r(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.underline;
            }

            public static TextView s(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.userNicknameTv;
            }

            public static View t(RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0) {
                return friendAddFragment$FriendAddAdapter$RecommandHolder0.userThumbLayout;
            }
        }

        private static final int VIEW_TYPE_HEADER = 0;
        private static final int VIEW_TYPE_REASON = 2;
        private static final int VIEW_TYPE_RECOMMEND_REASON_HEADER = 1;
        private String lastIndexKey;

        public FriendAddAdapter(Context context0, List list0) {
            super(context0, list0);
            this.lastIndexKey = "1";
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            if(v == this.getAvailableHeaderPosition()) {
                return 0;
            }
            return this.getItem(v1) instanceof String ? 1 : 2;
        }

        public String getLastIndexKey() {
            return this.lastIndexKey;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) {
            if(httpResponse0 instanceof ListRecmFriendRes && ((ListRecmFriendRes)httpResponse0) != null) {
                RESPONSE listRecmFriendRes$RESPONSE0 = ((ListRecmFriendRes)httpResponse0).response;
                if(listRecmFriendRes$RESPONSE0 != null) {
                    this.setHasMore(listRecmFriendRes$RESPONSE0.hasMore);
                    this.setMenuId(((ListRecmFriendRes)httpResponse0).response.menuId);
                    this.updateModifiedTime(this.getCacheKey());
                    this.lastIndexKey = ((ListRecmFriendRes)httpResponse0).response.lastIndexKey;
                    ArrayList arrayList0 = ((ListRecmFriendRes)httpResponse0).response.userList;
                    if(i.b.equals(i0) && arrayList0 != null && arrayList0.size() > 0) {
                        this.add("title");
                    }
                    this.addAll(arrayList0);
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            switch(o00.getItemViewType()) {
                case 0: {
                    ViewUtils.setOnClickListener(HeaderViewHolder.c(((HeaderViewHolder)o00)), new View.OnClickListener() {
                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            FriendSearchFragment.newInstance().open();
                            FriendAddFragment.this.tiaraLogAddMelonFriend();
                        }
                    });
                    ViewUtils.setOnClickListener(HeaderViewHolder.b(((HeaderViewHolder)o00)), new View.OnClickListener() {
                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            FriendAddFragment.this.inviteKakaoTalk();
                            FriendAddFragment.this.tiaraLogInviteKakaoTalkFriend();
                        }
                    });
                    ViewUtils.setOnClickListener(HeaderViewHolder.a(((HeaderViewHolder)o00)), new View.OnClickListener() {
                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            FriendAddFragment.this.inviteContact();
                            FriendAddFragment.this.tiaraLogInvitePhoneFriend();
                        }
                    });
                    return;
                }
                case 2: {
                    RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0 = (RecommandHolder)o00;
                    USERLIST listRecmFriendRes$RESPONSE$USERLIST0 = (USERLIST)this.getItem(v1);
                    if(listRecmFriendRes$RESPONSE$USERLIST0 != null) {
                        RecommandHolder.p(friendAddFragment$FriendAddAdapter$RecommandHolder0).setText(Html.fromHtml(ResourceUtils.replaceFontColor(this.getContext(), (TextUtils.isEmpty(listRecmFriendRes$RESPONSE$USERLIST0.recmDesc) ? "" : listRecmFriendRes$RESPONSE$USERLIST0.recmDesc.trim()), 0), 0));
                        ViewUtils.setOnClickListener(RecommandHolder.t(friendAddFragment$FriendAddAdapter$RecommandHolder0), new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                if(!TextUtils.isEmpty(listRecmFriendRes$RESPONSE$USERLIST0.memberKey)) {
                                    Navigator.openUserMain(listRecmFriendRes$RESPONSE$USERLIST0.memberKey);
                                }
                            }
                        });
                        if(RecommandHolder.q(friendAddFragment$FriendAddAdapter$RecommandHolder0) != null) {
                            Glide.with(RecommandHolder.q(friendAddFragment$FriendAddAdapter$RecommandHolder0).getContext()).load(listRecmFriendRes$RESPONSE$USERLIST0.myPageImg).apply(RequestOptions.circleCropTransform()).into(RecommandHolder.q(friendAddFragment$FriendAddAdapter$RecommandHolder0));
                        }
                        RecommandHolder.s(friendAddFragment$FriendAddAdapter$RecommandHolder0).setText(listRecmFriendRes$RESPONSE$USERLIST0.memberNickName);
                        RecommandHolder.s(friendAddFragment$FriendAddAdapter$RecommandHolder0).requestLayout();
                        if(TextUtils.isEmpty(listRecmFriendRes$RESPONSE$USERLIST0.gnrName)) {
                            RecommandHolder.o(friendAddFragment$FriendAddAdapter$RecommandHolder0).setVisibility(8);
                        }
                        else {
                            RecommandHolder.o(friendAddFragment$FriendAddAdapter$RecommandHolder0).setVisibility(0);
                            RecommandHolder.o(friendAddFragment$FriendAddAdapter$RecommandHolder0).setText(listRecmFriendRes$RESPONSE$USERLIST0.gnrName);
                        }
                        RecommandHolder.m(friendAddFragment$FriendAddAdapter$RecommandHolder0).setText(StringUtils.getCountString(listRecmFriendRes$RESPONSE$USERLIST0.playListCnt, 0xF423F));
                        RecommandHolder.l(friendAddFragment$FriendAddAdapter$RecommandHolder0).setText(StringUtils.getCountString(listRecmFriendRes$RESPONSE$USERLIST0.totVisitCnt, 0xF423F));
                        ViewUtils.showWhen(RecommandHolder.c(friendAddFragment$FriendAddAdapter$RecommandHolder0), false);
                        ViewUtils.showWhen(RecommandHolder.i(friendAddFragment$FriendAddAdapter$RecommandHolder0), false);
                        ViewUtils.setOnClickListener(RecommandHolder.c(friendAddFragment$FriendAddAdapter$RecommandHolder0), null);
                        ViewUtils.setOnClickListener(RecommandHolder.i(friendAddFragment$FriendAddAdapter$RecommandHolder0), null);
                        ViewUtils.hideWhen(RecommandHolder.r(friendAddFragment$FriendAddAdapter$RecommandHolder0), true);
                        if("N10001".equals(listRecmFriendRes$RESPONSE$USERLIST0.actContsTypeCode)) {
                            ViewUtils.showWhen(RecommandHolder.c(friendAddFragment$FriendAddAdapter$RecommandHolder0), true);
                            RecommandHolder.a(friendAddFragment$FriendAddAdapter$RecommandHolder0).setImageBitmap(null);
                            if(RecommandHolder.f(friendAddFragment$FriendAddAdapter$RecommandHolder0) != null) {
                                Glide.with(RecommandHolder.f(friendAddFragment$FriendAddAdapter$RecommandHolder0).getContext()).load(listRecmFriendRes$RESPONSE$USERLIST0.actContsImgPath).into(RecommandHolder.f(friendAddFragment$FriendAddAdapter$RecommandHolder0));
                            }
                            RecommandHolder.e(friendAddFragment$FriendAddAdapter$RecommandHolder0).setVisibility(0);
                            RecommandHolder.d(friendAddFragment$FriendAddAdapter$RecommandHolder0).setVisibility(0);
                            RecommandHolder.b(friendAddFragment$FriendAddAdapter$RecommandHolder0).setVisibility(0);
                            RecommandHolder.g(friendAddFragment$FriendAddAdapter$RecommandHolder0).setVisibility(0);
                            RecommandHolder.b(friendAddFragment$FriendAddAdapter$RecommandHolder0).setText(Html.fromHtml(ResourceUtils.replaceFontColor(this.getContext(), listRecmFriendRes$RESPONSE$USERLIST0.targTactDesc, 0), 0));
                            RecommandHolder.g(friendAddFragment$FriendAddAdapter$RecommandHolder0).setText(listRecmFriendRes$RESPONSE$USERLIST0.actContsName + " - " + listRecmFriendRes$RESPONSE$USERLIST0.actContsArtistName);
                            ViewUtils.setOnClickListener(RecommandHolder.c(friendAddFragment$FriendAddAdapter$RecommandHolder0), new View.OnClickListener() {
                                @Override  // android.view.View$OnClickListener
                                public void onClick(View view0) {
                                    String s = listRecmFriendRes$RESPONSE$USERLIST0.actContsId;
                                    String s1 = FriendAddAdapter.this.getMenuId();
                                    FriendAddFragment.this.playSong(s, s1);
                                }
                            });
                        }
                        else if("N10002".equals(listRecmFriendRes$RESPONSE$USERLIST0.actContsTypeCode) || "N10009".equals(listRecmFriendRes$RESPONSE$USERLIST0.actContsTypeCode)) {
                            ViewUtils.showWhen(RecommandHolder.c(friendAddFragment$FriendAddAdapter$RecommandHolder0), true);
                            ViewUtils.setDefaultImage(RecommandHolder.a(friendAddFragment$FriendAddAdapter$RecommandHolder0), ScreenUtils.dipToPixel(this.getContext(), 48.0f));
                            if(RecommandHolder.f(friendAddFragment$FriendAddAdapter$RecommandHolder0) != null) {
                                Glide.with(RecommandHolder.f(friendAddFragment$FriendAddAdapter$RecommandHolder0).getContext()).load(listRecmFriendRes$RESPONSE$USERLIST0.actContsImgPath).into(RecommandHolder.f(friendAddFragment$FriendAddAdapter$RecommandHolder0));
                            }
                            RecommandHolder.d(friendAddFragment$FriendAddAdapter$RecommandHolder0).setVisibility(0);
                            RecommandHolder.b(friendAddFragment$FriendAddAdapter$RecommandHolder0).setVisibility(0);
                            RecommandHolder.g(friendAddFragment$FriendAddAdapter$RecommandHolder0).setVisibility(0);
                            RecommandHolder.b(friendAddFragment$FriendAddAdapter$RecommandHolder0).setText(Html.fromHtml(ResourceUtils.replaceFontColor(this.getContext(), listRecmFriendRes$RESPONSE$USERLIST0.targTactDesc, 0), 0));
                            RecommandHolder.g(friendAddFragment$FriendAddAdapter$RecommandHolder0).setText(listRecmFriendRes$RESPONSE$USERLIST0.actContsName + " - " + listRecmFriendRes$RESPONSE$USERLIST0.actContsArtistName);
                            ViewUtils.setOnClickListener(RecommandHolder.c(friendAddFragment$FriendAddAdapter$RecommandHolder0), new View.OnClickListener() {
                                @Override  // android.view.View$OnClickListener
                                public void onClick(View view0) {
                                    if("N10002".equals(listRecmFriendRes$RESPONSE$USERLIST0.actContsTypeCode)) {
                                        FriendAddFragment.this.showAlbumInfoPage(listRecmFriendRes$RESPONSE$USERLIST0.actContsId);
                                        return;
                                    }
                                    DjPlaylistDetailFragment.newInstance(listRecmFriendRes$RESPONSE$USERLIST0.actContsId).open();
                                }
                            });
                        }
                        else {
                            ViewUtils.showWhen(RecommandHolder.i(friendAddFragment$FriendAddAdapter$RecommandHolder0), true);
                            if(RecommandHolder.j(friendAddFragment$FriendAddAdapter$RecommandHolder0) != null) {
                                Glide.with(RecommandHolder.j(friendAddFragment$FriendAddAdapter$RecommandHolder0).getContext()).load(listRecmFriendRes$RESPONSE$USERLIST0.actContsArtistImgPath).apply(RequestOptions.circleCropTransform()).into(RecommandHolder.j(friendAddFragment$FriendAddAdapter$RecommandHolder0));
                            }
                            RecommandHolder.h(friendAddFragment$FriendAddAdapter$RecommandHolder0).setText(Html.fromHtml(ResourceUtils.replaceFontColor(this.getContext(), listRecmFriendRes$RESPONSE$USERLIST0.targTactDesc, 0), 0));
                            RecommandHolder.k(friendAddFragment$FriendAddAdapter$RecommandHolder0).setText(listRecmFriendRes$RESPONSE$USERLIST0.actContsArtistName);
                            ViewUtils.setOnClickListener(RecommandHolder.i(friendAddFragment$FriendAddAdapter$RecommandHolder0), new View.OnClickListener() {
                                @Override  // android.view.View$OnClickListener
                                public void onClick(View view0) {
                                    FriendAddFragment.this.showArtistInfoPage(listRecmFriendRes$RESPONSE$USERLIST0.actContsId);
                                }
                            });
                        }
                        if(listRecmFriendRes$RESPONSE$USERLIST0.isMyFriend) {
                            RecommandHolder.n(friendAddFragment$FriendAddAdapter$RecommandHolder0).setType(1);
                        }
                        else {
                            RecommandHolder.n(friendAddFragment$FriendAddAdapter$RecommandHolder0).setType(0);
                        }
                        ViewUtils.setOnClickListener(RecommandHolder.n(friendAddFragment$FriendAddAdapter$RecommandHolder0), new View.OnClickListener() {
                            private void lambda$onClick$0(USERLIST listRecmFriendRes$RESPONSE$USERLIST0, RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0, String s) {
                                if(FriendAddFragment.this.isFragmentValid() && TextUtils.isEmpty(s)) {
                                    listRecmFriendRes$RESPONSE$USERLIST0.isMyFriend = false;
                                    RecommandHolder.n(friendAddFragment$FriendAddAdapter$RecommandHolder0).setType(0);
                                }
                            }

                            private void lambda$onClick$1(USERLIST listRecmFriendRes$RESPONSE$USERLIST0, RecommandHolder friendAddFragment$FriendAddAdapter$RecommandHolder0, String s) {
                                if(FriendAddFragment.this.isFragmentValid() && TextUtils.isEmpty(s)) {
                                    listRecmFriendRes$RESPONSE$USERLIST0.isMyFriend = true;
                                    RecommandHolder.n(friendAddFragment$FriendAddAdapter$RecommandHolder0).setType(1);
                                }
                            }

                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                USERLIST listRecmFriendRes$RESPONSE$USERLIST0 = listRecmFriendRes$RESPONSE$USERLIST0;
                                if(listRecmFriendRes$RESPONSE$USERLIST0.isMyFriend) {
                                    String s = listRecmFriendRes$RESPONSE$USERLIST0.memberKey;
                                    String s1 = FriendAddAdapter.this.getMenuId();
                                    m m0 = new m(this, listRecmFriendRes$RESPONSE$USERLIST0, friendAddFragment$FriendAddAdapter$RecommandHolder0, 0);
                                    FriendAddFragment.this.addOrDeleteFriend(s, s1, false, m0);
                                    return;
                                }
                                String s2 = listRecmFriendRes$RESPONSE$USERLIST0.memberKey;
                                String s3 = FriendAddAdapter.this.getMenuId();
                                m m1 = new m(this, listRecmFriendRes$RESPONSE$USERLIST0, friendAddFragment$FriendAddAdapter$RecommandHolder0, 1);
                                FriendAddFragment.this.addOrDeleteFriend(s2, s3, true, m1);
                                FriendAddFragment.this.tiaraLogFollow(v1, listRecmFriendRes$RESPONSE$USERLIST0.memberNickName);
                            }
                        });
                    }
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 0: {
                    return new HeaderViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D02CC, viewGroup0, false));  // layout:friend_add_header
                }
                case 1: {
                    return new RecommandHeadHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D02CE, viewGroup0, false));  // layout:friend_add_recommend_header
                }
                case 2: {
                    return new RecommandHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D02CD, viewGroup0, false));  // layout:friend_add_recommand_reason
                }
                default: {
                    return null;
                }
            }
        }
    }

    class SpacesItemDecoration extends r0 {
        private SpacesItemDecoration() {
        }

        public SpacesItemDecoration(int v) {
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
            if(recyclerView0.getChildAdapterPosition(view0) == recyclerView0.getAdapter().getItemCount() - 1) {
                rect0.bottom = ScreenUtils.dipToPixel(FriendAddFragment.this.getContext(), 24.0f);
            }
        }
    }

    private static final String TAG = "FriendAddFragment";
    private b activityResult;

    public FriendAddFragment() {
        this.activityResult = this.registerForActivityResult(new f0(2), new l(this, 1));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new FriendAddAdapter(this, context0, null);
        ((p)j00).setEmptyViewInfo(e.n);
        return j00;
    }

    private f getBaseTiaraLogEventBuilder() {
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        s s0 = this.mMelonTiaraProperty;
        if(s0 != null) {
            f0.b = s0.a;
            f0.c = s0.b;
            f0.I = s0.c;
        }
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.E0.toString();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    private void inviteContact() {
        LogU.d("FriendAddFragment", "inviteContact()");
        ContactAccessor contactAccessor0 = ContactAccessor.getInstance();
        this.activityResult.b(contactAccessor0.getPickContactIntent());
    }

    private void inviteKakaoTalk() {
        if(!F.a.B(SnsManager.SnsType.d).b()) {
            ToastManager.show(0x7F13106E);  // string:toast_message_kakaotalk_need_install "카카오톡이 설치되어 있지 않습니다."
            return;
        }
        O.a(new PvLogDummyReq(this.getContext(), "mymusicFriendKakaoInvite"));
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
            String s = fragmentActivity0.getString(0x7F1304CA, new Object[]{""});  // string:kakaotalk_request_friend "%1$s 님이 회원님을 친구로 초대하였습니다. 멜론으로 연결해 친구와 음악을 공유해보세요."
            q.f(s, "getString(...)");
            Uri uri0 = r8.f.k.buildUpon().appendQueryParameter("mode", "K").appendQueryParameter("fkey", u.v(((e0)o.a()).j())).build();
            q.f(uri0, "build(...)");
            String s1 = uri0.toString();
            q.f(s1, "toString(...)");
            if(!TextUtils.isEmpty(s1)) {
                Pattern pattern0 = Pattern.compile("melonapp");
                q.f(pattern0, "compile(...)");
                String s2 = pattern0.matcher(s1).replaceAll("meloniphone");
                q.f(s2, "replaceAll(...)");
                t t0 = new t(16);
                t0.k("TITLE", s);
                t0.k("AND_SCHEME", s1);
                t0.k("IOS_SCHEME", s2);
                ShareClient shareClient0 = ShareClient.Companion.getInstance();
                HashMap hashMap0 = (HashMap)t0.b;
                V2 v20 = new V2(fragmentActivity0, 24);
                ShareClient.shareCustom$default(shareClient0, fragmentActivity0, D.b, hashMap0, null, v20, 8, null);
            }
        }
    }

    private void lambda$new$0(ActivityResult activityResult0) {
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                this.loadContactInfo(intent0.getData());
            }
        }
    }

    private void loadContactInfo(Uri uri0) {
        LogU.d("FriendAddFragment", "loadContactInfo() uri : " + uri0);
        if(uri0 == null) {
            return;
        }
        new x8.f() {
            public Object backgroundWork(Uri uri0, Continuation continuation0) {
                FragmentActivity fragmentActivity0 = FriendAddFragment.this.getActivity();
                return fragmentActivity0 != null ? ContactAccessor.getInstance().loadContact(fragmentActivity0.getContentResolver(), uri0) : null;
            }

            @Override  // x8.f
            public Object backgroundWork(Object object0, Continuation continuation0) {
                return this.backgroundWork(((Uri)object0), continuation0);
            }

            public void postTask(ContactInfo contactInfo0) {
                this.showInviteDlgFromContactPicker(contactInfo0);
            }

            @Override  // x8.f
            public void postTask(Object object0) {
                this.postTask(((ContactInfo)object0));
            }

            private void showInviteDlgFromContactPicker(ContactInfo contactInfo0) {
                String s = StringUtils.getOnlyNumberForPhoneNumber((contactInfo0 == null ? null : contactInfo0.getPhoneNumber()));
                if(StringUtils.isPhoneNumber(s)) {
                    String s1 = FriendAddFragment.this.getString(0x7F130470);  // string:friend_invite_explain "\'%1$s\'님을 초대하시겠습니까?"
                    FragmentActivity fragmentActivity0 = FriendAddFragment.this.getActivity();
                    com.iloen.melon.fragments.friend.FriendAddFragment.2.1 friendAddFragment$2$10 = new DialogInterface.OnClickListener() {
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface dialogInterface0, int v) {
                            if(v == -1) {
                                FriendAddFragment.this.requestFriendInvitationList(s, contactInfo0.getDisplayName());
                            }
                        }
                    };
                    MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopup(fragmentActivity0, 1, "초대 메시지", String.format(s1, contactInfo0.getDisplayName()), friendAddFragment$2$10);
                    if(melonTextPopup0 != null) {
                        FriendAddFragment.this.mRetainDialog = melonTextPopup0;
                        melonTextPopup0.setCentFlag(true);
                        melonTextPopup0.setOnDismissListener(FriendAddFragment.this.mDialogDismissListener);
                        melonTextPopup0.show();
                    }
                }
                else {
                    MelonTextPopup melonTextPopup1 = PopupHelper.makeTextPopup(FriendAddFragment.this.getActivity(), 0, "안내", "유효한 휴대폰 번호가 아닙니다.", new DialogInterface.OnClickListener() {
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface dialogInterface0, int v) {
                        }
                    });
                    if(melonTextPopup1 != null) {
                        FriendAddFragment.this.mRetainDialog = melonTextPopup1;
                        melonTextPopup1.setCentFlag(true);
                        melonTextPopup1.setOnDismissListener(FriendAddFragment.this.mDialogDismissListener);
                        melonTextPopup1.show();
                    }
                }
            }
        }.execute(uri0);
    }

    public static FriendAddFragment newInstance() {
        FriendAddFragment friendAddFragment0 = new FriendAddFragment();
        friendAddFragment0.setArguments(new Bundle());
        return friendAddFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView0.setAdapter(this.mAdapter);
        recyclerView0.addItemDecoration(new SpacesItemDecoration(this, 0));
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D02CB, viewGroup0, false);  // layout:friend_add_fragment
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        FriendAddAdapter friendAddFragment$FriendAddAdapter0 = (FriendAddAdapter)this.mAdapter;
        i i1 = i.b;
        if(i1.equals(i0)) {
            friendAddFragment$FriendAddAdapter0.clear(false);
        }
        Params listRecmFriendReq$Params0 = new Params();
        listRecmFriendReq$Params0.lastIndexKey = i1.equals(i0) ? "1" : friendAddFragment$FriendAddAdapter0.getLastIndexKey();
        listRecmFriendReq$Params0.pageSize = 10;
        RequestBuilder.newInstance(new ListRecmFriendReq(this.getContext(), listRecmFriendReq$Params0)).tag("FriendAddFragment").listener(new Listener() {
            public void onResponse(ListRecmFriendRes listRecmFriendRes0) {
                if(!FriendAddFragment.this.prepareFetchComplete(listRecmFriendRes0)) {
                    return;
                }
                RESPONSE listRecmFriendRes$RESPONSE0 = listRecmFriendRes0.response;
                if(listRecmFriendRes$RESPONSE0 != null) {
                    s s0 = new s(listRecmFriendRes$RESPONSE0.section, listRecmFriendRes$RESPONSE0.page, listRecmFriendRes$RESPONSE0.menuId, null);
                    FriendAddFragment.this.mMelonTiaraProperty = s0;
                }
                FriendAddFragment.this.performFetchComplete(i0, listRecmFriendRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((ListRecmFriendRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle("친구 추가");
        }
    }

    private void requestFriendInvitationList(String s, String s1) {
        this.showProgress(true);
        RequestBuilder.newInstance(new MyMusicFriendListInviteUserReq(this.getContext())).tag("FriendAddFragment").listener(new Listener() {
            public void onResponse(MyMusicFriendListInviteUserRes myMusicFriendListInviteUserRes0) {
                FriendAddFragment.this.showProgress(false);
                if(FriendAddFragment.this.isFragmentValid() && myMusicFriendListInviteUserRes0.isSuccessful()) {
                    String s = "N";
                    String s1 = RijndaelAlgorithmUtils.encode(s);
                    com.iloen.melon.net.v4x.response.MyMusicFriendListInviteUserRes.RESPONSE myMusicFriendListInviteUserRes$RESPONSE0 = myMusicFriendListInviteUserRes0.response;
                    if(myMusicFriendListInviteUserRes$RESPONSE0 != null) {
                        ArrayList arrayList0 = myMusicFriendListInviteUserRes$RESPONSE0.userList;
                        if(arrayList0 != null && arrayList0.size() > 0) {
                            for(Object object0: arrayList0) {
                                if(s1.equals(((com.iloen.melon.net.v4x.response.MyMusicFriendListInviteUserRes.RESPONSE.USERLIST)object0).phoneNumber)) {
                                    s = "Y";
                                    break;
                                }
                            }
                        }
                    }
                    X8.f f0 = new X8.f();  // 初始化器: Lx8/f;-><init>()V
                    f0.a = s;
                    f0.b = s1;
                    f0.c = s1;
                    f0.d = s;
                    f0.execute(null);
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicFriendListInviteUserRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                FriendAddFragment.this.showProgress(false);
                if(!FriendAddFragment.this.isFragmentValid()) {
                    LogU.w("FriendAddFragment", "requestFriendInvitationList() invalid fragment - " + this);
                    return;
                }
                String s = volleyError0.getMessage();
                if(TextUtils.isEmpty(s)) {
                    s = "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.";
                }
                ToastManager.show(s);
            }
        }).request();
    }

    private void tiaraLogAddMelonFriend() {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.y = this.getString(0x7F130FB2);  // string:tiara_profile_layer1_add_friend "친구추가"
        f0.F = this.getString(0x7F130FB1);  // string:tiara_profile_copy_melon_user "멜론회원"
        f0.a().track();
    }

    private void tiaraLogFollow(int v, String s) {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.ClickContent;
        f0.y = this.getString(0x7F130FC2);  // string:tiara_profile_layer1_recommended_friend "추천친구"
        f0.C = String.valueOf(v);
        f0.h = s;
        f0.a().track();
    }

    private void tiaraLogInviteKakaoTalkFriend() {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.y = this.getString(0x7F130FB9);  // string:tiara_profile_layer1_invite_friend "친구초대"
        f0.F = this.getString(0x7F130FB0);  // string:tiara_profile_copy_kakao_talk "카카오톡"
        f0.a().track();
    }

    private void tiaraLogInvitePhoneFriend() {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.y = this.getString(0x7F130FB9);  // string:tiara_profile_layer1_invite_friend "친구초대"
        f0.F = this.getString(0x7F130FAF);  // string:tiara_profile_copy_contact "연락처"
        f0.a().track();
    }
}

