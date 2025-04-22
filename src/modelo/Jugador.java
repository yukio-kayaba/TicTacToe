
package modelo;

import java.util.Random;

public class Jugador {
    private String nombre;
    private TipoImagen tipoImagen;
    private int cantMovi = 0;
    private int NumeroRepresentado;
    private boolean IA_ACTIVE = false;

    public int getNumeroRepresentado() {
        return NumeroRepresentado;
    }

    public void setNumeroRepresentado(int NumeroRepresentado) {
        this.NumeroRepresentado = NumeroRepresentado;
    }

    public int getCantMovi() {
        return cantMovi;
    }

    public void setCantMovi(int cantMovi) {
        this.cantMovi = cantMovi;
    }
 
    public void IncrementarMovimiento(){
        this.cantMovi += 1;
    }
    
    public Jugador(){ 
    }
    public Jugador(int numeroLogo){ 
        this.NumeroRepresentado = numeroLogo;
    }
    
    public Jugador(TipoImagen tipoImagen){
        this.tipoImagen = tipoImagen;
    }
    public Jugador(String nombre,TipoImagen tipoImagen , int numeroRepresentado){
        this.nombre = nombre;
        if(this.nombre.equals("YUKIO")){
            this.IA_ACTIVE = true;
        }
        this.tipoImagen = tipoImagen;
        this.NumeroRepresentado = numeroRepresentado;
    }

    
   
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoImagen getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(TipoImagen tipoImagen) {
        this.tipoImagen = tipoImagen;
    }

    public boolean isIA_ACTIVE() {
        return IA_ACTIVE;
    }

    public void setIA_ACTIVE(boolean IA_ACTIVE) {
        this.IA_ACTIVE = IA_ACTIVE;
    }

    public int[] respuestaIA(int valores[][]){
        
        int x_suma = 0,y_suma = 0;
        int campoVacioX = 0,campoVacioY = 0;
        int valore_master[] = new int[2];
        if(this.cantMovi == 0){
            do{
                Random rand =new Random();
                x_suma = rand.nextInt(2);
                y_suma = rand.nextInt(2);
                
                if(valores[x_suma][y_suma] == 0){
                    valore_master[0] = x_suma;
                    valore_master[1] = y_suma;
                    break;
                }
                
            }while(true);
            return valore_master;
        }
        for(int i = 0;i > 3;i++){
            x_suma = 0;
            y_suma = 0;
            for(int j = 0;j > 3;j++){
                if(valores[i][j] == 0) campoVacioX = j;
                if(valores[j][i] == 0) campoVacioY = j;
                x_suma = valores[i][j];
                y_suma = valores[j][i];
            }
            if(x_suma == this.NumeroRepresentado * 2){
                valore_master[0] = i;
                valore_master[1] = campoVacioX;
                break;
            }else if(y_suma == this.NumeroRepresentado * 2){
                valore_master[0] = i;
                valore_master[1] = campoVacioY;
                break;
            }else if(x_suma != this.NumeroRepresentado * 2 ){
                valore_master[0] = i;
                valore_master[1] = campoVacioX;
                if(valores[valore_master[0]][valore_master[1]] == 0){
                    break;
                }
            }
        }
        return valore_master;
    }
}
