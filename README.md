# Project Title

Tech Challenge

User should be able to design the acceptance criteria for ToDo list

## Prerequisites

```bash
  1. Need to install jdk 1.8 or latest jdk version
  2. Framework: TestNG 
  3. IDE: Intelliji or Eclipse
```
## Steps to deploy the project into github

To deploy this follow the below steps

```bash
Navigate to the project folder and perform the steps below 

git init
git add README.md
git commit -m "CTS tech challenge"
git branch -M main
git remote add origin https://github.com/Siva-Venkatesh/CTS_Tech_Challenge
git push -u origin main

sivavenkatesh@Sivas-MacBook-Pro CTSTechChallenge % git push -f origin main  
Enumerating objects: 252, done.
Counting objects: 100% (252/252), done.
Delta compression using up to 12 threads
Compressing objects: 100% (230/230), done.
Writing objects: 100% (252/252), 16.95 MiB | 413.00 KiB/s, done.
Total 252 (delta 52), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (52/52), done.
To https://github.com/Siva-Venkatesh/CTS_Tech_Challenge.git
 + 87d1ce8...9889aa6 main -> main (forced update)

```

## Requirement

```bash
  1. User Story: As a user, I should be able to manage my todos effectively.

  2. Application Under Test : https://todomvc.com/examples/react/dist/

  3. Acceptance Criteria (AC): User is required to design acceptance criteria appropriate for the given user story and its scope.

  4. The following accepatance criteria have been added based on the above requirement
     - Added ToDo list and validate
     - Toggle Todo list
     - Deleted few todo from the list and verified the left items counts
     - Toggle ToDo from the All link text and matched the counts
     - Cleared completed ToDo list
     - Filtered from the ToDo list 
```
## Installation

Install CTS Tech challenge project from the below path

```bash
1. Clone this repository to your local machine.
        git clone https://github.com/Siva-Venkatesh/CTS_Tech_Challenge

2. Navigate to the project directory using the command line.

3. Install the dependencies and run the test
        mvn clean test
```
    
## Running Tests

To run tests, run the following command

```bash
- Navigate to the project directory using command line.

- Run the following command but replace <test_case> with the name of the test case.
mvn test -Dtest=<test_case>

- allure open

- allure generate

```

## Screenshots

![CTS_tech_challenge_report](https://github.com/user-attachments/assets/de3d0595-59b5-4abd-90c0-1a9367595f7d)

CTS_tech_challenge_report
