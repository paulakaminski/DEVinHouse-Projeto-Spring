package tech.devinhouse.pharmacymanagement.controller;

import org.springframework.web.bind.annotation.*;
import tech.devinhouse.pharmacymanagement.controller.dto.UsuarioRequest;
import tech.devinhouse.pharmacymanagement.controller.dto.UsuarioResponse;
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

    @GetMapping("/login")
    public UsuarioResponse loginUsuario (@RequestBody UsuarioRequest usuarioRequest) {
        UsuarioResponse usuarioResponse = usuarioService.encontrarUsuario(usuarioRequest);

        return usuarioResponse;
    }

    @PostMapping("/cadastro")
    public UsuarioResponse cadastrarNovoUsuario (@RequestBody UsuarioRequest usuarioRequest) {
        UsuarioResponse usuarioResponse = usuarioService.criarNovoUsuario(usuarioRequest);

        return usuarioResponse;
    }

}
