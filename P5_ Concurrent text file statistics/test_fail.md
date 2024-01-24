-El método addName de FileNames no usa notify ni notifyAll.(-1.5)
textprocessing/FileNames.java:5 Es necesario avisar a los FileReader que esperan obtener un nombre.
-El método addName de FileNames no está sincronizado.(-1)
textprocessing/FileNames.java:5 Debe estar sincronizado para que solo un hilo modifique en cada momento el dato compartido.
-El método getName de FileNames no está sincronizado.(-1)
textprocessing/FileNames.java:8 Debe estar sincronizado para que solo un hilo modifique en cada momento el dato compartido.
-El método getName de FileNames no usa wait.(-2.5)
textprocessing/FileNames.java:8 Se debe esperar a que esté disponible algún nombre de fichero.
-El método noMoreNames de FileNames no usa notify ni notifyAll.(-1.5)
textprocessing/FileNames.java:11 Es necesario avisar a todos los hilos en espera, para que desistan.
-El método registerWriter de FileContents no está sincronizado.(-1)
textprocessing/FileContents.java:10 Debe estar sincronizado para aceptar registros simultáneos.
-El método unregisterWriter de FileContents no usa notify ni notifyAll.(-1.5)
textprocessing/FileContents.java:13 Es necesario avisar a todos los hilos en espera, para que desistan.
-El método addContents de FileContents no está sincronizado.(-1)
textprocessing/FileContents.java:16 Debe estar sincronizado para que solo un hilo modifique en cada momento el dato compartido.
-El método addContents de FileContents no usa wait.(-2.5)
textprocessing/FileContents.java:16 Se debe esperar a que esté disponible algún nombre de fichero.
-En el método addContents de FileContents no usa notify.(-1.5)
textprocessing/FileContents.java:16 Se debe avisar al hilo en espera en getContents para que consuma el dato recién añadido.
-El método getContents de FileContents no está sincronizado.(-1)
textprocessing/FileContents.java:19 Debe estar sincronizado para que solo un hilo modifique en cada momento el dato compartido.
-El método getContents de FileContents no usa wait.(-2.5)
textprocessing/FileContents.java:19 Se debe esperar a que esté disponible algún nombre de fichero.
-En el método getContents de FileContents no se usa notifyAll ni notify.(-1.5)
textprocessing/FileContents.java:19 Se debe avisar a los hilos en espera en addContents para que puedan añadir contenido.
-No se usa private en WordFrequencies para datos compartidos entre hilos.(-1)
textprocessing/WordFrequencies.java:1 Solo se debe permitir acceso vía sincronización.
-El método addFrequencies de WordFrequencies no está sincronizado.(-1)
textprocessing/WordFrequencies.java:6 Debe estar sincronizado para que solo un hilo modifique en cada momento el dato compartido.
-El método getFrequencies de WordFrequencies no está sincronizado.(-1)
textprocessing/WordFrequencies.java:9 Debe estar sincronizado para que solo un hilo modifique en cada momento el dato compartido.
-El método run de FileReader no se registra y desregistra apropiadamente en FileContents.(-1)
textprocessing/FileReader.java:
-El método run de FileReader no contiene un bucle de obtención de nombres y lectura de ficheros.(-1)
textprocessing/FileReader.java:
-El método run de FileProcessor no acumula apropiadamente en FileContents.(-1)
textprocessing/FileProcessor.java:
-El método run de FileProcessor no contiene un bucle de obtención de nombres de ficheros para su procesamiento.(-1)
textprocessing/FileProcessor.java:
-El método main de Main no arranca los hilos.(-2)
textprocessing/Main.java:6
-No se ha podido simular la ejecución, al fallar la compilación con Main correcto.(-2)