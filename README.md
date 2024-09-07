# APPIUM QA AUTOMATION

This repository is for setting up an Appium automation environment to run tests on an iOS or Android simulator. 

# HIGH LEVEL PROCESS OVERVIEW

	Video for Local iOS process: https://www.loom.com/share/ff28152f6ba84d2f80a71cec289a03b5

	Video for local Android process: https://loom.com/share/f06535ff32604200acf0943264143983

	Video to debug & inspect elements: https://loom.com/share/2078bb8a37f64efbaf4db55890efebaa

	1. Build a .ipa file for "Running" via xCode

		Or build a .apk file with the instructions below

	2. Store the file in the Redi-QA project root
	3. Open and Run an Appium Server (Terminal or Appium Server GUI)
	4. Open IntelliJ
	5. Go to the Redi-QA project
	6. Open the iOS or Android project

	7. For iOS go to:

		a. Start the Appium WebDriverAgent on the simulator
		b. Go to the project: Application/Appium Server GUI/Contents/Resources/app/node_modules/appium/node_modules/appium-webdriveragent
		c. Open WebDriverAgent.xcodeproject
		d. Build the project for testing
		e. This will add the webDriverAgent to the iOS simulator

	8. For Android 

		a. Open Android Studio
		b. Open a device simulator

	9. Go back to IntelliJ
	10. Run the project

		a. The App will build onto the simulator and start running.

# REQUIREMENTS

	Full testing setup instructions are at: projectSetup/mobile_automation_environment__setup.docx
	
	1. JDK
	2. IntelliJ or Eclipse
	3. Maven
	4. xCode
	5. Android Studio 
	6. iOS Developer Signing Keys/Certificates
	7. Chrome Driver 
	8. Appium Server
	9. Appium Inspector (Optional)

# ANDROID - BUILD THE LATEST .apk FILE

	1. Pull the latest from GIT 
	2. In the Terminal: Go to documents/Redi-Android
	3. Then run: export ANDROID_HOME=/Users/jeremycallahan/Library/Android/sdk
	4. Then run: ./gradlew clean
	5. Then run: ./gradlew assembleProductionServerDebug
	6: Go get the APK at: ./app/build/outputs/apk/productionServer/debug/app-productionServer-debug.apk
	7. Drop the APK into documents/Redi-QA

# iOS - BUILD THE LATEST .ipa FILE

	For Testing (.app file)

	1. Pull the latest from GIT
	2. Open the Redi/Sharpen project in Xcode
	3. Build the project for "Running"
	4. Go to the build folder and find the .ipa file: In Xcode go to Product/Show Build Folder in Finder
	5. Drop the IPA into documents/Redi-QA

	For AWS (.ipa file)

	1. In Xcode go to Product -> Archive
	2. This will open an Archives window
	3. Select the App and click the "Distribute App" button
	4. Select "Development" and Next
	5. Select Next
	6. Automatically manage signing -> Next
	7. Select "Export" and save the file locally


# ASW DEVICE FARM

	Video for setup in iOS: https://loom.com/share/84df71e99bdd40679994fe5a11114a34

	Video for setup in Android: https://loom.com/share/27a94e72d6ab435084f4ec5ceb54e3fd

	1.	Open iOSBase.java or AndroidBase.java and comment out the platform, device and app capabilities. Within these files you will see comments on what to comment out.

	2. In the Redi-QA directory run this command: mvn clean package -DskipTests=true

	3. This will create a folder named "target"

	4. In that folder is a .zip file which is needed for AWS Device Lab

	5. Go to ASW 

	6. Select AFE-Redi-NonProd Management Console

	7. Go to the Device Farm

	8. Select either: Android Automations for Sharpen or iOS Automations for Sharpen

	9. Select Create a new run

	10. Upload or select a file (.apk or .ipa)

	11. Give the Run a name and hit Next

	12. Select Appium Java TestNG as the Setup test framework

	13. Upload the .zip file you created in step 3

	14. After the upload completes select: Run your test in a custom environment

	15. Hit Next and select the device to run your test on

	16. Hit Next and review your test package

	17. Change the Set execution timeout to "11"

	18. Scroll to the bottom and hit "Confirm and start run"

	19. Wait for test results. Once completed you can drill in to watch videos, see log files, errors, etc.

	NOTE: add these instructions to: https://mcgrawhill.atlassian.net/wiki/spaces/REDI/pages/472514842/Guide+Test+Builds+Manually+on+Android+Devices

	Helpful AWS Device Farm Setup Documenation:

		https://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-appium.html#test-types-appium-prepare
	
		https://github.com/aws-samples/aws-device-farm-sample-app-for-android

		https://github.com/aws-samples/aws-device-farm-sample-app-for-ios

# AWS DEVICE FARM - MANUAL TESTING ON SINGLE DEVICES

	1. Go to ASW 

	2. Select AFE-Redi-NonProd Management Console

	3. Go to the Device Farm

	4. Select either: Android Automations for Sharpen or iOS Automations for Sharpen

	5. Select "Remote Access"

	6. Select "Start a new session"

	7. Search/Choose the device you'd like to use

	8. Start the session

	9. On the right hand side (down the page) you can either select an existing .APK or upload a new .APK 

# AWS CODE PIPELINE

	In Progress Work - 12/8/22

	1. Upon changes submitted to: https://github.mheducation.com/Redi/Redi-automations-pipeline-ios

	2. AWS CodePipeline Kicks off

	3. Full automation test runs on AWS Device Farm

	See the following AWS documentation below:

		https://docs.aws.amazon.com/codepipeline/latest/userguide/tutorials-codebuild-devicefarm-S3.html

		https://docs.aws.amazon.com/codepipeline/latest/userguide/tutorials-codebuild-devicefarm.html

		https://docs.aws.amazon.com/codepipeline/latest/userguide/tutorials-codebuild-devicefarm-S3.html

		https://docs.aws.amazon.com/devicefarm/latest/developerguide/api-ref.html

		https://github.com/realm/aws-devicefarm#example-with-remote-sources-inline-test-specification-and-artifact-pulling

# HELPFUL PROJECT SETUP VIDEOS

	Process video Jeremy ran for the McGraw Hill developement team:

		https://mcgrawhill.zoom.us/rec/share/lmNxRCv-vy6us0rldASsSFccgzoncFpH-Cn5PU8_a3JcIFaEysm-TH8tlL62yw.jlgBOBKO4-6YGCvr 

		Passcode: B+Cx6tqD

	Setting Up Appium Locally:

	https://www.youtube.com/playlist?list=PLhW3qG5bs-L8npSSZD6aWdYFQ96OEduhk

	https://www.youtube.com/watch?v=BEF-d1xjV4Q&list=PLhW3qG5bs-L8npSSZD6aWdYFQ96OEduhk&index=6



