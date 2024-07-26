# CaseLab-FileTransfer

Инструкция по запуску:

 docker-compose build
 
 docker-compose up
 

API: 
  localhost:8080/api/v1/json/createFile - Принимает на вход JSON с аттрибутами data, title, creation_date, description. На выходе отправляется long
  Пример: {
            "data" : "none",
            "title": "titleeee",
            "creation_date": "13-01-2017 16:34:41",
            "description": "hihhahai"
          }

  localhost:8080/api/v1/json/getFile (POST) - принимает JSON с одним аттрибутом: id, или localhost:8080/api/v1/json/getFile?id=x (GET. Где x - id файла). - принимает id в ссылке. На выходе отдаёт JSON с аттрибутами файла

  localhost:8080/api/v1/json/getAllFiles?sort=x (где x - вариант упорядочивания. ASC - по возрастанию, DESC - по убыванию, любой отличающийся от asc и desc - без сортировки) (работает независимо от регистра). На выходе возвращается список всех файлов в порядке сортировки

(Добавлены кастомные ошибки. Например при попытке получить файл с несуществующим id)


Тесты: src/test/java/com/preinternship/caselabrosatom

src/test/java/resources - свойства для H2


Описание решения:
PostgreSQL СУБД, Spring WEB, Data, H2, PostgreSQL JDBC

На вход /createFile отправляется dto, которое сохраняется в базе данных. /getFile возвращает JSON с аттрибутами файла, в случае отсутствия файла с таким id вернётся ошибка FileNotFoundException

/getAllFiles возвращает все созданные файлы в порядке сортировки, в случае отсутствия файлов возвращает ошибку FileNotFoundException

Примеры тестовых запросов: 
localhost:8080/api/v1/json/createFile


JSON:

        {
          "data" : "none",
          "title": "titleeee",
          "creation_date": "13-01-2017 16:34:41",
          "description": "hihhahai"
        }

Вывод: id


localhost:8080/api/v1/json/getFile?id=(id с предыдущего метода createFile)

Вывод:

        {
          "data" : "none",
          "title": "titleeee",
          "creation_date": "13-01-2017 16:34:41",
          "description": "hihhahai"
        }


localhost:8080/api/v1/json/getFile

JSON:

    {
      "id": "id с метода createFile"
    }

Вывод:

        {
          "data" : "none",
          "title": "titleeee",
          "creation_date": "13-01-2017 16:34:41",
          "description": "hihhahai"
        }


localhost:8080/api/v1/json/getAllFiles

Вывод: все созданные файлы












