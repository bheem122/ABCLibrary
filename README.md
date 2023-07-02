# ABCLibrary
Technologies used-

framework-springboot
language- java
database used- mysql
dependency management tool maven is used
Java 17 is used.
spring boot starters are also used


functionality added as per test- 

1.Add books-Post(use post man to test this functionality)
api-http://localhost:8080/books
sample data-:
{
  "title": "naruto",
  "author": "kishimoto",
  "genre": "action"
}
description of functionality-
1.it will add new books
2.it will not add the book if the title already exists.
3.it will throw an exception "The book with title "book title" already exists." and server won't turn off and server will keep running.

2.get books by genre- Get
api-http://localhost:8080/books/genres/here enter the genre you want

description of functionality- it will return the books available with that genre in json format.

3.get all genres- Get
api-http://localhost:8080/books/genres
description of functionality- it will return the available genres in json format.

4. Update books- Put (use post man to test this functionality)

api-http://localhost:8080/books/{id}
example api-:http://localhost:8080/books/1
sample data-:
{
  "title": "naruto",
  "author": "kishimoto",
  "genre": "action"
}
description of functionality- updates the title,autor and genre of a particular id.
