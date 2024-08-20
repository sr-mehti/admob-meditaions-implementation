private inner class AppOpenAdManager {
  // ...
  /** Request an ad. */
  fun loadAd(context: Context) {
    // Do not load ad if there is an unused ad or one is already loading.
    if (isLoadingAd || isAdAvailable()) {
      return
    }

    isLoadingAd = true
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
    val request = AdRequest.Builder()
      .addNetworkExtrasBundle(VungleInterstitialAdapter::class.java,vungleExtras)
      .build()
    AppOpenAd.load(
        context, AD_UNIT_ID, request,
        AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
        object : AppOpenAdLoadCallback() {

          override fun onAdLoaded(ad: AppOpenAd) {
            // Called when an app open ad has loaded.
            Log.d(LOG_TAG, "Ad was loaded.")
            appOpenAd = ad
            isLoadingAd = false
            loadTime = Date().time
          }

          override fun onAdFailedToLoad(loadAdError: LoadAdError) {
            // Called when an app open ad has failed to load.
            Log.d(LOG_TAG, loadAdError.message)
            isLoadingAd = false;
          }
        })
  }
  // ...
}
