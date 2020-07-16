package com.redsocial.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.redsocial.entidad.Cliente;

@Repository
public class ClienteMySqlRepositorio implements ClienteRepositorio{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int elimina(int idCliente) {
		return jdbcTemplate.update("delete from cliente where idcliente=?", new Object[] { idCliente});
	}

	@Override
	public int inserta(Cliente obj) {
		 return jdbcTemplate.update("insert into cliente values(null,?,?,?)", new Object[] { obj.getNombre(), obj.getApellido(), obj.getFechaNacimiento()});
			
	}

	@Override
	public int actualiza(Cliente obj) {
		return jdbcTemplate.update("update cliente set nombre =?, apellido =?, fechaNacimiento=?  where idcliente =? ", new Object[] { obj.getNombre(), obj.getApellido(), obj.getFechaNacimiento(),obj.getIdCliente()});

	}

	@Override
	public List<Cliente> lista(String filtro) {
		List<Cliente> lista = jdbcTemplate.query("select * from cliente where nombre like ? ",new Object[] { filtro+"%" }, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int arg1) throws SQLException {
            	Cliente obj = new Cliente();
            	obj.setIdCliente(rs.getString("idcliente"));
            	obj.setNombre(rs.getString("nombre"));
            	obj.setApellido(rs.getString("apellido"));
            	obj.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            	
                return obj;
            }
        });
        return lista;
	}
	
	

}
