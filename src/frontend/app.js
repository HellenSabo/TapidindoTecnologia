// 1. Listar eventos - GET
document.getElementById("listarEventos").addEventListener("click", function() {
  fetch('http://localhost:8080/api/eventos') // Confirme a URL da API
    .then(response => response.json())
    .then(data => {
      const eventosList = document.getElementById("eventosList");
      eventosList.innerHTML = '';  // Limpa a lista antes de adicionar novos itens
      data.forEach(evento => {
        const li = document.createElement("li");
        li.textContent = `${evento.titulo} - ${evento.dataEvento}`;
        eventosList.appendChild(li);
      });
    })
    .catch(error => console.error('Erro ao listar eventos:', error));
});

// 2. Criar evento - POST
document.getElementById("formEvento").addEventListener("submit", function(event) {
  event.preventDefault();

  const novoEvento = {
    titulo: document.getElementById("titulo").value,
    dataEvento: document.getElementById("dataEvento").value,
    descricao: document.getElementById("descricao").value,
    localidade: document.getElementById("localidade").value
  };  

  fetch('http://localhost:8080/api/eventos', {  // Confirme a URL da API
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(novoEvento)
  })
  .then(response => response.json())
  .then(data => alert("Evento criado com sucesso!"))
  .catch(error => console.error('Erro ao criar evento:', error));
});