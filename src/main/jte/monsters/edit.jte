@import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO
@import com.github.fionasprinkles.monsteradoptioncenter.dto.UpdateMonsterDTO
@param Long id
@param UpdateMonsterDTO updateMonsterDTO

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit monster</title>
    <link rel="stylesheet" href="/style/style.css">
    <link rel="stylesheet" href="/style/new-style.css">
</head>
<body>
<h1>Update information about ${updateMonsterDTO.getName()}</h1>

<form action="/monsters/edit/${id}" method="post">
    <div>
        <label>Name:</label>
        <input type="text" name="name" value="${updateMonsterDTO.getName()}">
    </div>
    <div>
        <label>Species:</label>
        <input type="text" name="species" value="${updateMonsterDTO.getSpecies()}">
    </div>
    <div>
        <label>Description:</label>
        <textarea name="description">${updateMonsterDTO.getDescription()}</textarea>
    </div>
    <div>
        <label>Danger Level:</label>
        <input type="number" name="dangerLevel" value="${updateMonsterDTO.getDangerLevel()}">
    </div>
    <div>
        <label>Tamed Level</label>
        <input type="number" name="tamedLevel" value="${updateMonsterDTO.getTamedLevel()}">
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