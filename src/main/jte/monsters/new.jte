@import com.github.fionasprinkles.monsteradoptioncenter.dto.CreateMonsterDTO
@import org.springframework.validation.BindingResult
@param CreateMonsterDTO createMonsterDTO
@param BindingResult bindingResult
@param String error

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Register new</title>
    <link rel="stylesheet" href="/style/style.css">
    <link rel="stylesheet" href="/style/new-style.css">
    <link rel="stylesheet" href="/input-error.css">
</head>
<body>
<div class="container">
<h1>Add new monster to the center</h1>

    <form class="monster-form" action="/monsters" method="post" enctype="multipart/form-data">
    <div>
        <div class="form-group">
            <label for="name">Name</label>


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
            <label>Add a picture:</label>
            <input type="file" name="image" accept="image/png, image/jpeg">
            @if(error != null)
                <div class="error-text">
                ${error}
                </div>
            @endif
        </div>
    <div>
        <label>Species:</label>
        <input type="text" name="species" value="${createMonsterDTO.getSpecies()}">
    </div>
    <div>
        <label>Description:</label>
        <textarea name="description">${createMonsterDTO.getDescription()}</textarea>
    </div>
    <div>
        <label>Arrival Date:</label>
        <input type="date" name="arrivalDate" value="${createMonsterDTO.getArrivalDate() != null ? createMonsterDTO.getArrivalDate().toString() : ""}">
    </div>
        <div>
            <label>Danger Level</label>
            <input type="number"
                   name="dangerLevel"
                   min="0"
                   max="10"
                   value="${createMonsterDTO.getDangerLevel()}">
        </div>
        <div>
            <label>Tamed Level</label>
            <input type="number"
                   name="tamedLevel"
                   min="0"
                   max="10"
                   value="${createMonsterDTO.getTamedLevel()}">
        </div>

    <button type="submit">Save monster</button>
</form>

<p><a href="/monsters">Go back</a></p>
</div>
</body>
</html>