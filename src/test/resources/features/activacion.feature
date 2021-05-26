Feature: Activar usuario
  Scenario: Activacion exitosa
    Given que estamos en la pagina de activacion
    When ingresemos llenemos el formulario
    Then el sistema activa al usuario y le muestra el inicio de sesion
