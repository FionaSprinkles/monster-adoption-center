package com.github.fionasprinkles.monsteradoptioncenter.controller;

import com.github.fionasprinkles.monsteradoptioncenter.MonsterMapper;
import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.service.MonsterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static java.time.LocalTime.now;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(MonsterController.class)
class MonsterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MonsterService monsterService;

    @MockitoBean
    private MonsterMapper monsterMapper;


    @DisplayName("Should return monster list page")
@Test
void listMonsters() throws Exception {

        Page<MonsterDTO> page = new PageImpl<>(List.of(new MonsterDTO()));

        when(monsterService.findPaginated(any(), any())).thenReturn(page);

    mockMvc.perform(get("/monsters"))
            .andExpect(status().isOk())
            .andExpect(view().name("monsters/list"))
            .andExpect(model().attributeExists("monsters"));
}

    @DisplayName("Should show create monster page")
    @Test
    void showCreateForm() throws Exception {

        mockMvc.perform(get("/monsters/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("monsters/new"));
    }

    @DisplayName("Should create monster and redirect")
    @Test
    void createMonster() throws Exception {

        MockMultipartFile image =
                new MockMultipartFile(
                        "image",
                        "test.jpg",
                        "image/jpeg",
                        "fake-image".getBytes()
                );

        mockMvc.perform(multipart("/monsters")
                        .param("name", "Fluffy")
                        .file(image)
                        .param("species", "Dragon")
                        .param("description", "Cute")
                        .param("arrivalDate", "2026-01-01")
                        .param("dangerLevel", "3")
                        .param("tamedLevel", "8"))
                .andExpect(status().is3xxRedirection());

        verify(monsterService).createMonster(
                any(),
                any()
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("invalidMonsterData")
    @DisplayName("Should not create monster when validation fails")
    void createMonsterValidationError(
            String name,
            String species,
            String description,
            String arrivalDate,
            String dangerLevel,
            String tamedLevel
    ) throws Exception {

        MockMultipartFile image =
                new MockMultipartFile(
                        "image",
                        "test.jpg",
                        "image/jpeg",
                        "fake".getBytes()
                );

        mockMvc.perform(multipart("/monsters")
                        .file(image)
                        .param("name", name)
                        .param("species", species)
                        .param("description", description)
                        .param("arrivalDate", arrivalDate)
                        .param("dangerLevel", dangerLevel)
                        .param("tamedLevel", tamedLevel))
                .andExpect(status().isOk())
                .andExpect(view().name("monsters/new"));

        verify(monsterService, never())
                .createMonster(any(), any());
    }
    private static Stream<Arguments> invalidMonsterData() {
        return Stream.of(

                Arguments.of(
                        Named.of("Empty name", ""),
                        "Dragon",
                        "Cute",
                        LocalDate.now().toString(),
                        "3",
                        "8"
                ),

                Arguments.of(
                        Named.of("Future date", "Fluffy"),
                        "Dragon",
                        "Cute",
                        LocalDate.now().plusDays(1).toString(),
                        "3",
                        "8"
                ),

                Arguments.of(
                        Named.of("Danger to high", "Fluffy"),
                        "Dragon",
                        "Cute",
                        LocalDate.now().toString(),
                        "11",
                        "8"
                ),

                Arguments.of(
                        Named.of("Tamed to high", "Fluffy"),
                        "Dragon",
                        "Cute",
                        LocalDate.now().toString(),
                        "3",
                        "11"
                ),

                Arguments.of(
                        Named.of("Null date", "Fluffy"),
                        "Dragon",
                        "Cute",
                        "",
                        "3",
                        "8"
                )
        );
    }

    @DisplayName("Should show edit page")
    @Test
    void showEditForm() throws Exception {

        when(monsterService.findById(1L)).thenReturn(new MonsterDTO());

        mockMvc.perform(get("/monsters/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("monsters/edit"));
    }

    @DisplayName("Should delete monster and redirect")
    @Test
    void deleteMonster() throws Exception {

        mockMvc.perform(post("/monsters/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/monsters"));

        verify(monsterService).deleteMonster(1L);
    }

}
