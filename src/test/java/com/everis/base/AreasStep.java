package com.everis.base;
import com.everis.base.models.Areas;
import com.everis.base.models.ChildAreas;
import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
public class AreasStep {
    private String URL_BASE = "http://api.football-data.org/v4/";
    public Areas areas;
    public void consultarArea(int id) {
        areas = given().baseUri(URL_BASE).log().all().when().get("areas/" + id).as(Areas.class);
        listarAreas(areas);
    }
    private void listarAreas(Areas areas) {
        System.out.println("OUT: ID " + areas.getId());
        System.out.println("OUT: Name " + areas.getName());
        System.out.println("OUT: Code " + areas.getCode());
        System.out.println("OUT: Flag " + areas.getFlag());
        System.out.println("OUT: Parent Area ID " + areas.getParentAreaId());
        System.out.println("OUT: Parent Area " + areas.getParentArea());
        System.out.println("*************************************************************");
        System.out.println("OUT: Child Area");
        if (areas.getChildAreas() != null) {
            for (ChildAreas childrenAreas: areas.getChildAreas()) {
                System.out.println("OUT: ID " + childrenAreas.getId());
                System.out.println("OUT: Name " + childrenAreas.getName());
                System.out.println("OUT: Code " + childrenAreas.getCountryCode());
                System.out.println("OUT: Flag " + childrenAreas.getFlag());
                System.out.println("OUT: Parent Area ID " + childrenAreas.getParentAreaId());
                System.out.println("OUT: Parent Area " + childrenAreas.getParentArea());
                System.out.println("*************************************************************");
                System.out.println("*************************************************************");
            }
        }
    }
    public void validarCodigoRespuesta(int code) {
        assertThat(lastResponse().statusCode(), is(code));
    }

    public Areas obtenerRespuestadeAreas() {
        return areas;
    }
}