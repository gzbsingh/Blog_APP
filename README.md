# Blog_APP

This project is a blog application implemented using Spring Boot for the backend RESTful APIs. It includes user registration and authentication, role-based access control, CRUD operations for posts and categories, and JWT-based token authentication.

## Technologies Used

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Maven (for dependency management)
- MySQL  for data storage
-Unit testing-Testing added on service layer .

 # ER DIAGRAM
 ![ER_digram](https://github.com/gzbsingh/Blog_APP/assets/39863817/b82d59bc-93b8-4b15-95e5-c596eafa61d0)


## Setup Instructions

1. *Clone the Repository*
   ```bash
   git clone https://github.com/yourusername/Blog_App.git
   cd Blog_APP
## Database Configuration
 
 Create a MySQL database named blog_db.Configure database credentials in application.properties
 
 .Build and Run the Applicationmvn spring-boot:runAccessing the ApplicationOpen a web browser and go to http://localhost:8080 to access the application.

 # Hosting
The application is hosted on Railway.app.
Access the application through the provided host link:  Host Link https://blogapp-production-b5f7.up.railway.app/swagger-ui/index.html#/
 
# Video walk through of project
https://drive.google.com/file/d/1VJhNFFPUxi7myZdytRUmI54Q9dyW5NGw/view?usp=sharing
 
  # End points
 
 - #### POST /api/user/register: Register a new user.POST /api/user/login: Login with username/email and password.
 
  - #### Post EndpointsGET /api/posts: Get all posts.
  
  - #### POST /api/posts: Create a new post.GET /api/posts/{postId}: Get a post by ID.
 
 
 - #### PUT /api/posts/{postId}: Update a post by ID.DELETE /api/posts/{postId}: Delete a post by ID.Category EndpointsGET /api/category: 
 
   - ####  Get all categories.POST /api/category: Create a new category (admin only).
 
  - #### GET /api/category/{categoryId}: Get a category by ID.
 
  - #### PUT /api/category/{categoryId}: Update a category by ID (admin only).

-  #### DELETE /api/category/{categoryId}: Delete a category by ID (admin only).
 
 - #### Comment EndpointsPOST /api/comments: Add a new comment to a post.Feed EndpointGET /api/feed:
 
 Get all posts created on the current day.
 
 Security and AuthorizationRole-based Access Control:ROLE_USER: Regular user role.ROLE_ADMIN: Admin user role.JWT Token Authentication:Generate JWT token on successful 

### login-  Authenticate endpoints based on token and user roles.

# Swagger open Documentaion
![swagger_blog](https://github.com/gzbsingh/Blog_APP/assets/39863817/44138e9f-97a4-4536-8c59-62c9c795e0ff)

# Instruction to use Swagger API Documentation
 * Register as a user with the role "USER". For admin role-"ADMIN"
 * Login using the login API.
 * Copy the bearer token from the response body and paste it in the "Bearer token" input box (located in the top right corner by clicking on the lock symbol) to authorize access.
Access the available endpoints for user and admin .


