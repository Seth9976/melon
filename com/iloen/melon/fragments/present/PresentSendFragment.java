package com.iloen.melon.fragments.present;

import F8.m;
import F8.p;
import Zc.N;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.f0;
import androidx.fragment.app.l0;
import com.android.volley.VolleyError;
import com.iloen.melon.activity.FriendSelectActivity;
import com.iloen.melon.activity.PresentSendedHistoryAddActivity;
import com.iloen.melon.activity.SearchAndAddActivity;
import com.iloen.melon.custom.FlowLayout;
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.custom.ToReceiverViewForPresent;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.k1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.GiftProhibitedWordsCheckReq;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v4x.response.GiftProhibitedWordsCheckRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.contacts.ContactAccessor;
import com.iloen.melon.utils.contacts.ContactInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import e.b;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00B8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\'\u0018\u0000 \u0094\u00012\u00020\u0001:\u0004\u0094\u0001\u0095\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\r\u001A\u00020\u00062\b\u0010\f\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u000F\u0010\bJ+\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0011\u001A\u00020\u00102\b\u0010\u0013\u001A\u0004\u0018\u00010\u00122\b\u0010\f\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00142\b\u0010\f\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001C\u001A\u00020\u00062\u0006\u0010\u001B\u001A\u00020\u001AH\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u001F\u0010%\u001A\u00020\u00062\u0006\u0010\"\u001A\u00020!2\u0006\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\'\u0010\u0003J\u000F\u0010(\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b(\u0010\u0003J\u000F\u0010*\u001A\u00020)H\u0014\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010,\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b,\u0010-J\u000F\u0010.\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b.\u0010-J\u000F\u0010/\u001A\u00020\u0006H$\u00A2\u0006\u0004\b/\u0010\u0003J\u000F\u00101\u001A\u000200H\u0016\u00A2\u0006\u0004\b1\u00102J\u000F\u00103\u001A\u00020#H\u0016\u00A2\u0006\u0004\b3\u00104J\u000F\u00105\u001A\u00020#H\u0016\u00A2\u0006\u0004\b5\u00104J\u0017\u00107\u001A\u00020\u00062\u0006\u00106\u001A\u00020#H\u0014\u00A2\u0006\u0004\b7\u00108J\u000F\u00109\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b9\u0010\u0003J\u000F\u0010:\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b:\u0010\u0003J\u000F\u0010;\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b;\u0010-J\u000F\u0010<\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b<\u0010\u0003J\u000F\u0010=\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b=\u0010-J\u0011\u0010?\u001A\u0004\u0018\u00010>H\u0002\u00A2\u0006\u0004\b?\u0010@R\u001A\u0010A\u001A\u0002008\u0016X\u0096D\u00A2\u0006\f\n\u0004\bA\u0010B\u001A\u0004\bC\u00102R\u001A\u0010D\u001A\u00020#8\u0016X\u0096D\u00A2\u0006\f\n\u0004\bD\u0010E\u001A\u0004\bF\u00104R$\u0010H\u001A\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bH\u0010I\u001A\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010N\u001A\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bN\u0010O\u001A\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010U\u001A\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bU\u0010V\u001A\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010[\u001A\u00020\u00148\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b[\u0010O\u001A\u0004\b\\\u0010Q\"\u0004\b]\u0010SR\"\u0010^\u001A\u00020\u00148\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b^\u0010O\u001A\u0004\b_\u0010Q\"\u0004\b`\u0010SR\"\u0010a\u001A\u00020\u00148\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\ba\u0010O\u001A\u0004\bb\u0010Q\"\u0004\bc\u0010SR6\u0010g\u001A\u0016\u0012\u0004\u0012\u00020e\u0018\u00010dj\n\u0012\u0004\u0012\u00020e\u0018\u0001`f8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bg\u0010h\u001A\u0004\bi\u0010j\"\u0004\bk\u0010lR6\u0010n\u001A\u0016\u0012\u0004\u0012\u00020m\u0018\u00010dj\n\u0012\u0004\u0012\u00020m\u0018\u0001`f8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bn\u0010h\u001A\u0004\bo\u0010j\"\u0004\bp\u0010lR\"\u0010q\u001A\u00020\u001A8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bq\u0010r\u001A\u0004\bs\u0010-\"\u0004\bt\u0010\u001DR$\u0010u\u001A\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bu\u0010B\u001A\u0004\bv\u00102\"\u0004\bw\u0010xR$\u0010y\u001A\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\by\u0010B\u001A\u0004\bz\u00102\"\u0004\b{\u0010xR\'\u0010}\u001A\u0004\u0018\u00010|8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0015\n\u0004\b}\u0010~\u001A\u0005\b\u007F\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R)\u0010\u0086\u0001\u001A\u0014\u0012\u000F\u0012\r \u0085\u0001*\u0005\u0018\u00010\u0084\u00010\u0084\u00010\u0083\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R)\u0010\u0088\u0001\u001A\u0014\u0012\u000F\u0012\r \u0085\u0001*\u0005\u0018\u00010\u0084\u00010\u0084\u00010\u0083\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0087\u0001R)\u0010\u0089\u0001\u001A\u0014\u0012\u000F\u0012\r \u0085\u0001*\u0005\u0018\u00010\u0084\u00010\u0084\u00010\u0083\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0089\u0001\u0010\u0087\u0001R&\u0010\u008A\u0001\u001A\u00020\u001A8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0015\n\u0005\b\u008A\u0001\u0010r\u001A\u0005\b\u008A\u0001\u0010-\"\u0005\b\u008B\u0001\u0010\u001DR\u0018\u0010\u008D\u0001\u001A\u00030\u008C\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u008D\u0001\u0010\u008E\u0001R\"\u0010\u0090\u0001\u001A\u0005\u0018\u00010\u008F\u00018\u0004X\u0084\u0004\u00A2\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001A\u0006\b\u0092\u0001\u0010\u0093\u0001\u00A8\u0006\u0096\u0001"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentSendFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "savedInstanceState", "onCreate", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "show", "updateToolBar", "(Z)V", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "onResume", "onPause", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "shouldShowMiniPlayer", "()Z", "onBackPressed", "sendMessage", "", "getMenuId", "()Ljava/lang/String;", "getMaxReceiverCount", "()I", "getPresentCount", "maxCount", "openPresentSongSearchPage", "(I)V", "createListHeader", "createListFooter", "checkValidFields", "sendPresent", "checkValidMaxRecipientsCount", "Landroid/app/Activity;", "getAttachedActivity", "()Landroid/app/Activity;", "TAG", "Ljava/lang/String;", "getTAG", "MAX_RECEIVER_COUNT", "I", "getMAX_RECEIVER_COUNT", "Lcom/iloen/melon/custom/ToReceiverViewForPresent;", "mToSendersView", "Lcom/iloen/melon/custom/ToReceiverViewForPresent;", "getMToSendersView", "()Lcom/iloen/melon/custom/ToReceiverViewForPresent;", "setMToSendersView", "(Lcom/iloen/melon/custom/ToReceiverViewForPresent;)V", "mPresentEmptyView", "Landroid/view/View;", "getMPresentEmptyView", "()Landroid/view/View;", "setMPresentEmptyView", "(Landroid/view/View;)V", "Landroid/widget/EditText;", "mMessageView", "Landroid/widget/EditText;", "getMMessageView", "()Landroid/widget/EditText;", "setMMessageView", "(Landroid/widget/EditText;)V", "mHeaderView", "getMHeaderView", "setMHeaderView", "mMessageContainer", "getMMessageContainer", "setMMessageContainer", "mDescriptionContainer", "getMDescriptionContainer", "setMDescriptionContainer", "Ljava/util/ArrayList;", "Lcom/iloen/melon/custom/ToReceiverView$Receiver;", "Lkotlin/collections/ArrayList;", "mReceiverList", "Ljava/util/ArrayList;", "getMReceiverList", "()Ljava/util/ArrayList;", "setMReceiverList", "(Ljava/util/ArrayList;)V", "Lcom/iloen/melon/fragments/present/PresentData;", "presentDataList", "getPresentDataList", "setPresentDataList", "mIsCloseConfirm", "Z", "getMIsCloseConfirm", "setMIsCloseConfirm", "mProdId", "getMProdId", "setMProdId", "(Ljava/lang/String;)V", "mEventAuthKey", "getMEventAuthKey", "setMEventAuthKey", "Landroid/widget/TextView;", "mCountView", "Landroid/widget/TextView;", "getMCountView", "()Landroid/widget/TextView;", "setMCountView", "(Landroid/widget/TextView;)V", "Le/b;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "searchFriendActivityResult", "Le/b;", "pickContactActivityResult", "searchSongActivityResult", "isSongPresent", "setSongPresent", "Landroid/text/TextWatcher;", "mTextEditorWatcher", "Landroid/text/TextWatcher;", "Lcom/iloen/melon/fragments/present/PresentSendFragment$OnListViewChangedListener;", "mOnChangedListener", "Lcom/iloen/melon/fragments/present/PresentSendFragment$OnListViewChangedListener;", "getMOnChangedListener", "()Lcom/iloen/melon/fragments/present/PresentSendFragment$OnListViewChangedListener;", "Companion", "OnListViewChangedListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class PresentSendFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u00020\fX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\fX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001A\u00020\fX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001A\u00020\fX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentSendFragment$Companion;", "", "<init>", "()V", "ARG_MENU_ID", "", "ARG_FRAGMENT_TITLE", "ARG_PRESENT_RECEIVER_LIST", "ARG_PRESENT_DATA_LIST", "ARG_PRESENT_PRODUCT_ID", "ARG_PRESENT_EVENT_ENTER_AUTH_KEY", "PRESENT_HEADER_COUNT", "", "PRESENT_FOOTER_COUNT", "VIEW_TYPE_HEADER", "getVIEW_TYPE_HEADER", "()I", "VIEW_TYPE_ITEM", "getVIEW_TYPE_ITEM", "VIEW_TYPE_MESSAGE", "getVIEW_TYPE_MESSAGE", "VIEW_TYPE_DESCRIPTION", "getVIEW_TYPE_DESCRIPTION", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(20)
        public final int getVIEW_TYPE_DESCRIPTION() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        public final int getVIEW_TYPE_HEADER() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        public final int getVIEW_TYPE_ITEM() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        public final int getVIEW_TYPE_MESSAGE() [...] // 潜在的解密器
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bd\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentSendFragment$OnListViewChangedListener;", "", "Lie/H;", "onDataChanged", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface OnListViewChangedListener {
        void onDataChanged();
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_FRAGMENT_TITLE = "argFragmentTitle";
    @NotNull
    public static final String ARG_MENU_ID = "menuId";
    @NotNull
    public static final String ARG_PRESENT_DATA_LIST = "presentDataList";
    @NotNull
    public static final String ARG_PRESENT_EVENT_ENTER_AUTH_KEY = "presentEventEnterAuthKey";
    @NotNull
    public static final String ARG_PRESENT_PRODUCT_ID = "presentProductId";
    @NotNull
    public static final String ARG_PRESENT_RECEIVER_LIST = "presentReceiverList";
    @NotNull
    public static final Companion Companion = null;
    private final int MAX_RECEIVER_COUNT;
    public static final int PRESENT_FOOTER_COUNT = 2;
    public static final int PRESENT_HEADER_COUNT = 1;
    @NotNull
    private final String TAG;
    private static final int VIEW_TYPE_DESCRIPTION;
    private static final int VIEW_TYPE_HEADER;
    private static final int VIEW_TYPE_ITEM;
    private static final int VIEW_TYPE_MESSAGE;
    private boolean isSongPresent;
    @Nullable
    private TextView mCountView;
    public View mDescriptionContainer;
    @Nullable
    private String mEventAuthKey;
    public View mHeaderView;
    private boolean mIsCloseConfirm;
    public View mMessageContainer;
    @Nullable
    private EditText mMessageView;
    @Nullable
    private final OnListViewChangedListener mOnChangedListener;
    @Nullable
    private View mPresentEmptyView;
    @Nullable
    private String mProdId;
    @Nullable
    private ArrayList mReceiverList;
    @NotNull
    private final TextWatcher mTextEditorWatcher;
    @Nullable
    private ToReceiverViewForPresent mToSendersView;
    @NotNull
    private final b pickContactActivityResult;
    @Nullable
    private ArrayList presentDataList;
    @NotNull
    private final b searchFriendActivityResult;
    @NotNull
    private final b searchSongActivityResult;

    static {
        PresentSendFragment.Companion = new Companion(null);
        PresentSendFragment.$stable = 8;
        PresentSendFragment.VIEW_TYPE_ITEM = 1;
        PresentSendFragment.VIEW_TYPE_MESSAGE = 2;
        PresentSendFragment.VIEW_TYPE_DESCRIPTION = 3;
    }

    public PresentSendFragment() {
        this.TAG = "PresentSendFragment";
        this.MAX_RECEIVER_COUNT = 10;
        b b0 = this.registerForActivityResult(new f0(2), new com.iloen.melon.fragments.present.b(this, 0));
        q.f(b0, "registerForActivityResult(...)");
        this.searchFriendActivityResult = b0;
        b b1 = this.registerForActivityResult(new f0(2), new com.iloen.melon.fragments.present.b(this, 1));
        q.f(b1, "registerForActivityResult(...)");
        this.pickContactActivityResult = b1;
        b b2 = this.registerForActivityResult(new f0(2), new com.iloen.melon.fragments.present.b(this, 2));
        q.f(b2, "registerForActivityResult(...)");
        this.searchSongActivityResult = b2;
        this.mTextEditorWatcher = new TextWatcher() {
            @Override  // android.text.TextWatcher
            public void afterTextChanged(Editable editable0) {
                q.g(editable0, "s");
            }

            @Override  // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                q.g(charSequence0, "s");
            }

            @Override  // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                q.g(charSequence0, "s");
                TextView textView0 = PresentSendFragment.this.getMCountView();
                if(textView0 != null) {
                    textView0.setText(String.valueOf(charSequence0.length()));
                }
            }
        };
        this.mOnChangedListener = new OnListViewChangedListener() {
            @Override  // com.iloen.melon.fragments.present.PresentSendFragment$OnListViewChangedListener
            public void onDataChanged() {
                if(PresentSendFragment.this.mAdapter != null) {
                    int v = PresentSendFragment.this.getPresentCount();
                    String s = PresentSendFragment.this.getTAG();
                    Y.t("onDataChanged() count : ", v, LogU.Companion, s);
                    if(v == 0) {
                        PresentSendFragment.this.setMIsCloseConfirm(true);
                        View view0 = PresentSendFragment.this.getMPresentEmptyView();
                        if(view0 != null) {
                            view0.setVisibility(0);
                        }
                    }
                }
            }
        };
    }

    public static final int access$getVIEW_TYPE_DESCRIPTION$cp() [...] // 潜在的解密器

    public static final int access$getVIEW_TYPE_HEADER$cp() [...] // 潜在的解密器

    public static final int access$getVIEW_TYPE_ITEM$cp() [...] // 潜在的解密器

    public static final int access$getVIEW_TYPE_MESSAGE$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        ToolBar toolBar0 = ToolBar.f(((ToolBar)view0), 505);
        q.f(toolBar0, "initLayoutType(...)");
        return toolBar0;
    }

    private final boolean checkValidFields() {
        boolean z = ViewUtils.hasStringEditText(this.mMessageView);
        com.melon.ui.popup.b b0 = com.melon.ui.popup.b.a;
        if(!z) {
            com.melon.ui.popup.b.d(b0, this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F13078D), false, false, false, null, null, null, null, null, 2040);  // string:alert_dlg_title_info "안내"
            return false;
        }
        if(this.mToSendersView != null && this.mToSendersView.a.isEmpty()) {
            com.melon.ui.popup.b.d(b0, this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F130882), false, false, false, null, null, null, null, null, 2040);  // string:alert_dlg_title_info "안내"
            return false;
        }
        if(this.mAdapter != null && this.getPresentCount() < 1) {
            com.melon.ui.popup.b.d(b0, this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F130881), false, false, false, null, null, null, null, null, 2040);  // string:alert_dlg_title_info "안내"
            return false;
        }
        return true;
    }

    private final boolean checkValidMaxRecipientsCount() {
        if((this.mToSendersView == null ? 0 : this.mToSendersView.getCount()) >= this.getMaxReceiverCount()) {
            ToastManager.show(this.getString(0x7F1300DE, new Object[]{this.getMaxReceiverCount()}));  // string:alert_max_msg_user_count "한번에 최대 %d명에게만 보낼 수 있습니다."
            return false;
        }
        return true;
    }

    private final void createListFooter() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D05BB, null, false);  // layout:present_send_footer
        q.f(view0, "inflate(...)");
        this.setMMessageContainer(view0);
        EditText editText0 = (EditText)this.getMMessageContainer().findViewById(0x7F0A07FB);  // id:message
        this.mMessageView = editText0;
        if(editText0 != null) {
            editText0.addTextChangedListener(this.mTextEditorWatcher);
        }
        TextView textView0 = (TextView)this.getMMessageContainer().findViewById(0x7F0A0B54);  // id:text_count
        this.mCountView = textView0;
        if(textView0 != null) {
            textView0.setText("0");
        }
        View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D05BA, null, false);  // layout:present_send_description_footer
        q.f(view1, "inflate(...)");
        this.setMDescriptionContainer(view1);
    }

    private final void createListHeader() {
        int v = 0;
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D05BC, null, false);  // layout:present_send_header
        ToReceiverViewForPresent toReceiverViewForPresent0 = (ToReceiverViewForPresent)view0.findViewById(0x7F0A0A64);  // id:sender_list
        this.mToSendersView = toReceiverViewForPresent0;
        if(toReceiverViewForPresent0 != null) {
            toReceiverViewForPresent0.setMaxCount(this.getMaxReceiverCount());
        }
        ToReceiverViewForPresent toReceiverViewForPresent1 = this.mToSendersView;
        if(toReceiverViewForPresent1 != null) {
            toReceiverViewForPresent1.setHintText(this.getString(0x7F13087D, new Object[]{this.getMaxReceiverCount()}));  // string:present_send_add_hint_text "최대 %1$d명까지 선물을 보낼 수 있습니다."
        }
        ToReceiverViewForPresent toReceiverViewForPresent2 = this.mToSendersView;
        if(toReceiverViewForPresent2 != null) {
            ArrayList arrayList0 = this.mReceiverList;
            if(arrayList0 != null) {
                for(Object object0: arrayList0) {
                    toReceiverViewForPresent2.a(((Receiver)object0));
                }
            }
        }
        ToReceiverViewForPresent toReceiverViewForPresent3 = this.mToSendersView;
        if(toReceiverViewForPresent3 != null) {
            toReceiverViewForPresent3.setOnAddDeleteClickListener(new k1() {
                @Override  // com.iloen.melon.custom.k1
                public void onAddReceiver(View view0) {
                    q.g(view0, "v");
                    String s = PresentSendFragment.this.getTAG();
                    ToReceiverViewForPresent toReceiverViewForPresent0 = PresentSendFragment.this.getMToSendersView();
                    Integer integer0 = toReceiverViewForPresent0 == null ? null : toReceiverViewForPresent0.getCount();
                    LogU.Companion.d(s, "Send User Count : " + integer0);
                    ToReceiverViewForPresent toReceiverViewForPresent1 = PresentSendFragment.this.getMToSendersView();
                    if(toReceiverViewForPresent1 != null && toReceiverViewForPresent1.a.size() >= toReceiverViewForPresent1.e) {
                        l0 l00 = PresentSendFragment.this.getChildFragmentManager();
                        String s1 = PresentSendFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                        Object[] arr_object = {PresentSendFragment.this.getMaxReceiverCount()};
                        String s2 = PresentSendFragment.this.getString(0x7F1300E2, arr_object);  // string:alert_max_present_user_count "한번에 최대 %d명에게만 선물 가능합니다."
                        com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, s1, s2, false, false, false, null, null, null, null, null, 2040);
                    }
                }

                @Override  // com.iloen.melon.custom.k1
                public void onContentReceiver(View view0, Receiver toReceiverView$Receiver0) {
                    q.g(view0, "v");
                    q.g(toReceiverView$Receiver0, "sender");
                }

                @Override  // com.iloen.melon.custom.k1
                public void onDeleteReceiver(View view0) {
                    q.g(view0, "v");
                    com.melon.ui.popup.b.x(PresentSendFragment.this.getChildFragmentManager(), PresentSendFragment.this.getString(0x7F1300D0), PresentSendFragment.this.getString(0x7F130880), false, false, null, null, new N(13, PresentSendFragment.this, view0), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
                }

                private static final H onDeleteReceiver$lambda$0(PresentSendFragment presentSendFragment0, View view0) {
                    ToReceiverViewForPresent toReceiverViewForPresent0 = presentSendFragment0.getMToSendersView();
                    if(toReceiverViewForPresent0 != null) {
                        FlowLayout flowLayout0 = toReceiverViewForPresent0.b;
                        if(flowLayout0 != null) {
                            flowLayout0.removeView(view0);
                            if(toReceiverViewForPresent0.b.getChildCount() == 0) {
                                TextView textView0 = toReceiverViewForPresent0.c;
                                if(textView0 != null) {
                                    ViewUtils.showWhen(textView0, true);
                                }
                                ViewUtils.showWhen(toReceiverViewForPresent0.b, false);
                            }
                        }
                        Receiver toReceiverView$Receiver0 = (Receiver)view0.getTag();
                        toReceiverViewForPresent0.a.remove(toReceiverView$Receiver0);
                    }
                    return H.a;
                }
            });
        }
        ViewUtils.setOnClickListener(view0.findViewById(0x7F0A01B0), new c(this, 0));  // id:btn_send_recently
        View view1 = view0.findViewById(0x7F0A0151);  // id:btn_contact
        q.f(view1, "findViewById(...)");
        View view2 = view0.findViewById(0x7F0A0152);  // id:btn_contact_view
        q.f(view2, "findViewById(...)");
        ViewUtils.hideWhen(view1, this.isSongPresent());
        ViewUtils.hideWhen(view2, this.isSongPresent());
        ViewUtils.setOnClickListener(view1, new c(this, 1));
        View view3 = view0.findViewById(0x7F0A0164);  // id:btn_friend_list
        q.f(view3, "findViewById(...)");
        ViewUtils.setOnClickListener(view3, new c(this, 2));
        View view4 = view0.findViewById(0x7F0A01A6);  // id:btn_search
        q.f(view4, "findViewById(...)");
        ViewUtils.setOnClickListener(view4, new c(this, 3));
        if(TextUtils.isEmpty(this.mProdId)) {
            View view5 = view0.findViewById(0x7F0A013B);  // id:btn_add
            q.f(view5, "findViewById(...)");
            view5.setVisibility(0);
            ViewUtils.setOnClickListener(view5, new c(this, 4));
        }
        this.mPresentEmptyView = view0.findViewById(0x7F0A095F);  // id:present_empty_text
        if(TextUtils.isEmpty(this.mProdId)) {
            ArrayList arrayList1 = this.presentDataList;
            if(arrayList1 != null) {
                v = arrayList1.size();
            }
            if(v > 0) {
                goto label_46;
            }
        }
        else {
        label_46:
            View view6 = this.mPresentEmptyView;
            if(view6 != null) {
                view6.setVisibility(8);
            }
        }
        this.setMHeaderView(view0);
    }

    private static final void createListHeader$lambda$15(PresentSendFragment presentSendFragment0, View view0) {
        if(!presentSendFragment0.checkValidMaxRecipientsCount() || presentSendFragment0.getActivity() == null) {
            return;
        }
        Intent intent0 = new Intent(presentSendFragment0.getActivity(), PresentSendedHistoryAddActivity.class);
        intent0.putParcelableArrayListExtra("argAddedFriendList", (presentSendFragment0.mToSendersView == null ? null : presentSendFragment0.mToSendersView.getList()));
        intent0.putExtra("argMaxResultCount", presentSendFragment0.getMaxReceiverCount());
        presentSendFragment0.searchFriendActivityResult.b(intent0);
    }

    private static final void createListHeader$lambda$16(PresentSendFragment presentSendFragment0, View view0) {
        if(!presentSendFragment0.checkValidMaxRecipientsCount()) {
            return;
        }
        Intent intent0 = ContactAccessor.getInstance().getPickContactIntent();
        presentSendFragment0.pickContactActivityResult.b(intent0);
    }

    private static final void createListHeader$lambda$17(PresentSendFragment presentSendFragment0, View view0) {
        if(!presentSendFragment0.checkValidMaxRecipientsCount() || presentSendFragment0.getActivity() == null) {
            return;
        }
        q.f("친구 선택하기", "getString(...)");
        Intent intent0 = new Intent(presentSendFragment0.getActivity(), FriendSelectActivity.class);
        intent0.putExtra("argTabTitleName", "친구 선택하기");
        intent0.putExtra("argAddedFriendList", (presentSendFragment0.mToSendersView == null ? null : presentSendFragment0.mToSendersView.getList()));
        intent0.putExtra("argMaxResultCount", presentSendFragment0.getMaxReceiverCount());
        intent0.putExtra("argPresentToContactsOfFriend", true);
        intent0.putExtra("argIsOpenFriendList", true);
        intent0.putExtra("argWhereRUFrom", 1);
        presentSendFragment0.searchFriendActivityResult.b(intent0);
    }

    private static final void createListHeader$lambda$18(PresentSendFragment presentSendFragment0, View view0) {
        if(!presentSendFragment0.checkValidMaxRecipientsCount() || presentSendFragment0.getActivity() == null) {
            return;
        }
        q.f("친구 선택하기", "getString(...)");
        Intent intent0 = new Intent(presentSendFragment0.getActivity(), FriendSelectActivity.class);
        intent0.putExtra("argTabTitleName", "친구 선택하기");
        intent0.putExtra("argAddedFriendList", (presentSendFragment0.mToSendersView == null ? null : presentSendFragment0.mToSendersView.getList()));
        intent0.putExtra("argMaxResultCount", presentSendFragment0.getMaxReceiverCount());
        intent0.putExtra("argPresentToContactsOfFriend", true);
        intent0.putExtra("argIsOpenFriendList", false);
        intent0.putExtra("argWhereRUFrom", 1);
        presentSendFragment0.searchFriendActivityResult.b(intent0);
    }

    private static final void createListHeader$lambda$19(PresentSendFragment presentSendFragment0, View view0) {
        int v = 0;
        if((presentSendFragment0.presentDataList == null ? 0 : presentSendFragment0.presentDataList.size()) >= 50) {
            Context context0 = presentSendFragment0.getContext();
            ToastManager.show((context0 == null || context0.getResources() == null ? null : "최대 50곡까지만 선물 가능합니다."));
            return;
        }
        ArrayList arrayList0 = presentSendFragment0.presentDataList;
        if(arrayList0 != null) {
            v = arrayList0.size();
        }
        presentSendFragment0.openPresentSongSearchPage(50 - v);
    }

    private final Activity getAttachedActivity() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            Activity activity0 = fragmentActivity0.getParent();
            if(activity0 != null) {
                return activity0;
            }
        }
        return this.getActivity();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public f1 getInsetHandlingType() {
        return f1.c;
    }

    public int getMAX_RECEIVER_COUNT() {
        return this.MAX_RECEIVER_COUNT;
    }

    @Nullable
    public final TextView getMCountView() {
        return this.mCountView;
    }

    @NotNull
    public final View getMDescriptionContainer() {
        View view0 = this.mDescriptionContainer;
        if(view0 != null) {
            return view0;
        }
        q.m("mDescriptionContainer");
        throw null;
    }

    @Nullable
    public final String getMEventAuthKey() {
        return this.mEventAuthKey;
    }

    @NotNull
    public final View getMHeaderView() {
        View view0 = this.mHeaderView;
        if(view0 != null) {
            return view0;
        }
        q.m("mHeaderView");
        throw null;
    }

    public final boolean getMIsCloseConfirm() {
        return this.mIsCloseConfirm;
    }

    @NotNull
    public final View getMMessageContainer() {
        View view0 = this.mMessageContainer;
        if(view0 != null) {
            return view0;
        }
        q.m("mMessageContainer");
        throw null;
    }

    @Nullable
    public final EditText getMMessageView() {
        return this.mMessageView;
    }

    @Nullable
    public final OnListViewChangedListener getMOnChangedListener() {
        return this.mOnChangedListener;
    }

    @Nullable
    public final View getMPresentEmptyView() {
        return this.mPresentEmptyView;
    }

    @Nullable
    public final String getMProdId() {
        return this.mProdId;
    }

    @Nullable
    public final ArrayList getMReceiverList() {
        return this.mReceiverList;
    }

    @Nullable
    public final ToReceiverViewForPresent getMToSendersView() {
        return this.mToSendersView;
    }

    public int getMaxReceiverCount() {
        return this.getMAX_RECEIVER_COUNT();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public String getMenuId() {
        String s = this.mMenuId;
        q.f(s, "mMenuId");
        return s;
    }

    public int getPresentCount() {
        return this.mAdapter == null ? 0 : this.mAdapter.getItemCount();
    }

    @Nullable
    public final ArrayList getPresentDataList() {
        return this.presentDataList;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "mymusicGiftBox");
    }

    @NotNull
    public String getTAG() {
        return this.TAG;
    }

    public boolean isSongPresent() {
        return this.isSongPresent;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        String s = this.getTAG();
        l1.B("onBackPressed() : ", this.mIsCloseConfirm, LogU.Companion, s);
        if(this.mIsCloseConfirm) {
            if(this.mMessageView != null) {
                InputMethodUtils.hideInputMethod(this.getContext(), this.mMessageView);
            }
            return false;
        }
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
            com.melon.ui.popup.b.x(this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F13091C), false, false, null, null, new N(12, this, fragmentActivity0), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
        }
        return true;
    }

    private static final H onBackPressed$lambda$14(PresentSendFragment presentSendFragment0, FragmentActivity fragmentActivity0) {
        presentSendFragment0.mIsCloseConfirm = true;
        fragmentActivity0.getOnBackPressedDispatcher().c();
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            this.mMenuId = bundle0.getString("menuId");
            this.mReceiverList = bundle0.getParcelableArrayList("presentReceiverList");
            ArrayList arrayList0 = bundle0.getParcelableArrayList("presentDataList");
            this.presentDataList = arrayList0;
            if(arrayList0 == null) {
                this.presentDataList = new ArrayList();
            }
            this.mProdId = bundle0.getString("presentProductId");
            this.mEventAuthKey = bundle0.getString("presentEventEnterAuthKey");
        }
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D05B9, viewGroup0, false);  // layout:present_send
        q.f(view0, "inflate(...)");
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onPause() {
        super.onPause();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("menuId", this.mMenuId);
        bundle0.putParcelableArrayList("presentReceiverList", this.mReceiverList);
        bundle0.putParcelableArrayList("presentDataList", this.presentDataList);
        bundle0.putString("presentProductId", this.mProdId);
        bundle0.putString("presentEventEnterAuthKey", this.mEventAuthKey);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@NotNull ToolBarItem toolBar$ToolBarItem0, int v) {
        q.g(toolBar$ToolBarItem0, "item");
        if(14 == v && this.checkValidFields()) {
            this.sendPresent();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            p p0 = new p(1);
            p0.c = new a(1, this, titleBar0);
            m m0 = new m(2, false);
            m0.g(p0);
            titleBar0.a(m0);
            titleBar0.setTitle((this.getActivity() == null ? null : "선물하기"));
            titleBar0.f(true);
        }
        this.showToolBar();
        this.createListHeader();
        this.createListFooter();
        this.mEmptyView = null;
        View view1 = this.mRootView;
        if(view1 != null) {
            view1.requestFocus();
        }
    }

    private static final void onViewCreated$lambda$12$lambda$11(PresentSendFragment presentSendFragment0, TitleBar titleBar0, View view0) {
        EditText editText0 = presentSendFragment0.mMessageView;
        if(editText0 != null) {
            InputMethodUtils.hideInputMethod(titleBar0.getContext(), editText0);
        }
        presentSendFragment0.performBackPress();
    }

    public void openPresentSongSearchPage(int v) {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        Intent intent0 = new Intent(this.getActivity(), SearchAndAddActivity.class);
        intent0.addFlags(0x4000000);
        intent0.putExtra("argSearchViewType", 3);
        intent0.putExtra("argCallerType", 11);
        intent0.putExtra("argMaxContentCount", v);
        this.searchSongActivityResult.b(intent0);
    }

    private static final void pickContactActivityResult$lambda$3(PresentSendFragment presentSendFragment0, ActivityResult activityResult0) {
        q.g(activityResult0, "result");
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                Uri uri0 = intent0.getData();
                FragmentActivity fragmentActivity0 = presentSendFragment0.getActivity();
                q.e(fragmentActivity0, "null cannot be cast to non-null type android.app.Activity");
                ContactInfo contactInfo0 = ContactAccessor.getInstance().loadContact(fragmentActivity0.getContentResolver(), uri0);
                q.f(contactInfo0, "loadContact(...)");
                Receiver toReceiverView$Receiver0 = new Receiver();  // 初始化器: Ljava/lang/Object;-><init>()V
                toReceiverView$Receiver0.a = null;
                toReceiverView$Receiver0.b = null;
                toReceiverView$Receiver0.c = contactInfo0.getDisplayName();
                toReceiverView$Receiver0.d = null;
                toReceiverView$Receiver0.e = null;
                String s = contactInfo0.getPhoneNumber();
                toReceiverView$Receiver0.b = s == null || !s.contains("-") ? contactInfo0.getPhoneNumber() : s.replaceAll("-", "");
                ToReceiverViewForPresent toReceiverViewForPresent0 = presentSendFragment0.mToSendersView;
                if(toReceiverViewForPresent0 != null) {
                    ArrayList arrayList0 = toReceiverViewForPresent0.getList();
                    if(arrayList0 != null && arrayList0.contains(toReceiverView$Receiver0)) {
                        ToastManager.show(presentSendFragment0.getString(0x7F131066));  // string:toast_have_already_added_friend "이미 추가된 친구 입니다."
                        return;
                    }
                    ToReceiverViewForPresent toReceiverViewForPresent1 = presentSendFragment0.mToSendersView;
                    if(toReceiverViewForPresent1 != null) {
                        toReceiverViewForPresent1.a(toReceiverView$Receiver0);
                    }
                }
            }
        }
    }

    private static final void searchFriendActivityResult$lambda$1(PresentSendFragment presentSendFragment0, ActivityResult activityResult0) {
        q.g(activityResult0, "result");
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                ArrayList arrayList0 = intent0.getParcelableArrayListExtra("argSearchResultValues");
                if(arrayList0 != null) {
                    presentSendFragment0.mReceiverList = arrayList0;
                    ToReceiverViewForPresent toReceiverViewForPresent0 = presentSendFragment0.mToSendersView;
                    if(toReceiverViewForPresent0 != null) {
                        for(Object object0: arrayList0) {
                            toReceiverViewForPresent0.a(((Receiver)object0));
                        }
                    }
                }
            }
        }
    }

    // This method was un-flattened
    private static final void searchSongActivityResult$lambda$7(PresentSendFragment presentSendFragment0, ActivityResult activityResult0) {
        q.g(activityResult0, "result");
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                ArrayList arrayList0 = intent0.getParcelableArrayListExtra("argSearchResultValues");
                boolean z = true;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    int v = 0;
                    Iterator iterator0 = arrayList0.iterator();
                label_9:
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        Playable playable0 = (Playable)object0;
                        ArrayList arrayList1 = presentSendFragment0.presentDataList;
                        if(arrayList1 != null) {
                            Iterator iterator1 = arrayList1.iterator();
                            q.f(iterator1, "iterator(...)");
                            while(iterator1.hasNext()) {
                                Object object1 = iterator1.next();
                                q.f(object1, "next(...)");
                                int v1 = playable0.getSongid();
                                String s = ((PresentData)object1).getSongId();
                                q.g(s, "<this>");
                                try {
                                    int v2 = 0;
                                    v2 = Integer.parseInt(s);
                                }
                                catch(NumberFormatException unused_ex) {
                                }
                                if(v1 == v2) {
                                    ++v;
                                    continue label_9;
                                }
                                if(false) {
                                    break;
                                }
                            }
                        }
                        ArrayList arrayList2 = presentSendFragment0.presentDataList;
                        if(arrayList2 != null) {
                            arrayList2.add(PresentSongSendFragmentKt.toPresentData(playable0));
                        }
                    }
                    if(arrayList0.size() == v) {
                        l0 l00 = presentSendFragment0.getChildFragmentManager();
                        String s1 = presentSendFragment0.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                        String s2 = presentSendFragment0.getString(0x7F130883);  // string:present_send_exist_song "이미 추가된 곡 입니다."
                        com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, s1, s2, false, false, false, null, null, null, null, null, 2040);
                    }
                }
                View view0 = presentSendFragment0.mPresentEmptyView;
                if(presentSendFragment0.presentDataList != null && !presentSendFragment0.presentDataList.isEmpty()) {
                    z = false;
                }
                ViewUtils.showWhen(view0, z);
                presentSendFragment0.startFetch();
            }
        }
    }

    public abstract void sendMessage();

    private final void sendPresent() {
        Editable editable0 = this.mMessageView == null ? null : this.mMessageView.getText();
        this.showProgress(true);
        RequestBuilder.newInstance(new GiftProhibitedWordsCheckReq(this.getContext(), String.valueOf(editable0))).tag(this.getTAG()).listener(new com.iloen.melon.fragments.present.b(this, 3)).errorListener(new com.iloen.melon.fragments.present.b(this, 4)).request();
    }

    private static final void sendPresent$lambda$20(PresentSendFragment presentSendFragment0, GiftProhibitedWordsCheckRes giftProhibitedWordsCheckRes0) {
        if(presentSendFragment0.isFragmentValid() && giftProhibitedWordsCheckRes0 != null && giftProhibitedWordsCheckRes0.isSuccessful()) {
            presentSendFragment0.sendMessage();
        }
        presentSendFragment0.showProgress(false);
    }

    private static final void sendPresent$lambda$21(PresentSendFragment presentSendFragment0, VolleyError volleyError0) {
        presentSendFragment0.showProgress(false);
    }

    public final void setMCountView(@Nullable TextView textView0) {
        this.mCountView = textView0;
    }

    public final void setMDescriptionContainer(@NotNull View view0) {
        q.g(view0, "<set-?>");
        this.mDescriptionContainer = view0;
    }

    public final void setMEventAuthKey(@Nullable String s) {
        this.mEventAuthKey = s;
    }

    public final void setMHeaderView(@NotNull View view0) {
        q.g(view0, "<set-?>");
        this.mHeaderView = view0;
    }

    public final void setMIsCloseConfirm(boolean z) {
        this.mIsCloseConfirm = z;
    }

    public final void setMMessageContainer(@NotNull View view0) {
        q.g(view0, "<set-?>");
        this.mMessageContainer = view0;
    }

    public final void setMMessageView(@Nullable EditText editText0) {
        this.mMessageView = editText0;
    }

    public final void setMPresentEmptyView(@Nullable View view0) {
        this.mPresentEmptyView = view0;
    }

    public final void setMProdId(@Nullable String s) {
        this.mProdId = s;
    }

    public final void setMReceiverList(@Nullable ArrayList arrayList0) {
        this.mReceiverList = arrayList0;
    }

    public final void setMToSendersView(@Nullable ToReceiverViewForPresent toReceiverViewForPresent0) {
        this.mToSendersView = toReceiverViewForPresent0;
    }

    public final void setPresentDataList(@Nullable ArrayList arrayList0) {
        this.presentDataList = arrayList0;
    }

    public void setSongPresent(boolean z) {
        this.isSongPresent = z;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void updateToolBar(boolean z) {
        super.updateToolBar(true);
    }
}

