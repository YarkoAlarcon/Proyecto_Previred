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

import main.java.pageObjects.CC_Localizadores_Retomar_Solicitud_sin_Terminar;
import main.java.utils.GG_ElementFetch;
import main.java.utils.GG_Eventos;
import main.java.utils.GG_Utils;
import main.java.utils.GG_Validations;
import test.java.previred.CC_Test;

//En esta clase se ejecutan los Pasos de la Pagina.
public class Retomar_Solicitud_sin_Terminar extends CC_Test {

	public Retomar_Solicitud_sin_Terminar(WebDriver driver) {
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
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.inputUsuario);
			wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
			GG_Eventos.writeOnInput(inputNombreUsuarioElement, usuario);

			Thread.sleep(300);

			// Se escribe la Contrasena
			WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.inputContrasena);
			wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
			GG_Eventos.writeOnInput(inputContrasenaElement, contrasena);

			Thread.sleep(300);

			// Click en boton ingresar
			WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.btnIngresar);
			wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
			GG_Eventos.clickButton(buttonIniciarSesionElement);

			Thread.sleep(200);

			// Verifica si se llego a la segunda pantalla.
			WebElement labelPaginaElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.validaLoginExitoso);
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
			String direccion, String nrodire, String fechainafp, String administrativo, String pass,
			String personavalidaafiliado, String administradoradelseguro, String afeccionoenfermedad, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			// Se ingresa el rut del Usuario
			WebElement inputrutsolElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.inputRutSolicitante);
			wait.until(ExpectedConditions.visibilityOf(inputrutsolElement));
			GG_Eventos.writeOnInput(inputrutsolElement, rut);

			Thread.sleep(200);

			// Obetener imagen de la función
			System.out.println("Voy hacer Print");
			GG_Utils.takeAdditionalScreenshot(GG_Utils.obtenerFechaHoraActual() + "_TipoSolicitud", "passed");
			System.out.println("Ya hice Print");

			// Click en boton comenzar
			WebElement buttoncomenzarElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.btnComenzar);
			wait.until(ExpectedConditions.elementToBeClickable(buttoncomenzarElement));
			GG_Eventos.clickButton(buttoncomenzarElement);

			Thread.sleep(200);

			// Verifica si se llego a pantalla. Ingresar una solicitud
			WebElement labelPaginasolicitudElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.validaCrearNuevaSolicitud);
			wait.until(ExpectedConditions.visibilityOf(labelPaginasolicitudElement));
			String textoPagina = labelPaginasolicitudElement.getText();

			GG_Validations.trueBooleanCondition(textoPagina.equalsIgnoreCase("Ingreso de Nueva Solicitud"),
					"Se ha ingresado correctamente a la pagina: " + textoPagina,
					"No se ha ingresado correctamente a la pagina: ", currentEvent);

			Thread.sleep(200);

			// Ingresar informacion del solicitante
			// click para elegir tipo de solicitud
			WebElement tiposolicitud = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.clickOptTipoSolicitud);
			wait.until(ExpectedConditions.visibilityOf(tiposolicitud));
			GG_Eventos.clickButton(tiposolicitud);

			// Selecciona opcion tipo solicitud
			WebElement tiposolicitudopcion = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.optTipoSolicitud);
			wait.until(ExpectedConditions.visibilityOf(tiposolicitudopcion));
			GG_Eventos.clickButton(tiposolicitudopcion);

			Thread.sleep(1000);

			// Se escribe el Nº Interno Institución
			WebElement inputninstitucionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.nroInstitucion);
			wait.until(ExpectedConditions.visibilityOf(inputninstitucionElement));
			GG_Eventos.writeOnInput(inputninstitucionElement, ninstitucion);

			// Click en boton buscar
			WebElement buttonbuscarrSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.btnBuscar);
			wait.until(ExpectedConditions.elementToBeClickable(buttonbuscarrSesionElement));
			GG_Eventos.clickButton(buttonbuscarrSesionElement);

			Thread.sleep(3000);

			// Click en botón Enfermo Terminal
			WebElement buttonenfermoterminal = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.optEnfermoTerminal);
			wait.until(ExpectedConditions.elementToBeClickable(buttonenfermoterminal));
			GG_Eventos.clickButton(buttonenfermoterminal);

			// Se ingresa Fecha de recepción de solicitud en AFP
			WebElement fecharecepElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.fechaRecepcionAfp);
			wait.until(ExpectedConditions.visibilityOf(fecharecepElement));
			GG_Eventos.writeOnInput(fecharecepElement, fecharecep);

			// Se ingresa Nombres
			WebElement nombressoliElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.nombreSolicitante);
			wait.until(ExpectedConditions.visibilityOf(nombressoliElement));
			GG_Eventos.writeOnInput(nombressoliElement, nombressoli);

			// Se ingresa Primer Apellido
			WebElement primerapesoliElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.primerApellidoSolicitante);
			wait.until(ExpectedConditions.visibilityOf(primerapesoliElement));
			GG_Eventos.writeOnInput(primerapesoliElement, primerapesoli);

			// Se ingresa Segundo Apellido
			WebElement segundoapesoliElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.segundoApellidoSolicitante);
			wait.until(ExpectedConditions.visibilityOf(segundoapesoliElement));
			GG_Eventos.writeOnInput(segundoapesoliElement, segundoapesoli);

			// Se ingresa Fecha de nacimiento
			WebElement fechanacElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.fechaNacimiento);
			wait.until(ExpectedConditions.visibilityOf(fechanacElement));
			GG_Eventos.writeOnInput(fechanacElement, fechanac);
			GG_Eventos.actionEnterOnElement(driver, fechanacElement);

			Thread.sleep(300);

			// clickeamos sexo
			WebElement tiposex = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.clickOptTipoSexo);
			wait.until(ExpectedConditions.visibilityOf(tiposex));
			GG_Eventos.clickButton(tiposex);

			// Seleccionar masculino_femenino
			WebElement tiposexo = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.optTipoSexo);
			wait.until(ExpectedConditions.visibilityOf(tiposexo));
			GG_Eventos.clickButton(tiposexo);

			// clickeamos Estado Civil
			WebElement estadocivil = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.clickOptEstadoCivil);
			wait.until(ExpectedConditions.visibilityOf(estadocivil));
			GG_Eventos.clickButton(estadocivil);

			WebElement tipoestadocivil = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.optEstadoCivil);
			wait.until(ExpectedConditions.visibilityOf(tipoestadocivil));
			GG_Eventos.clickButton(tipoestadocivil);

			// Se ingresa Profesión o actividad
			WebElement profesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.profesion);
			wait.until(ExpectedConditions.visibilityOf(profesionElement));
			GG_Eventos.writeOnInput(profesionElement, profesion);

			// Click Ingrese correo electrónico
			WebElement btnmail = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.optEmail);
			wait.until(ExpectedConditions.visibilityOf(btnmail));
			GG_Eventos.clickButton(btnmail);
			
			// Se ingresa Teléfono móvil
			WebElement numovil = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.numeroMovil);
			wait.until(ExpectedConditions.visibilityOf(numovil));
			GG_Eventos.writeOnInput(numovil, nmovil);
			
			Thread.sleep(300);

			WebElement optcheckFijo = driver.findElement(By.id("isNoTieneTelefonoFijo"));
			optcheckFijo.click();
			Thread.sleep(300);
			

			// Nivel Educacional
			WebElement educa = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.clickOptNivelEducacional);
			wait.until(ExpectedConditions.visibilityOf(educa));
			GG_Eventos.clickButton(educa);

			WebElement educa2 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.optNivelEducacional);
			wait.until(ExpectedConditions.visibilityOf(educa2));
			GG_Eventos.clickButton(educa2);

			// Region
			WebElement region = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.clickOptRegion);
			wait.until(ExpectedConditions.visibilityOf(region));
			GG_Eventos.clickButton(region);

			WebElement regionopcion = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.optRegion);
			wait.until(ExpectedConditions.visibilityOf(regionopcion));
			GG_Eventos.clickButton(regionopcion);

			// Provincia
			WebElement provincia = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.clickOptProvincia);
			wait.until(ExpectedConditions.visibilityOf(provincia));
			GG_Eventos.clickButton(provincia);
			;

			WebElement provinciaopcion = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.optProvincia);
			wait.until(ExpectedConditions.visibilityOf(provinciaopcion));
			GG_Eventos.clickButton(provinciaopcion);

			// Comuna
			WebElement comuna = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.clickOptComuna);
			wait.until(ExpectedConditions.visibilityOf(comuna));
			GG_Eventos.clickButton(comuna);

			GG_Eventos.actionScroll(driver, 16);

			// Se activa el Scroll hasta llegar a Rancagua
			WebElement opcComuna = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.optComuna);
			GG_Eventos.scrollToElementAndClick(driver, opcComuna);

			// Se ingresa Dirección; Calle
			WebElement dire = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.direccion);
			wait.until(ExpectedConditions.visibilityOf(dire));
			GG_Eventos.writeOnInput(dire, direccion);

			// Se ingresa numeral de la dirección
			WebElement nrodir = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.nroDireccion);
			wait.until(ExpectedConditions.visibilityOf(nrodir));
			GG_Eventos.writeOnInput(nrodir, nrodire);

			// Obetener imagen de la función
			System.out.println("Voy hacer Print");
			GG_Utils.takeAdditionalScreenshot(GG_Utils.obtenerFechaHoraActual() + "_TipoSolicitud", "passed");
			System.out.println("Ya hice Print");

			// Click en boton continuar
			WebElement btncontinuar1 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.btnContinuar);
			wait.until(ExpectedConditions.elementToBeClickable(btncontinuar1));
			GG_Eventos.clickButton(btncontinuar1);

			// Situación laboral
			WebElement situlaboral = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.clickSituacionLaboral);
			wait.until(ExpectedConditions.elementToBeClickable(situlaboral));
			GG_Eventos.clickButton(situlaboral);

			WebElement situlaboral1 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.optSituacionLaboral);
			wait.until(ExpectedConditions.elementToBeClickable(situlaboral1));
			GG_Eventos.clickButton(situlaboral1);
			;

			// Institución de salud
			WebElement instsalud = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.clickInstitucionSalud);
			wait.until(ExpectedConditions.elementToBeClickable(instsalud));
			GG_Eventos.clickButton(instsalud);
			;

			WebElement instsalud1 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.optInstitucionSalud);
			wait.until(ExpectedConditions.elementToBeClickable(instsalud1));
			GG_Eventos.clickButton(instsalud1);

			Thread.sleep(3000);
			// Se ingresa Fecha de afiliación al sistema AFP
			WebElement fechaafp = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.fechaAfiliacionAfp);
			wait.until(ExpectedConditions.visibilityOf(fechaafp));
			GG_Eventos.writeOnInput(fechaafp, fechainafp);
			GG_Eventos.actionEnterOnElement(driver, fechaafp);
			Thread.sleep(300);

			// Click ¿Ha realizado cambio de AFP el afiliado?
			WebElement cambioafp = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.opcCambioAfp);
			wait.until(ExpectedConditions.elementToBeClickable(cambioafp));
			GG_Eventos.clickButton(cambioafp);

			// Click Se encuentra pensionado por la ley 16.744
			WebElement ley16744 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.opcMutualidad);
			wait.until(ExpectedConditions.elementToBeClickable(ley16744));
			GG_Eventos.clickButton(ley16744);

			// Click ¿Cuenta con cobertura del SIS el solicitante?
			WebElement consis = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.coberturaSis);
			wait.until(ExpectedConditions.elementToBeClickable(consis));
			GG_Eventos.clickButton(consis);

			// Click ¿Está actualmente acogido a una licencia médica el solicitante?
			WebElement limed = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.conLicencia);
			wait.until(ExpectedConditions.elementToBeClickable(limed));
			GG_Eventos.clickButton(limed);

			// Click botonera Guardar y continuar más tarde
			WebElement btnguardaycontinua = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.btnguardarycontinuar);
			wait.until(ExpectedConditions.elementToBeClickable(btnguardaycontinua));
			GG_Eventos.clickButton(btnguardaycontinua);
			Thread.sleep(5000);

			// Cerrar Sesion del perfil Ejecutivo
			WebElement perfilEjecutivo = driver
					.findElement(By.cssSelector("div.ant-col.ant-col-xs-0.ant-col-md-18 span"));
			perfilEjecutivo.click();
			Thread.sleep(200);
			WebElement cerrarSesion = driver.findElement(By.xpath("//a[text()='Cerrar sesión']"));
			cerrarSesion.click();

			// Vuelve a ingresar para continuar con la generación de la Nueva S
			// Se escribe el Nombre del Usuario
			WebElement inputNombreUsuario = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.inputUsuario2);
			wait.until(ExpectedConditions.visibilityOf(inputNombreUsuario));
			GG_Eventos.writeOnInput(inputNombreUsuario, administrativo);
			Thread.sleep(300);

			// Se escribe la Contrasena
			WebElement inputContrasena = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.inputContrasena2);
			wait.until(ExpectedConditions.visibilityOf(inputContrasena));
			GG_Eventos.writeOnInput(inputContrasena, pass);
			Thread.sleep(300);

			// Click en boton ingresar
			WebElement buttonIniciarSesion2 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.btnIngresar2);
			wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesion2));
			GG_Eventos.clickButton(buttonIniciarSesion2);

