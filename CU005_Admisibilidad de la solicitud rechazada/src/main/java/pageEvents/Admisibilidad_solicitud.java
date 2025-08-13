package main.java.pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.pageObjects.CC_Localizadores_Flujo_Sagcom;
//import main.java.pageObjects.String;
import main.java.pageObjects.CC_Localizadores_Enfermo_Terminal;
import main.java.utils.GG_ElementFetch;
import main.java.utils.GG_Eventos;
import main.java.utils.GG_Utils;
import main.java.utils.GG_Validations;
import test.java.previred.CC_Test;
import main.java.utils.CC_Parametros;
import java.io.File; // Importa la clase File para manejar rutas de archivo
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

//En esta clase se ejecutan los Pasos de la Pagina.
public class Admisibilidad_solicitud extends CC_Test {

	public Admisibilidad_solicitud(WebDriver driver) {
		CC_Test.driver = driver;
	}

	// iniciar sesion para camino feliz sagcom
	public static void iniciarSesion(String usuario, String contrasena, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			Thread.sleep(1000);

			// Se escribe el Nombre del Usuario
			WebElement inputNombreUsuarioElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputUsuario);
			wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
			GG_Eventos.writeOnInput(inputNombreUsuarioElement, usuario);

			Thread.sleep(300);

