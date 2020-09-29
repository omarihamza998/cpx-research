# CPX Research Android SDK

[Introduction to what CPX Research is.]

[Learn more.](https://cpx-research.com/)

# Table of Contents

* Prerequisites
* Complete Guide
* Overlay Banner
* Expert Mode

# Prerequisites

* Android 14+

# Complete Guide

## 1. Register as a Publisher

Register as a publisher at [CPX Research](https://publisher.cpx-research.com/), and retrieve your app id.

## 2. Integrate CPX Research SDK to your Project

### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

### Step 2. Add CPX Research dependency

```gradle
	dependencies {
		implementation 'com.github.User:Repo:Tag'
	}
```

## 3. Add internet permission to Manifest.xml

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## 4. Initialize CPX-Research SDK in your Activity

### Step 1. Create CPX Settings using CPXSettingsBuilder

You must provide the app id and the user id using this builder. 

* Kotlin

```kotlin
	val cpxSettings = CPXSettingsBuilder("YOUR_APP_ID", "YOUR_USER_ID")
             /* SDK Customization (See Table .1) */
            .build()
```

* Java

```java
	CPXSettings cpxSettings = new CPXSettingsBuilder("YOUR_APP_ID", "YOUR_USER_ID").build();
```

And you will also be able to provide other customization parameters using different methods (see the table below for all customization options).

Table .1 Optional Customization Options

 \# | Method | Description | Default Value
 ---|--------|------------ | -------------
  1 | setEmail(String) | Set the user email | empty
  2 | setUsername(String) | Set the username | empty
  3 | setSubId1(String) | Set the sub id 1 | empty
  4 | setSubId2(String) | Set the sub id 2 | empty
  8 | setSecureHash(String) | Add the secure hash to the requests to CPX-Research | empty
  5 | setExtraInfo1(String) | Add extra info (You can add up to 10 extra info using 10 different methods e.g. setExtraInfo2(String) ... setExtraInfo10(String) | empty
  6 | setOverlayBannerBackgroundColor("#000000") | Set the background color of the banner that is displayed at the bottom of the activity | #1565c0
  7 | setOverlayBannerTextColor("#FFFFFF") | Set the banner text color | #ffffff
  9 | setWebViewTextColor("#TEXT_COLOR") | Set the text color inside the WebView | Retrieved from CPX Research
  10 | setWebViewTopBarBackgroundColor("#TOP_BAR_COLOR") | Toolbar - Topbar color inside the WebView| Retrieved from CPX Research
  11 | setWebViewBoxBackgroundColor("#BOX_BACKGROUND_COLOR") | Box - Card Background Color| Retrieved from CPX Research
  12 | setWebViewStarsFilledColor("#STARS_FILLED_COLOR") | Rating stars fill color| Retrieved from CPX Research
  13 | setWebViewActivityRequestCode(Int) | If you want to get a listener that the WebView Activity is closed, provide the request id using this method, and override onActivityResult method in your activity. | empty
  
 #### Complete Customization Example:
 
 * Kotlin:
 
 ```kotlin
 val cpxSettings = CPXSettingsBuilder("APP_ID", "USER_ID")
            .setEmail("user@mail.com")
            .setUsername("username")
            .setExtraInfo1("Extra Info 1")
            .setExtraInfo2("Extra Info 2")
            .setOverlayBannerBackgroundColor("#000000")
            .setOverlayBannerTextColor("#FFFFFF")
            .setSecureHash("SECURE_HASH")
            .setSubId1("SUB_ID_1")
            .setWebViewTextColor("#TEXT_COLOR")
            .setWebViewTopBarBackgroundColor("#TOP_BAR_COLOR")
            .setWebViewBoxBackgroundColor("#BOX_BACKGROUND_COLOR")
            .setWebViewStarsFilledColor("#STARS_FILLED_COLOR")
            .setWebViewActivityRequestCode(100)
            .build()
 ```
 
 * Java:
 
 ```java
 
 CPXSettings cpxSettings = new CPXSettingsBuilder("APP_ID", "USER_ID")
                .setEmail("user@mail.com")
                .setUsername("username")
                .setExtraInfo1("Extra Info 1")
                .setExtraInfo2("Extra Info 2")
                .setOverlayBannerBackgroundColor("#000000")
                .setOverlayBannerTextColor("#FFFFFF")
                .setSecureHash("SECURE_HASH")
                .setSubId1("SUB_ID_1")
                .setWebViewTextColor("#TEXT_COLOR")
                .setWebViewTopBarBackgroundColor("#TOP_BAR_COLOR")
                .setWebViewBoxBackgroundColor("#BOX_BACKGROUND_COLOR")
                .setWebViewStarsFilledColor("#STARS_FILLED_COLOR")
                .setWebViewActivityRequestCode(100)
                .build();
		
```

```java
 @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            /* DO SOMETHING */
        }
    }
 ```
 
 ### Step 2. Initiate the SDK
 
 Inside your activity's onResume add the following line of code:
 
 * Kotlin: 
 
 ```kotlin
   override fun onResume() {
        super.onResume()

        val cpxSettings = CPXSettingsBuilder("APP_ID", "USER_ID")
            /* CUSTOMIZATION */
            .build()

        cpxResearch = CPXResearch.init(this, cpxSettings)
    }
 ```
 
 * Java:
 
 ```java
    @Override
    protected void onResume() {
        super.onResume();

        CPXSettings cpxSettings = new CPXSettingsBuilder("APP_ID", "USER_ID")
                /* CUSTOMIZATION */
                .build();

        cpxResearch = CPXResearch.Companion.init(this, cpxSettings);
    }
 ```
  
 ## Overlay Banner
 
 ### Step 1
 To display the banner at the bottom of your activity, you need to the following line in your activity's onResume:
 
 ```kotlin
   override fun onResume() {
        super.onResume()
        
        /* ... */
        
        cpxResearch.enableBanner(TimeUnit.MINUTES.toMillis(2))
    }
 ```
 
 The SDK regularly checks to see if there are any available surveys, you can specify the check period by passing the desired value to the enableBanner(duration) method.
 
 In the previous example, the SDK will check for available surveys every 2 minutes.
 
 Important: if there are no available surveys, the banner will not get displayed.
 
 ### Step 2
 Add this line of code to you activity's onPause:
 
```kotlin
    override fun onPause() {
        super.onPause()
        cpxResearch.disableBanner()
    }
```
 
 ## Expert Mode
 
 ### Get Available Surveys
 
 You can fetch all the available surveys using this method:
 
 * Kotlin
 ```kotlin
 	cpxResearch.getAvailableSurveys(object : OnCPXResponseListener<List<CPXSurvey>> {
            override fun onSuccess(data: List<CPXSurvey>?) {
                if (data?.isEmpty() == true) {
                    Toast.makeText(
                        this@MainActivity,
                        "There're no available surveys",
                        Toast.LENGTH_LONG
                    ).show()
                    return
                }

                /* Do something with the data (e.g. pass the surveys to your Surveys RecyclerView Adapter) */
            }

            override fun onError(message: String) {
              
            }

        })
 ```
 
 * Java
 ```java
      cpxResearch.getAvailableSurveys(new OnCPXResponseListener<List<CPXSurvey>>() {
         @Override
         public void onSuccess(@org.jetbrains.annotations.Nullable List<CPXSurvey> data) {
                
         }

         @Override
         public void onError(@NotNull String message) {

         }
      });
 ```
 
 ### Get Text Information
 
 The CPXTextInformation class has the following fields:
 
 Field Name | Example 
 ---------- | -----------
 currencyNameSingular | Coin
 currencyNamePlural | Coins
 shortcutMin | Min
 headlineGeneral | New Surveys available for you! <br> Click here to see! (Banner Text)
 headline1Element1 | New survey available
 headline1Element2 | Earn now [payout_rate] [currency_name] in [min_time] Minutes!
 headline2Element1 | Earn now [payout_rate] [currency_name] in [min_time] Minutes!
 reload1Text | Do not show this messe for next 3 hours
 reload1Time | 10800
 reload2Text | Do not show this messe for next 4 weeks
 reload2Time | 2419200
 reload3Text | Do not show this messe for next 3 months
 reload3Time | 7776000
 
 To fetch these values, call the following method on your CPX Research instance:
 
 * Kotlin
 
 ```kotlin
 	cpxResearch.getCPXTextInformation(object : OnCPXResponseListener<CPXTextInformation>{
            override fun onSuccess(data: CPXTextInformation?) {

            }

            override fun onError(message: String) {

            }

        })
 ```
 
 * Java
 
 ```java
 	cpxResearch.getCPXTextInformation(new OnCPXResponseListener<CPXTextInformation>() {
            @Override
            public void onSuccess(@org.jetbrains.annotations.Nullable CPXTextInformation data) {
        
            }

            @Override
            public void onError(@NotNull String message) {

            }
        });
 ```
 
 ### Check if the banner is visible
 
 
 ```kotlin
    cpxResearch.isBannerVisible()
 ```

 
 ### Check for New Surveys
 
 You can manually tell the SDK to check if there are new surveys using this method:
 
 ```kotlin
    cpxResearch.checkForNewSurveys(
 ```
 
 ### Open Surveys Wall WebView
 
 To open the Surveys Wall (The WebView that displayed all the surveys), call the following method:
 
 ```kotlin
    cpxResearch.openSurveyWall()
 ```
 
 ### Open the WebView for a Survey
 
 To start a survey use this method:
 
 ```kotlin
    cpxResearch.openSurvey("SURVEY_ID")
 ```
 
 The survey id is fetched using getAvailableSurveys method.
 
 ### Add Transaction Listener
 
 [add description]
 
 * Kotlin
 
 ``` kotlin
 	cpxResearch.addOnTransactionListener { cpxTransaction ->
                Toast.makeText(this, "New Transaction", Toast.LENGTH_LONG).show()
                Log.e("CPX_TRANSACTION", cpxTransaction.toString())
            }
```
* Java 8-

```java
	cpxResearch.addOnTransactionListener(new Function1<CPXTransaction, Unit>() {
            @Override
            public Unit invoke(CPXTransaction cpxTransaction) {
                return null;
            }
        });
```
* Java 8

```java
       cpxResearch.addOnTransactionListener(cpxTransaction -> {
            /* DO SOMETHING */
            return null;
        });
```
 
