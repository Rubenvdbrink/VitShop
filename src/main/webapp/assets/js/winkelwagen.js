const productSjabloon = `
        <div class="product" id="jsProduct">
            <div class="afbeelding">
                <img id="jsAfbeelding" class="afbeelding" src="" alt="" width="100px" height="100%">
            </div>
            <div class="titel">
                <h3 id="jsTitel" class="titel"></h3>
            </div>
            <div class="prijs">
                <p id="jsPrice"></p>
            </div>
            <div class="aantal">
                <input id="jsAantal" type="number" min="1" name="aantal">
            </div>
            <div class="verwijder">
                <button>Verwijder</button>
            </div>
        </div>
    <hr>`;

const alleProducten = document.querySelector("#jsProducten");


function redirectLogIn() {
    if(!window.sessionStorage.getItem("JWT")) {
        window.alert("U moet ingelogd zijn om uw winkelmandje te kunnen zien!");
        window.location.href = "inloggen.html";
    }
    else {
        fetch("vitshop/klant/winkelwagen", {method: 'GET', headers: { 'Authorization': `Bearer ${window.sessionStorage.getItem("JWT")}` }})
            .then(data => data.json()).then(data => toonWinkelwagen(data));
    }
}
redirectLogIn();

function toonWinkelwagen(data) {
    data.forEach(p => {
        let sjabloon = document.createElement("template");
        sjabloon.innerHTML = productSjabloon;

        let product = sjabloon.content.cloneNode(true).firstElementChild;

        let productAfbeelding = product.querySelector("#jsAfbeelding");
        console.log(p);
        productAfbeelding.setAttribute("src", p.afbeeldingPad);
        let productTitel = product.querySelector("#jsTitel");
        productTitel.textContent = p.titel;
        let productPrijs = product.querySelector("#jsPrijs");
        productPrijs.textContent = `€${p.prijs}`;

        alleProducten.appendChild(product);
    });
}