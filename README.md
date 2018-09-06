# sample-android


This is Sample Application to demonstrate how to use Tripod android library .

Tripod is an Innovative product that will help developers, testers, managers and companies to build quality apps productively.

Features available in Tripod:

Shake to Report : 
Reporting an issue has never been so convenient as shaking a device.

Video Recording:
Express yourself beyond pictures with our “state of the art” video recording feature to report an issue.

Crash Reporting:
Never again miss a crash occurred on all your user’s devices.

Live Engineering
Astounding Experience while Securely managing your internal app data.

SQLite Manager
Access SQLite tables & records from mobile secure storage productively at runtime

File Manager
Create, View, Delete and Modify the internal App files flexibly on the fly.

Defect management Integration
Go out of box and efficiently manage your defects with JIRA!


Using Tripod artifactory in Android Application:

Step 1 : Add Tripod artifactory repository to the list of Maven repositories in your top level build.gradle file as shown below:

allprojects {
    repositories {
        maven { url "http://backend.gettripod.com:8081/artifactory/libs-release-local" }
    }
}

Step 2 : Add the artifact as a dependency in the build.gradle file of main project:

dependencies {
    implementation(group: 'com.gendevs.tripod', name: 'TripodLibrary', version: '1.0', ext: 'aar')
}



