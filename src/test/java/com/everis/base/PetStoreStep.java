package com.everis.base;
import com.everis.base.models.Areas;
import com.everis.base.models.Order;
import net.serenitybdd.rest.RestRequests;

import static io.restassured.RestAssured.given;


public class PetStoreStep {

    private String URL_BASE="https://petstore.swagger.io/v2";
    private int codigoRespuesta;
    private Order respuestaOrder;


    public void crearOrden(int id, int petId, int quantity){
        Order nuevaOrden = new Order(id,petId,quantity);

        codigoRespuesta = given()
        .baseUri(URL_BASE).contentType("application/json")
                .body(nuevaOrden).when().post("/store/order").then().statusCode(200).extract().statusCode();

        respuestaOrder = given().baseUri(URL_BASE).when().get("/store/order/"+id).as(Order.class);
        System.out.println("ID Creado:" + respuestaOrder.getId());
        System.out.println("PetId Creado:" + respuestaOrder.getPetId());
        System.out.println("Quantity Creado:" + respuestaOrder.getQuantity());
    }

    public void consultarOrden(int Id){
        codigoRespuesta = given()
                .baseUri(URL_BASE).log().all().when().get("/store/order/"+Id).then().statusCode(200).extract().statusCode();

        respuestaOrder = given().baseUri(URL_BASE).log().all().when().get("/store/order/"+Id).as(Order.class);
        System.out.println("ID Creado:" + respuestaOrder.getId());
        System.out.println("PetId Creado:" + respuestaOrder.getPetId());
        System.out.println("Quantity Creado:" + respuestaOrder.getQuantity());
    }

    public void validarCodigoRespuesta(int codigoEsperado) {
        if (codigoRespuesta != codigoEsperado){
            throw new AssertionError("Código esperado: "+codigoEsperado+" Código Obtenido: "+codigoRespuesta);
        }
    }

    public Order obtenerRespuestaOrder(){
        return respuestaOrder;
    }
}
