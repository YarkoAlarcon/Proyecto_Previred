package main.java.pageObjects;
//Dentro de esta clase se almacenaran todos los localizadores que se ocuparan.
public interface CC_Localizadores_Enfermo_Terminal {

	//Login Médico Presidente
	String inputUsuariomedicopresi = "//*[@id=\"normal_login_username\"]"; //XPATH  nombre de usuario Médico Presidente ubicado en csv posicion 19
	String inputContrasenamedicopresi = "//*[@id=\"normal_login_password\"]"; //XPATH password Médico Presidente ubicado en csv posicion 20 
	String btnIngresarmedpresi =  "//button[normalize-space()='Ingresar']"; //XPATH boton ingresar
	String opcMiTrabajomedicopresidente = "//li[contains(@class, 'ant-menu-item') and .//span[text()='Mi Trabajo']]"; //Valida login flujo administrativo
	String opcExpedientesEvaluacionMedica = "/html/body/div[1]/div/section/main/div/div/section/div/div[2]/div/div/div[1]"; //Click opcion Expedientes en evaluacion medica
	String opcionEnPendientesDeInicio = "/html/body/div[1]/div/section/main/div/div/section/div/div[2]/div/div/div[2]/div/section/div[1]/div[1]/div/label[1]";//Click opcion en pendientes de inicio
	String borrar = "//label[@class='ant-radio-button-wrapper']//span[small[contains(text(),'En evaluación')]]";

	
	String clickopcrutbuscarmedpresi = "//input[@placeholder='Buscar rut' and contains(@class,'ant-input')]"; //Opcion Expedientes por tipo de prioridad
	String rutSolicitanteBuscarmedipre = "//input[@placeholder='Buscar rut' and contains(@class,'ant-input')]"; //Rut solicitante a buscar csv posicion 2 
	String opcionLupaBuscarmedpresi = "//button[contains(@class, 'ant-input-search-button') and @type='button']"; //Click 
	String opcionVerMasmedpresi = "//button[contains(@class, 'ant-btn-link') and span[text()='Ver más']]"; //Click ver mas
	String opcionExpediente = "//button[span[text()='Ir al expediente']]";
	String comenzar = "//button[span[text()='Comenzar']]";
	String Anamnesis = "//div[text()='Anamnesis']";
	
