[#ftl]
<!DOCTYPE html>
<html lang="cs">
<head>
  [#include "_common/head.ftlh"]
</head>
<body  style="background-image: url('/img/parking.jpg'); background-position: center; background-repeat: no-repeat">
<div class="container d-flex flex-column flex-grow-1 justify-content-between bg-white p-0" style="background-color: white">
  [#include "_common/header.ftlh"]

  <h2 class="mt-5 mb-3 px-4 text-center">Rekapitulace</h2>

  <div class="px-4 py-3 my-4 justify-content-center d-flex flex-wrap">
    <div class="col-md-6 border rounded p-3" style="background-color: #f9f9f9;">
      <div class="row align-items-center border-bottom pb-2 mb-2">
        <div class="col-6 text-start">
          <p class="mb-0"><strong>Datum příjezdu: ${dateOfArrival}</strong></p>
        </div>
        <div class="col-6 text-start border-start ps-3">
          <p class="mb-0"><strong>Datum odjezdu:${dateOfDeparture} </strong> </p>
        </div>
      </div>
      <div class="row align-items-center border-bottom pb-2 mb-2">
        <div class="col-6 text-start">
          <p class="mb-0"><strong>Číslo parkovacího místa:</strong> ${parkingPlace.parkingNumber?default('Není dostupné')}</p>
        </div>
        <div class="col-6 text-start border-start ps-3">
          <p class="mb-0"><strong>Patro:</strong> ${parkingPlace.numberOfFlour?default('Není dostupné')}</p>
        </div>
      </div>
      <div class="row">
        <div class="col-12 text-start">
          <p class="mb-0"><strong>Cena:</strong> ${parkingPlace.newPrice?default('Není dostupné')} Kč</p>
        </div>
      </div>
    </div>
  </div>

  <div class="container mt-4 mb-4">
    <form action="/${parkingPlace.id}" method="post" class="mx-auto" style="max-width: 50%; border: 2px solid rgba(47,170,211,0.4); border-radius: 10px; padding: 20px;">
      <fieldset style="border: 2px solid rgba(77,71,71,0.4); border-radius: 10px; padding: 20px; margin-bottom: 20px;">
        <legend style="color: rgb(5,19,19); font-weight: bold; padding: 0 10px;">Osobní údaje</legend>
        <div style="margin-bottom: 15px;">
          <label for="firstName" style="display: block; margin-bottom: 5px;">Jméno</label>
          <input type="text" id="firstName" name="firstName"
                 style="width: 100%; padding: 8px; border: 2px solid rgba(77,71,71,0.4); border-radius: 5px;"
                 required>
        </div>
        <div style="margin-bottom: 15px;">
          <label for="lastName" style="display: block; margin-bottom: 5px;">Příjmení</label>
          <input type="text" id="lastName" name="lastName"
                 style="width: 100%; padding: 8px; border: 2px solid rgba(77,71,71,0.4); border-radius: 5px;"
                 required>
        </div>
        <div style="margin-bottom: 15px;">
          <label for="email" style="display: block; margin-bottom: 5px;">Email</label>
          <input type="email" id="email" name="email"
                 style="width: 100%; padding: 8px; border: 2px solid rgba(77,71,71,0.4); border-radius: 5px;"
                 required>
        </div>
        <div style="margin-bottom: 15px;">
          <label for="phone" style="display: block; margin-bottom: 5px;">Telefon</label>
          <input type="tel" id="phone" name="phone"
                 style="width: 100%; padding: 8px; border: 2px solid rgba(77,71,71,0.4); border-radius: 5px;"
                 required>
        </div>
      </fieldset>

      <fieldset style="border: 2px solid rgba(77,71,71,0.4); border-radius: 10px; padding: 20px; margin-bottom: 20px;">
        <legend style="color: rgb(5,19,19); font-weight: bold; padding: 0 10px;">Údaje o vozidle</legend>
        <div style="margin-bottom: 15px;">
          <label for="licensePlate" style="display: block; margin-bottom: 5px;">SPZ</label>
          <input type="text" id="licensePlate" name="licensePlate"
                 style="width: 100%; padding: 8px; border: 2px solid rgba(77,71,71,0.4); border-radius: 5px;"
                 required>
        </div>
      </fieldset>

      <fieldset style="border: 2px solid rgba(77,71,71,0.4); border-radius: 10px; padding: 20px; margin-bottom: 20px;">
        <legend style="color: rgb(5,19,19); font-weight: bold; padding: 0 10px;">Podmínky</legend>
        <div style="margin-bottom: 15px;">
          <input type="checkbox" id="termsConditions" name="termsConditions" required>
          <label for="termsConditions">
            Souhlasím se zpracováním osobních údajů a se Všeobecnými obchodními podmínkami (povinné)
          </label>
        </div>
        <div style="margin-bottom: 15px;">
          <input type="checkbox" id="marketingConsent" name="marketingConsent">
          <label for="marketingConsent">
            Souhlasím se zpracováním osobních údajů pro marketingové účely (nepovinné)
          </label>
        </div>
      </fieldset>

      <div style="text-align: end;">
        <button type="submit" style="background-color: #007BFF; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer;">
          Odeslat
        </button>
      </div>
    </form>
  </div>

  [#include "_common/footer.ftlh"]
</div>
<script crossorigin="anonymous"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
