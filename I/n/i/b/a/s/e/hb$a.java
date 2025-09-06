package i.n.i.b.a.s.e;

import U4.x;
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

public final class hb.a extends JobService {
    @Override  // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters0) {
        boolean z;
        int v1;
        PersistableBundle persistableBundle0 = jobParameters0.getExtras();
        int v = new ib(persistableBundle0.getInt("requirements")).a;
        if((v & 1) == 0) {
            v1 = 0;
        }
        else {
            Object object0 = this.getSystemService("connectivity");
            object0.getClass();
            NetworkInfo networkInfo0 = ((ConnectivityManager)object0).getActiveNetworkInfo();
            if(networkInfo0 == null || !networkInfo0.isConnected()) {
                v1 = v & 3;
            }
            else if(L7.a >= 24) {
                Network network0 = ((ConnectivityManager)object0).getActiveNetwork();
                if(network0 == null) {
                    v1 = v & 3;
                }
                else {
                    NetworkCapabilities networkCapabilities0 = ((ConnectivityManager)object0).getNetworkCapabilities(network0);
                    if(networkCapabilities0 == null || !networkCapabilities0.hasCapability(16)) {
                        v1 = v & 3;
                    }
                    else {
                        v1 = (v & 2) == 0 || !((ConnectivityManager)object0).isActiveNetworkMetered() ? 0 : 2;
                    }
                }
            }
            else {
                v1 = (v & 2) == 0 || !((ConnectivityManager)object0).isActiveNetworkMetered() ? 0 : 2;
            }
        }
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
            int v2 = L7.a;
            if(v2 >= 23) {
                z = ((PowerManager)object1).isDeviceIdleMode();
            }
            else if(v2 < 20) {
                z = !((PowerManager)object1).isScreenOn();
            }
            else if(!((PowerManager)object1).isInteractive()) {
                z = true;
            }
            else {
                z = false;
            }
            if(!z) {
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
            Intent intent1 = new Intent(s).setPackage(s1);
            if(L7.a >= 26) {
                this.startForegroundService(intent1);
                return false;
            }
            this.startService(intent1);
            return false;
        }
        x.u(v1, "Requirements not met: ", "PlatformScheduler");
        this.jobFinished(jobParameters0, true);
        return false;
    }

    @Override  // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters0) {
        return false;
    }
}

