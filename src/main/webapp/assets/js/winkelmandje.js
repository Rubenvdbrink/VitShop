function redirectLogIn() {
    if(!window.sessionStorage.getItem("JWT")){
        window.alert("U moet ingelogd zijn om uw winkelmandje te kunnen zien!");
        window.location.href = "inloggen.html";
    }
}
redirectLogIn();