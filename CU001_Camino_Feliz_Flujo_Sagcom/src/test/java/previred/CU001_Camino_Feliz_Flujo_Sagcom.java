package test.java.previred;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.pageEvents.Camino_Feliz_Flujo_Sagcom;
import main.java.utils.GG_OpenCSV;
import main.java.utils.GG_Utils;

import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public class CU001_Camino_Feliz_Flujo_Sagcom extends CC_Test {

	@Test(enabled = true, dataProvider = "Data",priority = 1)
	public void Flujo_Sagcom(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo SAGCOM", "Validar el ingreso de una solicitud flujo sagcom");
		Camino_Feliz_Flujo_Sagcom.iniciarSesion(args[0], args[1], "1");
		Camino_Feliz_Flujo_Sagcom.iniciarSolicitud(args[2], args[3], args[4], args[5], args[6], args[7], args[8],
				args[9], args[10], args[11], args[12], args[13], args[14], args[15], args[16], args[17], "2");

	}

	@DataProvider(name = "Data")
	public Object[][] cargarDatos() throws IOException, CsvValidationException {

		return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 18);
	}

	@Test(enabled = true, dataProvider = "Data1",priority = 2)
	public void Flujo_Sagcom_Administrativo(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Administrativo","Validar flujo perfil administrativo");
		Camino_Feliz_Flujo_Sagcom.iniciarSesionAdministrativo(args[18], args[19], "1");
		Camino_Feliz_Flujo_Sagcom.iniciarSolicitudAdministrativo(args[2], "2");
	}

	@DataProvider(name = "Data1")
	public Object[][] cargarDatos1() throws IOException, CsvValidationException {

		return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 20);
	}

	@Test(enabled = true, dataProvider = "Data2",priority = 3)
	public void Flujo_Sagcom_Medico_Presidente(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Medico Presidente", "Validar flujo perfil medico presidente");
		Camino_Feliz_Flujo_Sagcom.iniciarSesionMedicoPresidente(args[20], args[21], "1");
		Camino_Feliz_Flujo_Sagcom.iniciarSolicitudMedicoPresidente(args[2], "2");

	}

	@DataProvider(name = "Data2")
	public Object[][] cargarDatos2() throws IOException, CsvValidationException {
// ver el tema del doctor
		return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 22);
	}

	@Test(enabled = true, dataProvider = "Data3",priority = 4)
	public void Flujo_Sagcom_Administrativo1(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Administrativo","Validar flujo perfil administrativo");
		Camino_Feliz_Flujo_Sagcom.iniciarSesionAdministrativo1(args[18], args[19], "1");
		Camino_Feliz_Flujo_Sagcom.iniciarSolicitudAdministrativo1(args[2], "2");

	}

	@DataProvider(name = "Data3")
	public Object[][] cargarDatos3() throws IOException, CsvValidationException {

		return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 22);
	}

	@Test(enabled = true, dataProvider = "Data4",priority = 5)
	public void Flujo_Sagcom_Administrativo2(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Administrativo","Validar flujo perfil administrativo");
		Camino_Feliz_Flujo_Sagcom.iniciarSesionAdministrativo2(args[18], args[19], "1");
		Camino_Feliz_Flujo_Sagcom.iniciarSolicitudAdministrativo2(args[2],args[31],args[32],"2");

	}

	@DataProvider(name = "Data4")
	public Object[][] cargarDatos4() throws IOException, CsvValidationException {

		return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 33);
	}
	
	@Test(enabled = true, dataProvider = "Data5",priority = 6)
	public void Flujo_Sagcom_Medico_Integrante1(String args[]) throws InterruptedException {
//agregar doble click
		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Medico Integrante","Validar flujo perfil Medico Integrante");
		Camino_Feliz_Flujo_Sagcom.iniciarSesionMedicoIntegrante(args[22], args[23], "1");
		Camino_Feliz_Flujo_Sagcom.iniciarSolicitudMedicoIntegrante1(args[2],args[30],args[24],args[25],args[26],args[27],args[28],args[29],"2");
	}

	@DataProvider(name = "Data5")
	public Object[][] cargarDatos5() throws IOException, CsvValidationException {

		return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 31);
	}
	//ver despues
	@Test(enabled = true, dataProvider = "Data6",priority = 7)
	public void Flujo_Sagcom_Medico_Presidente1(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Medico Presidente","Validar flujo perfil Medico Presidente");
		Camino_Feliz_Flujo_Sagcom.iniciarSesionMedicoPresidente1(args[20], args[21], "1");
		Camino_Feliz_Flujo_Sagcom.iniciarSolicitudMedicoPresidente1(args[2],"2");

	}

	@DataProvider(name = "Data6")
	public Object[][] cargarDatos6() throws IOException, CsvValidationException {

		return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 30);
	}
	
	@Test(enabled = true, dataProvider = "Data7", priority = 8)
	public void Flujo_Sagcom_Administrativo3(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Administrativo", "Validar flujo perfil administrativo");
		Camino_Feliz_Flujo_Sagcom.SesionAdministrativo2(args[18], args[19], "1");
		Camino_Feliz_Flujo_Sagcom.SolicitudAdministrativo2(args[2],"2");		
	}
	
	@DataProvider(name = "Data7")
	public Object[][] cargarDatos7() throws IOException, CsvValidationException {

		return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 30);
	}
}

