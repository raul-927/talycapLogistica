package com.talycap.gestion.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.talycap.gestion.domain.enumerador.TipoLogisticaEnum;

public class Logistica {
	private int						logisticaId;
	private TipoProducto 			tipoProducto;
	private BigDecimal				precioEnvio;
	private int 					cantidadProducto;
	private BigDecimal				subTotal;
	private Float					porcentajeDescuento;
	private BigDecimal				total;
	private LocalDateTime 			fechaRegistro;
	private LocalDateTime 			fechaEntrega;
	private Cliente					cliente;
	private LogisticaTerrestre		logisticaTerrestre;
	private LogisticaMaritima		logisticaMaritima;
	
	private TipoLogisticaEnum		tipoLogistica;
	
	
	public int getLogisticaId() {
		return logisticaId;
	}
	public void setLogisticaId(int logisticaId) {
		this.logisticaId = logisticaId;
	}
	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProducto tipoProducto) {
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LogisticaTerrestre getLogisticaTerrestre() {
		return logisticaTerrestre;
	}
	public void setLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre) {
		this.logisticaTerrestre = logisticaTerrestre;
	}
	public LogisticaMaritima getLogisticaMaritima() {
		return logisticaMaritima;
	}
	public void setLogisticaMaritima(LogisticaMaritima logisticaMaritima) {
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
	public TipoLogisticaEnum getTipoLogistica() {
		return tipoLogistica;
	}
	public void setTipoLogistica(TipoLogisticaEnum tipoLogistica) {
		this.tipoLogistica = tipoLogistica;
	}
}
