package com.iloen.melon.fragments.webview;

import A8.M;
import De.d;
import E9.w;
import F8.o;
import Ma.m;
import S2.c;
import U4.x;
import Y8.h;
import Z8.k;
import Zc.N;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.f0;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import co.ab180.airbridge.Airbridge;
import com.android.volley.VolleyError;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.constants.CType;
import com.iloen.melon.custom.I1;
import com.iloen.melon.custom.MelonWebView;
import com.iloen.melon.custom.MelonWebViewInterface;
import com.iloen.melon.custom.MelonWebViewListener;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.U0;
import com.iloen.melon.custom.U;
import com.iloen.melon.custom.r1;
import com.iloen.melon.custom.s1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.custom.x0;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventComment;
import com.iloen.melon.eventbus.EventWebView.CloseAndGoAppHome;
import com.iloen.melon.eventbus.EventWebView.DialogClose;
import com.iloen.melon.eventbus.EventWebView.Error;
import com.iloen.melon.eventbus.EventWebView.InputMethodVisible;
import com.iloen.melon.eventbus.EventWebView.KakaoEmoticonPopup;
import com.iloen.melon.eventbus.EventWebView.Load;
import com.iloen.melon.eventbus.EventWebView.OpenUri;
import com.iloen.melon.eventbus.EventWebView.ShowPayAppInstall;
import com.iloen.melon.eventbus.EventWebView.UncheckAll;
import com.iloen.melon.eventbus.EventWebViewClose.CloseView;
import com.iloen.melon.fragments.detail.DetailLikePersonListFragment;
import com.iloen.melon.fragments.melonchart.StreamingCardFragment;
import com.iloen.melon.fragments.radio.a;
import com.iloen.melon.fragments.settings.SettingMainFragment;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.UaLogDummyReq;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable.Builder;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.AddAction.Add;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddAction.VideoPlayAndOpen;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.player.playlist.tiara.ToolbarTiaraLogHelper;
import com.iloen.melon.popup.Category;
import com.iloen.melon.popup.ContextListPopup.OnMenuItemClickListener;
import com.iloen.melon.popup.ContextListPopup;
import com.iloen.melon.popup.MelonBaseListPopup;
import com.iloen.melon.popup.MelonCategoryPopup;
import com.iloen.melon.popup.MelonDcfMoreInfoPopup;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.popup.PopupClickLogHelper;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.sns.model.SharableAlbum;
import com.iloen.melon.sns.model.SharableArtist;
import com.iloen.melon.sns.model.SharableArtistFriendship;
import com.iloen.melon.sns.model.SharableContent;
import com.iloen.melon.sns.model.SharableMelOnAward;
import com.iloen.melon.sns.model.SharablePlaylist;
import com.iloen.melon.sns.model.SharableSong;
import com.iloen.melon.types.BasicNameValuePair;
import com.iloen.melon.types.ContextItemInfo.Params;
import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.ContextItemType;
import com.iloen.melon.types.Song;
import com.iloen.melon.userstore.VolatileDatabase_Impl;
import com.iloen.melon.userstore.entity.RestoreDataEntity;
import com.iloen.melon.utils.ContextListItemBuilder;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.MenuIdQueue;
import com.iloen.melon.utils.NameValuePairList;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.billing.BillingUtils;
import com.iloen.melon.utils.cipher.SimpleCrypto;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.CookieHelper;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewTreeObserverHelper.OnGlobalLayoutListener;
import com.iloen.melon.utils.ui.ViewTreeObserverHelper;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.WebViewUtils;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.ui.H1;
import com.melon.ui.J1;
import com.melon.ui.K1;
import com.melon.ui.M1;
import com.melon.ui.N1;
import com.melon.ui.X1;
import com.melon.ui.c2;
import com.melon.ui.e2;
import com.melon.ui.f2;
import com.melon.ui.h2;
import com.melon.ui.i2;
import com.melon.ui.k2;
import com.melon.ui.popup.context.more.ExtraProperties.Link;
import com.melon.ui.w1;
import com.melon.ui.x1;
import e.b;
import e1.u;
import ie.H;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import jeb.synthetic.TWR;
import k8.Y;
import kc.s2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import m9.l;
import ob.z;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p8.O;
import pb.j;
import pc.l1;
import r8.f;
import sd.g;
import v9.i;
import va.e0;
import va.e;
import vd.E;
import z9.P;
import zd.A0;

public class MelonWebViewFragment extends Hilt_MelonWebViewFragment implements MelonWebViewInterface, MelonWebViewListener, x0 {
    static class UiHandler extends U0 {
        public UiHandler(MelonWebViewFragment melonWebViewFragment0) {
            super(melonWebViewFragment0);
        }

        public void handleMessage(MelonWebViewFragment melonWebViewFragment0, Message message0) {
            switch(message0.what) {
                case 2: {
                    melonWebViewFragment0.showToolbarHandler(true);
                    return;
                }
                case 3: {
                    melonWebViewFragment0.showToolbarHandler(false);
                    return;
                }
                case 4: {
                    LogU.d("MelonWebViewFragment", "handle back press - this:" + this);
                    FragmentActivity fragmentActivity0 = melonWebViewFragment0.getActivity();
                    if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
                        if(fragmentActivity0 instanceof BaseActivity) {
                            ((BaseActivity)fragmentActivity0).navigateBack();
                        }
                        else {
                            LogU.d("MelonWebViewFragment", "move to home url");
                            melonWebViewFragment0.goHome(true);
                        }
                    }
                    String s = message0.getData().getString("openUri");
                    if(s != null && !s.isEmpty()) {
                        EventBusHelper.post(new OpenUri(Uri.parse(s)));
                        return;
                    }
                    break;
                }
                case 5: {
                    MelonWebView melonWebView0 = melonWebViewFragment0.mWebView;
                    if(melonWebView0 != null) {
                        melonWebView0.reload();
                        return;
                    }
                    break;
                }
            }
        }

