package test.java.previred;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.pageEvents.Fallecimiento_beneficiario_durante_proceso;
import main.java.utils.GG_OpenCSV;
import main.java.utils.GG_Utils;

import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

//En esta clase se ejecutan los Pasos de la Pagina.
public class CU006_Fallecimiento_beneficiario_durante_proceso extends CC_Test {

	@Test(enabled = true, dataProvider = "Data", priority = 1)
	public void Flujo_Sagcom(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo SAGCOM", "Validar el ingreso de una solicitud flujo sagcom");
		Fallecimiento_beneficiario_durante_proceso.iniciarSesion(args[0], args[1], "1");// toma el dato del archivo de carga
		Fallecimiento_beneficiario_durante_proceso.iniciarSolicitud(args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9],
				args[10], args[11], args[12], args[13], args[14], args[15], args[16], args[17],"2");
	}
	
    @DataProvider(name = "Data")
    public Object[][] cargarDatos() throws IOException, CsvValidationException {
        // Pasar sólo 2 parámetros, el CSV y el número mínimo columnas (ejemplo 18)
        return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 18);
    }
    
	@Test(enabled = true, dataProvider = "Data1", priority = 2)
	public void Flujo_Sagcom_Administrativo(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Administrativo", "Validar flujo perfil administrativo");
		Fallecimiento_beneficiario_durante_proceso.iniciarSesionAdministrativo(args[18], args[19], "1");
		Fallecimiento_beneficiario_durante_proceso.iniciarSolicitudAdministrativo(args[2],"2");
	}
	
    @DataProvider(name = "Data1")
    public Object[][] cargarDatos1() throws IOException, CsvValidationException {
        // Pasar sólo 2 parámetros, el CSV y el número mínimo columnas (ejemplo 20)
        return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 20);
    }
    
	@Test(enabled = true, dataProvider = "Data2", priority = 3)
	public void Flujo_Sagcom_Medico(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Medico", "Validar flujo perfil medico");
		Fallecimiento_beneficiario_durante_proceso.iniciarSesionMedico(args[20], args[21], "1");
		Fallecimiento_beneficiario_durante_proceso.iniciarSolicitudMedico(args[2], args[22], args[23], args[24],args[25],args[26],args[27], "2");
	}
	
    @DataProvider(name = "Data2")
    public Object[][] cargarDatos2() throws IOException, CsvValidationException {
        // Pasar sólo 2 parámetros, el CSV y el número mínimo columnas (ejemplo 20)
        return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 28);
    }
    
	@Test(enabled = true, dataProvider = "Data3", priority = 4)
	public void Flujo_Sagcom_Administrativo1(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Administrativo", "Validar flujo perfil administrativo");
		Fallecimiento_beneficiario_durante_proceso.iniciarSesionAdministrativo1(args[18], args[19], "1");
		Fallecimiento_beneficiario_durante_proceso.iniciarSolicitudAdministrativo1(args[2], args[22], "2");		
	}
	
    @DataProvider(name = "Data3")
    public Object[][] cargarDatos3() throws IOException, CsvValidationException {
        // Pasar sólo 2 parámetros, el CSV y el número mínimo columnas (ejemplo 20)
        return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 28);
    }
	
}
