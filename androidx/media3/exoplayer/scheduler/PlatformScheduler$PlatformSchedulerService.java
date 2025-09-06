package androidx.media3.exoplayer.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.PersistableBundle;
import android.os.PowerManager;
import com.iloen.melon.utils.a;

public final class PlatformScheduler.PlatformSchedulerService extends JobService {
    @Override  // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters0) {
        int v1;
        PersistableBundle persistableBundle0 = jobParameters0.getExtras();
        int v = new Requirements(persistableBundle0.getInt("requirements")).a;
        if((v & 1) == 0) {
            v1 = 0;
        }
        else {
            Object object0 = this.getSystemService("connectivity");
            object0.getClass();
            ConnectivityManager connectivityManager0 = (ConnectivityManager)object0;
            NetworkInfo networkInfo0 = connectivityManager0.getActiveNetworkInfo();
            if(networkInfo0 == null || !networkInfo0.isConnected()) {
                goto label_19;
            label_21:
                v1 = (v & 2) == 0 || !connectivityManager0.isActiveNetworkMetered() ? 0 : 2;
            }
            else {
                Network network0 = connectivityManager0.getActiveNetwork();
                if(network0 == null) {
                    v1 = v & 3;
                }
                else {
                    try {
                        NetworkCapabilities networkCapabilities0 = connectivityManager0.getNetworkCapabilities(network0);
                        if(networkCapabilities0 == null) {
                            v1 = v & 3;
                            goto label_27;
                        label_19:
                            v1 = v & 3;
                        }
                        else if(!networkCapabilities0.hasCapability(16)) {
                            v1 = v & 3;
                        }
                        else {
                            goto label_21;
                        }
                    }
                    catch(SecurityException unused_ex) {
                        goto label_21;
                    }
                }
            }
        }
    label_27:
        if((v & 8) != 0) {
            Intent intent0 = this.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if(intent0 == null) {
                v1 |= 8;
            }
            else {
                switch(intent0.getIntExtra("status", -1)) {
                    case 2: 
                    case 5: {
                        break;
                    }
                    default: {
                        v1 |= 8;
                    }
                }
            }
        }
        if((v & 4) != 0) {
            Object object1 = this.getSystemService("power");
            object1.getClass();
            if(!((PowerManager)object1).isDeviceIdleMode()) {
                v1 |= 4;
            }
        }
        if((v & 16) != 0 && this.registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) != null) {
            v1 |= 16;
        }
        if(v1 == 0) {
            String s = persistableBundle0.getString("service_action");
            s.getClass();
            String s1 = persistableBundle0.getString("service_package");
            s1.getClass();
            this.startForegroundService(new Intent(s).setPackage(s1));
            return false;
        }
        a.r(v1, "Requirements not met: ", "PlatformScheduler");
        this.jobFinished(jobParameters0, true);
        return false;
    }

    @Override  // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters0) {
        return false;
    }
}

