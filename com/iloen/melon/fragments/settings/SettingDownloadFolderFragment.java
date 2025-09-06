package com.iloen.melon.fragments.settings;

import G8.f;
import G8.i;
import G8.k;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.f0;
import androidx.fragment.app.l0;
import com.iloen.melon.eventbus.EventAudioSync.Finish;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import d5.w;
import d8.d;
import e.b;
import e3.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sd.j;
import u9.a;
import va.e;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u000B\u0010\u0003J\u000F\u0010\r\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0003J\u000F\u0010\u0011\u001A\u00020\u0010H\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u001A\u001A\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ!\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001C\u001A\u00020\u00192\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0003J\u0017\u0010\"\u001A\u00020\u00042\u0006\u0010!\u001A\u00020 H\u0007\u00A2\u0006\u0004\b\"\u0010#R\u0014\u0010%\u001A\u00020$8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\'\u001A\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\'\u0010(R\u0018\u0010*\u001A\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001A\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b,\u0010+R\u0018\u0010-\u001A\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b-\u0010(R\u0018\u0010.\u001A\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010+R\u0016\u00100\u001A\u00020/8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u00101R\"\u00104\u001A\u0010\u0012\f\u0012\n 3*\u0004\u0018\u00010\b0\b028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b4\u00105\u00A8\u00067"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingDownloadFolderFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "Lie/H;", "clickSelectOrChangeButton", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "getDocumentTreeIntent", "(Landroid/content/Context;)Landroid/content/Intent;", "updateUI", "Landroid/text/Spanned;", "getTipText", "()Landroid/text/Spanned;", "startMediaScan", "", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "Lcom/iloen/melon/eventbus/EventAudioSync$Finish;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventAudioSync$Finish;)V", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "folderInfoLayout", "Landroid/view/View;", "Landroid/widget/TextView;", "folderNameTextView", "Landroid/widget/TextView;", "folderTextButton", "folderTipLayout", "folderTipDescription", "", "updateTime", "J", "Le/b;", "kotlin.jvm.PlatformType", "activityResult", "Le/b;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingDownloadFolderFragment extends SettingBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0007H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingDownloadFolderFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingDownloadFolderFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingDownloadFolderFragment newInstance() {
            return new SettingDownloadFolderFragment();
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "SettingDownloadFolderFragment";
    @NotNull
    private final b activityResult;
    @Nullable
    private View folderInfoLayout;
    @Nullable
    private TextView folderNameTextView;
    @Nullable
    private TextView folderTextButton;
    @Nullable
    private TextView folderTipDescription;
    @Nullable
    private View folderTipLayout;
    @NotNull
    private final LogU log;
    private long updateTime;

    static {
        SettingDownloadFolderFragment.Companion = new Companion(null);
        SettingDownloadFolderFragment.$stable = 8;
    }

    public SettingDownloadFolderFragment() {
        this.log = new LogU("SettingDownloadFolderFragment");
        b b0 = this.registerForActivityResult(new f0(2), new s(this, 1));
        q.f(b0, "registerForActivityResult(...)");
        this.activityResult = b0;
    }

    private static final void activityResult$lambda$1(SettingDownloadFolderFragment settingDownloadFolderFragment0, ActivityResult activityResult0) {
        boolean z;
        FileOutputStream fileOutputStream0;
        q.g(activityResult0, "result");
        LogU.info$default(settingDownloadFolderFragment0.log, "onActivityResult() resultCode : " + activityResult0.a, null, false, 6, null);
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                Uri uri0 = intent0.getData();
                if(uri0 != null) {
                    h h0 = a.c;
                    h0.o("dcf").d(uri0);
                    if(StorageUtils.getNeedsLocalPlaylistMig()) {
                        h0.o("legacy_db").d(uri0);
                        LogU logU0 = new LogU("LegacyLocalPlaylistMigHelper");
                        logU0.setUseThreadInfo(true);
                        Context context0 = settingDownloadFolderFragment0.requireContext();
                        q.f(context0, "requireContext(...)");
                        i.a.f();
                        if(i.e() > 0) {
                            LogU.Companion.d("LegacyLocalPlaylistMigHelper", "private local playlist already exist");
                        }
                        else {
                            LogU.Companion.d("LegacyLocalPlaylistMigHelper", "private local playlist doesn\'t exist");
                            a a0 = h0.o("legacy_db");
                            if(a0.c()) {
                                r2.a a1 = a0.a();
                                if(a1 != null) {
                                    ArrayList arrayList0 = new ArrayList();
                                    f.c(arrayList0, a1);
                                    File file0 = context0.getDatabasePath("local_playlist_db");
                                    String s = String.valueOf((file0 == null ? null : file0.getParent()));
                                    for(Object object0: arrayList0) {
                                        String s1 = e.c(s, "/", ((r2.a)object0).e());
                                        Uri uri1 = ((r2.a)object0).f();
                                        q.f(uri1, "getUri(...)");
                                        File file1 = context0.getDatabasePath(s1);
                                        InputStream inputStream0 = context0.getContentResolver().openInputStream(uri1);
                                        if(inputStream0 == null) {
                                            z = false;
                                        }
                                        else {
                                            try {
                                                fileOutputStream0 = new FileOutputStream(file1);
                                            }
                                            catch(Throwable throwable0) {
                                                d.l(inputStream0, throwable0);
                                                throw throwable0;
                                            }
                                            try {
                                                try {
                                                    w.t(inputStream0, fileOutputStream0);
                                                    goto label_51;
                                                }
                                                catch(IOException iOException0) {
                                                }
                                                iOException0.printStackTrace();
                                            }
                                            catch(Throwable throwable1) {
                                                goto label_49;
                                            }
                                            try {
                                                fileOutputStream0.close();
                                            }
                                            catch(Throwable throwable0) {
                                                d.l(inputStream0, throwable0);
                                                throw throwable0;
                                            }
                                            inputStream0.close();
                                            z = false;
                                            goto label_60;
                                            try {
                                            label_49:
                                                d.l(fileOutputStream0, throwable1);
                                                throw throwable1;
                                            label_51:
                                                fileOutputStream0.close();
                                            }
                                            catch(Throwable throwable0) {
                                                d.l(inputStream0, throwable0);
                                                throw throwable0;
                                            }
                                            inputStream0.close();
                                            z = true;
                                        }
                                    label_60:
                                        LogU.debug$default(logU0, "result : " + z + " ||| fileName : " + s1, null, false, 6, null);
                                    }
                                }
                            }
                            else {
                                LogU.warn$default(logU0, "migrateLocalPlaylistDb() Check saf storage permission.", null, false, 6, null);
                            }
                        }
                        settingDownloadFolderFragment0.updateTime = System.currentTimeMillis();
                        settingDownloadFolderFragment0.startMediaScan();
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new G8.d(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                }
            }
        }
    }

    private final void clickSelectOrChangeButton() {
        Context context0 = this.getContext();
        if(context0 == null) {
            return;
        }
        Intent intent0 = this.getDocumentTreeIntent(context0);
        this.activityResult.b(intent0);
    }

    private final Intent getDocumentTreeIntent(Context context0) {
        Object object0 = context0.getSystemService("storage");
        q.e(object0, "null cannot be cast to non-null type android.os.storage.StorageManager");
        Intent intent0 = ((StorageManager)object0).getPrimaryStorageVolume().createOpenDocumentTreeIntent();
        q.d(intent0);
        return intent0;
    }

    private final Spanned getTipText() {
        Spanned spanned0 = Html.fromHtml(this.getString((ScreenUtils.isDarkMode(this.getContext()) ? 0x7F130980 : 0x7F13097F)), 0);  // string:setting_download_folder_tip_dark "<font color=\"#00e818\">Tip.</font> <font 
                                                                                                                                     // color=\"#A6A6A6\">기존 다운로드 받은 DCF 파일은 melon 폴더 하위에 저장되어있으며, 파일을 임의로 이동하지 않은 경우 다운로드 
                                                                                                                                     // 폴더 설정을 melon 폴더로 선택하시면 기존 다운로드 받은 DCF 파일 사용이 가능합니다.</font>"
        q.f(spanned0, "fromHtml(...)");
        return spanned0;
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F13097A;  // string:setting_download_folder "다운로드 폴더 설정"
    }

    @NotNull
    public static final SettingDownloadFolderFragment newInstance() {
        return SettingDownloadFolderFragment.Companion.newInstance();
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0829, viewGroup0, false);  // layout:setting_download_folder
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull Finish eventAudioSync$Finish0) {
        q.g(eventAudioSync$Finish0, "event");
        vd.e e0 = null;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new k(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        LogConstantsKt.debug(this.log, "event() EventAudioSync.Finish complete", this.updateTime);
        if(eventAudioSync$Finish0.getType() <= 2) {
            l0 l00 = this.getChildFragmentManager();
            if(l00 != null && !l00.T() && !l00.K) {
                l00.C();
                androidx.fragment.app.w w0 = com.melon.ui.popup.b.b(l00, "BlockingProgressDialogFragment", null, null, 12);
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
    public void onResume() {
        super.onResume();
        LogU.info$default(this.log, "onResume()", null, false, 6, null);
        this.updateUI();
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.folderInfoLayout = view0.findViewById(0x7F0A071C);  // id:layout_folder_info
        this.folderNameTextView = (TextView)view0.findViewById(0x7F0A0C7C);  // id:tv_folder_name
        TextView textView0 = (TextView)view0.findViewById(0x7F0A0A5C);  // id:select_or_change
        ViewUtils.setOnClickListener(textView0, new c(this, 1));
        this.folderTextButton = textView0;
        this.folderTipLayout = view0.findViewById(0x7F0A074C);  // id:layout_tip
        this.folderTipDescription = (TextView)view0.findViewById(0x7F0A0D33);  // id:tv_tip_description
    }

    private static final void onViewCreated$lambda$3$lambda$2(SettingDownloadFolderFragment settingDownloadFolderFragment0, View view0) {
        settingDownloadFolderFragment0.clickSelectOrChangeButton();
    }

    private final void startMediaScan() {
        if(!this.isFragmentValid()) {
            LogU.Companion.w("SettingDownloadFolderFragment", "startMediaScan() invalid fragment");
            return;
        }
        l0 l00 = this.getChildFragmentManager();
        String s = this.getString(0x7F130984);  // string:setting_file_management_update_dialog_msg "파일 목록 업데이트 중입니다.\n잠시만 기다려 주세요."
        if(l00 != null && !l00.T() && !l00.K) {
            l00.C();
            if(com.melon.ui.popup.b.b(l00, "BlockingProgressDialogFragment", null, new j(7), 4) == null) {
                vd.e e0 = new vd.e();
                e0.f = s;
                e0.showNow(l00, "BlockingProgressDialogFragment");
            }
        }
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        I8.e.b(context0, "From locker fragment.", true);
    }

    private final void updateUI() {
        String s;
        LogU.info$default(this.log, "updateUI()", null, false, 6, null);
        a a0 = a.c.o("dcf");
        if(a0.c()) {
            ViewUtils.showWhen(this.folderInfoLayout, true);
            ViewUtils.showWhen(this.folderTipLayout, true);
            TextView textView0 = this.folderNameTextView;
            if(textView0 != null) {
                r2.a a1 = a0.a();
                if(a1 == null) {
                    s = "";
                }
                else {
                    s = a1.e();
                    if(s == null) {
                        s = "";
                    }
                }
                textView0.setText(s);
            }
            TextView textView1 = this.folderTextButton;
            if(textView1 != null) {
                textView1.setText(this.getString(0x7F13097B));  // string:setting_download_folder_change "폴더 변경"
            }
            TextView textView2 = this.folderTipDescription;
            if(textView2 != null) {
                textView2.setText(this.getTipText());
            }
        }
        else {
            ViewUtils.hideWhen(this.folderInfoLayout, true);
            ViewUtils.hideWhen(this.folderTipLayout, true);
            TextView textView3 = this.folderTextButton;
            if(textView3 != null) {
                textView3.setText(this.getString(0x7F13097E));  // string:setting_download_folder_select "폴더 선택"
            }
        }
    }
}

