[#ftl]
<!DOCTYPE html>
<html lang="cs">
<head>
    [#include "_common/head.ftlh"]
</head>
<body class="d-flex flex-column vh-100" style="background-image: url('/img/parking.jpg'); background-position: center; background-repeat: no-repeat">
<!-- Třída „container“ je z Bootstrapu a zařídí, že stránka se na šířku nebude zvětšovat donekonečna -->
<div class="container d-flex flex-column flex-grow-1 justify-content-between bg-white p-0" style="background-color: white">
    [#include "_common/header.ftlh"]
    <!-- Třídy Bootstrapu, zajistí centrování textu. -->
    <div class="px-3 py-3 my-4 text-center justify-content-center d-flex flex-wrap">
        <form class="px-4 py-3 mx-auto">
            <div class="mb-3">
                <label for="exampleDropdownFormEmail1" class="form-label">Emailová adresa</label>
                <input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com">
            </div>
            <div class="mb-3">
                <label for="exampleDropdownFormPassword1" class="form-label">Heslo</label>
                <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password">
            </div>
            <div class="mb-3">
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="dropdownCheck">
                    <label class="form-check-label" for="dropdownCheck">
                        Zapamatuj si mě
                    </label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Přihlásit</button>
        </form>
        <div class="dropdown-divider"></div>
        <a class="dropdown-item" href="#">Ještě nemáš účet? Založit</a>
        <a class="dropdown-item" href="#">Zapomněl jsi heslo?</a>
    </div>
    [#include "_common/footer.ftlh"]
</div>
<script crossorigin="anonymous"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>