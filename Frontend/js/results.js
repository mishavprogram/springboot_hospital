var baseURL = "http://localhost:8081/api/results?status=HAS_RESULT";
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

function displayReseptions(results) {
	var diagnosesTable = document.getElementById('diagnosesTable');
    console.log(results);
    
    results.forEach(function(res){
        console.log(res);
        var tr = document.createElement("tr");

        var td = document.createElement("td");
        td.innerHTML = res.id;
        tr.append(td);

        var td = document.createElement("td");
        td.innerHTML = res.reception.doctor.name;
        tr.append(td);

        var td = document.createElement("td");
        td.innerHTML = res.reception.patient.name;
        tr.append(td);

        var td = document.createElement("td");
        td.innerHTML = res.info;
        tr.append(td);

        diagnosesTable.append(tr);
    });
}