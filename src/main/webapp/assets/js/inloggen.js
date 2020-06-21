function login() {
    let formData = new FormData(document.querySelector("#inlogform"));
    let encData = new URLSearchParams(formData.entries());

    fetch("vitshop/authentication/login", {method: 'POST', body: encData})
        .then(function(response) {
            if(response.ok) {
                window.alert("Succesvol ingelogd!");
                return response.json();
            } else throw "Verkeerde gebruikersnaam/wachtwoord!";
        })
        .then(myJson => {
            console.log(myJson);
            window.sessionStorage.setItem("JWT", myJson.JWT);
            window.location.replace("index.html");
        })
        .catch(console.log && window.alert);
}

document.querySelector("#loginbutton").addEventListener("click", login);
document.querySelector("#inputwachtwoord").addEventListener('keydown', event => {
    if (event.key === 'Enter') {
        login();
    }
});
document.querySelector("#inputgebruikersnaam").addEventListener('keydown', event => {
    if (event.key === 'Enter') {
        login();
    }
});