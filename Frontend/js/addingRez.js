var reseptionURL = "http://localhost:8081/api/reseptions";
var returnBtn;
var addRezBtn;
var enteredDiagnosis;

window.onload = function() {
	returnBtn = document.getElementById("returnBtn");
        returnBtn.addEventListener("click", function() {
        document.location.href = "patients.html";
    })

    enteredDiagnosis = document.getElementById("addRezField");
    addRezBtn = document.getElementById("addRezBtn");

    addRezBtn.addEventListener("click", fillResult);
}

async function fillResult(event){
	if (enteredDiagnosis.value.length != 0) {
		var reseptionId = sessionStorage.getItem("idResForRez");
		var result = {};
		result.info = enteredDiagnosis.value;

		console.log(reseptionId);

		await fetch(reseptionURL + `/${reseptionId}`)
		.then(d => d.json())
		.then(d => result.reseption = d)
		.catch(() => alert('Failed!'));

		console.log(result);
	} else {
		alert("Please, enter diagnosis");
	}
}