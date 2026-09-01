# 🩺 MediEval

### Sistema inteligente para la evaluación objetiva, estandarizada y formativa de competencias clínicas

MediEval es una plataforma de software basada en **Inteligencia Artificial** orientada al fortalecimiento de la evaluación de competencias clínicas de estudiantes de Medicina mediante escenarios de **simulación clínica** y el modelo de **Examen Clínico Objetivo Estructurado (ECOE/OSCE)**.

El sistema busca contribuir a la reducción de la variabilidad entre evaluadores, mejorar la trazabilidad del desempeño de los estudiantes, optimizar la gestión de las estaciones de evaluación y proporcionar retroalimentación formativa de manera oportuna.

El proyecto integra **ingeniería de software, inteligencia artificial, educación médica y simulación clínica**, con un enfoque de desarrollo tecnológico y validación en escenarios educativos.

---

##  Objetivo

Construir una herramienta software basada en inteligencia artificial orientada al fortalecimiento de la evaluación de competencias clínicas en estudiantes de Medicina mediante simulación clínica.

---

##  Problemática

La evaluación de competencias clínicas presenta diferentes desafíos relacionados con:

* Variabilidad entre evaluadores.
* Dependencia del juicio individual del docente.
* Alta carga operativa y administrativa.
* Dificultad para proporcionar retroalimentación oportuna.
* Falta de sistematización de los resultados.
* Limitaciones para realizar seguimiento longitudinal del desempeño.
* Necesidad de procesos de evaluación objetivos, reproducibles y trazables.

MediEval propone utilizar tecnologías de inteligencia artificial como mecanismo de apoyo para estructurar y fortalecer estos procesos, manteniendo el **juicio clínico docente como elemento fundamental del proceso evaluativo**.

---

#  Funcionalidades principales

## 👨‍🏫 Gestión de docentes

El sistema permitirá a los docentes:

* Gestionar casos clínicos.
* Seleccionar especialidades médicas.
* Definir parámetros para la generación de casos.
* Ajustar el nivel de dificultad.
* Publicar casos clínicos.
* Asignar casos a estaciones.
* Consultar resultados y desempeño.

El acceso a determinadas funcionalidades estará controlado mediante roles y permisos.

---

## 👨‍🎓 Gestión de estudiantes

Los estudiantes podrán:

* Acceder a evaluaciones.
* Participar en estaciones ECOE/OSCE.
* Resolver los casos clínicos asignados.
* Consultar resultados.
* Recibir retroalimentación formativa.
* Utilizar un modo de estudio independiente para practicar.

---

#  Inteligencia Artificial

Uno de los componentes principales de MediEval es la integración de modelos de **Inteligencia Artificial mediante Ollama**, permitiendo ejecutar modelos de lenguaje localmente.

La IA se utilizará como mecanismo de apoyo para diferentes procesos del sistema.

###  Generación de casos clínicos

La IA podrá generar casos clínicos a partir de:

* Especialidad médica.
* Parámetros definidos por el docente.
* Nivel de dificultad.
* Características clínicas requeridas.

Esto corresponde al requerimiento **RF-006: Generación de Casos**.

###  Adaptación del lenguaje

La IA también permitirá generar instrucciones y guiones adaptados para el rol de paciente estandarizado, correspondiente al requerimiento **RF-007: Adaptación de Lenguaje**.

###  Evaluación asistida

Como parte de la evolución del sistema, la IA podrá analizar las respuestas del estudiante y generar una calificación preliminar basada en criterios médicos definidos, correspondiente al requerimiento **RF-008: Evaluación Asistida por IA**.

###  Retroalimentación personalizada

El sistema contempla la generación de recomendaciones personalizadas para el estudiante a partir de los errores identificados durante la evaluación, correspondiente al requerimiento **RF-010: Feedback Personalizado**.

---

#  Modelos de Inteligencia Artificial

Durante el desarrollo se contempla evaluar diferentes modelos compatibles con Ollama:

