package test.java.previred;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.pageEvents.Admisibilidad_solicitud;
import main.java.utils.GG_OpenCSV;
import main.java.utils.GG_Utils;

import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public class CU005_Admisibilidad_solicitud_rechazada extends CC_Test {

	@Test(enabled = true, dataProvider = "Data",priority = 1)
	public void Flujo_Sagcom(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo SAGCOM", "Validar el ingreso de una solicitud flujo sagcom");
		Admisibilidad_solicitud.iniciarSesion(args[0], args[1], "1");
		Admisibilidad_solicitud.iniciarSolicitud(args[2], args[3], args[4], args[5], args[6], args[7], args[8], 
				args[9], args[10], args[11], args[12], args[13], args[14], args[15], args[16], args[17], args[18],args[19],args[20],args[21],args[22],args[23],args[24],args[25],args[26],args[27],"2");

	}

	@DataProvider(name = "Data")
	public Object[][] cargarDatos() throws IOException, CsvValidationException {

		return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 31);
	}

	@Test(enabled = true, dataProvider = "Data1",priority = 2)
	public void Flujo_Sagcom_Administrativo(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Administrativo","Validar flujo perfil administrativo");
		Admisibilidad_solicitud.iniciarSesionAdministrativo(args[28], args[29], "1");
		Admisibilidad_solicitud.iniciarSolicitudAdministrativo(args[2],args[30], "2");
	}

	@DataProvider(name = "Data1")
	public Object[][] cargarDatos1() throws IOException, CsvValidationException {

		return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 31);
	}

}