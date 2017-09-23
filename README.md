#Server for venki-spb.ru

## create heroku git remote
heroku apps:create server-venki-spb-ru

## publish to heroku
git push heroku master

##read logs
heroku logs --tail -a server-venki-spb-ru -n 1500

##Local start
Setup environment variables for database connection.
Go to Heroku database->settings->data base credentials and populate:
JDBC_DATABASE_URL
JDBC_DATABASE_USERNAME
JDBC_DATABASE_PASSWORD

###JDBC URL format
jdbc:postgresql://host:port/database_name?sslmode=require

###local database
db name: venok
user: venok
password: venok