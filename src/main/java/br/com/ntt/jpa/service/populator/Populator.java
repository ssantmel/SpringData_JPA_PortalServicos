package br.com.ntt.jpa.service.populator;

public interface Populator<SOURCE,TARGET> {

    void populate(SOURCE source,TARGET target);
}
