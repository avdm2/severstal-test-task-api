# Дмитриев Артём Вадимович, тестовое задание на стажировку. Северсталь

## Примечания
- К сожалению, у меня не так много опыта написания **API** на **ASP.NET Core**, поэтому
я решил выполнить задание на Java с использованием **Spring Boot**.
- Задокументировать **API** не получилось по единственной причине - **Swagger** пока еще
не поддерживает **Spring Boot 3**, поэтому для тестирования я использовал **Postman**. Описание 
запросов представлено ниже, а сама коллекция **Postman** лежит [тут](https://github.com/avdm2/severstal-test-task-api/blob/master/%5B%234%5D%20Severstal%20REST%20API.postman_collection.json).

## Стек
- Язык: `Java`
- Фреймворк: `Spring Boot`
- СУБД: `PostgreSQL`
- API-requests: `Postman`

## Docker
- Dockerfile: [тут](https://github.com/avdm2/severstal-test-task-api/blob/master/Dockerfile)
- Сборка: **docker build -t severstal-api .**
- Запуск: **docker run -p 8081:8081 severstal-api**

## API

---

### Получение всех заметок [GET]
Route - **"/api/notes/get"**

---

### Создание заметки [POST]
Route - **"/api/notes/create"**

Запрос:
```json
{
  "title": "Note",
  "description": "Description"
}
```

---

### Получение заметки по ID [GET]
Route - **"/api/notes/{id}"**

---

### Изменение заметки по ID [PATCH]
Route - **"/api/notes/{id}"**

Запрос:
```json
{
  "title": "New title",
  "description": "New description"
}
```

---

### Удаление заметки по ID [DELETE]
Route - **"/api/notes/{id}"**