			// Se escribe la Contrasena
			WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputContrasena);
			wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
			GG_Eventos.writeOnInput(inputContrasenaElement, contrasena);

			Thread.sleep(300);

			// Click en boton ingresar
			WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnIngresar);
			wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
			GG_Eventos.clickButton(buttonIniciarSesionElement);

			Thread.sleep(200);

			// Verifica si se llego a la segunda pantalla.
			WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.validaLoginExitoso);
			wait.until(ExpectedConditions.visibilityOf(labelPaginaElement));
			String textoPagina = labelPaginaElement.getText();

			GG_Validations.trueBooleanCondition(
					textoPagina.equalsIgnoreCase("Sistema de Apoyo a la Gestión de las Comisiones Médicas"),
					"Se ha ingresado correctamente a la pagina: " + textoPagina,
					"No se ha ingresado correctamente a la pagina: ", currentEvent);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}

	// Ingresar a nueva solicitud flujo sagcom
	public static void iniciarSolicitud(String rut, String ninstitucion, String fecharecep, String nombressoli,
			String primerapesoli, String segundoapesoli, String fechanac, String profesion, String nmovil, String nfijo,
			String direccion, String nrodire, String rutEmpledo, String RazonSocial, String fechainafp, String fechaIncorporacionAfp, String personavalidaafiliado,
			String NombreEmpleado, String apellidoEmpleado, String CorreoEmpleado, String administradoradelseguro, String nombreInstitucion, String fechaAccidente, 
			String entidadEvaluadoraAccidente, String informacionAccidentes, String afeccionoenfermedad, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			// Se ingresa el rut del Usuario
			WebElement inputrutsolElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputRutSolicitante);
			wait.until(ExpectedConditions.visibilityOf(inputrutsolElement));
			GG_Eventos.writeOnInput(inputrutsolElement, rut);

			Thread.sleep(200);

			// Click en boton comenzar
			WebElement buttoncomenzarElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnComenzar);
			wait.until(ExpectedConditions.elementToBeClickable(buttoncomenzarElement));
			GG_Eventos.clickButton(buttoncomenzarElement);

			Thread.sleep(200);

			// Verifica si se llego a pantalla. Ingresar una solicitud
			WebElement labelPaginasolicitudElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.validaCrearNuevaSolicitud);
			wait.until(ExpectedConditions.visibilityOf(labelPaginasolicitudElement));
			String textoPagina = labelPaginasolicitudElement.getText();

			GG_Validations.trueBooleanCondition(textoPagina.equalsIgnoreCase("Ingreso de Nueva Solicitud"),
					"Se ha ingresado correctamente a la pagina: " + textoPagina,
					"No se ha ingresado correctamente a la pagina: ", currentEvent);

			Thread.sleep(200);

			// Ingresar informacion del solicitante

			// click para elegir tipo de solicitud
			WebElement tiposolicitud = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickOptTipoSolicitud);
			wait.until(ExpectedConditions.visibilityOf(tiposolicitud));
			GG_Eventos.clickButton(tiposolicitud);

			// Selecciona opcion tipo solicitud
			WebElement tiposolicitudopcion = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.optTipoSolicitud);
			wait.until(ExpectedConditions.visibilityOf(tiposolicitudopcion));
			GG_Eventos.clickButton(tiposolicitudopcion);

			Thread.sleep(1000);

			// Se escribe el Nº Interno Institución
			WebElement inputninstitucionElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.nroInstitucion);
			wait.until(ExpectedConditions.visibilityOf(inputninstitucionElement));
			GG_Eventos.writeOnInput(inputninstitucionElement, ninstitucion);

			// Click en boton buscar
			WebElement buttonbuscarrSesionElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnBuscar);
			wait.until(ExpectedConditions.elementToBeClickable(buttonbuscarrSesionElement));
			GG_Eventos.clickButton(buttonbuscarrSesionElement);
			
			Thread.sleep(3000);

			// Click en botón Enfermo Terminal
			WebElement buttonenfermoterminal = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.optEnfermoTerminal);
			wait.until(ExpectedConditions.elementToBeClickable(buttonenfermoterminal));
			GG_Eventos.clickButton(buttonenfermoterminal);

			// Se ingresa Fecha de recepción de solicitud en AFP
			WebElement fecharecepElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.fechaRecepcionAfp);
			wait.until(ExpectedConditions.visibilityOf(fecharecepElement));
			GG_Eventos.writeOnInput(fecharecepElement, fecharecep);

			// Se ingresa Nombres
			WebElement nombressoliElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.nombreSolicitante);
			wait.until(ExpectedConditions.visibilityOf(nombressoliElement));
			GG_Eventos.writeOnInput(nombressoliElement, nombressoli);

			// Se ingresa Primer Apellido
			WebElement primerapesoliElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.primerApellidoSolicitante);
			wait.until(ExpectedConditions.visibilityOf(primerapesoliElement));
			GG_Eventos.writeOnInput(primerapesoliElement, primerapesoli);

			// Se ingresa Segundo Apellido
			WebElement segundoapesoliElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.segundoApellidoSolicitante);
			wait.until(ExpectedConditions.visibilityOf(segundoapesoliElement));
			GG_Eventos.writeOnInput(segundoapesoliElement, segundoapesoli);

			// Se ingresa Fecha de nacimiento
			WebElement fechanacElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.fechaNacimiento);
			wait.until(ExpectedConditions.visibilityOf(fechanacElement));
			GG_Eventos.writeOnInput(fechanacElement, fechanac);
			GG_Eventos.actionEnterOnElement(driver, fechanacElement);

			Thread.sleep(300);

			// clickeamos sexo
			WebElement tiposex = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.clickOptTipoSexo);
			wait.until(ExpectedConditions.visibilityOf(tiposex));
			GG_Eventos.clickButton(tiposex);
			Thread.sleep(300);
			// Seleccionar masculino_femenino
			WebElement tiposexo = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.optTipoSexo);
			wait.until(ExpectedConditions.visibilityOf(tiposexo));
			GG_Eventos.clickButton(tiposexo);
			Thread.sleep(300);
			// clickeamos Estado Civil
			WebElement estadocivil = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickOptEstadoCivil);
			wait.until(ExpectedConditions.visibilityOf(estadocivil));
			GG_Eventos.clickButton(estadocivil);
			Thread.sleep(300);
			WebElement tipoestadocivil = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.optEstadoCivil);
			wait.until(ExpectedConditions.visibilityOf(tipoestadocivil));
			GG_Eventos.clickButton(tipoestadocivil);
			Thread.sleep(300);
			// Se ingresa Profesión o actividad
			WebElement profesionElement = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.profesion);
			wait.until(ExpectedConditions.visibilityOf(profesionElement));
			GG_Eventos.writeOnInput(profesionElement, profesion);
			Thread.sleep(300);
			// Click Ingrese correo electrónico
			WebElement btnmail = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.optEmail);
			wait.until(ExpectedConditions.visibilityOf(btnmail));
			GG_Eventos.clickButton(btnmail);
			Thread.sleep(300);
			// Se ingresa Teléfono móvil
			WebElement numovil = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.numeroMovil);
			wait.until(ExpectedConditions.visibilityOf(numovil));
			GG_Eventos.writeOnInput(numovil, nmovil);
			Thread.sleep(300);
			// Se ingresa Teléfono fijo
			
			WebElement optcheckFijo = driver.findElement(By.id("isNoTieneTelefonoFijo"));
			optcheckFijo.click();
			Thread.sleep(300);
			// Nivel Educacional
			WebElement educa = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Flujo_Sagcom.clickOptNivelEducacional);
			wait.until(ExpectedConditions.visibilityOf(educa));
			GG_Eventos.clickButton(educa);
			Thread.sleep(300);
			WebElement educa2 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.optNivelEducacional);
			wait.until(ExpectedConditions.visibilityOf(educa2));
			GG_Eventos.clickButton(educa2);
			Thread.sleep(300);
			// Region
			WebElement region = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.clickOptRegion);
			wait.until(ExpectedConditions.visibilityOf(region));
			GG_Eventos.clickButton(region);
			Thread.sleep(300);
			WebElement regionopcion = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.optRegion);
			wait.until(ExpectedConditions.visibilityOf(regionopcion));
			GG_Eventos.clickButton(regionopcion);
			Thread.sleep(300);
			// Provincia
			WebElement provincia = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.clickOptProvincia);
			wait.until(ExpectedConditions.visibilityOf(provincia));
			GG_Eventos.clickButton(provincia);
			Thread.sleep(300);

			WebElement provinciaopcion = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.optProvincia);
			wait.until(ExpectedConditions.visibilityOf(provinciaopcion));
			GG_Eventos.clickButton(provinciaopcion);
			Thread.sleep(300);
			// Comuna
			WebElement comuna = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.clickOptComuna);
			wait.until(ExpectedConditions.visibilityOf(comuna));
			GG_Eventos.clickButton(comuna);
			Thread.sleep(300);
			GG_Eventos.actionScroll(driver,16);

			// Se activa el Scroll hasta llegar a Rancagua
			WebElement opcComuna = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.optComuna);
			GG_Eventos.scrollToElementAndClick(driver, opcComuna);
			Thread.sleep(300);
			// Se ingresa Dirección; Calle
			WebElement dire = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.direccion);
			wait.until(ExpectedConditions.visibilityOf(dire));
			GG_Eventos.writeOnInput(dire, direccion);
			Thread.sleep(300);
			// Se ingresa numeral de la dirección
			WebElement nrodir = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.nroDireccion);
			wait.until(ExpectedConditions.visibilityOf(nrodir));
			GG_Eventos.writeOnInput(nrodir, nrodire);
			Thread.sleep(300);
			// Click en boton continuar
			WebElement btncontinuar1 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.btnContinuar);
			wait.until(ExpectedConditions.elementToBeClickable(btncontinuar1));
			GG_Eventos.clickButton(btncontinuar1);
			Thread.sleep(300);
			// Situación laboral
			WebElement situlaboral = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickSituacionLaboral);
			wait.until(ExpectedConditions.elementToBeClickable(situlaboral));
			GG_Eventos.clickButton(situlaboral);
			Thread.sleep(3000);
			WebElement situlaboral1 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.optSituacionLaboral);
			wait.until(ExpectedConditions.elementToBeClickable(situlaboral1));
			GG_Eventos.clickButton(situlaboral1);
			Thread.sleep(3000);
			// INGRESAR RUT DE EMPLEADO
			WebElement intRutEmpledo = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.rutEmpledo);
			wait.until(ExpectedConditions.visibilityOf(intRutEmpledo));
			GG_Eventos.writeOnInput(intRutEmpledo, rutEmpledo);
			//ingresar opcion de rut
			Thread.sleep(300);
			WebElement intRazonSocial = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.RazonSocial);
			wait.until(ExpectedConditions.visibilityOf(intRazonSocial));
			GG_Eventos.writeOnInput(intRazonSocial, RazonSocial);
			Thread.sleep(300);
			// Region
			WebElement region1 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.clickOptRegion1);
			wait.until(ExpectedConditions.visibilityOf(region1));
			GG_Eventos.clickButton(region1);
			Thread.sleep(300);			
			WebElement regionopcion1 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.optRegion);
			wait.until(ExpectedConditions.visibilityOf(regionopcion1));
			GG_Eventos.clickButton(regionopcion1);
			Thread.sleep(300);
			// Provincia
			WebElement provincia1 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.clickOptProvincia1);
			wait.until(ExpectedConditions.visibilityOf(provincia1));			
			GG_Eventos.clickButton(provincia1);
			Thread.sleep(300);		
			WebElement provinciaopcion1 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.optProvincia);			
			wait.until(ExpectedConditions.visibilityOf(provinciaopcion1));			
			GG_Eventos.clickButton(provinciaopcion1);
			// Comuna
			Thread.sleep(300);	
			WebElement comuna1 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.clickOptComuna1);	
			wait.until(ExpectedConditions.visibilityOf(comuna1));	
			GG_Eventos.clickButton(comuna1);
			Thread.sleep(300);
			GG_Eventos.actionScroll(driver,16);

			// Se activa el Scroll hasta llegar a Rancagua
			WebElement opcComuna1 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.optComuna1);
			GG_Eventos.scrollToElementAndClick(driver, opcComuna1);
			Thread.sleep(300);
			// Se ingresa Dirección; Calle
			WebElement dire1 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.direccion1);
			wait.until(ExpectedConditions.visibilityOf(dire1));
			GG_Eventos.writeOnInput(dire1, direccion);
			Thread.sleep(300);
			// Se ingresa numeral de la dirección
			WebElement nrodir1 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.nroDireccion1);
			wait.until(ExpectedConditions.visibilityOf(nrodir1));
			GG_Eventos.writeOnInput(nrodir1, nrodire);
			Thread.sleep(300);
			
			// Institución de salud
			WebElement instsalud = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickInstitucionSalud);
			wait.until(ExpectedConditions.elementToBeClickable(instsalud));
			GG_Eventos.clickButton(instsalud);
			

			WebElement instsalud1 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.optInstitucionSalud);
			wait.until(ExpectedConditions.elementToBeClickable(instsalud1));
			GG_Eventos.clickButton(instsalud1);

			// Se ingresa Fecha de afiliación al sistema AFP
			WebElement fechaafp = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.fechaAfiliacionAfp);
			wait.until(ExpectedConditions.visibilityOf(fechaafp));
			GG_Eventos.writeOnInput(fechaafp, fechainafp);
			GG_Eventos.actionEnterOnElement(driver, fechaafp);
			Thread.sleep(300);

			// Click ¿Ha realizado cambio de AFP el afiliado?
			WebElement cambioafp = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.opcCambioAfp);
			wait.until(ExpectedConditions.elementToBeClickable(cambioafp));
			GG_Eventos.clickButton(cambioafp);

			//Fecha de incorporacion de afp
			WebElement fechaaIncorporacionAfp = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.fechaIncorporacionAfp);
			wait.until(ExpectedConditions.visibilityOf(fechaaIncorporacionAfp));
			GG_Eventos.writeOnInput(fechaaIncorporacionAfp, fechaIncorporacionAfp);
			GG_Eventos.actionEnterOnElement(driver, fechaaIncorporacionAfp);
			
			// Click Se encuentra pensionado por la ley 16.744
			WebElement ley16744 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.opcMutualidad);
			wait.until(ExpectedConditions.elementToBeClickable(ley16744));
			GG_Eventos.clickButton(ley16744);

			WebElement buttonArchivoSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Flujo_Sagcom.buttonArchivo);
			wait.until(ExpectedConditions.elementToBeClickable(buttonArchivoSesionElement));
			GG_Eventos.clickButton(buttonArchivoSesionElement);
			Thread.sleep(3000);
			
			try {
			    Robot robot = new Robot();

			    // 1️⃣ Esperar a que aparezca el diálogo de archivos
			    Thread.sleep(2000);

			    // 2️⃣ Ruta de la carpeta (desde CC_Parametros)
			    String rutaCarpeta = new File(CC_Parametros.gloDir).getAbsolutePath();

			    // Copiar ruta al portapapeles
			    StringSelection seleccionRuta = new StringSelection(rutaCarpeta);
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccionRuta, null);

			    // 3️⃣ Ctrl + L para seleccionar barra de dirección
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_L);
			    robot.keyRelease(KeyEvent.VK_L);
			    robot.keyRelease(KeyEvent.VK_CONTROL);
			    Thread.sleep(300);

			    // 4️⃣ Ctrl + V para pegar la ruta
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_CONTROL);
			    Thread.sleep(300);

			    // 5️⃣ Enter para ir a la carpeta
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);
			    System.out.println("Ruta abierta: " + rutaCarpeta);

			    // 6️⃣ Esperar carga de carpeta
			    Thread.sleep(1500);

			    // 7️⃣ Nombre del archivo
			    String nombreArchivo = "Documento.pdf";
			    StringSelection seleccionArchivo = new StringSelection(nombreArchivo);
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccionArchivo, null);

			    // 8️⃣ Mover el foco al campo "Nombre de archivo"
			    // Si el foco está en la lista de archivos, bastan 2 TABs
			    for (int i = 0; i < 7; i++) {
			        robot.keyPress(KeyEvent.VK_TAB);
			        robot.keyRelease(KeyEvent.VK_TAB);
			        Thread.sleep(200);
			    }

			    // 9️⃣ Pegar el nombre del archivo
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_CONTROL);
			    Thread.sleep(300);

			    // 🔟 Enter para abrir el archivo
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);

			    System.out.println("Archivo cargado: " + nombreArchivo);

			} catch (AWTException | InterruptedException e) {
			    e.printStackTrace();
			}
	
			Thread.sleep(3000);
			
			// Click ¿Está actualmente acogido a una licencia médica el solicitante?
			WebElement limed = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.conLicencia);
			wait.until(ExpectedConditions.elementToBeClickable(limed));
			GG_Eventos.clickButton(limed);

			// Click btn continuar paso 2
			WebElement btnContinuar2 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnContinuarPaso2);
			wait.until(ExpectedConditions.elementToBeClickable(btnContinuar2));
			GG_Eventos.clickButton(btnContinuar2);
			Thread.sleep(500);

			// ¿Beneficiario o afiliado incapacitado para comparecer en CM?
			WebElement compafrecerCm = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.comparecerCm);
			wait.until(ExpectedConditions.elementToBeClickable(compafrecerCm));
			GG_Eventos.clickButton(compafrecerCm);

			// ¿Quién verifica la incapacidad?
			WebElement buttonIncapacidad = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.Incapacidad);
			wait.until(ExpectedConditions.elementToBeClickable(buttonIncapacidad));
			GG_Eventos.clickButton(buttonIncapacidad);
			
			//documento para subir
			WebElement buttonarchivoSubir = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.archivoSubir2);
			wait.until(ExpectedConditions.elementToBeClickable(buttonarchivoSubir));
			GG_Eventos.clickButton(buttonarchivoSubir);
			Thread.sleep(3000);
			
			try {
			    Robot robot = new Robot();

			    // Espera breve para asegurar que se abra el diálogo de archivos
			    Thread.sleep(2000);

			    // Nombre del archivo a cargar (puede ser solo el nombre si ya estás en el directorio correcto)
			    String nombreArchivo = "Documento.pdf";  // o la ruta completa

			    // Copiar al portapapeles
			    StringSelection seleccion = new StringSelection(nombreArchivo);
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion, null);

			    // Ctrl + V
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    Thread.sleep(200);
			    robot.keyRelease(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_CONTROL);

			    Thread.sleep(500);

			    // Presionar Enter
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);

			    System.out.println("Archivo cargado automáticamente: " + nombreArchivo);

			} catch (AWTException | InterruptedException e) {
			    e.printStackTrace();
			}
			Thread.sleep(3000);
			// Nombre de la persona que verificó la identidad del afiliado en AFP
			WebElement inputPersonaValidaAfiliado = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.nombrePerVerificaIdentidadAfiliado);
			wait.until(ExpectedConditions.visibilityOf(inputPersonaValidaAfiliado));
			GG_Eventos.writeOnInput(inputPersonaValidaAfiliado, personavalidaafiliado);

						// ¿Requiere representación de un tercero?
			WebElement representanteTercero = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.requiereTercero);
			wait.until(ExpectedConditions.elementToBeClickable(representanteTercero));
			GG_Eventos.clickButton(representanteTercero);
			Thread.sleep(3000);
			//documento para subir
			WebElement buttonarchivoSubir3 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.archivoSubir3);
			wait.until(ExpectedConditions.elementToBeClickable(buttonarchivoSubir3));
			GG_Eventos.clickButton(buttonarchivoSubir3);
			Thread.sleep(3000);
			
			try {
			    Robot robot = new Robot();

			    // Espera breve para asegurar que se abra el diálogo de archivos
			    Thread.sleep(2000);

			    // Nombre del archivo a cargar (puede ser solo el nombre si ya estás en el directorio correcto)
			    String nombreArchivo = "Documento.pdf";  // o la ruta completa

			    // Copiar al portapapeles
			    StringSelection seleccion = new StringSelection(nombreArchivo);
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion, null);

			    // Ctrl + V
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    Thread.sleep(200);
			    robot.keyRelease(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_CONTROL);

			    Thread.sleep(500);

			    // Presionar Enter
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);

			    System.out.println("Archivo cargado automáticamente: " + nombreArchivo);

			} catch (AWTException | InterruptedException e) {
			    e.printStackTrace();
			}

			Thread.sleep(3000);

			WebElement inputNombreEmpleado = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.nombreEmpleado);
			wait.until(ExpectedConditions.visibilityOf(inputNombreEmpleado));
			GG_Eventos.writeOnInput(inputNombreEmpleado, NombreEmpleado);
			Thread.sleep(500);
			
			WebElement inputApellidoEmpleado = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.apellidoEmpleado);
			wait.until(ExpectedConditions.visibilityOf(inputApellidoEmpleado));
			GG_Eventos.writeOnInput(inputApellidoEmpleado, apellidoEmpleado);
			Thread.sleep(500);
			
			WebElement inputCorreoEmpleado = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.correoEmpleado);
			wait.until(ExpectedConditions.visibilityOf(inputCorreoEmpleado));
			GG_Eventos.writeOnInput(inputCorreoEmpleado, CorreoEmpleado);
			Thread.sleep(500);
			
			// Se ingresa Teléfono móvil
			WebElement numovil1 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.numeroMovil1);
			wait.until(ExpectedConditions.visibilityOf(numovil1));
			GG_Eventos.writeOnInput(numovil1, nmovil);
			Thread.sleep(300);
			// Se ingresa Teléfono fijo
			
			WebElement optcheckFijo2 = driver.findElement(By.id("isNoTieneFonoFijoTercero"));
			optcheckFijo2.click();
			Thread.sleep(300);
						
			// Entidad administradora del seguro de accidentes del trabajo y enfermedades
			// profesionales que se encuentre adscrito el solicitante
			WebElement nombreAdministradoraSeguro = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.adminDelSeguro);
			wait.until(ExpectedConditions.visibilityOf(nombreAdministradoraSeguro));
			GG_Eventos.writeOnInput(nombreAdministradoraSeguro, administradoradelseguro);
			Thread.sleep(500);

			// Ha sufrido algún accidente del trabajo o enfermedad profesional
			WebElement accidente = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.accidenteTrabajorEnfermedadProfesional);
			wait.until(ExpectedConditions.elementToBeClickable(accidente));
			GG_Eventos.clickButton(accidente);
			Thread.sleep(500);

			WebElement nombreInstitucion2 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.nombreInstitucion);
			wait.until(ExpectedConditions.visibilityOf(nombreInstitucion2));
			GG_Eventos.writeOnInput(nombreInstitucion2, nombreInstitucion);
			Thread.sleep(500);
			
			WebElement fechaAccidente2 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.fechaAccidente);
			wait.until(ExpectedConditions.visibilityOf(fechaAccidente2));
			GG_Eventos.writeOnInput(fechaAccidente2, fechaAccidente);
			GG_Eventos.actionEnterOnElement(driver, fechaAccidente2);
			Thread.sleep(500);
			
			WebElement IndemnizacionTrabajorEnfermedadProfesional2 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.IndemnizacionTrabajorEnfermedadProfesional);
			wait.until(ExpectedConditions.elementToBeClickable(IndemnizacionTrabajorEnfermedadProfesional2));
			GG_Eventos.clickButton(IndemnizacionTrabajorEnfermedadProfesional2);
			Thread.sleep(500);
			
			WebElement PensionTrabajorEnfermedadProfesional2 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.PensionTrabajorEnfermedadProfesional);
			wait.until(ExpectedConditions.elementToBeClickable(PensionTrabajorEnfermedadProfesional2));
			GG_Eventos.clickButton(PensionTrabajorEnfermedadProfesional2);
			Thread.sleep(500);
			
			WebElement entidadEvaluadoraAccidente2 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.entidadEvaluadoraAccidente);
			wait.until(ExpectedConditions.visibilityOf(entidadEvaluadoraAccidente2));
			GG_Eventos.writeOnInput(entidadEvaluadoraAccidente2, entidadEvaluadoraAccidente);
			Thread.sleep(500);
			
			WebElement informacionAccidentes2 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.informacionAccidentes);
			wait.until(ExpectedConditions.visibilityOf(informacionAccidentes2));
			GG_Eventos.writeOnInput(informacionAccidentes2, informacionAccidentes);
			Thread.sleep(500);
			
			// Principal afección o enfermedad por la que solicita este beneficio
			WebElement principalAfeccionOenfermedad = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.afeccionOenfermedad);
			wait.until(ExpectedConditions.visibilityOf(principalAfeccionOenfermedad));
			GG_Eventos.writeOnInput(principalAfeccionOenfermedad, afeccionoenfermedad);
			Thread.sleep(500);

			// Ingrese el porcentaje de cargo del afiliado a la Administradora del arancel
			// establecido por el D.F.L. Nº1, de 2005
			WebElement porcentaje = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.porcentajeAfiliado);
			wait.until(ExpectedConditions.elementToBeClickable(porcentaje));
			GG_Eventos.clickButton(porcentaje);
			Thread.sleep(500);

			// Click btn continuar paso 3
			WebElement btnContinuar3 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnContinuarPaso3);
			GG_Eventos.clickWithJS(driver, btnContinuar3);
			Thread.sleep(500);

			// Incorporar otros antecedentes
			WebElement masAntecedentes = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.incorporarAntecedentes);
			wait.until(ExpectedConditions.elementToBeClickable(masAntecedentes));
			GG_Eventos.clickButton(masAntecedentes);
			Thread.sleep(500);

			
			// click para elegir tipo de solicitud
			WebElement tipoArchivos = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickOptTipoArchivo);
			wait.until(ExpectedConditions.visibilityOf(tipoArchivos));
			GG_Eventos.clickButton(tipoArchivos);
			Thread.sleep(500);

						// Selecciona opcion tipo solicitud
			WebElement tiposArchivopcion = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.optTipoArchivo);
			wait.until(ExpectedConditions.visibilityOf(tiposArchivopcion));
			GG_Eventos.clickButton(tiposArchivopcion);
			Thread.sleep(500);

			//documento para subir
			WebElement buttonarchivoSubir4 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.archivoSubir4);
			wait.until(ExpectedConditions.elementToBeClickable(buttonarchivoSubir4));
			GG_Eventos.clickButton(buttonarchivoSubir4);
			Thread.sleep(3000);
			
			try {
			    Robot robot = new Robot();

			    // Espera breve para asegurar que se abra el diálogo de archivos
			    Thread.sleep(2000);

			    // Nombre del archivo a cargar (puede ser solo el nombre si ya estás en el directorio correcto)
			    String nombreArchivo = "logo.png";  // o la ruta completa

			    // Copiar al portapapeles
			    StringSelection seleccion = new StringSelection(nombreArchivo);
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion, null);

			    // Ctrl + V
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    Thread.sleep(200);
			    robot.keyRelease(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_CONTROL);

			    Thread.sleep(500);

			    // Presionar Enter
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);

			    System.out.println("Archivo cargado automáticamente: " + nombreArchivo);

			} catch (AWTException | InterruptedException e) {
			    e.printStackTrace();
			}
			
			Thread.sleep(3000);

			// Click btn continuar paso 4
			WebElement btnContinuar4 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnContinuarPaso4);
			wait.until(ExpectedConditions.elementToBeClickable(btnContinuar4));
			GG_Eventos.clickButton(btnContinuar4);
			
			Thread.sleep(500);

			// Click btn finalizar paso 5
			WebElement btnFinalizar5 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnFinalizarPaso5);
			GG_Eventos.clickWithJS(driver, btnFinalizar5);
			
			Thread.sleep(90000);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}

	// iniciar sesion para camino feliz sagcom perfil administrativo
	public static void iniciarSesionAdministrativo(String adm, String pass, String xNumero) {

			String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

			try {
				GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

				WebDriverWait wait = new WebDriverWait(driver, 50);
				GG_ElementFetch elementFetch = new GG_ElementFetch();

				Thread.sleep(1000);

				// Se escribe el Nombre del Usuario
				WebElement inputNombreUsuarioElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputUsuario);
				wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
				GG_Eventos.writeOnInput(inputNombreUsuarioElement, adm);

				Thread.sleep(300);

				// Se escribe la Contrasena
				WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputContrasena);
				wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
				GG_Eventos.writeOnInput(inputContrasenaElement, pass);

				Thread.sleep(300);

				// Click en boton ingresar
				WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnIngresar);
				wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
				GG_Eventos.clickButton(buttonIniciarSesionElement);

				Thread.sleep(200);

				// Verifica si se llego a la segunda pantalla.
				WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.validaLoginExitosoFlujoAdm);
				wait.until(ExpectedConditions.visibilityOf(labelPaginaElement));
				String textoPagina = labelPaginaElement.getText();

				GG_Validations.trueBooleanCondition(
						textoPagina.equalsIgnoreCase("Perfil Administrativo"),
						"Se ha ingresado correctamente a la pagina: " + textoPagina,
						"No se ha ingresado correctamente a la pagina: ", currentEvent);

			} catch (Exception e) {
				GG_Utils.eventFailed(currentEvent, e.getMessage());
			}
	}
	
	// Ingresar a nueva solicitud perfil administrativo

	public static void iniciarSolicitudAdministrativo(String rutsolicitantebuscar, String motivo,String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			// Click en boton "Mi Trabajo Administrativo"
			WebElement opcionMiTrabajoAdm = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcMiTrabajoAdministrativo);
			wait.until(ExpectedConditions.elementToBeClickable(opcionMiTrabajoAdm));
			GG_Eventos.clickButton(opcionMiTrabajoAdm);
			
			// Click en opcion Análisis de admisibilidad
			WebElement opcionDeAdmisibilidad = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.analisisAdmisibilidad);
			wait.until(ExpectedConditions.elementToBeClickable(opcionDeAdmisibilidad));
			GG_Eventos.clickButton(opcionDeAdmisibilidad);
			
			// Click en opcion Expedientes por tipo de prioridad
			WebElement opcionExpedienteTipoPrioridad = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.expedienteTipoPrioridad);
			wait.until(ExpectedConditions.elementToBeClickable(opcionExpedienteTipoPrioridad));
			GG_Eventos.clickButton(opcionExpedienteTipoPrioridad);
			
			Thread.sleep(5000);
			
			// Se ingresa el rut del solicitante a buscar
			WebElement inputrutsolBuscar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.rutSolicitanteBuscar);
			wait.until(ExpectedConditions.visibilityOf(inputrutsolBuscar));
			GG_Eventos.writeOnInput(inputrutsolBuscar, rutsolicitantebuscar);
			
			// Click en la lupa buscar
			WebElement opcionBuscar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcionLupaBuscar);
			wait.until(ExpectedConditions.elementToBeClickable(opcionBuscar));
			GG_Eventos.clickButton(opcionBuscar);
			
			Thread.sleep(10000);
			
			// Click en la opcion ver mas
			WebElement opcVerMas = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcionVerMas);
			wait.until(ExpectedConditions.elementToBeClickable(opcVerMas));
			GG_Eventos.clickButton(opcVerMas);
			
			Thread.sleep(5000);
			
			GG_Eventos.actionScroll(driver, 33);

			// Click en Admisibilidad del caso - 1er Documento - Si, Aprobar
			WebElement opcclicksiprobar1 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Flujo_Sagcom.clicksiprobar1);
			wait.until(ExpectedConditions.elementToBeClickable(opcclicksiprobar1));
			GG_Eventos.clickButton(opcclicksiprobar1);
			Thread.sleep(300);

			// Click en Admisibilidad del caso - 2do Documento - Si, Aprobar
			WebElement opcclicksiprobar2 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Flujo_Sagcom.clicksiprobar2);
			wait.until(ExpectedConditions.elementToBeClickable(opcclicksiprobar2));
			GG_Eventos.clickButton(opcclicksiprobar2);
			Thread.sleep(300);

			// Click en Admisibilidad del caso - 3er Documento - Si, Aprobar
			WebElement opcclicksiprobar3 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Flujo_Sagcom.clicksiprobar3);
			wait.until(ExpectedConditions.elementToBeClickable(opcclicksiprobar3));
			GG_Eventos.clickButton(opcclicksiprobar3);
			Thread.sleep(300);
			
			// Click en Admisibilidad del caso - 4er Documento - Si, Aprobar
			WebElement opcclicksiprobar4 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Flujo_Sagcom.clicksiprobar4);
			wait.until(ExpectedConditions.elementToBeClickable(opcclicksiprobar4));
			GG_Eventos.clickButton(opcclicksiprobar4);
			Thread.sleep(300);
			// Click en Admisibilidad de la solicitud
			WebElement admisibilidadSolicitud = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.admisibilidadSolicitud);
			wait.until(ExpectedConditions.elementToBeClickable(admisibilidadSolicitud));
			GG_Eventos.clickButton(admisibilidadSolicitud);
			Thread.sleep(300);
			// clickeamos sexo
			WebElement TipoMoti = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.clickTipoMotivo);
			wait.until(ExpectedConditions.visibilityOf(TipoMoti));
			GG_Eventos.clickButton(TipoMoti);
			Thread.sleep(300);
						// Seleccionar masculino_femenino
			WebElement TipoMotivo = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.optTipoMotivo);
			wait.until(ExpectedConditions.visibilityOf(TipoMotivo));
			GG_Eventos.clickButton(TipoMotivo);
			Thread.sleep(300);
			
			
			WebElement inputMotivoRechado = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.motivoRechado);
			wait.until(ExpectedConditions.visibilityOf(inputMotivoRechado));
			GG_Eventos.writeOnInput(inputMotivoRechado, motivo);	
			
			Thread.sleep(5000);
			
			// Click en boton confirmar
			WebElement btnConfirmar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnConfirmar);
			wait.until(ExpectedConditions.elementToBeClickable(btnConfirmar));
			GG_Eventos.clickButton(btnConfirmar);
			
		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
}
	// iniciar sesion para camino feliz sagcom medico presidente
