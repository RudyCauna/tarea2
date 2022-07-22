Feature: ChangePassword
  @ChangePassword
  Scenario: verify the Change Password is successfully
    Given la pagina "http://todo.ly" este abierta
    And yo quiero realizar el login
      | email    | pedro.2@escamoso.com |
      | password | 12345                |
    When yo cambio mi password antiguo por uno nuevo
      | oldPwd | 12345 |
      | newPwd | 54321 |
    And salgo de la App Web
    Then yo deberia realizar el login con el password nuevo
      | email    | pedro.2@escamoso.com |
      | password | 54321                |
