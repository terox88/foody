**Foody app**

**Short description**
This Aplication is still in working mode.
Main function is creating for Users weekely set of recipes for every day with four meals on each day.
It's also allows to create a shopping list for every day in Todoist app.
So far there is no impememntation of validation of Users

**Enviroment to set:**
DB_URL = mysql server link
MYSQL_USERNAME="mysql username"
MYSQL_PASSWORD="mysql password" 
spring.jpa.hibernate.ddl-auto=update

Endpoints used in app:
tasty api: ttps://tasty.p.rapidapi.com/recipes/list
To use tasty api you need a "key" and "host" you can find in https://rapidapi.com/apidojo/api/tasty after free registration and subscription.
todoist api for create projects: https://api.todoist.com/rest/v2/projects
todoist api for create tasks: https://api.todoist.com/rest/v2/tasks
In order to integrate with Todoist Api is nessery to get token using OAuth2. For development you can obtain private token after registration and then set it for user for testing. 

Here is link for frontend (curentlly not ready yet)
