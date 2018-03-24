//QUERY SELECTOR SELECIONA NO DOM (DOCUMENT) O QUE PEDIRMOS NO CASO O H1. O TEXTCONTENT BUSCA A PARTE DO CONTEUDO TEXTUAL VINDO DE UM ELEMENTO DO DOM
  var titulo = document.querySelector(".titulo");
  titulo.textContent = "Aparecida Nutrition :D";

//ADDEVENTLISTENER ESCUTA EVENTOS DO NAVEGADOR
titulo.addEventListener("click", function(){
  alert("Olá, eu fui clicado!");
});



var pacientes = document.querySelectorAll(".paciente");

var tamanhoLista = pacientes.length;

for (var i = 0 ; i < tamanhoLista ; i++) {
  var paciente = pacientes[i];

  var tdPeso = pacientes[i].querySelector(".info-peso");
  var peso = tdPeso.textContent;

  var tdAltura = pacientes[i].querySelector(".info-altura");
  var altura = tdAltura.textContent;

  var tdImc = pacientes[i].querySelector(".info-imc");

  var pesoEhValido = validaPeso(peso);
  var alturaEhValida = validaAltura(altura);

  if (!pesoEhValido) {
    console.log("Peso Invalido");
    pesoEhValido = false;
    tdImc.textContent = "Peso Invalido!";
    paciente.classList.add("paciente-invalido");

  }

  if (!alturaEhValida) {
    console.log("Altura Invalida");
    alturaEhValida = false;
    tdImc.textContent = "Altura Invalida!";
    paciente.classList.add("paciente-invalido");
  }

  if (pesoEhValido && alturaEhValida) {
    var imc = calculaImc(peso,altura);
    tdImc.textContent = imc;
  }
}

function validaPeso(peso){
    if(peso >= 0 && peso < 1000){
        return true;
    }
    else {
        return false;
    }
}

function validaAltura(altura){
    if(altura >= 0 && altura <= 3.0){
        return true;
    }
    else {
        return false;
    }
}


//função que calcula imc que pode ser feito o reuso em outro lugar
function calculaImc(peso,altura){
  var imc = 0;
  imc = peso / (altura*altura);
  return imc.toFixed(2);
}
