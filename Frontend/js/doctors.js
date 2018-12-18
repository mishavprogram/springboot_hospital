const baseURL = 'http://localhost:8081/api'


// чорнові функції
function postUser() {
      // console.log(event.target.parentNode.firstElementChild.id);
  // const user = getElementById('row1').innerText;
    fetch(baseURL, {
        method: 'POST',
        data: 'Steve Rogers',
      })
    .then(() => alert('success'))
    .catch(() => alert('failed'))
}


document.addEventListener('DOMContentLoaded', main)
// async function  main() {

//   const temp = await fetch(baseURL + '/doctors');
//   const doctors  = await temp.json();
//   displayDoctors(doctors);

// }
function  main() {
  var title = document.getElementById("title");
  title.innerHTML += sessionStorage.getItem("patName");

  fetch(baseURL + '/doctors')
    .then(d => d.json())
    // .then(d => d.slice(1))
    .then(d => displayDoctors(d))
    .catch(err => alert(err))
}


  function displayDoctors(doctors) {
   var doctorsTable = document.getElementById('doctorsTable');
    console.log(doctors);
    doctors.forEach(function(doc){
      var tr = document.createElement("tr");
      for (key in doc) {
        var td = document.createElement("td");
        if (key == "id") {
          td.id = doc[key];
        }
        td.innerHTML = doc[key];
        tr.append(td);
      }
      doctorsTable.append(tr);
    });

    doctorsTable.addEventListener("click", function(event) {
      var id;
      var name;
      if (event.target.parentNode.firstElementChild.id.length != 0) {
        id = +event.target.parentNode.firstElementChild.id;
        name = event.target.parentNode.children[1].innerHTML;
      }
      //console.log(id);
      sessionStorage.setItem("docID", id);
      sessionStorage.setItem("docName", name)
      document.location.href = "reseptionTime.html";
    }) 
  }

