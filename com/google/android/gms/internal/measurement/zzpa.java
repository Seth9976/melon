package com.google.android.gms.internal.measurement;

public final class zzpa implements zzoz {
    public static final zzkl zzA;
    public static final zzkl zzB;
    public static final zzkl zzC;
    public static final zzkl zzD;
    public static final zzkl zzE;
    public static final zzkl zzF;
    public static final zzkl zzG;
    public static final zzkl zzH;
    public static final zzkl zzI;
    public static final zzkl zzJ;
    public static final zzkl zzK;
    public static final zzkl zzL;
    public static final zzkl zzM;
    public static final zzkl zzN;
    public static final zzkl zzO;
    public static final zzkl zzP;
    public static final zzkl zzQ;
    public static final zzkl zzR;
    public static final zzkl zzS;
    public static final zzkl zzT;
    public static final zzkl zzU;
    public static final zzkl zzV;
    public static final zzkl zzW;
    public static final zzkl zzX;
    public static final zzkl zzY;
    public static final zzkl zzZ;
    public static final zzkl zza;
    public static final zzkl zzaa;
    public static final zzkl zzab;
    public static final zzkl zzac;
    public static final zzkl zzad;
    public static final zzkl zzae;
    public static final zzkl zzaf;
    public static final zzkl zzag;
    public static final zzkl zzah;
    public static final zzkl zzai;
    public static final zzkl zzaj;
    public static final zzkl zzak;
    public static final zzkl zzal;
    public static final zzkl zzam;
    public static final zzkl zzan;
    public static final zzkl zzao;
    public static final zzkl zzap;
    public static final zzkl zzaq;
    public static final zzkl zzar;
    public static final zzkl zzas;
    public static final zzkl zzat;
    public static final zzkl zzau;
    public static final zzkl zzav;
    public static final zzkl zzaw;
    public static final zzkl zzb;
    public static final zzkl zzc;
    public static final zzkl zzd;
    public static final zzkl zze;
    public static final zzkl zzf;
    public static final zzkl zzg;
    public static final zzkl zzh;
    public static final zzkl zzi;
    public static final zzkl zzj;
    public static final zzkl zzk;
    public static final zzkl zzl;
    public static final zzkl zzm;
    public static final zzkl zzn;
    public static final zzkl zzo;
    public static final zzkl zzp;
    public static final zzkl zzq;
    public static final zzkl zzr;
    public static final zzkl zzs;
    public static final zzkl zzt;
    public static final zzkl zzu;
    public static final zzkl zzv;
    public static final zzkl zzw;
    public static final zzkl zzx;
    public static final zzkl zzy;
    public static final zzkl zzz;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzpa.zza = zzkf0.zzc("measurement.ad_id_cache_time", 10000L);
        zzpa.zzb = zzkf0.zzc("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L);
        zzpa.zzc = zzkf0.zzd("measurement.config.bundle_for_all_apps_on_backgrounded", true);
        zzpa.zzd = zzkf0.zzc("measurement.max_bundles_per_iteration", 100L);
        zzpa.zze = zzkf0.zzf("measurement.gbraid_campaign.campaign_params_triggering_info_update", "gclid,gbraid,gad_campaignid");
        zzpa.zzf = zzkf0.zzc("measurement.config.cache_time", 86400000L);
        zzkf0.zzf("measurement.log_tag", "FA");
        zzpa.zzg = zzkf0.zzf("measurement.config.url_authority", "app-measurement.com");
        zzpa.zzh = zzkf0.zzf("measurement.config.url_scheme", "https");
        zzpa.zzi = zzkf0.zzc("measurement.upload.debug_upload_interval", 1000L);
        zzkf0.zzd("measurement.config.default_flag_values", true);
        zzpa.zzj = zzkf0.zzc("measurement.session.engagement_interval", 3600000L);
        zzpa.zzk = zzkf0.zzf("measurement.rb.attribution.event_params", "value|currency");
        zzpa.zzl = zzkf0.zzf("measurement.edpb.events_cached_in_no_data_mode", "_f,_v,_cmp");
        zzpa.zzm = zzkf0.zzc("measurement.upload.google_signal_max_queue_time", 605000L);
        zzpa.zzn = zzkf0.zzf("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d");
        zzpa.zzo = zzkf0.zzc("measurement.lifetimevalue.max_currency_tracked", 4L);
        zzpa.zzp = zzkf0.zzc("measurement.dma_consent.max_daily_dcu_realtime_events", 1L);
        zzpa.zzq = zzkf0.zzc("measurement.upload.max_event_parameter_value_length", 500L);
        zzpa.zzr = zzkf0.zzc("measurement.store.max_stored_events_per_app", 100000L);
        zzpa.zzs = zzkf0.zzc("measurement.experiment.max_ids", 50L);
        zzpa.zzt = zzkf0.zzc("measurement.audience.filter_result_max_count", 200L);
        zzpa.zzu = zzkf0.zzc("measurement.upload.max_item_scoped_custom_parameters", 27L);
        zzpa.zzv = zzkf0.zzc("measurement.rb.max_trigger_registrations_per_day", 1000L);
        zzpa.zzw = zzkf0.zzc("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0L);
        zzpa.zzx = zzkf0.zzc("measurement.rb.attribution.client.min_ad_services_version", 7L);
        zzpa.zzy = zzkf0.zzc("measurement.alarm_manager.minimum_interval", 60000L);
        zzpa.zzz = zzkf0.zzc("measurement.upload.minimum_delay", 500L);
        zzpa.zzA = zzkf0.zzc("measurement.monitoring.sample_period_millis", 86400000L);
        zzpa.zzB = zzkf0.zzc("measurement.rb.attribution.notify_app_delay_millis", 3000L);
        zzpa.zzC = zzkf0.zzd("measurement.config.notify_trigger_uris_on_backgrounded", true);
        zzkf0.zzc("measurement.id.rb.attribution.app_allowlist", 0L);
        zzpa.zzD = zzkf0.zzf("measurement.rb.attribution.app_allowlist", "com.labpixies.flood");
        zzpa.zzE = zzkf0.zzc("measurement.upload.realtime_upload_interval", 10000L);
        zzpa.zzF = zzkf0.zzc("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        zzkf0.zzc("measurement.config.cache_time.service", 3600000L);
        zzpa.zzG = zzkf0.zzc("measurement.service_client.idle_disconnect_millis", 5000L);
        zzkf0.zzf("measurement.log_tag.service", "FA-SVC");
        zzpa.zzH = zzkf0.zzc("measurement.service_client.reconnect_millis", 1000L);
        zzkf0.zzf("measurement.sgtm.app_allowlist", "*");
        zzpa.zzI = zzkf0.zzc("measurement.sgtm.batch.long_queuing_threshold", 240000L);
        zzpa.zzJ = zzkf0.zzc("measurement.sgtm.batch.retry_interval", 1800000L);
        zzpa.zzK = zzkf0.zzc("measurement.sgtm.batch.retry_max_count", 10L);
        zzpa.zzL = zzkf0.zzc("measurement.sgtm.batch.retry_max_wait", 21600000L);
        zzpa.zzM = zzkf0.zzf("measurement.sgtm.service_upload_apps_list", "");
        zzpa.zzN = zzkf0.zzf("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504");
        zzpa.zzO = zzkf0.zzc("measurement.sgtm.upload.batches_retrieval_limit", 5L);
        zzpa.zzP = zzkf0.zzc("measurement.sgtm.upload.max_queued_batches", 5000L);
        zzpa.zzQ = zzkf0.zzc("measurement.sgtm.upload.min_delay_after_background", 600000L);
        zzpa.zzR = zzkf0.zzc("measurement.sgtm.upload.min_delay_after_broadcast", 1000L);
        zzpa.zzS = zzkf0.zzc("measurement.sgtm.upload.min_delay_after_startup", 5000L);
        zzpa.zzT = zzkf0.zzc("measurement.sgtm.upload.retry_interval", 600000L);
        zzpa.zzU = zzkf0.zzc("measurement.sgtm.upload.retry_max_wait", 21600000L);
        zzpa.zzV = zzkf0.zzc("measurement.upload.stale_data_deletion_interval", 86400000L);
        zzpa.zzW = zzkf0.zzc("measurement.rb.attribution.max_retry_delay_seconds", 16L);
        zzpa.zzX = zzkf0.zzc("measurement.rb.attribution.client.min_time_after_boot_seconds", 90L);
        zzpa.zzY = zzkf0.zzf("measurement.rb.attribution.uri_authority", "google-analytics.com");
        zzpa.zzZ = zzkf0.zzc("measurement.rb.attribution.max_queue_time", 864000000L);
        zzpa.zzaa = zzkf0.zzf("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion");
        zzpa.zzab = zzkf0.zzf("measurement.rb.attribution.query_parameters_to_remove", "");
        zzpa.zzac = zzkf0.zzf("measurement.rb.attribution.uri_scheme", "https");
        zzpa.zzad = zzkf0.zzc("measurement.sdk.attribution.cache.ttl", 604800000L);
        zzpa.zzae = zzkf0.zzc("measurement.redaction.app_instance_id.ttl", 7200000L);
        zzpa.zzaf = zzkf0.zzc("measurement.upload.backoff_period", 43200000L);
        zzpa.zzag = zzkf0.zzc("measurement.upload.initial_upload_delay_time", 15000L);
        zzpa.zzah = zzkf0.zzc("measurement.upload.interval", 3600000L);
        zzpa.zzai = zzkf0.zzc("measurement.upload.max_bundle_size", 0x10000L);
        zzpa.zzaj = zzkf0.zzc("measurement.upload.max_bundles", 100L);
        zzpa.zzak = zzkf0.zzc("measurement.upload.max_conversions_per_day", 500L);
        zzpa.zzal = zzkf0.zzc("measurement.upload.max_error_events_per_day", 1000L);
        zzpa.zzam = zzkf0.zzc("measurement.upload.max_events_per_bundle", 1000L);
        zzpa.zzan = zzkf0.zzc("measurement.upload.max_events_per_day", 100000L);
        zzpa.zzao = zzkf0.zzc("measurement.upload.max_public_events_per_day", 50000L);
        zzpa.zzap = zzkf0.zzc("measurement.upload.max_queue_time", 518400000L);
        zzpa.zzaq = zzkf0.zzc("measurement.upload.max_realtime_events_per_day", 10L);
        zzpa.zzar = zzkf0.zzc("measurement.upload.max_batch_size", 0x10000L);
        zzpa.zzas = zzkf0.zzc("measurement.upload.retry_count", 6L);
        zzpa.zzat = zzkf0.zzc("measurement.upload.retry_time", 1800000L);
        zzpa.zzau = zzkf0.zzf("measurement.upload.url", "https://app-measurement.com/a");
        zzpa.zzav = zzkf0.zzc("measurement.upload.window_interval", 3600000L);
        zzpa.zzaw = zzkf0.zzf("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot");
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzA() {
        return (long)(((Long)zzpa.zzA.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzB() {
        return (long)(((Long)zzpa.zzB.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final boolean zzC() {
        return ((Boolean)zzpa.zzC.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzD() {
        return (String)zzpa.zzD.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzE() {
        return (long)(((Long)zzpa.zzE.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzF() {
        return (long)(((Long)zzpa.zzF.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzG() {
        return (long)(((Long)zzpa.zzG.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzH() {
        return (long)(((Long)zzpa.zzH.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzI() {
        return (long)(((Long)zzpa.zzI.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzJ() {
        return (long)(((Long)zzpa.zzJ.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzK() {
        return (long)(((Long)zzpa.zzK.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzL() {
        return (long)(((Long)zzpa.zzL.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzM() {
        return (String)zzpa.zzM.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzN() {
        return (String)zzpa.zzN.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzO() {
        return (long)(((Long)zzpa.zzO.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzP() {
        return (long)(((Long)zzpa.zzP.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzQ() {
        return (long)(((Long)zzpa.zzQ.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzR() {
        return (long)(((Long)zzpa.zzR.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzS() {
        return (long)(((Long)zzpa.zzS.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzT() {
        return (long)(((Long)zzpa.zzT.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzU() {
        return (long)(((Long)zzpa.zzU.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzV() {
        return (long)(((Long)zzpa.zzV.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzW() {
        return (long)(((Long)zzpa.zzW.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzX() {
        return (long)(((Long)zzpa.zzX.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzY() {
        return (String)zzpa.zzY.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzZ() {
        return (long)(((Long)zzpa.zzZ.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zza() {
        return (long)(((Long)zzpa.zza.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzaa() {
        return (String)zzpa.zzaa.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzab() {
        return (String)zzpa.zzab.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzac() {
        return (String)zzpa.zzac.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzad() {
        return (long)(((Long)zzpa.zzad.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzae() {
        return (long)(((Long)zzpa.zzae.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzaf() {
        return (long)(((Long)zzpa.zzaf.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzag() {
        return (long)(((Long)zzpa.zzag.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzah() {
        return (long)(((Long)zzpa.zzah.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzai() {
        return (long)(((Long)zzpa.zzai.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzaj() {
        return (long)(((Long)zzpa.zzaj.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzak() {
        return (long)(((Long)zzpa.zzak.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzal() {
        return (long)(((Long)zzpa.zzal.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzam() {
        return (long)(((Long)zzpa.zzam.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzan() {
        return (long)(((Long)zzpa.zzan.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzao() {
        return (long)(((Long)zzpa.zzao.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzap() {
        return (long)(((Long)zzpa.zzap.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzaq() {
        return (long)(((Long)zzpa.zzaq.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzar() {
        return (long)(((Long)zzpa.zzar.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzas() {
        return (long)(((Long)zzpa.zzas.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzat() {
        return (long)(((Long)zzpa.zzat.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzau() {
        return (String)zzpa.zzau.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzav() {
        return (long)(((Long)zzpa.zzav.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzaw() {
        return (String)zzpa.zzaw.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzb() {
        return (long)(((Long)zzpa.zzb.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final boolean zzc() {
        return ((Boolean)zzpa.zzc.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzd() {
        return (long)(((Long)zzpa.zzd.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zze() {
        return (String)zzpa.zze.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzf() {
        return (long)(((Long)zzpa.zzf.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzg() {
        return (String)zzpa.zzg.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzh() {
        return (String)zzpa.zzh.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzi() {
        return (long)(((Long)zzpa.zzi.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzj() {
        return (long)(((Long)zzpa.zzj.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzk() {
        return (String)zzpa.zzk.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzl() {
        return (String)zzpa.zzl.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzm() {
        return (long)(((Long)zzpa.zzm.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final String zzn() {
        return (String)zzpa.zzn.zzd();
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzo() {
        return (long)(((Long)zzpa.zzo.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzp() {
        return (long)(((Long)zzpa.zzp.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzq() {
        return (long)(((Long)zzpa.zzq.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzr() {
        return (long)(((Long)zzpa.zzr.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzs() {
        return (long)(((Long)zzpa.zzs.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzt() {
        return (long)(((Long)zzpa.zzt.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzu() {
        return (long)(((Long)zzpa.zzu.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzv() {
        return (long)(((Long)zzpa.zzv.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzw() {
        return (long)(((Long)zzpa.zzw.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzx() {
        return (long)(((Long)zzpa.zzx.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzy() {
        return (long)(((Long)zzpa.zzy.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzoz
    public final long zzz() {
        return (long)(((Long)zzpa.zzz.zzd()));
    }
}

