package Wizard;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SerenityRunner.class)
public class MyStepdefs
{
    ChromeDriver driver;
    String Activacion = "https://wizard.goasap.dev/activate/ZXlKaGJHY2lPaUpJVXpJMU5pSXNJblI1Y0NJNklrcFhWQ0o5LmV5SjFjMlZ5SWpwN0ltOXVZbTloY21ScGJtZGZjM1JoZEhWeklqb2lhVzUyYVhSbFpDSXNJbVpwY25OMFgyNWhiV1VpT2lKS1lYWnBaWElpTENKc1lYTjBYMjVoYldVaU9pSlNiMlJ5dzYxbmRXVjZJRk5oYldGdWFXVm5ieUlzSW1WdFlXbHNJam9pYW1GMmFXVnlMbk5oYldGdWFXVm5ieXN4T1RCQVlYTmhjRFV3Tnk1amIyMGlMQ0poWTJ4ZmJXVjBZV1JoZEdFaU9uc2liMjVpYjJGeVpHbHVaMTlwWkNJNklqWXdZV1UzTldWbVlUTXhZbVV3WW1Rd1pUSXlZekZoTVNKOWZTd2laM0poYm5SZmRIbHdaU0k2SW05dVltOWhjbVJwYm1kZmFXNTJhWFJoZEdsdmJpSXNJbWxoZENJNk1UWXlNakEwTmpJd09Dd2laWGh3SWpveE5qSXlOalV4TURBNGZRLnFLTXBjS0g5XzhSZm00LVZGd1U2RkNZb21Fem4tNUlWRWFhVmV4Y0pYTlk=";
    String Inicio = "https://wizard.goasap.dev/";

    @Given("que estamos en la pagina de inicio de sesion")
    public void queEstamosEnLaPaginaDeInicioDeSesion()
    {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Inicio);


    }

    @When("ingresamos el email y password")
    public void ingresamosElEmailYPassword()
    {
        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.HOURS);
        driver.findElement(By.id("emailInput")).sendKeys("javier.samaniego+190@asap507.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("qwerty123!A");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.HOURS);
        driver.findElement(By.xpath("/html/body/ngwork-root/asap-wizard-layout-login-activate/div/div/div[2]/ngwork-login/div/div/div[2]/div/div/form/div[3]/button")).click();

    }

    @Then("el sistema valida y nos permite iniciar sesion")
    public void elSistemaValidaYNosPermiteIniciarSesion()
    {
        WebElement Titulo;
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.HOURS);
        Titulo = driver.findElement(By.cssSelector("body > ngwork-root > ngwork-layout-wizard > div > div.row.container-wizard > div > asap-wizard-onboarding > div > div.col-8.offset-2 > asap-wizard-steps > div > div > div > asap-wizard-brand-form > div > h4"));
        assertThat(Titulo.getText(), Matchers.containsString("Registro de la marca"));
        System.out.print(Titulo.getText());
        driver.quit();

    }

    @Given("que estamos en la pagina de activacion")
    public void queEstamosEnLaPaginaDeActivacion()
    {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Activacion);
    }

    @When("ingresemos llenemos el formulario")
    public void ingresemosLlenemosElFormulario()
    {       driver.manage().timeouts().implicitlyWait(30,TimeUnit.HOURS);
            driver.findElement(By.id("exampleInputPassword1")).sendKeys("qwerty123!A");
            driver.findElement(By.id("exampleInputPassword2")).sendKeys("qwerty123!A");
            //driver.manage().timeouts().implicitlyWait(30,TimeUnit.HOURS);
            driver.findElement(By.xpath("/html/body/ngwork-root/asap-wizard-layout-login-activate/div/div/div[2]/ngwork-activate/div/div/div[2]/div/div/div/form/div[4]/button")).sendKeys(Keys.ENTER);

    }

    @Then("el sistema activa al usuario y le muestra el inicio de sesion")
    public void elSistemaActivaAlUsuarioYLeMuestraElInicioDeSesion()
    {      WebElement Titulo;
           driver.manage().timeouts().implicitlyWait(30,TimeUnit.HOURS);
           Titulo = driver.findElement(By.xpath("/html/body/ngwork-root/asap-wizard-layout-login-activate/div/div/div[2]/ngwork-login/div/div/div[2]/div/h2"));
           assertThat(Titulo.getText(), Matchers.containsString("Iniciar Sesión"));
           System.out.print(Titulo.getText());
           driver.quit();
    }

}
