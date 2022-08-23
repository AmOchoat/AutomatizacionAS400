package co.proyectobase.myextra.stepdefinitions;

import co.proyectobase.myextra.tasks.Abrir;
import co.proyectobase.myextra.tasks.LaRespuesta;
import co.proyectobase.myextra.tasks.Loguearse;
import co.proyectobase.myextra.tasks.Navegar;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class MyExtraStepDefinition {

    @Managed(drivere="chrome")
    private WebDriver navegador;
    private Actor rafa = Actor.named("Rafa");

    @Before public void setup()
    {
        rafa.can(BrowseTheWeb.with(navegador));
    }

    @Dado("^que Rafa desea realizar consultas en AS(\\d+), Rafa abre My Extra$")
    public void queRafaDeseaRealizarConsultasEnASRafaAbreMyExtra() {
        rafa.attemptsTo(Abrir.myExtra());
    }

    @Cuando("^él ingresa sus credenciales$")
    public void élIngresaSusCredenciales() {
        rafa.attemptsTo(Loguearse.enMyExtra());
    }

    @Cuando("^Navega en un menu$")
    public void navegaEnUnMenu() {
        rafa.attemptsTo(Navegar.aUnMenu());
    }

    @Entonces("^verifica que inició sesión correctamente$")
    public void verificaQueInicióSesiónCorrectamente() {
        rafa.should(seeThat(LaRespuesta.es(), equalTo("Introducir sentencia SQL")));
    }


}
