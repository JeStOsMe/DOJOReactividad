package com.dojo.actividad.models;

public class MalasPalabras {

    private String malaPalabra;

    public MalasPalabras(String malaPalabra) {
        this.malaPalabra = malaPalabra;
    }

    public String getMalaPalabra() {
        return malaPalabra;
    }

    public void setMalaPalabra(String malaPalabra) {
        this.malaPalabra = malaPalabra;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((malaPalabra == null) ? 0 : malaPalabra.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MalasPalabras other = (MalasPalabras) obj;
        if (malaPalabra == null) {
            if (other.malaPalabra != null)
                return false;
        } else if (!malaPalabra.equals(other.malaPalabra))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MalasPalabras [malaPalabra=" + malaPalabra + "]";
    }

    
    
}
