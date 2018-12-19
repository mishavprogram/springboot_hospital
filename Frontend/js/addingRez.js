var reseptionURL = "http://localhost:8081/api/receptions";
var baseUrl = "http://localhost:8081/api/results";
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

		await fetch(reseptionURL + `/${reseptionId}`)
		.then(d => d.json())
		.then(d => result.reception = d)
		.catch(() => alert('Failed!'));

		//console.log(result);

		await fetch(baseUrl, {
	        	method: 'POST',
	        	headers: {  
	        		'Accept': 'application/json',
			      "Content-type": "application/json"  
			    },
	        	body: JSON.stringify(result)
      		})
    		.then(() => alert('Success!'))
    		.catch(() => alert('Failed!'));
    		document.location.href = "patients.html";	
	} else {
		alert("Please, enter diagnosis");
	}
}