| Modelo                         | Enfoque                                        | Aplicación prevista                                  |
| ------------------------------ | ---------------------------------------------- | ---------------------------------------------------- |
| **MedGemma (4B / 27B)**        | Conocimiento y literatura médica               | Generación de casos clínicos y apoyo en evaluación   |
| **LlamaMedicine**              | Lenguaje orientado al área de salud            | Adaptación de terminología médica y guiones          |
| **Llama 3.1 / 3.3 (8B / 70B)** | Razonamiento general y generación estructurada | Procesamiento de respuestas y generación de feedback |
| **Mistral / Mixtral**          | Velocidad de inferencia                        | Procesamiento rápido de solicitudes                  |
| **Phi-3 / Phi-4**              | Deducción lógica con bajo consumo de recursos  | Alternativa para equipos con recursos limitados      |

> La selección definitiva del modelo se realizará mediante pruebas de calidad, consistencia, velocidad, consumo de recursos y capacidad para generar respuestas estructuradas.

---

#  Módulo de casos clínicos

El módulo de casos clínicos permite gestionar el ciclo de generación y utilización de los casos dentro del proceso ECOE/OSCE.

### Flujo principal

```text
Docente
   │
   ▼
Seleccionar especialidad
   │
   ▼
Definir parámetros
   │
   ▼
Validar parámetros
   │
   ▼
Generar caso clínico
   │
   ▼
Ollama + modelo IA
   │
   ▼
Recibir respuesta
   │
   ▼
Validar respuesta
   │
   ├───────────────┐
   │               │
Inválida         Válida
   │               │
   ▼               ▼
Mostrar error   Procesar respuesta
                   │
                   ▼
              Caso clínico
                   │
                   ▼
                 Guardar
                   │
                   ▼
                Publicar
                   │
                   ▼
          ¿Asignar a estación?
             │          │
            Sí          No
             │          │
             ▼          ▼
       Asignar caso   Mostrar caso
       a estación
```

---

#  Modelo de dominio

El módulo de casos clínicos contempla las siguientes entidades principales:

```text
Usuario
   │
   └── Rol
        │
        └── Permiso

Usuario
   │
   └── CasoClinico
          │
          ├── Especialidad
          │
          └── TipoDificultad

CasoClinico
   │
   └── Estacion

CasoClinico
   │
   └── Parametro
```

### Entidades

* `Usuario`
* `Rol`
* `Permiso`
* `CasoClinico`
* `Especialidad`
* `Parametro`
* `Estacion`

### Enumeraciones

* `TipoDificultad`

  * `BAJA`
  * `MEDIA`
  * `ALTA`

* `TipoParametro`

  * `TEXTO`
  * `NUMERO`
  * `DECIMAL`
  * `BOOLEANO`
  * `FECHA`
  * `LISTA`

El modelo de dominio define relaciones entre usuarios, casos clínicos, estaciones, especialidades, parámetros, roles y permisos.

---

#  Arquitectura

El backend de MediEval está desarrollado utilizando:

* **Java**
* **Spring Boot**
* **Arquitectura Hexagonal**
* **API REST**
* **Ollama**
* **Modelos de lenguaje locales**
* **Base de datos**

La arquitectura busca mantener separadas las reglas de negocio de los detalles de infraestructura, permitiendo cambiar componentes externos sin afectar el núcleo del sistema.

### Arquitectura general

```text
                    ┌──────────────────────┐
                    │       FRONTEND       │
                    │  Interfaz de usuario │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │       REST API       │
                    │     Controllers      │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │     APPLICATION      │
                    │                      │
                    │  Use Cases / Services │
                    └──────────┬───────────┘
                               │
                ┌──────────────┴──────────────┐
                ▼                             ▼
       ┌──────────────────┐          ┌──────────────────┐
       │      DOMAIN      │          │      PORTS       │
       │                  │          │                  │
       │ Entities         │          │ Input / Output   │
       │ Enums            │          │                  │
       │ Business Rules   │          └────────┬─────────┘
       └──────────────────┘                   │
                                    ┌─────────┴──────────┐
                                    ▼                    ▼
                           ┌────────────────┐    ┌────────────────┐
                           │  Persistence   │    │  Ollama / IA   │
                           │    Adapter     │    │    Adapter     │
                           └───────┬────────┘    └───────┬────────┘
                                   │                     │
                                   ▼                     ▼
                              Database                Ollama
```

---

# 📂 Estructura del proyecto

La estructura general propuesta para el backend es:

```text
medieval/
│
├── domain/
│   ├── model/
│   ├── enums/
│   ├── port/
│   │   ├── input/
│   │   └── output/
│   └── exception/
│
├── application/
│   ├── service/
│   └── dto/
│
├── infrastructure/
│   ├── adapter/
│   │   ├── persistence/
│   │   └── ai/
│   │
│   └── controller/
│
└── config/
```

