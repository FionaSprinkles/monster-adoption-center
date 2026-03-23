@import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO
@import java.util.List

@param List<MonsterDTO> monsters

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Monster Adoption Center</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body>
<div class="container">
<h1>Available monsters for adoption</h1>
    <div class="top-bar">
        <a class="button" href="/monsters/new">Register new</a>
    </div>

<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Image</th>
        <th>Species</th>
        <th>Danger Level</th>
        <th>Tamed Level</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    @for(var monster : monsters)
        <tr>
            <td>${monster.getName()}</td>

            <td>
                @if(monster.getImageUrl() != null)
                    <img src="${monster.getImageUrl()}"
                         alt="${monster.getName()}"
                         style="width: 50px; height: 50px; border-radius: 50%;">
                @endif
            </td>
            <td>${monster.getSpecies()}</td>
            <td>${monster.getDangerLevel()}</td>
            <td>${monster.getTamedLevel()}</td>
            <td>${monster.isAdopted() ? "Adopted" : "Available"}</td>
            <td>
                <a href="/monsters/edit/${monster.getId()}">Edit</a>
                <form action="/monsters/delete/${monster.getId()}" method="post" style="display:inline;">
                    <button type="submit" onclick="return confirm('Are you sure?')">Delete</button>
                </form>
            </td>
        </tr>
    @endfor
    </tbody>
</table>
</div>
</body>
</html>