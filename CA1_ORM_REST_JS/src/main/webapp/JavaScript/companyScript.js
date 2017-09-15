function createCompany() {

    var companyName = document.getElementById("CompanyName").value;
    var companyDesc = document.getElementById("CompanyDescription").value;
    var companyCVR = document.getElementById("CompanyCVR").value;
    var companyNumEmp = document.getElementById("CompanyNumEmp").value;
    var companyValue = document.getElementById("CompanyValue").value;

    var apiLink = "http://localhost:8084/CA1_ORM_REST_JS/api/company";

    var newCompany = {

        name: companyName,
        description: companyDesc,
        cvr: companyCVR,
        numEmployees: companyNumEmp,
        marketValue: companyValue

    };

    var data = JSON.stringify(newCompany);
    console.log(data);

    fetch(apiLink, {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: data
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        alert("Company has been added to database!");
    });


}