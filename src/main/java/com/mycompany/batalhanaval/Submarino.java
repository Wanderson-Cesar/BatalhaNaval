/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.batalhanaval;

/**
 *
 * @author Marcus
 */
public class Submarino extends Navio {
	public Submarino(){
		super("Submarino", 1, " s ");
	}

    public Submarino(String tipoNavio, int numeroBlocosOcupados, String representacao) {
        super(tipoNavio, numeroBlocosOcupados, representacao);
    }
}
