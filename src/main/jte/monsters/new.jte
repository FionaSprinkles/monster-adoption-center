@import com.github.fionasprinkles.monsteradoptioncenter.dto.CreateMonsterDTO
@import org.springframework.validation.BindingResult
@param CreateMonsterDTO createMonsterDTO
@param BindingResult bindingResult

<!DOCTYPE html>
<html lang="sv">
<head>
    <title>Registrera nytt monster</title>
    <link rel="stylesheet" href="/style/style.css">
    <link rel="stylesheet" href="/style/new-style.css">
    <link rel="stylesheet" href="/input-error.css">
</head>
<body>
<div class="container">
<h1>Lägg till ett nytt monster i centret</h1>

    <form class="monster-form" action="/monsters" method="post" enctype="multipart/form-data">
    <div>
        <div class="form-group">
            <label for="name">Namn</label>


            <input type="text"
                   id="name"
                   name="name"
                   value="${createMonsterDTO.getName()}"
                   class="${bindingResult != null && bindingResult.hasFieldErrors("name") ? "input-error" : ""}">


            @if(bindingResult != null && bindingResult.hasFieldErrors("name"))
                <div class="error-text">
                    <span class="error-icon">!</span>
                    ${bindingResult.getFieldError("name").getDefaultMessage()}
                </div>
            @endif
        </div>
    </div>
        <div class="form-group">
            <label>Välj bild:</label>
            <input type="file" name="image" accept="image/png, image/jpeg">
        </div>
    <div>
        <label>Art:</label>
        <input type="text" name="species" value="${createMonsterDTO.getSpecies()}">
    </div>
    <div>
        <label>Beskrivning:</label>
        <textarea name="description">${createMonsterDTO.getDescription()}</textarea>
    </div>
    <div>
        <label>Ankomstdatum:</label>
        <input type="date" name="arrivalDate" value="${createMonsterDTO.getArrivalDate() != null ? createMonsterDTO.getArrivalDate().toString() : ""}">
    </div>
    <div>
        <label>Farlighetsgrad (0-10):</label>
        <input type="number" name="dangerLevel" min="0" max="10" value="${createMonsterDTO.getDangerLevel()}">
    </div>
    <div>
        <label>Tämjningsgrad (0-10):</label>
        <input type="number" name="tamedLevel" min="0" max="10" value="${createMonsterDTO.getTamedLevel()}">
    </div>

    <button type="submit">Spara monster</button>
</form>

<p><a href="/monsters">Tillbaka till listan</a></p>
</div>
</body>
</html>