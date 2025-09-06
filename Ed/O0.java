package ed;

import com.melon.net.res.SearchMainContentRes.Genre;
import com.melon.net.res.SearchMainContentRes.Response;
import com.melon.net.res.SearchMainContentRes.ThemeOffering;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import we.k;

public abstract class o0 {
    public static ArrayList a(Response searchMainContentRes$Response0, ArrayList arrayList0, k k0) {
        ThemeOffering searchMainContentRes$ThemeOffering2;
        ThemeOffering searchMainContentRes$ThemeOffering1;
        ThemeOffering searchMainContentRes$ThemeOffering0;
        q.g(searchMainContentRes$Response0, "response");
        q.g(arrayList0, "recentGenreList");
        switch("") {
            case "THEME_1": {
                ArrayList arrayList2 = new ArrayList();
                p0 p01 = new p0(k0);
                int v1 = 0;
                for(Object object1: searchMainContentRes$Response0.getGenreList()) {
                    if(v1 >= 0) {
                        boolean z1 = arrayList0.contains("");
                        m0 m01 = new m0();  // 初始化器: Ljava/lang/Object;-><init>()V
                        m01.a = (Genre)object1;
                        m01.b = z1;
                        ArrayList arrayList3 = p01.b;
                        arrayList3.add(m01);
                        switch(arrayList2.size()) {
                            case 1: {
                                if(arrayList3.size() == 2) {
                                    p01.a = 1;
                                    for(Object object2: searchMainContentRes$Response0.getThemeOfferingList()) {
                                        searchMainContentRes$ThemeOffering0 = (ThemeOffering)object2;
                                        if(!q.b("", "2X2")) {
                                            continue;
                                        }
                                        goto label_56;
                                    }
                                    searchMainContentRes$ThemeOffering0 = null;
                                label_56:
                                    p01.c = searchMainContentRes$ThemeOffering0;
                                    p01.a("");
                                    p01.g = 1;
                                    arrayList2.add(p01);
                                    p01 = new p0(k0);
                                }
                                break;
                            }
                            case 3: {
                                if(arrayList3.size() == 1) {
                                    p01.a = 3;
                                    for(Object object3: searchMainContentRes$Response0.getThemeOfferingList()) {
                                        searchMainContentRes$ThemeOffering1 = (ThemeOffering)object3;
                                        if(!q.b("", "1X2")) {
                                            continue;
                                        }
                                        goto label_71;
                                    }
                                    searchMainContentRes$ThemeOffering1 = null;
                                label_71:
                                    p01.c = searchMainContentRes$ThemeOffering1;
                                    p01.a("");
                                    p01.g = 2;
                                    arrayList2.add(p01);
                                    p01 = new p0(k0);
                                }
                                break;
                            }
                            default: {
                                if(arrayList3.size() == 3) {
                                    arrayList2.add(p01);
                                    p01 = new p0(k0);
                                }
                                else if(v1 == searchMainContentRes$Response0.getGenreList().size() - 1) {
                                    arrayList2.add(p01);
                                }
                            }
                        }
                        ++v1;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
                return arrayList2;
            }
            case "THEME_2": {
                ArrayList arrayList4 = new ArrayList();
                p0 p02 = new p0(k0);
                int v2 = 0;
                for(Object object4: searchMainContentRes$Response0.getGenreList()) {
                    if(v2 >= 0) {
                        boolean z2 = arrayList0.contains("");
                        m0 m02 = new m0();  // 初始化器: Ljava/lang/Object;-><init>()V
                        m02.a = (Genre)object4;
                        m02.b = z2;
                        ArrayList arrayList5 = p02.b;
                        arrayList5.add(m02);
                        switch(arrayList4.size()) {
                            case 1: {
                                if(arrayList5.size() == 1) {
                                    p02.a = 2;
                                    for(Object object5: searchMainContentRes$Response0.getThemeOfferingList()) {
                                        searchMainContentRes$ThemeOffering2 = (ThemeOffering)object5;
                                        if(!q.b("", "1X2")) {
                                            continue;
                                        }
                                        goto label_111;
                                    }
                                    searchMainContentRes$ThemeOffering2 = null;
                                label_111:
                                    p02.c = searchMainContentRes$ThemeOffering2;
                                    p02.a("");
                                    p02.g = 1;
                                    arrayList4.add(p02);
                                    p02 = new p0(k0);
                                }
                                break;
                            }
                            case 3: {
                                if(arrayList5.size() == 2) {
                                    ThemeOffering searchMainContentRes$ThemeOffering3 = null;
                                    p02.a = 4;
                                    for(Object object6: searchMainContentRes$Response0.getThemeOfferingList()) {
                                        ThemeOffering searchMainContentRes$ThemeOffering4 = (ThemeOffering)object6;
                                        if(q.b("", "1X1")) {
                                            searchMainContentRes$ThemeOffering3 = searchMainContentRes$ThemeOffering4;
                                            break;
                                        }
                                    }
                                    p02.c = searchMainContentRes$ThemeOffering3;
                                    p02.d = 2;
                                    p02.a("");
                                    p02.g = 2;
                                    arrayList4.add(p02);
                                    p02 = new p0(k0);
                                }
                                break;
                            }
                            default: {
                                if(arrayList5.size() == 3) {
                                    arrayList4.add(p02);
                                    p02 = new p0(k0);
                                }
                                else if(v2 == searchMainContentRes$Response0.getGenreList().size() - 1) {
                                    arrayList4.add(p02);
                                }
                            }
                        }
                        ++v2;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
                return arrayList4;
            }
            case "THEME_3": {
                ArrayList arrayList6 = new ArrayList();
                p0 p03 = new p0(k0);
                int v3 = 0;
                for(Object object7: searchMainContentRes$Response0.getGenreList()) {
                    if(v3 >= 0) {
                        boolean z3 = arrayList0.contains("");
                        m0 m03 = new m0();  // 初始化器: Ljava/lang/Object;-><init>()V
                        m03.a = (Genre)object7;
                        m03.b = z3;
                        ArrayList arrayList7 = p03.b;
                        arrayList7.add(m03);
                        switch(arrayList6.size()) {
                            case 1: {
                                if(arrayList7.size() == 2) {
                                    p03.a = 4;
                                    p03.c = searchMainContentRes$Response0.getThemeOfferingList().size() <= 0 ? null : ((ThemeOffering)searchMainContentRes$Response0.getThemeOfferingList().get(0));
                                    p03.d = 0;
                                    p03.a("");
                                    p03.g = 1;
                                    arrayList6.add(p03);
                                    p03 = new p0(k0);
                                }
                                break;
                            }
                            case 2: {
                                if(arrayList7.size() == 2) {
                                    p03.a = 4;
                                    p03.c = searchMainContentRes$Response0.getThemeOfferingList().size() <= 1 ? null : ((ThemeOffering)searchMainContentRes$Response0.getThemeOfferingList().get(1));
                                    p03.d = 2;
                                    p03.a("");
                                    p03.g = 2;
                                    arrayList6.add(p03);
                                    p03 = new p0(k0);
                                }
                                break;
                            }
                            case 4: {
                                if(arrayList7.size() == 2) {
                                    p03.a = 4;
                                    p03.c = searchMainContentRes$Response0.getThemeOfferingList().size() <= 2 ? null : ((ThemeOffering)searchMainContentRes$Response0.getThemeOfferingList().get(2));
                                    p03.d = 0;
                                    p03.a("");
                                    p03.g = 3;
                                    arrayList6.add(p03);
                                    p03 = new p0(k0);
                                }
                                break;
                            }
                            default: {
                                if(arrayList7.size() == 3) {
                                    arrayList6.add(p03);
                                    p03 = new p0(k0);
                                }
                                else if(v3 == searchMainContentRes$Response0.getGenreList().size() - 1) {
                                    arrayList6.add(p03);
                                }
                            }
                        }
                        ++v3;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
                return arrayList6;
            }
            default: {
                ArrayList arrayList1 = new ArrayList();
                p0 p00 = new p0(k0);
                int v = 0;
                for(Object object0: searchMainContentRes$Response0.getGenreList()) {
                    if(v >= 0) {
                        boolean z = arrayList0.contains("");
                        m0 m00 = new m0();  // 初始化器: Ljava/lang/Object;-><init>()V
                        m00.a = (Genre)object0;
                        m00.b = z;
                        p00.b.add(m00);
                        if(p00.b.size() == 3) {
                            arrayList1.add(p00);
                            p00 = new p0(k0);
                        }
                        else if(v == searchMainContentRes$Response0.getGenreList().size() - 1) {
                            arrayList1.add(p00);
                        }
                        ++v;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
                return arrayList1;
            }
        }
    }
}

