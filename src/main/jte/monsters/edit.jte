@import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO
@import com.github.fionasprinkles.monsteradoptioncenter.dto.UpdateMonsterDTO
@import org.springframework.validation.BindingResult
@param BindingResult bindingResult
@param Long id
@param UpdateMonsterDTO updateMonsterDTO

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit monster</title>
    <link rel="stylesheet" href="/style/style.css">
    <link rel="stylesheet" href="/style/new-style.css">
    <link rel="stylesheet" href="/style/titles.css">
    <link rel="stylesheet" href="/input-error.css">

    <link href="https://fonts.googleapis.com/css2?family=Mystery+Quest&display=swap" rel="stylesheet">
</head>
<body>
<h1 class="page-title main-title">Update information about ${updateMonsterDTO.getName()}</h1>

<form action="/monsters/edit/${id}" method="post">
    <div>
        <label>Name:</label>
        <input type="text"
               name="name"
               value="${updateMonsterDTO.getName()}"
               class="${bindingResult != null && bindingResult.hasFieldErrors("name") ? "input-error" : ""}">
        @if(bindingResult != null && bindingResult.hasFieldErrors("name"))
            <div class="error-text">
                ${bindingResult.getFieldError("name").getDefaultMessage()}
            </div>
        @endif
    </div>
    <div>
        <label>Species:</label>
        <input type="text"
               name="species"
               value="${updateMonsterDTO.getSpecies()}"
               class="${bindingResult != null && bindingResult.hasFieldErrors("species") ? "input-error" : ""}">
        @if(bindingResult != null && bindingResult.hasFieldErrors("species"))
            <div class="error-text">
                ${bindingResult.getFieldError("species").getDefaultMessage()}
            </div>
        @endif
    </div>
    <div>
        <label>Description:</label>
        <textarea name="description"
                  class="${bindingResult != null && bindingResult.hasFieldErrors("description") ? "input-error" : ""}">
${updateMonsterDTO.getDescription()}
</textarea>
        @if(bindingResult != null && bindingResult.hasFieldErrors("description"))
            <div class="error-text">
                ${bindingResult.getFieldError("description").getDefaultMessage()}
            </div>
        @endif
    </div>
    <div>
        <label>Arrival Date:</label>
        <input type="date"
               name="arrivalDate"
               value="${updateMonsterDTO.getArrivalDate() != null ? updateMonsterDTO.getArrivalDate().toString() : ""}"
               class="${bindingResult != null && bindingResult.hasFieldErrors("arrivalDate") ? "input-error" : ""}">
        @if(bindingResult != null && bindingResult.hasFieldErrors("arrivalDate"))
            <div class="error-text">
                ${bindingResult.getFieldError("arrivalDate").getDefaultMessage()}
            </div>
        @endif
    </div>
    <div>
        <label>Danger Level</label>
        <input type="number"
               name="dangerLevel"
               min="0"
               max="10"
               value="${updateMonsterDTO.getDangerLevel()}"
               class="${bindingResult != null && bindingResult.hasFieldErrors("dangerLevel") ? "input-error" : ""}">
        @if(bindingResult != null && bindingResult.hasFieldErrors("dangerLevel"))
            <div class="error-text">
                ${bindingResult.getFieldError("dangerLevel").getDefaultMessage()}
            </div>
        @endif
    </div>
    <div>
        <label>Tamed Level</label>
        <input type="number"
               name="tamedLevel"
               min="0"
               max="10"
               value="${updateMonsterDTO.getTamedLevel()}"
               class="${bindingResult != null && bindingResult.hasFieldErrors("tamedLevel") ? "input-error" : ""}">
        @if(bindingResult != null && bindingResult.hasFieldErrors("tamedLevel"))
            <div class="error-text">
                ${bindingResult.getFieldError("tamedLevel").getDefaultMessage()}
            </div>
        @endif
    </div>
    <div>
        <label>Status:</label>
        <input type="checkbox"
               name="adopted"
               value="true"
               checked="${updateMonsterDTO.isAdopted()}">

    </div>

    <button type="submit">Update information</button>
</form>

<p><a href="/monsters">Go back</a></p>
</body>
</html>