> La estructura definitiva puede variar de acuerdo con la distribución final de los módulos del sistema.

---

# Tecnologías

## Backend

* Java
* Spring Boot
* Spring Web
* Spring Data
* Maven
* Arquitectura Hexagonal

## Inteligencia Artificial

* Ollama
* Modelos de lenguaje locales
* Generación estructurada mediante JSON

## Frontend

* React
* TypeScript
* Vite

## Base de datos

* Base de datos relacional

## Calidad

* Pruebas unitarias
* Pruebas de integración
* Pruebas de API
* Evaluación de modelos de IA
* ISO/IEC 25010

---

#  Requerimientos funcionales

MediEval contempla los siguientes grupos de funcionalidades.

## Gestión de evaluaciones y estaciones

| ID     | Requerimiento            |
| ------ | ------------------------ |
| RF-001 | Independencia Operativa  |
| RF-002 | Sincronización Temporal  |
| RF-003 | Asignación Automatizada  |
| RF-004 | Cierre Automático        |
| RF-005 | Monitoreo en tiempo real |

## Inteligencia artificial y contenido clínico

| ID     | Requerimiento              |
| ------ | -------------------------- |
| RF-006 | Generación de Casos        |
| RF-007 | Adaptación de Lenguaje     |
| RF-008 | Evaluación Asistida por IA |
| RF-009 | Ajuste de Complejidad      |
| RF-010 | Feedback Personalizado     |

## Administración de usuarios y casos

| ID     | Requerimiento           |
| ------ | ----------------------- |
| RF-011 | Gestión de Identidad    |
| RF-012 | Control de Roles (RBAC) |
| RF-013 | Persistencia de Casos   |
| RF-014 | Log de Auditoría        |
| RF-015 | Modo de Estudio         |

## Reportes, salidas y comunicación

| ID     | Requerimiento                |
| ------ | ---------------------------- |
| RF-016 | Generación de PDF Automática |
| RF-017 | Envío de Notificaciones      |
| RF-018 | Chat de Logística            |
| RF-019 | Evidencia Multimedia         |
| RF-020 | Reporte de grupo             |
| RF-021 | Instructivo para docentes    |

---

#  Requerimientos no funcionales

| ID      | Requerimiento         | Característica |
| ------- | --------------------- | -------------- |
| RNF-001 | Disponibilidad        | Fiabilidad     |
| RNF-002 | Tiempo de Respuesta   | Eficiencia     |
| RNF-003 | Multidispositivo      | Usabilidad     |
| RNF-004 | Protección de Datos   | Seguridad      |
| RNF-005 | Concurrencia          | Eficiencia     |
| RNF-006 | Tolerancia a Fallos   | Fiabilidad     |
| RNF-007 | Arquitectura Modular  | Mantenibilidad |
| RNF-008 | Integridad de Entrada | Seguridad      |
| RNF-009 | Consumo Eficiente     | Eficiencia     |

---

#  Roles del sistema

##  Profesor

Responsable de:

* Crear y administrar casos.
* Configurar evaluaciones.
* Gestionar estaciones.
* Consultar resultados.
* Revisar información generada por la IA.

##  Estudiante

Responsable de:

* Participar en las evaluaciones.
* Resolver casos clínicos.
* Consultar resultados.
* Recibir retroalimentación.
* Utilizar el modo de estudio.

---

#  Instalación

## Requisitos previos

Antes de ejecutar el proyecto se requiere:

* Java JDK
* Maven
* Node.js
* npm
* Ollama
* Base de datos configurada
* Git

### Verificar Java

```bash
java -version
```

### Verificar Maven

```bash
mvn -version
```

### Verificar Node.js

```bash
node -v
```

### Verificar npm

```bash
npm -v
```

### Verificar Ollama

```bash
ollama --version
```

---

#  Configuración de Ollama

Instalar Ollama y descargar el modelo seleccionado para el proyecto.

```bash
ollama pull <modelo>
```

Verificar los modelos instalados:

```bash
ollama list
```

Ejecutar un modelo:

```bash
ollama run <modelo>
```

> El modelo definitivo será establecido después del proceso de evaluación y benchmark.

---

