package com.redsocial.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.redsocial.entidad.Usuario;

@Repository
public class UsuarioMySqlRepositorio implements UsuarioRepositorio {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int elimina(int idUsuario) {
		
		return jdbcTemplate.update("delete from usuario where idUsuario=?", new Object[] { idUsuario});
	}

	@Override
	public int inserta(Usuario obj) {
		
		return jdbcTemplate.update("insert into usuario values(null,?,?,?,?,?)", new Object[] { obj.getNombre(), obj.getApellido(), obj.getUsuario(), obj.getContraseña(), obj.getEmail()});
	}

	@Override
	public int actualiza(Usuario obj) {
		
		return jdbcTemplate.update("update usuario set nombre =?, apellido =?, usuario =?, contraseña =?, email =? where idusuario =? ", new Object[] { obj.getNombre(), obj.getApellido(), obj.getUsuario(), obj.getContraseña(), obj.getEmail(),obj.getIdUsuario()});
	}

	@Override
	public List<Usuario> lista(String filtro) {
		
		List<Usuario> lista = jdbcTemplate.query("select * from usuario where nombre like ? ",new Object[] { filtro+"%" }, new RowMapper<Usuario>() {
            @Override
            public Usuario mapRow(ResultSet rs, int arg1) throws SQLException {
            	Usuario obj = new Usuario();
            	obj.setIdUsuario(rs.getInt("idUsuario"));
            	obj.setNombre(rs.getString("Nombre"));
            	obj.setApellido(rs.getString("Apellido"));
            	obj.setUsuario(rs.getString("Usuario"));
            	obj.setContraseña(rs.getString("Contraseña"));
            	obj.setEmail(rs.getString("Email"));
                return obj;
            }
        });
        return lista;
	}

	
	
	
}
