package main.java.pageObjects;
//Dentro de esta clase se almacenaran todos los localizadores que se ocuparan.
public interface CC_Localizadores_Flujo_Sagcom {

	//Login
	String inputUsuario = "//*[@id=\"normal_login_username\"]"; //XPATH  nombre de usuario ubicado en csv posicion 0
	String inputContrasena = "//*[@id=\"normal_login_password\"]"; //XPATH password ubicado en csv posicion 1
	String btnIngresar =  "//button[normalize-space()='Ingresar']"; ; //XPATH boton ingresar
	
	//Valida login exitoso a SAGCOM
	String validaLoginExitoso = "//h1[contains(text(), 'Sistema de Apoyo a la Gestión de las Comisiones Médicas')]";
	
	//Ingresar datos para nueva solicitud (datos desde csv)
	String inputRutSolicitante = "//input[@id='rut']"; //XPATH  rut solicitante ubicacion en csv 2
	String btnComenzar = "//button[normalize-space()='Comenzar']"; 
	
	//Valida ingreso a creacion de nueva solicitud mediante la busqueda por rut de un solicitante
	String validaCrearNuevaSolicitud = "//h3[contains(text(), 'Ingreso de Nueva Solicitud')]";

    //Ingresar informacion del solicitante paso 1
	String clickOptTipoSolicitud  = "//input[@id='tipoExpediente']/ancestor::div[contains(@class,'ant-select')]/div[@class='ant-select-selector']"; //Click para opcion tipo de solicitud
	String optTipoSolicitud  = "//div[contains(@class, 'ant-select-item-option') and text()='Calificación de invalidez de un afiliado']";//Opcion tipo de solicitud
	String nroInstitucion  = "//input[@id=\'numeroInterno\']"; //Ubicacion en csv 3
	String btnBuscar = "//button[normalize-space()='Buscar']"; //Click btn buscar para validar si existe alguna solicitud creada
	String optEnfermoTerminal = "//label[contains(@class, 'ant-radio-wrapper') and .//span[text()='No']]"; //Seleciona opcion si/no enfermo terminal
	String fechaRecepcionAfp  = "//input[contains(@placeholder, 'Seleccionar fecha')]"; //Ubicacion en csv 4, se llama igual a fecha de nacimiento
	String nombreSolicitante  = "//input[@id='nombre']"; //Ubicacion en csv 5
	String primerApellidoSolicitante  = "//input[@id='apellidoPaterno']"; //Ubicacion en csv 6
	String segundoApellidoSolicitante  = "//input[@id='apellidoMaterno']"; //Ubicacion en csv 7
	String fechaNacimiento  = "//*[@id=\"fechaNacimiento\"]"; //Ubicacion en csv 8
	String clickOptTipoSexo = "//input[@id='sexo']/ancestor::div[contains(@class, 'ant-select')]//div[contains(@class, 'ant-select-selector')]"; //Click para abrir la selecion tipo sexo
	String optTipoSexo = "//div[contains(@class, 'ant-select-item-option') and text()='Masculino']"; //Seleciona la opcion tiopo de sexo masculino
	String clickOptEstadoCivil = "//input[@id='estadoCivil']/ancestor::div[contains(@class,'ant-select')]/div[contains(@class,'ant-select-selector')]"; //Click para desplegar opciones de estado civil
	String optEstadoCivil = "//div[contains(@class, 'ant-select-item-option') and text()='Casado(a)']"; //Se pone en bruto por el momento, casado
	String profesion  = "//input[@id=\"profesionActividad\"]"; //Ubicacion en csv 9
	String optEmail = "//div[@id='isNoTieneEmail']//label[.//span[text()='No']]"; //Seleciona opsion si/no email en este caso sera opcion no
	String numeroMovil = "//input[@id='celular']"; //Ubicacion en csv 10
	String numeroFijo = "//input[@id='telefono']"; //Ubicacion en csv 11
	String clickOptNivelEducacional = "//input[@id='nivelEducacional']/ancestor::div[contains(@class, 'ant-select')]"; //Click para desplegar las opciones de nivel educacional
	String optNivelEducacional = "//div[contains(@class, 'ant-select-item-option') and text()='Educación Media']"; //De momento selecciona analfabeto
	String clickOptRegion  = "//input[@id='region']/ancestor::div[contains(@class,'ant-select-selector')]"; //Click para desplegar las opociones de regiones
	String optRegion  = "//div[contains(@class, 'ant-select-item-option') and text()=concat('Libertador General Bernardo O', \"'\", 'Higgins')]"; //Seleciona opcion bernardo ohiggins
	String clickOptProvincia  = "//input[@id='ciudad']/ancestor::div[contains(@class, 'ant-select-selector')]"; //Click ára desplegar las opciones de provincia
	String optProvincia  = "//div[contains(@class, 'ant-select-item-option') and text()='Cachapoal']"; //Click opcion provincia cachapoal
	String clickOptComuna  = "//input[@id='comuna']/ancestor::div[contains(@class, 'ant-select')]/div[@class='ant-select-selector']"; //Click para desplegar las opciones de comuna
	String optComuna  = "//div[contains(@class, 'ant-select-item') and .//div[text()='Rancagua']]"; //Click opcion rancagua
	String direccion = "//input[@id='calle']"; //Ubicacion en csv 12
	String nroDireccion = "//input[@id='numero']"; //Ubicacion en csv 13
    String btnContinuar = "//button[contains(@class, 'ant-btn') and contains(@class, 'btn-form') and span[text()='Continuar']]"; //Click al btn continuar para seguir ingrdsando informacion del solicitante
	
    
    //Ingresar informacion del solicitante paso 2
    String clickSituacionLaboral = "//div[contains(@class, 'ant-select') and contains(@class, 'ant-select-single') and .//input[@id='tipoTrabajador']]"; //Click para desplegar opciopn situacion laboral
    String optSituacionLaboral = "//div[contains(@class, 'ant-select-item-option') and text()='Trabajador dependiente - Sector Privado']"; //Click para seleccionar opcion Trabajador Independiente o voluntario
	String rutEmpledo="//input[contains(@class, 'ant-input') and @id='rutEmpleador']";
    String RazonSocial ="//input[contains(@class, 'ant-input') and @id='razonSocial']";
	//String clickOptRegion1  = "//input[@id='regionEmpleador']";//div[@class='ant-select-selector']"; //Click para desplegar las opociones de regiones
    String clickOptRegion1 = "//div[contains(@class, 'ant-select') and contains(@class, 'ant-select-single') and .//input[@id='regionEmpleador']]"; //Click para desplegar opciopn situacion laboral
    String clickOptProvincia1 = "//div[contains(@class, 'ant-select') and contains(@class, 'ant-select-single') and .//input[@id='ciudadEmpleador']]"; //Click para desplegar opciopn situacion laboral
    String clickOptComuna1 = "//div[contains(@class, 'ant-select') and contains(@class, 'ant-select-single') and .//input[@id='comunaEmpleador']]"; //Click para desplegar opciopn situacion laboral
	String optComuna1  = "//div[contains(@class, 'ant-select-item') and .//div[text()='Rancagua']]"; //Click opcion rancagua
	String direccion1 = "//input[@id='calleEmpleador']"; //Ubicacion en csv 12
	String nroDireccion1 = "//input[@id='numeroEmpleador']"; //Ubicacion en csv 13
	
    
    
