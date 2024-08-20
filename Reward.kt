class MainActivity : AppCompatActivity() {
  private var rewardedAd: RewardedAd? = null
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    IronSource.setConsent(true)
    IronSource.setMetaData("do_not_sell", "true")
    val unityMetaData = MetaData(this)
    unityMetaData["gdpr.consent"] = true
    unityMetaData["privacy.consent"] = true
    unityMetaData.commit()
    val dataUseConsentGDPR = GDPR(GDPR.GDPR_CONSENT.NON_BEHAVIORAL)
    Chartboost.addDataUseConsent(this, dataUseConsentGDPR)
    val dataUseConsentCCPA = CCPA(CCPA.CCPA_CONSENT.OPT_IN_SALE)
    Chartboost.addDataUseConsent(this, dataUseConsentCCPA)
    VunglePrivacySettings.setGDPRStatus(true, "v1.0.0")
    VunglePrivacySettings.setCCPAStatus(true)
    InneractiveAdManager.setGdprConsent(true)
    InneractiveAdManager.setGdprConsentString("myGdprConsentString")
    InneractiveAdManager.setUSPrivacyString("myUSPrivacyString")
    val consentObject = JSONObject()
    try {
      consentObject.put(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE, true)
      consentObject.put("gdpr", "1")
    } catch (exception: JSONException) {
      exception.printStackTrace()
    }
    InMobiConsent.updateGDPRConsent(consentObject)
    val sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
    sharedPref.edit().putString("IABUSPrivacy_String", "1---").apply()
    MyTargetPrivacy.setUserConsent(true)
    MyTargetPrivacy.setUserAgeRestricted(false)
    MyTargetPrivacy.setCcpaUserConsent(true)
    AppLovinPrivacySettings.setHasUserConsent(true, this)
    AppLovinPrivacySettings.setIsAgeRestrictedUser(false, this)
    AppLovinPrivacySettings.setDoNotSell(true, this)
    val vungleExtras = Bundle()
    vungleExtras.putString(VungleConstants.KEY_USER_ID, "myUserID")
    vungleExtras.putInt(VungleConstants.KEY_ORIENTATION, 1)
    var fyberExtras = Bundle()
    fyberExtras.putInt(InneractiveMediationDefs.KEY_AGE, 20)
    val lineExtras = LineExtras(true)
    val extrasLine = lineExtras.build()
    val inmobiExtras = Bundle()
    inmobiExtras.putString(InMobiNetworkKeys.AGE_GROUP, InMobiNetworkValues.BETWEEN_18_AND_24)
    val applovinExtras = AppLovinExtras.Builder()
      .setMuteAudio(false)
      .build()
    var adRequest = AdRequest.Builder()
      .addNetworkExtrasBundle(VungleInterstitialAdapter::class.java,vungleExtras)
      .addNetworkExtrasBundle(FyberMediationAdapter::class.java, fyberExtras)
      .addNetworkExtrasBundle(LineMediationAdapter::class.java, extrasLine)
      .addNetworkExtrasBundle(InMobiAdapter::class.java, inmobiExtras)
      .addNetworkExtrasBundle(ApplovinAdapter::class.java, applovinExtras)
      .build()
    RewardedAd.load(this,"ca-app-pub-3940256099942544/5224354917", adRequest, object : RewardedAdLoadCallback() {
      override fun onAdFailedToLoad(adError: LoadAdError) {
        rewardedAd = null
      }
      
      override fun onAdLoaded(ad: RewardedAd) {
        Log.d(TAG, "Ad was loaded.")
        rewardedAd = ad
      }
      
    })
  }
}
