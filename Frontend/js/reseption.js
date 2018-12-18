var baseURL = "http://localhost:8081/api/receptions";
var doctorsURL = "http://localhost:8081/api/doctors";
var patientsURL = "http://localhost:8081/api/patients";

window.onload = function() {
	var title2 = document.getElementById('title2');
	title2.innerHTML = "Reseption time of doctor " + sessionStorage.getItem("docName") + " for today";
    var title = document.getElementById('title');
    title.innerHTML += sessionStorage.getItem("patName");

	fetch(baseURL)
	.then(d => d.json())
	.then(d => filterById(d))
	.then(d => displayReseptions(d));
}

function filterById(reseptions) {
	return reseptions.filter(function(item){
		return (item.doctor.id == sessionStorage.getItem("docID"));
	})
}

function displayReseptions(reseptions) {
	var reseptionsTable = document.getElementById('reseptionsTable');
    console.log(reseptions);
    var startTime = 9;
    for (var i = 0; i < 9; i++) {
    	var tr = document.createElement("tr");
    	var td = document.createElement("td");
    	td.innerHTML = i + 1;
    	tr.append(td);
    	for (var j = 0; j < 1; j++) {
    		var td = document.createElement("td");
    		tr.append(td);
    	}
    	var td = document.createElement("td");
    	td.innerHTML = startTime++ + ":00";
    	tr.append(td);
    	tr.addEventListener("click", fillReseption);
    	reseptionsTable.append(tr);
    }

    reseptions.forEach(function(res){
      var tr = document.createElement("tr");
        // var idTd = document.createElement("td");
        // idTd.id = res.id;
        // idTd.innerHTML = res.id;
        // tr.append(idTd);
        var date = new Date(res.localDate);
        var hours = date.getHours() + ":00";

        for (var iRow = 0; iRow < reseptionsTable.children.length; iRow++) {
        	if (reseptionsTable.children[iRow].lastElementChild.innerHTML == hours) {
        		reseptionsTable.children[iRow].className = "busy";
        		reseptionsTable.children[iRow].removeEventListener("click", fillReseption);
        		// reseptionsTable.children[iRow].children[1].innerHTML = res.doctor.name;
        		reseptionsTable.children[iRow].children[1].innerHTML = res.patient.name;
        	}
        }
    });
}


async function fillReseption(event) {
	var time = event.target.parentNode.lastElementChild.innerHTML;
	var doctor;
    var patient;
    var date = new Date();
    var reseption = {}

    await fetch(doctorsURL)
    .then(d => d.json())
    // .then(d => d.slice(1))
    .then(d => filterPeopleById(d, sessionStorage.getItem("docID")))
    .then(d => doctor = d)
    .catch(err => alert(err));

    // console.log(doctor)

    await fetch(patientsURL)
    .then(d => d.json())
    .then(d => filterPeopleById(d, sessionStorage.getItem("patID")))
    .then(d => patient = d)
    .catch(err => alert(err));

    // console.log(patient)
    var hours = event.target.parentNode.lastElementChild.innerHTML;
    var trueHours = "";
    var i = 0;
    while (hours[i] != ":") {
        trueHours += hours[i];
        i++;
    }

    date.setHours(+trueHours);
    date.setMinutes(0);
    date.setSeconds(0);
    // console.log(date);

    reseption.doctor = doctor;
    reseption.patient = patient;
    reseption.localDate = date.toISOString();
    console.log(reseption);

    fetch(baseURL, {
                method: 'POST',
                headers: {  
                    'Accept': 'application/json',
                  "Content-type": "application/json"  
                },
                body: JSON.stringify(reseption)
            })
            .then(() => alert('Success!'))
            .catch(() => alert('Failed!'));
            //document.location.href = "patients.html";
}

function filterPeopleById(arr, id) {
    //console.log(sessionStorage);
    for (var i = 0; i < arr.length; i++) {
        if (arr[i].id == id) {
            return arr[i];
        }
    }
}