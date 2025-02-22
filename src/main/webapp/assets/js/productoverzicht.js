const productSjabloon = `
        <div id="jsProduct" class="product">
            <a id="jsProductPagina" href="">
                <img id="jsProductAfbeelding" src="" alt="" class="productafbeelding">
                <div class="container">
                    <h1 id="jsProductTitel" class="producttitel"></h1>
                    <p id="jsProductBeschrijving" class="productbeschrijving"></p>
                    <p id="jsProductPrijs" class="prijs"></p>
                </div>
            </a>
        </div>`;

const alleProducten = document.querySelector("#jsProducten");

fetch("vitshop/product/getall").then(data => data.json()).then(data => toonProducten(data));

function toonProducten(data) {
    console.log(data);
    data.forEach(p => {
        let sjabloon = document.createElement("template");
        sjabloon.innerHTML = productSjabloon;

        let product = sjabloon.content.cloneNode(true).firstElementChild;

        //CONSTRUCTION AREA
        let productPagina = product.querySelector("#jsProductPagina");
        // productPagina.setAttribute("href", "productpagina.html");
        productPagina.setAttribute("href", (`productpagina.html?productid=${p.productId}`));
        //CONSTRUCTION AREA

        let productAfbeelding = product.querySelector("#jsProductAfbeelding");

        productAfbeelding.setAttribute("src", p.afbeeldingPad);
        let productTitel = product.querySelector("#jsProductTitel");
        productTitel.textContent = p.titel;
        let productBeschrijving = product.querySelector("#jsProductBeschrijving");
        productBeschrijving.textContent = p.beschrijving;
        let productPrijs = product.querySelector("#jsProductPrijs");
        productPrijs.textContent = `€${p.prijs}`;

        alleProducten.appendChild(product);
    });
}