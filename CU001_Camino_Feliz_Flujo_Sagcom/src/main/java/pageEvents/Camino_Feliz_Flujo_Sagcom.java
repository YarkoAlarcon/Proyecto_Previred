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

import java.util.List;

//En esta clase se ejecutan los Pasos de la Pagina.
public class Camino_Feliz_Flujo_Sagcom extends CC_Test {

	public Camino_Feliz_Flujo_Sagcom(WebDriver driver) {
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
			String direccion, String nrodire, String fechainafp, String personavalidaafiliado,
			String administradoradelseguro, String afeccionoenfermedad, String xNumero) {

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

			// Seleccionar masculino_femenino
			WebElement tiposexo = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.optTipoSexo);
			wait.until(ExpectedConditions.visibilityOf(tiposexo));
			GG_Eventos.clickButton(tiposexo);

			// clickeamos Estado Civil
			WebElement estadocivil = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickOptEstadoCivil);
			wait.until(ExpectedConditions.visibilityOf(estadocivil));
			GG_Eventos.clickButton(estadocivil);

			WebElement tipoestadocivil = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.optEstadoCivil);
			wait.until(ExpectedConditions.visibilityOf(tipoestadocivil));
			GG_Eventos.clickButton(tipoestadocivil);

			// Se ingresa Profesión o actividad
			WebElement profesionElement = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.profesion);
			wait.until(ExpectedConditions.visibilityOf(profesionElement));
			GG_Eventos.writeOnInput(profesionElement, profesion);

			// Click Ingrese correo electrónico
			WebElement btnmail = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.optEmail);
			wait.until(ExpectedConditions.visibilityOf(btnmail));
			GG_Eventos.clickButton(btnmail);
			
			Thread.sleep(300);

			WebElement optcheckFijo = driver.findElement(By.id("isNoTieneTelefonoFijo"));
			optcheckFijo.click();
			Thread.sleep(300);
			
			// Se ingresa Teléfono móvil
			WebElement numovil = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.numeroMovil);
			wait.until(ExpectedConditions.visibilityOf(numovil));
			GG_Eventos.writeOnInput(numovil, nmovil);

			// Nivel Educacional
			WebElement educa = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Flujo_Sagcom.clickOptNivelEducacional);
			wait.until(ExpectedConditions.visibilityOf(educa));
			GG_Eventos.clickButton(educa);

			WebElement educa2 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.optNivelEducacional);
			wait.until(ExpectedConditions.visibilityOf(educa2));
			GG_Eventos.clickButton(educa2);

			// Region
			WebElement region = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.clickOptRegion);
			wait.until(ExpectedConditions.visibilityOf(region));
			GG_Eventos.clickButton(region);

			WebElement regionopcion = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.optRegion);
			wait.until(ExpectedConditions.visibilityOf(regionopcion));
			GG_Eventos.clickButton(regionopcion);

			// Provincia
			WebElement provincia = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.clickOptProvincia);
			wait.until(ExpectedConditions.visibilityOf(provincia));
			GG_Eventos.clickButton(provincia);
			;

			WebElement provinciaopcion = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.optProvincia);
			wait.until(ExpectedConditions.visibilityOf(provinciaopcion));
			GG_Eventos.clickButton(provinciaopcion);

			// Comuna
			WebElement comuna = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.clickOptComuna);
			wait.until(ExpectedConditions.visibilityOf(comuna));
			GG_Eventos.clickButton(comuna);

			GG_Eventos.actionScroll(driver,16);

			// Se activa el Scroll hasta llegar a Rancagua
			WebElement opcComuna = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.optComuna);
			GG_Eventos.scrollToElementAndClick(driver, opcComuna);

			// Se ingresa Dirección; Calle
			WebElement dire = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.direccion);
			wait.until(ExpectedConditions.visibilityOf(dire));
			GG_Eventos.writeOnInput(dire, direccion);

			// Se ingresa numeral de la dirección
			WebElement nrodir = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.nroDireccion);
			wait.until(ExpectedConditions.visibilityOf(nrodir));
			GG_Eventos.writeOnInput(nrodir, nrodire);

			// Click en boton continuar
			WebElement btncontinuar1 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.btnContinuar);
			wait.until(ExpectedConditions.elementToBeClickable(btncontinuar1));
			GG_Eventos.clickButton(btncontinuar1);

			// Situación laboral
			WebElement situlaboral = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickSituacionLaboral);
			wait.until(ExpectedConditions.elementToBeClickable(situlaboral));
			GG_Eventos.clickButton(situlaboral);

			WebElement situlaboral1 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.optSituacionLaboral);
			wait.until(ExpectedConditions.elementToBeClickable(situlaboral1));
			GG_Eventos.clickButton(situlaboral1);
			;

			// Institución de salud
			WebElement instsalud = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickInstitucionSalud);
			wait.until(ExpectedConditions.elementToBeClickable(instsalud));
			GG_Eventos.clickButton(instsalud);
			;

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

			// Click Se encuentra pensionado por la ley 16.744
			WebElement ley16744 = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.opcMutualidad);
			wait.until(ExpectedConditions.elementToBeClickable(ley16744));
			GG_Eventos.clickButton(ley16744);

			// Click ¿Cuenta con cobertura del SIS el solicitante?
			WebElement consis = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.coberturaSis);
			wait.until(ExpectedConditions.elementToBeClickable(consis));
			GG_Eventos.clickButton(consis);

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

			// Nombre de la persona que verificó la identidad del afiliado en AFP
			WebElement inputPersonaValidaAfiliado = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.nombrePerVerificaIdentidadAfiliado);
			wait.until(ExpectedConditions.visibilityOf(inputPersonaValidaAfiliado));
			GG_Eventos.writeOnInput(inputPersonaValidaAfiliado, personavalidaafiliado);

			// ¿Requiere representación de un tercero?
			WebElement representanteTercero = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.requiereTercero);
			wait.until(ExpectedConditions.elementToBeClickable(representanteTercero));
			GG_Eventos.clickButton(representanteTercero);

			// Entidad administradora del seguro de accidentes del trabajo y enfermedades
			// profesionales que se encuentre adscrito el solicitante
			WebElement nombreAdministradoraSeguro = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.adminDelSeguro);
			wait.until(ExpectedConditions.visibilityOf(nombreAdministradoraSeguro));
			GG_Eventos.writeOnInput(nombreAdministradoraSeguro, administradoradelseguro);

			// Ha sufrido algún accidente del trabajo o enfermedad profesional
			WebElement accidente = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.accidenteTrabajorEnfermedadProfesional);
			wait.until(ExpectedConditions.elementToBeClickable(accidente));
			GG_Eventos.clickButton(accidente);

			// Principal afección o enfermedad por la que solicita este beneficio
			WebElement principalAfeccionOenfermedad = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.afeccionOenfermedad);
			wait.until(ExpectedConditions.visibilityOf(principalAfeccionOenfermedad));
			GG_Eventos.writeOnInput(principalAfeccionOenfermedad, afeccionoenfermedad);

			// Ingrese el porcentaje de cargo del afiliado a la Administradora del arancel
			// establecido por el D.F.L. Nº1, de 2005
			WebElement porcentaje = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.porcentajeAfiliado);
			wait.until(ExpectedConditions.elementToBeClickable(porcentaje));
			GG_Eventos.clickButton(porcentaje);

			// Click btn continuar paso 3
			WebElement btnContinuar3 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnContinuarPaso3);
			GG_Eventos.clickWithJS(driver, btnContinuar3);
			Thread.sleep(500);

			// Incorporar otros antecedentes
			WebElement masAntecedentes = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.incorporarAntecedentes);
			wait.until(ExpectedConditions.elementToBeClickable(masAntecedentes));
			GG_Eventos.clickButton(masAntecedentes);

			// Click btn continuar paso 4
			WebElement btnContinuar4 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnContinuarPaso4);
			wait.until(ExpectedConditions.elementToBeClickable(btnContinuar4));
			GG_Eventos.clickButton(btnContinuar4);
			
			Thread.sleep(500);

			// Click btn finalizar paso 5
			WebElement btnFinalizar5 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnFinalizarPaso5);
			GG_Eventos.clickWithJS(driver, btnFinalizar5);
			
			Thread.sleep(100000);

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

	public static void iniciarSolicitudAdministrativo(String rutsolicitantebuscar,String xNumero) {

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
			
			GG_Eventos.actionScroll(driver,40);
			
			Thread.sleep(5000);
			
			// Click en Admisibilidad de la solicitud
			WebElement admisibilidadSolicitud = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.admisibilidadSolicitud);
			wait.until(ExpectedConditions.elementToBeClickable(admisibilidadSolicitud));
			GG_Eventos.clickButton(admisibilidadSolicitud);
			
			Thread.sleep(5000);
			
			// Click en boton confirmar
			WebElement btnConfirmar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnConfirmar);
			wait.until(ExpectedConditions.elementToBeClickable(btnConfirmar));
			GG_Eventos.clickButton(btnConfirmar);
			
			Thread.sleep(10000);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
	
	// iniciar sesion para camino feliz sagcom medico presidente
	
		public static void iniciarSesionMedicoPresidente(String medicopresidente, String password,String xNumero) {

			String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

			try {
				GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

				WebDriverWait wait = new WebDriverWait(driver, 50);
				GG_ElementFetch elementFetch = new GG_ElementFetch();

				Thread.sleep(1000);

				// Se escribe el Nombre del Usuario Medico
				WebElement inputMedicoElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputUsuario);
				wait.until(ExpectedConditions.visibilityOf(inputMedicoElement));
				GG_Eventos.writeOnInput(inputMedicoElement, medicopresidente);

				Thread.sleep(300);

				// Se escribe la Contrasena
				WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputContrasena);
				wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
				GG_Eventos.writeOnInput(inputContrasenaElement, password);

				Thread.sleep(300);

				// Click en boton ingresar
				WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnIngresar);
				wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
				GG_Eventos.clickButton(buttonIniciarSesionElement);

				Thread.sleep(200);

				// Verifica si se llego a la segunda pantalla.
				WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.validaLoginExitosoFlujoMedico);
				wait.until(ExpectedConditions.visibilityOf(labelPaginaElement));
				String textoPagina = labelPaginaElement.getText();

				GG_Validations.trueBooleanCondition(
						textoPagina.equalsIgnoreCase("Perfil Médico Presidente"),
						"Se ha ingresado correctamente a la pagina: " + textoPagina,
						"No se ha ingresado correctamente a la pagina: ", currentEvent);

			} catch (Exception e) {
				GG_Utils.eventFailed(currentEvent, e.getMessage());
			}
		}
		
		// Ingresar a nueva solicitud perfil medico presidente

		public static void iniciarSolicitudMedicoPresidente(String rutparabuscar,String xNumero) {

			String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

			try {
				GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

				WebDriverWait wait = new WebDriverWait(driver, 50);
				GG_ElementFetch elementFetch = new GG_ElementFetch();

				// Click en opcion Mi Trabajo
				WebElement opcionMiTrabajo = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcMiTrabajo);
				wait.until(ExpectedConditions.elementToBeClickable(opcionMiTrabajo));
				GG_Eventos.clickButton(opcionMiTrabajo);
				
				GG_Eventos.actionScroll(driver,5);
				
				Thread.sleep(1000);
				
				// Click en opción asignar médico
				//ElementFetch elementFetch = new ElementFetch(driver);

				// Click en opción Asignar Médico
				WebElement opcionAsigMedico = elementFetch.getWebElement("XPATH", CC_Localizadores_Flujo_Sagcom.opcionAsignarMedico);
				wait.until(ExpectedConditions.elementToBeClickable(opcionAsigMedico));
				GG_Eventos.clickButton(opcionAsigMedico);
				
				// Click en opcion regular
				WebElement opcionRegular = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcionRegular);
				wait.until(ExpectedConditions.elementToBeClickable(opcionRegular));
				GG_Eventos.clickButton(opcionRegular);
				
				GG_Eventos.actionScroll(driver,5);
				
				Thread.sleep(8000);
				
				// Se escribe el rut del solicitante a buscar
				WebElement rutBuscar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.ingresarRutAbuscar);
				wait.until(ExpectedConditions.visibilityOf(rutBuscar));
				GG_Eventos.writeOnInput(rutBuscar, rutparabuscar);
				
				Thread.sleep(9000);
				
				// Click en lupa para buscar por rut del solicitante
				WebElement clickLupa = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickLupaBuscar);
				wait.until(ExpectedConditions.elementToBeClickable(clickLupa));
				GG_Eventos.clickButton(clickLupa);
				
				Thread.sleep(6000);
				
				// Click en acciones para desplegar opciones
				WebElement acciones = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickAcciones);
				wait.until(ExpectedConditions.elementToBeClickable(acciones));
				GG_Eventos.clickButton(acciones);
				
				// Click en opcion modificar
				WebElement opcModificar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickOpcionModificar);
				wait.until(ExpectedConditions.elementToBeClickable(opcModificar));
				GG_Eventos.clickButton(opcModificar);
				
				Thread.sleep(6000);
				
				// Click en opcion medico disponible por defecto
				//WebElement opcMedicoDisponible = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickMedicoDisponible);				
				//GG_Eventos.clickJavaScript(driver,opcMedicoDisponible);
				
				String nombreMedico = "Medico Prueba Auto";
				String xpath = "//tr[td[2][normalize-space()='" + nombreMedico + "']]//input[@type='radio']";
				WebElement radio = driver.findElement(By.xpath(xpath));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radio);
				radio.click(); // O usa tu método GG_Eventos.clickButton(radio);

				
				//GG_Eventos.actionScroll(driver,10);
				
				Thread.sleep(3000);
				
				// Click en boton confirmar medico
				WebElement clickConfirmarMedico = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickConfirmarMedico);
				wait.until(ExpectedConditions.elementToBeClickable(clickConfirmarMedico));
				GG_Eventos.clickButton(clickConfirmarMedico);
				
				Thread.sleep(1000);
				
			} catch (Exception e) {
				GG_Utils.eventFailed(currentEvent, e.getMessage());
			}
	  }
		
		// iniciar sesion para camino feliz sagcom perfil administrativo 1
		public static void iniciarSesionAdministrativo1(String adm1,String pass1,String xNumero) {

				String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

				try {
					GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

					WebDriverWait wait = new WebDriverWait(driver, 50);
					GG_ElementFetch elementFetch = new GG_ElementFetch();

					Thread.sleep(1000);

					// Se escribe el Nombre del Usuario
					WebElement inputNombreUsuarioElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputUsuario);
					wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
					GG_Eventos.writeOnInput(inputNombreUsuarioElement, adm1);

					Thread.sleep(300);

					// Se escribe la Contrasena
					WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputContrasena);
					wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
					GG_Eventos.writeOnInput(inputContrasenaElement, pass1);

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
					
					Thread.sleep(3000);

				} catch (Exception e) {
					GG_Utils.eventFailed(currentEvent, e.getMessage());
				}
				
		}
				
		// Ingresar a nueva solicitud perfil administrativo 1

		public static void iniciarSolicitudAdministrativo1(String rutsolicitantebuscar,String xNumero) {

			String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

			try {
				GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

				WebDriverWait wait = new WebDriverWait(driver, 50);
				GG_ElementFetch elementFetch = new GG_ElementFetch();

				// Click en boton "Mi Trabajo Administrativo"
				WebElement opcionMiTrabajoAdm = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcMiTrabajoAdministrativo);
				wait.until(ExpectedConditions.elementToBeClickable(opcionMiTrabajoAdm));
				GG_Eventos.clickButton(opcionMiTrabajoAdm);
				
				// Click en boton "Mi Trabajo Administrativo"
				WebElement opcionCitaciones = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcionCitaciones);
				wait.until(ExpectedConditions.elementToBeClickable(opcionCitaciones));
				GG_Eventos.clickButton(opcionCitaciones);
				
				// Click en opcion Expedientes por tipo de prioridad
				WebElement opcionExpedienteTipoPrioridad = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.expedienteTipoPrioridad1);
				GG_Eventos.validaObjetoIsSelect(driver,opcionExpedienteTipoPrioridad);
				
				Thread.sleep(3000);
				
				// Se ingresa el rut del solicitante a buscar
				WebElement inputrutsolBuscar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.rutSolicitanteBuscar);
				wait.until(ExpectedConditions.visibilityOf(inputrutsolBuscar));
				GG_Eventos.writeOnInput(inputrutsolBuscar, rutsolicitantebuscar);
				
				// Click en la lupa buscar
				WebElement opcionBuscar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcionLupaBuscar);
				wait.until(ExpectedConditions.elementToBeClickable(opcionBuscar));
				GG_Eventos.clickButton(opcionBuscar);
				
				Thread.sleep(300);
				
				// Click en acciones para desplegar opciones
				WebElement acciones = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcClickAcciones);
				wait.until(ExpectedConditions.elementToBeClickable(acciones));
				GG_Eventos.clickButton(acciones);
				
				// Click en opcion reagendar
				WebElement reagendar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcClickReagendar);
				wait.until(ExpectedConditions.elementToBeClickable(reagendar));
				GG_Eventos.clickButton(reagendar);
				
				Thread.sleep(800);
				
				// Click en hora disponible medico
				WebElement horaMedico = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.seleccionarHoraDisponible);
				wait.until(ExpectedConditions.elementToBeClickable(horaMedico));
				GG_Eventos.clickButton(horaMedico);
				
				
				// Click en el boton confirmar
				WebElement botonConfirmar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.botonConfirmar);
				wait.until(ExpectedConditions.elementToBeClickable(botonConfirmar));
				GG_Eventos.clickButton(botonConfirmar);
				
				Thread.sleep(3000);
				
				// Click en acciones para desplegar opciones
				WebElement acciones1 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcClickAcciones);
				wait.until(ExpectedConditions.elementToBeClickable(acciones1));
				GG_Eventos.clickButton(acciones1);
				
				Thread.sleep(3000);
				
				// Click en opcion gestionar citacion
				WebElement gestionaeCitacion = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.gestionarCitacion);
				wait.until(ExpectedConditions.elementToBeClickable(gestionaeCitacion));
				GG_Eventos.clickButton(gestionaeCitacion);
				Thread.sleep(3000);
				// Click en opcion previsualizar carta
				WebElement verCarta = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.previsualizarCarta);
				wait.until(ExpectedConditions.elementToBeClickable(verCarta));
				GG_Eventos.clickButton(verCarta);
				Thread.sleep(3000);
				// Click en opcion confifrmar cita
				WebElement confirmarCita = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnConfirmarCita);
				wait.until(ExpectedConditions.elementToBeClickable(confirmarCita));
				GG_Eventos.clickButton(confirmarCita);
				
				Thread.sleep(1000);


			} catch (Exception e) {
				GG_Utils.eventFailed(currentEvent, e.getMessage());
			}
			
		}		
		
		// iniciar sesion para camino feliz sagcom perfil administrativo 2
			public static void iniciarSesionAdministrativo2(String adm2,String pass2,String xNumero) {

					String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

					try {
						GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

						WebDriverWait wait = new WebDriverWait(driver, 50);
						GG_ElementFetch elementFetch = new GG_ElementFetch();

						Thread.sleep(1000);

						// Se escribe el Nombre del Usuario
						WebElement inputNombreUsuarioElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputUsuario);
						wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
						GG_Eventos.writeOnInput(inputNombreUsuarioElement, adm2);

						Thread.sleep(300);

						// Se escribe la Contrasena
						WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputContrasena);
						wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
						GG_Eventos.writeOnInput(inputContrasenaElement, pass2);

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
						
						Thread.sleep(3000);

					} catch (Exception e) {
						GG_Utils.eventFailed(currentEvent, e.getMessage());
					}
					
			}
					
			// Ingresar a nueva solicitud perfil administrativo 2

			public static void iniciarSolicitudAdministrativo2(String rutsolicitantebuscar1,String horaInicio, String horaFinal, String xNumero) {

				String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

				try {
					GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

					WebDriverWait wait = new WebDriverWait(driver, 50);
					GG_ElementFetch elementFetch = new GG_ElementFetch();

					// Click en boton "Mi Trabajo Administrativo"
					WebElement opcionMiTrabajoAdm = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcMiTrabajoAdministrativo);
					wait.until(ExpectedConditions.elementToBeClickable(opcionMiTrabajoAdm));
					GG_Eventos.clickButton(opcionMiTrabajoAdm);
					
					// Click en boton "Mi Trabajo Administrativo"
					WebElement asistenciaMedica = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.asistencia);
					wait.until(ExpectedConditions.elementToBeClickable(asistenciaMedica));
					GG_Eventos.clickButton(asistenciaMedica);
					
					// Comisiones
					WebElement comisiones = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.comisiones);
					String validaTextRancagua = comisiones.getText();
					Assert.assertEquals(validaTextRancagua, "Rancagua");
					
					Thread.sleep(1000);
					
					// Modalidad de evaluación médica
					WebElement evaluacionMedica = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.modalidadEvaluacion);
					wait.until(ExpectedConditions.elementToBeClickable(evaluacionMedica));
					GG_Eventos.clickButton(evaluacionMedica);
					
					Thread.sleep(3000);
					//GG_Eventos.actionScroll(driver,4);

					
					
					// Se ingresa el rut del solicitante a buscar
					WebElement inputrutsolBuscar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.rutSolicitanteBuscar);
					wait.until(ExpectedConditions.visibilityOf(inputrutsolBuscar));
					GG_Eventos.writeOnInput(inputrutsolBuscar, rutsolicitantebuscar1);
					Thread.sleep(9000);
					// Click en la lupa buscar
					WebElement opcionBuscar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcionLupaBuscar);
					wait.until(ExpectedConditions.elementToBeClickable(opcionBuscar));
					GG_Eventos.clickButton(opcionBuscar);

					GG_Eventos.actionScroll(driver,4);

					Thread.sleep(1000);
					// Click en acciones para desplegar opciones
					WebElement acciones1 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcAcciones1);
					wait.until(ExpectedConditions.elementToBeClickable(acciones1));
					GG_Eventos.clickButton(acciones1);
				
					// Click en la opcion confirmar
					WebElement confirmar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickConfirmar);
					wait.until(ExpectedConditions.elementToBeClickable(confirmar));
					GG_Eventos.clickButton(confirmar);
					
					Thread.sleep(300);
					
					// Click en la opcion Si
					WebElement opcSi = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickOpcionSi);
					wait.until(ExpectedConditions.elementToBeClickable(opcSi));
					GG_Eventos.clickButton(opcSi);
					
					Thread.sleep(10000);
			
				} catch (Exception e) {
					GG_Utils.eventFailed(currentEvent, e.getMessage());
				}
	    }
			
			// iniciar sesion para camino feliz sagcom medico integrante
			
			public static void iniciarSesionMedicoIntegrante(String medicointegrante, String password,String xNumero) {

				String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

				try {
					GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

					WebDriverWait wait = new WebDriverWait(driver, 50);
					GG_ElementFetch elementFetch = new GG_ElementFetch();

					Thread.sleep(1000);

					// Se escribe el Nombre del Usuario Medico
					WebElement inputMedicoElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputUsuario);
					wait.until(ExpectedConditions.visibilityOf(inputMedicoElement));
					GG_Eventos.writeOnInput(inputMedicoElement, medicointegrante);

					Thread.sleep(300);

					// Se escribe la Contrasena
					WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputContrasena);
					wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
					GG_Eventos.writeOnInput(inputContrasenaElement, password);

					Thread.sleep(300);

					// Click en boton ingresar
					WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnIngresar);
					wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
					GG_Eventos.clickButton(buttonIniciarSesionElement);

					Thread.sleep(200);

					// Verifica si se llego a la segunda pantalla.
					WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.validaLogin);
					wait.until(ExpectedConditions.visibilityOf(labelPaginaElement));
					String textoPagina = labelPaginaElement.getText();

					GG_Validations.trueBooleanCondition(
							textoPagina.equalsIgnoreCase("Conozca aquí las funciones que puedo realizar como médico."),
							"Se ha ingresado correctamente a la pagina: " + textoPagina,
							"No se ha ingresado correctamente a la pagina: ", currentEvent);
					
					Thread.sleep(300);

				} catch (Exception e) {
					GG_Utils.eventFailed(currentEvent, e.getMessage());
				}
		}
			
			//****************************************************************************************************************
			
		// Ingresar nueva solicitud perfil medico integrante 1
		public static void iniciarSolicitudMedicoIntegrante1(String rut2,String rut3, String comentarios1, String pulso, String presion,
	            String talla, String peso, String buscarcodigocie10, String xNumero) {
			
			String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

			try {
				GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

				WebDriverWait wait = new WebDriverWait(driver, 50);
				GG_ElementFetch elementFetch = new GG_ElementFetch();

				// Click en boton "Mi Trabajo"
				WebElement opcionMiTrabajomedpresi = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.opcMiTrabajomedicopresidente);
				wait.until(ExpectedConditions.elementToBeClickable(opcionMiTrabajomedpresi));
				GG_Eventos.clickButton(opcionMiTrabajomedpresi);

				// Click en opcion expedientes en  evaluacion medica
				WebElement opcionEvaluacionMedica = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.opcExpedientesEvaluacionMedica);
				wait.until(ExpectedConditions.elementToBeClickable(opcionEvaluacionMedica));
				GG_Eventos.clickButton(opcionEvaluacionMedica);
				
				// Click en opcion en pendientes de inicio
				WebElement opcionPendientesDeInicio = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.opcionEnPendientesDeInicio);
				wait.until(ExpectedConditions.elementToBeClickable(opcionPendientesDeInicio));
				GG_Eventos.clickButton(opcionPendientesDeInicio);
				
				
				Thread.sleep(1000);

				
				// Click en text box Rut a buscar
				//WebElement opcrutbuscarmedpresi = wait.until(ExpectedConditions
						//.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal.clickopcrutbuscarmedpresi)));
				//opcrutbuscarmedpresi.click();
				//Thread.sleep(300);

				// Se ingresa el rut del solicitante a buscar
				
				
				WebElement inputrutBuscarmedpresi = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.rutSolicitanteBuscarmedipre);
				wait.until(ExpectedConditions.visibilityOf(inputrutBuscarmedpresi));
				GG_Eventos.writeOnInput(inputrutBuscarmedpresi, rut2);
				Thread.sleep(9000);

				// Click en la lupa buscar
				WebElement opcionBuscarmedpresi = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.opcionLupaBuscarmedpresi);
				wait.until(ExpectedConditions.elementToBeClickable(opcionBuscarmedpresi));
				GG_Eventos.clickButton(opcionBuscarmedpresi);
				Thread.sleep(2000);				
				
				WebElement opcionExpediente = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.opcionExpediente);
				wait.until(ExpectedConditions.elementToBeClickable(opcionExpediente));
				GG_Eventos.clickButton(opcionExpediente);
				//Thread.sleep(2000);				
				
				WebElement opcionComenzar = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.comenzar);
				wait.until(ExpectedConditions.elementToBeClickable(opcionComenzar));
				GG_Eventos.clickButton(opcionComenzar);
				//Thread.sleep(9000);
				// Click en la opcion Expediente
				Thread.sleep(2000);
				// Click en la opcion ver mas
				WebElement opcevaluacionmedpresi = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.opcevaluacionmedica);
				wait.until(ExpectedConditions.elementToBeClickable(opcevaluacionmedpresi));
				GG_Eventos.clickButton(opcevaluacionmedpresi);
				Thread.sleep(2000);
				WebElement opcAnamnesis = elementFetch.getWebElement("XPATH",CC_Localizadores_Enfermo_Terminal.Anamnesis);
				wait.until(ExpectedConditions.elementToBeClickable(opcAnamnesis));
				GG_Eventos.clickButton(opcAnamnesis);
				Thread.sleep(2000);
				GG_Eventos.actionScroll(driver, 8);
				Thread.sleep(2000);
				// ingresa comentario en Antecedentes personales y/o laborales y/o mórbidos
				WebElement inputAntecedentespersonales = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.Inputantecedentesper);
				wait.until(ExpectedConditions.visibilityOf(inputAntecedentespersonales));
				GG_Eventos.writeOnInput(inputAntecedentespersonales, comentarios1);
				Thread.sleep(2000);
				// Cursa con licencia médica - NO
				WebElement opccursalicenciamedica = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.cursalicenciamedica);
				wait.until(ExpectedConditions.elementToBeClickable(opccursalicenciamedica));
				GG_Eventos.clickButton(opccursalicenciamedica);
				Thread.sleep(2000);
				// ingresa comentario en Anamnesis y cronología de la evolución
				WebElement inputAnamnesisycronologia = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputAnamnesisycronolo);
				wait.until(ExpectedConditions.visibilityOf(inputAnamnesisycronologia));
				GG_Eventos.writeOnInput(inputAnamnesisycronologia, comentarios1);
				Thread.sleep(2000);
				// ingresa comentario en Tratamiento actual o reciente
				WebElement inputratamientoactual = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputtratamientoactual);
				wait.until(ExpectedConditions.visibilityOf(inputratamientoactual));
				GG_Eventos.writeOnInput(inputratamientoactual, comentarios1);
				Thread.sleep(2000);
				// ingresa comentario Otros Tratamientos
				WebElement inputotrotratamiento = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputotrostratamientos);
				wait.until(ExpectedConditions.visibilityOf(inputotrotratamiento));
				GG_Eventos.writeOnInput(inputotrotratamiento, comentarios1);
				Thread.sleep(2000);
				// ingresa comentario Seleccione las Actividades Esenciales interferidas
				WebElement inputoactividadesescenciales = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputcomentarioEscenciales);
				wait.until(ExpectedConditions.visibilityOf(inputoactividadesescenciales));
				GG_Eventos.writeOnInput(inputoactividadesescenciales, comentarios1);
				Thread.sleep(2000);
				// ingresa comentario Seleccione las Actividades Domésticas interferidas
				WebElement inputcomentariosdomesticos = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputcomentariosdomesticos);
				wait.until(ExpectedConditions.visibilityOf(inputcomentariosdomesticos));
				GG_Eventos.writeOnInput(inputcomentariosdomesticos, comentarios1);
				Thread.sleep(2000);
				// ingresa comentario Seleccione las Actividades de Desplazamiento interferidas
				WebElement inputcomentariosdesplazamiento = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputcomentarioDesplazamiento);
				wait.until(ExpectedConditions.visibilityOf(inputcomentariosdesplazamiento));
				GG_Eventos.writeOnInput(inputcomentariosdesplazamiento, comentarios1);
				Thread.sleep(2000);
				// ingresa comentario Seleccione las Actividades de Desplazamiento interferidas
				WebElement inputcomentariosociales = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputcomentariosociales);
				wait.until(ExpectedConditions.visibilityOf(inputcomentariosociales));
				GG_Eventos.writeOnInput(inputcomentariosociales, comentarios1);
				Thread.sleep(2000);
				WebElement btnclickNo = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.clickNo);
				wait.until(ExpectedConditions.elementToBeClickable(btnclickNo));
				GG_Eventos.clickButton(btnclickNo);
				Thread.sleep(2000);
				// Botonera Guardar Evaluación Médica
				WebElement btnguardarevaluacionmedica = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.btnguardarevamedica);
				wait.until(ExpectedConditions.elementToBeClickable(btnguardarevaluacionmedica));
				GG_Eventos.clickButton(btnguardarevaluacionmedica);
				Thread.sleep(2000);
				// ingresa en Examen Físico - Pulso
				WebElement inputExFisicopulso = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputpulsaciones);
				wait.until(ExpectedConditions.visibilityOf(inputExFisicopulso));
				GG_Eventos.writeOnInput(inputExFisicopulso, pulso);
				Thread.sleep(2000);
				// ingresa en Examen Físico - Presión
				WebElement inputExFisicopresion = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputpresion);
				wait.until(ExpectedConditions.visibilityOf(inputExFisicopresion));
				GG_Eventos.writeOnInput(inputExFisicopresion, presion);
				Thread.sleep(2000);
				// ingresa en Examen Físico - Talla
				WebElement inputExFisicotalla = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputalla);
				wait.until(ExpectedConditions.visibilityOf(inputExFisicotalla));
				GG_Eventos.writeOnInput(inputExFisicotalla, talla);
				Thread.sleep(2000);
				// ingresa en Examen Físico - Peso
				WebElement inputExFisicopeso = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputpeso);
				wait.until(ExpectedConditions.visibilityOf(inputExFisicopeso));
				GG_Eventos.writeOnInput(inputExFisicopeso, peso);
				Thread.sleep(2000);
				// ingresa comentario Examen Físico - Impedimentos a considerar
				WebElement inputTextEstadoGenerak = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.TextEstadoGenerak);
				wait.until(ExpectedConditions.visibilityOf(inputTextEstadoGenerak));
				GG_Eventos.writeOnInput(inputTextEstadoGenerak, comentarios1);
				Thread.sleep(2000);
				// ingresa comentario Examen Físico - Impedimentos a considerar
				WebElement inputTextTronco = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.TextTronco);
				wait.until(ExpectedConditions.visibilityOf(inputTextTronco));
				GG_Eventos.writeOnInput(inputTextTronco, comentarios1);
				Thread.sleep(2000);
				// ingresa comentario Examen Físico - Impedimentos a considerar
				WebElement inputTextExtremidadSuper = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.TextExtremidadSuper);
				wait.until(ExpectedConditions.visibilityOf(inputTextExtremidadSuper));
				GG_Eventos.writeOnInput(inputTextExtremidadSuper, comentarios1);
				Thread.sleep(2000);
				// ingresa comentario Examen Físico - Impedimentos a considerar
				WebElement inputTextExtremidadInfer = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.TextExtremidadInfer);
				wait.until(ExpectedConditions.visibilityOf(inputTextExtremidadInfer));
				GG_Eventos.writeOnInput(inputTextExtremidadInfer, comentarios1);
				Thread.sleep(2000);
				// ingresa comentario Examen Físico - Impedimentos a considerar
				WebElement inputTextColumna = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.TextColumna);
				wait.until(ExpectedConditions.visibilityOf(inputTextColumna));
				GG_Eventos.writeOnInput(inputTextColumna, comentarios1);
				Thread.sleep(2000);
				// ingresa comentario Examen Físico - Impedimentos a considerar
				WebElement inputTextExamenMental = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.TextExamenMental);
				wait.until(ExpectedConditions.visibilityOf(inputTextExamenMental));
				GG_Eventos.writeOnInput(inputTextExamenMental, comentarios1);
				Thread.sleep(2000);
				// ingresa comentario Examen Físico - Impedimentos a considerar
				WebElement inputTextExamenNeuro = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.TextExamenNeuro);
				wait.until(ExpectedConditions.visibilityOf(inputTextExamenNeuro));
				GG_Eventos.writeOnInput(inputTextExamenNeuro, comentarios1);
				Thread.sleep(2000);
				// Botonera Guardar Examen Físico
				WebElement btnguardarexamenfisico = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.btnguardaexamenfisico);
				wait.until(ExpectedConditions.elementToBeClickable(btnguardarexamenfisico));
				GG_Eventos.clickButton(btnguardarexamenfisico);
				Thread.sleep(2000);

				// Acción a seguir - Cierre de caso
				WebElement optplanaccion = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal.clickOptplanaccion)));
				optplanaccion.click();
				Thread.sleep(2000);
				WebElement clicckplanaccion = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal.optclicckplanaccion)));
				clicckplanaccion.click();
				Thread.sleep(2000);
				// ingresa comentario Argumentos, configuración, menoscabos y comentario final
				WebElement inputplanaccioncomentarioFinal = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputcomentariofinal);
				wait.until(ExpectedConditions.visibilityOf(inputplanaccioncomentarioFinal));
				GG_Eventos.writeOnInput(inputplanaccioncomentarioFinal, comentarios1);
				//Thread.sleep(9000);

				GG_Eventos.actionScroll(driver, 8);		
				Thread.sleep(6000);
				// Botonera Configurar y Agregar Impedimentos
				WebElement btnConfigurarAgregarImpedimentos = elementFetch.getWebElement("XPATH", 
				        CC_Localizadores_Enfermo_Terminal.btnConfigurarAgregarImpedimentos);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnConfigurarAgregarImpedimentos);

				Thread.sleep(2000);
				
				// Botonera agregar Otro Impedimento
				WebElement btnotroimpedimento = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.btnagregarotroimpedimento);
				wait.until(ExpectedConditions.elementToBeClickable(btnotroimpedimento));
				GG_Eventos.clickButton(btnotroimpedimento);
				Thread.sleep(2000);
				
				// ingresa comentario en Plan de Acción - Configurar y Agregar Impedimentos
				WebElement inputotroimpedimentoagregarnuevoimpedimento = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputagregarimpedimento);
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
				
				Thread.sleep(2000);
				// Click en menú desplegable de Clase
				WebElement optplanaccionmenuclase = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal.clickOptmenuclase)));
				optplanaccionmenuclase.click();
				Thread.sleep(2000);
				
				// Seleccionar Clase de valor "IV"
				WebElement clickplanaccionmenuclase = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal.optclickmenuclase)));
				clickplanaccionmenuclase.click();
				Thread.sleep(2000);
				// Click en menú desplegable de Rango
				WebElement optplanaccionmenurango = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal.clickOptmenurango)));
				optplanaccionmenurango.click();
				Thread.sleep(2000);
				// Seleccionar Clase de valor "Alto"
				WebElement clickplanaccionmenurango = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal.optclickmenurango)));
				clickplanaccionmenurango.click();
				Thread.sleep(2000);

				// Botonera Agregar Otro Impedimento
				WebElement btnagregarotroimpedimento = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.btnagregarimpedimento);
				wait.until(ExpectedConditions.elementToBeClickable(btnagregarotroimpedimento));
				GG_Eventos.clickButton(btnagregarotroimpedimento);
				Thread.sleep(3000);
				
				// ¿Existen impedimentos configurados del mismo capítulo que afectan la misma
				// área de AVD y se... - NO
				WebElement opcAVD = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.opcconfiguracionAVD);
				wait.until(ExpectedConditions.elementToBeClickable(opcAVD));
				GG_Eventos.clickButton(opcAVD);
				//Thread.sleep(2000);
				
				GG_Eventos.actionScroll(driver, 15);				
				Thread.sleep(3000);

				
				// Asignar cie 10
				WebElement btnAsignarCie10 = elementFetch.getWebElement("XPATH", 
				        CC_Localizadores_Enfermo_Terminal.btnAsignarCie10);
				wait.until(ExpectedConditions.elementToBeClickable(btnAsignarCie10));
				GG_Eventos.clickButton(btnAsignarCie10);

				Thread.sleep(2000);
				
				// Filtrar en Asignar código cie10
				WebElement inputbusquedacodigocie10 = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.inputcodigocie10);
				wait.until(ExpectedConditions.visibilityOf(inputbusquedacodigocie10));
				GG_Eventos.writeOnInput(inputbusquedacodigocie10, buscarcodigocie10);
				Thread.sleep(2000);
				// Presionar lupa de Asignar código cie10
				WebElement opcionlupacie10 = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.optlupacie10);
				wait.until(ExpectedConditions.elementToBeClickable(opcionlupacie10));
				GG_Eventos.clickButton(opcionlupacie10);
				Thread.sleep(2000);
				// click en cabecera llamada Nombre
				WebElement clickcabeceranombre = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(CC_Localizadores_Enfermo_Terminal.clickencabeceranombre)));
				clickcabeceranombre.click();
				Thread.sleep(2000);
				// Asignar código cie10 - O22 COMPLICACIONES VENOSAS DEL EMBARAZO
				WebDriverWait wait3 = new WebDriverWait(driver, 10);
				WebElement btnradio = driver.findElement(By.cssSelector("tr[data-row-key='1'] input.ant-radio-input"));
				btnradio.click();
				Thread.sleep(2000);				// Botonera Asignar cie10
				WebElement btnasignarciel0 = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.btnagregarasignarcie10codigo);
				wait.until(ExpectedConditions.elementToBeClickable(btnasignarciel0));
				GG_Eventos.clickButton(btnasignarciel0);
				
				Thread.sleep(2000);				// Invalidez Previa - NO
				WebElement radioNo = elementFetch.getWebElement("XPATH", 
				        CC_Localizadores_Enfermo_Terminal.radioNo);
				wait.until(ExpectedConditions.elementToBeClickable(radioNo));
				GG_Eventos.clickButton(radioNo);

				Thread.sleep(6000);
				// Botonera Guardar Plan de Acción
				WebElement btnguardaplanaccion = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.btnguardarplandeaccion);
				wait.until(ExpectedConditions.elementToBeClickable(btnguardaplanaccion));
				GG_Eventos.clickButton(btnguardaplanaccion);
				

				//GG_Eventos.subirScroll(driver, 30);
				Thread.sleep(2000);				
				// Botonera Enviar a Sesión
				
				WebElement btnenviarsesion = elementFetch.getWebElement("XPATH",
						CC_Localizadores_Enfermo_Terminal.btnenviarasesion);
				wait.until(ExpectedConditions.elementToBeClickable(btnenviarsesion));
				GG_Eventos.clickButton(btnenviarsesion);
				Thread.sleep(2000);
				// Cerrar Sesion Perfil Administrador
				WebElement perfilPresidenteMedico = driver
						.findElement(By.cssSelector("div.ant-col.ant-col-xs-0.ant-col-md-18 span"));
				perfilPresidenteMedico.click();
				Thread.sleep(2000);				WebElement cerrarSesionPresiMedico = driver.findElement(By.xpath("//a[text()='Cerrar sesión']"));
				cerrarSesionPresiMedico.click();
				
				//Thread.sleep(10000);

			} catch (Exception e) {
				GG_Utils.eventFailed(currentEvent, e.getMessage());
			}
			
			
      }
