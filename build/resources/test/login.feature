Feature: Login

  Scenario: verify the login is successfully
    Given la pagina "http://todo.ly" este abierta
    When yo quiero realizar el login
      | email    | pedro.2@escamoso.com |
      | password | 12345                |
    Then  yo deberia ingresar a la app web
