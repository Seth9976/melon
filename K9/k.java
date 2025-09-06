package k9;

import E9.w;
import android.content.Context;
import androidx.room.H;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.premium.PremiumContentsEntity;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import ie.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import u9.f;

public final class k extends Thread {
    @Override
    public final void run() {
        boolean z;
        Context context0 = MelonAppBase.instance.getContext();
        f f0 = f.g.b(context0, "offline");
        File file0 = (File)((j)f0.d).getValue();
        File file1 = f0.a();
        c c0 = b.a;
        c0.getClass();
        for(Object object0: new ArrayList(((List)w.N(((H)c0.f().a), true, false, new ld.j(9))))) {
            PremiumContentsEntity premiumContentsEntity0 = (PremiumContentsEntity)object0;
            String s = c.d(file0, file1, premiumContentsEntity0.j);
            if(s == null || s.isEmpty()) {
                z = false;
            }
            else {
                premiumContentsEntity0.j = s;
                z = true;
            }
            String s1 = premiumContentsEntity0.k;
            if(s1 != null && !s1.isEmpty()) {
                String s2 = c.d(file0, file1, s1);
                if(s2 == null || s2.isEmpty()) {
                    z = false;
                }
                else {
                    premiumContentsEntity0.k = s2;
                }
            }
            String s3 = premiumContentsEntity0.l;
            if(s3 != null && !s3.isEmpty()) {
                String s4 = c.d(file0, file1, s3);
                if(s4 == null || s4.isEmpty()) {
                    z = false;
                }
                else {
                    premiumContentsEntity0.l = s4;
                }
            }
            if(!z) {
            }
            else if(c0.h(premiumContentsEntity0)) {
                continue;
            }
            LogU.d("ContentsManager", "updatePathWhenMigration(), Offline Migragion Fail");
        }
        File file2 = new File(file0, "2");
        File file3 = new File(file1, "2");
        if(!file3.exists()) {
            file3.mkdirs();
        }
        File[] arr_file = file2.listFiles();
        if(arr_file != null) {
            for(int v = 0; v < arr_file.length; ++v) {
                File file4 = arr_file[v];
                file4.renameTo(new File(file3, file4.getName()));
            }
        }
        c.c(file0);
        MelonPrefs.getInstance().setBoolean("offlineMigration", true);
    }
}

