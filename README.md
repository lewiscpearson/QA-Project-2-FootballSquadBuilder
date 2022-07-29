# QA Project 2 - Football Squad Builder

This is my second QA Academy project to design an application that is related to a hobby.

This application allows users to create a football squad, by adding players with their age, nationality, and position. They can then view all players added, update existing players, or even delete them. 

## Getting started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

###

You will need the following downloaded and installed to run the application:
-Java JDK
-Git (Git Bash for example)
-MySQL

Any required dependencies have been included in the pom.xml file.

### Installation

Using Git clone the repository from GitHub to your local machine. The jar file can then be ran from a command line in the folder with `java -jar [jar file name]`.

To run the application the database will have to be created locally, and VS Code Live Server (or alternative) to run the frontend.

### Database
ERD for the Database used with the Application
![ERD Diagram](https://user-images.githubusercontent.com/105277446/181787649-ff273280-b1d9-4f54-b5a5-3033af5ae279.png)
### Backend
UML diagram for the backend.
![UML drawio](https://user-images.githubusercontent.com/105277446/181787671-8194e168-bba4-493e-9da1-daba9a6d4705.png)
### Frontend
Wireframe for the frontend web page.
![wireframe drawio](https://user-images.githubusercontent.com/105277446/181787678-e0d6cfd3-cab1-41c0-a38b-d6b176c12f58.png)

## Testing
Testing was done through JUnit, and a test coverage of 98.2% of the src/main/java path was achieved. Well above the industry standard of >80%. Tests cover all CRUD methods. 

## Usage

Usage of the application is very straightforward, due to the user-friendly frontend UI. Type the player's information into the form and click submit to create a new player card. Do similarly and click the update button on the player's card you wish to update, and click delete to delete that player.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

### Versioning

[Git with GitHub](http://GitHub.com/) was used for version control. The main/dev/feature branch model was used with regular commits to keep track of progress and preserve work in case of data loss.


### Project Management

The project was managed through using a Scrum Board on Jira. User stories were created with tasks and story points assigned.

## Authors
* **Lewis Pearson**  - [lewispearson](https://github.com/LewisPearsonGitHub)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

## Acknowledgements
Thanks to QA, and the trainers Jordan Harrison and Jordan Benbelaid without whom this project would not have been possible.
