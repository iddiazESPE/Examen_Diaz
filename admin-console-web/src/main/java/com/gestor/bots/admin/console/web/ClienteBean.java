/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.web;

import com.gestor.bots.admin.console.model.Cliente;
import com.gestor.bots.admin.console.servicio.ClienteService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author toshiba
 */
@Named
@ViewScoped
public class ClienteBean extends BaseBean implements Serializable{
    
    private List<Cliente> clientes;
    
    private Cliente cliente;
    
    private Cliente clienteSel;
    
    @Inject
    private ClienteService clienteService;
    
     @PostConstruct
    public void init() {
        this.clientes = this.clienteService.obtenerTodos();
        this.cliente = new Cliente();
    }
    
    public List<Cliente> getCruceros() {
        return clientes;
    }
    
    public void agregar() {
        this.cliente = new Cliente();
        super.agregar();
    }
    
    public void modificar() {
        super.modificar();
        this.cliente = new Cliente();
        this.cliente.setRuc(this.clienteSel.getRuc());
        this.cliente.setRazonSocial(this.clienteSel.getRazonSocial());
        this.cliente.setDireccion(this.clienteSel.getDireccion());
        this.cliente.setFechaRegistro(this.clienteSel.getFechaRegistro());
        this.cliente.setMailContacto(this.clienteSel.getMailContacto());
        this.cliente.setNombreComercial(this.clienteSel.getNombreComercial());
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCruceroSel() {
        return clienteSel;
    }

    public void setClienteSel(Cliente clienteSel) {
        this.clienteSel = clienteSel;
    }
}
