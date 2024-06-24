# Cookie Clicker Automation Tool

## Overview

The Cookie Clicker Automation Tool is a Java-based application that uses Playwright to automate the popular web game, Cookie Clicker. This tool launches a new game session, continuously clicks the cookie, and purchases upgrades and items as soon as the player has enough cookies.

## Features

- **Automated Cookie Clicking**: Automatically clicks the cookie at a high frequency to generate cookies efficiently.
- **Auto Purchase Upgrades**: Buys upgrades and items automatically when enough cookies are available.
- **Playwright Integration**: Utilizes the Playwright library for browser automation, ensuring reliable and fast interactions with the game.

## Requirements

- Java 11 or higher
- Playwright for Java
- Internet connection to access the Cookie Clicker game

## Installation

1. **Clone the Repository**:
    ```sh
    git clone https://github.com/yourusername/cookie-clicker-automation.git
    cd cookie-clicker-automation
    ```

2. **Install Dependencies**:
   Ensure you have Playwright installed for Java. If not, you can add it using Maven. 

    ```xml
    <dependency>
        <groupId>com.microsoft.playwright</groupId>
        <artifactId>playwright</artifactId>
        <version>1.16.0</version>
    </dependency>
    ```

3. **Build the Project**:
    ```sh
    mvn clean install
    ```

## Usage

1. **Run the Automation Tool**:
    ```sh
    java -jar target/cookie-clicker-automation-1.0.jar
    ```

2. The application will launch a new browser window, navigate to the Cookie Clicker game, and start automating the clicking and purchasing processes.

## How It Works

1. **Initialize Playwright**: The tool initializes Playwright and launches a new browser instance.
2. **Navigate to Cookie Clicker**: Opens the Cookie Clicker game website.
3. **Cookie Clicking**: Continuously clicks the cookie in the center of the screen.
4. **Purchasing Upgrades**: Monitors the number of cookies and automatically purchases available upgrades and items when the player has enough cookies.

Contributions are welcome! Please fork the repository and create a pull request with your changes. Ensure your code follows the existing style and includes appropriate tests.
---

Enjoy automating your Cookie Clicker game and watch your cookie empire grow effortlessly! 🍪