//******************************************************************************************************************************************
			
			// iniciar sesion para camino feliz sagcom medico presidente 1
			public static void iniciarSesionMedicoPresidente1(String medicopresidente1, String password1,String xNumero) {

				String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

				try {
					GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

					WebDriverWait wait = new WebDriverWait(driver, 50);
					GG_ElementFetch elementFetch = new GG_ElementFetch();

					Thread.sleep(1000);

					// Se escribe el Nombre del Usuario Medico
					WebElement inputMedicoElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputUsuario);
					wait.until(ExpectedConditions.visibilityOf(inputMedicoElement));
					GG_Eventos.writeOnInput(inputMedicoElement, medicopresidente1);

					Thread.sleep(300);

					// Se escribe la Contrasena
					WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.inputContrasena);
					wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
					GG_Eventos.writeOnInput(inputContrasenaElement, password1);

					Thread.sleep(300);

					// Click en boton ingresar
					WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.btnIngresar);
					wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
					GG_Eventos.clickButton(buttonIniciarSesionElement);

					Thread.sleep(200);

					// Verifica si se llego a la segunda pantalla.
					WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.validaLoginExitosoFlujoMedico);
					wait.until(ExpectedConditions.visibilityOf(labelPaginaElement));
					String textoPagina = labelPaginaElement.getText();

					GG_Validations.trueBooleanCondition(
							textoPagina.equalsIgnoreCase("Perfil Médico Presidente"),
							"Se ha ingresado correctamente a la pagina: " + textoPagina,
							"No se ha ingresado correctamente a la pagina: ", currentEvent);

				} catch (Exception e) {
					GG_Utils.eventFailed(currentEvent, e.getMessage());
				}
			}
			
			// Ingresar a nueva solicitud perfil medico presidente 1

			public static void iniciarSolicitudMedicoPresidente1(String rut, String xNumero) {

				String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

				try {
					GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

					WebDriverWait wait = new WebDriverWait(driver, 50);
					GG_ElementFetch elementFetch = new GG_ElementFetch();

					// Click en opcion Mi Trabajo
					WebElement opcionMiTrabajo = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcMiTrabajo);
					wait.until(ExpectedConditions.elementToBeClickable(opcionMiTrabajo));
					GG_Eventos.clickButton(opcionMiTrabajo);
					
					Thread.sleep(1000);
					
					GG_Eventos.actionScroll(driver,15);
					
					// Click en opcion derivar expedientes a sesion
					WebElement opcionEpedientes = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.opcionMisExpedientes);
					wait.until(ExpectedConditions.elementToBeClickable(opcionEpedientes));
					GG_Eventos.clickButton(opcionEpedientes);
					
					Thread.sleep(3000);
					
					WebElement opcionregular = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.regular);
					wait.until(ExpectedConditions.elementToBeClickable(opcionregular));
					GG_Eventos.clickButton(opcionregular);
					
					Thread.sleep(3000);
					
					// Se ingresa el rut del solicitante a buscar
					WebElement inputrutsolBuscar1 = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.rut);
					wait.until(ExpectedConditions.visibilityOf(inputrutsolBuscar1));
					GG_Eventos.writeOnInput(inputrutsolBuscar1, rut);
					
					Thread.sleep(3000);
					// Click en la lupa buscar
					WebElement opcionBuscar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.Buscar);
					wait.until(ExpectedConditions.elementToBeClickable(opcionBuscar));
					GG_Eventos.clickButton(opcionBuscar);
					
					Thread.sleep(3000);
					
					// Click en acciones para desplegar opciones
					WebElement acciones = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clickAcciones);
					wait.until(ExpectedConditions.elementToBeClickable(acciones));
					GG_Eventos.clickButton(acciones);
					
					Thread.sleep(1000);

					// Click en acciones para desplegar opciones
					WebElement clicpEnviar = elementFetch.getWebElement("XPATH",CC_Localizadores_Flujo_Sagcom.clicpEnviar);
					wait.until(ExpectedConditions.elementToBeClickable(clicpEnviar));
					GG_Eventos.clickButton(clicpEnviar);
					
				} catch (Exception e) {
					GG_Utils.eventFailed(currentEvent, e.getMessage());
				}
		  }
			public static void SesionAdministrativo2(String usuarioadm, String contrasenaadm, String xNumero) {

				String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

				try {
					GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

					WebDriverWait wait = new WebDriverWait(driver, 50);
					GG_ElementFetch elementFetch = new GG_ElementFetch();

					Thread.sleep(1000);

					// Se escribe el Nombre del Usuario
					WebElement inputNombreUsuarioElement = elementFetch.getWebElement("XPATH",
							CC_Localizadores_Flujo_Sagcom.inputUsuario2);
					wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
					GG_Eventos.writeOnInput(inputNombreUsuarioElement, usuarioadm);

					Thread.sleep(300);

					// Se escribe la Contrasena
					WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",
							CC_Localizadores_Flujo_Sagcom.inputContrasena2);
					wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
					GG_Eventos.writeOnInput(inputContrasenaElement, contrasenaadm);

					Thread.sleep(300);

					// Click en boton ingresar
					WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",
							CC_Localizadores_Flujo_Sagcom.btnIngresaadm2);
					wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
					GG_Eventos.clickButton(buttonIniciarSesionElement);

					Thread.sleep(200);

					// Verifica si se llego a la segunda pantalla.
					WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",
							CC_Localizadores_Flujo_Sagcom.validaLoginExitosoFlujoAdm);
					wait.until(ExpectedConditions.visibilityOf(labelPaginaElement));
					String textoPagina = labelPaginaElement.getText();

					GG_Validations.trueBooleanCondition(textoPagina.equalsIgnoreCase("Perfil Administrativo"),
							"Se ha ingresado correctamente a la pagina: " + textoPagina,
							"No se ha ingresado correctamente a la pagina: ", currentEvent);

					Thread.sleep(3000);

				} catch (Exception e) {
					GG_Utils.eventFailed(currentEvent, e.getMessage());
				}

			}

			// Ingresar a nueva solicitud perfil administrativo
			public static void SolicitudAdministrativo2 (String rut, String xNumero) {

				String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

				try {
					GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

					WebDriverWait wait = new WebDriverWait(driver, 50);
					GG_ElementFetch elementFetch = new GG_ElementFetch();

					// Click en los tres "..." punto del menú
					WebElement buttonbtntrespuntos = elementFetch.getWebElement("XPATH",
							CC_Localizadores_Flujo_Sagcom.btntrespuntos);
					wait.until(ExpectedConditions.elementToBeClickable(buttonbtntrespuntos));
					GG_Eventos.clickButton(buttonbtntrespuntos);
					Thread.sleep(200);

					// Click en opción Sesiones"
					WebElement opcoptsesiones = elementFetch.getWebElement("XPATH",
							CC_Localizadores_Flujo_Sagcom.optsesiones);
					wait.until(ExpectedConditions.elementToBeClickable(opcoptsesiones));
					GG_Eventos.clickButton(opcoptsesiones);

					// Click en botonera para la Crear Tabla
					WebElement opcioncreartablas = elementFetch.getWebElement("XPATH",
							CC_Localizadores_Flujo_Sagcom.btncreartabla);
					wait.until(ExpectedConditions.elementToBeClickable(opcioncreartablas));
					GG_Eventos.clickButton(opcioncreartablas);
					Thread.sleep(1000);

					// Click calendario de fecha para Crear Tabla
					WebElement opccalendariocreatabla = wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath(CC_Localizadores_Flujo_Sagcom.clickcalendariocreatabla)));
					opccalendariocreatabla.click();
					Thread.sleep(1000);

					// Seleccionar Ahora en calendario
					WebElement btnahoracalendario = wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath(CC_Localizadores_Flujo_Sagcom.btncalendarioahora)));
					btnahoracalendario.click();
					Thread.sleep(1000);

					GG_Eventos.actionScroll(driver, 10);

					// Click en Expedientes de calificación / reevaluación CMR
					WebElement opcexpedientecali = elementFetch.getWebElement("XPATH",
							CC_Localizadores_Flujo_Sagcom.opcexpedientecalificacion);
					wait.until(ExpectedConditions.elementToBeClickable(opcexpedientecali));
					GG_Eventos.clickButton(opcexpedientecali);
					Thread.sleep(500);

					// Presiona ícono Filtro
					WebElement btniconofiltro = elementFetch.getWebElement("XPATH",
							CC_Localizadores_Flujo_Sagcom.botoniconofiltro);
					wait.until(ExpectedConditions.elementToBeClickable(btniconofiltro));
					GG_Eventos.clickButton(btniconofiltro);

					// Ingresa rut en Filtro del búsqueda
					WebElement inputrutfiltroadm = elementFetch.getWebElement("XPATH",
							CC_Localizadores_Flujo_Sagcom.rutfiltroadm);
					wait.until(ExpectedConditions.visibilityOf(inputrutfiltroadm));
					GG_Eventos.writeOnInput(inputrutfiltroadm, rut);
					Thread.sleep(90000);


					// Click en Filtrar
					WebElement clickfiltraricono = elementFetch.getWebElement("XPATH",
							CC_Localizadores_Flujo_Sagcom.clickfiltrarut);
					wait.until(ExpectedConditions.elementToBeClickable(clickfiltraricono));
					GG_Eventos.clickButton(clickfiltraricono);
					Thread.sleep(2000);

					GG_Eventos.actionScroll(driver, 10);

					// Click en check box
					WebDriverWait wait4 = new WebDriverWait(driver, 10);
					WebElement clickencheckbox = wait
							.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label.ant-checkbox-wrapper")));
					clickencheckbox.click();
					Thread.sleep(1000);

					// Click en botonera Crear Tabla Sesion
					WebElement clickencreatablasesion = elementFetch.getWebElement("XPATH",
							CC_Localizadores_Flujo_Sagcom.btncreatablasesion);
					wait.until(ExpectedConditions.elementToBeClickable(clickencreatablasesion));
					GG_Eventos.clickButton(clickencreatablasesion);
					Thread.sleep(500);

				} catch (Exception e) {
					GG_Utils.eventFailed(currentEvent, e.getMessage());
				}
			}			
			
			
			
	  }


