Feature: Signup

  Scenario: verify the signup is successfully
    Given la pagina "http://todo.ly" este abierta
    When yo quiero realizar un signup
      | fullName | Pedro Coral Tavera        |
      | email    | pedro.random@escamoso.com |
      | password | 12345                     |
    Then yo deberia ingresar a la app web