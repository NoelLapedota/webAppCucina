Cooking Recipes Web App

Welcome to the Cooking Recipes Web App! This application has been developed using Java and Spring Boot, with a PostgreSQL database managed through Docker.
Features

    Recipe Management: Add, edit, and delete your favorite recipes.
    Advanced Search: Find recipes based on ingredients, categories, or preparation times.
    Intuitive User Interface: User-friendly interface for easy navigation.

System Requirements

Make sure you have the following installed:

    Java
    Spring Boot
    Docker
    [bootstrap](https://getbootstrap.com/(

Database Configuration

The PostgreSQL database is managed through Docker. Run the following command to start the database container:

docker-compose up -d

Application Setup

    Clone the repository:

bash

git@github.com:NoelLapedota/webAppCucina.gitcd recipes-cooking-app

    Run the application:

bash

./mvnw spring-boot:run

The application will be available at http://localhost:8080.
Contributing

If you wish to contribute to this project, follow these steps:

    Fork the repository
    Create a branch with your name or the feature's name
    Make your changes
    Submit a pull request

Thank you for contributing!
