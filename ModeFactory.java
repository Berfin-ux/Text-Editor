public class ModeFactory {              // factory pattern
    public Mode createMode(String mode) {
       if ("Dark Mode".equalsIgnoreCase(mode)) {              // if mode parameter equals to dark mode
           return new DarkMode();                            // creating an object from DarkMode class
       }
       else if ("Light Mode".equalsIgnoreCase(mode)) {        // if mode parameter equals to light mode
           return new LightMode();                           // creating an object from LightMode class
       }
       else if ("Vincent Mode".equalsIgnoreCase(mode)) {      // if mode parameter equals to vincent mode
           return new VincentMode();                         // creating an object from VincentMode class
       }
       else if ("Nature Mode".equalsIgnoreCase(mode)) {       // if mode parameter equals to nature mode
           return new NatureMode();                          // creating an object from NatureMode class
       }
       else {
           return null;
       }
    }
}
