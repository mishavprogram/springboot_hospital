var baseURL = "http://localhost:8081/api/patients";
window.onload = function() {
	fetch(baseURL)
	.then(d => d.json())
	// axios.get(baseURL)
	.then(d => displayPatients(d));

	var enteredName = document.getElementById("enteredPatientName");
	var addBtn = document.getElementById("addPatButton");
  var fillResBtn = document.getElementById("fillRes");
  var showResultsBtn = document.getElementById("showRes");

  showResultsBtn.addEventListener("click", function() {
    document.location.href = "results.html";
  })

  fillResBtn.addEventListener("click", function() {
    document.location.href = "withoutResults.html";
  })

	addBtn.addEventListener("click", function(event){
		if (enteredName.value.length != 0) {
			var patient = {};
			patient.name = enteredName.value;
			console.log(JSON.stringify(patient));
			fetch(baseURL, {
	        	method: 'POST',
	        	headers: {  
	        		'Accept': 'application/json',
			      "Content-type": "application/json"  
			    },
	        	body: JSON.stringify(patient)
      		})
    		.then(() => alert('Success!'))
    		.catch(() => alert('Failed!'));
    		//document.location.href = "patients.html";
		} else {
			alert("Please, enter patient name");
		}
	});
}

function displayPatients(patients) {
	var patientsTable = document.getElementById("patientsTable");
    console.log(patients);
    patients.forEach(function(pat){
      var tr = document.createElement("tr");
      for (key in pat) {
        var td = document.createElement("td");
        if (key == "id") {
          td.id = pat[key];
        }
        td.innerHTML = pat[key];
        tr.append(td);
      }
      patientsTable.append(tr);
    });

    patientsTable.addEventListener("click", function(event) {
      var id;
      var name;
      if (event.target.parentNode.firstElementChild.id.length != 0) {
        id = +event.target.parentNode.firstElementChild.id;
        name = event.target.parentNode.children[1].innerHTML;
      }
      //console.log(id);
      sessionStorage.setItem("patID", id);
      sessionStorage.setItem("patName", name)
      document.location.href = "doctors.html";
    }) 
}
