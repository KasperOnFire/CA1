/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




function createCompany(){

var companyName = document.getElementById("companyName").value;
var companyDesc = document.getElementById("companyDescription").value;
var companyCVR = document.getElementById("companyCVR").value;
var companyNumEmp = document.getElementById("companyNumEmp").value;
var companyValue = document.getElementById("companyValue").value;    
    
var apiLink = "http://localhost:8084/CA1_ORM_REST_JS/api/company";    

var newCompany = {
    
    name: companyName,
    description: companyDesc,
    cvr: companyCVR,
    numEmployees: companyNumEmp,
    marketValue: companyValue
    
};

var data = new FormData();
data.append( "json", JSON.stringify( newCompany ) );

fetch(apiLink,
{
    method: "POST",
    body: data
})
.then(function(res){ return res.json(); })
.then(function(data){ alert( JSON.stringify( data ) ) });

   
}

