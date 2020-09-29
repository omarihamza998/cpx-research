# CPX Research Android SDK

[Introduction to what CPX Research is.]

[Learn more.](https://cpx-research.com/)


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
  
 ## Easy Integration
 
 
 ## Expert Mode
