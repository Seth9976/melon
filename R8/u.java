package R8;

import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.drm.AbsDcfController;
import com.iloen.melon.drm.DcfError;
import com.iloen.melon.drm.DcfExtendResult;
import com.iloen.melon.drm.DcfFile;
import com.iloen.melon.eventbus.EventAudioSync.Finish;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.v4x.response.DcfExtensionExpireDateRes.Response.AcceptList;
import com.iloen.melon.net.v4x.response.DcfExtensionExpireDateRes.Response.HeaderList;
import com.iloen.melon.net.v4x.response.DcfExtensionExpireDateRes.Response.RejectList;
import com.iloen.melon.net.v4x.response.DcfExtensionExpireDateRes.Response;
import com.iloen.melon.net.v4x.response.DcfExtensionExpireDateRes;
import com.iloen.melon.playback.TaskUpdateLocalPlaylists;
import com.iloen.melon.task.TaskState;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import x8.g;

public abstract class u {
    public static ArrayList a(List list0, y y0) {
        if(list0.size() >= 50) {
            ArrayList arrayList0 = new ArrayList();
            LinkedList linkedList0 = new LinkedList();
            for(Object object0: list0) {
                linkedList0.addLast(((DcfFile)object0));
                if(linkedList0.size() >= 50) {
                    arrayList0.addAll(u.b(linkedList0));
                    linkedList0.clear();
                    if(y0 != null) {
                        EventBusHelper.post(new g(y0, TaskState.getRunningState(arrayList0.size(), null)));
                    }
                }
            }
            if(!linkedList0.isEmpty()) {
                arrayList0.addAll(u.b(linkedList0));
                if(y0 != null) {
                    EventBusHelper.post(new g(y0, TaskState.getRunningState(arrayList0.size(), null)));
                }
            }
            return arrayList0;
        }
        ArrayList arrayList1 = u.b(list0);
        if(y0 != null) {
            EventBusHelper.post(new g(y0, TaskState.getRunningState(arrayList1.size(), null)));
        }
        return arrayList1;
    }

    public static ArrayList b(List list0) {
        IndexOutOfBoundsException indexOutOfBoundsException1;
        AcceptList dcfExtensionExpireDateRes$Response$AcceptList0;
        HashMap hashMap0 = new HashMap();
        for(Object object0: list0) {
            hashMap0.put(((DcfFile)object0), DcfError.d);
        }
        try {
            AbsDcfController absDcfController0 = m.a(MelonAppBase.instance.getContext(), m.a);
            if(absDcfController0 == null) {
                LogU.w("DrmService", "extendDueDateReal() invalid dcfController");
            }
            else {
                try {
                    DcfExtensionExpireDateRes dcfExtensionExpireDateRes0 = AbsDcfController.b(list0);
                    if(dcfExtensionExpireDateRes0 != null) {
                        if(dcfExtensionExpireDateRes0.isSuccessful()) {
                            Response dcfExtensionExpireDateRes$Response0 = dcfExtensionExpireDateRes0.response;
                            ArrayList arrayList0 = dcfExtensionExpireDateRes$Response0.acceptList;
                            ArrayList arrayList1 = dcfExtensionExpireDateRes$Response0.headerList;
                            if(arrayList0 != null) {
                                int v1 = arrayList0.size();
                                int v2 = 0;
                                while(v2 < v1) {
                                    try {
                                        dcfExtensionExpireDateRes$Response$AcceptList0 = null;
                                        dcfExtensionExpireDateRes$Response$AcceptList0 = (AcceptList)arrayList0.get(v2);
                                    }
                                    catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                                        indexOutOfBoundsException1 = indexOutOfBoundsException0;
                                        goto label_37;
                                    }
                                    try {
                                        LogU.i("DrmService", "extendDueDateReal() accept(" + v2 + ") : " + dcfExtensionExpireDateRes$Response$AcceptList0);
                                        goto label_38;
                                    }
                                    catch(IndexOutOfBoundsException indexOutOfBoundsException1) {
                                    }
                                label_37:
                                    LogU.e("DrmService", indexOutOfBoundsException1.toString());
                                label_38:
                                    for(Object object2: list0) {
                                        DcfFile dcfFile0 = (DcfFile)object2;
                                        if(dcfExtensionExpireDateRes$Response$AcceptList0 != null && TextUtils.equals(dcfFile0.a, dcfExtensionExpireDateRes$Response$AcceptList0.lcode)) {
                                            DcfExtendResult dcfExtendResult0 = absDcfController0.h(dcfFile0, ((HeaderList)arrayList1.get(v2)).usage);
                                            hashMap0.put(dcfExtendResult0.a, dcfExtendResult0.b);
                                            break;
                                        }
                                        if(false) {
                                            break;
                                        }
                                    }
                                    ++v2;
                                }
                            }
                            ArrayList arrayList2 = dcfExtensionExpireDateRes$Response0.rejectList;
                            if(arrayList2 != null) {
                                for(Object object3: arrayList2) {
                                    RejectList dcfExtensionExpireDateRes$Response$RejectList0 = (RejectList)object3;
                                    LogU.w("DrmService", "extendDueDateReal() reject: " + dcfExtensionExpireDateRes$Response$RejectList0);
                                    for(Object object4: list0) {
                                        DcfFile dcfFile1 = (DcfFile)object4;
                                        if(TextUtils.equals(dcfFile1.a, dcfExtensionExpireDateRes$Response$RejectList0.lcode)) {
                                            hashMap0.put(dcfFile1, new DcfError(dcfExtensionExpireDateRes$Response$RejectList0));
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            Notification httpResponse$Notification0 = dcfExtensionExpireDateRes0.notification;
                            for(Object object1: list0) {
                                DcfError dcfError0 = new DcfError((httpResponse$Notification0 == null ? "" : httpResponse$Notification0.message));  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
                                dcfError0.a = -1;
                                hashMap0.put(((DcfFile)object1), dcfError0);
                            }
                        }
                    }
                }
                catch(VolleyError volleyError0) {
                    LogU.e("DrmService", volleyError0.toString());
                    for(Object object5: list0) {
                        hashMap0.put(((DcfFile)object5), new DcfError(volleyError0));
                    }
                }
            }
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for(Object object6: hashMap0.keySet()) {
                arrayList3.add(new DcfExtendResult(((DcfFile)object6), ((DcfError)hashMap0.get(((DcfFile)object6)))));
                arrayList4.add(((DcfFile)object6));
            }
            EventBusHelper.post(new Finish(3, arrayList3.size()));
            LogU.d("DrmService", "extendDueDateReal() finished");
            new s(arrayList4).start();
            new TaskUpdateLocalPlaylists().updateFromDcfExtendResultAsync(arrayList3);
            return arrayList3;
        }
        finally {
            m.b(MelonAppBase.instance.getContext());
        }
    }
}

