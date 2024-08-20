private fun loadRewardInterstitial() {
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
    val rewardInterstitialAdUnit = AppPreferences.rew
    val request = AdManagerAdRequest.Builder()
        .addNetworkExtrasBundle(VungleInterstitialAdapter::class.java,vungleExtras)
        .build()

    RewardedInterstitialAd.load(
        this,
        rewardInterstitialAdUnit,
        request,
        object : RewardedInterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                   
                }

                override fun onAdLoaded(rewardInterstitialAd: RewardedInterstitialAd) {
                    mRewardInterstitialAd = rewardInterstitialAd
                    mRewardInterstitialAd?.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdClicked() {

                            }

                            override fun onAdDismissedFullScreenContent() {
                               
                                mRewardInterstitialAd = null

                            }

                            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                mRewardInterstitialAd = null
                            }

                            override fun onAdImpression() {
                                
                            }

                            override fun onAdShowedFullScreenContent() {
                            
                            }
                        }
                    //show()
                }
            })
}
