/**
 * 
 */
var listaDeIdsDaPagina = new Array;

var arrayIdsElementsPage = new Array;

var idundefined = 'idundefined';

 function invalidarSession(contex,pagina){
	 document.location = (contex+pagina+'.jsf');
 }
 
 function validarSenhaLogin(){
	 j_username = document.getElementById("j_username").value;
	 j_password = document.getElementById("j_password").value;
	 if(j_username === null || j_username.trim() === ''){
		 alert("informe o login.");
		 $('#j_username').focus();
		 return false;
	 }
	 if(j_senha === null || j_senha.trim() === ''){
		 alert("informe a senha.");
		 $('#j_password').focus();
		 return false;
	 }
	 return true;
 }
 function logout (contextPath){
	var post = 'invalidar_session';
	$.ajax({
		type: "POST", url: post
	}).always(function(resposta){
		
		document.location = contextPath+'/j_spring_security_logout';
	});
 }
 
 function openMenuLoginInfo(){
	 $("#menuLoginInfo").show('slow').mouseleave(function(){
		closeMenuLoginInfo();
	 });
 }
 
 function closeMenuLoginInfo(){
	 if($("#menuLoginInfo").is(":visible")){
		 $("#menuLoginInfo").hide("slow");
	 }
 }
 
 function redirecionarPagina(context, pagina){
	 var sufixo = '.jsf';
	 document.location = context+pagina+sufixo;
 }
 
 function carregarIdDosElementosDaPagina(){
	 listaDeIdsDaPagina = new Array;
	 let allElementsWithIds = [... document.querySelectorAll('[id]')];
	 allElementsWithIds.forEach((element)=>{listaDeIdsDaPagina.push(element.id)});
 }
 
 /**
 * Carrega um array global com os ids de todos os componentes da pagina Para ter
 * faciliades em obtencao de valores dos componentes bem como trabalhar com ajax
 */
function carregarIdElementosPagina() {
	 arrayIdsElementsPage = new Array;
	 for (form = 0 ; form <= document.forms.length; form++){
		 var formAtual = document.forms[form];
		 if (formAtual != undefined) {
			 for (i = 0; i< document.forms[form].elements.length; i++){
				 if(document.forms[form].elements[i].id != '') {
					 arrayIdsElementsPage[i] = document.forms[form].elements[i].id;
				 }
			 }	
		 }
	 }
}
/**
 * Retorno o valor do id do componente dentro do documento html passando como
 * parametro a descrição do id declarada em jsf
 * 
 * @param id
 */
function getValorElementPorId(id) {
	 carregarIdElementosPagina();
	 for (i = 0; i< arrayIdsElementsPage.length; i++){
		 var valor =  ""+arrayIdsElementsPage[i];
		 if (valor.indexOf(id) > -1) {
			return valor;
	}
  }	
	 return idundefined;
}
function getIndexDoIdDoElemento(id){
	carregarIdDosElementosDaPagina();
	let index = listaDeIdsDaPagina.findIndex(id);
	if(index>-1){
		
		return index;
	}else{
		return idundefined;
	}
		
}
function localeData_pt_br() {
	PrimeFaces.locales['pt'] = {
		closeText : 'Fechar',
		prevText : 'Anterior',
		nextText : 'Próximo',
		currentText : 'Começo',
		monthNames : [ 'Janeiro', 'Fevereiro', 'Marcio', 'Abril', 'Maio',
				'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro',
				'Dezembro' ],
		monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul',
				'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
		dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta',
				'Sexta', 'Sábado' ],
		dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb' ],
		dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S' ],
		weekHeader : 'Semana',
		firstDay : 0,
		isRTL : false,
		showMonthAfterYear : false,
		yearSuffix : '',
		timeOnlyTitle : 'São Horas',
		timeText : 'Tempo',
		hourText : 'Hora',
		minuteText : 'Minuto',
		secondText : 'Segundo',
		ampm : false,
		month : 'Mês',
		week : 'Semana',
		day : 'Dia',
		allDayText : 'Todo o Dia'
	};
}

function ocultarMenu() {
  $('#barramenu').animate({"left":"-200px"}, "slow", function() {
  	$('#barramenu').hide();
  });
}
function initTamplete() {
	$(document).ready(function() {
	  $('#menupop').hide();
	  $('#barramenu').hide();
	  $('#barramenu').css("left", "-200px");
	  $('#iniciarmenu').click(function() {
	  	if ($('#barramenu').is(':visible')) {
	  	  ocultarMenu();
	  	} else {
	  	  $('#barramenu').show();
	  	  $('#barramenu').animate({"left":"0px"}, "slow");	
	  	}
	  });
	});
}