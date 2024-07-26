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

Тесты: src/test/java/com/preinternship/caselabrosatom

src/test/java/resources - свойства для H2

