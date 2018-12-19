var baseURL = "http://localhost:8081/api/receptions?status=NO_RESULT";
var returnBtn;

window.onload = function() {
    returnBtn = document.getElementById("returnBtn");
        returnBtn.addEventListener("click", function() {
        document.location.href = "patients.html";
    })

	fetch(baseURL)
	.then(d => d.json())
	.then(d => displayReseptions(d));
}

function displayReseptions(reseptions) {
	var withoutResultTable = document.getElementById('withoutResultTable');
    console.log(reseptions);
    
    reseptions.forEach(function(res){
        var tr = document.createElement("tr");

        var td = document.createElement("td");
        td.innerHTML = res.id;
        tr.append(td);

        var td = document.createElement("td");
        td.innerHTML = res.patient.name;
        tr.append(td);

        var td = document.createElement("td");
        td.innerHTML = res.doctor.name;
        tr.append(td);

        var td = document.createElement("td");
        var date =new Date(res.localDate);
        td.innerHTML = date.getHours() + ":00";
        tr.append(td);

        withoutResultTable.append(tr);
    });

    for (var iRow = 1; iRow < withoutResultTable.children.length; iRow++) {
        withoutResultTable.children[iRow].addEventListener("click", fillResult);
    }

    function fillResult(event) {
        sessionStorage.setItem("idResForRez", event.target.parentNode.firstElementChild.innerHTML);
        document.location.href = "addingRez.html";
    }
}