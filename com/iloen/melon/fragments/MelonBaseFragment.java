package com.iloen.melon.fragments;

import A8.M;
import Dd.J;
import E9.w;
import G8.i;
import H0.e;
import Hb.l;
import Hb.p;
import Sd.a;
import Ub.v;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.f0;
import androidx.fragment.app.l0;
import androidx.media3.exoplayer.V;
import b3.Z;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.activity.FriendSelectActivity;
import com.iloen.melon.activity.PopupFragmentBaseActivity;
import com.iloen.melon.adapters.PopupTextListAdapter.OnAddPositionSetListener;
import com.iloen.melon.constants.CType;
import com.iloen.melon.constants.DownloadBuyType;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.custom.L0;
import com.iloen.melon.custom.P;
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.custom.U0;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.g1;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.database.core.LocalPlaylistDatabase_Impl;
import com.iloen.melon.eventbus.EventActivityState.EventActivityPaused;
import com.iloen.melon.eventbus.EventActivityState.EventActivityResumed;
import com.iloen.melon.eventbus.EventActivityState.EventActivityStarted;
import com.iloen.melon.eventbus.EventActivityState.EventActivityStopped;
import com.iloen.melon.eventbus.EventActivityState;
import com.iloen.melon.eventbus.EventAlertDialog;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPlaylist.EventAddSongIds;
import com.iloen.melon.eventbus.EventPopup.EventShowWifiSettingPopup;
import com.iloen.melon.fragments.detail.PlaylistMakeFragment;
import com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment;
import com.iloen.melon.fragments.tabs.BottomTabBaseFragment.BottomTabInnerBaseFragment;
import com.iloen.melon.fragments.tabs.BottomTabBaseFragment;
import com.iloen.melon.fragments.webview.MelonWebViewDefaultMiniPlayerFragment.BuyingGoodsFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.MelonError;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.AlbumSuggestedContentsReq;
import com.iloen.melon.net.v4x.request.ArtistRecomContsReq;
import com.iloen.melon.net.v4x.request.AuthMsgContentReq;
import com.iloen.melon.net.v4x.request.DownloadInformCheckReq.ClassCode;
import com.iloen.melon.net.v4x.request.MelonTvVdoStreamInAppReq;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistListReq;
import com.iloen.melon.net.v4x.response.AlbumSuggestedContentsRes.RESPONSE.RECMLIST;
import com.iloen.melon.net.v4x.response.AlbumSuggestedContentsRes;
import com.iloen.melon.net.v4x.response.ArtistRecomContsRes.RESPONSE.CONTSLIST;
import com.iloen.melon.net.v4x.response.ArtistRecomContsRes;
import com.iloen.melon.net.v4x.response.AuthMsgContentRes;
import com.iloen.melon.net.v4x.response.MelonTvVdoStreamInAppRes;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistListRes.RESPONSE.PLAYLISTLIST;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistListRes;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.response.CreatorInfoBase.ContsList;
import com.iloen.melon.net.v5x.response.CreatorInfoBase;
import com.iloen.melon.net.v6x.request.AlbumSongDownListReq;
import com.iloen.melon.net.v6x.request.MusicMessageShareInsertMusicMsgReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistDownloadListSongReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistInsertReq;
import com.iloen.melon.net.v6x.response.AlbumSongDownListRes.RESPONSE.CdInfo;
import com.iloen.melon.net.v6x.response.AlbumSongDownListRes.RESPONSE.SongInfo;
import com.iloen.melon.net.v6x.response.AlbumSongDownListRes.RESPONSE;
import com.iloen.melon.net.v6x.response.AlbumSongDownListRes;
import com.iloen.melon.net.v6x.response.MusicMessageInsertMusicMsgRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistDownloadListSongRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistInsertRes;
import com.iloen.melon.net.v6x.response.PlaylistListSongBaseRes.RESPONSE.SONGLIST;
import com.iloen.melon.playback.Playable.Builder;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.playback.playlist.add.AddAction.Add;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlayer;
import com.iloen.melon.playback.playlist.add.AddAction.VideoPlayAndOpen;
import com.iloen.melon.playback.playlist.add.AddPlayableList;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Album;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Artist;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.ChartTop100;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MV;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MixUp;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Playlist;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Station;
import com.iloen.melon.player.video.FloatingFragment;
import com.iloen.melon.popup.AddToPlaylistPopup.PopupClickListener;
import com.iloen.melon.popup.AddToPlaylistPopup;
import com.iloen.melon.popup.ConfigChangeable;
import com.iloen.melon.popup.DjPlaylistAddPopup;
import com.iloen.melon.popup.FanAnimationPopup;
import com.iloen.melon.popup.ForegroundPopup;
import com.iloen.melon.popup.LikeAnimationPopup;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.popup.NormalPlaylistAddPopup;
import com.iloen.melon.popup.PlaylistAddPopup;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.popup.RetainPopup;
import com.iloen.melon.popup.SingleFilterListPopup;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableBase;
import com.iloen.melon.sns.model.SharableSong;
import com.iloen.melon.sns.target.SnsManager.PostParam;
import com.iloen.melon.sns.target.SnsManager.SnsType;
import com.iloen.melon.sns.target.SnsPostListener;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.task.request.LikeUpdateAsyncTask;
import com.iloen.melon.task.request.TaskGetSongInfo.ResultListener;
import com.iloen.melon.task.request.TaskGetSongInfo;
import com.iloen.melon.types.ContextItemInfo.Params;
import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.Song;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.ContextListItemBuilder;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.NameValuePairList;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.SystemSettingUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.track.Event;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.K1;
import com.melon.ui.h3;
import com.melon.ui.k2;
import com.melon.ui.popup.context.more.k;
import e.b;
import eb.t;
import eb.u;
import ie.H;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.StringTokenizer;
import javax.inject.Inject;
import k8.K;
import k8.Y;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Dispatchers;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import p8.s;
import pc.P0;
import pc.w1;
import q8.c;
import t9.D;
import t9.F;
import v9.d;
import va.e0;
import vd.E;
import x8.f;
import xd.g;
import xd.h;
import zd.x0;

public class MelonBaseFragment extends Hilt_MelonBaseFragment implements a, FragmentStack, TabFragment, RetainPopup, h3, K {
    public static class ContsDownInfo {
        public String classCode;
        public String contsId;

    }

    public static class MyAlbumCacheInfo {
        protected String albumId;
        protected String albumTitle;
        protected String songCnt;

    }

    public interface OnArtistClickListener {
        void onAfterClick(String arg1, String arg2);

        void onBeforeClick(String arg1, String arg2);
    }

    public interface OnFlacArtistSelectListener {
        void onArtistSelect(String arg1);
    }

    public interface OnSNSLinkClickListener {
        void onLinkClick();
    }

    class PopupHandler extends U0 {
        public PopupHandler(MelonBaseFragment melonBaseFragment1) {
            super(melonBaseFragment1);
        }

        public void handleMessage(MelonBaseFragment melonBaseFragment0, Message message0) {
            LogU.d("MelonBaseFragment", "popupHandler - process:" + message0);
            switch(message0.what) {
                case 0: {
                    String s = (String)message0.obj;
                    if(TextUtils.isEmpty(s)) {
                        LogU.w("MelonBaseFragment", "handleMessage() WHAT_CREATE_PLAYLIST_AND_ADD_SONGS - invalid parameter");
                        return;
                    }
                    LogU.d("MelonBaseFragment", "handleMessage() WHAT_CREATE_PLAYLIST_AND_ADD_SONGS playlistName:" + s);
                    melonBaseFragment0.showProgress(true);
                    RequestBuilder.newInstance(MyMusicPlaylistInsertReq.newBuilder().plylstTitle(s).build(MelonBaseFragment.this.getContext())).tag("MelonBaseFragment").listener(new Listener() {
                        public void onResponse(MyMusicPlaylistInsertRes myMusicPlaylistInsertRes0) {
                            melonBaseFragment0.showProgress(false);
                            if(myMusicPlaylistInsertRes0.isSuccessful()) {
                                String s = myMusicPlaylistInsertRes0.response.plylstSeq;
                                com.iloen.melon.fragments.MelonBaseFragment.PopupHandler.2.1 melonBaseFragment$PopupHandler$2$10 = new Runnable() {
                                    @Override
                                    public void run() {
                                        ToastManager.show(0x7F130823);  // string:playlist_created "플레이리스트가 생성되었습니다."
                                    }
                                };
                                melonBaseFragment0.addAllToPlaylist(s, "M20001", s, melonBaseFragment$PopupHandler$2$10);
                                if(MelonBaseFragment.this.mPopupListener != null) {
                                    MelonBaseFragment.this.mPopupListener.onPopupProcResult(true);
                                }
                            }
                        }

                        @Override  // com.android.volley.Response$Listener
                        public void onResponse(Object object0) {
                            this.onResponse(((MyMusicPlaylistInsertRes)object0));
                        }
                    }).errorListener(new ErrorListener() {
                        @Override  // com.android.volley.Response$ErrorListener
                        public void onErrorResponse(VolleyError volleyError0) {
                            melonBaseFragment0.showProgress(false);
                            LogU.w("MelonBaseFragment", HttpResponse.getErrorMessage(volleyError0));
                            if(MelonBaseFragment.this.isFragmentValid()) {
                                String s = MelonBaseFragment.this.getString(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                                melonBaseFragment0.showErrorPopup(s, false);
                            }
                            if(MelonBaseFragment.this.mPopupListener != null) {
                                MelonBaseFragment.this.mPopupListener.onPopupProcResult(false);
                            }
                        }
                    }).request();
                    return;
                }
                case 1: {
                    MelonBaseFragment.y(melonBaseFragment0, "M20001");
                    return;
                }
                case 2: {
                    MelonBaseFragment.y(melonBaseFragment0, "M20002");
                    return;
                }
                case 4: {
                    if(message0.obj == null) {
                        LogU.w("MelonBaseFragment", "handleMessage() WHAT_SHOW_SELECTED_PLAYLIST_FOR_ADD_INTO - invalid playlistType");
                        return;
                    }
                    if(!melonBaseFragment0.isPossiblePopupShow()) {
                        return;
                    }
                    ArrayList arrayList0 = new ArrayList();
                    for(Object object0: melonBaseFragment0.getCachedAlbumList()) {
                        String s1 = String.valueOf(ProtocolUtils.parseInt(((MyAlbumCacheInfo)object0).songCnt, 0));
                        ContextItemInfo contextItemInfo0 = ContextItemInfo.a(new d(-1, ((MyAlbumCacheInfo)object0).albumTitle, s1));
                        Params contextItemInfo$Params0 = new Params();
                        contextItemInfo$Params0.a = ((MyAlbumCacheInfo)object0).albumId;
                        contextItemInfo0.b(contextItemInfo$Params0);
                        arrayList0.add(contextItemInfo0);
                    }
                    String s2 = (String)message0.obj;
                    AddToPlaylistPopup addToPlaylistPopup0 = new AddToPlaylistPopup(melonBaseFragment0.getActivity(), s2);
                    addToPlaylistPopup0.setTitle(MelonBaseFragment.this.getString(("M20001".equals(s2) ? 0x7F1300D3 : 0x7F1300CE)));  // string:alert_dlg_title_myalbum_add_song_sel "플레이리스트에 담기"
                    addToPlaylistPopup0.setPlayListTitle(null);
                    addToPlaylistPopup0.setListItems(arrayList0);
                    addToPlaylistPopup0.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override  // android.content.DialogInterface$OnCancelListener
                        public void onCancel(DialogInterface dialogInterface0) {
                            MelonBaseFragment.this.onCancelAddToPlaylist();
                        }
                    });
                    addToPlaylistPopup0.setOnPopupClickListener(new PopupClickListener() {
                        @Override  // com.iloen.melon.popup.AddToPlaylistPopup$PopupClickListener
                        public void onAddNewListEvent(String s, String s1) {
                            if(TextUtils.isEmpty(s)) {
                                MelonBaseFragment.this.showPlaylistEmptyAlertPopup(false);
                                return;
                            }
                            if("M20002".equals(s1) && MelonLimits.TextLimit.c.a(s) != 0) {
                                MelonBaseFragment.this.showPlaylistNameLimitAlertPopup(false);
                                return;
                            }
                            MelonBaseFragment.this.sendPopupMessage(0, s);
                        }

                        @Override  // com.iloen.melon.popup.AddToPlaylistPopup$PopupClickListener
                        public void onClickListItemEvent(int v, ContextItemInfo contextItemInfo0) {
                            melonBaseFragment0.addToPlaylist(contextItemInfo0.c.a, s2, ((d)contextItemInfo0.a).R);
                            melonBaseFragment0.showProgress(false);
                        }

                        @Override  // com.iloen.melon.popup.AddToPlaylistPopup$PopupClickListener
                        public void onMoveToDjPlaylistEvent() {
                            new f() {
                                @Override  // x8.f
                                public Object backgroundWork(Object object0, @NotNull Continuation continuation0) {
                                    return this.backgroundWork(((Void)object0), continuation0);
                                }

                                public Object backgroundWork(Void void0, @NotNull Continuation continuation0) {
                                    return MelonBaseFragment.this.onAddSongsToPlaylist(null, null);
                                }

                                @Override  // x8.f
                                public void postTask(Object object0) {
                                    this.postTask(((List)object0));
                                }

                                public void postTask(List list0) {
                                    super.postTask(list0);
                                    if(!MelonBaseFragment.this.isAdded() && list0 == null) {
                                        return;
                                    }
                                    ArrayList arrayList0 = new ArrayList();
                                    for(Object object0: list0) {
                                        arrayList0.add(((Song)object0).b);
                                    }
                                    Navigator.open(PlaylistMakeFragment.newInstance(null, "M20002", arrayList0, null, null));
                                }
                            }.execute(null);
                        }
                    });
                    melonBaseFragment0.mRetainDialog = addToPlaylistPopup0;
                    addToPlaylistPopup0.show();
                }
            }
        }

