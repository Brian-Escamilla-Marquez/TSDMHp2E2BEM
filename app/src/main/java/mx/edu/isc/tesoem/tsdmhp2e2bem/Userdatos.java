package mx.edu.isc.tesoem.tsdmhp2e2bem;

import android.os.Parcel;
import android.os.Parcelable;



public class Userdatos implements Parcelable {
    String nombre, correo;
    int edad;

    public Userdatos() {
    }

    public Userdatos(String nombre, String correo, int edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }

    protected Userdatos(Parcel in) {
        nombre = in.readString();
        correo = in.readString();
        edad = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(correo);
        dest.writeInt(edad);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Userdatos> CREATOR = new Creator<Userdatos>() {
        @Override
        public Userdatos createFromParcel(Parcel in) {
            return new Userdatos(in);
        }

        @Override
        public Userdatos[] newArray(int size) {
            return new Userdatos[size];
        }
    };
}
