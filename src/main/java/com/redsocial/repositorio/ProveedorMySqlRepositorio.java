package com.redsocial.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.redsocial.entidad.Proveedor;
import com.redsocial.repositorio.ProveedorRepositorio;

@Repository
public class ProveedorMySqlRepositorio implements  ProveedorRepositorio{

	@Autowired
    private JdbcTemplate jdbcTemplate ;
	
	
	@Override
	public int inserta(Proveedor obj) {
		String sql = "insert into proveedor values(null,?,?,?,?,?,?)";
		Object[] val = { obj.getNombre_proveedor(), obj.getRuc(), obj.getDireccion(), 
				 obj.getTelefono(),obj.getNombre_contacto(),obj.getEmail_proveedor()};
		return jdbcTemplate.update(sql, val);
	}

	@Override
	public int actualiza(Proveedor obj) {
		 return jdbcTemplate.update("update proveedor set nombre_proveedor =?, ruc =?, direccion =?, telefono =?,nombre_contacto =?,email_proveedor =? where idproveedor =? ",
				 new Object[] { obj.getNombre_proveedor(), obj.getRuc(), obj.getDireccion(), 
				 obj.getTelefono(),obj.getNombre_contacto(),obj.getEmail_proveedor() ,obj.getIdProveedor()});
	}
	@Override
	public int elimina(int idProveedor) {
		String sql = "delete from proveedor where idproveedor=?";
		Object[] val = {idProveedor};
		return jdbcTemplate.update(sql, val);
	}
	
	@Override
	public List<Proveedor> lista(String filtro) {
		String sql = "select * from proveedor where nombre_proveedor like ?";
		Object[] val = {filtro+"%"};
		
		RowMapper<Proveedor> rowMapper = new RowMapper<Proveedor>() {
			@Override
			public Proveedor mapRow(ResultSet rs, int rowNum) throws SQLException {
				Proveedor obj = new Proveedor();
				obj.setIdProveedor(rs.getInt(1));
				obj.setNombre_proveedor(rs.getString(2));
				obj.setRuc(rs.getString(3));
				obj.setDireccion(rs.getString(4));
				obj.setTelefono(rs.getString(5));
				obj.setNombre_contacto(rs.getString(6));
				obj.setEmail_proveedor(rs.getString(7));
				return obj;
			}
		};
		
		List<Proveedor> lista = jdbcTemplate.query(sql, val, rowMapper);
		return lista;
	}
	
}
