#### Hi!👋 I'm Mami!🙂 I am a QA Automation Test Engineer.

#### Software  Tester Assignment:
- This project was created as part of the assignment for the Cloudwise Company.

#### Run Locally:
- Install dependencies by opening the project and installing the dependencies. (Maven will handle this for you.)
- To run this project, go to the feature file and click the 'Run' Icon button.
- Due to multiple thread issues with the web driver configuration, parallel test execution is not available for now.
- Please use this option until the issue with the driver thread is resolved.
- You may also alter your setup settings, such as browser options, url, flash and draw elements, and page titles, through the configuration.properties file. 
- https://github.com/makcal1/Cloudwise-B.V./blob/main/src/test/resources/configuration/configuration.properties
- Clone the project
```bash
  git clone https://github.com/makcal1/Cloudwise-B.V.
```
#### Go to the project directory;

```bash
  cd my-project
```
- Please use Intelij's Gherking Plugins to execute tests from feature files.
- (Settings->Plugins) -> Gherking, Cucumber for Java 
- Verify that you have Java, Maven, and Google Chrome installed.
- Launch the project by double-clicking the icon file under the feature files ( Ideally Usage IDE: Intelij)


#### Java Environment Variables For Windows;
- Download or save the JDK version for Windows
- Right-click the Computer icon on your desktop and select Properties.
- Click Advanced system settings.
- Click Environment variables.
- Under User variables, click New.
- Enter JAVA_HOME as the variable name.
- Enter the path to the JDK as the variable value.

#### Java Environment Variables For Mac;
- Open terminal window. ...
- Type command: $ vim ~/.bash_profile and Hit Enter. ...
- Type command: $ export JAVA_HOME=$(/usr/libexec/java_home) and press Escape key for Save changes. ...
- Type command: :(colon)wq, It will Save and close .

#### How to add Maven to the Path variable?

#### Maven Environment Variables For Windows;
- Right click on my computer.
- Properties.
- Advanced System Setting.
- Environment Variable.
- New user variable and added Maven_Home with value C:\apache-maven-3.5. ...
- Add it to path variable with: %Maven_Home%\bin.
- Open cmd and ask for mvn -version in desktop.

#### Maven Environment Variables For Mac
- https://www.journaldev.com/2348/install-maven-mac-os


## Reports:
- After the text has been processed, the test report will be available. The report can be seen using the link mentioned at the bottom of the 'Run' Section.

## Feedback:
- If you have any feedback, please reach out to me muhammedzahidakcal@gmail.com 



