package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.V;
import androidx.collection.f;
import androidx.collection.u;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzja;
import com.google.android.gms.internal.measurement.zzmq;
import com.google.android.gms.internal.measurement.zzr;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public final class zzhs extends zzor implements zzak {
    final Map zza;
    final Map zzb;
    final Map zzc;
    final u zzd;
    final zzr zze;
    private final Map zzf;
    private final Map zzh;
    private final Map zzi;
    private final Map zzj;
    private final Map zzk;
    private final Map zzl;

    public zzhs(zzpf zzpf0) {
        super(zzpf0);
        this.zzf = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.zza = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.zzb = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.zzc = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.zzh = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.zzj = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.zzk = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.zzl = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.zzi = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.zzd = new zzhl(this, 20);
        this.zze = new zzhm(this);
    }

    public final zzjh zzA(String s, zzjj zzjj0) {
        this.zzg();
        this.zzE(s);
        zzgf zzgf0 = this.zzx(s);
        if(zzgf0 == null) {
            return zzjh.zza;
        }
        for(Object object0: zzgf0.zzf()) {
            zzfu zzfu0 = (zzfu)object0;
            if(zzhs.zzJ(zzfu0.zzb()) == zzjj0) {
                switch(zzfu0.zzc() - 1) {
                    case 1: {
                        return zzjh.zzd;
                    }
                    case 2: {
                        return zzjh.zzc;
                    }
                    default: {
                        return zzjh.zza;
                    }
                }
            }
            if(false) {
                break;
            }
        }
        return zzjh.zza;
    }

    public final boolean zzB(String s) {
        this.zzg();
        this.zzE(s);
        zzgf zzgf0 = this.zzx(s);
        if(zzgf0 == null) {
            return false;
        }
        for(Object object0: zzgf0.zza()) {
            if(((zzfu)object0).zzb() == 3 && ((zzfu)object0).zzd() == 3) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public final zzc zzC(String s) {
        this.zzay();
        Preconditions.checkNotEmpty(s);
        zzaq zzaq0 = this.zzg.zzj().zzy(s);
        if(zzaq0 == null) {
            return null;
        }
        this.zzu.zzaV().zzk().zzb("Populate EES config from database on cache miss. appId", s);
        this.zzG(s, this.zzH(s, zzaq0.zza));
        return (zzc)this.zzd.snapshot().get(s);
    }

    public final Map zzD() {
        return this.zzf;
    }

    private final void zzE(String s) {
        this.zzay();
        this.zzg();
        Preconditions.checkNotEmpty(s);
        Map map0 = this.zzh;
        if(map0.get(s) == null) {
            zzaq zzaq0 = this.zzg.zzj().zzy(s);
            if(zzaq0 == null) {
                this.zzf.put(s, null);
                this.zzb.put(s, null);
                this.zza.put(s, null);
                this.zzc.put(s, null);
                map0.put(s, null);
                this.zzj.put(s, null);
                this.zzk.put(s, null);
                this.zzl.put(s, null);
                this.zzi.put(s, null);
                return;
            }
            zzgk zzgk0 = (zzgk)this.zzH(s, zzaq0.zza).zzcl();
            this.zzF(s, zzgk0);
            Map map1 = zzhs.zzI(((zzgl)zzgk0.zzbc()));
            this.zzf.put(s, map1);
            map0.put(s, ((zzgl)zzgk0.zzbc()));
            this.zzG(s, ((zzgl)zzgk0.zzbc()));
            String s1 = zzgk0.zzh();
            this.zzj.put(s, s1);
            this.zzk.put(s, zzaq0.zzb);
            this.zzl.put(s, zzaq0.zzc);
        }
    }

    private final void zzF(String s, zzgk zzgk0) {
        HashSet hashSet0 = new HashSet();
        f f0 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        f f1 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        f f2 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        Iterator iterator0 = zzgk0.zzg().iterator();
        while(iterator0.hasNext()) {
            iterator0.next();
            hashSet0.add("");
        }
        for(int v = 0; v < zzgk0.zza(); ++v) {
            zzgi zzgi0 = (zzgi)zzgk0.zzb(v).zzcl();
            if(zzgi0.zza().isEmpty()) {
                Z.A(this.zzu, "EventConfig contained null event name");
            }
            else {
                String s1 = zzgi0.zza();
                String s2 = zzjl.zzb(zzgi0.zza());
                if(!TextUtils.isEmpty(s2)) {
                    zzgi0.zzb(s2);
                    zzgk0.zzc(v, zzgi0);
                }
                if(zzgi0.zzc() && zzgi0.zzd()) {
                    f0.put(s1, Boolean.TRUE);
                }
                if(zzgi0.zze() && zzgi0.zzf()) {
                    f1.put(zzgi0.zza(), Boolean.TRUE);
                }
                if(zzgi0.zzg()) {
                    if(zzgi0.zzh() < 2 || zzgi0.zzh() > 0xFFFF) {
                        this.zzu.zzaV().zze().zzc("Invalid sampling rate. Event name, sample rate", zzgi0.zza(), zzgi0.zzh());
                    }
                    else {
                        f2.put(zzgi0.zza(), zzgi0.zzh());
                    }
                }
            }
        }
        this.zza.put(s, hashSet0);
        this.zzb.put(s, f0);
        this.zzc.put(s, f1);
        this.zzi.put(s, f2);
    }

    private final void zzG(String s, zzgl zzgl0) {
        if(zzgl0.zzj() != 0) {
            zzib zzib0 = this.zzu;
            zzib0.zzaV().zzk().zzb("EES programs found", zzgl0.zzj());
            zzja zzja0 = (zzja)zzgl0.zzi().get(0);
            try {
                zzc zzc0 = new zzc();
                zzc0.zza("internal.remoteConfig", new zzhr(this, s));
                zzc0.zza("internal.appMetadata", new zzho(this, s));
                zzc0.zza("internal.logger", new zzhp(this));
                zzc0.zzf(zzja0);
                this.zzd.put(s, zzc0);
                zzib0.zzaV().zzk().zzc("EES program loaded for appId, activities", s, zzja0.zzb().zzb());
                Iterator iterator0 = zzja0.zzb().zza().iterator();
                while(iterator0.hasNext()) {
                    iterator0.next();
                    zzib0.zzaV().zzk().zzb("EES program activity", "");
                }
            }
            catch(zzd unused_ex) {
                this.zzu.zzaV().zzb().zzb("Failed to load EES program. appId", s);
            }
            return;
        }
        this.zzd.remove(s);
    }

    private final zzgl zzH(String s, byte[] arr_b) {
        if(arr_b == null) {
            return zzgl.zzs();
        }
        try {
            zzgl zzgl0 = (zzgl)((zzgk)zzpj.zzw(zzgl.zzr(), arr_b)).zzbc();
            zzgr zzgr0 = this.zzu.zzaV().zzk();
            String s1 = null;
            Long long0 = zzgl0.zza() ? zzgl0.zzb() : null;
            if(zzgl0.zzc()) {
                s1 = "";
            }
            zzgr0.zzc("Parsed config. version, gmp_app_id", long0, s1);
            return zzgl0;
        }
        catch(zzmq zzmq0) {
        }
        catch(RuntimeException runtimeException0) {
            this.zzu.zzaV().zze().zzc("Unable to merge remote config. appId", zzgt.zzl(s), runtimeException0);
            return zzgl.zzs();
        }
        this.zzu.zzaV().zze().zzc("Unable to merge remote config. appId", zzgt.zzl(s), zzmq0);
        return zzgl.zzs();
    }

    private static final Map zzI(zzgl zzgl0) {
        Map map0 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        if(zzgl0 != null) {
            Iterator iterator0 = zzgl0.zze().iterator();
            while(iterator0.hasNext()) {
                iterator0.next();
                ((V)map0).put("", "");
            }
        }
        return map0;
    }

    private static final zzjj zzJ(int v) {
        switch(v - 1) {
            case 1: {
                return zzjj.zza;
            }
            case 2: {
                return zzjj.zzb;
            }
            case 3: {
                return zzjj.zzc;
            }
            case 4: {
                return zzjj.zzd;
            }
            default: {
                return null;
            }
        }
    }

    @Override  // com.google.android.gms.measurement.internal.zzak
    public final String zza(String s, String s1) {
        this.zzg();
        this.zzE(s);
        Map map0 = (Map)this.zzf.get(s);
        return map0 == null ? null : ((String)map0.get(s1));
    }

    public final zzgl zzb(String s) {
        this.zzay();
        this.zzg();
        Preconditions.checkNotEmpty(s);
        this.zzE(s);
        return (zzgl)this.zzh.get(s);
    }

    @Override  // com.google.android.gms.measurement.internal.zzor
    public final boolean zzbb() {
        return false;
    }

    public final String zzc(String s) {
        this.zzg();
        this.zzE(s);
        return (String)this.zzj.get(s);
    }

    public final String zzd(String s) {
        this.zzg();
        return (String)this.zzk.get(s);
    }

    public final String zze(String s) {
        this.zzg();
        return (String)this.zzl.get(s);
    }

    public final void zzf(String s) {
        this.zzg();
        this.zzk.put(s, null);
    }

    public final void zzh(String s) {
        this.zzg();
        this.zzh.remove(s);
    }

    public final boolean zzi(String s, byte[] arr_b, String s1, String s2) {
        this.zzay();
        this.zzg();
        Preconditions.checkNotEmpty(s);
        zzgk zzgk0 = (zzgk)this.zzH(s, arr_b).zzcl();
        this.zzF(s, zzgk0);
        this.zzG(s, ((zzgl)zzgk0.zzbc()));
        zzgl zzgl0 = (zzgl)zzgk0.zzbc();
        this.zzh.put(s, zzgl0);
        String s3 = zzgk0.zzh();
        this.zzj.put(s, s3);
        this.zzk.put(s, s1);
        this.zzl.put(s, s2);
        Map map0 = zzhs.zzI(((zzgl)zzgk0.zzbc()));
        this.zzf.put(s, map0);
        this.zzg.zzj().zzag(s, new ArrayList(zzgk0.zzd()));
        try {
            zzgk0.zze();
            arr_b = ((zzgl)zzgk0.zzbc()).zzcc();
        }
        catch(RuntimeException runtimeException0) {
            this.zzu.zzaV().zze().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzgt.zzl(s), runtimeException0);
        }
        zzav zzav0 = this.zzg.zzj();
        Preconditions.checkNotEmpty(s);
        zzav0.zzg();
        zzav0.zzay();
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("remote_config", arr_b);
        contentValues0.put("config_last_modified_time", s1);
        contentValues0.put("e_tag", s2);
        try {
            if(((long)zzav0.zze().update("apps", contentValues0, "app_id = ?", new String[]{s})) == 0L) {
                zzav0.zzu.zzaV().zzb().zzb("Failed to update remote config (got 0). appId", zzgt.zzl(s));
            }
        }
        catch(SQLiteException sQLiteException0) {
            zzav0.zzu.zzaV().zzb().zzc("Error storing remote config. appId", zzgt.zzl(s), sQLiteException0);
        }
        zzgk0.zzf();
        zzgl zzgl1 = (zzgl)zzgk0.zzbc();
        this.zzh.put(s, zzgl1);
        return true;
    }

    public final boolean zzj(String s, String s1) {
        this.zzg();
        this.zzE(s);
        if(this.zzn(s) && zzpo.zzZ(s1)) {
            return true;
        }
        if(this.zzo(s) && zzpo.zzh(s1)) {
            return true;
        }
        Map map0 = (Map)this.zzb.get(s);
        if(map0 != null) {
            Boolean boolean0 = (Boolean)map0.get(s1);
            return boolean0 == null ? false : boolean0.booleanValue();
        }
        return false;
    }

    public final boolean zzk(String s, String s1) {
        this.zzg();
        this.zzE(s);
        if("ecommerce_purchase".equals(s1)) {
            return true;
        }
        if(!"purchase".equals(s1) && !"refund".equals(s1)) {
            Map map0 = (Map)this.zzc.get(s);
            if(map0 != null) {
                Boolean boolean0 = (Boolean)map0.get(s1);
                return boolean0 == null ? false : boolean0.booleanValue();
            }
            return false;
        }
        return true;
    }

    public final Set zzl(String s) {
        this.zzg();
        this.zzE(s);
        return (Set)this.zza.get(s);
    }

    public final int zzm(String s, String s1) {
        this.zzg();
        this.zzE(s);
        Map map0 = (Map)this.zzi.get(s);
        if(map0 != null) {
            Integer integer0 = (Integer)map0.get(s1);
            return integer0 == null ? 1 : ((int)integer0);
        }
        return 1;
    }

    public final boolean zzn(String s) {
        return "1".equals(this.zza(s, "measurement.upload.blacklist_internal"));
    }

    public final boolean zzo(String s) {
        return "1".equals(this.zza(s, "measurement.upload.blacklist_public"));
    }

    public final boolean zzp(String s) {
        this.zzg();
        this.zzE(s);
        return this.zza.get(s) != null && (((Set)this.zza.get(s)).contains("device_model") || ((Set)this.zza.get(s)).contains("device_info"));
    }

    public final boolean zzq(String s) {
        this.zzg();
        this.zzE(s);
        return this.zza.get(s) != null && (((Set)this.zza.get(s)).contains("os_version") || ((Set)this.zza.get(s)).contains("device_info"));
    }

    public final boolean zzr(String s) {
        this.zzg();
        this.zzE(s);
        return this.zza.get(s) != null && ((Set)this.zza.get(s)).contains("user_id");
    }

    public final boolean zzs(String s) {
        this.zzg();
        this.zzE(s);
        return this.zza.get(s) != null && ((Set)this.zza.get(s)).contains("google_signals");
    }

    public final boolean zzt(String s) {
        this.zzg();
        this.zzE(s);
        return this.zza.get(s) != null && ((Set)this.zza.get(s)).contains("app_instance_id");
    }

    public final boolean zzu(String s) {
        this.zzg();
        this.zzE(s);
        return this.zza.get(s) != null && ((Set)this.zza.get(s)).contains("enhanced_user_id");
    }

    public final boolean zzv(String s, zzjj zzjj0) {
        this.zzg();
        this.zzE(s);
        zzgf zzgf0 = this.zzx(s);
        if(zzgf0 == null) {
            return false;
        }
        for(Object object0: zzgf0.zza()) {
            zzfu zzfu0 = (zzfu)object0;
            if(zzjj0 == zzhs.zzJ(zzfu0.zzb())) {
                return zzfu0.zzc() == 2;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public final zzjj zzw(String s, zzjj zzjj0) {
        this.zzg();
        this.zzE(s);
        zzgf zzgf0 = this.zzx(s);
        if(zzgf0 != null) {
            for(Object object0: zzgf0.zzb()) {
                zzfw zzfw0 = (zzfw)object0;
                if(zzjj0 == zzhs.zzJ(zzfw0.zzb())) {
                    return zzhs.zzJ(zzfw0.zzc());
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    public final zzgf zzx(String s) {
        this.zzg();
        this.zzE(s);
        zzgl zzgl0 = this.zzb(s);
        return zzgl0 == null || !zzgl0.zzn() ? null : zzgl0.zzo();
    }

    public final boolean zzy(String s) {
        this.zzg();
        this.zzE(s);
        zzgf zzgf0 = this.zzx(s);
        return zzgf0 == null ? true : !zzgf0.zzd() || zzgf0.zze();
    }

    public final SortedSet zzz(String s) {
        this.zzg();
        this.zzE(s);
        SortedSet sortedSet0 = new TreeSet();
        zzgf zzgf0 = this.zzx(s);
        if(zzgf0 != null) {
            Iterator iterator0 = zzgf0.zzc().iterator();
            while(iterator0.hasNext()) {
                iterator0.next();
                ((TreeSet)sortedSet0).add("");
            }
        }
        return sortedSet0;
    }
}

