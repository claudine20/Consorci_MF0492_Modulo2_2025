Eficiencia de IntArrayList vs. IntVector
La elección entre una estrategia de crecimiento del array (como la de IntArrayList o IntVector) depende de cómo esperas que la lista se comporte y de las limitaciones de tu entorno.

IntArrayList (crecimiento del 50%)
Mas eficiente cuando:

La memoria es una preocupacion: El crecimiento del 50% es mas conservador. A diferencia de duplicar el tamano, IntArrayList no asigna una gran cantidad de memoria no utilizada de golpe. Esto es util en sistemas con memoria limitada o para aplicaciones que requieren un crecimiento constante y a largo plazo.

Se anaden elementos uno a uno o en pequenos grupos: Si tu aplicacion solo anade un par de elementos a la vez, el redimensionamiento del 50% reduce el desperdicio de memoria.

Desventaja:
La desventaja es que el array se redimensiona con mas frecuencia, lo que implica que el proceso de copiar elementos a un nuevo array se ejecuta mas a menudo. En escenarios de anadido intensivo, esto puede ser mas lento.

IntVector (crecimiento del 100%)
Mas eficiente cuando:

La velocidad es critica: Duplicar el tamano del array de golpe reduce significativamente el numero de operaciones de redimensionamiento. Aunque se desperdicie memoria temporalmente, el coste de la operacion de anadir un elemento se amortiza a lo largo de multiples anadidos, haciendo que el rendimiento sea mas rapido en general para anadidos en lote o con una alta frecuencia.

El crecimiento es impredecible o rapido: Si la lista puede crecer de forma exponencial o si no tienes una idea clara de su tamano final, duplicar el tamano es una estrategia mas robusta y mas rapida a largo plazo.

Desventaja:
La principal desventaja es el desperdicio de memoria. El array tendra siempre al menos el doble de espacio del que se esta usando, lo que puede ser problematico en sistemas con memoria muy restringida.