#  Ejecución del Backend

Clonar el repositorio:

```bash
git clone <URL_DEL_REPOSITORIO>
```

Ingresar al proyecto:

```bash
cd MediEval
```

Ejecutar el proyecto:

```bash
mvn spring-boot:run
```

O construir el proyecto:

```bash
mvn clean install
```

---

#  Ejecución del Frontend

Ingresar al directorio del frontend:

```bash
cd frontend
```

Instalar las dependencias:

```bash
npm install
```

Ejecutar el servidor de desarrollo:

```bash
npm run dev
```

---

#  Pruebas

El proyecto contempla diferentes niveles de pruebas.

## Pruebas unitarias

Se validarán:

* Entidades.
* Reglas de negocio.
* Casos de uso.
* Servicios.
* Validaciones.

## Pruebas de integración

Se validarán:

* API REST.
* Persistencia.
* Integración con Ollama.
* Flujo completo de generación de casos.

## Pruebas de IA

Se evaluará:

* Calidad de los casos clínicos.
* Consistencia.
* Cumplimiento del formato JSON.
* Tiempo de respuesta.
* Consumo de recursos.
* Manejo de respuestas inválidas.
* Capacidad para seguir parámetros médicos.

---

#  Metodología de desarrollo

El desarrollo de MediEval se organiza en las siguientes fases:

```text
Diagnóstico
     │
     ▼
Diseño
     │
     ▼
Desarrollo
     │
     ▼
Implementación piloto
     │
     ▼
Evaluación
```

Estas fases permiten avanzar desde la identificación del problema y el diseño de la solución hasta la implementación piloto y posterior evaluación del sistema.

---

#  Estado del proyecto

### 🟡 En desarrollo

Actualmente se encuentra en desarrollo el módulo de **generación y gestión de casos clínicos**, incluyendo:

* Arquitectura hexagonal.
* Modelo de dominio.
* API REST.
* Integración con Ollama.
* Evaluación de modelos de IA.
* Generación estructurada de casos clínicos.
* Persistencia de casos.

Las demás funcionalidades del sistema serán integradas progresivamente.

---

#  Roadmap

* [x] Levantamiento de requerimientos
* [x] Diseño inicial del dominio
* [x] Diseño del flujo de generación
* [ ] Implementación del módulo de casos clínicos
* [ ] Integración con Ollama
* [ ] Selección definitiva del modelo de IA
* [ ] Gestión de estaciones
* [ ] Gestión de evaluaciones
* [ ] Evaluación asistida por IA
* [ ] Feedback personalizado
* [ ] Generación de reportes
* [ ] Modo de estudio
* [ ] Pruebas de calidad ISO/IEC 25010
* [ ] Implementación piloto
* [ ] Validación del sistema

---

#  Fundamento del proyecto

MediEval se fundamenta en la evaluación de competencias clínicas, la simulación clínica, el modelo de la **Pirámide de Miller** y el **ECOE/OSCE**.

El proyecto busca aprovechar la inteligencia artificial como herramienta de apoyo para mejorar la objetividad, estandarización, trazabilidad y retroalimentación del proceso evaluativo.

La IA se plantea como un mecanismo de apoyo al proceso docente y no como un sustituto del criterio profesional de los evaluadores clínicos.

---

#  Contexto académico

**Proyecto:** MediEval: Diseño, desarrollo y validación de un aplicativo basado en inteligencia artificial para la evaluación objetiva, estandarizada y formativa de competencias clínicas en estudiantes de Medicina mediante simulación clínica.

**Institución:** Universidad Cooperativa de Colombia — Campus Pasto.

**Programa:** Ingeniería de Software.

**Línea:** Desarrollo de software e Inteligencia Artificial.

**ODS relacionado:** ODS 4 — Educación de Calidad.

---

#  Equipo

MediEval es desarrollado como un proyecto interdisciplinario que integra conocimientos de:

* Ingeniería de Software.
* Desarrollo Backend.
* Desarrollo Frontend.
* Arquitectura de Software.
* Inteligencia Artificial.
* Educación Médica.
* Simulación Clínica.
* Aseguramiento de Calidad.

---

# ⭐ MediEval

> **Inteligencia artificial + simulación clínica + educación médica + ingeniería de software**

### Hacia una evaluación clínica más objetiva, estandarizada, trazable y formativa.
