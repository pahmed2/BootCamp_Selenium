# Team 2 - Web Automation [![Build Status](https://travis-ci.org/mhasan90/Team2WebAutomation.svg?branch=master)](https://travis-ci.org/mhasan90/Team2WebAutomation)

## Technical Requirements

- Must have:
    + Operating system: Mac / Windows
    + Software platform: Java
        * JDK
    + Java IDE: IntelliJ IDEA
    + Version control: Git
    + Git repository hosting service: GitHub
    + Build tool: Maven
    + Software-testing framework: Selenium
    + Testing framework: TestNG
    + Automation server: Jenkins
    + Cloud testing platform: BrowserStack / Sauce Labs
    + Database: MySQL / MongoDB

## Setup

- Fork the repository
    + To fork the Spoon-Knife repository, click the Fork button in the header of the repository.
    ![alt text](https://image.ibb.co/nE6AGb/Fork_button.png)
    + Sit back and watch the forking magic. When it’s finished, you’ll be taken to your copy of the Spoon-Knife repository.

- Clone your fork
    + On your GitHub account, navigate to the main page of the repository.
    + Under the repository name, click Clone or download.
    ![alt text](https://image.ibb.co/k9iU9w/clone_button.png)
    + In the Clone with HTTPs section, copy the clone URL for the repository.
    + Open Terminal and navigate to your workspace.
    + Type git clone, and then paste the URL you copied.
    `git clone https://github.com/your-username/project-name.git`. This will clone the master branch.
        - To clone a specific github branch: 
        `git clone -b your-branch git@github.com:user/project-name.git`
    + Press Enter. Your local clone will be created.

- Switch to your branch
    + Switch over to the branch `"yourfirstname"` when you want to add new commits to it.
    + You can see all branches created by using:
    `git branch`. 
    The asterisk indicates the current active branch.
    + Use the checkout command to switch branch.
    `git checkout [name_of_your_branch]`
        - To create a new branch, `git checkout -b [name_of_your_branch]`
        - Save any unfinished work before checkout by a commit. Reset the head after you get back.
- After you have done a lot of work on your branch
    + Stage the file(s) for commit to your local repository.
    `git add .`
    + Commit the file(s) that you've staged in your local repository.
    `git commit -m "Add message here"`
    + Push the changes in your local repository to GitHub:
    `git push origin [name_of_your_branch]`
- Making a Pull Request
    + At last, you’re ready to propose changes into the main project!
    + On your GitHub account, navigate to the main page of the repository.
    + In the "Branch" menu, choose the branch that contains your commits.
    ![alt text](https://image.ibb.co/ka6wNG/new_pull_request.png)
    + To the right of the Branch menu, click New pull request.
    Use the base branch dropdown menu to select the branch you'd like to merge your changes into, 
    then use the compare branch drop-down menu to choose the topic branch you made your changes in.
    + Type a title and description for your pull request.
    + Click Create pull request.
    

## Explanations

- `/Amazon`
    + Test cases: includes page object model, page factory.
    + Data driven: reads testdata from xls files, google sheets, mysql tables. 
    + Keyword driven: reads keyworks (feature names) from xls file. 
- `/Cnn`
    + Test cases: includes page object model.
- `/Demo`
    + Demo is a maven module created for demonstration purposes. 
    + In maven, modules are sub-projects.
    + You will be using different Modules to maintain different web-domains.
- `/Generic`
    + Generic module is created to manage all the common settings for all the modules.
- `/Horizon`
    + Test cases: includes page object model, page factory.
- `/MetLife`
    + Test cases: includes page object model. 
- `/RestApi`
    + Test cases: includes REST API testing (status code).
- `/W3Schools`
    + Test cases: includes page object model. 
- `.gitignore`
    + Git uses this file to determine which files and directories to ignore, before you make a commit.
- `.travis.yml`
    + To build and test the project online.
- `README.md`
    + To write all these information here.
- `pom.xml`
    + A Project Object Model or POM is the fundamental unit of work in Maven. 
    + It is an XML file that contains information about the project and configuration details used by Maven to build the project.

## References

* Java API
    - [https://docs.oracle.com/javase/8/docs/api/](https://docs.oracle.com/javase/8/docs/api/)
* Git and GitHub learning resources
    - [https://help.github.com/articles/good-resources-for-learning-git-and-github/](https://help.github.com/articles/good-resources-for-learning-git-and-github/)
* POM Reference
    - [https://maven.apache.org/pom.html](https://maven.apache.org/pom.html)
* Selenium Java API
    - [https://seleniumhq.github.io/selenium/docs/api/java/](https://seleniumhq.github.io/selenium/docs/api/java/)
* TestNG API
    - [https://jitpack.io/com/github/cbeust/testng/master/javadoc/](https://jitpack.io/com/github/cbeust/testng/master/javadoc/)
* Java Quickstart for Google Sheets
    - [https://developers.google.com/sheets/api/quickstart/java](https://developers.google.com/sheets/api/quickstart/java)
* Rest Assured - Getting Started
    - [https://github.com/rest-assured/rest-assured/wiki/GettingStarted](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)