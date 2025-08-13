package main.java.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.google.common.io.Files;

//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.util.Base64;

import resource.java.GG_BaseTest;

public class GG_Utils extends GG_BaseTest {

	public static void infoTestCase(String funcionality, String description) {
		String logText = "Funcionalidad: " + funcionality;
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.TEAL);
		GG_BaseTest.logger.log(Status.INFO, m);
		logText = "Descripcion: " + description;
		m = MarkupHelper.createLabel(logText, ExtentColor.TEAL);
		GG_BaseTest.logger.log(Status.INFO, m);
	}

	public static void eventFailed(String currentEvent, String errorMessage) {
		GG_BaseTest.logger.warning("[ERROR] en " + currentEvent + ", No se pudo terminar a causa de: " + errorMessage);
		System.out.println("[ERROR] en " + currentEvent + ", No se pudo terminar a causa de: " + errorMessage);

		String logText = "FAILED: " + currentEvent;
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		GG_BaseTest.logger.log(Status.FAIL, m);
		String path = takeScreenshot(currentEvent);
		try {
			GG_BaseTest.logger.addScreenCaptureFromPath(path, currentEvent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.fail();
	}

	public static String takeScreenshot(String nameMethod) {
		// Obtener Fecha y Hora para la Evidencia del Pas� Fallido.
		LocalTime hhora = LocalTime.now();
		DateTimeFormatter f_t = DateTimeFormatter.ofPattern("HHmmss");

		LocalDate ffecha = LocalDate.now();
		DateTimeFormatter f_d = DateTimeFormatter.ofPattern("yyyyMMdd");

		String xHora = hhora.format(f_t).toString();
		String xFecha = ffecha.format(f_d).toString();

		String xSufijo = xFecha + "_" + xHora;
		// Fin

		String fileName = CC_Parametros.gloDir + File.separator + "screenshots" + File.separator + "failed"
				+ File.separator + nameMethod + "_" + xSufijo;
		File f = ((TakesScreenshot) GG_BaseTest.driver).getScreenshotAs(OutputType.FILE);

		try {
			File newFile = new File(fileName + ".png");
			FileUtils.copyFile(f, newFile);

			return newFile.getAbsolutePath();

		} catch (IOException e) {
			e.printStackTrace();

			return "";
		}
	}

	public static void outputInfo(String output) {
		GG_BaseTest.logger.info(output);
		System.out.println(output);
	}

	public static void testCasePassed(String currentTestCase, String message) {
		outputInfo("PASSED: " + currentTestCase + "\n" + message + "\n");
	}

	public static void testCaseFailed(String currentTestCase, String caseTestDesc, Exception e) {
		outputInfo("No se ha terminado el caso de prueba '" + currentTestCase + "' por la siguiente excepcion: " + "\n"
				+ e.getMessage());
		outputInfo("FAILED: " + currentTestCase + " - " + caseTestDesc + "\n");
		takeScreenshot(currentTestCase);
		Assert.fail();
	}

	public static String inputName(WebElement element) {
		String name = "";

		try {
			String nameCamelCase = element.getAttribute("id").replace("input", "").replace("IR", "").replace("Lbl", "")
					.replace("bto", "").replace("Login", "").replace("SS03_lgn", "").replace("Log", "")
					.replace("In_", "").replace("Interno_", "").replace("SSO3_lgn", "").trim();
			if (nameCamelCase.equals("")) {
				nameCamelCase = element.getAttribute("formcontrolname").replace("input", "").replace("IR", "")
						.replace("Lbl", "").replace("bto", "").trim();
			}
			String[] nameSplit = nameCamelCase.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");
			name = "";
			for (int i = 0; i < nameSplit.length; i++) {
				name = name + nameSplit[i] + " ";
			}

			return name.trim();
		} catch (Exception e) {
			name = "*Sin-nombre*";
			System.out.println("Elemento (text-box) sin Nombre asociado. Error: " + e.getMessage());

			return name;
		}
	}

	public static String buttonName(WebElement element) {
		String name = "";

		try {
			String nameCamelCase = element.getText();
			if (nameCamelCase.equalsIgnoreCase("")) {
				nameCamelCase = element.getAttribute("text");
			}
			if (nameCamelCase == null || nameCamelCase.equalsIgnoreCase("null")) {
				nameCamelCase = element.getAttribute("data-original-title");
			}
			if (nameCamelCase == null || nameCamelCase.equalsIgnoreCase("null")) {
				nameCamelCase = element.getAttribute("defaultValue");
			}
			if (nameCamelCase.equalsIgnoreCase("") || nameCamelCase == null || nameCamelCase.equalsIgnoreCase("null")) {
				nameCamelCase = element.getAttribute("class").split("-")[2];
			}
			String[] nameSplit = nameCamelCase.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");
			name = "";
			for (int i = 0; i < nameSplit.length; i++) {
				name = name + nameSplit[i] + " ";
			}
			return name.trim();
		} catch (Exception e) {
			name = "*Sin-nombre*";
			System.out.println("Elemento(Botón) sin Nombre asociado. Error: " + e.getMessage());

			return name;
		}
	}

	// 
//	@Contex(description = "Captura la pantalla y guarda la imagen en Base64 y la agrega como extra al reporte")
	public static void takeAdditionalScreenshot(String methodName, String folder) {
		String imagePath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + folder
				+ File.separator + methodName + ".png";
//      File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// File f = ((TakesScreenshot)
		// driver.getDelegate()).getScreenshotAs(OutputType.FILE);
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			File image = new File(imagePath);
			Files.copy(f, image);
			byte[] imageBytes = readImageToBytes(image.getAbsolutePath());
//			step.pass("Captura adicional",
//					MediaEntityBuilder.createScreenCaptureFromBase64String(encodeBytesToBase64(imageBytes)).build());
		} catch (IOException e) {
			GG_Utils.outputInfo(e.getMessage());
		}
	}

//	@Context(description = "Convierte la imagen a una cadena de bytes")
    private static byte[] readImageToBytes(String imagePath) throws IOException {
                   File imageFile = new File(imagePath);
                   byte[] imageBytes;
                   try (FileInputStream fileInputStream = new FileInputStream(imageFile)) {
                                 imageBytes = new byte[(int) imageFile.length()];
                                 fileInputStream.read(imageBytes);
                   }
                   return imageBytes;
    }
	
    private static String encodeBytesToBase64(byte[] bytes) {
		return Base64.getEncoder().encodeToString(bytes);
	}
    
	public static String obtenerFechaHoraActual() {
		LocalDateTime ahora = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		return ahora.format(formato);
	}

	
	
}
