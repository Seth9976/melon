package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.f;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzhg;
import com.google.android.gms.internal.measurement.zzhq;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zzpq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jeb.synthetic.TWR;

final class zzad extends zzor {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    public zzad(zzpf zzpf0) {
        super(zzpf0);
    }

    public final List zzb(String s, List list0, List list1, Long long0, Long long1, boolean z) {
        f f8;
        Map map8;
        List list7;
        Integer integer5;
        zzgr zzgr0;
        zzfn zzfn0;
        Cursor cursor7;
        String s6;
        Iterator iterator11;
        Cursor cursor6;
        long v6;
        Iterator iterator9;
        Map map6;
        List list6;
        List list5;
        Integer integer3;
        zzff zzff1;
        Cursor cursor4;
        zzbc zzbc1;
        Cursor cursor3;
        String s4;
        Iterator iterator6;
        zzz zzz1;
        boolean z3;
        Map map4;
        Map map3;
        zzii zzii0;
        f f1;
        Cursor cursor1;
        Map map1;
        List list3;
        zzff zzff0;
        Cursor cursor0;
        Preconditions.checkNotEmpty(s);
        Preconditions.checkNotNull(list0);
        Preconditions.checkNotNull(list1);
        this.zza = s;
        this.zzb = new HashSet();
        this.zzc = new f();
        this.zzd = long0;
        this.zze = long1;
        Iterator iterator0 = list0.iterator();
        while(iterator0.hasNext()) {
            iterator0.next();
        }
        zzpq.zza();
        boolean z1 = this.zzu.zzc().zzp(this.zza, zzfx.zzaF);
        zzpq.zza();
        boolean z2 = this.zzu.zzc().zzp(this.zza, zzfx.zzaE);
        Map map0 = Collections.EMPTY_MAP;
        if(!z2 || !z1) {
        label_56:
            map1 = map0;
        }
        else {
            zzav zzav0 = this.zzg.zzj();
            String s1 = this.zza;
            Preconditions.checkNotEmpty(s1);
            f f0 = new f();
            SQLiteDatabase sQLiteDatabase0 = zzav0.zze();
            try {
                cursor0 = null;
                cursor0 = sQLiteDatabase0.query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{s1}, null, null, null);
                if(cursor0.moveToFirst()) {
                    do {
                        byte[] arr_b = cursor0.getBlob(1);
                        try {
                            zzff0 = (zzff)((zzfe)zzpj.zzw(zzff.zzn(), arr_b)).zzbc();
                        }
                        catch(IOException iOException0) {
                            zzav0.zzu.zzaV().zzb().zzc("Failed to merge filter. appId", zzgt.zzl(s1), iOException0);
                            continue;
                        }
                        if(zzff0.zzg()) {
                            Integer integer0 = cursor0.getInt(0);
                            List list2 = (List)f0.get(integer0);
                            if(list2 == null) {
                                list3 = new ArrayList();
                                f0.put(integer0, list3);
                            }
                            else {
                                list3 = list2;
                            }
                            list3.add(zzff0);
                        }
                    }
                    while(cursor0.moveToNext());
                    goto label_52;
                }
                else {
                    goto label_55;
                }
                goto label_57;
            }
            catch(SQLiteException sQLiteException0) {
                try {
                    zzav0.zzu.zzaV().zzb().zzc("Database error querying filters. appId", zzgt.zzl(s1), sQLiteException0);
                    map0 = Collections.EMPTY_MAP;
                    if(cursor0 != null) {
                        goto label_47;
                    }
                    goto label_56;
                }
                catch(Throwable throwable0) {
                    goto label_50;
                }
            label_47:
                cursor0.close();
                goto label_56;
            }
            catch(Throwable throwable0) {
            label_50:
                TWR.safeClose$NT(cursor0, throwable0);
                throw throwable0;
            }
        label_52:
            cursor0.close();
            map1 = f0;
            goto label_57;
        label_55:
            cursor0.close();
            goto label_56;
        }
    label_57:
        zzav zzav1 = this.zzg.zzj();
        String s2 = this.zza;
        zzav1.zzay();
        zzav1.zzg();
        Preconditions.checkNotEmpty(s2);
        SQLiteDatabase sQLiteDatabase1 = zzav1.zze();
        try {
            cursor1 = null;
            cursor1 = sQLiteDatabase1.query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{s2}, null, null, null);
            goto label_69;
        }
        catch(SQLiteException sQLiteException1) {
            goto label_86;
        }
        catch(Throwable throwable1) {
        }
        Cursor cursor2 = null;
        goto label_94;
        try {
        label_69:
            if(cursor1.moveToFirst()) {
                f1 = new f();
                while(true) {
                    int v = cursor1.getInt(0);
                    byte[] arr_b1 = cursor1.getBlob(1);
                    try {
                        zzii0 = (zzii)((zzih)zzpj.zzw(zzii.zzi(), arr_b1)).zzbc();
                    }
                    catch(IOException iOException1) {
                        zzav1.zzu.zzaV().zzb().zzd("Failed to merge filter results. appId, audienceId, error", zzgt.zzl(s2), v, iOException1);
                        goto label_79;
                    }
                    f1.put(v, zzii0);
                label_79:
                    if(cursor1.moveToNext()) {
                        continue;
                    }
                    goto label_80;
                }
            }
            else {
                goto label_83;
            }
            goto label_99;
        }
        catch(SQLiteException sQLiteException1) {
            goto label_86;
        }
        catch(Throwable throwable1) {
            goto label_93;
        }
    label_80:
        cursor1.close();
        Map map2 = f1;
        goto label_99;
        try {
            try {
            label_83:
                map3 = Collections.EMPTY_MAP;
                goto label_97;
            }
            catch(SQLiteException sQLiteException1) {
            }
        label_86:
            zzav1.zzu.zzaV().zzb().zzc("Database error querying filter results. appId", zzgt.zzl(s2), sQLiteException1);
            map4 = Collections.EMPTY_MAP;
            if(cursor1 != null) {
                goto label_89;
            }
            goto label_90;
        }
        catch(Throwable throwable1) {
            goto label_93;
        }
    label_89:
        cursor1.close();
    label_90:
        map2 = map4;
        goto label_99;
    label_93:
        cursor2 = cursor1;
    label_94:
        if(cursor2 != null) {
            cursor2.close();
        }
        throw throwable1;
    label_97:
        cursor1.close();
        map2 = map3;
    label_99:
        if(!map2.isEmpty()) {
            for(Object object0: new HashSet(map2.keySet())) {
                Integer integer1 = (Integer)object0;
                integer1.getClass();
                zzii zzii1 = (zzii)map2.get(integer1);
                BitSet bitSet0 = new BitSet();
                BitSet bitSet1 = new BitSet();
                f f2 = new f();
                if(zzii1 != null && zzii1.zzf() != 0) {
                    for(Object object1: zzii1.zze()) {
                        zzhq zzhq0 = (zzhq)object1;
                        if(zzhq0.zza()) {
                            f2.put(zzhq0.zzb(), (zzhq0.zzc() ? zzhq0.zzd() : null));
                        }
                    }
                }
                f f3 = new f();
                if(zzii1 != null && zzii1.zzh() != 0) {
                    for(Object object2: zzii1.zzg()) {
                        zzik zzik0 = (zzik)object2;
                        if(zzik0.zza() && zzik0.zzd() > 0) {
                            f3.put(zzik0.zzb(), zzik0.zze(zzik0.zzd() - 1));
                        }
                    }
                }
                zzii zzii2 = zzii1;
                if(zzii2 != null) {
                    int v1 = 0;
                    while(v1 < zzii2.zzb() * 0x40) {
                        if(zzpj.zzn(zzii2.zza(), v1)) {
                            z3 = z1;
                            this.zzu.zzaV().zzk().zzc("Filter already evaluated. audience ID, filter ID", integer1, v1);
                            bitSet1.set(v1);
                            if(zzpj.zzn(zzii2.zzc(), v1)) {
                                bitSet0.set(v1);
                                goto label_139;
                            }
                        }
                        else {
                            z3 = z1;
                        }
                        f2.remove(v1);
                    label_139:
                        ++v1;
                        z1 = z3;
                    }
                }
                Object object3 = map2.get(integer1);
                if(z2 && z1) {
                    List list4 = (List)map1.get(integer1);
                    if(list4 != null && this.zze != null && this.zzd != null) {
                        for(Object object4: list4) {
                            int v2 = ((zzff)object4).zzb();
                            long v3 = ((long)this.zze) / 1000L;
                            if(((zzff)object4).zzj()) {
                                v3 = ((long)this.zzd) / 1000L;
                            }
                            Integer integer2 = v2;
                            if(f2.containsKey(integer2)) {
                                f2.put(integer2, v3);
                            }
                            if(f3.containsKey(integer2)) {
                                f3.put(integer2, v3);
                            }
                        }
                    }
                }
                zzy zzy0 = new zzy(this, this.zza, ((zzii)object3), bitSet0, bitSet1, f2, f3, null);
                this.zzc.put(integer1, zzy0);
            }
        }
        if(!list0.isEmpty()) {
            zzz zzz0 = new zzz(this, null);
            f f4 = new f();
            Iterator iterator5 = list0.iterator();
            while(iterator5.hasNext()) {
                Object object5 = iterator5.next();
                zzhs zzhs0 = (zzhs)object5;
                zzhs zzhs1 = zzz0.zza(this.zza, zzhs0);
                if(zzhs1 != null) {
                    zzpf zzpf0 = this.zzg;
                    zzbc zzbc0 = zzpf0.zzj().zzah(this.zza, zzhs0, "");
                    zzpf0.zzj().zzh(zzbc0);
                    if(!z) {
                        long v4 = zzbc0.zzc;
                        Map map5 = (Map)f4.get("");
                        if(map5 == null) {
                            zzav zzav2 = zzpf0.zzj();
                            zzz1 = zzz0;
                            String s3 = this.zza;
                            zzav2.zzay();
                            zzav2.zzg();
                            Preconditions.checkNotEmpty(s3);
                            Preconditions.checkNotEmpty("");
                            iterator6 = iterator5;
                            f f5 = new f();
                            SQLiteDatabase sQLiteDatabase2 = zzav2.zze();
                            try {
                                s4 = s3;
                                try {
                                    cursor3 = sQLiteDatabase2.query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{s3, ""}, null, null, null);
                                }
                                catch(SQLiteException sQLiteException2) {
                                    zzbc1 = zzbc0;
                                    cursor4 = null;
                                    goto label_242;
                                }
                            }
                            catch(Throwable throwable2) {
                                cursor4 = null;
                                goto label_252;
                            }
                            try {
                                if(cursor3.moveToFirst()) {
                                    goto label_204;
                                }
                                else {
                                    goto label_235;
                                }
                                goto label_256;
                            }
                            catch(SQLiteException sQLiteException2) {
                            }
                            catch(Throwable throwable2) {
                                goto label_219;
                            }
                            Cursor cursor5 = cursor3;
                            zzbc1 = zzbc0;
                            goto label_241;
                        label_204:
                            zzbc1 = zzbc0;
                            while(true) {
                                try {
                                    byte[] arr_b2 = cursor3.getBlob(1);
                                    try {
                                        zzff1 = (zzff)((zzfe)zzpj.zzw(zzff.zzn(), arr_b2)).zzbc();
                                        goto label_212;
                                    }
                                    catch(IOException iOException2) {
                                    }
                                }
                                catch(SQLiteException sQLiteException2) {
                                    goto label_216;
                                }
                                catch(Throwable throwable2) {
                                    goto label_219;
                                }
                                try {
                                    cursor5 = cursor3;
                                    zzav2.zzu.zzaV().zzb().zzc("Failed to merge filter. appId", zzgt.zzl(s4), iOException2);
                                    goto label_229;
                                }
                                catch(SQLiteException sQLiteException2) {
                                    goto label_241;
                                }
                                catch(Throwable throwable2) {
                                    goto label_239;
                                }
                                try {
                                label_212:
                                    integer3 = cursor3.getInt(0);
                                    list5 = (List)f5.get(integer3);
                                    goto label_221;
                                }
                                catch(SQLiteException sQLiteException2) {
                                }
                                catch(Throwable throwable2) {
                                    goto label_219;
                                }
                                try {
                                label_216:
                                    cursor5 = cursor3;
                                    goto label_241;
                                label_219:
                                    cursor5 = cursor3;
                                    goto label_251;
                                label_221:
                                    if(list5 == null) {
                                        cursor5 = cursor3;
                                        list6 = new ArrayList();
                                        f5.put(integer3, list6);
                                    }
                                    else {
                                        cursor5 = cursor3;
                                        list6 = list5;
                                    }
                                    list6.add(zzff1);
                                label_229:
                                    if(!cursor5.moveToNext()) {
                                        goto label_230;
                                    }
                                    goto label_233;
                                }
                                catch(SQLiteException sQLiteException2) {
                                    goto label_241;
                                }
                                catch(Throwable throwable2) {
                                    goto label_239;
                                }
                            label_230:
                                cursor5.close();
                                map5 = f5;
                                goto label_256;
                            label_233:
                                cursor3 = cursor5;
                            }
                            try {
                            label_235:
                                zzbc1 = zzbc0;
                                map5 = Collections.EMPTY_MAP;
                                goto label_255;
                            label_239:
                                goto label_251;
                            }
                            catch(SQLiteException sQLiteException2) {
                            }
                            catch(Throwable throwable2) {
                                goto label_239;
                            }
                        label_241:
                            cursor4 = cursor5;
                            try {
                            label_242:
                                zzav2.zzu.zzaV().zzb().zzc("Database error querying filters. appId", zzgt.zzl(s4), sQLiteException2);
                                map5 = Collections.EMPTY_MAP;
                            }
                            catch(Throwable throwable2) {
                                TWR.safeClose$NT(cursor4, throwable2);
                                throw throwable2;
                            }
                            if(cursor4 != null) {
                                cursor4.close();
                                goto label_256;
                            label_251:
                                cursor4 = cursor5;
                            label_252:
                                if(cursor4 != null) {
                                    cursor4.close();
                                }
                                throw throwable2;
                            label_255:
                                cursor3.close();
                            }
                        label_256:
                            f4.put("", map5);
                        }
                        else {
                            zzz1 = zzz0;
                            iterator6 = iterator5;
                            zzbc1 = zzbc0;
                        }
                        Iterator iterator7 = map5.keySet().iterator();
                        while(iterator7.hasNext()) {
                            Object object6 = iterator7.next();
                            Integer integer4 = (Integer)object6;
                            int v5 = (int)integer4;
                            if(this.zzb.contains(integer4)) {
                                this.zzu.zzaV().zzk().zzb("Skipping failed audience ID", integer4);
                            }
                            else {
                                boolean z4 = true;
                                for(Object object7: ((List)map5.get(integer4))) {
                                    map6 = map5;
                                    iterator9 = iterator7;
                                    zzaa zzaa0 = new zzaa(this, this.zza, v5, ((zzff)object7));
                                    v6 = v4;
                                    z4 = zzaa0.zzd(this.zzd, this.zze, zzhs1, v6, zzbc1, this.zzd(v5, ((zzff)object7).zzb()));
                                    zzaa zzaa1 = zzaa0;
                                    if(z4) {
                                        this.zzc(integer4).zza(zzaa1);
                                        v4 = v6;
                                        map5 = map6;
                                        iterator7 = iterator9;
                                        continue;
                                    }
                                    this.zzb.add(integer4);
                                    goto label_290;
                                }
                                map6 = map5;
                                iterator9 = iterator7;
                                v6 = v4;
                            label_290:
                                if(!z4) {
                                    this.zzb.add(integer4);
                                }
                                v4 = v6;
                                map5 = map6;
                                iterator7 = iterator9;
                            }
                        }
                        iterator5 = iterator6;
                        zzz0 = zzz1;
                    }
                }
            }
        }
        if(!z) {
            if(!list1.isEmpty()) {
                f f6 = new f();
                Iterator iterator10 = list1.iterator();
                while(iterator10.hasNext()) {
                    Object object8 = iterator10.next();
                    zziu zziu0 = (zziu)object8;
                    Map map7 = (Map)f6.get("");
                    if(map7 == null) {
                        zzav zzav3 = this.zzg.zzj();
                        String s5 = this.zza;
                        zzav3.zzay();
                        zzav3.zzg();
                        Preconditions.checkNotEmpty(s5);
                        Preconditions.checkNotEmpty("");
                        f f7 = new f();
                        SQLiteDatabase sQLiteDatabase3 = zzav3.zze();
                        try {
                            cursor6 = sQLiteDatabase3.query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{s5, ""}, null, null, null);
                        }
                        catch(SQLiteException sQLiteException3) {
                            iterator11 = iterator10;
                            s6 = s5;
                            cursor6 = null;
                            goto label_366;
                        }
                        catch(Throwable throwable3) {
                            cursor7 = null;
                            goto label_371;
                        }
                        try {
                            try {
                                if(cursor6.moveToFirst()) {
                                    while(true) {
                                    label_327:
                                        byte[] arr_b3 = cursor6.getBlob(1);
                                        try {
                                            zzfn0 = (zzfn)((zzfm)zzpj.zzw(zzfn.zzi(), arr_b3)).zzbc();
                                            goto label_336;
                                        }
                                        catch(IOException iOException3) {
                                        }
                                        goto label_331;
                                    }
                                }
                                else {
                                    goto label_357;
                                }
                                goto label_375;
                            }
                            catch(SQLiteException sQLiteException3) {
                                goto label_355;
                            }
                            try {
                            label_331:
                                iterator11 = iterator10;
                                zzgr0 = zzav3.zzu.zzaV().zzb();
                                s6 = s5;
                            }
                            catch(SQLiteException sQLiteException3) {
                                goto label_365;
                            }
                            try {
                                zzgr0.zzc("Failed to merge filter", zzgt.zzl(s6), iOException3);
                                goto label_347;
                            }
                            catch(SQLiteException sQLiteException3) {
                                goto label_361;
                            }
                            try {
                            label_336:
                                integer5 = cursor6.getInt(0);
                                list7 = (List)f7.get(integer5);
                                if(list7 == null) {
                                    goto label_339;
                                }
                                else {
                                    goto label_343;
                                }
                                goto label_345;
                            }
                            catch(SQLiteException sQLiteException3) {
                                goto label_355;
                            }
                            try {
                            label_339:
                                iterator11 = iterator10;
                                List list8 = new ArrayList();
                                f7.put(integer5, list8);
                                goto label_345;
                            label_343:
                                iterator11 = iterator10;
                                list8 = list7;
                            label_345:
                                list8.add(zzfn0);
                                s6 = s5;
                            }
                            catch(SQLiteException sQLiteException3) {
                                goto label_365;
                            }
                            try {
                            label_347:
                                if(!cursor6.moveToNext()) {
                                    goto label_348;
                                }
                                goto label_351;
                            }
                            catch(SQLiteException sQLiteException3) {
                                goto label_361;
                            }
                        }
                        catch(Throwable throwable3) {
                            goto label_363;
                        }
                    label_348:
                        cursor6.close();
                        map7 = f7;
                        goto label_375;
                        try {
                            try {
                            label_351:
                                iterator10 = iterator11;
                                s5 = s6;
                                goto label_327;
                            }
                            catch(SQLiteException sQLiteException3) {
                                try {
                                label_355:
                                    iterator11 = iterator10;
                                    goto label_365;
                                    try {
                                    label_357:
                                        iterator11 = iterator10;
                                        map7 = Collections.EMPTY_MAP;
                                        goto label_374;
                                    }
                                    catch(SQLiteException sQLiteException3) {
                                    label_361:
                                        goto label_366;
                                    }
                                    try {
                                    label_363:
                                        goto label_370;
                                    label_365:
                                        s6 = s5;
                                    }
                                    catch(SQLiteException sQLiteException3) {
                                        goto label_365;
                                    }
                                }
                                catch(SQLiteException sQLiteException3) {
                                    goto label_365;
                                }
                            }
                        label_366:
                            zzav3.zzu.zzaV().zzb().zzc("Database error querying filters. appId", zzgt.zzl(s6), sQLiteException3);
                            map7 = Collections.EMPTY_MAP;
                            if(cursor6 == null) {
                                goto label_369;
                            }
                            goto label_374;
                        }
                        catch(Throwable throwable3) {
                            goto label_363;
                        }
                    label_369:
                        goto label_375;
                    label_370:
                        cursor7 = cursor6;
                    label_371:
                        if(cursor7 != null) {
                            cursor7.close();
                        }
                        throw throwable3;
                    label_374:
                        cursor6.close();
                    label_375:
                        f6.put("", map7);
                    }
                    else {
                        iterator11 = iterator10;
                    }
                    Iterator iterator12 = map7.keySet().iterator();
                label_379:
                    while(iterator12.hasNext()) {
                        Object object9 = iterator12.next();
                        Integer integer6 = (Integer)object9;
                        int v7 = (int)integer6;
                        if(this.zzb.contains(integer6)) {
                            this.zzu.zzaV().zzk().zzb("Skipping failed audience ID", integer6);
                            break;
                        }
                        boolean z5 = true;
                        for(Object object10: ((List)map7.get(integer6))) {
                            zzfn zzfn1 = (zzfn)object10;
                            zzib zzib0 = this.zzu;
                            map8 = map7;
                            if(Log.isLoggable(zzib0.zzaV().zzn(), 2)) {
                                f8 = f6;
                                zzib0.zzaV().zzk().zzd("Evaluating filter. audience, filter, property", integer6, (zzfn1.zza() ? zzfn1.zzb() : null), zzib0.zzl().zzc(""));
                                zzib0.zzaV().zzk().zzb("Filter definition", this.zzg.zzp().zzk(zzfn1));
                            }
                            else {
                                f8 = f6;
                            }
                            if(zzfn1.zza() && zzfn1.zzb() <= 0x100) {
                                zzac zzac0 = new zzac(this, this.zza, v7, zzfn1);
                                z5 = zzac0.zzd(this.zzd, this.zze, zziu0, this.zzd(v7, zzfn1.zzb()));
                                if(z5) {
                                    this.zzc(integer6).zza(zzac0);
                                    map7 = map8;
                                    f6 = f8;
                                    continue;
                                }
                                this.zzb.add(integer6);
                                goto label_416;
                            }
                            zzib0.zzaV().zze().zzc("Invalid property filter ID. appId, id", zzgt.zzl(this.zza), String.valueOf((zzfn1.zza() ? zzfn1.zzb() : null)));
                            this.zzb.add(integer6);
                            map7 = map8;
                            f6 = f8;
                            continue label_379;
                        }
                        map8 = map7;
                        f8 = f6;
                    label_416:
                        if(!z5) {
                            this.zzb.add(integer6);
                        }
                        map7 = map8;
                        f6 = f8;
                    }
                    iterator10 = iterator11;
                }
            }
            List list9 = new ArrayList();
            Set set0 = this.zzc.keySet();
            set0.removeAll(this.zzb);
            for(Object object11: set0) {
                zzy zzy1 = (zzy)this.zzc.get(((Integer)object11));
                Preconditions.checkNotNull(zzy1);
                zzhg zzhg0 = zzy1.zzb(((int)(((Integer)object11))));
                ((ArrayList)list9).add(zzhg0);
                zzav zzav4 = this.zzg.zzj();
                String s7 = this.zza;
                zzii zzii3 = zzhg0.zzc();
                zzav4.zzay();
                zzav4.zzg();
                Preconditions.checkNotEmpty(s7);
                Preconditions.checkNotNull(zzii3);
                byte[] arr_b4 = zzii3.zzcc();
                ContentValues contentValues0 = new ContentValues();
                contentValues0.put("app_id", s7);
                contentValues0.put("audience_id", ((Integer)object11));
                contentValues0.put("current_results", arr_b4);
                try {
                    if(zzav4.zze().insertWithOnConflict("audience_filter_values", null, contentValues0, 5) != -1L) {
                        continue;
                    }
                    zzav4.zzu.zzaV().zzb().zzb("Failed to insert filter results (got -1). appId", zzgt.zzl(s7));
                }
                catch(SQLiteException sQLiteException4) {
                    zzav4.zzu.zzaV().zzb().zzc("Error storing filter results. appId", zzgt.zzl(s7), sQLiteException4);
                }
            }
            return list9;
        }
        return new ArrayList();
    }

    @Override  // com.google.android.gms.measurement.internal.zzor
    public final boolean zzbb() {
        return false;
    }

    private final zzy zzc(Integer integer0) {
        if(this.zzc.containsKey(integer0)) {
            return (zzy)this.zzc.get(integer0);
        }
        zzy zzy0 = new zzy(this, this.zza, null);
        this.zzc.put(integer0, zzy0);
        return zzy0;
    }

    private final boolean zzd(int v, int v1) {
        zzy zzy0 = (zzy)this.zzc.get(v);
        return zzy0 == null ? false : zzy0.zzc().get(v1);
    }
}

