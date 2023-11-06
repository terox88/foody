**Foody app**

**Short description**
Main function of app is creating for Users weekely set of recipes for every day with four meals on each day.
It's also allows to create a shopping list for every day in Todoist app.


**Enviroment to set:**
DB_URL = mysql server link
MYSQL_USERNAME="mysql username"
MYSQL_PASSWORD="mysql password" 
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true

Endpoints used in app:
tasty api: ttps://tasty.p.rapidapi.com/recipes/list
To use tasty api you need a "key" and "host" you can find it in https://rapidapi.com/apidojo/api/tasty after free registration and subscription.
todoist api for create projects: https://api.todoist.com/rest/v2/projects
todoist api for create tasks: https://api.todoist.com/rest/v2/tasks
In order to integrate with Todoist Api is nessery to get token using OAuth2. For development you can obtain private token after registration and then set it for user for testing. 

Link for frontend https://github.com/terox88/foody_front
