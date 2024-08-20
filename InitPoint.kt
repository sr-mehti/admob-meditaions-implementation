private fun initAds(){
        setupMeditaions()
        val androidId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        val deviceId = md5(androidId).uppercase(Locale.ROOT)
        val testDeviceIds = listOf(deviceId)
        val configuration = RequestConfiguration.Builder()
            .setTestDeviceIds(testDeviceIds)
            .build()
        MobileAds.setRequestConfiguration(configuration)
        MobileAds.initialize(this) { initializationStatus ->
            val statusMap = initializationStatus.adapterStatusMap
            for (adapterClass in statusMap.keys) {
                val status = statusMap[adapterClass]
                Log.d("Adymob Init", String.format("Adapter name: %s, Description: %s, Latency: %d",adapterClass, status!!.description, status.latency))
            }
            //Do Your Works
        }
    }

    private fun setupMeditaions() {
        try{
            var sdk = MBridgeSDKFactory.getMBridgeSDK()
            sdk.setConsentStatus(appContext, MBridgeConstans.IS_SWITCH_ON)
            var mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK()
            mBridgeSDK.setDoNotTrackStatus(false)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
