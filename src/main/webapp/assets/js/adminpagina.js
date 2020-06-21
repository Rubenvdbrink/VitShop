function isAdmin() {
    fetch("vitshop/authentication/checkadmin", {headers: { 'Authorization': `Bearer ${window.sessionStorage.getItem("JWT")}` }})
        .then(function(response) {
            if(!response.ok) {
                window.location.href= "index.html";
                window.alert("U bent niet bevoegd!");
            }
        })
}
isAdmin();

function maakProduct() {
    let formData = new FormData(document.querySelector("#producttoevoegenform"));
    let encData = new URLSearchParams(formData.entries());

    fetch("vitshop/product/create", {method: 'POST', body: encData, headers: { 'Authorization': `Bearer ${window.sessionStorage.getItem("JWT")}` }})
        .then(function(response) {
            if(response.ok) {
                document.querySelector("#producttoevoegenform").reset();
                window.alert("Product aangemaakt");
                return response.json();
            } else throw "Kan product niet aanmaken!";
        })
        .catch(console.log && window.alert)
}

function verwijderProduct() {
    let formData = new FormData(document.querySelector("#productverwijderenform"));
    let encData = new URLSearchParams(formData.entries());

    fetch("vitshop/product/remove", {method: 'DELETE', body: encData, headers: { 'Authorization': `Bearer ${window.sessionStorage.getItem("JWT")}` }})
        .then(function(response) {
            if(response.ok) {
                document.querySelector("#productverwijderenform").reset();
                window.alert("Product verwijderd");
                return response.json();
            } else throw "Kan product niet verwijderen!";
        })
        .catch(console.log && window.alert)
}

document.querySelector("#toevoegenbutton").addEventListener("click", maakProduct);
document.querySelector("#verwijderenbutton").addEventListener("click", verwijderProduct);