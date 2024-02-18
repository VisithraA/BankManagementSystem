# Bank Management System

## Overview
  The Banking Application is a Java-based console application that provides functionality for managing bank accounts, transactions, and user authentication.

## Features
  - **User Authentication:**
      Users need to provide a username and password to access the banking features.
      
  - **Account Management:**
      Users can create, edit, and delete accounts.
      
  - **Transaction Handling:**
      Users can deposit and withdraw amounts from their accounts.
      
  - **Account Search:**
      Users can search for accounts by account number.
      
  - **Display All Accounts:**
      Users can view all existing accounts.

## Technologies Used
  - Java
  - Hibernate
  - MySQL Database

## Prerequisites
  - Java Development Kit (JDK)
  - MySQL Database 

## DataBase Tables

**Account Table:**

| Column Name       | Data Type    | Constraints                   |
|-------------------|--------------|-------------------------------|
| id                | int          | Primary Key, Auto Increment   |
| accountNumber     | varchar(255) | Unique                        |
| accountHolderName | varchar(255) |                               |
| address           | varchar(255) |                               |
| balance           | double       |                               |
| phone             | varchar(20)  |                               |
| openDate          | datetime     |                               |


**Transaction Table:**

| Column Name       | Data Type    | Constraints                             |
|-------------------|--------------|-----------------------------------------|
| id                | int          | Primary Key, Auto Increment             |
| deposit           | double       |                                         |
| withdrawl         | double       |                                         |
| transactionDate   | datetime     |                                         |
| account_id        | int          | Foreign Key (references Account.id)     |


