Feature: API de Store - Gestión de Pedidos
  @CrearOrden
  Scenario Outline: Creacion de Order POST
    Given Dado que estoy en la pagina de pedido
    When creo una orden con id<id>, petId<petId>, quantity<quantity>
    Then el codigo de estado de la respuesta debe ser <codigo>
    And la respuesta debe contener el id<id>, petId<petId>, quantity<quantity>
    Examples:
    |id|petId|quantity|codigo|
    |301|2   |4       | 200|
    |302|3   |1       | 200|
    |303|4   |2       | 200|
  @ConsultarOrden
  Scenario Outline: Consulta de Order: GET
    Given Dado que estoy en la pagina de pedidos
    When consulto una orden con id<Id>,
    Then el codigo de estado de la respuesta del pedido debe ser <Codigo>
    Examples:
      |Id|Codigo|
      |301| 200|
      |302|200|
      |303| 200|