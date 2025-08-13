package test.java.previred;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.pageEvents.Retomar_Solicitud_sin_Terminar;
import main.java.utils.GG_OpenCSV;
import main.java.utils.GG_Utils;

import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

//En esta clase se ejecutan los Pasos de la Pagina.
public class CU004_Retomar_Solicitud_sin_Terminar extends CC_Test {

	@Test(enabled = true, dataProvider = "Data")
	public void Flujo_Sagcom(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Ingreso de Solicitud Flujo SAGCOM", "Validar el ingreso de una solicitud flujo sagcom");
		Retomar_Solicitud_sin_Terminar.iniciarSesion(args[0], args[1], "1");// toma el dato del archivo de carga
		Retomar_Solicitud_sin_Terminar.iniciarSolicitud(args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9],
				args[10], args[11], args[12], args[13], args[14], args[15], args[16], args[17], args[18], args[19], "2");

	}
	
    @DataProvider(name = "Data")
    public Object[][] cargarDatos() throws IOException, CsvValidationException {
        // Pasar sólo 2 parámetros, el CSV y el número mínimo columnas (ejemplo 18)
        return GG_OpenCSV.getCSVParameters("Flujo_Sagcom.csv", 20);
    }

}
