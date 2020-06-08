function logout(){
    if (window.sessionStorage.getItem("JWT")) {
        window.sessionStorage.clear();
        window.alert("Succesvol uitgelogd!")
    } else {
        window.alert("U moet ingelogd zijn om te kunnen uitloggen!")
    }
}