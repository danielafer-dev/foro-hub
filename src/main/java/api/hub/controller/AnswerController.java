package api.hub.controller;

import api.hub.domain.answer.AnswerRequestDTO;
import api.hub.domain.answer.AnswerService;
import api.hub.domain.answer.AnswerSummaryDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid AnswerRequestDTO data) {
        // Ejecuta la lógica a través del servicio para limpiar los warnings
        var response = answerService.create(data);

        // Retorna la respuesta exitosa
        return ResponseEntity.ok(response);
    }
}