    String clickInstitucionSalud = "//input[@id='institucionSalud']/ancestor::div[contains(@class, 'ant-select-selector')]"; //Click para desplegar opciones tipo de salud ej: fonasa
	String optInstitucionSalud = "//div[contains(@class, 'ant-select-item-option') and text()='Isapre Banmedica']"; //Click para seleccionar fonasa
	String fechaAfiliacionAfp = "//*[@id='fechaAfiliacionAfp']"; //Ubicacion en csv 14
	String opcCambioAfp = "//div[@id='cambioAfiliacion']//label[.//span[text()='Si']]"; //Opcion si/no para si realizo cambio de afp (No)
	String fechaIncorporacionAfp = "//*[@id='fechaIncorporacionAfp']"; //Ubicacion en csv 14

	
	String opcMutualidad = "//div[@id='mutualidad']//label[.//span[text()='Si']]"; //¿Se encuentra pensionado por la ley 16.744? y ¿registra cotizaciones por ella? (No)
	String coberturaSis = "//div[@id='isCoberturaSis']//label[.//span[text()='Si']]"; //¿Cuenta con cobertura del SIS el solicitante? (No)
	String conLicencia = "//div[@id='isLicenciaMedica']//label[.//span[text()='No']]"; //¿Está actualmente acogido a una licencia médica el solicitante? (No)
	String buttonArchivo ="//button[span[text()='Adjuntar documento de cobertura']]";
	String btnContinuarPaso2 ="//button[normalize-space()='Continuar']"; //Click botn continuar paso 2
	
