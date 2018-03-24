var botaoAdicionar = document.querySelector("#adicionar-paciente");
botaoAdicionar.addEventListener("click", function(event) {
    event.preventDefault();

    var form = document.querySelector("#form-adiciona");

    var paciente = obtemPacienteDoForm(form);

    var pacienteTr = montaTr(paciente);


    var erro = validaPaciente(paciente);
    console.log(erro);
    if (erro.length > 0) {
        exibeMensagensDeErro(erro);
        return;
    }

    adicionaPacienteNaTabela(paciente);

    form.reset();
    var msgnErro = document.querySelector("#mensagensErro");
    msgnErro.innerHTML = "";

});

function adicionaPacienteNaTabela(paciente) {
    var pacienteTr = montaTr(paciente);
    var tabela = document.querySelector("#tabela-pacientes");
    tabela.appendChild(pacienteTr);
}

function exibeMensagensDeErro(erros) {
    var ul = document.querySelector("#mensagensErro");
    ul.innerHTML = "";
    erros.forEach(function(erro){
        var li = document.createElement("li");
        li.textContent = erro;
        ul.appendChild(li);
    });
}

function obtemPacienteDoForm(form){

  var paciente = {
    nome: form.nome.value,
    peso: form.peso.value,
    altura: form.altura.value,
    gordura: form.gordura.value,
    imc: calculaImc(form.peso.value, form.altura.value)
  }
  return paciente;
}


function montaTr(paciente){
      var pacienteTr = document.createElement("tr");
      pacienteTr.classList.add("paciente");
      var nomeTd = montaTd(paciente.nome, "info-nome");
      var pesoTd = montaTd(paciente.peso, "info-peso");
      var alturaTd = montaTd(paciente.altura, "info-altura");
      var gorduraTd = montaTd(paciente.gordura, "info-gordura");
      var imcTd = montaTd(paciente.imc, "info-imc");

      nomeTd.textContent = paciente.nome;
      pesoTd.textContent = paciente.peso;
      alturaTd.textContent = paciente.altura;
      gorduraTd.textContent = paciente.gordura;
      imcTd.textContent = paciente.imc;

      pacienteTr.appendChild(nomeTd);
      pacienteTr.appendChild(pesoTd);
      pacienteTr.appendChild(alturaTd);
      pacienteTr.appendChild(gorduraTd);
      pacienteTr.appendChild(imcTd);

      return pacienteTr;
}

function montaTd(dado, classe) {
    var td = document.createElement("td");
    td.classList.add(classe);
    td.textContent = dado;

    return td;
}

function validaPaciente(paciente){

    var erros = [];
    if (paciente.nome.length == 0) {
        erros.push("Nome não pode ser em branco");
    }
    if (!validaPeso(paciente.peso)) {
        erros.push("Peso é inválido");
    }

    if (!validaAltura(paciente.altura)) {
        erros.push("Altura é inválida");
    }

    if (paciente.gordura.length == 0 ) {
        erros.push("Gordura não pode ser em branco");
    }

    if (paciente.peso.length == 0 ) {
        erros.push("peso não pode ser em branco");
    }

    if (paciente.altura.length == 0 ) {
        erros.push("altura não pode ser em branco");
    }
    return erros;

}
