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
public class PortaAvioes extends Navio {
	public PortaAvioes(){
		super("Porta Aviões", 5, " p ");
	}

    public PortaAvioes(String tipoNavio, int numeroBlocosOcupados, String representacao) {
        super(tipoNavio, numeroBlocosOcupados, representacao);
    }
}