//	-------------------
			// Se ingresa Retomar Solicitud sin Terminar
			WebElement inputrutretomar = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.inputRutRetomarSolicitud);
			wait.until(ExpectedConditions.visibilityOf(inputrutretomar));
			GG_Eventos.writeOnInput(inputrutretomar, rut);
			Thread.sleep(200);

			// Click en boton comenzar
			WebElement buttoncomenzarRetomar = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.btnComenzarRetomarSolicitud);
			wait.until(ExpectedConditions.elementToBeClickable(buttoncomenzarRetomar));
			GG_Eventos.clickButton(buttoncomenzarRetomar);
			Thread.sleep(900);
//	------------------
			GG_Eventos.actionScroll(driver, 16);
			
			// Click en boton continuar
			WebElement btncontinuar01 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.btnContinuar);
			wait.until(ExpectedConditions.elementToBeClickable(btncontinuar01));
			GG_Eventos.clickButton(btncontinuar01);
			Thread.sleep(1000);
			
			GG_Eventos.actionScroll(driver, 16);			
			
			// Click btn continuar paso 2
			WebElement btnContinuar2 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.btnContinuarPaso2);
			wait.until(ExpectedConditions.elementToBeClickable(btnContinuar2));
			GG_Eventos.clickButton(btnContinuar2);
			Thread.sleep(500);
