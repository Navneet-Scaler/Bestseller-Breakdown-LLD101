# Amazon Bestsellers Data Analyzer

A simple command-line application built in Java to analyze the Amazon Top 50 Bestselling Books dataset (2009-2019) from Kaggle. It allows users to query the dataset for specific information through an interactive menu.

-----

## Features

  * Get the total number of bestselling books by a specific author.
  * List all unique authors in the dataset.
  * List all book titles written by a specific author.
  * Find books that match a specific user rating.
  * Show the names and prices of books by a specific author.

-----

## Dataset

This project uses the **Amazon Top 50 Bestselling Books 2009 - 2019** dataset.

  * **Source:** [Kaggle](https://www.kaggle.com/datasets/sootersaalu/amazon-top-50-bestselling-books-2009-2019)
  * The data file `bestsellers.csv` must be present in the root directory of the project to run the application.

-----

## Requirements

  * Java Development Kit (JDK) 8 or higher.

-----

## How to Run

1.  Clone the repository or download the source files.
2.  Make sure `bestsellers.csv` is in the same directory as the `.java` files.
3.  Open a terminal or command prompt in the project directory.
4.  Compile the Java files:
    ```sh
    javac *.java
    ```
5.  Run the application:
    ```sh
    java Driver
    ```
6.  Follow the instructions in the interactive menu.