        @Override  // com.iloen.melon.custom.U0
        public void handleMessage(Object object0, Message message0) {
            this.handleMessage(((MelonWebViewFragment)object0), message0);
        }
    }

    static class WebContextListInfo {
        private String adultFlg;
        private String albumId;
        private String artistId;
        private String artistName;
        private String hasMv;
        private boolean isBrandDj;
        private boolean isService;
        private String menuId;
        private String mvId;
        private String mvSongId;
        private String prodsclascode;
        private String songId;
        private String thumbnail;
        private String title;
        private String type;

        private WebContextListInfo() {
            this.type = "";
            this.title = "";
            this.artistName = "";
            this.adultFlg = "";
            this.hasMv = "";
            this.menuId = "";
            this.songId = "";
            this.albumId = "";
            this.artistId = "";
            this.mvId = "";
            this.mvSongId = "";
            this.prodsclascode = "";
            this.thumbnail = "";
        }

        public WebContextListInfo(int v) {
        }

        public static void A(WebContextListInfo melonWebViewFragment$WebContextListInfo0, String s) {
            melonWebViewFragment$WebContextListInfo0.title = s;
        }

        public static void B(WebContextListInfo melonWebViewFragment$WebContextListInfo0, String s) {
            melonWebViewFragment$WebContextListInfo0.type = s;
        }

        public static void C(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            melonWebViewFragment$WebContextListInfo0.clear();
        }

        public static String a(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            return melonWebViewFragment$WebContextListInfo0.adultFlg;
        }

        public static String b(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            return melonWebViewFragment$WebContextListInfo0.albumId;
        }

        public static String c(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            return melonWebViewFragment$WebContextListInfo0.artistId;
        }

        private void clear() {
            this.type = "";
            this.title = "";
            this.artistName = "";
            this.adultFlg = "";
            this.hasMv = "";
            this.menuId = "";
            this.songId = "";
            this.albumId = "";
            this.artistId = "";
            this.mvId = "";
            this.mvSongId = "";
            this.prodsclascode = "";
            this.isService = false;
            this.isBrandDj = false;
            this.thumbnail = "";
        }

        public static String d(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            return melonWebViewFragment$WebContextListInfo0.artistName;
        }

        public static String e(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            return melonWebViewFragment$WebContextListInfo0.hasMv;
        }

        public static boolean f(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            return melonWebViewFragment$WebContextListInfo0.isBrandDj;
        }

        public static boolean g(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            return melonWebViewFragment$WebContextListInfo0.isService;
        }

        public static String h(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            return melonWebViewFragment$WebContextListInfo0.menuId;
        }

        public static String i(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            return melonWebViewFragment$WebContextListInfo0.mvId;
        }

        public static String j(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            return melonWebViewFragment$WebContextListInfo0.mvSongId;
        }

        public static String k(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            return melonWebViewFragment$WebContextListInfo0.songId;
        }

        public static String l(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            return melonWebViewFragment$WebContextListInfo0.thumbnail;
        }

        public static String m(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
            return melonWebViewFragment$WebContextListInfo0.title;
        }

        public static void n(WebContextListInfo melonWebViewFragment$WebContextListInfo0, String s) {
            melonWebViewFragment$WebContextListInfo0.adultFlg = s;
        }

        public static void o(WebContextListInfo melonWebViewFragment$WebContextListInfo0, String s) {
            melonWebViewFragment$WebContextListInfo0.albumId = s;
        }

        public static void p(WebContextListInfo melonWebViewFragment$WebContextListInfo0, String s) {
            melonWebViewFragment$WebContextListInfo0.artistId = s;
        }

        public static void q(WebContextListInfo melonWebViewFragment$WebContextListInfo0, String s) {
            melonWebViewFragment$WebContextListInfo0.artistName = s;
        }

        public static void r(WebContextListInfo melonWebViewFragment$WebContextListInfo0, String s) {
            melonWebViewFragment$WebContextListInfo0.hasMv = s;
        }

        public static void s(WebContextListInfo melonWebViewFragment$WebContextListInfo0, boolean z) {
            melonWebViewFragment$WebContextListInfo0.isBrandDj = z;
        }

        public static void t(WebContextListInfo melonWebViewFragment$WebContextListInfo0, boolean z) {
            melonWebViewFragment$WebContextListInfo0.isService = z;
        }

        @Override
        public String toString() [...] // 潜在的解密器

        public static void u(WebContextListInfo melonWebViewFragment$WebContextListInfo0, String s) {
            melonWebViewFragment$WebContextListInfo0.menuId = s;
        }

        public static void v(WebContextListInfo melonWebViewFragment$WebContextListInfo0, String s) {
            melonWebViewFragment$WebContextListInfo0.mvId = s;
        }

        public static void w(WebContextListInfo melonWebViewFragment$WebContextListInfo0, String s) {
            melonWebViewFragment$WebContextListInfo0.mvSongId = s;
        }

        public static void x(WebContextListInfo melonWebViewFragment$WebContextListInfo0, String s) {
            melonWebViewFragment$WebContextListInfo0.prodsclascode = s;
        }

        public static void y(WebContextListInfo melonWebViewFragment$WebContextListInfo0, String s) {
            melonWebViewFragment$WebContextListInfo0.songId = s;
        }

        public static void z(WebContextListInfo melonWebViewFragment$WebContextListInfo0, String s) {
            melonWebViewFragment$WebContextListInfo0.thumbnail = s;
        }
    }

    protected static final String KEY_ADDITIONAL_HTTP_HEADERS = "additionalHttpHeader";
    protected static final String KEY_DATA = "data";
    protected static final String KEY_IS_POST_METHOD = "isPostMethod";
    protected static final String KEY_OPEN_URI = "openUri";
    public static final String KEY_TYPE = "type";
    public static final String KEY_URL = "url";
    private static final String KEY_WEBVIEW_CHROMIUM_STATE = "WEBVIEW_CHROMIUM_STATE";
    private static final boolean LOGV = true;
    private static final int MSG_WHAT_FIRE_BACK_PRESS = 4;
    private static final int MSG_WHAT_HIDE_TOOLBAR = 3;
    private static final int MSG_WHAT_RELOAD = 5;
    private static final int MSG_WHAT_SHOW_TOOLBAR = 2;
    private static final String RESTORE_URLS = "restoreHistoryUrls";
    private static final String RESTORE_WEBVIEW = "restoreWebview";
    private static final String RESTORE_WEBVIEW_CHROME_STATE = "restoreWebviewChromeState";
    private static final String TAG = "MelonWebViewFragment";
    private static final int WEBVIEW_CHROMIUM_STATE_MAX_SIZE = 0x19000;
    private b activityResult;
    private boolean bEditMode;
    boolean isScreenLandscapeSupported;
    private I1 jsConnect;
    private Map mAdditionalHttpHeaders;
    private String mCameraPhotoPath;
    protected boolean mContextType;
    private WebContextListInfo mCtxInfo;
    private LinearLayout mErrorCustomErrorLayout;
    private ValueCallback mFilePathCallback;
    private UiHandler mHandler;
    private ArrayList mHistoryUrls;
    private boolean mIsFirstEntry;
    private boolean mIsPostMethod;
    private View mNetworkIconIv;
    private Dialog mRequestCommandDialog;
    private String mRootUrl;
    protected ToolBar mToolBar;
    private r1 mToolBarAnimationListener;
    private s1 mToolBarListener;
    private int mToolbarCount;
    private int mToolbarType;
    protected MelonWebView mWebView;
    private String[] myAlbumSongIds;
    private ViewTreeObserverHelper observerHelper;
    @Inject
    z playerUseCase;
    @Inject
    s2 playlistManager;

    public MelonWebViewFragment() {
        this.mHistoryUrls = new ArrayList();
        this.isScreenLandscapeSupported = true;
        this.mToolBar = null;
        this.bEditMode = false;
        this.mContextType = false;
        this.mCtxInfo = new WebContextListInfo(0);
        this.mIsFirstEntry = true;
        this.activityResult = this.registerForActivityResult(new f0(2), new a(this, 1));
        this.mToolBarAnimationListener = new r1() {
            @Override  // com.iloen.melon.custom.r1
            public void onToolBarAnimationEnd(boolean z) {
                if(!z) {
                    MelonWebViewFragment.this.showMiniPlayer(true);
                }
            }

            @Override  // com.iloen.melon.custom.r1
            public void onToolBarAnimationStart(boolean z) {
                if(z) {
                    MelonWebViewFragment.this.hideMiniPlayerForToolBar();
                }
                else {
                    MelonWebViewFragment.this.showMiniPlayer(true);
                }
                MelonWebViewFragment.r0(MelonWebViewFragment.this, z);
            }
        };
        this.mToolBarListener = new s1() {
            @Override  // com.iloen.melon.custom.s1
            public void onToolBarItemClicked(ToolBarItem toolBar$ToolBarItem0, int v) {
                if(1 == v || 2 == v || 14 == v) {
                    ToolbarTiaraLogHelper.sendClickLog(v);
                }
                if(v != 0 && 10 != v) {
                    if(0x1F == v) {
                        if(!NetUtils.showNetworkPopupOrToast(MelonWebViewFragment.this.getContext(), false)) {
                            return;
                        }
                        MelonWebView.i(MelonWebViewFragment.this, 12);
                        return;
                    }
                    if(1 != v && 3 != v) {
                        if(2 == v) {
                            if(!NetUtils.showNetworkPopupOrToast(MelonWebViewFragment.this.getContext(), false)) {
                                return;
                            }
                            MelonWebViewFragment.this.showContextMenuAddTo();
                            return;
                        }
                        if(14 != v || !NetUtils.showNetworkPopupOrToast(MelonWebViewFragment.this.getContext(), false)) {
                            return;
                        }
                        if(!MelonWebViewFragment.this.isLoginUser()) {
                            MelonWebViewFragment.this.showLoginPopup();
                            return;
                        }
                        MelonWebView.i(MelonWebViewFragment.this, 10);
                        return;
                    }
                    if(!NetUtils.showNetworkPopupOrToast(MelonWebViewFragment.this.getContext(), false)) {
                        return;
                    }
                    MelonWebViewFragment.this.mContextType = false;
                    if(!MelonWebViewFragment.this.isLoginUser()) {
                        MelonWebViewFragment.this.showLoginPopup();
                        return;
                    }
                    if(MelonWebViewFragment.this.bEditMode) {
                        MelonWebView.i(MelonWebViewFragment.this, 5);
                        return;
                    }
                    if(!NetUtils.isConnected()) {
                        ToastManager.show(0x7F1302AF);  // string:dcf_check_network "네트워크에 연결되어 있지 않아 기간 연장을 진행할 수 없습니다."
                        return;
                    }
                    MelonWebViewFragment.this.showProgress(true);
                    MelonWebViewFragment melonWebViewFragment0 = MelonWebViewFragment.this;
                    if(melonWebViewFragment0.mWebView.n) {
                        MelonWebView.i(melonWebViewFragment0, 6);
                    }
                    else if(melonWebViewFragment0.mToolbarType == 2) {
                        MelonWebView.i(MelonWebViewFragment.this, 9);
                    }
                    else {
                        MelonWebView.i(MelonWebViewFragment.this, 0);
                    }
                    MelonWebView melonWebView0 = MelonWebViewFragment.this.mWebView;
                    melonWebView0.j(melonWebView0.getUrl(), "toolbar");
                    return;
                }
                if(!NetUtils.showNetworkPopupOrToast(MelonWebViewFragment.this.getContext(), false)) {
                    return;
                }
                MelonWebViewFragment.this.mContextType = false;
                if(MelonWebViewFragment.this.bEditMode) {
                    MelonWebView.i(MelonWebViewFragment.this, 4);
                    return;
                }
                MelonWebViewFragment melonWebViewFragment1 = MelonWebViewFragment.this;
                if(melonWebViewFragment1.mWebView.n) {
                    MelonWebView.i(melonWebViewFragment1, 7);
                    return;
                }
                if(melonWebViewFragment1.mToolbarType == 2) {
                    MelonWebView.i(MelonWebViewFragment.this, 8);
                    return;
                }
                MelonWebView.i(MelonWebViewFragment.this, 1);
            }
        };
        this.mHandler = new UiHandler(this);
    }

    @Override  // com.iloen.melon.custom.MelonWebViewListener
    public void addOrPlay(boolean z, String s, String s1, String s2) {
        VideoPlayAndOpen addAction$VideoPlayAndOpen0;
        if("21".equals(s)) {
            addAction$VideoPlayAndOpen0 = new VideoPlayAndOpen(true);
        }
        else if(z) {
            addAction$VideoPlayAndOpen0 = new AddPlay(false);
        }
        else {
            addAction$VideoPlayAndOpen0 = Add.INSTANCE;
        }
        FragmentActivity fragmentActivity0 = this.getActivity();
        CType cType0 = CType.get(s);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(fragmentActivity0, AddServerContent.Companion.with(cType0, s2, s1, addAction$VideoPlayAndOpen0, this.blockingProgressDialogManage), true);
    }

    private void calculateView(View view0) {
        if(view0 == null) {
            return;
        }
        ViewTreeObserverHelper viewTreeObserverHelper0 = this.observerHelper;
        if(viewTreeObserverHelper0 != null) {
            viewTreeObserverHelper0.unregisterGlobalLayoutListener();
            this.observerHelper = null;
        }
        ViewTreeObserverHelper viewTreeObserverHelper1 = new ViewTreeObserverHelper();
        this.observerHelper = viewTreeObserverHelper1;
        viewTreeObserverHelper1.registerGlobalLayoutListener(view0, new OnGlobalLayoutListener() {
            @Override  // com.iloen.melon.utils.ui.ViewTreeObserverHelper$OnGlobalLayoutListener
            public void onGlobalLayout() {
                view0.requestLayout();
            }
        });
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return null;
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void darkChanged(boolean z) {
        this.initTitleBar();
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void doLoginNeedDlg() {
        this.showLoginPopup();
    }

    private void dumpWebViewHistory(WebBackForwardList webBackForwardList0) {
        if(webBackForwardList0 != null) {
            LogU.d("MelonWebViewFragment", "history dump start - histSize:" + webBackForwardList0.getSize() + ", curIdx:" + webBackForwardList0.getCurrentIndex());
            for(int v = 0; v < webBackForwardList0.getSize(); ++v) {
                WebHistoryItem webHistoryItem0 = webBackForwardList0.getItemAtIndex(v);
                StringBuilder stringBuilder0 = x.n(v, "history(", ") - origin: ");
                stringBuilder0.append(webHistoryItem0.getOriginalUrl());
                stringBuilder0.append(", final:");
                stringBuilder0.append(webHistoryItem0.getUrl());
                LogU.d("MelonWebViewFragment", stringBuilder0.toString());
            }
            LogU.d("MelonWebViewFragment", "history dump end");
            return;
        }
        LogU.d("MelonWebViewFragment", "history is null");
    }

    public static H e0(MelonWebViewFragment melonWebViewFragment0) {
        return melonWebViewFragment0.lambda$onEventMainThread$3();
    }

    public static void f0(MelonWebViewFragment melonWebViewFragment0, ActivityResult activityResult0) {
        melonWebViewFragment0.lambda$new$0(activityResult0);
    }

    private static ArrayList fromJsonHistoryUrls(String s) {
        n n0 = new n();
        try {
            return (ArrayList)n0.f(s, new TypeToken() {
            }.getType());
        }
        catch(Exception unused_ex) {
            return null;
        }
    }

    private Playable getAlbumPlayable(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
        if(melonWebViewFragment$WebContextListInfo0 == null) {
            LogU.w("MelonWebViewFragment", "getAlbumPlayable() invalid parameter");
            return null;
        }
        return Playable.newBuilder().cType(CType.ALBUM).menuId(WebContextListInfo.h(melonWebViewFragment$WebContextListInfo0)).albumIdName(WebContextListInfo.b(melonWebViewFragment$WebContextListInfo0), WebContextListInfo.m(melonWebViewFragment$WebContextListInfo0)).albumImgThumb(WebContextListInfo.l(melonWebViewFragment$WebContextListInfo0)).artists(StringUtils.makeArtistMap(WebContextListInfo.c(melonWebViewFragment$WebContextListInfo0), WebContextListInfo.d(melonWebViewFragment$WebContextListInfo0))).build();
    }

    private Playable getFlacPlayable(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
        if(melonWebViewFragment$WebContextListInfo0 == null) {
            LogU.w("MelonWebViewFragment", "getFlacPlayable() invalid parameter");
            return null;
        }
        return Playable.newBuilder().cType(CType.SONG).menuId(WebContextListInfo.h(melonWebViewFragment$WebContextListInfo0)).songIdTitle(WebContextListInfo.k(melonWebViewFragment$WebContextListInfo0), WebContextListInfo.m(melonWebViewFragment$WebContextListInfo0)).albumId(WebContextListInfo.b(melonWebViewFragment$WebContextListInfo0)).artists(StringUtils.makeArtistMap(WebContextListInfo.c(melonWebViewFragment$WebContextListInfo0), WebContextListInfo.d(melonWebViewFragment$WebContextListInfo0))).build();
    }

    private Uri getImagePickerContentUri(Uri uri0) {
        Uri uri1;
        CharSequence charSequence0 = null;
        if(uri0 == null) {
            LogU.i("MelonWebViewFragment", "getImagePickerContentUri Invalid uri");
            return null;
        }
        if(DocumentsContract.isDocumentUri(this.getContext(), uri0)) {
            String[] arr_s = DocumentsContract.getDocumentId(uri0).split(":");
            if(arr_s != null && arr_s.length > 1) {
                charSequence0 = arr_s[1];
            }
            if(!TextUtils.isEmpty(charSequence0)) {
                Cursor cursor0 = this.getActivity().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data"}, e.b("_id=", ((String)charSequence0)), null, null);
                if(cursor0 != null) {
                    try {
                        if(cursor0.moveToFirst()) {
                            String s = cursor0.getString(0);
                            if(!TextUtils.isEmpty(s)) {
                                uri1 = Uri.fromFile(new File(s));
                                goto label_19;
                            }
                        }
                        goto label_21;
                    }
                    catch(Throwable throwable0) {
                        TWR.safeClose$NT(cursor0, throwable0);
                        throw throwable0;
                    }
                label_19:
                    cursor0.close();
                    return uri1;
                label_21:
                    cursor0.close();
                    return uri0;
                }
            }
        }
        return uri0;
    }

    private Playable getMvPlayable(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
        if(melonWebViewFragment$WebContextListInfo0 == null) {
            LogU.w("MelonWebViewFragment", "getMvPlayable() invalid parameter");
            return null;
        }
        boolean z = true;
        Builder playable$Builder0 = Playable.newBuilder().cType(CType.MV).menuId(WebContextListInfo.h(melonWebViewFragment$WebContextListInfo0)).mvIdTitle(WebContextListInfo.i(melonWebViewFragment$WebContextListInfo0), WebContextListInfo.m(melonWebViewFragment$WebContextListInfo0)).songId(WebContextListInfo.j(melonWebViewFragment$WebContextListInfo0)).albumId(WebContextListInfo.b(melonWebViewFragment$WebContextListInfo0)).artists(StringUtils.makeArtistMap(WebContextListInfo.c(melonWebViewFragment$WebContextListInfo0), WebContextListInfo.d(melonWebViewFragment$WebContextListInfo0))).isAdult(ProtocolUtils.parseBoolean(WebContextListInfo.a(melonWebViewFragment$WebContextListInfo0))).hasMv(WebContextListInfo.e(melonWebViewFragment$WebContextListInfo0)).isSong(!TextUtils.isEmpty(WebContextListInfo.j(melonWebViewFragment$WebContextListInfo0)));
        if(TextUtils.isEmpty(WebContextListInfo.i(melonWebViewFragment$WebContextListInfo0)) || !WebContextListInfo.g(melonWebViewFragment$WebContextListInfo0)) {
            z = false;
        }
        return playable$Builder0.isService(z).isBrandDj(WebContextListInfo.f(melonWebViewFragment$WebContextListInfo0)).albumImg(WebContextListInfo.l(melonWebViewFragment$WebContextListInfo0)).build();
    }

    public String getRootUrl() {
        return this.mRootUrl;
    }

    private Playable getSongPlayable(WebContextListInfo melonWebViewFragment$WebContextListInfo0) {
        if(melonWebViewFragment$WebContextListInfo0 == null) {
            LogU.w("MelonWebViewFragment", "getSongPlayable() invalid parameter");
            return null;
        }
        return Playable.newBuilder().cType(CType.SONG).menuId(WebContextListInfo.h(melonWebViewFragment$WebContextListInfo0)).songIdTitle(WebContextListInfo.k(melonWebViewFragment$WebContextListInfo0), WebContextListInfo.m(melonWebViewFragment$WebContextListInfo0)).albumId(WebContextListInfo.b(melonWebViewFragment$WebContextListInfo0)).artists(StringUtils.makeArtistMap(WebContextListInfo.c(melonWebViewFragment$WebContextListInfo0), WebContextListInfo.d(melonWebViewFragment$WebContextListInfo0))).isAdult(ProtocolUtils.parseBoolean(WebContextListInfo.a(melonWebViewFragment$WebContextListInfo0))).hasMv(WebContextListInfo.e(melonWebViewFragment$WebContextListInfo0)).isService(WebContextListInfo.g(melonWebViewFragment$WebContextListInfo0)).albumImgThumb(WebContextListInfo.l(melonWebViewFragment$WebContextListInfo0)).build();
    }

    public o getTitleBarItem() {
        return null;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public MelonWebView getWebView() {
        return this.isAdded() ? this.mWebView : null;
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void goHome(boolean z) {
        LogU.i("MelonWebViewFragment", "goHome - rootUrl:" + this.mRootUrl);
        if(z) {
            this.initWebView();
        }
        MelonWebView melonWebView0 = this.getWebView();
        if(melonWebView0 != null) {
            LogU.d("MelonWebViewFragment", "Url0:" + melonWebView0.getUrl());
            LogU.d("MelonWebViewFragment", "Url1:" + this.mRootUrl);
            if(!StringUtils.equals(melonWebView0.getUrl(), this.mRootUrl)) {
                melonWebView0.clearHistory();
                melonWebView0.loadUrl(this.mRootUrl);
            }
        }
    }

    public boolean hasCloseOrBackButton() {
        return true;
    }

    private void heapLog() {
    }

    private void hideAndShowErrorCloseButton(boolean z) {
        if(!this.hasCloseOrBackButton()) {
            View view0 = this.findViewById(0x7F0A0449);  // id:error_close
            if(view0 != null) {
                view0.setVisibility((z ? 0 : 8));
            }
        }
    }

    public void hideSoftInputMethod() {
        MelonWebView melonWebView0 = this.mWebView;
        if(melonWebView0 != null) {
            LogU.v("MelonWebView", "hideSoftInputMethod()");
            ((InputMethodManager)melonWebView0.getContext().getSystemService("input_method")).hideSoftInputFromWindow(melonWebView0.getWindowToken(), 0);
        }
    }

    public void historyBack() {
        if(this.mWebView != null && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return;
        }
        this.navigateBack();
    }

    private void initErrorUIClass() {
        TextView textView0 = (TextView)this.findViewById(0x7F0A08A2);  // id:network_error_confirm_button
        TextView textView1 = (TextView)this.findViewById(0x7F0A08A6);  // id:network_error_retry_button
        View view0 = this.findViewById(0x7F0A0449);  // id:error_close
        LinearLayout linearLayout0 = (LinearLayout)this.findViewById(0x7F0A0568);  // id:include_adapter_network_error_view
        this.mErrorCustomErrorLayout = linearLayout0;
        if(linearLayout0 != null) {
            ViewUtils.setBackground(linearLayout0, null);
            this.mErrorCustomErrorLayout.setVisibility(4);
        }
        if(view0 != null) {
            view0.setOnClickListener(new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    MelonWebViewFragment.this.performBackPress();
                }
            });
            view0.setVisibility(8);
        }
        if(textView0 != null) {
            textView0.setOnClickListener(new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    Navigator.open(SettingMainFragment.Companion.newInstance(true));
                }
            });
        }
        if(textView1 != null) {
            textView1.setOnClickListener(new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    if(NetUtils.isConnected()) {
                        MelonWebView melonWebView0 = MelonWebViewFragment.this.mWebView;
                        if(melonWebView0 != null) {
                            melonWebView0.reload();
                        }
                        return;
                    }
                    NetUtils.showNetworkInfoPopupIfNotConnected(MelonWebViewFragment.this.getContext());
                }
            });
        }
    }

    private void initTitleBar() {
        TitleBar titleBar0 = this.getTitleBar();
        o o0 = this.getTitleBarItem();
        if(titleBar0 != null) {
            if(o0 != null) {
                titleBar0.a(o0);
            }
            titleBar0.setBackgroundColor(0);
            titleBar0.f(false);
            titleBar0.setContainerClickable(false);
        }
    }

    private void initUIClass() {
        this.mToolBar = ToolBar.f(((ToolBar)this.findViewById(0x7F0A0BC6)), 0);  // id:toolbar_layout
    }

    public void initWebView() {
        MelonWebView melonWebView0 = this.mWebView;
        if(melonWebView0 != null) {
            melonWebView0.destroy();
        }
        MelonWebView melonWebView1 = this.newMelonWebView();
        this.mWebView = melonWebView1;
        melonWebView1.setOverScrollMode(2);
        I1 i10 = this.jsConnect;
        if(i10 != null) {
            this.mWebView.setWebViewJSConnect(i10);
        }
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.g(this, (this instanceof CAWebView ? true : this.mIsPostMethod), this.getActivity());
        this.mWebView.setWebViewListener(this);
        this.mWebView.setCustomErrorView(true);
        if(this.isAdded() && !this.isDetached() && this.getView() != null) {
            MelonWebView melonWebView2 = this.mWebView;
            FragmentActivity fragmentActivity0 = this.getActivity();
            D d0 = this.getViewLifecycleOwner();
            melonWebView2.getClass();
            if(BillingUtils.getBillingType().equals("GOOGLE")) {
                LogU.d("MelonWebView", "setupGoogleIap()");
                q.g(fragmentActivity0, "owner");
                q0 q00 = fragmentActivity0.getViewModelStore();
                o0 o00 = fragmentActivity0.getDefaultViewModelProviderFactory();
                c c0 = fragmentActivity0.getDefaultViewModelCreationExtras();
                q.g(q00, "store");
                q.g(o00, "factory");
                o9.b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
                d d1 = df.d.y(h.class);
                String s = d1.l();
                if(s == null) {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
                h h0 = (h)b0.s(d1, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
                melonWebView2.j = h0;
                com.iloen.melon.custom.q0 q01 = new com.iloen.melon.custom.q0(melonWebView2, 0);
                h0.e.observe(d0, q01);
            }
            else if(BillingUtils.getBillingType().equals("ONE_STORE")) {
                LogU.d("MelonWebView", "setupOneStoreIap()");
                q.g(fragmentActivity0, "owner");
                q0 q02 = fragmentActivity0.getViewModelStore();
                o0 o01 = fragmentActivity0.getDefaultViewModelProviderFactory();
                c c1 = fragmentActivity0.getDefaultViewModelCreationExtras();
                q.g(q02, "store");
                q.g(o01, "factory");
                o9.b b1 = com.iloen.melon.utils.a.p(c1, "defaultCreationExtras", q02, o01, c1);
                d d2 = df.d.y(k.class);
                String s1 = d2.l();
                if(s1 == null) {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
                k k0 = (k)b1.s(d2, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s1);
                melonWebView2.k = k0;
                com.iloen.melon.custom.q0 q03 = new com.iloen.melon.custom.q0(melonWebView2, 1);
                k0.c.observe(d0, q03);
            }
        }
        ViewGroup viewGroup0 = (ViewGroup)this.findViewById(0x7F0A0DE7);  // id:webview_container
        if(viewGroup0 != null) {
            viewGroup0.removeAllViews();
            viewGroup0.addView(this.mWebView, -1, -1);
            this.updateBottomMargin();
        }
        this.setCookies(this.getContext(), this.mIsFirstEntry);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return this.isScreenLandscapeSupported;
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public boolean isToolbarVisible() {
        return false;
    }

    private void lambda$new$0(ActivityResult activityResult0) {
        Uri[] arr_uri;
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(this.mFilePathCallback != null) {
                if(intent0 == null || TextUtils.isEmpty(intent0.getDataString())) {
                    arr_uri = this.mCameraPhotoPath == null ? null : new Uri[]{Uri.parse(this.mCameraPhotoPath)};
                }
                else {
                    String s = intent0.getDataString();
                    arr_uri = s == null ? null : new Uri[]{Uri.parse(s)};
                }
                this.mFilePathCallback.onReceiveValue(arr_uri);
                this.mFilePathCallback = null;
            }
        }
        else {
            ValueCallback valueCallback0 = this.mFilePathCallback;
            if(valueCallback0 != null) {
                valueCallback0.onReceiveValue(null);
                this.mFilePathCallback = null;
            }
        }
    }

    private H lambda$onEventMainThread$2(String s) {
        this.mWebView.loadUrl(s);
        return null;
    }

    private H lambda$onEventMainThread$3() {
        ToastManager.showShort(0x7F1304B6);  // string:isp_cancel_payment_message "(-1)결제가 취소 되었습니다."
        this.navigateBack();
        return null;
    }

    private static void lambda$requestCommand$7(DialogInterface dialogInterface0, int v) {
        if(-1 == v) {
            Navigator.openUrl(M.R, OpenType.FirstDepth);
        }
        dialogInterface0.dismiss();
    }

    private void lambda$requestWebViewFocus$1() {
        if(this.isFragmentValid()) {
            MelonWebView melonWebView0 = this.mWebView;
            if(melonWebView0 != null) {
                melonWebView0.requestFocus(130);
            }
        }
    }

    private void lambda$shouldOverrideUrlLoading$4() {
        this.playerUseCase.u();
    }

    private static void lambda$shouldOverrideUrlLoading$5(Uri uri0, H h0) {
        LogU.d("MelonWebViewFragment", "Airbridge#click() success : " + uri0.toString());
    }

    private static void lambda$shouldOverrideUrlLoading$6(Uri uri0, Throwable throwable0) {
        LogU.w("MelonWebViewFragment", "Airbridge#click() failure : " + uri0.toString());
    }

    private static H lambda$showContextPopupAlbum$10() [...] // Inlined contents

    private H lambda$showContextPopupAlbum$11(Playable playable0, k2 k20) {
        if(k20 instanceof J1) {
            Navigator.open(DetailLikePersonListFragment.newInstance("N10002", "N20001", ""));
            return null;
        }
        if(k20 instanceof X1) {
            this.shareData(playable0, "N10002");
            return null;
        }
        if(k20 instanceof x1) {
            this.showArtistInfoPage(playable0);
            return null;
        }
        if(k20 instanceof w1) {
            this.showAlbumInfoPage(playable0);
        }
        return null;
    }

    private static H lambda$showContextPopupSong$8() [...] // Inlined contents

    private H lambda$showContextPopupSong$9(Playable playable0, k2 k20) {
        if(k20 instanceof H1) {
            if(!this.isLoginUser()) {
                this.showLoginPopup();
                return null;
            }
            this.showKakaoProfileMusicPopup("", "", "");
            return null;
        }
        if(k20 instanceof e2) {
            Navigator.openSimilarSongList("", "N10001");
            return null;
        }
        if(k20 instanceof J1) {
            Navigator.open(DetailLikePersonListFragment.newInstance("N10001", "N20001", ""));
            return null;
        }
        if(k20 instanceof h2) {
            this.setSelectAllWithToolbar(false);
            Navigator.open(StreamingCardFragment.newInstance(""));
            return null;
        }
        if(k20 instanceof M1) {
            StatsElementsBase statsElementsBase0 = this.getAdapter() instanceof com.iloen.melon.adapters.common.q ? ((com.iloen.melon.adapters.common.q)this.getAdapter()).getStatsElements() : null;
            l1 l10 = new l1("", "", playable0.getArtistid(), statsElementsBase0);
            this.playMixUp(WebContextListInfo.h(this.mCtxInfo), l10);
            PopupClickLogHelper.sendMorePopupPlayClickLog(this.getContext(), WebContextListInfo.h(this.mCtxInfo), playable0);
            return null;
        }
        if(k20 instanceof i2) {
            O.a(new UaLogDummyReq(this.getContext(), "songListTiktok"));
            MelonLinkExecutor.open(((i2)k20).a, ((i2)k20).b);
            return null;
        }
        if(k20 instanceof K1 && ((K1)k20).b.a.equals(zd.M.h0)) {
            O.a(new UaLogDummyReq(this.getContext(), "songListTiktok"));
            Link extraProperties$Link0 = (Link)((K1)k20).b.f;
            MelonLinkExecutor.open(extraProperties$Link0.a, extraProperties$Link0.b);
            return null;
        }
        if(k20 instanceof c2) {
            this.shareData(playable0, "N10001");
            return null;
        }
        if(k20 instanceof f2) {
            this.showSongInfoPage(playable0);
            return null;
        }
        if(k20 instanceof w1) {
            this.showAlbumInfoPage(playable0);
            return null;
        }
        if(k20 instanceof x1) {
            this.showArtistInfoPage(playable0);
            return null;
        }
        if(k20 instanceof N1) {
            this.showMvInfoPage(playable0);
        }
        return null;
    }

    private static Serializable loadAdditionalHttpHeaders(Context context0, String s) {
        if(context0 != null && !TextUtils.isEmpty(s)) {
            x9.a a0 = P.a();
            if(a0 == null) {
                LogU.w("MelonWebViewFragment", "loadAdditionalHttpHeaders() invalid db");
                return null;
            }
            VolatileDatabase_Impl volatileDatabase_Impl0 = (VolatileDatabase_Impl)a0.a;
            if(((RestoreDataEntity)w.N(volatileDatabase_Impl0, true, false, new g(s, 16))) != null) {
                w.N(volatileDatabase_Impl0, false, true, new g(s, 15));
            }
            return null;
        }
        LogU.w("MelonWebViewFragment", "loadAdditionalHttpHeaders() invalid paramteer");
        return null;
    }

    private static ArrayList loadHistoryUrlsFromDb(String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonWebViewFragment", "loadHistroyUrlsfromDb() invalid key");
            return null;
        }
        x9.a a0 = P.a();
        if(a0 == null) {
            LogU.w("MelonWebViewFragment", "loadHistroyUrlsfromDb() invalid db");
            return null;
        }
        VolatileDatabase_Impl volatileDatabase_Impl0 = (VolatileDatabase_Impl)a0.a;
        if(((RestoreDataEntity)w.N(volatileDatabase_Impl0, true, false, new g(s, 16))) != null) {
            w.N(volatileDatabase_Impl0, false, true, new g(s, 15));
        }
        return null;
    }

    public void loadUrl(String s) {
        Z.w("loadUrl() ", s, "MelonWebViewFragment");
        MelonWebView melonWebView0 = this.mWebView;
        if(melonWebView0 != null) {
            melonWebView0.loadUrl(s);
        }
    }

    public void loadUrl(String s, Map map0) {
        LogU.d("MelonWebViewFragment", "loadUrl() : " + s + ", additionalHttpHeaders:" + map0);
        MelonWebView melonWebView0 = this.mWebView;
        if(melonWebView0 != null) {
            melonWebView0.loadUrl(s, map0);
        }
    }

    private static byte[] loadWebviewChromeStateFromDb(String s) {
        byte[] arr_b = new byte[0];
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonWebViewFragment", "loadWebviewChromeStateFromDb() invalid key");
            return arr_b;
        }
        x9.a a0 = P.a();
        if(a0 == null) {
            LogU.w("MelonWebViewFragment", "loadWebviewChromeStateFromDb() invalid db");
            return arr_b;
        }
        VolatileDatabase_Impl volatileDatabase_Impl0 = (VolatileDatabase_Impl)a0.a;
        if(((RestoreDataEntity)w.N(volatileDatabase_Impl0, true, false, new g(s, 16))) != null) {
            w.N(volatileDatabase_Impl0, false, true, new g(s, 15));
        }
        return arr_b;
    }

    public static String makeGetArgs(String s, NameValuePairList nameValuePairList0) {
        StringBuilder stringBuilder0 = Y.p(s);
        if(nameValuePairList0 != null && nameValuePairList0.size() > 0) {
            stringBuilder0.append("?");
            for(Object object0: nameValuePairList0) {
                stringBuilder0.append(((BasicNameValuePair)object0).a);
                stringBuilder0.append("=");
                stringBuilder0.append(((BasicNameValuePair)object0).b.toString());
                stringBuilder0.append("&");
            }
            stringBuilder0.setLength(stringBuilder0.length() - 1);
        }
        return stringBuilder0.toString();
    }

    public static Bundle makePostArgs(String s, byte[] arr_b) {
        Bundle bundle0 = new Bundle();
        bundle0.putString("url", s);
        bundle0.putByteArray("data", arr_b);
        bundle0.putBoolean("isPostMethod", arr_b != null && arr_b.length > 0);
        return bundle0;
    }

    public static H n0() {
        return null;
    }

    private void navigateBack(Uri uri0) {
        if(this != this.getCurrentTabContainerFragment().getCurrentFragment()) {
            return;
        }
        Message message0 = new Message();
        message0.what = 4;
        if(uri0 != null) {
            Bundle bundle0 = new Bundle();
            bundle0.putString("openUri", uri0.toString());
            message0.setData(bundle0);
        }
        this.mHandler.handleMessage(message0);
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void navigateBack() {
        LogU.d("MelonWebViewFragment", "navigateBack - this:" + this);
        this.navigateBack(null);
    }

    public MelonWebView newMelonWebView() {
        return new MelonWebView(this.getActivity());
    }

    public static H o0() {
        return null;
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public List onAddSongsToPlaylist(String s, String s1) {
        List list0 = new ArrayList();
        if(this.mContextType) {
            WebContextListInfo melonWebViewFragment$WebContextListInfo0 = this.mCtxInfo;
            if(melonWebViewFragment$WebContextListInfo0 != null) {
                ((ArrayList)list0).add(Song.b(WebContextListInfo.k(melonWebViewFragment$WebContextListInfo0)));
            }
        }
        else if(this.myAlbumSongIds != null && this.myAlbumSongIds.length > 0) {
            for(int v = 0; true; ++v) {
                String[] arr_s = this.myAlbumSongIds;
                if(v >= arr_s.length) {
                    break;
                }
                ((ArrayList)list0).add(Song.b(arr_s[v]));
            }
        }
        LogU.d("MelonWebViewFragment", "onAddSongsToPlaylist() songIds : " + list0.toString());
        return list0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onAddSongsToPlaylistComplete(String s, String s1, String s2, int v, VolleyError volleyError0) {
        if(volleyError0 == null) {
            EventBusHelper.post(new UncheckAll());
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onAddToDJCollection(Object object0) {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        MelonWebView.i(this, 11);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onAddToNowPlayingList(Object object0) {
        if(((WebContextListInfo)object0) == null) {
            LogU.e("MelonWebViewFragment", "onAddToNowPlayingList() invalid popup info");
            MelonWebView.i(this, 2);
        }
        else {
            this.loadUrl("javascript:__appSingleSongPlay(\'" + WebContextListInfo.h(((WebContextListInfo)object0)) + "\',\'" + WebContextListInfo.k(((WebContextListInfo)object0)) + "\',\'" + WebContextListInfo.a(((WebContextListInfo)object0)) + "\')");
        }
        EventBusHelper.post(new UncheckAll());
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onAddToPlaylist(Object object0) {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        if(((WebContextListInfo)object0) != null) {
            this.loadUrl("javascript:__appSingleSongAdd(\'" + WebContextListInfo.k(((WebContextListInfo)object0)) + "\')");
            return;
        }
        this.mContextType = false;
        MelonWebView.i(this, 3);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        LogU.d("MelonWebViewFragment", "configurationChange() : " + configuration0.orientation);
        this.updateToolbar();
        if(this.mRequestCommandDialog != null && this.mRequestCommandDialog.isShowing()) {
            Dialog dialog0 = this.mRequestCommandDialog;
            if(dialog0 instanceof MelonBaseListPopup) {
                ((MelonBaseListPopup)dialog0).setConfigurationChanged(configuration0.orientation);
            }
        }
        this.setNetworkIconMarginHeight(configuration0.orientation == 1);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        LogU.d("MelonWebViewFragment", "onCreate - inState:" + bundle0);
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            this.mIsPostMethod = bundle0.getBoolean("isPostMethod", false);
        }
        if(this.getArguments() != null) {
            String s = this.getArguments().getString("url");
            if(s != null) {
                Uri uri0 = Uri.parse(s);
                String s1 = "";
                String s2 = uri0.getPath() == null ? "" : uri0.getPath();
                if(uri0.getHost() != null) {
                    s1 = uri0.getHost();
                }
                if(TextUtils.equals(s2, "/musicstory/detail.htm") || s1.endsWith("present.melon.com")) {
                    this.isScreenLandscapeSupported = false;
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0906, viewGroup0, false);  // layout:webviewbrowser
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onDestroy() {
        LogU.d("MelonWebViewFragment", "onDestory");
        super.onDestroy();
        MelonWebView melonWebView0 = this.mWebView;
        if(melonWebView0 != null) {
            melonWebView0.destroy();
            this.mWebView = null;
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        LogU.d("MelonWebViewFragment", "onDestroyView");
        super.onDestroyView();
        this.mHistoryUrls.clear();
        List list0 = this.saveHistoryUrls(this.getArguments());
        if(list0 != null && !list0.isEmpty()) {
            this.mHistoryUrls.addAll(list0);
        }
        ViewTreeObserverHelper viewTreeObserverHelper0 = this.observerHelper;
        if(viewTreeObserverHelper0 != null) {
            viewTreeObserverHelper0.unregisterGlobalLayoutListener();
            this.observerHelper = null;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(CloseAndGoAppHome eventWebView$CloseAndGoAppHome0) {
        LogU.d("MelonWebViewFragment", "CloseAndGoAppHome()");
        this.performBackPress();
        String s = eventWebView$CloseAndGoAppHome0.targetUrl;
        Uri.Builder uri$Builder0 = f.e.buildUpon();
        if(!TextUtils.isEmpty(s)) {
            uri$Builder0.appendQueryParameter("targeturl", s);
            uri$Builder0.appendQueryParameter("javascriptMethod", "Y");
        }
        Uri uri0 = uri$Builder0.build();
        q.f(uri0, "build(...)");
        f.a(uri0);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(DialogClose eventWebView$DialogClose0) {
        this.navigateBack();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(Error eventWebView$Error0) {
        if(this.isFragmentValid()) {
            LinearLayout linearLayout0 = this.mErrorCustomErrorLayout;
            if(linearLayout0 != null) {
                linearLayout0.setVisibility(0);
            }
            this.hideAndShowErrorCloseButton(true);
            ViewUtils.hideWhen(this.mWebView, true);
            this.showToolbarHandler(false);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(InputMethodVisible eventWebView$InputMethodVisible0) {
        if(eventWebView$InputMethodVisible0.isVisible()) {
            this.showSoftInputMethod();
            return;
        }
        this.hideSoftInputMethod();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(KakaoEmoticonPopup eventWebView$KakaoEmoticonPopup0) {
        if(b9.d.h == null) {
            b9.d.h = new b9.d();
        }
        b9.d d0 = b9.d.h;
        if(d0 != null) {
            d0.e = this;
            d0.b(new EmoticonClickListener() {
                @Override  // com.kakao.emoticon.interfaces.EmoticonClickListener
                public void onEmoticonClick(EmoticonViewParam emoticonViewParam0) {
                    String s = emoticonViewParam0.toJsonString();
                    MelonWebViewFragment.this.loadUrl("javascript:commentObj.selectKakaoEmoticon(\'" + s + "\')");
                }

                @Override  // com.kakao.emoticon.interfaces.EmoticonClickListener
                public void onEmoticonDoubleClick(EmoticonViewParam emoticonViewParam0) {
                }
            });
            return;
        }
        q.m("mInstance");
        throw null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(Load eventWebView$Load0) {
        if(this.isAdded()) {
            LinearLayout linearLayout0 = this.mErrorCustomErrorLayout;
            if(linearLayout0 != null) {
                linearLayout0.setVisibility(4);
            }
            this.hideAndShowErrorCloseButton(false);
            this.mWebView.setVisibility(0);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(ShowPayAppInstall eventWebView$ShowPayAppInstall0) {
        String s1;
        String s;
        if(this.isAdded()) {
            LinearLayout linearLayout0 = this.mErrorCustomErrorLayout;
            if(linearLayout0 != null) {
                linearLayout0.setVisibility(4);
            }
            this.hideAndShowErrorCloseButton(false);
            MelonWebView melonWebView0 = this.mWebView;
            if(melonWebView0 != null) {
                melonWebView0.setVisibility(0);
                this.mWebView.loadData("<html><body></body></html>", "text/html", "euc-kr");
                if(this.getActivity() != null) {
                    if(eventWebView$ShowPayAppInstall0.type == 1) {
                        s = "금결원 계좌이체 어플리케이션이 설치되어 있지 않습니다. \n설치를 눌러 진행해 주십시요.\n취소를 누르면 결제가 취소 됩니다.";
                        s1 = "market://details?id=com.kftc.bankpay.android";
                    }
                    else {
                        s = "모바일 ISP 앱이 설치되어 있지 않습니다. \n설치버튼을 눌러 앱을 설치해 주세요.\n취소를 누르면 결제가 취소 됩니다.";
                        s1 = "http://mobile.vpay.co.kr/jsp/MISP/andown.jsp";
                    }
                    String s2 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                    if(TextUtils.isEmpty(s)) {
                        s = this.getString(0x7F1304B7);  // string:isp_install_check_fail_message "모바일 ISP 앱이 설치되어 있지 않습니다. \n설치버튼을 눌러 앱을 설치해 
                                                         // 주세요.\n취소를 누르면 결제가 취소 됩니다."
                    }
                    String s3 = this.getString(0x7F1304B8);  // string:isp_install_confirm "설치"
                    String s4 = this.getString(0x7F130199);  // string:cancel "취소"
                    com.melon.ui.popup.b.v(this.getChildFragmentManager(), s2, s, false, s4, s3, new N(18, this, s1), new b9.a(this, 21));
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(UncheckAll eventWebView$UncheckAll0) {
        if(this.isFragmentValid()) {
            LogU.v("MelonWebViewFragment", "EventWebView.UncheckAll()");
            this.loadUrl("javascript:unSelectAll()");
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(CloseView eventWebViewClose$CloseView0) {
        this.navigateBack(eventWebViewClose$CloseView0.openUri);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, v9.h h0, String s) {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onNewArguments(Bundle bundle0) {
        LogU.d("MelonWebViewFragment", "onNewArguments - bundle:" + bundle0);
        this.processArguments(bundle0, true);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onPause() {
        View view0;
        LogU.d("MelonWebViewFragment", "onPause()");
        super.onPause();
        MelonWebView melonWebView0 = this.mWebView;
        if(melonWebView0 != null) {
            melonWebView0.onPause();
        }
        this.setToolbarListener(false);
        Activity activity0 = this.getActivity();
        if(activity0 != null) {
            Activity activity1 = activity0.getParent();
            if(activity1 != null) {
                activity0 = activity1;
            }
        }
        if(activity0 == null) {
            view0 = null;
        }
        else {
            Window window0 = activity0.getWindow();
            view0 = window0 == null ? null : window0.getCurrentFocus();
        }
        EventBusHelper.post(new UncheckAll());
        InputMethodUtils.hideInputMethod(this.getContext(), view0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        LogU.d("MelonWebViewFragment", "onResume");
        super.onResume();
        MelonWebView melonWebView0 = this.mWebView;
        if(melonWebView0 != null) {
            melonWebView0.onResume();
            this.mWebView.resumeTimers();
        }
        this.setToolbarListener(true);
        this.requestWebViewFocus();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        if(bundle0 != null) {
            bundle0.putString("url", this.mRootUrl);
            Map map0 = this.mAdditionalHttpHeaders;
            if(map0 != null) {
                if(!map0.isEmpty()) {
                    if(MelonWebViewFragment.saveAdditionalHttpHeaders(this.getContext(), "8d97b896-8ad4-479b-9d60-114076ff04b2", ((Serializable)this.mAdditionalHttpHeaders))) {
                        bundle0.putString("additionalHttpHeader", "8d97b896-8ad4-479b-9d60-114076ff04b2");
                    }
                    this.mAdditionalHttpHeaders.clear();
                }
                this.mAdditionalHttpHeaders = null;
            }
        }
        super.onSaveInstanceState(bundle0);
        JsResult jsResult0 = MelonWebView.getJsResult();
        if(jsResult0 != null) {
            jsResult0.cancel();
        }
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            bundle1.putBoolean("restoreWebview", true);
            List list0 = this.saveHistoryUrls(bundle1);
            if(list0 != null && !list0.isEmpty() && MelonWebViewFragment.saveHistoryUrlsToDb(this.getContext(), "4fd52335-a7d2-4d98-8876-35415c78325f", list0)) {
                bundle1.putString("restoreHistoryUrls", "4fd52335-a7d2-4d98-8876-35415c78325f");
            }
            bundle1.putBoolean("isPostMethod", this.mIsPostMethod);
            byte[] arr_b = bundle1.getByteArray("WEBVIEW_CHROMIUM_STATE");
            if(MelonWebViewFragment.saveWebviewChromeStateToDb(this.getContext(), "78951f40-167a-4d22-8642-a86be79a8331", arr_b)) {
                bundle1.putString("restoreWebviewChromeState", "78951f40-167a-4d22-8642-a86be79a8331");
                bundle1.remove("WEBVIEW_CHROMIUM_STATE");
            }
            if(bundle0 != null) {
                bundle0.putAll(bundle1);
            }
        }
        LogU.d("MelonWebViewFragment", "onSaveInstanceState() outState:" + bundle0 + ", this:" + this);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStart() {
        LogU.d("MelonWebViewFragment", "onStart");
        super.onStart();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        LogU.d("MelonWebViewFragment", "onStop");
        super.onStop();
        MelonWebView melonWebView0 = this.mWebView;
        if(melonWebView0 != null) {
            melonWebView0.f();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onUpdateRatingInfo(String s, float f) {
        if(!TextUtils.isEmpty(s)) {
            this.loadUrl("javascript:__appAlbumGradRegist(" + s + ", " + f + ")");
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.initTitleBar();
        this.initWebView();
        this.initUIClass();
        this.initErrorUIClass();
        this.updateToolbar();
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        this.processArguments(bundle0, false);
        this.mNetworkIconIv = view0.findViewById(0x7F0A08A4);  // id:network_error_info_icon
        this.setNetworkIconMarginHeight(ScreenUtils.isPortrait(this.getContext()));
        this.calculateView(this.mRootView);
    }

    @Override  // com.iloen.melon.custom.MelonWebViewListener
    public void playMixUp(String s, String s1, String s2) {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            WebViewUtils.playMixUpPlaylist(fragmentActivity0, s1, s2);
        }
    }

    public void postUrl(String s, byte[] arr_b) {
        LogU.d("MelonWebViewFragment", "postUrl() " + s + ", postData:" + arr_b);
        MelonWebView melonWebView0 = this.mWebView;
        if(melonWebView0 != null) {
            melonWebView0.postUrl(s, arr_b);
        }
    }

    private void processArguments(Bundle bundle0, boolean z) {
        Map map0;
        boolean z1;
        byte[] arr_b;
        String s1;
        LogU.d("MelonWebViewFragment", "processArguments() args:" + bundle0 + ", fromOnNewIntent:" + z);
        String s = null;
        if(bundle0 == null) {
            z1 = false;
            arr_b = null;
            s1 = null;
            map0 = null;
        }
        else {
            s1 = bundle0.getString("url");
            if(!z) {
                Z.w("processArguments() setRootUrl: ", s1, "MelonWebViewFragment");
                this.mRootUrl = s1;
            }
            arr_b = bundle0.getByteArray("data");
            z1 = bundle0.getBoolean("restoreWebview", !this.mHistoryUrls.isEmpty());
            String s2 = bundle0.getString("additionalHttpHeader");
            if(TextUtils.isEmpty(s2)) {
                map0 = null;
            }
            else {
                map0 = (Map)MelonWebViewFragment.loadAdditionalHttpHeaders(this.getContext(), s2);
                if(map0 == null || map0.isEmpty()) {
                    map0 = null;
                }
            }
        }
        if(this.mWebView != null) {
            if(z1) {
                String s3 = bundle0.getString("restoreWebviewChromeState");
                if(!TextUtils.isEmpty(s3)) {
                    byte[] arr_b1 = MelonWebViewFragment.loadWebviewChromeStateFromDb(s3);
                    if(arr_b1 != null && arr_b1.length > 0) {
                        bundle0.putByteArray("WEBVIEW_CHROMIUM_STATE", arr_b1);
                    }
                }
                this.mWebView.b();
                WebBackForwardList webBackForwardList0 = this.mWebView.restoreState(bundle0);
                ArrayList arrayList0 = MelonWebViewFragment.loadHistoryUrlsFromDb(bundle0.getString("restoreHistoryUrls"));
                this.dumpWebViewHistory(webBackForwardList0);
                if(webBackForwardList0 != null && arrayList0 != null && !arrayList0.isEmpty()) {
                    if(webBackForwardList0.getCurrentIndex() != -1) {
                        try {
                            s = (String)arrayList0.get(webBackForwardList0.getCurrentIndex());
                        }
                        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                            LogU.w("MelonWebViewFragment", "processArguments() error on historyUrls.get() : " + indexOutOfBoundsException0);
                        }
                    }
                    Z.w("processArguments() lastUrl: ", s, "MelonWebViewFragment");
                    if(s != null) {
                        if(this.mWebView.canGoBack()) {
                            LogU.i("MelonWebViewFragment", "processArguments() goback and load: " + s);
                            return;
                        }
                        LogU.i("MelonWebViewFragment", "processArguments() clear and load: " + s);
                        this.mWebView.clearHistory();
                    }
                }
            }
            else if(!TextUtils.isEmpty(s1)) {
                if(arr_b != null && arr_b.length > 0) {
                    this.postUrl(s1, arr_b);
                    return;
                }
                if(map0 != null && !map0.isEmpty()) {
                    this.loadUrl(s1, map0);
                    Map map1 = this.mAdditionalHttpHeaders;
                    if(map1 != null) {
                        map1.clear();
                    }
                    this.mAdditionalHttpHeaders = map0;
                    return;
                }
                this.loadUrl(s1);
            }
        }
    }

    public static void r0(MelonWebViewFragment melonWebViewFragment0, boolean z) {
        melonWebViewFragment0.updateBottomMargin(true, z);
    }

    @Override  // com.iloen.melon.custom.MelonWebViewListener
    public void requestCommand(String s, String s1, String s2, String s3) {
        StringBuilder stringBuilder0 = A7.d.o("requestCommand()-", s, "::param1=", s1, "::param2=");
        stringBuilder0.append(s2);
        stringBuilder0.append("::param3=");
        stringBuilder0.append(s3);
        LogU.d("MelonWebViewFragment", stringBuilder0.toString());
        if(this.isFragmentValid()) {
            if(this.mRequestCommandDialog != null && this.mRequestCommandDialog.isShowing()) {
                this.mRequestCommandDialog.dismiss();
            }
            SharableArtistFriendship sharableArtistFriendship0 = null;
            int v = 0;
            if("cateListTabPop".equals(s)) {
                MelonCategoryPopup melonCategoryPopup0 = new MelonCategoryPopup(this.getActivity(), s2, s3);
                melonCategoryPopup0.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override  // android.widget.AdapterView$OnItemClickListener
                    public void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
                        Category category0 = (Category)adapterView0.getAdapter().getItem(v);
                        StringBuilder stringBuilder0 = new StringBuilder();
                        A7.d.u(stringBuilder0, s1, "?cateId=", category0.getId(), "&cateNum=");
                        stringBuilder0.append(category0.getNum());
                        MelonWebViewFragment.this.loadUrl(stringBuilder0.toString());
                        melonCategoryPopup0.dismiss();
                    }
                });
                this.mRequestCommandDialog = melonCategoryPopup0;
                melonCategoryPopup0.show();
                return;
            }
            if("openAlbumSNS".equals(s)) {
                String[] arr_s = this.getResources().getStringArray(0x7F030001);  // array:alert_dlg_sns_list_item_1
                ContextListItemBuilder contextListItemBuilder0 = ContextListItemBuilder.newInstance();
                while(v < arr_s.length) {
                    String s4 = arr_s[v];
                    ContextItemInfo contextItemInfo0 = ContextItemInfo.a(new v9.d(s4));
                    Params contextItemInfo$Params0 = new Params();
                    contextItemInfo$Params0.a = s4;
                    contextItemInfo0.b(contextItemInfo$Params0);
                    contextListItemBuilder0.add(contextItemInfo0);
                    ++v;
                }
                ContextListPopup contextListPopup0 = new ContextListPopup(this.getActivity());
                contextListPopup0.setTitle("공유하기");
                contextListPopup0.setListItems(contextListItemBuilder0.build());
                contextListPopup0.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    @Override  // com.iloen.melon.popup.ContextListPopup$OnMenuItemClickListener
                    public void onItemClick(ContextItemInfo contextItemInfo0, ContextItemType contextItemType0, Params contextItemInfo$Params0) {
                        SharablePlaylist sharablePlaylist0;
                        MelonWebViewFragment melonWebViewFragment0;
                        try {
                            melonWebViewFragment0 = MelonWebViewFragment.this;
                            JSONObject jSONObject0 = new JSONObject(s1);
                            String s = jSONObject0.getString("id");
                            String s1 = jSONObject0.getString("memberKey");
                            String s2 = jSONObject0.getString("title");
                            String s3 = jSONObject0.getString("nickName");
                            String s4 = jSONObject0.getString("modDate");
                            com.iloen.melon.sns.model.c c0 = new com.iloen.melon.sns.model.c();
                            c0.a = s;
                            c0.d = s1;
                            c0.e = s2;
                            c0.f = s3;
                            c0.g = s4;
                            sharablePlaylist0 = new SharablePlaylist(c0);
                        }
                        catch(JSONException jSONException0) {
                            jSONException0.printStackTrace();
                            sharablePlaylist0 = null;
                        }
                        melonWebViewFragment0.showSNSListPopup(sharablePlaylist0);
                    }
                });
                this.mRequestCommandDialog = contextListPopup0;
                contextListPopup0.show();
                return;
            }
            if("confirm".equals(s)) {
                this.mRequestCommandDialog = PopupHelper.showConfirmPopup(this.getActivity(), this.getString(0x7F1300D0), s1, new DialogInterface.OnClickListener() {  // string:alert_dlg_title_info "안내"
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface dialogInterface0, int v) {
                        switch(v) {
                            case -2: {
                                if(!TextUtils.isEmpty(s3)) {
                                    if(s2.contains("melonapp")) {
                                        Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse(s3));
                                        MelonWebViewFragment.this.startActivity(intent0);
                                        return;
                                    }
                                    MelonWebViewFragment.this.loadUrl(s3);
                                    return;
                                }
                                break;
                            }
                            case -1: {
                                if(!TextUtils.isEmpty(s2)) {
                                    if(s2.contains("melonapp")) {
                                        Intent intent1 = new Intent("android.intent.action.VIEW", Uri.parse(s2));
                                        MelonWebViewFragment.this.startActivity(intent1);
                                        return;
                                    }
                                    MelonWebViewFragment.this.loadUrl(s2);
                                    return;
                                }
                                break;
                            }
                        }
                    }
                });
                return;
            }
            if("msgBox".equals(s)) {
                String s5 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                if("confirm".equals(s1)) {
                    this.mRequestCommandDialog = PopupHelper.showConfirmPopup(this.getActivity(), s5, s2, new DialogInterface.OnClickListener() {
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface dialogInterface0, int v) {
                            if(v == -1 && !TextUtils.isEmpty(s3)) {
                                if(s3.contains("melonapp")) {
                                    Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse(s3));
                                    MelonWebViewFragment.this.startActivity(intent0);
                                    return;
                                }
                                MelonWebViewFragment.this.loadUrl(s3);
                            }
                        }
                    });
                    return;
                }
                if("alert".equals(s1)) {
                    this.mRequestCommandDialog = PopupHelper.showAlertPopup(this.getActivity(), s5, s2, new DialogInterface.OnClickListener() {
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface dialogInterface0, int v) {
                            if(!TextUtils.isEmpty(s3)) {
                                if(s3.contains("melonapp")) {
                                    Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse(s3));
                                    MelonWebViewFragment.this.startActivity(intent0);
                                    return;
                                }
                                MelonWebViewFragment.this.loadUrl(s3);
                            }
                        }
                    });
                    return;
                }
                if("dcfInfo".equals(s1)) {
                    if(MelonPrefs.getInstance().getBoolean("AGAIN_NEVER_SHOW_DCF_INFO_POPUP", false)) {
                        this.loadUrl(s3);
                        return;
                    }
                    MelonDcfMoreInfoPopup melonDcfMoreInfoPopup0 = new MelonDcfMoreInfoPopup(this.getActivity(), s2);
                    melonDcfMoreInfoPopup0.setPopupOnClickListener(new DialogInterface.OnClickListener() {
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface dialogInterface0, int v) {
                            switch(v) {
                                case -12: {
                                    if(MelonWebViewFragment.this instanceof PopupWebView) {
                                        EventBusHelper.post(new DialogClose());
                                    }
                                    Navigator.openMelonSupportPlayback();
                                    return;
                                }
                                case -10: {
                                    MelonWebViewFragment.this.loadUrl(s3);
                                }
                            }
                        }
                    });
                    melonDcfMoreInfoPopup0.show();
                    this.mRequestCommandDialog = melonDcfMoreInfoPopup0;
                }
            }
            else {
                if("onJsAlert".equals(s)) {
                    int v1 = Integer.parseInt(s2);
                    MelonTextPopup melonTextPopup0 = PopupHelper.showAlertPopup(this.getActivity(), this.getString(0x7F1300D0), s1, (/* 缺少LAMBDA参数 */, int v1) -> if(this.val$hashCode > 0) {
                        Hashtable hashtable0 = MelonWebView.I;
                        JsResult jsResult0 = (JsResult)hashtable0.get(this.val$hashCode);
                        if(jsResult0 != null) {
                            hashtable0.remove(this.val$hashCode);
                            if(v1 == -1) {
                                jsResult0.confirm();
                                return;
                            }
                            jsResult0.cancel();
                        }
                    });
                    this.mRequestCommandDialog = melonTextPopup0;
                    melonTextPopup0.setOnDismissListener((/* 缺少LAMBDA参数 */) -> if(this.val$hashCode > 0) {
                        Hashtable hashtable0 = MelonWebView.I;
                        JsResult jsResult0 = (JsResult)hashtable0.get(this.val$hashCode);
                        if(jsResult0 != null) {
                            hashtable0.remove(this.val$hashCode);
                            if(-2 == -1) {
                                jsResult0.confirm();
                                return;
                            }
                            jsResult0.cancel();
                        }
                    });
                    return;
                }
                if("onJsConfirm".equals(s)) {
                    int v2 = Integer.parseInt(s2);
                    MelonTextPopup melonTextPopup1 = PopupHelper.showConfirmPopup(this.getActivity(), this.getString(0x7F1300D0), s1, (/* 缺少LAMBDA参数 */, int v1) -> if(this.val$hashCode > 0) {
                        Hashtable hashtable0 = MelonWebView.I;
                        JsResult jsResult0 = (JsResult)hashtable0.get(this.val$hashCode);
                        if(jsResult0 != null) {
                            hashtable0.remove(this.val$hashCode);
                            if(v1 == -1) {
                                jsResult0.confirm();
                                return;
                            }
                            jsResult0.cancel();
                        }
                    });
                    this.mRequestCommandDialog = melonTextPopup1;
                    melonTextPopup1.setOnDismissListener((/* 缺少LAMBDA参数 */) -> if(this.val$hashCode > 0) {
                        Hashtable hashtable0 = MelonWebView.I;
                        JsResult jsResult0 = (JsResult)hashtable0.get(this.val$hashCode);
                        if(jsResult0 != null) {
                            hashtable0.remove(this.val$hashCode);
                            if(-2 == -1) {
                                jsResult0.confirm();
                                return;
                            }
                            jsResult0.cancel();
                        }
                    });
                    return;
                }
                if("present".equals(s)) {
                    try {
                        JSONObject jSONObject0 = new JSONObject(s1);
                        LogU.d("MelonWebViewFragment", "requestCommand() present count : " + Integer.parseInt(jSONObject0.getString("songCnt")));
                        ArrayList arrayList0 = new ArrayList();
                        JSONArray jSONArray0 = jSONObject0.getJSONArray("songs");
                        while(v < jSONArray0.length()) {
                            JSONObject jSONObject1 = jSONArray0.getJSONObject(v);
                            Builder playable$Builder0 = Playable.newBuilder().songId(jSONObject1.getString("songId")).songName(jSONObject1.getString("songName")).cType(CType.SONG).isMelonSong(true).artists(StringUtils.makeArtistMap("", jSONObject1.getString("artistName")));
                            if(jSONObject1.has("menuId")) {
                                playable$Builder0.menuId(jSONObject1.getString("menuId"));
                            }
                            arrayList0.add(playable$Builder0.build());
                            ++v;
                        }
                        this.openPresentSendPage(null, arrayList0);
                        return;
                    }
                    catch(JSONException jSONException0) {
                    }
                    catch(NumberFormatException numberFormatException0) {
                        LogU.e("MelonWebViewFragment", "requestCommand() present : " + numberFormatException0.toString());
                        return;
                    }
                    LogU.e("MelonWebViewFragment", "requestCommand() present : " + jSONException0.toString());
                    return;
                }
                if("AwardSNS".equals(s)) {
                    this.showSNSListPopup(new SharableMelOnAward());  // 初始化器: Ljava/lang/Object;-><init>()V
                    return;
                }
                if("shareSNS".equals(s)) {
                    if("afr".equals(s1)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(s2);
                            String s6 = jSONObject2.getString("ARTISTID");
                            String s7 = jSONObject2.getString("ARTISTNAME");
                            String s8 = jSONObject2.getString("TODAYDATE");
                            String s9 = jSONObject2.getString("TOTALUSERRANK");
                            String s10 = jSONObject2.getString("USERRANK");
                            String s11 = jSONObject2.getString("USERTEMPER");
                            String s12 = jSONObject2.getString("MENUID");
                            SharableArtistFriendship sharableArtistFriendship1 = new SharableArtistFriendship();  // 初始化器: Ljava/lang/Object;-><init>()V
                            sharableArtistFriendship1.a = s6;
                            sharableArtistFriendship1.b = s7;
                            sharableArtistFriendship1.d = null;
                            sharableArtistFriendship1.e = s8;
                            sharableArtistFriendship1.f = s9;
                            sharableArtistFriendship1.g = s10;
                            sharableArtistFriendship1.h = s11;
                            sharableArtistFriendship1.i = s12;
                            sharableArtistFriendship1.j = null;
                            sharableArtistFriendship1.k = null;
                            sharableArtistFriendship0 = sharableArtistFriendship1;
                        }
                        catch(JSONException jSONException1) {
                            jSONException1.printStackTrace();
                        }
                    }
                    else {
                        try {
                            JSONObject jSONObject3 = new JSONObject(s2);
                            String s13 = jSONObject3.getString("ID");
                            String s14 = jSONObject3.getString("LINK");
                            String s15 = jSONObject3.getString("POSTIMG");
                            String s16 = jSONObject3.getString("CONTENT");
                            SharableContent sharableContent0 = new SharableContent();  // 初始化器: Ljava/lang/Object;-><init>()V
                            sharableContent0.a = s1;
                            sharableContent0.b = s13;
                            sharableContent0.d = s14;
                            sharableContent0.e = s15;
                            sharableContent0.f = s16;
                            sharableArtistFriendship0 = sharableContent0;
                        }
                        catch(JSONException jSONException2) {
                            jSONException2.printStackTrace();
                        }
                    }
                    if(sharableArtistFriendship0 != null) {
                        this.showSNSListPopup(sharableArtistFriendship0);
                    }
                }
                else {
                    if("commentList".equals(s)) {
                        try {
                            this.performBackPress();
                            JSONObject jSONObject4 = new JSONObject(s2);
                            EventBusHelper.post(new EventComment(s1, jSONObject4.getInt("chnlSeq"), jSONObject4.getInt("cmtSeq")));
                        }
                        catch(Exception exception0) {
                            H0.b.v(exception0, new StringBuilder("requestCommand() commentList : "), "MelonWebViewFragment");
                        }
                        return;
                    }
                    if("updateVoiceAlbumPurchaseList".equals(s)) {
                        this.getParentFragmentManager().i0(new Bundle(), "key_voice_alarm_list_updated");
                        return;
                    }
                    if("closeMusicWavePlayer".equals(s)) {
                        this.playerUseCase.t();
                        return;
                    }
                    if("treviShowAdIdSetting".equals(s)) {
                        this.startActivity(new Intent("com.google.android.gms.settings.ADS_PRIVACY"));
                        return;
                    }
                    if("treviShowLogin".equals(s)) {
                        if(((e0)va.o.a()).m()) {
                            MelonTextPopup melonTextPopup2 = new MelonTextPopup(this.getActivity(), 2);
                            melonTextPopup2.setTitleName(this.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
                            melonTextPopup2.setBodyMsg(this.getString(0x7F13007A));  // string:alert_dlg_body_cash_friends_need_kakao_account "고객님! 캐시프렌즈 이용을 위해 카카오톡 계정과 
                                                                                     // 연동이 필요합니다."
                            melonTextPopup2.setPopupOnClickListener(new Xb.a(2));
                            melonTextPopup2.setRightBtnName(this.getString(0x7F1300C5));  // string:alert_dlg_link_button_cash_friends_need_kakao_account "계정 연동하기"
                            melonTextPopup2.show();
                            return;
                        }
                        this.openLoginView(f.f);
                    }
                }
            }
        }

        class com.iloen.melon.fragments.webview.MelonWebViewFragment.15 implements DialogInterface.OnClickListener {
            public com.iloen.melon.fragments.webview.MelonWebViewFragment.15(int v) {
            }

            @Override  // android.content.DialogInterface$OnClickListener
            public void onClick(DialogInterface dialogInterface0, int v) {
                MelonWebViewFragment.this.updateWebViewResult(this.val$hashCode, v);
            }
        }


        class com.iloen.melon.fragments.webview.MelonWebViewFragment.16 implements DialogInterface.OnDismissListener {
            public com.iloen.melon.fragments.webview.MelonWebViewFragment.16(int v) {
            }

            @Override  // android.content.DialogInterface$OnDismissListener
            public void onDismiss(DialogInterface dialogInterface0) {
                MelonWebViewFragment.this.updateWebViewResult(this.val$hashCode, -2);
            }
        }


        class com.iloen.melon.fragments.webview.MelonWebViewFragment.17 implements DialogInterface.OnClickListener {
            public com.iloen.melon.fragments.webview.MelonWebViewFragment.17(int v) {
            }

            @Override  // android.content.DialogInterface$OnClickListener
            public void onClick(DialogInterface dialogInterface0, int v) {
                MelonWebViewFragment.this.updateWebViewResult(this.val$hashCode, v);
            }
        }


        class com.iloen.melon.fragments.webview.MelonWebViewFragment.18 implements DialogInterface.OnDismissListener {
            public com.iloen.melon.fragments.webview.MelonWebViewFragment.18(int v) {
            }

            @Override  // android.content.DialogInterface$OnDismissListener
            public void onDismiss(DialogInterface dialogInterface0) {
                MelonWebViewFragment.this.updateWebViewResult(this.val$hashCode, -2);
            }
        }

    }

    private void requestWebViewFocus() {
        new Handler(Looper.myLooper()).post(new com.iloen.melon.fragments.webview.b(this, 1));
    }

    @Override  // com.iloen.melon.custom.MelonWebViewListener
    public void restoreScreenRotation() {
        ViewUtils.setOrientation(this.getActivity(), (this.isScreenLandscapeSupported() ? 13 : 1));
    }

    private static boolean saveAdditionalHttpHeaders(Context context0, String s, Serializable serializable0) {
        if(context0 != null && !TextUtils.isEmpty(s) && serializable0 != null) {
            String s1 = StringUtils.toString(serializable0);
            if(TextUtils.isEmpty(s1)) {
                LogU.w("MelonWebViewFragment", "saveAdditionalHttpHeaders() invalid convertedHeaders");
                return false;
            }
            P.b();
            x9.a a0 = P.a();
            if(a0 != null) {
                RestoreDataEntity restoreDataEntity0 = new RestoreDataEntity();
                restoreDataEntity0.setRestore_id(s);
                restoreDataEntity0.setData(s1);
                w.N(((VolatileDatabase_Impl)a0.a), false, true, new l(25, a0, restoreDataEntity0));
                return true;
            }
            return false;
        }
        LogU.w("MelonWebViewFragment", "saveAdditionalHttpHeaders() invalid parameter");
        return false;
    }

    private List saveHistoryUrls(Bundle bundle0) {
        MelonWebView melonWebView0 = this.mWebView;
        if(melonWebView0 != null) {
            WebBackForwardList webBackForwardList0 = melonWebView0.saveState(bundle0);
            if(webBackForwardList0 != null) {
                List list0 = new ArrayList();
                for(int v = 0; v < webBackForwardList0.getSize(); ++v) {
                    String s = webBackForwardList0.getItemAtIndex(v).getUrl();
                    if(!TextUtils.isEmpty(s)) {
                        byte[] arr_b = s.getBytes();
                        byte[] arr_b1 = new byte[arr_b.length];
                        System.arraycopy(arr_b, 0, arr_b1, 0, arr_b.length);
                        ((ArrayList)list0).add(new String(arr_b1));
                        LogU.d("MelonWebViewFragment", "saveHistoryUrls() history url: " + s);
                    }
                }
                this.dumpWebViewHistory(webBackForwardList0);
                return list0;
            }
        }
        return null;
    }

    private static boolean saveHistoryUrlsToDb(Context context0, String s, List list0) {
        if(context0 != null && !TextUtils.isEmpty(s) && list0 != null) {
            P.b();
            x9.a a0 = P.a();
            if(a0 != null) {
                RestoreDataEntity restoreDataEntity0 = new RestoreDataEntity();
                restoreDataEntity0.setRestore_id(s);
                restoreDataEntity0.setData(MelonWebViewFragment.toJsonHistoryUrls(list0));
                w.N(((VolatileDatabase_Impl)a0.a), false, true, new l(25, a0, restoreDataEntity0));
                return true;
            }
            return false;
        }
        LogU.w("MelonWebViewFragment", "saveHistoryUrlstoDb() invalid parameter");
        return false;
    }

    private static boolean saveWebviewChromeStateToDb(Context context0, String s, byte[] arr_b) {
        if(context0 != null && !TextUtils.isEmpty(s)) {
            P.b();
            x9.a a0 = P.a();
            if(a0 != null) {
                RestoreDataEntity restoreDataEntity0 = new RestoreDataEntity();
                restoreDataEntity0.setRestore_id(s);
                restoreDataEntity0.setData(SimpleCrypto.toHex(arr_b));
                w.N(((VolatileDatabase_Impl)a0.a), false, true, new l(25, a0, restoreDataEntity0));
                return true;
            }
            return false;
        }
        LogU.w("MelonWebViewFragment", "saveWebViewChromeStateToDb() invalid parameter");
        return false;
    }

    private void setCookies(Context context0, boolean z) {
        CookieHelper cookieHelper0 = CookieHelper.getInstance();
        cookieHelper0.initCookies(context0);
        if(z) {
            this.mIsFirstEntry = false;
        }
        cookieHelper0.updateServiceCookies(z);
        if(this.mWebView != null) {
            CookieManager cookieManager0 = CookieManager.getInstance();
            if(cookieManager0 != null) {
                cookieManager0.setAcceptThirdPartyCookies(this.mWebView, true);
            }
        }
    }

    public void setJsConnect(I1 i10) {
        this.jsConnect = i10;
        MelonWebView melonWebView0 = this.mWebView;
        if(melonWebView0 != null) {
            melonWebView0.setWebViewJSConnect(i10);
        }
    }

    private void setNetworkIconMarginHeight(boolean z) {
        View view0 = this.mNetworkIconIv;
        if(view0 == null) {
            return;
        }
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)view0.getLayoutParams();
        linearLayout$LayoutParams0.topMargin = ScreenUtils.dipToPixel(this.getContext(), (z ? 75.0f : 20.0f));
        this.mNetworkIconIv.setLayoutParams(linearLayout$LayoutParams0);
    }

    private void setToolbarListener(boolean z) {
        s1 s10 = null;
        ToolBar toolBar0 = this.mToolBar;
        if(toolBar0 != null) {
            toolBar0.setOnToolBarAnimationListener((z ? this.mToolBarAnimationListener : null));
            ToolBar toolBar1 = this.mToolBar;
            if(z) {
                s10 = this.mToolBarListener;
            }
            toolBar1.setOnToolBarListener(s10);
        }
    }

    @Override  // com.iloen.melon.custom.MelonWebViewListener
    public boolean shouldOverrideUrlLoading(WebView webView0, String s) {
        LogU.d("MelonWebViewFragment", "shouldOverrideUrlLoading url : " + s);
        if(!TextUtils.isEmpty(s)) {
            if(!s.endsWith("FROMAPP")) {
                if(!s.endsWith("&navhint=hist")) {
                    goto label_15;
                }
                int v = s.lastIndexOf("&navhint=hist");
                if(v != -1) {
                    String s1 = s.substring(0, v);
                    ((MelonWebView)webView0).j(s1, "navhint=hist");
                    if(((MelonWebView)webView0).e()) {
                        return true;
                    }
                    LogU.w("MelonWebViewFragment", "savedReturnUrl not found in history - loadUrl directly: " + s1);
                    this.loadUrl(s1);
                    return true;
                label_15:
                    if(s.startsWith("snssdk")) {
                        return true;
                    }
                    Uri uri0 = Uri.parse(s);
                    int v1 = f.c(uri0);
                    Z.r(v1, "shouldOverrideUrlLoading matchResult : ", "MelonWebViewFragment");
                    String s2 = "Y";
                    switch(v1) {
                        case 10: {
                            if("Y".equalsIgnoreCase(uri0.getQueryParameter("exclude_adult_content"))) {
                                this.navigateBack();
                                FragmentActivity fragmentActivity0 = this.getActivity();
                                if(fragmentActivity0 != null) {
                                    pb.l l0 = new pb.l(this.playlistManager, 0);
                                    ye.a.B(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, new j(l0, null), 7).addListener(new com.iloen.melon.fragments.webview.b(this, 0), P1.c.getMainExecutor(fragmentActivity0));
                                    return true;
                                }
                            }
                            break;
                        }
                        case 0x709: {
                            String s3 = uri0.getQueryParameter("menuId");
                            String s4 = uri0.getQueryParameter("page");
                            String s5 = uri0.getQueryParameter("section");
                            MenuIdQueue menuIdQueue0 = MenuIdQueue.getInstance();
                            menuIdQueue0.setSkipAction(false);
                            String s6 = menuIdQueue0.peek();
                            menuIdQueue0.offer(s3);
                            this.loadUrl("javascript:__appSendMenuId(\'" + s6 + "\')");
                            LogU.v("MelonWebViewFragment", "WEBVIEW_REQUEST_MENUID - webViewMenuId: " + s3 + ", appMenuId: " + s6);
                            String s7 = Z.m(MelonAppBase.Companion, 0x7F130FD3, "getString(...)");  // string:tiara_pv_log_action_name "페이지보기"
                            HashMap hashMap0 = p8.q.b();
                            hashMap0.put("menuid", s3);
                            hashMap0.put("orgmenuid", s6);
                            if(u.u(((e0)va.o.a()).j()).equals("4")) {
                                s2 = "N";
                            }
                            hashMap0.put("charged", s2);
                            if(!TextUtils.isEmpty(s5) && !TextUtils.isEmpty(s4)) {
                                try {
                                    String s8 = URLDecoder.decode(s5, "utf-8");
                                    String s9 = URLDecoder.decode(s4, "utf-8");
                                    p8.q.c().trackPage(s8 + s7).section(s8).page(s9).customProps(hashMap0).adTrackId("2875552754074864296").track();
                                }
                                catch(Exception exception0) {
                                    LogU.Companion.w("MelonTiaraLogHelper", "sendWebviewPvLog() - " + exception0);
                                }
                                return true;
                            }
                            p8.q.c().trackPage(s7).page(s3).customProps(hashMap0).adTrackId("2875552754074864296").track();
                            return true;
                        }
                        case 0x70A: {
                            String s10 = uri0.getQueryParameter("menuId");
                            LogU.v("MelonWebViewFragment", "WEBVIEW_SEND_MENUID - menuId: " + s10);
                            MenuIdQueue.getInstance().offer(s10);
                            return true;
                        }
                        case 0x70B: {
                            LogU.v("MelonWebViewFragment", "WEBVIEW_BNRSGMT");
                            this.loadUrl("javascript:__appSendBnrSgmt(\'\')");
                            return true;
                        }
                        case 0xAF0: {
                            LogU.v("MelonWebViewFragment", "AUDIOFOCUS_REQUEST");
                            FragmentActivity fragmentActivity1 = this.getActivity();
                            if(fragmentActivity1 != null) {
                                MelonAppBase.instance.setLoanedAudioFocus(true);
                                Context context0 = fragmentActivity1.getApplicationContext();
                                q.d(context0);
                                ((Qb.z)((k8.o)(((m)com.google.firebase.b.B(context0, m.class)))).t.get()).r();
                                return true;
                            }
                            break;
                        }
                        default: {
                            return uri0.isHierarchical() ? Airbridge.click(uri0, new com.iloen.melon.fragments.webview.c(uri0, 0), new com.iloen.melon.fragments.webview.c(uri0, 1)) : false;
                        }
                    }
                    return uri0.isHierarchical() ? Airbridge.click(uri0, new com.iloen.melon.fragments.webview.c(uri0, 0), new com.iloen.melon.fragments.webview.c(uri0, 1)) : false;
                }
            }
            else if("FROMAPP".equals(Uri.parse(s).getLastPathSegment())) {
                this.navigateBack();
                return true;
            }
        }
        return false;
    }

    @Override  // com.iloen.melon.custom.x0
    public void showAddSongsToDjPlaylistPopup(String[] arr_s, String[] arr_s1, String[] arr_s2) {
        if(arr_s1 != null && arr_s != null) {
            this.mCachedAlbumId.clear();
            int v = Math.min(arr_s1.length, arr_s.length);
            for(int v1 = 0; v1 < v; ++v1) {
                this.addCachedAlbumId(arr_s[v1], arr_s1[v1]);
            }
            this.myAlbumSongIds = arr_s2;
            this.sendPopupMessage(2);
        }
    }

    @Override  // com.iloen.melon.custom.x0
    public void showAddSongsToPlaylistPopup(String[] arr_s, String[] arr_s1, String[] arr_s2) {
        if(arr_s1 != null && arr_s != null) {
            this.mCachedAlbumId.clear();
            int v = Math.min(arr_s1.length, arr_s.length);
            for(int v1 = 0; v1 < v; ++v1) {
                this.addCachedAlbumId(arr_s[v1], arr_s1[v1]);
            }
            this.myAlbumSongIds = arr_s2;
            this.sendPopupMessage(1);
        }
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void showBlockedProgress(boolean z) {
        if(z) {
            this.showProgressDialog();
            return;
        }
        this.dismissProgressDialog();
    }

    @Override  // com.iloen.melon.custom.x0
    public void showCategoryListPopup(String s, String[] arr_s, String[] arr_s1) {
        LogU.d("MelonWebViewFragment", "showCategoryListPopup()");
        this.showListPopup(s, arr_s, arr_s1, new OnMenuItemClickListener() {
            @Override  // com.iloen.melon.popup.ContextListPopup$OnMenuItemClickListener
            public void onItemClick(ContextItemInfo contextItemInfo0, ContextItemType contextItemType0, Params contextItemInfo$Params0) {
                if(contextItemInfo0 != null) {
                    MelonWebViewFragment.this.loadUrl("javascript:__appCatePageView(\'" + contextItemInfo$Params0.a + "\')");
                }
            }
        });
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void showContextPopupAlbum(Playable playable0) {
        if(!this.isAdded() || !this.isPossiblePopupShow()) {
            return;
        }
        if(playable0 == null) {
            LogU.w("MelonWebViewFragment", "showContextPopupFromAlbum() invalid playable");
            return;
        }
        LogU.d("MelonWebViewFragment", "showContextPopupFromAlbum() playable:" + playable0);
        zd.d d0 = new zd.d(playable0);
        l0 l00 = this.getChildFragmentManager();
        com.iloen.melon.fragments.mymusic.dna.d d1 = new com.iloen.melon.fragments.mymusic.dna.d(12);
        com.iloen.melon.fragments.webview.a a0 = new com.iloen.melon.fragments.webview.a(this, playable0, 0);
        com.melon.ui.popup.b.n(l00, d0, d1, E.a, a0);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void showContextPopupSong(Playable playable0) {
        if(!this.isAdded() || !this.isPossiblePopupShow()) {
            return;
        }
        if(playable0 == null) {
            LogU.w("MelonWebViewFragment", "showContextPopupFromSong() invalid playable");
            return;
        }
        LogU.d("MelonWebViewFragment", "showContextPopupFromSong() playable:" + playable0);
        A0 a00 = new A0(playable0);
        l0 l00 = this.getChildFragmentManager();
        com.iloen.melon.fragments.mymusic.dna.d d0 = new com.iloen.melon.fragments.mymusic.dna.d(13);
        com.iloen.melon.fragments.webview.a a0 = new com.iloen.melon.fragments.webview.a(this, playable0, 1);
        com.melon.ui.popup.b.n(l00, a00, d0, E.a, a0);
    }

    @Override  // com.iloen.melon.custom.x0
    public void showDjPlylstPopup(String s, String s1, String s2, String s3, String s4, String s5) {
        DjPlayListInfoBase djPlayListInfoBase0 = new DjPlayListInfoBase();
        djPlayListInfoBase0.plylstseq = s;
        djPlayListInfoBase0.plylsttitle = s1;
        djPlayListInfoBase0.ownermemberkey = s2;
        djPlayListInfoBase0.ownernickname = s3;
        djPlayListInfoBase0.withdrawyn = s4;
        djPlayListInfoBase0.thumbimg = s5;
        this.showContextPopupDjPlaylist(djPlayListInfoBase0);
    }

    @Override  // com.iloen.melon.custom.MelonWebViewListener
    public boolean showFileChooser(WebView webView0, ValueCallback valueCallback0, Object object0) {
        File file0;
        ValueCallback valueCallback1 = this.mFilePathCallback;
        Intent intent0 = null;
        if(valueCallback1 != null) {
            valueCallback1.onReceiveValue(null);
        }
        this.mFilePathCallback = valueCallback0;
        Intent intent1 = new Intent("android.media.action.IMAGE_CAPTURE");
        if(intent1.resolveActivity(this.getActivity().getPackageManager()) == null) {
            intent0 = intent1;
        }
        else {
            try {
                file0 = null;
                file0 = FileUtils.createImageFile(this.requireContext());
                intent1.putExtra("PhotoPath", this.mCameraPhotoPath);
            }
            catch(IOException iOException0) {
                LogU.e("MelonWebViewFragment", "showFileChooser Unable to create Image File", iOException0);
            }
            if(file0 != null) {
                this.mCameraPhotoPath = "file:" + FileUtils.getSafetyPath(file0);
                intent1.putExtra("output", FileUtils.getFileUri(this.getContext(), file0));
                intent0 = intent1;
            }
        }
        Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
        intent2.addCategory("android.intent.category.OPENABLE");
        intent2.setType("*/*");
        Intent intent3 = new Intent("android.intent.action.CHOOSER");
        intent3.putExtra("android.intent.extra.INTENT", intent2);
        intent3.putExtra("android.intent.extra.TITLE", "File Chooser");
        intent3.putExtra("android.intent.extra.INITIAL_INTENTS", (intent0 == null ? new Intent[0] : new Intent[]{intent0}));
        this.activityResult.b(intent3);
        return true;
    }

    @Override  // com.iloen.melon.custom.x0
    public void showGenreListPopup(String s, String[] arr_s, String[] arr_s1) {
        LogU.d("MelonWebViewFragment", "showGenreListPopup()");
        this.showListPopup(s, arr_s, arr_s1, new OnMenuItemClickListener() {
            @Override  // com.iloen.melon.popup.ContextListPopup$OnMenuItemClickListener
            public void onItemClick(ContextItemInfo contextItemInfo0, ContextItemType contextItemType0, Params contextItemInfo$Params0) {
                if(contextItemInfo0 != null) {
                    MelonWebViewFragment.this.loadUrl("javascript:__appGenrePageView(\'" + contextItemInfo$Params0.a + "\')");
                }
            }
        });
    }

    private void showListPopup(String s, String[] arr_s, String[] arr_s1, OnMenuItemClickListener contextListPopup$OnMenuItemClickListener0) {
        ContextListItemBuilder contextListItemBuilder0 = ContextListItemBuilder.newInstance();
        if(arr_s != null && arr_s.length > 0 && arr_s1 != null && arr_s1.length > 0) {
            int v = Math.min(arr_s.length, arr_s1.length);
            for(int v1 = 0; v1 < v; ++v1) {
                ContextItemInfo contextItemInfo0 = ContextItemInfo.a(new v9.d(arr_s1[v1]));
                Params contextItemInfo$Params0 = new Params();
                contextItemInfo$Params0.a = arr_s[v1];
                contextItemInfo0.b(contextItemInfo$Params0);
                contextListItemBuilder0.add(contextItemInfo0);
            }
        }
        ContextListPopup contextListPopup0 = new ContextListPopup(this.getActivity());
        contextListPopup0.setTitle(s);
        contextListPopup0.setListItems(contextListItemBuilder0.build());
        contextListPopup0.setOnMenuItemClickListener(contextListPopup$OnMenuItemClickListener0);
        contextListPopup0.show();
    }

    @Override  // com.iloen.melon.custom.x0
    public void showMediaContextListPopup(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, boolean z, boolean z1, String s12) {
        WebContextListInfo.C(this.mCtxInfo);
        WebContextListInfo.B(this.mCtxInfo, s);
        WebContextListInfo.u(this.mCtxInfo, s1);
        WebContextListInfo.A(this.mCtxInfo, s2);
        WebContextListInfo.y(this.mCtxInfo, s3);
        WebContextListInfo.o(this.mCtxInfo, s4);
        WebContextListInfo.p(this.mCtxInfo, s5);
        WebContextListInfo.v(this.mCtxInfo, s6);
        WebContextListInfo.w(this.mCtxInfo, s7);
        WebContextListInfo.q(this.mCtxInfo, s8);
        WebContextListInfo.n(this.mCtxInfo, s9);
        WebContextListInfo.r(this.mCtxInfo, s10);
        WebContextListInfo.x(this.mCtxInfo, s11);
        WebContextListInfo.t(this.mCtxInfo, z);
        WebContextListInfo.s(this.mCtxInfo, z1);
        WebContextListInfo.z(this.mCtxInfo, s12);
        this.mContextType = false;
        LogU.d("MelonWebViewFragment", "showMediaContextListPopup() - ctxInfo:type[] title[] artistName[] adultFlg[] hasMv[] menuId[] songId[] albumId[]artistId[] mvId[] mvSongId[]prodsclascode[]isService[false]isBrandDj[false]thumbnail[]");
        if(!"song".equals(s) && !"flac".equals(s)) {
            if("album".equals(s)) {
                Playable playable0 = this.getAlbumPlayable(this.mCtxInfo);
                if(playable0 == null) {
                    LogU.d("MelonWebViewFragment", "showMediaContextListPopup() invalid playable song");
                    return;
                }
                this.showContextPopupAlbum(playable0);
                return;
            }
            if("mv".equals(s)) {
                this.showContextPopupMv(this.getMvPlayable(this.mCtxInfo));
            }
            return;
        }
        Playable playable1 = this.getSongPlayable(this.mCtxInfo);
        if(playable1 == null) {
            LogU.d("MelonWebViewFragment", "showMediaContextListPopup() invalid playable song");
            return;
        }
        this.showContextPopupSong(playable1);
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void showNetworkDisabledPopup() {
        EventBusHelper.post(new Error());
    }

    @Override  // com.iloen.melon.custom.x0
    public void showSNSListPopup(String[] arr_s, String s) {
        SharableSong sharableSong0;
        if("SongSNS".equals(s)) {
            String s1 = arr_s[0];
            String[] arr_s1 = arr_s[1].split("\\:");
            String s2 = arr_s1[0];
            String s3 = arr_s1[1];
            String s4 = arr_s[2];
            E9.u u0 = new E9.u();  // 初始化器: Ljava/lang/Object;-><init>()V
            u0.a = s2;
            u0.b = s1;
            u0.c = s3;
            u0.f = s4;
            sharableSong0 = new SharableSong(u0);
        }
        else if("AlbumSNS".equals(s)) {
            String s5 = arr_s[0];
            String s6 = arr_s[1];
            String s7 = arr_s[2];
            com.iloen.melon.sns.model.a a0 = new com.iloen.melon.sns.model.a();  // 初始化器: Ljava/lang/Object;-><init>()V
            a0.b = s6;
            a0.f = s7;
            sharableSong0 = new SharableAlbum(a0);
        }
        else if("ArtistSNS".equals(s)) {
            String s8 = arr_s[0];
            String s9 = arr_s[1];
            String s10 = arr_s[2];
            H8.q q0 = new H8.q();  // 初始化器: Ljava/lang/Object;-><init>()V
            q0.a = s9;
            q0.b = s8;
            q0.c = s10;
            sharableSong0 = new SharableArtist(q0);
        }
        else {
            sharableSong0 = null;
        }
        LogU.w("MelonWebViewFragment", "showSNSListPopup : " + sharableSong0);
        this.showSNSListPopup(sharableSong0);
    }

    public void showSoftInputMethod() {
        MelonWebView melonWebView0 = this.mWebView;
        if(melonWebView0 != null) {
            LogU.v("MelonWebView", "showSoftInputMethod()");
            melonWebView0.requestFocus();
            ((InputMethodManager)melonWebView0.getContext().getSystemService("input_method")).showSoftInputFromInputMethod(melonWebView0.getWindowToken(), 1);
        }
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void showToolbar(boolean z, int v, int v1, boolean z1) {
        LogU.v("MelonWebViewFragment", "showToolbar(" + z + "," + v + "," + v1 + "," + z1 + ")");
        this.bEditMode = z1;
        this.mToolbarType = v;
        this.mToolbarCount = v1;
        if(z) {
            this.mHandler.sendEmptyMessage(2);
            return;
        }
        this.mHandler.sendEmptyMessage(3);
    }

    public void showToolbarHandler(boolean z) {
        try {
            if(z) {
                this.updateToolbar();
            }
            ToolBar toolBar0 = this.mToolBar;
            if(toolBar0 != null) {
                toolBar0.h(z);
            }
            return;
        }
        catch(Exception exception0) {
        }
        LogU.e("MelonWebViewFragment", "showToolbarHandler() : " + z);
        LogU.e("MelonWebViewFragment", exception0.toString());
        exception0.printStackTrace();
    }

    private static String toJsonHistoryUrls(List list0) {
        n n0 = new n();
        try {
            return n0.k(list0);
        }
        catch(Exception unused_ex) {
            return "";
        }
    }

    private void updateBottomMargin() {
        this.updateBottomMargin(false, false);
    }

    private void updateBottomMargin(boolean z, boolean z1) {
        int v;
        if(this.isFragmentValid()) {
            ViewGroup viewGroup0 = (ViewGroup)this.findViewById(0x7F0A0DE7);  // id:webview_container
            if(viewGroup0 != null) {
                FragmentActivity fragmentActivity0 = this.getActivity();
                if(fragmentActivity0 instanceof U) {
                    boolean z2 = this.shouldShowMiniPlayer();
                    if(!z || !z1) {
                        v = this.getResources().getDimensionPixelOffset(0x7F070057);  // dimen:bottom_tab_height
                        if(z2) {
                            v = this.getResources().getDimensionPixelOffset(0x7F070315) + v;  // dimen:mini_player_height
                        }
                        int v1 = ((U)fragmentActivity0).getMiniPlayerHeight();
                        if(v1 > 0) {
                            v = v1;
                        }
                    }
                    else {
                        v = this.getResources().getDimensionPixelOffset(0x7F070464);  // dimen:toolbar_height
                    }
                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = viewGroup0.getLayoutParams();
                    if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
                        if(!z2) {
                            v = 0;
                        }
                        ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).bottomMargin = v;
                        viewGroup0.setLayoutParams(viewGroup$LayoutParams0);
                        return;
                    }
                    if(!z2) {
                        v = 0;
                    }
                    viewGroup0.setPadding(0, 0, 0, v);
                }
            }
        }
    }

    public void updateToolbar() {
        StringBuilder stringBuilder0 = new StringBuilder("updateToolbar - toolbarType: ");
        Z.s(this.mToolbarType, "MelonWebViewFragment", stringBuilder0);
        switch(this.mToolbarType) {
            case 0: {
                if(this.bEditMode) {
                    ToolBar.c(this.mToolBar, 100);
                }
                else {
                    ToolBar.c(this.mToolBar, 1000);
                }
                break;
            }
            case 1: {
                ToolBar.c(this.mToolBar, 103);
                break;
            }
            case 2: {
                ToolBar.c(this.mToolBar, 104);
                break;
            }
            case 3: {
                if(this.bEditMode) {
                    ToolBar.c(this.mToolBar, 100);
                }
                else {
                    ToolBar.c(this.mToolBar, 1);
                }
            }
        }
        ToolBar toolBar0 = this.mToolBar;
        if(toolBar0 != null) {
            int v = this.mToolbarCount;
            if(v > 0) {
                toolBar0.l(v);
                return;
            }
            toolBar0.d();
        }
    }

    // 检测为 Lambda 实现
    private void updateWebViewResult(int v, int v1) [...]

    public void webViewRequestMenuIdForMainTab(String s, String s1, String s2) {
    }
}

