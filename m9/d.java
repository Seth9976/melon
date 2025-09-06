package m9;

import Ma.g;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.kakao.tiara.data.ActionKind;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import je.p;
import je.w;
import k8.Y;
import k8.o;
import kotlin.jvm.internal.q;
import mb.k;
import p8.b;
import p8.c;
import we.a;

public final class d implements a {
    public final int a;

    public d(int v) {
        this.a = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        List list3;
        List list2;
        List list1;
        List list0;
        Class class0 = g.class;
        switch(this.a) {
            case 0: {
                return ActionKind.PlayVideo;
            }
            case 1: {
                return ActionKind.ClickContent;
            }
            case 2: {
                return ActionKind.ClickContent;
            }
            case 3: {
                return ActionKind.ClickContent;
            }
            case 4: {
                return ActionKind.PlayMusic;
            }
            case 5: {
                return ActionKind.ClickContent;
            }
            case 6: {
                return "1000003099";
            }
            case 7: {
                return ActionKind.Share;
            }
            case 8: {
                return ActionKind.ClickContent;
            }
            case 9: {
                return ActionKind.PlayMusic;
            }
            case 10: {
                return ActionKind.ClickContent;
            }
            case 11: {
                return ActionKind.ClickContent;
            }
            case 12: {
                return ActionKind.ClickContent;
            }
            case 13: {
                return ActionKind.ClickContent;
            }
            case 14: {
                return ActionKind.ClickContent;
            }
            case 15: {
                return ActionKind.ClickContent;
            }
            case 16: {
                return ActionKind.ClickContent;
            }
            case 17: {
                return ActionKind.ClickContent;
            }
            case 18: {
                return ActionKind.ClickContent;
            }
            case 19: {
                return Y.i(ContsTypeCode.DJ_MALRANG, "code(...)");
            }
            case 20: {
                return ActionKind.PlayMusic;
            }
            case 21: {
                return ActionKind.ClickContent;
            }
            case 22: {
                return ActionKind.ClickContent;
            }
            case 23: {
                return ActionKind.Like;
            }
            case 24: {
                return ActionKind.PlayMusic;
            }
            case 25: {
                return DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.of("GMT+09:00"));
            }
            case 26: {
                DateTimeFormatter dateTimeFormatter0 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.of("GMT+09:00"));
                q.f(dateTimeFormatter0, "withZone(...)");
                return dateTimeFormatter0;
            }
            case 27: {
                return (k)((o)(((g)Y.f(MelonAppBase.Companion, class0)))).m.get();
            }
            case 28: {
                LogU.Companion.d("MelonTiaraCodeManager", "commCodeList - lazy init");
                LogU.Companion.d("MelonTiaraCodeManager", "loadTiaraCommCode()");
                HashMap hashMap0 = new HashMap();
                String s = MelonPrefs.getInstance().getString("TIARA_COMMON_CODE_LIST", null);
                if(s != null) {
                    Pattern pattern0 = Pattern.compile("/");
                    q.f(pattern0, "compile(...)");
                    Tf.o.P0(0);
                    Matcher matcher0 = pattern0.matcher(s);
                    if(matcher0.find()) {
                        ArrayList arrayList0 = new ArrayList(10);
                        int v = 0;
                        do {
                            v = androidx.appcompat.app.o.c(matcher0, s, v, arrayList0);
                        }
                        while(matcher0.find());
                        androidx.appcompat.app.o.w(v, s, arrayList0);
                        list0 = arrayList0;
                    }
                    else {
                        list0 = e.k.z(s.toString());
                    }
                    w w0 = w.a;
                    if(!list0.isEmpty()) {
                        ListIterator listIterator0 = list0.listIterator(list0.size());
                        while(listIterator0.hasPrevious()) {
                            if(((String)listIterator0.previous()).length() == 0) {
                                continue;
                            }
                            list1 = p.K0(listIterator0.nextIndex() + 1, list0);
                            goto label_59;
                        }
                    }
                    list1 = w0;
                label_59:
                    String[] arr_s = (String[])list1.toArray(new String[0]);
                    int v1 = 0;
                    while(v1 < arr_s.length) {
                        String s1 = arr_s[v1];
                        Pattern pattern1 = Pattern.compile(",");
                        q.f(pattern1, "compile(...)");
                        q.g(s1, "input");
                        Tf.o.P0(0);
                        Matcher matcher1 = pattern1.matcher(s1);
                        if(matcher1.find()) {
                            ArrayList arrayList1 = new ArrayList(10);
                            int v2 = 0;
                            do {
                                v2 = androidx.appcompat.app.o.c(matcher1, s1, v2, arrayList1);
                            }
                            while(matcher1.find());
                            androidx.appcompat.app.o.w(v2, s1, arrayList1);
                            list2 = arrayList1;
                        }
                        else {
                            list2 = e.k.z(s1.toString());
                        }
                        if(!list2.isEmpty()) {
                            ListIterator listIterator1 = list2.listIterator(list2.size());
                            while(listIterator1.hasPrevious()) {
                                if(((String)listIterator1.previous()).length() == 0) {
                                    continue;
                                }
                                list3 = p.K0(listIterator1.nextIndex() + 1, list2);
                                goto label_84;
                            }
                        }
                        list3 = w0;
                    label_84:
                        String[] arr_s1 = (String[])list3.toArray(new String[0]);
                        if(arr_s1.length > 1) {
                            String s2 = arr_s1[0];
                            String s3 = arr_s1[1];
                            hashMap0.put(s3, new c(s2, s3));
                        }
                        ++v1;
                    }
                }
                if(!hashMap0.isEmpty()) {
                    b.b();
                }
                return hashMap0;
            }
            default: {
                return (k)((o)(((g)Y.f(MelonAppBase.Companion, class0)))).m.get();
            }
        }
    }
}

