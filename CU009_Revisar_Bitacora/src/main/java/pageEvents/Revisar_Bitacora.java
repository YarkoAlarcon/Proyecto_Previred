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

import main.java.pageObjects.CC_Localizadores_Revisar_Bitacora;
import main.java.utils.GG_ElementFetch;
import main.java.utils.GG_Eventos;
import main.java.utils.GG_Utils;
import main.java.utils.GG_Validations;
import main.java.utils.CC_Parametros;
import test.java.previred.CC_Test;
import java.io.File; // Importa la clase File para manejar rutas de archivo

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


//En esta clase se ejecutan los Pasos de la Pagina.
public class Revisar_Bitacora extends CC_Test {

	public Revisar_Bitacora(WebDriver driver) {
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
			WebElement inputNombreUsuarioElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputUsuario);
			wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
			GG_Eventos.writeOnInput(inputNombreUsuarioElement, usuario);

			Thread.sleep(300);

			// Se escribe la Contrasena
			WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputContrasena);
			wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
			GG_Eventos.writeOnInput(inputContrasenaElement, contrasena);

			Thread.sleep(300);

			// Click en boton ingresar
			WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnIngresar);
			wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
			GG_Eventos.clickButton(buttonIniciarSesionElement);

			Thread.sleep(200);

			// Verifica si se llego a la segunda pantalla.
			WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.validaLoginExitoso);
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
			String primerapesoli, String segundoapesoli, String fechanac, String profesion, String mail, String nmovil,
			String nfijo, String direccion, String nrodire, String fechainafp, String personavalidaafiliado,
			String administradoradelseguro, String afeccionoenfermedad, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			// Se ingresa el rut del Usuario
			WebElement inputrutsolElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputRutSolicitante);
			wait.until(ExpectedConditions.visibilityOf(inputrutsolElement));
			GG_Eventos.writeOnInput(inputrutsolElement, rut);

			Thread.sleep(200);

			// Obetener imagen de la función
			System.out.println("Voy hacer Print");
			GG_Utils.takeAdditionalScreenshot(GG_Utils.obtenerFechaHoraActual() + "_TipoSolicitud", "passed");
			System.out.println("Ya hice Print");

			// Click en boton comenzar
			WebElement buttoncomenzarElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnComenzar);
			wait.until(ExpectedConditions.elementToBeClickable(buttoncomenzarElement));
			GG_Eventos.clickButton(buttoncomenzarElement);

			Thread.sleep(200);

			// Verifica si se llego a pantalla. Ingresar una solicitud
			WebElement labelPaginasolicitudElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.validaCrearNuevaSolicitud);
			wait.until(ExpectedConditions.visibilityOf(labelPaginasolicitudElement));
			String textoPagina = labelPaginasolicitudElement.getText();

			GG_Validations.trueBooleanCondition(textoPagina.equalsIgnoreCase("Ingreso de Nueva Solicitud"),
					"Se ha ingresado correctamente a la pagina: " + textoPagina,
					"No se ha ingresado correctamente a la pagina: ", currentEvent);

			Thread.sleep(200);

			// Ingresar informacion del solicitante

			// click para elegir tipo de solicitud
			WebElement tiposolicitud = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.clickOptTipoSolicitud);
			wait.until(ExpectedConditions.visibilityOf(tiposolicitud));
			GG_Eventos.clickButton(tiposolicitud);

			// Selecciona opcion tipo solicitud
			WebElement tiposolicitudopcion = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.optTipoSolicitud);
			wait.until(ExpectedConditions.visibilityOf(tiposolicitudopcion));
			GG_Eventos.clickButton(tiposolicitudopcion);

			Thread.sleep(1000);

			// Se escribe el Nº Interno Institución
			WebElement inputninstitucionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.nroInstitucion);
			wait.until(ExpectedConditions.visibilityOf(inputninstitucionElement));
			GG_Eventos.writeOnInput(inputninstitucionElement, ninstitucion);
			
			Thread.sleep(300);
			// Click en boton buscar
			WebElement buttonbuscarrSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnBuscar);
			wait.until(ExpectedConditions.elementToBeClickable(buttonbuscarrSesionElement));
			GG_Eventos.clickButton(buttonbuscarrSesionElement);

			Thread.sleep(3000);

			// Click en botón Enfermo Terminal
			WebElement buttonenfermoterminal = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.optEnfermoTerminal);
			wait.until(ExpectedConditions.elementToBeClickable(buttonenfermoterminal));
			GG_Eventos.clickButton(buttonenfermoterminal);
			Thread.sleep(300);

			WebElement buttonBuscarDocumento= elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.buscarArchivo);
			wait.until(ExpectedConditions.elementToBeClickable(buttonBuscarDocumento));
			GG_Eventos.clickButton(buttonBuscarDocumento);
			Thread.sleep(300);
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
			Thread.sleep(300);
			// Se ingresa Fecha de recepción de solicitud en AFP
			WebElement fecharecepElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.fechaRecepcionAfp);
			wait.until(ExpectedConditions.visibilityOf(fecharecepElement));
			GG_Eventos.writeOnInput(fecharecepElement, fecharecep);
			
			Thread.sleep(300);
			// Se ingresa Nombres
			WebElement nombressoliElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.nombreSolicitante);
			wait.until(ExpectedConditions.visibilityOf(nombressoliElement));
			GG_Eventos.writeOnInput(nombressoliElement, nombressoli);
			
			Thread.sleep(3000);
			// Se ingresa Primer Apellido
			WebElement primerapesoliElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.primerApellidoSolicitante);
			wait.until(ExpectedConditions.visibilityOf(primerapesoliElement));
			GG_Eventos.writeOnInput(primerapesoliElement, primerapesoli);

			Thread.sleep(300);
			// Se ingresa Segundo Apellido
			WebElement segundoapesoliElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.segundoApellidoSolicitante);
			wait.until(ExpectedConditions.visibilityOf(segundoapesoliElement));
			GG_Eventos.writeOnInput(segundoapesoliElement, segundoapesoli);

			Thread.sleep(300);
			// Se ingresa Fecha de nacimiento
			WebElement fechanacElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.fechaNacimiento);
			wait.until(ExpectedConditions.visibilityOf(fechanacElement));
			GG_Eventos.writeOnInput(fechanacElement, fechanac);
			GG_Eventos.actionEnterOnElement(driver, fechanacElement);

			Thread.sleep(300);

			// clickeamos sexo
			WebElement tiposex = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.clickOptTipoSexo);
			wait.until(ExpectedConditions.visibilityOf(tiposex));
			GG_Eventos.clickButton(tiposex);

			Thread.sleep(300);
			// Seleccionar masculino_femenino
			WebElement tiposexo = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.optTipoSexo);
			wait.until(ExpectedConditions.visibilityOf(tiposexo));
			GG_Eventos.clickButton(tiposexo);

			Thread.sleep(300);
			// clickeamos Estado Civil
			WebElement estadocivil = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.clickOptEstadoCivil);
			wait.until(ExpectedConditions.visibilityOf(estadocivil));
			GG_Eventos.clickButton(estadocivil);

			Thread.sleep(300);
			WebElement tipoestadocivil = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.optEstadoCivil);
			wait.until(ExpectedConditions.visibilityOf(tipoestadocivil));
			GG_Eventos.clickButton(tipoestadocivil);

			Thread.sleep(300);
			// Se ingresa Profesión o actividad
			WebElement profesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.profesion);
			wait.until(ExpectedConditions.visibilityOf(profesionElement));
			GG_Eventos.writeOnInput(profesionElement, profesion);

			Thread.sleep(300);
			// Click Ingrese correo electrónico
			WebElement btnmail = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.optEmail);
			wait.until(ExpectedConditions.visibilityOf(btnmail));
			GG_Eventos.clickButton(btnmail);
			Thread.sleep(300);
			//-------------
			// Se ingresa correo electrónco
			WebElement inputmail = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.ingresomail);
			wait.until(ExpectedConditions.visibilityOf(inputmail));
			GG_Eventos.writeOnInput(inputmail, mail);

			Thread.sleep(300);
			// Se ingresa confirmación correo
			WebElement inputmail2 = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.ingresomail2);
			wait.until(ExpectedConditions.visibilityOf(inputmail2));
			GG_Eventos.writeOnInput(inputmail2, mail);

			Thread.sleep(300);
			// Click ¿Su correo es personal o de un tercero? - Personal
			WebElement optmailpersonalotercero = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.mailpersonalotercero);
			wait.until(ExpectedConditions.visibilityOf(optmailpersonalotercero));
			GG_Eventos.clickButton(optmailpersonalotercero);

			Thread.sleep(300);
			
			WebElement optchecknomovil = driver.findElement(By.id("isNoTieneTelefonoFijo"));
			optchecknomovil.click();

			Thread.sleep(300);
			// Se ingresa Teléfono Movil
			WebElement nuMovil = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.numeroMovil);
			wait.until(ExpectedConditions.visibilityOf(nuMovil));
			GG_Eventos.writeOnInput(nuMovil, nmovil);

			Thread.sleep(300);
			// Nivel Educacional
			WebElement educa = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.clickOptNivelEducacional);
			wait.until(ExpectedConditions.visibilityOf(educa));
			GG_Eventos.clickButton(educa);

			Thread.sleep(300);
			
			WebElement educa2 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.optNivelEducacional);
			wait.until(ExpectedConditions.visibilityOf(educa2));
			GG_Eventos.clickButton(educa2);

			Thread.sleep(300);
			// Region
			WebElement region = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.clickOptRegion);
			wait.until(ExpectedConditions.visibilityOf(region));
			GG_Eventos.clickButton(region);

			Thread.sleep(300);
			
			WebElement regionopcion = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.optRegion);
			wait.until(ExpectedConditions.visibilityOf(regionopcion));
			GG_Eventos.clickButton(regionopcion);

			Thread.sleep(300);
			
			// Provincia
			WebElement provincia = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.clickOptProvincia);
			wait.until(ExpectedConditions.visibilityOf(provincia));
			GG_Eventos.clickButton(provincia);

			Thread.sleep(300);
			
			WebElement provinciaopcion = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.optProvincia);
			wait.until(ExpectedConditions.visibilityOf(provinciaopcion));
			GG_Eventos.clickButton(provinciaopcion);
			
			Thread.sleep(300);
			// Comuna
			WebElement comuna = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.clickOptComuna);
			wait.until(ExpectedConditions.visibilityOf(comuna));
			GG_Eventos.clickButton(comuna);

			GG_Eventos.actionScroll(driver, 16);
			Thread.sleep(300);
			// Se activa el Scroll hasta llegar a Rancagua
			WebElement opcComuna = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.optComuna);
			GG_Eventos.scrollToElementAndClick(driver, opcComuna);
			
			Thread.sleep(300);
			// Se ingresa Dirección; Calle
			WebElement dire = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.direccion);
			wait.until(ExpectedConditions.visibilityOf(dire));
			GG_Eventos.writeOnInput(dire, direccion);

			Thread.sleep(300);
			// Se ingresa numeral de la dirección
			WebElement nrodir = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.nroDireccion);
			wait.until(ExpectedConditions.visibilityOf(nrodir));
			GG_Eventos.writeOnInput(nrodir, nrodire);

			Thread.sleep(300);

			// Click en boton continuar
			WebElement btncontinuar1 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnContinuar);
			wait.until(ExpectedConditions.elementToBeClickable(btncontinuar1));
			GG_Eventos.clickButton(btncontinuar1);

			
			// 2- Antecedentes Laborales y Previsionales
			// Situación laboral
			WebElement situlaboral = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.clickSituacionLaboral);
			wait.until(ExpectedConditions.elementToBeClickable(situlaboral));
			GG_Eventos.clickButton(situlaboral);

			Thread.sleep(300);
			
			WebElement situlaboral1 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.optSituacionLaboral);
			wait.until(ExpectedConditions.elementToBeClickable(situlaboral1));
			GG_Eventos.clickButton(situlaboral1);

			Thread.sleep(300);
			// Institución de salud
			WebElement instsalud = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.clickInstitucionSalud);
			wait.until(ExpectedConditions.elementToBeClickable(instsalud));
			GG_Eventos.clickButton(instsalud);
			
			Thread.sleep(300);

			WebElement instsalud1 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.optInstitucionSalud);
			wait.until(ExpectedConditions.elementToBeClickable(instsalud1));
			GG_Eventos.clickButton(instsalud1);

			Thread.sleep(300);
			// Se ingresa Fecha de afiliación al sistema AFP
			WebElement fechaafp = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.fechaAfiliacionAfp);
			wait.until(ExpectedConditions.visibilityOf(fechaafp));
			GG_Eventos.writeOnInput(fechaafp, fechainafp);
			GG_Eventos.actionEnterOnElement(driver, fechaafp);
			Thread.sleep(300);

			// Click ¿Ha realizado cambio de AFP el afiliado? - No
			WebElement cambioafp = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.opcCambioAfp);
			wait.until(ExpectedConditions.elementToBeClickable(cambioafp));
			GG_Eventos.clickButton(cambioafp);

			Thread.sleep(300);
			// Click Se encuentra pensionado por la ley 16.744 - NO
			WebElement ley16744 = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.opcMutualidad);
			wait.until(ExpectedConditions.elementToBeClickable(ley16744));
			GG_Eventos.clickButton(ley16744);

			Thread.sleep(300);
			// Click ¿Cuenta con cobertura del SIS el solicitante? - Si
			WebElement consis = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.coberturaSis);
			wait.until(ExpectedConditions.elementToBeClickable(consis));
			GG_Eventos.clickButton(consis);
			Thread.sleep(500);

			WebElement buttonBuscarDocumento1= elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.subircertificadomedico);
			wait.until(ExpectedConditions.elementToBeClickable(buttonBuscarDocumento1));
			GG_Eventos.clickButton(buttonBuscarDocumento1);
			Thread.sleep(300);			
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
			Thread.sleep(300);
			// Click ¿Está actualmente acogido a una licencia médica el solicitante? - NO
			WebElement limed = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.conLicencia);
			wait.until(ExpectedConditions.elementToBeClickable(limed));
			GG_Eventos.clickButton(limed);
			Thread.sleep(900);

			// Click btn continuar paso 2
			WebElement btnContinuar2 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnContinuarPaso2);
			wait.until(ExpectedConditions.elementToBeClickable(btnContinuar2));
			GG_Eventos.clickButton(btnContinuar2);
			
			Thread.sleep(500);
			
			// 3-Otros datos de la solicitud
			// Click ¿Quién verifica la incapacidad? - Certificado médico
			WebElement optverificarincapacidad = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.verificarincapacidad);
			wait.until(ExpectedConditions.elementToBeClickable(optverificarincapacidad));
			GG_Eventos.clickButton(optverificarincapacidad);
			Thread.sleep(200);

			// Subir Arvhivo Documento de cobertura del solicitante			
			WebElement buttonBuscarDocumento2= elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.Archivo);
			wait.until(ExpectedConditions.elementToBeClickable(buttonBuscarDocumento2));
			GG_Eventos.clickButton(buttonBuscarDocumento2);
			Thread.sleep(300);
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
			
			Thread.sleep(300);
			// Nombre de la persona que verificó la identidad del afiliado en AFP
			WebElement inputPersonaValidaAfiliado = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.nombrePerVerificaIdentidadAfiliado);
			wait.until(ExpectedConditions.visibilityOf(inputPersonaValidaAfiliado));
			GG_Eventos.writeOnInput(inputPersonaValidaAfiliado, personavalidaafiliado);

			Thread.sleep(300);
			// ¿Requiere representación de un tercero?
			WebElement representanteTercero = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.requiereTercero);
			wait.until(ExpectedConditions.elementToBeClickable(representanteTercero));
			GG_Eventos.clickButton(representanteTercero);

			Thread.sleep(300);
			// Entidad administradora del seguro de accidentes del trabajo y enfermedades
			// profesionales que se encuentre adscrito el solicitante
			WebElement nombreAdministradoraSeguro = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.adminDelSeguro);
			wait.until(ExpectedConditions.visibilityOf(nombreAdministradoraSeguro));
			GG_Eventos.writeOnInput(nombreAdministradoraSeguro, administradoradelseguro);

			Thread.sleep(300);
			// Ha sufrido algún accidente del trabajo o enfermedad profesional
			WebElement accidente = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.accidenteTrabajorEnfermedadProfesional);
			wait.until(ExpectedConditions.elementToBeClickable(accidente));
			GG_Eventos.clickButton(accidente);

			Thread.sleep(300);
			// Principal afección o enfermedad por la que solicita este beneficio
			WebElement principalAfeccionOenfermedad = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.afeccionOenfermedad);
			wait.until(ExpectedConditions.visibilityOf(principalAfeccionOenfermedad));
			GG_Eventos.writeOnInput(principalAfeccionOenfermedad, afeccionoenfermedad);

			Thread.sleep(300);
			// Ingrese el porcentaje de cargo del afiliado a la Administradora del arancel
			// establecido por el D.F.L. Nº1, de 2005
			WebElement porcentaje = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.porcentajeAfiliado);
			wait.until(ExpectedConditions.elementToBeClickable(porcentaje));
			GG_Eventos.clickButton(porcentaje);

			Thread.sleep(300);
			// Click btn continuar paso 3
			WebElement btnContinuar3 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnContinuarPaso3);
			GG_Eventos.clickWithJS(driver, btnContinuar3);
			Thread.sleep(500);

			// Incorporar otros antecedentes
			WebElement masAntecedentes = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.incorporarAntecedentes);
			wait.until(ExpectedConditions.elementToBeClickable(masAntecedentes));
			GG_Eventos.clickButton(masAntecedentes);

			// Click btn continuar paso 4
			WebElement btnContinuar4 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnContinuarPaso4);
			wait.until(ExpectedConditions.elementToBeClickable(btnContinuar4));
			GG_Eventos.clickButton(btnContinuar4);

			Thread.sleep(500);

			// Click btn finalizar paso 5
			WebElement btnFinalizar5 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnFinalizarPaso5);
			GG_Eventos.clickWithJS(driver, btnFinalizar5);

			Thread.sleep(1000);

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
			WebElement inputNombreUsuarioElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputUsuario);
			wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
			GG_Eventos.writeOnInput(inputNombreUsuarioElement, adm);

			Thread.sleep(300);

			// Se escribe la Contrasena
			WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputContrasena);
			wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
			GG_Eventos.writeOnInput(inputContrasenaElement, pass);

			Thread.sleep(300);

			// Click en boton ingresar
			WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnIngresar);
			wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
			GG_Eventos.clickButton(buttonIniciarSesionElement);

			Thread.sleep(200);

			// Verifica si se llego a la segunda pantalla.
			WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.validaLoginExitosoFlujoAdm);
			wait.until(ExpectedConditions.visibilityOf(labelPaginaElement));
			String textoPagina = labelPaginaElement.getText();

			GG_Validations.trueBooleanCondition(textoPagina.equalsIgnoreCase("Perfil Administrativo"),
					"Se ha ingresado correctamente a la pagina: " + textoPagina,
					"No se ha ingresado correctamente a la pagina: ", currentEvent);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}

	// Ingresar a nueva solicitud perfil administrativo

	public static void iniciarSolicitudAdministrativo(String rutsolicitantebuscar, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			// Click en boton "Mi Trabajo Administrativo"
			WebElement opcionMiTrabajoAdm = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.opcMiTrabajoAdministrativo);
			wait.until(ExpectedConditions.elementToBeClickable(opcionMiTrabajoAdm));
			GG_Eventos.clickButton(opcionMiTrabajoAdm);

			// Click en opcion Análisis de admisibilidad
			WebElement opcionDeAdmisibilidad = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.analisisAdmisibilidad);
			wait.until(ExpectedConditions.elementToBeClickable(opcionDeAdmisibilidad));
			GG_Eventos.clickButton(opcionDeAdmisibilidad);
			Thread.sleep(1000);

			// Click en text box de Rut a buscar
			WebElement opcrutbuscar = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Revisar_Bitacora.clickopcrutbuscar)));
			opcrutbuscar.click();
			Thread.sleep(300);

			// Se ingresa el rut del solicitante a buscar
			WebElement inputrutsolBuscar = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.rutSolicitanteBuscar);
			wait.until(ExpectedConditions.visibilityOf(inputrutsolBuscar));
			GG_Eventos.writeOnInput(inputrutsolBuscar, rutsolicitantebuscar);
			Thread.sleep(90000);

			// Click en la lupa buscar
			WebElement opcionBuscar = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.opcionLupaBuscar);
			wait.until(ExpectedConditions.elementToBeClickable(opcionBuscar));
			GG_Eventos.clickButton(opcionBuscar);
			Thread.sleep(5000);

			// Click en la opcion ver mas
			WebElement opcVerMas = elementFetch.getWebElement("XPATH", CC_Localizadores_Revisar_Bitacora.opcionVerMas);
			wait.until(ExpectedConditions.elementToBeClickable(opcVerMas));
			GG_Eventos.clickButton(opcVerMas);
			Thread.sleep(5000);

			GG_Eventos.actionScroll(driver, 33);

			// Click en Admisibilidad del caso - 1er Documento - Si, Aprobar
			WebElement opcclicksiprobar1 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.clicksiprobar1);
			wait.until(ExpectedConditions.elementToBeClickable(opcclicksiprobar1));
			GG_Eventos.clickButton(opcclicksiprobar1);
			Thread.sleep(300);

			// Click en Admisibilidad del caso - 2do Documento - Si, Aprobar
			WebElement opcclicksiprobar2 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.clicksiprobar2);
			wait.until(ExpectedConditions.elementToBeClickable(opcclicksiprobar2));
			GG_Eventos.clickButton(opcclicksiprobar2);
			Thread.sleep(300);
			
			WebElement opcclicksiprobar3 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.clicksiprobar3);
			wait.until(ExpectedConditions.elementToBeClickable(opcclicksiprobar3));
			GG_Eventos.clickButton(opcclicksiprobar3);
			Thread.sleep(300);

			// Click en Admisibilidad del caso - Si, Aprobar Final
			WebElement opcclickaprobardoc = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.clickAprobardoc);
			wait.until(ExpectedConditions.elementToBeClickable(opcclickaprobardoc));
			GG_Eventos.clickButton(opcclickaprobardoc);
			Thread.sleep(300);

			// Click btn Confirmar Expediente del Caso
			WebElement btnConfirmarexpecaso = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnContinuarexpedientecaso);
			wait.until(ExpectedConditions.elementToBeClickable(btnConfirmarexpecaso));
			GG_Eventos.clickButton(btnConfirmarexpecaso);
			Thread.sleep(5000);

			// Cerrar Sesion Perfil Administrador
			//WebElement perfilAdministrador = driver
			//		.findElement(By.cssSelector("div.ant-col.ant-col-xs-0.ant-col-md-18 span"));
			//perfilAdministrador.click();
			//Thread.sleep(500);
			//WebElement cerrarSesionadm = driver.findElement(By.xpath("//a[text()='Cerrar sesión']"));
			//cerrarSesionadm.click();
			//Thread.sleep(800);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}

	// iniciar sesion para camino feliz sagcom medico
	public static void iniciarSesionMedico(String medico, String password, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			Thread.sleep(1000);

			// Se escribe el Nombre del Usuario Medico
			WebElement inputMedicoElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputUsuario);
			wait.until(ExpectedConditions.visibilityOf(inputMedicoElement));
			GG_Eventos.writeOnInput(inputMedicoElement, medico);

			Thread.sleep(300);

			// Se escribe la Contrasena
			WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputContrasena);
			wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
			GG_Eventos.writeOnInput(inputContrasenaElement, password);

			Thread.sleep(300);

			// Click en boton ingresar
			WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnIngresar);
			wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
			GG_Eventos.clickButton(buttonIniciarSesionElement);

			Thread.sleep(200);
			
			  // Verifica si se llego a la segunda pantalla.
			WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",
			  CC_Localizadores_Revisar_Bitacora.validaLoginExitosoFlujoMedico);
			  wait.until(ExpectedConditions.visibilityOf(labelPaginaElement)); String
			  textoPagina = labelPaginaElement.getText();
			  
			  GG_Validations.trueBooleanCondition(textoPagina.equalsIgnoreCase("Perfil Médico Presidente"),
			  "Se ha ingresado correctamente a la pagina: " + textoPagina,
			  "No se ha ingresado correctamente a la pagina: ", currentEvent);
			 
		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}

	// Ingresar a nueva solicitud perfil medico

	public static void iniciarSolicitudMedico(String rutparabuscar, String comentarios1, String pulso, String presion,
			String talla, String peso, String buscarcodigocie10,  String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();
	

			// Click en boton "Mi Trabajo"
			WebElement opcionMiTrabajomedpresi = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.opcMiTrabajomedicopresidente);
			wait.until(ExpectedConditions.elementToBeClickable(opcionMiTrabajomedpresi));
			GG_Eventos.clickButton(opcionMiTrabajomedpresi);

			// Click en opcion Análisis de admisibilidad
			WebElement opcionexpediente = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.opcExpedientes);
			wait.until(ExpectedConditions.elementToBeClickable(opcionexpediente));
			GG_Eventos.clickButton(opcionexpediente);
			Thread.sleep(9000);

			// Click en text box Rut a buscar
			WebElement opcrutbuscarmedpresi = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Revisar_Bitacora.clickopcrutbuscarmedpresi)));
			opcrutbuscarmedpresi.click();
			Thread.sleep(300);

			// Se ingresa el rut del solicitante a buscar
			WebElement inputrutBuscarmedpresi = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.rutSolicitanteBuscarmedipre);
			wait.until(ExpectedConditions.visibilityOf(inputrutBuscarmedpresi));
			GG_Eventos.writeOnInput(inputrutBuscarmedpresi, rutparabuscar);
			Thread.sleep(9000);

			// Click en la lupa buscar
			WebElement opcionBuscarmedpresi = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.opcionLupaBuscarmedpresi);
			wait.until(ExpectedConditions.elementToBeClickable(opcionBuscarmedpresi));
			GG_Eventos.clickButton(opcionBuscarmedpresi);
			Thread.sleep(5000);

			// Click en la opcion ver mas
			WebElement opcVerMasmedpresi = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.opcionVerMasmedpresi);
			wait.until(ExpectedConditions.elementToBeClickable(opcVerMasmedpresi));
			GG_Eventos.clickButton(opcVerMasmedpresi);
			Thread.sleep(5000);

			// Click en la opcion ver mas
			WebElement opcevaluacionmedpresi = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.opcevaluacionmedica);
			wait.until(ExpectedConditions.elementToBeClickable(opcevaluacionmedpresi));
			GG_Eventos.clickButton(opcevaluacionmedpresi);
			Thread.sleep(2000);

			GG_Eventos.actionScroll(driver, 8);

			// ingresa comentario en Antecedentes personales y/o laborales y/o mórbidos
			WebElement inputAntecedentespersonales = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.Inputantecedentesper);
			wait.until(ExpectedConditions.visibilityOf(inputAntecedentespersonales));
			GG_Eventos.writeOnInput(inputAntecedentespersonales, comentarios1);

			// Cursa con licencia médica - NO
			WebElement opccursalicenciamedica = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.cursalicenciamedica);
			wait.until(ExpectedConditions.elementToBeClickable(opccursalicenciamedica));
			GG_Eventos.clickButton(opccursalicenciamedica);

			// ingresa comentario en Anamnesis y cronología de la evolución
			WebElement inputAnamnesisycronologia = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputAnamnesisycronolo);
			wait.until(ExpectedConditions.visibilityOf(inputAnamnesisycronologia));
			GG_Eventos.writeOnInput(inputAnamnesisycronologia, comentarios1);

			// ingresa comentario en Tratamiento actual o reciente
			WebElement inputratamientoactual = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputtratamientoactual);
			wait.until(ExpectedConditions.visibilityOf(inputratamientoactual));
			GG_Eventos.writeOnInput(inputratamientoactual, comentarios1);

			// ingresa comentario Otros Tratamientos
			WebElement inputotrotratamiento = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputotrostratamientos);
			wait.until(ExpectedConditions.visibilityOf(inputotrotratamiento));
			GG_Eventos.writeOnInput(inputotrotratamiento, comentarios1);

			// ingresa comentario Seleccione las Actividades Esenciales interferidas
			WebElement inputoactividadesescenciales = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputcomentarioEscenciales);
			wait.until(ExpectedConditions.visibilityOf(inputoactividadesescenciales));
			GG_Eventos.writeOnInput(inputoactividadesescenciales, comentarios1);

			// ingresa comentario Seleccione las Actividades Domésticas interferidas
			WebElement inputcomentariosdomesticos = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputcomentariosdomesticos);
			wait.until(ExpectedConditions.visibilityOf(inputcomentariosdomesticos));
			GG_Eventos.writeOnInput(inputcomentariosdomesticos, comentarios1);

			// ingresa comentario Seleccione las Actividades de Desplazamiento interferidas
			WebElement inputcomentariosdesplazamiento = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputcomentarioDesplazamiento);
			wait.until(ExpectedConditions.visibilityOf(inputcomentariosdesplazamiento));
			GG_Eventos.writeOnInput(inputcomentariosdesplazamiento, comentarios1);

			// ingresa comentario Seleccione las Actividades de Desplazamiento interferidas
			WebElement inputcomentariosociales = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputcomentariosociales);
			wait.until(ExpectedConditions.visibilityOf(inputcomentariosociales));
			GG_Eventos.writeOnInput(inputcomentariosociales, comentarios1);

			// Sospecha de invalidez previa - NO
			WebElement opcsospechainvalidez = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.sospechainvalidez);
			wait.until(ExpectedConditions.elementToBeClickable(opcsospechainvalidez));
			GG_Eventos.clickButton(opcsospechainvalidez);

			//
			//
			//
			
			// Botonera Guardar Evaluación Médica
			WebElement btnguardarevaluacionmedica = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnguardarevamedica);
			wait.until(ExpectedConditions.elementToBeClickable(btnguardarevaluacionmedica));
			GG_Eventos.clickButton(btnguardarevaluacionmedica);

			// ingresa en Examen Físico - Pulso
			WebElement inputExFisicopulso = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputpulsaciones);
			wait.until(ExpectedConditions.visibilityOf(inputExFisicopulso));
			GG_Eventos.writeOnInput(inputExFisicopulso, pulso);

			// ingresa en Examen Físico - Presión
			WebElement inputExFisicopresion = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputpresion);
			wait.until(ExpectedConditions.visibilityOf(inputExFisicopresion));
			GG_Eventos.writeOnInput(inputExFisicopresion, presion);

			// ingresa en Examen Físico - Talla
			WebElement inputExFisicotalla = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputalla);
			wait.until(ExpectedConditions.visibilityOf(inputExFisicotalla));
			GG_Eventos.writeOnInput(inputExFisicotalla, talla);

			// ingresa en Examen Físico - Peso
			WebElement inputExFisicopeso = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputpeso);
			wait.until(ExpectedConditions.visibilityOf(inputExFisicopeso));
			GG_Eventos.writeOnInput(inputExFisicopeso, peso);

			// ingresa comentario Examen Físico - Impedimentos a considerar
			WebElement inputExfisicoimpedimentoconsiderar = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.impedimentoconsiderar);
			wait.until(ExpectedConditions.visibilityOf(inputExfisicoimpedimentoconsiderar));
			GG_Eventos.writeOnInput(inputExfisicoimpedimentoconsiderar, comentarios1);

			// Botonera Guardar Examen Físico
			WebElement btnguardarexamenfisico = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnguardaexamenfisico);
			wait.until(ExpectedConditions.elementToBeClickable(btnguardarexamenfisico));
			GG_Eventos.clickButton(btnguardarexamenfisico);

			// Acción a seguir - Cierre de caso
			WebElement optplanaccion = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Revisar_Bitacora.clickOptplanaccion)));
			optplanaccion.click();

			WebElement clicckplanaccion = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Revisar_Bitacora.optclicckplanaccion)));
			clicckplanaccion.click();

			// ingresa comentario Argumentos, configuración, menoscabos y comentario final
			WebElement inputplanaccioncomentarioFinal = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputcomentariofinal);
			wait.until(ExpectedConditions.visibilityOf(inputplanaccioncomentarioFinal));
			GG_Eventos.writeOnInput(inputplanaccioncomentarioFinal, comentarios1);
			Thread.sleep(1000);

			GG_Eventos.actionScroll(driver, 8);

			// ¿Existen impedimentos configurados del mismo capítulo que afectan la misma
			// área de AVD y se... - NO
			WebElement opcAVD = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.opcconfiguracionAVD);
			wait.until(ExpectedConditions.elementToBeClickable(opcAVD));
			GG_Eventos.clickButton(opcAVD);
			Thread.sleep(1000);

			// Botonera Configurar y Agregar Impedimentos
			WebElement btnconfiagreimpe = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnconfiguraragregarimpedimento);
			wait.until(ExpectedConditions.elementToBeClickable(btnconfiagreimpe));
			GG_Eventos.clickButton(btnconfiagreimpe);
			Thread.sleep(500);

			// Botonera agregar Otro Impedimento
			WebElement btnotroimpedimento = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnagregarotroimpedimento);
			wait.until(ExpectedConditions.elementToBeClickable(btnotroimpedimento));
			GG_Eventos.clickButton(btnotroimpedimento);
			Thread.sleep(1000);

			// ingresa comentario en Plan de Acción - Configurar y Agregar Impedimentos
			WebElement inputotroimpedimentoagregarnuevoimpedimento = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputagregarimpedimento);
			wait.until(ExpectedConditions.visibilityOf(inputotroimpedimentoagregarnuevoimpedimento));
			GG_Eventos.writeOnInput(inputotroimpedimentoagregarnuevoimpedimento, comentarios1);
			Thread.sleep(2000);

			// Seleccionar en Configuración la opción NO - Así habilita los campos Clase y
			// rango
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			WebElement cie10Switch = wait.until(ExpectedConditions.elementToBeClickable(By.id("isCie10")));
			cie10Switch.click();
			String estado = cie10Switch.getAttribute("aria-checked");
			if (!"true".equals(cie10Switch.getAttribute("aria-checked"))) {
				cie10Switch.click(); // Encenderlo si está apagado
			}

			// Click en menú desplegable de Clase
			WebElement optplanaccionmenuclase = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Revisar_Bitacora.clickOptmenuclase)));
			optplanaccionmenuclase.click();
			// Seleccionar Clase de valor "IV"
			WebElement clickplanaccionmenuclase = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Revisar_Bitacora.optclickmenuclase)));
			clickplanaccionmenuclase.click();

			// Click en menú desplegable de Rango
			WebElement optplanaccionmenurango = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Revisar_Bitacora.clickOptmenurango)));
			optplanaccionmenurango.click();
			// Seleccionar Clase de valor "Alto"
			WebElement clickplanaccionmenurango = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Revisar_Bitacora.optclickmenurango)));
			clickplanaccionmenurango.click();
			Thread.sleep(2000);

			// Botonera Agregar Otro Impedimento
			WebElement btnagregarotroimpedimento = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnagregarimpedimento);
			wait.until(ExpectedConditions.elementToBeClickable(btnagregarotroimpedimento));
			GG_Eventos.clickButton(btnagregarotroimpedimento);
			Thread.sleep(3000);

			// ¿Existen impedimentos configurados del mismo capítulo que afectan la misma
			// área de AVD y se... - NO
			WebElement opcAVD2 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.opcconfiguracionAVD);
			wait.until(ExpectedConditions.elementToBeClickable(opcAVD2));
			GG_Eventos.clickButton(opcAVD2);

			GG_Eventos.actionScroll(driver, 8);

			// Asignar cie 10
			WebElement opclinkasignarcie10 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.opcasignarcie10);
			wait.until(ExpectedConditions.elementToBeClickable(opclinkasignarcie10));
			GG_Eventos.clickButton(opclinkasignarcie10);
			Thread.sleep(2000);

			// Filtrar en Asignar código cie10
			WebElement inputbusquedacodigocie10 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.inputcodigocie10);
			wait.until(ExpectedConditions.visibilityOf(inputbusquedacodigocie10));
			GG_Eventos.writeOnInput(inputbusquedacodigocie10, buscarcodigocie10);

			// Presionar lupa de Asignar código cie10
			WebElement opcionlupacie10 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.optlupacie10);
			wait.until(ExpectedConditions.elementToBeClickable(opcionlupacie10));
			GG_Eventos.clickButton(opcionlupacie10);
			Thread.sleep(1000);

			// click en cabecera llamada Nombre
			WebElement clickcabeceranombre = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(CC_Localizadores_Revisar_Bitacora.clickencabeceranombre)));
			clickcabeceranombre.click();
			Thread.sleep(3000);

			// Asignar código cie10 - O22 COMPLICACIONES VENOSAS DEL EMBARAZO
			WebDriverWait wait3 = new WebDriverWait(driver, 10);
			WebElement btnradio = driver.findElement(By.cssSelector("tr[data-row-key='1'] input.ant-radio-input"));
			btnradio.click();
			Thread.sleep(3000);

			// Botonera Asignar cie10
			WebElement btnasignarciel0 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnagregarasignarcie10codigo);
			wait.until(ExpectedConditions.elementToBeClickable(btnasignarciel0));
			GG_Eventos.clickButton(btnasignarciel0);
			Thread.sleep(3000);

			// Invalidez Previa - NO
			WebElement opcinvalidezprevi = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.opcinvalidezprevia);
			wait.until(ExpectedConditions.elementToBeClickable(opcinvalidezprevi));
			GG_Eventos.clickButton(opcinvalidezprevi);
			Thread.sleep(6000);

			// Botonera Guardar Plan de Acción
			WebElement btnguardaplanaccion = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnguardarplandeaccion);
			wait.until(ExpectedConditions.elementToBeClickable(btnguardaplanaccion));
			GG_Eventos.clickButton(btnguardaplanaccion);
			
			//GG_Eventos.subirScroll(driver, 30);
			Thread.sleep(1500);

			// Botonera Enviar a Sesión
			WebElement btnenviarsesion = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.btnenviarasesion);
			wait.until(ExpectedConditions.elementToBeClickable(btnenviarsesion));
			GG_Eventos.clickButton(btnenviarsesion);
			Thread.sleep(2000);

			// Botonera Bitacora
			WebElement btnlinkBitacora = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.linkBitacora);
			wait.until(ExpectedConditions.elementToBeClickable(btnlinkBitacora));
			GG_Eventos.clickButton(btnlinkBitacora);		

			// Botonera Descargar Bitacora
			WebElement btnbajarBitacora = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Revisar_Bitacora.BajarBitacora);
			wait.until(ExpectedConditions.elementToBeClickable(btnbajarBitacora));
			GG_Eventos.clickButton(btnbajarBitacora);
			Thread.sleep(2000);
			
			// Cerrar Sesion Perfil Administrador
			WebElement perfilPresidenteMedico = driver
					.findElement(By.cssSelector("div.ant-col.ant-col-xs-0.ant-col-md-18 span"));
			perfilPresidenteMedico.click();
			Thread.sleep(500);
			WebElement cerrarSesionPresiMedico = driver.findElement(By.xpath("//a[text()='Cerrar sesión']"));
			cerrarSesionPresiMedico.click();
			Thread.sleep(800);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}

}