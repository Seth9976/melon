package com.iloen.melon.utils.player;

import Hb.k;
import Ma.l;
import R6.c;
import R8.m;
import R8.y;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.fragment.app.l0;
import androidx.fragment.app.w;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.constants.CType;
import com.iloen.melon.drm.CollectionRulesDcf;
import com.iloen.melon.fragments.DcfExtensionNeededBrowserFragment;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.net.ServerResponseError;
import com.iloen.melon.net.v4x.request.DeviceInformDeviceCheckReq.CallerType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.DcfLog;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.popup.b;
import e1.u;
import java.util.LinkedList;
import kotlin.coroutines.Continuation;
import sd.j;
import va.e0;
import va.o;
import vd.E;
import vd.e;
import x8.f;

public class DcfUtils {
    static class GetDcfExtendInfoCoroutine extends f {
        public LinkedList a;
        public BaseActivity b;

        public final boolean a(CollectionRulesDcf collectionRulesDcf0) {
            BaseActivity baseActivity0 = this.b;
            if(collectionRulesDcf0.c) {
                b b0 = b.a;
                if(collectionRulesDcf0.d) {
                    if(this.a != null && this.a.size() == 0) {
                        b0.c(baseActivity0.getSupportFragmentManager(), "안내", "연장이 필요한 DCF파일이 없습니다.");
                        return true;
                    }
                    Navigator.open(DcfExtensionNeededBrowserFragment.newInstance());
                    return true;
                }
                if(this.a != null && this.a.size() == 0) {
                    b0.c(baseActivity0.getSupportFragmentManager(), "안내", "연장이 필요한 DCF파일이 없습니다.");
                    return true;
                }
                new y(this.a, CallerType.DCF).execute(null);
                return true;
            }
            return false;
        }

        @Override  // x8.f
        public Object backgroundWork(Object object0, Continuation continuation0) {
            return this.backgroundWork(((Void)object0), continuation0);
        }

        public Object backgroundWork(Void void0, Continuation continuation0) {
            BaseActivity baseActivity0;
            try {
                baseActivity0 = this.b;
                c.g().k("GetDcfExtendInfoCoroutine", new CType[]{CType.SONG, CType.EDU});
                object0 = null;
            }
            catch(Exception object0) {
                Z.v(((Exception)object0), new StringBuilder("GetDcfExtendInfoAsynkTask::processInBackground() "), "DcfUtils");
            }
            try {
                this.a = m.a(baseActivity0, m.a).e();
                return object0;
            }
            finally {
                m.b(baseActivity0);
            }
        }

        public void postTask(Exception exception0) {
            String s;
            BaseActivity baseActivity0;
            try {
                baseActivity0 = this.b;
                s = null;
                l0 l00 = baseActivity0.getSupportFragmentManager();
                if(l00 != null && !l00.T() && !l00.K) {
                    l00.C();
                    w w0 = b.b(l00, "BlockingProgressDialogFragment", null, null, 12);
                    if(w0 != null) {
                        e e0 = w0 instanceof e ? ((e)w0) : null;
                        if(e0 != null) {
                            e0.dismissAllowingStateLoss();
                        }
                    }
                }
            }
            catch(IllegalArgumentException unused_ex) {
            }
            CollectionRulesDcf collectionRulesDcf0 = c.g().d;
            CollectionRulesDcf collectionRulesDcf1 = c.g().e;
            if(collectionRulesDcf0 == null || collectionRulesDcf1 == null) {
                LogU.w("DcfUtils", "GetDcfExtendInfoAsynkTask::onPostExecute() dcf files empty");
            }
            else if(!this.a(collectionRulesDcf0) && !this.a(collectionRulesDcf1)) {
                Resources resources0 = baseActivity0.getResources();
                String s1 = exception0 == null ? "다운로드 서비스 사용 기간이 종료되었거나 사용 중인 이용권이 없습니다." : exception0.getMessage();
                if(exception0 instanceof ServerResponseError) {
                    s = ((ServerResponseError)exception0).getErrorCode();
                }
                boolean z = "2306".equals(s);
                String s2 = TextUtils.isEmpty(s1) ? "다운로드 서비스 사용 기간이 종료되었거나 사용 중인 이용권이 없습니다." : s1;
                String s3 = resources0.getString((z ? 0x7F130227 : 0x7F1302C4));  // string:confirm "확인"
                k k0 = new k(z, 2);
                b.d(b.a, baseActivity0.getSupportFragmentManager(), "안내", s2, true, false, false, s3, E.a, k0, null, null, 0x400);
            }
        }

        @Override  // x8.f
        public void postTask(Object object0) {
            this.postTask(((Exception)object0));
        }
    }

    public static void executeDcfExtension() {
        DcfLog.d("DcfUtils", "---------- DCF_EXTENSION ----------");
        BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
        Context context0 = baseActivity0.getApplicationContext();
        if(NetUtils.showNetworkPopupOrToast(context0, false)) {
            if(!NetUtils.isConnected()) {
                ToastManager.show(0x7F1302AF);  // string:dcf_check_network "네트워크에 연결되어 있지 않아 기간 연장을 진행할 수 없습니다."
                return;
            }
            if(!((e0)o.a()).m()) {
                Intent intent0 = new Intent();
                Q1.c.Y(intent0, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
                intent0.putExtra("alertdialogtype", 5);
                context0.sendBroadcast(intent0);
                return;
            }
            DcfUtils dcfUtils0 = new DcfUtils();
            LogU.d("DcfUtils", "executeDcfExtensionBaseInfo()");
            l0 l00 = baseActivity0.getSupportFragmentManager();
            if(l00 != null && !l00.T() && !l00.K) {
                l00.C();
                if(b.b(l00, "BlockingProgressDialogFragment", null, new j(7), 4) == null) {
                    e e0 = new e();
                    e0.f = null;
                    e0.showNow(l00, "BlockingProgressDialogFragment");
                }
            }
            ((Ba.j)((k8.o)(((l)com.google.firebase.b.B(MelonAppBase.instance.getContext(), l.class)))).K.get()).d(u.v(((e0)o.a()).j())).enqueue(new DcfUtils.2(dcfUtils0, baseActivity0));
        }
    }
}

