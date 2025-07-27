[#ftl]
<!DOCTYPE html>
<html lang="cs">
<head>
    [#include "_common/head.ftlh"]
</head>
<body  style="background-image: url('/img/parking.jpg'); background-position: center; background-repeat: no-repeat">
<div class="container p-0" style="background-color: white">
    [#include "_common/header.ftlh"]

    <div class="px-4 py-5 my-5 text-center" style="margin-bottom: 20px">

        <h3 style="margin-bottom: 40px">Vyberte datum a rezervujte si své místo</h3>

        <div class="row mb-5 justify-content-center align-items-center">
            <div class="col-md-6 rounded p-6" style="max-width: 50%; border: 2px solid rgba(47,170,211,0.4); border-radius: 10px; padding: 20px;">
                <form action="/" method="get" id="filterForm" class="d-flex justify-content-between align-items-end">
                    <div class="mb-1">
                        <label for="arrival-date" class="form-label fw-bold">Vyberte datum příjezdu</label>
                        <input id="arrival-date" name="dateOfArrival" class="form-control" type="date" value="${dateOfArrival}"/>
                    </div>
                    <div class="mb-1">
                        <label for="departure-date" class="form-label fw-bold">Vyberte datum odjezdu</label>
                        <input id="departure-date" name="dateOfDeparture" class="form-control" type="date" value="${dateOfDeparture}"/>
                    </div>

                    <div class="mb-1 d-flex justify-content-center align-items-center">
                        <button type="submit" class="btn btn-primary">Hledej</button>
                    </div>
                </form>

                <div class="row mt-3">
                    <div class="col-md-12 d-flex justify-content-center align-items-center">
                        <div class="fw-bold">Vybraný počet dní: ${parkingDate} </p></div>
                    </div>
                </div>
            </div>

        </div>


        <h3 style="margin-bottom: 40px">Vyberte si parkovací místo</h3>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Status</th>
                <th scope="col">Parkovací místo</th>
                <th scope="col">Patro</th>
                <th scope="col">Cena</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody id="parkingTableBody">
        <!-- Načtení dat z parking tabulky -->
            </tbody>
        </table>
    </div>

    [#noparse]
    <script>
        const dateOfArrival = "${dateOfArrival}";
        const dateOfDeparture = "${dateOfDeparture}";
        const parkingDate = "${parkingDate}";

        document.getElementById('filterForm').addEventListener('submit', function(e) {
            e.preventDefault();

            fetch('http://localhost:8080/api/parking-places')
                .then(response => response.json())
                .then(data => {
                    console.log("Received data:", data);
                    const tbody = document.getElementById('parkingTableBody');
                    tbody.innerHTML = '';

                    data.forEach(place => {

                        const statusText = place.status
                            ? '<span class="text-success fw-bold">VOLNO</span>'
                            : '<span class="text-danger fw-bold">OBSAZENO</span>';

                        const action = place.status
                            ? `<a  href="/\${place.index}?dateOfArrival=${dateOfArrival}&dateOfDeparture=${dateOfDeparture}&days=${parkingDate}" class="btn btn-primary btn-sm">Vybrat</a>`
                            : '<span class="text-muted"></span>';

                        const row = document.createElement('tr');

                        row.innerHTML = `
                           <td>${statusText}</td>
                           <td>${place.parkingNumber}</td>
                           <td>${place.numberOfFlour} </td>
                           <td>${place.newPrice} Kč</td>
                           <td>${action}</td>
                        `;
                        tbody.appendChild(row);
                    });
                })
                .catch(error => {
                    console.error('Chyba při načítání:', error);
                });
        });
    </script>
    [/#noparse]


    [#include "_common/footer.ftlh"]
</div>
<script crossorigin="anonymous"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>