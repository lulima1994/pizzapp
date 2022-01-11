package com.picolli.pepperone.controller;

import com.picolli.pepperone.domain.model.Usuario;
import com.picolli.pepperone.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @PostMapping("/usuario")
    public void salvar(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @GetMapping("/usuario/{id}")
    public Usuario buscarID(@PathVariable Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @GetMapping("/usuario")
    public Page<Usuario> buscarPage(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @DeleteMapping("/usuario/{id}")
    public void deletarID(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
    }
}
