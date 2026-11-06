const API_URL =
  "http://ec2-54-221-105-146.compute-1.amazonaws.com:8089/people";

const lista = document.getElementById("nombres");

const btn = document.getElementById("submitter");

const input = document.getElementById("nombre");

const form = document.getElementById("form");

form.addEventListener("submit", (e) => e.preventDefaullt());

const spinner = `
    <div class="spinner-border mx-auto" role="status">
        <span class="visually-hidden">Cargando...</span>
    </div>
  `;

const get = () =>
  fetch(API_URL)
    .then((res) => res.json())
    .then((data) => pintarData(data))
    .catch(console.log)
    .finally(() => console.log("Ya se realizó el llamado"));

const post = (nombre) =>
  fetch(API_URL, {
    method: "POST",
    body: nombre,
  })
    .then((data) => {
      get();
      alert(`Se subió: ${data.nombre}`);
    })
    .catch(console.error)
    .finally(() => console.log("Ya se realizó el post"));

function pintarData(data) {
  lista.innerHTML = "";
  const list = data.map((d) => d.nombre);
  if (list.length === 0) {
    lista.innerHTML = `
    <div class="alert alert-info" role="alert">
        ¡No hay nada aún!
    </div>
    `;
  } else {
    list.forEach((element) => {
      const li = document.createElement("li");
      li.innerText = element;
      li.classList.add("list-group-item");
      lista.appendChild(li);
    });
  }
}

function pintarSpinner() {
  lista.innerHTML = spinner;
}

function enviar() {
  const payload = input.value.trim();
  if (payload === "") {
    alert("No envíes nombres vacíos");
    return;
  }
  pintarSpinner();
  post(payload);
}

pintarSpinner();
get();
