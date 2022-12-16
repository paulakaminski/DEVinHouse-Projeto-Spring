package tech.devinhouse.pharmacymanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.pharmacymanagement.dataprovider.entity.UsuarioEntity;
import tech.devinhouse.pharmacymanagement.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioEntity> teste() {
        return usuarioService.encontrarUsuarios();
    }

}
