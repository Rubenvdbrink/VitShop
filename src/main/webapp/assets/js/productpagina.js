const productSjabloon = `
    <div class="productContainer" id="jsProductContainer">
        <div class="productAfbeelding">
            <img id="jsProductAfbeelding" src="" alt="Vitamine D">
        </div>
        <div class="productTitel">
            <h1 id="jsProductTitel">Vitamine D tabletten</h1>
        </div>
        <div class="productBeschrijving">
            <p id= "jsProductBeschrijving"></p>
        </div>
        <div class="productPrijs">
            <p id= "jsProductPrijs"></p>
        </div>
        <div class="bestelKnop">
            <button id="jsBestelKnop">Voeg toe aan winkelwagen</button>
        </div>
    </div>`;

function getProductId() {
    let param = new URLSearchParams(window.location.search);
    return param.get("productid");
}

const jsProductId = getProductId();
const productDiv = document.querySelector("#jsProduct");

fetch("vitshop/productpagina/" + `${jsProductId}`).then(data => data.json()).then(data => toonProduct(data));
// params: {productId:`${jsProductId}`},
function addProduct() {
    fetch("vitshop/winkelwagen/producttoevoegen/"+ `${jsProductId}`, {method: 'POST',
        headers: { 'Authorization': `Bearer ${window.sessionStorage.getItem("JWT")}` }})
        .then(function(response) {
            if(response.ok) {
                window.alert("Product toegevoegd aan uw winkelwagen!");
                return response.json();
            }
            else throw "Product kan niet toegevoegd worden";
        })
        .catch(console.log && window.alert);
}

function toonProduct(data){
    console.log(data);

    let sjabloon = document.createElement("template");
    sjabloon.innerHTML = productSjabloon;

    let product = sjabloon.content.cloneNode(true).firstElementChild;

    let productAfbeelding = product.querySelector("#jsProductAfbeelding");
    productAfbeelding.setAttribute("src", data.afbeeldingPad);

    let productTitel = product.querySelector("#jsProductTitel");
    productTitel.textContent = data.titel;

    let productBeschrijving = product.querySelector("#jsProductBeschrijving");
    productBeschrijving.textContent = data.beschrijving;

    let productPrijs = product.querySelector("#jsProductPrijs");
    productPrijs.textContent = `€${data.prijs}`;

    let bestelKnop = product.querySelector("#jsBestelKnop");
    bestelKnop.addEventListener("click", addProduct);

    productDiv.appendChild(product);
}
