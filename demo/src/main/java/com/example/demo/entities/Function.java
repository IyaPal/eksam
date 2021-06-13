package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Function {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int c1, c2, c3, c4, c5;

    public Function() {
    }

    public Function(int c1, int c2, int c3, int c4, int c5) {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getC2() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    public int getC3() {
        return c3;
    }

    public void setC3(int c3) {
        this.c3 = c3;
    }

    public int getC4() {
        return c4;
    }

    public void setC4(int c4) {
        this.c4 = c4;
    }

    public int getC5() {
        return c5;
    }

    public void setC5(int c5) {
        this.c5 = c5;
    }

    @Override
    public String toString() {
        String s = "";
        ArrayList<String> polynoms = new ArrayList<>();
        if (c1 != 0) polynoms.add(c1 + "x^2");
        if (c2 != 0) polynoms.add(c2 + "y^2");
        if (c3 != 0) polynoms.add(c3 + "x");
        if (c4 != 0) polynoms.add(c4 + "y");
        if (c5 != 0) polynoms.add(c5 + "");
        s = String.join(" + ", polynoms);
        return s;

    }
}