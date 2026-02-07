# Item Management API

A simple Spring Boot REST API to manage items using in-memory storage.

## Features
- Add a new item
- Get item by ID
- Input validation
- In-memory data storage (ArrayList)

## Tech Stack
- Java 17
- Spring Boot
- Maven

## API Endpoints

### Add Item
POST /api/items

Request Body:
{
"name": "Laptop",
"price": 65000
}

### Get Item
GET /api/items/{id}

## How to Run
1. Open project in IntelliJ IDEA
2. Run ItemManagementApiApplication
3. Server starts on port 8080
