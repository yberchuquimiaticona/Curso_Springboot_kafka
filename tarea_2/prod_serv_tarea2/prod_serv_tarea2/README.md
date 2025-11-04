# Tarea - Clase 2


---

## Objetivo
Construir un CRUD simple para la entidad Product utilizando Spring Data JPA, Docker Compose y pruebas con Postman.

---
## Servicios REST
Se tiene los servico de:
- GET (Servicio que permite obtener todo los productos registrados, ver evidencia en screenshots\01_servicio_GET.png)
```bash
  http://localhost:8080/api/products
```

- POST (Sevicio que permite registrar los productos con los campos name, description, price, stock. ver evidencia en screenshots\02_servicio_POST.png)
```bash
  http://localhost:8080/api/products
```
- GET ID (Servicio que permite la obtencio de un producto a traves del Id, ver evidencia en screenshots\03_servicio_GET_ID.png)
```bash
    http://localhost:8080/api/products/1
```
- PUT (Servicio que permite actualizar un producto sus valores como name, description, price, stock. ver evidencia en screenshots\04_servicio_PUT.png)
```bash
    http://localhost:8080/api/products/1
```
- DELETE (Servicio que elimina un producto a traves del id, ver evidencia en screenshots\05_servicio_DELETE.png)
```bash
    http://localhost:8080/api/products/1
```
Se tiene la coleccion de POSTMAN en la ruta de (Coleccion_Postman\Product Service - Clase 2_tarea.postman_collection.json)

## Persistencia en PstgresSQL
Para ello se tiene el una maquina Docker:

Crear un archivo docker-compose.yml 
```bash
cat <<'EOF' > docker-compose.yml
services:
  postgres:
    image: postgres:15-alpine
    container_name: product-db
    restart: unless-stopped
    environment:
      POSTGRES_DB: product_db
      POSTGRES_USER: product_user
      POSTGRES_PASSWORD: product_password
    ports:
      - "5432:5432"
    volumes:
      - postgres-data:/var/lib/postgresql/data

volumes:
  postgres-data:
EOF
```
Levantar el contenedor
```bash
  docker compose up -d
```

Verificar estado
```bash
    docker compose ps
```

Inspeccionar logs iniciales (opcional)
```bash
  docker compose logs -f postgres
```

Los capturas se encuentran en la ruta (screenshots\06_aplicacion_Docker_Windows.png, screenshots\07_ejecucion_docker.png y screenshots\08_base_de_datos.png)

