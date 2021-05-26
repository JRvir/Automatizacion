#language: en

  Feature: Login
    Verificar que es posible acceder al inicio de sesion

    Scenario: inicio de sesion exitos
      Given que estamos en la pagina de inicio de sesion
      When ingresamos el email y password
      Then el sistema valida y nos permite iniciar sesion
