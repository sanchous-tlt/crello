# Crello - is a Trello clone app.

Crello - клон планировщика Trello.

- api - серверная часть на Spring Boot, Spring MVC, Spring Data JPA и Postgres
- web - клиентская часть на React

### Модели данных приложения:

- User - идентифицируется по номеру телефона
- TaskList - список задач
- TaskJob - конкретная задача

### Описание API

- GET /users - список всех пользователей
- GET /users/{id} - пользователь с номером телефона id
- POST /users - создать пользователя

- GET /users/{id}/tasklists - список всех листов у пользователя id
- GET /users/{id}/tasklists/{taskListId} - конкретный лист задач taskListId у пользователя id
- POST /users/{id}/tasklists - создать лист задач у пользователя id
- PUT /users/{id}/tasklists/{taskListId} - изменить лист задач taskListId у пользователя id
- DELETE /users/{id}/tasklists/{taskListId} - удалить лист задач taskListId у пользователя id

- GET /users/{userId}/tasklists/{taskListId}/taskjobs - список всех задач в листе taskListId
- GET /users/{userId}/tasklists/{taskListId}/taskjobs/{taskJobId} - задача taskJobId в листе taskListId
- POST /users/{userId}/tasklists/{taskListId}/taskjobs - создать задачу в листе taskListId
- PUT /users/{userId}/tasklists/{taskListId}/taskjobs/{taskJobId} - изменить задачу в листе taskListId
- DELETE /users/{userId}/tasklists/{taskListId}/taskjobs/{taskJobId} - удалить задачу taskJobId из листа taskListId

### Как запустить:

1. На сервере БД Postgres создать:

- пользователя scott/tiger
- базу данных crello с владельцем scott
- схему crello у пользователя scott

2. Собрать серверную часть

- mvn -f ./api package

3. запустить API-сервер

- java -jar target/crello.jar

4. собрать фронт

- cd web && npm run build

5. запустить фронт на веб-сервере (например nginx), спроксировать запросы к /api на бекенд