	String opcevaluacionmedica = "//div[contains(@class, 'ant-tabs-tab-btn') and text()='Evaluación médica']"; //Click en Evaluación médica
	String Inputantecedentesper = "//*[@id='antecedentesPersonales']"; // Comentario en Antecedentes personales y/o laborales y/o mórbidos
	String cursalicenciamedica = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='No']])[2]"; // ¿Cursa con licencia médica? - No
	String inputAnamnesisycronolo = "//*[@id='anamnesisCronologia']"; // Comentario en Anamnesis y cronología de la evolución
	String inputtratamientoactual = "//*[@id='tratamientoActual']"; // Comentario en Tratamiento actual o reciente
	String inputotrostratamientos = "//*[@id='otrosTratamientos']"; // Comentario en Otros tratamientos
	String inputcomentarioEscenciales = "//*[@id='comentarioEscenciales']"; // Comentario en Seleccione las Actividades Esenciales interferidas
	String inputcomentariosdomesticos = "//*[@id='comentarioDomesticas']";// Comentario en Seleccione las Actividades Domésticas interferidas
	String inputcomentarioDesplazamiento = "//*[@id='comentarioDesplazamiento']"; // Comentario en Seleccione las Actividades de Desplazamiento interferidas
	String inputcomentariosociales = "//*[@id='comentarioSociales']"; // Comentario en Seleccione las Actividades de Eficiencia Social interferidas
	String clickNo = "/html/body/div[1]/div/section/main/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/form/div/div[10]/div/div/div[2]/div/div/div/label[2]/span[1]";
	String clickNo2 ="//label[contains(@class, 'ant-radio-wrapper') and .//span[text()='No']]";
	String btnguardarevamedica = "//button[@type='submit' and span[text()='Siguiente']]"; // Guarda Evuañuacion Médica
	String inputpulsaciones = "//*[@id='pulso']"; // Informar  Pulso
	String inputpresion = "//*[@id='presion']"; // Informar  Presion
	String inputalla = "//*[@id='talla']"; // Informar  Talla
	String inputpeso = "//*[@id='peso']"; // Informar  Peso
	
	String TextEstadoGenerak = "//textarea[@id='estadoGeneral']"; // Informar  Peso
	String TextTronco = "//textarea[@id='cabezaCuello']"; // Informar  Peso
	String TextExtremidadSuper = "//textarea[@id='extremidadSuperior']"; // Informar  Peso
	String TextExtremidadInfer = "//textarea[@id='extremidadInferior']"; // Informar  Peso
	String TextColumna = "//textarea[@id='columnaVertebral']"; // Informar  Peso
	String TextExamenMental = "//textarea[@id='examenMental']"; // Informar  Peso
	String TextExamenNeuro = "//textarea[@id='examenNeurologico']";
	
	String impedimentoconsiderar = "//input[contains(@placeholder, 'Agregue impedimentos')]"; // comentario Examen Físico - Impedimentos a considerar
	String btnguardaexamenfisico = "(//button[@type='submit' and @class='ant-btn ant-btn-primary ant-btn-block btn-form' and span[text()='Siguiente']])[2]"; // Guarda Examen Físico
	String clickOptplanaccion = "//input[@id='planAccion']/ancestor::div[contains(@class, 'ant-select')]"; //Click para desplegar las opciones de nivel educacional
	String optclicckplanaccion = "//div[contains(@class, 'ant-select-item-option') and text()='Cierre de caso']"; //De momento selecciona Cierre de caso
	String inputcomentariofinal = "//*[@id='comentarioFinal']"; // Comentario en Argumentos, configuración, menoscabos y comentario final
	String btnconfiguraragregarimpedimento = "//button[@class='ant-btn ant-btn-primary ant-btn-block btn-form']//span[contains(text(), 'Configurar')]"; // Configurar y Agregar Impedimentos
	String btnagregarotroimpedimento = "(//span[@aria-label='plus-circle' and contains(@class, 'anticon-plus-circle')])[2]"; // Boton agregar Otro Impedimento
	String inputagregarimpedimento = "(//input[@placeholder='Agregue impedimentos' and contains(@class,'react-tags__search-input')])[2]"; // comentario en Plan de Acción - Configurar y Agregar Impedimentos
	String clickOptconfiguracion = "(//button[@role='switch' and @aria-checked='false'])[1]"; // Configuración la opción NO - Así habilita los campos Clase y rango
	String clickOptmenuclase = "(//input[@id='claseImpedimento']/ancestor::div[contains(@class, 'ant-select')])[1]"; //Click para desplegar las opciones de Nivel educacional
	String optclickmenuclase = "//div[contains(@class, 'ant-select-item-option') and text()='IV']"; // Seleccionar valor "IV"
	String clickOptmenurango = "(//input[@id='rangoImpedimento']/ancestor::div[contains(@class, 'ant-select')])[1]"; //Click para desplegar las opciones de Rango educacional
	String optclickmenurango = "//div[contains(@class, 'ant-select-item-option') and text()='Alto']"; // Seleccionar valor "Alto"
	String btnagregarimpedimento = "(//button[@type='submit' and @class='ant-btn ant-btn-primary ant-btn-block btn-form'])[4]"; // Botonera Agregar Otro Impedimento 	
	String opcconfiguracionAVD = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='No']])[6]"; // ¿Existen impedimentos configurados del mismo capítulo que afectan la misma área de AVD y se... - NO
	String opcasignarcie10 = "//button[@class='ant-btn ant-btn-link' and span[text()='Asignar cie10']]"; // Link Asignar cie10
	String inputcodigocie10 = "(//input[@class='ant-input' and @type='text'])[6]"; // Poner texto para filtrar COMPLICACIONES VENOSAS DEL EMBARAZO
	String optlupacie10 = "//button[contains(@class, 'ant-input-search-button') and @type='button']"; // Presionar lupa de búsqueda
	String clickencabeceranombre = "//thead[@class='ant-table-thead']//th[normalize-space()='Nombre']"; // Click en la cabecera de título Nombre
	String opccodigoasignarcie10 = "//td[.//label[contains(@class, 'ant-radio-wrapper')]]//input[@type='radio']"; //  Asignar código cie10 - O22	COMPLICACIONES VENOSAS DEL EMBARAZO	
	String btnagregarasignarcie10codigo = "//button[@type='button' and @class='ant-btn ant-btn-primary ant-btn-block' and span[text()='Asignar']]"; // Botonera Asignar cie10 
	String opcinvalidezprevia = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='No']])[8]"; // Invalidez Previa - NO
	String btnguardarplandeaccion = "//button[@type='submit' and @class='ant-btn ant-btn-primary ant-btn-block btn-form' and span[text()='Guardar']]"; // Botonera Guardar Plan de Acción
	String btnenviarasesion = "//button[@type='button' and @class='ant-btn ant-btn-primary ant-btn-block' and span[text()='Enviar a revisión previa a sesión']]"; // Botonera Enviar a sesión
	
}