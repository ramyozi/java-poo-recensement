package fr.diginamic.recensement.exceptions;

public class MesExceptions {
    public static class CodeDepartementInconnuException extends Exception {
        public CodeDepartementInconnuException(String message) {
            super(message);
        }
    }

    public static class PopulationNegatifException extends Exception {
        public PopulationNegatifException(String message) {
            super(message);
        }
    }

    public static class PopulationNonNumeriqueException extends Exception {
        public PopulationNonNumeriqueException(String message) {
            super(message);
        }
    }

    public static class PopulationMaxInferieurMinException extends Exception {
        public PopulationMaxInferieurMinException(String message) {
            super(message);
        }
    }
}
