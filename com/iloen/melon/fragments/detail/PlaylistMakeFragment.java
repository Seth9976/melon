package com.iloen.melon.fragments.detail;

import E9.w;
import F8.K;
import F8.m;
import H0.b;
import M6.B;
import M6.s;
import M6.t;
import M6.u;
import Md.f;
import Md.l;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.f0;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.activity.PlaylistSearchAndAddActivity;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.CType;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.custom.AlphaControlCheckButton;
import com.iloen.melon.custom.CheckableTextView;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.U0;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v4x.common.YNType;
import com.iloen.melon.net.v4x.request.PlaylistUploadRepntImgBaseReq.Params;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v4x.response.DjPlaylistInformRes;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistInformRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistInformRes;
import com.iloen.melon.net.v4x.response.PlaylistInformBaseRes;
import com.iloen.melon.net.v4x.response.PlaylistUpdateRepntImgBaseRes;
import com.iloen.melon.net.v5x.response.MelonDjPlaylistListSongRes;
import com.iloen.melon.net.v5x.response.MyMusicPlaylistListSongRes;
import com.iloen.melon.net.v6x.request.CleanIsBlackReq;
import com.iloen.melon.net.v6x.request.DjPlaylistInsertReq.Builder;
import com.iloen.melon.net.v6x.request.DjPlaylistInsertReq;
import com.iloen.melon.net.v6x.request.DjTagSearchAutoCompleteReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistInsertReq;
import com.iloen.melon.net.v6x.request.PlaylistInsertBaseReq.BuilderBase;
import com.iloen.melon.net.v6x.response.CleanIsBlackRes;
import com.iloen.melon.net.v6x.response.DjTagSearchAutoCompleteRes.RESPONSE.TAGLIST;
import com.iloen.melon.net.v6x.response.DjTagSearchAutoCompleteRes;
import com.iloen.melon.net.v6x.response.DjTagSearchRecommendsRes;
import com.iloen.melon.net.v6x.response.PlaylistInsertBaseRes;
import com.iloen.melon.net.v6x.response.PlaylistUpdateBaseRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.task.request.TaskGetSongInfo.ResultListener;
import com.iloen.melon.task.request.TaskGetSongInfo;
import com.iloen.melon.types.TagInfo;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.TagParser.OnParsedListener;
import com.iloen.melon.utils.TagParser.TagPos;
import com.iloen.melon.utils.TagParser;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter;
import com.iloen.melon.utils.dragdrop.MelonItemTouchHelper.ItemMoveListener;
import com.iloen.melon.utils.dragdrop.MelonItemTouchHelper;
import com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase.ScrollSpeed;
import com.iloen.melon.utils.image.ImageSelector.ImageSelectorListener;
import com.iloen.melon.utils.image.ImageSelector.Request;
import com.iloen.melon.utils.image.ImageSelector;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.playlist.DjPlaylistDetailFactory;
import com.iloen.melon.utils.playlist.PlaylistCacheCreatorBase;
import com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.MelonDetailInfoUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.net.res.common.SongInfoBase;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import k8.Y;
import kc.d3;
import kc.s2;
import v9.h;
import v9.i;
import v9.o;

public class PlaylistMakeFragment extends Hilt_PlaylistMakeFragment implements View.OnTouchListener {
    class BasicInfo {
        public boolean bOpenYn;
        public String contentText;
        public String modifyingContentText;
        public String modifyingTitleText;
        public String repntImg;
        public String songCnt;
        public String titleText;

        public BasicInfo(PlaylistInformBaseRes playlistInformBaseRes0) {
            this.bOpenYn = false;
            this.modifyingTitleText = "";
            if(playlistInformBaseRes0 == null) {
                return;
            }
            this.updateData(playlistInformBaseRes0);
        }

