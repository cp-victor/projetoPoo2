/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import modelo.Categoria;
import modelo.Cliente;
import modelo.ItemPedido;
import modelo.Produto;

/**
 *
 * @author victo
 */
public class Dados {
    private static ArrayList<Cliente> LISTA_CLIENTES;
    private static ArrayList<Produto> LISTA_PRODUTOS;
    private static ArrayList<Categoria> LISTA_CATEGORIAS;
    private static ArrayList<ItemPedido> LISTA_ITEMPEDIDOS;
    private static int auxC;
    private static int contPed=0;
    private static int contCli=0;
    private static int cliFinal;
    private static int pedidoVer=0;
    
    
    private static void init(){
        LISTA_CLIENTES = new ArrayList();
    }
    
    private static void init2(){
        LISTA_PRODUTOS = new ArrayList();
    }
    
    private static void init3(){
        LISTA_CATEGORIAS = new ArrayList();
    }
    
    private static void init4(){
        LISTA_ITEMPEDIDOS = new ArrayList();
    }
    
    public static ArrayList<Cliente> getLISTA_CLIENTES() {
        if(LISTA_CLIENTES == null)
            init();
        return LISTA_CLIENTES;
    }
        
    public static ArrayList<Produto> getLISTA_PRODUTOS() {
        if(LISTA_PRODUTOS == null)
            init2();
        return LISTA_PRODUTOS;
    }
    
    public static ArrayList<Categoria> getLISTA_CATEGORIAS() {
        if(LISTA_CATEGORIAS == null)
            init3();
        return LISTA_CATEGORIAS;
    }
    
    public static ArrayList<ItemPedido> getLISTA_ITEMPEDIDOS() {
        if(LISTA_ITEMPEDIDOS == null)
            init4();
        return LISTA_ITEMPEDIDOS;
    }
    
    public static int getAuxC(){
        return auxC;
    }
    
    public static void setAuxC(int aux){
        auxC = aux;
    }

    public static int getContPed(int x){
        if(x == 1)
            setContPed();
        return contPed;
    }

    public static void setContPed(){
        Dados.contPed++;
    }

    public static int getContPed() {
        return contPed;
    }

    public static void setContPed(int contPed) {
        Dados.contPed = contPed;
    }

    
//    public static int getContCli() {
//        return contCli;
//    }
//
//    public static void setContCli(int contCli) {
//        Dados.contCli = contCli;
//    }
//    

    public static int getCliFinal() {
        return cliFinal;
    }

    public static void setCliFinal(int cliFinal) {
        Dados.cliFinal = cliFinal;
    }
    
    public static void limpaLista(){
        LISTA_ITEMPEDIDOS = new ArrayList<>();
    }

    public static int getPedidoVer() {
        return pedidoVer;
    }

    public static void setPedidoVer(int pedidoVer) {
        Dados.pedidoVer = pedidoVer;
    }
}