//			------------------
			// ¿Beneficiario o afiliado incapacitado para comparecer en CM?
			WebElement compafrecerCm = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.comparecerCm);
			wait.until(ExpectedConditions.elementToBeClickable(compafrecerCm));
			GG_Eventos.clickButton(compafrecerCm);

			// Nombre de la persona que verificó la identidad del afiliado en AFP
			WebElement inputPersonaValidaAfiliado = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.nombrePerVerificaIdentidadAfiliado);
			wait.until(ExpectedConditions.visibilityOf(inputPersonaValidaAfiliado));
			GG_Eventos.writeOnInput(inputPersonaValidaAfiliado, personavalidaafiliado);

			// ¿Requiere representación de un tercero?
			WebElement representanteTercero = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.requiereTercero);
			wait.until(ExpectedConditions.elementToBeClickable(representanteTercero));
			GG_Eventos.clickButton(representanteTercero);

			// Entidad administradora del seguro de accidentes del trabajo y enfermedades
			// profesionales que se encuentre adscrito el solicitante
			WebElement nombreAdministradoraSeguro = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.adminDelSeguro);
			wait.until(ExpectedConditions.visibilityOf(nombreAdministradoraSeguro));
			GG_Eventos.writeOnInput(nombreAdministradoraSeguro, administradoradelseguro);

			// Ha sufrido algún accidente del trabajo o enfermedad profesional
			WebElement accidente = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.accidenteTrabajorEnfermedadProfesional);
			wait.until(ExpectedConditions.elementToBeClickable(accidente));
			GG_Eventos.clickButton(accidente);

			// Principal afección o enfermedad por la que solicita este beneficio
			WebElement principalAfeccionOenfermedad = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.afeccionOenfermedad);
			wait.until(ExpectedConditions.visibilityOf(principalAfeccionOenfermedad));
			GG_Eventos.writeOnInput(principalAfeccionOenfermedad, afeccionoenfermedad);

			// Ingrese el porcentaje de cargo del afiliado a la Administradora del arancel
			// establecido por el D.F.L. Nº1, de 2005
			WebElement porcentaje = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.porcentajeAfiliado);
			wait.until(ExpectedConditions.elementToBeClickable(porcentaje));
			GG_Eventos.clickButton(porcentaje);

			// Click btn continuar paso 3
			WebElement btnContinuar3 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.btnContinuarPaso3);
			GG_Eventos.clickWithJS(driver, btnContinuar3);
			Thread.sleep(500);

			// Incorporar otros antecedentes
			WebElement masAntecedentes = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.incorporarAntecedentes);
			wait.until(ExpectedConditions.elementToBeClickable(masAntecedentes));
			GG_Eventos.clickButton(masAntecedentes);

			// Click btn continuar paso 4
			WebElement btnContinuar4 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.btnContinuarPaso4);
			wait.until(ExpectedConditions.elementToBeClickable(btnContinuar4));
			GG_Eventos.clickButton(btnContinuar4);

			Thread.sleep(500);

			// Click btn finalizar paso 5
			WebElement btnFinalizar5 = elementFetch.getWebElement("XPATH",
					CC_Localizadores_Retomar_Solicitud_sin_Terminar.btnFinalizarPaso5);
			GG_Eventos.clickWithJS(driver, btnFinalizar5);

			Thread.sleep(100);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
	
}