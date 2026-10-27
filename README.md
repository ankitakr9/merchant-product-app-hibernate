# Merchant Product App — Hibernate

## 📌 About the Project

Merchant Product App is a Java application developed to practise Hibernate and JPA concepts. It manages merchants and their products through database operations.

The project demonstrates entity mapping, database interaction, and the use of Hibernate/JPA for persistence.

## 🛠️ Technologies Used

* Java
* Hibernate ORM
* JPA (Java Persistence API)
* MySQL
* Maven
* XML
* Eclipse IDE

## ✨ Features

### Merchant Operations

* Save a merchant
* Update merchant details
* Find a merchant by ID
* Find a merchant using name and password
* Find a merchant using a product ID

### Product Operations

* Add a product to a merchant
* Update product details
* Find all products
* Find products by merchant name
* Find products using merchant GST number and password

## 📚 Concepts Practised

* Hibernate and JPA configuration
* Entity classes and annotations
* `EntityManagerFactory`
* `EntityManager`
* Database transactions
* One-to-many association mapping
* Many-to-one association mapping
* CRUD operations
* JPQL queries

## 📂 Project Structure

```text
merchant-product-app-hibernate/
├── src/
│   └── main/
│       ├── java/
│       │   └── org/
│       │       └── jsp/
│       │           └── Merchant_Product/
│       │               ├── Controller/
│       │               ├── DAO/
│       │               └── DTO/
│       └── resources/
│           └── META-INF/
│               └── persistence.xml
├── pom.xml
└── README.md
```

*Note: The structure may vary depending on your actual project setup.*

## Database Configuration

This project uses MySQL as its database.

Before running the application:

1. Install and start MySQL.
2. Configure the database connection in `persistence.xml`.
3. Replace the placeholder username and password with your own MySQL credentials.
4. Ensure the configured database is available.
5. Run the application from the controller class.


## ▶️ How to Run

1. Clone this repository.
2. Import the project into Eclipse as a Maven project.
3. Make sure Java, Maven, and MySQL are installed and configured.
4. Create the required MySQL database or configure the database connection settings.
5. Check the database credentials and Hibernate/JPA configuration.
6. Run the controller class to access the application menu.

## 🔐 Security Note

Do not commit real database passwords, API keys, or other credentials to GitHub. Use placeholders or environment variables for sensitive configuration.

## 👩‍💻 Author

Java Full Stack Development Practice

## 📈 Learning Goals

This project is part of my Java Full Stack development learning journey, with a focus on Java, Hibernate, JPA, MySQL, and object-relational mapping.
