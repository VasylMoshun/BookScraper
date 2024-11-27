# BookScraper
# 
# 
# 
# Prerequisites
- **Docker: Ensure Docker and Docker Compose are installed on your machine.
- **Java: Install JDK 17 or higher.
- **Maven: Ensure Maven is installed for building the project.
- **Configuration
- **Database Configuration
- **The application uses PostgreSQL as the database, running in a Docker container.
- **The following configuration is defined in application.properties:
# 
# 
# To start the PostgreSQL container, use the following docker-compose.yml configuration:

How to Run
1. Start PostgreSQL
   - **Run the following command to start the PostgreSQL container:
   - **docker-compose up -d


2. Build the Application
   - **Use Maven to build the application:
   - **mvn clean package

3. Run the Application
   - **Start the application:
   - **java -jar target/webscraper-0.0.1-SNAPSHOT.jar
4. Access API
   - **You can access the API to fetch the book data:

- **Get Books with Pagination
- **Endpoint: GET /api/books
- **Parameters:
- **page (optional, default: 0): The page number (0-indexed).
- **size (optional, default: 50): The number of books per page.




#
