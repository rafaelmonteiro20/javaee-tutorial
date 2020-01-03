package com.encoder.service;

public class CoderImpl implements Coder {

	private static final int SPACE_CHAR = 32;
    private static final int CAPITAL_A = 65;
    private static final int CAPITAL_Z = 90;
    private static final int SMALL_A = 97;
    private static final int SMALL_Z = 122;
	
    @Override
    public String code(String texto, int numeroCaracteresShift) {

        StringBuilder sb = new StringBuilder(texto);

        for (int i = 0; i < sb.length(); i++) {

            int cp = sb.codePointAt(i);
            int cplus = cp + numeroCaracteresShift;
            if (cp == SPACE_CHAR) {
                cplus = SPACE_CHAR;
            }
            
            if ((cp >= CAPITAL_A) && (cp <= CAPITAL_Z)) {
                if (cplus > CAPITAL_Z) {
                    cplus = cplus - 26;
                }
            } else if ((cp >= SMALL_A) && (cp <= SMALL_Z)) {
                if (cplus > SMALL_Z) {
                    cplus = cplus - 26;
                }
            } else {
                cplus = cp;
            }
            char c = (char) cplus;
            sb.setCharAt(i, c);
        }

        return (sb.toString());
    }
    
}
