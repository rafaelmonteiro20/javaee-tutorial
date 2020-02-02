package com.cronometro.util;

import java.util.Map;
import java.util.TreeMap;

public class Cronometro {

    private Map<Long, String> marcacoes = new TreeMap<>();

    public Cronometro() {
        this.marca("Inicio");
    }

    public void marca(String marco) {
        marcacoes.put(System.currentTimeMillis(), marco);
    }
    
    public void finaliza() {
        this.marca("Fim");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Long[] marcas = marcacoes.keySet().toArray(new Long[0]);
        for (int i = 0; i < marcas.length - 1; i++) {
            long marca1 = marcas[i];
            if (i + 1 < marcas.length) {
                long marca2 = marcas[i + 1];
                long tempoDecorridoNS = marca2 - marca1;
                sb.append("[").append(marcacoes.get(marca1) + " -> " + marcacoes.get(marca2))
                  .append("] ").append(tempoDecorridoNS).append("ms ");
            }
        }
        long totalMS = marcas[marcas.length - 1] - marcas[0];
        sb.append("=> Total: ").append(totalMS).append("ms");
        return sb.toString();
    }

}
