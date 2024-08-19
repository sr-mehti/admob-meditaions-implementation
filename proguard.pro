
-keep class com.google.android.gms.ads.** { *; }
-keep class com.google.ads.** { *; }

-keep class com.bytedance.sdk.** { *; }
-keepclassmembers class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
-keep class com.ironsource.unity.androidbridge.** { *;}
-keep class com.google.android.gms.ads.** {public *;}
-keep class com.google.android.gms.appset.** { *; }
-keep class com.google.android.gms.tasks.** { *; }
-keep class com.ironsource.adapters.** { *; }
-dontwarn com.ironsource.**
-dontwarn com.ironsource.adapters.**
-keepclassmembers class com.ironsource.** { public *; }
-keep public class com.ironsource.**
-keep class com.ironsource.adapters.** { *;}
-keepclassmembers class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
-keep class com.google.android.gms.ads.** {public *;}
-keep class com.google.android.gms.appset.** { *; }
-keep class com.google.android.gms.tasks.** { *; }
-keep class com.ironsource.adapters.** { *; }
-dontwarn com.ironsource.**
-dontwarn com.ironsource.adapters.**
-keepclassmembers class com.ironsource.** { public *; }
-keep public class com.ironsource.**
-keep class com.ironsource.adapters.** { *;}
-dontwarn com.iab.omid.**
-keep class com.iab.omid.** {*;}
-keepattributes JavascriptInterface
-keepclassmembers class * { @android.webkit.JavascriptInterface <methods>; }
-keep class com.amazon.device.ads.DtbThreadService {
    static *;
}
-keep public interface com.amazon.device.ads** {*; }
-keepclassmembers class com.applovin.sdk.AppLovinSdk {
    static *;
}
-keep public interface com.applovin.sdk** {*; }
-keep public interface com.applovin.adview** {*; }
-keep public interface com.applovin.mediation** {*; }
-keep public interface com.applovin.communicator** {*; }
-keep public interface com.bytedance.sdk.openadsdk** {*; }
-keepclassmembers class com.facebook.ads.internal.AdSdkVersion {
    static *;
}
-keepclassmembers class com.facebook.ads.internal.settings.AdSdkVersion {
    static *;
 }
-keepclassmembers class com.facebook.ads.BuildConfig {
    static *;
 }
-keep public interface com.facebook.ads** {*; }
-keep public interface com.fyber.fairbid.ads.interstitial** {*; }
-keep public interface com.fyber.fairbid.ads.rewarded** {*; }
-keep class com.fyber.offerwall.*
-keep public interface com.five_corp.ad** {*; }
-keep public interface com.fyber.inneractive.sdk.external** {*; }
-keep public interface com.fyber.inneractive.sdk.activities** {*; }
-keep public interface com.fyber.inneractive.sdk.ui** {*; }
-keepclassmembers class com.hyprmx.android.sdk.utility.HyprMXProperties {
    static *;
}
-keepclassmembers class com.hyprmx.android.BuildConfig {
    static *;
}
-keep public interface com.hyprmx.android.sdk.activity** {*; }
-keep public interface com.hyprmx.android.sdk.graphics** {*; }
-keep class com.inmobi.*
-keep public interface com.inmobi.ads.listeners** {*; }
-keep public interface com.inmobi.ads.InMobiInterstitial** {*; }
-keep public interface com.inmobi.ads.InMobiBanner** {*; }
-keep public interface com.ironsource.mediationsdk.sdk** {*; }
-keep public interface com.ironsource.mediationsdk.impressionData.ImpressionDataListener {*; }
-keep public interface jp.maio.sdk.android.MaioAdsListenerInterface {*; }
-keep public interface com.mbridge.msdk.out** {*; }
-keep public interface com.mbridge.msdk.videocommon.listener** {*; }
-keep public interface com.mbridge.msdk.interstitialvideo.out** {*; }
-keep public interface com.mintegral.msdk.out** {*; }
-keep public interface com.mintegral.msdk.videocommon.listener** {*; }
-keep public interface com.mintegral.msdk.interstitialvideo.out** {*; }
-keep class com.my.target.** {*;}
-keep public interface io.presage.interstitial** {*; }
-keep public interface io.presage.interstitial.PresageInterstitialCallback {*; }
-keep public interface net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd** {*; }
-keep public interface net.pubnative.lite.sdk.rewarded.HyBidRewardedAd** {*; }
-keep public interface net.pubnative.lite.sdk.views.HyBidAdView** {*; }
-keep public interface com.smaato.sdk.interstitial** {*; }
-keep public interface com.smaato.sdk.video.vast** {*; }
-keep public interface com.smaato.sdk.banner.widget** {*; }
-keep public interface com.smaato.sdk.core.util** {*; }
-keep public interface com.tapjoy.** {*; }
-keep public interface com.qq.e.ads.interstitial2** {*; }
-keep public interface com.qq.e.ads.interstitial3** {*; }
-keep public interface com.qq.e.ads.rewardvideo** {*; }
-keep public interface com.qq.e.ads.rewardvideo2** {*; }
-keep public interface com.qq.e.ads.banner2** {*; }
-keep public interface com.qq.e.comm.adevent** {*; }
-keepclassmembers class com.verizon.ads.edition.BuildConfig {
    static *;
}
-keep public interface com.verizon.ads.interstitialplacement** {*; }
-keep public interface com.verizon.ads.inlineplacement** {*; }
-keep public interface com.verizon.ads.vastcontroller** {*; }
-keep public interface com.verizon.ads.webcontroller** {*; }
-keep public interface com.vungle.warren.PlayAdCallback {*; }
-keep public interface com.vungle.warren.ui.contract** {*; }
-keep public interface com.vungle.warren.ui.view** {*; }
