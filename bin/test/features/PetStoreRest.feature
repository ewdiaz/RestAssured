Feature: Servicios Rest con Serenity

  Scenario: Servicios Rest Pet Store
    Given que me encuentro con la uri de Pet Store
    When realice el crud de los servicios
    Then validare que el codigo de estado del servicio final sea 200
