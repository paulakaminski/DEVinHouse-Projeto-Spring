package tech.devinhouse.pharmacymanagement.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.devinhouse.pharmacymanagement.controller.dto.UsuarioRequest;
import tech.devinhouse.pharmacymanagement.controller.dto.UsuarioResponse;
import tech.devinhouse.pharmacymanagement.dataprovider.entity.UsuarioEntity;
import tech.devinhouse.pharmacymanagement.dataprovider.repository.UsuarioRepository;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponse encontrarUsuario(UsuarioRequest usuarioRequest) {
        List<UsuarioEntity> usuarioEntities = usuarioRepository.findAll();

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        for (UsuarioEntity usuarioEntity : usuarioEntities) {
            if(Objects.equals(usuarioRequest.getEmail(), usuarioEntity.getEmail())
                    && Objects.equals(usuarioRequest.getSenha(), usuarioEntity.getSenha())
            ) {
                usuarioResponse.setId(usuarioEntity.getId());
            }
        }

        if(usuarioResponse.getId() == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return usuarioResponse;

    }

    public UsuarioResponse criarNovoUsuario(UsuarioRequest usuarioRequest) {
        UsuarioEntity usuarioEntity = usuarioRepository.save(new UsuarioEntity(usuarioRequest.getEmail()
                , usuarioRequest.getSenha()
        ));

        return new UsuarioResponse(
                usuarioEntity.getId()
        );
    }

}
