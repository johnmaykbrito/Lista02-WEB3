/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "form")
public class MrBean {

    private static int type = -1;
    private static int input;
    private static int output;

    public int calcularTipo(ValueChangeEvent ev) {
        System.out.println("EVENT: " + ev.getNewValue());
        int tipo = (int) ev.getNewValue();
        type = tipo;
        return calcular(tipo, input);

    }

    public int calcularNum(ValueChangeEvent ev) {
        System.out.println("NUM: " + ev.getNewValue());
        int num = (int) ev.getNewValue();
        input = num;
        return calcular(type, num);
    }

    public int calcular(int tipo, int num) {
        if (tipo == 0) {
            output = fib(num);
        } else if (tipo == 1) {
            output = fat(num);
        }
        return output;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    public void validateNumber(FacesContext fc, UIComponent c, Object value) {
        Integer inteiro = (Integer) value;
        if (inteiro <= 0) {
            input = 0;
            throw new ValidatorException(new FacesMessage("Número inválido. Tem de ser um inteiro positivo."));
        }
    }

    private int fib(int num) {
        return (num < 2) ? num : fib(num - 1) + fib(num - 2);
    }

    private int fat(int num) {
        int i, fact = 1;
        for (i = 1; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }

}
