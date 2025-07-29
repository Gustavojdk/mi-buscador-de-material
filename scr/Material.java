public class Material {
    private String nombre;
    private String materia;
    private int semestre;

    public Material(String nombre, String materia, int semestre) {
        this.nombre = nombre;
        this.materia = materia;
        this.semestre = semestre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMateria() {
        return materia;
    }

    public int getSemestre() {
        return semestre;
    }

    @Override
    public String toString() {
        return "📘 " + nombre + " - " + materia + " (Semestre: " + semestre + ")";
    }
}
