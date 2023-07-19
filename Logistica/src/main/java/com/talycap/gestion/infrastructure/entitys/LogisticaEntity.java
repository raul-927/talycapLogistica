package com.talycap.gestion.infrastructure.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.talycap.gestion.domain.models.TipoProducto;

public class LogisticaEntity implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int						 logisticaId;
	private TipoProductoEntity 		 tipoProducto;
	private BigDecimal				 precioEnvio;
	private int 					 cantidadProducto;
	private BigDecimal				subTotal;
	private Float					porcentajeDescuento;
	private BigDecimal				total;
	private LocalDateTime 			 fechaRegistro;
	private LocalDateTime 			 fechaEntrega;
	private ClienteEntity			 cliente;
	private LogisticaTerrestreEntity logisticaTerrestre;
	private LogisticaMaritimaEntity	 logisticaMaritima;
	
	public int getLogisticaId() {
		return logisticaId;
	}
	public void setLogisticaId(int logisticaId) {
		this.logisticaId = logisticaId;
	}
	public TipoProductoEntity getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProductoEntity tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(LocalDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public BigDecimal getPrecioEnvio() {
		return precioEnvio;
	}
	public void setPrecioEnvio(BigDecimal precioEnvio) {
		this.precioEnvio = precioEnvio;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	public LogisticaTerrestreEntity getLogisticaTerrestre() {
		return logisticaTerrestre;
	}
	public void setLogisticaTerrestre(LogisticaTerrestreEntity logisticaTerrestre) {
		this.logisticaTerrestre = logisticaTerrestre;
	}
	public LogisticaMaritimaEntity getLogisticaMaritima() {
		return logisticaMaritima;
	}
	public void setLogisticaMaritima(LogisticaMaritimaEntity logisticaMaritima) {
		this.logisticaMaritima = logisticaMaritima;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	public Float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	public void setPorcentajeDescuento(Float porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
}
