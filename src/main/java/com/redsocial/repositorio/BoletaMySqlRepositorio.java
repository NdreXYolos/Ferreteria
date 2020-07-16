package com.redsocial.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.redsocial.entidad.Boleta;
import com.redsocial.entidad.Cliente;
import com.redsocial.entidad.DetalleBoleta;
import com.redsocial.entidad.Producto;

@Repository
public class BoletaMySqlRepositorio implements BoletaRepositorio {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	RowMapper<Cliente> mapperCliente = new RowMapper<Cliente>() {
		@Override
		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cliente obj = new Cliente();
			obj.setIdCliente(rs.getString(1));
			obj.setNombre(rs.getString(2));
			obj.setApellido(rs.getString(3));
			obj.setFechaNacimiento(rs.getDate(4));
			return obj;
		}
	};

	RowMapper<Producto> mapperProducto = new RowMapper<Producto>() {
		@Override
		public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
			Producto obj = new Producto();
			obj.setIdProducto(rs.getString(1));
			obj.setNombre(rs.getString(2));
			obj.setMarca(rs.getString(3));
			obj.setPrecio(rs.getDouble(4));
			obj.setStock(rs.getInt(5));
			return obj;

		}
	};

	@Override
	public List<Cliente> traeClientePorNombre(String filtro) {
		List<Cliente> lista = jdbcTemplate.query("select * from cliente where nombre like ? or apellido like ?",new Object[] { filtro + "%", filtro + "%" }, mapperCliente);
		return lista;
	}

	@Override
	public List<Producto> traeProductoPorNombre(String filtro) {
		List<Producto> lista = jdbcTemplate.query("select * from producto where nombre like ? ",new Object[] { filtro + "%" }, mapperProducto);
		return lista;
	}

	@Override
	public int insertaBoleta(Boleta bean) {
		int idBoleta = -1;

		// Para insertar la cabecera
		jdbcTemplate.update("insert into boleta values(null,curdate(),?,?)", new Object[] { bean.getCliente().getIdCliente(), bean.getIdUsuario() });

		// regresa el id generado
		idBoleta = jdbcTemplate.queryForObject("select max(idBoleta) from boleta", new Object[] {}, Integer.class);

		// Se insertar los detalles
		List<DetalleBoleta> detalles = bean.getDetalles();
		for (DetalleBoleta x : detalles) {
			x.setIdBoleta(String.valueOf(idBoleta));
			jdbcTemplate.update("insert into producto_has_boleta values(?,?,?,?)",	new Object[] { x.getIdProducto(), x.getIdBoleta(), x.getPrecio(), x.getCantidad() });
			jdbcTemplate.update("update producto set stock = stock - ? where idproducto = ?", new Object[] { x.getCantidad(), x.getIdProducto() });
		}
		return idBoleta;
	}

}