        private ArrayList convertParcelableTagInfo(List list0) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: list0) {
                String s = ((TagInfoBase)object0).tagName;
                String s1 = ((TagInfoBase)object0).repntTagYn;
                TagInfo tagInfo0 = new TagInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
                tagInfo0.a = s;
                tagInfo0.b = s1;
                arrayList0.add(tagInfo0);
            }
            return arrayList0;
        }

        public String getCurrentContentText() {
            return TextUtils.isEmpty(this.modifyingContentText) ? this.contentText : this.modifyingContentText;
        }

        public String getCurrentTitleText() {
            return TextUtils.isEmpty(this.modifyingTitleText) ? this.titleText : this.modifyingTitleText;
        }

        public void updateData(PlaylistInformBaseRes playlistInformBaseRes0) {
            if(playlistInformBaseRes0 instanceof MyMusicPlaylistInformRes) {
                RESPONSE myMusicPlaylistInformRes$RESPONSE0 = ((MyMusicPlaylistInformRes)playlistInformBaseRes0).response;
                if(myMusicPlaylistInformRes$RESPONSE0 != null) {
                    this.bOpenYn = ProtocolUtils.parseBoolean(myMusicPlaylistInformRes$RESPONSE0.openYN);
                    this.titleText = myMusicPlaylistInformRes$RESPONSE0.plylsttitle;
                    this.contentText = myMusicPlaylistInformRes$RESPONSE0.plylstDesc;
                    this.repntImg = myMusicPlaylistInformRes$RESPONSE0.postImg;
                    this.songCnt = myMusicPlaylistInformRes$RESPONSE0.songcnt;
                }
            }
            else if(playlistInformBaseRes0 instanceof DjPlaylistInformRes) {
                com.iloen.melon.net.v4x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE0 = ((DjPlaylistInformRes)playlistInformBaseRes0).response;
                if(djPlaylistInformRes$RESPONSE0 != null) {
                    this.bOpenYn = ProtocolUtils.parseBoolean(djPlaylistInformRes$RESPONSE0.openYN);
                    this.titleText = djPlaylistInformRes$RESPONSE0.plylstTitle;
                    this.contentText = djPlaylistInformRes$RESPONSE0.plylstDesc;
                    this.repntImg = djPlaylistInformRes$RESPONSE0.postImg;
                    this.songCnt = djPlaylistInformRes$RESPONSE0.songCnt;
                }
            }
        }
    }

    class PlaylistAdapter extends p implements DragSortHeaderFooterAdapter {
        class MenuItemViewHolder extends O0 {
            private LinearLayout autoCompleteTagListContainer;
            private CheckableTextView btnSelectAll;
            private LinearLayout latelyTagListContainer;
            private LinearLayout layoutAddSong;
            private View layoutLatelyTag;
            private View layoutRecmTag;
            private View layoutSelectAll;
            private View layoutTag;
            private AlphaControlCheckButton mAccbOpenYN;
            private LinearLayout mLayoutOpenSetting;
            private LinearLayout recmTagListContainer;
            private TextView tvContentTextCount;
            private TextView tvSongCnt;
            private TextView tvTitleTextCount;
            private View underlineIntroduce;
            private View underlineTitle;

            public MenuItemViewHolder(View view0) {
                super(view0);
                this.mLayoutOpenSetting = (LinearLayout)view0.findViewById(0x7F0A06E6);  // id:layoutOpenSetting
                this.layoutTag = view0.findViewById(0x7F0A0748);  // id:layout_tag
                this.layoutLatelyTag = view0.findViewById(0x7F0A0720);  // id:layout_lately_tag
                this.latelyTagListContainer = (LinearLayout)view0.findViewById(0x7F0A06D5);  // id:lately_tag_list_container
                this.layoutRecmTag = view0.findViewById(0x7F0A073A);  // id:layout_recm_tag
                this.recmTagListContainer = (LinearLayout)view0.findViewById(0x7F0A09C3);  // id:recm_tag_list_container
                this.autoCompleteTagListContainer = (LinearLayout)view0.findViewById(0x7F0A00D7);  // id:auto_complete_tag_list_container
                MelonEditText melonEditText0 = (MelonEditText)view0.findViewById(0x7F0A0453);  // id:et_input_title
                PlaylistMakeFragment.this.etInputTitle = melonEditText0;
                this.underlineTitle = view0.findViewById(0x7F0A0D6E);  // id:underline_title
                MelonEditText melonEditText1 = (MelonEditText)view0.findViewById(0x7F0A0452);  // id:et_input_introduce
                PlaylistMakeFragment.this.etInputIntroduce = melonEditText1;
                this.underlineIntroduce = view0.findViewById(0x7F0A0D6C);  // id:underline_introduce
                this.tvTitleTextCount = (TextView)view0.findViewById(0x7F0A0D40);  // id:tv_title_text_count
                this.tvContentTextCount = (TextView)view0.findViewById(0x7F0A0C4D);  // id:tv_content_text_count
                String s = "0/" + PlaylistMakeFragment.this.getContentTextCountLimit();
                this.tvContentTextCount.setText(s);
                this.tvContentTextCount.setContentDescription(String.format(PlaylistMakeFragment.this.getString(0x7F130BEB), s));  // string:talkback_playlist_make_edittext_limit "입력글자수 제한, %1$s"
                this.tvSongCnt = (TextView)view0.findViewById(0x7F0A0D16);  // id:tv_song_cnt
                PlaylistMakeFragment.this.etInputIntroduce.setHint(("M20001".equals(PlaylistMakeFragment.this.mPlylstType) ? 0x7F13082E : 0x7F130350));  // string:playlist_input_intro "소개글을 입력해주세요."
                LinearLayout linearLayout0 = (LinearLayout)view0.findViewById(0x7F0A06D7);  // id:layoutAddSong
                this.layoutAddSong = linearLayout0;
                ViewUtils.setContentDescriptionWithButtonClassName(linearLayout0, PlaylistMakeFragment.this.getString(0x7F13081E));  // string:playlist_adding_songs "곡 추가"
                ViewUtils.setOnClickListener(this.layoutAddSong, new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(!PlaylistMakeFragment.this.isProgressShowing() && PlaylistMakeFragment.this.isSongInitCompleted) {
                            int v = PlaylistAdapter.this.getCount();
                            StringBuilder stringBuilder0 = new StringBuilder();
                            for(int v1 = 0; v1 < v; ++v1) {
                                SongInfoBase songInfoBase0 = (SongInfoBase)PlaylistAdapter.this.getItem(v1);
                                if(stringBuilder0.length() > 0) {
                                    stringBuilder0.append(",");
                                }
                                stringBuilder0.append(songInfoBase0.songId);
                            }
                            Intent intent0 = new Intent(PlaylistMakeFragment.this.getActivity(), PlaylistSearchAndAddActivity.class);
                            intent0.putExtra("argOriginalSongIds", stringBuilder0.toString());
                            PlaylistMakeFragment.this.activityResult.b(intent0);
                        }
                    }
                });
                this.layoutSelectAll = view0.findViewById(0x7F0A0741);  // id:layout_select_all
                CheckableTextView checkableTextView0 = (CheckableTextView)view0.findViewById(0x7F0A01A9);  // id:btn_select_all
                this.btnSelectAll = checkableTextView0;
                ViewUtils.setContentDescriptionWithButtonClassName(checkableTextView0, checkableTextView0.getText());
                ViewUtils.setOnClickListener(this.btnSelectAll, new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        PlaylistMakeFragment.this.toggleSelectAll();
                        CharSequence charSequence0 = MenuItemViewHolder.b(MenuItemViewHolder.this).getText();
                        ViewUtils.setContentDescriptionWithButtonClassName(MenuItemViewHolder.b(MenuItemViewHolder.this), charSequence0);
                        if(!PlaylistMakeFragment.this.mMarkedAll) {
                            MenuItemViewHolder.b(MenuItemViewHolder.this).sendAccessibilityEvent(8);
                        }
                    }
                });
                AlphaControlCheckButton alphaControlCheckButton0 = (AlphaControlCheckButton)view0.findViewById(0x7F0A002B);  // id:accbOpenYN
                this.mAccbOpenYN = alphaControlCheckButton0;
                alphaControlCheckButton0.setChecked(false);
                this.mAccbOpenYN.setContentDescription(PlaylistMakeFragment.this.getString(0x7F130344) + "," + PlaylistMakeFragment.this.getString(0x7F130BA9) + "," + PlaylistMakeFragment.this.getString(0x7F130AF5));  // string:dj_playlist_tag_public_setting "공개 설정"
                ViewUtils.setOnClickListener(this.mAccbOpenYN, new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        PlaylistMakeFragment.Z0(PlaylistMakeFragment.this);
                        boolean z = MenuItemViewHolder.h(MenuItemViewHolder.this).i;
                        MenuItemViewHolder.h(MenuItemViewHolder.this).setChecked(!z);
                        PlaylistMakeFragment.this.mBasicInfo.bOpenYn = !z;
                        MenuItemViewHolder.h(MenuItemViewHolder.this).setContentDescription(PlaylistMakeFragment.this.getString(0x7F130344) + "," + PlaylistMakeFragment.this.getString((z ? 0x7F130BA9 : 0x7F130BAD)) + "," + PlaylistMakeFragment.this.getString(0x7F130AF5));  // string:dj_playlist_tag_public_setting "공개 설정"
                        MenuItemViewHolder.h(MenuItemViewHolder.this).sendAccessibilityEvent(8);
                    }
                });
                MelonLimits.TextLimit melonLimits$TextLimit0 = w.I(40);
                PlaylistMakeFragment.this.etInputTitle.setTextLimit(melonLimits$TextLimit0);
                com.iloen.melon.fragments.detail.PlaylistMakeFragment.PlaylistAdapter.MenuItemViewHolder.4 playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder$40 = new TextWatcher() {
                    @Override  // android.text.TextWatcher
                    public void afterTextChanged(Editable editable0) {
                        if(TextUtils.isEmpty(PlaylistMakeFragment.this.mPlylstSeq)) {
                            PlaylistMakeFragment.Z0(PlaylistMakeFragment.this);
                        }
                        else if(TextUtils.isEmpty(PlaylistMakeFragment.this.mBasicInfo.titleText) && PlaylistMakeFragment.this.mBasicInfo.modifyingTitleText.hashCode() != editable0.toString().hashCode()) {
                            PlaylistMakeFragment.Z0(PlaylistMakeFragment.this);
                        }
                        PlaylistMakeFragment.this.mBasicInfo.titleText = "";
                        PlaylistMakeFragment.this.mBasicInfo.modifyingTitleText = editable0.toString();
                        String s = PlaylistMakeFragment.this.mBasicInfo.modifyingTitleText.length() + "/40";
                        MenuItemViewHolder.m(MenuItemViewHolder.this).setText(s);
                        String s1 = PlaylistMakeFragment.this.getString(0x7F130BEB);  // string:talkback_playlist_make_edittext_limit "입력글자수 제한, %1$s"
                        MenuItemViewHolder.m(MenuItemViewHolder.this).setContentDescription(String.format(s1, s));
                    }

                    @Override  // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                    }

                    @Override  // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                    }
                };
                PlaylistMakeFragment.this.etInputTitle.setTextWatcher(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder$40);
                com.iloen.melon.fragments.detail.PlaylistMakeFragment.PlaylistAdapter.MenuItemViewHolder.5 playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder$50 = new View.OnFocusChangeListener() {
                    @Override  // android.view.View$OnFocusChangeListener
                    public void onFocusChange(View view0, boolean z) {
                        MenuItemViewHolder.m(MenuItemViewHolder.this).setVisibility((z ? 0 : 4));
                        int v = ColorUtils.getColor(PlaylistAdapter.this.getContext(), (z ? 0x7F06016D : 0x7F060152));  // color:gray900s
                        MenuItemViewHolder.o(MenuItemViewHolder.this).setBackgroundColor(v);
                    }
                };
                PlaylistMakeFragment.this.etInputTitle.setOnFocusChangeListener(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder$50);
                this.tvTitleTextCount.setVisibility(4);
                MelonLimits.TextLimit melonLimits$TextLimit1 = w.I(PlaylistMakeFragment.this.getContentTextCountLimit());
                PlaylistMakeFragment.this.etInputIntroduce.setTextLimit(melonLimits$TextLimit1);
                PlaylistMakeFragment.this.etInputIntroduce.setImeOptions(6);
                com.iloen.melon.fragments.detail.PlaylistMakeFragment.PlaylistAdapter.MenuItemViewHolder.6 playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder$60 = new TextWatcher() {
                    @Override  // android.text.TextWatcher
                    public void afterTextChanged(Editable editable0) {
                        if(TextUtils.isEmpty(PlaylistMakeFragment.this.mPlylstSeq)) {
                            PlaylistMakeFragment.Z0(PlaylistMakeFragment.this);
                        }
                        else if(TextUtils.isEmpty(PlaylistMakeFragment.this.mBasicInfo.contentText) && PlaylistMakeFragment.this.mBasicInfo.modifyingContentText.hashCode() != editable0.toString().hashCode()) {
                            PlaylistMakeFragment.Z0(PlaylistMakeFragment.this);
                        }
                        PlaylistMakeFragment.this.mBasicInfo.contentText = "";
                        PlaylistMakeFragment.this.mBasicInfo.modifyingContentText = editable0.toString();
                        String s = PlaylistMakeFragment.this.mBasicInfo.modifyingContentText.length() + "/" + PlaylistMakeFragment.this.getContentTextCountLimit();
                        MenuItemViewHolder.k(MenuItemViewHolder.this).setText(s);
                        String s1 = PlaylistMakeFragment.this.getString(0x7F130BEB);  // string:talkback_playlist_make_edittext_limit "입력글자수 제한, %1$s"
                        MenuItemViewHolder.k(MenuItemViewHolder.this).setContentDescription(String.format(s1, s));
                        if(!"M20001".equals(PlaylistMakeFragment.this.mPlylstType)) {
                            int v = PlaylistMakeFragment.this.etInputIntroduce.getSelectionEnd();
                            if(v >= 0) {
                                String s2 = v - 1 < 0 ? " " : editable0.subSequence(v - 1, v).toString();
                                Z.w("afterTextChanged() >> token: ", s2, "PlaylistMakeFragment");
                                Message message0 = PlaylistMakeFragment.this.mTagHandler.obtainMessage(5000, v - 1, v, s2);
                                PlaylistMakeFragment.this.mTagHandler.sendMessageDelayed(message0, 100L);
                            }
                        }
                    }

                    @Override  // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                    }

                    @Override  // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                    }
                };
                PlaylistMakeFragment.this.etInputIntroduce.setTextWatcher(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder$60);
                com.iloen.melon.fragments.detail.PlaylistMakeFragment.PlaylistAdapter.MenuItemViewHolder.7 playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder$70 = new View.OnFocusChangeListener() {
                    @Override  // android.view.View$OnFocusChangeListener
                    public void onFocusChange(View view0, boolean z) {
                        MenuItemViewHolder.k(MenuItemViewHolder.this).setVisibility((z ? 0 : 4));
                        int v = ColorUtils.getColor(PlaylistAdapter.this.getContext(), (z ? 0x7F06016D : 0x7F060152));  // color:gray900s
                        MenuItemViewHolder.n(MenuItemViewHolder.this).setBackgroundColor(v);
                    }
                };
                PlaylistMakeFragment.this.etInputIntroduce.setOnFocusChangeListener(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder$70);
                this.tvContentTextCount.setVisibility(4);
            }

            public static LinearLayout a(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.autoCompleteTagListContainer;
            }

            public static CheckableTextView b(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.btnSelectAll;
            }

            public static LinearLayout c(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.latelyTagListContainer;
            }

            public static View d(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.layoutLatelyTag;
            }

            public static View e(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.layoutRecmTag;
            }

            public static View f(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.layoutSelectAll;
            }

            public static View g(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.layoutTag;
            }

            public static AlphaControlCheckButton h(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.mAccbOpenYN;
            }

            public static LinearLayout i(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.mLayoutOpenSetting;
            }

            public static LinearLayout j(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.recmTagListContainer;
            }

            public static TextView k(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.tvContentTextCount;
            }

            public static TextView l(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.tvSongCnt;
            }

            public static TextView m(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.tvTitleTextCount;
            }

            public static View n(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.underlineIntroduce;
            }

            public static View o(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0) {
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0.underlineTitle;
            }
        }

        public static final int VIEW_TYPE_MENU = 0;
        public static final int VIEW_TYPE_SONG = 1;
        private MenuItemViewHolder menuItemHolder;

        public PlaylistAdapter(Context context0, List list0) {
            super(context0, list0);
        }

        private void bindTagClickListener(View view0) {
            ViewUtils.setOnClickListener(view0, new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    String s = (String)view0.getTag();
                    if(s == null) {
                        return;
                    }
                    PlaylistMakeFragment.this.isShowAutoCompleteTag = false;
                    PlaylistMakeFragment.this.replaceTagToCurrentTag(s.replace("#", ""));
                    PlaylistMakeFragment.this.getAdapter().notifyItemChanged(1, 1);
                    PlaylistMakeFragment.this.etInputIntroduce.requestFocus();
                }
            });
        }

        public void dragNDrop(int v, int v1) {
            int v2 = v1 - 1;
            if(v2 < 0) {
                return;
            }
            int v3 = this.getCount();
            if(v2 >= v3) {
                v2 = v3 - 1;
            }
            SongInfoBase songInfoBase0 = (SongInfoBase)this.getItem(v - 1);
            try {
                this.remove(v - 1);
                this.add(v2, songInfoBase0);
                this.notifyDataSetChanged();
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                LogU.e("PlaylistMakeFragment", "dragNDrop() >> Index Err: " + indexOutOfBoundsException0.toString());
            }
            catch(Exception exception0) {
                b.v(exception0, new StringBuilder("dragNDrop() >> Unknown Err: "), "PlaylistMakeFragment");
            }
            PlaylistMakeFragment.Z0(PlaylistMakeFragment.this);
            PlaylistMakeFragment.this.setSelectAllWithToolbar(false);
        }

        @Override  // com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter
        public View getDragSortFooterView() {
            return null;
        }

        @Override  // com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter
        public int getDragSortFooterViewPosition() {
            return this.getItemCount() - 1;
        }

        @Override  // com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter
        public View getDragSortHeaderView() {
            return null;
        }

        @Override  // com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter
        public int getDragSortHeaderViewPosition() {
            return 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) {
            boolean z1;
            String s1;
            ArrayList arrayList0;
            boolean z = false;
            if(httpResponse0 instanceof MyMusicPlaylistListSongRes) {
                com.iloen.melon.net.v5x.response.MyMusicPlaylistListSongRes.RESPONSE myMusicPlaylistListSongRes$RESPONSE0 = ((MyMusicPlaylistListSongRes)httpResponse0).response;
                if(myMusicPlaylistListSongRes$RESPONSE0 != null) {
                    arrayList0 = myMusicPlaylistListSongRes$RESPONSE0.songList;
                    s1 = "";
                    z1 = ((MyMusicPlaylistListSongRes)httpResponse0).hasMore();
                    goto label_18;
                }
            }
            else if(httpResponse0 instanceof MelonDjPlaylistListSongRes) {
                com.iloen.melon.net.v5x.response.MelonDjPlaylistListSongRes.RESPONSE melonDjPlaylistListSongRes$RESPONSE0 = ((MelonDjPlaylistListSongRes)httpResponse0).response;
                if(melonDjPlaylistListSongRes$RESPONSE0 != null) {
                    arrayList0 = melonDjPlaylistListSongRes$RESPONSE0.songList;
                    s1 = "";
                    z1 = ((MelonDjPlaylistListSongRes)httpResponse0).hasMore();
                    goto label_18;
                }
            }
            else {
                arrayList0 = null;
                s1 = null;
                z1 = false;
            label_18:
                if(arrayList0 != null && !arrayList0.isEmpty() && !TextUtils.isEmpty(s1)) {
                    this.setMenuId(s1);
                    PlaylistMakeFragment playlistMakeFragment0 = PlaylistMakeFragment.this;
                    if(i0 == i.b) {
                        z = true;
                    }
                    playlistMakeFragment0.setDataList(arrayList0, z, z1);
                    return true;
                }
            }
            return false;
        }

        @Override  // com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter
        public boolean hasDragSortFooterView() {
            return true;
        }

        @Override  // com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter
        public boolean hasDragSortHeaderView() {
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.q
        public boolean ignoreCanService() {
            return true;
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onBindViewHolder(O0 o00, int v, List list0) {
            boolean z = false;
            if(list0.isEmpty()) {
                super.onBindViewHolder(o00, v, list0);
                return;
            }
            boolean z1 = PlaylistMakeFragment.this.isShowRecmTag && PlaylistMakeFragment.this.mRecommendTagArray != null && PlaylistMakeFragment.this.mRecommendTagArray.size() > 0 && "M20002".equals(PlaylistMakeFragment.this.mPlylstType);
            if(z1 && MenuItemViewHolder.j(((MenuItemViewHolder)o00)).getChildCount() < 1) {
                for(Object object0: PlaylistMakeFragment.this.mRecommendTagArray) {
                    View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04E7, null, false);  // layout:melondj_auto_complete_tag_list_item
                    ((TextView)view0.findViewById(0x7F0A0B29)).setText(((String)object0));  // id:tag_name
                    view0.setTag(((String)object0));
                    this.bindTagClickListener(view0);
                    MenuItemViewHolder.j(((MenuItemViewHolder)o00)).addView(view0);
                }
            }
            ViewUtils.showWhen(MenuItemViewHolder.e(((MenuItemViewHolder)o00)), z1);
            if(PlaylistMakeFragment.this.isShowLatelyTag && MenuItemViewHolder.c(((MenuItemViewHolder)o00)).getChildCount() < 1) {
                Iterator iterator1 = PlaylistMakeFragment.this.mLatelyTagHashMap.keySet().iterator();
                String s = PlaylistMakeFragment.this.getString(0x7F130BED);  // string:talkback_playlist_make_recent_tag_delete "최근 태그 삭제"
                while(iterator1.hasNext()) {
                    Object object1 = iterator1.next();
                    View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04E7, null, false);  // layout:melondj_auto_complete_tag_list_item
                    ((TextView)view1.findViewById(0x7F0A0B29)).setText(((String)object1));  // id:tag_name
                    view1.setTag(((String)object1));
                    this.bindTagClickListener(view1);
                    View view2 = view1.findViewById(0x7F0A060D);  // id:iv_btn_delete
                    ViewUtils.showWhen(view2, true);
                    ViewUtils.setContentDescriptionWithButtonClassName(view2, s, ((String)object1));
                    ViewUtils.setOnClickListener(view2, new View.OnClickListener() {
                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            String s = PlaylistMakeFragment.this.getString(0x7F130BEE);  // string:talkback_playlist_make_recent_tag_removed "%1$s 태그 삭제됨"
                            view2.setContentDescription(String.format(s, ((String)object1)));
                            view2.sendAccessibilityEvent(0x8000);
                            MelonDetailInfoUtils.removeDjPlaylistLatelyTag(((String)object1));
                            PlaylistMakeFragment.this.mLatelyTagHashMap.remove(((String)object1));
                            MenuItemViewHolder.c(((MenuItemViewHolder)o00)).removeView(view1);
                            if(PlaylistMakeFragment.this.mLatelyTagHashMap.size() < 1) {
                                ViewUtils.hideWhen(MenuItemViewHolder.d(((MenuItemViewHolder)o00)), true);
                                PlaylistMakeFragment.this.isShowLatelyTag = false;
                                PlaylistMakeFragment.this.isShowRecmTag = true;
                                PlaylistMakeFragment.this.getAdapter().notifyItemChanged(1, 0);
                            }
                        }
                    });
                    MenuItemViewHolder.c(((MenuItemViewHolder)o00)).addView(view1);
                }
            }
            ViewUtils.showWhen(MenuItemViewHolder.d(((MenuItemViewHolder)o00)), PlaylistMakeFragment.this.isShowLatelyTag);
            if(PlaylistMakeFragment.this.isShowAutoCompleteTag) {
                if(MenuItemViewHolder.a(((MenuItemViewHolder)o00)).getChildCount() > 0) {
                    MenuItemViewHolder.a(((MenuItemViewHolder)o00)).removeAllViews();
                }
                for(int v1 = 0; v1 < PlaylistMakeFragment.this.autoCompleteTagList.size(); ++v1) {
                    TagInfoBase tagInfoBase0 = (TagInfoBase)PlaylistMakeFragment.this.autoCompleteTagList.get(v1);
                    String s1 = "#" + tagInfoBase0.tagName;
                    SpannableString spannableString0 = new SpannableString(s1);
                    int v2 = s1.indexOf(PlaylistMakeFragment.this.autoCompeteTagName);
                    if(v2 > 0) {
                        int v3 = PlaylistMakeFragment.this.autoCompeteTagName.length() + v2;
                        LogU.d("PlaylistMakeFragment", "TagListAdapter >> onBindViewHolder() >> [Spann Pos] begin: " + v2 + ", end: " + v3);
                        spannableString0.setSpan(new ForegroundColorSpan(ColorUtils.getColor(this.getContext(), 0x7F06017C)), 0, v3, 33);  // color:green500s_support_high_contrast
                    }
                    View view3 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04E7, null, false);  // layout:melondj_auto_complete_tag_list_item
                    view3.setTag(s1);
                    ((TextView)view3.findViewById(0x7F0A0B29)).setText(spannableString0);  // id:tag_name
                    TextView textView0 = (TextView)view3.findViewById(0x7F0A0934);  // id:playlist_count
                    textView0.setText(StringUtils.getCountString(((TAGLIST)tagInfoBase0).plylstcnt, -1));
                    ViewUtils.showWhen(textView0, true);
                    ViewUtils.setContentDescriptionWithButtonClassName(view3, String.format(PlaylistMakeFragment.this.getString(0x7F130BEF), s1, textView0.getText()));  // string:talkback_playlist_make_recommend_tag_item "%1$s, %2$s번 태그됨"
                    this.bindTagClickListener(view3);
                    MenuItemViewHolder.a(((MenuItemViewHolder)o00)).addView(view3);
                }
            }
            ViewUtils.showWhen(MenuItemViewHolder.a(((MenuItemViewHolder)o00)), PlaylistMakeFragment.this.isShowAutoCompleteTag);
            if(PlaylistMakeFragment.this.isShowRecmTag || PlaylistMakeFragment.this.isShowLatelyTag || PlaylistMakeFragment.this.isShowAutoCompleteTag) {
                z = true;
            }
            this.speackSuggestTagAccessibility(((MenuItemViewHolder)o00), z);
            ViewUtils.showWhen(MenuItemViewHolder.g(((MenuItemViewHolder)o00)), z);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            boolean z = true;
            switch(o00.getItemViewType()) {
                case 0: {
                    MenuItemViewHolder.l(((MenuItemViewHolder)o00)).setText(PlaylistMakeFragment.this.getString(0x7F130655, new Object[]{PlaylistMakeFragment.this.mBasicInfo.songCnt}));  // string:melondj_playlist_song_count "%s곡"
                    ViewUtils.showWhen(MenuItemViewHolder.l(((MenuItemViewHolder)o00)), StringUtils.getNumberFromString(PlaylistMakeFragment.this.mBasicInfo.songCnt) > 0);
                    int v2 = ((PlaylistAdapter)PlaylistMakeFragment.this.getAdapter()).getCount();
                    View view0 = MenuItemViewHolder.f(((MenuItemViewHolder)o00));
                    if(v2 <= 0) {
                        z = false;
                    }
                    ViewUtils.showWhen(view0, z);
                    if(PlaylistMakeFragment.this.mBasicInfo != null) {
                        MenuItemViewHolder.h(((MenuItemViewHolder)o00)).setChecked(PlaylistMakeFragment.this.mBasicInfo.bOpenYn);
                        MenuItemViewHolder.h(((MenuItemViewHolder)o00)).setContentDescription(PlaylistMakeFragment.this.getString(0x7F130344) + "," + PlaylistMakeFragment.this.getString((PlaylistMakeFragment.this.mBasicInfo.bOpenYn ? 0x7F130BAD : 0x7F130BA9)) + "," + PlaylistMakeFragment.this.getString(0x7F130AF5));  // string:dj_playlist_tag_public_setting "공개 설정"
                        MenuItemViewHolder.i(((MenuItemViewHolder)o00)).setVisibility(0);
                        ViewUtils.showWhen(MenuItemViewHolder.i(((MenuItemViewHolder)o00)), "M20001".equals(PlaylistMakeFragment.this.mPlylstType));
                        String s = PlaylistMakeFragment.this.mBasicInfo.getCurrentTitleText();
                        if(!TextUtils.isEmpty(s)) {
                            PlaylistMakeFragment.this.etInputTitle.setText(s);
                        }
                        String s1 = PlaylistMakeFragment.this.mBasicInfo.getCurrentContentText();
                        if(!TextUtils.isEmpty(s1)) {
                            PlaylistMakeFragment.this.etInputIntroduce.setText(s1);
                            String s2 = PlaylistMakeFragment.this.etInputIntroduce.getText().toString();
                            PlaylistMakeFragment.this.mTagParser.parse(s2);
                            Editable editable0 = PlaylistMakeFragment.this.etInputIntroduce.getText();
                            PlaylistMakeFragment.this.mTagParser.syncWithSpannable(editable0);
                            return;
                        }
                    }
                    break;
                }
                case 1: {
                    SongInfoBase songInfoBase0 = (SongInfoBase)this.getItem(v1);
                    if(songInfoBase0 != null) {
                        ViewUtils.setOnClickListener(((SongHolder)o00).rootView, new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                PlaylistMakeFragment.this.onItemClick(view0, v);
                            }
                        });
                        if(this.isMarked(v1)) {
                            ((SongHolder)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                        }
                        else {
                            ((SongHolder)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                        }
                        Glide.with(this.getContext()).load(songInfoBase0.albumImg).into(((SongHolder)o00).thumbnailIv);
                        ((SongHolder)o00).titleTv.setText(songInfoBase0.songName);
                        ((SongHolder)o00).artistTv.setText(ProtocolUtils.getArtistNames(songInfoBase0.artistList));
                        ViewUtils.hideWhen(((SongHolder)o00).btnPlay, true);
                        ViewUtils.hideWhen(((SongHolder)o00).btnInfo, true);
                        ViewUtils.showWhen(((SongHolder)o00).list19Iv, songInfoBase0.isAdult);
                        ViewUtils.showWhen(((SongHolder)o00).listFreeIv, songInfoBase0.isFree);
                        ViewUtils.showWhen(((SongHolder)o00).moveIv, true);
                        ViewUtils.setEnable(((SongHolder)o00).wrapperLayout, songInfoBase0.canService);
                        return;
                    }
                    break;
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            if(v == 0) {
                MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0 = new MenuItemViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D059B, viewGroup0, false));  // layout:playlist_detail_make_menu
                this.menuItemHolder = playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0;
                return playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0;
            }
            return new SongHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D04AE, viewGroup0, false));  // layout:listitem_song_new
        }

        private void speackSuggestTagAccessibility(MenuItemViewHolder playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0, boolean z) {
            int v = MenuItemViewHolder.g(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0).getTag() == null ? 0 : ((int)(((Integer)MenuItemViewHolder.g(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0).getTag())));
            int v1 = PlaylistMakeFragment.this.isShowRecmTag ? MenuItemViewHolder.j(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0).getChildCount() : 0;
            if(PlaylistMakeFragment.this.isShowLatelyTag) {
                v1 += MenuItemViewHolder.c(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0).getChildCount();
            }
            if(PlaylistMakeFragment.this.isShowAutoCompleteTag) {
                v1 += MenuItemViewHolder.a(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0).getChildCount();
            }
            MenuItemViewHolder.g(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0).setTag(v1);
            if(MenuItemViewHolder.g(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0).getVisibility() != 0 && z || MenuItemViewHolder.g(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0).getVisibility() == 0 && v != v1) {
                MenuItemViewHolder.g(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0).setContentDescription(String.format(PlaylistMakeFragment.this.getString(0x7F130BF0), v1));  // string:talkback_playlist_make_suggest_tag_list "%1$d개의 태그 검색결과 제안"
                PlaylistMakeFragment.this.suggestTagAccessibilityHandler.removeMessages(0);
                PlaylistMakeFragment.this.suggestTagAccessibilityHandler.removeMessages(1);
                Message message0 = PlaylistMakeFragment.this.suggestTagAccessibilityHandler.obtainMessage(0, MenuItemViewHolder.g(playlistMakeFragment$PlaylistAdapter$MenuItemViewHolder0));
                PlaylistMakeFragment.this.suggestTagAccessibilityHandler.sendMessageDelayed(message0, 500L);
            }
        }

        public void updateSelectAllButton(boolean z) {
            if(this.menuItemHolder != null && MenuItemViewHolder.b(this.menuItemHolder) != null) {
                MenuItemViewHolder.b(this.menuItemHolder).setChecked(z);
                MenuItemViewHolder.b(this.menuItemHolder).setText((z ? 0x7F1310D9 : 0x7F130914));  // string:unselect_selection "선택해제"
            }
        }
    }

    class SuggestTagAccessibilityHandler extends U0 {
        public SuggestTagAccessibilityHandler(PlaylistMakeFragment playlistMakeFragment1) {
            super(playlistMakeFragment1);
        }

        public void handleMessage(PlaylistMakeFragment playlistMakeFragment0, Message message0) {
            switch(message0.what) {
                case 0: {
                    View view0 = (View)message0.obj;
                    view0.sendAccessibilityEvent(4);
                    this.sendMessageDelayed(PlaylistMakeFragment.this.suggestTagAccessibilityHandler.obtainMessage(1, view0), 100L);
                    return;
                }
                case 1: {
                    ((View)message0.obj).setContentDescription("");
                }
            }
        }

        @Override  // com.iloen.melon.custom.U0
        public void handleMessage(Object object0, Message message0) {
            this.handleMessage(((PlaylistMakeFragment)object0), message0);
        }
    }

    class TagHandler extends U0 {
        public TagHandler(PlaylistMakeFragment playlistMakeFragment1) {
            super(playlistMakeFragment1);
        }

        public void handleMessage(PlaylistMakeFragment playlistMakeFragment0, Message message0) {
            if(message0.what == 5000) {
                if(PlaylistMakeFragment.this.mTagHandler.hasMessages(5000)) {
                    PlaylistMakeFragment.this.mTagHandler.removeMessages(5000);
                    Message message1 = PlaylistMakeFragment.this.mTagHandler.obtainMessage(message0.what, message0.arg1, message0.arg2, message0.obj);
                    PlaylistMakeFragment.this.mTagHandler.sendMessageDelayed(message1, 100L);
                    return;
                }
                String s = PlaylistMakeFragment.this.etInputIntroduce.getText().toString();
                PlaylistMakeFragment.this.mTagParser.parse(s);
                Editable editable0 = PlaylistMakeFragment.this.etInputIntroduce.getText();
                PlaylistMakeFragment.this.mTagParser.syncWithSpannable(editable0);
                String s1 = (String)message0.obj;
                if("#".equals(s1)) {
                    int v = PlaylistMakeFragment.this.etInputIntroduce.getSelectionEnd();
                    if(PlaylistMakeFragment.this.mTagParser.getTagInnerPos(v) != null) {
                        if(PlaylistMakeFragment.this.mLatelyTagHashMap == null || PlaylistMakeFragment.this.mLatelyTagHashMap.size() <= 0) {
                            PlaylistMakeFragment.this.isShowRecmTag = true;
                        }
                        else {
                            PlaylistMakeFragment.this.isShowLatelyTag = true;
                        }
                        PlaylistMakeFragment.this.isShowAutoCompleteTag = false;
                        PlaylistMakeFragment.this.getAdapter().notifyItemChanged(1, 0);
                    }
                }
                else {
                    if(" ".equals(s1) || "\n".equals(s1)) {
                        goto label_29;
                    }
                    TagPos tagParser$TagPos0 = PlaylistMakeFragment.this.mTagParser.getTagInnerPos(message0.arg1);
                    if(tagParser$TagPos0 != null) {
                        PlaylistMakeFragment.this.isShowLatelyTag = false;
                        PlaylistMakeFragment.this.isShowRecmTag = false;
                        PlaylistMakeFragment.this.autoCompeteTagName = tagParser$TagPos0.tagName.replace("#", "");
                        PlaylistMakeFragment.this.showAutoCompleteTagList(PlaylistMakeFragment.this.autoCompeteTagName);
                        return;
                    label_29:
                        PlaylistMakeFragment.this.isShowLatelyTag = false;
                        PlaylistMakeFragment.this.isShowRecmTag = false;
                        PlaylistMakeFragment.this.isShowAutoCompleteTag = false;
                        PlaylistMakeFragment.this.getAdapter().notifyItemChanged(1, 1);
                    }
                }
            }
        }

        @Override  // com.iloen.melon.custom.U0
        public void handleMessage(Object object0, Message message0) {
            this.handleMessage(((PlaylistMakeFragment)object0), message0);
        }
    }

    public static final String ARG_GROUP_ID = "argGroupId";
    public static final String ARG_IGNORE_TEMP_PLAYLIST = "argIgnoreTempPlaylist";
    public static final String ARG_PLAYLIST_INTRODUCE = "argPlaylistIntroduce";
    public static final String ARG_PLAYLIST_TITLE = "argPlaylistTitle";
    public static final String ARG_PLAYLIST_TYPE = "argPlaylistType";
    public static final String ARG_PVLOGDUMMYACTION = "argPvLogDummyAction";
    public static final String ARG_REPNT_COVER_THUMBNAIL = "argRepntCoverThumbnail";
    public static final String ARG_SONG_LIST = "argSongList";
    public static final String ARG_TITLE = "argTitle";
    private static final int DELAY_TIME_MSG_TAG_CHECK = 100;
    private static final int DJ_PLAYLIST_CONTENT_TEXT_COUNT_LIMIT = 1000;
    private static final int MSG_SUGGEST_TAG_ACCESSIBILITY_CLEAR = 1;
    private static final int MSG_SUGGEST_TAG_ACCESSIBILITY_START = 0;
    private static final int MSG_TAG_CHECK = 5000;
    private static final int PAYLOAD_FROM_TAG_HIDE = 1;
    private static final int PAYLOAD_FROM_TAG_SHOW = 0;
    private static final int PLAYLIST_CONTENT_TEXT_COUNT_LIMIT = 0xA0;
    private static final int SONG_REQUEST_MAX_SIZE = 1000;
    public static final String TAG = "PlaylistMakeFragment";
    private static final String TAG_COVER = "tag_cover";
    private static final int TITLE_TEXT_COUNT_LIMIT = 40;
    private static final int VIEW_INDEX_MENU_ITEM = 1;
    private e.b activityResult;
    private String autoCompeteTagName;
    private ArrayList autoCompleteTagList;
    private MelonEditText etInputIntroduce;
    private MelonEditText etInputTitle;
    private View headerView;
    private boolean ignoreTempPlaylist;
    private boolean isModified;
    private boolean isShowAutoCompleteTag;
    private boolean isShowLatelyTag;
    private boolean isShowRecmTag;
    private boolean isSongInitCompleted;
    private BasicInfo mBasicInfo;
    private ImageSelector mImageSelector;
    private ImageSelectorListener mImageSelectorListener;
    private ImageView mIvCamera;
    private ImageView mIvCoverImage;
    private LinkedHashMap mLatelyTagHashMap;
    private PlaylistCacheCreatorBase mPlaylistCacheCreator;
    private PlaylistDetailFactoryBase mPlaylistFactory;
    private String mPlylstSeq;
    private String mPlylstType;
    private String mPvLogDummyAction;
    private ArrayList mRecommendTagArray;
    private ArrayList mSongArray;
    private TagHandler mTagHandler;
    private TagParser mTagParser;
    private String mTitle;
    private TitleBar mTitleBar;
    private MelonItemTouchHelper melonItemTouchHelper;
    private String ocrGroupId;
    @Inject
    s2 playlistManager;
    private String repntCoverThumbnail;
    private SuggestTagAccessibilityHandler suggestTagAccessibilityHandler;

    public PlaylistMakeFragment() {
        this.isShowRecmTag = false;
        this.isShowLatelyTag = false;
        this.isShowAutoCompleteTag = false;
        this.ignoreTempPlaylist = false;
        this.mPvLogDummyAction = "";
        this.isSongInitCompleted = false;
        this.isModified = false;
        this.activityResult = this.registerForActivityResult(new f0(2), new e(this, 6));
        this.mTagHandler = new TagHandler(this, this);
        this.suggestTagAccessibilityHandler = new SuggestTagAccessibilityHandler(this, this);
        this.mImageSelectorListener = new ImageSelectorListener() {
            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onFinishBackgroundLoading() {
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onImageSelectorCanceled(ImageSelector imageSelector0, Request imageSelector$Request0) {
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onImageSelectorComplete(ImageSelector imageSelector0, Request imageSelector$Request0, Uri uri0) {
                if(Uri.EMPTY.equals(uri0)) {
                    return;
                }
                File file0 = new File(uri0.getPath());
                if(!file0.exists()) {
                    LogU.e("PlaylistMakeFragment", "setUserCoverImage file doesn\'t exist : " + file0);
                    return;
                }
                PlaylistMakeFragment.this.showProgress(true);
                Context context0 = PlaylistMakeFragment.this.getContext();
                Params playlistUploadRepntImgBaseReq$Params0 = new Params();
                RequestBuilder.newInstance(PlaylistMakeFragment.this.mPlaylistFactory.uploadRepntImage(context0, playlistUploadRepntImgBaseReq$Params0)).tag("PlaylistMakeFragment").file("imgFile", file0).listener(new Listener() {
                    public static void a(com.iloen.melon.fragments.detail.PlaylistMakeFragment.10.2 playlistMakeFragment$10$20, com.iloen.melon.net.v4x.response.PlaylistUpdateRepntImgBaseRes.RESPONSE playlistUpdateRepntImgBaseRes$RESPONSE0) {
                        playlistMakeFragment$10$20.lambda$onResponse$0(playlistUpdateRepntImgBaseRes$RESPONSE0);
                    }

                    private void lambda$onResponse$0(com.iloen.melon.net.v4x.response.PlaylistUpdateRepntImgBaseRes.RESPONSE playlistUpdateRepntImgBaseRes$RESPONSE0) {
                        PlaylistMakeFragment.this.mIvCoverImage.setBackgroundColor(0);
                        String s = PlaylistMakeFragment.this.getString(0x7F130BF1);  // string:talkback_playlist_make_thumb_set "썸네일 설정됨, 설정"
                        PlaylistMakeFragment.this.mIvCoverImage.setContentDescription(s);
                        Glide.with(PlaylistMakeFragment.this.getContext()).load(playlistUpdateRepntImgBaseRes$RESPONSE0.repntImg).into(PlaylistMakeFragment.this.mIvCoverImage);
                        PlaylistMakeFragment.e1(PlaylistMakeFragment.this);
                    }

                    public void onResponse(PlaylistUpdateRepntImgBaseRes playlistUpdateRepntImgBaseRes0) {
                        PlaylistMakeFragment.this.showProgress(false);
                        if(playlistUpdateRepntImgBaseRes0.isSuccessful() && playlistUpdateRepntImgBaseRes0.response != null) {
                            PlaylistMakeFragment.Z0(PlaylistMakeFragment.this);
                            com.iloen.melon.net.v4x.response.PlaylistUpdateRepntImgBaseRes.RESPONSE playlistUpdateRepntImgBaseRes$RESPONSE0 = playlistUpdateRepntImgBaseRes0.response;
                            PlaylistMakeFragment.this.mBasicInfo.repntImg = playlistUpdateRepntImgBaseRes$RESPONSE0.repntImg;
                            new Handler(Looper.getMainLooper()).postDelayed(new H(0, this, playlistUpdateRepntImgBaseRes$RESPONSE0), ((long)playlistUpdateRepntImgBaseRes$RESPONSE0.sleepTime));
                        }
                    }

                    @Override  // com.android.volley.Response$Listener
                    public void onResponse(Object object0) {
                        this.onResponse(((PlaylistUpdateRepntImgBaseRes)object0));
                    }
                }).errorListener(new ErrorListener() {
                    @Override  // com.android.volley.Response$ErrorListener
                    public void onErrorResponse(VolleyError volleyError0) {
                        LogU.d("PlaylistMakeFragment", "uploadRepntImage() Req >> " + volleyError0.toString());
                        PlaylistMakeFragment.this.showProgress(false);
                        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                    }
                }).request();
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onStartBackgroundLoading() {
            }
        };
    }

    public static void Z0(PlaylistMakeFragment playlistMakeFragment0) {
        playlistMakeFragment0.isModified = true;
    }

    private void applySongIds(List list0) {
        if(list0 != null && !list0.isEmpty()) {
            LogU.d("PlaylistMakeFragment", "applySongIds songIds : " + list0.toString());
            TaskGetSongInfo taskGetSongInfo0 = new TaskGetSongInfo(((String[])list0.toArray(new String[0])), CType.SONG);
            taskGetSongInfo0.setResultListener(new ResultListener() {
                @Override  // com.iloen.melon.task.request.TaskGetSongInfo$ResultListener
                public void onFinishTask(Throwable throwable0) {
                    if(PlaylistMakeFragment.this.isFragmentValid()) {
                        PlaylistMakeFragment.this.showProgress(false);
                        if(throwable0 != null) {
                            ToastManager.show(throwable0.getMessage());
                            return;
                        }
                        List list0 = taskGetSongInfo0.getSongInfoList();
                        if(list0 != null && list0.size() != 0) {
                            PlaylistMakeFragment.this.mPreventDefaultFetcher = true;
                            PlaylistMakeFragment.this.mBasicInfo.songCnt = String.valueOf(list0.size());
                            PlaylistMakeFragment.p1(PlaylistMakeFragment.this, list0, true, false);
                        }
                    }
                }

                @Override  // com.iloen.melon.task.request.TaskGetSongInfo$ResultListener
                public void onStartTask() {
                }
            });
            taskGetSongInfo0.executeAsync();
            return;
        }
        this.mBasicInfo.songCnt = "0";
        this.setDataList(null, true, false);
        this.showProgress(false);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public View buildParallaxHeaderView() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D059A, null, false);  // layout:playlist_detail_make_header
        this.headerView = view0;
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public ToolBar buildToolBar() {
        return ToolBar.f(((ToolBar)this.findViewById(0x7F0A0BC6)), 507);  // id:toolbar_layout
    }

    private boolean checkMakePossible() {
        if(!"M20001".equals(this.mPlylstType)) {
            String s = this.mBasicInfo.getCurrentTitleText();
            if(TextUtils.isEmpty(s) || s.length() < 4) {
                ToastManager.show(0x7F13082F);  // string:playlist_input_name_4_char_hint_text "제목을 4자 이상 입력해 주세요."
                return false;
            }
            if(TextUtils.isEmpty(this.mBasicInfo.getCurrentContentText())) {
                ToastManager.show(0x7F13081F);  // string:playlist_alert_msg_enter_introduction "소개글을 입력해주세요."
                return false;
            }
            if(this.mSongArray == null || this.mSongArray.size() < 10) {
                ToastManager.show(0x7F130821);  // string:playlist_alert_msg_more_ten_songs "DJ플레이리스트 수록곡은 10곡 이상이어야 합니다."
                return false;
            }
        }
        else if(TextUtils.isEmpty(this.mBasicInfo.getCurrentTitleText())) {
            ToastManager.show(0x7F130834);  // string:playlist_no_title_msg "제목을 입력해주세요."
            return false;
        }
        return true;
    }

    private void clearPlaylistTempInfo() {
        boolean z = "M20002".equals(this.mPlylstType);
        MelonPrefs.getInstance().setString((z ? "DJ_PLAYLIST_MAKE_TITLE" : "PLAYLIST_MAKE_TITLE"), "");
        MelonPrefs.getInstance().setString((z ? "DJ_PLAYLIST_MAKE_CONTENT" : "PLAYLIST_MAKE_CONTENT"), "");
        MelonPrefs.getInstance().setString((z ? "DJ_PLAYLIST_MAKE_SONG_IDS" : "PLAYLIST_MAKE_SONG_IDS"), "");
        String s = "PLAYLIST_MAKE_REPNT_IMAGE_URL";
        MelonPrefs.getInstance().setString((z ? "DJ_PLAYLIST_MAKE_REPNT_IMAGE_URL" : "PLAYLIST_MAKE_REPNT_IMAGE_URL"), "");
        MelonPrefs melonPrefs0 = MelonPrefs.getInstance();
        if(z) {
            s = "DJ_PLAYLIST_MAKE_REPNT_IMAGE_URL";
        }
        melonPrefs0.setString(s, "");
    }

    private void clearTimeExpiredCache() {
        TimeExpiredCache.getInstance().removeLike(("M20001".equals(this.mPlylstType) ? MelonContentUris.J0.toString() : MelonContentUris.O0.toString()));
        TimeExpiredCache.getInstance().removeLike(MelonContentUris.X.toString());
        TimeExpiredCache.getInstance().removeLike(MelonContentUris.Y.toString());
        TimeExpiredCache.getInstance().removeLike(MelonContentUris.b0.toString());
        l.a(("M20001".equals(this.mPlylstType) ? f.b : f.c));
    }

    private void createPlaylist() {
        StringBuilder stringBuilder0 = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        for(Object object0: ((PlaylistAdapter)this.getAdapter()).getAllPlayableItems()) {
            stringBuilder0.append(String.valueOf(((Playable)object0).getSongid()));
            stringBuilder0.append(",");
            stringBuilder1.append("Y,");
        }
        if(stringBuilder0.length() > 0) {
            stringBuilder0.deleteCharAt(stringBuilder0.length() - 1);
            stringBuilder1.deleteCharAt(stringBuilder1.length() - 1);
            LogU.v("PlaylistMakeFragment", "songIds : " + stringBuilder0.toString());
            LogU.v("PlaylistMakeFragment", "matchIds : " + stringBuilder1.toString());
        }
        this.showProgress(true);
        if(TextUtils.isEmpty(this.mBasicInfo.repntImg)) {
            BuilderBase playlistInsertBaseReq$BuilderBase0 = this.getPlaylistCreateReqBuilder(stringBuilder0.toString(), null);
            if(playlistInsertBaseReq$BuilderBase0 == null) {
                return;
            }
            RequestBuilder.newInstance(this.mPlaylistFactory.createPlaylist(this.getContext(), playlistInsertBaseReq$BuilderBase0)).tag("PlaylistMakeFragment").listener(new Listener() {
                public void onResponse(PlaylistInsertBaseRes playlistInsertBaseRes0) {
                    PlaylistMakeFragment.this.showProgress(false);
                    if(PlaylistMakeFragment.this.isFragmentValid() && playlistInsertBaseRes0.isSuccessful()) {
                        if(!"M20001".equals(PlaylistMakeFragment.this.mPlylstType)) {
                            MelonDetailInfoUtils.saveDjPlaylistLatelyTags(PlaylistMakeFragment.this.mBasicInfo.getCurrentContentText());
                        }
                        PlaylistMakeFragment.h1(PlaylistMakeFragment.this);
                        PlaylistMakeFragment.m1(PlaylistMakeFragment.this);
                    }
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((PlaylistInsertBaseRes)object0));
                }
            }).errorListener(new ErrorListener() {
                @Override  // com.android.volley.Response$ErrorListener
                public void onErrorResponse(VolleyError volleyError0) {
                    ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                }
            }).request();
            return;
        }
        BuilderBase playlistInsertBaseReq$BuilderBase1 = this.getPlaylistCreateReqBuilder(stringBuilder0.toString(), this.mBasicInfo.repntImg);
        if(playlistInsertBaseReq$BuilderBase1 == null) {
            return;
        }
        Z.x(new StringBuilder("createPlaylist() >> mBasicInfo.postImg: "), this.mBasicInfo.repntImg, "PlaylistMakeFragment");
        RequestBuilder.newInstance(this.mPlaylistFactory.createPlaylist(this.getContext(), playlistInsertBaseReq$BuilderBase1)).tag("PlaylistMakeFragment").listener(new Listener() {
            // 检测为 Lambda 实现
            public static void a(com.iloen.melon.fragments.detail.PlaylistMakeFragment.18 playlistMakeFragment$180) [...]

            private void lambda$onResponse$0() {
                PlaylistMakeFragment.this.showProgress(false);
                PlaylistMakeFragment.m1(PlaylistMakeFragment.this);
            }

            public void onResponse(PlaylistInsertBaseRes playlistInsertBaseRes0) {
                if(PlaylistMakeFragment.this.isFragmentValid() && playlistInsertBaseRes0.isSuccessful() && playlistInsertBaseRes0.response != null) {
                    PlaylistMakeFragment.h1(PlaylistMakeFragment.this);
                    new Handler(Looper.getMainLooper()).postDelayed(() -> this.lambda$onResponse$0(), ((long)playlistInsertBaseRes0.response.sleepTime));
                    return;
                }
                PlaylistMakeFragment.this.showProgress(false);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((PlaylistInsertBaseRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new PlaylistAdapter(this, context0, null);
        ((j)j00).setMarkedMode(true);
        ((j)j00).setListContentType(1);
        ((p)j00).setEmptyViewInfo(v9.e.n);
        ((p)j00).setErrorViewInfo(o.j);
        return j00;
    }

    public static void d1(PlaylistMakeFragment playlistMakeFragment0) {
        playlistMakeFragment0.isSongInitCompleted = true;
    }

    private void deleteSongsToClient(boolean z) {
        PlaylistAdapter playlistMakeFragment$PlaylistAdapter0 = (PlaylistAdapter)this.getAdapter();
        if(playlistMakeFragment$PlaylistAdapter0 != null) {
            List list0 = z ? playlistMakeFragment$PlaylistAdapter0.getAllIndexItems() : playlistMakeFragment$PlaylistAdapter0.getMarkedItems();
            if(list0 != null && list0.size() >= 1) {
                this.setSelectAllWithToolbar(false);
                int v1 = list0.size() - 1;
                int v2 = 0;
                try {
                    while(v1 > -1) {
                        try {
                            playlistMakeFragment$PlaylistAdapter0.remove(((int)(((Integer)list0.get(v1)))));
                            ++v2;
                            --v1;
                        }
                        catch(Exception exception0) {
                            LogU.w("PlaylistMakeFragment", "deleteSongsToClient() >> Err: " + exception0.toString());
                            if(true) {
                                break;
                            }
                        }
                    }
                }
                finally {
                    ToastManager.showFormatted(0x7F1302F1, new Object[]{v2});  // string:deleted_songs_of_arg1 "%1$s곡이 삭제되었습니다."
                }
                this.mSongArray.clear();
                int v4 = playlistMakeFragment$PlaylistAdapter0.getCount();
                for(int v = 0; v < v4; ++v) {
                    SongInfoBase songInfoBase0 = (SongInfoBase)playlistMakeFragment$PlaylistAdapter0.getItem(v);
                    this.mSongArray.add(songInfoBase0.songId);
                }
                this.mBasicInfo.songCnt = String.valueOf(this.mSongArray.size());
                this.isModified = true;
                playlistMakeFragment$PlaylistAdapter0.notifyDataSetChanged();
            }
        }
    }

    public static void e1(PlaylistMakeFragment playlistMakeFragment0) {
        playlistMakeFragment0.repntCoverThumbnail = null;
    }

    private PlaylistInformBaseRes fetchData() {
        Cursor cursor0 = a.f(this.getContext(), this.mPlaylistCacheCreator.getBasicInformCacheKey(this.mPlylstSeq));
        if(cursor0 == null) {
            LogU.w("PlaylistMakeFragment", "fetchData() invalid cursor");
            return null;
        }
        PlaylistInformBaseRes playlistInformBaseRes0 = "M20001".equals(this.mPlylstType) ? ((PlaylistInformBaseRes)a.d(cursor0, MyMusicPlaylistInformRes.class)) : ((PlaylistInformBaseRes)a.d(cursor0, DjPlaylistInformRes.class));
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        if(playlistInformBaseRes0 == null) {
            LogU.w("PlaylistMakeFragment", "fetchData() failed to extract contents");
            return null;
        }
        return playlistInformBaseRes0;
    }

    private com.iloen.melon.net.v6x.response.DjTagSearchRecommendsRes.RESPONSE fetchRecmTagData() {
        Cursor cursor0 = a.f(this.getContext(), this.mPlaylistCacheCreator.recommendTagCacheKey());
        if(cursor0 == null) {
            LogU.w("PlaylistMakeFragment", "fetchData() invalid cursor");
            return null;
        }
        DjTagSearchRecommendsRes djTagSearchRecommendsRes0 = (DjTagSearchRecommendsRes)a.d(cursor0, DjTagSearchRecommendsRes.class);
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        if(djTagSearchRecommendsRes0 == null) {
            LogU.w("PlaylistMakeFragment", "fetchData() failed to extract contents");
            return null;
        }
        return djTagSearchRecommendsRes0.response;
    }

    public float getAlphaValue(float f) [...] // 潜在的解密器

    private int getContentTextCountLimit() {
        return "M20001".equals(this.mPlylstType) ? 0xA0 : 1000;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        return (int)this.getResources().getDimension(0x7F070418);  // dimen:playlist_titlebar_height
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        return (int)this.getResources().getDimension(0x7F070470);  // dimen:top_header_playlist_detail_edit_height
    }

    private BuilderBase getPlaylistCreateReqBuilder(String s, String s1) {
        if(!"M20001".equals(this.mPlylstType)) {
            BuilderBase playlistInsertBaseReq$BuilderBase0 = DjPlaylistInsertReq.newBuilder().plylstTitle(this.mBasicInfo.getCurrentTitleText()).introdCont(this.mBasicInfo.getCurrentContentText()).songIds(s).plylstTypeCode(this.mPlylstType).ocrGroupId(this.ocrGroupId);
            if(!TextUtils.isEmpty(s1)) {
                ((Builder)playlistInsertBaseReq$BuilderBase0).repntImg(s1);
            }
            return playlistInsertBaseReq$BuilderBase0;
        }
        BuilderBase playlistInsertBaseReq$BuilderBase1 = MyMusicPlaylistInsertReq.newBuilder().plylstTitle(this.mBasicInfo.getCurrentTitleText()).introdCont(this.mBasicInfo.getCurrentContentText()).songIds(s).openYn(YNType.valueOf(this.mBasicInfo.bOpenYn)).repntImgDefaultYn((TextUtils.isEmpty(this.repntCoverThumbnail) ? "N" : "Y"));
        if(!TextUtils.isEmpty(s1)) {
            ((com.iloen.melon.net.v6x.request.MyMusicPlaylistInsertReq.Builder)playlistInsertBaseReq$BuilderBase1).repntImg(s1);
        }
        return playlistInsertBaseReq$BuilderBase1;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public PvLogDummyReq getPvDummyLogRequest() {
        return TextUtils.isEmpty(this.mPvLogDummyAction) ? null : new PvLogDummyReq(this.getContext(), this.mPvLogDummyAction);
    }

    private boolean hasPlaylistTempInfo() {
        if(this.ignoreTempPlaylist) {
            return false;
        }
        boolean z = "M20002".equals(this.mPlylstType);
        if(!TextUtils.isEmpty(MelonPrefs.getInstance().getString((z ? "DJ_PLAYLIST_MAKE_TITLE" : "PLAYLIST_MAKE_TITLE"), ""))) {
            return true;
        }
        if(!TextUtils.isEmpty(MelonPrefs.getInstance().getString((z ? "DJ_PLAYLIST_MAKE_CONTENT" : "PLAYLIST_MAKE_CONTENT"), ""))) {
            return true;
        }
        return TextUtils.isEmpty(MelonPrefs.getInstance().getString((z ? "DJ_PLAYLIST_MAKE_SONG_IDS" : "PLAYLIST_MAKE_SONG_IDS"), "")) ? !TextUtils.isEmpty(MelonPrefs.getInstance().getString((z ? "DJ_PLAYLIST_MAKE_REPNT_IMAGE_URL" : "PLAYLIST_MAKE_REPNT_IMAGE_URL"), "")) : true;
    }

    private void hideInputMethodEditor() {
        InputMethodUtils.hideInputMethod(this.getContext(), this.etInputTitle);
        InputMethodUtils.hideInputMethod(this.getContext(), this.etInputIntroduce);
    }

    private void lambda$new$0(ActivityResult activityResult0) {
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                String s = intent0.getStringExtra("argSearchResultValues");
                if(s != null) {
                    String[] arr_s = s.split(",");
                    if((this.mSongArray == null ? 0 : this.mSongArray.size()) == arr_s.length) {
                        int v = 0;
                        while(v < arr_s.length) {
                            if(!((String)this.mSongArray.get(v)).equals(arr_s[v])) {
                                goto label_13;
                            }
                            ++v;
                        }
                    }
                    else {
                    label_13:
                        this.mSongArray = new ArrayList(Arrays.asList(arr_s));
                        this.mPreventDefaultFetcher = false;
                        this.isModified = true;
                        this.isSongInitCompleted = false;
                    }
                    this.startFetch("add songs");
                }
            }
        }
    }

    private ie.H lambda$onToolBarClick$5() {
        this.deleteSongsToClient(false);
        return null;
    }

    private ie.H lambda$showLoadPlaylistTempInfoPopup$3() {
        if(this.getActivity() == null) {
            return null;
        }
        this.loadPlaylistTempInfo();
        this.clearPlaylistTempInfo();
        return null;
    }

    private ie.H lambda$showLoadPlaylistTempInfoPopup$4() {
        if(this.getActivity() == null) {
            return null;
        }
        this.clearPlaylistTempInfo();
        if(!"M20001".equals(this.mPlylstType) && this.mSongArray.size() > 0) {
            this.applySongIds(this.mSongArray);
            return null;
        }
        this.isSongInitCompleted = true;
        return null;
    }

    private ie.H lambda$showTempSavePopup$1() {
        this.savePlaylistTempInfo();
        this.navigateBack();
        return null;
    }

    private ie.H lambda$showTempSavePopup$2() {
        this.clearPlaylistTempInfo();
        this.navigateBack();
        return null;
    }

    private void loadPlaylistTempInfo() {
        boolean z = "M20002".equals(this.mPlylstType);
        String s = MelonPrefs.getInstance().getString((z ? "DJ_PLAYLIST_MAKE_TITLE" : "PLAYLIST_MAKE_TITLE"), "");
        if(!TextUtils.isEmpty(s)) {
            this.etInputTitle.setText(s);
        }
        String s1 = MelonPrefs.getInstance().getString((z ? "DJ_PLAYLIST_MAKE_CONTENT" : "PLAYLIST_MAKE_CONTENT"), "");
        if(!TextUtils.isEmpty(s1)) {
            this.etInputIntroduce.setText(s1);
        }
        String s2 = MelonPrefs.getInstance().getString((z ? "DJ_PLAYLIST_MAKE_SONG_IDS" : "PLAYLIST_MAKE_SONG_IDS"), "");
        if(!TextUtils.isEmpty(s2)) {
            String[] arr_s = s2.split(",");
            ArrayList arrayList0 = this.mSongArray;
            if(arrayList0 == null) {
                this.mSongArray = new ArrayList(Arrays.asList(arr_s));
            }
            else {
                arrayList0.addAll(Arrays.asList(arr_s));
            }
        }
        if(this.mSongArray.size() > 0) {
            this.showProgress(true);
            this.applySongIds(this.mSongArray);
        }
        else {
            this.isSongInitCompleted = true;
        }
        Context context0 = this.getContext();
        if(context0 != null) {
            String s3 = MelonPrefs.getInstance().getString("DJ_PLAYLIST_MAKE_FIXED_REPNT_IMAGE_URL", "");
            this.repntCoverThumbnail = s3;
            if(TextUtils.isEmpty(s3)) {
                BasicInfo playlistMakeFragment$BasicInfo0 = this.mBasicInfo;
                playlistMakeFragment$BasicInfo0.repntImg = MelonPrefs.getInstance().getString((z ? "DJ_PLAYLIST_MAKE_REPNT_IMAGE_URL" : "PLAYLIST_MAKE_REPNT_IMAGE_URL"), "");
            }
            else {
                this.mBasicInfo.repntImg = this.repntCoverThumbnail;
            }
            if(!TextUtils.isEmpty(this.mBasicInfo.repntImg)) {
                Glide.with(context0).load(this.mBasicInfo.repntImg).into(this.mIvCoverImage);
            }
        }
        this.isModified = true;
    }

    public static void n1(PlaylistMakeFragment playlistMakeFragment0) {
        playlistMakeFragment0.refreshSongList(i.b);
    }

    private void navigateBack() {
        if(this.getActivity() instanceof BaseActivity) {
            ((BaseActivity)this.getActivity()).navigateBack();
        }
    }

    public static PlaylistMakeFragment newInstance(String s, String s1) {
        return PlaylistMakeFragment.newInstance(s, s1, null);
    }

    public static PlaylistMakeFragment newInstance(String s, String s1, String s2) {
        PlaylistMakeFragment playlistMakeFragment0 = new PlaylistMakeFragment();
        Bundle bundle0 = Y.c("argItemId", s, "argPlaylistType", s1);
        bundle0.putString("argPvLogDummyAction", s2);
        playlistMakeFragment0.setArguments(bundle0);
        return playlistMakeFragment0;
    }

    public static PlaylistMakeFragment newInstance(String s, String s1, ArrayList arrayList0, String s2, String s3) {
        return PlaylistMakeFragment.newInstance(s, s1, arrayList0, "", s2, s3);
    }

    public static PlaylistMakeFragment newInstance(String s, String s1, ArrayList arrayList0, String s2, String s3, String s4) {
        return PlaylistMakeFragment.newInstance(s, s1, arrayList0, s2, s3, false, s4, null);
    }

    public static PlaylistMakeFragment newInstance(String s, String s1, ArrayList arrayList0, String s2, String s3, boolean z, String s4, String s5) {
        PlaylistMakeFragment playlistMakeFragment0 = new PlaylistMakeFragment();
        Bundle bundle0 = Y.c("argItemId", s, "argPlaylistType", s1);
        bundle0.putSerializable("argSongList", arrayList0);
        bundle0.putBoolean("argIgnoreTempPlaylist", z);
        bundle0.putString("argTitle", s2);
        bundle0.putString("argPvLogDummyAction", s3);
        bundle0.putString("argRepntCoverThumbnail", s4);
        bundle0.putString("argGroupId", s5);
        playlistMakeFragment0.setArguments(bundle0);
        return playlistMakeFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        if(!TextUtils.isEmpty(this.mPlylstSeq)) {
            return super.onBackPressed();
        }
        if(this.ignoreTempPlaylist) {
            return super.onBackPressed();
        }
        String s = this.etInputTitle.getText().toString();
        String s1 = this.etInputIntroduce.getText().toString();
        int v = ((PlaylistAdapter)this.getAdapter()).getCount();
        if(TextUtils.isEmpty(s) && TextUtils.isEmpty(s1) && TextUtils.isEmpty(this.mBasicInfo.repntImg) && v < 1) {
            return super.onBackPressed();
        }
        this.showTempSavePopup();
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        if(TextUtils.isEmpty(this.mPlylstSeq)) {
            ImageView imageView0 = this.mIvCamera;
            if(imageView0 != null) {
                imageView0.setAlpha(1.0f);
            }
            this.updateParallaxTranslation(0);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        if(!"M20001".equals(this.mPlylstType)) {
            String s1 = this.mPlaylistCacheCreator.recommendTagCacheKey();
            if(a.e(300000L, s1, this.getContext())) {
                RequestBuilder.newInstance(((DjPlaylistDetailFactory)this.mPlaylistFactory).listRecmTag(this.getContext())).tag("PlaylistMakeFragment").listener(new Listener() {
                    public void onResponse(DjTagSearchRecommendsRes djTagSearchRecommendsRes0) {
                        if(PlaylistMakeFragment.this.isFragmentValid() && djTagSearchRecommendsRes0.isSuccessful(false)) {
                            a.a(PlaylistMakeFragment.this.getContext(), djTagSearchRecommendsRes0, s1);
                            PlaylistMakeFragment.this.setRecommendTagArray(djTagSearchRecommendsRes0.response);
                        }
                    }

                    @Override  // com.android.volley.Response$Listener
                    public void onResponse(Object object0) {
                        this.onResponse(((DjTagSearchRecommendsRes)object0));
                    }
                }).errorListener(new ErrorListener() {
                    @Override  // com.android.volley.Response$ErrorListener
                    public void onErrorResponse(VolleyError volleyError0) {
                        LogU.w("PlaylistMakeFragment", "listRecmTag() >> Receiving tag list is failed.");
                    }
                }).request();
            }
            else {
                this.setRecommendTagArray(this.fetchRecmTagData());
            }
        }
        String s2 = "PLAYLIST";
        i i1 = i.b;
        if(i1 == i0) {
            if(TextUtils.isEmpty(this.mPlylstSeq)) {
                if("M20002".equals(this.mPlylstType)) {
                    s2 = "DJPLAYLIST";
                }
                RequestBuilder.newInstance(new CleanIsBlackReq(this.getContext(), s2, "")).tag(this.getRequestTag()).listener(new Listener() {
                    public void onResponse(CleanIsBlackRes cleanIsBlackRes0) {
                        if(cleanIsBlackRes0.isSuccessful() && PlaylistMakeFragment.this.isFragmentValid()) {
                            int v = PlaylistMakeFragment.this.mSongArray.size();
                            if("M20001".equals(PlaylistMakeFragment.this.mPlylstType)) {
                                if(v > 0) {
                                    PlaylistMakeFragment.this.applySongIds(PlaylistMakeFragment.this.mSongArray);
                                    return;
                                }
                                PlaylistMakeFragment.this.showProgress(false);
                                if(PlaylistMakeFragment.this.hasPlaylistTempInfo()) {
                                    PlaylistMakeFragment.this.showLoadPlaylistTempInfoPopup();
                                    return;
                                }
                                PlaylistMakeFragment.d1(PlaylistMakeFragment.this);
                                return;
                            }
                            if(PlaylistMakeFragment.this.hasPlaylistTempInfo()) {
                                PlaylistMakeFragment.this.showProgress(false);
                                PlaylistMakeFragment.this.showLoadPlaylistTempInfoPopup();
                                return;
                            }
                            PlaylistMakeFragment.this.applySongIds(PlaylistMakeFragment.this.mSongArray);
                        }
                    }

                    @Override  // com.android.volley.Response$Listener
                    public void onResponse(Object object0) {
                        this.onResponse(((CleanIsBlackRes)object0));
                    }
                }).errorListener(this.mResponseErrorListener).request();
                return true;
            }
            String s3 = this.mPlaylistCacheCreator.getBasicInformCacheKey(this.mPlylstSeq);
            if(a.e(300000L, s3, this.getContext())) {
                LogU.d("PlaylistMakeFragment", "onFetchStart() >> DjPlaylistInformReq >> Cache Data Expired!");
                com.iloen.melon.net.v4x.request.PlaylistInformBaseReq.Params playlistInformBaseReq$Params0 = new com.iloen.melon.net.v4x.request.PlaylistInformBaseReq.Params();
                playlistInformBaseReq$Params0.plylstSeq = this.mPlylstSeq;
                RequestBuilder.newInstance(this.mPlaylistFactory.playlistInform(this.getContext(), playlistInformBaseReq$Params0)).tag("PlaylistMakeFragment").listener(new Listener() {
                    public void onResponse(PlaylistInformBaseRes playlistInformBaseRes0) {
                        if(!PlaylistMakeFragment.this.prepareFetchComplete(playlistInformBaseRes0)) {
                            return;
                        }
                        a.a(PlaylistMakeFragment.this.getContext(), playlistInformBaseRes0, s3);
                        PlaylistMakeFragment.this.updateBasicInfoUi(playlistInformBaseRes0);
                        if(PlaylistMakeFragment.this.mSongArray.size() > 0) {
                            PlaylistMakeFragment.this.applySongIds(PlaylistMakeFragment.this.mSongArray);
                            return;
                        }
                        PlaylistMakeFragment.n1(PlaylistMakeFragment.this);
                    }

                    @Override  // com.android.volley.Response$Listener
                    public void onResponse(Object object0) {
                        this.onResponse(((PlaylistInformBaseRes)object0));
                    }
                }).errorListener(this.mResponseErrorListener).request();
                return true;
            }
            LogU.d("PlaylistMakeFragment", "onFetchStart() >> DjPlaylistInformReq >> Cache Data Exist!");
            this.updateBasicInfoUi(this.fetchData());
            if(this.mSongArray.size() > 0) {
                this.applySongIds(this.mSongArray);
                return true;
            }
            this.refreshSongList(i1);
            return true;
        }
        this.refreshSongList(i0);
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.setSelectAllWithToolbar(false);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        this.mPlylstSeq = bundle0.getString("argItemId");
        String s = bundle0.getString("argPlaylistType");
        if(!StringUtils.isEmptyOrZero(s)) {
            this.mPlylstType = s;
        }
        if(bundle0.containsKey("argPvLogDummyAction")) {
            this.mPvLogDummyAction = bundle0.getString("argPvLogDummyAction");
        }
        if(this.mBasicInfo == null) {
            this.mBasicInfo = new BasicInfo(this, null);
        }
        this.mTitle = bundle0.getString("argTitle");
        BasicInfo playlistMakeFragment$BasicInfo0 = this.mBasicInfo;
        playlistMakeFragment$BasicInfo0.modifyingTitleText = bundle0.getString("argPlaylistTitle");
        if(this.mBasicInfo.modifyingTitleText == null) {
            this.mBasicInfo.modifyingTitleText = TextUtils.isEmpty(this.mTitle) ? "" : this.mTitle;
        }
        BasicInfo playlistMakeFragment$BasicInfo1 = this.mBasicInfo;
        playlistMakeFragment$BasicInfo1.modifyingContentText = bundle0.getString("argPlaylistIntroduce");
        BasicInfo playlistMakeFragment$BasicInfo2 = this.mBasicInfo;
        if(playlistMakeFragment$BasicInfo2.modifyingContentText == null) {
            playlistMakeFragment$BasicInfo2.modifyingContentText = "";
        }
        ArrayList arrayList0 = (ArrayList)CompatUtils.getSerializable(bundle0, "argSongList", ArrayList.class);
        this.mSongArray = arrayList0;
        this.mSongArray = arrayList0 == null ? new ArrayList() : this.removeDuplicatedAndExceededSongId(arrayList0);
        this.ignoreTempPlaylist = bundle0.getBoolean("argIgnoreTempPlaylist");
        this.repntCoverThumbnail = bundle0.getString("argRepntCoverThumbnail");
        this.ocrGroupId = bundle0.getString("argGroupId");
        if(TextUtils.isEmpty(this.mBasicInfo.repntImg) && !TextUtils.isEmpty(this.repntCoverThumbnail)) {
            this.mBasicInfo.repntImg = this.repntCoverThumbnail;
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("argItemId", this.mPlylstSeq);
            bundle0.putString("argPlaylistType", this.mPlylstType);
            bundle0.putSerializable("argSongList", this.mSongArray);
            bundle0.putString("argTitle", this.mTitle);
            if(this.etInputTitle != null && this.etInputTitle.getText() != null) {
                bundle0.putString("argPlaylistTitle", this.etInputTitle.getText().toString());
            }
            if(this.etInputIntroduce != null && this.etInputIntroduce.getText() != null) {
                bundle0.putString("argPlaylistIntroduce", this.etInputIntroduce.getText().toString());
            }
            bundle0.putString("argPvLogDummyAction", this.mPvLogDummyAction);
            bundle0.putString("argRepntCoverThumbnail", this.repntCoverThumbnail);
        }
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(ToolBarItem toolBar$ToolBarItem0, int v) {
        if(16 == v) {
            if(!this.isLoginUser()) {
                ToastManager.showShort(0x7F1308D1);  // string:retry_after_login "로그인 후 이용해 주세요."
                return;
            }
            PlaylistAdapter playlistMakeFragment$PlaylistAdapter0 = (PlaylistAdapter)this.mAdapter;
            if(playlistMakeFragment$PlaylistAdapter0 != null && playlistMakeFragment$PlaylistAdapter0.getMarkedCount() >= 1) {
                int v1 = this.getMarkedList(false).d.size();
                if(v1 < 1) {
                    String s = this.getString(0x7F130833);  // string:playlist_no_marked_song "곡을 선택해주세요."
                    com.melon.ui.popup.b.x(this.getChildFragmentManager(), this.getString(0x7F1300D0), s, false, false, null, null, null, null, null, null, 0xFF8);  // string:alert_dlg_title_info "안내"
                    return;
                }
                String s1 = this.getString(0x7F130838);  // string:playlist_remove_n_songs_confirm_message "%1$d곡을 플레이리스트에서 삭제하시겠습니까?"
                l0 l00 = this.getChildFragmentManager();
                String s2 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                G g0 = new G(this, 0);
                com.melon.ui.popup.b.v(l00, s2, String.format(s1, v1), false, null, null, g0, null);
                return;
            }
            String s3 = this.getString(0x7F1300A4);  // string:alert_dlg_body_delete_song_select_content "곡을 선택해 주세요."
            l0 l01 = this.getChildFragmentManager();
            String s4 = this.getString(0x7F1300CD);  // string:alert_dlg_title_delete_confirm "안내"
            com.melon.ui.popup.b.a.c(l01, s4, s3);
        }
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View view0, MotionEvent motionEvent0) {
        this.hideInputMethodEditor();
        return false;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        PlaylistDetailFactoryBase playlistDetailFactoryBase0 = PlaylistDetailFactoryBase.create(this.mPlylstType);
        this.mPlaylistFactory = playlistDetailFactoryBase0;
        this.mPlaylistCacheCreator = playlistDetailFactoryBase0.getCacheCreator();
        this.setLatelyTagArray(MelonDetailInfoUtils.loadDjPlaylistLatelyTags());
        F8.o o0 = null;
        if(this.mBasicInfo == null) {
            BasicInfo playlistMakeFragment$BasicInfo0 = new BasicInfo(this, null);
            this.mBasicInfo = playlistMakeFragment$BasicInfo0;
            playlistMakeFragment$BasicInfo0.modifyingTitleText = this.mTitle;
        }
        if(TextUtils.isEmpty(this.mPlylstSeq)) {
            this.mBasicInfo.bOpenYn = true;
        }
        TitleBar titleBar0 = this.getTitleBar();
        this.mTitleBar = titleBar0;
        if(titleBar0 != null) {
            K k0 = new K(1, false);
            k0.c = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    if(!PlaylistMakeFragment.this.isProgressShowing() && PlaylistMakeFragment.this.checkMakePossible()) {
                        PlaylistMakeFragment.this.hideInputMethodEditor();
                        if(PlaylistMakeFragment.this.isModified) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    if(TextUtils.isEmpty(PlaylistMakeFragment.this.mPlylstSeq)) {
                                        PlaylistMakeFragment.this.createPlaylist();
                                        return;
                                    }
                                    PlaylistMakeFragment.this.updatePlaylist();
                                }
                            }).start();
                            return;
                        }
                        PlaylistMakeFragment.this.navigateBack();
                    }
                }
            };
            F8.p p0 = new F8.p(1);
            p0.c = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    PlaylistMakeFragment.this.hideInputMethodEditor();
                    if(!TextUtils.isEmpty(PlaylistMakeFragment.this.mPlylstSeq)) {
                        PlaylistMakeFragment.this.navigateBack();
                        return;
                    }
                    if(PlaylistMakeFragment.this.ignoreTempPlaylist) {
                        PlaylistMakeFragment.this.navigateBack();
                        return;
                    }
                    String s = PlaylistMakeFragment.this.etInputTitle.getText().toString();
                    String s1 = PlaylistMakeFragment.this.etInputIntroduce.getText().toString();
                    int v = ((PlaylistAdapter)PlaylistMakeFragment.this.getAdapter()).getCount();
                    if(TextUtils.isEmpty(s) && TextUtils.isEmpty(s1) && TextUtils.isEmpty(PlaylistMakeFragment.this.mBasicInfo.repntImg) && v < 1) {
                        PlaylistMakeFragment.this.navigateBack();
                        return;
                    }
                    PlaylistMakeFragment.this.showTempSavePopup();
                }
            };
            m m0 = new m(2, false);
            TitleBar titleBar1 = this.mTitleBar;
            F8.o[] arr_o = {p0, m0, k0};
            for(int v = 0; v < 3; ++v) {
                F8.o o1 = arr_o[v];
                if(o0 == null) {
                    o0 = o1;
                }
                else {
                    o0.g(o1);
                }
            }
            titleBar1.a(o0);
            this.mTitleBar.f(false);
            if("M20001".equals(this.mPlylstType)) {
                this.mTitleBar.setTitle(this.getString((TextUtils.isEmpty(this.mPlylstSeq) ? 0x7F13083E : 0x7F130840)));  // string:playlist_title_create_playlist "플레이리스트 만들기"
            }
            else {
                this.mTitleBar.setTitle(this.getString((TextUtils.isEmpty(this.mPlylstSeq) ? 0x7F13083D : 0x7F13083F)));  // string:playlist_title_create_djplaylist "DJ플레이리스트 만들기"
            }
        }
        this.mImageSelector = new ImageSelector(this, this.mImageSelectorListener);
        this.mIvCamera = (ImageView)this.findViewById(0x7F0A05D8);  // id:ivCamera
        ImageView imageView0 = (ImageView)this.findViewById(0x7F0A0351);  // id:cover_image
        this.mIvCoverImage = imageView0;
        imageView0.setContentDescription(this.getString(0x7F130BF2));  // string:talkback_playlist_make_thumb_unset "썸네일 설정안됨, 설정"
        ViewUtils.setOnClickListener(this.mIvCoverImage, new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(PlaylistMakeFragment.this.mImageSelector != null) {
                    Request imageSelector$Request0 = Request.newNormalImage("tag_cover");
                    PlaylistMakeFragment.this.mImageSelector.startSelector(imageSelector$Request0);
                }
            }
        });
        if(!TextUtils.isEmpty(this.mBasicInfo.repntImg)) {
            Context context0 = this.getContext();
            if(context0 != null) {
                Glide.with(context0).load(this.mBasicInfo.repntImg).into(this.mIvCoverImage);
            }
        }
        this.mTagParser = new TagParser(this.getContext(), new OnParsedListener() {
            @Override  // com.iloen.melon.utils.TagParser$OnParsedListener
            public void onParseFailed(int v, String s) {
            }

            @Override  // com.iloen.melon.utils.TagParser$OnParsedListener
            public void onParseSuccess(ArrayList arrayList0, SpannableString spannableString0, int v) {
            }
        });
        MelonItemTouchHelper melonItemTouchHelper0 = new MelonItemTouchHelper(this.mRecyclerView);
        this.melonItemTouchHelper = melonItemTouchHelper0;
        melonItemTouchHelper0.setAutoScrollSpeed(ScrollSpeed.SCROLL_SPEED_MIDDLE);
        this.melonItemTouchHelper.setFloatingAlpha(0.8f);
        this.melonItemTouchHelper.setFloatingBgColor(ColorUtils.getColor(this.getContext(), 0x7F060195));  // color:item_floating_bg
        this.melonItemTouchHelper.setViewHandleId(0x7F0A0651);  // id:iv_move
        this.melonItemTouchHelper.setOnItemMovedListener(new ItemMoveListener() {
            @Override  // com.iloen.melon.utils.dragdrop.MelonItemTouchHelper$ItemMoveListener
            public boolean onItemCheckEnable(int v) {
                return true;
            }

            @Override  // com.iloen.melon.utils.dragdrop.MelonItemTouchHelper$ItemMoveListener
            public void onItemMoved(int v, int v1) {
                LogU.d("PlaylistMakeFragment", "from : " + v + ", to : " + v1);
                if(v == v1) {
                    return;
                }
                ((PlaylistAdapter)PlaylistMakeFragment.this.mAdapter).dragNDrop(v - 1, v1 - 1);
            }
        });
        this.headerView.setOnTouchListener(this);
        this.getRecyclerView().setOnTouchListener(this);
    }

    public static ie.H r0(PlaylistMakeFragment playlistMakeFragment0) {
        return playlistMakeFragment0.lambda$showTempSavePopup$2();
    }

    // 去混淆评级： 低(20)
    private void refreshSongList(i i0) {
        String s = "M20002".equals(this.mPlylstType) ? "DJPLAYLIST" : "PLAYLIST";
        RequestBuilder.newInstance(new CleanIsBlackReq(this.getContext(), s, "")).tag(this.getRequestTag()).listener(new Listener() {
            public void onResponse(CleanIsBlackRes cleanIsBlackRes0) {
                if(cleanIsBlackRes0.isSuccessful() && PlaylistMakeFragment.this.isFragmentValid()) {
                    if(((PlaylistAdapter)PlaylistMakeFragment.this.getAdapter()) == null) {
                        LogU.w("PlaylistMakeFragment", "refreshSongList() >> adapter is null");
                        return;
                    }
                    com.iloen.melon.net.v5x.request.PlaylistListSongBaseReq.Params playlistListSongBaseReq$Params0 = new com.iloen.melon.net.v5x.request.PlaylistListSongBaseReq.Params();
                    playlistListSongBaseReq$Params0.plylstSeq = PlaylistMakeFragment.this.mPlylstSeq;
                    playlistListSongBaseReq$Params0.mode = "M20001".equals(PlaylistMakeFragment.this.mPlylstType) ? "all" : "modify";
                    Context context0 = PlaylistMakeFragment.this.getContext();
                    RequestBuilder.newInstance(PlaylistMakeFragment.this.mPlaylistFactory.songList(context0, playlistListSongBaseReq$Params0, 1)).tag("PlaylistMakeFragment").listener(new Listener() {
                        public void onResponse(HttpResponse httpResponse0) {
                            httpResponse0.notification = null;
                            if(!PlaylistMakeFragment.this.prepareFetchComplete(httpResponse0)) {
                                return;
                            }
                            PlaylistMakeFragment.this.mPreventDefaultFetcher = true;
                            PlaylistMakeFragment.this.performFetchComplete(com.iloen.melon.fragments.detail.PlaylistMakeFragment.13.this.val$fetchType, httpResponse0);
                            PlaylistMakeFragment.d1(PlaylistMakeFragment.this);
                        }

                        @Override  // com.android.volley.Response$Listener
                        public void onResponse(Object object0) {
                            this.onResponse(((HttpResponse)object0));
                        }
                    }).errorListener(new ErrorListener() {
                        @Override  // com.android.volley.Response$ErrorListener
                        public void onErrorResponse(VolleyError volleyError0) {
                            LogU.d("PlaylistMakeFragment", "refreshSongList() >> " + volleyError0.toString());
                            ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                        }
                    }).request();
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((CleanIsBlackRes)object0));
            }
        }).request();
    }

    private ArrayList removeDuplicatedAndExceededSongId(ArrayList arrayList0) {
        ArrayList arrayList1 = new ArrayList();
        HashSet hashSet0 = new HashSet();
        for(Object object0: arrayList0) {
            String s = (String)object0;
            if(hashSet0.size() >= 1000) {
                if(arrayList0.size() <= 1000) {
                    break;
                }
                ToastManager.show(0x7F13083C);  // string:playlist_song_list_add_limit_warning "초과하는 곡을 제외하고 1000곡을 담았습니다."
                return arrayList1;
            }
            if(!hashSet0.contains(s)) {
                arrayList1.add(s);
                hashSet0.add(s);
            }
        }
        return arrayList1;
    }

    private void replaceTagToCurrentTag(String s) {
        int v = this.etInputIntroduce.getSelectionEnd();
        TagPos tagParser$TagPos0 = this.mTagParser.getTagInnerPos(v);
        if(tagParser$TagPos0 != null) {
            int v1 = Math.max(tagParser$TagPos0.begin + 1, 0);
            int v2 = Math.max(this.etInputIntroduce.getSelectionEnd(), 0);
            if(v1 <= v2) {
                try {
                    this.etInputIntroduce.getText().replace(Math.min(v1, v2), Math.max(v1, v2), s + " ", 0, (s + " ").length());
                    this.etInputIntroduce.setSelection(v1 + (s + " ").length());
                    this.etInputIntroduce.clearComposingText();
                    this.hideInputMethodEditor();
                }
                catch(Exception exception0) {
                    b.v(exception0, new StringBuilder("replaceTagToCurrentTag() >> "), "PlaylistMakeFragment");
                }
            }
        }
    }

    public static ie.H s0(PlaylistMakeFragment playlistMakeFragment0) {
        return playlistMakeFragment0.lambda$showTempSavePopup$1();
    }

    private void savePlaylistTempInfo() {
        PlaylistAdapter playlistMakeFragment$PlaylistAdapter0 = (PlaylistAdapter)this.getAdapter();
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = playlistMakeFragment$PlaylistAdapter0.getCount();
        for(int v1 = 0; v1 < v; ++v1) {
            SongInfoBase songInfoBase0 = (SongInfoBase)playlistMakeFragment$PlaylistAdapter0.getItem(v1);
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append(",");
            }
            stringBuilder0.append(songInfoBase0.songId);
        }
        boolean z = "M20002".equals(this.mPlylstType);
        MelonPrefs.getInstance().setString((z ? "DJ_PLAYLIST_MAKE_TITLE" : "PLAYLIST_MAKE_TITLE"), this.etInputTitle.getText().toString());
        MelonPrefs.getInstance().setString((z ? "DJ_PLAYLIST_MAKE_CONTENT" : "PLAYLIST_MAKE_CONTENT"), this.etInputIntroduce.getText().toString());
        MelonPrefs.getInstance().setString((z ? "DJ_PLAYLIST_MAKE_SONG_IDS" : "PLAYLIST_MAKE_SONG_IDS"), stringBuilder0.toString());
        MelonPrefs.getInstance().setString((z ? "DJ_PLAYLIST_MAKE_REPNT_IMAGE_URL" : "PLAYLIST_MAKE_REPNT_IMAGE_URL"), this.mBasicInfo.repntImg);
        MelonPrefs.getInstance().setString("DJ_PLAYLIST_MAKE_FIXED_REPNT_IMAGE_URL", this.repntCoverThumbnail);
        ToastManager.show(0x7F13082A);  // string:playlist_edit_temp_save_complete "플레이리스트가 임시저장되었습니다."
    }

    private void setDataList(List list0, boolean z, boolean z1) {
        PlaylistAdapter playlistMakeFragment$PlaylistAdapter0 = (PlaylistAdapter)this.mAdapter;
        if(playlistMakeFragment$PlaylistAdapter0 == null) {
            return;
        }
        if(z) {
            playlistMakeFragment$PlaylistAdapter0.clear();
            this.mSongArray.clear();
        }
        if(list0 != null) {
            for(Object object0: list0) {
                this.mSongArray.add(((SongInfoBase)object0).songId);
            }
        }
        if(list0 != null) {
            LogU.d("PlaylistMakeFragment", "setDataList() >> songInfoArray.size: " + list0.size());
            playlistMakeFragment$PlaylistAdapter0.addAll(list0);
        }
        playlistMakeFragment$PlaylistAdapter0.setHasMore(z1);
        playlistMakeFragment$PlaylistAdapter0.updateModifiedTime(this.mPlaylistCacheCreator.getBasicInformCacheKey(this.mPlylstSeq));
        playlistMakeFragment$PlaylistAdapter0.notifyDataSetChanged();
        this.isSongInitCompleted = true;
    }

    public void setLatelyTagArray(ArrayList arrayList0) {
        if(arrayList0 != null) {
            if(this.mLatelyTagHashMap == null) {
                this.mLatelyTagHashMap = new LinkedHashMap();
            }
            for(Object object0: arrayList0) {
                this.mLatelyTagHashMap.put(((String)object0), ((String)object0));
            }
        }
    }

    private void setRecommendTagArray(com.iloen.melon.net.v6x.response.DjTagSearchRecommendsRes.RESPONSE djTagSearchRecommendsRes$RESPONSE0) {
        if(djTagSearchRecommendsRes$RESPONSE0 != null && (djTagSearchRecommendsRes$RESPONSE0.tagList != null && djTagSearchRecommendsRes$RESPONSE0.tagList.size() >= 1)) {
            this.mRecommendTagArray = new ArrayList();
            for(Object object0: djTagSearchRecommendsRes$RESPONSE0.tagList) {
                this.mRecommendTagArray.add(((TagInfoBase)object0).tagName);
            }
        }
    }

    private void showAutoCompleteTagList(String s) {
        if(!TextUtils.isEmpty(s)) {
            String s1 = s.replaceAll("#", "");
            if(!TextUtils.isEmpty(s1)) {
                LogU.d("PlaylistMakeFragment", "autoCompleteTagList() >> keyword: " + s1);
                RequestBuilder.newInstance(new DjTagSearchAutoCompleteReq(this.getContext(), s1)).tag("PlaylistMakeFragment").listener(new Listener() {
                    public void onResponse(DjTagSearchAutoCompleteRes djTagSearchAutoCompleteRes0) {
                        if(PlaylistMakeFragment.this.isFragmentValid() && djTagSearchAutoCompleteRes0.isSuccessful()) {
                            com.iloen.melon.net.v6x.response.DjTagSearchAutoCompleteRes.RESPONSE djTagSearchAutoCompleteRes$RESPONSE0 = djTagSearchAutoCompleteRes0.response;
                            if(djTagSearchAutoCompleteRes$RESPONSE0 != null) {
                                PlaylistMakeFragment.this.autoCompleteTagList = djTagSearchAutoCompleteRes$RESPONSE0.tagList;
                                if(PlaylistMakeFragment.z0(PlaylistMakeFragment.this) != null && PlaylistMakeFragment.z0(PlaylistMakeFragment.this).size() > 0) {
                                    PlaylistMakeFragment.this.isShowAutoCompleteTag = true;
                                    PlaylistMakeFragment.this.getAdapter().notifyItemChanged(1, 0);
                                    return;
                                }
                            }
                        }
                        PlaylistMakeFragment.this.isShowAutoCompleteTag = false;
                        PlaylistMakeFragment.this.getAdapter().notifyItemChanged(1, 0);
                    }

                    @Override  // com.android.volley.Response$Listener
                    public void onResponse(Object object0) {
                        this.onResponse(((DjTagSearchAutoCompleteRes)object0));
                    }
                }).errorListener(new ErrorListener() {
                    @Override  // com.android.volley.Response$ErrorListener
                    public void onErrorResponse(VolleyError volleyError0) {
                        PlaylistMakeFragment.this.isShowAutoCompleteTag = false;
                        PlaylistMakeFragment.this.getAdapter().notifyItemChanged(1, 0);
                    }
                }).request();
            }
        }
    }

    private void showLoadPlaylistTempInfoPopup() {
        com.melon.ui.popup.b.v(this.getChildFragmentManager(), null, this.getString(0x7F130338), false, this.getString(0x7F130337), this.getString(0x7F130336), new G(this, 1), new G(this, 2));  // string:dj_playlist_make_popup_load_msg "임시 저장된 플레이리스트를\n불러오시겠습니까?"
    }

    private void showTempSavePopup() {
        com.melon.ui.popup.b.v(this.getChildFragmentManager(), null, "플레이리스트를 임시저장하시겠습니까?\n만들기 취소 시 플레이리스트는 임시저장되지 않습니다.", false, "만들기 취소", "임시저장", new G(this, 3), new G(this, 4));
    }

    public static ie.H t0(PlaylistMakeFragment playlistMakeFragment0) {
        return playlistMakeFragment0.lambda$onToolBarClick$5();
    }

    private void updateBasicInfoUi(PlaylistInformBaseRes playlistInformBaseRes0) {
        this.mBasicInfo.updateData(playlistInformBaseRes0);
        Context context0 = this.getContext();
        if(context0 != null && this.mIvCoverImage != null && !TextUtils.isEmpty(this.mBasicInfo.repntImg)) {
            Glide.with(context0).load(this.mBasicInfo.repntImg).into(this.mIvCoverImage);
        }
        this.getAdapter().notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void updateHeaderRatio(float f) {
        super.updateHeaderRatio(f);
        float f1 = this.getAlphaValue(f);
        this.mIvCamera.setAlpha(f1);
        this.mIvCoverImage.setAlpha(f1);
        this.mTitleBar.f(f > 0.0f);
    }

    private void updatePlaylist() {
        PlaylistAdapter playlistMakeFragment$PlaylistAdapter0 = (PlaylistAdapter)this.getAdapter();
        int v = playlistMakeFragment$PlaylistAdapter0.getCount();
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v1 = 0; v1 < v; ++v1) {
            SongInfoBase songInfoBase0 = (SongInfoBase)playlistMakeFragment$PlaylistAdapter0.getItem(v1);
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append(",");
            }
            stringBuilder0.append(songInfoBase0.songId);
        }
        com.iloen.melon.net.v4x.request.PlaylistUpdateBaseReq.Params playlistUpdateBaseReq$Params0 = new com.iloen.melon.net.v4x.request.PlaylistUpdateBaseReq.Params();
        playlistUpdateBaseReq$Params0.plylstSeq = this.mPlylstSeq;
        playlistUpdateBaseReq$Params0.plylstTypeCode = this.mPlylstType;
        playlistUpdateBaseReq$Params0.plylstTitle = String.valueOf(this.etInputTitle.getText());
        playlistUpdateBaseReq$Params0.introdCont = String.valueOf(this.etInputIntroduce.getText());
        playlistUpdateBaseReq$Params0.openYn = this.mBasicInfo.bOpenYn ? "Y" : "N";
        playlistUpdateBaseReq$Params0.repntImg = this.mBasicInfo.repntImg;
        playlistUpdateBaseReq$Params0.songIds = stringBuilder0.toString();
        RequestBuilder.newInstance(this.mPlaylistFactory.update(this.getContext(), playlistUpdateBaseReq$Params0)).tag("PlaylistMakeFragment").listener(new Listener() {
            public void onResponse(PlaylistUpdateBaseRes playlistUpdateBaseRes0) {
                if(playlistUpdateBaseRes0.isSuccessful()) {
                    if(!"M20001".equals(PlaylistMakeFragment.this.mPlylstType)) {
                        MelonDetailInfoUtils.saveDjPlaylistLatelyTags(PlaylistMakeFragment.this.mBasicInfo.getCurrentContentText());
                    }
                    PlaylistId playlistId0 = ((d3)PlaylistMakeFragment.this.playlistManager).j();
                    B b0 = ((d3)PlaylistMakeFragment.this.playlistManager).l();
                    b0.addListener(new u(0, b0, new t() {
                        @Override  // M6.t
                        public void onFailure(Throwable throwable0) {
                            LogU.d("PlaylistMakeFragment", "getDrawerPlaylist error: " + throwable0.getMessage());
                        }

                        @Override  // M6.t
                        public void onSuccess(Object object0) {
                            this.onSuccess(((nc.a)object0));
                        }

                        // 去混淆评级： 低(40)
                        public void onSuccess(nc.a a0) {
                        }
                    }), s.a);
                    String s = PlaylistMakeFragment.this.mPlaylistCacheCreator.getBasicInformCacheKey(PlaylistMakeFragment.this.mPlylstSeq);
                    a.c(PlaylistMakeFragment.this.getContext(), s, true);
                    PlaylistMakeFragment.this.clearTimeExpiredCache();
                    ToastManager.show(0x7F130832);  // string:playlist_modified "플레이리스트가 변경되었습니다."
                    PlaylistMakeFragment.this.navigateBack();
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((PlaylistUpdateBaseRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.show(0x7F1303DA);  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
            }
        }).request();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void updateSelectAllButton(boolean z) {
        if(!this.isFragmentValid()) {
            return;
        }
        ((PlaylistAdapter)this.getAdapter()).updateSelectAllButton(z);
    }

    public static ie.H v0(PlaylistMakeFragment playlistMakeFragment0) {
        return playlistMakeFragment0.lambda$showLoadPlaylistTempInfoPopup$3();
    }

    public static ie.H w0(PlaylistMakeFragment playlistMakeFragment0) {
        return playlistMakeFragment0.lambda$showLoadPlaylistTempInfoPopup$4();
    }
}

