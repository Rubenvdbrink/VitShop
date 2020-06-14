const productSjabloon = `
        <div class="product" id="jsProduct">
            <div class="afbeelding">
                <img id="jsAfbeelding" class="afbeelding" src="" alt="" width="100px" height="100%">
            </div>
            <div class="titel">
                <h3 id="jsTitel" class="titel"></h3>
            </div>
            <div class="prijs">
                <p id="jsPrijs"></p>
            </div>
<!--            <div class="aantal">-->
<!--                <input id="jsAantal" type="number" min="1" name="aantal">-->
<!--            </div>-->
            <div class="verwijder">
                <button id="jsVerwijderKnop">Verwijder</button>
            </div>
        </div>`;

const alleProducten = document.querySelector("#jsProducten");
const totaalPrijs_ = document.querySelector("#jsTotaalPrijs");
const bestelKnop = document.querySelector("#jsBestelButton");

bestelKnop.addEventListener("click", bestellen);

function redirectLogIn() {
    if(!window.sessionStorage.getItem("JWT")) {
        window.alert("U moet ingelogd zijn om uw winkelmandje te kunnen zien!");
        window.location.href = "inloggen.html";
    }
    else {
        fetch("vitshop/klant/winkelwagen", {method: 'GET', headers: { 'Authorization': `Bearer ${window.sessionStorage.getItem("JWT")}` }})
            .then(data => data.json()).then(data => toonWinkelwagen(data));
    }

    // CONSTRUCTION AREA
    // fetch("/vitshop/authentication/checklogin", {headers: { 'Authorization': `Bearer ${window.sessionStorage.getItem("JWT")}`}})
    //     .then(response => {
    //         fetch("vitshop/klant/winkelwagen", {method: 'GET', headers: { 'Authorization': `Bearer ${window.sessionStorage.getItem("JWT")}` }})
    //             .then(data => data.json()).then(data => toonWinkelwagen(data));
    //     })
    //     .catch(window.alert("U moet ingelogd zijn om uw winkelmandje te kunnen zien!"));
    // CONSTRUCTION AREA
}
redirectLogIn();

function round(value, decimals) {
    return Number(Math.round(value+'e'+decimals)+'e-'+decimals);
}

function verwijderProduct() {
    //WIP
    window.alert("deze functie is in een volgende versie beschikbaar!");
}

function bestellen() {
    //WIP
    window.alert("deze functie is in een volgende versie beschikbaar!");
}

function toonWinkelwagen(data) {
    console.log(data);
    let totaalPrijs = 0;
    data.forEach(p => {
        if (p === null) {}
        totaalPrijs = totaalPrijs + p.prijs;
        let sjabloon = document.createElement("template");
        sjabloon.innerHTML = productSjabloon;

        let product = sjabloon.content.cloneNode(true).firstElementChild;

        let productAfbeelding = product.querySelector("#jsAfbeelding");
        productAfbeelding.setAttribute("src", p.afbeeldingPad);
        let productTitel = product.querySelector("#jsTitel");
        productTitel.textContent = p.titel;
        let productPrijs = product.querySelector("#jsPrijs");
        productPrijs.textContent = `€${p.prijs}`;
        let verwijderKnop = product.querySelector("#jsVerwijderKnop");
        verwijderKnop.addEventListener("click", verwijderProduct);

        alleProducten.appendChild(product);
        alleProducten.appendChild(document.createElement("hr"))
    });
    totaalPrijs_.textContent = `Totaal: €${ round(totaalPrijs,2) }`;
}