#Server for venki-spb.ru

## create heroku git remote
heroku apps:create server-venki-spb-ru

## publish to heroku
git push heroku master

##read logs
heroku logs --tail -a server-venki-spb-ru -n 1500