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

### Step 1. Create a CPXResearchSettingsBuilder

You must provide the app id and the user id using this builder. And you will also be able to provide other customization parameters using different methods (see the table [1. Customization Options Table] below for all customization options).

