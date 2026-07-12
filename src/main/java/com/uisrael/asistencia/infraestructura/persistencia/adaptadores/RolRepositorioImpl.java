package com.uisrael.asistencia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.asistencia.dominio.entidades.Rol;
import com.uisrael.asistencia.dominio.repositorio.IRolRepositorio;
import com.uisrael.asistencia.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.uisrael.asistencia.infraestructura.repositorios.IRolJpaRepositorio;

public class RolRepositorioImpl implements IRolRepositorio {

    private final IRolJpaRepositorio jpaRepositorio;
    private final IRolJpaMapper entityMapper;

    public RolRepositorioImpl(IRolJpaRepositorio jpaRepositorio, IRolJpaMapper entityMapper) {
        this.jpaRepositorio = jpaRepositorio;
        this.entityMapper = entityMapper;
    }

    @Override
    public Rol guardar(Rol nuevoRol) {
        return entityMapper.toDomain(jpaRepositorio.save(entityMapper.toEntity(nuevoRol)));
    }

    @Override
    public Optional<Rol> buscarPorId(int idRol) {
        return jpaRepositorio.findById(idRol).map(entityMapper::toDomain);
    }

    @Override
    public List<Rol> listarTodos() {
        return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
    }

    @Override
    public void eliminar(int idRol) {
        jpaRepositorio.deleteById(idRol);
    }

    @Override
    public List<Rol> findByNombre(String nombre) {
        return jpaRepositorio.findByNombre(nombre).stream().map(entityMapper::toDomain).toList();
    }
}