	//Ingresar informacion del solicitante paso 3
    //Fecha de recepción de CAPRI no aplica
	String comparecerCm = "//div[@id='isIncapacidadSolicitante']//label[.//span[text()='Si']]"; //¿Beneficiario o afiliado incapacitado para comparecer en CM? si/no (No)
	String Incapacidad = "//div[@id='quienVerificaIncapacidad']//label[.//span[text()='Visita']]"; //¿Beneficiario o afiliado incapacitado para comparecer en CM? si/no (No)
	String archivoSubir2 ="//button[span[text()='Adjuntar certificado']]";
	String nombrePerVerificaIdentidadAfiliado = "//input[@id='nombreVerificaIdentidad']"; //Nombre de la persona que verificó la identidad del afiliado en AFP
	String requiereTercero = "//div[@id='isTercero']//label[.//span[text()='Si']]"; //¿Requiere representación de un tercero? No
	String archivoSubir3 ="//button[span[text()='Adjuntar mandato o documento']]";
	String nombreEmpleado = "//input[@id='nombreTercero']";
	String apellidoEmpleado ="//input[@id='apellidoTercero']";
	String correoEmpleado ="//input[@id='emailTercero']";
	String numeroMovil1 = "//input[@id='telefonoTercero']"; //Ubicacion en csv 10
	String numeroFijo1 = "//input[@id='telefonoFijoTercero']"; //Ubicacion en csv 11
	
	String adminDelSeguro = "//input[@id='entidadAdmSeguro']"; //Entidad administradora del seguro de accidentes del trabajo y enfermedades profesionales que se encuentre adscrito el solicitante
	String accidenteTrabajorEnfermedadProfesional = "//div[@id='isAccidenteTrabajo']//label[span[text()='Si']]"; //Ha sufrido algún accidente del trabajo o enfermedad profesional
	String nombreInstitucion = "//input[@id='nombreInstitucionAsegurado']";
	String fechaAccidente = "//input[@id='fechaAccidente']";
	String IndemnizacionTrabajorEnfermedadProfesional = "//div[@id='isIndemnizacionAccidente']//label[span[text()='Si']]"; //Ha sufrido algún accidente del trabajo o enfermedad profesional
	String PensionTrabajorEnfermedadProfesional = "//div[@id='isPensionAccidente']//label[span[text()='Si']]"; //Ha sufrido algún accidente del trabajo o enfermedad profesional
	String entidadEvaluadoraAccidente = "//input[@id='entidadEvaluadoraAccidente']";
	String informacionAccidentes = "//textarea[@id='informacionAccidentes']";

	String afeccionOenfermedad = "//input[@id='enfermedadSolicitante']"; //Principal afección o enfermedad por la que solicita este beneficio
	String porcentajeAfiliado = "//div[@id='porcentCargoAfiliado']//label[span[text()='10%']]"; //Ingrese el porcentaje de cargo del afiliado a la Administradora del arancel establecido por el D.F.L. Nº1, de 2005
	String btnContinuarPaso3 = "//button[span[text()='Continuar']]"; //Click botn continuar paso 3
	
	//Ingresar informacion del solicitante paso 4
	String incorporarAntecedentes = "//div[@id='isAcompanaAntecedentesMedicos']//label[span[text()='Si']]"; //Incorporar otros antecedentes No
	String clickOptTipoArchivo  = "//input[@id='tipoArchivos-1']/ancestor::div[contains(@class,'ant-select')]/div[@class='ant-select-selector']"; //Click para opcion tipo de solicitud
	String optTipoArchivo  = "//div[contains(@class, 'ant-select-item-option') and text()='Imágenes']";//Opcion tipo de solicitud
	String archivoSubir4 ="//button[span[text()='Adjuntar certificado']]";
	String btnContinuarPaso4 = "//button[span[text()='Continuar']]"; //Click botn continuar paso 4
	
	//Ingresar informacion del solicitante paso 5
	String btnFinalizarPaso5 = "//button[span[text()='Finalizar']]"; //Click botn finalizar paso 5
	
