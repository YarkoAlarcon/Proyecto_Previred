package test.java.previred;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.pageEvents.Revisar_Bitacora;
import main.java.utils.GG_OpenCSV;
import main.java.utils.GG_Utils;

import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

//En esta clase se ejecutan los Pasos de la Pagina.
public class CU009_Revisar_Bitacora extends CC_Test {

	@Test(enabled = true, dataProvider = "Data", priority = 1)
	public void Flujo_Sagcom(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo SAGCOM", "Validar el ingreso de una solicitud flujo sagcom");
		Revisar_Bitacora.iniciarSesion(args[0], args[1], "1");// toma el dato del archivo de carga
		Revisar_Bitacora.iniciarSolicitud(args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9],
				args[10], args[11], args[12], args[13], args[14], args[15], args[16], args[17], args[18],"2");
	}
	
    @DataProvider(name = "Data")
    public Object[][] cargarDatos() throws IOException, CsvValidationException {
        // Pasar sólo 2 parámetros, el CSV y el número mínimo columnas (ejemplo 18)
        return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 19);
    }
    
	@Test(enabled = true, dataProvider = "Data1", priority = 2)
	public void Flujo_Sagcom_Administrativo(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Administrativo", "Validar flujo perfil administrativo");
		Revisar_Bitacora.iniciarSesionAdministrativo(args[19], args[20], "1");
		Revisar_Bitacora.iniciarSolicitudAdministrativo(args[2],"2");
	}
	
    @DataProvider(name = "Data1")
    public Object[][] cargarDatos1() throws IOException, CsvValidationException {
        // Pasar sólo 2 parámetros, el CSV y el número mínimo columnas (ejemplo 20)
        return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 21);
    }
    
	@Test(enabled = true, dataProvider = "Data2", priority = 3)
	public void Flujo_Sagcom_Medico(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo Perfil Medico", "Validar flujo perfil medico");
		Revisar_Bitacora.iniciarSesionMedico(args[21], args[22], "1");
		Revisar_Bitacora.iniciarSolicitudMedico(args[2], args[23], args[24], args[25],args[26],args[27],args[28], "2");
	}
	
    @DataProvider(name = "Data2")
    public Object[][] cargarDatos2() throws IOException, CsvValidationException {
        // Pasar sólo 2 parámetros, el CSV y el número mínimo columnas (ejemplo 20)
        return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 29);
    }
    
}
