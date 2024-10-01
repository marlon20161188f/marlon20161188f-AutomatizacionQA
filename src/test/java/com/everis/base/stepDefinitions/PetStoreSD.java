package com.everis.base.stepDefinitions;

import com.everis.base.PetStoreStep;
import com.everis.base.models.Order;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PetStoreSD {
    @Steps
    PetStoreStep petStore;
    @Given("Dado que estoy en la pagina de pedido")
    public void dadoQueEstoyEnLaPaginaDePedido() {
        
    }

    @When("creo una orden con id{int}, petId{int}, quantity{int}")
    public void creoUnaOrdenConIdIdPetIdPetIdQuantityQuantity( int id, int petId, int quantity) {
        petStore.crearOrden(id, petId, quantity);
    }

    @Then("el codigo de estado de la respuesta debe ser {int}")
    public void elCodigoDeEstadoDeLaRespuestaDebeSerCodigo(int codigo) {
        petStore.validarCodigoRespuesta(codigo);
    }

    @And("la respuesta debe contener el id{int}, petId{int}, quantity{int}")
    public void laRespuestaDebeContenerElIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity) {
        Order order = petStore.obtenerRespuestaOrder();
        assertNotNull(order);
        assertEquals(id,order.getId());
        assertEquals(petId, order.getPetId());
        assertEquals(quantity, order.getQuantity());

    }

    @Given("Dado que estoy en la pagina de pedidos")
    public void dadoQueEstoyEnLaPaginaDePedidos() {
    }

    @When("consulto una orden con id{int},")
    public void consultoUnaOrdenConIdId(int Id) {
        petStore.consultarOrden(Id);
    }


    @Then("el codigo de estado de la respuesta del pedido debe ser {int}")
    public void elCodigoDeEstadoDeLaRespuestaDelPedidoDebeSerCodigo(int Codigo) {
        petStore.validarCodigoRespuesta(Codigo);
    }
}
