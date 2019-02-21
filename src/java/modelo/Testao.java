/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 171095
 */
public class Testao {
    private ArrayList<String> listona = new ArrayList();
    private int atributosodezoas;
    
    public ArrayList<String> getListona() {
        return listona;
    }

    public void setListona(String nome) {
        listona.add(nome);
    }
}
