docker run -d --name mysql_product_service -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 mysql:5.7.43

docker exec -it mysql_product_service mysql -u root -p

(enter "root")
