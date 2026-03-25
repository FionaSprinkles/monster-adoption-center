@import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO
@import java.util.List

@import org.springframework.data.domain.Page
@param Page<MonsterDTO> monsters
@param int currentPage
@param int totalPages

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Monster Adoption Center</title>
    <link rel="stylesheet" href="/style/style.css">
    <link rel="stylesheet" href="/style/titles.css">
    <link rel="stylesheet" href="/style/monster-card.css">
    <link href="https://fonts.googleapis.com/css2?family=Mystery+Quest&display=swap" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="title-frame">
        <h1 class="page-title">Welcome to the</h1>

        <h1 class="page-title main-title">
            Monster Adoption Center
        </h1>

    </div>

    <h2 class="page-title page-subtitle">
        Available monsters for adoption
    </h2>
    <div class="top-bar">
        <a class="button" href="/monsters/new">Register new</a>
    </div>

    <div class="monster-grid">

        @for(var monster : monsters.getContent())
            <div class="monster-card">

                <div class="monster-image-wrapper">
                    @if(monster.getImageUrl() != null)
                        <img class="monster-img"
                             src="${monster.getImageUrl()}"
                             alt="${monster.getName()}">
                    @else
                        <div class="monster-img placeholder">
                            No image
                        </div>
                    @endif

                    <div class="status-badge ${monster.isAdopted() ? "adopted" : "available"}">
                        ${monster.isAdopted() ? "Adopted" : "Available"}
                    </div>
                </div>

                <div class="monster-content">
                    <h3>${monster.getName()}</h3>

                    <p class="monster-species">
                        ${monster.getSpecies()}
                    </p>

                    <div class="monster-levels">
                        <span>Danger: ${monster.getDangerLevel()}</span>
                        <span>Tamed: ${monster.getTamedLevel()}</span>
                    </div>

                    <div class="monster-actions">
                        <a class="edit-btn"
                           href="/monsters/edit/${monster.getId()}">
                            Edit
                        </a>

                        <form action="/monsters/delete/${monster.getId()}"
                              method="post">
                            <button type="submit"
                                    onclick="return confirm('Delete ${monster.getName()}?')">
                                Delete
                            </button>
                        </form>
                    </div>
                </div>

            </div>
        @endfor

    </div>


</div>
<div class="pagination">
    @if(currentPage < totalPages - 1)
        <a href="/monsters?page=${currentPage + 1}">
            Next →
        </a>
    @endif
</div>

</body>
</html>