	//Flujo perfil administrativo
	String validaLoginExitosoFlujoAdm = "//span[text()='Perfil Administrativo']"; //Valida login perfil flujo administrativo
	String opcMiTrabajoAdministrativo = "//li[contains(@class, 'ant-menu-item') and .//span[text()='Mi Trabajo Administrativo']]"; //Click opcion mi trabajo administrativo
	String analisisAdmisibilidad = "//div[@class='ant-collapse-header']//span[contains(text(), 'Análisis de admisibilidad')]"; //Click opcion Análisis de admisibilidad
	String expedienteTipoPrioridad = "//label[@class='ant-radio-button-wrapper' and .//small[contains(text(), 'Regular')]]"; //Opcion Expedientes por tipo de prioridad regular
	String rutSolicitanteBuscar = "//input[@placeholder='Buscar rut' and contains(@class,'ant-input')]"; //Rut solicitante a buscar
	String opcionLupaBuscar = "//button[contains(@class, 'ant-input-search-button') and @type='button']"; //Click 
	String opcionVerMas = "//button[contains(@class, 'ant-btn-link') and span[text()='Ver más']]"; //Click ver mas
	String clicksiprobar1 = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='Si, Aprobar']])[1]"; // click en Si, Apobar 1er documento
	String clicksiprobar2 = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='Si, Aprobar']])[3]"; // click en Si, Apobar 2do documento
	String clicksiprobar3 = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='Si, Aprobar']])[5]"; // click en Si, Apobar 3er documento
	String clicksiprobar4 = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='Si, Aprobar']])[7]"; // click en Si, Apobar 3er documento
	
	String admisibilidadSolicitud = "//div[@id='isCompletitud']//label[.//span[text()='Rechazar y devolver']]"; //Click Admisibilidad de la solicitud aceptar
	String clickTipoMotivo = "//input[@id='motivoObservacion']/ancestor::div[contains(@class, 'ant-select')]//div[contains(@class, 'ant-select-selector')]"; //Click para abrir la selecion tipo sexo
	String optTipoMotivo = "//div[contains(@class, 'ant-select-item-option') and text()='Error en tipo de solicitud ingresada']"; //Seleciona la opcion tiopo de sexo masculino
	
	
	String motivoRechado = "//*[@id=\"descripcionMotivo\"]"; //XPATH  nombre de usuario ubicado en csv posicion 0

	String btnConfirmar = "//button[@type='submit' and span[text()='Confirmar']]"; //Click boton confirmar
	
	//Login flujo perfil medico
	String validaLoginExitosoFlujoMedico = "//span[text()='Perfil Médico Presidente']"; //Valida login perfil flujo medico
	String opcMiTrabajo = "//li[contains(@class, 'ant-menu-item') and .//span[text()='Mi Trabajo']]"; //Click opcion mi trabajo
	String opcionAsignarMedico = "//div[contains(@class, 'ant-collapse-header') and .//span[contains(text(), 'Asignar médico')]]"; //Click en opcion asignar medico
	String opcionRegular = "//label[.//small[contains(text(),'Regular')]]"; //Click opcion regular
	String ingresarRutAbuscar = "//input[@placeholder='Buscar rut']"; //Ingresa Rut del solicitante a buscar
	String clickLupaBuscar = "//button[contains(@class, 'ant-btn-primary') and contains(@class, 'ant-input-search-button')]"; //Click en lupa para buscar por rut
	String clickAcciones = "//div[contains(@class, 'ant-space') and .//div[text()='Acciones']]//span[@role='img' and contains(@class, 'anticon-down')]"; //Click en acciones para desplegar opciones
	String clickOpcionModificar = "//button[span[text()='Modificar']]"; //Click opcion modificar
	String clickMedicoDisponible = "(//input[@type='radio' and contains(@class, 'ant-radio-input')])[1]"; //Click opcion medico disponible
	String clickConfirmarMedico = "//button[@type='button' and contains(@class, 'ant-btn-primary') and span[text()='Confirmar médico']]"; //Click boton confirmar medico
	
	//Flujo perfil administrativo
	String opcionCitaciones = "//div[@class='ant-collapse-header']//span[contains(text(), 'Citaciones')]"; //Click opcion citaciones
	String expedienteTipoPrioridad1 = "//span[contains(@class, 'ant-radio-button-checked')]//input[@value='regular']"; //Opcion Expedientes por tipo de prioridad regular
	String opcClickAcciones = "//button[contains(., 'Acciones')]"; //Click opcion acciones
	String opcClickReagendar = "//li[normalize-space()='Reagendar']"; //Click opcion reagendar
	String seleccionarHoraDisponible = "//*[@id='horas']/div/div/div/label[1]"; //Click opcion hora disponible medico
	String botonConfirmar = "//button[span[text()='Confirmar']]"; //Click btn confirmar
	String gestionarCitacion = "//button[span[text()='Gestionar citación']]"; //Click opcion gestionar citacion
	String previsualizarCarta = "//button[span[text()='Previsualizar Carta']]"; //Click opcion previsualizar carta
	String btnConfirmarCita = "//button[span[text()='Confirmar cita']]"; //Click btn confirmar cita
	
	//Flujo perfil administrativo
	String asistencia = "//div[contains(@class, 'ant-collapse-header') and .//span[contains(text(), 'Confirmar asistencia a evaluaciones médicas')]]"; //Confirmar asistencia a evaluaciones médicas
	String comisiones = "//span[@class='ant-select-selection-item' and @title='Rancagua' and text()='Rancagua']"; //Comisiones
	String modalidadEvaluacion = "//label[@class='ant-radio-button-wrapper' or contains(@class,'ant-radio-button-wrapper')][span[text()='Presencial']]"; //Modalidad de evaluación médica
	String opcAcciones1 = "//button[contains(., 'Acciones')]"; //Click opcion acciones
	String clickSobreCupo = "//li[contains(@class, 'ant-dropdown-menu-item')]//button[span[text()='Sobrecupo']]";
	String clickHora = "//input[@id='horaInicio']";
	String clickHora2 = "//input[@id='horaFin']";
	String aceptar = "//button[span[text()='Aceptar']]";
	String aceptar2 = "//li[contains(@class,'ant-picker-ok')]//button[.//span[text()='Aceptar']]";
	String clickConfirmarSobreCupo= "//button[span[text()='Confirmar']]";
	String clickConfirmar = "//li[contains(@class, 'ant-dropdown-menu-item')]//button[span[text()='Confirmar']]"; //Click opcion confirmar
	String clickOpcionSi = "//button[contains(@class, 'ant-btn-primary')]//span[text()='Sí']"; //Click opcion Si
	
	//Flujo perfil medico integrante
	String validaLogin = "//div[contains(@class, 'ant-alert-success')]//span[text()='Conozca aquí las funciones que puedo realizar como médico.']"; //Valida login exitoso
	
	//Flujo perfil medico presidente paso 6
	String opcionMisExpedientes = "/html/body/div/div/section/main/div/div/section/div/div[3]/div/div[4]/div[1]/span"; //Click en opcion derivar expedientes a sesion
	String rut ="//input[@placeholder='Buscar rut']";
	String Buscar ="//button[contains(@class,'ant-input-search-button')]";
	String clicpEnviar = "//span[@class='ant-dropdown-menu-title-content']//span[text()='Enviar a sesión']";

	// Login Administrativo - Creación de Tabla de Sesión (Enfermo Terminal)
		String inputUsuario2 = "//*[@id=\"normal_login_username\"]"; //XPATH  nombre de usuario ubicado en csv posicion 0
		String inputContrasena2 = "//*[@id=\"normal_login_password\"]"; //XPATH password ubicado en csv posicion 1
		String btnIngresaadm2 = "//button[normalize-space()='Ingresar']"; //  Botonera Ingresar Administrador
		String btntrespuntos = "(//div[contains(@class, 'ant-menu-submenu-title')])[2]"; // Seleccionar opción tres puntos
		String optsesiones = "(//span[@class='ant-menu-title-content' and text()='Sesiones'])[2]"; // Seleccionar opción sesiones para generar tablas
		String btncreartabla = "//button[span[text()='+ Crear tabla']]"; // Presionar botonera crear tabla
		String clickcalendariocreatabla = "//input[@placeholder='Seleccionar fecha']"; //Opcion Expedientes por tipo de prioridad
		String btncalendarioahora = "//a[contains(@class, 'ant-picker-now-btn') and contains(text(), 'Ahora')]"; // seleccionar la opcipón Ahora 
		String opcexpedientecalificacion = "//h5[@class='ant-typography' and contains(text(), 'Expedientes de calificación')]"; //Click opcion Expedientes
		String botoniconofiltro ="//button[span[text()='Filtros']]"; // click en ícono de filtro
		String rutfiltroadm = "//input[@id='rutSolicitante']"; // Ingresar rut a buscar
		String clickfiltrarut ="//span[@class='anticon anticon-search']"; // Presionar en ícono de busqieda
		String clickcheckbox = "(//input[@type='checkbox' and contains(@class,'ant-checkbox-input')])[2]"; // seleccionar checkbox
		String btncreatablasesion = "//button[span[text()='Crear tabla sesión']]"; // hacer click en Crear Tabla Sesion
		
}