        @Override  // com.iloen.melon.custom.U0
        public void handleMessage(Object object0, Message message0) {
            this.handleMessage(((MelonBaseFragment)object0), message0);
        }
    }

    public interface PopupListener {
        void onPopupProcResult(boolean arg1);
    }

    static final class TaskAddToPlaylist extends f {
        private VolleyError error;
        private WeakReference fragment;
        private String playlistId;
        private String playlistName;
        private String playlistType;
        private List songs;

        private TaskAddToPlaylist() {
        }

        public TaskAddToPlaylist(int v) {
        }

        private void addToPlaylist(List list0, String s, String s1) {
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: list0) {
                Song song0 = (Song)object0;
                if(TextUtils.isEmpty(song0.b)) {
                    throw MelonError.fromClientMessage(("Empty SongId: " + song0));
                }
                stringBuilder0.append(song0.b);
                stringBuilder0.append(",");
            }
            if(stringBuilder0.length() == 0) {
                LogU.w("MelonBaseFragment", "addToPlaylist - not songs to be added");
                return;
            }
            if(stringBuilder0.length() > 0) {
                stringBuilder0.setLength(stringBuilder0.length() - 1);
            }
            RequestFuture requestFuture0 = RequestFuture.newFuture();
            com.iloen.melon.net.v6x.request.PlaylistAddSongBaseReq.Params playlistAddSongBaseReq$Params0 = new com.iloen.melon.net.v6x.request.PlaylistAddSongBaseReq.Params();
            playlistAddSongBaseReq$Params0.plylstSeq = s1;
            playlistAddSongBaseReq$Params0.plylstTypeCode = s;
            playlistAddSongBaseReq$Params0.songIds = stringBuilder0.toString();
            PlaylistDetailFactoryBase playlistDetailFactoryBase0 = PlaylistDetailFactoryBase.create(s);
            if(playlistDetailFactoryBase0 != null) {
                ResponseV4Res responseV4Res0 = (ResponseV4Res)RequestBuilder.newInstance(playlistDetailFactoryBase0.addSongList(MelonAppBase.instance.getContext(), playlistAddSongBaseReq$Params0)).tag("MelonBaseFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                if(!responseV4Res0.isSuccessful()) {
                    throw MelonError.from(responseV4Res0);
                }
            }
        }

        @Override  // x8.f
        public Object backgroundWork(Object object0, Continuation continuation0) {
            return this.backgroundWork(((Void)object0), continuation0);
        }

        public Object backgroundWork(Void void0, Continuation continuation0) {
            MelonBaseFragment melonBaseFragment0 = (MelonBaseFragment)this.fragment.get();
            if(melonBaseFragment0 != null && melonBaseFragment0.isAdded()) {
                try {
                    this.addToPlaylist(this.songs, this.playlistType, this.playlistId);
                    return null;
                }
                catch(VolleyError volleyError0) {
                    this.error = volleyError0;
                }
            }
            return null;
        }

        @Override  // x8.f
        public void postTask(Object object0) {
            this.postTask(((Void)object0));
        }

        public void postTask(Void void0) {
            Object object0 = this.fragment.get();
            if(((MelonBaseFragment)object0) != null && ((MelonBaseFragment)object0).isAdded()) {
                ((MelonBaseFragment)object0).showProgress(false);
                if(this.error != null) {
                    LogU.w("MelonBaseFragment", "TaskAddToPlaylist > onPostExecute() " + this.error);
                    return;
                }
                ArrayList arrayList0 = new ArrayList();
                for(Object object1: this.songs) {
                    arrayList0.add(((Song)object1).b);
                }
                EventBusHelper.post(new EventAddSongIds(this.playlistId, arrayList0));
                ((MelonBaseFragment)object0).onAddSongsToPlaylistComplete(this.playlistId, this.playlistType, this.playlistName, this.songs.size(), this.error);
            }
        }

        @Override  // x8.f
        public void preTask() {
            ((MelonBaseFragment)this.fragment.get()).showProgress(true);
        }

        public void setParams(MelonBaseFragment melonBaseFragment0, String s, String s1, String s2, List list0) {
            this.fragment = new WeakReference(melonBaseFragment0);
            this.playlistId = s;
            this.playlistType = s1;
            this.playlistName = s2;
            this.songs = list0;
        }
    }

    protected static final String ARG_BOTTOM_TABBAR_VISIBLE = "argBottomTabbarVisible";
    protected static final String ARG_CALLER = "argCaller";
    protected static final String ARG_DIRECT_OPEN_FRAGMENT = "argDirectOpenFragment";
    protected static final String ARG_DIRECT_OPEN_REPLY = "argDirectOpenReply";
    protected static final String ARG_FRAGMENT_TITLE = "argFragmentTitle";
    protected static final String ARG_HAS_PERSONALIZED_CONTENT = "argHasPersonalizedContent";
    protected static final String ARG_IS_FLAC = "argIsFlac";
    protected static final String ARG_IS_LOGIN_REQUIRED = "argIsLoginRequired";
    protected static final String ARG_LOGGING = "argLogging";
    protected static final String ARG_LOGIN_VIEW_MOVE_COUNT = "argLoginViewMoveCount";
    protected static final String ARG_MEMBER_KEY = "argMemberKey";
    protected static final String ARG_MEMBER_NICKNAME = "argMemberNickname";
    protected static final String ARG_MENU_ID = "argMenuId";
    protected static final String ARG_MINIPLAYER_VISIBLE = "argMiniplayerVisible";
    protected static final String ARG_PLAYBACK_MENU_ID = "argPlaybackMenuId";
    protected static final String ARG_REPLY_CHANNEL_SEQ = "argReplyChannelSeq";
    protected static final String ARG_REPLY_COMMENT_SEQ = "argReplyCommentSeq";
    protected static final String ARG_TABINFO = "argTabinfo";
    protected static final String ARG_VISIBLE_SNS_POPUP = "argVisibleSnsPopup";
    protected static final String ARG_VISIBLE_WHEN_ACTIVATE = "argVisibleWhenActivate";
    private static final boolean DEBUG = false;
    protected static final int REQUEST_CODE_FOR_FACEBOOK = 0xFACE;
    protected static final int RETAINED_DLG_LOCAL_PLAYLIST = 0;
    protected static final int RETAINED_DLG_MELON_PLAYLIST = 1;
    private static final String TAG = "MelonBaseFragment";
    public static final int WHAT_CREATE_PLAYLIST_AND_ADD_SONGS = 0;
    public static final int WHAT_SHOW_DJ_COLLECTION_TO_ADD_INTO = 2;
    public static final int WHAT_SHOW_PLAYLIST_TO_ADD_INTO = 1;
    public static final int WHAT_SHOW_SELECTED_PLAYLIST_FOR_ADD_INTO = 4;
    @Inject
    public k8.a blockingProgressDialogManage;
    private b exportLogDevActivityResult;
    private b exportLogUserActivityResult;
    protected boolean isFragmentVisible;
    protected boolean mBottomTabbarVisible;
    protected HashMap mCachedAlbumId;
    protected int mCaller;
    protected String mChannelSeq;
    protected String mCommentSeq;
    protected DialogInterface.OnDismissListener mDialogDismissListener;
    protected boolean mHasPersonalizedContent;
    private boolean mIsDirectOpenFragment;
    protected boolean mIsDirectOpenReply;
    protected boolean mIsFlac;
    private boolean mIsLoginRequired;
    private int mLocalPlaylistCount;
    protected String mLogging;
    private int mLoginViewMoveCount;
    protected s mMelonTiaraProperty;
    protected String mMenuId;
    protected boolean mMiniplayerVisible;
    protected String mPlaybackMenuId;
    private PopupHandler mPopupHandler;
    private PopupListener mPopupListener;
    protected String mPrevMenuId;
    private volatile int mProgressBarRefCount;
    protected ResponseBase mResponse;
    protected Dialog mRetainDialog;
    protected View mRootView;
    protected TabInfo mTabInfo;
    protected String mTitle;
    private TitleBar mTitleBar;
    private WeakReference mTitleBarRef;
    protected String mUserKey;
    protected String mUserNickname;
    protected boolean mVisibleSnsPopup;
    protected boolean mVisibleWhenActivate;
    @Inject
    public s2 playlistManager;
    private L0 progressUpdater;
    @Inject
    public Ub.s remotePlayerManager;
    @Inject
    public u screenCaptureUseCase;
    private b searchFriendActivityResult;
    @Inject
    public Ub.u vodRepeatManager;

    static {
        MelonBaseFragment.DEBUG = false;
    }

    public MelonBaseFragment() {
        this.isFragmentVisible = false;
        this.mTitleBar = null;
        this.mRetainDialog = null;
        this.mCachedAlbumId = new LinkedHashMap();
        this.mTitle = "";
        this.mIsFlac = false;
        this.mIsLoginRequired = false;
        this.mUserKey = null;
        this.mUserNickname = null;
        this.mVisibleWhenActivate = false;
        this.mVisibleSnsPopup = false;
        this.mBottomTabbarVisible = true;
        this.mMiniplayerVisible = true;
        this.mCaller = -1;
        this.mLogging = "";
        this.mPrevMenuId = "";
        this.mMenuId = "";
        this.mResponse = null;
        this.mPlaybackMenuId = "";
        this.mTabInfo = null;
        this.mMelonTiaraProperty = null;
        this.mPopupHandler = new PopupHandler(this, this);
        this.mDialogDismissListener = new DialogInterface.OnDismissListener() {
            @Override  // android.content.DialogInterface$OnDismissListener
            public void onDismiss(DialogInterface dialogInterface0) {
                if(dialogInterface0 != null && dialogInterface0.equals(MelonBaseFragment.this.mRetainDialog)) {
                    MelonBaseFragment.this.mRetainDialog = null;
                }
            }
        };
        this.searchFriendActivityResult = this.registerForActivityResult(new f0(2), new o(this, 0));
        this.exportLogUserActivityResult = this.registerForActivityResult(new f0(2), new o(this, 1));
        this.exportLogDevActivityResult = this.registerForActivityResult(new f0(2), new o(this, 2));
        this.mLocalPlaylistCount = 0;
    }

    public static boolean A() [...] // 潜在的解密器

    public final void addAllToPlaylist(String s, String s1, String s2, Runnable runnable0) {
        StringBuilder stringBuilder0 = A7.d.o("addAllToPlaylist() playlistId:", s, ", playlistType:", s1, ", playlistName:");
        stringBuilder0.append(s2);
        LogU.d("MelonBaseFragment", stringBuilder0.toString());
        this.showProgressDialog();
        new f() {
            @Override  // x8.f
            public Object backgroundWork(Object object0, Continuation continuation0) {
                return this.backgroundWork(((Void)object0), continuation0);
            }

            public Object backgroundWork(Void void0, Continuation continuation0) {
                return MelonBaseFragment.this.onAddSongsToPlaylist(s, s2);
            }

            @Override  // x8.f
            public void postTask(Object object0) {
                this.postTask(((List)object0));
            }

            public void postTask(List list0) {
                MelonBaseFragment.this.dismissProgressDialog();
                if(list0 != null && !list0.isEmpty()) {
                    ArrayList arrayList0 = new ArrayList();
                    for(Object object0: list0) {
                        Song song0 = (Song)object0;
                        if(!TextUtils.isEmpty(song0.b)) {
                            arrayList0.add(song0);
                        }
                    }
                    if(arrayList0.isEmpty()) {
                        ToastManager.show(0x7F13081B);  // string:playlist_added_only_melon_song_msg "플레이리스트에는 멜론곡만 담기 가능합니다."
                        return;
                    }
                    MelonBaseFragment.this.addToPlaylist(s, s1, s2, arrayList0);
                    return;
                }
                Runnable runnable0 = runnable0;
                if(runnable0 != null) {
                    runnable0.run();
                }
            }
        }.execute(null);
    }

    public void addCachedAlbumId(String s, String s1) {
        this.addCachedAlbumId(s, s, null);
    }

    public void addCachedAlbumId(String s, String s1, String s2) {
        if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1)) {
            if(s != null) {
                HashMap hashMap0 = this.mCachedAlbumId;
                synchronized(hashMap0) {
                    MyAlbumCacheInfo melonBaseFragment$MyAlbumCacheInfo0 = new MyAlbumCacheInfo();
                    melonBaseFragment$MyAlbumCacheInfo0.albumId = s;
                    melonBaseFragment$MyAlbumCacheInfo0.albumTitle = s1;
                    melonBaseFragment$MyAlbumCacheInfo0.songCnt = s2;
                    this.mCachedAlbumId.put(s, melonBaseFragment$MyAlbumCacheInfo0);
                }
                return;
            }
            return;
        }
        LogU.w("MelonBaseFragment", "addCachedAlbumId() - invalid parameter");
    }

    public final void addOrDeleteFriend(String s, String s1, boolean z, X8.a a0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "addOrDeleteFriend() invalid friend memberKey");
            return;
        }
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        StringBuilder stringBuilder0 = A7.d.o("addOrDeleteFriend() fMemberKey: ", s, ", menuId : ", s1, ", isMyFriend:");
        stringBuilder0.append(z);
        LogU.d("MelonBaseFragment", stringBuilder0.toString());
        X8.b b0 = new X8.b();  // 初始化器: Lx8/f;-><init>()V
        q.g(s, "fMemberKey");
        q.g(s1, "menuId");
        b0.b = s;
        b0.c = s1;
        b0.d = z;
        b0.a = a0;
        b0.execute(null);
    }

    public final void addToPlaylist(String s, String s1, String s2) {
        StringBuilder stringBuilder0 = A7.d.o("addToPlaylist() playlistId:", s, ", playlistType:", s1, ", playlistName:");
        stringBuilder0.append(s2);
        LogU.d("MelonBaseFragment", stringBuilder0.toString());
        this.showProgressDialog();
        new f() {
            @Override  // x8.f
            public Object backgroundWork(Object object0, Continuation continuation0) {
                return this.backgroundWork(((Void)object0), continuation0);
            }

            public Object backgroundWork(Void void0, Continuation continuation0) {
                return MelonBaseFragment.this.onAddSongsToPlaylist(s, s2);
            }

            @Override  // x8.f
            public void postTask(Object object0) {
                this.postTask(((List)object0));
            }

            public void postTask(List list0) {
                MelonBaseFragment.this.dismissProgressDialog();
                if(list0 != null && !list0.isEmpty()) {
                    ArrayList arrayList0 = new ArrayList();
                    for(Object object0: list0) {
                        Song song0 = (Song)object0;
                        if(!TextUtils.isEmpty(song0.b)) {
                            arrayList0.add(song0);
                        }
                    }
                    if(arrayList0.isEmpty()) {
                        ToastManager.show(0x7F13081B);  // string:playlist_added_only_melon_song_msg "플레이리스트에는 멜론곡만 담기 가능합니다."
                        return;
                    }
                    MelonBaseFragment.this.addToPlaylist(s, s1, s2, arrayList0);
                    return;
                }
                ToastManager.show(0x7F13081B);  // string:playlist_added_only_melon_song_msg "플레이리스트에는 멜론곡만 담기 가능합니다."
            }
        }.execute(null);
    }

    public final void addToPlaylist(String s, String s1, String s2, List list0) {
        Z.x(A7.d.o("addToPlaylist - plId:", s, ", plName:", s2, ", playlistType:"), s1, "MelonBaseFragment");
        if(list0 != null && !list0.isEmpty()) {
            TaskAddToPlaylist melonBaseFragment$TaskAddToPlaylist0 = new TaskAddToPlaylist(0);
            melonBaseFragment$TaskAddToPlaylist0.setParams(this, s, s1, s2, list0);
            melonBaseFragment$TaskAddToPlaylist0.execute(null);
            return;
        }
        LogU.d("MelonBaseFragment", "addToPlaylist - no songs to be added!");
    }

    // 去混淆评级： 低(20)
    public boolean canPlayPossibleAdultSong(int v, int v1, boolean z) {
        return v <= 0 || v1 > 0 && (!this.isLoginUser() || v1 != e1.u.E(((e0)va.o.a()).j())) ? z : true;
    }

    public boolean canPlayPossibleAdultSong(Playable playable0, boolean z) {
        if(playable0 == null) {
            LogU.w("MelonBaseFragment", "canPlayPossibleAdultSong() - invalid playable");
            return false;
        }
        return this.canPlayPossibleAdultSong(playable0.getIsservice(), playable0.getIsadult(), z);
    }

    public boolean checkLoginIfNeedToShowMsg() {
        if(!this.isLoginUser()) {
            ToastManager.showShort(0x7F1308D1);  // string:retry_after_login "로그인 후 이용해 주세요."
            return false;
        }
        return true;
    }

    public void dismissProgressDialog() {
        if(this.isFragmentValid()) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(fragmentActivity0 instanceof BaseActivity) {
                ((BaseActivity)fragmentActivity0).dismissMelonProgressDialog();
            }
        }
    }

    @Override  // com.iloen.melon.popup.RetainPopup
    public void dismissRetainedPopup() {
        if(this.isFragmentValid() && this.isRetainedPopupShowing()) {
            this.mRetainDialog.dismiss();
        }
    }

    public boolean downloadAlbum(String s, String s1) {
        if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1)) {
            LogU.d("MelonBaseFragment", "downloadAlbum() albumId: " + s + " menuId:" + s1);
            if(!this.isLoginUser()) {
                this.showLoginPopup();
                return false;
            }
            this.showProgress(true);
            RequestBuilder.newInstance(new AlbumSongDownListReq(this.getContext(), s)).tag("MelonBaseFragment").listener(new Listener() {
                public void onResponse(AlbumSongDownListRes albumSongDownListRes0) {
                    MelonBaseFragment.this.showProgress(false);
                    if(albumSongDownListRes0.isSuccessful()) {
                        RESPONSE albumSongDownListRes$RESPONSE0 = albumSongDownListRes0.response;
                        if(albumSongDownListRes$RESPONSE0 != null) {
                            ArrayList arrayList0 = albumSongDownListRes$RESPONSE0.cdList;
                            if(arrayList0 != null && arrayList0.size() > 0) {
                                ArrayList arrayList1 = new ArrayList();
                                for(Object object0: arrayList0) {
                                    ArrayList arrayList2 = ((CdInfo)object0).songList;
                                    if(arrayList2 != null && arrayList2.size() != 0) {
                                        for(Object object1: arrayList2) {
                                            arrayList1.add(Playable.from(((SongInfo)object1), s1, null));
                                        }
                                    }
                                }
                                MelonBaseFragment.this.downloadSongs(s1, arrayList1);
                            }
                        }
                    }
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((AlbumSongDownListRes)object0));
                }
            }).errorListener(new ErrorListener() {
                @Override  // com.android.volley.Response$ErrorListener
                public void onErrorResponse(VolleyError volleyError0) {
                    MelonBaseFragment.this.showProgress(false);
                    EventBusHelper.post(EventAlertDialog.fromNetworkError(HttpResponse.getErrorMessage(volleyError0)));
                }
            }).request();
            return true;
        }
        LogU.w("MelonBaseFragment", "downloadAlbum() - invalid parameter");
        return false;
    }

    private boolean downloadAlbumUnit(NameValuePairList nameValuePairList0) {
        if(nameValuePairList0 != null && nameValuePairList0.size() != 0) {
            LogU.d("MelonBaseFragment", "downloadAlbumUnit()");
            return this.downloadUrl(null, M.w, nameValuePairList0);
        }
        LogU.w("MelonBaseFragment", "downloadAlbumUnit() - invalid parameter");
        return false;
    }

    public boolean downloadAlbumUnit(String s, String s1) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "downloadAlbumUnit() invalid menuId");
            return false;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("MelonBaseFragment", "downloadAlbumUnit() invalid albumId");
            return false;
        }
        LogU.d("MelonBaseFragment", "downloadAlbumUnit() albumId: " + s1 + " menuId:" + s);
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return false;
        }
        return this.downloadAlbumUnit(this.getNameValuePairsAlbumUrl(s, s1, false, null, true));
    }

    public boolean downloadFlacAlbumUnit(String s, String s1, String s2, boolean z) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "downloadFlacAlbumUnit() invalid menuId");
            return false;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("MelonBaseFragment", "downloadFlacAlbumUnit() invalid albumId");
            return false;
        }
        StringBuilder stringBuilder0 = A7.d.o("downloadFlacAlbumUnit() albumId: ", s1, ", menuId:", s, ", flacCode:");
        stringBuilder0.append(s2);
        stringBuilder0.append(", isAlbumOnly:");
        stringBuilder0.append(z);
        LogU.d("MelonBaseFragment", stringBuilder0.toString());
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return false;
        }
        return this.downloadAlbumUnit(this.getNameValuePairsAlbumUrl(s, s1, true, s2, z));
    }

    public boolean downloadFlacSongs(String s, String s1, List list0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "downloadFlacSongs() invalid menuId");
            return false;
        }
        if(list0 == null || list0.isEmpty()) {
            LogU.w("MelonBaseFragment", "downloadFlacSongs() invalid playables");
            return false;
        }
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            Playable playable0 = (Playable)object0;
            if(playable0.isOriginMelon()) {
                arrayList0.add(playable0);
            }
        }
        if(arrayList0.isEmpty()) {
            l0 l00 = this.getChildFragmentManager();
            String s2 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
            String s3 = this.getString(0x7F1300C4);  // string:alert_dlg_is_melon_service_song "멜론 서비스 곡이 아닙니다."
            com.melon.ui.popup.b.a.c(l00, s2, s3);
            return false;
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object1: arrayList0) {
            arrayList1.add(((Playable)object1).getSongidString());
        }
        return this.downloadSongs(this.getNameValuePairsSongUrl(s, arrayList1, null, DownloadBuyType.e, false, true, s1));
    }

    public void downloadMv(String s, Playable playable0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "downloadMv() invalid menuId");
            return;
        }
        if(playable0 == null) {
            LogU.w("MelonBaseFragment", "downloadMv() invalid playable");
            return;
        }
        this.downloadMv(s, "");
    }

    public void downloadMv(String s, String s1) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "downloadMv() invalid menuId");
            return;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("MelonBaseFragment", "downloadMv() invalid mvId");
            return;
        }
        this.downloadUrl(this.getDownloadMvUrl(s, s1));
    }

    public void downloadPlaylist(String s, String s1) {
        if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1)) {
            LogU.d("MelonBaseFragment", "downloadPlaylist() playlistId: " + s + " menuId:" + s1);
            this.showProgress(true);
            RequestBuilder.newInstance(new MyMusicPlaylistDownloadListSongReq(MelonAppBase.instance.getContext(), s)).tag("MelonBaseFragment").listener(new Listener() {
                public void onResponse(MyMusicPlaylistDownloadListSongRes myMusicPlaylistDownloadListSongRes0) {
                    MelonBaseFragment.this.showProgress(false);
                    if(myMusicPlaylistDownloadListSongRes0.isSuccessful()) {
                        com.iloen.melon.net.v6x.response.PlaylistListSongBaseRes.RESPONSE playlistListSongBaseRes$RESPONSE0 = myMusicPlaylistDownloadListSongRes0.response;
                        if(playlistListSongBaseRes$RESPONSE0 != null) {
                            ArrayList arrayList0 = playlistListSongBaseRes$RESPONSE0.songList;
                            if(arrayList0 != null && arrayList0.size() > 0) {
                                ArrayList arrayList1 = new ArrayList();
                                for(Object object0: arrayList0) {
                                    arrayList1.add(Playable.from(((SONGLIST)object0), s1, playlistListSongBaseRes$RESPONSE0.statsElements));
                                }
                                MelonBaseFragment.this.downloadSongs(s1, arrayList1);
                            }
                        }
                    }
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((MyMusicPlaylistDownloadListSongRes)object0));
                }
            }).errorListener(new ErrorListener() {
                @Override  // com.android.volley.Response$ErrorListener
                public void onErrorResponse(VolleyError volleyError0) {
                    MelonBaseFragment.this.showProgress(false);
                    EventBusHelper.post(EventAlertDialog.fromNetworkError(HttpResponse.getErrorMessage(volleyError0)));
                }
            }).request();
            return;
        }
        LogU.w("MelonBaseFragment", "downloadPlaylist() - invalid parameter");
    }

    public boolean downloadSong(String s, Playable playable0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "downloadSong() invalid menuId");
            return false;
        }
        if(playable0 == null) {
            LogU.w("MelonBaseFragment", "downloadSong() invalid playable");
            return false;
        }
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(playable0);
        return this.downloadSongs(s, arrayList0);
    }

    private boolean downloadSongs(NameValuePairList nameValuePairList0) {
        if(nameValuePairList0 != null && nameValuePairList0.size() != 0) {
            LogU.d("MelonBaseFragment", "downloadSongs()");
            return this.downloadUrl(null, M.v, nameValuePairList0);
        }
        LogU.w("MelonBaseFragment", "downloadSongs() - invalid parameter");
        return false;
    }

    public boolean downloadSongs(String s, List list0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "downloadSongs() invalid menuId");
            return false;
        }
        if(list0 == null || list0.isEmpty()) {
            LogU.w("MelonBaseFragment", "downloadSongs() invalid playables");
            return false;
        }
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            Playable playable0 = (Playable)object0;
            if(playable0.isOriginMelon()) {
                arrayList0.add(playable0);
            }
        }
        if(arrayList0.isEmpty()) {
            l0 l00 = this.getChildFragmentManager();
            String s1 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
            String s2 = this.getString(0x7F1300C4);  // string:alert_dlg_is_melon_service_song "멜론 서비스 곡이 아닙니다."
            com.melon.ui.popup.b.a.c(l00, s1, s2);
            return false;
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object1: arrayList0) {
            arrayList1.add(((Playable)object1).getSongidString());
        }
        return this.downloadSongs(this.getNameValuePairsSongUrl(s, arrayList1, null, DownloadBuyType.b, false, false, null));
    }

    public boolean downloadSongs(String s, List list0, DownloadBuyType downloadBuyType0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "downloadSongs() invalid menuId");
            return false;
        }
        if(list0 == null || list0.size() == 0) {
            LogU.w("MelonBaseFragment", "downloadSongs() invalid list");
            return false;
        }
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: list0) {
            arrayList0.add(((ContsDownInfo)object0).contsId);
            arrayList1.add(ClassCode.getName(((ContsDownInfo)object0).classCode));
        }
        return this.downloadSongs(this.getNameValuePairsSongUrl(s, arrayList0, arrayList1, downloadBuyType0, false, false, null));
    }

    public void downloadUrl(String s) {
        LogU.d("MelonBaseFragment", "downloadUrl() url:" + s);
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        Navigator.openUrlFullScreenView(s);
    }

    public boolean downloadUrl(String s, String s1, NameValuePairList nameValuePairList0) {
        LogU.d("MelonBaseFragment", "downloadUrl() title: " + s + ", url:" + s1);
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return false;
        }
        new Handler(Looper.getMainLooper()).post(new m(s, s1, nameValuePairList0, 0));
        return true;
    }

    @Override  // com.iloen.melon.fragments.FragmentStack
    public boolean excludingTagArguments() {
        return false;
    }

    private void executeFacebookPosting(Sharable sharable0) {
        SnsManager.PostParam snsManager$PostParam0 = new SnsManager.PostParam();
        snsManager$PostParam0.a = SnsManager.SnsType.a;
        snsManager$PostParam0.c = sharable0;
        snsManager$PostParam0.b = this.getActivity();
        com.iloen.melon.fragments.MelonBaseFragment.28 melonBaseFragment$280 = new SnsPostListener() {
            @Override  // com.iloen.melon.sns.target.SnsPostListener
            public void onError(String s, Sharable sharable0, Object object0) {
                ToastManager.show(0x7F13106B);  // string:toast_message_facebook_send_fail "페이스북 공유에 실패하였습니다."
            }

            @Override  // com.iloen.melon.sns.target.SnsPostListener
            public void onSuccess(String s, Sharable sharable0) {
            }
        };
        F.a.getClass();
        F.a.B(snsManager$PostParam0.a).a(snsManager$PostParam0, melonBaseFragment$280);
    }

    public void executeFacebookStoryPosting(Sharable sharable0) {
        this.shareSnsAppToApp(sharable0, SnsManager.SnsType.b);
    }

    public void executeTwitterPosting(Sharable sharable0) {
        SnsManager.PostParam snsManager$PostParam0 = new SnsManager.PostParam();
        snsManager$PostParam0.a = SnsManager.SnsType.c;
        snsManager$PostParam0.c = sharable0;
        snsManager$PostParam0.b = this.getActivity();
        com.iloen.melon.fragments.MelonBaseFragment.27 melonBaseFragment$270 = new SnsPostListener() {
            @Override  // com.iloen.melon.sns.target.SnsPostListener
            public void onError(String s, Sharable sharable0, Object object0) {
                ToastManager.show(0x7F13106F);  // string:toast_message_twitter_send_fail "X 공유에 실패하였습니다."
            }

            @Override  // com.iloen.melon.sns.target.SnsPostListener
            public void onSuccess(String s, Sharable sharable0) {
            }
        };
        F.a.getClass();
        F.a.B(snsManager$PostParam0.a).a(snsManager$PostParam0, melonBaseFragment$270);
    }

    public void exportAppLogFile4Dev() {
        this.exportLogDevActivityResult.b(l.a(p.a));
    }

    public void exportAppLogFile4User() {
        this.exportLogUserActivityResult.b(l.a(p.b));
    }

    private void fetchAndSelectPlaylist(int v, String s) {
        new Handler(Looper.getMainLooper()).postDelayed(new V(this, v, s, 4), 500L);
    }

    private void fetchAndSelectPlaylistProc(int v, String s) {
        LogU.d("MelonBaseFragment", "fetchAndSelectPlaylist - nextWhat:" + v + ", playlistType:" + s);
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        if(!this.isMemberKeyValid()) {
            this.showLoginPopup();
            return;
        }
        this.mCachedAlbumId.clear();
        com.iloen.melon.net.v4x.request.PlaylistListBaseReq.Params playlistListBaseReq$Params0 = new com.iloen.melon.net.v4x.request.PlaylistListBaseReq.Params();
        playlistListBaseReq$Params0.startIndex = 1;
        playlistListBaseReq$Params0.pageSize = 100;
        playlistListBaseReq$Params0.targetMemberKey = e1.u.v(((e0)va.o.a()).j());
        playlistListBaseReq$Params0.plylstTypeCode = s;
        playlistListBaseReq$Params0.mode = "all";
        this.showProgress(true);
        RequestBuilder.newInstance(new MyMusicPlaylistListReq(this.getContext(), playlistListBaseReq$Params0)).tag("MelonBaseFragment").listener(new Listener() {
            public void onResponse(MyMusicPlaylistListRes myMusicPlaylistListRes0) {
                MelonBaseFragment.this.showProgress(false);
                if(myMusicPlaylistListRes0.isSuccessful()) {
                    ArrayList arrayList0 = myMusicPlaylistListRes0.response.playlistlist;
                    if(arrayList0 != null && arrayList0.size() > 0) {
                        MelonBaseFragment.this.mCachedAlbumId.clear();
                        for(Object object0: arrayList0) {
                            MelonBaseFragment.this.addCachedAlbumId(((PLAYLISTLIST)object0).plylstseq, ((PLAYLISTLIST)object0).plylsttitle, ((PLAYLISTLIST)object0).songcnt);
                        }
                    }
                    MelonBaseFragment.this.sendPopupMessage(v, s);
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicPlaylistListRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                MelonBaseFragment.this.showProgress(false);
                LogU.w("MelonBaseFragment", HttpResponse.getErrorMessage(volleyError0));
                if(MelonBaseFragment.this.isFragmentValid()) {
                    String s = MelonBaseFragment.this.getString(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                    MelonBaseFragment.this.showErrorPopup(s, false);
                }
            }
        }).request();
    }

    public View findViewById(int v) {
        return this.mRootView == null ? null : this.mRootView.findViewById(v);
    }

    @Override  // com.iloen.melon.fragments.CacheTag
    public String getCacheKey() [...] // 潜在的解密器

    public List getCachedAlbumList() {
        List list0 = new ArrayList();
        Iterator iterator0 = this.mCachedAlbumId.keySet().iterator();
        while(iterator0.hasNext()) {
            HashMap hashMap0 = this.mCachedAlbumId;
            Object object0 = iterator0.next();
            ((ArrayList)list0).add(((MyAlbumCacheInfo)hashMap0.get(object0)));
        }
        return list0;
    }

    public BottomTabBaseFragment getCurrentTabContainerFragment() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        return fragmentActivity0 instanceof com.iloen.melon.custom.V ? ((com.iloen.melon.custom.V)fragmentActivity0).getCurrentTabContainerFragment() : null;
    }

    public DialogInterface.OnDismissListener getDialogDismissListener() {
        return this.mDialogDismissListener;
    }

    public String getDownloadMvUrl(String s, String s1) {
        StringBuilder stringBuilder0 = new StringBuilder();
        A7.d.u(stringBuilder0, M.y, "?mvId=", s1, "&menuId=");
        stringBuilder0.append(s);
        return stringBuilder0.toString();
    }

    public int getFragmentHeight() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        return fragmentActivity0 == null || fragmentActivity0.findViewById(0x7F0A04DB) == null ? 0 : fragmentActivity0.findViewById(0x7F0A04DB).getMeasuredHeight();  // id:fragment
    }

    @Override  // com.iloen.melon.fragments.FragmentStack
    public String getFragmentTag() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.getClass().getSimpleName());
        if(!this.excludingTagArguments()) {
            Bundle bundle0 = this.getArguments();
            if(bundle0 != null && !bundle0.isEmpty()) {
                stringBuilder0.append("?");
                stringBuilder0.append(bundle0);
            }
        }
        return stringBuilder0.toString();
    }

    public f1 getInsetHandlingType() {
        return f1.a;
    }

    public String getMenuId() {
        return this.mMenuId;
    }

    private NameValuePairList getNameValuePairsAlbumUrl(String s, String s1, boolean z, String s2, boolean z1) {
        NameValuePairList nameValuePairList0 = new NameValuePairList();
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "getNameValuePairsAlbumUrl() invalid menuId");
            return nameValuePairList0;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("MelonBaseFragment", "getNameValuePairsAlbumUrl() invalid albumId");
            return nameValuePairList0;
        }
        if(z) {
            if(TextUtils.isEmpty(s2)) {
                s2 = "";
            }
            nameValuePairList0.add("FLAC_CODE", s2);
        }
        if(z1) {
            nameValuePairList0.add("albumOnlyFlg", "1");
        }
        else {
            nameValuePairList0.add("albumOnlyFlg", "0");
        }
        nameValuePairList0.add("formName", "streamForm");
        nameValuePairList0.add("albumId", s1);
        nameValuePairList0.add("contsType", "3B0001");
        nameValuePairList0.add("paramsName", "albumId");
        nameValuePairList0.add("buyType", "0");
        nameValuePairList0.add("menuId", s);
        nameValuePairList0.add("retUrl", "fromApp");
        return nameValuePairList0;
    }

    private NameValuePairList getNameValuePairsSongUrl(String s, List list0, List list1, DownloadBuyType downloadBuyType0, boolean z, boolean z1, String s1) {
        NameValuePairList nameValuePairList0 = new NameValuePairList();
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "getNameValuePairsSongUrl() invalid menuId");
            return nameValuePairList0;
        }
        if(list0 != null && list0.size() != 0) {
            nameValuePairList0.add("contsType", (z ? "3C0003" : "3C0001"));
            nameValuePairList0.add("formName", "streamForm");
            nameValuePairList0.add("menuId", s);
            if(!TextUtils.isEmpty(downloadBuyType0.a)) {
                nameValuePairList0.add("buyType", downloadBuyType0.a);
            }
            nameValuePairList0.add("paramsName", "contsId");
            if(z1) {
                if(TextUtils.isEmpty(s1)) {
                    s1 = "";
                }
                nameValuePairList0.add("FLAC_CODE", s1);
            }
            for(Object object0: list0) {
                nameValuePairList0.add("contsId", ((String)object0));
            }
            if(list1 != null) {
                for(Object object1: list1) {
                    nameValuePairList0.add("usedDrmFlg", ((String)object1));
                }
            }
            return nameValuePairList0;
        }
        LogU.w("MelonBaseFragment", "getNameValuePairsSongUrl() invalid songId");
        return nameValuePairList0;
    }

    @Deprecated
    public Activity getParentActivity() {
        Activity activity0 = this.getActivity();
        if(activity0 != null) {
            Activity activity1 = activity0.getParent();
            return activity1 == null ? activity0 : activity1;
        }
        return null;
    }

    public BottomTabBaseFragment getParentTabContainerFragment() {
        I i0;
        for(i0 = this; !(i0 instanceof P) && i0 != null; i0 = i0.getParentFragment()) {
        }
        return i0 == null ? null : ((P)i0).getBottomTabContainer();
    }

    @Override  // com.iloen.melon.popup.RetainPopup
    public Dialog getRetainedDialog() {
        return this.mRetainDialog;
    }

    public Sharable getSNSSharable() {
        return null;
    }

    @Override  // com.iloen.melon.fragments.TabFragment
    public TabInfo getTabInfo() {
        return this.mTabInfo;
    }

    public s getTiaraProperty() {
        return this.mMelonTiaraProperty;
    }

    public TitleBar getTitleBar() {
        return this.mTitleBarRef == null ? null : ((TitleBar)this.mTitleBarRef.get());
    }

    public int getTitleBarHeight() {
        TitleBar titleBar0 = this.getTitleBar();
        return titleBar0 == null ? 0 : titleBar0.getHeight();
    }

    private void hideAllProgress() {
        while(this.mProgressBarRefCount > 0) {
            this.showProgress(false);
        }
    }

    public void hideMiniPlayer(boolean z) {
        LogU.v("MelonBaseFragment", "hideMiniPlayer()");
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 instanceof com.iloen.melon.custom.V) {
            ((com.iloen.melon.custom.V)fragmentActivity0).setTabAndMiniPlayerVisible(false, z, false);
        }
    }

    public void hideMiniPlayerForToolBar() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 instanceof com.iloen.melon.custom.V) {
            ((com.iloen.melon.custom.V)fragmentActivity0).setTabAndMiniPlayerVisible(false, true, true);
        }
    }

    public boolean ignoreUpdateVideoScreen() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.FragmentStack
    public boolean isAppEntryPointFragment() {
        return false;
    }

    private boolean isBottomTabContainerVisible() {
        return this.getParentTabContainerFragment() == this.getCurrentTabContainerFragment();
    }

    public boolean isBottomTabFragment() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.FragmentStack
    public boolean isBringToFrontFragment() {
        return false;
    }

    public boolean isFragmentValid() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        return fragmentActivity0 != null && !fragmentActivity0.isFinishing() && this.isAdded();
    }

    public final boolean isFullyCoveredByFloatingFragment() {
        if(this.getParentFragment() instanceof FloatingFragment) {
            return false;
        }
        FragmentActivity fragmentActivity0 = this.getActivity();
        MusicBrowserActivity musicBrowserActivity0 = fragmentActivity0 instanceof MusicBrowserActivity ? ((MusicBrowserActivity)fragmentActivity0) : null;
        return musicBrowserActivity0 != null && musicBrowserActivity0.isFullyCoveredByFloatingFragment();
    }

    public boolean isGenreExclude() {
        return false;
    }

    public final boolean isLeafFragment() [...] // 潜在的解密器

    private boolean isLockScreenFragment() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        return fragmentActivity0 instanceof r8.b && ((r8.b)fragmentActivity0).isLockScreen();
    }

    public boolean isLoginUser() {
        return ((e0)va.o.a()).m();
    }

    public boolean isMemberKeyValid() {
        return e1.u.o(e1.u.v(((e0)va.o.a()).j()));
    }

    // 去混淆评级： 低(20)
    public boolean isNeedToLoginInLoginRequiredFragment() {
        return this.mIsLoginRequired && !this.isLoginUser();
    }

    @Override  // com.iloen.melon.fragments.FragmentStack
    public boolean isPlayerFragment() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.FragmentStack
    public boolean isPlaylistFragment() {
        return false;
    }

    public boolean isPossiblePopupShow() {
        if(this.isFragmentValid() && !this.isRetainedPopupShowing()) {
            return true;
        }
        LogU.v("MelonBaseFragment", "isPossiblePopupShow() popup can not be show");
        return false;
    }

    public boolean isProgressDialogShowing() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        return fragmentActivity0 instanceof BaseActivity ? ((BaseActivity)fragmentActivity0).isMelonProgressDialogShowing() : false;
    }

    public boolean isProgressShowing() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 instanceof BaseActivity) {
            return ((BaseActivity)fragmentActivity0).isProgressShowing();
        }
        return fragmentActivity0 instanceof PopupFragmentBaseActivity ? ((PopupFragmentBaseActivity)fragmentActivity0).isProgressShowing() : false;
    }

    @Override  // com.iloen.melon.popup.RetainPopup
    public boolean isRetainedPopupShowing() {
        if(this.mRetainDialog != null && this.mRetainDialog.isShowing()) {
            if(MelonBaseFragment.DEBUG) {
                LogU.v("MelonBaseFragment", "isRetainedPopupShowing() showing...");
            }
            return true;
        }
        return false;
    }

    public boolean isScreenLandscapeSupported() {
        return true;
    }

    @Override  // k8.K
    public boolean isShowMiniPlayer() {
        return this.shouldShowMiniPlayer();
    }

    @Override  // com.iloen.melon.fragments.FragmentStack
    public boolean isTopLevelFragment() {
        return false;
    }

    private static void lambda$downloadUrl$6(String s, String s1, NameValuePairList nameValuePairList0) {
        Navigator.openUrl(s, s1, OpenType.FullScreen, nameValuePairList0);
    }

    private void lambda$fetchAndSelectPlaylist$9(int v, String s) {
        this.fetchAndSelectPlaylistProc(v, s);
    }

    private void lambda$new$0(ActivityResult activityResult0) {
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                this.sendMusicMessage(intent0.getParcelableArrayListExtra("argSearchResultValues"), ((Sharable)intent0.getParcelableExtra("argAttachedSharable")));
            }
        }
    }

    private void lambda$new$1(ActivityResult activityResult0) {
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                Uri uri0 = intent0.getData();
                Context context0 = this.getContext();
                if(uri0 != null && context0 != null) {
                    l.b(context0, uri0, p.b);
                }
            }
        }
    }

    private void lambda$new$2(ActivityResult activityResult0) {
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                Uri uri0 = intent0.getData();
                Context context0 = this.getContext();
                if(uri0 != null && context0 != null) {
                    l.b(context0, uri0, p.a);
                }
            }
        }
    }

    private void lambda$onExecuteDirectOpenFragment$5() {
        if(this.isFragmentValid()) {
            this.onDirectOpenFragment();
        }
    }

    private void lambda$onResume$3() {
        if(!this.isFragmentValid()) {
            return;
        }
        if(this.mLoginViewMoveCount > 0) {
            this.performBackPress();
            return;
        }
        this.openLoginView(r8.f.f);
        ++this.mLoginViewMoveCount;
    }

    private static void lambda$openPresentSendPage$4(ArrayList arrayList0, ArrayList arrayList1, ArrayList arrayList2) {
        Navigator.openPresentSongSendFragment(((Playable)arrayList0.get(0)).getMenuid(), arrayList1, arrayList2);
    }

    private H lambda$showMultiArtistPopup$7(h h0) {
        if(h0 instanceof g) {
            this.showArtistInfoPage(((g)h0).b);
        }
        return null;
    }

    private H lambda$showMultiCreatorPopup$8(String s, h h0) {
        if(h0 instanceof g) {
            String s1 = ((g)h0).b;
            if(!TextUtils.isEmpty(s1)) {
                if("N10006".equals(s)) {
                    this.showArtistInfoPage(s1);
                    return null;
                }
                if("N10018".equals(s) || "N10080".equals(s)) {
                    this.showUserInfoPage(s1);
                }
            }
        }
        return null;
    }

    public String makePlayListTitle() [...] // Inlined contents

    public final void notifyContentChange(Uri uri0) {
        LogU.d("MelonBaseFragment", "notifyContentChange: " + uri0);
        Context context0 = this.getContext();
        if(context0 != null && uri0 != null) {
            context0.getContentResolver().notifyChange(uri0, null);
        }
    }

    public void onAddSongsToLocalPlaylist(String s) {
    }

    public void onAddSongsToLocalPlaylist(String s, Playable playable0) {
    }

    public List onAddSongsToPlaylist(String s, String s1) {
        return null;
    }

    public void onAddSongsToPlaylistComplete(String s, String s1, String s2, int v, VolleyError volleyError0) {
    }

    public void onAddToDJCollection(Object object0) {
        this.sendPopupMessage(2, object0);
    }

    public void onAddToNowPlayingList(Object object0) {
    }

    public void onAddToPlaylist(Object object0) {
        this.sendPopupMessage(1, object0);
    }

    public void onAfterHandlePopupMessage(Message message0) {
    }

    public boolean onBackPressed() {
        return false;
    }

    public boolean onBeforeHandlePopupMessage(Message message0) [...] // Inlined contents

    public void onCancelAddToPlaylist() {
    }

    public void onCancelAddToToLocalPlaylist() {
    }

    @Override  // androidx.fragment.app.I
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        if(this.mRetainDialog instanceof SingleFilterListPopup && this.mRetainDialog.isShowing()) {
            this.mRetainDialog.dismiss();
            return;
        }
        if(this.mRetainDialog instanceof ConfigChangeable && this.mRetainDialog.isShowing()) {
            ((ConfigChangeable)this.mRetainDialog).onConfigurationChanged();
        }
    }

    @Override  // androidx.fragment.app.I
    public void onCreate(Bundle bundle0) {
        if(MelonBaseFragment.DEBUG) {
            LogU.v("MelonBaseFragment", "onCreate() " + this + ", savedInstanceState: " + bundle0);
        }
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        this.restoreInstanceState(bundle0);
        this.progressUpdater = e.G(this);
    }

    @Override  // androidx.fragment.app.I
    public void onDestroy() {
        if(MelonBaseFragment.DEBUG) {
            LogU.v("MelonBaseFragment", "onDestroy() " + this);
        }
        super.onDestroy();
    }

    @Override  // androidx.fragment.app.I
    public void onDestroyView() {
        if(MelonBaseFragment.DEBUG) {
            LogU.v("MelonBaseFragment", "onDestroyView() " + this);
        }
        I i0 = this.getParentFragment();
        if(i0 instanceof IPagerFragment && !((IPagerFragment)i0).isUseLoopViewPager()) {
            this.isFragmentVisible = false;
        }
        if(this.mRootView != null) {
            this.mRootView = null;
        }
        super.onDestroyView();
    }

    public void onDirectOpenFragment() {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventActivityState eventActivityState0) {
        if(eventActivityState0 instanceof EventActivityStarted) {
            LogU.v("MelonBaseFragment", "EventActivityState.EventActivityStarted");
            return;
        }
        if(eventActivityState0 instanceof EventActivityResumed) {
            LogU.v("MelonBaseFragment", "EventActivityState.EventActivityResumed");
            return;
        }
        if(eventActivityState0 instanceof EventActivityPaused) {
            LogU.v("MelonBaseFragment", "EventActivityState.EventActivityPaused");
            if(this.mRetainDialog instanceof ForegroundPopup && this.mRetainDialog.isShowing()) {
                this.mRetainDialog.cancel();
            }
        }
        else if(eventActivityState0 instanceof EventActivityStopped) {
            LogU.v("MelonBaseFragment", "EventActivityState.EventActivityStopped");
        }
    }

    public void onExecuteDirectOpenFragment() {
        if(!this.mIsDirectOpenFragment) {
            return;
        }
        this.mIsDirectOpenFragment = false;
        new Handler(Looper.getMainLooper()).post(new n(this, 1));
    }

    public void onFailNetworkConnection(int v) {
    }

    @Override  // com.melon.ui.h3
    public void onForeground() {
        LogU.d("MelonBaseFragment", "onForeground(), this:" + this);
        if(!this.shouldIgnoreSetUIOnForegroundEvent()) {
            if(this.isFragmentValid()) {
                if(this.getActivity().getWindow() != null) {
                    FragmentActivity fragmentActivity0 = this.getActivity();
                    if(!(fragmentActivity0 instanceof MusicBrowserActivity) || !((MusicBrowserActivity)fragmentActivity0).isShowRuntimePermissionGuide()) {
                        this.requestFitSystemWindows();
                        if(!this.shouldIgnoreSetOrientation()) {
                            ViewUtils.setOrientation(this.getActivity(), (this.isScreenLandscapeSupported() ? 13 : 1));
                        }
                    }
                }
                FragmentActivity fragmentActivity1 = this.getActivity();
                if(fragmentActivity1 instanceof com.iloen.melon.custom.V) {
                    ((com.iloen.melon.custom.V)fragmentActivity1).setBottomTabFragmentForeground(this.isBottomTabFragment());
                }
            }
            if(this.shouldShowMiniPlayer()) {
                this.showMiniPlayer(false);
                return;
            }
            this.hideMiniPlayer(false);
        }
    }

    public void onFragmentVisibilityChanged(boolean z) {
    }

    public void onLocalPlaylistAddPopupOk(String s) {
        LogU.d("MelonBaseFragment", "onLocalPlaylistAddPopupOk - editText:" + s);
        if(TextUtils.isEmpty(s)) {
            this.showProgress(false);
            this.showPlaylistEmptyAlertPopup(true);
            return;
        }
        if(MelonLimits.TextLimit.c.a(s) != 0) {
            this.showProgress(false);
            this.showPlaylistNameLimitAlertPopup(true);
            return;
        }
        i.a.f();
        int v = i.e();
        this.mLocalPlaylistCount = v;
        if(v >= 500) {
            if(this.isFragmentValid()) {
                this.showProgress(false);
                this.showErrorPopup(this.getResources().getString(0x7F130507, new Object[]{500}), false);  // string:localplaylist_create_max_exceed_msg "로컬 플레이리스트 만들기는 %d개까지만 가능합니다. 로컬 플레이리스트를 
                                                                                                           // 추가하시려면 로컬 플레이리스트 목록에서 기존 리스트를 삭제하신 후 다시 시도해주세요."
            }
            return;
        }
        new f() {
            private boolean existsSameName;

            {
                String s = s;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.existsSameName = false;
            }

            @Override  // x8.f
            public Object backgroundWork(Object object0, @NotNull Continuation continuation0) {
                return this.backgroundWork(((Void)object0), continuation0);
            }

            public Object backgroundWork(Void void0, @NotNull Continuation continuation0) {
                i.a.f();
                q.g(s, "playlistName");
                this.existsSameName = ((int)(((Integer)w.N(((LocalPlaylistDatabase_Impl)i.a().a), true, false, new Ac.g(s, 22))))) > 0;
                int v = (int)(((Integer)w.N(((LocalPlaylistDatabase_Impl)i.a().a), true, false, new H8.g(3))));
                H8.s s0 = new H8.s();
                q.g(s, "<set-?>");
                s0.b = s;
                s0.e = v + 1;
                s0.c = System.currentTimeMillis();
                H8.q q0 = i.a();
                q0.getClass();
                Long long0 = (Long)w.N(((LocalPlaylistDatabase_Impl)q0.a), false, true, new J(14, q0, s0));
                long0.getClass();
                return ((long)long0) >= 0L ? long0.toString() : null;
            }

            @Override  // x8.f
            public void postTask(Object object0) {
                this.postTask(((String)object0));
            }

            public void postTask(String s) {
                super.postTask(s);
                if(MelonBaseFragment.this.isAdded()) {
                    MelonBaseFragment.this.showProgress(false);
                    if(!TextUtils.isEmpty(s)) {
                        MelonBaseFragment.this.onAddSongsToLocalPlaylist(s);
                        return;
                    }
                    LogU.d("MelonBaseFragment", "comparePlaylist > onPostExecute > error");
                    if(this.existsSameName) {
                        ToastManager.show(MelonBaseFragment.this.getString(0x7F1300A8));  // string:alert_dlg_body_local_playlist_equal_name "같은 이름의 로컬 플레이리스트가 있습니다.\n다시 입력해 
                                                                                          // 주세요."
                    }
                }
            }

            @Override  // x8.f
            public void preTask() {
                super.preTask();
                MelonBaseFragment.this.showProgress(true);
            }
        }.execute(null);
    }

    public void onLocalPlaylistTrackAddClick(String s) {
        LogU.d("MelonBaseFragment", "onLocalPlaylistTrackAddClick - playlistId:" + s);
        if(TextUtils.isEmpty(s)) {
            this.showPlaylistAddEditPopup("", true);
            return;
        }
        this.onAddSongsToLocalPlaylist(s);
    }

    public void onLocalPlaylistTrackAddClick(String s, Playable playable0) {
        LogU.d("MelonBaseFragment", "onLocalPlaylistTrackAddClick - playlistId:" + s);
        if(TextUtils.isEmpty(s)) {
            this.showPlaylistAddEditPopup("", true);
            return;
        }
        this.onAddSongsToLocalPlaylist(s, playable0);
    }

    @Override  // androidx.fragment.app.I
    public void onLowMemory() {
        LogU.w("MelonBaseFragment", "onLowMemory() " + this);
        super.onLowMemory();
        Glide.get(this.getContext()).clearMemory();
        System.gc();
    }

    @Override  // com.iloen.melon.fragments.FragmentStack
    public void onNewArguments(Bundle bundle0) {
        if(MelonBaseFragment.DEBUG) {
            LogU.v("MelonBaseFragment", "onNewArguments() " + this + ", savedInstanceState: " + bundle0);
        }
    }

    @Override  // androidx.fragment.app.I
    public void onPause() {
        this.isFragmentVisible = false;
        this.onFragmentVisibilityChanged(false);
        if(MelonBaseFragment.DEBUG) {
            LogU.v("MelonBaseFragment", "onPause() " + this);
        }
        super.onPause();
        this.hideAllProgress();
    }

    public void onPlaylistCreated(String s, String s1) {
    }

    @Override  // androidx.fragment.app.I
    public void onResume() {
        this.isFragmentVisible = true;
        if(MelonBaseFragment.DEBUG) {
            LogU.v("MelonBaseFragment", "onResume() " + this + ", isFragmentVisible: " + this.isFragmentVisible);
        }
        super.onResume();
        if(!this.isFullyCoveredByFloatingFragment()) {
            if(!this.shouldIgnoreForegroundEvent()) {
                I i0 = this.getParentFragment();
                if(!(i0 instanceof BottomTabInnerBaseFragment)) {
                    if(this.isBottomTabContainerVisible()) {
                        this.onForeground();
                    }
                    else if(i0 instanceof FloatingFragment) {
                        this.onForeground();
                    }
                }
                else if(((BottomTabInnerBaseFragment)i0).getUserVisibleHint()) {
                    this.onForeground();
                }
            }
            if(this.isNeedToLoginInLoginRequiredFragment()) {
                new Handler(Looper.getMainLooper()).post(new n(this, 0));
            }
            this.onFragmentVisibilityChanged(this.isFragmentVisible);
        }
    }

    public void onRetainedPopupCancel(int v) {
    }

    public void onRetainedPopupOk(int v) {
        switch(v) {
            case 0: {
                this.showPlaylistAddEditPopup("", true);
                return;
            }
            case 1: {
                this.showPlaylistAddEditPopup("", false);
            }
        }
    }

    @Override  // androidx.fragment.app.I
    public void onSaveInstanceState(Bundle bundle0) {
        if(MelonBaseFragment.DEBUG) {
            LogU.v("MelonBaseFragment", "onSaveInstanceState() " + this);
        }
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            if(!TextUtils.isEmpty(this.mTitle)) {
                bundle0.putString("argFragmentTitle", this.mTitle);
            }
            if(!TextUtils.isEmpty(this.mUserKey)) {
                bundle0.putString("argMemberKey", this.mUserKey);
            }
            if(!TextUtils.isEmpty(this.mUserNickname)) {
                bundle0.putString("argMemberNickname", this.mUserNickname);
            }
            bundle0.putBoolean("argIsFlac", this.mIsFlac);
            bundle0.putBoolean("argIsLoginRequired", this.mIsLoginRequired);
            bundle0.putInt("argLoginViewMoveCount", this.mLoginViewMoveCount);
            bundle0.putBoolean("argVisibleWhenActivate", this.mVisibleWhenActivate);
            bundle0.putBoolean("argBottomTabbarVisible", this.mBottomTabbarVisible);
            bundle0.putBoolean("argMiniplayerVisible", this.mMiniplayerVisible);
            bundle0.putBoolean("argDirectOpenFragment", this.mIsDirectOpenFragment);
            bundle0.putBoolean("argHasPersonalizedContent", this.mHasPersonalizedContent);
            bundle0.putInt("argCaller", this.mCaller);
            bundle0.putString("argLogging", this.mLogging);
            bundle0.putString("argMenuId", this.mMenuId);
            bundle0.putString("argPlaybackMenuId", this.mPlaybackMenuId);
            TabInfo tabInfo0 = this.mTabInfo;
            if(tabInfo0 != null) {
                bundle0.putParcelable("argTabinfo", tabInfo0);
            }
        }
    }

    @Override  // Sd.a
    public void onScreenCaptured() {
        u u0 = this.screenCaptureUseCase;
        String s = this.getMenuId();
        u0.getClass();
        q.g(s, "menuId");
        q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
        t t0 = new t(u0, 1);
        ((q8.h)d0.b).a(t0);
        q8.b b0 = (q8.b)d0.c;
        if(b0 == null) {
            q8.b b1 = new q8.b();  // 初始化器: Ljava/lang/Object;-><init>()V
            b1.b = s;
            d0.c = b1;
        }
        else {
            b0.b = s;
        }
        q8.a a0 = (q8.a)d0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            a1.g = (String)new t(u0, 0).invoke();
            d0.d = a1;
        }
        else {
            a0.g = (String)new t(u0, 0).invoke();
        }
        c c0 = new c();
        c0.a.put("menuid", s);
        ((LinkedHashMap)d0.g).putAll(c0.a);
        ((Event)d0.p()).track();
    }

    public void onShowLoginPopup(int v) {
    }

    @Override  // androidx.fragment.app.I
    public void onStart() {
        if(MelonBaseFragment.DEBUG) {
            LogU.v("MelonBaseFragment", "onStart() " + this);
        }
        EventBusHelper.register(this);
        BottomTabBaseFragment bottomTabBaseFragment0 = this.getCurrentTabContainerFragment();
        if(bottomTabBaseFragment0 != null && bottomTabBaseFragment0.getCurrentFragment() == this) {
            this.isFragmentVisible = true;
        }
        super.onStart();
    }

    @Override  // androidx.fragment.app.I
    public void onStop() {
        if(MelonBaseFragment.DEBUG) {
            LogU.v("MelonBaseFragment", "onStop() " + this);
        }
        this.hideAllProgress();
        EventBusHelper.unregister(this);
        super.onStop();
    }

    public void onUpdateRatingInfo(String s, float f) {
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(View view0, Bundle bundle0) {
        if(MelonBaseFragment.DEBUG) {
            LogU.v("MelonBaseFragment", "onViewCreated() " + this);
        }
        super.onViewCreated(view0, bundle0);
        this.mRootView = view0;
        View view1 = this.findViewById(0x7F0A0BAD);  // id:titlebar
        if(view1 instanceof TitleBar) {
            this.setTitleBar(((TitleBar)view1));
            this.setTitleBarCommonButtonEventListener(((TitleBar)view1));
            if(!TextUtils.isEmpty(this.mTitle)) {
                ((TitleBar)view1).setTitle(this.mTitle);
            }
        }
    }

    @Override  // androidx.fragment.app.I
    public void onViewStateRestored(Bundle bundle0) {
        if(MelonBaseFragment.DEBUG) {
            LogU.v("MelonBaseFragment", "onViewStateRestored() " + this + ", savedInstanceState: " + bundle0);
        }
        super.onViewStateRestored(bundle0);
    }

    public final void open() {
        Navigator.open(this);
    }

    public final void open(I i0) {
        if(i0 instanceof a9.a) {
            ((a9.a)i0).addFragment(this);
            return;
        }
        Navigator.open(this);
    }

    public void openLoginView(Uri uri0) {
        Navigator.openLoginView(uri0);
    }

    public void openMusicMessagePage(Receiver toReceiverView$Receiver0) {
        ArrayList arrayList0;
        if(toReceiverView$Receiver0 == null) {
            arrayList0 = null;
        }
        else {
            arrayList0 = new ArrayList();
            arrayList0.add(toReceiverView$Receiver0);
        }
        this.openMusicMessagePage(arrayList0);
    }

    public void openMusicMessagePage(ArrayList arrayList0) {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        MusicMessageEditorFragment.newInstance(arrayList0, null, null).open();
    }

    public void openMusicMessagePage(ArrayList arrayList0, String s, String s1) {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        MusicMessageEditorFragment.newInstance(arrayList0, s, s1).open();
    }

    public boolean openPresentSendPage(Receiver toReceiverView$Receiver0) {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return false;
        }
        ArrayList arrayList0 = new ArrayList();
        if(toReceiverView$Receiver0 != null) {
            arrayList0.add(toReceiverView$Receiver0);
        }
        Navigator.openPresentSongSendFragment(arrayList0);
        return true;
    }

    public boolean openPresentSendPage(Receiver toReceiverView$Receiver0, ArrayList arrayList0) {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return false;
        }
        com.melon.ui.popup.b b0 = com.melon.ui.popup.b.a;
        if(arrayList0 != null && arrayList0.size() > 50) {
            b0.c(this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F13088A));  // string:alert_dlg_title_info "안내"
            return false;
        }
        ArrayList arrayList1 = new ArrayList();
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            for(Object object0: arrayList0) {
                Playable playable0 = (Playable)object0;
                if(playable0.isMelonSong()) {
                    arrayList1.add(playable0);
                }
            }
        }
        if(arrayList1.size() == 0) {
            b0.c(this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F1300C4));  // string:alert_dlg_title_info "안내"
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        if(toReceiverView$Receiver0 != null) {
            arrayList2.add(toReceiverView$Receiver0);
        }
        new Handler(Looper.getMainLooper()).post(new m(arrayList0, arrayList2, arrayList1, 1));
        return true;
    }

    public final boolean performBackPress() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            fragmentActivity0.getOnBackPressedDispatcher().c();
            return true;
        }
        return false;
    }

    public void playAlbum(Playable playable0) {
        this.playAlbum(playable0, false);
    }

    public void playAlbum(Playable playable0, boolean z) {
        if(playable0 == null) {
            LogU.w("MelonBaseFragment", "playAlbum() - invalid playable");
            return;
        }
        LogU.d("MelonBaseFragment", "playAlbum() playable");
        this.playAlbum("", "", z);
    }

    public void playAlbum(String s, String s1) {
        this.playAlbum(s, s1, false);
    }

    public void playAlbum(String s, String s1, boolean z) {
        this.playAlbum(s, s1, z, null);
    }

    public void playAlbum(String s, String s1, boolean z, StatsElementsBase statsElementsBase0) {
        if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1)) {
            LogU.d("MelonBaseFragment", "playAlbum() albumId:" + s + " menuId:" + s1);
            FragmentActivity fragmentActivity0 = this.getActivity();
            AddPlayOpenPlayer addAction$AddPlayOpenPlayer0 = z ? new AddPlayOpenPlayer(false) : new AddPlay(false);
            AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(fragmentActivity0, new AddServerContent(addAction$AddPlayOpenPlayer0, false, false, this.blockingProgressDialogManage, new Album(s, CType.ALBUM, s1, statsElementsBase0)), true);
            return;
        }
        LogU.w("MelonBaseFragment", "playAlbum() - invalid paramter");
    }

    public void playArtistSongBasic(String s, String s1, boolean z, StatsElementsBase statsElementsBase0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "playArtistSongBasic() invalid artistId");
            return;
        }
        LogU.d("MelonBaseFragment", "playArtistSongBasic() artistId: " + s);
        FragmentActivity fragmentActivity0 = this.getActivity();
        AddPlayOpenPlayer addAction$AddPlayOpenPlayer0 = z ? new AddPlayOpenPlayer(false) : new AddPlay(false);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(fragmentActivity0, new AddServerContent(addAction$AddPlayOpenPlayer0, false, false, this.blockingProgressDialogManage, new Artist(s, s1, statsElementsBase0)), true);
    }

    public void playLive(String s, String s1, boolean z) {
        this.playLive(s, s1, z, null);
    }

    public void playLive(String s, String s1, boolean z, StatsElementsBase statsElementsBase0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "playLive() - invalid liveSeq");
            return;
        }
        Navigator.openLive(s, s1, z, statsElementsBase0);
    }

    public void playMixUp(String s, w1 w10) {
        AddPlay addAction$AddPlay0 = !(w10 instanceof P0) || !((P0)w10).c ? new AddPlay(false) : new AddPlayOpenPlayer(false);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(this.getActivity(), new AddServerContent(addAction$AddPlay0, false, false, this.blockingProgressDialogManage, new MixUp(w10, s, null)), true);
    }

    private void playMv(String s, String s1, boolean z, boolean z1, boolean z2) {
        this.playMv(s, s1, z, z1, z2, null);
    }

    private void playMv(String s, String s1, boolean z, boolean z1, boolean z2, StatsElementsBase statsElementsBase0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "playMv() - invalid songId");
            return;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("MelonBaseFragment", "playMv() - invalid menuId");
            return;
        }
        FragmentActivity fragmentActivity0 = this.getActivity();
        VideoPlayAndOpen addAction$VideoPlayAndOpen0 = z2 ? new VideoPlayAndOpen(false) : new AddPlay(false);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(fragmentActivity0, new AddServerContent(addAction$VideoPlayAndOpen0, false, false, this.blockingProgressDialogManage, new MV(null, s, s1, statsElementsBase0)), true);
    }

    public void playMv(Playable playable0) {
        this.playMv(playable0, false, true);
    }

    public void playMv(Playable playable0, boolean z, boolean z1) {
        this.playMv(playable0, false, z, z1);
    }

    public void playMv(Playable playable0, boolean z, boolean z1, boolean z2) {
        this.playMv(playable0, z, z1, z2, null);
    }

    public void playMv(Playable playable0, boolean z, boolean z1, boolean z2, StatsElementsBase statsElementsBase0) {
        if(playable0 == null) {
            LogU.w("MelonBaseFragment", "playMv() - invalid paramter");
            return;
        }
        if(!this.canPlayPossibleAdultSong(playable0, true)) {
            this.runTaskAuthMsgContent();
            return;
        }
        boolean z3 = playable0.hasMv();
        StringBuilder stringBuilder0 = Z.p("playMv() hasMv:", " ,songId:", "", " ,mvId:", z3);
        stringBuilder0.append("");
        stringBuilder0.append(" ,menuId:");
        stringBuilder0.append("");
        LogU.d("MelonBaseFragment", stringBuilder0.toString());
        if(z3) {
            this.playMv("", "", z, z1, z2, statsElementsBase0);
        }
    }

    public void playMv(String s, String s1) {
        this.playMv(s, s1, false, true);
    }

    public void playMv(String s, String s1, boolean z, boolean z1) {
        this.playMv(s, s1, false, z, z1);
    }

    public void playMvById(String s, String s1) {
        this.playMvById(s, s1, false, true);
    }

    public void playMvById(String s, String s1, boolean z, boolean z1) {
        this.playMvById(s, s1, false, z, z1, null);
    }

    public void playMvById(String s, String s1, boolean z, boolean z1, boolean z2, StatsElementsBase statsElementsBase0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "playMv() - invalid mvId");
            return;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("MelonBaseFragment", "playMv() - invalid menuId");
            return;
        }
        LogU.d("MelonBaseFragment", "playMvByMvId() mvId:" + s);
        FragmentActivity fragmentActivity0 = this.getActivity();
        VideoPlayAndOpen addAction$VideoPlayAndOpen0 = z2 ? new VideoPlayAndOpen(z1) : new AddPlay(false);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(fragmentActivity0, new AddServerContent(addAction$VideoPlayAndOpen0, false, false, this.blockingProgressDialogManage, new MV(s, null, s1, statsElementsBase0)), true);
    }

    public void playMvByMvId(Playable playable0) {
        this.playMvByMvId(playable0, false, true);
    }

    public void playMvByMvId(Playable playable0, boolean z, boolean z1) {
        if(playable0 == null) {
            LogU.w("MelonBaseFragment", "playMvByMvId() - invalid parameter");
            return;
        }
        LogU.d("MelonBaseFragment", "playMvByMvId() mvId:" + playable0.getMvid());
        this.playMvByMvId(new ArrayList(Collections.singletonList(playable0)), z, z1);
    }

    public void playMvByMvId(ArrayList arrayList0) {
        this.playMvByMvId(arrayList0, false, true);
    }

    public void playMvByMvId(ArrayList arrayList0, boolean z, boolean z1) {
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            StringBuilder stringBuilder0 = new StringBuilder();
            CharSequence charSequence0 = null;
            CharSequence charSequence1 = null;
            for(Object object0: arrayList0) {
                Playable playable0 = (Playable)object0;
                if(TextUtils.isEmpty(charSequence0)) {
                    charSequence0 = "";
                }
                if(TextUtils.isEmpty(charSequence1)) {
                    charSequence1 = "";
                }
                stringBuilder0.append("");
                stringBuilder0.append(",");
            }
            if(stringBuilder0.length() > 0) {
                stringBuilder0.setLength(stringBuilder0.length() - 1);
            }
            LogU.d("MelonBaseFragment", "playMvByMvId() mvId:" + stringBuilder0.toString());
            this.playMvById(stringBuilder0.toString(), ((String)charSequence0), z, z1);
            return;
        }
        LogU.w("MelonBaseFragment", "playMvByMvId() - invalid parameter");
    }

    public void playMvByMvIdFromKids(ArrayList arrayList0) {
        boolean z = ((v)this.vodRepeatManager).b();
        boolean z1 = ((v)this.vodRepeatManager).a();
        if(z || !z1) {
            if(z) {
                ((v)this.vodRepeatManager).d(false);
            }
            if(!z1) {
                ((v)this.vodRepeatManager).c(true);
            }
            ToastManager.show(0x7F1306AC);  // string:mk_video_repeat_mode_auto "자동재생이 설정되어 영상이 연속으로 재생됩니다."
        }
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            StringBuilder stringBuilder0 = new StringBuilder();
            CharSequence charSequence0 = null;
            CharSequence charSequence1 = null;
            for(Object object0: arrayList0) {
                Playable playable0 = (Playable)object0;
                if(TextUtils.isEmpty(charSequence1)) {
                    charSequence1 = "";
                }
                if(TextUtils.isEmpty(charSequence0)) {
                    charSequence0 = "";
                }
                stringBuilder0.append("");
                stringBuilder0.append(",");
            }
            if(stringBuilder0.length() > 0) {
                stringBuilder0.setLength(stringBuilder0.length() - 1);
            }
            LogU.d("MelonBaseFragment", "playMvByMvId() mvId:" + stringBuilder0.toString());
            this.playMvById(stringBuilder0.toString(), ((String)charSequence1), true, false, true, null);
            return;
        }
        LogU.w("MelonBaseFragment", "playMvByMvId() - invalid parameter");
    }

    public void playPlaylist(String s, String s1, String s2, StatsElementsBase statsElementsBase0) {
        this.playPlaylist(s, s1, s2, false, false, statsElementsBase0);
    }

    public void playPlaylist(String s, String s1, String s2, boolean z, StatsElementsBase statsElementsBase0) {
        this.playPlaylist(s, s1, s2, z, false, statsElementsBase0);
    }

    public void playPlaylist(String s, String s1, String s2, boolean z, boolean z1, StatsElementsBase statsElementsBase0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "playPlaylist() - invalid playlistId");
            return;
        }
        if(TextUtils.isEmpty(s2)) {
            LogU.w("MelonBaseFragment", "playPlaylist() - invalid menuId");
            return;
        }
        LogU.d("MelonBaseFragment", "playPlaylist() playlistId:" + s);
        FragmentActivity fragmentActivity0 = this.getActivity();
        AddPlayOpenPlayer addAction$AddPlayOpenPlayer0 = z ? new AddPlayOpenPlayer(z1) : new AddPlay(z1);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(fragmentActivity0, new AddServerContent(addAction$AddPlayOpenPlayer0, false, false, this.blockingProgressDialogManage, new Playlist(s, s2, statsElementsBase0)), true);
    }

    public void playRadioCast(String s, String s1, StatsElementsBase statsElementsBase0) {
        this.playRadioCast(s, s1, null, statsElementsBase0, false);
    }

    public void playRadioCast(String s, String s1, String s2, StatsElementsBase statsElementsBase0) {
        this.playRadioCast(s, s1, s2, statsElementsBase0, false);
    }

    public void playRadioCast(String s, String s1, String s2, StatsElementsBase statsElementsBase0, boolean z) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "playRadioCast() invalid castInfo");
            return;
        }
        if(((Ub.t)this.remotePlayerManager).g()) {
            ToastManager.show(0x7F1301B4);  // string:cast_not_support_external_device "연결중인 외부기기에서 재생이 불가능 합니다."
            return;
        }
        LogU.d("MelonBaseFragment", "playRadioCast() castSeq: " + s);
        FragmentActivity fragmentActivity0 = this.getActivity();
        AddPlayOpenPlayer addAction$AddPlayOpenPlayer0 = z ? new AddPlayOpenPlayer(false) : new AddPlay(false);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(fragmentActivity0, new AddServerContent(addAction$AddPlayOpenPlayer0, false, false, this.blockingProgressDialogManage, new Station(s, s2, s1, statsElementsBase0)), true);
    }

    public boolean playSong(Playable playable0, boolean z) {
        return this.playSong(playable0, z, false, this.isGenreExclude());
    }

    public boolean playSong(Playable playable0, boolean z, boolean z1) {
        return this.playSong(playable0, z, z1, this.isGenreExclude());
    }

    public boolean playSong(Playable playable0, boolean z, boolean z1, boolean z2) {
        if(playable0 == null) {
            LogU.w("MelonBaseFragment", "playSong() - invalid parameter");
            return false;
        }
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(playable0);
        return this.playSongs(arrayList0, z, z1, false, z2);
    }

    public boolean playSong(String s, String s1) {
        return this.playSong(s, s1, false, null);
    }

    public boolean playSong(String s, String s1, boolean z) {
        return this.playSong(s, s1, z, null);
    }

    public boolean playSong(String s, String s1, boolean z, StatsElementsBase statsElementsBase0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "playSong() invalid songId");
            return false;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("MelonBaseFragment", "playSong() invalid menuId");
            return false;
        }
        AddPlayOpenPlayer addAction$AddPlayOpenPlayer0 = z ? new AddPlayOpenPlayer(false) : new AddPlay(false);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(this.getActivity(), AddServerContent.Companion.with(CType.SONG, s, s1, addAction$AddPlayOpenPlayer0, this.blockingProgressDialogManage), true);
        return true;
    }

    public boolean playSongIds(String s, String s1, boolean z, boolean z1, StatsElementsBase statsElementsBase0) {
        return this.playSongIds(s, s1, z, z1, statsElementsBase0, this.isGenreExclude());
    }

    public boolean playSongIds(String s, String s1, boolean z, boolean z1, StatsElementsBase statsElementsBase0, boolean z2) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "playSongs() invalid songId");
            return false;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("MelonBaseFragment", "playSongs() invalid menuId");
            return false;
        }
        FragmentActivity fragmentActivity0 = this.getActivity();
        AddPlayOpenPlayer addAction$AddPlayOpenPlayer0 = z ? new AddPlayOpenPlayer(z1) : new AddPlay(false);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(fragmentActivity0, new AddServerContent(addAction$AddPlayOpenPlayer0, false, z2, this.blockingProgressDialogManage, new com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Song(s, CType.SONG, s1, statsElementsBase0)), true);
        return true;
    }

    public boolean playSongs(ArrayList arrayList0, boolean z) {
        return this.playSongs(arrayList0, z, false);
    }

    public boolean playSongs(ArrayList arrayList0, boolean z, boolean z1) {
        return this.playSongs(arrayList0, z, z1, false);
    }

    public boolean playSongs(ArrayList arrayList0, boolean z, boolean z1, boolean z2) {
        return this.playSongs(arrayList0, z, z1, z2, this.isGenreExclude());
    }

    public boolean playSongs(ArrayList arrayList0, boolean z, boolean z1, boolean z2, boolean z3) {
        AddPlayOpenPlayer addAction$AddPlayOpenPlayer0;
        if(arrayList0 != null && arrayList0.size() != 0) {
            LogU.d("MelonBaseFragment", "playSongs() - playableList");
            if(z && z1) {
                addAction$AddPlayOpenPlayer0 = new AddPlayOpenPlayer(z2);
            }
            else if(z) {
                addAction$AddPlayOpenPlayer0 = new AddPlay(z2);
            }
            else {
                addAction$AddPlayOpenPlayer0 = Add.INSTANCE;
            }
            AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(this.getActivity(), new AddPlayableList(null, addAction$AddPlayOpenPlayer0, false, z3, false, this.blockingProgressDialogManage, arrayList0), false);
            return true;
        }
        LogU.w("MelonBaseFragment", "playSongs() - invalid parameter");
        return false;
    }

    public void playTop100(String s, boolean z) {
        this.playTop100(false, s, z);
    }

    public void playTop100(boolean z, String s, boolean z1) {
        LogU.d("MelonBaseFragment", "playTop100()");
        FragmentActivity fragmentActivity0 = this.getActivity();
        AddPlayOpenPlayer addAction$AddPlayOpenPlayer0 = z ? new AddPlayOpenPlayer(false) : new AddPlay(false);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(fragmentActivity0, new AddServerContent(addAction$AddPlayOpenPlayer0, false, z1, this.blockingProgressDialogManage, new ChartTop100(s, null)), true);
    }

    public void postExecutePlayerRequestAdd(ArrayList arrayList0, boolean z, boolean z1, String s) {
    }

    public void requestFitSystemWindows() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 instanceof g1) {
            ((g1)fragmentActivity0).updateSystemUiFit(this.getInsetHandlingType());
        }
    }

    private void restoreInstanceState(Bundle bundle0) {
        if(MelonBaseFragment.DEBUG) {
            LogU.v("MelonBaseFragment", "restoreInstanceState() " + this + ", savedInstanceState: " + bundle0);
        }
        if(bundle0 != null) {
            if(bundle0.containsKey("argFragmentTitle")) {
                Object object0 = bundle0.get("argFragmentTitle");
                if(object0 instanceof Integer) {
                    this.mTitle = this.getString(((int)(((Integer)object0))));
                }
                else if(object0 instanceof String) {
                    this.mTitle = (String)object0;
                }
            }
            if(bundle0.containsKey("argMemberKey")) {
                this.mUserKey = bundle0.getString("argMemberKey");
            }
            if(bundle0.containsKey("argMemberNickname")) {
                this.mUserNickname = bundle0.getString("argMemberNickname");
            }
            if(bundle0.containsKey("argIsFlac")) {
                this.mIsFlac = bundle0.getBoolean("argIsFlac");
            }
            if(bundle0.containsKey("argIsLoginRequired")) {
                this.mIsLoginRequired = bundle0.getBoolean("argIsLoginRequired");
            }
            if(bundle0.containsKey("argLoginViewMoveCount")) {
                this.mLoginViewMoveCount = bundle0.getInt("argLoginViewMoveCount", 0);
            }
            if(bundle0.containsKey("argVisibleWhenActivate")) {
                this.mVisibleWhenActivate = bundle0.getBoolean("argVisibleWhenActivate");
            }
            if(bundle0.containsKey("argVisibleSnsPopup")) {
                this.mVisibleSnsPopup = bundle0.getBoolean("argVisibleSnsPopup");
            }
            if(bundle0.containsKey("argBottomTabbarVisible")) {
                this.mBottomTabbarVisible = bundle0.getBoolean("argBottomTabbarVisible");
            }
            if(bundle0.containsKey("argMiniplayerVisible")) {
                this.mMiniplayerVisible = bundle0.getBoolean("argMiniplayerVisible");
            }
            if(bundle0.containsKey("argDirectOpenReply")) {
                this.mIsDirectOpenReply = bundle0.getBoolean("argDirectOpenReply");
            }
            if(bundle0.containsKey("argDirectOpenFragment")) {
                this.mIsDirectOpenFragment = bundle0.getBoolean("argDirectOpenFragment");
            }
            if(bundle0.containsKey("argReplyChannelSeq")) {
                this.mChannelSeq = bundle0.getString("argReplyChannelSeq");
            }
            if(bundle0.containsKey("argReplyCommentSeq")) {
                this.mCommentSeq = bundle0.getString("argReplyCommentSeq");
            }
            if(bundle0.containsKey("argHasPersonalizedContent")) {
                this.mHasPersonalizedContent = bundle0.getBoolean("argHasPersonalizedContent");
            }
            if(bundle0.containsKey("argCaller")) {
                this.mCaller = bundle0.getInt("argCaller", -1);
            }
            if(bundle0.containsKey("argLogging")) {
                this.mLogging = bundle0.getString("argLogging");
            }
            if(bundle0.containsKey("argMenuId")) {
                this.mMenuId = bundle0.getString("argMenuId");
            }
            if(bundle0.containsKey("argPlaybackMenuId")) {
                this.mPlaybackMenuId = bundle0.getString("argPlaybackMenuId");
            }
            if(bundle0.containsKey("argTabinfo")) {
                this.mTabInfo = (TabInfo)bundle0.getParcelable("argTabinfo");
            }
        }
    }

    public void runTaskAuthMsgContent() {
        LogU.d("MelonBaseFragment", "runTaskAuthMsgContent()");
        String s = ((e0)va.o.a()).m() ? "NOTAUTH" : "NOTLOGIN";
        if(TextUtils.isEmpty(s)) {
            LogU.d("MelonBaseFragment", "requestAuthMsgContent() - login & adult & auth > allowed user");
            return;
        }
        RequestBuilder.newInstance(new AuthMsgContentReq(MelonAppBase.instance.getContext(), s)).tag("MelonBaseFragment").listener(new Listener() {
            public void onResponse(AuthMsgContentRes authMsgContentRes0) {
                authMsgContentRes0.isSuccessful();
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((AuthMsgContentRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                if(MelonBaseFragment.this.isFragmentValid()) {
                    ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                }
            }
        }).request();
    }

    private void sendMusicMessage(ArrayList arrayList0, Sharable sharable0) {
        if(sharable0 == null) {
            LogU.w("MelonBaseFragment", "sendMusicMessage() invalid attachedSharable");
            return;
        }
        if(arrayList0 == null) {
            LogU.w("MelonBaseFragment", "sendMusicMessage() invalid receivers");
            return;
        }
        com.melon.ui.popup.b b0 = com.melon.ui.popup.b.a;
        if(arrayList0.size() == 0) {
            b0.c(this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F13087E));  // string:alert_dlg_title_info "안내"
            return;
        }
        if(Receiver.e(arrayList0)) {
            b0.c(this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F130472));  // string:alert_dlg_title_info "안내"
            return;
        }
        com.iloen.melon.net.v6x.request.MusicMessageInsertMusicMsgBaseReq.Params musicMessageInsertMusicMsgBaseReq$Params0 = new com.iloen.melon.net.v6x.request.MusicMessageInsertMusicMsgBaseReq.Params();
        musicMessageInsertMusicMsgBaseReq$Params0.targetMemberkeys = Receiver.b(arrayList0);
        musicMessageInsertMusicMsgBaseReq$Params0.contsTypeCodes = sharable0.getContsTypeCode().code();
        musicMessageInsertMusicMsgBaseReq$Params0.contsIds = sharable0.getContentId();
        RequestBuilder.newInstance(new MusicMessageShareInsertMusicMsgReq(this.getContext(), musicMessageInsertMusicMsgBaseReq$Params0)).tag("MelonBaseFragment").listener(new Listener() {
            public void onResponse(MusicMessageInsertMusicMsgRes musicMessageInsertMusicMsgRes0) {
                if(musicMessageInsertMusicMsgRes0.isSuccessful()) {
                    MelonBaseFragment.this.openMusicMessagePage(arrayList0);
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MusicMessageInsertMusicMsgRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                LogU.w("MelonBaseFragment", "onErrorResponse() " + HttpResponse.getErrorMessage(volleyError0));
                MelonBaseFragment.this.dismissProgressDialog();
                if(MelonBaseFragment.this.isFragmentValid()) {
                    ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                }
            }
        }).request();
    }

    public void sendPopupMessage(int v) {
        Z.r(v, "sendPopupMessage - what:", "MelonBaseFragment");
        this.mPopupHandler.sendEmptyMessage(v);
    }

    public void sendPopupMessage(int v, Object object0) {
        LogU.d("MelonBaseFragment", "sendPopupMessage - what:" + v + ", obj:" + object0);
        this.mPopupHandler.obtainMessage(v, object0).sendToTarget();
    }

    @Override  // com.iloen.melon.popup.RetainPopup
    public void setRetainDialog(Dialog dialog0) {
        this.mRetainDialog = dialog0;
    }

    @Override  // com.iloen.melon.fragments.TabFragment
    public void setTabInfo(TabInfo tabInfo0) {
        this.mTabInfo = tabInfo0;
    }

    public void setTitleBar(TitleBar titleBar0) {
        this.mTitleBar = titleBar0;
        WeakReference weakReference0 = new WeakReference(this.mTitleBar);
        this.mTitleBarRef = weakReference0;
        TitleBar titleBar1 = this.mTitleBar;
        if(titleBar1 != null) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(AppUtils.isAccessibilityTalkbackOn() && fragmentActivity0 instanceof MusicBrowserActivity) {
                View view0 = ((MusicBrowserActivity)fragmentActivity0).getCtlBottom();
                if(view0 != null) {
                    view0.setImportantForAccessibility(4);
                }
                I i0 = ((MusicBrowserActivity)fragmentActivity0).getCurrentFragment();
                BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.f(fragmentActivity0), Dispatchers.getIO().plus(new F8.d(CoroutineExceptionHandler.Key, ((MusicBrowserActivity)fragmentActivity0))), null, new F8.h(titleBar1, i0, fragmentActivity0, null), 2, null);
            }
            this.mTitleBarRef = new WeakReference(this.mTitleBar);
            return;
        }
        weakReference0.clear();
    }

    public void setTitleBarCommonButtonEventListener(TitleBar titleBar0) {
        titleBar0.setCommonButtonEventListener(new F8.b() {
            @Override  // F8.b
            public void onClick(int v, F8.o o0) {
                boolean z;
                s s0 = o0.f == null ? MelonBaseFragment.this.getTiaraProperty() : o0.f;
                if(s0 == null) {
                    z = false;
                }
                else {
                    String s1 = s0.b;
                    if(TextUtils.isEmpty(s1)) {
                        z = false;
                    }
                    else {
                        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                        g0.I = s0.c;
                        g0.a = "페이지이동";
                        g0.b = s0.a;
                        g0.c = s1;
                        g0.y = "GNB";
                        g0.z = "페이지이동";
                        g0.F = o0.e;
                        g0.a().track();
                        z = true;
                    }
                }
                switch(v) {
                    case 1: {
                        if(!z) {
                            F8.i.a(0x7F130EBB);  // string:tiara_gnb_layer2_ticket "이용권"
                        }
                        Navigator.open(BuyingGoodsFragment.newInstance());
                        return;
                    }
                    case 3: {
                        d5.s s2 = new d5.s();
                        s2.b = "0";
                        s2.e = "S03";
                        s2.h = "S1";
                        com.iloen.melon.utils.a.t(s2);
                        if(!z) {
                            F8.i.a(0x7F130EBA);  // string:tiara_gnb_layer2_music_search "음악검색"
                        }
                        Navigator.openSoundSearch();
                        return;
                    }
                    case 6: {
                        Navigator.openMainMusicAndClearStack();
                        return;
                    }
                    case 4: 
                    case 5: 
                    case 7: {
                        MelonBaseFragment.this.performBackPress();
                    }
                }
            }
        });
    }

    public void setVisibleWhenActivate(boolean z) {
        this.mVisibleWhenActivate = z;
    }

    public void shareInstagram(Sharable sharable0) {
        this.shareSnsAppToApp(sharable0, SnsManager.SnsType.e);
    }

    private void shareSnsAppToApp(Sharable sharable0, SnsManager.SnsType snsManager$SnsType0) {
        if(sharable0 instanceof Playable && ((Playable)sharable0).hasSongId() && ((Playable)sharable0).isOriginLocal()) {
            TaskGetSongInfo taskGetSongInfo0 = new TaskGetSongInfo(((Playable)sharable0).getSongidString(), ((Playable)sharable0).getCtype());
            taskGetSongInfo0.setResultListener(new ResultListener() {
                @Override  // com.iloen.melon.task.request.TaskGetSongInfo$ResultListener
                public void onFinishTask(Throwable throwable0) {
                    if(MelonBaseFragment.this.isFragmentValid()) {
                        MelonBaseFragment.this.dismissProgressDialog();
                        if(throwable0 == null) {
                            SongInfoBase songInfoBase0 = taskGetSongInfo0.getSongInfo();
                            if(songInfoBase0 != null) {
                                ((Playable)sharable0).updateFrom(songInfoBase0);
                            }
                            MelonBaseFragment.z(MelonBaseFragment.this, sharable0, snsManager$SnsType0);
                        }
                    }
                }

                @Override  // com.iloen.melon.task.request.TaskGetSongInfo$ResultListener
                public void onStartTask() {
                    MelonBaseFragment.this.showProgressDialog();
                }
            });
            taskGetSongInfo0.executeAsync();
            return;
        }
        this.shareSnsAppToAppImpl(sharable0, snsManager$SnsType0);
    }

    private void shareSnsAppToAppImpl(Sharable sharable0, SnsManager.SnsType snsManager$SnsType0) {
        SnsTarget snsTarget0 = F.a.B(snsManager$SnsType0);
        SnsManager.PostParam snsManager$PostParam0 = new SnsManager.PostParam();
        snsManager$PostParam0.a = snsManager$SnsType0;
        snsManager$PostParam0.c = sharable0;
        snsManager$PostParam0.b = this.getActivity();
        snsManager$PostParam0.d = sharable0.getDisplayMessage(snsTarget0);
        F.a.B(snsManager$PostParam0.a).a(snsManager$PostParam0, null);
    }

    public boolean shouldIgnoreForegroundEvent() {
        return false;
    }

    public boolean shouldIgnoreSetOrientation() {
        return false;
    }

    public boolean shouldIgnoreSetUIOnForegroundEvent() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.FragmentStack
    public boolean shouldOnResume() {
        return true;
    }

    public boolean shouldShowMiniPlayer() {
        return true;
    }

    public void showAddPositionSettingPopup(OnAddPositionSetListener popupTextListAdapter$OnAddPositionSetListener0) {
        String[] arr_s = {this.getString(0x7F13002B), this.getString(0x7F130027), this.getString(0x7F130028)};  // string:addposition_first "목록 맨 처음"
        if(this.mRetainDialog instanceof PlaylistAddPopup && this.mRetainDialog.isShowing()) {
            return;
        }
        PlaylistAddPopup playlistAddPopup0 = new PlaylistAddPopup(this.getActivity(), null, arr_s, null);
        playlistAddPopup0.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override  // android.content.DialogInterface$OnDismissListener
            public void onDismiss(DialogInterface dialogInterface0) {
                OnAddPositionSetListener popupTextListAdapter$OnAddPositionSetListener0 = popupTextListAdapter$OnAddPositionSetListener0;
                if(popupTextListAdapter$OnAddPositionSetListener0 != null) {
                    popupTextListAdapter$OnAddPositionSetListener0.g();
                }
                DialogInterface.OnDismissListener dialogInterface$OnDismissListener0 = MelonBaseFragment.this.mDialogDismissListener;
                if(dialogInterface$OnDismissListener0 != null) {
                    dialogInterface$OnDismissListener0.onDismiss(dialogInterface0);
                }
            }
        });
        this.mRetainDialog = playlistAddPopup0;
        playlistAddPopup0.show();
    }

    public void showAddToDjPlaylistPositionSettingPopup(OnAddPositionSetListener popupTextListAdapter$OnAddPositionSetListener0) {
        String[] arr_s = {this.getString(0x7F13002B), this.getString(0x7F130028)};  // string:addposition_first "목록 맨 처음"
        if(this.mRetainDialog instanceof PlaylistAddPopup && this.mRetainDialog.isShowing()) {
            return;
        }
        DjPlaylistAddPopup djPlaylistAddPopup0 = new DjPlaylistAddPopup(this.getActivity(), null, arr_s, null);
        djPlaylistAddPopup0.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override  // android.content.DialogInterface$OnDismissListener
            public void onDismiss(DialogInterface dialogInterface0) {
                OnAddPositionSetListener popupTextListAdapter$OnAddPositionSetListener0 = popupTextListAdapter$OnAddPositionSetListener0;
                if(popupTextListAdapter$OnAddPositionSetListener0 != null) {
                    popupTextListAdapter$OnAddPositionSetListener0.g();
                }
                DialogInterface.OnDismissListener dialogInterface$OnDismissListener0 = MelonBaseFragment.this.mDialogDismissListener;
                if(dialogInterface$OnDismissListener0 != null) {
                    dialogInterface$OnDismissListener0.onDismiss(dialogInterface0);
                }
            }
        });
        this.mRetainDialog = djPlaylistAddPopup0;
        djPlaylistAddPopup0.show();
    }

    public void showAddToNormalPlaylistPositionSettingPopup(OnAddPositionSetListener popupTextListAdapter$OnAddPositionSetListener0) {
        String[] arr_s = {this.getString(0x7F13002B), this.getString(0x7F130028)};  // string:addposition_first "목록 맨 처음"
        if(this.mRetainDialog instanceof PlaylistAddPopup && this.mRetainDialog.isShowing()) {
            return;
        }
        NormalPlaylistAddPopup normalPlaylistAddPopup0 = new NormalPlaylistAddPopup(this.getActivity(), null, arr_s, null);
        normalPlaylistAddPopup0.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override  // android.content.DialogInterface$OnDismissListener
            public void onDismiss(DialogInterface dialogInterface0) {
                OnAddPositionSetListener popupTextListAdapter$OnAddPositionSetListener0 = popupTextListAdapter$OnAddPositionSetListener0;
                if(popupTextListAdapter$OnAddPositionSetListener0 != null) {
                    popupTextListAdapter$OnAddPositionSetListener0.g();
                }
                DialogInterface.OnDismissListener dialogInterface$OnDismissListener0 = MelonBaseFragment.this.mDialogDismissListener;
                if(dialogInterface$OnDismissListener0 != null) {
                    dialogInterface$OnDismissListener0.onDismiss(dialogInterface0);
                }
            }
        });
        this.mRetainDialog = normalPlaylistAddPopup0;
        normalPlaylistAddPopup0.show();
    }

    public void showAlbumInfoPage(Playable playable0) {
        if(playable0 == null) {
            LogU.w("MelonBaseFragment", "showAlbumInfoPage() invalid playable");
            return;
        }
        if(playable0.hasSongId()) {
            TaskGetSongInfo taskGetSongInfo0 = new TaskGetSongInfo("", playable0.getCtype());
            taskGetSongInfo0.setResultListener(new ResultListener() {
                @Override  // com.iloen.melon.task.request.TaskGetSongInfo$ResultListener
                public void onFinishTask(Throwable throwable0) {
                    SongInfoBase songInfoBase0;
                    if(MelonBaseFragment.this.isFragmentValid()) {
                        MelonBaseFragment.this.dismissProgressDialog();
                        String s = null;
                        if(throwable0 == null) {
                            songInfoBase0 = taskGetSongInfo0.getSongInfo();
                            if(songInfoBase0 != null) {
                                playable0.updateFrom(songInfoBase0);
                                if(MelonBaseFragment.this.isFragmentValid()) {
                                    String s1 = songInfoBase0.albumId;
                                    if(TextUtils.isEmpty(s1)) {
                                        LogU.e("MelonBaseFragment", "showAlbumInfoPage() invalid albumId");
                                        ToastManager.show(0x7F13019A);  // string:cannot_find_album_info "앨범 정보가 없습니다."
                                    }
                                    else {
                                        MelonBaseFragment.this.showAlbumInfoPage(s1);
                                    }
                                }
                            }
                        }
                        else {
                            songInfoBase0 = null;
                        }
                        if((throwable0 != null || songInfoBase0 == null) && MelonBaseFragment.this.isFragmentValid()) {
                            if(throwable0 != null) {
                                s = throwable0.getMessage();
                            }
                            if(TextUtils.isEmpty(s)) {
                                s = "앨범 정보가 없습니다.";
                            }
                            ToastManager.show(s);
                        }
                    }
                }

                @Override  // com.iloen.melon.task.request.TaskGetSongInfo$ResultListener
                public void onStartTask() {
                    MelonBaseFragment.this.showProgressDialog();
                }
            });
            taskGetSongInfo0.executeAsync();
            return;
        }
        LogU.w("MelonBaseFragment", "showAlbumInfoPage() invalid songId");
    }

    public void showAlbumInfoPage(String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "showAlbumInfoPage() invalid albumId");
            return;
        }
        Navigator.openAlbumInfo(s);
    }

    public void showAlbumbRcmdCntsPopup(com.iloen.melon.net.v4x.response.AlbumSuggestedContentsRes.RESPONSE albumSuggestedContentsRes$RESPONSE0) {
        if(albumSuggestedContentsRes$RESPONSE0.recmList != null && albumSuggestedContentsRes$RESPONSE0.recmList.size() != 0) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: albumSuggestedContentsRes$RESPONSE0.recmList) {
                arrayList0.add(new vd.P(((RECMLIST)object0).relatTitle, ((RECMLIST)object0).recmTypeCode, ((RECMLIST)object0).contsTypeCode, ((RECMLIST)object0).contsId, ((RECMLIST)object0).contsName, ((RECMLIST)object0).contsImg, ((RECMLIST)object0).chnllSeq, ((RECMLIST)object0).link, ((RECMLIST)object0).playTime));
            }
            com.melon.ui.popup.b.q(this.getChildFragmentManager(), (TextUtils.isEmpty(albumSuggestedContentsRes$RESPONSE0.popupTitle) ? "이 앨범을 좋아하신 다면!" : albumSuggestedContentsRes$RESPONSE0.popupTitle), arrayList0, albumSuggestedContentsRes$RESPONSE0.menuId);
            return;
        }
        LogU.w("MelonBaseFragment", "showRecommendContentsPopup() >> invalid parameter");
    }

    public void showArtistInfoPage(Playable playable0) {
        this.showArtistInfoPage(playable0, false);
    }

    public void showArtistInfoPage(Playable playable0, boolean z) {
        this.showArtistInfoPage(playable0, z, null);
    }

    public void showArtistInfoPage(Playable playable0, boolean z, OnArtistClickListener melonBaseFragment$OnArtistClickListener0) {
        if(playable0 == null) {
            LogU.w("MelonBaseFragment", "showArtistInfoPage() invalid playable");
            return;
        }
        Map map0 = playable0.getArtists();
        if(map0 == null) {
            LogU.w("MelonBaseFragment", "showArtistInfoPage() invalid artists");
            return;
        }
        LogU.d("MelonBaseFragment", "showArtistInfoPage() artist size : " + map0.size());
        if(map0.size() > 1) {
            this.showMultiArtistPopup(map0, new OnArtistClickListener() {
                @Override  // com.iloen.melon.fragments.MelonBaseFragment$OnArtistClickListener
                public void onAfterClick(String s, String s1) {
                    OnArtistClickListener melonBaseFragment$OnArtistClickListener0 = melonBaseFragment$OnArtistClickListener0;
                    if(melonBaseFragment$OnArtistClickListener0 != null) {
                        melonBaseFragment$OnArtistClickListener0.onAfterClick(s, s1);
                    }
                }

                @Override  // com.iloen.melon.fragments.MelonBaseFragment$OnArtistClickListener
                public void onBeforeClick(String s, String s1) {
                    OnArtistClickListener melonBaseFragment$OnArtistClickListener0 = melonBaseFragment$OnArtistClickListener0;
                    if(melonBaseFragment$OnArtistClickListener0 != null) {
                        melonBaseFragment$OnArtistClickListener0.onBeforeClick(s, s1);
                    }
                }
            });
            return;
        }
        String s = playable0.getArtistid();
        if(TextUtils.isEmpty(s)) {
            if(playable0.hasSongId()) {
                TaskGetSongInfo taskGetSongInfo0 = new TaskGetSongInfo("", playable0.getCtype());
                taskGetSongInfo0.setResultListener(new ResultListener() {
                    @Override  // com.iloen.melon.task.request.TaskGetSongInfo$ResultListener
                    public void onFinishTask(Throwable throwable0) {
                        SongInfoBase songInfoBase0;
                        if(MelonBaseFragment.this.isFragmentValid()) {
                            MelonBaseFragment.this.dismissProgressDialog();
                            String s = null;
                            if(throwable0 == null) {
                                songInfoBase0 = taskGetSongInfo0.getSongInfo();
                                if(songInfoBase0 != null) {
                                    playable0.updateFrom(songInfoBase0);
                                    if(MelonBaseFragment.this.isFragmentValid()) {
                                        if(StringIds.a(playable0.getArtistid(), StringIds.e)) {
                                            MelonBaseFragment.this.showArtistInfoPage(playable0);
                                        }
                                        else {
                                            LogU.e("MelonBaseFragment", "showArtistInfoPage() invalid artistId");
                                            ToastManager.show(0x7F13019B);  // string:cannot_find_artist_info "아티스트 정보가 없습니다."
                                        }
                                    }
                                }
                            }
                            else {
                                songInfoBase0 = null;
                            }
                            if((throwable0 != null || songInfoBase0 == null) && MelonBaseFragment.this.isFragmentValid()) {
                                if(throwable0 != null) {
                                    s = throwable0.getMessage();
                                }
                                if(TextUtils.isEmpty(s)) {
                                    s = "아티스트 정보가 없습니다.";
                                }
                                ToastManager.show(s);
                            }
                            OnArtistClickListener melonBaseFragment$OnArtistClickListener0 = melonBaseFragment$OnArtistClickListener0;
                            if(melonBaseFragment$OnArtistClickListener0 != null) {
                                melonBaseFragment$OnArtistClickListener0.onBeforeClick(s, "");
                                melonBaseFragment$OnArtistClickListener0.onAfterClick(s, "");
                            }
                        }
                    }

                    @Override  // com.iloen.melon.task.request.TaskGetSongInfo$ResultListener
                    public void onStartTask() {
                        MelonBaseFragment.this.showProgressDialog();
                    }
                });
                taskGetSongInfo0.executeAsync();
                return;
            }
            LogU.w("MelonBaseFragment", "showArtistInfoPage() invalid songId");
            return;
        }
        if(!StringIds.a(s, StringIds.e)) {
            LogU.w("MelonBaseFragment", "showArtistInfoPage() invalid artistId");
            if(z) {
                ToastManager.show(0x7F13019B);  // string:cannot_find_artist_info "아티스트 정보가 없습니다."
            }
            return;
        }
        this.showArtistInfoPage(s);
    }

    public void showArtistInfoPage(String s) {
        Navigator.openArtistInfo(s);
    }

    public void showArtistInfoPage(String s, String s1) {
        LogU.d("MelonBaseFragment", "showArtistInfoPage - ids:" + s + ", names:" + s1);
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        if(s != null) {
            StringTokenizer stringTokenizer0 = new StringTokenizer(s, ",");
            while(stringTokenizer0.hasMoreTokens()) {
                arrayList0.add(stringTokenizer0.nextToken());
            }
        }
        if(s1 != null) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(s1, ",");
            while(stringTokenizer1.hasMoreTokens()) {
                arrayList1.add(stringTokenizer1.nextToken());
            }
        }
        this.showArtistInfoPage(arrayList0, arrayList1);
    }

    public void showArtistInfoPage(ArrayList arrayList0) {
        this.showArtistInfoPage(arrayList0, false);
    }

    public void showArtistInfoPage(ArrayList arrayList0, ArrayList arrayList1) {
        if(arrayList0 != null && arrayList0.size() != 0) {
            if(arrayList1 != null && arrayList1.size() != 0) {
                if(arrayList0.size() > 1 && arrayList1.size() > 1) {
                    this.showMultiArtistPopup(arrayList0, arrayList1);
                    return;
                }
                String s = (String)arrayList0.get(0);
                if(!StringIds.a(s, StringIds.e)) {
                    return;
                }
                this.showArtistInfoPage(s);
                return;
            }
            LogU.w("MelonBaseFragment", "showArtistInfoPage() invalid artistNames");
            return;
        }
        LogU.w("MelonBaseFragment", "showArtistInfoPage() invalid artistIds");
    }

    public void showArtistInfoPage(ArrayList arrayList0, boolean z) {
        if(arrayList0 != null) {
            switch(arrayList0.size()) {
                case 0: {
                    break;
                }
                case 1: {
                    String s = ((ArtistsInfoBase)arrayList0.get(0)).getArtistId();
                    if(StringIds.a(s, StringIds.e)) {
                        this.showArtistInfoPage(s);
                        return;
                    }
                    return;
                }
                default: {
                    if(arrayList0.size() > 1) {
                        this.showMultiArtistPopup(arrayList0, null, z, null);
                        return;
                    }
                    return;
                }
            }
        }
        LogU.w("MelonBaseFragment", "showArtistInfoPage() invalid paramter");
    }

    public final void showContextMenuAddTo() {
        this.showContextMenuAddTo(null, false);
    }

    public final void showContextMenuAddTo(Object object0, boolean z) {
        LogU.d("MelonBaseFragment", "showContextMenuAddTo  - userData:" + object0 + " isNowPlayingList:" + z);
        this.mPopupHandler.post(new Runnable() {
            public static H b() {
                return null;
            }

            private static H lambda$run$0() [...] // Inlined contents

            private H lambda$run$1(Object object0, k2 k20) {
                if(k20 instanceof K1) {
                    zd.M m0 = ((K1)k20).b.a;
                    if(m0 == zd.M.S) {
                        MelonBaseFragment.this.onAddToNowPlayingList(object0);
                        return null;
                    }
                    if(m0 == zd.M.T) {
                        MelonBaseFragment.this.onAddToPlaylist(object0);
                        return null;
                    }
                    if(m0 == zd.M.W) {
                        MelonBaseFragment.this.onAddToDJCollection(object0);
                    }
                }
                return null;
            }

            @Override
            public void run() {
                if(!MelonBaseFragment.this.isPossiblePopupShow()) {
                    return;
                }
                boolean z = ((e0)va.o.a()).j().getIsDj();
                k k0 = new k(z, false, z);
                l0 l00 = MelonBaseFragment.this.getChildFragmentManager();
                com.iloen.melon.fragments.p p0 = new com.iloen.melon.fragments.p(1);
                r r0 = new r(1, this, object0);
                com.melon.ui.popup.b.n(l00, k0, p0, E.a, r0);
            }
        });
    }

    public final void showDjPlaylistContextMenu(Object object0, boolean z) {
        LogU.d("MelonBaseFragment", "showContextMenuAddTo  - userData:" + object0 + " isNowPlayingList:" + z);
        if(!this.isPossiblePopupShow()) {
            return;
        }
        this.sendPopupMessage(2, object0);
    }

    public void showErrorPopup(String s, boolean z) {
        LogU.d("MelonBaseFragment", "showErrorPopup()");
        this.mPopupHandler.post(new Runnable() {
            @Override
            public void run() {
                if(MelonBaseFragment.this.isPossiblePopupShow()) {
                    FragmentActivity fragmentActivity0 = MelonBaseFragment.this.getActivity();
                    String s = MelonBaseFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                    com.iloen.melon.fragments.MelonBaseFragment.31.1 melonBaseFragment$31$10 = new DialogInterface.OnClickListener() {
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface dialogInterface0, int v) {
                            if(v == -1) {
                                com.iloen.melon.fragments.MelonBaseFragment.31 melonBaseFragment$310 = com.iloen.melon.fragments.MelonBaseFragment.31.this;
                                if(melonBaseFragment$310.val$performBackPressed) {
                                    MelonBaseFragment.this.performBackPress();
                                }
                            }
                        }
                    };
                    MelonTextPopup melonTextPopup0 = PopupHelper.showAlertPopup(fragmentActivity0, s, s, melonBaseFragment$31$10);
                    if(melonTextPopup0 != null) {
                        if(z) {
                            melonTextPopup0.setCancelable(false);
                        }
                        if(z) {
                            melonTextPopup0.setOnKeyListener(new DialogInterface.OnKeyListener() {
                                @Override  // android.content.DialogInterface$OnKeyListener
                                public boolean onKey(DialogInterface dialogInterface0, int v, KeyEvent keyEvent0) {
                                    if(4 == v) {
                                        if(dialogInterface0 != null) {
                                            dialogInterface0.dismiss();
                                        }
                                        MelonBaseFragment.this.performBackPress();
                                        return true;
                                    }
                                    return false;
                                }
                            });
                        }
                        melonTextPopup0.setOnDismissListener(MelonBaseFragment.this.mDialogDismissListener);
                        MelonBaseFragment.this.mRetainDialog = melonTextPopup0;
                    }
                }
            }
        });
    }

    public void showLocalPlaylistPopup() {
        LogU.d("MelonBaseFragment", "showLocalPlaylistPopup()");
        this.mPopupHandler.post(new Runnable() {
            @Override
            public void run() {
                ContextListItemBuilder contextListItemBuilder0 = ContextListItemBuilder.newInstance();
                i.a.f();
                List list0 = i.c();
                int v = list0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    H8.s s0 = (H8.s)list0.get(v1);
                    ContextItemInfo contextItemInfo0 = ContextItemInfo.a(new d(v1, s0.b, String.valueOf(s0.f)));
                    Params contextItemInfo$Params0 = new Params();
                    contextItemInfo$Params0.a = String.valueOf(s0.a);
                    contextItemInfo0.b(contextItemInfo$Params0);
                    contextListItemBuilder0.add(contextItemInfo0);
                }
                AddToPlaylistPopup addToPlaylistPopup0 = new AddToPlaylistPopup(MelonBaseFragment.this.getActivity());
                addToPlaylistPopup0.setTitle(MelonBaseFragment.this.getString(0x7F1300D6));  // string:alert_dlg_title_playlist_add_song_sel "로컬 플레이리스트에 담기"
                addToPlaylistPopup0.setListItems(contextListItemBuilder0.build());
                addToPlaylistPopup0.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override  // android.content.DialogInterface$OnCancelListener
                    public void onCancel(DialogInterface dialogInterface0) {
                        MelonBaseFragment.this.onCancelAddToToLocalPlaylist();
                    }
                });
                addToPlaylistPopup0.setOnPopupClickListener(new PopupClickListener() {
                    @Override  // com.iloen.melon.popup.AddToPlaylistPopup$PopupClickListener
                    public void onAddNewListEvent(String s, String s1) {
                        MelonBaseFragment.this.onLocalPlaylistAddPopupOk(s);
                    }

                    @Override  // com.iloen.melon.popup.AddToPlaylistPopup$PopupClickListener
                    public void onClickListItemEvent(int v, ContextItemInfo contextItemInfo0) {
                        String s = contextItemInfo0.c.a;
                        Z.w("showLocalPlaylistPopup() playlistId:", s, "MelonBaseFragment");
                        MelonBaseFragment.this.onLocalPlaylistTrackAddClick(s);
                        MelonBaseFragment.this.showProgress(false);
                    }

                    @Override  // com.iloen.melon.popup.AddToPlaylistPopup$PopupClickListener
                    public void onMoveToDjPlaylistEvent() {
                    }
                });
                addToPlaylistPopup0.setOnDismissListener(MelonBaseFragment.this.mDialogDismissListener);
                MelonBaseFragment.this.mRetainDialog = addToPlaylistPopup0;
                addToPlaylistPopup0.show();
            }
        });
    }

    public void showLocalPlaylistPopup(Playable playable0) {
        LogU.d("MelonBaseFragment", "showLocalPlaylistPopup()");
        this.mPopupHandler.post(new Runnable() {
            @Override
            public void run() {
                ContextListItemBuilder contextListItemBuilder0 = ContextListItemBuilder.newInstance();
                i.a.f();
                List list0 = i.c();
                int v = list0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    H8.s s0 = (H8.s)list0.get(v1);
                    ContextItemInfo contextItemInfo0 = ContextItemInfo.a(new d(v1, s0.b, String.valueOf(s0.f)));
                    Params contextItemInfo$Params0 = new Params();
                    contextItemInfo$Params0.a = String.valueOf(s0.a);
                    contextItemInfo0.b(contextItemInfo$Params0);
                    contextListItemBuilder0.add(contextItemInfo0);
                }
                AddToPlaylistPopup addToPlaylistPopup0 = new AddToPlaylistPopup(MelonBaseFragment.this.getActivity());
                addToPlaylistPopup0.setTitle(MelonBaseFragment.this.getString(0x7F1300D6));  // string:alert_dlg_title_playlist_add_song_sel "로컬 플레이리스트에 담기"
                addToPlaylistPopup0.setListItems(contextListItemBuilder0.build());
                addToPlaylistPopup0.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override  // android.content.DialogInterface$OnCancelListener
                    public void onCancel(DialogInterface dialogInterface0) {
                        MelonBaseFragment.this.onCancelAddToToLocalPlaylist();
                    }
                });
                addToPlaylistPopup0.setOnPopupClickListener(new PopupClickListener() {
                    @Override  // com.iloen.melon.popup.AddToPlaylistPopup$PopupClickListener
                    public void onAddNewListEvent(String s, String s1) {
                        MelonBaseFragment.this.onLocalPlaylistAddPopupOk(s);
                    }

                    @Override  // com.iloen.melon.popup.AddToPlaylistPopup$PopupClickListener
                    public void onClickListItemEvent(int v, ContextItemInfo contextItemInfo0) {
                        String s = contextItemInfo0.c.a;
                        Z.w("showLocalPlaylistPopup() playlistId:", s, "MelonBaseFragment");
                        MelonBaseFragment.this.onLocalPlaylistTrackAddClick(s, com.iloen.melon.fragments.MelonBaseFragment.39.this.val$playable);
                        MelonBaseFragment.this.showProgress(false);
                    }

                    @Override  // com.iloen.melon.popup.AddToPlaylistPopup$PopupClickListener
                    public void onMoveToDjPlaylistEvent() {
                    }
                });
                addToPlaylistPopup0.setOnDismissListener(MelonBaseFragment.this.mDialogDismissListener);
                MelonBaseFragment.this.mRetainDialog = addToPlaylistPopup0;
                addToPlaylistPopup0.show();
            }
        });
    }

    public void showLoginPopup() {
        this.showLoginPopup(r8.f.f, null);
    }

    public void showLoginPopup(DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        this.showLoginPopup(r8.f.f, dialogInterface$OnClickListener0);
    }

    public void showLoginPopup(Uri uri0) {
        this.showLoginPopup(uri0, null);
    }

    public void showLoginPopup(Uri uri0, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        LogU.d("MelonBaseFragment", "showLoginPopup() returnUri:" + uri0);
        if(this.getActivity() == null) {
            LogU.d("MelonBaseFragment", "showLoginPopup() invalid activity");
            return;
        }
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(MelonBaseFragment.this.isFragmentValid()) {
                    DevLog.get("Account").put("login require service");
                    MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopup(MelonBaseFragment.this.getActivity(), 1, "안내", "로그인이 필요한 서비스입니다.\n로그인하시겠습니까?", new DialogInterface.OnClickListener() {
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface dialogInterface0, int v) {
                            DialogInterface.OnClickListener dialogInterface$OnClickListener0 = com.iloen.melon.fragments.MelonBaseFragment.24.this.val$listener;
                            if(dialogInterface$OnClickListener0 != null) {
                                dialogInterface$OnClickListener0.onClick(dialogInterface0, v);
                            }
                            MelonBaseFragment.this.onShowLoginPopup(v);
                            if(v == -1) {
                                MelonBaseFragment.this.openLoginView(com.iloen.melon.fragments.MelonBaseFragment.24.this.val$returnUri);
                            }
                        }
                    });
                    if(melonTextPopup0 != null) {
                        MelonBaseFragment.this.mRetainDialog = melonTextPopup0;
                        melonTextPopup0.setCentFlag(true);
                        melonTextPopup0.setOnDismissListener(MelonBaseFragment.this.mDialogDismissListener);
                        melonTextPopup0.show();
                    }
                }
            }
        });
    }

    public void showMiniPlayer(boolean z) {
        LogU.v("MelonBaseFragment", "showMiniPlayer()");
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 instanceof com.iloen.melon.custom.V) {
            ((com.iloen.melon.custom.V)fragmentActivity0).setTabAndMiniPlayerVisible(true, z, false);
        }
    }

    public void showMultiArtistPopup(ArrayList arrayList0, OnArtistClickListener melonBaseFragment$OnArtistClickListener0, int v, boolean z, String s, DialogInterface.OnDismissListener dialogInterface$OnDismissListener0) {
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            if(!z && arrayList0.size() == 1) {
                String s1 = ((ArtistsInfoBase)arrayList0.get(0)).getArtistId();
                String s2 = ((ArtistsInfoBase)arrayList0.get(0)).getArtistName();
                if(melonBaseFragment$OnArtistClickListener0 != null) {
                    melonBaseFragment$OnArtistClickListener0.onBeforeClick(s1, s2);
                }
                this.showArtistInfoPage(s1);
                if(melonBaseFragment$OnArtistClickListener0 != null) {
                    melonBaseFragment$OnArtistClickListener0.onAfterClick(s1, s2);
                }
                return;
            }
            ArrayList arrayList1 = new ArrayList();
            for(Object object0: arrayList0) {
                LogU.d("MelonBaseFragment", "artist : " + ((ArtistsInfoBase)object0).getArtistName() + "   fan : " + "N");
                arrayList1.add(new ie.m(((ArtistsInfoBase)object0).getArtistId(), ((ArtistsInfoBase)object0).getArtistName()));
            }
            if(s == null || s.isEmpty()) {
                s = this.getString(0x7F130111);  // string:artist_channel_popup_artist_list_title "아티스트 선택"
            }
            com.melon.ui.popup.b.e(this.getChildFragmentManager(), s, arrayList1, v, this.mMenuId, new com.iloen.melon.fragments.t(this, 2));
            return;
        }
        LogU.w("MelonBaseFragment", "showMultiArtistPopup() >> invalid parameter");
    }

    public void showMultiArtistPopup(ArrayList arrayList0, OnArtistClickListener melonBaseFragment$OnArtistClickListener0, boolean z, String s) {
        this.showMultiArtistPopup(arrayList0, melonBaseFragment$OnArtistClickListener0, z, false, s, null);
    }

    public void showMultiArtistPopup(ArrayList arrayList0, OnArtistClickListener melonBaseFragment$OnArtistClickListener0, boolean z, boolean z1, String s, DialogInterface.OnDismissListener dialogInterface$OnDismissListener0) {
        if(z) {
            this.showMultiArtistPopup(arrayList0, melonBaseFragment$OnArtistClickListener0, 2, z1, s, dialogInterface$OnDismissListener0);
            return;
        }
        this.showMultiArtistPopup(arrayList0, melonBaseFragment$OnArtistClickListener0, 1, z1, s, dialogInterface$OnDismissListener0);
    }

    public void showMultiArtistPopup(ArrayList arrayList0, ArrayList arrayList1) {
        if(arrayList0 != null && arrayList0.size() != 0) {
            if(arrayList1 != null && arrayList1.size() != 0) {
                this.showMultiArtistPopup(new StringIds(arrayList0).d(arrayList1));  // 初始化器: Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
                return;
            }
            LogU.w("MelonBaseFragment", "showMultiArtistPopup() invalid artistNames");
            return;
        }
        LogU.w("MelonBaseFragment", "showMultiArtistPopup() invalid artistIds");
    }

    public void showMultiArtistPopup(Map map0) {
        this.showMultiArtistPopup(map0, null);
    }

    public void showMultiArtistPopup(Map map0, OnArtistClickListener melonBaseFragment$OnArtistClickListener0) {
        if(map0 != null && map0.size() != 0) {
            Iterator iterator0 = map0.entrySet().iterator();
            ArrayList arrayList0 = new ArrayList();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                ArtistInfoBase artistInfoBase0 = new ArtistInfoBase();
                artistInfoBase0.setArtistId(((String)((Map.Entry)object0).getKey()));
                artistInfoBase0.setArtistName(((String)((Map.Entry)object0).getValue()));
                arrayList0.add(artistInfoBase0);
            }
            this.showMultiArtistPopup(arrayList0, melonBaseFragment$OnArtistClickListener0, false, null);
            return;
        }
        LogU.w("MelonBaseFragment", "showMultiArtistPopup() invalid parameter");
    }

    @Deprecated
    public void showMultiCreatorPopup(CreatorInfoBase creatorInfoBase0) {
        String s1;
        if(creatorInfoBase0 == null) {
            LogU.w("MelonBaseFragment", "showMultiCreatorPopup() >> invalid parameter");
            return;
        }
        ArrayList arrayList0 = creatorInfoBase0.contsList;
        String s = creatorInfoBase0.contsTypeCode;
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            if(creatorInfoBase0.contsList.size() == 1) {
                if("N10006".equals(s)) {
                    this.showArtistInfoPage(((ContsList)arrayList0.get(0)).id);
                    return;
                }
                if(!"N10018".equals(s) && !"N10080".equals(s)) {
                    return;
                }
                this.showUserInfoPage(((ContsList)arrayList0.get(0)).id);
                return;
            }
            if("N10006".equals(s)) {
                s1 = this.getString(0x7F130111);  // string:artist_channel_popup_artist_list_title "아티스트 선택"
            }
            else if("N10018".equals(s)) {
                s1 = this.getString(0x7F13034D);  // string:dj_popup_list_title "DJ 선택"
            }
            else {
                s1 = "N10080".equals(s) ? this.getString(0x7F130185) : "";  // string:brand_dj_popup_list_title "브랜드 DJ 선택"
            }
            ArrayList arrayList1 = new ArrayList();
            for(Object object0: arrayList0) {
                LogU.d("MelonBaseFragment", "artist : " + ((ContsList)object0).name);
                arrayList1.add(new ie.m(((ContsList)object0).id, ((ContsList)object0).name));
            }
            com.melon.ui.popup.b.e(this.getChildFragmentManager(), s1, arrayList1, 1, this.mMenuId, new r(2, this, s));
            return;
        }
        LogU.w("MelonBaseFragment", "showMultiCreatorPopup() >> invalid parameter");
    }

    public void showMvInfoPage(Playable playable0) {
        if(playable0 == null) {
            LogU.w("MelonBaseFragment", "showMvInfoPage() invalid playable");
            return;
        }
        if(!NetUtils.isConnected() && this.isFragmentValid()) {
            this.showErrorPopup(this.getString(0x7F1303C6), false);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            return;
        }
        LogU.d("MelonBaseFragment", "showMvInfoPage() playable");
        if(PlayableExtensionsKt.isMvEnabled(playable0)) {
            this.showMvInfoPageBySongId("", "");
        }
    }

    public void showMvInfoPage(String s, String s1) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "showMvInfoPage() invalid mvId");
            return;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("MelonBaseFragment", "showMvInfoPage() invalid menuId");
            return;
        }
        this.playMvById(s, s1);
    }

    public void showMvInfoPageBySongId(String s, String s1) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "showMvInfoPage() invalid songId");
            return;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("MelonBaseFragment", "showMvInfoPage() invalid menuId");
            return;
        }
        LogU.d("MelonBaseFragment", "showMvInfoPage()");
        this.showProgress(true);
        RequestBuilder.newInstance(new MelonTvVdoStreamInAppReq(this.getContext(), s)).tag("MelonBaseFragment").listener(new Listener() {
            public void onResponse(MelonTvVdoStreamInAppRes melonTvVdoStreamInAppRes0) {
                MelonBaseFragment.this.showProgress(false);
                if(MelonBaseFragment.this.isFragmentValid() && melonTvVdoStreamInAppRes0.isSuccessful()) {
                    com.iloen.melon.net.v4x.response.MelonTvVdoStreamInAppRes.RESPONSE melonTvVdoStreamInAppRes$RESPONSE0 = melonTvVdoStreamInAppRes0.response;
                    if(melonTvVdoStreamInAppRes$RESPONSE0 != null) {
                        MelonBaseFragment.this.showMvInfoPage(melonTvVdoStreamInAppRes$RESPONSE0.cid, s1);
                    }
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MelonTvVdoStreamInAppRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                MelonBaseFragment.this.showProgress(false);
                ToastManager.show(HttpResponse.getErrorMessage(volleyError0));
            }
        }).request();
    }

    public void showNetwokSettingPopup() {
        LogU.d("MelonBaseFragment", "showNetwokSettingPopup()");
        this.mPopupHandler.post(new Runnable() {
            private static H lambda$run$0() {
                EventBusHelper.post(new EventShowWifiSettingPopup());
                return null;
            }

            @Override
            public void run() {
                if(!MelonBaseFragment.this.isPossiblePopupShow()) {
                    return;
                }
                com.melon.ui.popup.b.v(MelonBaseFragment.this.getChildFragmentManager(), "안내", "데이터 네트워크 차단 상태에서는\n단말에 저장된 콘텐츠만 재생이 가능합니다. 음악서랍>다운로드 로 이동하시겠습니까?", false, null, null, new com.iloen.melon.fragments.p(0), null);
            }
        });
    }

    public void showNetworkAlertPopup() {
        LogU.d("MelonBaseFragment", "showNetworkAlertPopup()");
        this.mPopupHandler.post(new Runnable() {
            @Override
            public void run() {
                if(!MelonBaseFragment.this.isPossiblePopupShow()) {
                    return;
                }
                l0 l00 = MelonBaseFragment.this.getChildFragmentManager();
                com.melon.ui.popup.b.a.c(l00, "네트워크 연결 확인", "데이터 네트워크 차단 상태입니다.\n차단 해제 또는 Wi-Fi설정 후 사용해주세요.");
            }
        });
    }

    public boolean showNetworkCheckOrSettingPopupIfNeed(Context context0) {
        switch(NetUtils.checkDataNetwork()) {
            case 2: {
                this.showNetworkCheckPopup();
                return false;
            }
            case 3: {
                this.showNetwokSettingPopup();
                return false;
            }
            default: {
                return true;
            }
        }
    }

    public void showNetworkCheckPopup() {
        LogU.d("MelonBaseFragment", "showNetworkCheckPopup()");
        this.mPopupHandler.post(new Runnable() {
            private H lambda$run$0() {
                ToastManager.show(0x7F1310E9);  // string:use_3g_setting_on "Wi-Fi가 연결되지 않았을 경우 데이터 네트워크를 사용합니다."
                MelonSettingInfo.setUseDataNetwork(true);
                return null;
            }

            private H lambda$run$1() {
                return null;
            }

            @Override
            public void run() {
                if(!MelonBaseFragment.this.isPossiblePopupShow()) {
                    return;
                }
                com.melon.ui.popup.b.v(MelonBaseFragment.this.getChildFragmentManager(), MelonBaseFragment.this.getString(0x7F1300D0), MelonBaseFragment.this.getString(0x7F1300AB), false, null, null, new com.iloen.melon.fragments.q(this, 0), new com.iloen.melon.fragments.q(this, 1));  // string:alert_dlg_title_info "안내"
            }
        });
    }

    public final void showPlaylistAddEditPopup(String s, PopupListener melonBaseFragment$PopupListener0) {
        this.mPopupListener = melonBaseFragment$PopupListener0;
        Z.w("showLocalPlaylistAddEditPopup() - editText:", s, "MelonBaseFragment");
        this.mPopupHandler.post(new Runnable() {
            private H lambda$run$0(String s) {
                MelonBaseFragment.this.onLocalPlaylistAddPopupOk(s);
                return null;
            }

            @Override
            public void run() {
                if(!MelonBaseFragment.this.isPossiblePopupShow()) {
                    return;
                }
                String s = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
                l0 l00 = MelonBaseFragment.this.getChildFragmentManager();
                com.iloen.melon.fragments.t t0 = new com.iloen.melon.fragments.t(this, 1);
                com.melon.ui.popup.b.j(l00, "새로만들기", null, s, MelonLimits.TextLimit.c.a, t0);
            }
        });
    }

    public final void showPlaylistAddEditPopup(String s, boolean z) {
        this.showPlaylistAddEditPopup(s, null);
    }

    public final void showPlaylistContextMenu(Object object0, boolean z) {
        LogU.d("MelonBaseFragment", "showContextMenuAddTo  - userData:" + object0 + " isNowPlayingList:" + z);
        if(!this.isPossiblePopupShow()) {
            return;
        }
        this.sendPopupMessage(1, object0);
    }

    public void showPlaylistEmptyAlertPopup(boolean z) {
        this.showRetainedAlertPopup(!z, this.getString(0x7F1300D0), this.getString(0x7F1300B2));  // string:alert_dlg_title_info "안내"
    }

    public void showPlaylistEqualNameAlertPopup(boolean z) {
        this.showRetainedAlertPopup(!z, this.getString(0x7F1300D0), (z ? this.getString(0x7F1300A8) : this.getString(0x7F1300B3)));  // string:alert_dlg_title_info "안내"
    }

    public void showPlaylistNameLimitAlertPopup(boolean z) {
        this.showRetainedAlertPopup(!z, this.getString(0x7F1300D0), this.getString(0x7F1300B4, new Object[]{MelonLimits.TextLimit.c.a}));  // string:alert_dlg_title_info "안내"
    }

    public void showProgress(boolean z) {
        __monitor_enter(this);
        if(this.progressUpdater == null) {
            __monitor_exit(this);
            return;
        }
        if(z) {
            try {
                if(this.isFragmentVisible) {
                    if(this.mProgressBarRefCount == 0) {
                        LogU.v("MelonBaseFragment", "showProgress() show , " + this);
                        this.progressUpdater.a(this.getClass().getSimpleName(), true);
                    }
                    ++this.mProgressBarRefCount;
                }
            }
            catch(Throwable throwable0) {
                __monitor_exit(this);
                throw throwable0;
            }
        }
        else {
            if(this.mProgressBarRefCount <= 0) {
                __monitor_exit(this);
                return;
            }
            try {
                --this.mProgressBarRefCount;
                if(this.mProgressBarRefCount == 0) {
                    LogU.v("MelonBaseFragment", "showProgress() hide , " + this);
                    this.progressUpdater.a(this.getClass().getSimpleName(), false);
                }
            label_18:
                LogU.v("MelonBaseFragment", "showProgress() refCount:" + this.mProgressBarRefCount);
                goto label_23;
            }
            catch(Throwable throwable0) {
            }
            __monitor_exit(this);
            throw throwable0;
        }
        goto label_18;
    label_23:
        __monitor_exit(this);
    }

    public void showProgressDialog() {
        if(this.isFragmentValid()) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(fragmentActivity0 instanceof BaseActivity) {
                ((BaseActivity)fragmentActivity0).showMelonProgressDialog("");
            }
        }
    }

    public void showRatingPopup(String s) {
        Z.w("showRatingPopup() albumId:", s, "MelonBaseFragment");
        this.mPopupHandler.post(new Runnable() {
            private H lambda$run$0(String s, Float float0) {
                MelonBaseFragment.this.onUpdateRatingInfo(s, ((float)float0));
                return null;
            }

            @Override
            public void run() {
                if(MelonBaseFragment.this.isPossiblePopupShow()) {
                    Context context0 = MelonBaseFragment.this.getContext();
                    l0 l00 = MelonBaseFragment.this.getChildFragmentManager();
                    r r0 = new r(0, this, s);
                    if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K && context0 != null) {
                        l00.C();
                        if(com.melon.ui.popup.b.b(l00, "showRatingPopup", null, new Cc.n(context0, 14), 4) == null) {
                            e3.h.t("평점 주기", null, null, true, null, "확인", new hd.i(r0, 29), null, false, true, vd.h.c, false, null, 0xF356).show(l00, "showRatingPopup");
                        }
                    }
                }
            }
        });
    }

    public void showRecommendAlbumContentsPopup(String s) {
        RequestBuilder.newInstance(new AlbumSuggestedContentsReq(this.getContext(), s)).tag("MelonBaseFragment").listener(new Listener() {
            public void onResponse(AlbumSuggestedContentsRes albumSuggestedContentsRes0) {
                if(MelonBaseFragment.this.isFragmentValid() && albumSuggestedContentsRes0.isSuccessful()) {
                    com.iloen.melon.net.v4x.response.AlbumSuggestedContentsRes.RESPONSE albumSuggestedContentsRes$RESPONSE0 = albumSuggestedContentsRes0.response;
                    if(albumSuggestedContentsRes$RESPONSE0 != null) {
                        MelonBaseFragment.this.showAlbumbRcmdCntsPopup(albumSuggestedContentsRes$RESPONSE0);
                    }
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((AlbumSuggestedContentsRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                LogU.w("MelonBaseFragment", volleyError0.toString());
            }
        }).request();
    }

    public void showRecommendContentsPopup(com.iloen.melon.net.v4x.response.ArtistRecomContsRes.RESPONSE artistRecomContsRes$RESPONSE0) {
        if(artistRecomContsRes$RESPONSE0.contsList != null && artistRecomContsRes$RESPONSE0.contsList.size() != 0) {
            int v = 0;
            for(Object object0: artistRecomContsRes$RESPONSE0.contsList) {
                ContsTypeCode contsTypeCode0 = ContsTypeCode.valueOf(((CONTSLIST)object0).contsTypeCode);
                boolean z = ContsTypeCode.PHOTO.equals(contsTypeCode0);
                int v1 = !z;
                if(!z) {
                    v = v1;
                    break;
                }
                v = v1;
            }
            if(v == 0) {
                return;
            }
            ArrayList arrayList0 = new ArrayList();
            for(Object object1: artistRecomContsRes$RESPONSE0.contsList) {
                arrayList0.add(new vd.P(((CONTSLIST)object1).title, ((CONTSLIST)object1).type, ((CONTSLIST)object1).contsTypeCode, ((CONTSLIST)object1).contsId, ((CONTSLIST)object1).contsName, ((CONTSLIST)object1).contsImg, ((CONTSLIST)object1).chnllSeq, ((CONTSLIST)object1).link, ((CONTSLIST)object1).playTime));
            }
            com.melon.ui.popup.b.q(this.getChildFragmentManager(), (TextUtils.isEmpty(artistRecomContsRes$RESPONSE0.message) ? "팬이 되셨다면!" : artistRecomContsRes$RESPONSE0.message), arrayList0, artistRecomContsRes$RESPONSE0.menuId);
            return;
        }
        LogU.w("MelonBaseFragment", "showRecommendContentsPopup() >> invalid parameter");
    }

    public void showRecommendContentsPopup(String s, String s1) {
        RequestBuilder.newInstance(new ArtistRecomContsReq(this.getContext(), s, s1)).tag("MelonBaseFragment").listener(new Listener() {
            public void onResponse(ArtistRecomContsRes artistRecomContsRes0) {
                if(MelonBaseFragment.this.isFragmentValid() && artistRecomContsRes0.isSuccessful()) {
                    com.iloen.melon.net.v4x.response.ArtistRecomContsRes.RESPONSE artistRecomContsRes$RESPONSE0 = artistRecomContsRes0.response;
                    if(artistRecomContsRes$RESPONSE0 != null) {
                        MelonBaseFragment.this.showRecommendContentsPopup(artistRecomContsRes$RESPONSE0);
                    }
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((ArtistRecomContsRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                LogU.w("MelonBaseFragment", volleyError0.toString());
            }
        }).request();
    }

    public void showRetainedAlertPopup(int v, String s, String s1) {
        LogU.d("MelonBaseFragment", "showRetainedAlertPopup()");
        this.mPopupHandler.post(new Runnable() {
            @Override
            public void run() {
                if(!MelonBaseFragment.this.isPossiblePopupShow()) {
                    return;
                }
                FragmentActivity fragmentActivity0 = MelonBaseFragment.this.getActivity();
                com.iloen.melon.fragments.MelonBaseFragment.29.1 melonBaseFragment$29$10 = new DialogInterface.OnClickListener() {
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface dialogInterface0, int v) {
                    }
                };
                MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopup(fragmentActivity0, 0, s, s1, melonBaseFragment$29$10);
                melonTextPopup0.setOnDismissListener(MelonBaseFragment.this.mDialogDismissListener);
                MelonBaseFragment.this.mRetainDialog = melonTextPopup0;
                melonTextPopup0.show();
            }
        });
    }

    public void showRetainedConfirmPopup(int v, String s, String s1) {
        LogU.d("MelonBaseFragment", "showRetainedConfirmPopup()");
        this.mPopupHandler.post(new Runnable() {
            @Override
            public void run() {
                if(!MelonBaseFragment.this.isPossiblePopupShow()) {
                    return;
                }
                FragmentActivity fragmentActivity0 = MelonBaseFragment.this.getActivity();
                com.iloen.melon.fragments.MelonBaseFragment.30.1 melonBaseFragment$30$10 = new DialogInterface.OnClickListener() {
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface dialogInterface0, int v) {
                        if(v == -1) {
                            MelonBaseFragment.this.onRetainedPopupOk(com.iloen.melon.fragments.MelonBaseFragment.30.this.val$id);
                        }
                    }
                };
                MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopup(fragmentActivity0, 1, s, s1, melonBaseFragment$30$10);
                melonTextPopup0.setOnDismissListener(MelonBaseFragment.this.mDialogDismissListener);
                MelonBaseFragment.this.mRetainDialog = melonTextPopup0;
                melonTextPopup0.show();
            }
        });
    }

    public void showSNSListPopup(View view0, Sharable sharable0) {
        this.showSNSListPopup(view0, sharable0, null, null);
    }

    public void showSNSListPopup(View view0, Sharable sharable0, OnSNSLinkClickListener melonBaseFragment$OnSNSLinkClickListener0, OnDismissListener melonBottomSheetBaseFragment$OnDismissListener0) {
        LogU.d("MelonBaseFragment", "showSNSListPopup() : " + sharable0);
        if(sharable0 == null || !this.isAdded()) {
            return;
        }
        this.showProgress(false);
        this.mPopupHandler.post(new Runnable() {
            private static H lambda$run$0(OnDismissListener melonBottomSheetBaseFragment$OnDismissListener0) {
                if(melonBottomSheetBaseFragment$OnDismissListener0 != null) {
                    melonBottomSheetBaseFragment$OnDismissListener0.dismiss();
                }
                return null;
            }

            private H lambda$run$1(OnSNSLinkClickListener melonBaseFragment$OnSNSLinkClickListener0, Sharable sharable0, k2 k20) {
                Sharable sharable1;
                if(MelonBaseFragment.this.isFragmentValid()) {
                    zd.M m0 = ((K1)k20).b.a;
                    if(m0.equals(zd.M.g0)) {
                        if(!MelonBaseFragment.this.isLoginUser()) {
                            MelonBaseFragment.this.showLoginPopup();
                            return null;
                        }
                        if(melonBaseFragment$OnSNSLinkClickListener0 != null) {
                            melonBaseFragment$OnSNSLinkClickListener0.onLinkClick();
                        }
                        if(sharable0 instanceof SharableSong) {
                            Builder playable$Builder0 = Playable.newBuilder().songIdTitle(((SharableSong)sharable0).a, ((SharableSong)sharable0).b);
                            ((SharableBase)sharable0).getClass();
                            sharable1 = playable$Builder0.isAdult(false).cType(CType.SONG).albumId(((SharableSong)sharable0).d).artists(StringUtils.makeArtistMap("", ((SharableSong)sharable0).g)).build();
                        }
                        else {
                            if(sharable0 instanceof Playable) {
                                ((Playable)sharable0).isTypeOfSong();
                            }
                            sharable1 = sharable0;
                        }
                        Intent intent0 = new Intent(MelonBaseFragment.this.getActivity(), FriendSelectActivity.class);
                        intent0.putExtra("argTabTitleName", "친구 선택하기");
                        intent0.putExtra("argMaxResultCount", 10);
                        intent0.putExtra("argAttachedSharable", ((Parcelable)sharable1));
                        intent0.putExtra("argWhereRUFrom", 0);
                        MelonBaseFragment.this.searchFriendActivityResult.b(intent0);
                        pc.t.E(F.a.B(SnsManager.SnsType.f), sharable0);
                        return null;
                    }
                    if(m0.equals(zd.M.w0)) {
                        SnsTarget snsTarget0 = F.a.B(SnsManager.SnsType.h);
                        new com.iloen.melon.fragments.MelonBaseFragment.25.1(this, sharable0.getDisplayMessage(snsTarget0), sharable0, snsTarget0).execute(null);
                        return null;
                    }
                    if(m0.equals(zd.M.p0)) {
                        SnsManager.PostParam snsManager$PostParam0 = new SnsManager.PostParam();
                        snsManager$PostParam0.a = SnsManager.SnsType.d;
                        snsManager$PostParam0.c = sharable0;
                        snsManager$PostParam0.b = MelonBaseFragment.this.getActivity();
                        snsManager$PostParam0.d = sharable0.getDisplayMessage(new D());
                        F.a.getClass();
                        F.a.B(snsManager$PostParam0.a).a(snsManager$PostParam0, null);
                        return null;
                    }
                    if(m0.equals(zd.M.j0)) {
                        MelonBaseFragment.this.shareInstagram(sharable0);
                        return null;
                    }
                    if(m0.equals(zd.M.k0) || m0.equals(zd.M.l0)) {
                        MelonBaseFragment.this.executeFacebookPosting(sharable0);
                        return null;
                    }
                    if(m0.equals(zd.M.m0)) {
                        MelonBaseFragment.this.executeFacebookStoryPosting(sharable0);
                        return null;
                    }
                    if(m0.equals(zd.M.o0)) {
                        MelonBaseFragment.this.executeTwitterPosting(sharable0);
                        return null;
                    }
                    if(m0.equals(zd.M.n0)) {
                        SnsTarget snsTarget1 = F.a.B(SnsManager.SnsType.g);
                        SnsManager.PostParam snsManager$PostParam1 = new SnsManager.PostParam();
                        snsManager$PostParam1.a = SnsManager.SnsType.g;
                        snsManager$PostParam1.c = sharable0;
                        snsManager$PostParam1.b = MelonBaseFragment.this.getActivity();
                        snsManager$PostParam1.d = sharable0.getDisplayMessage(snsTarget1);
                        F.a.B(snsManager$PostParam1.a).a(snsManager$PostParam1, null);
                        pc.t.E(snsTarget1, sharable0);
                        return null;
                    }
                }
                return null;
            }

            @Override
            public void run() {
                if(!MelonBaseFragment.this.isPossiblePopupShow()) {
                    return;
                }
                String s = sharable0.getContentId();
                if(!TextUtils.isEmpty(s)) {
                    "-1".equals(s);
                }
                x0 x00 = new x0(sharable0);
                l0 l00 = MelonBaseFragment.this.getChildFragmentManager();
                com.iloen.melon.fragments.q q0 = new com.iloen.melon.fragments.q(melonBottomSheetBaseFragment$OnDismissListener0, 2);
                com.iloen.melon.fragments.s s1 = new com.iloen.melon.fragments.s(this, melonBaseFragment$OnSNSLinkClickListener0, sharable0, 0);
                com.melon.ui.popup.b.n(l00, x00, q0, E.a, s1);

                class com.iloen.melon.fragments.MelonBaseFragment.25.1 extends f {
                    public com.iloen.melon.fragments.MelonBaseFragment.25.1(String s, Sharable sharable0, SnsTarget snsTarget0) {
                    }

                    @Override  // x8.f
                    public Object backgroundWork(Object object0, Continuation continuation0) {
                        return this.backgroundWork(((Void)object0), continuation0);
                    }

                    public Object backgroundWork(Void void0, Continuation continuation0) {
                        StringBuilder stringBuilder0 = new StringBuilder();
                        if(!TextUtils.isEmpty(this.val$text)) {
                            stringBuilder0.append(this.val$text);
                        }
                        stringBuilder0.append("\n");
                        stringBuilder0.append(this.val$s.getShareGatePageUrl(this.val$targetOther, true));
                        stringBuilder0.append("\n#Melon");
                        return stringBuilder0.toString();
                    }

                    @Override  // x8.f
                    public void postTask(Object object0) {
                        this.postTask(((String)object0));
                    }

                    public void postTask(String s) {
                        if(!MelonBaseFragment.this.isFragmentValid()) {
                            LogU.i("MelonBaseFragment", "showSNSListPopup() Share Other >> invalid fragment");
                            return;
                        }
                        LogU.i("MelonBaseFragment", "Share Other >> message: " + s);
                        if(!TextUtils.isEmpty(s)) {
                            Intent intent0 = new Intent("android.intent.action.SEND");
                            intent0.addCategory("android.intent.category.DEFAULT");
                            intent0.putExtra("android.intent.extra.TEXT", s);
                            intent0.setType("text/plain");
                            Intent intent1 = Intent.createChooser(intent0, MelonBaseFragment.this.getString(0x7F130291));  // string:ctx_menu_share_more_popup_title "공유"
                            MelonBaseFragment.this.startActivity(intent1);
                            Sharable sharable0 = this.val$s;
                            if(sharable0 != null) {
                                pc.t.E(this.val$targetOther, sharable0);
                            }
                        }
                    }
                }

            }
        });
    }

    public void showSNSListPopup(Sharable sharable0) {
        this.showSNSListPopup(null, sharable0);
    }

    public void showSNSListPopup(Sharable sharable0, OnDismissListener melonBottomSheetBaseFragment$OnDismissListener0) {
        this.showSNSListPopup(null, sharable0, null, melonBottomSheetBaseFragment$OnDismissListener0);
    }

    public void showSongInfoPage(Playable playable0) {
        if(playable0 == null) {
            LogU.w("MelonBaseFragment", "showSongInfoPage() invalid playable");
            return;
        }
        LogU.d("MelonBaseFragment", "showSongInfoPage() playable");
        this.showSongInfoPage("");
    }

    public void showSongInfoPage(String s) {
        Navigator.openSongInfo(s);
    }

    public void showTrackAddToLocalPlaylistPopup(String s) {
        this.showTrackAddToLocalPlaylistPopup(s, new OnBottomSheetItemClickListener() {
            @Override  // com.iloen.melon.fragments.OnBottomSheetItemClickListener
            public void onItemClick(zd.M m0) {
                if(zd.M.S.equals(m0)) {
                    MelonBaseFragment.this.onAddToNowPlayingList(null);
                    return;
                }
                if(zd.M.T.equals(m0)) {
                    MelonBaseFragment.this.onAddToPlaylist(null);
                    return;
                }
                if(zd.M.V.equals(m0)) {
                    MelonBaseFragment.this.showLocalPlaylistPopup();
                }
            }
        });
    }

    public void showTrackAddToLocalPlaylistPopup(String s, OnBottomSheetItemClickListener onBottomSheetItemClickListener0) {
        LogU.d("MelonBaseFragment", "showTrackAddToLocalPlaylistPopup()");
        this.mPopupHandler.post(new Runnable() {
            public static H a() {
                return null;
            }

            private static H lambda$run$0() [...] // Inlined contents

            private static H lambda$run$1(OnBottomSheetItemClickListener onBottomSheetItemClickListener0, k2 k20) {
                if(k20 instanceof K1) {
                    onBottomSheetItemClickListener0.onItemClick(((K1)k20).b.a);
                }
                return null;
            }

            @Override
            public void run() {
                if(!MelonBaseFragment.this.isPossiblePopupShow()) {
                    return;
                }
                k k0 = new k(false, true, ((e0)va.o.a()).j().getIsDj());
                l0 l00 = MelonBaseFragment.this.getChildFragmentManager();
                com.iloen.melon.fragments.p p0 = new com.iloen.melon.fragments.p(2);
                com.iloen.melon.fragments.t t0 = new com.iloen.melon.fragments.t(onBottomSheetItemClickListener0, 0);
                com.melon.ui.popup.b.n(l00, k0, p0, E.a, t0);
            }
        });
    }

    private void showUserInfoPage(String s) {
        Navigator.openUserMain(s);
    }

    @Override  // androidx.fragment.app.I
    public void startActivityForResult(Intent intent0, int v) {
        I i0 = this.getParentFragment();
        if(i0 != null && !(this instanceof a9.f)) {
            i0.startActivityForResult(intent0, v);
            return;
        }
        super.startActivityForResult(intent0, v);
    }

    public static void u(MelonBaseFragment melonBaseFragment0, int v, String s) {
        melonBaseFragment0.lambda$fetchAndSelectPlaylist$9(v, s);
    }

    public void updateFan(String s, String s1, boolean z, String s2, OnJobFinishListener likeUpdateAsyncTask$OnJobFinishListener0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "updateFan() invalid contsId");
            return;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("MelonBaseFragment", "updateFan() invalid contsTypeCode");
            return;
        }
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        if(z) {
            new FanAnimationPopup(this.getActivity()).show();
        }
        LikeUpdateAsyncTask likeUpdateAsyncTask0 = new LikeUpdateAsyncTask("N20004", s, s1, z, s2, "");
        likeUpdateAsyncTask0.setOnJobFinishListener(likeUpdateAsyncTask$OnJobFinishListener0);
        likeUpdateAsyncTask0.execute(null);
    }

    public void updateLike(String s, String s1, boolean z, String s2, OnJobFinishListener likeUpdateAsyncTask$OnJobFinishListener0) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "updateLike() invalid contsId");
            return;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("MelonBaseFragment", "updateLike() invalid contsTypeCode");
            return;
        }
        if(!NetUtils.isConnected()) {
            ToastManager.show(0x7F1303DA);  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
            return;
        }
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        if(z && !"N10022".equals(s1)) {
            new LikeAnimationPopup(this.getActivity()).show();
        }
        LikeUpdateAsyncTask likeUpdateAsyncTask0 = new LikeUpdateAsyncTask("N20001", s, s1, z, s2, "");
        likeUpdateAsyncTask0.setOnJobFinishListener(likeUpdateAsyncTask$OnJobFinishListener0);
        likeUpdateAsyncTask0.execute(null);
    }

    public void updateSubscribe(String s, String s1, boolean z, String s2, OnJobFinishListener likeUpdateAsyncTask$OnJobFinishListener0) {
        String s3;
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonBaseFragment", "updateLike() invalid contsId");
            return;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("MelonBaseFragment", "updateLike() invalid contsTypeCode");
            return;
        }
        if(!NetUtils.isConnected()) {
            ToastManager.show(0x7F1303DA);  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
            return;
        }
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        if(!SystemSettingUtils.areNotificationsEnabled(this.getContext())) {
            s3 = "apns";
        }
        else if(this.getContext() == null) {
            s3 = "popup";
        }
        else {
            Context context0 = this.getContext();
            q.g(context0, "context");
            s3 = "Y".equals(context0.getSharedPreferences("pushinfo", 0).getString("NOTIFY_YN", "")) ? "msg" : "popup";
        }
        LikeUpdateAsyncTask likeUpdateAsyncTask0 = new LikeUpdateAsyncTask("N20001", s, s1, z, s2, s3);
        likeUpdateAsyncTask0.setOnJobFinishListener(likeUpdateAsyncTask$OnJobFinishListener0);
        likeUpdateAsyncTask0.execute(null);
    }

    public static void y(MelonBaseFragment melonBaseFragment0, String s) {
        melonBaseFragment0.fetchAndSelectPlaylist(4, s);
    }

    public static void z(MelonBaseFragment melonBaseFragment0, Sharable sharable0, SnsManager.SnsType snsManager$SnsType0) {
        melonBaseFragment0.shareSnsAppToAppImpl(sharable0, snsManager$SnsType0);
    }
}

