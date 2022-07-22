Feature: Login

  Scenario Outline: Como usuario quiero ingresar a la aplicacion usando email y pwd para revisar mis archivos

    Given tengo acceso a todo.ly
    When realizo click en el boton login
    And ingreso mi correo electronico: "<email>"
    And ingreso mi password: <password>
    And realizo click en el boton login
    Then deberia ingresar a la aplicacion

    Examples:
      | email          | password |
      | rudy@rudy.com  | 1234     |
      | rudy1@rudy.com | 1234     |
      | rudy2@rudy.com | 1234     |