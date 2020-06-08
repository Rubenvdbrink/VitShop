function register() {
    let formData = new FormData(document.querySelector("#registerform"));
    let encData = new URLSearchParams(formData.entries());

    fetch("vitshop/authentication/register", {method: 'POST', body: encData})
        .then(function(response){
            if (response.ok) {
                window.alert("Succesvol geregistreerd! \nU bent ook gelijk ingelogd.");
                return response.json();
            } else throw "Kan niet registreren! / Gebruikersnaam bestaat al";
        })
        .then(myJson => {
            window.sessionStorage.setItem("JWT", myJson.JWT);
            window.location.replace("index.html")
        })
        .catch(console.log && window.alert);
}

document.querySelector("#registerbutton").addEventListener("click", register);
document.querySelector("#inputemail").addEventListener('keydown', event => {
    if (event.key === 'Enter') {
        register();
    }
});
document.querySelector("#inputwachtwoord").addEventListener('keydown', event => {
    if (event.key === 'Enter') {
        register();
    }
});
document.querySelector("#inputgebruikersnaam").addEventListener('keydown', event => {
    if (event.key === 'Enter') {
        register();
    }
});
