## Preguntas de Análisis

### 1. ¿En qué parte del ejercicio se aplica IoC y en cuál DI?
* **Inversión de Control (IoC):** Es el principio de diseño donde se delega la responsabilidad de crear y administrar los objetos a un tercero, en este caso al contenedor de componentes ArC de Quarkus. Se aplica al anotar las clases con `@ApplicationScoped` y `@Dependent` y no utilizar en ningún momento la palabra reservada `new` para instanciar los servicios.
* **Inyección de Dependencias (DI):** Es el patrón de diseño mediante el cual el contenedor entrega las dependencias necesarias a una clase. Se aplica en `VentaService` de dos formas:
  * **Por atributo:** Usando `@Inject` sobre los atributos `descuentoRegular` y `descuentoVip` (y en `Main` para `ventaService` y `auditoriaMain`).
  * **Por constructor:** En el constructor `public VentaService(Auditoria auditoria)`, donde el contenedor inyecta la dependencia `Auditoria`.

### 2. ¿Qué función cumplen los Qualifiers y por qué son necesarios?
Los Qualifiers (`@Named("regular")` y `@Named("vip")`) sirven para identificar y diferenciar qué implementación específica de una interfaz se desea inyectar. Son necesarios porque tanto `DescuentoRegular` como `DescuentoVIP` implementan la misma interfaz `CalculadoraDescuento`, y el contenedor necesita saber cuál de las dos asignar a cada atributo en `VentaService`.

### 3. ¿Cuál es la diferencia entre `@ApplicationScoped` y `@Dependent`?
El ámbito define el tiempo de vida de los componentes:
* **`@ApplicationScoped`:** El contenedor crea una sola instancia compartida para toda la aplicación y la mantiene viva durante toda la ejecución del programa (se observa que el `UUID` es siempre el mismo en todas las ventas).
* **`@Dependent`:** No comparte una única instancia global; el contenedor crea una instancia nueva cada vez que se inyecta en una clase distinta y su tiempo de vida depende del componente donde fue inyectado (por ejemplo, el `UUID` de `Auditoria` en `Main` es distinto al `UUID` de `Auditoria` dentro de `VentaService`).

### 4. ¿Por qué las instancias `@ApplicationScoped` pueden reutilizarse entre varias ventas?
Porque tienen un ámbito de nivel de aplicación donde el contenedor mantiene una única instancia en memoria para toda la lógica de negocio. Como `VentaService`, `DescuentoRegular` y `DescuentoVIP` solo reciben el monto por parámetro y calculan el descuento sin guardar datos de un cliente específico en sus atributos, la misma instancia puede reutilizarse en las 4 ventas sin mezclar información.

### 5. ¿Qué sucedería si se elimina el Qualifier de un punto de inyección de `CalculadoraDescuento`?
Se produciría un error de ambigüedad al ejecutar o compilar la aplicación (`AmbiguousResolutionException`), ya que el contenedor ArC encontraría dos clases que implementan `CalculadoraDescuento` (`DescuentoRegular` y `DescuentoVIP`) y no sabría cuál de las dos inyectar.